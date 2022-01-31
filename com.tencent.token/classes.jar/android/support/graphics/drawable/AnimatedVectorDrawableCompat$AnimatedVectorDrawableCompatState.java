package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState
  extends Drawable.ConstantState
{
  AnimatorSet mAnimatorSet;
  private ArrayList mAnimators;
  int mChangingConfigurations;
  ArrayMap mTargetNameMap;
  VectorDrawableCompat mVectorDrawable;
  
  public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(Context paramContext, AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Drawable.Callback paramCallback, Resources paramResources)
  {
    if (paramAnimatedVectorDrawableCompatState != null)
    {
      this.mChangingConfigurations = paramAnimatedVectorDrawableCompatState.mChangingConfigurations;
      if (paramAnimatedVectorDrawableCompatState.mVectorDrawable != null)
      {
        paramContext = paramAnimatedVectorDrawableCompatState.mVectorDrawable.getConstantState();
        if (paramResources == null) {
          break label215;
        }
      }
      label215:
      for (this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable(paramResources));; this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable()))
      {
        this.mVectorDrawable = ((VectorDrawableCompat)this.mVectorDrawable.mutate());
        this.mVectorDrawable.setCallback(paramCallback);
        this.mVectorDrawable.setBounds(paramAnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
        this.mVectorDrawable.setAllowCaching(false);
        if (paramAnimatedVectorDrawableCompatState.mAnimators == null) {
          return;
        }
        int j = paramAnimatedVectorDrawableCompatState.mAnimators.size();
        this.mAnimators = new ArrayList(j);
        this.mTargetNameMap = new ArrayMap(j);
        while (i < j)
        {
          paramCallback = (Animator)paramAnimatedVectorDrawableCompatState.mAnimators.get(i);
          paramContext = paramCallback.clone();
          paramCallback = (String)paramAnimatedVectorDrawableCompatState.mTargetNameMap.get(paramCallback);
          paramContext.setTarget(this.mVectorDrawable.getTargetByName(paramCallback));
          this.mAnimators.add(paramContext);
          this.mTargetNameMap.put(paramContext, paramCallback);
          i += 1;
        }
      }
      setupAnimatorSet();
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
  
  public void setupAnimatorSet()
  {
    if (this.mAnimatorSet == null) {
      this.mAnimatorSet = new AnimatorSet();
    }
    this.mAnimatorSet.playTogether(this.mAnimators);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState
 * JD-Core Version:    0.7.0.1
 */