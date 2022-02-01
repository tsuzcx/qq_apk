package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

class FragmentManagerImpl$5
  extends AnimatorListenerAdapter
{
  FragmentManagerImpl$5(FragmentManagerImpl paramFragmentManagerImpl, ViewGroup paramViewGroup, View paramView, Fragment paramFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$container.endViewTransition(this.val$animatingView);
    paramAnimator.removeListener(this);
    if ((this.val$fragment.mView != null) && (this.val$fragment.mHidden)) {
      this.val$fragment.mView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */