module lentoliput.harjoitustyo.lentoliput {
    requires javafx.controls;
    requires javafx.fxml;


    opens lentoliput.harjoitustyo.lentoliput to javafx.fxml;
    exports lentoliput.harjoitustyo.lentoliput;
}