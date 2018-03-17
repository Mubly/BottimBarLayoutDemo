package com.mayi.bottimbarlayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomBarLayout bottomBarLayout;
    private ViewPager mVpContent;
    private List<BlankFragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBarLayout = findViewById(R.id.bbl);
        mVpContent = (ViewPager) findViewById(R.id.vp_content);
        bottomBarLayout.setMsg(2, "new");
        bottomBarLayout.setUnread(0, 101);
        bottomBarLayout.showNotify(1);
        initData();
        initListener();
    }

    private void initListener() {
        mVpContent.setAdapter(new MyAdapter(getSupportFragmentManager()));
        bottomBarLayout.setViewPager(mVpContent);
//        bottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(BottomBarItem bottomBarItem, int i, int i1) {
////                mVpContent.setCurrentItem(i1);
//                Toast.makeText(MainActivity.this,i+"____"+i1,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void initData() {
        BlankFragment homeFragment = new BlankFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(BlankFragment.CONTENT, "首页");
        homeFragment.setArguments(bundle1);
        mFragmentList.add(homeFragment);

        BlankFragment videoFragment = new BlankFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(BlankFragment.CONTENT, "视频");
        videoFragment.setArguments(bundle2);
        mFragmentList.add(videoFragment);

        BlankFragment microFragment = new BlankFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString(BlankFragment.CONTENT, "微头条");
        microFragment.setArguments(bundle3);
        mFragmentList.add(microFragment);

//        BlankFragment meFragment = new BlankFragment();
//        Bundle bundle4 = new Bundle();
//        bundle4.putString(BlankFragment.CONTENT,"我的");
//        meFragment.setArguments(bundle4);
//        mFragmentList.add(meFragment);
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
