package com.tencent.mobileqq.contactsync;

import aevy;
import com.tencent.qphone.base.util.QLog;

public class ContactSyncManager$2
  implements Runnable
{
  public ContactSyncManager$2(aevy paramaevy) {}
  
  public void run()
  {
    try
    {
      this.this$0.aih();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.2
 * JD-Core Version:    0.7.0.1
 */