package com.tencent.mobileqq.search.util;

import amxe;
import amxf;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import jpa;

public class PAOfflineSearchManager$1$1
  implements Runnable
{
  public PAOfflineSearchManager$1$1(amxf paramamxf) {}
  
  public void run()
  {
    String str = jpa.dL("1011");
    if ((str == null) || (TextUtils.equals(str, ""))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PAOfflineSearchManager", 2, "callback get current ver:" + str + ", local ver:" + this.a.b.ccn);
      }
    } while ((str.equals(this.a.b.ccn)) && (!str.equals("0")));
    this.a.b.needUpdate = true;
    this.a.b.ccn = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager.1.1
 * JD-Core Version:    0.7.0.1
 */