package androidx.appcompat.widget;

import android.view.View;

class ListPopupWindow$2
  implements Runnable
{
  ListPopupWindow$2(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    View localView = this.this$0.getAnchorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.this$0.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */