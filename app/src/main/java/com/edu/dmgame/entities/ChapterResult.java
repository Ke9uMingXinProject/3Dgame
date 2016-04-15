package com.edu.dmgame.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jash
 * Date: 15-11-20
 * Time: 下午1:44
 */
public class ChapterResult {

    private HashMap<String, ChapterEntity> chapterMap;
    public List<ChapterEntity> getChapterList(){
        return new ArrayList<>(chapterMap.values());
    }
}
