package android.support.v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

class StandardMenuPopup$2
  implements View.OnAttachStateChangeListener
{
  StandardMenuPopup$2(StandardMenuPopup paramStandardMenuPopup) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (StandardMenuPopup.access$000(this.this$0) != null)
    {
      if (!StandardMenuPopup.access$000(this.this$0).isAlive()) {
        StandardMenuPopup.access$002(this.this$0, paramView.getViewTreeObserver());
      }
      StandardMenuPopup.access$000(this.this$0).removeGlobalOnLayoutListener(StandardMenuPopup.access$100(this.this$0));
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.StandardMenuPopup.2
 * JD-Core Version:    0.7.0.1
 */