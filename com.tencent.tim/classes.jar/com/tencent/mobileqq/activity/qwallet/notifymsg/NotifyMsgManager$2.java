package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aaca.a;
import aagd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

public final class NotifyMsgManager$2
  implements Runnable
{
  public NotifyMsgManager$2(ArrayList paramArrayList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.val$list.iterator();
      while (localIterator.hasNext())
      {
        aaca.a locala = (aaca.a)localIterator.next();
        if ((locala != null) && (locala.o != null)) {
          localQQAppInterface.b().a(locala.o.frienduin, locala.o.istroop, locala.o.uniseq, "extStr", locala.o.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */