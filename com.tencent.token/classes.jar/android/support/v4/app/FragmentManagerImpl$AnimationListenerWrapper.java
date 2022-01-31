package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$AnimationListenerWrapper
  implements Animation.AnimationListener
{
  private final Animation.AnimationListener mWrapped;
  
  private FragmentManagerImpl$AnimationListenerWrapper(Animation.AnimationListener paramAnimationListener)
  {
    this.mWrapped = paramAnimationListener;
  }
  
  @CallSuper
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.mWrapped != null) {
      this.mWrapped.onAnimationEnd(paramAnimation);
    }
  }
  
  @CallSuper
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.mWrapped != null) {
      this.mWrapped.onAnimationRepeat(paramAnimation);
    }
  }
  
  @CallSuper
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.mWrapped != null) {
      this.mWrapped.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper
 * JD-Core Version:    0.7.0.1
 */