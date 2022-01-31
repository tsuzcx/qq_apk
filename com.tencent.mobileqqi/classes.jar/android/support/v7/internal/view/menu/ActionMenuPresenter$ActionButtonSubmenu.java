package android.support.v7.internal.view.menu;

import android.content.DialogInterface;

class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuDialogHelper
{
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, SubMenuBuilder paramSubMenuBuilder)
  {
    super(paramSubMenuBuilder);
    paramActionMenuPresenter.setCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    ActionMenuPresenter.access$202(this.this$0, null);
    this.this$0.mOpenSubMenuId = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.ActionButtonSubmenu
 * JD-Core Version:    0.7.0.1
 */