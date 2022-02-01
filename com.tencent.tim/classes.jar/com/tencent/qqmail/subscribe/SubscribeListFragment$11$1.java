package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.model.uidomain.MailOperate;

class SubscribeListFragment$11$1
  implements Runnable
{
  SubscribeListFragment$11$1(SubscribeListFragment.11 param11, SubscribeMailUI paramSubscribeMailUI) {}
  
  public void run()
  {
    SubscribeListFragment.access$900(this.this$1.this$0).deleteMail(SubscribeListFragment.access$1600(this.this$1.this$0), this.val$mail.getSubscribe().getMid(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.11.1
 * JD-Core Version:    0.7.0.1
 */