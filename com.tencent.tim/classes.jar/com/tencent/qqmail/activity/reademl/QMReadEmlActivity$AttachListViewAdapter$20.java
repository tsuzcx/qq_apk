package com.tencent.qqmail.activity.reademl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMReadEmlActivity$AttachListViewAdapter$20
  implements View.OnTouchListener
{
  private int mLastX;
  private int mLastY;
  private int webViewScrollyWhenDown = 0;
  
  QMReadEmlActivity$AttachListViewAdapter$20(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getParent() != null) && (paramView.getParent().getParent() != null) && ((paramView.getParent().getParent() instanceof View))) {
      ((View)paramView.getParent().getParent()).setTag(Boolean.valueOf(false));
    }
    if ((QMReadEmlActivity.access$2800(this.this$1.this$0) == null) || (QMReadEmlActivity.access$2800(this.this$1.this$0).getWebView() == null)) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.webViewScrollyWhenDown = QMReadEmlActivity.access$2800(this.this$1.this$0).getWebView().getScrollY();
      QMReadEmlActivity.AttachListViewAdapter.access$6002(this.this$1, false);
      this.mLastX = ((int)paramMotionEvent.getX());
      this.mLastY = ((int)paramMotionEvent.getY());
      QMReadEmlActivity.AttachListViewAdapter.access$5902(this.this$1, true);
      QMReadEmlActivity.AttachListViewAdapter.access$5702(this.this$1, true);
      return false;
    case 2: 
      if (QMReadEmlActivity.access$2800(this.this$1.this$0).getWebView().getScrollY() != this.webViewScrollyWhenDown)
      {
        QMReadEmlActivity.AttachListViewAdapter.access$5902(this.this$1, false);
        QMReadEmlActivity.AttachListViewAdapter.access$5702(this.this$1, false);
        paramView.setPressed(false);
      }
      Math.abs((int)(this.mLastX - paramMotionEvent.getX()));
      this.mLastX = ((int)paramMotionEvent.getX());
      Math.abs((int)(this.mLastY - paramMotionEvent.getY()));
      this.mLastY = ((int)paramMotionEvent.getY());
      return false;
    case 3: 
      QMReadEmlActivity.AttachListViewAdapter.access$5902(this.this$1, false);
      return false;
    case 4: 
      QMReadEmlActivity.AttachListViewAdapter.access$5902(this.this$1, false);
      return false;
    }
    paramView.setLongClickable(false);
    QMReadEmlActivity.AttachListViewAdapter.access$5902(this.this$1, false);
    paramView.clearFocus();
    if (QMReadEmlActivity.AttachListViewAdapter.access$6000(this.this$1))
    {
      QMReadEmlActivity.AttachListViewAdapter.access$6002(this.this$1, false);
      return false;
    }
    QMReadEmlActivity.AttachListViewAdapter.access$6002(this.this$1, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.20
 * JD-Core Version:    0.7.0.1
 */