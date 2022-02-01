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
    double d1 = getCurCpuFreq();
    int j = 5;
    if (d1 < 0.0D)
    {
      Logger.g().w("AbstractMediaPlayer", "no cpuinfo");
      return 5;
    }
    int i = getNumberOfCores();
    int k = getMemoryInfo();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getScore  getNumberOfCores ");
    ((StringBuilder)localObject).append(Integer.toString(i));
    ((StringBuilder)localObject).append(" getCurCpuFreq ");
    ((StringBuilder)localObject).append(Double.toString(d1));
    ((StringBuilder)localObject).append(" , getMemoryInfo ");
    ((StringBuilder)localObject).append(Integer.toString(k));
    ((StringBuilder)localObject).append(" isNeon ");
    ((StringBuilder)localObject).append(Boolean.toString(bool));
    localObject = ((StringBuilder)localObject).toString();
    Logger.g().w("AbstractMediaPlayer", (String)localObject);
    double d2 = i;
    Double.isNaN(d2);
    d1 = d2 * d1;
    if ((d1 >= 6.4D) && (k >= 600)) {
      return 26;
    }
    if ((d1 >= 4.8D) && (k >= 600)) {
      return 21;
    }
    if ((d1 >= 2.0D) && (k >= 400)) {
      return 16;
    }
    i = j;
    if (d1 >= 1.0D)
    {
      i = j;
      if (k >= 400) {
        i = 11;
      }
    }
    return i;
  }
  
  private static String getCPUInfos()
  {
    Object localObject = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat  /proc/cpuinfo").getInputStream()), 8192);
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        ((StringBuilder)localObject).append(str);
      }
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  private static double getCurCpuFreq()
  {
    int m = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      int j = i;
      try
      {
        if (m < getNumberOfCores())
        {
          k = i;
          Object localObject1 = new StringBuilder();
          k = i;
          ((StringBuilder)localObject1).append("/sys/devices/system/cpu/cpu");
          k = i;
          ((StringBuilder)localObject1).append(m);
          k = i;
          ((StringBuilder)localObject1).append("/cpufreq/cpuinfo_max_freq");
          k = i;
          localObject1 = new File(((StringBuilder)localObject1).toString());
          j = i;
          k = i;
          if (((File)localObject1).exists())
          {
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
              k = i;
              localNumberFormatException.printStackTrace();
              j = i;
            }
            k = j;
            ((FileInputStream)localObject1).close();
          }
          m += 1;
          i = j;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        j = k;
        if (j > 0)
        {
          double d = j;
          Double.isNaN(d);
          return Math.rint(d * 10.0D / 1024.0D / 1024.0D) / 10.0D;
        }
      }
    }
    return 0.0D;
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
        int k = Integer.parseInt(str.substring(str.indexOf(':') + 1, str.indexOf('k')).trim());
        i += k;
      }
      double d = i;
      Double.isNaN(d);
      d /= 1024.0D;
      d = Math.rint(d);
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
    catch (Exception localException)
    {
      label23:
      break label23;
    }
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
    String str = getCPUInfos();
    boolean bool2 = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */