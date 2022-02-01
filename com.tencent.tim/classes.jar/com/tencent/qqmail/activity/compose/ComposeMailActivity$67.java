package com.tencent.qqmail.activity.compose;

import java.util.List;

class ComposeMailActivity$67
  implements Runnable
{
  ComposeMailActivity$67(ComposeMailActivity paramComposeMailActivity, List paramList) {}
  
  public void run()
  {
    if (this.this$0.composeView != null) {
      this.this$0.composeView.updateContactArray(this.val$contacts, ComposeMailActivity.access$7900(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.67
 * JD-Core Version:    0.7.0.1
 */