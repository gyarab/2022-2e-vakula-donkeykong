package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Zivoty extends Rectangle {
    BufferedImage dvaZivotyVelky;
    BufferedImage jedenZivotVelky;
    BufferedImage triZivotyMaly;
    BufferedImage dvaZivotyMaly;
    BufferedImage jedenZivotMaly;
    BufferedImage nultyZivotVelky;
    BufferedImage nultyZivotMaly;
    int jeVelky;
    int pocetZivotu;
    int seconds = 0;
    Timer timer = new Timer();
//Konstruktor
    Zivoty(int x, int y, int SIRKA, int VYSKA) {
        super(x, y, SIRKA, VYSKA);

        try {
            dvaZivotyVelky = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\DvaZivotyVelke.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jedenZivotVelky = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\JedenZivotVelke.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            triZivotyMaly = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\PlneZivotyMale.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dvaZivotyMaly = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\DvaZivotyMale.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jedenZivotMaly = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\JedenZivotMaly.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            nultyZivotVelky = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\NultyZivotVelky.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            nultyZivotMaly = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\NultyZivotMaly.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Časovač slouží aby vykreslil objekty jen na krátkou dobu
    TimerTask task = new TimerTask() {
        public void run() {
            if (HerniPanel.panel == 6){
                seconds++;
                if (seconds == 2) {
                    seconds = 0;
                    HerniPanel.panel = 2;
                }
            }

        }
    };
    public void startTimer() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
//Metoda pro nakreslení
    public void nakresli(Graphics g) {
        //Kreslí objekt podle toho, kolok má hrací postava životů
        if (jeVelky == 1){

            if (pocetZivotu == 2){
                g.drawImage(dvaZivotyVelky, x,y, null);
            }
            if (pocetZivotu == 1){
                g.drawImage(jedenZivotVelky, x,y, null);
            }
            if (pocetZivotu == 0){
                g.drawImage(nultyZivotVelky, x,y, null);
            }
        }
        if (jeVelky == 0){
            if (pocetZivotu == 3){
                g.drawImage(triZivotyMaly, x,y, null);
            }
            if (pocetZivotu == 2){
                g.drawImage(dvaZivotyMaly, x,y, null);
            }
            if (pocetZivotu == 1){
                g.drawImage(jedenZivotMaly, x,y, null);
            }
            if (pocetZivotu == 0){
                g.drawImage(nultyZivotMaly, x,y, null);
            }
        }


    }

}
