package com.tencent.mobileqq.ar.model;

import adid;
import adku;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$28
  implements Runnable
{
  public QQARSession$28(adku paramadku) {}
  
  public void run()
  {
    if ((this.this$0.cHX != 2) || (!adku.a(this.this$0)))
    {
      QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
      return;
    }
    if (this.this$0.aeU())
    {
      this.this$0.cSn();
      adku.c(this.this$0, 0L);
      adku.a(this.this$0, null);
      adku.b(this.this$0, null);
    }
    this.this$0.iM(5L);
    adku.e(this.this$0);
    this.this$0.bOr = false;
    if (this.this$0.a != null) {
      this.this$0.a.b(true, adku.a(this.this$0), adku.b(this.this$0));
    }
    adku.a(this.this$0, 1);
    this.this$0.bOs = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */