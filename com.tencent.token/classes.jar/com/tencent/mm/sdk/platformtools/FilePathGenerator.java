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
    if (Util.isNullOrNil(paramString)) {
      return null;
    }
    if (paramString.length() <= 4) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 2));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.substring(2, 4));
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".nomedia");
        paramString = new File(((StringBuilder)localObject).toString());
        boolean bool = paramString.exists();
        if (!bool) {
          try
          {
            paramString.createNewFile();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      label78:
      break label78;
    }
    return false;
  }
  
  public static String defGenPathWithOld(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString4);
    localStringBuilder.append(paramString5);
    paramString1 = localStringBuilder.toString();
    paramString2 = genPath(paramString2, paramString3, paramString4, paramString5, paramInt);
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)))
    {
      paramString3 = new File(paramString2);
      paramString4 = new File(paramString1);
      if (paramString3.exists()) {
        return paramString2;
      }
      if (paramString4.exists()) {
        FilesCopy.copy(paramString1, paramString2, false);
      }
      return paramString2;
    }
    return null;
  }
  
  public static String genPath(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (Util.isNullOrNil(paramString1)) {
      return null;
    }
    if (!paramString1.endsWith("/")) {
      return null;
    }
    Object localObject = "";
    if (paramInt == 1) {}
    for (localObject = b(paramString3);; localObject = b(MD5.getMessageDigest(paramString3.getBytes())))
    {
      break;
      if (paramInt != 2) {
        break;
      }
      if (Util.isNullOrNil(paramString3))
      {
        localObject = null;
        break;
      }
    }
    if (Util.isNullOrNil((String)localObject)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append((String)localObject);
    paramString1 = localStringBuilder.toString();
    if (!c(paramString1)) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(Util.nullAsNil(paramString2));
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(Util.nullAsNil(paramString4));
    return ((StringBuilder)localObject).toString();
  }
  
  public static enum DIR_HASH_TYPE
  {
    private DIR_HASH_TYPE() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilePathGenerator
 * JD-Core Version:    0.7.0.1
 */