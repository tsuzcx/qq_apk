package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.view.QMReadMailView;
import com.tencent.qqmail.view.ReadMailDetailView;

class ReadMailFragment$55
  implements Runnable
{
  ReadMailFragment$55(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    if (ReadMailFragment.access$2400(this.this$0) != null) {
      ReadMailFragment.access$2400(this.this$0).setStatus(1);
    }
    ReadMailFragment.access$6300(this.this$0);
    if (ReadMailFragment.access$11900(this.this$0) != null) {
      ReadMailFragment.access$11900(this.this$0).setShowDetail(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.55
 * JD-Core Version:    0.7.0.1
 */