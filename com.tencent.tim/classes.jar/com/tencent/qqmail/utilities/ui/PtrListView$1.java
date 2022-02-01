package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMRefreshingView;

class PtrListView$1
  implements Runnable
{
  PtrListView$1(PtrListView paramPtrListView) {}
  
  public void run()
  {
    if (PtrListView.access$000(this.this$0) == 5)
    {
      if (PtrListView.access$100(this.this$0) != null) {
        PtrListView.access$100(this.this$0).rotate(false);
      }
      PtrListView.access$200(this.this$0, 0, false, 0);
      return;
    }
    QMLog.log(4, "PtrListView", "wierd mState = " + PtrListView.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PtrListView.1
 * JD-Core Version:    0.7.0.1
 */