package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.token.aad;
import com.tencent.token.aad.a;
import com.tencent.token.aic;
import com.tencent.token.r;
import com.tencent.token.rw;
import com.tencent.token.rw.a;
import com.tencent.token.rw.b;
import com.tencent.token.rw.c;
import com.tencent.token.t;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.yt;
import com.tencent.token.zx;
import java.io.File;

public class DownloadQQSecureActivity
  extends BaseActivity
{
  static final int MSG_UPDATE_UI = 99;
  boolean isInstall;
  rw.c listener = new rw.c()
  {
    public final void a(rw.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void b(rw.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void c(rw.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
    
    public final void d(rw.a paramAnonymousa)
    {
      DownloadQQSecureActivity.this.postUpdateUI();
    }
  };
  LayoutAppKeyInfo mAppLayout;
  FrameLayout mBackView;
  Button mButton;
  rw.a mDownloadInfo;
  @SuppressLint({"HandlerLeak"})
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
    if (this.isInstall)
    {
      showUserDialog(0, "即将离开QQ安全中心，打开其他应用", "取消", "允许", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zx.c(DownloadQQSecureActivity.this, "com.tencent.qqpimsecure");
        }
      });
      return;
    }
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (8.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 7: 
      rw.b.a().c(this.mDownloadInfo);
      return;
    case 6: 
      rw.b.a().d(this.mDownloadInfo);
      return;
    case 5: 
      rw.b.a().c(this.mDownloadInfo);
      return;
    case 4: 
      rw.a(this, new File(rw.a(), this.mDownloadInfo.d));
      return;
    case 2: 
    case 3: 
      rw.b.a().b(this.mDownloadInfo);
      return;
    }
    rw.b.a().c(this.mDownloadInfo);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2131296296);
    this.mButton = ((Button)findViewById(2131165860));
    this.mBackView = ((FrameLayout)findViewById(2131165893));
    this.mDownloadInfo = rw.b.a().a("http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = aic.a("com.tencent.qqpimsecure", "http://qqwx.qq.com/s?aid=index&p=1&c=107014&vt=1&pf=0");
    }
    if (rw.b.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    this.mButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadQQSecureActivity.this.checkIsPermissionOK(new yt()
        {
          public final void a()
          {
            DownloadQQSecureActivity.this.handleProcessByState();
          }
          
          public final void b() {}
        });
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
    rw.b.a().a(this.listener);
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166044));
    this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "8.11.0", "腾讯手机管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpimsecure", "https://privacy.qq.com/document/priview/c4c2fc8a9e8c47d19577907a72e62f11", this);
    aad.a("com.tencent.qqpimsecure", new aad.a()
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
    rw.b.a().b(this.listener);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.isInstall = zx.b(this, "com.tencent.qqpimsecure");
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
    switch (8.a[this.mDownloadInfo.f.ordinal()])
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