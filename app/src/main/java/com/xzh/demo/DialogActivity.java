package com.xzh.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        findViewById(R.id.style1_btn).setOnClickListener(this);
        findViewById(R.id.style2_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.style1_btn:
                LoadingDialog.Builder builder1 = new LoadingDialog.Builder(DialogActivity.this)
                        .setMessage("加载中...")
                        .setCancelable(false);
                final LoadingDialog dialog1 = builder1.create();
                dialog1.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 2000);
                break;
            case R.id.style2_btn:
                LoadingDialog.Builder builder2 = new LoadingDialog.Builder(DialogActivity.this)
                        .setShowMessage(false)
                        .setCancelable(false);
                final LoadingDialog dialog2 = builder2.create();
                dialog2.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog2.dismiss();
                    }
                }, 2000);
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
