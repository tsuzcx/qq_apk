package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.qphone.base.util.QLog;
import yuo;

public class PhoneContactManagerImp$2$1
  implements Runnable
{
  public PhoneContactManagerImp$2$1(yuo paramyuo) {}
  
  public void run()
  {
    if (PhoneContactManagerImp.a(this.a.this$0)) {
      return;
    }
    this.a.this$0.boI = false;
    if (this.a.this$0.xy() <= 5) {
      try
      {
        this.a.cma();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("PhoneContact.Manager", 1, "onFirstRespQueryNotBindState fail!", localException1);
        return;
      }
    }
    try
    {
      this.a.cmb();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("PhoneContact.Manager", 1, "onFirstRespQueryState fail!", localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.2.1
 * JD-Core Version:    0.7.0.1
 */