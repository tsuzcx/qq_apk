package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.AttachInfo;

class ComposeMailActivity$41
  implements Runnable
{
  ComposeMailActivity$41(ComposeMailActivity paramComposeMailActivity, AttachInfo paramAttachInfo) {}
  
  public void run()
  {
    if (this.val$info.canCopyToSandBox())
    {
      ComposeMailActivity.access$5400(this.this$0).notifyDataSetChanged();
      ComposeMailActivity.access$5500(this.this$0);
    }
    if (this.this$0.hasClickSaveDraft) {
      ComposeMailActivity.access$3900(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.41
 * JD-Core Version:    0.7.0.1
 */