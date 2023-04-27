package com.company;

import java.awt.*;

import static java.lang.String.format;

public class VyhralJsi extends Rectangle {
    //Konstruktor
    VyhralJsi(int x, int y, int SIRKA, int VYSKA){
        super(x,y,SIRKA,VYSKA);
    }
    //Metoda pro nalreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.GREEN);
        g.setFont(new Font("Consolas",Font.PLAIN,100));
        g.drawString(format("YOU WON"), x,y);
    }
}
