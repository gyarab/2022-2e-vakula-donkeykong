package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Třída Plosina je rozšířena o třídu Rectangle, která umožnuje vytvoření objektu na bázy pravidelného čtyřuhelníku
public class Mario extends Rectangle {
    //Proměnné
    int rychlostX = 3;
    int rychlostPoZebriku;
    int povoleniKLezeni;
    int xZrychleni;
    int yZrychleni = 10;
    int maxVyskok;
    int povoleniVyskocit;
    boolean skace;
    int gravitace = 5;
    int kamchodi;
    int lezeAnoNe;
    int pocetZivotu = 3;
    BufferedImage doPrava;
    BufferedImage doLeva;
    BufferedImage leze;
    BufferedImage mario50;
    BufferedImage marioJump50;
    BufferedImage marioLeze50;
    int jeFake = 0;
//Konstruktor
    Mario(int x, int y, int SIRKA_MARIA,int VYSKA_MARIA) {
        super(x, y, SIRKA_MARIA, VYSKA_MARIA);
        skace = false;
        povoleniVyskocit = 0;

        try {
            doPrava = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\marioRight25.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            doLeva = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\marioLeft25.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            leze = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\MarioLeze.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mario50 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\Mario50.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            marioJump50 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\MarioJump50.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            marioLeze50 = ImageIO.read(new File("C:\\Users\\micha\\IdeaProjects\\DonkeyKong\\.idea\\Images\\MarioLeze50.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        if (kamchodi == 0){
            g.drawImage(doLeva, x, y,null);
        }
        if (kamchodi == 1){
            g.drawImage(doPrava, x,y, null);
        }
        if (lezeAnoNe == 1){
            g.drawImage(leze, x, y , null);
        }
        if (jeFake == 1){
            g.drawImage(mario50, x,y,null);
        }
        if (jeFake == 2){
            g.drawImage(marioJump50, x,y,null);
        }
        if (jeFake == 3){
            g.drawImage(marioLeze50, x,y,null);
        }



    }
    //Metoda pro zaznamenání pokud byla určitá klávesa zmáčknuta
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A) {
            nastavSmerX(-rychlostX);
            kamchodi = 0;
        }
        if(e.getKeyCode()== KeyEvent.VK_D) {
            nastavSmerX(rychlostX);
            kamchodi = 1;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(povoleniVyskocit==1){
                skace = true;
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_W) {
            if(povoleniKLezeni == 1) {
                rychlostPoZebriku= -2;
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_S) {
            if(povoleniKLezeni ==1) {
                rychlostPoZebriku= 2;
            }
        }
    }
//Metoda pro zaznamenání jestli byla určitá klávesa puštěna
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            nastavSmerX(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            nastavSmerX(0);
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){

        }
        if(e.getKeyCode()== KeyEvent.VK_W) {
            rychlostPoZebriku = 0;
        }
        if(e.getKeyCode()== KeyEvent.VK_S) {
            rychlostPoZebriku = 0;
        }
    }
    public void nastavSmerX ( int SmerX){
        xZrychleni = SmerX;
    }

//Metoda pro updatování polohy objektu mario
    public void move () {
        x = x + xZrychleni;
        y = y + rychlostPoZebriku;
        y = y + gravitace;

        if (povoleniVyskocit == 1){
            maxVyskok = y - 50;
        }

        if (skace) {


            y -= yZrychleni;

            if (y <= maxVyskok) {
                skace = false;
            }
        }
    }
}
