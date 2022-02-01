package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.utilities.observer.ICallBack;

class ComposeMailActivity$65
  implements ICallBack
{
  ComposeMailActivity$65(ComposeMailActivity paramComposeMailActivity) {}
  
  public void callback(Object paramObject)
  {
    if ((ComposeMailActivity.access$4400(this.this$0) == ComposeMailActivity.SendMailStatus.SENDCLOSED) || (ComposeMailActivity.access$1700(this.this$0) == null)) {
      return;
    }
    paramObject = (ComposeData)paramObject;
    ComposeMailActivity.access$7800(this.this$0, new ComposeMailActivity.65.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.65
 * JD-Core Version:    0.7.0.1
 */