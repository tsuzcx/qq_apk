package com.tencent.biz.qqcircle.manager;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import aqnm;
import pbv;
import pbw;

public class QCircleFuelAnimationManager$3
  implements Runnable
{
  public QCircleFuelAnimationManager$3(pbv parampbv, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public void run()
  {
    this.ma.setVisibility(8);
    this.ma.setImageDrawable(null);
    this.mb.setVisibility(0);
    Object localObject1 = new PointF(this.mb.getX(), this.mb.getY() - aqnm.dip2px(5.0F));
    Object localObject2 = new PointF(this.mb.getX() + aqnm.dip2px(145.0F), this.mb.getY() - aqnm.dip2px(95.0F));
    localObject2 = pbv.a(this.this$0, this.mb, (PointF)localObject1, (PointF)localObject2, new PointF(0.19F * (((PointF)localObject2).x - ((PointF)localObject1).x) + ((PointF)localObject1).x, 1.14F * (((PointF)localObject2).y - ((PointF)localObject1).y) + ((PointF)localObject1).y), new PointF(0.91F * (((PointF)localObject2).x - ((PointF)localObject1).x) + ((PointF)localObject1).x, 1.16F * (((PointF)localObject2).y - ((PointF)localObject1).y) + ((PointF)localObject1).y), 420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ValueAnimator)localObject2).setInterpolator(new PathInterpolator(0.16F, 0.0F, 0.0F, 1.0F));
    }
    ((ValueAnimator)localObject2).start();
    ((ValueAnimator)localObject2).addListener(new pbw(this, (PointF)localObject1));
    localObject1 = ObjectAnimator.ofFloat(this.mb, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ObjectAnimator)localObject1).setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObject2 = ObjectAnimator.ofFloat(this.mb, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ObjectAnimator)localObject2).setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mb, "alpha", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    ((ObjectAnimator)localObject1).start();
    ((ObjectAnimator)localObject2).start();
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.3
 * JD-Core Version:    0.7.0.1
 */