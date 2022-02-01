package com.tencent.token.upload;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

public class c
{
  public static String a()
  {
    try
    {
      String str = new java.io.BufferedReader(new java.io.FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2)[1];
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return f.a;
  }
  
  public static String b()
  {
    str2 = f.a;
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
      int i = 1;
      for (;;)
      {
        String str1 = str2;
        if (i < 100)
        {
          String str3 = localLineNumberReader.readLine();
          str1 = str2;
          if (str3 != null)
          {
            if (str3.indexOf("Serial") <= -1) {
              break label89;
            }
            str1 = str3.substring(str3.indexOf(":") + 1, str3.length()).trim();
          }
        }
        return str1;
        label89:
        i += 1;
      }
      return str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String c()
  {
    str2 = f.a;
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
      int i = 1;
      for (;;)
      {
        String str1 = str2;
        if (i < 100)
        {
          String str3 = localLineNumberReader.readLine();
          str1 = str2;
          if (str3 != null)
          {
            if (str3.indexOf("Hardware") <= -1) {
              break label89;
            }
            str1 = str3.substring(str3.indexOf(":") + 1, str3.length()).trim();
          }
        }
        return str1;
        label89:
        i += 1;
      }
      return str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static int d()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static String e()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = f.a;
      }
    }
    return str1.trim();
  }
  
  class a
    implements FileFilter
  {
    public boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.c
 * JD-Core Version:    0.7.0.1
 */