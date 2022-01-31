package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.service.a;
import com.tencent.service.d;
import com.tencent.service.f;
import com.tencent.token.fk;
import java.io.File;

public class DownloadAppActivity
  extends Activity
{
  static final int MSG_UPDATE_UI = 99;
  f listener = new dw(this);
  Button mButton;
  d mDownloadInfo;
  Handler mHandler = new du(this);
  
  void handleProcessByState()
  {
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (dx.a[this.mDownloadInfo.f.ordinal()])
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
    paramBundle = getIntent().getStringExtra("downloadurl");
    this.mDownloadInfo = a.a().a(paramBundle);
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = fk.b(paramBundle);
    }
    if (a.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    this.mButton.setOnClickListener(new dv(this));
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
    switch (dx.a[this.mDownloadInfo.f.ordinal()])
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
 * Qualified Name:     com.tencent.token.ui.DownloadAppActivity
 * JD-Core Version:    0.7.0.1
 */