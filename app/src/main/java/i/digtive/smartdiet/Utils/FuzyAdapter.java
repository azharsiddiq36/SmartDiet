package i.digtive.smartdiet.Utils;

import android.content.Context;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FuzyAdapter {
    Context context;
    double berat;
    double tinggi;
    String jk;
    double umur;
    double aktifitas;
    double bmi;
    double kalori;
    String kbmi;// jenis bmi
    private static DecimalFormat df;
    double bAtas,bBawah;
    double hu;//himpunan umur
    double ha;//himp aktifitas
    double iminkal;//implikasi minimum kalori
    String jBmi;
    double kBA,kBb;//kalori batas atas, kalori batas bawah
    HimpunanAdapter himpunanAdapter;
    RuleAdapter ruleAdapter;
    String TAG = "kambing";
    ArrayList<Double> imp;
    public FuzyAdapter(Context context, double berat, double tinggi, String jk, double umur,
                       double aktifitas) {
        this.context = context;
        this.berat = berat;
        this.jk = jk;
        this.tinggi = tinggi;
        this.aktifitas = aktifitas;
        this.umur = umur;
        ruleAdapter = new RuleAdapter();
        himpunanAdapter = new HimpunanAdapter();
    }
    public ArrayList<Double> getImp(){
        return this.imp;
    }
    public double getBerat(){
        return this.berat;
    }
    public double getTinggi(){
        return this.tinggi;
    }


    private double get_min(double[] h) {
        Arrays.sort(h);
        double a = 0;
        for (int i = 0; i < h.length;i++){
            if (h[i]>0){
                a = h[i];
                break;
            }
        }
        Log.d("kambing", "get_min: "+a);
        return a;
    }

    //nilai minimal implikasi kalori
    public double getIminkal(){
        return this.iminkal;
    }

    public String getKbmi(){
        return this.kbmi;
    }

    //batas atas dan batas bawah
    public void setBatasAtas(String kbmi,double bmi){
        if (kbmi.equals("normal")){
            this.bBawah = (bmi*4)+17;
            this.bAtas = 24.9-(bmi*3.9);
        }
        else if (kbmi.equals("underweight")){
            this.bBawah = (bmi*5)+10;
            this.bAtas = 19.9-(bmi*4.9);
        }
        else if(kbmi.equals("overweight")){
            this.bBawah = (bmi*4)+23;
            this.bAtas = 29.9 - (bmi*2.9);
        }
        else if (kbmi.equals("obesitas")){
            this.bBawah = (bmi*4)+28;
            this.bAtas = 35-(bmi*3);
        }
    }
    public double getBatas(){
        return this.bAtas;
    }
    public double getBbawah(){
        return this.bBawah;
    }
    public double getBmi(){
        return this.bmi;
    }
    
    public double hitungM1Bmi(String kbmi){
        double m1 = 0;
        double b = getBbawah();
        double c = 17;
        double p1,p2;

        if (kbmi.equals("normal")){
            c = 17;
            p1 = (((b*b*b)/3)-(17*(b*b)/2))/4;
            p2 = (((c*c*c)/3)-(17*(c*c)/2))/4;
        }
        else if (kbmi.equals("underweight")){
            c = 10;
            p1 = (((b*b*b)/3)-(5*(b*b)))/5;
            p2 = (((c*c*c)/3)-(5*(c*c)))/5;
        }
        else if (kbmi.equals("overweight")){
            c = 23;
            p1 = (((b*b*b)/3)-((23*(b*b))/2))/4;
            p2 = (((c*c*c)/3)-((23*(c*c))/2))/4;
        }
        else{
            c = 28;
            p1 = (((b*b*b)/3)-((14*(b*b))))/4;
            p2 = (((c*c*c)/3)-((14*(c*c))))/4;
        }

        m1 = (p1-p2);
        return m1;
    }
    public double hitungM2Bmi(double angka){
        double m2;
        double b= getBbawah();
        double c = getBatas();
        double p1 = (c*c)*angka/2;
        double p2 = (b*b)*angka/2;
        m2 = (p1-p2);
        return m2;
    }
    public double hitungM3Bmi(String kbmi){
        
        double m3;
        double b = 24.9;
        double c = getBatas();
        double p1,p2;
        /*
        10 - 19,9 =
        17 - 24,9 =
        23 - 29.9 =
        28 - 35 =
         */
        if (kbmi.equals("normal")){
            b = 24.9;
            p1 = (((249*(b*b))/2)-((10*(b*b*b))/3))/39;
            p2 = (((249*(c*c))/2)-((10*(c*c*c))/3))/39;
        }
        else if (kbmi.equals("underweight")){
            b = 19.9;
            p1 = (((199*(b*b))/2)-((10*(b*b*b))/3))/49;
            p2 = (((199*(c*c))/2)-((10*(c*c*c))/3))/49;
        }
        else if (kbmi.equals("overweight")){
            b = 29.9;
            p1 = (((299*(b*b))/2)-((10*(b*b*b))/3))/29;
            p2 = (((299*(c*c))/2)-((10*(c*c*c))/3))/29;
        }
        else{
            b = 35;
            p1 = (((35*(b*b))/2)-((b*b*b)/3))/3;
            p2 = (((35*(c*c))/2)-((c*c*c)/3))/3;
        }
        m3 = p1-p2;
        return m3;
    }
    public double d1Bmi(double a,String z){
        double c = getBbawah();
        double bm = a;
        double d = 0;
        if (z.equals("normal")){
            d = 17;
        }
        else if (z.equals("underweight")){
            d = 10;
        }
        else if (z.equals("overweight")){
            d = 23;
        }
        else if (z.equals("obesitas")){
            d = 28;
        }
        double d1 = ((c-d)*bm)/2;
        return d1;
    }
    public double d2Bmi(double bmi){
        double d2;
        double c,d,a;
        a= bmi;
        d = getBatas();
        c = getBbawah();
        d2 = (d-c)*a;
        return d2;
    }
    public double d3Bmi(double bmi,String z){
        double c = getBatas();
        double bm = bmi;
        double d3;
        double d = 0;
        if (z.equals("normal")){
            d = 24.9;
        }
        else if (z.equals("underweight")){
            d = 19.9;
        }
        else if (z.equals("overweight")){
            d = 29.9;
        }
        else if (z.equals("obesitas")){
            d = 35;
        }
        d3 = ((d-c)*bm)/2;
        return d3;
    }
    public void setBmi(double d1,
                       double d2,
                       double d3,
                       double m1,
                       double m2,
                       double m3){
        double bmi = (m1+m2+m3)/(d1+d2+d3);
        this.bmi = bmi;
    }
    public String getJbmi(){
        return this.jBmi;
    }

    public void setkba(String k,double iminkal){
        if (k.equals("sedikit")){
            kBb =(600*iminkal)+800;
            kBA = 1400-(iminkal*600);
        }
        else if (k.equals("sedang")){
            kBb = (400*iminkal)+1200;
            kBA = 2000-(400*iminkal);
        }
        else if (k.equals("banyak")){
            kBb = (500*iminkal)+1900;
            kBA = 2300-(2300*iminkal);
        }
        else if (k.equals("sangat banyak")){
            kBb = (200 * iminkal)+2200;
            kBA = 2400-(200*iminkal);
        }
    }

    public double getkBb(){
        return this.kBb;
    }
    public double getkBA(){
        return this.kBA;
    }
    public double hitungM1Kal(String kbmi){
        double m1 = 0;
        double b = getkBb();
        double c = 800;
        double p1,p2;
        if (kbmi.equals("sedikit")){
            c = 800;
            /*
        800 - 1400 = 1100
        1200 - 2000 = 1600
        1900 - 2300 = 2100
        2200 - 2400 = 2300
        */
            p1 = (((b*b*b)/3)-((b*b)*400))/300;
            p2 = (((c*c*c)/3)-((c*c)*400))/300;
        }
        else if (kbmi.equals("sedang")){
            c = 1200;
          /*
        800 - 1400 = 1100
        1200 - 2000 = 1600
        1900 - 2300 = 2100
        2200 - 2400 = 2300
        */
            p1 = (((b*b*b)/3)-(600*(b*b)))/400;
            p2 = (((c*c*c)/3)-(600*(c*c)))/400;
        }

        else if (kbmi.equals("banyak")){
            c = 1900;
          /*
        800 - 1400 = 1100
        1200 - 2000 = 1600
        1900 - 2300 = 2100
        2200 - 2400 = 2300
        */
            p1 = (((b*b*b)/3)-(950*(b*b)))/200;
            p2 = (((c*c*c)/3)-(950*(c*c)))/200;
        }
        else{
            c = 2200;
          /*
        800 - 1400 = 1100
        1200 - 2000 = 1600
        1900 - 2300 = 2100
        2200 - 2400 = 2300
        */
            p1 = (((b*b*b)/3)-(1100*(b*b)))/100;
            p2 = (((c*c*c)/3)-(1100*(c*c)))/100;
        }
        m1 = (p1-p2);
        return m1;
    }
    public double hitungM2Kal(double a){
        double d2;
        double c = getkBA();
        double b = getkBb();
        double p1 = (c*c)*a/2;
        double p2 = (b*b)*a/2;
        d2 = (p1-p2);
        return d2;
    }
    public double hitungM3Kal(String kbmi){
        double m1 = 0;
        double b = getkBA();
        double c = 1400;
        double p1,p2;
        if (kbmi.equals("sedikit")){
            c = 1400;
            p2 = (((b*b)*700)-(((b*b*b)/3)))/300;
            p1 = (((c*c)*700)-(((c*c*c)/3)))/300;
        }
        else if (kbmi.equals("sedang")){
            c = 2000;
            Log.d(TAG, "hitungM3Kal: sedang "+kbmi);
            p2 = (((b*b)*1000)-(((b*b*b)/3)))/400;
            p1 = (((c*c)*1000)-(((c*c*c)/3)))/400;
        }
        else if (kbmi.equals("banyak")){
            c = 2300;
            p2 = (((b*b)*1150)-(((b*b*b)/3)))/200;
            p1 = (((c*c)*1150)-(((c*c*c)/3)))/200;
        }
        else{
            c = 2400;
            p2 = (((b*b)*700)-(((b*b*b)/3)))/300;
            p1 = (((c*c)*700)-(((c*c*c)/3)))/300;
        }
        m1 = (p1-p2);
        return m1;
    }
    public double d1Kal(double a,String z){
        double c = getkBb();
        double bm = a;
        double d = 0;
        if (z.equals("sedikit")){
            d = 800;
        }
        else if (z.equals("sedang")){
            d = 1200;
        }
        else if (z.equals("banyak")){
            d = 1900;
        }
        else if (z.equals("sangat banyak")){
            d = 2200;
        }
        double d1 = ((c-d)*bm)/2;
        return d1;
    }
    public double d2Kal(double a){
        double d2;
        double c,d;
        d = this.getkBA();
        c = this.getkBb();
        d2 = (d-c)*a;
        return d2;
    }
    public double d3Kal(double a,String z){
        double c = getkBA();
        double bm = a;
        double d = 0;
        if (z.equals("sedikit")){
            d = 1400;
        }
        else if (z.equals("sedang")){
            d = 2000;
        }
        else if (z.equals("banyak")){
            d = 2300;
        }
        else if (z.equals("sangat banyak")){
            d = 2400;
        }
        double d1 = ((d-c)*bm)/2;
        return d1;
    }
    //mengatur nilai kalori
    public void setKal(double d1,
                       double d2,
                       double d3,
                       double m1,
                       double m2,
                       double m3){
        double bmi = (m1+m2+m3)/(d1+d2+d3);
        this.kalori= bmi;
    }
    public double getKalori(){
        return this.kalori;
    }
}
