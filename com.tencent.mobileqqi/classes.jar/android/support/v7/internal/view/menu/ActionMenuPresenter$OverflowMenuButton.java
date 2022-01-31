package android.support.v7.internal.view.menu;

import android.content.Context;
import android.widget.ImageButton;

class ActionMenuPresenter$OverflowMenuButton
  extends ImageButton
  implements ActionMenuView.ActionMenuChildView
{
  public ActionMenuPresenter$OverflowMenuButton(ActionMenuPresenter paramActionMenuPresenter, Context paramContext)
  {
    super(paramContext, null, 2130771978);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
  }
  
  public boolean needsDividerAfter()
  {
    return false;
  }
  
  public boolean needsDividerBefore()
  {
    return false;
  }
  
  public boolean performClick()
  {
    if (super.performClick()) {
      return true;
    }
    playSoundEffect(0);
    this.this$0.showOverflowMenu();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.OverflowMenuButton
 * JD-Core Version:    0.7.0.1
 */