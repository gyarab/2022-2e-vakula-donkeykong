package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HromadaBarelu extends Rectangle {
    BufferedImage hromadaBarelu;
//Konstruktor
    HromadaBarelu(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA, VYSKA);

        try {
            hromadaBarelu = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\HromadaBarelu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   // Metoda Pro nakreslení
    public void nakresli(Graphics g) {
        g.drawImage(hromadaBarelu, x,y, null);
    }
}
