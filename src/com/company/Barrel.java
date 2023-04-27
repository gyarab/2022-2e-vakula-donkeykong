package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Barrel extends Rectangle{

    int rychlost = 0;
    int gravitace = 5;
    int povoleniKPohybu =0;
    BufferedImage barrel;
//Konstruktor
    Barrel(int x, int y, int sirka, int vyska){
        super(x, y, sirka, vyska);

        try {
            barrel = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Barrel25x25.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//Metoda k nakreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.lightGray);
        g.drawImage(barrel, x, y , null);
    }
//Metoda k pohybu
    public void move() {
        x = x + rychlost;
        y = y + gravitace;

    }
}
