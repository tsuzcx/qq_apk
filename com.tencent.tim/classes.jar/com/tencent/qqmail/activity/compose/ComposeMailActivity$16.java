package com.tencent.qqmail.activity.compose;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$16
  implements PickSenderViewControl.SenderPickerViewControlCallback
{
  ComposeMailActivity$16(ComposeMailActivity paramComposeMailActivity) {}
  
  public void didSelectRow(PickSenderViewControl paramPickSenderViewControl, int paramInt)
  {
    if (paramPickSenderViewControl == ComposeMailActivity.access$1700(this.this$0))
    {
      ComposeMailActivity.access$1800(this.this$0, paramPickSenderViewControl.getChooseAccountId(), paramPickSenderViewControl.getChooseName());
      ComposeMailActivity.access$1900(this.this$0);
      if (this.this$0.composeMail.isDraft())
      {
        this.this$0.composeMail.setFwdType(8);
        ComposeMailActivity.access$2002(this.this$0, 8);
      }
      ComposeMailActivity.access$2100(this.this$0);
    }
  }
  
  public void dismissSenderPickerView(View paramView) {}
  
  public Activity getSenderActivity()
  {
    return this.this$0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.16
 * JD-Core Version:    0.7.0.1
 */