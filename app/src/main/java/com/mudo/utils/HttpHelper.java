package com.mudo.utils;


/**
 * Created by Mudo on 2015/12/18.
 */
public class HttpHelper {



/*
    HttpUtils utils = new HttpUtils();


    private Handler mHandler;
    private Context mContext;

    public HttpHelper(Context context,Handler handler){

        this.mHandler = handler;
        this.mContext = context;

    }
    public void sendGet(String interfaceStr){
        utils.send(HttpRequest.HttpMethod.GET, ConstansElements.BaseUrl()+interfaceStr, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Message msg = mHandler.obtainMessage();
                msg.obj = responseInfo.toString();
                mHandler.sendMessage(msg);

            }

            @Override
            public void onFailure(HttpException e, String s) {

                Message msg = mHandler.obtainMessage();
                msg.obj = "访问网络失败，请检查网络后重试";
                mHandler.sendMessage(msg);

            }
        });
    }

    public void sendPost(String interfaceStr){
        utils.send(HttpRequest.HttpMethod.POST, ConstansElements.BaseUrl()+interfaceStr, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {



            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }*/
}
