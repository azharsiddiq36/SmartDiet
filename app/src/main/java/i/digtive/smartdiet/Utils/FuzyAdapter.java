package i.digtive.smartdiet.Utils;

import android.content.Context;
import android.util.Log;

import java.text.DecimalFormat;
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
    public FuzyAdapter(Context context, double berat, double tinggi, String jk, double umur,
                       double aktifitas) {
        this.df = new DecimalFormat("0.00");
        this.context = context;
        if (berat<30){
            this.berat = 30;
        }
        else if (berat>80){
            this.berat = 80;
        }
        else{
            this.berat = berat;
        }
        this.jk = jk;
        if (tinggi<145){
            this.tinggi = 145;
        }
        else if (tinggi>185){
            this.tinggi = 185;
        }
        else{
            this.tinggi = tinggi;
        }
        this.tinggi = tinggi;
        this.aktifitas = aktifitas;
        this.umur = umur;
    }

    public double getBerat(){
        return this.berat;
    }
    public double getTinggi(){
        return this.tinggi;
    }

    //hitung himpunan berat
    public String getTextBerat(){
        String text = null;
        double hr = himpRingan();
        double hn = himpNormal();
        double hb = himpBerat();
        String kt = null;
        if (hr>0 && hr<1){
            hr = himpRingan();
        }
        else{
            hr = 0;
        }
        if (hb>0 && hb<1){
            hb = himpBerat();
        }
        else{
            hb = 0;
        }
        if (hn>0 && hn<1){
            hn = himpNormal();
        }
        else{
            hn = 0;
        }
        if (hr!= 0){
            if (hr>hn){
                text = "ringan";
            }
            else{
                text = "normal";
            }
        }
        else if (hn!= 0){
            if (hn<hr){
                text = "ringan";
            }
            else if (hn<hb){
                text = "berat";
            }
            else{
                text = "normal";
            }
        }
        else{
            text = "berat";
        }
        return text;
    }
    public double himpRingan() {
        double hr = (50 - this.berat) / (50 - 30);
        return hr;
    }

    public double himpNormal() {
        double hn = (60 - this.berat) / (60 - 45);
        return hn;
    }

    public double himpBerat() {
        double hb = (80 - this.berat) / (80 - 55);
        return hb;
    }

    //hitung himp tinggi
    public String getTextTinggi(){
        String text = null;
        double hr = himpRendah();
        double hn = himpTinggiNormal();
        double ht = himpTinggi();
        String kt = null;
        if (hr>0 && hr<1){
            hr = himpRendah();
        }
        else{
            hr = 0;
        }
        if (hn>0 && hn<1){
            hn = himpTinggiNormal();
        }
        else{
            hn = 0;
        }
        if (ht>0 && ht<1){
            ht = himpTinggi();
        }
        else{
            ht = 0;
        }
        if (hr!= 0){
            if (hr>hn){
                text = "rendah";
            }
            else{
                text = "normal";
            }
        }
        else if (hn!= 0){
            if (hn<hr){
                text = "rendah";
            }
            else if (hn<ht){
                text = "tinggi";
            }
            else{
                text = "normal";
            }
        }
        else{
            text = "tinggi";
        }
        return text;
    }
    public double himpRendah() {
        double hr = (155 - this.tinggi) / (155 - 145);
        return hr;
    }

    public double himpTinggiNormal() {
        double hn = (170 - this.tinggi) / (170 - 155);
        return hn;
    }

    public double himpTinggi() {
        double ht = (185 - this.tinggi) / (185 - 165);
        return ht;
    }

    //hitung himp BMI
    public double underweight() {
        double h = (19.9 - this.bmi) / (19.9 - 10);
        return h;
    }

    public double normal() {
        double h = (24.9 - this.bmi) / (24.9 - 17);
        return h;
    }

    public double overweight() {
        double h = (29.9 - this.bmi) / (29.9 - 23);
        return h;
    }

    public double obesitas() {
        double h = (35 - this.bmi) / (35 - 28);
        return h;
    }

    //umur
    public String getTextUmur(){
        String text = null;
        double au = 0; //angka umur
        double ls = lansia();
        double rm = remaja();
        double da = dAwal();
        double de = dAkhir();
        if (rm>0 && rm<1){
            rm = remaja();
        }
        else{
            rm = 0;
        }
        if (da>0 && da<1){
            da = dAwal();
        }
        else{
            da = 0;
        }
        if (de>0 && de<1){
            de = dAkhir();
        }
        else{
            de = 0;
        }
        if (ls>0 && ls<1){
            ls = lansia();
        }
        else{
            ls = 0;
        }
        if (rm!= 0){
            if (rm>da){
                au = rm;
                text = "remaja";
            }
            else{
                au = da;
                text = "dewasa awal";
            }
        }
        else if (da!= 0){
            if (da<rm){
                au = rm;
                text = "remaja";
            }
            else if (da<de){
                au = de;
                text = "dewasa akhir";
            }
            else{
                au = da;
                text = "dewasa awal";
            }
        }
        else if (de!= 0){
            if (de<da){
                au = da;
                text = "dewasa awal";
            }
            else if (de<ls){
                au = ls;
                text = "lansia";
            }
            else{
                au = de;
                text = "dewasa akhir";
            }
        }
        else{
            au = ls;
            text = "lansia";
        }
        this.hu = au;
        return text;
    }
    public double getHimpUmur(){
        return this.hu;
    }
    public double remaja() {
        double h = (25 - this.umur) / (25 - 18);
        return h;
    }

    public double dAwal() {
        double h = (35 - this.umur) / (35 - 23);
        return h;
    }

    public double dAkhir() {
        double h = (65 - this.umur) / (65 - 30);
        return h;
    }

    public double lansia() {
        double h = (80 - this.umur) / (80 - 60);
        return h;
    }

    //aktifitas
    public String getTextAktifitas(){
        String text = null;
        double sr = aSRingan();
        double r = aRingan();
        double s = aSedang();
        double b = aBerat();
        double sb = aSBerat();
        double aa = 0;
        if (sr>0 && sr<=1){

            sr = aSRingan();
        }
        else{
            sr = 0;
        }
        if (r>0 && r<=1){
            r = aRingan();
        }
        else{
            r = 0;
        }
        if (s>0 && s<=1){
            s = aSedang();
        }
        else{
            s = 0;
        }
        if (b>0 && b<=1){
            b = aBerat();
        }
        else{
            b = 0;
        }
        if (sb>0 && sb<=1){
            sb = aSBerat();
        }
        else{
            sb = 0;
        }
        if (sr!= 0){
            if (sr>r){
                aa = sr;
                text = "sangat ringan";
            }
            else{
                aa = r;
                text = "ringan";
            }
        }
        else if (r!= 0){
            if (r<sr){
                aa = sr;
                text = "sangat ringan";
            }
            else if (r<s){
                aa = s;
                text = "sedang";
            }
            else{
                aa = r;
                text = "ringan";
            }
        }
        else if (s!= 0){
            if (s<r){
                aa = r;
                text = "ringan";
            }
            else if (s<b){
                aa = b;
                text = "berat";
            }
            else{
                aa = s;
                text = "sedang";
            }
        }
        else if (b!= 0){
            if (b<s){
                aa = s;
                text = "sedang";
            }
            else if (b<sb){
                aa = sb;
                text = "sangat berat";
            }
            else{
                aa = b;
                text = "berat";
            }
        }
        else{
            aa = sb;
            text = "sangat berat";
        }
        this.ha = aa;
        return text;
    }
    public double getHimpAktifitas(){
        return this.ha;
    }
    public double aSRingan() {
        double h = (2 - this.aktifitas) / (2 - 0);
        return h;
    }

    public double aRingan() {
        double h = (3 - this.aktifitas) / (3 - 1);
        return h;
    }

    public double aSedang() {
        double h = (6 - this.aktifitas) / (6 - 2);
        return h;
    }

    public double aBerat() {
        double h = (7 - this.aktifitas) / (7 - 5);
        return h;
    }

    public double aSBerat() {
        double h = (8 - this.aktifitas) / (8 - 6);
        return h;
    }

    //kalori
    public double kSSedikit(){
        double h = (800 - this.kalori )/ (800 - 600);

        return h;
    }
    public double kSedikit(){
        double h = (1400 - this.kalori )/ (1400 - 800);
        return h;
    }
    public double kSedang(){
        double h = (2000 - this.kalori )/ (2000 - 1200);
        return h;
    }
    public double kBanyak(){
        double h = (2300 - this.kalori )/ (2300 - 1900);
        return h;
    }
    public double kSBanyak(){
        double h = (2400 - this.kalori )/ (2400 - 2200);
        return h;
    }

    //implikasi BMI
    public double iBMI(String bdn,String tgi){

        String ibmi = null;
        double getmax = 0;
        if (bdn.equals("ringan")){
            if (tgi.equals("rendah")){
                ibmi = "normal";
                if (himpRingan()>himpRendah()){
                    getmax = himpRingan();
                }
                else{
                    getmax = himpRendah();
                }
            }
            else if(tgi.equals("normal")){
                ibmi = "normal";
                if (himpRingan()>himpNormal()){
                    getmax = himpRingan();
                }
                else{
                    getmax = himpNormal();
                }
            }
            else if (tgi.equals("tinggi")){
                if (himpRingan()>himpTinggi()){
                    getmax = himpRingan();
                }
                else{
                    getmax = himpTinggi();
                }
                ibmi = "underweight";
            }
        }
        else if (bdn.equals("normal")){
            if (tgi.equals("rendah")){
                ibmi = "overweight";
                if (himpNormal()>himpRendah()){
                    getmax = himpNormal();
                }
                else{
                    getmax = himpRendah();
                }
            }
            else if(tgi.equals("normal")){
                ibmi = "normal";
                if (himpNormal()>himpTinggiNormal()){
                    getmax = himpNormal();
                }
                else{
                    getmax = himpTinggiNormal();
                }
            }
            else if (tgi.equals("tinggi")){
                if (himpNormal()>himpTinggi()){
                    getmax = himpNormal();
                }
                else{
                    getmax = himpTinggi();
                }
                ibmi = "underweight";
            }
        }
        else if (bdn.equals("berat")){
            if (tgi.equals("rendah")){
                ibmi = "obesitas";
                if (himpBerat()>himpRendah()){
                    getmax = himpBerat();
                }
                else{
                    getmax = himpRendah();
                }
            }
            else if(tgi.equals("normal")){
                ibmi = "overweight";
                if (himpBerat()>himpTinggiNormal()){
                    getmax = himpBerat();
                }
                else{
                    getmax = himpTinggiNormal();
                }
            }
            else if (tgi.equals("tinggi")){
                ibmi = "normal";
                if (himpBerat()>himpTinggi()){
                    getmax = himpBerat();
                }
                else{
                    getmax = himpTinggi();
                }
            }
        }
        this.kbmi = ibmi;
        return getmax;
    }


    //implikasi kalori
    public String iKalori(String b,String u, String a,String jk){
        // b = bmi
        // u = umur
        // a = aktifitas
        // jk = jenis kelamin
        String kal = null;
        double h[] = new double[4];
        if (jk.equals("laki")){
            h[0] = 1;
            if (b.equals("underweight")){
                h[1] = underweight();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "ringan";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "sangat banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        kal = "sedikit";
                        h[3] = aSRingan();
                    }
                    else if (a.equals("ringan")){
                        kal = "sedang";
                        h[3] = aRingan();
                    }
                    else if (a.equals("sedang")){
                        kal = "sedang";
                        h[3] = aSedang();
                    }
                    else if (a.equals("berat")){
                        kal = "sedang";
                        h[3] = aBerat();
                    }
                    else if (a.equals("sberat")){
                        kal = "banyak";
                        h[3] = aSBerat();
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        kal = "sedikit";
                        h[3] = aSRingan();
                    }
                    else if (a.equals("ringan")){
                        kal = "sedikit";
                        h[3] = aRingan();
                    }
                    else if (a.equals("sedang")){
                        kal = "sedikit";
                        h[3] = aSedang();
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "berat";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("normal")){
                h[1] = normal();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("overweight")){
                h[1] = overweight();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("obesitas")){
                h[1] = obesitas();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
        }
        else{
            h[0] = 0;
            if (b.equals("underweight")){
                h[1] = underweight();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sedang";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedikit";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sedang";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sedang";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("normal")){
                h[1] = normal();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("overweight")){
                h[1] = overweight();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        kal = "sedang";
                        h[3] = aSRingan();
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
            else if (b.equals("obesitas")){
                h[1] = obesitas();
                if (u.equals("remaja")){
                    h[2] = remaja();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dawal")){
                    h[2] = dAwal();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aRingan();
                        kal = "banyak";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("dakhir")){
                    h[2] = dAkhir();
                    if (a.equals("sringan")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        kal = "sedang";
                        h[3] = aRingan();
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "sangat banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
                else if (u.equals("lansia")){
                    h[2] = lansia();
                    if (a.equals("sringan")){
                        h[3] = aSRingan();
                        kal = "sedang";
                    }
                    else if (a.equals("ringan")){
                        h[3] = aSedang();
                        kal = "sedang";
                    }
                    else if (a.equals("sedang")){
                        h[3] = aSedang();
                        kal = "banyak";
                    }
                    else if (a.equals("berat")){
                        h[3] = aBerat();
                        kal = "banyak";
                    }
                    else if (a.equals("sberat")){
                        h[3] = aSBerat();
                        kal = "sangat banyak";
                    }else{
                        kal = "banyak";
                        h[3]=aSBerat();
                    }
                }
            }
        }
        double min = 0;
        for (int i = 0;i<3;i++){
            Log.d("kambing", "iKalori: "+h[i]);
            if (h[i]>0){
                if (h[i]<h[i+1]){
                    min = h[i];
                }
                else{
                    min = h[i+1];
                }
            }

        }
        if (min < 0){
            min = (-1)*min;
        }
        boolean coba = 0 < 0.2;
        Log.d("kambing", "coba: "+coba);
        Log.d("kambing", "min iKalori: "+min);
        this.iminkal = min;
        return kal;
    }
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
    public double getHimpBmi(String s){
        double a = 0;
        String jBmi = null;
        if (this.bmi>=10 && this.bmi<=19.9){
            a = underweight();
            jBmi = "underweight";
        }
        else if (this.bmi>=17 && this.bmi <= 24.9){
            a = normal();
            jBmi = "normal";
        }
        else if (this.bmi>=23 && this.bmi<=29.9){
            a = overweight();
            jBmi = "overweight";
        }
        else if (this.bmi>=28){
            a = obesitas();
            jBmi = "obesitas";
        }
        if (a>0){
            a = a;
        }
        else{
            a = (-1)*a;
        }
        this.jBmi = jBmi;
        return a;
    }
    public double hitungM1Bmi(String kbmi){
        double m1 = 0;
        double b = getBbawah();
        double c = 17;
        if (kbmi.equals("normal")){
            c = 17;
        }
        else if (kbmi.equals("underweight")){
            c = 10;
        }
        else if (kbmi.equals("overweight")){
            c = 23;
        }
        else if (kbmi.equals("obesitas")){
            c = 28;
        }
        double p1 = (((b*b*b)*8)-((17*b*b)*12))/96;
        double p2 = (((c*c*c)*8)-((17*c*c)*12))/96;
        m1 = (p1-p2);
        return m1;
    }
    public double hitungM2Bmi(){
        double m2;
        double b= getBbawah();
        double c = getBatas();
        double p1 = (c*c)/5;
        double p2 = (b*b)/5;
        m2 = (p1-p2);
        return m2;
    }
    public double hitungM3Bmi(String kbmi){
        
        double m3;
        double b = 24.9;
        double c = getBatas();
        if (kbmi.equals("normal")){
            b = 24.9;
        }
        else if (kbmi.equals("underweight")){
            b = 19.9;
        }
        else if (kbmi.equals("overweight")){
            b = 29.9;
        }
        else if (kbmi.equals("obesitas")){
            b = 35;
        }
        double p1 = (((b*b*83)*117)-((10*b*b*b)*26))/3042;
        double p2 = (((c*c*83)*117)-((10*c*c*c)*26))/3042;
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
    public double getHimpJk(){
        if (this.jk.equals("laki")){
            return 1;
        }
        else{
            return 0;
        }
    }
    public String getJbmi(){
        return this.jBmi;
    }
    public void setkba(String k){
        if (k.equals("sedikit")){
            kBb =(600*this.iminkal)+800;
            kBA = 1400-(this.iminkal*600);
        }
        else if (k.equals("sedang")){
            kBb = (400*this.iminkal)+1200;
            kBA = 2000-(400*this.iminkal);
        }
        else if (k.equals("banyak")){
            kBb = (500*this.iminkal)+1900;
            kBA = 2300-(2300*this.iminkal);
        }
        else if (k.equals("sangat banyak")){
            kBb = (200 * this.iminkal)+2200;
            kBA = 2400-(200*this.iminkal);
        }
    }
    public double hitungM1Kal(String kbmi){
        double m1 = 0;
        double b = this.kBb;
        double c = 800;
        if (kbmi.equals("sedikit")){
            c = 800;
        }
        else if (kbmi.equals("sedang")){
            c = 1200;
        }
        else if (kbmi.equals("banyak")){
            c = 1900;
        }
        else if (kbmi.equals("sangat banyak")){
            c = 2200;
        }
        double p1 = (((b*b*b))-((3*b*b)*600))/1200;
        double p2 = (((c*c*c))-((3*c*c)*600))/1200;
        m1 = (p1-p2);
        return m1;
    }
    public double hitungM2Kal(){
        double m2;
        double b= this.kBb;
        double c = this.kBA;
        double p1 = (c*c)/5;
        double p2 = (b*b)/5;
        m2 = (p1-p2);
        return m2;
    }
    public double hitungM3Kal(String kbmi){
        double m1 = 0;
        double b = this.kBA;
        double c = 1400;
        if (kbmi.equals("sedikit")){
            c = 1400;
        }
        else if (kbmi.equals("sedang")){
            c = 2000;
        }
        else if (kbmi.equals("banyak")){
            c = 2300;
        }
        else if (kbmi.equals("sangat banyak")){
            c = 2400;
        }
        double p2 = (((5*b*b*b*600))-((b*b*b)))/1200;
        double p1 = (((5*c*c*600))-((c*c*c)))/1200;
        m1 = (p1-p2);
        return m1;
    }
    public double d1Kal(double a,String z){
        double c = getBbawah();
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
    public double d2Kal(){
        double d2;
        double c,d,a;
        a= this.iminkal;
        d = this.kBA;
        c = this.kBb;
        d2 = (d-c)*a;
        return d2;
    }
    public double d3Kal(double a,String z){
        double c = getBatas();
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
        double d1 = ((c-d)*bm)/2;
        return d1;
    }
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
