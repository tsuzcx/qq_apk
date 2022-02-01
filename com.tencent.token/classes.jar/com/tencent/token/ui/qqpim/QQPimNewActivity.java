package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.upload.i;
import com.tencent.token.utils.m;
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
  private BroadcastReceiver mNetworkMsgReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext != null)
      {
        if (!paramAnonymousContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          break label128;
        }
        paramAnonymousContext = i.o(QQPimNewActivity.this);
        if ((!i.a()) || (!"WIFI".equals(paramAnonymousContext))) {
          break label68;
        }
        if (!QQPimNewActivity.this.isWifiFirstRun) {
          QQPimNewActivity.this.downloadApk();
        }
      }
      label68:
      while (!paramAnonymousContext.equals("noConnectivity"))
      {
        QQPimNewActivity.access$102(QQPimNewActivity.this, false);
        do
        {
          return;
        } while (!cy.f().g());
        cy.f().c();
        QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
        QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
        QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131231311));
        return;
      }
      label128:
    }
  };
  private InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private ImageView qqpimBackNew;
  private FrameLayout qqpimFlProgressNew;
  private ProgressBar qqpimPbDownloadProgressNew;
  private ProgressTextView qqpimTvProgressChangeNew;
  private TextView tvQqpimDownload;
  
  private void downloadApk()
  {
    this.isApkDownload = cy.f().d();
    if (this.isApkDownload) {
      return;
    }
    cy.f().b(new cx()
    {
      public void a()
      {
        QQPimNewActivity.access$502(QQPimNewActivity.this, true);
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131231303));
            Toast.makeText(QQPimNewActivity.this, QQPimNewActivity.this.getResources().getText(2131231307), 0).show();
            a.a(QQPimNewActivity.this, QQPimNewActivity.this.filePath);
            QQPimNewActivity.access$702(QQPimNewActivity.this, true);
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
          }
        });
        QQPimNewActivity.access$802(QQPimNewActivity.this, 0.0F);
        TMSDKContext.saveActionData(170023);
        Log.i("QQPimNewActivity", "onFinished: ");
      }
      
      public void a(final float paramAnonymousFloat)
      {
        Log.i("QQPimNewActivity", "onProgress: " + paramAnonymousFloat);
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > QQPimNewActivity.this.lastProgress))
        {
          QQPimNewActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              QQPimNewActivity.this.tvQqpimDownload.setVisibility(4);
              QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(0);
              QQPimNewActivity.this.qqpimTvProgressChangeNew.setTextWhiteLength(paramAnonymousFloat);
              QQPimNewActivity.this.qqpimPbDownloadProgressNew.setProgress((int)(paramAnonymousFloat * 100.0F));
              QQPimNewActivity.this.qqpimTvProgressChangeNew.setText("下载中..." + (int)(paramAnonymousFloat * 100.0F) + "%");
            }
          });
          QQPimNewActivity.access$802(QQPimNewActivity.this, paramAnonymousFloat);
        }
      }
      
      public void b()
      {
        Log.i("QQPimNewActivity", "onPause: ");
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131231306));
          }
        });
      }
      
      public void c()
      {
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131231311));
          }
        });
        Log.i("QQPimNewActivity", "onCancel: ");
        QQPimNewActivity.access$802(QQPimNewActivity.this, 0.0F);
      }
    });
    if (Environment.getExternalStorageDirectory().getFreeSpace() < 20971520L)
    {
      Toast.makeText(this, getResources().getText(2131230901), 0).show();
      return;
    }
    this.tvQqpimDownload.setText(getResources().getText(2131231312));
    cy.f().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = cy.f().d();
    this.isInstall = a.b(this, "com.tencent.qqpim");
    this.filePath = cy.f().e();
  }
  
  private void initView()
  {
    this.qqpimBackNew = ((ImageView)findViewById(2131558707));
    this.tvQqpimDownload = ((TextView)findViewById(2131558712));
    this.qqpimFlProgressNew = ((FrameLayout)findViewById(2131558713));
    this.qqpimPbDownloadProgressNew = ((ProgressBar)findViewById(2131558714));
    this.qqpimTvProgressChangeNew = ((ProgressTextView)findViewById(2131558715));
    this.LlQqpimDesc = ((LinearLayout)findViewById(2131558708));
    this.ivQqpimFile = ((ImageView)findViewById(2131558709));
    this.ivQqpimContact = ((ImageView)findViewById(2131558710));
    this.ivQqpimCoinCenter = ((ImageView)findViewById(2131558711));
    this.qqpimTvProgressChangeNew.setColorId(2131493002);
    this.tvQqpimDownload.setOnClickListener(this);
    this.qqpimFlProgressNew.setOnClickListener(this);
    this.qqpimBackNew.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        QQPimNewActivity.this.finish();
      }
    });
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
    this.mReceiver = new InstallBroadcastReceiver();
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
    new QQPim4GNotifyDialog(this, 2131362182, new QQPim4GNotifyDialog.a()
    {
      public void a()
      {
        QQPimNewActivity.this.startDownload();
      }
    }).show();
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
    if ((i == 2131558712) || (i == 2131558713))
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
    if (i.a())
    {
      if (cy.f().g())
      {
        cy.f().c();
        return;
      }
      if ("4G".equals(i.o(this)))
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
    m.a(this, this.mTitleBar, 2131492933);
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
  
  public class InstallBroadcastReceiver
    extends BroadcastReceiver
  {
    public InstallBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (QQPimNewActivity.this.needReportInstall))
      {
        TMSDKContext.saveActionData(170024);
        QQPimNewActivity.access$502(QQPimNewActivity.this, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimNewActivity
 * JD-Core Version:    0.7.0.1
 */