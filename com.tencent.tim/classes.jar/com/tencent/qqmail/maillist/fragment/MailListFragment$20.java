package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;

class MailListFragment$20
  implements Runnable
{
  MailListFragment$20(MailListFragment paramMailListFragment, ConcurrentHashSet paramConcurrentHashSet) {}
  
  public void run()
  {
    long[] arrayOfLong = new long[this.val$hitMailId.size()];
    Iterator localIterator = this.val$hitMailId.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
      i += 1;
    }
    QMMailManager.sharedInstance().updateMailRencetOpTime(arrayOfLong);
    QMLog.log(2, "MailListFragment", "update mail rencetOpTime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.20
 * JD-Core Version:    0.7.0.1
 */