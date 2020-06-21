package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import i.digtive.smartdiet.Utils.FuzyAdapter;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_akhir);
        ButterKnife.bind(this);
        brt = Double.parseDouble(getIntent().getStringExtra("berat"));
        tgi = Double.parseDouble(getIntent().getStringExtra("tinggi"));
        aktf = Double.parseDouble(getIntent().getStringExtra("aktifitas"));
        umr = Double.parseDouble(getIntent().getStringExtra("umur"));
        jk = getIntent().getStringExtra("jk");
        fuzyAdapter = new FuzyAdapter(getApplicationContext(),brt,tgi,jk,umr,aktf);
        fuzyAdapter.iBMI(fuzyAdapter.getTextBerat(),fuzyAdapter.getTextTinggi());
        String kbmi = fuzyAdapter.getKbmi();
        String textBerat = fuzyAdapter.getTextBerat();
        String textTinggi = fuzyAdapter.getTextTinggi();
        double ibmi = fuzyAdapter.iBMI(fuzyAdapter.getTextBerat(),fuzyAdapter.getTextTinggi());
        fuzyAdapter.setBatasAtas(kbmi,ibmi);
        double m1,m2,m3,d1,d2,d3;
        m1 = fuzyAdapter.hitungM1Bmi(kbmi);
        m2 = fuzyAdapter.hitungM2Bmi();
        m3 = fuzyAdapter.hitungM3Bmi(kbmi);
        d1 = fuzyAdapter.d1Bmi(ibmi,kbmi);
        d2 = fuzyAdapter.d2Bmi(ibmi);
        d3 = fuzyAdapter.d3Bmi(ibmi,kbmi);
        Log.d(TAG, "onCreate: tinggi :"+tgi);
        Log.d(TAG, "onCreate: berat :"+brt);
        Log.d(TAG, "onCreate: umur :"+umr);
        Log.d(TAG, "onCreate: jk :"+jk);
        Log.d(TAG, "onCreate: aktifitas :"+aktf);
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: berat:"+textBerat);
        Log.d(TAG, "onCreate: tinggi:"+textTinggi);
        Log.d(TAG, "onCreate: kbmi:"+kbmi);
        Log.d(TAG, "onCreate: Implikasi BMI : "+ibmi);
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: m1 bmi : "+m1);
        Log.d(TAG, "onCreate: m2 bmi : "+m2);
        Log.d(TAG, "onCreate: m3 bmi : "+m3);
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: d1 bmi : "+d1);
        Log.d(TAG, "onCreate: d2 bmi : "+d2);
        Log.d(TAG, "onCreate: d3 bmi : "+d3);
        Log.d(TAG, "onCreate: --------------------------------");
        fuzyAdapter.setBmi(d1,d2,d3,m1,m2,m3);
        int bmi = (int) fuzyAdapter.getBmi();
        Log.d(TAG, "onCreate: bmi double : "+fuzyAdapter.getBmi());
        Log.d(TAG, "onCreate: bmi int :" +bmi);
        tvBMI.setText("Nilai BMI : "+bmi);
        tvKBerat.setText(""+kbmi.toUpperCase());
        String textUmur = fuzyAdapter.getTextUmur();
        double himpUmur = fuzyAdapter.getHimpUmur();
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: himp umur : "+himpUmur);
        Log.d(TAG, "onCreate: text umur : "+textUmur);
        String textAktifitas = fuzyAdapter.getTextAktifitas();
        double himpAktifitas = fuzyAdapter.getHimpAktifitas();
        Log.d(TAG, "onCreate: text aktifitas : "+textAktifitas);
        Log.d(TAG, "onCreate: Himp aktifitas : "+himpAktifitas);
        double himpBmi = fuzyAdapter.getHimpBmi(kbmi.toLowerCase());
        double himpJk  = fuzyAdapter.getHimpJk();
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: himp Bmi : "+himpBmi);
        Log.d(TAG, "onCreate: Himp JK : "+himpJk);
        String iKalori = fuzyAdapter.iKalori(kbmi,fuzyAdapter.getTextUmur(),fuzyAdapter.getTextAktifitas(),jk);
 //       fuzyAdapter.setkba(iKalori);
        double kd1,kd2,kd3,km1,km2,km3;
        double implikasiminimalkalori = fuzyAdapter.getIminkal();

        km1 = fuzyAdapter.hitungM1Kal(iKalori);
        km2 = fuzyAdapter.hitungM2Kal();
        km3 = fuzyAdapter.hitungM3Kal(iKalori);
        kd1 = fuzyAdapter.d1Kal(fuzyAdapter.getIminkal(),iKalori);
        kd2 = fuzyAdapter.d2Kal();
        kd3 = fuzyAdapter.d3Kal(fuzyAdapter.getIminkal(),iKalori);
        Log.d(TAG, "onCreate: --------------------------------");
        Log.d(TAG, "onCreate: implikasi minimal kalori :"+implikasiminimalkalori);
        Log.d(TAG, "onCreate: implikasi kalori : "+iKalori);
        Log.d(TAG, "onCreate: km1:"+km1);
        Log.d(TAG, "onCreate: km2:"+km2);
        Log.d(TAG, "onCreate: km3:"+km3);
        Log.d(TAG, "onCreate: d1:"+d1);
        Log.d(TAG, "onCreate: d2:"+d2);
        Log.d(TAG, "onCreate: d3:"+d3);

        fuzyAdapter.setKal(kd1,kd2,kd3,km1,km2,km3);
        int kalori = (int) fuzyAdapter.getKalori();
        if (kalori<0){
            kalori = -(1)*kalori;
        }
        tvKalori.setText(kalori+" kkal");
        double karbo = kalori*0.6;
        double protein = kalori*0.15;
        double lemak = kalori*0.25;
        tvKarbohidrat.setText((int)(karbo)+" kkal");
        tvProtein.setText((int)(protein)+" kkal");
        tvLemak.setText((int)(lemak)+" kkal");
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
