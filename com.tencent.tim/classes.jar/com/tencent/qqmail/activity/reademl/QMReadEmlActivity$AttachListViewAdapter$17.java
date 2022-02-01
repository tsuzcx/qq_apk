package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnLongClickListener;

class QMReadEmlActivity$AttachListViewAdapter$17
  implements View.OnLongClickListener
{
  QMReadEmlActivity$AttachListViewAdapter$17(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!QMReadEmlActivity.AttachListViewAdapter.access$5900(this.this$1)) {
      return false;
    }
    QMReadEmlActivity.AttachListViewAdapter.access$6002(this.this$1, true);
    ((Integer)paramView.getTag()).intValue();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.17
 * JD-Core Version:    0.7.0.1
 */