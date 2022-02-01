package com.tencent.mobileqq.bubble;

import adxn;
import adyk;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(adxn paramadxn, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.E.iterator();
    while (localIterator.hasNext())
    {
      adyk localadyk = (adyk)localIterator.next();
      if ((localadyk != null) && (localadyk.getCallback() != null))
      {
        String str = localadyk.bwm;
        if ((this.cg.contains(str)) && (!localHashSet.contains(localadyk)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localadyk.toString());
          }
          localHashSet.add(localadyk);
          localadyk.invalidateSelf();
          this.this$0.E.remove(localadyk);
        }
      }
      else
      {
        this.this$0.E.remove(localadyk);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.this$0.E.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */