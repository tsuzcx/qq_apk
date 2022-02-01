package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class CameraFocusView
  extends ImageView
{
  protected int mHeight;
  protected int mWidth;
  
  public CameraFocusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDrawableRes(2130847395);
  }
  
  public boolean F(MotionEvent paramMotionEvent)
  {
    return y(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  public void brX()
  {
    clearAnimation();
    setVisibility(4);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDrawableRes(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    if (localDrawable != null)
    {
      this.mWidth = localDrawable.getMinimumWidth();
      this.mHeight = localDrawable.getMinimumHeight();
    }
  }
  
  public boolean y(float paramFloat1, float paramFloat2)
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(800L);
    localAlphaAnimation.setFillAfter(true);
    setPadding((int)paramFloat1 - this.mWidth / 2, (int)paramFloat2 - this.mHeight / 2, 0, 0);
    startAnimation(localAlphaAnimation);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.CameraFocusView
 * JD-Core Version:    0.7.0.1
 */