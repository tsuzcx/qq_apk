package com.tencent.mobileqq.activity.aio.ecommerce;

import aeif;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;
import wsz.a;
import wta;

public final class ECommerceDataReportUtil$1
  implements Runnable
{
  public ECommerceDataReportUtil$1(QQAppInterface paramQQAppInterface, WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    try
    {
      wsz.a locala = (wsz.a)aeif.a().o(592);
      if ((locala != null) && (locala.gK != null) && (!locala.gK.isEmpty()))
      {
        wta.c(locala.gK);
        wta.access$102(this.val$app.getCurrentAccountUin());
        wta.c((QQAppInterface)this.ad.get(), this.val$content, this.val$type, this.Lz);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ECommerceDataReportUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1
 * JD-Core Version:    0.7.0.1
 */