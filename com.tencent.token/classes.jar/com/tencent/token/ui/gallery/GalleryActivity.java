package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.upload.o;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;

public class GalleryActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String TAG = "GalleryActivity";
  private String filePath;
  private FrameLayout flProgress;
  private boolean isApkDownload;
  private boolean isInstall;
  private boolean isNeedLaunch = false;
  private ImageView ivBack;
  private float lastProgress = 0.0F;
  private BroadcastReceiver mNetworkMsgReceiver = new b(this);
  private GalleryActivity.InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private ProgressBar pbProgress;
  private TextView tvDownload;
  private ProgressTextView tvProgress;
  
  private void downloadApk()
  {
    TMSDKContext.saveActionData(170016);
    h.f().a(new c(this));
    h.f().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = h.f().d();
    this.isInstall = com.tencent.token.ui.qqpim.a.b(this, "com.tencent.gallerymanager");
    this.filePath = h.f().e();
  }
  
  private void initView()
  {
    this.pbProgress = ((ProgressBar)findViewById(2131558687));
    this.flProgress = ((FrameLayout)findViewById(2131558686));
    this.tvProgress = ((ProgressTextView)findViewById(2131558688));
    this.ivBack = ((ImageView)findViewById(2131558681));
    this.tvDownload = ((TextView)findViewById(2131558685));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new a(this));
  }
  
  private void launchGalleryApp(Context paramContext)
  {
    try
    {
      this.isNeedLaunch = false;
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("gallerymanager://unijump/p?v=1&ed=1&ep=1&p={\"jumpers\":[{\"path\":\"privacy\",\"p\":{\"jumpmain\":0,\"comefrom\":\"qqprotect\"}}]}"));
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void registReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    RqdApplication.l().registerReceiver(this.mNetworkMsgReceiver, localIntentFilter);
  }
  
  private void registerInstallReceiver()
  {
    this.mReceiver = new GalleryActivity.InstallBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      finish();
    }
  }
  
  private void startDownload()
  {
    this.tvDownload.setText(getResources().getText(2131231072).toString());
    downloadApk();
  }
  
  private void unInstallRegisterReceiver()
  {
    try
    {
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void unregistReceiver()
  {
    RqdApplication.l().unregisterReceiver(this.mNetworkMsgReceiver);
  }
  
  private void updateBtnState()
  {
    this.tvDownload.setText(getResources().getText(2131231063));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131558685) || (i == 2131558686))
    {
      if (this.isInstall) {
        launchGalleryApp(this);
      }
    }
    else {
      return;
    }
    if (this.isApkDownload)
    {
      com.tencent.token.ui.qqpim.a.a(this, this.filePath);
      return;
    }
    if (o.a())
    {
      if (h.f().g())
      {
        h.f().c();
        return;
      }
      startDownload();
      return;
    }
    Toast.makeText(this, getResources().getText(2131231069), 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968616);
    x.a(this, this.mTitleBar, 2131493037);
    initView();
    registReceiver();
    registerInstallReceiver();
    TMSDKContext.saveActionData(170015);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregistReceiver();
    unInstallRegisterReceiver();
  }
  
  protected void onResume()
  {
    super.onResume();
    initStatus();
    updateBtnState();
    if (this.isNeedLaunch) {
      launchGalleryApp(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.GalleryActivity
 * JD-Core Version:    0.7.0.1
 */