package com.tencent.qqmail.activity.compose;

import android.view.View;

class ComposeMailActivity$21$1
  implements Runnable
{
  ComposeMailActivity$21$1(ComposeMailActivity.21 param21) {}
  
  public void run()
  {
    if (this.this$1.this$0.composeView != null)
    {
      this.this$1.this$0.composeView.setScrollable(true);
      ((View)this.this$1.this$0.composeView).setVerticalScrollBarEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.21.1
 * JD-Core Version:    0.7.0.1
 */