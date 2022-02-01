package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ActionBarOverlayLayout$1
  extends AnimatorListenerAdapter
{
  ActionBarOverlayLayout$1(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.mCurrentActionBarTopAnimator = null;
    this.this$0.mAnimatingForFling = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.mCurrentActionBarTopAnimator = null;
    this.this$0.mAnimatingForFling = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout.1
 * JD-Core Version:    0.7.0.1
 */