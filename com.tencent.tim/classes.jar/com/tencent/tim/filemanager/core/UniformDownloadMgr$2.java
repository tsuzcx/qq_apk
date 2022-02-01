package com.tencent.tim.filemanager.core;

import ahcn;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$2
  implements Runnable
{
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    ahcn.a().dmo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */