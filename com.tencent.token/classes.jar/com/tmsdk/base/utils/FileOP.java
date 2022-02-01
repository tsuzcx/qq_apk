package com.tmsdk.base.utils;

import android.content.Context;
import android.os.storage.StorageManager;
import btmsdkobf.dz;
import com.tencent.token.aqn;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FileOP
{
  public static CheckResult check(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramInt4 < 2000) {
      paramInt4 = 0;
    }
    return dz.check(paramInt1, paramString, paramInt3, paramInt2, paramArrayOfByte, paramInt4);
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
  
  public static List<String> getStoragePathList()
  {
    StorageManager localStorageManager = (StorageManager)TMSDKBaseContext.getApplicationContext().getSystemService("storage");
    ArrayList localArrayList = new ArrayList();
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
    return localArrayList;
  }
  
  public static aqn loadWupObjectFromFile(String paramString1, String paramString2)
  {
    return dz.loadWupObjectFromFile(paramString1, paramString2);
  }
  
  public static boolean traverseFolder(String paramString, FileFilter paramFileFilter, IFoundListener paramIFoundListener)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramIFoundListener != null))
    {
      paramString = paramString.listFiles(paramFileFilter);
      if (paramString != null)
      {
        if (paramString.length == 0) {
          return false;
        }
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramString[i];
          if (localFile.isDirectory())
          {
            if (traverseFolder(localFile.getAbsolutePath(), paramFileFilter, paramIFoundListener)) {
              return true;
            }
          }
          else if (paramIFoundListener.onFound(localFile)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static int update(CheckResult paramCheckResult)
  {
    return dz.update(paramCheckResult);
  }
  
  public static class CheckResult
  {
    public String mFileName = "";
    public int mStatusCode = 0;
    public String mUrl = "";
  }
  
  public static abstract interface IFoundListener
  {
    public abstract boolean onFound(File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.FileOP
 * JD-Core Version:    0.7.0.1
 */