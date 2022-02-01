package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import wro;
import wsa;

class LoadDataJob$1
  implements Runnable
{
  LoadDataJob$1(LoadDataJob paramLoadDataJob, wro paramwro, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel begin:");
    }
    this.this$0.a(this.b, LoadDataJob.a(this.this$0, this.this$0.mFile, false));
    if (this.this$0.e(this.rO, LoadDataJob.b(this.this$0, this.this$0.mFile, false)))
    {
      Iterator localIterator = this.rO.iterator();
      while (localIterator.hasNext()) {
        ((wsa)localIterator.next()).cbs();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel end:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.1
 * JD-Core Version:    0.7.0.1
 */