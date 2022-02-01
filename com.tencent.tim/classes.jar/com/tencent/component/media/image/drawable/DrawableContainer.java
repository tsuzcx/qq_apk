package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.annotation.Public;

@Public
public abstract class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private boolean mMutated;
  private ContainerState mState;
  
  public void draw(Canvas paramCanvas)
  {
    this.mState.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mState.mChangingConfigurations | this.mState.mDrawable.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.mState.canConstantState())
    {
      this.mState.mChangingConfigurations = getChangingConfigurations();
      return this.mState;
    }
    return null;
  }
  
  public Drawable getDrawable()
  {
    return this.mState.mDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mState.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mState.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    if (this.mState.mDrawable != null) {
      return this.mState.mDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.mState.mDrawable != null) {
      return this.mState.mDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    return this.mState.mDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mState.mDrawable.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.mState.mDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mState.mDrawable.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mState.mDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mState.mDrawable.setLevel(paramInt);
    invalidateSelf();
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = this.mState.mDrawable.setState(paramArrayOfInt);
    onBoundsChange(getBounds());
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mState.mDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mState.mDrawable.setColorFilter(paramColorFilter);
  }
  
  @Public
  protected void setConstantState(ContainerState paramContainerState)
  {
    this.mState = paramContainerState;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mState.mDrawable.setDither(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    this.mState.mDrawable.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  static abstract class ContainerState
    extends Drawable.ConstantState
  {
    private boolean mCanConstantState;
    int mChangingConfigurations;
    private boolean mCheckedConstantState;
    Drawable mDrawable;
    
    ContainerState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
    {
      this.mDrawable = paramDrawable;
      this.mDrawable.setCallback(paramDrawableContainer);
    }
    
    ContainerState(ContainerState paramContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      if ((paramContainerState != null) && (paramContainerState.mDrawable != null) && (paramContainerState.mDrawable.getConstantState() != null)) {
        if (paramResources == null) {
          break label63;
        }
      }
      label63:
      for (this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable(paramResources);; this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable())
      {
        this.mDrawable.setCallback(paramDrawableContainer);
        this.mCanConstantState = true;
        this.mCheckedConstantState = true;
        return;
      }
    }
    
    boolean canConstantState()
    {
      if (!this.mCheckedConstantState) {
        if (this.mDrawable.getConstantState() == null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.mCanConstantState = bool;
        this.mCheckedConstantState = true;
        return this.mCanConstantState;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */