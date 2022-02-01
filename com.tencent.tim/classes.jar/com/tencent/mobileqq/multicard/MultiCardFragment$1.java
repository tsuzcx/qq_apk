package com.tencent.mobileqq.multicard;

import ajjj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class MultiCardFragment$1
  implements Runnable
{
  MultiCardFragment$1(MultiCardFragment paramMultiCardFragment, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    Object localObject1 = MultiCardFragment.a(this.this$0);
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      Object localObject3;
      label279:
      Map.Entry localEntry;
      if (QLog.isColorLevel())
      {
        if (this.Dl != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateData uinlist: ");
          ((StringBuilder)localObject2).append(this.Dl.size());
          ((StringBuilder)localObject2).append("  ");
          localObject3 = this.Dl.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next());
            ((StringBuilder)localObject2).append(" ");
          }
          QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.lW != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateData intimateinfo map: ");
          ((StringBuilder)localObject2).append(this.lW.size());
          ((StringBuilder)localObject2).append("  ");
          localObject3 = this.lW.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((StringBuilder)localObject2).append(((Map.Entry)((Iterator)localObject3).next()).getKey());
            ((StringBuilder)localObject2).append(" ");
          }
          QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.lX != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateData name map: ");
          ((StringBuilder)localObject2).append(this.lX.size());
          ((StringBuilder)localObject2).append("  ");
          localObject3 = this.lX.entrySet().iterator();
          if (((Iterator)localObject3).hasNext()) {
            localEntry = (Map.Entry)((Iterator)localObject3).next();
          }
        }
      }
      try
      {
        ((StringBuilder)localObject2).append(String.valueOf((Long)localEntry.getKey()));
        label317:
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localEntry.getValue());
        ((StringBuilder)localObject2).append(" ");
        break label279;
        QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
        localObject2 = ((ajjj)localObject1).bl(this.Dl);
        localObject3 = ((ajjj)localObject1).h(this.lW);
        localObject1 = ((ajjj)localObject1).i(this.lX);
        if ((localObject2 != null) && (localObject3 == null))
        {
          MultiCardFragment.a(this.this$0, -1);
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.1(this, (List)localObject2, (Map)localObject3, (Map)localObject1));
          return;
        }
        if ((localObject2 == null) && (localObject3 != null))
        {
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.2(this, (List)localObject2, (Map)localObject3, (Map)localObject1));
          return;
        }
        if ((localObject2 == null) && (localObject3 == null))
        {
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.3(this, (Map)localObject1));
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MultiCardFragment", 2, "updatedata err");
        return;
      }
      catch (Exception localException)
      {
        break label317;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1
 * JD-Core Version:    0.7.0.1
 */