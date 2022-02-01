package com.tencent.token.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.service.a;
import com.tencent.service.a.a;
import com.tencent.service.a.c;
import com.tencent.token.ec;
import java.io.File;

public class DownloadQQSecureActivity
  extends Activity
{
  static final int MSG_UPDATE_UI = 99;
  a.c listener = new a.c()
  {
    public void a(a.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public void b(a.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public void c(a.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public void d(a.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
  };
  Button mButton;
  a.a mDownloadInfo;
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        DownloadQQSecureActivity.this.refreshUIByState();
      }
    }
  };
  
  void handleProcessByState()
  {
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (4.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 1: 
      a.a().c(this.mDownloadInfo);
      return;
    case 2: 
    case 3: 
      a.a().b(this.mDownloadInfo);
      return;
    case 4: 
      a.a(this, new File(a.b(), this.mDownloadInfo.d));
      return;
    case 5: 
      a.a().c(this.mDownloadInfo);
      return;
    case 6: 
      a.a().d(this.mDownloadInfo);
      return;
    }
    a.a().c(this.mDownloadInfo);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130968615);
    this.mButton = ((Button)findViewById(2131558680));
    this.mDownloadInfo = a.a().a("http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = ec.a("com.tencent.qqpimsecure", "http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    }
    if (a.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    this.mButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownloadQQSecureActivity.this.handleProcessByState();
      }
    });
    refreshUIByState();
    a.a().a(this.listener);
  }
  
  protected void onDestroy()
  {
    a.a().b(this.listener);
    super.onDestroy();
  }
  
  void postUpdateUI()
  {
    this.mHandler.removeMessages(99);
    this.mHandler.sendEmptyMessage(99);
  }
  
  void refreshUIByState()
  {
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (4.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.mButton.setText("立即体验");
      return;
    case 2: 
    case 3: 
      this.mButton.setText("下载中...(" + this.mDownloadInfo.e + "%)");
      return;
    case 4: 
      this.mButton.setText("安装");
      return;
    case 5: 
      this.mButton.setText("重试");
      return;
    }
    this.mButton.setText("继续");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DownloadQQSecureActivity
 * JD-Core Version:    0.7.0.1
 */