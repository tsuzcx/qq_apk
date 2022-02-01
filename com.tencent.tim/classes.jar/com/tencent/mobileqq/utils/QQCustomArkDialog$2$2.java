package com.tencent.mobileqq.utils;

import android.app.Activity;
import aqjn;
import aqjp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$2$2
  implements Runnable
{
  public QQCustomArkDialog$2$2(aqjp paramaqjp) {}
  
  public void run()
  {
    if (aqjn.a(this.a.this$0) != null) {}
    for (Activity localActivity = (Activity)aqjn.a(this.a.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      this.a.this$0.show();
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog onloadcallback activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.2
 * JD-Core Version:    0.7.0.1
 */