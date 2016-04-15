package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {

    public static void main(String[] args) {

        Schema schema = new Schema(1,"com.edu.dmgame.entities");
        schema.setDefaultJavaPackageDao("com.edu.dmgame.dao");

        //文章详情实体
        Entity chapterContent = schema.addEntity("ChapterEntity");
        chapterContent.addIdProperty().columnName("id");
        chapterContent.addStringProperty("title");
        chapterContent.addStringProperty("pubdate");
        chapterContent.addStringProperty("senddate");
        chapterContent.addStringProperty("shorttitle");
        chapterContent.addStringProperty("typeid");
        chapterContent.addStringProperty("writer");
        chapterContent.addStringProperty("source");
        chapterContent.addStringProperty("litpic");
        chapterContent.addStringProperty("feedback");
        chapterContent.addStringProperty("click");
        chapterContent.addStringProperty("description");
        chapterContent.addStringProperty("typename");
        chapterContent.addStringProperty("arcurl");
        chapterContent.addStringProperty("body");

        //评论列表实体 ChapterCommentListItem
        Entity chapterCommentListItem = schema.addEntity("ChapterCommentEntity");
        chapterCommentListItem.addIdProperty().columnName("id");
        chapterCommentListItem.addStringProperty("aid");
        chapterCommentListItem.addStringProperty("typeid");
        chapterCommentListItem.addStringProperty("username");
        chapterCommentListItem.addStringProperty("ip");
        chapterCommentListItem.addStringProperty("ip1");
        chapterCommentListItem.addStringProperty("ip2");
        chapterCommentListItem.addStringProperty("ischeck");
        chapterCommentListItem.addStringProperty("dtime");
        chapterCommentListItem.addStringProperty("mid");
        chapterCommentListItem.addStringProperty("bad");
        chapterCommentListItem.addStringProperty("good");
        chapterCommentListItem.addStringProperty("ftype");
        chapterCommentListItem.addStringProperty("face");
        chapterCommentListItem.addStringProperty("msg");
        chapterCommentListItem.addStringProperty("cid");
        chapterCommentListItem.addStringProperty("reid");
        chapterCommentListItem.addStringProperty("topid");
        chapterCommentListItem.addStringProperty("floor");
        chapterCommentListItem.addStringProperty("reply");


        //游戏详情实体 GameContent
        Entity gameContent = schema.addEntity("GameContentEntity");
        gameContent.addIdProperty().columnName("id");
        gameContent.addStringProperty("title");
        gameContent.addStringProperty("pubdate");
        gameContent.addStringProperty("senddate");
        gameContent.addStringProperty("shorttitle");
        gameContent.addStringProperty("typeid");
        gameContent.addStringProperty("writer");
        gameContent.addStringProperty("source");
        gameContent.addStringProperty("litpic");
        gameContent.addStringProperty("feedback");
        gameContent.addStringProperty("click");
        gameContent.addStringProperty("description");
        gameContent.addStringProperty("typename");
        gameContent.addStringProperty("arcurl");
        gameContent.addStringProperty("body");

        gameContent.addStringProperty("game_trans_name");
        gameContent.addStringProperty("release_date");
        gameContent.addStringProperty("language");
        gameContent.addStringProperty("terrace");
        gameContent.addStringProperty("made_company");
        gameContent.addStringProperty("release_company");
        gameContent.addStringProperty("websit");
        gameContent.addStringProperty("gameplay");
        gameContent.addStringProperty("graphics");
        gameContent.addStringProperty("sound");
        gameContent.addStringProperty("concept");
        gameContent.addStringProperty("multiplayer");
        gameContent.addStringProperty("total");
        gameContent.addStringProperty("game_info");
        gameContent.addStringProperty("system");
        gameContent.addStringProperty("system1");
        gameContent.addStringProperty("game_bbs");
        gameContent.addStringProperty("game_othername1");
        gameContent.addStringProperty("game_othername2");


        //种类 ChapterEntity
        Entity chapterEntity = schema.addEntity("CategoryEntity");
        chapterEntity.addIdProperty().columnName("id");
        chapterEntity.addStringProperty("category");

        // 创建
        try {
            new DaoGenerator().generateAll(schema, "lib/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
