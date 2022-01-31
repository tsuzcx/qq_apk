package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState mDelegateState;
  
  public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
  {
    this.mDelegateState = paramConstantState;
  }
  
  public boolean canApplyTheme()
  {
    return this.mDelegateState.canApplyTheme();
  }
  
  public int getChangingConfigurations()
  {
    return this.mDelegateState.getChangingConfigurations();
  }
  
  public Drawable newDrawable()
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
    localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
    localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
    return localAnimatedVectorDrawableCompat;
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
    localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources);
    localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
    return localAnimatedVectorDrawableCompat;
  }
  
  public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
    localAnimatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources, paramTheme);
    localAnimatedVectorDrawableCompat.mDelegateDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
    return localAnimatedVectorDrawableCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState
 * JD-Core Version:    0.7.0.1
 */