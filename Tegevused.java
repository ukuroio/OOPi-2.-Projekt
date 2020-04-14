package oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tegevused extends Application{
    public void start(Stage peaLava) {
        VBox juur= new VBox(5);

        Label tekst = new Label("Millist tehet soovid teha?");
        Label vastus= new Label();

        RadioButton raadio1=new RadioButton("1. Liida");
        RadioButton raadio2= new RadioButton("2. Lahuta");
        RadioButton raadio3= new RadioButton("3. Korruta");
        RadioButton raadio4= new RadioButton("4. Jaga");
        RadioButton raadio5= new RadioButton("5. Astenda");
        RadioButton raadio6= new RadioButton("6. Leia SÜT");
        RadioButton raadio7= new RadioButton("7. Leia VÜK");
        RadioButton raadio8= new RadioButton("8. Astenda");

        ToggleGroup küsimus= new ToggleGroup();
        raadio1.setToggleGroup(küsimus);
        raadio2.setToggleGroup(küsimus);
        raadio3.setToggleGroup(küsimus);
        raadio4.setToggleGroup(küsimus);
        raadio5.setToggleGroup(küsimus);
        raadio6.setToggleGroup(küsimus);
        raadio7.setToggleGroup(küsimus);
        raadio8.setToggleGroup(küsimus);

        Button nupp= new Button("Esita");

        /*nupp.setOnAction(e ->
        {
            if (raadio2.isSelected()) {
                nupp.setOnMouseClicked(me -> vastus.setText("Õige vastus"));
            } else {
                nupp.setOnMouseClicked(me -> vastus.setText("Vale vastus"));
            }
        });*/

        juur.getChildren().addAll(tekst, raadio1, raadio2, raadio3,raadio4,raadio5,raadio6,raadio7, nupp, vastus);

        Scene stseen1 = new Scene(juur, 300, 300, Color.SNOW);
        peaLava.setTitle("Tegevused");
        peaLava.setResizable(false);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}