package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import java.util.Date;

class ComposeMailActivity$65$1
  implements Runnable
{
  ComposeMailActivity$65$1(ComposeMailActivity.65 param65, ComposeData paramComposeData) {}
  
  public void run()
  {
    ComposeMailActivity.access$7400(this.this$1.this$0, this.val$composeData);
    ComposeMailActivity.access$1700(this.this$1.this$0).sortData();
    boolean bool = this.this$1.this$0.hasDiffer();
    ComposeMailActivity.access$1700(this.this$1.this$0).setDefaultSelect(ComposeMailActivity.access$7500(this.this$1.this$0));
    ComposeMailActivity.access$7600(this.this$1.this$0, ComposeMailActivity.access$7500(this.this$1.this$0));
    if (!bool)
    {
      ComposeMailActivity.access$7700(this.this$1.this$0, this.this$1.this$0.composeMail, true);
      ComposeMailActivity.access$4702(this.this$1.this$0, this.this$1.this$0.composeMail.toString());
      ComposeMailActivity.access$4802(this.this$1.this$0, this.this$1.this$0.composeMail.getInformation().getDate().getTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.65.1
 * JD-Core Version:    0.7.0.1
 */