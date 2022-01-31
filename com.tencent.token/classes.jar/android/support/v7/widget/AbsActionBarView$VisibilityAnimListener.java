package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

public class AbsActionBarView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  private boolean mCanceled = false;
  int mFinalVisibility;
  
  protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView paramAbsActionBarView) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (this.mCanceled) {
      return;
    }
    this.this$0.mVisibilityAnim = null;
    AbsActionBarView.access$101(this.this$0, this.mFinalVisibility);
  }
  
  public void onAnimationStart(View paramView)
  {
    AbsActionBarView.access$001(this.this$0, 0);
    this.mCanceled = false;
  }
  
  public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
  {
    this.this$0.mVisibilityAnim = paramViewPropertyAnimatorCompat;
    this.mFinalVisibility = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AbsActionBarView.VisibilityAnimListener
 * JD-Core Version:    0.7.0.1
 */