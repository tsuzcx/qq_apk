package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cw;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.qqpim.ProgressTextView;
import com.tencent.token.upload.i;
import com.tencent.token.utils.m;
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
  private ImageView ivBack;
  private float lastProgress = 0.0F;
  private BroadcastReceiver mNetworkMsgReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext != null)
      {
        if (!paramAnonymousContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          break label100;
        }
        if (!i.a()) {
          break label40;
        }
        if (!a.f().g()) {
          a.f().a();
        }
      }
      label40:
      label100:
      while (!paramAnonymousContext.equals("noConnectivity"))
      {
        do
        {
          return;
        } while (!a.f().g());
        a.f().c();
        GalleryActivity.this.tvDownload.setVisibility(0);
        GalleryActivity.this.flProgress.setVisibility(4);
        GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131231071));
        return;
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
    a.f().a(new cw()
    {
      public void a()
      {
        GalleryActivity.access$202(GalleryActivity.this, true);
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131231060));
            Toast.makeText(GalleryActivity.this, GalleryActivity.this.getResources().getText(2131231068), 0).show();
            com.tencent.token.ui.qqpim.a.a(GalleryActivity.this, GalleryActivity.this.filePath);
            GalleryActivity.access$402(GalleryActivity.this, true);
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(4);
          }
        });
        GalleryActivity.access$502(GalleryActivity.this, 0.0F);
        TMSDKContext.saveActionData(170017);
        Log.i("GalleryActivity", "onFinished: ");
      }
      
      public void a(final float paramAnonymousFloat)
      {
        Log.i("GalleryActivity", "onProgress: " + paramAnonymousFloat);
        if ((paramAnonymousFloat > 0.01D) && (paramAnonymousFloat <= 1.0F) && (paramAnonymousFloat > GalleryActivity.this.lastProgress))
        {
          GalleryActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              GalleryActivity.this.tvDownload.setVisibility(4);
              GalleryActivity.this.flProgress.setVisibility(0);
              GalleryActivity.this.tvProgress.setTextWhiteLength(paramAnonymousFloat);
              GalleryActivity.this.pbProgress.setProgress((int)(paramAnonymousFloat * 100.0F));
              GalleryActivity.this.tvProgress.setText("下载中..." + (int)(paramAnonymousFloat * 100.0F) + "%");
            }
          });
          GalleryActivity.access$502(GalleryActivity.this, paramAnonymousFloat);
        }
      }
      
      public void b()
      {
        Log.i("GalleryActivity", "onPause: ");
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(4);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131231067));
          }
        });
      }
      
      public void c()
      {
        GalleryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            GalleryActivity.this.tvDownload.setVisibility(0);
            GalleryActivity.this.flProgress.setVisibility(4);
            GalleryActivity.this.tvDownload.setText(GalleryActivity.this.getResources().getText(2131231071));
          }
        });
        Log.i("GalleryActivity", "onCancel: ");
        GalleryActivity.access$502(GalleryActivity.this, 0.0F);
      }
    });
    a.f().a();
  }
  
  private void initStatus()
  {
    this.isApkDownload = a.f().d();
    this.isInstall = com.tencent.token.ui.qqpim.a.b(this, "com.tencent.gallerymanager");
    this.filePath = a.f().e();
  }
  
  private void initView()
  {
    this.pbProgress = ((ProgressBar)findViewById(2131558688));
    this.flProgress = ((FrameLayout)findViewById(2131558687));
    this.tvProgress = ((ProgressTextView)findViewById(2131558689));
    this.ivBack = ((ImageView)findViewById(2131558681));
    this.tvDownload = ((TextView)findViewById(2131558686));
    this.tvDownload.setOnClickListener(this);
    this.flProgress.setOnClickListener(this);
    this.ivBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        GalleryActivity.this.finish();
      }
    });
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
    if ((i == 2131558686) || (i == 2131558687))
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
    if (i.a())
    {
      if (a.f().g())
      {
        a.f().c();
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
    m.a(this, this.mTitleBar, 2131493037);
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
        if ("com.tencent.gallerymanager".equals(paramContext)) {
          break label45;
        }
      }
      label45:
      do
      {
        return;
        GalleryActivity.access$802(GalleryActivity.this, true);
        new File(GalleryActivity.this.filePath).delete();
      } while (!GalleryActivity.this.needReportInstall);
      TMSDKContext.saveActionData(170018);
      GalleryActivity.access$202(GalleryActivity.this, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.GalleryActivity
 * JD-Core Version:    0.7.0.1
 */