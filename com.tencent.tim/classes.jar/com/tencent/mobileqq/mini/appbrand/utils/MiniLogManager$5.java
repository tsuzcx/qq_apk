package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

final class MiniLogManager$5
  implements Runnable
{
  MiniLogManager$5(String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = new File(this.val$logPath).listFiles();
    Object localObject1;
    ArrayList localArrayList;
    String str;
    Object localObject3;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      long l = MiniLogManager.access$400();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      int j = localObject2.length;
      int i = 0;
      if (i < j)
      {
        str = localObject2[i];
        if (str.length() == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(MiniLogManager.access$100(), 2, "file:" + str.getName() + " size is 0");
          }
          str.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          localObject3 = str.getName();
          if ((l < str.lastModified()) && ((((String)localObject3).endsWith(".log")) || (((String)localObject3).endsWith(".log.zip")) || (((String)localObject3).endsWith(".qlog")))) {
            ((ArrayList)localObject1).add(new MiniLogManager.LogFile(str.getPath()));
          }
          if ((((String)localObject3).contains("log")) && (!((String)localObject3).endsWith(".zip"))) {
            localArrayList.add(new MiniLogManager.LogFile(str.getPath()));
          }
        }
      }
    }
    try
    {
      str = MiniLogManager.access$700().format(Long.valueOf(System.currentTimeMillis()));
      localObject2 = this.val$logPath + "nativeLog_" + str + ".zip";
      str = this.val$logPath + "miniLog_" + str + ".zip";
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject3 = new File((String)localObject2);
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        ((File)localObject3).createNewFile();
        MiniLogManager.zipFiles((ArrayList)localObject1, (String)localObject2);
        MiniLogManager.upload(this.val$appId, (String)localObject2, 4, this.val$miniVersion);
      }
      if (localArrayList.size() > 0)
      {
        localObject1 = new File(str);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        ((File)localObject1).createNewFile();
        MiniLogManager.zipFiles(localArrayList, str);
        MiniLogManager.upload(this.val$appId, str, 5, this.val$miniVersion);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(MiniLogManager.access$100(), 1, "compressAndUploadLog error " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.5
 * JD-Core Version:    0.7.0.1
 */