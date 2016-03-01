package com.example.zjb.bamin.everything_fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zjb.bamin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainEverytingFragment extends Fragment implements View.OnClickListener
{

    private View layout;
    private LinearLayout mLl_onlinebus;
    private LinearLayout mLl_ticket;
    private LinearLayout mLl_taxi;

    public MainEverytingFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        layout = inflater.inflate(R.layout.fragment_main, null);

        findID();
        initUI();
        setListener();




        return layout;
    }

    private void findID()
    {
        mLl_onlinebus = (LinearLayout) layout.findViewById(R.id.ll_onlinebus);
        mLl_ticket = (LinearLayout) layout.findViewById(R.id.ll_ticket);
        mLl_taxi = (LinearLayout) layout.findViewById(R.id.ll_taxi);
    }

    private void initUI()
    {
    }

    private void setListener()
    {
        mLl_onlinebus.setOnClickListener(this);
        mLl_ticket.setOnClickListener(this);
        mLl_taxi.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.ll_onlinebus:

                break;
            case R.id.ll_ticket:

                break;
            case R.id.ll_taxi:

                break;

        }
    }
}
