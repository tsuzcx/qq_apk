package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.WeakHashMap;

public abstract class ViewPropertyAnimator
{
  private static final WeakHashMap<View, ViewPropertyAnimator> ANIMATORS = new WeakHashMap(0);
  
  public static ViewPropertyAnimator animate(View paramView)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)ANIMATORS.get(paramView);
    Object localObject = localViewPropertyAnimator;
    if (localViewPropertyAnimator == null)
    {
      localObject = new ViewPropertyAnimatorPreHC(paramView);
      ANIMATORS.put(paramView, localObject);
    }
    return localObject;
  }
  
  public abstract ViewPropertyAnimator alpha(float paramFloat);
  
  public abstract ViewPropertyAnimator alphaBy(float paramFloat);
  
  public abstract void cancel();
  
  public abstract long getDuration();
  
  public abstract long getStartDelay();
  
  public abstract ViewPropertyAnimator rotation(float paramFloat);
  
  public abstract ViewPropertyAnimator rotationBy(float paramFloat);
  
  public abstract ViewPropertyAnimator rotationX(float paramFloat);
  
  public abstract ViewPropertyAnimator rotationXBy(float paramFloat);
  
  public abstract ViewPropertyAnimator rotationY(float paramFloat);
  
  public abstract ViewPropertyAnimator rotationYBy(float paramFloat);
  
  public abstract ViewPropertyAnimator scaleX(float paramFloat);
  
  public abstract ViewPropertyAnimator scaleXBy(float paramFloat);
  
  public abstract ViewPropertyAnimator scaleY(float paramFloat);
  
  public abstract ViewPropertyAnimator scaleYBy(float paramFloat);
  
  public abstract ViewPropertyAnimator setDuration(long paramLong);
  
  public abstract ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator);
  
  public abstract ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener);
  
  public abstract ViewPropertyAnimator setStartDelay(long paramLong);
  
  public abstract void start();
  
  public abstract ViewPropertyAnimator translationX(float paramFloat);
  
  public abstract ViewPropertyAnimator translationXBy(float paramFloat);
  
  public abstract ViewPropertyAnimator translationY(float paramFloat);
  
  public abstract ViewPropertyAnimator translationYBy(float paramFloat);
  
  public abstract ViewPropertyAnimator x(float paramFloat);
  
  public abstract ViewPropertyAnimator xBy(float paramFloat);
  
  public abstract ViewPropertyAnimator y(float paramFloat);
  
  public abstract ViewPropertyAnimator yBy(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimator
 * JD-Core Version:    0.7.0.1
 */