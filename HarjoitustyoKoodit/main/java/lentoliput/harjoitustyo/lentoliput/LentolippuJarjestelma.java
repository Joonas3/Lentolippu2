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
        cbxlahtoPaikat.setValue("Helsinki");

        ComboBox<String> cbxmatkaKohteet = new ComboBox<>();
        cbxmatkaKohteet.setPrefWidth(100);
        cbxmatkaKohteet.setValue("Helsinki");

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
        Scene ikkuna = new Scene(lippuIkkuna,600, 300);

        //Sijoitetaan kaikki hBoxit vBoxiin, jotta tavarat ovat ikkunassa allekain
        VBox vBox = new VBox(ylaosa, kaupunkiValinta, alaosa);

        //Valintataulukko vasemmalle ja keskelle muut asiat BorderPanessa
        paneeli.setLeft(lv);
        paneeli.setCenter(vBox);

        //Painikkeelle toiminnallisuus
        btLippuIkkuna.setOnAction(e->{
            primaryStage.setScene(ikkuna);
            primaryStage.setTitle("BOARDING PASS");
            primaryStage.show();
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