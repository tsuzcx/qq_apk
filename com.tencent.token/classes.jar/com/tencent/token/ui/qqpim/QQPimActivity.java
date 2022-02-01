package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
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

public class QQPimActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String TAG = "QQPimActivity";
  private String filePath;
  private FrameLayout flProgress;
  private boolean isApkDownload;
  private boolean isInstall;
  private FrameLayout ivBack;
  private float lastProgress = 0.0F;
  private LayoutAppKeyInfo mAppLayout;
  private Handler mHandler = new Handler(Looper.myLooper());
  private BroadcastReceiver mNetworkMsgReceiver = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext != null) {
        if (paramAnonymousContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          if (aaj.a())
          {
            if (!zz.e().f()) {
              zz.e().a();
            }
          }
          else if (zz.e().f())
          {
            zz.e().b();
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(8);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493462));
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
    zz.e().a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, new zy()
    {
      public final void a()
      {
        QQPimActivity.access$402(QQPimActivity.this, true);
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493454));
            Toast.makeText(QQPimActivity.this, QQPimActivity.this.getResources().getText(2131493458), 0).show();
            zx.a(QQPimActivity.this, QQPimActivity.this.filePath);
            QQPimActivity.access$602(QQPimActivity.this, true);
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(8);
          }
        });
        QQPimActivity.access$702(QQPimActivity.this, 0.0F);
        TMSDKContext.saveActionData(170011);
      }
      
      public final void a(final float paramAnonymousFloat)
      {
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > QQPimActivity.this.lastProgress))
        {
          QQPimActivity.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              QQPimActivity.this.tvDownload.setVisibility(8);
              QQPimActivity.this.flProgress.setVisibility(0);
              QQPimActivity.this.tvProgress.setTextWhiteLength(paramAnonymousFloat);
              QQPimActivity.this.pbProgress.setProgress((int)(paramAnonymousFloat * 100.0F));
              ProgressTextView localProgressTextView = QQPimActivity.this.tvProgress;
              StringBuilder localStringBuilder = new StringBuilder("下载中...");
              localStringBuilder.append((int)(paramAnonymousFloat * 100.0F));
              localStringBuilder.append("%");
              localProgressTextView.setText(localStringBuilder.toString());
            }
          });
          QQPimActivity.access$702(QQPimActivity.this, paramAnonymousFloat);
        }
      }
      
      public final void b()
      {
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(8);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493457));
          }
        });
      }
      
      public final void c()
      {
        QQPimActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            QQPimActivity.this.tvDownload.setVisibility(0);
            QQPimActivity.this.flProgress.setVisibility(8);
            QQPimActivity.this.tvDownload.setText(QQPimActivity.this.getResources().getText(2131493462));
          }
        });
        QQPimActivity.access$702(QQPimActivity.this, 0.0F);
      }
    });
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
    this.pbProgress = ((ProgressBar)findViewById(2131165896));
    this.flProgress = ((FrameLayout)findViewById(2131165894));
    this.tvProgress = ((ProgressTextView)findViewById(2131165898));
    this.ivBack = ((FrameLayout)findViewById(2131165892));
    this.tvDownload = ((TextView)findViewById(2131166225));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        QQPimActivity.this.finish();
      }
    });
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166044));
    this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "7.16", "QQ同步助手-微信文件备份", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.qqpim", "https://cftweb.3g.qq.com/privacy/privacyPolicy?content_id=26e57ba2bb972d84e9a8c45ed6f7ad801617788449", this);
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
  
  private void startDownload()
  {
    this.tvDownload.setText(getResources().getText(2131493463).toString());
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
    this.tvDownload.setText(getResources().getText(2131493051));
  }
  
  void checkIfNetworkOKForDownload()
  {
    if (aaj.a())
    {
      if (zz.e().f())
      {
        zz.e().b();
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
    if ((i == 2131166225) || (i == 2131165894))
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
            zx.c(QQPimActivity.this, "com.tencent.qqpim");
          }
        });
        return;
      }
      if (this.isApkDownload)
      {
        zx.a(this, this.filePath);
        return;
      }
      checkIsPermissionOK(new yt()
      {
        public final void a()
        {
          QQPimActivity.this.checkIfNetworkOKForDownload();
        }
        
        public final void b() {}
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296299);
    aaz.a(this, this.mTitleBar, 2130968772);
    initView();
    registReceiver();
    registerInstallReceiver();
    TMSDKContext.saveActionData(170009);
    aad.a("com.tencent.qqpim", new aad.a()
    {
      public final void a(final r paramAnonymousr)
      {
        QQPimActivity.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            QQPimActivity.this.setSoftDetail(paramAnonymousr);
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
      if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) && (QQPimActivity.this.needReportInstall))
      {
        TMSDKContext.saveActionData(170012);
        QQPimActivity.access$402(QQPimActivity.this, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPimActivity
 * JD-Core Version:    0.7.0.1
 */