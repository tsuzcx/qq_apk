package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class ToolbarWidgetWrapper$2
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean mCanceled = false;
  
  ToolbarWidgetWrapper$2(ToolbarWidgetWrapper paramToolbarWidgetWrapper, int paramInt) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (!this.mCanceled) {
      this.this$0.mToolbar.setVisibility(this.val$visibility);
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.mToolbar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper.2
 * JD-Core Version:    0.7.0.1
 */