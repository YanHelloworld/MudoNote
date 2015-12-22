package com.mudo.constantUtils;

/**
 * Created by Mudo on 2015/12/18.
 */
public class ConstansElements {

    public static final String TAG = "mudonote:";

    public static final String debugUrl = "http://192.168.1.63:8080/MudoHttpHelperWeb/servlet/MudoHttpHelperWebServlet?name=tom";

    public static final String Url = "http://192.168.1.63:8080/MudoHttpHelperWeb/servlet/MudoHttpHelperWebServlet?name=tom";

    private  static boolean flag_isproduct = false;// true为正式环境,false为测试环境

    public static String BaseUrl(){
        if(flag_isproduct){
            return Url;
        }else{
            return debugUrl;
        }
    }
}
