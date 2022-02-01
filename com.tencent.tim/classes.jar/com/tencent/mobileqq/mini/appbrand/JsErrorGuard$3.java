package com.tencent.mobileqq.mini.appbrand;

import com.tencent.qphone.base.util.QLog;

class JsErrorGuard$3
  implements Runnable
{
  JsErrorGuard$3(JsErrorGuard paramJsErrorGuard) {}
  
  public void run()
  {
    if ((JsErrorGuard.access$000(this.this$0) == null) || (JsErrorGuard.access$000(this.this$0).activity == null) || (JsErrorGuard.access$000(this.this$0).isFirstDomReady) || (JsErrorGuard.access$300(this.this$0))) {
      return;
    }
    QLog.e("miniapp-start_JsConsoleGuard", 1, "start X5 guide.");
    JsErrorGuard.access$302(this.this$0, true);
    try
    {
      JsErrorGuard.access$400(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start_JsConsoleGuard", 1, "start X5 guide exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.3
 * JD-Core Version:    0.7.0.1
 */