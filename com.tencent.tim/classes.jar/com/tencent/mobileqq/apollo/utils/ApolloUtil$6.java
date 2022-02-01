package com.tencent.mobileqq.apollo.utils;

import abxi;
import android.content.SharedPreferences;
import apqw;
import aqhq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class ApolloUtil$6
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = ApolloUtil.q();
        Object localObject = new File(abxi.biF);
        if (!((File)localObject).exists()) {
          break;
        }
        if (!((File)localObject).isDirectory()) {
          return;
        }
        if (aqhq.getFileOrFolderSize(abxi.biF) <= 104857600L) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        if (localObject == null) {
          break;
        }
        localObject = Arrays.asList((Object[])localObject);
        Collections.sort((List)localObject, ApolloUtil.J);
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        File localFile = (File)localIterator.next();
        int i = 0;
        if ((localFile != null) && (localFile.exists()))
        {
          String str = localFile.getName();
          if ((str.endsWith(".patch")) || (str.endsWith(".patched")))
          {
            localFile.delete();
            i = 1;
          }
          localObject = str;
          if (str.endsWith(".zip")) {
            localObject = str.substring(0, str.indexOf("."));
          }
          if (apqw.isNumeric((String)localObject))
          {
            long l1 = localSharedPreferences.getLong((String)localObject, 0L);
            long l2 = NetConnInfoCenter.getServerTimeMillis();
            if ((l2 - l1 > 2592000000L) && (l2 - localFile.lastModified() > 2592000000L))
            {
              if (QLog.isColorLevel()) {
                QLog.i("ApolloUtil", 2, "time limit delete file:" + localFile.getName());
              }
              localFile.delete();
              i = 1;
              if (i != 0)
              {
                l1 = aqhq.getFileOrFolderSize(abxi.biF);
                if (l1 < 104857600L)
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("ApolloUtil", 2, "delete finish,new size:" + l1);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "deleteGameResIfNeed error:", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.6
 * JD-Core Version:    0.7.0.1
 */