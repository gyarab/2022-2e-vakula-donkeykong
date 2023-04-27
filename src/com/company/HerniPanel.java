package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Třída HerniPanel je rozšířena o třídu Jpanel ze knihovny java swing, třída je také implementovaná o Runnable, tudíž v ní máme metodu run(), která běří jako samostatné vlákna
public class HerniPanel extends JPanel implements Runnable{
    //Velmi důležitá proměnná, podle ní se rozhoduje co se namaluje na panel a co ne
    public static int panel = 1;
    //Předepsané proměnné, které nelze měnit
    static final int HERNI_SIRKA = 1000;
    static final int HERNI_VYSKA = 750;
    static final Dimension SCREEN_SIZE = new Dimension(HERNI_SIRKA, HERNI_VYSKA);
    static final int SIRKA_PLOSINY = 850;
    static final int VYSKA_PLOSINY = 20;
    static final int SIRKA_ZEBRIKU = 20;
    static final int VYSKA_ZEBRIKU = 70;
    static final int MARIO_VELIKOST_XY = 25;
    static final int BARREL_VELIKOST_XY = 25;
    static final int OPICAL_VELIKOST_XY = 50;
    static final int PRINCEZNA_VELIKOST_XY = 25;
//Vytvořené objekty
    Thread gameThread;
    Image image;
    Graphics graphics;
    Plosina plosina0a;
    Plosina plosina0b;
    Plosina plosina1a;
    Plosina plosina1b;
    Plosina plosina2a;
    Plosina plosina2b;
    Plosina plosina3a;
    Plosina plosina3b;
    Plosina plosina4a;
    Plosina plosina4b;
    Plosina plosina5a;
    Plosina plosina5b;
    Plosina plosina6a;
    Plosina plosina6b;
    Plosina plosina7;
    Plosina plosina8a;
    Plosina plosina8b;
    Mario mario;
    Mario fakeMario1;
    Mario fakeMario2;
    Mario fakeMario3;
    Mario fakeMario4;
    Mario fakeMario5;
    Zebrik zebrik1;
    Zebrik zebrik2;
    Zebrik zebrik3;
    Zebrik zebrik4;
    Zebrik zebrik5;
    Zebrik zebrik6;
    Zebrik zebrik7;
    Zebrik fakZebrik;
    Barrel barrel1;
    Barrel barrel2;
    Barrel barrel3;
    Barrel barrel4;
    Barrel barrel5;
    Barrel barrel6;
    Barrel barrel7;
    Barrel fakeBarrel;
    Opicak opicak;
    Princezna princezna;
    Princezna fakePrincezna;
    Cas cas;
    HromadaBarelu hromadaBarelu;
    Logo logo;
    Start start;
    Ovladani ovladani;
    OvladaniList ovladaniList;
    VyhralJsi vyhralJsi;
    Srdicko fakeSrdicko;
    ZpetDoMenu zpetDoMenu;
    ProhralJsi prohralJsi;
    ZkusitZnovu zkusitZnovu;
    Zivoty zivotyVelke;
    Zivoty zivotyMale;

//Konstruktor s předepsanými metodami
    HerniPanel(){
            novaPlosina();
            novyMario();
            novyZebrik();
            novyBarrel();
            novyOpicak();
            novaPrincezna();
            novyCas();
            novyHromadaBarelu();
            novyLogo();
            novyStart();
            novyOvladani();
            novyOvladaniList();
            novyVyhralJsi();
            novySrdicko();
            novyZpetDoMenu();
            novyProhralJsi();
            novyZkusitZnovu();
            novyZivoty();


            this.setFocusable(true);
            this.addKeyListener(new AL());
            this.setPreferredSize(SCREEN_SIZE);

            gameThread = new Thread(this);
            gameThread.start();

    }

//Metoda pro vytvoření objektů podle konstruktoru ze třídy Plosina
    public void novaPlosina() {
        plosina0a = new Plosina(0, (HERNI_VYSKA - VYSKA_PLOSINY), (HERNI_SIRKA/2), VYSKA_PLOSINY);
        plosina0b = new Plosina((HERNI_SIRKA/2), (HERNI_VYSKA - VYSKA_PLOSINY), (HERNI_SIRKA/2), VYSKA_PLOSINY);
        plosina1a = new Plosina(0,(HERNI_VYSKA - VYSKA_PLOSINY - 90), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina1b = new Plosina((SIRKA_PLOSINY/2),(HERNI_VYSKA - VYSKA_PLOSINY - 90), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina2a = new Plosina((HERNI_SIRKA - SIRKA_PLOSINY), (HERNI_VYSKA - VYSKA_PLOSINY - 180), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina2b = new Plosina((HERNI_SIRKA - (SIRKA_PLOSINY/2)), (HERNI_VYSKA - VYSKA_PLOSINY - 180), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina3a = new Plosina(0, (HERNI_VYSKA - VYSKA_PLOSINY - 270), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina3b = new Plosina((SIRKA_PLOSINY/2), (HERNI_VYSKA - VYSKA_PLOSINY - 270), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina4a = new Plosina((HERNI_SIRKA - SIRKA_PLOSINY), (HERNI_VYSKA - VYSKA_PLOSINY - 360), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina4b = new Plosina((HERNI_SIRKA - (SIRKA_PLOSINY/2)), (HERNI_VYSKA - VYSKA_PLOSINY - 360), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina5a = new Plosina(0, (HERNI_VYSKA - VYSKA_PLOSINY - 450), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina5b = new Plosina((SIRKA_PLOSINY/2), (HERNI_VYSKA - VYSKA_PLOSINY - 450), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina6a = new Plosina((HERNI_SIRKA - SIRKA_PLOSINY), (HERNI_VYSKA - VYSKA_PLOSINY - 540), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina6b = new Plosina((HERNI_SIRKA - (SIRKA_PLOSINY/2)), (HERNI_VYSKA - VYSKA_PLOSINY - 540), (SIRKA_PLOSINY/2), VYSKA_PLOSINY);
        plosina7 = new Plosina(600, (HERNI_VYSKA - VYSKA_PLOSINY - 630), 400, VYSKA_PLOSINY);
        plosina8a = new Plosina(0, 500, (HERNI_SIRKA/2), VYSKA_PLOSINY);
        plosina8b = new Plosina((HERNI_SIRKA/2), 500, (HERNI_SIRKA/2), VYSKA_PLOSINY);

//Určení parametrů aby plošiny věděly jak se nakreslit
        plosina7.typPlosiny = 7;
        plosina0a.typPlosiny = 0;
        plosina0b.typPlosiny = 0;
        plosina8a.typPlosiny = 0;
        plosina8b.typPlosiny = 0;

    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Mario
    public void novyMario(){
        mario= new Mario(150, (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY), MARIO_VELIKOST_XY , MARIO_VELIKOST_XY );
        //Určování parametrů aby daný objekt věděl kde má být a jak se má nakreslit
        fakeMario1 = new Mario(200, (HERNI_VYSKA - VYSKA_PLOSINY -50 ), 50, 50);
        fakeMario1.x = 200;
        fakeMario1.y = (HERNI_VYSKA - VYSKA_PLOSINY -50 );
        fakeMario1.jeFake = 1;
        fakeMario1.lezeAnoNe= 3;
        fakeMario1.kamchodi = 3;
        fakeMario2 = new Mario(500,(HERNI_VYSKA - VYSKA_PLOSINY -100 ), 50, 50 );
        fakeMario2.x = 500;
        fakeMario2.y = (HERNI_VYSKA - VYSKA_PLOSINY -100 );
        fakeMario2.jeFake = 2;
        fakeMario2.lezeAnoNe= 3;
        fakeMario2.kamchodi = 3;
        fakeMario3 = new Mario(800,(HERNI_VYSKA - VYSKA_PLOSINY -80 ), 50, 50 );
        fakeMario3.x = 800;
        fakeMario3.y = (HERNI_VYSKA - VYSKA_PLOSINY -80 );
        fakeMario3.jeFake = 3;
        fakeMario3.lezeAnoNe= 3;
        fakeMario3.kamchodi = 3;
        fakeMario4 = new Mario(200, 450, 50, 50);
        fakeMario4.x = 200;
        fakeMario4.jeFake = 1;
        fakeMario4.lezeAnoNe= 3;
        fakeMario4.kamchodi = 3;
        fakeMario5 = new Mario(350,450, 50, 50);
        fakeMario5.jeFake = 1;
        fakeMario5.lezeAnoNe= 3;
        fakeMario5.kamchodi = 3;

    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Zebrik
    public void novyZebrik(){
        zebrik1 = new Zebrik(800, (HERNI_VYSKA-VYSKA_PLOSINY-VYSKA_ZEBRIKU),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik2 = new Zebrik(200, (HERNI_VYSKA-VYSKA_PLOSINY-VYSKA_ZEBRIKU-90),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik3 = new Zebrik(700, (HERNI_VYSKA-180-VYSKA_PLOSINY-VYSKA_ZEBRIKU),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik4 = new Zebrik(300, (HERNI_VYSKA-270-VYSKA_PLOSINY-VYSKA_ZEBRIKU),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik5 = new Zebrik(800, (HERNI_VYSKA-360-VYSKA_PLOSINY-VYSKA_ZEBRIKU),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik6 = new Zebrik(200, (HERNI_VYSKA-450-VYSKA_PLOSINY-VYSKA_ZEBRIKU),SIRKA_ZEBRIKU,VYSKA_ZEBRIKU);
        zebrik7 = new Zebrik(700, (HERNI_VYSKA-540-VYSKA_PLOSINY-VYSKA_ZEBRIKU), SIRKA_ZEBRIKU, VYSKA_ZEBRIKU);
        fakZebrik = new Zebrik(800,(HERNI_VYSKA - VYSKA_PLOSINY -95 ),45, 95);
        fakZebrik.jeFake = 1;
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Barrel
    public void novyBarrel(){
        barrel1 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel2 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel3 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel4 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel5 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel6 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        barrel7 = new Barrel(785, 75, BARREL_VELIKOST_XY,BARREL_VELIKOST_XY);
        fakeBarrel = new Barrel(HERNI_SIRKA-25, 475, 25,25);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Opicak
    public void novyOpicak(){
        opicak = new Opicak(800, 50, OPICAL_VELIKOST_XY, OPICAL_VELIKOST_XY);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Princezna
    public void novaPrincezna(){
        princezna = new Princezna(900, 165, PRINCEZNA_VELIKOST_XY,PRINCEZNA_VELIKOST_XY);
        fakePrincezna = new Princezna(600, 450,50, 50);
        fakePrincezna.jeFake = 1;
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Cas
    public void novyCas(){
        cas = new Cas(50,50, 200,100);
        cas.startTimer();
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy HromadaBarelu
    public void novyHromadaBarelu(){
        hromadaBarelu = new HromadaBarelu(850, 50, 50, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Logo
    public void novyLogo(){
        logo = new Logo(200, 150, 600, 300 );
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Start
    public void novyStart(){
        start = new Start(350, 600, 100, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Ovladani
    public void novyOvladani(){
        ovladani = new Ovladani(365,700,100, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy OvladaniList
    public void novyOvladaniList(){
        ovladaniList = new OvladaniList(50,50, 200, 200);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Vyhraljsi
    public void novyVyhralJsi(){
        vyhralJsi = new VyhralJsi(300,150,600,300);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Srdicko
    public void novySrdicko(){
        fakeSrdicko = new Srdicko(475, 300, 50, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy ZpetDoMenu
    public void novyZpetDoMenu(){
        zpetDoMenu = new ZpetDoMenu(325, 600, 100, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy ProhralJsi
    public void novyProhralJsi(){
        prohralJsi = new ProhralJsi(250,150,600,300);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy ZkusitZnovu
    public void novyZkusitZnovu(){
        zkusitZnovu = new ZkusitZnovu(375, 650, 100, 50);
    }
    //Metoda pro vytvoření objektů podle konstruktoru ze třídy Zivoty
    public void novyZivoty(){
        zivotyVelke = new Zivoty(350, 365, 350, 100);
        zivotyVelke.jeVelky = 1;
        zivotyVelke.startTimer();
        zivotyMale = new Zivoty(50, 100, 200, 50);
        zivotyMale.jeVelky = 0;


    }

//Metoda z knihovny java swing, která podle objektu Graphis konfiguruje příslušné komponenty
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        nakresli(graphics);
        g.drawImage(image,0,0,this);

    }
    //Metoda která kreslí všechny vytvořené objekty
    public void nakresli(Graphics g) {
        if (panel == 2){
    plosina0a.nakresli(g);
    plosina0b.nakresli(g);
    plosina1a.nakresli(g);
    plosina1b.nakresli(g);
    plosina2a.nakresli(g);
    plosina2b.nakresli(g);
    plosina3a.nakresli(g);
    plosina3b.nakresli(g);
    plosina4a.nakresli(g);
    plosina4b.nakresli(g);
    plosina5a.nakresli(g);
    plosina5b.nakresli(g);
    plosina6a.nakresli(g);
    plosina6b.nakresli(g);
    plosina7.nakresli(g);
    zebrik1.nakresli(g);
    zebrik2.nakresli(g);
    zebrik3.nakresli(g);
    zebrik4.nakresli(g);
    zebrik5.nakresli(g);
    zebrik6.nakresli(g);
    zebrik7.nakresli(g);
    barrel1.nakresli(g);
    opicak.nakresli(g);
    princezna.nakresli(g);
    mario.nakresli(g);
    cas.nakresli(g);
    hromadaBarelu.nakresli(g);
    zivotyMale.nakresli(g);

//udělené podmínky slouží k určetému chování objektů na ploše panelu
    if(barrel2.povoleniKPohybu == 1){
        barrel2.nakresli(g);
    }
    if(barrel3.povoleniKPohybu == 1){
        barrel3.nakresli(g);
    }
    if(barrel4.povoleniKPohybu == 1){
        barrel4.nakresli(g);
    }
    if(barrel5.povoleniKPohybu == 1){
        barrel5.nakresli(g);
    }
    if(barrel6.povoleniKPohybu == 1){
        barrel6.nakresli(g);
    }
    if(barrel7.povoleniKPohybu == 1){
        barrel7.nakresli(g);
    }
}
        if (panel == 1){
            logo.nakresli(g);
            start.nakresli(g);
            ovladani.nakresli(g);
            plosina8a.nakresli(g);
            plosina8b.nakresli(g);
            fakeMario4.nakresli(g);
            fakeBarrel.nakresli(g);
        }
        if (panel == 3){
            ovladaniList.nakresli(g);
            plosina0a.nakresli(g);
            plosina0b.nakresli(g);
            fakeMario1.nakresli(g);
            fakeMario2.nakresli(g);
            fakZebrik.nakresli(g);
            fakeMario3.nakresli(g);

        }
        if (panel == 4){
            vyhralJsi.nakresli(g);
            plosina8a.nakresli(g);
            plosina8b.nakresli(g);
            fakeMario5.nakresli(g);
            fakePrincezna.nakresli(g);
            fakeSrdicko.nakresli(g);
            zpetDoMenu.nakresli(g);
        }
        if (panel == 5){
            prohralJsi.nakresli(g);
            zkusitZnovu.nakresli(g);
        }
        if (panel == 6){
            zivotyVelke.nakresli(g);
        }

    }
    //metoda, která zobrazuje objekty na určité souřadnicové poloze a umožnuje tak jejich pohyb
    public void move() {
if (panel == 2){
    mario.move();

    barrel1.move();
    if (barrel2.povoleniKPohybu == 1){
        barrel2.move();
    }
    if (barrel3.povoleniKPohybu == 1){
        barrel3.move();
    }
    if (barrel4.povoleniKPohybu == 1){
        barrel4.move();
    }
    if (barrel5.povoleniKPohybu == 1){
        barrel5.move();
    }
    if(barrel6.povoleniKPohybu == 1){
        barrel6.move();
    }
    if(barrel7.povoleniKPohybu == 1){
        barrel7.move();
    }

}
        if (panel == 1 ){
            fakeBarrel.move();
            fakeMario4.move();
        }

    }
    //Velmi obsáhlá a důležítá metoda, slouží k rozpoznání zda li některé objety mezi sebou interagují
    public void zkontrolujKolizi() {
//podmínka aby objekt mario nemohl za rám aplikace
            if(mario.x<=0)
                mario.x=0;
            if(mario.x >= (HERNI_SIRKA-MARIO_VELIKOST_XY))
                mario.x = HERNI_SIRKA-MARIO_VELIKOST_XY;
//Umožňuje objektu mario chození po plošinách a další interakce
            if (mario.intersects(plosina0a)) {
                mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina0b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina1a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-90);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina1b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-90);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina2a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-180);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina2b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-180);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina3a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-270);
                mario.povoleniVyskocit = 1;
            }else if(mario.intersects(plosina3b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-270);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina4a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-360);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina4b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-360);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina5a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-450);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina5b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-450);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina6a)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-540);
                mario.povoleniVyskocit = 1;
            } else if(mario.intersects(plosina6b)){
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY-540);
                mario.povoleniVyskocit = 1;
            } else mario.povoleniVyskocit = 0;


//Umožňuje objektům barrel kutálení po plošinách
            if(barrel1.intersects(plosina0a)) {
                barrel1.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina0b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina1a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina1b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina2a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina2b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina3a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina3b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina4a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina4b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina5a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina5b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel1.rychlost = 5;
            }else if(barrel1.intersects(plosina6a)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina6b)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel1.rychlost = -5;
            }else if(barrel1.intersects(plosina7)){
                barrel1.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel1.rychlost = -5;
            }else {
                barrel1.rychlost = 0;
            }
            //Pokud barrel dojde za rám aplikace, ocitne se na místě kde začínal
            if(barrel1.x == 0){
                barrel1.x = 785;
                barrel1.y = 60;
            }

            if(barrel1.intersects(zebrik6)){
                barrel2.povoleniKPohybu = 1;
            }if(barrel2.intersects(plosina0a)) {
                barrel2.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina0b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina1a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina1b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina2a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina2b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina3a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina3b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina4a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina4b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina5a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina5b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel2.rychlost = 5;
            }else if(barrel2.intersects(plosina6a)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina6b)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel2.rychlost = -5;
            }else if(barrel2.intersects(plosina7)){
                barrel2.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel2.rychlost = -5;
            } else {
                barrel2.rychlost = 0;
            }
            if(barrel2.x == 0){
                barrel2.x = 785;
                barrel2.y = 60;
            }

            if(barrel2.intersects(zebrik6)){
                barrel3.povoleniKPohybu = 1;
            }else if(barrel3.intersects(plosina0a)) {
                barrel3.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina0b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina1a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina1b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina2a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina2b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina3a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina3b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina4a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina4b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina5a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina5b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel3.rychlost = 5;
            }else if(barrel3.intersects(plosina6a)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina6b)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel3.rychlost = -5;
            }else if(barrel3.intersects(plosina7)){
                barrel3.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel3.rychlost = -5;
            } else {
                barrel3.rychlost = 0;
            }
            if(barrel3.x == 0){
                barrel3.x = 785;
                barrel3.y = 60;
            }

            if(barrel3.intersects(zebrik6)){
                barrel4.povoleniKPohybu = 1;
            }else if(barrel4.intersects(plosina0a)) {
                barrel4.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina0b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina1a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina1b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina2a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina2b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina3a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina3b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina4a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina4b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina5a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina5b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel4.rychlost = 5;
            }else if(barrel4.intersects(plosina6a)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina6b)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel4.rychlost = -5;
            }else if(barrel4.intersects(plosina7)){
                barrel4.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel4.rychlost = -5;
            } else {
                barrel4.rychlost = 0;
            }
            if(barrel4.x == 0){
                barrel4.x = 785;
                barrel4.y = 60;
            }

            if(barrel4.intersects(zebrik6)){
                barrel5.povoleniKPohybu = 1;
            }else if(barrel5.intersects(plosina0a)) {
                barrel5.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina0b)) {
                barrel5.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina1a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina1b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina2a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina2b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina3a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina3b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina4a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina4b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina5a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina5b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel5.rychlost = 5;
            }else if(barrel5.intersects(plosina6a)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina6b)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel5.rychlost = -5;
            }else if(barrel5.intersects(plosina7)){
                barrel5.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel5.rychlost = -5;
            } else {
                barrel5.rychlost = 0;
            }
            if(barrel5.x == 0){
                barrel5.x = 785;
                barrel5.y = 60;
            }

            if(barrel5.intersects(zebrik6)){
                barrel6.povoleniKPohybu = 1;
            }else if(barrel6.intersects(plosina0a)) {
                barrel6.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina0b)) {
                barrel6.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina1a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina1b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina2a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina2b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina3a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina3b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina4a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina4b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina5a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina5b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel6.rychlost = 5;
            }else if(barrel6.intersects(plosina6a)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina6b)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel6.rychlost = -5;
            }else if(barrel6.intersects(plosina7)){
                barrel6.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel6.rychlost = -5;
            } else {
                barrel6.rychlost = 0;
            }
            if(barrel6.x == 0){
                barrel6.x = 785;
                barrel6.y = 60;
            }

            if(barrel6.intersects(zebrik6)){
                barrel7.povoleniKPohybu = 1;
            }else if(barrel7.intersects(plosina0a)) {
                barrel7.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina0b)) {
                barrel7.y = (HERNI_VYSKA - VYSKA_PLOSINY - BARREL_VELIKOST_XY);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina1a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina1b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-90);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina2a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina2b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-180);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina3a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina3b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-270);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina4a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina4b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-360);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina5a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina5b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-450);
                barrel7.rychlost = 5;
            }else if(barrel7.intersects(plosina6a)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina6b)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-540);
                barrel7.rychlost = -5;
            }else if(barrel7.intersects(plosina7)){
                barrel7.y = (HERNI_VYSKA-VYSKA_PLOSINY-BARREL_VELIKOST_XY-630);
                barrel7.rychlost = -5;
            } else {
                barrel7.rychlost = 0;
            }
            if(barrel7.x == 0){
                barrel7.x = 785;
                barrel7.y = 60;
            }
//díky podmínkám je objekt opičák se schopen se chovat podle souřadnicích ostatních objektů
            if (barrel1.x >= 600 && barrel1.x <= 780 && barrel1.y == 75) {
                opicak.polohaOpicaka = 1;
            }else if (barrel2.x >= 600 && barrel2.x <= 780 && barrel2.y == 75){
                opicak.polohaOpicaka = 1;
            }else if (barrel3.x >= 600 && barrel3.x <= 780 && barrel3.y == 75){
                opicak.polohaOpicaka = 1;
            }else if (barrel4.x >= 600 && barrel4.x <= 780 && barrel4.y == 75){
                opicak.polohaOpicaka = 1;
            }else if (barrel5.x >= 600 && barrel5.x <= 780 && barrel5.y == 75){
                opicak.polohaOpicaka = 1;
            }else if (barrel6.x >= 600 && barrel6.x <= 780 && barrel6.y == 75){
                opicak.polohaOpicaka = 1;
            }else if (barrel7.x >= 600 && barrel7.x <= 780 && barrel7.y == 75){
                opicak.polohaOpicaka = 1;
            } else opicak.polohaOpicaka = 0;


//Podmínky umožňujou lezení po žebříku
            if(mario.intersects(zebrik1)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik2)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik3)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik3)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik4)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik5)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else if (mario.intersects(zebrik6)){
                mario.povoleniKLezeni = 1;
                mario.gravitace =0;
            }else{
                mario.povoleniKLezeni = 0;
                mario.gravitace =5;
            }
//Podmínku určujou jak se má objekt mario vykreslit
            if (mario.intersects(zebrik1) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 5)){
                mario.lezeAnoNe = 1;
            }else if (mario.intersects(zebrik2) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU - 90 + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 90 - 5)){
                mario.lezeAnoNe = 1;
            }else if (mario.intersects(zebrik3) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU - 180 + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 180 - 5)){
                mario.lezeAnoNe = 1;
            }else if (mario.intersects(zebrik4) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU - 270 + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 270 - 5)){
                mario.lezeAnoNe = 1;
            }else if (mario.intersects(zebrik5) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU - 360 + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 360 - 5)){
                mario.lezeAnoNe = 1;
            }else if (mario.intersects(zebrik6) && mario.y > (HERNI_VYSKA - VYSKA_PLOSINY-VYSKA_ZEBRIKU - 450 + 5) && mario.y < (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY - 450 - 5)){
                mario.lezeAnoNe = 1;
            } else mario.lezeAnoNe = 0;
//Podmínky pro náraz barrelu a maria
            if (mario.intersects(barrel1)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                } else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel2)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel3)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel4)) {
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel5)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel6)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }
            if (mario.intersects(barrel7)){
                if (mario.pocetZivotu == 0) {
                    panel = 5;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }else if (mario.pocetZivotu > 0){
                    mario.pocetZivotu--;
                    panel = 6;
                    mario.x = 150;
                    mario.y = (HERNI_VYSKA - VYSKA_PLOSINY - MARIO_VELIKOST_XY);
                    barrel1.x = 785;
                    barrel1.y = 75;
                    barrel2.x = 785;
                    barrel2.y = 75;
                    barrel2.povoleniKPohybu = 0;
                    barrel3.x = 785;
                    barrel3.y = 75;
                    barrel3.povoleniKPohybu = 0;
                    barrel4.x = 785;
                    barrel4.y = 75;
                    barrel4.povoleniKPohybu = 0;
                    barrel5.x = 785;
                    barrel5.y = 75;
                    barrel5.povoleniKPohybu = 0;
                    barrel6.x = 785;
                    barrel6.y = 75;
                    barrel6.povoleniKPohybu = 0;
                    barrel7.x = 785;
                    barrel7.y = 75;
                    barrel7.povoleniKPohybu = 0;
                }
            }

