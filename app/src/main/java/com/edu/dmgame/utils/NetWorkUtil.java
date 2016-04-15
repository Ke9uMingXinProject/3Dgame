package com.edu.dmgame.utils;

import com.edu.dmgame.entities.ChapterCommentEntity;
import com.edu.dmgame.entities.ChapterEntity;
import com.edu.dmgame.entities.ChapterResult;
import com.edu.dmgame.entities.GameContentEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ming on 2016/1/24.
 * email 1715944993@qq.com
 */
public class NetWorkUtil {

    public interface Service {

        // 获取文章列表
        @GET("sitemap/api.php?paging=1")
        Call<ChapterResult> getChapterList(@Query("row") String row,
                                             @Query("typeid") String typeid,
                                             @Query("page") String page);

        // 文章详情
        @GET("sitemap/api.php")
        Call<ChapterEntity> getChapterContent(@Query("id") String id,
                                               @Query("typeid") String typeid);

        // 评论列表
        @GET("sitemap/api.php")
        Call<ChapterCommentEntity> getChapterCommentList(@Query("type") String type,
                                                           @Query("aid") String aid,
                                                           @Query("pageno") String pageno);

        // http://www.3dmgame.com/sitemap/api.php?type=2  post 提交
        @POST("sitemap/api.php?type=2")
        Call<ChapterCommentEntity> commentComment(@Field("aid") String aid,
                                                    @Field("msg") String msg,
                                                    @Field("username") String username);

        // 游戏列表
        @GET("sitemap/api.php")
        Call<GameContentEntity> getGameContent(@Query("row") String row,
                                         @Query("typeid") String typeid,
                                         @Query("paging") String paging,
                                         @Query("page") String page);
    }

    private static Service service;

    // 静态代码块，初始化 service 并且 转化 Date 的格式
    static {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new TypeAdapter<Date>() {
            @Override
            public void write(JsonWriter out, Date value) throws IOException {
                out.value(value.getTime());
            }

            @Override
            public Date read(JsonReader in) throws IOException {
                long l = in.nextLong();
                return new Date(l);
            }
        }).create();

        service = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://www.3dmgame.com").build().create(Service.class);
    }

    public static Service getService() {
        return service;
    }
}
