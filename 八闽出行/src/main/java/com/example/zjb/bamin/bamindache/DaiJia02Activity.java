package com.example.zjb.bamin.bamindache;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DaiJia02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dai_jia02);
    }
    public void queren(View view) {
        Intent intent= new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(DaiJia02Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
