package com.tencent.mobileqq.activity;

import anen;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import jji;
import mqq.app.NewIntent;
import ujt;
import ujt.c;

public final class ChatActivityFacade$2
  implements Runnable
{
  public ChatActivityFacade$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    ujt.i(this.val$app, this.a);
    long l;
    NewIntent localNewIntent;
    if ((ujt.d(this.val$app, this.a)) || (ujt.c(this.val$app, this.a, true)))
    {
      l = ujt.d(this.val$app, this.a);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded    last publish time:" + l);
      }
      localNewIntent = new NewIntent(this.val$app.getApplication(), anen.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(this.val$app.getCurrentAccountUin()));
    }
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { jji.B(this.a.aTl) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      if (this.aTp)
      {
        localNewIntent.putExtra("src", i);
        if (this.a != null)
        {
          ujt.c localc2 = (ujt.c)ujt.k().get(this.a.aTl);
          ujt.c localc1 = localc2;
          if (localc2 == null)
          {
            localc1 = new ujt.c();
            ujt.k().put(this.a.aTl, localc1);
          }
          localc1.bV = new WeakReference(this.val$app);
          localc1.sessionInfo = this.a;
          localc1.aTr = this.aTp;
          this.val$app.registObserver(localc1);
          this.val$app.startServlet(localNewIntent);
        }
        ujt.c(this.val$app, this.a, "key_last_req_aio_feeds_time");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "Long.valueOf " + this.a.aTl);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.2
 * JD-Core Version:    0.7.0.1
 */