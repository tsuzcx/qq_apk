package android.support.v7.internal.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupScrollListener
  implements AbsListView.OnScrollListener
{
  private ListPopupWindow$PopupScrollListener(ListPopupWindow paramListPopupWindow) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.this$0.isInputMethodNotNeeded()) && (ListPopupWindow.access$800(this.this$0).getContentView() != null))
    {
      ListPopupWindow.access$1000(this.this$0).removeCallbacks(ListPopupWindow.access$900(this.this$0));
      ListPopupWindow.access$900(this.this$0).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow.PopupScrollListener
 * JD-Core Version:    0.7.0.1
 */