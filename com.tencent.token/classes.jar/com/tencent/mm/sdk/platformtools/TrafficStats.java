package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;

public final class TrafficStats
{
  public static final String DEV_FILE = "/proc/self/net/dev";
  public static final String GPRSLINE = "rmnet0";
  public static final String WIFILINE = "tiwlan0";
  private static long br;
  private static long bs;
  private static long bt;
  private static long bu;
  private static long bv;
  private static long bw;
  private static long bx;
  private static long by;
  
  public static long getMobileRx(long paramLong)
  {
    long l = bw;
    if (l > paramLong) {
      return l;
    }
    return paramLong;
  }
  
  public static long getMobileTx(long paramLong)
  {
    long l = bv;
    if (l > paramLong) {
      return l;
    }
    return paramLong;
  }
  
  public static long getWifiRx(long paramLong)
  {
    long l = by;
    if (l > paramLong) {
      return l;
    }
    return paramLong;
  }
  
  public static long getWifiTx(long paramLong)
  {
    long l = bx;
    if (l > paramLong) {
      return l;
    }
    return paramLong;
  }
  
  public static void reset()
  {
    br = -1L;
    bs = -1L;
    bt = -1L;
    bu = -1L;
    update();
  }
  
  public static void update()
  {
    for (;;)
    {
      long l6;
      long l7;
      long l8;
      try
      {
        Object localObject = new StringBuilder("/proc/");
        ((StringBuilder)localObject).append(Process.myPid());
        ((StringBuilder)localObject).append("/net/dev");
        localObject = new Scanner(new File(((StringBuilder)localObject).toString()));
        ((Scanner)localObject).nextLine();
        ((Scanner)localObject).nextLine();
        l4 = 0L;
        l3 = l4;
        l2 = l3;
        l1 = l2;
        if (((Scanner)localObject).hasNext())
        {
          String[] arrayOfString = ((Scanner)localObject).nextLine().split("[ :\t]+");
          if (arrayOfString[0].length() != 0) {
            break label626;
          }
          i = 1;
          l6 = l4;
          l5 = l3;
          if (!arrayOfString[0].equals("lo"))
          {
            l6 = l4;
            l5 = l3;
            if (arrayOfString[(i + 0)].startsWith("rmnet"))
            {
              l6 = l4 + Long.parseLong(arrayOfString[(i + 9)]);
              l5 = l3 + Long.parseLong(arrayOfString[(i + 1)]);
            }
          }
          int j = i + 0;
          l7 = l2;
          l8 = l1;
          if (arrayOfString[j].equals("lo")) {
            break label631;
          }
          l7 = l2;
          l8 = l1;
          if (arrayOfString[j].startsWith("rmnet")) {
            break label631;
          }
          l7 = l2 + Long.parseLong(arrayOfString[(i + 9)]);
          l8 = l1 + Long.parseLong(arrayOfString[(i + 1)]);
          break label631;
        }
        ((Scanner)localObject).close();
        if (br < 0L)
        {
          br = l4;
          Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", new Object[] { Long.valueOf(l4) });
        }
        if (bs < 0L)
        {
          bs = l3;
          Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", new Object[] { Long.valueOf(l3) });
        }
        if (bt < 0L)
        {
          bt = l2;
          Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", new Object[] { Long.valueOf(l2) });
        }
        if (bu < 0L)
        {
          bu = l1;
          Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", new Object[] { Long.valueOf(l1) });
        }
        if (l1 - bu < 0L) {
          Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l1 - bu) });
        }
        if (l2 - bt < 0L) {
          Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l2 - bt) });
        }
        if (l4 < br) {
          break label649;
        }
        l5 = l4 - br;
        bv = l5;
        if (l3 < bs) {
          break label656;
        }
        l5 = l3 - bs;
        bw = l5;
        if (l2 < bt) {
          break label663;
        }
        l5 = l2 - bt;
        bx = l5;
        if (l1 < bu) {
          break label670;
        }
        l5 = l1 - bu;
        by = l5;
        br = l4;
        bs = l3;
        bt = l2;
        bu = l1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Log.d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", new Object[] { Long.valueOf(by), Long.valueOf(bx), Long.valueOf(bw), Long.valueOf(bv) });
      return;
      label626:
      int i = 0;
      continue;
      label631:
      long l4 = l6;
      long l3 = l5;
      long l2 = l7;
      long l1 = l8;
      continue;
      label649:
      long l5 = l4;
      continue;
      label656:
      l5 = l3;
      continue;
      label663:
      l5 = l2;
      continue;
      label670:
      l5 = l1;
    }
  }
  
  public static long updateMobileRx(long paramLong)
  {
    update();
    return getMobileRx(paramLong);
  }
  
  public static long updateMobileTx(long paramLong)
  {
    update();
    return getMobileTx(paramLong);
  }
  
  public static long updateWifiRx(long paramLong)
  {
    update();
    return getWifiRx(paramLong);
  }
  
  public static long updateWifiTx(long paramLong)
  {
    update();
    return getWifiTx(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TrafficStats
 * JD-Core Version:    0.7.0.1
 */