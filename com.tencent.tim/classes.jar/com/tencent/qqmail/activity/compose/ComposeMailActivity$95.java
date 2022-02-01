package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMTips;

class ComposeMailActivity$95
  implements Runnable
{
  ComposeMailActivity$95(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    ComposeMailActivity.access$10000(this.this$0).showError(this.this$0.getString(2131696462));
    ComposeMailActivity.access$11300(this.this$0);
    ComposeMailActivity.access$4402(this.this$0, ComposeMailActivity.SendMailStatus.SENDFAIL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.95
 * JD-Core Version:    0.7.0.1
 */