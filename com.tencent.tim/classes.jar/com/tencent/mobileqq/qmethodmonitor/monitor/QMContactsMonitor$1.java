package com.tencent.mobileqq.qmethodmonitor.monitor;

import alky;
import allb;
import alld;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public final class QMContactsMonitor$1
  implements Runnable
{
  public QMContactsMonitor$1(String paramString1, Uri paramUri, String[] paramArrayOfString, String paramString2, Throwable paramThrowable) {}
  
  public void run()
  {
    boolean bool = alky.isAppOnForeground();
    if ((this.bXd.contains("com.android.contacts")) && (!bool))
    {
      StringBuilder localStringBuilder = alld.b(this.M, this.gk);
      QLog.e("QMContactsMonitor", 1, this.val$msg + localStringBuilder.toString(), this.val$t);
      allb.h("qm_contacts", "ContentResolver.query(U[SS[SS)" + localStringBuilder.toString(), this.val$t);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.QMContactsMonitor.1
 * JD-Core Version:    0.7.0.1
 */