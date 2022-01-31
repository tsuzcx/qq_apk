package android.support.v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

class CascadingMenuPopup$2
  implements View.OnAttachStateChangeListener
{
  CascadingMenuPopup$2(CascadingMenuPopup paramCascadingMenuPopup) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (CascadingMenuPopup.access$000(this.this$0) != null)
    {
      if (!CascadingMenuPopup.access$000(this.this$0).isAlive()) {
        CascadingMenuPopup.access$002(this.this$0, paramView.getViewTreeObserver());
      }
      CascadingMenuPopup.access$000(this.this$0).removeGlobalOnLayoutListener(CascadingMenuPopup.access$100(this.this$0));
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.CascadingMenuPopup.2
 * JD-Core Version:    0.7.0.1
 */