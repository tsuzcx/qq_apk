package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.QMMailManager;

class SubscribeListFragment$6
  implements Runnable
{
  SubscribeListFragment$6(SubscribeListFragment paramSubscribeListFragment, int paramInt) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().markSubscribeAllAsUnread(this.val$accountId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.6
 * JD-Core Version:    0.7.0.1
 */