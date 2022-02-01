package com.tencent.qqmail.activity.compose;

import android.widget.HorizontalScrollView;

class ComposeMailActivity$113
  implements Runnable
{
  ComposeMailActivity$113(ComposeMailActivity paramComposeMailActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    while (ComposeMailActivity.access$13800(this.this$0) == null) {
      return;
    }
    ComposeMailActivity.access$13800(this.this$0).smoothScrollTo(this.val$width, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.113
 * JD-Core Version:    0.7.0.1
 */