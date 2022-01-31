package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

class FragmentManagerImpl$AnimationOrAnimator
{
  public final Animation animation;
  public final Animator animator;
  
  private FragmentManagerImpl$AnimationOrAnimator(Animator paramAnimator)
  {
    this.animation = null;
    this.animator = paramAnimator;
    if (paramAnimator == null) {
      throw new IllegalStateException("Animator cannot be null");
    }
  }
  
  private FragmentManagerImpl$AnimationOrAnimator(Animation paramAnimation)
  {
    this.animation = paramAnimation;
    this.animator = null;
    if (paramAnimation == null) {
      throw new IllegalStateException("Animation cannot be null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator
 * JD-Core Version:    0.7.0.1
 */