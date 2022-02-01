package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class WrappedDrawableApi14
  extends Drawable
  implements Drawable.Callback, TintAwareDrawable, WrappedDrawable
{
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private boolean mColorFilterSet;
  private int mCurrentColor;
  private PorterDuff.Mode mCurrentMode;
  Drawable mDrawable;
  private boolean mMutated;
  DrawableWrapperState mState;
  
  WrappedDrawableApi14(@Nullable Drawable paramDrawable)
  {
    this.mState = mutateConstantState();
    setWrappedDrawable(paramDrawable);
  }
  
  WrappedDrawableApi14(@NonNull DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
  {
    this.mState = paramDrawableWrapperState;
    updateLocalState(paramResources);
  }
  
  private void updateLocalState(@Nullable Resources paramResources)
  {
    DrawableWrapperState localDrawableWrapperState = this.mState;
    if ((localDrawableWrapperState != null) && (localDrawableWrapperState.mDrawableState != null)) {
      setWrappedDrawable(this.mState.mDrawableState.newDrawable(paramResources));
    }
  }
  
  private boolean updateTint(int[] paramArrayOfInt)
  {
    if (!isCompatTintEnabled()) {
      return false;
    }
    ColorStateList localColorStateList = this.mState.mTint;
    PorterDuff.Mode localMode = this.mState.mTintMode;
    if ((localColorStateList != null) && (localMode != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!this.mColorFilterSet) || (i != this.mCurrentColor) || (localMode != this.mCurrentMode))
      {
        setColorFilter(i, localMode);
        this.mCurrentColor = i;
        this.mCurrentMode = localMode;
        this.mColorFilterSet = true;
        return true;
      }
    }
    else
    {
      this.mColorFilterSet = false;
      clearColorFilter();
    }
    return false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    DrawableWrapperState localDrawableWrapperState = this.mState;
    int i;
    if (localDrawableWrapperState != null) {
      i = localDrawableWrapperState.getChangingConfigurations();
    } else {
      i = 0;
    }
    return j | i | this.mDrawable.getChangingConfigurations();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    DrawableWrapperState localDrawableWrapperState = this.mState;
    if ((localDrawableWrapperState != null) && (localDrawableWrapperState.canConstantState()))
    {
      this.mState.mChangingConfigurations = getChangingConfigurations();
      return this.mState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    return this.mDrawable.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState()
  {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.mDrawable.getTransparentRegion();
  }
  
  public final Drawable getWrappedDrawable()
  {
    return this.mDrawable;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  protected boolean isCompatTintEnabled()
  {
    return true;
  }
  
  public boolean isStateful()
  {
    if (isCompatTintEnabled())
    {
      localObject = this.mState;
      if (localObject != null)
      {
        localObject = ((DrawableWrapperState)localObject).mTint;
        break label26;
      }
    }
    Object localObject = null;
    label26:
    return ((localObject != null) && (((ColorStateList)localObject).isStateful())) || (this.mDrawable.isStateful());
  }
  
  public void jumpToCurrentState()
  {
    this.mDrawable.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mState = mutateConstantState();
      Object localObject = this.mDrawable;
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      DrawableWrapperState localDrawableWrapperState = this.mState;
      if (localDrawableWrapperState != null)
      {
        localObject = this.mDrawable;
        if (localObject != null) {
          localObject = ((Drawable)localObject).getConstantState();
        } else {
          localObject = null;
        }
        localDrawableWrapperState.mDrawableState = ((Drawable.ConstantState)localObject);
      }
      this.mMutated = true;
    }
    return this;
  }
  
  @NonNull
  DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateBase(this.mState, null);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawable.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfInt)
  {
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    return (updateTint(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mState.mTint = paramColorStateList;
    updateTint(getState());
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    this.mState.mTintMode = paramMode;
    updateTint(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.mDrawable.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public final void setWrappedDrawable(Drawable paramDrawable)
  {
    Object localObject = this.mDrawable;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      localObject = this.mState;
      if (localObject != null) {
        ((DrawableWrapperState)localObject).mDrawableState = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  protected static abstract class DrawableWrapperState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
    
    DrawableWrapperState(@Nullable DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      if (paramDrawableWrapperState != null)
      {
        this.mChangingConfigurations = paramDrawableWrapperState.mChangingConfigurations;
        this.mDrawableState = paramDrawableWrapperState.mDrawableState;
        this.mTint = paramDrawableWrapperState.mTint;
        this.mTintMode = paramDrawableWrapperState.mTintMode;
      }
    }
    
    boolean canConstantState()
    {
      return this.mDrawableState != null;
    }
    
    public int getChangingConfigurations()
    {
      int j = this.mChangingConfigurations;
      Drawable.ConstantState localConstantState = this.mDrawableState;
      int i;
      if (localConstantState != null) {
        i = localConstantState.getChangingConfigurations();
      } else {
        i = 0;
      }
      return j | i;
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return newDrawable(null);
    }
    
    @NonNull
    public abstract Drawable newDrawable(@Nullable Resources paramResources);
  }
  
  private static class DrawableWrapperStateBase
    extends WrappedDrawableApi14.DrawableWrapperState
  {
    DrawableWrapperStateBase(@Nullable WrappedDrawableApi14.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      super(paramResources);
    }
    
    @NonNull
    public Drawable newDrawable(@Nullable Resources paramResources)
    {
      return new WrappedDrawableApi14(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.WrappedDrawableApi14
 * JD-Core Version:    0.7.0.1
 */