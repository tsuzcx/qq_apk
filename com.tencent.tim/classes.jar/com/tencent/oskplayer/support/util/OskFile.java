package com.tencent.oskplayer.support.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class OskFile
{
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_EB = 1152921504606846976L;
  public static final BigInteger ONE_EB_BI;
  public static final long ONE_GB = 1073741824L;
  public static final BigInteger ONE_GB_BI;
  public static final long ONE_KB = 1024L;
  public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
  public static final long ONE_MB = 1048576L;
  public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
  public static final long ONE_PB = 1125899906842624L;
  public static final BigInteger ONE_PB_BI;
  public static final long ONE_TB = 1099511627776L;
  public static final BigInteger ONE_TB_BI;
  public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
  public static final BigInteger ONE_ZB;
  public static final String TAG = "OskFile";
  
  static
  {
    ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
  }
  
  public static String byteCountToDisplaySize(long paramLong)
  {
    return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
  }
  
  public static String byteCountToDisplaySize(BigInteger paramBigInteger)
  {
    if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_EB_BI)) + " EB";
    }
    if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_PB_BI)) + " PB";
    }
    if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_TB_BI)) + " TB";
    }
    if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_GB_BI)) + " GB";
    }
    if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_MB_BI)) + " MB";
    }
    if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_KB_BI)) + " KB";
    }
    return String.valueOf(paramBigInteger) + " bytes";
  }
  
  public static void copy(File paramFile1, File paramFile2)
    throws IOException
  {
    paramFile1 = new FileInputStream(paramFile1);
    try
    {
      paramFile2 = new FileOutputStream(paramFile2);
      try
      {
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramFile1.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramFile2.write(arrayOfByte, 0, i);
        }
        paramFile2 = finally;
      }
      finally {}
    }
    finally
    {
      paramFile1.close();
    }
    paramFile1.close();
  }
  
  private static String ensureDir(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      bool1 = bool2;
      if (paramFile.isFile()) {
        bool1 = paramFile.delete();
      }
    }
    if (!paramFile.exists()) {
      bool1 = paramFile.mkdirs();
    }
    bool2 = bool1;
    if (paramFile.isDirectory())
    {
      bool2 = bool1;
      if (paramFile.exists()) {
        bool2 = true;
      }
    }
    Logger.g().i("OskFile", "ensureDir " + paramFile + " result:" + bool2);
    if (bool2) {
      return paramFile.getAbsolutePath();
    }
    return null;
  }
  
  public static boolean ensureDirEmpty(String paramString)
  {
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
      if (!paramString.exists()) {
        bool1 = paramString.mkdirs();
      }
      boolean bool2 = bool1;
      if (paramString.isDirectory())
      {
        bool2 = bool1;
        if (paramString.exists()) {
          bool2 = true;
        }
      }
      Logger.g().i("OskFile", "ensureDirEmpty " + paramString + " result:" + bool2);
      return bool2;
    }
    Logger.g().i("OskFile", "ensureDirEmpty invalidPath");
    return false;
  }
  
  public static String ensureFilesDir(String paramString)
  {
    String str = "";
    Object localObject1 = str;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = OskSupport.getContext().getExternalFilesDir(null);
      if (localObject1 != null) {
        str = ensureDir(new File(localObject1 + File.separator + paramString));
      }
      localObject1 = str;
      if (!TextUtils.isEmpty(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        localFile = OskSupport.getContext().getFilesDir();
        localObject1 = str;
        if (localFile != null) {
          localObject1 = ensureDir(new File(localFile + File.separator + paramString));
        }
        return localObject1;
        localException1 = localException1;
        Logger.g().e("OskFile", "cant get extFilesRootDir", localException1);
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Logger.g().e("OskFile", "cant get internalFilesRootDir", localException2);
          File localFile = null;
        }
      }
    }
  }
  
  public static String getFileExtension(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString).getName();
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return "";
      }
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  public static boolean isLocalFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.util.OskFile
 * JD-Core Version:    0.7.0.1
 */