package projekt;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class TeineAken {

    public static void display(int moodul, int tehte_arv){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setMinHeight(250);
        VBox vbox = new VBox(5);

        if (1 <= tehte_arv && tehte_arv <=5) {
            Label lab1 = new Label();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button();
            if (tehte_arv == 1) {
                nupp.setText("Liida!");
                window.setTitle("Liitmine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta liidetavad:");
            }
            else if (tehte_arv == 2){
                nupp.setText("Lahuta");
                window.setTitle("Lahutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta vähendatav ja vähendaja:");
            }
            else if (tehte_arv == 3){
                nupp.setText("Korruta");
                window.setTitle("Korrutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta tegurid:");
            }
            else if (tehte_arv == 4){
                nupp.setText("Jaga");
                window.setTitle("Jagamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta jagatav ja jagaja:");
            }
            else{
                nupp.setText("Astenda");
                window.setTitle("Astendamine jägiklassis Z" + moodul);
                lab1.setText("Sisesta astendatav ja astendaja:");
            }

            lab2.setVisible(false);

            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            nupp.setOnAction(e ->{
                try{
                    int arv1 = Integer.parseInt(tf1.getText());
                    int arv2 = Integer.parseInt(tf2.getText());
                    if(tehte_arv == 1){
                        int tulemus = zn.liitmine(arv1,arv2);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    }
                    else if(tehte_arv == 2){
                        int tulemus = zn.lahutamine(arv1,arv2);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    }
                    else if(tehte_arv == 3){
                        int tulemus = zn.korrutamine(arv1,arv2);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    }
                    else if(tehte_arv == 4){
                        try{
                            int tulemus = zn.jagamine(arv1,arv2);
                            lab2.setText(Integer.toString(tulemus));
                            lab2.setVisible(true);
                        }catch(ArithmeticException e2){
                            lab2.setText("Jagaja peab olema nullist erinev!");
                            lab2.setVisible(true);
                        }
                    }
                    else{
                        try {
                            int tulemus = zn.astendamine(arv1, arv2);
                            lab2.setText(Integer.toString(tulemus));
                            lab2.setVisible(true);
                        }catch(ArithmeticException e2){
                            lab2.setText("Nulli astendaja peab olema positiivne!");
                            lab2.setVisible(true);
                        }
                    }
                }catch(NumberFormatException e1){
                    lab2.setText("Sisestage täisarvud!");
                    lab2.setVisible(true);
                }
            });

            vbox.getChildren().addAll(lab1,tf1,tf2, nupp, lab2);
        }
        else if(tehte_arv == 6){
            Label lab1 = new Label("Sisesta pööratav");
            TextField tf1 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button("Leia pöördarv");
            window.setTitle("Pööramine jäägiklassis Z" + moodul);

            lab2.setVisible(false);

            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            nupp.setOnAction(e ->{
                try{
                    int arv = Integer.parseInt(tf1.getText());
                    try {
                        int tulemus = zn.pöördarv(arv);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    }catch(ArithmeticException e2){
                        lab2.setText("Nullil pole pöördelementi!");
                        lab2.setVisible(true);
                    }
                }catch(NumberFormatException e1){
                    lab2.setText("Sisestage täisarv!");
                    lab2.setVisible(true);
                }
            });
            vbox.getChildren().addAll(lab1,tf1, nupp, lab2);
        }
        Scene newScene = new Scene(vbox);
        window.setScene(newScene);
        window.showAndWait();
    }
}
