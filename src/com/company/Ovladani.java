package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.String.format;

public class Ovladani extends Rectangle {
    //Konstruktor
    Ovladani(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString(format("Press F to see controls "), x,y);
    }
    //Metoda pro zaznamenání jestli byla určitá klávesa zmáčknuta
    public void keyPressedOvladani(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F) {
            if (HerniPanel.panel == 1){
                HerniPanel.panel = 3;
            }
        }
    }
}
