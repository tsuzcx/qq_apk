package com.tencent.qqmail.utilities.qmnetwork.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;

class QMSocketTimer$1
  extends TimerTask
{
  QMSocketTimer$1(QMSocketTimer paramQMSocketTimer) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (QMSocketTimer.access$100(this.this$0))
    {
      Iterator localIterator = QMSocketTimer.access$100(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        QMSocketTimer.QMSocketPacket localQMSocketPacket2 = (QMSocketTimer.QMSocketPacket)((Map.Entry)localIterator.next()).getValue();
        localQMSocketPacket2.timeCount += 1;
        if (localQMSocketPacket2.timeCount > 10) {
          localArrayList.add(localQMSocketPacket2);
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      QMSocketTimer.QMSocketPacket localQMSocketPacket1 = (QMSocketTimer.QMSocketPacket)((Iterator)???).next();
      localQMSocketPacket1.respondTimeout();
      QMSocketTimer.access$100(this.this$0).remove(localQMSocketPacket1.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMSocketTimer.1
 * JD-Core Version:    0.7.0.1
 */