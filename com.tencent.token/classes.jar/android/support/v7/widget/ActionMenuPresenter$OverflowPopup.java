package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View;

class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
    setGravity(8388613);
    setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  protected void onDismiss()
  {
    if (ActionMenuPresenter.access$000(this.this$0) != null) {
      ActionMenuPresenter.access$100(this.this$0).close();
    }
    this.this$0.mOverflowPopup = null;
    super.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowPopup
 * JD-Core Version:    0.7.0.1
 */