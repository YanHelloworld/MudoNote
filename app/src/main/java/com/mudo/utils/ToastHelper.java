package com.mudo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Mudo on 2015/12/18.
 */
public class ToastHelper {

    public static void show(Context context,String str){

        Toast.makeText(context,str,Toast.LENGTH_LONG).show();

    }
}
