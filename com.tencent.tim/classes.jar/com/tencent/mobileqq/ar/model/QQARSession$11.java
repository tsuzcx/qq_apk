package com.tencent.mobileqq.ar.model;

import adio;
import adku;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$11
  implements Runnable
{
  public QQARSession$11(adku paramadku) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult. download resource timeout.");
    adku.a(this.this$0).cRV();
    this.this$0.b(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.11
 * JD-Core Version:    0.7.0.1
 */