package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformasiAplikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_aplikasi);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnKembali)
    protected void btnKembali(View view){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}
