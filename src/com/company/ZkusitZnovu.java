package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.String.format;

public class ZkusitZnovu extends Rectangle {
    int bylZmacknut;
//Konstruktor
    ZkusitZnovu(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString(format("Press H to try again "), x,y);
    }
    //Metoda pro zaznamenání jestli byla určitá klávesa zmáčknuta
    public void keyPressedZkusitZnovu(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H) {
            if (HerniPanel.panel == 5){
                bylZmacknut = 1;
                HerniPanel.panel = 2;
            }
        }
    }
    //Metoda pro zaznamenání jestli byla určitá klávesa puštěna
    public void keyReleasedZkusitZnovu(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H) {
            if (HerniPanel.panel == 5){
                bylZmacknut = 0;
            }
        }
        }
}
