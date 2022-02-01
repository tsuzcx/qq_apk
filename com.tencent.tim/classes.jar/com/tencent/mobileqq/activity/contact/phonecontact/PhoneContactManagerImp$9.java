package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class PhoneContactManagerImp$9
  implements Runnable
{
  PhoneContactManagerImp$9(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    Object localObject1 = PhoneContactManagerImp.a(this.this$0).getTransaction();
    ((EntityTransaction)localObject1).begin();
    try
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).values().iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend)
        {
          localPhoneContact.isNewRecommend = false;
          PhoneContactManagerImp.a(this.this$0).update(localPhoneContact);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).end();
    }
    ((EntityTransaction)localObject1).end();
    localObject1 = PhoneContactManagerImp.a(this.this$0);
    if (localObject1 != null) {
      ((ContactBinded)localObject1).isReaded = true;
    }
    PhoneContactManagerImp.c(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.9
 * JD-Core Version:    0.7.0.1
 */