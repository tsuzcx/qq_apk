package com.tencent.mobileqq.activity.aio.helper;

import aalz;
import acxw;
import aizp;
import aptq;
import aptr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wxj;

public class TroopNotificationAIOHelper$2
  implements Runnable
{
  public TroopNotificationAIOHelper$2(wxj paramwxj) {}
  
  public void run()
  {
    int i = 1;
    if (wxj.a(this.this$0) == null) {}
    label12:
    Object localObject;
    label207:
    do
    {
      break label12;
      break label12;
      do
      {
        return;
      } while (wxj.a(this.this$0).app == null);
      acxw localacxw = wxj.a(this.this$0).app.a().a();
      RecentUser localRecentUser = localacxw.a(wxj.a(this.this$0).oL(), 1);
      localObject = aptr.a(wxj.a(this.this$0).app, wxj.a(this.this$0).oL());
      if ((localObject != null) && (!((aptq)localObject).crj.isEmpty())) {}
      for (;;)
      {
        localObject = wxj.a(this.this$0).app.getHandler(Conversation.class);
        if (i != 0) {
          break;
        }
        if (aizp.a().J(wxj.a(this.this$0).app, wxj.a(this.this$0).oL())) {
          break label207;
        }
        if (!(localRecentUser.msg instanceof aalz)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
        }
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localacxw.e(localRecentUser);
        if (localObject == null) {
          break;
        }
        ((MqqHandler)localObject).sendEmptyMessage(1009);
        return;
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationAIOHelper", 2, "remove recent user on stop.");
      }
      localacxw.b(localRecentUser, false);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */