package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

class ActionMenuPresenter$OverflowMenuButton$1
  extends ForwardingListener
{
  ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter.OverflowMenuButton paramOverflowMenuButton, View paramView, ActionMenuPresenter paramActionMenuPresenter)
  {
    super(paramView);
  }
  
  public ShowableListMenu getPopup()
  {
    if (this.this$1.this$0.mOverflowPopup == null) {
      return null;
    }
    return this.this$1.this$0.mOverflowPopup.getPopup();
  }
  
  public boolean onForwardingStarted()
  {
    this.this$1.this$0.showOverflowMenu();
    return true;
  }
  
  public boolean onForwardingStopped()
  {
    if (this.this$1.this$0.mPostedOpenRunnable != null) {
      return false;
    }
    this.this$1.this$0.hideOverflowMenu();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
 * JD-Core Version:    0.7.0.1
 */