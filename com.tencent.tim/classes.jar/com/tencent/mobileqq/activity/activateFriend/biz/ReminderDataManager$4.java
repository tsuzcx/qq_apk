package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wii;

public class ReminderDataManager$4
  implements Runnable
{
  public void run()
  {
    File[] arrayOfFile = wii.b(this.this$0, wii.a(this.this$0));
    if (arrayOfFile.length > 0)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (QLog.isColorLevel()) {
          QLog.i(wii.access$500(), 2, "delete file name: " + localFile.getName());
        }
        if ((localFile != null) && (localFile.isFile()) && (localFile.exists()))
        {
          AcsMsg localAcsMsg = this.this$0.a(localFile);
          if (aqhq.deleteFile(localFile.getAbsolutePath())) {
            wii.a(this.this$0, localAcsMsg);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.4
 * JD-Core Version:    0.7.0.1
 */