package lentoliput.harjoitustyo.lentoliput;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LentolippuJarjestelma extends Application {
    int iLippu = 0;

    @Override
    public void start(Stage primaryStage) {
        LentoliputTiedostossa kaikkiLentoLiput = new LentoliputTiedostossa();

        BorderPane paneeli = new BorderPane();

        //Otsikot kaikille lipuille
        String [] lippuLista = {
                "Lippu 1", "Lippu 2", "Lippu 3", "Lippu 4", "Lippu 5",
                "Lippu 6", "Lippu 7", "Lippu 8", "Lippu 9", "Lippu 10",
                "Lippu 11", "Lippu 12", "Lippu 13", "Lippu 14", "Lippu 15",
                "Lippu 16", "Lippu 17", "Lippu 18", "Lippu 19", "Lippu 20",};

        //ListView, jossa on lippujen otsikot
        ListView<String> lv = new ListView<>
                (FXCollections.observableArrayList(lippuLista));
        lv.setPrefSize(80,400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //Teksti ja tekstikenttä matkustajan nimelle, nämä hBoxiin
        Label nimet = new Label("Syötä etu -ja sukunimesi:");
        TextField tfNimi = new TextField();

        HBox ylaosa = new HBox(nimet, tfNimi);
        ylaosa.setSpacing(5);
        ylaosa.setPadding(new Insets(100,10,40,10));
        ylaosa.setAlignment(Pos.TOP_CENTER);

        //Kohde -ja lähtökaupunkien nimet
        String[] kaupungit = {"Helsinki", "Singapore", "New York", "Amsterdam", "Antalya"};

        //Näiden sijoitus kahteen alasvetolistaan
        ComboBox<String> cbxlahtoPaikat = new ComboBox<>();
        cbxlahtoPaikat.setPrefWidth(100);

        ComboBox<String> cbxmatkaKohteet = new ComboBox<>();
        cbxmatkaKohteet.setPrefWidth(100);

        ObservableList<String> sisalto =
                FXCollections.observableArrayList(kaupungit);

        cbxlahtoPaikat.getItems().addAll(sisalto);
        cbxmatkaKohteet.getItems().addAll(sisalto);

        //Selitys alasvetolistoille
        Label valitse = new Label("Lähtökaupunki sekä määränpää:");

        //Jälkimmäisten sijoitus hBoxiin
        HBox kaupunkiValinta = new HBox(valitse, cbxlahtoPaikat, cbxmatkaKohteet);
        kaupunkiValinta.setSpacing(10);
        kaupunkiValinta.setAlignment(Pos.CENTER);

        //Teksti ja tekstikenttä matkustajaluokalle sekä nappi, joka avaa lentolipun, näiden sijoitus hBoxiin
        Label mLuokka = new Label("Syötä matkustajaluokka (1 tai 2):");
        TextField tfmLuokka = new TextField();
        tfmLuokka.setMaxWidth(30);
        Button btLippuIkkuna = new Button("Tulosta lentolippu");

        HBox alaosa = new HBox(mLuokka, tfmLuokka, btLippuIkkuna);
        alaosa.setSpacing(10);
        alaosa.setPadding(new Insets(40,10,10,10));
        alaosa.setAlignment(Pos.BOTTOM_CENTER);

        //Uusi ikkuna, joka on lopullinen lentolippu
        BorderPane lippuIkkuna = new BorderPane();
        Button btLopeta = new Button("Tallenna ja sulje");
        Scene ikkuna = new Scene(lippuIkkuna,600, 300);

        //Sijoitetaan kaikki hBoxit vBoxiin, jotta tavarat ovat ikkunassa allekain
        VBox vBox = new VBox(ylaosa, kaupunkiValinta, alaosa);

        //Valintataulukko vasemmalle ja keskelle muut asiat BorderPanessa
        paneeli.setLeft(lv);
        paneeli.setCenter(vBox);

        //Eri lentolippujen valintalistalle, eli listviewille toiminnallisuus
        lv.getSelectionModel().selectedItemProperty().addListener(ov->{
            iLippu = lv.getSelectionModel().getSelectedIndex();
        });

        //Painike, josta voidaan tallentaa tiedot ja sulkea sovellus
        btLopeta.setOnAction(e->{
            kaikkiLentoLiput.tiedostoonKirjoitus();
            System.exit(0);
        });

        //Toiminnallisuudet comboboxeille
        cbxlahtoPaikat.setOnAction(e->{
            String valittuKaupunki1 = cbxlahtoPaikat.getValue();
            kaikkiLentoLiput.lentoliput[iLippu].setLahtoPaikka(valittuKaupunki1);
        });

        cbxmatkaKohteet.setOnAction(e->{
            String valittuKaupunki2 = cbxmatkaKohteet.getValue();
            kaikkiLentoLiput.lentoliput[iLippu].setMatkaKohde(valittuKaupunki2);
        });

        //Uuden ikkunan painikkeelle toiminnallisuus
        btLippuIkkuna.setOnAction(e->{
            primaryStage.setScene(ikkuna);
            primaryStage.setTitle("BOARDING PASS");
            primaryStage.show();
            lippuIkkuna.setBottom(btLopeta);

            //Otetaan nimi tekstikentästä, jos ei kirjoita mitään, näytetään tiedostoon tallennettu nimi
            String matkustajaNimi = tfNimi.getText();
            if (matkustajaNimi.isEmpty()){
                matkustajaNimi = kaikkiLentoLiput.lentoliput[iLippu].getNimi();
            }
            else{
                kaikkiLentoLiput.lentoliput[iLippu].setNimi(matkustajaNimi);
            }


            //Lisätään uuteen ikkunaan käyttäjän syöttämä nimi
            Label nimi = new Label(matkustajaNimi);
            lippuIkkuna.setCenter(nimi);

            //Lisätään lähtö -ja saapumiskaupunki uuteen ikkunaan
            Label lahtoKaupunki = new Label(kaikkiLentoLiput.lentoliput[iLippu].getLahtoPaikka());
            lippuIkkuna.setTop(lahtoKaupunki);
            Label saapumisKaupunki = new Label(kaikkiLentoLiput.lentoliput[iLippu].getMatkaKohde());
            lippuIkkuna.setRight(saapumisKaupunki);

            //Käsitellään matkustajaluokan valinta
            int matkustusLuokka;
            if (!tfmLuokka.getText().isEmpty()){
                matkustusLuokka = Integer.parseInt(tfmLuokka.getText());
            }
            else {
                matkustusLuokka = 2;
            }
            kaikkiLentoLiput.lentoliput[iLippu].setMatkustusluokka(matkustusLuokka);

            Label matkustajaLuokkaLabel = new Label(Integer.toString(
                    kaikkiLentoLiput.lentoliput[iLippu].getMatkustusluokka()));
            lippuIkkuna.setTop(matkustajaLuokkaLabel);

            //Lisätään lippuun sen luomispäivämäärä
            SimpleDateFormat pvmFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date luomisPvm = kaikkiLentoLiput.lentoliput[iLippu].getPvm();
            Label pvmTeksti = new Label(pvmFormat.format(luomisPvm));
            lippuIkkuna.setRight(pvmTeksti);

            //Näytetään kaupunkien välinen etäisyys lippuikkunassa
            Label etaisyys = new Label(Double.toString(kaikkiLentoLiput.lentoliput[iLippu].etaisyysMaarittelija()));
            lippuIkkuna.setTop(etaisyys);

        });

        //Loput toiminnallisuudet sekä lentolipun luonti tulee tästä eteenpäin->

        //Näytetään ikkuna, jossa asetetaan lipulle tietoja
        Scene scene = new Scene(paneeli, 500, 400);
        primaryStage.setTitle("Luodaan lentolippu:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}