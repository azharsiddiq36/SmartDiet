package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormAktifitas extends AppCompatActivity {
    @BindView(R.id.spAktivitas)
    Spinner spAktifitas;
    HashMap<String,String> aktif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aktifitas);
        ButterKnife.bind(this);
        aktif = new HashMap<>();
        aktif.put("Jarang/Tidak Pernah Olahraga","0");
        aktif.put("1 Kali Seminggu","1");
        aktif.put("2 Kali Seminggu","2");
        aktif.put("3 Kali Seminggu","3");
        aktif.put("4 Kali Seminggu","4");
        aktif.put("5 Kali Seminggu","5");
        aktif.put("6 Kali Seminggu","6");
        aktif.put("7 Kali Seminggu","7");
        aktif.put("2 Kali Sehari dalam Seminggu/Lebih","8");
    }
    @OnClick(R.id.btnNext)
    protected void btnNext(View view){
        Intent next = new Intent(FormAktifitas.this,FormJenisKelamin.class);
        next.putExtra("berat",getIntent().getStringExtra("berat"));
        next.putExtra("tinggi",getIntent().getStringExtra("tinggi"));
        next.putExtra("umur",getIntent().getStringExtra("umur"));
        next.putExtra("aktifitas",aktif.get(spAktifitas.getSelectedItem().toString()));
        startActivity(next);
    }
}
