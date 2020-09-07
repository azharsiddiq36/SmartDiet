package i.digtive.smartdiet.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class RuleAdapter {
    HimpunanAdapter himpunanAdapter;
    ArrayList<Double> implikasi;
    HashMap<Double,String> outputBmi;
    String TAG = "kambing";
    ArrayList<String> berat = new ArrayList<>();
    ArrayList<String> tinggi = new ArrayList<>();
    ArrayList<String> aktifitas = new ArrayList<>();
    ArrayList<String> umur = new ArrayList<>();
    ArrayList<String> kalori = new ArrayList<>();
    ArrayList<String> bmi = new ArrayList<>();
    String kategoriBmi,jumlahKalori;
    public RuleAdapter(){
        himpunanAdapter = new HimpunanAdapter();
        implikasi = new ArrayList<>();
        outputBmi = new HashMap<>();
    }
    
    public void setRuleAktifitas(double b){
        if (b<=2){
            aktifitas.add("sangat ringan");
        }
        if (b>=1 && b <=2){
            aktifitas.add("ringan");
        }
        if (b>=2 &&  b<=6){
            aktifitas.add("sedang");
        }
        if (b>=5 &&  b<=7){
            aktifitas.add("berat");
        }
        if (b>=6){
            aktifitas.add("sangat berat");
        }
    }
    public void setRuleBmi(double b){
        if (b<=19.9){
            bmi.add("underweight");
        }
        if (b>=17 && b <=24.9){
            bmi.add("normal");
        }
        if (b>=23 &&  b<=29.9){
            bmi.add("overweight");
        }
        if (b>=28){
            bmi.add("obesitas");
        }
    }
    public ArrayList<String> getRuleBmi(){
        return this.bmi;
    }
    public void setRuleUmur(double b){
        if (b<=25){
            umur.add("remaja");
        }
        if (b>=23 && b <=35){
            umur.add("dewasa awal");
        }
        if (b>=30 &&  b<=65){
            umur.add("dewasa akhir");
        }
        if (b>=60){
            umur.add("lansia");
        }
    }
    public ArrayList<String> getRuleUmur(){
        return this.umur;
    }
    public ArrayList<String> getRuleAktifitas(){
        return this.aktifitas;
    }
    public void setRuleBerat(double b){
        if (b<=50){
            berat.add("ringan");
        }
        if (b>=45 && b <=60){
            berat.add("normal");
        }
        if (b>=55){
            berat.add("berat");
        }
    }
    public void setRuleTinggi(double t){
        if (t<=155){
            tinggi.add("rendah");
        }
        if (t>=150 && t<=170){
            tinggi.add("normal");
        }
        if (t>=165){
            tinggi.add("tinggi");
        }
    }
    public ArrayList<String> getRuleBerat(){
        return this.berat;
    }
    public ArrayList<String> getRuleTinggi(){
        return this.tinggi;
    }
    public void setKategoriBmi(String berat,String tinggi){
        if (berat.equals("ringan") && tinggi.equals("rendah")){
            kategoriBmi = "normal";
        }
        else if (berat.equals("ringan") && tinggi.equals("normal")){
            kategoriBmi = "normal";
        }
        else if (berat.equals("ringan") && tinggi.equals("tinggi")){
            kategoriBmi = "underweight";
        }
        else if (berat.equals("normal") && tinggi.equals("rendah")){
            kategoriBmi = "overweight";
        }
        else if (berat.equals("normal") && tinggi.equals("normal")){
            kategoriBmi = "normal";
        }
        else if (berat.equals("normal") && tinggi.equals("tinggi")){
            kategoriBmi = "underweight";
        }
        else if (berat.equals("berat") && tinggi.equals("rendah")){
            kategoriBmi = "obesitas";
        }
        else if (berat.equals("berat") && tinggi.equals("normal")){
            kategoriBmi = "overweight";
        }
        else{
            kategoriBmi = "normal";
        }
    }
    public String getKategoriBmi(){
        return this.kategoriBmi;
    }
    public void setJumlahKalori(String bmi,String umur,String aktif){
        if (bmi.equals("underweight") && umur.equals("remaja") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("remaja") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("remaja") && aktif.equals("sedang")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("remaja") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("underweight") && umur.equals("remaja") && aktif.equals("sangat berat")){
            jumlahKalori = "banyak";
        }


        else if (bmi.equals("underweight") && umur.equals("dewasa awal") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa awal") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa awal") && aktif.equals("sedang")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa awal") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa awal") && aktif.equals("sangat berat")){
            jumlahKalori = "banyak";
        }

        else if (bmi.equals("underweight") && umur.equals("dewasa akhir") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa akhir") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa akhir") && aktif.equals("sedang")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa akhir") && aktif.equals("berat")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("underweight") && umur.equals("dewasa akhir") && aktif.equals("sangat berat")){
            jumlahKalori = "banyak";
        }

        else if (bmi.equals("underweight") && umur.equals("lansia") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("lansia") && aktif.equals("ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("lansia") && aktif.equals("sedang")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("lansia") && aktif.equals("berat")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("underweight") && umur.equals("lansia") && aktif.equals("sangat berat")){
            jumlahKalori = "sedang";
        }




        else if (bmi.equals("normal") && umur.equals("remaja") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("remaja") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("remaja") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("remaja") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("normal") && umur.equals("remaja") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }


        else if (bmi.equals("normal") && umur.equals("dewasa awal") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa awal") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa awal") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa awal") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa awal") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("normal") && umur.equals("dewasa akhir") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa akhir") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa akhir") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa akhir") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("dewasa akhir") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("normal") && umur.equals("lansia") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedikit";
        }
        else if (bmi.equals("normal") && umur.equals("lansia") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("lansia") && aktif.equals("sedang")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("normal") && umur.equals("lansia") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("normal") && umur.equals("lansia") && aktif.equals("sangat berat")){
            jumlahKalori = "banyak";
        }



        else if (bmi.equals("overweight") && umur.equals("remaja") && aktif.equals("sangat ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("remaja") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("remaja") && aktif.equals("sedang")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("remaja") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("remaja") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }


        else if (bmi.equals("overweight") && umur.equals("dewasa awal") && aktif.equals("sangat ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa awal") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa awal") && aktif.equals("sedang")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa awal") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa awal") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("overweight") && umur.equals("dewasa akhir") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa akhir") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa akhir") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa akhir") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("dewasa akhir") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("overweight") && umur.equals("lansia") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("overweight") && umur.equals("lansia") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("overweight") && umur.equals("lansia") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("lansia") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("overweight") && umur.equals("lansia") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }





        else if (bmi.equals("obesitas") && umur.equals("remaja") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("remaja") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("remaja") && aktif.equals("sedang")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("remaja") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("remaja") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }


        else if (bmi.equals("obesitas") && umur.equals("dewasa awal") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa awal") && aktif.equals("ringan")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa awal") && aktif.equals("sedang")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa awal") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa awal") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("obesitas") && umur.equals("dewasa akhir") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa akhir") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa akhir") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa akhir") && aktif.equals("berat")){
            jumlahKalori = "sangat banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("dewasa akhir") && aktif.equals("sangat berat")){
            jumlahKalori = "sangat banyak";
        }

        else if (bmi.equals("obesitas") && umur.equals("lansia") && aktif.equals("sangat ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("lansia") && aktif.equals("ringan")){
            jumlahKalori = "sedang";
        }
        else if (bmi.equals("obesitas") && umur.equals("lansia") && aktif.equals("sedang")){
            jumlahKalori = "banyak";
        }
        else if (bmi.equals("obesitas") && umur.equals("lansia") && aktif.equals("berat")){
            jumlahKalori = "banyak";
        }
        else{
            jumlahKalori = "sangat banyak";
        }
    }
    public String getJumlahKalori(){
        return this.jumlahKalori;
    }


}
