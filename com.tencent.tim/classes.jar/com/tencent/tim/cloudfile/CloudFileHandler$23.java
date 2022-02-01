package com.tencent.tim.cloudfile;

import atnc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CloudFileHandler$23
  implements Runnable
{
  public void run()
  {
    try
    {
      if (atnc.a("", this.b.peerUin, this.b.busId, this.b.Uuid, this.b.fileSize, this.b.fileName) != null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("CloudFileHandler", 2, "local_file_to_cloud saveFileToCloudReal suc");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "local_file_to_cloud saveFileToCloudReal error");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CloudFileHandler", 1, "local_file_to_cloud saveFileToCloudReal Exception = " + localException.toString());
      }
    }
    ThreadManager.getUIHandler().post(new CloudFileHandler.23.1(this));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileHandler.23
 * JD-Core Version:    0.7.0.1
 */