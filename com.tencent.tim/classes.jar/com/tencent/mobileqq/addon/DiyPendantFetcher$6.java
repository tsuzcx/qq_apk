package com.tencent.mobileqq.addon;

import abgl;
import abgl.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiyPendantFetcher$6
  implements Runnable
{
  public DiyPendantFetcher$6(abgl paramabgl) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.E.iterator();
    while (localIterator.hasNext())
    {
      abgl.a locala = (abgl.a)localIterator.next();
      if ((locala != null) && (locala.L() != null))
      {
        if (!localHashSet.contains(locala))
        {
          localHashSet.add(locala);
          locala.invalidateSelf();
          this.this$0.E.remove(locala);
        }
      }
      else {
        this.this$0.E.remove(locala);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "wait for refresh size: " + this.this$0.E.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.6
 * JD-Core Version:    0.7.0.1
 */