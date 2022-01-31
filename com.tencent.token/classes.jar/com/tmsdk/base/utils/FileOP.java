package com.tmsdk.base.utils;

import android.content.Context;
import android.os.storage.StorageManager;
import btmsdkobf.dz;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import tmsdk.QQPIM.CommList;

public class FileOP
{
  public static FileOP.CheckResult check(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramInt4 < 2000) {
      paramInt4 = 0;
    }
    for (;;)
    {
      return dz.check(paramInt1, paramString, paramInt3, paramInt2, paramArrayOfByte, paramInt4);
    }
  }
  
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    return dz.copyFile(paramFile1, paramFile2);
  }
  
  public static boolean deleteDir(File paramFile)
  {
    return dz.deleteDir(paramFile);
  }
  
  public static boolean deleteFile(String paramString)
  {
    return dz.deleteFile(paramString);
  }
  
  public static String getAssetWupFile(String paramString, boolean paramBoolean)
  {
    return dz.getAssetWupFile(paramString, paramBoolean);
  }
  
  public static List getStoragePathList()
  {
    StorageManager localStorageManager = (StorageManager)TMSDKBaseContext.getApplicationContext().getSystemService("storage");
    localArrayList = new ArrayList();
    try
    {
      Object[] arrayOfObject = (Object[])localStorageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(localStorageManager, new Object[0]);
      if ((arrayOfObject != null) && (arrayOfObject.length > 0))
      {
        Method localMethod1 = arrayOfObject[0].getClass().getDeclaredMethod("getPath", new Class[0]);
        Method localMethod2 = localStorageManager.getClass().getMethod("getVolumeState", new Class[] { String.class });
        int j = arrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          String str = (String)localMethod1.invoke(arrayOfObject[i], new Object[0]);
          if (str != null) {
            if ("mounted".equals(localMethod2.invoke(localStorageManager, new Object[] { str }))) {
              localArrayList.add(str);
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static CommList loadWupObjectFromFile(String paramString1, String paramString2)
  {
    return dz.loadWupObjectFromFile(paramString1, paramString2);
  }
  
  public static boolean traverseFolder(String paramString, FileFilter paramFileFilter, FileOP.IFoundListener paramIFoundListener)
  {
    boolean bool2 = true;
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramIFoundListener != null))
    {
      paramString = paramString.listFiles(paramFileFilter);
      boolean bool1;
      if ((paramString == null) || (paramString.length == 0)) {
        bool1 = false;
      }
      int i;
      File localFile;
      do
      {
        return bool1;
        int j = paramString.length;
        i = 0;
        if (i >= j) {
          break label106;
        }
        localFile = paramString[i];
        if (!localFile.isDirectory()) {
          break;
        }
        bool1 = bool2;
      } while (traverseFolder(localFile.getAbsolutePath(), paramFileFilter, paramIFoundListener));
      while (!paramIFoundListener.onFound(localFile))
      {
        i += 1;
        break;
      }
      return true;
    }
    label106:
    return false;
  }
  
  public static int update(FileOP.CheckResult paramCheckResult)
  {
    return dz.update(paramCheckResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.FileOP
 * JD-Core Version:    0.7.0.1
 */