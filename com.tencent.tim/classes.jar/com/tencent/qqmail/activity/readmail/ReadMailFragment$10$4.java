package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$10$4
  implements Runnable
{
  ReadMailFragment$10$4(ReadMailFragment.10 param10, long paramLong) {}
  
  public void run()
  {
    if ((this.val$mailId == ReadMailFragment.access$400(this.this$1.this$0)) && (ReadMailFragment.access$2400(this.this$1.this$0).getStatus() != 0))
    {
      if (ReadMailFragment.access$4700(this.this$1.this$0)) {
        break label72;
      }
      if (ReadMailFragment.access$2900(this.this$1.this$0, true)) {
        ReadMailFragment.access$4800(this.this$1.this$0);
      }
    }
    return;
    label72:
    ReadMailFragment.access$4300(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.10.4
 * JD-Core Version:    0.7.0.1
 */