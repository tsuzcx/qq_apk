package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import apvc;
import apvd;
import apve;

public class RedDotAnimateView
  extends View
{
  public float Ay;
  public float Az;
  ValueAnimator aM;
  ValueAnimator aN;
  ValueAnimator aO;
  Paint cp;
  Paint cq;
  public int dXc = 76;
  int dXd = 255;
  int viewHeight;
  public int viewWidth;
  AnimatorSet z;
  
  public RedDotAnimateView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RedDotAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  void init()
  {
    this.cp = new Paint();
    this.cp.setAntiAlias(true);
    this.cp.setColor(Color.rgb(241, 54, 27));
    this.cp.setStyle(Paint.Style.FILL);
    this.cq = new Paint();
    this.cq.setAntiAlias(true);
    this.cq.setColor(Color.rgb(241, 54, 27));
    this.cq.setStyle(Paint.Style.FILL);
    this.aO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3333333F, 1.9F), Keyframe.ofFloat(0.5F, 0.58F), Keyframe.ofFloat(0.6666667F, 1.25F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.aO.setDuration(1600L);
    this.aO.setInterpolator(new AccelerateDecelerateInterpolator());
    this.aO.addUpdateListener(new apvc(this));
    this.aM = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 0.0F), Keyframe.ofFloat(0.3333333F, 3.0F), Keyframe.ofFloat(0.5F, 1.4F), Keyframe.ofFloat(0.6666667F, 2.08F), Keyframe.ofFloat(1.0F, 2.08F) }) });
    this.aM.setDuration(1600L);
    this.aM.setInterpolator(new AccelerateDecelerateInterpolator());
    this.aM.addUpdateListener(new apvd(this));
    this.aN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.3F), Keyframe.ofFloat(0.1333333F, 0.3F), Keyframe.ofFloat(0.3333333F, 0.3F), Keyframe.ofFloat(0.5F, 0.3F), Keyframe.ofFloat(0.6666667F, 0.3F), Keyframe.ofFloat(1.0F, 0.0F) }) });
    this.aN.setDuration(1600L);
    this.aN.setInterpolator(new LinearInterpolator());
    this.aN.addUpdateListener(new apve(this));
    this.z = new AnimatorSet();
    this.z.setDuration(1600L);
    this.z.playTogether(new Animator[] { this.aO, this.aM, this.aN });
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.viewHeight == 0) {
      this.viewHeight = getHeight();
    }
    if (this.viewWidth == 0) {
      this.viewWidth = getWidth();
    }
    this.cp.setAlpha(this.dXd);
    paramCanvas.drawCircle(this.viewWidth / 2, this.viewHeight / 2, this.Az, this.cp);
    this.cq.setAlpha(this.dXc);
    paramCanvas.drawCircle(this.viewWidth / 2, this.viewHeight / 2, this.Ay, this.cq);
  }
  
  public void setStaticRedDot(int paramInt1, int paramInt2)
  {
    this.viewWidth = paramInt1;
    this.viewHeight = paramInt2;
    this.dXc = 0;
    this.Az = (this.viewWidth / 2);
    invalidate();
  }
  
  public void setVisibleAndZeroRadius()
  {
    this.Ay = 0.0F;
    this.Az = 0.0F;
    setVisibility(0);
  }
  
  public void startAnimation()
  {
    this.z.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotAnimateView
 * JD-Core Version:    0.7.0.1
 */