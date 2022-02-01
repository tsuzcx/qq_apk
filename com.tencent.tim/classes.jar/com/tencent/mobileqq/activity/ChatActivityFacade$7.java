package com.tencent.mobileqq.activity;

import NS_QQ_STORY_META.META.StStoryFeed;
import anaz;
import android.util.Base64;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ujt;
import wkh;

public final class ChatActivityFacade$7
  implements Runnable
{
  public ChatActivityFacade$7(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, META.StStoryFeed paramStStoryFeed) {}
  
  public void run()
  {
    wkh localwkh;
    BeancurdMsg localBeancurdMsg;
    if (ujt.d(this.val$app, this.a, false))
    {
      localwkh = (wkh)this.val$app.getManager(282);
      localBeancurdMsg = new BeancurdMsg();
    }
    try
    {
      localBeancurdMsg.buffer = Base64.encodeToString(this.b.toByteArray(), 0);
      localBeancurdMsg.busiid = 7;
      localBeancurdMsg.frienduin = this.a.aTl;
      localBeancurdMsg.isNeedDelHistory = true;
      localBeancurdMsg.ispush = true;
      localBeancurdMsg.startTime = anaz.gQ();
      localBeancurdMsg.validTime = 604800L;
      localwkh.a(localBeancurdMsg);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ChatActivityFacade.byte encode to String", 2, "encode error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.7
 * JD-Core Version:    0.7.0.1
 */