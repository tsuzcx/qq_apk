package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.dz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.upload.o;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;

public class QQPimActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String TAG = "QQPimActivity";
  private String filePath;
  private FrameLayout flProgress;
  private boolean isApkDownload;
  private boolean isInstall;
  private ImageView ivBack;
  private float lastProgress = 0.0F;
  private BroadcastReceiver mNetworkMsgReceiver = new f(this);
  private QQPimActivity.InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private ProgressBar pbProgress;
  private TextView tvDownload;
  private ProgressTextView tvProgress;
  
  private void downloadApk()
  {
    TMSDKContext.saveActionData(170010);
    dz.f().a(new g(this));
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
    this.pbProgress = ((ProgressBar)findViewById(2131558704));
    this.flProgress = ((FrameLayout)findViewById(2131558703));
    this.tvProgress = ((ProgressTextView)findViewById(2131558705));
    this.ivBack = ((ImageView)findViewById(2131558698));
    this.tvDownload = ((TextView)findViewById(2131558702));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new e(this));
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
    this.mReceiver = new QQPimActivity.InstallBroadcastReceiver(this);
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
    this.tvDownload.setText(getResources().getText(2131231312).toString());
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
    this.tvDownload.setText(getResources().getText(2131230907));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131558702) || (i == 2131558703))
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
    if (o.a())
    {
      if (dz.f().g())
      {
        dz.f().c();
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
    setContentView(2130968618);
    x.a(this, this.mTitleBar, 2131493037);
    initView();
    registReceiver();
    registerInstallReceiver();
    TMSDKContext.saveActionData(170009);
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
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimActivity
 * JD-Core Version:    0.7.0.1
 */