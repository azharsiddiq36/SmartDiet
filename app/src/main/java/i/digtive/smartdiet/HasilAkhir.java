package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import i.digtive.smartdiet.Utils.FuzyAdapter;
import i.digtive.smartdiet.Utils.HimpunanAdapter;
import i.digtive.smartdiet.Utils.RuleAdapter;

public class HasilAkhir extends AppCompatActivity {
    @BindView(R.id.tvKBerat)
    TextView tvKBerat;
    @BindView(R.id.tvKalori)
    TextView tvKalori;
    @BindView(R.id.tvBMI)
    TextView tvBMI;
    @BindView(R.id.tvProtein)
    TextView tvProtein;
    @BindView(R.id.tvKarbohidrat)
    TextView tvKarbohidrat;
    @BindView(R.id.tvLemak)
    TextView tvLemak;
    FuzyAdapter fuzyAdapter;
    double brt,umr,tgi,aktf;
    String jk;
    String TAG = "kambing";
    ArrayList<Double> himp = new ArrayList<>();
    ArrayList<Double> himpBerat= new ArrayList<>();
    ArrayList<Double> himpTinggi= new ArrayList<>();
    ArrayList<Double> himpUmur= new ArrayList<>();
    ArrayList<Double> himpBmi= new ArrayList<>();
    ArrayList<Double> himpAktifitas= new ArrayList<>();
    RuleAdapter ruleAdapter;
    ArrayList<String> berat = new ArrayList<>();
    ArrayList<String> tinggi = new ArrayList<>();
    ArrayList<String> aktifitas = new ArrayList<>();
    ArrayList<String> umur = new ArrayList<>();
    ArrayList<String> kalori = new ArrayList<>();
    ArrayList<String> listBmi = new ArrayList<>();
    String kategoriBerat,kategoriTinggi,kategoriBmi,kategoriAktifitas,kategoriUmur;
    DecimalFormat df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_akhir);
        ButterKnife.bind(this);
        df = new DecimalFormat("0.00");
        brt = Double.parseDouble(getIntent().getStringExtra("berat"));
        tgi = Double.parseDouble(getIntent().getStringExtra("tinggi"));
        aktf = Double.parseDouble(getIntent().getStringExtra("aktifitas"));
        umr = Double.parseDouble(getIntent().getStringExtra("umur"));
        jk = getIntent().getStringExtra("jk");
        HimpunanAdapter himpunanAdapter = new HimpunanAdapter();
        ruleAdapter = new RuleAdapter();
        fuzyAdapter = new FuzyAdapter(getApplicationContext(),brt,tgi,jk,umr,aktf);
        //atur kategori berat
        ruleAdapter.setRuleBerat(brt);
        //atur kategori tinggi
        ruleAdapter.setRuleTinggi(tgi);
        //mendapatkan kategori berat
        berat = ruleAdapter.getRuleBerat();
        //mendapatkan kategori tinggi
        tinggi = ruleAdapter.getRuleTinggi();
        //mengatur nilai himp berat
        for (int i = 0;i<berat.size();i++){
            himpunanAdapter.setHimpBerat(brt,berat.get(i));
            himpBerat.add(himpunanAdapter.getHimpBerat());
            Log.d(TAG, "1. himpunan berat"+himpBerat.get(i));
        }
        for (int i = 0;i<tinggi.size();i++){
            himpunanAdapter.setHimpTinggi(tgi,tinggi.get(i));
            himpTinggi.add(himpunanAdapter.getHimpTinggi());
            Log.d(TAG, "2. himpunan tinggi"+himpTinggi.get(i));
        }
        //mendapatkan nilai min fungsi implikasi bmi
        double minBmi = getMinValBmi(himpBerat,himpTinggi);
        Log.d(TAG, "3. min bmi : "+minBmi);
        //mengatur rule yg tepat untuk kategori bmi
        ruleAdapter.setKategoriBmi(kategoriBerat,kategoriTinggi);
        //mendapatkan kategori
        String kbmi = ruleAdapter.getKategoriBmi();
        Log.d(TAG, "4. kategori bmi : "+kbmi);
        //mengatur limit atas dan bawah
        fuzyAdapter.setBatasAtas(kbmi,minBmi);
        Log.d(TAG, "5. Atas ("+fuzyAdapter.getBatas()+"), Bawha ("+fuzyAdapter.getBbawah()+")");
        double m1,m2,m3,d1,d2,d3;
        /*
        mendapatkan nilai m1 bmi
        hingga d3 bmi
         */
        m1 = fuzyAdapter.hitungM1Bmi(kbmi);
        m2 = fuzyAdapter.hitungM2Bmi(minBmi);
        m3 = fuzyAdapter.hitungM3Bmi(kbmi);
        d1 = fuzyAdapter.d1Bmi(minBmi,kbmi);
        d2 = fuzyAdapter.d2Bmi(minBmi);
        d3 = fuzyAdapter.d3Bmi(minBmi,kbmi);
        /*
        m1 = df.format(fuzyAdapter.hitungM1Bmi(kbmi));
        m2 = df.format(fuzyAdapter.hitungM2Bmi(minBmi));
        m3 = df.format(fuzyAdapter.hitungM3Bmi(kbmi));
        d1 = df.format(fuzyAdapter.d1Bmi(minBmi,kbmi));
        d2 = df.format(fuzyAdapter.d2Bmi(minBmi));
        d3 = df.format(fuzyAdapter.d3Bmi(minBmi,kbmi));
        */
        fuzyAdapter.setBmi(d1,
                d2,
                d3,
                m1,
                m2,
                m3);
        //mendapatkan nilai bmi
        double bmi = fuzyAdapter.getBmi();
        tvBMI.setText("Nilai BMI : "+df.format(bmi));
        tvKBerat.setText(""+kbmi);
        //atur kategori aktifitas bmi dan umur
        ruleAdapter.setRuleAktifitas(aktf);
        ruleAdapter.setRuleUmur(umr);
        ruleAdapter.setRuleBmi(bmi);
        aktifitas = ruleAdapter.getRuleAktifitas();
        umur = ruleAdapter.getRuleUmur();
        listBmi = ruleAdapter.getRuleBmi();
        for (int i = 0;i<aktifitas.size();i++){
            himpunanAdapter.setHimpAktivitas(aktf,aktifitas.get(i));
            himpAktifitas.add(himpunanAdapter.getHimpAktivitas());
        }
        for (int i = 0;i<umur.size();i++){
            himpunanAdapter.setHimpUmur(umr,umur.get(i));
            himpUmur.add(himpunanAdapter.getHimpUmur());
        }
        for (int i = 0;i<listBmi.size();i++){
            himpunanAdapter.setBmi(bmi,listBmi.get(i));
            himpBmi.add(himpunanAdapter.getBmi());
        }
        double minKalori = getMinValKal(aktifitas,umur,listBmi);
        ruleAdapter.setJumlahKalori(kategoriBmi,kategoriUmur,kategoriAktifitas);
        String jumlahkalori = ruleAdapter.getJumlahKalori();
        //mengatur batas limit atas dan bawah
        fuzyAdapter.setkba(jumlahkalori,minKalori);

        double d1k,d2k,d3k,m1k,m2k,m3k;
        m1k = fuzyAdapter.hitungM1Kal(jumlahkalori);
        m2k = fuzyAdapter.hitungM2Kal(minKalori);
        m3k = fuzyAdapter.hitungM3Kal(jumlahkalori);
        d1k = fuzyAdapter.d1Kal(minKalori,jumlahkalori);
        d2k = fuzyAdapter.d2Kal(minKalori);
        d3k = fuzyAdapter.d3Kal(minKalori,jumlahkalori);
        fuzyAdapter.setKal(d1k,
                d2k,
                d3k,
                m1k,
                m2k,
                m3k);
        double klri = fuzyAdapter.getKalori();
        double a = klri;
        if (a<0){
            a = (-1)*a;
        }
        tvKalori.setText(df.format(a)+" kkal");
        double karbo = a*0.6;
        double protein = a*0.15;
        double lemak = a*0.25;
        tvKarbohidrat.setText((int)(karbo)+" kkal");
        tvProtein.setText((int)(protein)+" kkal");
        tvLemak.setText((int)(lemak)+" kkal");
    }

    private double getMinValKal(ArrayList<String> aktifitas, ArrayList<String> umur, ArrayList<String> listBmi) {
        double min =1;
        for (int i =0 ;i<himpUmur.size();i++){
            if (himpUmur.get(i)<min && himpUmur.get(i)>0){
                min = himpUmur.get(i);
                kategoriUmur = umur.get(i);
            }
            else{
                if (himpUmur.get(i) >= 1 && kategoriUmur==null||himpUmur.get(i) <= 0 && kategoriUmur==null){
                    kategoriUmur = umur.get(i);
                }
            }
        }
        double min2 =1;
        for (int i =0 ;i<himpBmi.size();i++){
            if (himpBmi.get(i)<min2 && himpBmi.get(i)>0){
                min2 = himpBmi.get(i);
                kategoriBmi = listBmi.get(i);
            }
            else{
                if (himpBmi.get(i) >= 1 && kategoriBmi==null||himpBmi.get(i) <= 0 && kategoriBmi==null){
                    kategoriBmi = listBmi.get(i);
                }
            }
        }
        double min3 =1;
        for (int i =0 ;i<himpAktifitas.size();i++){
            if (himpAktifitas.get(i)<min3 && himpAktifitas.get(i)>0){
                min3 = himpAktifitas.get(i);
                kategoriAktifitas = aktifitas.get(i);
            }
            else{
                if (himpAktifitas.get(i) >= 1 && kategoriAktifitas==null||himpAktifitas.get(i) <= 0 && kategoriAktifitas==null){
                    kategoriAktifitas = aktifitas.get(i);
                }
            }
        }
        if (min<min2 && min <min3){
            min =min;
        }
        else if (min2<min && min2<min3){
            min = min2;
        }
        else if (min3<min && min3<min2){
            min = min3;
        }
    return min;
    }

    private double getMinValBmi(ArrayList<Double> himpBerat, ArrayList<Double> himpTinggi) {
        double min =1;
        for (int i =0 ;i<himpBerat.size();i++){
            if (himpBerat.get(i)<min && himpBerat.get(i)>0){
                min = himpBerat.get(i);
                kategoriBerat = berat.get(i);
            }
            else{
                if (himpBerat.get(i) >= 1 && kategoriBerat==null||himpBerat.get(i) <= 0 && kategoriBerat==null){
                    kategoriBerat = berat.get(i);
                }
            }
        }
        double min2 = 1;
        for (int i =0 ;i<himpTinggi.size();i++){
            if (himpTinggi.get(i)<min2 && himpTinggi.get(i)>0){
                min2 = himpTinggi.get(i);
                kategoriTinggi = tinggi.get(i);
            }
            else{
                if (himpTinggi.get(i) <= 0 && kategoriTinggi==null || himpTinggi.get(i) >= 1 && kategoriTinggi==null){
                    kategoriTinggi = tinggi.get(i);
                }
            }
        }
        if (min>min2){
            min = min2;
        }
        return min;
    }
    @OnClick(R.id.btnKembali)
    protected void btnKembali(View view){
        Intent i = new Intent(HasilAkhir.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    @OnClick(R.id.btnHitung)
    protected void btnHitung(View view){
        Intent i = new Intent(HasilAkhir.this,FormActivity.class);
        startActivity(i);
        finish();
    }
}
