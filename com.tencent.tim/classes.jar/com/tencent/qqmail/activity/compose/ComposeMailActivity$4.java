package com.tencent.qqmail.activity.compose;

class ComposeMailActivity$4
  implements Runnable
{
  ComposeMailActivity$4(ComposeMailActivity paramComposeMailActivity, ComposeAddrView paramComposeAddrView) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    while (this.this$0.composeView == null) {
      return;
    }
    this.this$0.composeView.autoScrollHeader(this.val$addressView, ComposeMailActivity.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.4
 * JD-Core Version:    0.7.0.1
 */