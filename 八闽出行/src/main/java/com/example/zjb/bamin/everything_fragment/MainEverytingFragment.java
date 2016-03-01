package com.example.zjb.bamin.everything_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.example.administrator.shane_library.shane.utils.GsonUtils;
import com.example.administrator.shane_library.shane.utils.HTTPUtils;
import com.example.administrator.shane_library.shane.utils.VolleyListener;
import com.example.zjb.bamin.DaCheActivity.MainDacheActivity;
import com.example.zjb.bamin.MainActivity;
import com.example.zjb.bamin.R;
import com.example.zjb.bamin.constant.Constant;
import com.example.zjb.bamin.customView.ViewPagerIndicator;
import com.example.zjb.bamin.fragment.BannerFragment;
import com.example.zjb.bamin.models.about_banner.BannerInfo;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainEverytingFragment extends Fragment implements View.OnClickListener
{

    private View mLayout;
    private LinearLayout mLl_onlinebus;
    private LinearLayout mLl_ticket;
    private LinearLayout mLl_taxi;
    private List<BannerInfo> bannerData = new ArrayList<BannerInfo>();
    private int[] mImageID = new int[]{R.mipmap.banner01, R.mipmap.banner02, R.mipmap.banner03};
    private int mPagerCount = Integer.MAX_VALUE / 3;
    private ViewPager mViewPager_banner;
    private ViewPagerIndicator mViewPagerIndicator;
    private boolean isFrist = true;
    private boolean mDragging;

    public MainEverytingFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mLayout = inflater.inflate(R.layout.fragment_main, null);

        findID();
        initUI();
        setListener();
        initData();



        return mLayout;
    }

    private void initData()
    {
        //初始化Banner数据
        initBannerData();
    }
    private void initBannerData()
    {
        HTTPUtils.get(getActivity(), Constant.URLFromAiTon.GET_BANNER_IMG, new VolleyListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {

            }

            @Override
            public void onResponse(String s)
            {
                Type type = new TypeToken<ArrayList<BannerInfo>>()
                {
                }.getType();
                bannerData = GsonUtils.parseJSONArray(s, type);
            }
        });
    }

    private void findID()
    {
        mLl_onlinebus = (LinearLayout) mLayout.findViewById(R.id.ll_onlinebus);
        mLl_ticket = (LinearLayout) mLayout.findViewById(R.id.ll_ticket);
        mLl_taxi = (LinearLayout) mLayout.findViewById(R.id.ll_taxi);
    }

    private void initUI()
    {
        initBanner();
    }

    /**
     * 设置广告条
     */
    private void initBanner()
    {
        mViewPager_banner = (ViewPager) mLayout.findViewById(R.id.vp_headerview_pager);
        mViewPager_banner.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        mViewPager_banner.addOnPageChangeListener(new BannerOnPageChangeListener());
        mViewPagerIndicator = (ViewPagerIndicator) mLayout.findViewById(R.id.ViewPagerIndicator);
        if (isFrist)
        {
            autoScroll();
        }
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
        Intent intent= new Intent();
        switch (v.getId())
        {
            case R.id.ll_onlinebus:

                break;
            case R.id.ll_ticket:
                intent.setClass(getActivity(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_taxi:
                intent.setClass(getActivity(),MainDacheActivity.class);
                startActivity(intent);
                break;

        }
    }


    class MyPagerAdapter extends FragmentPagerAdapter
    {

        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            if(bannerData.size()==0)
            {
                int pager_index = position % mImageID.length;
                return new BannerFragment(pager_index, mImageID[pager_index]);
            }else
            {
                int pager_index = position % bannerData.size();
                return new BannerFragment(pager_index, bannerData.get(pager_index).getUrl(),bannerData.get(pager_index).getUrl2());
            }
        }

        @Override
        public int getCount()
        {
            return mPagerCount;
        }
    }

    class BannerOnPageChangeListener implements ViewPager.OnPageChangeListener
    {
        public void onPageScrollStateChanged(int state)
        {
            switch (state)
            {
                case ViewPager.SCROLL_STATE_IDLE:
                    mDragging = false;
                    break;
                case ViewPager.SCROLL_STATE_DRAGGING:
                    mDragging = true;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    mDragging = false;
                    break;
                default:
                    break;
            }
        }

        public void onPageScrolled(int position, float arg1, int arg2)
        {
            position = position % 3;
            mViewPagerIndicator.move(arg1, position);
        }

        public void onPageSelected(int arg0)
        {
        }
    }

    private void autoScroll()
    {
        mViewPager_banner.setCurrentItem(mPagerCount / 2);
        mViewPager_banner.postDelayed(new Runnable()
        {
            public void run()
            {
                int position = mViewPager_banner.getCurrentItem() + 1;
                if (!mDragging)
                {
                    isFrist = false;
                    mViewPager_banner.setCurrentItem(position);
                }
                mViewPager_banner.postDelayed(this, 3000);
            }
        }, 3000);
    }
}
