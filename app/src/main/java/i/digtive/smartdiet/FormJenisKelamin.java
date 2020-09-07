package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormJenisKelamin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_jenis_kelamin);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnLakiLakir)
    protected void btnLakiLakir(View view){
        Intent i = new Intent(getApplicationContext(),HasilAkhir.class);
        i.putExtra("jk","laki");
        i.putExtra("berat",getIntent().getStringExtra("berat"));
        i.putExtra("tinggi",getIntent().getStringExtra("tinggi"));
        i.putExtra("umur",getIntent().getStringExtra("umur"));
        i.putExtra("aktifitas",getIntent().getStringExtra("aktifitas"));
        startActivity(i);
    }
    @OnClick(R.id.btnPerempuan)
    protected void btnPerempuan(View view){
        Intent i = new Intent(getApplicationContext(),HasilAkhir.class);
        i.putExtra("jk","perempuan");
        i.putExtra("berat",getIntent().getStringExtra("berat"));
        i.putExtra("tinggi",getIntent().getStringExtra("tinggi"));
        i.putExtra("umur",getIntent().getStringExtra("umur"));
        i.putExtra("aktifitas",getIntent().getStringExtra("aktifitas"));
        startActivity(i);
    }
}
