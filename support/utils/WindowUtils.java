package main.support.utils;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by jlaotsezu on 16/12/2017.
 */

public class WindowUtils {
    private WeakReference<Context> context;
    private WindowUtils(Context context){
        this.context = new WeakReference<>(context.getApplicationContext());
    }
    private static WindowUtils instance;

    public static WindowUtils getInstance(Context context) {
        if(instance == null){
            instance = new WindowUtils(context);
        }
        return instance;
    }

    public int getWidth(){
        return context.get().getResources().getDisplayMetrics().widthPixels;
    }
    public int getHeight(){
        return context.get().getResources().getDisplayMetrics().heightPixels;
    }
}
