package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.observer.ICallBack;

class MailAddrsViewControl$15
  implements ICallBack
{
  MailAddrsViewControl$15(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void callback(Object paramObject)
  {
    boolean bool = ((Boolean)paramObject).booleanValue();
    if (((!MailAddrsViewControl.access$2000(this.this$0)) && (bool)) || ((MailAddrsViewControl.access$2000(this.this$0)) && (!bool))) {
      this.this$0.setExpanded(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.15
 * JD-Core Version:    0.7.0.1
 */