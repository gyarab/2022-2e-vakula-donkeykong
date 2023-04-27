package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Srdicko extends Rectangle {

    BufferedImage fakeSrdicko;
    //Konstruktor
    Srdicko(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);

        try {
            fakeSrdicko = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Srdicko.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//Metoda pro nakreslení
    }
    public void nakresli(Graphics g) {

            g.drawImage(fakeSrdicko, x,y, null);
    }
}
