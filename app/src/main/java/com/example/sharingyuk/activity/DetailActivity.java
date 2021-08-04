package com.example.sharingyuk.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sharingyuk.R;

public class DetailActivity extends AppCompatActivity {
//    public static final String EXTRA_NAME = "extra_name";
//    public static final String EXTRA_ALAMAT = "extra_alamat";
//    public static final String EXTRA_BIDANG = "extra_bidang";
//    public static final String EXTRA_PHOTO = "extra_photo";
    TextView textView1, textView2, textView3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.img_viewdetail);
        textView1 = findViewById(R.id.tv_namalengkap2);
        textView2 = findViewById(R.id.tv_alamat2);
        textView3 =findViewById(R.id.tv_bidang2);
//        imageView = findViewById(R.id.img_viewdetail);
//
//        String nama = getIntent().getStringExtra(EXTRA_NAME);
//        String alamat = getIntent().getStringExtra(EXTRA_ALAMAT);
//        String bidang = getIntent().getStringExtra(EXTRA_BIDANG);
//        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
//
//        String text = ""+nama;
//        String alamat2 = ""+alamat;
//        String bidang2 = " "+bidang;
////        String photo2 = String.valueOf(photo);
//
//        textView1.setText(text);
//        textView2.setText(alamat2);
//        textView3.setText(bidang2);
//        imageView.setImageResource(Integer.parseInt(photo2));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        if (getIntent().hasExtra("gambar") && getIntent().hasExtra("nama")&& getIntent().hasExtra("alamat")&& getIntent().hasExtra("bidang")){

            String photolengkap = getIntent().getStringExtra("gambar");
            String namalengkap = getIntent().getStringExtra("nama");
            String alamatlengkap = getIntent().getStringExtra("alamat");
            String bidanglengkap = getIntent().getStringExtra("bidang");

            int ini_gambar = bundle.getInt("gambar");
          imageView.setImageResource(ini_gambar);
           textView1.setText(namalengkap);
            textView2.setText(alamatlengkap);
            textView3.setText(bidanglengkap);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}