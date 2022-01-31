package android.support.v7.view.menu;

import android.support.v7.widget.MenuPopupWindow;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class StandardMenuPopup$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  StandardMenuPopup$1(StandardMenuPopup paramStandardMenuPopup) {}
  
  public void onGlobalLayout()
  {
    if ((this.this$0.isShowing()) && (!this.this$0.mPopup.isModal()))
    {
      View localView = this.this$0.mShownAnchorView;
      if ((localView == null) || (!localView.isShown())) {
        this.this$0.dismiss();
      }
    }
    else
    {
      return;
    }
    this.this$0.mPopup.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.StandardMenuPopup.1
 * JD-Core Version:    0.7.0.1
 */