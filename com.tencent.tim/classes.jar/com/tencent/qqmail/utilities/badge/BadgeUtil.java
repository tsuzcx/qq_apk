package com.tencent.qqmail.utilities.badge;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;

public class BadgeUtil
{
  public static final String TAG = BadgeUtil.class.getSimpleName();
  private static volatile BadgeUtil instance;
  private int currUnReadCount = 0;
  
  public static BadgeUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BadgeUtil();
      }
      return instance;
    }
    finally {}
  }
  
  private void setCompleteBadgesAccordingQMAccount()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    String str = "";
    int i = 0;
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      int j = QMMailManager.sharedInstance().getCliAccountUnreadCount(localAccount.getId(), true);
      i += j;
      str = str + "[" + localAccount.getEmail() + " has badges: " + j + "]、";
    }
    if (this.currUnReadCount != i) {
      QMLog.log(4, TAG, "Complete Badge changes from：" + this.currUnReadCount + " to：" + i + " they are：" + str);
    }
  }
  
  public void clearBadge()
  {
    setBadge(0);
  }
  
  public boolean isSupportBadge()
  {
    return false;
  }
  
  public void setBadge(int paramInt)
  {
    QMLog.log(4, TAG, "Update Badge to " + paramInt);
    this.currUnReadCount = Math.min(paramInt, 99);
  }
  
  public void setBadgeAccordingNotification(int paramInt) {}
  
  public void setBadgeAccordingQMAccount() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.badge.BadgeUtil
 * JD-Core Version:    0.7.0.1
 */