package android.support.v4.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$2
  extends FragmentManagerImpl.AnimationListenerWrapper
{
  FragmentManagerImpl$2(FragmentManagerImpl paramFragmentManagerImpl, Animation.AnimationListener paramAnimationListener, ViewGroup paramViewGroup, Fragment paramFragment)
  {
    super(paramAnimationListener, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    this.val$container.post(new FragmentManagerImpl.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */