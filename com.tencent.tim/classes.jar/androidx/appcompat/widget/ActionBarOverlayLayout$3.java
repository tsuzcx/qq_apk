package androidx.appcompat.widget;

import android.view.ViewPropertyAnimator;

class ActionBarOverlayLayout$3
  implements Runnable
{
  ActionBarOverlayLayout$3(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    this.this$0.haltActionBarHideOffsetAnimations();
    this.this$0.mCurrentActionBarTopAnimator = this.this$0.mActionBarTop.animate().translationY(-this.this$0.mActionBarTop.getHeight()).setListener(this.this$0.mTopAnimatorListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout.3
 * JD-Core Version:    0.7.0.1
 */