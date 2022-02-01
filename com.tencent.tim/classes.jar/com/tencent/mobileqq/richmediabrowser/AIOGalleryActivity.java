package com.tencent.mobileqq.richmediabrowser;

import aeee;
import amcb;
import amcd;
import amce;
import amcf;
import amcg;
import amcj;
import amcl;
import amcm;
import amcv;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import arlc;
import axol;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.util.BinderWarpper;
import ivv;
import skj;
import xuh;
import xuh.a;
import xui;

public class AIOGalleryActivity
  extends PeakActivity
{
  BroadcastReceiver A = null;
  private amcd jdField_a_of_type_Amcd;
  xuh jdField_a_of_type_Xuh;
  xui jdField_a_of_type_Xui = new amcg(this);
  private volatile boolean aJE;
  private amcv b;
  private skj mClient;
  BroadcastReceiver mReceiver = null;
  public String troopUin;
  
  private void dMl()
  {
    if (this.jdField_a_of_type_Xuh == null)
    {
      Object localObject = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject == null) {
        break label157;
      }
      this.jdField_a_of_type_Xuh = xuh.a.a(((BinderWarpper)localObject).binder);
      this.jdField_a_of_type_Xuh.a(this.jdField_a_of_type_Xui);
      if (this.b != null)
      {
        this.b.a(this.jdField_a_of_type_Xuh);
        localObject = new amcl();
        ((amcl)localObject).a(this.jdField_a_of_type_Xuh);
        RichMediaBrowserManager.getInstance().setProvider((IProvider)localObject);
        if ((this.jdField_a_of_type_Xuh != null) && (!amcj.a().avD())) {
          this.jdField_a_of_type_Xuh.loadMedias(amcj.a().IA());
        }
      }
    }
    for (;;)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "IAIOImageProvider is " + this.jdField_a_of_type_Xuh);
      return;
      label157:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "binder is null!");
      finish();
    }
  }
  
  private void dm(Bundle paramBundle)
  {
    dMl();
    initReceiver();
  }
  
  private void initReceiver()
  {
    this.A = new amcf(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      if (!this.aJE)
      {
        this.aJE = true;
        registerReceiver(this.A, localIntentFilter);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Amcd.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Amcd.onBackEvent()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Amcd.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    ayxa.initLiuHaiProperty(this);
    ayxa.enableNotch(this);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    this.mClient = skj.a();
    this.mClient.bzj();
    xsa.density = getResources().getDisplayMetrics().density;
    ShortVideoUtils.B(axol.getAppInterface());
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.troopUin = localBundle.getString("extra.GROUP_UIN");
    }
    try
    {
      RichMediaBrowserManager.getInstance().setLogProxy(new amcm());
      RichMediaBrowserManager.getInstance().setMvpFactory(new amce());
      Rect localRect = (Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND");
      amcj.a().n(localRect);
      amcb localamcb = new amcb();
      localamcb.bn = localRect;
      RichMediaBrowserManager.getInstance().setAnimationListener(localamcb);
      amcj.a().D(paramBundle);
      this.jdField_a_of_type_Amcd = new amcd(this);
      new BrowserDirector(this.jdField_a_of_type_Amcd).construct(paramBundle);
      this.b = this.jdField_a_of_type_Amcd.a();
      dm(localBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onCreate exception = " + paramBundle.getMessage());
      finish();
    }
  }
  
  public void onDestroy()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onDestroy()");
    super.onDestroy();
    if (this.jdField_a_of_type_Amcd != null) {
      this.jdField_a_of_type_Amcd.onDestroy();
    }
    if (this.jdField_a_of_type_Xuh != null) {}
    try
    {
      if ((!getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false)))
      {
        this.jdField_a_of_type_Xuh.unregisterCallback();
        this.jdField_a_of_type_Xuh.destory();
        this.jdField_a_of_type_Xui = null;
      }
      for (;;)
      {
        if ((this.A != null) && (this.aJE))
        {
          unregisterReceiver(this.A);
          this.A = null;
        }
        this.mClient.bzk();
        return;
        this.jdField_a_of_type_Xuh.unregisterCallback();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onDestroy() exception = " + localException.getMessage());
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Amcd.onKeyDown(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    ivv.o(BaseApplicationImpl.getContext(), false);
    arlc.b(BaseApplicationImpl.getContext(), true, 52);
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.mReceiver != null)) {}
    try
    {
      unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Amcd.onPause();
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("AIOGalleryActivity", 1, "mainBrowserBuilder.onPause() exception: " + localException2);
        }
        localException1 = localException1;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onPause exception = " + localException1.getMessage());
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ivv.o(BaseApplicationImpl.getContext(), true);
    arlc.b(BaseApplicationImpl.getContext(), false, 52);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.mReceiver = new a(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.mReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Amcd.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Amcd.onStart();
  }
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "onStop()");
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Amcd.onWindowFocusChanged();
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    boolean biC = true;
    Activity mActivity;
    
    a(Activity paramActivity)
    {
      this.mActivity = paramActivity;
    }
    
    public boolean aN(Context paramContext)
    {
      return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = true;
      paramIntent = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
        if (!aN(paramContext)) {
          this.biC = bool;
        }
      }
      for (;;)
      {
        if (!this.biC)
        {
          this.mActivity.unregisterReceiver(this);
          this.mActivity.finish();
        }
        return;
        bool = false;
        break;
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent)) {
          this.biC = false;
        } else if ("android.intent.action.USER_PRESENT".equals(paramIntent)) {
          this.biC = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */