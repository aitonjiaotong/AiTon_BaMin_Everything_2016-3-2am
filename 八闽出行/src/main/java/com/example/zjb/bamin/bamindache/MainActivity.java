package com.example.zjb.bamin.bamindache;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zjb.bamin.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mJiemian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dache);
        mJiemian = (LinearLayout) findViewById(R.id.jiemian);
    }

    public void shouye(View view) {
        mJiemian.setBackgroundResource(R.mipmap.yongche01);
    }

    public void dache(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,DaCheActivity.class);
        startActivity(intent);
    }
    public void tejiayouhui(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,TeJiaTaoCanActivity.class);
        startActivity(intent);
    }
    public void daijia(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,DaiJiaActivity.class);
        startActivity(intent);
    }
    public void jigouyongche(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,JiGouYongCheActivity.class);
        startActivity(intent);
    }
    public void mendian(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,MenDianActivity.class);
        startActivity(intent);
    }
    public void zijiazhuche(View view) {
        Intent intent= new Intent();
        intent.setClass(MainActivity.this,ZiJiaZuCheActivity.class);
        startActivity(intent);
    }
    public void dingdan(View view) {
        Toast.makeText(MainActivity.this, "功能暂时未做", Toast.LENGTH_SHORT).show();
    }
    public void gerenzhongxin(View view) {
        Toast.makeText(MainActivity.this, "功能暂时未做", Toast.LENGTH_SHORT).show();
    }
}
