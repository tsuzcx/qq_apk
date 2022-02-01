package com.tencent.token;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

public final class aae
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
    return aah.a;
  }
  
  public static String b()
  {
    str1 = aah.a;
    try
    {
      Object localObject = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
      int i = 1;
      while (i < 100)
      {
        String str2 = ((LineNumberReader)localObject).readLine();
        if (str2 == null) {
          break;
        }
        if (str2.indexOf("Serial") >= 0)
        {
          localObject = str2.substring(str2.indexOf(":") + 1, str2.length()).trim();
          return localObject;
        }
        i += 1;
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String c()
  {
    str1 = aah.a;
    try
    {
      Object localObject = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
      int i = 1;
      while (i < 100)
      {
        String str2 = ((LineNumberReader)localObject).readLine();
        if (str2 == null) {
          break;
        }
        if (str2.indexOf("Hardware") >= 0)
        {
          localObject = str2.substring(str2.indexOf(":") + 1, str2.length()).trim();
          return localObject;
        }
        i += 1;
      }
      return str1;
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
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 1;
  }
  
  public static String e()
  {
    String str1 = "";
    String str2;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(new String(arrayOfByte));
        str1 = localStringBuilder.toString();
      }
      localInputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = aah.a;
    }
    return str2.trim();
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aae
 * JD-Core Version:    0.7.0.1
 */