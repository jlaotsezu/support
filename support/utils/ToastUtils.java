package main.support.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jlaotsezu on 16/12/2017.
 */

public class ToastUtils {
    private Context context;
    private static ToastUtils instance;
    private Toast toast;
    private ToastUtils(Context context){
        this.context = context.getApplicationContext();
    }
    public static ToastUtils getInstance(Context context){
        if(instance == null){
            instance = new ToastUtils(context);
        }
        return instance;
    }
    public void showMessage(String message){
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
