package android.support.v7.widget;

import android.view.ViewPropertyAnimator;

class ActionBarOverlayLayout$2
  implements Runnable
{
  ActionBarOverlayLayout$2(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    this.this$0.haltActionBarHideOffsetAnimations();
    this.this$0.mCurrentActionBarTopAnimator = this.this$0.mActionBarTop.animate().translationY(0.0F).setListener(this.this$0.mTopAnimatorListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout.2
 * JD-Core Version:    0.7.0.1
 */