package com.tencent.mobileqq.location.net;

import aiqn;
import aira;
import aira.a;
import android.os.Handler;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(aira paramaira) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((aira.a(this.this$0) != null) && (aira.a(this.this$0).b() != null)))
    {
      aira.a(this.this$0, ((Integer)aira.a(this.this$0).o().first).intValue());
      aira.a(this.this$0, Long.valueOf(Long.parseLong((String)aira.a(this.this$0).o().second)));
      aiqn localaiqn = aira.a(this.this$0).b();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + aira.a(this.this$0) + "], sessionUin = [" + aira.a(this.this$0) + "], locationItem = [" + localaiqn + "]" });
      }
      if (aira.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(aira.a(this.this$0)), " sessionUin: ", aira.a(this.this$0), " locationItem: ", localaiqn });
        }
        return;
      }
      this.this$0.a(aira.a(this.this$0), aira.a(this.this$0).longValue(), localaiqn);
    }
    for (;;)
    {
      aira.a(this.this$0).postDelayed(this, aira.access$400());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", aira.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */