package com.company;

import java.awt.*;
import javax.swing.*;
//Třída HraciRam je rozšířena o třídu JFrame ze knihovny java swing
public class HraciRam extends JFrame {
    //Vytvoření objektu
    HerniPanel herniPanel;

    HraciRam(){
        //Objekt postaven podle konstruktoru třídy HerniPanel
            herniPanel = new HerniPanel();
            //nastavení určitých parametrů u vytvořeného objektu
            this.add(herniPanel);
            this.setTitle("Donkey Kong");
            this.setResizable(false);
            this.setBackground(Color.BLACK);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
    }
}
