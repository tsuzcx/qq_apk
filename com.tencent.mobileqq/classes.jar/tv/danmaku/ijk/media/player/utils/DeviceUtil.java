package tv.danmaku.ijk.media.player.utils;

import android.os.Build.VERSION;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeviceUtil
{
  public static int getBaseScore()
  {
    boolean bool = isNEON();
    double d = getCurCpuFreq();
    if (d < 0.0D) {
      Logger.g().w("AbstractMediaPlayer", "no cpuinfo");
    }
    int j;
    do
    {
      return 5;
      int i = getNumberOfCores();
      j = getMemoryInfo();
      String str = "getScore  getNumberOfCores " + Integer.toString(i) + " getCurCpuFreq " + Double.toString(d) + " , getMemoryInfo " + Integer.toString(j) + " isNeon " + Boolean.toString(bool);
      Logger.g().w("AbstractMediaPlayer", str);
      d *= i;
      if ((d >= 6.4D) && (j >= 600)) {
        return 26;
      }
      if ((d >= 4.8D) && (j >= 600)) {
        return 21;
      }
      if ((d >= 2.0D) && (j >= 400)) {
        return 16;
      }
    } while ((d < 1.0D) || (j < 400));
    return 11;
  }
  
  private static String getCPUInfos()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat  /proc/cpuinfo").getInputStream()), 8192);
      for (;;)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        localStringBuilder.append(str2);
      }
      while (localIOException == null) {}
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    String str1 = localIOException.toString();
    return str1;
  }
  
  private static double getCurCpuFreq()
  {
    int m = 0;
    int j;
    for (int i = 0;; i = j)
    {
      int k = i;
      j = i;
      try
      {
        if (m < getNumberOfCores())
        {
          k = i;
          Object localObject1 = new File("/sys/devices/system/cpu/cpu" + m + "/cpufreq/cpuinfo_max_freq");
          k = i;
          j = i;
          if (!((File)localObject1).exists()) {
            break label233;
          }
          k = i;
          Object localObject2 = new byte[''];
          k = i;
          localObject1 = new FileInputStream((File)localObject1);
          k = i;
          try
          {
            ((FileInputStream)localObject1).read((byte[])localObject2);
            j = 0;
            while ((localObject2[j] >= 48) && (localObject2[j] <= 57))
            {
              k = i;
              if (j >= localObject2.length) {
                break;
              }
              j += 1;
            }
            k = i;
            localObject2 = Integer.valueOf(Integer.parseInt(new String((byte[])localObject2, 0, j)));
            j = i;
            k = i;
            if (((Integer)localObject2).intValue() > i)
            {
              k = i;
              j = ((Integer)localObject2).intValue();
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              k = i;
              localNumberFormatException.printStackTrace();
              j = i;
            }
          }
          k = j;
          ((FileInputStream)localObject1).close();
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        j = k;
        if (j > 0) {
          return Math.rint(j * 10.0D / 1024.0D / 1024.0D) / 10.0D;
        }
        return 0.0D;
      }
      label233:
      m += 1;
    }
  }
  
  private static int getMemoryInfo()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/meminfo").getInputStream()), 8192);
      int j = 0;
      int i = 0;
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if ((str == null) || (j >= 2)) {
          break;
        }
        j += 1;
        i += Integer.parseInt(str.substring(str.indexOf(':') + 1, str.indexOf('k')).trim());
      }
      double d = Math.rint(i / 1024.0D);
      return (int)d;
    }
    catch (IOException localIOException)
    {
      localIOException.getMessage();
    }
    return 0;
  }
  
  private static int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  private static int getNumberOfCores()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return getNumCoresOldPhones();
  }
  
  public static boolean isNEON()
  {
    boolean bool2 = false;
    String str = getCPUInfos();
    boolean bool1 = bool2;
    if (str != null)
    {
      str = str.toLowerCase();
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (str.contains("neon")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */