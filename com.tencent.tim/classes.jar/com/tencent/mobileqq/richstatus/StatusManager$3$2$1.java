package com.tencent.mobileqq.richstatus;

import amfk;
import amhj;
import amhm;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (amhj.b(this.a.a.e) != null)
    {
      Iterator localIterator = amhj.b(this.a.a.e).iterator();
      if (localIterator.hasNext())
      {
        amfk localamfk = (amfk)localIterator.next();
        if (this.a.val$isSuccess) {}
        for (int i = 100;; i = -1)
        {
          localamfk.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */