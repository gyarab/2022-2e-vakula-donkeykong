package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Zebrik extends Rectangle {

    BufferedImage zebrik;
    BufferedImage fakeZebrik;
    int jeFake = 0;
//Konstruktor
    Zebrik(int x, int y, int SIRKA_ZEBRIKU, int VYSKA_ZEBRIKU){
        super(x, y, SIRKA_ZEBRIKU, VYSKA_ZEBRIKU);

        try {
            zebrik = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Zebrik.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fakeZebrik = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Zebrik50.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        if (jeFake == 1){
            g.drawImage(fakeZebrik, x, y, null);
        }else
        g.drawImage(zebrik, x, y, null);
    }


}
