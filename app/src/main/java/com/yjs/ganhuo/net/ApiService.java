package com.yjs.ganhuo.net;

import android.os.Environment;

import com.yjs.ganhuo.GanHuoApplication;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangjingsong on 16/6/15.
 */
public class ApiService {
    private static final String path = Environment.getExternalStorageDirectory().getPath()+"/Ganhuo/cache";

    public  static <T> T getApi(String baseurl,Class<T> api){
//        OkHttpClient client = new OkHttpClient();
//        File cacheFile = new File(getCacheDir(),"cache");
//        Cache cache = new Cache(cacheFile,)
        Retrofit retrofit = new Retrofit.Builder()
                //.client(getCacheDir())
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(api);
    }

    public static File getCacheDir(){
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        return dir;
    }

}
