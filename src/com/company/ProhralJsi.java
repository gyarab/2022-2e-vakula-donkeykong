package com.company;

import java.awt.*;
import static java.lang.String.format;

public class ProhralJsi extends Rectangle {

    //Konstruktor
    ProhralJsi(int x, int y, int SIRKA, int VYSKA) {
        super(x, y, SIRKA, VYSKA);

    }
    //metoda pro nakreslení
    public void nakresli(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Consolas",Font.PLAIN,100));
        g.drawString(format("GAME OVER"), x,y);
    }

}
