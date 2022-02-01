package com.tencent.mobileqq.filemanager.app;

import agiq;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QFileConfigManager$1
  implements Runnable
{
  public QFileConfigManager$1(agiq paramagiq, HashMap paramHashMap) {}
  
  public void run()
  {
    if (this.kJ != null)
    {
      agiq.a(this.this$0).clear();
      agiq.a(this.this$0).putAll(this.kJ);
      QLog.i("QFileConfigManager", 1, "setFileDownloadConfig: set download config. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.1
 * JD-Core Version:    0.7.0.1
 */