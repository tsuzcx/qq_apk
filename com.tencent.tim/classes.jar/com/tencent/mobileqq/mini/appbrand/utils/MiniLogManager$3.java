package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

final class MiniLogManager$3
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        Object localObject = new File(MiniLog.getMiniLogFolderPath());
        if (((File)localObject).exists())
        {
          localObject = ((File)localObject).listFiles();
          if (localObject != null)
          {
            if (localObject.length == 0) {
              return;
            }
            int m = localObject.length;
            i = 0;
            if (i < m)
            {
              File[] arrayOfFile1 = localObject[i].listFiles();
              if ((arrayOfFile1 == null) || (arrayOfFile1.length == 0)) {
                break label354;
              }
              int n = arrayOfFile1.length;
              j = 0;
              if (j >= n) {
                break label354;
              }
              File[] arrayOfFile2 = arrayOfFile1[j].listFiles();
              if ((arrayOfFile2 == null) || (arrayOfFile2.length == 0)) {
                break label361;
              }
              Arrays.sort(arrayOfFile2, MiniLogManager.access$300());
              long l = MiniLogManager.access$400();
              str = MiniLogManager.access$500();
              int i1 = arrayOfFile2.length;
              k = 0;
              if (k >= i1) {
                break label361;
              }
              localFile = arrayOfFile2[k];
              if (localFile.getName().contains("log")) {
                break label368;
              }
              if ((l > localFile.lastModified()) || (localFile.lastModified() > System.currentTimeMillis() + 3600000L))
              {
                localFile.delete();
                if (!QLog.isColorLevel()) {
                  break label368;
                }
                QLog.d(MiniLogManager.access$100(), 2, "del expires log " + localFile.getName());
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        File localFile;
        if (QLog.isColorLevel())
        {
          QLog.d(MiniLogManager.access$100(), 2, localException, new Object[0]);
          return;
          if ((!localFile.getName().endsWith(".log")) || ((localFile.lastModified() >= System.currentTimeMillis() - 3600000L) && (!localFile.getName().contains(str))) || (!MiniLogManager.access$600(localFile))) {
            break label368;
          }
          localFile.delete();
          if (!QLog.isColorLevel()) {
            break label368;
          }
          QLog.d(MiniLogManager.access$100(), 2, "compress log success " + localFile.getName());
        }
      }
      return;
      label354:
      i += 1;
      continue;
      label361:
      j += 1;
      continue;
      label368:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.3
 * JD-Core Version:    0.7.0.1
 */