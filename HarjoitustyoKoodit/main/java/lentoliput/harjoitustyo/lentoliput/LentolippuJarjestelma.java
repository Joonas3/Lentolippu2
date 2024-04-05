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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LentolippuJarjestelma extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane paneeli = new BorderPane();

        String [] lippuLista = {
                "Lippu 1", "Lippu 2", "Lippu 3", "Lippu 4", "Lippu 5",
                "Lippu 6", "Lippu 7", "Lippu 8", "Lippu 9", "Lippu 10",
                "Lippu 11", "Lippu 12", "Lippu 13", "Lippu 14", "Lippu 15",
                "Lippu 16", "Lippu 17", "Lippu 18", "Lippu 19", "Lippu 20",};


        ListView<String> lv = new ListView<>
                (FXCollections.observableArrayList(lippuLista));
        lv.setPrefSize(100,400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Label nimet = new Label("Syötä etu -ja sukunimesi:");
        TextField tfNimi = new TextField();

        HBox ylaosa = new HBox(nimet, tfNimi);
        ylaosa.setSpacing(5);
        ylaosa.setPadding(new Insets(10,10,10,10));
        ylaosa.setAlignment(Pos.TOP_CENTER);

        String[] kaupungit = {"Helsinki", "Singapore", "New York", "Amsterdam", "Antalya"};

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

        HBox kaupunkiValinta = new HBox(cbxlahtoPaikat, cbxmatkaKohteet);
        kaupunkiValinta.setSpacing(10);
        kaupunkiValinta.setAlignment(Pos.CENTER);

        Label mLuokka = new Label("Syötä matkustajaluokka (1 tai 2):");
        TextField tfmLuokka = new TextField();

        HBox alaosa = new HBox(mLuokka, tfmLuokka);
        alaosa.setSpacing(5);
        alaosa.setPadding(new Insets(10,10,10,10));
        alaosa.setAlignment(Pos.BOTTOM_CENTER);

        paneeli.setLeft(lv);
        paneeli.setTop(ylaosa);
        paneeli.setCenter(kaupunkiValinta);
        paneeli.setBottom(alaosa);

        Scene scene = new Scene(paneeli, 500, 400);
        primaryStage.setTitle("Valitse lippusi tiedot:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

