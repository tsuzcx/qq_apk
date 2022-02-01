package com.tencent.token;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

abstract class bs
  extends Drawable
  implements di
{
  Drawable b;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      dh.a(localDrawable, paramTheme);
      return;
    }
  }
  
  public void clearColorFilter()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return localDrawable.getColorFilter();
      }
      return null;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      return;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setFilterBitmap(paramBoolean);
      return;
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      dh.a(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      dh.a(localDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bs
 * JD-Core Version:    0.7.0.1
 */