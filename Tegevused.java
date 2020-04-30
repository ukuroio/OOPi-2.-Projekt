package projekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tegevused extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public boolean onAlgarv(int arv){
        if (arv < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(arv) ; i++) {
            if(arv % i==0){
                return false;
            }
        }
        return true;
    }

    public void start(Stage peaLava){
        BorderPane juur = new BorderPane();
        VBox vbox1 = new VBox(5);
        VBox vbox2 = new VBox(5);
        VBox vbox3 = new VBox(10);

        Label lab1 = new Label("Millist tehet soovid teha?");
        Label lab2 = new Label("Tehted jäägiklassi-\nkorpuses:");
        Label lab3 = new Label("Tehted polünoomi-\nringis");
        Label lab4 = new Label("Sisesta algarvuline moodul:");
        Label lab5 = new Label();
        lab5.setVisible(false);
        TextField tf = new TextField();

        //Jäägiklassi tehted
        RadioButton raadio1=new RadioButton("1. Liida");
        RadioButton raadio2= new RadioButton("2. Lahuta");
        RadioButton raadio3= new RadioButton("3. Korruta");
        RadioButton raadio4= new RadioButton("4. Jaga");
        RadioButton raadio5= new RadioButton("5. Astenda");
        RadioButton raadio6= new RadioButton("6. Pöördelement");

        //polünoomide klassi tehted
        RadioButton raadio7= new RadioButton("1. Liida");
        RadioButton raadio8= new RadioButton("2. Lahuta");
        RadioButton raadio9= new RadioButton("3. Korruta");
        RadioButton raadio10= new RadioButton("4. Jaga");
        RadioButton raadio11= new RadioButton("5. VÜK");
        RadioButton raadio12= new RadioButton("6. SÜT");
        RadioButton raadio13= new RadioButton("7. Astenda");


        ToggleGroup küsimus= new ToggleGroup();
        raadio1.setToggleGroup(küsimus);
        raadio2.setToggleGroup(küsimus);
        raadio3.setToggleGroup(küsimus);
        raadio4.setToggleGroup(küsimus);
        raadio5.setToggleGroup(küsimus);
        raadio6.setToggleGroup(küsimus);
        raadio7.setToggleGroup(küsimus);
        raadio8.setToggleGroup(küsimus);
        raadio9.setToggleGroup(küsimus);
        raadio10.setToggleGroup(küsimus);
        raadio11.setToggleGroup(küsimus);
        raadio12.setToggleGroup(küsimus);
        raadio13.setToggleGroup(küsimus);


        Button nupp = new Button("Esita");

        Button nupp1 = new Button("Sulge");

        //Enteri vajutamisel sulgub aken, kui vajutada enteriga sulge nupule
        // ja logifaili sisu prinditakse konsooli, failist lugemine
        nupp1.setOnAction(e -> {
            lab5.setText("Väljumiseks vajutage ENTER!");
            lab5.setVisible(true);
        });

        nupp1.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                    try (BufferedReader br = new BufferedReader(new FileReader("logi.txt"))) {
                        String rida = br.readLine();
                        while(rida!=null){
                            System.out.println(rida);
                            rida=br.readLine();
                        }
                    } catch (IOException ignored) {}
                peaLava.close();
            }
        });

        nupp.setOnAction(e ->
        {
            try {
                int moodul = Integer.parseInt(tf.getCharacters().toString());
                if (onAlgarv(moodul)) {
                    lab5.setVisible(false);
                    if (raadio1.isSelected()) {
                        TeineAken.display(moodul,1);
                    }
                    else if (raadio2.isSelected()) {
                        TeineAken.display(moodul,2);
                    }
                    else if (raadio3.isSelected()) {
                        TeineAken.display(moodul,3);
                    }
                    else if (raadio4.isSelected()) {
                        TeineAken.display(moodul,4);
                    }
                    else if (raadio5.isSelected()) {
                        TeineAken.display(moodul,5);
                    }
                    else if (raadio6.isSelected()) {
                        TeineAken.display(moodul,6);
                    }
                    else if(raadio7.isSelected()) {
                        TeineAken.display(moodul,7);
                    }
                    else if (raadio8.isSelected()) {
                        TeineAken.display(moodul,8);
                    }
                    else if (raadio9.isSelected()) {
                        TeineAken.display(moodul,9);
                    }
                    else if (raadio10.isSelected()) {
                        TeineAken.display(moodul,10);
                    }
                    else if (raadio11.isSelected()) {
                        TeineAken.display(moodul,11);
                    }
                    else if (raadio12.isSelected()) {
                        TeineAken.display(moodul,12);
                    }
                    else if (raadio13.isSelected()) {
                        TeineAken.display(moodul,13);
                    }
                }else{
                    lab5.setText("Moodul peab olema algarv!");
                    lab5.setVisible(true);
                }
            }catch (NumberFormatException e1){
                lab5.setText("Sisestage arv!");
                lab5.setVisible(true);
            }
        });

        vbox1.getChildren().addAll(lab2, raadio1, raadio2, raadio3, raadio4, raadio5, raadio6);
        vbox2.getChildren().addAll(lab3, raadio7, raadio8, raadio9, raadio10, raadio11, raadio12, raadio13);
        vbox3.getChildren().addAll(lab1, lab4, tf, nupp,nupp1, lab5);
        juur.setLeft(vbox1);
        juur.setRight(vbox2);
        juur.setCenter(vbox3);
        Scene stseen1 = new Scene(juur, 475, 300, Color.SNOW);
        peaLava.setMinHeight(250);
        peaLava.setMinWidth(400);
        peaLava.setTitle("Tegevused");
        peaLava.setScene(stseen1);
        peaLava.show();
    }
}