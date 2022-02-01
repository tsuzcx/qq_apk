package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jji;
import mqq.app.NewIntent;
import rxg;
import ujt;

public final class ChatActivityFacade$3
  implements Runnable
{
  public void run()
  {
    NewIntent localNewIntent;
    if (ujt.d(this.val$app, this.a, true))
    {
      long l = ujt.e(this.val$app, this.a);
      QLog.i("ChatActivityFacade.QZoneStoryFeeds", 1, "lastTime: " + l);
      localNewIntent = new NewIntent(this.val$app.getApplication(), rxg.class);
      localNewIntent.putExtra("key_last_aio_story_create_time", l);
    }
    try
    {
      localNewIntent.putExtra("key_friend_uid", jji.B(this.a.aTl));
      ujt.a().bV = new WeakReference(this.val$app);
      ujt.a().sessionInfo = this.a;
      localNewIntent.setObserver(ujt.a());
      this.val$app.startServlet(localNewIntent);
      ujt.c(this.val$app, this.a, "key_last_req_aio_story_feed_time");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneStoryFeeds", 1, "Long.valueOf " + this.a.aTl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.3
 * JD-Core Version:    0.7.0.1
 */