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
    long l = paramLong;
    if (bw > paramLong) {
      l = bw;
    }
    return l;
  }
  
  public static long getMobileTx(long paramLong)
  {
    long l = paramLong;
    if (bv > paramLong) {
      l = bv;
    }
    return l;
  }
  
  public static long getWifiRx(long paramLong)
  {
    long l = paramLong;
    if (by > paramLong) {
      l = by;
    }
    return l;
  }
  
  public static long getWifiTx(long paramLong)
  {
    long l = paramLong;
    if (bx > paramLong) {
      l = bx;
    }
    return l;
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
    long l4 = 0L;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    for (;;)
    {
      try
      {
        localScanner = new Scanner(new File("/proc/" + Process.myPid() + "/net/dev"));
        localScanner.nextLine();
        localScanner.nextLine();
        if (!localScanner.hasNext()) {
          continue;
        }
        arrayOfString = localScanner.nextLine().split("[ :\t]+");
        if (arrayOfString[0].length() != 0) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Scanner localScanner;
        String[] arrayOfString;
        long l6;
        long l5;
        localException.printStackTrace();
        continue;
        int i = 0;
        continue;
      }
      l6 = l3;
      l5 = l4;
      if (!arrayOfString[0].equals("lo"))
      {
        l6 = l3;
        l5 = l4;
        if (arrayOfString[(i + 0)].startsWith("rmnet"))
        {
          l5 = l4 + Long.parseLong(arrayOfString[(i + 9)]);
          l6 = l3 + Long.parseLong(arrayOfString[(i + 1)]);
        }
      }
      l3 = l6;
      l4 = l5;
      if (!arrayOfString[(i + 0)].equals("lo"))
      {
        l3 = l6;
        l4 = l5;
        if (!arrayOfString[(i + 0)].startsWith("rmnet"))
        {
          l2 += Long.parseLong(arrayOfString[(i + 9)]);
          l1 += Long.parseLong(arrayOfString[(i + 1)]);
          l3 = l6;
          l4 = l5;
        }
      }
    }
    localScanner.close();
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
    if (l4 >= br)
    {
      l5 = l4 - br;
      bv = l5;
      if (l3 < bs) {
        break label594;
      }
      l5 = l3 - bs;
      label476:
      bw = l5;
      if (l2 < bt) {
        break label601;
      }
      l5 = l2 - bt;
      label496:
      bx = l5;
      if (l1 < bu) {
        break label607;
      }
    }
    label594:
    label601:
    label607:
    for (l5 = l1 - bu;; l5 = l1)
    {
      by = l5;
      br = l4;
      bs = l3;
      bt = l2;
      bu = l1;
      Log.d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", new Object[] { Long.valueOf(by), Long.valueOf(bx), Long.valueOf(bw), Long.valueOf(bv) });
      return;
      l5 = l4;
      break;
      l5 = l3;
      break label476;
      l5 = l2;
      break label496;
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