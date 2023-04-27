package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.String.format;

public class OvladaniList extends Rectangle {
    //Konstruktor
    OvladaniList(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        //Zde je napsáno ovládání hry
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString(format("'A' to move LEFT "), x,y+50);
        g.drawString(format("'D' to move RIGHT "), x,y+100);
        g.drawString(format("'W' for UP on the ladder"), x,y+150);
        g.drawString(format("'S' for DOWN on the ladder"), x,y+200);
        g.drawString(format("'SPACE' to JUMP"), x,y+250);
        g.drawString(format("Press G to go back"), x+350,y+350);
    }
    //Metoda pro zaznamenání jestli byla určitá klávesa zmáčknuta
    public void keyPressedOvladaniList(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_G) {
            if (HerniPanel.panel == 3){
                HerniPanel.panel = 1;
            }
        }
    }
}
