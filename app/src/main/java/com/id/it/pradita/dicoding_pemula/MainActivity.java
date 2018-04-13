package com.id.it.pradita.dicoding_pemula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //ToDo 2 ButterKnife intuk ngenalin widget panjang
    @BindView(R.id.edt_height)//layout
    EditText etHeight;

    //ToDo 3 ButterKnife intuk ngenalin widget Tinggi
    @BindView(R.id.edt_length)
    EditText etLength;

    //ToDo 4 ButterKnife intuk ngenalin widget lebar
    @BindView(R.id.edt_width)
    EditText etWidth;

    //ToDo 5 ButterKnife intuk ngenalin widget button hasil
    @BindView(R.id.btn_calculate)
    Button btnHasil;

    //ToDo 6 ButterKnife intuk ngenalin widget textview hasil
    @BindView(R.id.tv_result)
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(v.getId() == R.id.btn_calculate){
                   String length = etLength.getText().toString().trim();
                   String width = etWidth.getText().toString().trim();
                   String height = etHeight.getText().toString().trim();

                   //jika edit text view tidak boleh kosong ada komment
                   boolean isEmptyFields = false;
                   if (TextUtils.isEmpty(length)){
                       isEmptyFields = true;
                       etLength.setError("tidak boleh kosong");
                   }

                   if (TextUtils.isEmpty(width)){
                       isEmptyFields = true;
                       etWidth.setError("tidak boleh kosong");
                   }

                   if (TextUtils.isEmpty(height)){
                       isEmptyFields = true;
                       etHeight.setError("tidak boleh kosong");
                   }
                   //jika edit terisi
                   if (!isEmptyFields){
                       double l = Double.parseDouble(length);
                       double w = Double.parseDouble(width);
                       double h = Double.parseDouble(height);
                       double volume = l * w * h;
                       tvHasil.setText(String.valueOf(volume));
                   }

               }
            }
        });
        //agar hasil tidak hilang jika
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvHasil.setText(hasil);
        }



    }
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, tvHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
