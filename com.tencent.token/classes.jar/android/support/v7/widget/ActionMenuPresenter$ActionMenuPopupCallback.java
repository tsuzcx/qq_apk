package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.ShowableListMenu;

class ActionMenuPresenter$ActionMenuPopupCallback
  extends ActionMenuItemView.PopupCallback
{
  ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public ShowableListMenu getPopup()
  {
    if (this.this$0.mActionButtonPopup != null) {
      return this.this$0.mActionButtonPopup.getPopup();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback
 * JD-Core Version:    0.7.0.1
 */