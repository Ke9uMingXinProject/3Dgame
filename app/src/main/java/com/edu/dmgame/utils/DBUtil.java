package com.edu.dmgame.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.edu.dmgame.dao.CategoryEntityDao;
import com.edu.dmgame.dao.DaoMaster;
import com.edu.dmgame.dao.DaoSession;
import com.edu.dmgame.entities.CategoryEntity;


/**
 * Created by Ming on 2016/1/21.
 * email 1715944993@qq.com
 */
public class DBUtil {

    private static DaoSession session;
    // 这边严格模式做不了，要做需要开启线程
    public static void initialize(Context context) {
        GameOpenHelper helper = new GameOpenHelper(context, "3Dgames.db", null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        session = daoMaster.newSession();
    }

    public static DaoSession getSession() {
        return session;
    }

    private static class GameOpenHelper extends DaoMaster.DevOpenHelper {

        public GameOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            CategoryEntityDao categoryEntityDao = new DaoMaster(db).newSession().getCategoryEntityDao();
            categoryEntityDao.insertOrReplace(new CategoryEntity(1L, "文章首页"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(2L, "游戏新闻"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(151L, "游戏杂谈"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(152L, "硬件信息"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(153L, "游戏前瞻"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(154L, "游戏评测"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(194L, "原创精品"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(197L, "游戏盘点"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(199L, "时事焦点"));
            categoryEntityDao.insertOrReplace(new CategoryEntity(25L, "攻略中心"));
        }
    }
}
