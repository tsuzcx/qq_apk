package com.tencent.qqmail.activity.reademl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMReadEmlActivity$AttachListViewAdapter$18
  implements View.OnLongClickListener
{
  QMReadEmlActivity$AttachListViewAdapter$18(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView.cancelLongPress();
    paramView.clearFocus();
    if (QMReadEmlActivity.access$2800(this.this$1.this$0).getWebView() != null)
    {
      paramView = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      QMReadEmlActivity.access$2800(this.this$1.this$0).getWebView().dispatchTouchEvent(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.18
 * JD-Core Version:    0.7.0.1
 */