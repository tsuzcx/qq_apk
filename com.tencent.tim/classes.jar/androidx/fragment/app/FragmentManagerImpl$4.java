package androidx.fragment.app;

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
    this.val$container.endViewTransition(this.val$viewToAnimate);
    paramAnimator = this.val$fragment.getAnimator();
    this.val$fragment.setAnimator(null);
    if ((paramAnimator != null) && (this.val$container.indexOfChild(this.val$viewToAnimate) < 0)) {
      this.this$0.moveToState(this.val$fragment, this.val$fragment.getStateAfterAnimating(), 0, 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */