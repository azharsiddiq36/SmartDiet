package i.digtive.smartdiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;

public class TingkatAktifitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tingkat_aktifitas);
        ButterKnife.bind(this);
    }
}
