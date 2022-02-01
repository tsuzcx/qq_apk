package com.tencent.mobileqq.filemanager.core;

import aglz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$2
  implements Runnable
{
  public UniformDownloadMgr$2(aglz paramaglz) {}
  
  public void run()
  {
    try
    {
      if (aglz.a(this.this$0) != null)
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(aglz.a(this.this$0));
        aglz.a(this.this$0, null);
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST");
        return;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST, had unRegister");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */