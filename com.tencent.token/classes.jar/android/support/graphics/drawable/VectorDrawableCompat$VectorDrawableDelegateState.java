package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class VectorDrawableCompat$VectorDrawableDelegateState
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState mDelegateState;
  
  public VectorDrawableCompat$VectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
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
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable());
    return localVectorDrawableCompat;
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources));
    return localVectorDrawableCompat;
  }
  
  public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources, paramTheme));
    return localVectorDrawableCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VectorDrawableDelegateState
 * JD-Core Version:    0.7.0.1
 */