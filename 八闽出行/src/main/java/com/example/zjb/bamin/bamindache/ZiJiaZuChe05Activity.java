package com.example.zjb.bamin.bamindache;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ZiJiaZuChe05Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_jia_zu_che05);
    }
    public void zijiazuche05(View view) {
        Intent intent= new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(ZiJiaZuChe05Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
