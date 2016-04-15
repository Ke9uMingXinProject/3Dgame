package com.edu.dmgame.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.dmgame.entities.CategoryEntity;
import com.edu.dmgame.entities.ChapterEntity;
import com.edu.dmgame.fragments.ChapterItemsFragment;

import java.util.List;

/**
 * Created by Ming on 2016/2/15.
 * email 1715944993@qq.com
 */
public class CommonPagerAdapter extends FragmentPagerAdapter {

    private List<CategoryEntity> mChapterEntities;

    public CommonPagerAdapter(FragmentManager fm, List<CategoryEntity> chapterEntities) {
        super(fm);
        mChapterEntities = chapterEntities;
    }

    @Override
    public Fragment getItem(int position) {
        return ChapterItemsFragment.newInstance(String.valueOf(mChapterEntities.get(position).getId()));
    }

    @Override
    public int getCount() {
        return mChapterEntities.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChapterEntities.get(position).getCategory();
    }
}
