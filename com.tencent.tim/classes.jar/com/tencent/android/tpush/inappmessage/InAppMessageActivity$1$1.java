package com.tencent.android.tpush.inappmessage;

import com.tencent.android.tpush.inappmessage.a.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;
import java.util.HashMap;

class InAppMessageActivity$1$1
  implements Runnable
{
  InAppMessageActivity$1$1(InAppMessageActivity.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      d locald = new d(new a("center_popup", this.a, "message_id"));
      InAppMessageActivity.a(this.b.b, new c((InAppMessageActivity)InAppMessageActivity.a(this.b.b), locald, InAppMessageActivity.b(this.b.b)));
      InAppMessageActivity.c(this.b.b).show();
      ServiceStat.appReportSDKReceived(b.e(), InAppMessageActivity.b(this.b.b));
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("InAppMessageActivity", "init CenterPopup :" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.InAppMessageActivity.1.1
 * JD-Core Version:    0.7.0.1
 */