package com.example.zjb.bamin.bamindache;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class JiGouYongChe02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_gou_yong_che02);
    }

    public void jigouyongche02(View view) {
        Intent intent= new Intent();
        intent.setClass(JiGouYongChe02Activity.this,JiGouYongChe03Activity.class);
        startActivity(intent);
    }
}
