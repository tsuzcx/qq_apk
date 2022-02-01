package com.tencent.mobileqq.activity.contacts.topentry;

import android.util.SparseArray;
import aqgt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import zbq;

public class CTEntryMng$2
  implements Runnable
{
  public CTEntryMng$2(zbq paramzbq, SparseArray paramSparseArray) {}
  
  public void run()
  {
    String str = zbq.a(this.this$0, this.bL);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveEntryRedDot value: %s", new Object[] { str }));
    }
    aqgt.q(zbq.a(this.this$0).getApp(), zbq.a(this.this$0).getCurrentUin(), "ct_entry_reddot_info", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2
 * JD-Core Version:    0.7.0.1
 */