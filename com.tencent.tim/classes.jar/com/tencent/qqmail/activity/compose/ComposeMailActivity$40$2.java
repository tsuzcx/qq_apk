package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.raw.QMRawComposeView;

class ComposeMailActivity$40$2
  implements Runnable
{
  ComposeMailActivity$40$2(ComposeMailActivity.40 param40) {}
  
  public void run()
  {
    if (!this.this$1.this$0.isDestroyed())
    {
      ComposeMailActivity.access$4200(this.this$1.this$0);
      this.this$1.this$0.composeView.setScrollable(true);
      ((QMRawComposeView)this.this$1.this$0.composeView).scrollTo(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.40.2
 * JD-Core Version:    0.7.0.1
 */