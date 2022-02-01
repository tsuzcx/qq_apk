package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
  private BroadcastReceiver mNetworkMsgReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext != null) {
        if (paramAnonymousContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          if (i.a())
          {
            if (!cy.f().g()) {
              cy.f().a();
            }
          }
          else if (cy.f().g())
          {
            cy.f().c();
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(4);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493453));
          }
        }
        else {
          paramAnonymousContext.equals("noConnectivity");
        }
      }
    }
  };
  private InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private ProgressBar pbProgress;
  private TextView tvDownload;
  private ProgressTextView tvProgress;
  
  private void downloadApk()
  {
    TMSDKContext.saveActionData(170010);
    cy.f().a(new cx()
    {
      public void a()
      {
        QQPimActivity.access$202(QQPimActivity.this, true);
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493445));
            Toast.makeText(QQPimActivity.this, QQPimActivity.this.getResources().getText(2131493449), 0).show();
            a.a(QQPimActivity.this, QQPimActivity.this.filePath);
            QQPimActivity.access$402(QQPimActivity.this, true);
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(4);
          }
        });
        QQPimActivity.access$502(QQPimActivity.this, 0.0F);
        TMSDKContext.saveActionData(170011);
        Log.i("QQPimActivity", "onFinished: ");
      }
      
      public void a(final float paramAnonymousFloat)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onProgress: ");
        localStringBuilder.append(paramAnonymousFloat);
        Log.i("QQPimActivity", localStringBuilder.toString());
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > QQPimActivity.this.lastProgress))
        {
          QQPimActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              QQPimActivity.this.tvDownload.setVisibility(4);
              QQPimActivity.this.flProgress.setVisibility(0);
              QQPimActivity.this.tvProgress.setTextWhiteLength(paramAnonymousFloat);
              QQPimActivity.this.pbProgress.setProgress((int)(paramAnonymousFloat * 100.0F));
              ProgressTextView localProgressTextView = QQPimActivity.this.tvProgress;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("下载中...");
              localStringBuilder.append((int)(paramAnonymousFloat * 100.0F));
              localStringBuilder.append("%");
              localProgressTextView.setText(localStringBuilder.toString());
            }
          });
          QQPimActivity.access$502(QQPimActivity.this, paramAnonymousFloat);
        }
      }
      
      public void b()
      {
        Log.i("QQPimActivity", "onPause: ");
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(4);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493448));
          }
        });
      }
      
      public void c()
      {
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(4);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493453));
          }
        });
        Log.i("QQPimActivity", "onCancel: ");
        QQPimActivity.access$502(QQPimActivity.this, 0.0F);
      }
    });
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
    this.pbProgress = ((ProgressBar)findViewById(2131165855));
    this.flProgress = ((FrameLayout)findViewById(2131165853));
    this.tvProgress = ((ProgressTextView)findViewById(2131165857));
    this.ivBack = ((ImageView)findViewById(2131165851));
    this.tvDownload = ((TextView)findViewById(2131166171));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        QQPimActivity.this.finish();
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
  
  private void startDownload()
  {
    this.tvDownload.setText(getResources().getText(2131493454).toString());
    downloadApk();
  }
  
  private void unInstallRegisterReceiver()
  {
    try
    {
      if (this.mReceiver != null)
      {
        unregisterReceiver(this.mReceiver);
        return;
      }
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
    this.tvDownload.setText(getResources().getText(2131493049));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131166171) || (i == 2131165853))
    {
      if (this.isInstall)
      {
        a.c(this, "com.tencent.qqpim");
        return;
      }
      if (this.isApkDownload)
      {
        a.a(this, this.filePath);
        return;
      }
      if (i.a())
      {
        if (cy.f().g())
        {
          cy.f().c();
          return;
        }
        startDownload();
        return;
      }
      Toast.makeText(this, getResources().getText(2131493451), 0).show();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296298);
    m.a(this, this.mTitleBar, 2130968771);
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
  
  public class InstallBroadcastReceiver
    extends BroadcastReceiver
  {
    public InstallBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (QQPimActivity.this.needReportInstall))
      {
        TMSDKContext.saveActionData(170012);
        QQPimActivity.access$202(QQPimActivity.this, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimActivity
 * JD-Core Version:    0.7.0.1
 */