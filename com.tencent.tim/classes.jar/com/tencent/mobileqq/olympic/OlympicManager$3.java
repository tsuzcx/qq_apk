package com.tencent.mobileqq.olympic;

import com.tencent.qphone.base.util.QLog;

class OlympicManager$3
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "refreshUI tryDownloadActResource in Prepare ");
    }
    OlympicManager.a(this.this$0, this.this$0.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.3
 * JD-Core Version:    0.7.0.1
 */