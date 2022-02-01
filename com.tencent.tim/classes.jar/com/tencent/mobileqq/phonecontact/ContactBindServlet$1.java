package com.tencent.mobileqq.phonecontact;

import akwn;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ContactBindServlet$1
  implements Runnable
{
  public ContactBindServlet$1(akwn paramakwn, Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Servlet", 2, "handleQueryContactV3 run in Threadmanager");
    }
    try
    {
      akwn.a(this.this$0, this.ak, this.h);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Servlet", 1, "handleQueryContactV3 fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindServlet.1
 * JD-Core Version:    0.7.0.1
 */