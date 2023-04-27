package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.String.format;

public class Cas extends Rectangle {
//Konstruktor
    Cas(int x, int y, int Sirka, int Vyska){
        super(x,y,Sirka,Vyska);
    }
//Metoda pro počítání času na sekundy a minuty
         int sekundy = 0;
         int minuty = 0;
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            public void run() {
                if (HerniPanel.panel == 2){
                    sekundy++;
                    if (sekundy == 60) {
                        sekundy = 0;
                        minuty++;
                    }
                }
                if (HerniPanel.panel == 5){
                    sekundy = 0;
                    minuty = 0;
                }

            }
        };

        public void startTimer() {
            timer.scheduleAtFixedRate(task, 1000, 1000);
        }
        //Metoda pro nakreslení
        public void nakresli(Graphics g) {
        g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas",Font.PLAIN,60));
            g.drawString(format("%02d:%02d", minuty, sekundy), 50,50);

    }
    }


