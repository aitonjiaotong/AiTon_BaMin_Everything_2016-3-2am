package com.example.zjb.bamin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zjb.bamin.fragment.Fragment01;
import com.example.zjb.bamin.fragment.Fragment02;
import com.example.zjb.bamin.fragment.MineFragment;

public class EverytingActivity extends AppCompatActivity {
    private String[] tabsItem = new String[]{
            "查询",
            "订单",
            "我的",
    };
    private Class[] fragment = new Class[]{
            Fragment01.class,
            Fragment02.class,
            MineFragment.class,
    };
    private int[] imgRes = new int[]{
            R.drawable.ic_home_search_selector,
            R.drawable.ic_home_order_selector,
            R.drawable.ic_home_me_selector
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyting);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_everyting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
