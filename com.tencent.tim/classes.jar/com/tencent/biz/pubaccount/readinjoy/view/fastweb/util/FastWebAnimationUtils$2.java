package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import nmr;

public final class FastWebAnimationUtils$2
  implements Runnable
{
  public FastWebAnimationUtils$2(TextView paramTextView, Activity paramActivity) {}
  
  public void run()
  {
    if (this.ty.getX() == 0.0F)
    {
      this.ty.post(new FastWebAnimationUtils.2.1(this));
      return;
    }
    AnimationSet localAnimationSet = nmr.b(this.ty, this.val$activity.getApplicationContext());
    this.ty.setVisibility(0);
    this.ty.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */