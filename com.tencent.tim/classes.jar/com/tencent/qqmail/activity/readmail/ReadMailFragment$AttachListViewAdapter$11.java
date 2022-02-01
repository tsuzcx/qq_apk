package com.tencent.qqmail.activity.readmail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadMailFragment$AttachListViewAdapter$11
  implements View.OnLongClickListener
{
  ReadMailFragment$AttachListViewAdapter$11(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!ReadMailFragment.AttachListViewAdapter.access$21400(this.this$1)) {
      return false;
    }
    ReadMailFragment.AttachListViewAdapter.access$21502(this.this$1, true);
    paramView.cancelLongPress();
    paramView.clearFocus();
    int i = ((Integer)paramView.getTag()).intValue();
    if (!ReadMailFragment.access$21600(this.this$1.this$0, i)) {
      ReadMailFragment.access$21300(this.this$1.this$0, i, paramView, true);
    }
    if (ReadMailFragment.access$2300(this.this$1.this$0).getWebView() != null)
    {
      paramView = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      ReadMailFragment.access$2300(this.this$1.this$0).getWebView().dispatchTouchEvent(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.11
 * JD-Core Version:    0.7.0.1
 */