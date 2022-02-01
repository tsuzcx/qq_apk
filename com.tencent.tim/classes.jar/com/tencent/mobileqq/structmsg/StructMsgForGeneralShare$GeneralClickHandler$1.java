package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class StructMsgForGeneralShare$GeneralClickHandler$1
  implements Runnable
{
  StructMsgForGeneralShare$GeneralClickHandler$1(StructMsgForGeneralShare.a parama, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.val$params.containsKey("msgSeq")) && (this.val$params.containsKey("uin")) && (this.val$params.containsKey("sessionType")))
    {
      l = this.val$params.getLong("msgSeq");
      localObject = this.val$params.getString("uin");
      i = this.val$params.getInt("sessionType");
      localQQMessageFacade = this.this$0.mApp.b();
      localObject = localQQMessageFacade.a((String)localObject, i, l);
      ((MessageRecord)localObject).saveExtInfoToExtStr("receipt_msg_is_read", "1");
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject).extLong));
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extStr", ((MessageRecord)localObject).extStr);
    }
    while (!QLog.isColorLevel())
    {
      long l;
      Object localObject;
      int i;
      QQMessageFacade localQQMessageFacade;
      return;
    }
    QLog.w(StructMsgForGeneralShare.access$000(), 2, "set receipt msg read missing param");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.1
 * JD-Core Version:    0.7.0.1
 */