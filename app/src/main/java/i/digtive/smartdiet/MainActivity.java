package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnMulai)
    protected void btnMulai(View view){
        Intent gotomulai = new Intent(MainActivity.this,FormActivity.class);
        startActivity(gotomulai);
    }
    @OnClick(R.id.carapenggunaan)
    protected void carapenggunaan(View view){
        Intent gotocara = new Intent(MainActivity.this,CaraPenggunaan.class);
        startActivity(gotocara);
    }
    @OnClick(R.id.informasi)
    protected void informasi(View view){
        Intent gotoinformasi = new Intent(MainActivity.this,SaranActivity.class);
        startActivity(gotoinformasi);
    }
    @OnClick(R.id.tentang)
    protected void tentang (View view){
        Intent gototentang = new Intent(MainActivity.this,InformasiAplikasi.class);
        startActivity(gototentang);
    }
    @OnClick(R.id.keluar)
    protected void keluar(View view){

        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
        finish();
    }
}
