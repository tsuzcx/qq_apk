package com.tencent.mobileqq.mixedmsg;

import ajcy;
import akxj;
import ambj;
import anbi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import wte;

public class MixedMsgManager$1
  implements Runnable
{
  public MixedMsgManager$1(ajcy paramajcy, SessionInfo paramSessionInfo, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.app.getAccount();
    int j = this.a.cZ;
    String str = this.a.aTl;
    Object localObject2 = this.a.troopUin;
    localObject2 = anbi.a(this.this$0.app, str, (String)localObject2, j);
    int i;
    if (this.bES == 0)
    {
      i = this.c.forwardID;
      wte.a().i(((MessageForMixedMsg)localObject2).uniseq, this.c.uniseq, i);
      ((MessageForMixedMsg)localObject2).extraflag = 32772;
      ((MessageForMixedMsg)localObject2).msgData = this.c.msgData;
      ((MessageForMixedMsg)localObject2).msgElemList = this.c.msgElemList;
      if (this.cny) {
        break label208;
      }
      ((MessageForMixedMsg)localObject2).mForwardFromIsTroop = this.c.istroop;
      ((MessageForMixedMsg)localObject2).mForwardFromUin = this.c.frienduin;
    }
    for (;;)
    {
      localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          localMessageRecord.istroop = j;
        }
      }
      i = this.bES;
      break;
      label208:
      ((MessageForMixedMsg)localObject2).mIsResend = true;
    }
    ((MessageForMixedMsg)localObject2).prewrite();
    Object localObject3 = (ambj)this.this$0.app.getManager(326);
    ((ambj)localObject3).p(str, this.c.uniseq, ((MessageForMixedMsg)localObject2).uniseq);
    ((ambj)localObject3).d((MessageRecord)localObject2, null);
    this.this$0.app.a().notifyUI(1000, true, str);
    localObject3 = new ArrayList();
    localObject1 = akxj.a(7, (MessageForMixedMsg)localObject2, j, (String)localObject1, str, this.this$0.app.getAccount());
    if (localObject1 != null) {
      ((ArrayList)localObject3).addAll((Collection)localObject1);
    }
    while (((ArrayList)localObject3).size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]Upload pictures, count is [" + ((ArrayList)localObject3).size() + "], goto requestUploadPics");
      }
      ajcy.a(this.this$0, this.this$0.app, str, j, (ArrayList)localObject3, (MessageForMixedMsg)localObject2);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MixedMsgManager", 2, "[forwardMixedMsg]createForwardPicInfos from MessageForMixedMsg failed");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]There's not any picture messages, goto onPackAndSendMsg");
    }
    ajcy.a(this.this$0, this.this$0.app, str, j, (MessageForMixedMsg)localObject2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.1
 * JD-Core Version:    0.7.0.1
 */