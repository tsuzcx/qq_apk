package com.tencent.mobileqq.teamwork.spread;

import aeur;
import aeus;
import anaz;
import aocs.a;
import aoda;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopFileAIOMsgTips$1
  implements Runnable
{
  public TroopFileAIOMsgTips$1(aoda paramaoda, aocs.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "sub Thread getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    long l1 = anaz.gQ();
    ArrayList localArrayList = new ArrayList();
    int i = aeus.a().getMaxCount();
    List localList = this.this$0.mApp.b().a(this.this$0.mUin, 1, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2017 }, i);
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.this$0.dNX + "]");
      }
      this.a.mv(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "current AIO msg count[" + localList.size() + "]");
    }
    long l2 = aeus.a().CC() * 3600;
    i = 0;
    if (i < localList.size())
    {
      Object localObject = (MessageRecord)localList.get(i);
      if (!(localObject instanceof MessageForTroopFile)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((this.this$0.q.uniseq != ((MessageRecord)localObject).uniseq) && (new aoda(this.this$0.mApp, (ChatMessage)localObject, this.this$0.a).isSupport()))
        {
          localObject = (MessageForTroopFile)localObject;
          if (l1 - ((MessageForTroopFile)localObject).time <= l2) {
            localArrayList.add(((MessageForTroopFile)localObject).fileName);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "find file msg count[" + localArrayList.size() + "]");
    }
    this.a.mv(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */