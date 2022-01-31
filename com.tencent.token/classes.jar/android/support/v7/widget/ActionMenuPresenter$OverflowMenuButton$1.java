package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
 * JD-Core Version:    0.7.0.1
 */