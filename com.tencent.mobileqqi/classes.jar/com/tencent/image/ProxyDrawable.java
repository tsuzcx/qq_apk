package com.tencent.image;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public abstract class ProxyDrawable
  extends Drawable
  implements Drawable.Callback
{
  protected Drawable mCurrDrawable;
  private boolean mMutated;
  
  public ProxyDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new IllegalArgumentException("proxy drawable can't be null!");
    }
    this.mCurrDrawable = paramDrawable;
    this.mCurrDrawable.setCallback(this);
  }
  
  public int getChangingConfigurations()
  {
    return this.mCurrDrawable.getChangingConfigurations();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mCurrDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mCurrDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mCurrDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mCurrDrawable.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.mCurrDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mCurrDrawable.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.mCurrDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mCurrDrawable.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mCurrDrawable.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    return this.mCurrDrawable.setState(paramArrayOfInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mCurrDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setColorFilter(paramColorFilter);
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mCurrDrawable.setDither(paramBoolean);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.image.ProxyDrawable
 * JD-Core Version:    0.7.0.1
 */