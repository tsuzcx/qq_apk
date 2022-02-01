package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnLongClickListener;

class ReadMailFragment$AttachListViewAdapter$10
  implements View.OnLongClickListener
{
  ReadMailFragment$AttachListViewAdapter$10(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!ReadMailFragment.AttachListViewAdapter.access$21400(this.this$1)) {
      return false;
    }
    ReadMailFragment.AttachListViewAdapter.access$21502(this.this$1, true);
    int i = ((Integer)paramView.getTag()).intValue();
    ReadMailFragment.access$21300(this.this$1.this$0, i, paramView, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.10
 * JD-Core Version:    0.7.0.1
 */