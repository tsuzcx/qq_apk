package com.tencent.tim.cloudfile.troopFile;

import apcy;
import attf;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class AutoRetryManager$3
  implements Runnable
{
  public void run()
  {
    FileManagerEntity localFileManagerEntity2 = AutoRetryManager.a(this.this$0).a().i(this.g.FilePath);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = audx.a(this.g);
    }
    ThreadManager.executeOnSubThread(new AutoRetryManager.3.1(this, localFileManagerEntity1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3
 * JD-Core Version:    0.7.0.1
 */