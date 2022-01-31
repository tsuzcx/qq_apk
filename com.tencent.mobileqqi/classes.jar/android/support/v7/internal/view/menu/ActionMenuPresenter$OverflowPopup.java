package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.View;

class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean);
    setCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    this.this$0.mMenu.close();
    ActionMenuPresenter.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.OverflowPopup
 * JD-Core Version:    0.7.0.1
 */