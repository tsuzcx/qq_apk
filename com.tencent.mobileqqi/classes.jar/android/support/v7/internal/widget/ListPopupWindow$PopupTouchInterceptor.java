package android.support.v7.internal.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupTouchInterceptor
  implements View.OnTouchListener
{
  private ListPopupWindow$PopupTouchInterceptor(ListPopupWindow paramListPopupWindow) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (ListPopupWindow.access$800(this.this$0) != null) && (ListPopupWindow.access$800(this.this$0).isShowing()) && (j >= 0) && (j < ListPopupWindow.access$800(this.this$0).getWidth()) && (k >= 0) && (k < ListPopupWindow.access$800(this.this$0).getHeight())) {
      ListPopupWindow.access$1000(this.this$0).postDelayed(ListPopupWindow.access$900(this.this$0), 250L);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        ListPopupWindow.access$1000(this.this$0).removeCallbacks(ListPopupWindow.access$900(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow.PopupTouchInterceptor
 * JD-Core Version:    0.7.0.1
 */