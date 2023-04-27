package com.company;

import java.awt.*;

import static java.lang.String.format;

public class Logo extends Rectangle {
    //Konstruktor
    Logo(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nakreslení
    public void nakresli(Graphics g) {
        //Určení barvy, velikosti a fontu Textu
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,100));
        g.drawString(format("Donkey kong"), x,y);
    }
}
