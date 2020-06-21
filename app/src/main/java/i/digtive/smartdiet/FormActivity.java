package i.digtive.smartdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormActivity extends AppCompatActivity {
    @BindView(R.id.etUmur)
    EditText etUmur;
    @BindView(R.id.etBerat)
    EditText etBerat;
    @BindView(R.id.etTinggi)
    EditText etTinggi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnNext)
    protected void btnNext(View view){
        Intent gotonext = new Intent(FormActivity.this,FormAktifitas.class);
        gotonext.putExtra("berat",etBerat.getText().toString());
        gotonext.putExtra("tinggi",etTinggi.getText().toString());
        gotonext.putExtra("umur",etUmur.getText().toString());
        startActivity(gotonext);
    }
}
