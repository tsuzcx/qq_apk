package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.token.aae;
import com.tencent.token.afr;
import com.tencent.token.r;
import com.tencent.token.rc;
import com.tencent.token.rc.a;
import com.tencent.token.rc.b;
import com.tencent.token.rc.c;
import com.tencent.token.t;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.zf;
import com.tencent.token.zf.a;
import com.tencent.token.zt;
import java.io.File;

public class DownloadAppActivity
  extends BaseActivity
{
  static final int MSG_UPDATE_UI = 99;
  private ImageView centerImage;
  private TextView descriptionText;
  private FrameLayout flProgress;
  private FrameLayout ivBack;
  rc.c listener = new rc.c()
  {
    public final void a(rc.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public final void b(rc.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public final void c(rc.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public final void d(rc.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
      DownloadAppActivity.this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          if ((DownloadAppActivity.this.mDownloadInfo != null) && (DownloadAppActivity.this.mDownloadInfo.f == DownloaderTaskStatus.COMPLETE)) {
            rc.a(DownloadAppActivity.this, new File(rc.a(), DownloadAppActivity.this.mDownloadInfo.d));
          }
        }
      }, 500L);
    }
  };
  private LayoutAppKeyInfo mAppLayout;
  rc.a mDownloadInfo;
  Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 99) {
        DownloadAppActivity.this.refreshUIByState();
      }
    }
  };
  private TextView mPageTitle;
  private ProgressBar pbProgress;
  private TextView subDescriptionText;
  private TextView tvDownload;
  private ProgressTextView tvProgress;
  
  private void setDefaultSoftDetail(String paramString)
  {
    if ("com.tencent.qqpimsecure".equals(paramString))
    {
      this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "8.11.0", "腾讯手机管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpimsecure", "https://privacy.qq.com/document/priview/c4c2fc8a9e8c47d19577907a72e62f11", this);
      this.mAppLayout.setVisibility(0);
      return;
    }
    if ("com.tencent.qqpim".equals(paramString))
    {
      this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "7.16", "QQ同步助手-微信文件备份", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpim", "https://cftweb.3g.qq.com/privacy/privacyPolicy?content_id=26e57ba2bb972d84e9a8c45ed6f7ad801617788449", this);
      this.mAppLayout.setVisibility(0);
      return;
    }
    if ("com.tencent.gallerymanager".equals(paramString))
    {
      this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "4.2.6", "腾讯相册管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.gallerymanager", "https://cftweb.3g.qq.com/privacy/privacyPolicy?content_id=95fb3a1fc2e0d6bda65de66c15606b2b1617954054", this);
      this.mAppLayout.setVisibility(0);
      return;
    }
    if ("com.tencent.gamestick".equals(paramString))
    {
      this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "4.4.2", "腾讯游戏管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.gamestick", "http://pic-17161.sh.gfp.tencent-cloud.com/fromcos%7C5242880%7C1599561493.4843%7C%E9%9A%90%E7%A7%81%E6%94%BF%E7%AD%96375px.png", this);
      this.mAppLayout.setVisibility(0);
      return;
    }
    if ("com.tencent.transfer".equals(paramString))
    {
      this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "1.5.6", "换机助手", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.transfer", "http://pic-17161.sh.gfp.tencent-cloud.com/fromcos%7C5242880%7C1599559220.8459%7C%E9%9A%90%E7%A7%81%E6%94%BF%E7%AD%96-3.jpg", this);
      this.mAppLayout.setVisibility(0);
    }
  }
  
  private void setSoftDetail(r paramr)
  {
    if (paramr != null)
    {
      if (TextUtils.isEmpty(paramr.i)) {
        return;
      }
      this.mAppLayout.setVisibility(0);
      this.mAppLayout.a(paramr.i, paramr.a.b, paramr.a.d, paramr.k, paramr.r, this);
      return;
    }
  }
  
  private void updateUIFromBundle()
  {
    String str1 = getIntent().getStringExtra("title");
    String str2 = getIntent().getStringExtra("des");
    String str3 = getIntent().getStringExtra("subdes");
    String str4 = getIntent().getStringExtra("button");
    String str5 = getIntent().getStringExtra("imgurl");
    this.mPageTitle.setText(str1);
    this.descriptionText.setText(str2);
    this.subDescriptionText.setText(str3);
    this.tvDownload.setText(str4);
    if (!TextUtils.isEmpty(str5)) {
      new zt(this.centerImage).execute(new String[] { str5 });
    }
  }
  
  void handleProcessByState()
  {
    if (this.mDownloadInfo == null) {
      return;
    }
    switch (7.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
      return;
    case 7: 
      rc.b.a().c(this.mDownloadInfo);
      return;
    case 6: 
      rc.b.a().d(this.mDownloadInfo);
      return;
    case 5: 
      rc.b.a().c(this.mDownloadInfo);
      return;
    case 4: 
      rc.a(this, new File(rc.a(), this.mDownloadInfo.d));
      return;
    case 2: 
    case 3: 
      rc.b.a().b(this.mDownloadInfo);
      return;
    }
    rc.b.a().c(this.mDownloadInfo);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2131296296);
    aae.a(this, this.mTitleBar, 2130968771);
    this.mPageTitle = ((TextView)findViewById(2131165807));
    this.pbProgress = ((ProgressBar)findViewById(2131165549));
    this.flProgress = ((FrameLayout)findViewById(2131165548));
    this.tvProgress = ((ProgressTextView)findViewById(2131165550));
    this.descriptionText = ((TextView)findViewById(2131166163));
    this.subDescriptionText = ((TextView)findViewById(2131166165));
    this.centerImage = ((ImageView)findViewById(2131165625));
    this.ivBack = ((FrameLayout)findViewById(2131165547));
    this.tvDownload = ((TextView)findViewById(2131166164));
    this.tvDownload.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.handleProcessByState();
      }
    });
    this.flProgress.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.handleProcessByState();
      }
    });
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.finish();
      }
    });
    paramBundle = getIntent().getStringExtra("downloadurl");
    this.mDownloadInfo = rc.b.a().a(paramBundle);
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = afr.a(getIntent().getStringExtra("pkg"), paramBundle);
    }
    if (rc.b.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    updateUIFromBundle();
    refreshUIByState();
    rc.b.a().a(this.listener);
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166007));
    this.mAppLayout.setVisibility(8);
    zf.a(getIntent().getStringExtra("pkg"), new zf.a()
    {
      public final void a(final r paramAnonymousr)
      {
        DownloadAppActivity.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            DownloadAppActivity.this.setSoftDetail(paramAnonymousr);
          }
        });
      }
    });
    setDefaultSoftDetail(getIntent().getStringExtra("pkg"));
  }
  
  protected void onDestroy()
  {
    rc.b.a().b(this.listener);
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
    switch (7.a[this.mDownloadInfo.f.ordinal()])
    {
    default: 
    case 6: 
      this.tvDownload.setVisibility(0);
      this.flProgress.setVisibility(8);
      this.tvDownload.setText(getResources().getText(2131493210));
      return;
    case 5: 
      this.tvDownload.setVisibility(0);
      this.flProgress.setVisibility(8);
      this.tvDownload.setText(getResources().getText(2131493214));
      return;
    case 4: 
      this.tvDownload.setVisibility(0);
      this.flProgress.setVisibility(8);
      this.tvDownload.setText("安装");
      return;
    case 2: 
    case 3: 
      this.tvDownload.setVisibility(8);
      this.flProgress.setVisibility(0);
      this.tvProgress.setTextWhiteLength(this.mDownloadInfo.e / 100);
      this.pbProgress.setProgress(this.mDownloadInfo.e);
      ProgressTextView localProgressTextView = this.tvProgress;
      StringBuilder localStringBuilder = new StringBuilder("下载中...");
      localStringBuilder.append(this.mDownloadInfo.e);
      localStringBuilder.append("%");
      localProgressTextView.setText(localStringBuilder.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DownloadAppActivity
 * JD-Core Version:    0.7.0.1
 */