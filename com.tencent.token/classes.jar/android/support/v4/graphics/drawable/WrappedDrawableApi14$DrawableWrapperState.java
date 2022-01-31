package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class WrappedDrawableApi14$DrawableWrapperState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  Drawable.ConstantState mDrawableState;
  ColorStateList mTint = null;
  PorterDuff.Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
  
  WrappedDrawableApi14$DrawableWrapperState(@Nullable DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
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
    if (this.mDrawableState != null) {}
    for (int i = this.mDrawableState.getChangingConfigurations();; i = 0) {
      return i | j;
    }
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  @NonNull
  public abstract Drawable newDrawable(@Nullable Resources paramResources);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.WrappedDrawableApi14.DrawableWrapperState
 * JD-Core Version:    0.7.0.1
 */