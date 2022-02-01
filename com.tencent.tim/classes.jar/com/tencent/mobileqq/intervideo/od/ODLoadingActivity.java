package com.tencent.mobileqq.intervideo.od;

import acfp;
import acmo;
import aids;
import aidx;
import aigs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import arhz;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

public class ODLoadingActivity
  extends Activity
{
  private FrameLayout K;
  private aidx b;
  private IVPluginDataReporter c = new IVPluginDataReporter();
  private boolean ckm;
  private arhz m;
  private boolean mClosed;
  private Handler mHandler;
  private View mLoadingView;
  
  private void Sa()
  {
    if (this.m == null)
    {
      this.m = new arhz(this, 40);
      this.m.setMessage(acfp.m(2131709353));
    }
    this.m.show();
  }
  
  private void bpm()
  {
    this.mClosed = true;
    if (this.m != null) {
      this.m.dismiss();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
    if (!this.ckm)
    {
      this.c.opType("onBackPressed").report();
      aids.report("33669910");
      IVCommonInterfaceImpl.getInstance().onHostActivityBackPress();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getBooleanExtra("show_status_bar", false)) {
      setTheme(16973840);
    }
    super.onCreate(paramBundle);
    this.ckm = getIntent().getBooleanExtra("is_start_huiyin", false);
    if (this.ckm)
    {
      this.b = new aidx(this);
      this.b.onCreate(paramBundle);
      return;
    }
    paramBundle = new Bundle(getIntent().getExtras());
    String str = paramBundle.getString("fromId");
    long l = 0L;
    if (str != null) {}
    try
    {
      l = Long.parseLong(str);
      for (;;)
      {
        str = paramBundle.getString("bizType");
        paramBundle.putString("qqVersion", "3.4.4");
        paramBundle.putBoolean("isGooglePlayVersion", false);
        this.c.opDepartment("shadow").opName(str).d1(String.valueOf(l));
        this.c.opType("enterLoading").report();
        aids.report("33669907");
        this.K = new FrameLayout(this);
        this.K.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.K);
        findViewById(16908290).setVisibility(8);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHandler.postDelayed(new ODLoadingActivity.1(this), 1000L);
        ExecutorService localExecutorService = acmo.a(192);
        localExecutorService.submit(new ODLoadingActivity.3(this, localExecutorService.submit(new aigs(this, str)), l, paramBundle));
        return;
        QLog.e("ODLoadingActivity", 2, "not have fromId");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ODLoadingActivity", 2, "fromId not long");
        l = 0L;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.ckm) {
      this.b.onDestroy();
    }
    for (;;)
    {
      IVCommonInterfaceImpl.getInstance().onHostActivityDestroy();
      return;
      if (this.mLoadingView != null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mParent");
        localField.setAccessible(true);
        localField.set(this.mLoadingView, null);
        label55:
        bpm();
      }
      catch (Throwable localThrowable)
      {
        break label55;
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    IVCommonInterfaceImpl.getInstance().onHostActivityPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    IVCommonInterfaceImpl.getInstance().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    IVCommonInterfaceImpl.getInstance().onHostActivityResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    IVCommonInterfaceImpl.getInstance().onHostActivityStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity
 * JD-Core Version:    0.7.0.1
 */