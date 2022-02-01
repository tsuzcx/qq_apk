import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class lgl
{
  public static int count;
  public static long uc;
  public static long ud;
  public static long ue;
  public static long uf;
  public static long ug;
  
  public static void a(int paramInt, noz paramnoz)
  {
    if ((lgj.Cc()) && (paramnoz != null))
    {
      if (paramInt != 1) {
        break label23;
      }
      paramnoz.startTime = System.currentTimeMillis();
    }
    label23:
    while (paramnoz.startTime == 0L) {
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.d("RIJImageOptReport", 1, "unknown type: " + paramInt + " " + paramnoz);
      return;
    case 2: 
      paramnoz.xT = System.currentTimeMillis();
      return;
    case 3: 
      paramnoz.xU = System.currentTimeMillis();
      return;
    case 4: 
      paramnoz.xV = System.currentTimeMillis();
      return;
    case 5: 
      paramnoz.xY = System.currentTimeMillis();
      return;
    }
    paramnoz.endTime = System.currentTimeMillis();
  }
  
  public static void a(noz paramnoz, boolean paramBoolean, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new RIJImageOptReport.1(paramnoz, paramBoolean, paramString));
  }
  
  private static boolean a(noz paramnoz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (lgj.Cc())
    {
      bool1 = bool2;
      if (paramnoz != null)
      {
        bool1 = bool2;
        if (paramnoz.startTime != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void b(int paramInt, noz paramnoz)
  {
    if (a(paramnoz)) {
      paramnoz.cacheType = paramInt;
    }
  }
  
  private static void c(noz paramnoz)
  {
    long l2 = paramnoz.xU;
    long l3 = paramnoz.xT;
    long l4 = paramnoz.xV - paramnoz.xU;
    long l5 = paramnoz.xW;
    long l6 = paramnoz.xX;
    if (paramnoz.xY > 0L) {}
    for (long l1 = paramnoz.endTime - paramnoz.xY;; l1 = 0L)
    {
      long l7 = paramnoz.endTime - paramnoz.startTime;
      int i = paramnoz.cacheType;
      int j = paramnoz.failCode;
      paramnoz = paramnoz.errMsg;
      HashMap localHashMap = new HashMap();
      localHashMap.put("subThreadWaitTime", l2 - l3 + "");
      localHashMap.put("threadPoolWaitTime", l4 + "");
      localHashMap.put("downloadAndWriteFileTime", l5 + "");
      localHashMap.put("decodeTime", l6 + "");
      localHashMap.put("mainThreadWaitTime", l1 + "");
      localHashMap.put("cacheType", i + "");
      localHashMap.put("errMsg", paramnoz);
      odv.a(j, 6, l7, localHashMap);
      if (QLog.isColorLevel())
      {
        count += 1;
        uc += l7;
        ud += l4;
        ue = l1 + ue;
        uf += l5;
        ug += l6;
        if (count == 100)
        {
          QLog.d("RIJImageOptReport", 2, "average  total: " + (float)uc / count + " threapool: " + (float)ud / count + " mainthread: " + (float)ue / count + " downloadAndWriteFileTime: " + (float)uf / count + " decodeTime: " + (float)ug / count);
          count = 0;
          uc = 0L;
          ud = 0L;
          ue = 0L;
          uf = 0L;
          ug = 0L;
        }
      }
      return;
    }
  }
  
  public static void d(noz paramnoz)
  {
    if (paramnoz != null) {
      kbp.a(null, "", "0X800AEF3", "0X800AEF3", 0, 0, "", "", "", paramnoz.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgl
 * JD-Core Version:    0.7.0.1
 */