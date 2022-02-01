package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ToolbarWidgetWrapper.2
 * JD-Core Version:    0.7.0.1
 */