package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.dz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;
import java.io.File;

public class QQPimNewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final long APK_SIZE = 20971520L;
  private static final String TAG = "QQPimNewActivity";
  private LinearLayout LlQqpimDesc;
  private String filePath;
  private boolean isApkDownload;
  private boolean isInstall;
  private boolean isWifiFirstRun = true;
  private ImageView ivQqpimCoinCenter;
  private ImageView ivQqpimContact;
  private ImageView ivQqpimFile;
  private float lastProgress = 0.0F;
  private BroadcastReceiver mNetworkMsgReceiver = new n(this);
  private QQPimNewActivity.InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private ImageView qqpimBackNew;
  private FrameLayout qqpimFlProgressNew;
  private ProgressBar qqpimPbDownloadProgressNew;
  private ProgressTextView qqpimTvProgressChangeNew;
  private TextView tvQqpimDownload;
  
  private void downloadApk()
  {
    this.isApkDownload = dz.f().d();
    if (this.isApkDownload) {
      return;
    }
    dz.f().b(new o(this));
    if (Environment.getExternalStorageDirectory().getFreeSpace() < 20971520L)
    {
      Toast.makeText(this, getResources().getText(2131230901), 0).show();
      return;
    }
    this.tvQqpimDownload.setText(getResources().getText(2131231312));
    dz.f().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = dz.f().d();
    this.isInstall = a.b(this, "com.tencent.qqpim");
    this.filePath = dz.f().e();
  }
  
  private void initView()
  {
    this.qqpimBackNew = ((ImageView)findViewById(2131558706));
    this.tvQqpimDownload = ((TextView)findViewById(2131558711));
    this.qqpimFlProgressNew = ((FrameLayout)findViewById(2131558712));
    this.qqpimPbDownloadProgressNew = ((ProgressBar)findViewById(2131558713));
    this.qqpimTvProgressChangeNew = ((ProgressTextView)findViewById(2131558714));
    this.LlQqpimDesc = ((LinearLayout)findViewById(2131558707));
    this.ivQqpimFile = ((ImageView)findViewById(2131558708));
    this.ivQqpimContact = ((ImageView)findViewById(2131558709));
    this.ivQqpimCoinCenter = ((ImageView)findViewById(2131558710));
    this.qqpimTvProgressChangeNew.setColorId(2131493002);
    this.tvQqpimDownload.setOnClickListener(this);
    this.qqpimFlProgressNew.setOnClickListener(this);
    this.qqpimBackNew.setOnClickListener(new l(this));
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
    this.mReceiver = new QQPimNewActivity.InstallBroadcastReceiver(this);
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
  
  private void show4GNotifyShow()
  {
    new QQPim4GNotifyDialog(this, 2131362182, new m(this)).show();
  }
  
  private void startDownload()
  {
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
    this.isInstall = a.b(this, "com.tencent.qqpim");
    if ((this.isApkDownload) && (!this.isInstall))
    {
      this.tvQqpimDownload.setText(getResources().getText(2131231308));
      return;
    }
    this.tvQqpimDownload.setText(getResources().getText(2131230908));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131558711) || (i == 2131558712))
    {
      if (this.isInstall) {
        a.c(this, "com.tencent.qqpim");
      }
    }
    else {
      return;
    }
    if (this.isApkDownload)
    {
      a.a(this, this.filePath);
      return;
    }
    TMSDKContext.saveActionData(170022);
    if (com.tencent.token.upload.o.a())
    {
      if (dz.f().g())
      {
        dz.f().c();
        return;
      }
      if ("4G".equals(com.tencent.token.upload.o.o(this)))
      {
        show4GNotifyShow();
        return;
      }
      startDownload();
      return;
    }
    Toast.makeText(this, getResources().getText(2131231309), 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968619);
    TMSDKContext.saveActionData(170021);
    x.a(this, this.mTitleBar, 2131492933);
    initView();
    registReceiver();
    registerInstallReceiver();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimNewActivity
 * JD-Core Version:    0.7.0.1
 */