package com.tencent.mobileqq.mini.appbrand;

class JsErrorGuard$5
  implements Runnable
{
  JsErrorGuard$5(JsErrorGuard paramJsErrorGuard, int paramInt) {}
  
  public void run()
  {
    if (this.val$result == JsErrorGuard.access$1000()) {
      return;
    }
    if ((this.val$result == JsErrorGuard.access$1100()) || (this.val$result == JsErrorGuard.access$1200()))
    {
      JsErrorGuard.access$100(this.this$0);
      return;
    }
    JsErrorGuard.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.5
 * JD-Core Version:    0.7.0.1
 */