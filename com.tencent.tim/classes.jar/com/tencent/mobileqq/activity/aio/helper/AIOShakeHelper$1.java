package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import wun;
import wuo;
import wup;

public class AIOShakeHelper$1
  implements Runnable
{
  public AIOShakeHelper$1(wun paramwun, Activity paramActivity) {}
  
  public void run()
  {
    wun.a(this.this$0, new View(this.C));
    wun.a(this.this$0).setOnTouchListener(new wuo(this));
    this.C.addContentView(wun.a(this.this$0), new ViewGroup.LayoutParams(-1, -1));
    View localView = ((ViewGroup)this.C.getWindow().getDecorView()).getChildAt(0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 0L;
    long[] arrayOfLong = new long[6];
    long[] tmp99_97 = arrayOfLong;
    tmp99_97[0] = 200L;
    long[] tmp105_99 = tmp99_97;
    tmp105_99[1] = 300L;
    long[] tmp111_105 = tmp105_99;
    tmp111_105[2] = 200L;
    long[] tmp117_111 = tmp111_105;
    tmp117_111[3] = 300L;
    long[] tmp123_117 = tmp117_111;
    tmp123_117[4] = 200L;
    long[] tmp129_123 = tmp123_117;
    tmp129_123[5] = 300L;
    tmp129_123;
    int i = 0;
    while (i < arrayOfLong.length)
    {
      if (i % 2 != 0)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 10.0F);
        localTranslateAnimation.setDuration(arrayOfLong[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new CycleInterpolator((float)localTranslateAnimation.getDuration() / 60.0F));
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfLong[i];
      i += 1;
    }
    localAnimationSet.setAnimationListener(new wup(this));
    localView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1
 * JD-Core Version:    0.7.0.1
 */