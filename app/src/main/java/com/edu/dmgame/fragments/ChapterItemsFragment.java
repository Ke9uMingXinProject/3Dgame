package com.edu.dmgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.dmgame.R;
import com.edu.dmgame.entities.ChapterResult;
import com.edu.dmgame.utils.NetWorkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterItemsFragment extends Fragment implements Callback<ChapterResult> {

    private static final String ARG_PARAM = "typeid";


    public ChapterItemsFragment() {
        // Required empty public constructor
    }

    public static ChapterItemsFragment newInstance(String typeId) {
        ChapterItemsFragment fragment = new ChapterItemsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, typeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chapter_items, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String text = bundle.getString(ARG_PARAM, "默认");
       /* Call<ChapterResult> call = NetWorkUtil.getService().getChapterList("1", "ss", "1");
        call.enqueue(this);*/

    }

    @Override
    public void onResponse(Response<ChapterResult> response) {

    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"网络连接错误",Toast.LENGTH_SHORT).show();
    }
}
