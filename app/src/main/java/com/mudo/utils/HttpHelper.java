package com.mudo.utils;

import android.content.Context;
import android.content.SyncStatusObserver;
import android.os.Handler;
import android.os.Message;

import com.mudo.constantUtils.ConstansElements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHelper {

    // Xutils暂时不稳定，直接用HttpUrlConnection实现


    private Context mContext;
    private Handler mHandler;

    public HttpHelper(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    public void sendGet(String params) {


        final String path = ConstansElements.BaseUrl() + "?" + params;

        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection conn = null;
                try {
                    URL url = new URL(path);

                    conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);

                    conn.connect();

                    if (conn.getResponseCode() == 200) {
                        // 返回码为200，连接正常

                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int len = 0;
                        byte buffer[] = new byte[1024];
                        while ((len = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        is.close();
                        baos.close();
                        String result = new String(baos.toByteArray());

                        Message msg = mHandler.obtainMessage();
                        msg.obj = result;
                        mHandler.sendMessage(msg);

                    } else {
                        LogHelper.logv(ConstansElements.TAG, "网络连接出错");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(conn != null){
                        conn.disconnect();
                    }
                }
            }
        }).start();


    }


    public void sendPost(String interfaceStr,final String paraStr) {
        final String path = ConstansElements.BaseUrl() + interfaceStr;

        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection conn = null;

                try {
                    URL url = new URL(path);
                    conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);

                    //只有设置contentType为application/x-www-form-urlencoded，servlet就可以直接使用request.getParameter("参数例如：name");直接得到所需要信息
                    conn.setRequestProperty("contentType", "application/x-www-form-urlencoded");

                    // 可以将所有的请求数据保存在jsonstr中，在servlet里面获取到该json字符串，然后对json字符串进行解析，进行相应的处理
                    String para = "json=" + paraStr;

                    conn.setRequestProperty("Content-Length", String.valueOf(para.getBytes().length));
                    conn.setDoOutput(true);
                    conn.getOutputStream().write(para.getBytes());
                    conn.connect();

                    if (conn.getResponseCode() == 200) {
                        // 连接正常
                        LogHelper.logv(ConstansElements.TAG, "成功");

                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int len = 0;
                        byte buffer[] = new byte[1024];
                        while ((len = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        is.close();
                        baos.close();
                        String result = new String(baos.toByteArray());

                        // 部分数据可以在该处统一处理，其他的使用handler传递到外部去处理
                        Message msg = mHandler.obtainMessage();
                        msg.obj = result;
                        mHandler.sendMessage(msg);

                    } else {
                        //连接失败
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //6.释放资源
                    if (conn != null) {
                        //关闭连接 即设置 http.keepAlive = false;
                        conn.disconnect();
                    }
                }


            }
        }).start();
    }

}