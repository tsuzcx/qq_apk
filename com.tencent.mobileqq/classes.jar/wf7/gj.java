package wf7;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;

public class gj
{
  private static Integer sm = null;
  
  public static String eS()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    InputStream localInputStream;
    try
    {
      localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        localStringBuilder1.append(new String(arrayOfByte));
        continue;
        StringBuilder localStringBuilder2;
        return localStringBuilder2.toString().trim();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      localStringBuilder2 = new StringBuilder("N/A");
    }
    for (;;)
    {
      localInputStream.close();
    }
  }
  
  public static int eT()
  {
    if (sm == null) {}
    try
    {
      Object localObject = new gj.1();
      localObject = new File("/sys/devices/system/cpu/").listFiles((FileFilter)localObject);
      if (localObject == null) {
        return 1;
      }
      sm = Integer.valueOf(localObject.length);
      return sm.intValue();
    }
    catch (Throwable localThrowable) {}
    return 1;
  }
  
  public static long eU()
  {
    try
    {
      Object localObject2 = Environment.getRootDirectory();
      Object localObject1 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject1 = new File("/system");
      }
      gr.a locala = new gr.a();
      gr.a((File)localObject1, locala);
      localObject2 = Environment.getDataDirectory();
      localObject1 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject1 = new File("/data");
      }
      localObject2 = new gr.a();
      gr.a((File)localObject1, (gr.a)localObject2);
      long l1 = locala.sx;
      long l2 = ((gr.a)localObject2).sx;
      return l2 + l1;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static String[] s(Context paramContext)
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    Object localObject1 = "";
    Object localObject2 = new File("/proc/cpuinfo");
    try
    {
      localObject2 = new String(gk.a((File)localObject2)).split("\\n")[0];
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return new String[] { str1, str2, localObject1, Integer.toString(gr.D(paramContext)) + "*" + Integer.toString(gr.E(paramContext)) };
  }
  
  public static boolean t(Context paramContext)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gj
 * JD-Core Version:    0.7.0.1
 */