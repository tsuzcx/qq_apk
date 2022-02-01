package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

final class ReportLogUtil$2
  implements Runnable
{
  ReportLogUtil$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new File(this.val$logPath).listFiles();
    ArrayList localArrayList;
    File localFile;
    if ((localObject != null) && (localObject.length > 0))
    {
      localArrayList = new ArrayList();
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        localFile = localObject[i];
        if (localFile.length() == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReportLogUtil", 2, "file:" + localFile.getName() + " size is 0");
          }
          localFile.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          String str = localFile.getName();
          if ((str.contains("log")) && (!str.endsWith(".zip"))) {
            localArrayList.add(new MiniLogManager.LogFile(localFile.getPath()));
          }
        }
      }
    }
    try
    {
      localObject = ReportLogUtil.access$000().format(Long.valueOf(System.currentTimeMillis()));
      localObject = this.val$logPath + "miniLog_" + (String)localObject + ".zip";
      if (localArrayList.size() > 0)
      {
        localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        localFile.createNewFile();
        ReportLogUtil.zipFiles(localArrayList, (String)localObject);
        ReportLogUtil.uploadLogAndReport(this.val$appId, (String)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReportLogUtil", 1, "compressAndUploadLog error " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.2
 * JD-Core Version:    0.7.0.1
 */