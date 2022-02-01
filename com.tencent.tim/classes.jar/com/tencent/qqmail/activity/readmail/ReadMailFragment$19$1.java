package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$19$1
  implements Runnable
{
  ReadMailFragment$19$1(ReadMailFragment.19 param19) {}
  
  public void run()
  {
    boolean bool = ReadMailFragment.access$7100(this.this$1.this$0, ReadMailFragment.access$200(this.this$1.this$0));
    if (!ReadMailFragment.access$7100(this.this$1.this$0, ReadMailFragment.access$200(this.this$1.this$0))) {
      ReadMailFragment.access$5900(this.this$1.this$0);
    }
    if (bool) {
      ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695602));
    }
    for (;;)
    {
      QMLog.log(4, "ReadMailFragment", "spamWatcher onSuccess");
      return;
      ReadMailFragment.access$1500(this.this$1.this$0, this.this$1.this$0.getString(2131695615));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.19.1
 * JD-Core Version:    0.7.0.1
 */