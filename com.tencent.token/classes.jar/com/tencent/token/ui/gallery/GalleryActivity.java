package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.token.aaa;
import com.tencent.token.aab;
import com.tencent.token.aad;
import com.tencent.token.aad.a;
import com.tencent.token.aaj;
import com.tencent.token.aaz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;
import com.tencent.token.t;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo;
import com.tencent.token.yt;
import com.tencent.token.zw;
import com.tencent.token.zx;
import com.tencent.token.zy;
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
          if (aaj.a())
          {
            if (!zw.g().h()) {
              zw.g().a();
            }
          }
          else if (zw.g().h())
          {
            zw.g().c();
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(8);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493216));
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
    zw localzw = zw.g();
    zy local4 = new zy()
    {
      public final void a()
      {
        GalleryActivity.access$402(GalleryActivity.this, true);
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493205));
            Toast.makeText(GalleryActivity.this, GalleryActivity.this.getResources().getText(2131493213), 0).show();
            zx.a(GalleryActivity.this, GalleryActivity.this.filePath);
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
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493212));
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
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131493216));
          }
        });
        GalleryActivity.access$702(GalleryActivity.this, 0.0F);
      }
    };
    String str2 = null;
    String str1;
    if (TextUtils.isEmpty(null)) {
      str1 = localzw.f();
    } else {
      str1 = null;
    }
    if (TextUtils.isEmpty(null)) {
      str2 = zw.b();
    }
    localzw.a = new aaa(new aab("http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0", str1, str2), local4);
    zw.g().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = zw.g().d();
    this.isInstall = zx.b(this, "com.tencent.gallerymanager");
    this.filePath = zw.g().e();
  }
  
  private void initView()
  {
    this.pbProgress = ((ProgressBar)findViewById(2131165564));
    this.flProgress = ((FrameLayout)findViewById(2131165563));
    this.tvProgress = ((ProgressTextView)findViewById(2131165565));
    this.ivBack = ((FrameLayout)findViewById(2131165562));
    this.tvDownload = ((TextView)findViewById(2131166206));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GalleryActivity.this.finish();
      }
    });
    this.mAppLayout = ((LayoutAppKeyInfo)findViewById(2131166044));
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
    this.tvDownload.setText(getResources().getText(2131493217).toString());
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
    this.tvDownload.setText(getResources().getText(2131493208));
  }
  
  void checkNetworkIfOKDownload()
  {
    if (aaj.a())
    {
      if (zw.g().h())
      {
        zw.g().c();
        return;
      }
      startDownload();
      return;
    }
    Toast.makeText(this, getResources().getText(2131493214), 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131166206) || (i == 2131165563))
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
            paramAnonymousDialogInterface = GalleryActivity.this;
            paramAnonymousDialogInterface.launchGalleryApp(paramAnonymousDialogInterface);
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
          GalleryActivity.this.checkNetworkIfOKDownload();
        }
        
        public final void b() {}
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296297);
    aaz.a(this, this.mTitleBar, 2130968772);
    initView();
    registReceiver();
    registerInstallReceiver();
    TMSDKContext.saveActionData(170015);
    aad.a("com.tencent.gallerymanager", new aad.a()
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
        GalleryActivity.access$1102(GalleryActivity.this, true);
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