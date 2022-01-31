package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.algorithm.MD5;
import java.io.File;
import java.io.IOException;

public class FilePathGenerator
{
  public static final String ANDROID_DIR_SEP = "/";
  public static final int HASH_TYPE_ALL_MD5 = 2;
  public static final int HASH_TYPE_HEAD_2_BYTE = 1;
  public static final String NO_MEDIA_FILENAME = ".nomedia";
  
  private static String b(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    while (paramString.length() <= 4) {
      return null;
    }
    return paramString.substring(0, 2) + "/" + paramString.substring(2, 4) + "/";
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        paramString = new File(paramString + ".nomedia");
        boolean bool = paramString.exists();
        if (bool) {}
      }
      try
      {
        paramString.createNewFile();
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public static String defGenPathWithOld(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    String str = paramString1 + paramString3 + paramString4 + paramString5;
    paramString2 = genPath(paramString2, paramString3, paramString4, paramString5, paramInt);
    if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramString2))) {
      paramString1 = null;
    }
    do
    {
      do
      {
        return paramString1;
        paramString3 = new File(paramString2);
        paramString4 = new File(str);
        paramString1 = paramString2;
      } while (paramString3.exists());
      paramString1 = paramString2;
    } while (!paramString4.exists());
    FilesCopy.copy(str, paramString2, false);
    return paramString2;
  }
  
  public static String genPath(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (Util.isNullOrNil(paramString1)) {}
    label134:
    for (;;)
    {
      return null;
      if (paramString1.endsWith("/"))
      {
        String str = "";
        if (paramInt == 1) {
          str = b(paramString3);
        }
        for (;;)
        {
          if (Util.isNullOrNil(str)) {
            break label134;
          }
          paramString1 = paramString1 + str;
          if (!c(paramString1)) {
            break;
          }
          return paramString1 + Util.nullAsNil(paramString2) + paramString3 + Util.nullAsNil(paramString4);
          if (paramInt == 2) {
            if (Util.isNullOrNil(paramString3)) {
              str = null;
            } else {
              str = b(MD5.getMessageDigest(paramString3.getBytes()));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilePathGenerator
 * JD-Core Version:    0.7.0.1
 */