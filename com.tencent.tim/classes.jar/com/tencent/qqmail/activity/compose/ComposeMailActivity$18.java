package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.ui.QMTips;

class ComposeMailActivity$18
  implements ComposeMailActivity.LoadComposeMailCallback
{
  ComposeMailActivity$18(ComposeMailActivity paramComposeMailActivity, QMTips paramQMTips) {}
  
  public void onBeforeLoadComposeMail()
  {
    ComposeMailActivity.access$2502(this.this$0, 1);
    this.val$tmpLoadingView.setCallback(new ComposeMailActivity.18.1(this));
  }
  
  public void onLoadedComposeMail(ComposeMailUI paramComposeMailUI)
  {
    if (ComposeMailActivity.access$2500(this.this$0) == 1)
    {
      ComposeMailActivity.access$2502(this.this$0, 3);
      this.val$tmpLoadingView.hide();
      ComposeMailActivity.access$2600(this.this$0, paramComposeMailUI);
    }
    for (;;)
    {
      this.val$tmpLoadingView.recycle();
      return;
      ComposeMailActivity.access$2700(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.18
 * JD-Core Version:    0.7.0.1
 */