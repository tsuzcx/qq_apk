import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ajgu
{
  public static String TAG;
  public static boolean TRACE = true;
  public static long acH;
  public static long acI;
  public static long acJ;
  public static long acK;
  public static long acL;
  public static long acM;
  public static long acN;
  public static long acO;
  public static long acP;
  public static long acQ;
  public static long acR;
  public static boolean cou;
  private static ConcurrentHashMap<String, Long> gh = new ConcurrentHashMap(new HashMap(10));
  private static ConcurrentHashMap<Long, Long> gi = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Long> sLogs;
  public static long totalLength;
  
  static
  {
    TAG = "MsgBackup_timeStats";
    sLogs = new ConcurrentHashMap(new HashMap(8));
  }
  
  public static void MA(String paramString)
  {
    gh.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void au(long paramLong1, long paramLong2)
  {
    gi.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  public static void av(long paramLong1, long paramLong2)
  {
    if (!cou)
    {
      acH = paramLong2;
      cou = true;
    }
    ajgv.c(TAG, "transport increment = %d sMaxSpeed = %d, sMinSpeed = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(acI), Long.valueOf(acH) });
    ajgv.c(TAG, "transport storeSpeed increment = %s", new Object[] { ajgv.bw(paramLong2) });
    if (paramLong2 >= acI) {
      acI = paramLong2;
    }
    if (paramLong2 <= acH) {
      acH = paramLong2;
    }
  }
  
  public static void complete(long paramLong)
  {
    if (gi.containsKey(Long.valueOf(paramLong)))
    {
      Long localLong = (Long)gi.get(Long.valueOf(paramLong));
      if (localLong != null)
      {
        ajgv.c(TAG, "transport complete complete = %d", new Object[] { localLong });
        long l = totalLength;
        totalLength = localLong.longValue() + l;
      }
      gi.remove(Long.valueOf(paramLong));
    }
  }
  
  public static void dxv()
  {
    ajgt.dxs();
    ajgt.a.totalCost = acJ;
    ajgt.a.acE = acM;
    String str1;
    String str2;
    if (ajgp.b().getRole() == 2)
    {
      ajgt.a.acF = acK;
      if (acJ > 0L) {
        ajgt.a.cN = (totalLength * 1000.0D / acJ);
      }
      if (TRACE)
      {
        str1 = ajgv.bw(acI);
        str2 = ajgv.bw(acH);
        if (acJ != 0L) {
          break label120;
        }
        ajgv.c(TAG, "transport speed error", new Object[0]);
      }
    }
    label120:
    do
    {
      return;
      ajgt.a.acF = acL;
      break;
      ajgv.c(TAG, "transport speed sSizeCache.size = %d, sLogs.size = %d", new Object[] { Integer.valueOf(gi.size()), Integer.valueOf(sLogs.size()) });
      long l = totalLength * 1000L / acJ;
      ajgv.c(TAG, "transport speed totalLength = %d B, totalElipse = %d ms", new Object[] { Long.valueOf(totalLength), Long.valueOf(acJ) });
      String str3 = ajgv.bw(l);
      ajgv.c(TAG, "transport speed max = %s, min = %s, average = %s", new Object[] { str1, str2, str3 });
    } while (ajgp.b().getRole() != 2);
    ajgv.c(TAG, acfp.m(2131708492), new Object[] { Long.valueOf(acK) });
  }
  
  public static void dxw()
  {
    acN = 0L;
    acO = 0L;
    acP = 0L;
    acQ = 0L;
    acR = 0L;
    gh.clear();
  }
  
  public static void dxx()
  {
    if ((gh.containsKey("statis_qianchums_start")) && (gh.containsKey("statis_qianchums_end")))
    {
      long l = ((Long)gh.get("statis_qianchums_start")).longValue();
      acN = ((Long)gh.get("statis_qianchums_end")).longValue() - l;
      ajgv.c(TAG, "pure qianchu time cost = %d,pb_pack cost time = %d ", new Object[] { Long.valueOf(acN), Long.valueOf(acO) });
    }
  }
  
  public static void dxy()
  {
    if ((gh.containsKey("statis_qianchums_start")) && (gh.containsKey("statis_qianchums_end")))
    {
      long l = ((Long)gh.get("statis_qianchums_start")).longValue();
      acR = ((Long)gh.get("statis_qianchums_end")).longValue() - l + acR;
    }
  }
  
  public static void dxz()
  {
    if ((gh.containsKey("statis_qianchums_start")) && (gh.containsKey("statis_qianchums_end")))
    {
      long l = ((Long)gh.get("statis_qianchums_start")).longValue();
      acP = ((Long)gh.get("statis_qianchums_end")).longValue() - l;
      ajgv.c(TAG, "pure qianru time cost = %d ", new Object[] { Long.valueOf(acR) });
      ajgv.c(TAG, "pure daoru time cost = %d,pb_unpack cost time = %d ", new Object[] { Long.valueOf(acP), Long.valueOf(acQ) });
    }
  }
  
  public static void reset()
  {
    ajgv.c(TAG, "transport reset", new Object[0]);
    cou = false;
    totalLength = 0L;
    acH = 0L;
    acI = 0L;
    gi.clear();
  }
  
  public static void track(String paramString1, String paramString2)
  {
    long l;
    Long localLong;
    if (TRACE)
    {
      l = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        localLong = (Long)sLogs.remove(paramString1);
        if (localLong != null)
        {
          if (TextUtils.equals("total_transport_cost", paramString1)) {
            acJ = l - localLong.longValue();
          }
          if (TextUtils.equals("single_uin_cost", paramString1)) {
            acK += l - localLong.longValue();
          }
          if (TextUtils.equals("total_daoru_cost", paramString1)) {
            acL += l - localLong.longValue();
          }
          if (TextUtils.equals("cost_connect_total", paramString1)) {
            acM += l - localLong.longValue();
          }
          if (!QLog.isColorLevel()) {
            break label178;
          }
          QLog.i(TAG, 2, paramString1 + ", cost=" + (l - localLong.longValue()));
        }
      }
    }
    for (;;)
    {
      if (paramString2 != null) {
        sLogs.put(paramString2, Long.valueOf(l));
      }
      return;
      label178:
      Log.i(TAG, paramString1 + ", cost=" + (l - localLong.longValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgu
 * JD-Core Version:    0.7.0.1
 */