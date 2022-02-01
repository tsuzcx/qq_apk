package com.tencent.mobileqq.activity.aio.rebuild;

import ajdr;
import android.os.Message;
import apbo;
import aptq;
import aptr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$24
  implements Runnable
{
  TroopChatPie$24(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.aSY) {}
    do
    {
      return;
      localObject = aptr.a(this.this$0.app, this.this$0.sessionInfo.aTl);
    } while ((localObject == null) || (((aptq)localObject).crj.isEmpty()));
    Object localObject = (ajdr)this.this$0.app.getManager(37);
    if (localObject != null) {
      ((ajdr)localObject).a(Long.valueOf(Long.parseLong(this.this$0.sessionInfo.aTl)), true).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = TroopChatPie.h(this.this$0).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopChatPie.i(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.24
 * JD-Core Version:    0.7.0.1
 */