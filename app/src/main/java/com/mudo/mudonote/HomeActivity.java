package com.mudo.mudonote;

import com.mudo.bean.RequestTest;
import com.mudo.fragment.NetNoteFragment;
import com.mudo.fragment.NoteFragment;
import com.mudo.fragment.SettingFragment;
import com.mudo.utils.HttpHelper;
import com.mudo.utils.JsonParseHelper;
import com.mudo.utils.ToastHelper;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.xutils.http.RequestParams;


public class HomeActivity extends Activity {

    private RadioGroup rg_choose;
    private FrameLayout fl_content;
    private NoteFragment noteFragment;
    private NetNoteFragment netNoteFragment;
    private SettingFragment settingFragment;
    private Fragment mFragment;
    private RelativeLayout rl_note;
    private RelativeLayout rl_netnote;
    private FrameLayout fl_title;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            String result = msg.obj.toString();

            // 直接将json字符串解析出来放入接收的bean中
            RequestTest resultpara = JsonParseHelper.json2bean(result, RequestTest.class);

            ToastHelper.show(HomeActivity.this,resultpara.toString());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initTitle();

        initLayout();

        initListener();

        netApply();

    }

    public void netApply() {


        // TODO 请求bean文件，转换成json数据

        RequestTest params = new RequestTest();
        params.setId(1);
        params.setName("Martin");
        params.setPassword("123");

        String jsonstr = JsonParseHelper.bean2json(params);

        HttpHelper helper = new HttpHelper(HomeActivity.this, handler);
        helper.sendPost("", jsonstr); //第一个参数填写接口名，第二个参数填写请求json字符串

    }

    public void initLayout() {
        rg_choose = (RadioGroup) findViewById(R.id.rg_home_changefragment);

        fl_content = (FrameLayout) findViewById(R.id.fl_home_content);

        fl_title = (FrameLayout) findViewById(R.id.fl_home_title);
        rl_note = (RelativeLayout) findViewById(R.id.rl_titlelayout_note);
        rl_netnote = (RelativeLayout) findViewById(R.id.rl_titlelayout_netnote);

        FragmentManager fragmentManager = getFragmentManager();

        noteFragment = new NoteFragment();

        mFragment = noteFragment;

        fragmentManager.beginTransaction().add(R.id.fl_home_content, noteFragment, "fnote").commit();

    }

    public void initListener() {

        rg_choose.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rb_home_note:
                        // TODO 日记界面

                        Toast.makeText(HomeActivity.this, "切换到日记界面", Toast.LENGTH_LONG).show();
                        if (noteFragment == null) {
                            noteFragment = new NoteFragment();
                        }

                        getFragmentManager().beginTransaction().remove(mFragment)
                                .add(R.id.fl_home_content, noteFragment, "fnote").commit();
                        mFragment = noteFragment;
                        break;

                    case R.id.rb_home_netnote:
                        // TODO 过客界面
                        Toast.makeText(HomeActivity.this, "切换到过客界面", Toast.LENGTH_LONG).show();
                        if (netNoteFragment == null) {
                            netNoteFragment = new NetNoteFragment();
                        }

                        getFragmentManager().beginTransaction().remove(mFragment)
                                .add(R.id.fl_home_content, netNoteFragment, "fnetnote").commit();
                        mFragment = netNoteFragment;
                        break;
                    case R.id.rb_home_setting:
                        // TODO 我的界面
                        Toast.makeText(HomeActivity.this, "切换到我的界面", Toast.LENGTH_LONG).show();
                        if (settingFragment == null) {
                            settingFragment = new SettingFragment();
                        }

                        getFragmentManager().beginTransaction().remove(mFragment)
                                .add(R.id.fl_home_content, settingFragment, "fsetting").commit();
                        mFragment = settingFragment;
                        break;
                    default:
                        break;
                }

                changeTitle(checkedId);
            }
        });

    }

    public void changeTitle(int CheckId) {
        switch (CheckId) {
            case R.id.rb_home_note:
                // TODO 日记界面title
                rl_note.setVisibility(View.VISIBLE);
                rl_netnote.setVisibility(View.GONE);
                fl_title.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_home_netnote:
                // TODO 过客界面title
                rl_note.setVisibility(View.GONE);
                rl_netnote.setVisibility(View.VISIBLE);
                fl_title.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_home_setting:
                // TODO 我的界面title
                rl_note.setVisibility(View.GONE);
                rl_netnote.setVisibility(View.GONE);
                fl_title.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    public void initTitle() {
        Button iv_titlebar_calender = (Button) findViewById(R.id.iv_titlebar_calender);
        Button iv_titlebar_find = (Button) findViewById(R.id.iv_titlebar_find);
        Button iv_titlebar_tocreatenote = (Button) findViewById(R.id.iv_titlebar_tocreate);
        Button iv_titlebar_info = (Button) findViewById(R.id.iv_titlebar_info);

        iv_titlebar_calender.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(HomeActivity.this, "点击日历", Toast.LENGTH_LONG).show();
            }
        });

        iv_titlebar_find.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(HomeActivity.this, "点击查找", Toast.LENGTH_LONG).show();
            }
        });

        iv_titlebar_tocreatenote.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(HomeActivity.this, EditNoteActivity.class);
                startActivity(intent);
            }
        });

        iv_titlebar_info.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(HomeActivity.this, "点击信息", Toast.LENGTH_LONG).show();
            }
        });

    }

}
