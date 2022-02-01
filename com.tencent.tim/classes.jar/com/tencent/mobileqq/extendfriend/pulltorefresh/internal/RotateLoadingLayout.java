package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

public class RotateLoadingLayout
  extends LoadingLayout
{
  private final boolean cbG;
  private final Matrix o;
  private float wk;
  private float wl;
  private final Animation x;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.cbG = paramTypedArray.getBoolean(18, true);
    this.gl.setScaleType(ImageView.ScaleType.MATRIX);
    this.o = new Matrix();
    this.gl.setImageMatrix(this.o);
    this.x = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.x.setInterpolator(k);
    this.x.setDuration(1200L);
    this.x.setRepeatCount(-1);
    this.x.setRepeatMode(1);
  }
  
  private void akM()
  {
    if (this.o != null)
    {
      this.o.reset();
      this.gl.setImageMatrix(this.o);
    }
  }
  
  protected int DQ()
  {
    return 2130842418;
  }
  
  public void T(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.wk = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.wl = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  protected void aM(float paramFloat)
  {
    if (this.cbG) {}
    for (paramFloat = 90.0F * paramFloat;; paramFloat = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F)))
    {
      this.o.setRotate(paramFloat, this.wk, this.wl);
      this.gl.setImageMatrix(this.o);
      return;
    }
  }
  
  protected void ddI() {}
  
  protected void ddJ()
  {
    this.gl.startAnimation(this.x);
  }
  
  protected void ddK() {}
  
  protected void ddL()
  {
    this.gl.clearAnimation();
    akM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */