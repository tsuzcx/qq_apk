package com.tencent.mobileqq.activity.contact.phonecontact;

import ajdo.a;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$10
  implements Runnable
{
  PhoneContactManagerImp$10(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      try
      {
        Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((ajdo.a)localIterator.next()).sc(this.this$0.cbf);
        }
        localObject = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.10
 * JD-Core Version:    0.7.0.1
 */