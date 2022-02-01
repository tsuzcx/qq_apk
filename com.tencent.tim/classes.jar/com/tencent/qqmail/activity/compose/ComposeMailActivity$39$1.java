package com.tencent.qqmail.activity.compose;

import android.content.Intent;

class ComposeMailActivity$39$1
  implements Runnable
{
  ComposeMailActivity$39$1(ComposeMailActivity.39 param39) {}
  
  public void run()
  {
    ComposeMailActivity.access$4900(this.this$1.this$0, this.this$1.val$attachInfos);
    if ((ComposeMailActivity.access$5000(this.this$1.this$0)) && ("CONTROLLER_SCREENSHOT_REPLY".equals(this.this$1.this$0.getIntent().getStringExtra("toController"))))
    {
      ComposeMailActivity.access$5002(this.this$1.this$0, false);
      ComposeMailActivity.access$5100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.39.1
 * JD-Core Version:    0.7.0.1
 */