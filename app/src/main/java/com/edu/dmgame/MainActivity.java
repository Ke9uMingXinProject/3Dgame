package com.edu.dmgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.edu.dmgame.fragments.ChapterFragment;
import com.edu.dmgame.fragments.ForumFragment;
import com.edu.dmgame.fragments.GameFragment;
import com.edu.dmgame.fragments.SelfFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView mToolbarTitle;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mFragments = new ArrayList<>();
        ChapterFragment chapterFragment = new ChapterFragment();
        mFragments.add(chapterFragment);
        ForumFragment forumFragment = new ForumFragment();
        mFragments.add(forumFragment);
        GameFragment gameFragment = new GameFragment();
        mFragments.add(gameFragment);
        SelfFragment selfFragment = new SelfFragment();
        mFragments.add(selfFragment);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,chapterFragment);
        transaction.commit();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tab_bar_menu);
        radioGroup.check(R.id.tab_bar_menu_chapter);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        int index = 0;
        switch (checkedId) {
            case R.id.tab_bar_menu_chapter:
                index = 0;
                mToolbarTitle.setText("文章");
                break;

            case R.id.tab_bar_menu_forum:
                index = 1;
                mToolbarTitle.setText("论坛");
                break;

            case R.id.tab_bar_menu_game:
                index = 2;
                mToolbarTitle.setText("游戏");
                break;

            case R.id.tab_bar_menu_self:
                index = 3;
                mToolbarTitle.setText("我的");
                break;
        }
        transaction.replace(R.id.container,mFragments.get(index));
        transaction.commit();
    }
}
