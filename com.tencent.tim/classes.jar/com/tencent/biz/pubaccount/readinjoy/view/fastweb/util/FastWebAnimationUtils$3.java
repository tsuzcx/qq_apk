package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import nms;

public final class FastWebAnimationUtils$3
  implements Runnable
{
  public FastWebAnimationUtils$3(Activity paramActivity, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)AnimationUtils.loadAnimation(this.val$activity.getApplicationContext(), 2130772256);
    localAlphaAnimation.setAnimationListener(new nms(this));
    this.ty.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.3
 * JD-Core Version:    0.7.0.1
 */