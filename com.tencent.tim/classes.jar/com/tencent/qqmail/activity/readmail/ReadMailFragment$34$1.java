package com.tencent.qqmail.activity.readmail;

import android.widget.LinearLayout;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;

class ReadMailFragment$34$1
  implements Runnable
{
  ReadMailFragment$34$1(ReadMailFragment.34 param34, int paramInt, MailBigAttach paramMailBigAttach) {}
  
  public void run()
  {
    int i = ReadMailFragment.AttachListViewAdapter.access$10100(ReadMailFragment.access$2000(this.this$1.this$0)) + this.val$mailBigAttachPosition;
    ReadMailFragment.AttachListViewAdapter.access$10200(ReadMailFragment.access$2000(this.this$1.this$0), ReadMailFragment.access$8400(this.this$1.this$0).getChildAt(i), this.val$mailBigAttach, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.34.1
 * JD-Core Version:    0.7.0.1
 */