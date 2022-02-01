package com.tencent.mobileqq.activity;

import acff;
import albz;
import anaz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$4
  implements Runnable
{
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.val$app.getManager(51)).a(this.a.aTl);
    long l1;
    long l2;
    label38:
    long l3;
    if (localExtensionInfo == null)
    {
      l1 = 0L;
      if (localExtensionInfo != null) {
        break label185;
      }
      l2 = 0L;
      if (localExtensionInfo != null) {
        break label194;
      }
      l3 = 0L;
      label46:
      long l4 = anaz.gQ();
      if ((l4 <= 0L) || (l4 - l1 <= 604800L)) {
        break label204;
      }
    }
    label185:
    label194:
    label204:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade", 2, String.format("insertFriendPLNewsIfNeeded latest:%d last:%d pull:%d overWeek:%b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool) }));
      }
      if ((l1 > l2) && (!bool) && (System.currentTimeMillis() / 1000L - l3 >= 86400L)) {
        ((albz)this.val$app.getBusinessHandler(112)).l(this.a.aTl, l2, l1);
      }
      return;
      l1 = localExtensionInfo.latestPLUpdateTimestamp;
      break;
      l2 = localExtensionInfo.lastPLNewsTimestamp;
      break label38;
      l3 = localExtensionInfo.lastPullPLNewsTimestamp;
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.4
 * JD-Core Version:    0.7.0.1
 */