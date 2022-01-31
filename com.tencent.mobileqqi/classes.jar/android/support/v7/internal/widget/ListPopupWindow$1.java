package android.support.v7.internal.widget;

import android.view.View;

class ListPopupWindow$1
  implements Runnable
{
  ListPopupWindow$1(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    View localView = this.this$0.getAnchorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.this$0.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */