package com.tencent.mobileqq.mini.appbrand;

import acfp;

class JsErrorGuard$6
  implements Runnable
{
  JsErrorGuard$6(JsErrorGuard paramJsErrorGuard, int paramInt) {}
  
  public void run()
  {
    if ((JsErrorGuard.access$1300(this.this$0) != null) && (JsErrorGuard.access$1300(this.this$0).isShowing())) {
      JsErrorGuard.access$1300(this.this$0).setTitle(acfp.m(2131707530) + this.val$progress + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.6
 * JD-Core Version:    0.7.0.1
 */