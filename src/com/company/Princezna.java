package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Princezna extends Rectangle {

    BufferedImage princezna;
    BufferedImage fakePrincezna;
    int jeFake = 0;
//Konstruktor
    Princezna(int x, int y, int SIRKA_PRINCEZNY, int VYSKA_PRINCEZNY){
        super(x,y,SIRKA_PRINCEZNY,VYSKA_PRINCEZNY);

        try {
            princezna = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Princezna.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fakePrincezna = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Princezna50.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metoda k nakreslení
    public void nakresli(Graphics g) {
        if (jeFake == 1){
            g.drawImage(fakePrincezna, x,y, null);
        }else
        g.drawImage(princezna, x,y, null);
    }
}

