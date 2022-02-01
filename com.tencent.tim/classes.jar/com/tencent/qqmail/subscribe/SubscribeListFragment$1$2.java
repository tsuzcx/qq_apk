package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;

class SubscribeListFragment$1$2
  implements Runnable
{
  SubscribeListFragment$1$2(SubscribeListFragment.1 param1, QMSubscribeColumnCursor paramQMSubscribeColumnCursor) {}
  
  public void run()
  {
    this.val$listCursor.refresh(false, new SubscribeListFragment.1.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.1.2
 * JD-Core Version:    0.7.0.1
 */