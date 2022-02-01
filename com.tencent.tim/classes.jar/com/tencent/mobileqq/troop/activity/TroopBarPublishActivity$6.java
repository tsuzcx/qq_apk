package com.tencent.mobileqq.troop.activity;

import android.view.animation.DecelerateInterpolator;
import aovi;
import com.nineoldandroids.animation.ObjectAnimator;

public class TroopBarPublishActivity$6
  implements Runnable
{
  TroopBarPublishActivity$6(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.this$0.a, "scrollY", new int[] { this.dRT }).setDuration(this.val$duration);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.addListener(new aovi(this));
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.6
 * JD-Core Version:    0.7.0.1
 */