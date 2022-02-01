package com.tencent.biz.qqcircle.manager;

import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import pbv;

public class QCircleFuelAnimationManager$1
  implements Runnable
{
  public QCircleFuelAnimationManager$1(pbv parampbv, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    this.val$textView.setVisibility(0);
    this.val$imageView.setVisibility(0);
    ObjectAnimator.ofFloat(this.val$imageView, "scaleX", new float[] { 1.0F, 1.4F, 1.0F, 0.8F, 1.2F, 1.0F }).setDuration(400L).start();
    ObjectAnimator.ofFloat(this.val$imageView, "scaleY", new float[] { 1.0F, 1.4F, 1.0F, 0.8F, 1.2F, 1.0F }).setDuration(400L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */