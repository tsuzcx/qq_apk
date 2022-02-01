package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends LoadingLayout
{
  private final Animation aD;
  private final Animation x;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {}
    for (int i = -180;; i = 180)
    {
      this.x = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.x.setInterpolator(k);
      this.x.setDuration(150L);
      this.x.setFillAfter(true);
      this.aD = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.aD.setInterpolator(k);
      this.aD.setDuration(150L);
      this.aD.setFillAfter(true);
      return;
    }
  }
  
  private float bc()
  {
    switch (afxj.lg[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
    {
    }
    do
    {
      return 0.0F;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation == PullToRefreshBase.Orientation.HORIZONTAL) {
        return 90.0F;
      }
      return 180.0F;
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation != PullToRefreshBase.Orientation.HORIZONTAL);
    return 270.0F;
  }
  
  protected int DQ()
  {
    return 2130839678;
  }
  
  protected void T(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      paramDrawable = this.gl.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.gl.requestLayout();
      this.gl.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(bc(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.gl.setImageMatrix(localMatrix);
    }
  }
  
  protected void aM(float paramFloat) {}
  
  protected void ddI()
  {
    if (this.x == this.gl.getAnimation()) {
      this.gl.startAnimation(this.aD);
    }
  }
  
  protected void ddJ()
  {
    this.gl.clearAnimation();
    this.gl.setVisibility(4);
    this.Z.setVisibility(0);
  }
  
  protected void ddK()
  {
    this.gl.startAnimation(this.x);
  }
  
  protected void ddL()
  {
    this.gl.clearAnimation();
    this.Z.setVisibility(8);
    this.gl.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.FlipLoadingLayout
 * JD-Core Version:    0.7.0.1
 */