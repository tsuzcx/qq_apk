package com.tencent.biz.qqcircle.manager;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.PathInterpolator;
import pbv;

public class QCircleFuelAnimationManager$4
  implements Runnable
{
  public QCircleFuelAnimationManager$4(pbv parampbv, View paramView) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nQ, "scaleX", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.nQ, "scaleY", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.4
 * JD-Core Version:    0.7.0.1
 */