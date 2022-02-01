package com.tencent.mobileqq.activity.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PeakService$1
  implements Runnable
{
  PeakService$1(PeakService paramPeakService) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "peak service start MediaScanner.doScan()");
    }
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).doScan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService.1
 * JD-Core Version:    0.7.0.1
 */