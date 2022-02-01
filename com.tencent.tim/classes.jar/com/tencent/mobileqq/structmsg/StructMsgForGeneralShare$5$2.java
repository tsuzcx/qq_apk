package com.tencent.mobileqq.structmsg;

import anot;
import anrl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;

public class StructMsgForGeneralShare$5$2
  implements Runnable
{
  public StructMsgForGeneralShare$5$2(anrl paramanrl, StructingMsgItemBuilder.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg getView report.........");
    }
    String str2 = "";
    String str1;
    if ((this.b.sessionInfo != null) && (this.b.mMessage != null)) {
      if (this.b.sessionInfo.cZ == 1)
      {
        str1 = this.b.sessionInfo.aTl;
        str2 = this.b.mMessage.senderuin;
      }
    }
    for (;;)
    {
      PortalManager localPortalManager = (PortalManager)this.t.getManager(79);
      if (localPortalManager != null) {}
      for (int j = localPortalManager.Ho();; j = -1)
      {
        anot.a(this.t, "CliOper", "", "", "0X8004FFA", "0X8004FFA", 0, 0, "" + j, "" + i, "" + str1, str2);
        return;
        i = 2;
        break;
      }
      str1 = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.2
 * JD-Core Version:    0.7.0.1
 */