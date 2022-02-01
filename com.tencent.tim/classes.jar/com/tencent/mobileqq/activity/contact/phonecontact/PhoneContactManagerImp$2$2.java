package com.tencent.mobileqq.activity.contact.phonecontact;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import yuo;

public class PhoneContactManagerImp$2$2
  implements Runnable
{
  public PhoneContactManagerImp$2$2(yuo paramyuo) {}
  
  public void run()
  {
    try
    {
      this.a.this$0.pref.edit().putLong("contact_last_query_list_time", this.a.this$0.KD).apply();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, String.format("save last query time: %s", new Object[] { Long.valueOf(this.a.this$0.KD) }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.2.2
 * JD-Core Version:    0.7.0.1
 */