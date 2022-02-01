package com.tencent.biz.qqstory.takevideo;

import acbn;
import acfp;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import pmi;
import qwp;
import qyk.b;
import ram;
import rev;
import rpq;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
  implements Handler.Callback
{
  public static boolean aHw;
  public static final String azX = acbn.bmi + "qqstory/animation_cover.jpg";
  protected a a;
  private Handler mHandler;
  protected ImageView mImageView;
  private float mM;
  private float mN;
  private float mO;
  private float mP;
  
  @TargetApi(14)
  public void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { acfp.m(2131712455), Float.valueOf(paramFloat1), ",bottom:", Float.valueOf(paramFloat4) });
    this.mHandler.removeMessages(1);
    float f3 = rpq.getWindowScreenHeight(this);
    float f4 = rpq.getWindowScreenWidth(this);
    float f1 = (paramFloat4 - paramFloat1) / f3;
    float f2 = (paramFloat3 - paramFloat2) / f4;
    paramFloat3 = (paramFloat3 - paramFloat2) / 2.0F;
    f4 /= 2.0F;
    paramFloat4 = (paramFloat4 - paramFloat1) / 2.0F;
    f3 /= 2.0F;
    ViewPropertyAnimator localViewPropertyAnimator = this.mImageView.animate().setDuration(250L).scaleXBy(1.0F).scaleX(f2).scaleYBy(1.0F).scaleY(f1).x(paramFloat3 + paramFloat2 - f4).y(paramFloat4 + paramFloat1 - f3);
    localViewPropertyAnimator.setListener(new rev(this));
    localViewPropertyAnimator.start();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    aHw = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.mHandler = new Handler(this);
    super.doOnCreate(paramBundle);
    this.mImageView = new AutoPlayImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.mImageView);
    paramBundle = getIntent();
    String str = paramBundle.getStringExtra("path");
    this.mM = paramBundle.getIntExtra("target_top", 0);
    this.mN = paramBundle.getIntExtra("target_right", 0);
    this.mO = paramBundle.getIntExtra("target_left", 0);
    this.mP = paramBundle.getIntExtra("target_bottom", 0);
    ram.d("Q.qqstory.home:FeedSegment_animation", "动画activity终于 OnCreate 了！！！");
    this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.a = new a(this);
    pmi.a().registerSubscriber(this.a);
    try
    {
      paramBundle = BitmapFactory.decodeFile(str);
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      paramBundle = paramBundle.copy(Bitmap.Config.ARGB_8888, true);
      if (paramBundle == null)
      {
        finish();
        return false;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(1, 3000L);
      return false;
      this.mImageView.setImageBitmap(paramBundle);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    aHw = false;
    if (this.a != null) {
      pmi.a().unRegisterSubscriber(this.a);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.mHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ram.d("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", "动画等超时了");
      c(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public static class a
    extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, qyk.b>
  {
    public a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull qyk.b paramb)
    {
      if (paramb != null) {
        paramQQStoryTakeVideoCloseAnimationActivity.c(paramb.top, paramb.left, paramb.right, paramb.bottom);
      }
    }
    
    public Class acceptEventClass()
    {
      return qyk.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */