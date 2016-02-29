package com.example.zjb.bamin.fragment;


import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.shane_library.shane.utils.HTTPUtils;
import com.example.administrator.shane_library.shane.utils.UILUtils;
import com.example.administrator.shane_library.shane.utils.VolleyListener;
import com.example.zjb.bamin.R;
import com.example.zjb.bamin.customView.redpacket.FlakeView;

public class BannerFragment extends Fragment {


    //红包相关-----start
    private FlakeView flakeView;
    private PopupWindow pop;
    //红包相关-----end
    private View mLayout;
    private int mPosition;
    private String mImageUrl;
    private int mImageId;
    private ImageView mBanner_image;

    public BannerFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public BannerFragment(int pager_index, String imageUrl)
    {
        this.mPosition = pager_index;
        this.mImageUrl = imageUrl;
    }

    @SuppressLint("ValidFragment")
    public BannerFragment(int pager_index, int imageId)
    {
        this.mPosition = pager_index;
        this.mImageId = imageId;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mLayout = inflater.inflate(R.layout.fragment_banner, container, false);

        //红包相关
        flakeView = new FlakeView(getActivity());

        initUI();
        return mLayout;
    }

    private void initUI()
    {
        mBanner_image = (ImageView) mLayout.findViewById(R.id.iv_banner_image);
        if("".equals(mImageUrl))
        {
            mBanner_image.setImageResource(mImageId);
        }else
        {
            UILUtils.displayImageNoAnim(mImageUrl,mBanner_image);
        }
        mBanner_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mPosition == 0)
                {
                    //弹出抢红包对话框
                    HTTPUtils.get(getActivity(), "Constant.URLFromAiTon.RED_PACKET?account_id=string", new VolleyListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError volleyError)
                        {

                        }

                        @Override
                        public void onResponse(String s)
                        {

                        }
                    });
                    showPopWindows(v, "￥2", false);
                }
            }
        });
    }

    private PopupWindow showPopWindows(View v, String moneyStr, boolean show) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_red_packet, null);
        TextView tv_rule = (TextView) view.findViewById(R.id.tv_rule);
        tv_rule.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        TextView money = (TextView) view.findViewById(R.id.tv_money);
        money.setText(moneyStr);
        final LinearLayout container = (LinearLayout) view.findViewById(R.id.container);
        //将flakeView 添加到布局中
        container.addView(flakeView);
        //设置背景
//        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        //设置同时出现在屏幕上的金币数量  建议64以内 过多会引起卡顿
        flakeView.addFlakes(32);
        /**
         * 绘制的类型
         * @see View.LAYER_TYPE_HARDWARE
         * @see View.LAYER_TYPE_SOFTWARE
         * @see View.LAYER_TYPE_NONE
         */
        flakeView.setLayerType(View.LAYER_TYPE_NONE, null);
        view.findViewById(R.id.btn_ikow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (container!=null){
                    container.removeAllViews();
                }
                pop.dismiss();
            }
        });
        pop = new PopupWindow(view, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.half_color));
        pop.setBackgroundDrawable(dw);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        pop.showAtLocation(v, Gravity.CENTER, 0, 0);

        /**
         * 移除动画
         */
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //设置2秒后
                    Thread.sleep(1500);
                    getActivity().runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            container.removeAllViews();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        if (!show)
            thread.start();
        MediaPlayer player = MediaPlayer.create(getActivity(), R.raw.shake);
        player.start();
        return pop;
    }
}
