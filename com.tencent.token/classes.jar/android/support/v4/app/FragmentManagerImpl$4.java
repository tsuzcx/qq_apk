package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

class FragmentManagerImpl$4
  extends AnimatorListenerAdapter
{
  FragmentManagerImpl$4(FragmentManagerImpl paramFragmentManagerImpl, ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$container.endViewTransition(this.val$animatingView);
    paramAnimator.removeListener(this);
    if (this.val$fragment.mView != null) {
      this.val$fragment.mView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */