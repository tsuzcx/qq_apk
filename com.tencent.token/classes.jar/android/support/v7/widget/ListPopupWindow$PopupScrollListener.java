package android.support.v7.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupScrollListener
  implements AbsListView.OnScrollListener
{
  ListPopupWindow$PopupScrollListener(ListPopupWindow paramListPopupWindow) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.this$0.isInputMethodNotNeeded()) && (this.this$0.mPopup.getContentView() != null))
    {
      this.this$0.mHandler.removeCallbacks(this.this$0.mResizePopupRunnable);
      this.this$0.mResizePopupRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.PopupScrollListener
 * JD-Core Version:    0.7.0.1
 */