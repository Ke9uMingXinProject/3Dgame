package com.edu.dmgame.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.dmgame.R;
import com.edu.dmgame.adapters.CommonPagerAdapter;
import com.edu.dmgame.entities.CategoryEntity;
import com.edu.dmgame.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class ChapterFragment extends Fragment {


    private List<CategoryEntity> mChapterEntities;

    public ChapterFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initViews(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void initViews(View view) {
        TabLayout chapterLayout = (TabLayout) view.findViewById(R.id.chapter_tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.chapter_viewpager);
        mChapterEntities = new ArrayList<>();
        mChapterEntities = DBUtil.getSession().getCategoryEntityDao().loadAll();
        CommonPagerAdapter adapter = new CommonPagerAdapter(getChildFragmentManager(),mChapterEntities);
        viewPager.setAdapter(adapter);
        chapterLayout.setupWithViewPager(viewPager);
    }

}
