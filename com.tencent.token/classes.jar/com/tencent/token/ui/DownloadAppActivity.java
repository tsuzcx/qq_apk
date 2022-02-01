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
import com.tencent.service.a.a;
import com.tencent.service.a.c;
import com.tencent.token.ec;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.upload.i;
import com.tencent.token.utils.m;
import java.io.File;

public class DownloadAppActivity
  extends BaseActivity
{
  static final int MSG_UPDATE_UI = 99;
  private ImageView centerImage;
  private TextView descriptionText;
  private FrameLayout flProgress;
  private ImageView ivBack;
  a.c listener = new a.c()
  {
    public void a(a.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public void b(a.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public void c(a.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
    }
    
    public void d(a.a paramAnonymousa)
    {
      DownloadAppActivity.this.postUpdateUI();
      DownloadAppActivity.this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          if ((DownloadAppActivity.this.mDownloadInfo != null) && (DownloadAppActivity.this.mDownloadInfo.f == DownloaderTaskStatus.COMPLETE)) {
            com.tencent.service.a.a(DownloadAppActivity.this, new File(com.tencent.service.a.b(), DownloadAppActivity.this.mDownloadInfo.d));
          }
        }
      }, 500L);
    }
  };
  a.a mDownloadInfo;
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
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
      new com.tencent.token.utils.a(this.centerImage).execute(new String[] { str5 });
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
    case 1: 
      com.tencent.service.a.a().c(this.mDownloadInfo);
      return;
    case 2: 
    case 3: 
      com.tencent.service.a.a().b(this.mDownloadInfo);
      return;
    case 4: 
      com.tencent.service.a.a(this, new File(com.tencent.service.a.b(), this.mDownloadInfo.d));
      return;
    case 5: 
      com.tencent.service.a.a().c(this.mDownloadInfo);
      return;
    case 6: 
      com.tencent.service.a.a().d(this.mDownloadInfo);
      return;
    }
    com.tencent.service.a.a().c(this.mDownloadInfo);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130968616);
    m.a(this, this.mTitleBar, 2131493037);
    this.mPageTitle = ((TextView)findViewById(2131558682));
    this.pbProgress = ((ProgressBar)findViewById(2131558688));
    this.flProgress = ((FrameLayout)findViewById(2131558687));
    this.tvProgress = ((ProgressTextView)findViewById(2131558689));
    this.descriptionText = ((TextView)findViewById(2131558684));
    this.subDescriptionText = ((TextView)findViewById(2131558685));
    this.centerImage = ((ImageView)findViewById(2131558683));
    this.ivBack = ((ImageView)findViewById(2131558681));
    this.tvDownload = ((TextView)findViewById(2131558686));
    this.tvDownload.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.handleProcessByState();
      }
    });
    this.flProgress.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.handleProcessByState();
      }
    });
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownloadAppActivity.this.finish();
      }
    });
    paramBundle = getIntent().getStringExtra("downloadurl");
    this.mDownloadInfo = com.tencent.service.a.a().a(paramBundle);
    if (this.mDownloadInfo == null) {
      this.mDownloadInfo = ec.a(getIntent().getStringExtra("pkg"), paramBundle);
    }
    if (com.tencent.service.a.a().a(this.mDownloadInfo)) {
      this.mDownloadInfo.f = DownloaderTaskStatus.COMPLETE;
    }
    updateUIFromBundle();
    refreshUIByState();
    com.tencent.service.a.a().a(this.listener);
    if (i.e(RqdApplication.l()) == 1) {
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          if ((DownloadAppActivity.this.mDownloadInfo != null) && (DownloadAppActivity.this.mDownloadInfo.f == DownloaderTaskStatus.PENDING)) {
            com.tencent.service.a.a().c(DownloadAppActivity.this.mDownloadInfo);
          }
        }
      }, 500L);
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.service.a.a().b(this.listener);
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
    case 1: 
    default: 
      return;
    case 2: 
    case 3: 
      this.tvDownload.setVisibility(4);
      this.flProgress.setVisibility(0);
      this.tvProgress.setTextWhiteLength(this.mDownloadInfo.e / 100);
      this.pbProgress.setProgress(this.mDownloadInfo.e);
      this.tvProgress.setText("下载中..." + this.mDownloadInfo.e + "%");
      return;
    case 4: 
      this.tvDownload.setVisibility(0);
      this.flProgress.setVisibility(4);
      this.tvDownload.setText("安装");
      return;
    case 5: 
      this.tvDownload.setVisibility(0);
      this.flProgress.setVisibility(4);
      this.tvDownload.setText(getResources().getText(2131231071));
      return;
    }
    this.tvDownload.setVisibility(0);
    this.flProgress.setVisibility(4);
    this.tvDownload.setText(getResources().getText(2131231067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DownloadAppActivity
 * JD-Core Version:    0.7.0.1
 */