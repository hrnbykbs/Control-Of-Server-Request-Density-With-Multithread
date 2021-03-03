/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab1proje2;

import java.util.Random;

/**
 *
 * @author HARUN
 */
public class Yazlab1proje2 extends BarForm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        anasunucu ana = new anasunucu();
        Thread anathread = new Thread(ana);
        anathread.start();
    }
}

class anasunucu extends Thread {

    altsunucu1 sunucu1 = new altsunucu1();
    altsunucu2 sunucu2 = new altsunucu2();
    altsunucu3 sunucu3 = new altsunucu3();
    kontrolsunucu kontrolthread = new kontrolsunucu();
    Thread thread1 = new Thread(sunucu1);
    Thread thread2 = new Thread(sunucu2);
    Thread thread3 = new Thread(sunucu3);
    Thread thread4 = new Thread(kontrolthread);
    public static int anakapasite = 0;

    @Override
    public void run() {
        thread1.start();
        thread2.start();
        thread4.start();
        Random rnd = new Random();
        int sayac = 0;
        int rastgele = 0;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            sayac++;
            if (sayac % 2 == 0 && sayac % 5 != 0) {
                rastgele = rnd.nextInt(100);
                anakapasite += rastgele;
                System.out.println("Ana Thread'e Gelen İstek: " + rastgele + " Ana Thread'in Anlık Kapasitesi: " + anakapasite);

            }
            if (sayac % 5 == 0 && sayac % 2 != 0) {
                rastgele = rnd.nextInt(50);
                anakapasite -= rastgele;
                System.out.println("Ana Thread'den Giden İstek: " + rastgele + " Ana Thread'in Anlık Kapasitesi: " + anakapasite);
            }
            if (sayac % 5 == 0 && sayac % 2 == 0) {
                rastgele = rnd.nextInt(50);
                anakapasite -= rastgele;
                System.out.println("Ana Thread'den Giden İstek: " + rastgele + " Ana Thread'in Anlık Kapasitesi: " + anakapasite);
                rastgele = rnd.nextInt(100);
                anakapasite += rastgele;
                System.out.println("Ana Thread'e Gelen İstek: " + rastgele + " Ana Thread'in Anlık Kapasitesi: " + anakapasite);
            }

        }
    }
}

class altsunucu1 extends Thread {

    public static int sunucu1kapasite;

