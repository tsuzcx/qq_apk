package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.aad;
import com.tencent.token.aad.a;
import com.tencent.token.aaj;
import com.tencent.token.aaz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;
import com.tencent.token.t;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.yt;
import com.tencent.token.zx;
import com.tencent.token.zy;
import com.tencent.token.zz;
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
  private LayoutAppKeyInfo mAppLayout;
  private Handler mHandler = new Handler(Looper.myLooper());
  private BroadcastReceiver mNetworkMsgReceiver = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext != null)
      {
        if (paramAnonymousContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          paramAnonymousContext = aaj.m(QQPimNewActivity.this);
          if ((aaj.a()) && ("WIFI".equals(paramAnonymousContext)))
          {
            if (!QQPimNewActivity.this.isWifiFirstRun) {
              QQPimNewActivity.this.downloadApk();
            }
            QQPimNewActivity.access$302(QQPimNewActivity.this, false);
            return;
          }
          if (zz.e().f())
          {
            zz.e().b();
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131493462));
          }
          return;
        }
        paramAnonymousContext.equals("noConnectivity");
      }
    }
  };
  private InstallBroadcastReceiver mReceiver;
  private boolean needReportInstall = false;
  private FrameLayout qqpimBackNew;
  private FrameLayout qqpimFlProgressNew;
  private ProgressBar qqpimPbDownloadProgressNew;
  private ProgressTextView qqpimTvProgressChangeNew;
  private TextView tvQqpimDownload;
  
  private void downloadApk()
  {
    this.isApkDownload = zz.e().c();
    if (this.isApkDownload) {
      return;
    }
    zz.e().a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, new zy()
    {
      public final void a()
      {
        QQPimNewActivity.access$702(QQPimNewActivity.this, true);
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131493454));
            Toast.makeText(QQPimNewActivity.this, QQPimNewActivity.this.getResources().getText(2131493458), 0).show();
            zx.a(QQPimNewActivity.this, QQPimNewActivity.this.filePath);
            QQPimNewActivity.access$902(QQPimNewActivity.this, true);
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
          }
        });
        QQPimNewActivity.access$1002(QQPimNewActivity.this, 0.0F);
        TMSDKContext.saveActionData(170023);
      }
      
      public final void a(final float paramAnonymousFloat)
      {
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > QQPimNewActivity.this.lastProgress))
        {
          QQPimNewActivity.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              QQPimNewActivity.this.tvQqpimDownload.setVisibility(4);
              QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(0);
              QQPimNewActivity.this.qqpimTvProgressChangeNew.setTextWhiteLength(paramAnonymousFloat);
              QQPimNewActivity.this.qqpimPbDownloadProgressNew.setProgress((int)(paramAnonymousFloat * 100.0F));
              ProgressTextView localProgressTextView = QQPimNewActivity.this.qqpimTvProgressChangeNew;
              StringBuilder localStringBuilder = new StringBuilder("下载中...");
              localStringBuilder.append((int)(paramAnonymousFloat * 100.0F));
              localStringBuilder.append("%");
              localProgressTextView.setText(localStringBuilder.toString());
            }
          });
          QQPimNewActivity.access$1002(QQPimNewActivity.this, paramAnonymousFloat);
        }
      }
      
      public final void b()
      {
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131493457));
          }
        });
      }
      
      public final void c()
      {
        QQPimNewActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimNewActivity.this.tvQqpimDownload.setVisibility(0);
            QQPimNewActivity.this.qqpimFlProgressNew.setVisibility(4);
            QQPimNewActivity.this.tvQqpimDownload.setText(QQPimNewActivity.this.getResources().getText(2131493462));
          }
        });
        QQPimNewActivity.access$1002(QQPimNewActivity.this, 0.0F);
      }
    });
    if (Environment.getExternalStorageDirectory().getFreeSpace() < 20971520L)
    {
      Toast.makeText(this, getResources().getText(2131493045), 0).show();
      return;
    }
    this.tvQqpimDownload.setText(getResources().getText(2131493463));
    zz.e().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = zz.e().c();
    this.isInstall = zx.b(this, "com.tencent.qqpim");
    this.filePath = zz.e().d();
  }
  
  private void initView()
  {
    this.qqpimBackNew = ((FrameLayout)findViewById(2131165893));
    this.tvQqpimDownload = ((TextView)findViewById(2131166226));
    this.qqpimFlProgressNew = ((FrameLayout)findViewById(2131165895));
    this.qqpimPbDownloadProgressNew = ((ProgressBar)findViewById(2131165897));
    this.qqpimTvProgressChangeNew = ((ProgressTextView)findViewById(2131165899));
    this.LlQqpimDesc = ((LinearLayout)findViewById(2131165701));
    this.ivQqpimFile = ((ImageView)findViewById(2131165662));
    this.ivQqpimContact = ((ImageView)findViewById(2131165661));
    this.ivQqpimCoinCenter = ((ImageView)findViewById(2131165660));
    this.qqpimTvProgressChangeNew.setColorId(2130968736);
    this.tvQqpimDownload.setOnClickListener(this);
    this.qqpimFlProgressNew.setOnClickListener(this);
    this.qqpimBackNew.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
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
    RqdApplication.n().registerReceiver(this.mNetworkMsgReceiver, localIntentFilter);
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
  
  private void show4GNotifyShow()
  {
    new QQPim4GNotifyDialog(this, new QQPim4GNotifyDialog.a()
    {
      public final void a()
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
    RqdApplication.n().unregisterReceiver(this.mNetworkMsgReceiver);
  }
  
  private void updateBtnState()
  {
    this.isInstall = zx.b(this, "com.tencent.qqpim");
    if ((this.isApkDownload) && (!this.isInstall))
    {
      this.tvQqpimDownload.setText(getResources().getText(2131493459));
      return;
    }
    this.tvQqpimDownload.setText(getResources().getText(2131493052));
  }
  
  void checkIfNetworkOkForDownload()
  {
    if (aaj.a())
    {
      if (zz.e().f())
      {
        zz.e().b();
        return;
      }
      if ("4G".equals(aaj.m(this)))
      {
        show4GNotifyShow();
        return;
      }
      startDownload();
      return;
    }
    Toast.makeText(this, getResources().getText(2131493460), 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131166226) || (i == 2131165895))
    {
      if (this.isInstall)
      {
        zx.c(this, "com.tencent.qqpim");
        return;
      }
      if (this.isApkDownload)
      {
        zx.a(this, this.filePath);
        return;
      }
      TMSDKContext.saveActionData(170022);
      checkIsPermissionOK(new yt()
      {
        public final void a()
        {
          QQPimNewActivity.this.checkIfNetworkOkForDownload();
        }
        
        public final void b() {}
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296300);
    TMSDKContext.saveActionData(170021);
    aaz.a(this, this.mTitleBar, 2130968666);
    initView();
    registReceiver();
    registerInstallReceiver();
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166044));
    this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "7.16", "QQ同步助手-微信文件备份", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpim", "https://cftweb.3g.qq.com/privacy/privacyPolicy?content_id=26e57ba2bb972d84e9a8c45ed6f7ad801617788449", this);
    aad.a("com.tencent.qqpim", new aad.a()
    {
      public final void a(final r paramAnonymousr)
      {
        QQPimNewActivity.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            QQPimNewActivity.this.setSoftDetail(paramAnonymousr);
          }
        });
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregistReceiver();
    unInstallRegisterReceiver();
  }
  
  public void onResume()
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
        QQPimNewActivity.access$702(QQPimNewActivity.this, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimNewActivity
 * JD-Core Version:    0.7.0.1
 */