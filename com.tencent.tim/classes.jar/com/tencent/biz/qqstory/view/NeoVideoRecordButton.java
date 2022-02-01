package com.tencent.biz.qqstory.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import rrg;
import rrh;
import rri;

@TargetApi(11)
public class NeoVideoRecordButton
  extends RingView
{
  public AnimatorSet K;
  public ValueAnimator O;
  public ValueAnimator P;
  public ValueAnimator Q;
  public RingView.a a;
  public RingView.a b;
  final int bum;
  final int bun;
  final int buo;
  final int bup;
  final int buq;
  final int bur;
  public RingView.a c;
  public float mProgress = 0.0F;
  
  public NeoVideoRecordButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bum = dip2px(paramContext, 37.5F);
    this.bun = dip2px(paramContext, 6.0F);
    this.buo = dip2px(paramContext, 1.0F);
    this.bur = dip2px(paramContext, 45.5F);
    this.buq = dip2px(paramContext, 6.0F);
    this.bup = dip2px(paramContext, 31.799999F);
    paramContext = new RingView.a(-90, 270, this.bum, 0.0F, this.bun, 0.0F, -15550475, -1, Paint.Style.STROKE);
    this.a = paramContext;
    super.a(paramContext);
    paramContext = new RingView.a(-90, 270, 1, 0.0F, 1, 0.0F, 1090519039, 0, Paint.Style.FILL);
    this.c = paramContext;
    super.a(paramContext);
    paramContext = new RingView.a(-90, 270, this.buo, 0.0F, 1, 0.0F, -1, 0, Paint.Style.FILL);
    this.b = paramContext;
    super.a(paramContext);
    this.O = new ValueAnimator();
    this.O.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("border", new IntEvaluator(), new Object[] { Integer.valueOf(this.bum), Integer.valueOf(this.bur) }), PropertyValuesHolder.ofObject("ring", new IntEvaluator(), new Object[] { Integer.valueOf(this.bun), Integer.valueOf(this.buq) }), PropertyValuesHolder.ofObject("center", new IntEvaluator(), new Object[] { Integer.valueOf(this.buo), Integer.valueOf(this.bup) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(-1), Integer.valueOf(-15550475) }) });
    this.O.setDuration(400L);
    this.O.addUpdateListener(new rrg(this));
    this.P = new ValueAnimator();
    this.P.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("radius", new IntEvaluator(), new Object[] { Integer.valueOf(1), Integer.valueOf(this.bur - this.bun) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(2147483647), Integer.valueOf(16777215) }) });
    this.P.setInterpolator(new DecelerateInterpolator());
    this.P.setDuration(1500L);
    this.P.setRepeatCount(-1);
    this.P.setRepeatMode(1);
    this.P.addUpdateListener(new rrh(this));
    this.K = new AnimatorSet();
    this.K.play(this.O).before(this.P);
    this.Q = new ValueAnimator();
    this.Q.setDuration(400L);
    this.Q.addUpdateListener(new rri(this));
    setProgress(this.mProgress);
    this.b.bvY();
    this.c.bvY();
  }
  
  private void bvW()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(getDensity(paramContext) * paramFloat + 0.5F);
  }
  
  public static float getDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int l(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return -90;
    }
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    return (int)(360.0F * f) - 90;
  }
  
  public void setProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
    this.a.buw = l(this.mProgress);
    bvW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.NeoVideoRecordButton
 * JD-Core Version:    0.7.0.1
 */