package com.tencent.mobileqq.filemanager.core;

import agkl;
import ahav;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;

public class FileManagerRSWorker$3
  implements Runnable
{
  public FileManagerRSWorker$3(agkl paramagkl) {}
  
  public void run()
  {
    if (this.this$0.actionType == 0)
    {
      if (this.this$0.serverPath != null)
      {
        this.this$0.aj(this.this$0.serverPath, 0L);
        return;
      }
      this.this$0.alA();
      return;
    }
    if (this.this$0.serverPath.equalsIgnoreCase(""))
    {
      this.this$0.dhp();
      return;
    }
    try
    {
      if (this.this$0.c != null) {
        this.this$0.c.flush();
      }
      this.this$0.YD = ahav.getFileSizes(this.this$0.bHJ);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.this$0.nSessionId + "]retry request Httpmsg,rd[" + String.valueOf(this.this$0.YD) + "]");
      agkl.a(this.this$0, this.this$0.YD, this.this$0.bHM);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.3
 * JD-Core Version:    0.7.0.1
 */