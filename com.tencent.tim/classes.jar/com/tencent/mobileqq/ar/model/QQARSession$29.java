package com.tencent.mobileqq.ar.model;

import adid;
import adku;

public class QQARSession$29
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.cHX != 2) || (!adku.a(this.this$0))) {
      return;
    }
    if (this.this$0.a != null) {
      this.this$0.a.b(false, adku.a(this.this$0), adku.b(this.this$0));
    }
    adku.a(this.this$0, 0);
    this.this$0.bOs = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.29
 * JD-Core Version:    0.7.0.1
 */