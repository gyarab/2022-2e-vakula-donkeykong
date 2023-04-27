package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//Třída Plosina je rozšířena o třídu Rectangle, která umožnuje vytvoření objektu na bázy pravidelného čtyřuhelníku
public class Plosina extends Rectangle {
//Proměnné typu BufferedImage, které jsou schopny nést formu obrázku
   BufferedImage plosina7;
   BufferedImage plosina0;
   BufferedImage plosina1;
    int typPlosiny = 1;
//Konstruktor
    Plosina(int x, int y, int SIRKA_PLOSINY, int VYSKA_PLOSINY){
        super(x,y,SIRKA_PLOSINY,VYSKA_PLOSINY);
//Do předurčených proměnných jsou vloženy obrázky ze složky
        try {
            plosina7 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Plosina7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            plosina0 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Plosina0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            plosina1 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Plosina1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        if (typPlosiny == 1){
            g.drawImage(plosina1, x, y, null);
        }
        if (typPlosiny == 7){
            g.drawImage(plosina7, x, y, null);
        }
        if (typPlosiny == 0){
            g.drawImage(plosina0, x, y, null);
        }
    }
}