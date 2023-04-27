package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.String.format;

public class ZpetDoMenu extends Rectangle {
    //Konstruktor
    ZpetDoMenu(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString(format("Press G to return to main menu "), x,y);
    }
    //Metoda pro zaznamenání jestli byla určitá klávesa zmáčknuta
    //Slouží k návratu do menu
    public void keyPressedDoMenu(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_G) {
            if (HerniPanel.panel == 4){
                HerniPanel.panel = 1;
            }
        }
    }
}
