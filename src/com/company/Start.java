package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import static java.lang.String.format;

public class Start extends Rectangle {
//Konstruktor
    Start(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        //Určení barvy, velikosti a fontu textu
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString(format("Press X to start the game "), x,y);
    }
    //Metoda pro zaznamenání jesli byla určitá klávesa zmáčknuta
    public void keyPressedStart(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_X) {
            if (HerniPanel.panel == 1){
                HerniPanel.panel = 2;
            }
        }
    }
}
