package com.tencent.tim.cloudfile;

import atnc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CloudFileHandler$22
  implements Runnable
{
  public void run()
  {
    if (atnc.a("0", this.f.frienduin, this.f.bisID, this.f.url, this.f.fileSize, this.f.fileName) != null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("CloudFileHandler", 2, "local_file_to_cloud saveFileToCloudInGroup suc");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CloudFileHandler", 1, "local_file_to_cloud saveFileToCloudInGroup Exception = " + localException.toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "local_file_to_cloud saveFileToCloudInGroup error");
    }
    ThreadManager.getUIHandler().post(new CloudFileHandler.22.1(this));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileHandler.22
 * JD-Core Version:    0.7.0.1
 */