package com.tencent.mobileqq.search.rich;

import amuf;
import com.tencent.qphone.base.util.QLog;

public class ArkNodeContainer$1
  implements Runnable
{
  public ArkNodeContainer$1(amuf paramamuf, String paramString) {}
  
  public void run()
  {
    this.this$0.mExtraTimerRecord.getAppFromLocal = true;
    this.this$0.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
    }
    this.this$0.loadArkApp(this.val$appPath, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeContainer.1
 * JD-Core Version:    0.7.0.1
 */