package com.tencent.mobileqq.activity.aio.photo;

import aeee;
import alyn;
import alyp;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import anot;
import arlc;
import axol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import ivv;
import skj;
import sxi;
import sxm;
import sxn;
import sxz;
import xsd;
import xse;
import xsk;
import xtj;
import xto;
import xtp;
import xuh;
import xuh.a;
import xui;

public class AIOGalleryActivity
  extends PeakActivity
{
  BroadcastReceiver A = null;
  public long Jt = -1L;
  alyn jdField_a_of_type_Alyn;
  alyp jdField_a_of_type_Alyp;
  sxz jdField_a_of_type_Sxz = new a();
  xuh jdField_a_of_type_Xuh;
  int bWG;
  int bWH = 1;
  public boolean biA = false;
  boolean bix = false;
  public boolean biy;
  public boolean biz = true;
  private skj mClient;
  BroadcastReceiver mReceiver = null;
  public String troopUin;
  
  public alyn a()
  {
    if (this.jdField_a_of_type_Alyn == null) {
      this.jdField_a_of_type_Alyn = new alyn(this);
    }
    return this.jdField_a_of_type_Alyn;
  }
  
  public alyp a()
  {
    if (this.jdField_a_of_type_Alyp == null) {
      this.jdField_a_of_type_Alyp = new alyp(this);
    }
    return this.jdField_a_of_type_Alyp;
  }
  
  public void finish()
  {
    sxi localsxi = this.jdField_a_of_type_Sxz.a();
    if (xsk.class.isInstance(localsxi)) {
      ((xsk)localsxi).onFinish();
    }
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Sxz.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_Sxz.onBackEvent()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_Sxz.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.mClient = skj.a();
    this.mClient.bzj();
    xsa.density = getResources().getDisplayMetrics().density;
    ShortVideoUtils.B(axol.getAppInterface());
    this.jdField_a_of_type_Alyn = new alyn(this);
    this.jdField_a_of_type_Alyp = new alyp(this);
    paramBundle = getIntent().getExtras();
    this.troopUin = paramBundle.getString("extra.GROUP_UIN");
    this.biy = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_Sxz.onCreate(this);
      this.A = new xsd(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        try
        {
          registerReceiver(this.A, paramBundle);
          return;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        paramBundle = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, "", paramBundle);
        }
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onDestroy()");
    }
    super.onDestroy();
    this.jdField_a_of_type_Sxz.onDestroy(this);
    if (this.jdField_a_of_type_Xuh != null) {}
    try
    {
      if ((!this.biy) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_Xuh.destory();
      }
      for (;;)
      {
        label62:
        if (this.A != null)
        {
          unregisterReceiver(this.A);
          this.A = null;
        }
        if (this.jdField_a_of_type_Alyn != null)
        {
          this.jdField_a_of_type_Alyn.exit(this.bWG);
          this.jdField_a_of_type_Alyn.dLB();
        }
        if (this.jdField_a_of_type_Alyp != null) {
          this.jdField_a_of_type_Alyp.exit();
        }
        this.mClient.bzk();
        return;
        this.jdField_a_of_type_Xuh.unregisterCallback();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Sxz.onKeyDown(paramInt, paramKeyEvent)) {
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
      this.jdField_a_of_type_Sxz.onPause();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, localException.getMessage());
        }
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
      this.mReceiver = new b(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.mReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_Sxz.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onStop()");
    }
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Sxz.bh(this);
    }
  }
  
  public class a
    extends sxz
  {
    xui a;
    
    a()
    {
      this.jdField_a_of_type_Xui = new xse(this);
    }
    
    public boolean Ny()
    {
      return true;
    }
    
    public sxi a(Activity paramActivity, sxm paramsxm)
    {
      return new xtj(paramActivity, paramsxm, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
    }
    
    public sxm a(Activity paramActivity)
    {
      return new xto(true);
    }
    
    public sxn a(Activity paramActivity, sxm paramsxm)
    {
      xto localxto = (xto)paramsxm;
      localxto.bjk = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
      if (localxto.bjk) {
        anot.a(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.troopUin, "", "", "");
      }
      localxto.Dw(4);
      localxto.ceL();
      return new xtp(paramActivity, paramsxm, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
    }
    
    public void onCreate(Activity paramActivity)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a == null)
      {
        BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
        if (localBinderWarpper == null) {
          break label160;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a = xuh.a.a(localBinderWarpper.binder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a.a(this.jdField_a_of_type_Xui);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a);
        }
      }
      boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
      super.onCreate(paramActivity);
      if (bool)
      {
        this.aOd = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
        super.bBV();
        if ((this.jdField_b_of_type_Sxn != null) && ((this.jdField_b_of_type_Sxn instanceof xtp))) {
          ((xtp)this.jdField_b_of_type_Sxn).ceN();
        }
      }
      return;
      label160:
      throw new IllegalArgumentException("can't find Binder in Intent..");
    }
  }
  
  static class b
    extends BroadcastReceiver
  {
    boolean biC = true;
    Activity mActivity;
    
    b(Activity paramActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */