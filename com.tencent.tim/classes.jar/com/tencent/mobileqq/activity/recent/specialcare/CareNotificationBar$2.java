package com.tencent.mobileqq.activity.recent.specialcare;

import aamm;
import aamn;
import aamo;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

public class CareNotificationBar$2
  implements Runnable
{
  public CareNotificationBar$2(aamm paramaamm, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofInt(this.val$view, "backgroundColor", new int[] { this.chL, this.chM });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setEvaluator(new ArgbEvaluator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(this.val$view, "backgroundColor", new int[] { this.chM, this.chL });
    localObjectAnimator2.setDuration(300L);
    localObjectAnimator2.setEvaluator(new ArgbEvaluator());
    localObjectAnimator1.addListener(new aamn(this, localObjectAnimator2));
    localObjectAnimator2.addListener(new aamo(this));
    localObjectAnimator1.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */