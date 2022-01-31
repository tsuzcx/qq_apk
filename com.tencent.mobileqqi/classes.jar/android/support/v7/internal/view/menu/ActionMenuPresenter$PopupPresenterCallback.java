package android.support.v7.internal.view.menu;

import android.view.MenuItem;

class ActionMenuPresenter$PopupPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramMenuBuilder instanceof SubMenuBuilder)) {
      ((SubMenuBuilder)paramMenuBuilder).getRootMenu().close(false);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == null) {
      return false;
    }
    this.this$0.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.PopupPresenterCallback
 * JD-Core Version:    0.7.0.1
 */