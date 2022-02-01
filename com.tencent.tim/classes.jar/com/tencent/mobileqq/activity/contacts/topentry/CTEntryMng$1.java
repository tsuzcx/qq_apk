package com.tencent.mobileqq.activity.contacts.topentry;

import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import zbq;

public class CTEntryMng$1
  implements Runnable
{
  public CTEntryMng$1(zbq paramzbq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "read sp and init config");
    }
    String str = aqmj.k(zbq.a(this.this$0).getApp(), zbq.a(this.this$0).getCurrentUin(), "contact_top_entry_config");
    zbq.a(this.this$0, false, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1
 * JD-Core Version:    0.7.0.1
 */