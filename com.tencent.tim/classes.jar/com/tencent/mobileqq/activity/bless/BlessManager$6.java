package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;

public class BlessManager$6
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "checkAndDownloadJson begin");
    }
    VasQuickUpdateManager.getJSONFromLocal(this.b, "blessVoiceList.json", true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.6
 * JD-Core Version:    0.7.0.1
 */