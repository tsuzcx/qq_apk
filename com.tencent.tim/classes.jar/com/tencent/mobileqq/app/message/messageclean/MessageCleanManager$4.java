package com.tencent.mobileqq.app.message.messageclean;

import acsf;
import acsn;
import java.util.Iterator;
import java.util.List;

public class MessageCleanManager$4
  implements Runnable
{
  public MessageCleanManager$4(acsn paramacsn, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$itemInfoList.iterator();
    while (localIterator.hasNext())
    {
      acsf localacsf = (acsf)localIterator.next();
      acsn.a(this.this$0, localacsf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */