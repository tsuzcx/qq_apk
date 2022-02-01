package com.tencent.mobileqq.activity.aio.item;

import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;

class StructingMsgItemBuilder$5
  implements Runnable
{
  StructingMsgItemBuilder$5(StructingMsgItemBuilder paramStructingMsgItemBuilder, StructingMsgItemBuilder.a parama) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg getView report.........");
    }
    String str2 = "";
    String str1;
    if ((this.a.sessionInfo != null) && (this.a.mMessage != null)) {
      if (this.a.sessionInfo.cZ == 1)
      {
        str1 = this.a.sessionInfo.aTl;
        str2 = this.a.mMessage.senderuin;
      }
    }
    for (;;)
    {
      PortalManager localPortalManager = (PortalManager)this.this$0.app.getManager(79);
      if (localPortalManager != null) {}
      for (int j = localPortalManager.Ho();; j = -1)
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8004FF9", "0X8004FF9", 0, 0, "" + j, "" + i, "" + str1, str2);
        return;
        i = 2;
        break;
      }
      str1 = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */