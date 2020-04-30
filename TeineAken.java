package projekt;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TeineAken {

    //Logifaili kirjutamine
    static void kirjutaFaili(String failinimi, String tulemus, String tehe) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(failinimi, true), StandardCharsets.UTF_8))){
            bw.write(tehe);
            bw.write(",");
            bw.write("Tulemus: ");
            bw.write(tulemus);
            bw.write("\n");
        }
    }


    public static void display(int moodul, int tehte_arv) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setMinHeight(250);
        VBox vbox = new VBox(5);

        if (1 <= tehte_arv && tehte_arv <= 5) {
            Label lab1 = new Label();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button();
            if (tehte_arv == 1) {
                nupp.setText("Liida!");
                window.setTitle("Liitmine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta liidetavad:");
            } else if (tehte_arv == 2) {
                nupp.setText("Lahuta");
                window.setTitle("Lahutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta vähendatav ja vähendaja:");
            } else if (tehte_arv == 3) {
                nupp.setText("Korruta");
                window.setTitle("Korrutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta tegurid:");
            } else if (tehte_arv == 4) {
                nupp.setText("Jaga");
                window.setTitle("Jagamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta jagatav ja jagaja:");
            } else {
                nupp.setText("Astenda");
                window.setTitle("Astendamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta astendatav ja astendaja:");
            }

            lab2.setVisible(false);

            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            nupp.setOnAction(e -> {
                try {
                    int arv1 = Integer.parseInt(tf1.getText());
                    int arv2 = Integer.parseInt(tf2.getText());
                    if (tehte_arv == 1) {
                        int tulemus = zn.liitmine(arv1, arv2);
                        kirjutaFaili("logi.txt", Integer.toString(tulemus), "Liitmine jäägiklassis Z"+ moodul);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 2) {
                        int tulemus = zn.lahutamine(arv1, arv2);
                        kirjutaFaili("logi.txt", Integer.toString(tulemus), "Lahutamine jäägiklassis Z"+ moodul);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 3) {
                        int tulemus = zn.korrutamine(arv1, arv2);
                        kirjutaFaili("logi.txt", Integer.toString(tulemus), "Korrutamine jäägiklassis Z"+ moodul);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 4) {
                        try {
                            int tulemus = zn.jagamine(arv1, arv2);
                            kirjutaFaili("logi.txt", Integer.toString(tulemus), "Jagamine jäägiklassis Z" +moodul);
                            lab2.setText(Integer.toString(tulemus));
                            lab2.setVisible(true);
                        } catch (ArithmeticException e2) {
                            lab2.setText("Jagaja peab olema nullist erinev!");
                            lab2.setVisible(true);
                        }
                    } else {
                        try {
                            int tulemus = zn.astendamine(arv1, arv2);
                            kirjutaFaili("logi.txt", Integer.toString(tulemus), " Astendamine jäägiklassis Z" + moodul);
                            lab2.setText(Integer.toString(tulemus));
                            lab2.setVisible(true);
                        } catch (ArithmeticException e2) {
                            lab2.setText("Nulli astendaja peab olema positiivne!");
                            lab2.setVisible(true);
                        }
                    }
                } catch (NumberFormatException | IOException e1) {
                    lab2.setText("Sisestage täisarvud!");
                    lab2.setVisible(true);
                }
            });

            vbox.getChildren().addAll(lab1, tf1, tf2, nupp, lab2);
        } else if (tehte_arv == 6) {
            Label lab1 = new Label("Sisesta pööratav");
            TextField tf1 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button("Leia pöördarv");
            window.setTitle("Pööramine jäägiklassis Z" + moodul);

            lab2.setVisible(false);

            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            nupp.setOnAction(e -> {
                try {
                    int arv = Integer.parseInt(tf1.getText());
                    try {
                        int tulemus = zn.pöördarv(arv);
                        kirjutaFaili("logi.txt", Integer.toString(tulemus), "Astendamine jäägiklassis Z"+ moodul);
                        lab2.setText(Integer.toString(tulemus));
                        lab2.setVisible(true);
                    } catch (ArithmeticException e2) {
                        lab2.setText("Nullil pole pöördelementi!");
                        lab2.setVisible(true);
                    }
                } catch (NumberFormatException | IOException e1) {
                    lab2.setText("Sisestage täisarv!");
                    lab2.setVisible(true);
                }
            });
            vbox.getChildren().addAll(lab1, tf1, nupp, lab2);
        }

        //Polünoomi klassi tehted
        if (7 <= tehte_arv && tehte_arv <= 12) {
            Label lab1 = new Label();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button();
            if (tehte_arv == 7) {
                nupp.setText("Liida!");
                window.setTitle("Polünoomide liitmine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta liidetavad(sisesta polünoomi kordajad tühikutega):");
            } else if (tehte_arv == 8) {
                nupp.setText("Lahuta");
                window.setTitle("Polünoomide lahutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta vähendatav ja vähendaja(sisesta polünoomi kordajad tühikutega):");
            } else if (tehte_arv == 9) {
                nupp.setText("Korruta");
                window.setTitle("Polünoomide korrutamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta tegurid(sisesta polünoomi kordajad tühikutega):");
            } else if (tehte_arv == 10) {
                nupp.setText("Jaga");
                window.setTitle("Polünoomide jagamine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta jagatav ja jagaja(sisesta polünoomi kordajad tühikutega):");
            } else if (tehte_arv == 11) {
                nupp.setText("Leia VÜK");
                window.setTitle("Polünoomide VÜKi leidmine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta polünoomid(sisesta polünoomi kordajad tühikutega):");
            } else {
                nupp.setText("Leia SÜT");
                window.setTitle("Polünoomide SÜTi leidmine jäägiklassis Z" + moodul);
                lab1.setText("Sisesta polünoomid(sisesta polünoomi kordajad tühikutega):");

            }

            lab2.setVisible(false);
            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            Polünoomid p = new Polünoomid(moodul);

            nupp.setOnAction(e -> {
                try {
                    String polünoom1 = tf1.getText();
                    String polünoom2 = tf2.getText();
                    String[] polünoom3 = polünoom1.split(" ");
                    String[] polünoom4 = polünoom2.split(" ");
                    int[] polüA = new int[polünoom3.length];
                    int[] polüB = new int[polünoom4.length];
                    for (int i = 0; i < polünoom3.length; i++) {
                        polüA[i] = Integer.parseInt(polünoom3[i]);
                    }
                    for (int i = 0; i < polünoom4.length; i++) {
                        polüB[i] = Integer.parseInt(polünoom4[i]);
                    }
                    p.eemaldaNullid(polüA);
                    p.eemaldaNullid(polüB);
                    if (tehte_arv == 7) {
                        int[] tulemus = p.liida(polüA, polüB);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü liitmine Z"  + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 8) {
                        int[] tulemus = p.lahuta(polüA, polüB);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü lahutamine Z" + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 9) {
                        int[] tulemus = p.korruta(polüA, polüB);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü korrutamine Z" + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    } else if (tehte_arv == 10) {
                        try {
                            int[][] tulemus = p.jaga(polüA, polüB);
                            kirjutaFaili("logi.txt", Arrays.deepToString(tulemus), "Polü jagamine Z" + moodul);
                            lab2.setText(Arrays.deepToString(tulemus));
                            lab2.setVisible(true);
                        } catch (ArithmeticException e2) {
                            lab2.setText("Jagaja peab olema nullist erinev!");
                            lab2.setVisible(true);
                        }
                    } else if (tehte_arv == 11) {
                        int[] tulemus = p.VÜK(polüA, polüB);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü VÜK Z" + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    } else {
                        int[] tulemus = p.SÜT(polüA, polüB);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü SÜT Z" + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    }
                } catch (NumberFormatException | IOException e1) {
                    lab2.setText("Sisestage täisarvuline polünoom!");
                    lab2.setVisible(true);
                }
            });
            vbox.getChildren().addAll(lab1, tf1, tf2, nupp, lab2);

        } else if (tehte_arv == 13) {
            Label lab1 = new Label("Sisesta astendatav ja astendaja:");
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            Label lab2 = new Label();
            Button nupp = new Button("Leia aste");
            lab2.setVisible(false);
            window.setTitle("Polünoomi astendamine jäägiklassis Z" + moodul);
            Jäägiklass zn = new Jäägiklass(moodul);
            zn.looTsükkel();
            Polünoomid p = new Polünoomid(moodul);
            nupp.setOnAction(e -> {
                try {
                    String polünoom1 = tf1.getText();
                    String[] polünoom3 = polünoom1.split(" ");
                    int[] polüA = new int[polünoom3.length];
                    for (int i = 0; i < polünoom3.length; i++) {
                        polüA[i] = Integer.parseInt(polünoom3[i]);
                    }
                    int astendaja = Integer.parseInt(tf2.getText());
                    p.eemaldaNullid(polüA);
                    try {
                        int[] tulemus = p.astendaPolünoom(polüA, astendaja);
                        kirjutaFaili("logi.txt", Arrays.toString(tulemus), "Polü astendamine Z" + moodul);
                        lab2.setText(Arrays.toString(tulemus));
                        lab2.setVisible(true);
                    } catch (ArithmeticException e2) {
                        lab2.setText("Nulli ei saa nulliga astendada ja astendaja peab olema " +
                                "positiivne!");
                        lab2.setVisible(true);
                    }
                } catch (NumberFormatException | IOException e1) {
                    lab2.setText("Sisestage täisarvuline polünoom ja astendaja peab olema mittenegatiivne");
                    lab2.setVisible(true);
                }
            });
            vbox.getChildren().addAll(lab1, tf1, tf2, nupp, lab2);

        }
        Scene newScene = new Scene(vbox);
        window.setScene(newScene);
        window.showAndWait();
    }

}

