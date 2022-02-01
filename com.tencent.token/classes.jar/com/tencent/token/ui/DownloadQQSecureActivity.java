package com.tencent.token.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.token.ahc;
import com.tencent.token.r;
import com.tencent.token.rj;
import com.tencent.token.rj.a;
import com.tencent.token.rj.b;
import com.tencent.token.rj.c;
import com.tencent.token.t;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.zr;
import com.tencent.token.zr.a;
import java.io.File;

public class DownloadQQSecureActivity
  extends Activity
{
  static final int MSG_UPDATE_UI = 99;
  rj.c listener = new rj.c()
  {
    public final void a(rj.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void b(rj.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void c(rj.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void d(rj.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
  };
  LayoutAppKeyInfo mAppLayout;
  FrameLayout mBackView;
  Button mButton;
  rj.a mDownloadInfo;
  Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        DownloadQQSecureActivity.this.refreshUIByState();
      }
    }
  };
  
  private void setSoftDetail(r paramr)
  {
    if (paramr != null)
    {
      if (TextUtils.isEmpty(paramr.i)) {
        return;
      }
      this.mAppLayout.a(paramr.i, paramr.a.b, paramr.a.d, paramr.k, paramr.r, this);
      return;
    }
  }
  
  void handleProcessByState()
  {
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (6.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 7: 
      rj.b.a().c(this.mDownloadInfo);
      return;
    case 6: 
      rj.b.a().d(this.mDownloadInfo);
      return;
    case 5: 
      rj.b.a().c(this.mDownloadInfo);
      return;
    case 4: 
      rj.a(this, new File(rj.a(), this.mDownloadInfo.d));
      return;
    case 2: 
    case 3: 
      rj.b.a().b(this.mDownloadInfo);
      return;
    }
    rj.b.a().c(this.mDownloadInfo);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2131296295);
    this.mButton = ((Button)findViewById(2131165827));
    this.mBackView = ((FrameLayout)findViewById(2131165859));
    this.mDownloadInfo = rj.b.a().a("http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = ahc.a("com.tencent.qqpimsecure", "http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    }
    if (rj.b.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    this.mButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadQQSecureActivity.this.handleProcessByState();
      }
    });
    this.mBackView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadQQSecureActivity.this.finish();
      }
    });
    refreshUIByState();
    rj.b.a().a(this.listener);
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166009));
    this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "8.11.0", "腾讯手机管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpimsecure", "https://privacy.qq.com/document/priview/c4c2fc8a9e8c47d19577907a72e62f11", this);
    zr.a("com.tencent.qqpimsecure", new zr.a()
    {
      public final void a(final r paramAnonymousr)
      {
        DownloadQQSecureActivity.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            DownloadQQSecureActivity.this.setSoftDetail(paramAnonymousr);
          }
        });
      }
    });
  }
  
  protected void onDestroy()
  {
    rj.b.a().b(this.listener);
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
    switch (6.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 6: 
      this.mButton.setText("继续");
      return;
    case 5: 
      this.mButton.setText("重试");
      return;
    case 4: 
      this.mButton.setText("安装");
      return;
    case 2: 
    case 3: 
      Button localButton = this.mButton;
      StringBuilder localStringBuilder = new StringBuilder("下载中...(");
      localStringBuilder.append(this.mDownloadInfo.e);
      localStringBuilder.append("%)");
      localButton.setText(localStringBuilder.toString());
      return;
    }
    this.mButton.setText("立即下载");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DownloadQQSecureActivity
 * JD-Core Version:    0.7.0.1
 */