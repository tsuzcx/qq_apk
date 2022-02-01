package com.tencent.mobileqq.ar.ARRecord;

import adcl;
import adcn;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordUIControllerImpl$7
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$7(adcl paramadcl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate progress=%s", new Object[] { Integer.valueOf(1) }));
    if (adcl.a(this.this$0)) {
      adcl.a(this.this$0).he(this.val$duration, this.val$fileSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.7
 * JD-Core Version:    0.7.0.1
 */