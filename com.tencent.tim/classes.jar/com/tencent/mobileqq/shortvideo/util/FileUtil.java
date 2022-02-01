package com.tencent.mobileqq.shortvideo.util;

import java.io.File;

public class FileUtil
{
  public static boolean checkFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */