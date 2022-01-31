package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.View;

class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuPopupHelper
{
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, SubMenuBuilder paramSubMenuBuilder, View paramView)
  {
    super(paramContext, paramSubMenuBuilder, paramView, false, R.attr.actionOverflowMenuStyle);
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton()) {
      if (paramActionMenuPresenter.mOverflowButton != null) {
        break label59;
      }
    }
    label59:
    for (paramContext = (View)ActionMenuPresenter.access$200(paramActionMenuPresenter);; paramContext = paramActionMenuPresenter.mOverflowButton)
    {
      setAnchorView(paramContext);
      setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
      return;
    }
  }
  
  protected void onDismiss()
  {
    this.this$0.mActionButtonPopup = null;
    this.this$0.mOpenSubMenuId = 0;
    super.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu
 * JD-Core Version:    0.7.0.1
 */