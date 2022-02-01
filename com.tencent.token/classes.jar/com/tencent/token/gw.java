package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class gw
  extends Drawable
  implements Drawable.Callback
{
  public Drawable a;
  
  public gw(Drawable paramDrawable)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.a = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return this.a.getChangingConfigurations();
  }
  
  public Drawable getCurrent()
  {
    return this.a.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.a.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.a.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.a.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.a.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.a.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return dk.a(this.a);
  }
  
  public boolean isStateful()
  {
    return this.a.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    this.a.jumpToCurrentState();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.a.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.a.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    dk.a(this.a, paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.a.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.a.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.a.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    dk.a(this.a, paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dk.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    return this.a.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    dk.a(this.a, paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    dk.a(this.a, paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    dk.a(this.a, paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.a.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gw
 * JD-Core Version:    0.7.0.1
 */