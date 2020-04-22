package com.example.xday01;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.xday01.Fragment.OneFragment;
import com.example.xday01.Fragment.TwoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvFinish;
    /**
     * 全部
     */
    private Button mBtnTitle1;
    /**
     * 视频
     */
    private Button mBtnTitle2;
    private FrameLayout mFl;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mIvFinish = (ImageView) findViewById(R.id.iv_finish);
        mBtnTitle1 = (Button) findViewById(R.id.btn_title1);
        mBtnTitle1.setOnClickListener(this);
        mBtnTitle2 = (Button) findViewById(R.id.btn_title2);
        mBtnTitle2.setOnClickListener(this);
        mFl = (FrameLayout) findViewById(R.id.fl);
        mIvFinish.setOnClickListener(this);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        transaction.add(R.id.fl,oneFragment);
        transaction.add(R.id.fl,twoFragment);
        transaction.show(oneFragment);
        transaction.hide(twoFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_title1:
                manager.beginTransaction().show(oneFragment).hide(twoFragment).commit();
                break;
            case R.id.btn_title2:
                manager.beginTransaction().show(twoFragment).hide(oneFragment).commit();
                break;
            case R.id.iv_finish:
                finish();
                break;
        }
    }
}
