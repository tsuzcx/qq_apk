package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
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
import com.tencent.token.aap;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;
import com.tencent.token.t;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.zk;
import com.tencent.token.zl;
import com.tencent.token.zm;
import com.tencent.token.zo;
import com.tencent.token.zp;
import com.tencent.token.zr;
import com.tencent.token.zr.a;
import com.tencent.token.zz;
import com.tmsdk.TMSDKContext;
import java.io.File;

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
          if (zz.a())
          {
            if (!zk.g().h()) {
              zk.g().a();
            }
          }
          else if (zk.g().h())
          {
            zk.g().c();
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(8);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493214));
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
    TMSDKContext.saveActionData(170016);
    zk localzk = zk.g();
    zm local4 = new zm()
    {
      public final void a()
      {
        GalleryActivity.access$402(GalleryActivity.this, true);
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493203));
            Toast.makeText(GalleryActivity.this, GalleryActivity.this.getResources().getText(2131493211), 0).show();
            zl.a(GalleryActivity.this, GalleryActivity.this.filePath);
            GalleryActivity.access$602(GalleryActivity.this, true);
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(8);
          }
        });
        GalleryActivity.access$702(GalleryActivity.this, 0.0F);
        TMSDKContext.saveActionData(170017);
      }
      
      public final void a(final float paramAnonymousFloat)
      {
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > GalleryActivity.this.lastProgress))
        {
          GalleryActivity.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              GalleryActivity.this.tvDownload.setVisibility(8);
              GalleryActivity.this.flProgress.setVisibility(0);
              GalleryActivity.this.tvProgress.setTextWhiteLength(paramAnonymousFloat);
              GalleryActivity.this.pbProgress.setProgress((int)(paramAnonymousFloat * 100.0F));
              ProgressTextView localProgressTextView = GalleryActivity.this.tvProgress;
              StringBuilder localStringBuilder = new StringBuilder("下载中...");
              localStringBuilder.append((int)(paramAnonymousFloat * 100.0F));
              localStringBuilder.append("%");
              localProgressTextView.setText(localStringBuilder.toString());
            }
          });
          GalleryActivity.access$702(GalleryActivity.this, paramAnonymousFloat);
        }
      }
      
      public final void b()
      {
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(8);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493210));
          }
        });
      }
      
      public final void c()
      {
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(8);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493214));
          }
        });
        GalleryActivity.access$702(GalleryActivity.this, 0.0F);
      }
    };
    String str2 = null;
    String str1;
    if (TextUtils.isEmpty(null)) {
      str1 = localzk.f();
    } else {
      str1 = null;
    }
    if (TextUtils.isEmpty(null)) {
      str2 = zk.b();
    }
    localzk.a = new zo(new zp("http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0", str1, str2), local4);
    zk.g().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = zk.g().d();
    this.isInstall = zl.b(this, "com.tencent.gallerymanager");
    this.filePath = zk.g().e();
  }
  
  private void initView()
  {
    this.pbProgress = ((ProgressBar)findViewById(2131165549));
    this.flProgress = ((FrameLayout)findViewById(2131165548));
    this.tvProgress = ((ProgressTextView)findViewById(2131165550));
    this.ivBack = ((FrameLayout)findViewById(2131165547));
    this.tvDownload = ((TextView)findViewById(2131166166));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GalleryActivity.this.finish();
      }
    });
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166009));
    this.mAppLayout.a("深圳市腾讯计算机系统有限公司", "4.2.6", "腾讯相册管家", "http://ntool.3g.qq.com/permissionInfo?pkgName=com.tencent.gallerymanager", "https://cftweb.3g.qq.com/privacy/privacyPolicy?content_id=95fb3a1fc2e0d6bda65de66c15606b2b1617954054", this);
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
    RqdApplication.p().registerReceiver(this.mNetworkMsgReceiver, localIntentFilter);
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
    this.tvDownload.setText(getResources().getText(2131493215).toString());
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
    RqdApplication.p().unregisterReceiver(this.mNetworkMsgReceiver);
  }
  
  private void updateBtnState()
  {
    this.tvDownload.setText(getResources().getText(2131493206));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131166166) || (i == 2131165548))
    {
      if (this.isInstall)
      {
        launchGalleryApp(this);
        return;
      }
      if (this.isApkDownload)
      {
        zl.a(this, this.filePath);
        return;
      }
      if (zz.a())
      {
        if (zk.g().h())
        {
          zk.g().c();
          return;
        }
        startDownload();
        return;
      }
      Toast.makeText(this, getResources().getText(2131493212), 0).show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296296);
    aap.a(this, this.mTitleBar, 2130968771);
    initView();
    registReceiver();
    registerInstallReceiver();
    TMSDKContext.saveActionData(170015);
    zr.a("com.tencent.gallerymanager", new zr.a()
    {
      public final void a(final r paramAnonymousr)
      {
        GalleryActivity.this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            GalleryActivity.this.setSoftDetail(paramAnonymousr);
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
    if (this.isNeedLaunch) {
      launchGalleryApp(this);
    }
  }
  
  public class InstallBroadcastReceiver
    extends BroadcastReceiver
  {
    public InstallBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")))
      {
        paramIntent = paramIntent.getData();
        paramContext = null;
        if (paramIntent != null) {
          paramContext = paramIntent.getSchemeSpecificPart();
        }
        if (!"com.tencent.gallerymanager".equals(paramContext)) {
          return;
        }
        GalleryActivity.access$1002(GalleryActivity.this, true);
        new File(GalleryActivity.this.filePath).delete();
        if (GalleryActivity.this.needReportInstall)
        {
          TMSDKContext.saveActionData(170018);
          GalleryActivity.access$402(GalleryActivity.this, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.GalleryActivity
 * JD-Core Version:    0.7.0.1
 */