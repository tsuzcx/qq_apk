package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class TPDLFileSystem
{
  public static void clearCache(Context paramContext)
  {
    clearInternalCache(paramContext);
    clearExternalCache(paramContext);
  }
  
  public static void clearCache(Context paramContext, String paramString)
  {
    clearInternalCache(paramContext, paramString);
    clearExternalCache(paramContext, paramString);
  }
  
  public static void clearExternalCache(Context paramContext)
  {
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext));
  }
  
  public static void clearExternalCache(Context paramContext, String paramString)
  {
    TPDLIOUtil.recursiveDelete(getExternalCacheDirectory(paramContext, paramString));
  }
  
  public static void clearInternalCache(Context paramContext)
  {
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext));
  }
  
  public static void clearInternalCache(Context paramContext, String paramString)
  {
    TPDLIOUtil.recursiveDelete(getInternalCacheDirectory(paramContext, paramString));
  }
  
  public static void deleteDirectory(Context paramContext, String paramString)
  {
    deleteInternalDirectory(paramContext, paramString);
    deleteExternalDirectory(paramContext, paramString);
  }
  
  public static void deleteExternalDirectory(Context paramContext, String paramString)
  {
    TPDLIOUtil.recursiveDelete(getExternalDirectory(paramContext, paramString));
  }
  
  public static void deleteInternalDirectory(Context paramContext, String paramString)
  {
    TPDLIOUtil.recursiveDelete(getInternalDirectory(paramContext, paramString));
  }
  
  public static File getExternalCacheDirectory(Context paramContext)
  {
    return paramContext.getExternalCacheDir();
  }
  
  public static File getExternalCacheDirectory(Context paramContext, String paramString)
  {
    paramContext = getExternalCacheDirectory(paramContext);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.getAbsolutePath() + File.separator + paramString);
  }
  
  public static File getExternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getExternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, paramString2);
  }
  
  public static File getExternalDirectory(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile == null) {
      return null;
    }
    return new File(localFile.getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files");
  }
  
  public static File getExternalDirectory(Context paramContext, String paramString)
  {
    paramContext = getExternalDirectory(paramContext);
    if (paramContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    return new File(localStringBuilder.toString());
  }
  
  public static File getExternalFile(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getExternalDirectory(paramContext, paramString1);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, paramString2);
  }
  
  public static File getInternalCacheDirectory(Context paramContext)
  {
    return paramContext.getCacheDir();
  }
  
  public static File getInternalCacheDirectory(Context paramContext, String paramString)
  {
    paramContext = getInternalCacheDirectory(paramContext);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.getAbsolutePath() + File.separator + paramString);
  }
  
  public static File getInternalCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getInternalCacheDirectory(paramContext, paramString1);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, paramString2);
  }
  
  public static File getInternalDirectory(Context paramContext)
  {
    return paramContext.getFilesDir();
  }
  
  public static File getInternalDirectory(Context paramContext, String paramString)
  {
    paramContext = getInternalDirectory(paramContext);
    if (paramContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath()).append(File.separator).append(paramString);
    return new File(localStringBuilder.toString());
  }
  
  public static File getInternalFile(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getInternalDirectory(paramContext, paramString1);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, paramString2);
  }
  
  public static File getNewerCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    return TPDLIOUtil.compare(getInternalCacheFile(paramContext, paramString1, paramString2), getExternalCacheFile(paramContext, paramString1, paramString2));
  }
  
  public static File getNewerFile(Context paramContext, String paramString1, String paramString2)
  {
    return TPDLIOUtil.compare(getInternalFile(paramContext, paramString1, paramString2), getExternalFile(paramContext, paramString1, paramString2));
  }
  
  public static File getProperCacheDirectory(Context paramContext, String paramString)
  {
    if (TPDLIOUtil.isExternalStorageMounted()) {
      return getExternalCacheDirectory(paramContext, paramString);
    }
    return getInternalCacheDirectory(paramContext, paramString);
  }
  
  public static File getProperCacheFile(Context paramContext, String paramString1, String paramString2)
  {
    if (TPDLIOUtil.isExternalStorageMounted()) {
      return getExternalCacheFile(paramContext, paramString1, paramString2);
    }
    return getInternalCacheFile(paramContext, paramString1, paramString2);
  }
  
  public static File getProperDirectory(Context paramContext, String paramString)
  {
    if (TPDLIOUtil.isExternalStorageMounted()) {
      return getExternalDirectory(paramContext, paramString);
    }
    return getInternalDirectory(paramContext, paramString);
  }
  
  public static File getProperFile(Context paramContext, String paramString1, String paramString2)
  {
    if (TPDLIOUtil.isExternalStorageMounted()) {
      return getExternalFile(paramContext, paramString1, paramString2);
    }
    return getInternalFile(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem
 * JD-Core Version:    0.7.0.1
 */