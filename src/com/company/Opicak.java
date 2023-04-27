package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Opicak extends Rectangle {
    BufferedImage opicakPoloha0;
    BufferedImage opicakPoloha1;
    int polohaOpicaka;
//Konstruktor
    Opicak(int x, int y, int SIRKA_OPICAKA,int VYSKA_OPICAKA){
        super(x, y, SIRKA_OPICAKA, VYSKA_OPICAKA);

        try {
            opicakPoloha0 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Opicak.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            opicakPoloha1 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\OpicakHazi.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//Metoda k nakreslení
    public void nakresli(Graphics g) {
        if (polohaOpicaka == 0){
            g.drawImage(opicakPoloha0, x, y, null);
        }
        if (polohaOpicaka == 1){
            g.drawImage(opicakPoloha1, x, y, null);
        }

    }
}
