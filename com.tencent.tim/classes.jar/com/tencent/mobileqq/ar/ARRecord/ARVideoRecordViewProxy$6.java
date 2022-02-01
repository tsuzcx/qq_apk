package com.tencent.mobileqq.ar.ARRecord;

import adco;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordViewProxy$6
  implements Runnable
{
  public ARVideoRecordViewProxy$6(adco paramadco, int paramInt) {}
  
  public void run()
  {
    if (this.aJf == 0)
    {
      adco.a(this.this$0).setShowState(2);
      adco.a(this.this$0);
      adco.a(this.this$0, 0);
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_NORMAL_MODE");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.aJf != 1);
      adco.a(this.this$0).setShowState(3);
      adco.a(this.this$0).setVisibility(0);
      adco.b(this.this$0).setVisibility(0);
      adco.a(this.this$0, 1);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6
 * JD-Core Version:    0.7.0.1
 */