    public void run() {
        anasunucu ana = new anasunucu();
        Random rnd = new Random();
        int sayac = 0;
        int rastgele = 0;
        while (true) {
            try {
                Thread.sleep(95);
            } catch (Exception e) {
            }
            sayac++;
            if (sayac % 3 == 0 && sayac % 5 != 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu1kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    BarForm bf=new BarForm();
                    //bf.jProgressBar2.setValue(sunucu1kapasite);
                    //bf.jProgressBar1.setValue(ana.anakapasite);
                    //System.out.println((bf.jProgressBar2.setValue(sunucu1kapasite)));
                    Thread.sleep(0);
                    //sunucu1kapasite=0;
                    if(sunucu1kapasite==0){
                        System.out.println("1. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu1.currentThread().stop();
                    }
                    else{
                    System.out.println("1.Alt Sunucuya Gelen İstek: " + rastgele + " - 1.Alt Sunucu Kapasitesi: " + sunucu1kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);}
                } catch (Exception e) {
                }
            }
            if (sayac % 5 == 0 && sayac % 3 != 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu1kapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu1kapasite==0){
                        System.out.println("1. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu1.currentThread().stop();
                    }
                    else
                    System.out.println("1.Alt Sunucudan Giden İstek: " + rastgele + " - 1.Alt Sunucu Kapasitesi: " + sunucu1kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }
            if (sayac % 5 == 0 && sayac % 3 == 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu1kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu1kapasite==0){
                        System.out.println("1. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu1.currentThread().stop();
                    }
                    else
                    System.out.println("1.Alt Sunucuya Gelen İstek: " + rastgele + " - 1.Alt Sunucu Kapasitesi: " + sunucu1kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);

                } catch (Exception e) {
                }
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu1kapasite += rastgele;
                    Thread.sleep(0);
                    if(sunucu1kapasite==0){
                        System.out.println("1. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu1.currentThread().stop();
                    }
                    else
                    System.out.println("1.Alt Sunucudan Giden İstek: " + rastgele + " - 1.Alt Sunucu Kapasitesi: " + sunucu1kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }

        }
    }
}

class altsunucu2 extends Thread {

    public static int sunucu2kapasite;

    public void run() {
        anasunucu ana = new anasunucu();
        Random rnd = new Random();
        int sayac = 0;
        int rastgele;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            sayac++;
            if (sayac % 3 == 0 && sayac % 5 != 0) {

                try {
                    rastgele = rnd.nextInt(50);
                    sunucu2kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu2kapasite==0){
                        System.out.println("2. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu2.currentThread().stop();
                    }
                    else
                    System.out.println("2.Alt Sunucuya Gelen İstek: " + rastgele + " - 2.Alt Sunucu Kapasitesi: " + sunucu2kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {
                }
            }

            if (sayac % 5 == 0 && sayac % 3 != 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu2kapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu2kapasite==0){
                        System.out.println("2. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu2.currentThread().stop();
                    }
                    else
                    System.out.println("2.Alt Sunucudan Giden İstek: " + rastgele + " - 2.Alt Sunucu Kapasitesi: " + sunucu2kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }
            if (sayac % 5 == 0 && sayac % 3 == 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu2kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu2kapasite==0){
                        System.out.println("2. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu2.currentThread().stop();
                    }
                    else
                    System.out.println("2.Alt Sunucuya Gelen İstek: " + rastgele + " - 2.Alt Sunucu Kapasitesi: " + sunucu2kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {
                }
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu2kapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu2kapasite==0){
                        System.out.println("2. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu2.currentThread().stop();
                    }
                    else
                    System.out.println("2.Alt Sunucudan Giden İstek: " + rastgele + " - 2.Alt Sunucu Kapasitesi: " + sunucu2kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }

        }
    }
}

class altsunucu3 extends Thread {

    int kapasite = 5000;
    public static int sunucu3kapasite;

    public void run() {
        anasunucu ana = new anasunucu();
        Random rnd = new Random();
        int sayac = 0;
        int rastgele;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            sayac++;
            if (sayac % 3 == 0 && sayac % 5 != 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu3kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    Thread.sleep(0);
                    //sunucu3kapasite=0;
                    if(sunucu3kapasite==0){
                        System.out.println("3. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu3.currentThread().stop();
                    }
                    else
                    System.out.println("3.Alt Sunucuya Gelen İstek: " + rastgele + " - 3.Alt Sunucu Kapasitesi: " + sunucu3kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {
                }
            }
            if (sayac % 5 == 0 && sayac % 3 != 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu3kapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu3kapasite==0){
                        System.out.println("3. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu3.currentThread().stop();
                    }
                    else
                    System.out.println("3.Alt Sunucudan Giden İstek: " + rastgele + " - 3.Alt Sunucu Kapasitesi: " + sunucu3kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }
            if (sayac % 5 == 0 && sayac % 3 == 0) {
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu3kapasite += rastgele;
                    ana.anakapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu3kapasite==0){
                        System.out.println("3. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu3.currentThread().stop();
                    }
                    else
                    System.out.println("3.Alt Sunucuya Gelen İstek: " + rastgele + " - 3.Alt Sunucu Kapasitesi: " + sunucu3kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {
                }
                try {
                    rastgele = rnd.nextInt(50);
                    sunucu3kapasite -= rastgele;
                    Thread.sleep(0);
                    if(sunucu3kapasite==0){
                        System.out.println("3. alt sunucunun kapasitesi %0 olduğundan durduruldu!");
                        altsunucu3.currentThread().stop();
                    }
                    else
                    System.out.println("3.Alt Sunucudan Giden İstek: " + rastgele + " - 3.Alt Sunucu Kapasitesi: " + sunucu3kapasite + " - Ana Thread'in Anlık Kapasitesi: " + ana.anakapasite);
                } catch (Exception e) {

                }
            }

        }
    }
}

class kontrolsunucu extends Thread {

    int kapasite = 50;
    altsunucu1 sunucu1 = new altsunucu1();
    altsunucu2 sunucu2 = new altsunucu2();
    altsunucu3 sunucu3 = new altsunucu3();
    BarForm bf = new BarForm();
    int sunucu1yuzde = 0;
    int sunucu2yuzde = 0;
    int sunucu3yuzde = 0;

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            sunucu1yuzde = sunucu1.sunucu1kapasite / kapasite;
            System.out.println("1.Alt Sunucu Yüzdesi: " + sunucu1yuzde);
            sunucu2yuzde = sunucu2.sunucu2kapasite / kapasite;
            System.out.println("2.Alt Sunucu Yüzdesi: " + sunucu2yuzde);
            sunucu3yuzde = sunucu3.sunucu3kapasite / kapasite;
            System.out.println("3.Alt Sunucu Yüzdesi: " + sunucu3yuzde);
            if (sunucu1yuzde >= 10) {
                int yenikapasite;
                yenikapasite = altsunucu1.sunucu1kapasite / 2;
                sunucu3.kapasite = yenikapasite;
                //bf.jProgressBar3.setValue(sunucu3.kapasite);
                sunucu3.start();
            }
            if (sunucu2yuzde >= 10) {
                int yenikapasite;
                yenikapasite = altsunucu2.sunucu2kapasite / 2;
                sunucu3.kapasite = yenikapasite;
                //bf.jProgressBar3.setValue(sunucu3.kapasite);
                sunucu3.start();
            }

        }
    }
}