//Podmínky pro kolizi Maria a Princezny
            if (mario.intersects(princezna)){
                panel = 4;
                mario.x = 150;
                mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY);
                barrel1.x = 785;
                barrel1.y = 75;
                barrel2.x = 785;
                barrel2.y = 75;
                barrel2.povoleniKPohybu = 0;
                barrel3.x = 785;
                barrel3.y = 75;
                barrel3.povoleniKPohybu = 0;
                barrel4.x = 785;
                barrel4.y = 75;
                barrel4.povoleniKPohybu = 0;
                barrel5.x = 785;
                barrel5.y = 75;
                barrel5.povoleniKPohybu = 0;
                barrel6.x = 785;
                barrel6.y = 75;
                barrel6.povoleniKPohybu = 0;
                barrel7.x = 785;
                barrel7.y = 75;
                barrel7.povoleniKPohybu = 0;
            }

//Podmínky pro umožnění animace určitého barrelu
        if(fakeBarrel.intersects(plosina8a)) {
            fakeBarrel.y = 475;
            fakeBarrel.rychlost = -5;
        }else if(fakeBarrel.intersects(plosina8b)){
            fakeBarrel.y = 475;
            fakeBarrel.rychlost = -5;
        }
        if(fakeBarrel.x == 0){
            fakeBarrel.x = HERNI_SIRKA;
        }

//Podmínky pro umožnění animace určitého objektu mario
        if (fakeMario4.intersects(plosina8a)) {
            fakeMario4.y = 450;
            fakeMario4.povoleniVyskocit = 1;
        } else if(fakeMario4.intersects(plosina8b)){
            fakeMario4.y = 450;
            fakeMario4.povoleniVyskocit = 1;
        }
        if (fakeBarrel.x == (fakeMario4.x + 50 + 10)){
            if(fakeMario4.povoleniVyskocit==1){
                fakeMario4.skace = true;
            }
        }
        if (fakeMario4.y == 400) {
            fakeMario4.skace = false;
        }


//Podmínky pro chování určitých atributů při resetování hry
        if (zkusitZnovu.bylZmacknut == 1){
            mario.pocetZivotu = 3;
        }
        zivotyMale.pocetZivotu = mario.pocetZivotu;
        zivotyVelke.pocetZivotu = mario.pocetZivotu;

        if (mario.x != 200){
            zkusitZnovu.bylZmacknut = 0;
        }
        //Slouží aby se mario tolik neglitchoval
        if (panel != 2){
            mario.x = 150;
            mario.y = (HERNI_VYSKA-VYSKA_PLOSINY-MARIO_VELIKOST_XY);
        }

    }
//Metoda run(), neboli u her často nazívána game loop, velmi důležitá metoda, která neustále kontroluje podmínky a vykresluje podmínky
    //Metodu run() jsem převzal z videa: https://youtu.be/oLirZqJFKPE
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                zkontrolujKolizi();
                repaint();
                delta--;

            }
        }
    }
    //Třída rozřířená o třídu z knihovny pro čtení z klávesnice
    public class AL extends KeyAdapter{
        //Metoda pro zaznamenávání zmáčknutí klávesy
        public void keyPressed(KeyEvent e) {
            mario.keyPressed(e);
            start.keyPressedStart(e);
            ovladani.keyPressedOvladani(e);
            ovladaniList.keyPressedOvladaniList(e);
            zpetDoMenu.keyPressedDoMenu(e);
            zkusitZnovu.keyPressedZkusitZnovu(e);
        }
        //Metoda pro zaznamenávání puštění klávesy
        public void keyReleased(KeyEvent e) {
            mario.keyReleased(e);
            zkusitZnovu.keyReleasedZkusitZnovu(e);
        }
    }
}


