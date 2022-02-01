package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.view.FolderLockDialog;

class ReadMailFragment$30$2
  implements Runnable
{
  ReadMailFragment$30$2(ReadMailFragment.30 param30) {}
  
  public void run()
  {
    ReadMailFragment.access$9000(this.this$1.this$0).cancelDialog();
    ReadMailFragment.access$9000(this.this$1.this$0).dismissTips();
    ReadMailFragment.access$9000(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.30.2
 * JD-Core Version:    0.7.0.1
 */