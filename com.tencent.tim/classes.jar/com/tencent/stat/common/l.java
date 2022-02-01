package com.tencent.stat.common;

import java.io.File;

class l
{
  public static boolean a()
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "/bin";
    arrayOfString[1] = "/system/bin/";
    arrayOfString[2] = "/system/xbin/";
    arrayOfString[3] = "/system/sbin/";
    arrayOfString[4] = "/sbin/";
    arrayOfString[5] = "/vendor/bin/";
    int i = 0;
    try
    {
      while (i < arrayOfString.length)
      {
        File localFile = new File(arrayOfString[i] + "su");
        if (localFile != null)
        {
          boolean bool = localFile.exists();
          if (bool) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.common.l
 * JD-Core Version:    0.7.0.1
 */