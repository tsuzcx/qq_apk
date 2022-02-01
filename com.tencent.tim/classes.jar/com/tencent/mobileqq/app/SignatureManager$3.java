package com.tencent.mobileqq.app;

import aqqr;
import aqqs;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SignatureManager$3
  implements Runnable
{
  public void run()
  {
    this.this$0.be.set(this.val$id);
    aqqs localaqqs = aqqr.a(this.this$0.mApp, this.val$id);
    if (localaqqs != null) {
      SignatureManager.ek.put(Integer.valueOf(this.val$id), localaqqs);
    }
    this.this$0.be.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.3
 * JD-Core Version:    0.7.0.1
 */