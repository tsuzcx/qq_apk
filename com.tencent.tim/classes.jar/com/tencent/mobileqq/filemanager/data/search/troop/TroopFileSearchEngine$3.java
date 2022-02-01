package com.tencent.mobileqq.filemanager.data.search.troop;

import agny;
import agoo;
import agor;
import amwe;
import apen;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(agoo paramagoo, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (agoo.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.val$isSuccess)
    {
      localObject = new ArrayList();
      if ((this.jr != null) && (!this.jr.isEmpty()))
      {
        if (agoo.a(this.this$0) == null) {
          agoo.b(this.this$0, new ArrayList());
        }
        agoo.a(this.this$0).addAll(this.jr);
        Iterator localIterator = agoo.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          apen localapen = (apen)localIterator.next();
          ((List)localObject).add(new agor(agoo.a(this.this$0), agoo.a(this.this$0), agoo.a(this.this$0), localapen));
        }
      }
      agoo.a(this.this$0).s((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - agoo.a(this.this$0);
      localObject = agoo.a(this.this$0).vo();
      if ((!((String)localObject).equals(agoo.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + agoo.a(this.this$0) + "] timeInterval[" + l + "]");
        agoo.a(this.this$0);
        agoo.a(this.this$0, (String)localObject);
        agoo.a(this.this$0, agoo.a(this.this$0));
      }
      return;
      agoo.a(this.this$0).s(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */