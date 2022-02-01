package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$108
  implements Runnable
{
  ReadMailFragment$108(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    ReadMailFragment.access$16900(this.this$0);
    if (ReadMailFragment.access$2300(this.this$0) != null) {
      ReadMailFragment.access$2300(this.this$0).clearResourceLoader();
    }
    ReadMailFragment.access$17000(this.this$0);
    this.this$0.refreshData(true);
    if (ReadMailFragment.access$17100(this.this$0)) {
      ReadMailFragment.access$9100(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.108
 * JD-Core Version:    0.7.0.1
 */