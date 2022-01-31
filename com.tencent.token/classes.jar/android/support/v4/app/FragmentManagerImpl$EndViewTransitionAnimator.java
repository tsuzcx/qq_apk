package android.support.v4.app;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

class FragmentManagerImpl$EndViewTransitionAnimator
  extends AnimationSet
  implements Runnable
{
  private final View mChild;
  private boolean mEnded;
  private final ViewGroup mParent;
  private boolean mTransitionEnded;
  
  FragmentManagerImpl$EndViewTransitionAnimator(@NonNull Animation paramAnimation, @NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    super(false);
    this.mParent = paramViewGroup;
    this.mChild = paramView;
    addAnimation(paramAnimation);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.mEnded) {
      if (this.mTransitionEnded) {}
    }
    while (super.getTransformation(paramLong, paramTransformation))
    {
      return true;
      return false;
    }
    this.mEnded = true;
    OneShotPreDrawListener.add(this.mParent, this);
    return true;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
  {
    if (this.mEnded) {
      if (this.mTransitionEnded) {}
    }
    while (super.getTransformation(paramLong, paramTransformation, paramFloat))
    {
      return true;
      return false;
    }
    this.mEnded = true;
    OneShotPreDrawListener.add(this.mParent, this);
    return true;
  }
  
  public void run()
  {
    this.mParent.endViewTransition(this.mChild);
    this.mTransitionEnded = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.EndViewTransitionAnimator
 * JD-Core Version:    0.7.0.1
 */