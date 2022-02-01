package com.tencent.qqmail.activity.readmail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadMailFragment$AttachListViewAdapter$13
  implements View.OnTouchListener
{
  private int mLastX;
  private int mLastY;
  private int webViewScrollyWhenDown = 0;
  
  ReadMailFragment$AttachListViewAdapter$13(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getParent() != null) && (paramView.getParent().getParent() != null) && ((paramView.getParent().getParent() instanceof View))) {
      ((View)paramView.getParent().getParent()).setTag(Boolean.valueOf(false));
    }
    if ((ReadMailFragment.access$2300(this.this$1.this$0) == null) || (ReadMailFragment.access$2300(this.this$1.this$0).getWebView() == null)) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.webViewScrollyWhenDown = ReadMailFragment.access$2300(this.this$1.this$0).getWebView().getScrollY();
      ReadMailFragment.AttachListViewAdapter.access$21502(this.this$1, false);
      this.mLastX = ((int)paramMotionEvent.getX());
      this.mLastY = ((int)paramMotionEvent.getY());
      ReadMailFragment.AttachListViewAdapter.access$21402(this.this$1, true);
      ReadMailFragment.AttachListViewAdapter.access$21202(this.this$1, true);
      return false;
    case 2: 
      if (ReadMailFragment.access$2300(this.this$1.this$0).getWebView().getScrollY() != this.webViewScrollyWhenDown)
      {
        ReadMailFragment.AttachListViewAdapter.access$21402(this.this$1, false);
        ReadMailFragment.AttachListViewAdapter.access$21202(this.this$1, false);
        paramView.setPressed(false);
      }
      Math.abs((int)(this.mLastX - paramMotionEvent.getX()));
      this.mLastX = ((int)paramMotionEvent.getX());
      Math.abs((int)(this.mLastY - paramMotionEvent.getY()));
      this.mLastY = ((int)paramMotionEvent.getY());
      return false;
    case 3: 
      ReadMailFragment.AttachListViewAdapter.access$21402(this.this$1, false);
      return false;
    case 4: 
      ReadMailFragment.AttachListViewAdapter.access$21402(this.this$1, false);
      return false;
    }
    paramView.setLongClickable(false);
    ReadMailFragment.AttachListViewAdapter.access$21402(this.this$1, false);
    paramView.clearFocus();
    if (ReadMailFragment.AttachListViewAdapter.access$21500(this.this$1))
    {
      ReadMailFragment.AttachListViewAdapter.access$21502(this.this$1, false);
      return false;
    }
    ReadMailFragment.AttachListViewAdapter.access$21502(this.this$1, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.13
 * JD-Core Version:    0.7.0.1
 */