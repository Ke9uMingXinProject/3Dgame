package com.edu.dmgame.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.dmgame.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Ming on 2016/2/16.
 * email 1715944993@qq.com
 */
public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>{

    private Context mContext;

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ChapterViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView mSimpleDraweeView;
        private TextView mChapterTitle;
        private TextView mChapterTime;
        private TextView mChapterComment;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.chapter_image);
            mChapterTitle = (TextView) itemView.findViewById(R.id.chapter_title);
            mChapterTime = (TextView) itemView.findViewById(R.id.chapter_time);
            mChapterComment = (TextView) itemView.findViewById(R.id.chapter_comment);
        }
    }
}
