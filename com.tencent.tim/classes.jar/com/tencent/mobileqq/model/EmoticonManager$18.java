package com.tencent.mobileqq.model;

import ajdg;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import yhf;

public class EmoticonManager$18
  implements Runnable
{
  public EmoticonManager$18(ajdg paramajdg, String paramString) {}
  
  public void run()
  {
    String str;
    synchronized (this.this$0)
    {
      this.this$0.em.drop(EmoticonTab.class.getSimpleName());
      EntityTransaction localEntityTransaction = this.this$0.em.getTransaction();
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = this.this$0.CR.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          ajdg.a(this.this$0, str, true, false);
          continue;
          localObject2 = finally;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
    Object localObject5 = this.this$0.CS.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      str = (String)((Iterator)localObject5).next();
      ajdg.a(this.this$0, str, false, true);
    }
    localObject2.commit();
    localObject2.end();
    Object localObject3 = this.this$0.az(this.bQO);
    if (localObject3 == null) {
      return;
    }
    ??? = new HashSet();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (Emoticon)((Iterator)localObject3).next();
      if (((Emoticon)localObject5).name != null) {
        ((HashSet)???).add(((Emoticon)localObject5).name);
      }
    }
    yhf.a(this.this$0.app).f((Collection)???);
    this.this$0.Ml(this.bQO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.18
 * JD-Core Version:    0.7.0.1
 */