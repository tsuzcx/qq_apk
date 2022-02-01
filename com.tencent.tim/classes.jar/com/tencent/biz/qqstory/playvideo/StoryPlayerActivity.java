package com.tencent.biz.qqstory.playvideo;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import ayxa;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Event;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import pmi;
import qfs;
import qfu;
import qfz;
import qfz.b;
import qii;
import qvf;
import ram;
import rar;

public class StoryPlayerActivity
  extends FragmentActivity
  implements IEventReceiver, qfz.b
{
  public static int blW;
  private static int blX;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private b jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$b = new b(this);
  public AnimationParam a;
  protected qfz a;
  public boolean aDg;
  protected AnimationParam b;
  protected Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.jdField_a_of_type_Qfz = new qfz();
    this.jdField_a_of_type_Qfz.a(this);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Qfz.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    blX += 1;
    ram.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate, instance count = %d", Integer.valueOf(blX));
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    ayxa.initLiuHaiProperty(this);
    if (ayxa.needCloseFullScreen())
    {
      getWindow().clearFlags(1024);
      getWindow().addFlags(2048);
    }
    this.isClearCoverLayer = true;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131714966), 0).show();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getIntent().getParcelableExtra("AnimationParam"));
    ram.d("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate = > StoryPlayerActivity doOnCreate");
    setContentView(2131561926);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_Qfz.a(paramBundle, getIntent().getExtras());
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) && (!this.aDg))
    {
      this.aDg = true;
      paramBundle = findViewById(16908290);
      paramBundle.getViewTreeObserver().addOnPreDrawListener(new qfs(this, paramBundle));
    }
    pmi.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$b);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    blX -= 1;
    ram.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnDestroy, instance count = %d", Integer.valueOf(blX));
    this.jdField_a_of_type_Qfz.onDestroy();
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$b);
    qvf.brf();
    if (blX == 0) {
      this.mUiHandler.post(new StoryPlayerActivity.2(this));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Qfz.onPause();
    rar.R(2, this.currentActivityStayTime);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Qfz.onResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Qfz.onStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Qfz.onStop();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void finish()
  {
    boolean bool;
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null)
    {
      bool = true;
      ram.b("Q.qqstory.playernew.StoryPlayerActivity", "finish with animation = %s", Boolean.valueOf(bool));
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
        break label94;
      }
      if (!this.aDg)
      {
        this.aDg = true;
        this.jdField_a_of_type_Qfz.bog();
        localViewGroup = (ViewGroup)getRootView();
        if (this.b == null) {
          break label86;
        }
      }
    }
    label86:
    for (AnimationParam localAnimationParam = this.b;; localAnimationParam = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam)
    {
      qii.a(localViewGroup, localAnimationParam, new qfu(this));
      return;
      bool = false;
      break;
    }
    label94:
    this.jdField_a_of_type_Qfz.bog();
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
  
  @NonNull
  public Context getContext()
  {
    return this;
  }
  
  @NonNull
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Qfz.Js()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setImmersiveStatus()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167595);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        this.mSystemBarComp.setStatusDrawable(null);
      }
      if (!isInMultiWindow()) {
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
      }
    }
  }
  
  public static class a
    implements Dispatcher.Event
  {
    public final AnimationParam c;
    public final String vid;
    
    public a(AnimationParam paramAnimationParam, String paramString)
    {
      this.c = paramAnimationParam;
      this.vid = paramString;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<StoryPlayerActivity, StoryPlayerActivity.a>
  {
    public b(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
    {
      super();
    }
    
    public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull StoryPlayerActivity.a parama)
    {
      paramStoryPlayerActivity.b = parama.c;
    }
    
    public Class acceptEventClass()
    {
      return StoryPlayerActivity.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity
 * JD-Core Version:    0.7.0.1
 */