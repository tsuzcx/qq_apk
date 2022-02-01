import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class aomq
{
  static PhantomReference<Object> a;
  public static long aqc;
  static long aqd;
  static long aqe;
  static long aqf;
  static ReferenceQueue<Object> c = new ReferenceQueue();
  public static boolean cNh;
  public static boolean cNi;
  static boolean cNj;
  static int dPV;
  static int dPW;
  public static ConcurrentHashMap<String, Long> iG;
  private static Random random = new Random();
  static int releaseCount;
  
  static
  {
    iG = new ConcurrentHashMap();
  }
  
  private static void P(QQAppInterface paramQQAppInterface, int paramInt)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", paramInt, 0, "", "", "", "3.4.4");
  }
  
  public static void Rc(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void Rd(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttNoRangeFailed", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void VV(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttLongPressFate2", false, 0L, 0L, localHashMap, "");
  }
  
  public static void VW(int paramInt)
  {
    anpc localanpc = anpc.a(BaseApplication.getContext());
    long l = SystemClock.uptimeMillis() - aqc;
    if (l > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localanpc.collectPerformance("", "PTTCostUntilPrepare", true, l, paramInt, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "COST : " + l + " from : " + paramInt);
      }
    }
  }
  
  public static void VX(int paramInt)
  {
    anpc localanpc = anpc.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localanpc.collectPerformance("", "PTTStraightRecordCount", false, 0L, 0L, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.d("PttInfoCollector", 4, "pttStraightRecordCount " + paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (!(paramMessageRecord instanceof MessageForPtt)) {}
    for (;;)
    {
      return;
      if (paramMessageRecord.getPttStreamFlag() != 10001)
      {
        if (!paramMessageRecord.isSend()) {
          break;
        }
        if (((MessageForPtt)paramMessageRecord).voiceChangeFlag == 1) {}
        while ((i != 0) && (paramInt == 1001))
        {
          P(paramQQAppInterface, 4);
          return;
          i = 0;
        }
      }
    }
    switch (paramInt)
    {
    case 2002: 
    case 2004: 
    default: 
      return;
    case 2001: 
      P(paramQQAppInterface, 2);
      return;
    case 2003: 
      P(paramQQAppInterface, 1);
      return;
    }
    P(paramQQAppInterface, 3);
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject = (Long)iG.get(paramString);
        if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
          continue;
        }
        if (!paramBoolean1) {
          continue;
        }
        str = "pttSendTotalCost";
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PttInfoCollector", 2, "report sendcost error" + paramString);
        return;
        if (!paramBoolean1) {
          continue;
        }
        continue;
      }
      l1 = SystemClock.uptimeMillis();
      l2 = ((Long)localObject).longValue();
      localObject = new HashMap();
      ((HashMap)localObject).put("isVoiceChange", String.valueOf(paramInt));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, paramBoolean2, l1 - l2, paramLong, (HashMap)localObject, "");
      if ((!paramBoolean1) || (!iG.containsKey(paramString))) {
        return;
      }
      iG.remove(paramString);
      return;
      str = "offlinePttHandleCost";
      continue;
      paramBoolean2 = true;
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 10002L) || (paramLong1 == 10004L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static void aM(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (paramString.equals("codecsilk")) {
      if (paramBoolean)
      {
        cNh = true;
        i = 0;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", String.valueOf(i));
      paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
      return;
      cNh = false;
      continue;
      if (paramBoolean)
      {
        cNi = true;
        i = 2;
      }
      else
      {
        i = 3;
        cNi = false;
      }
    }
  }
  
  public static final int aP(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 0xF) + paramInt1 * 100;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005C1C", "0X8005C1C", i * 10 + paramInt1 * 100 + paramInt2, 0, "", "", "", "3.4.4");
      return;
    }
  }
  
  public static void c(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    HashMap localHashMap;
    if (Math.abs(random.nextInt() % 100) < 10)
    {
      int i = imm.getCpuArchitecture();
      int j = imm.getNumCores();
      long l1 = imm.getMaxCpuFreq();
      long l2 = aqgz.getSystemTotalMemory() / 1048576L;
      localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(i));
      localHashMap.put("numCores", String.valueOf(j));
      localHashMap.put("maxFreq", String.valueOf(l1));
      localHashMap.put("memory", String.valueOf(l2));
      if (paramInt2 <= 2) {
        break label180;
      }
    }
    label180:
    for (boolean bool = cNi;; bool = cNh)
    {
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
      return;
    }
  }
  
  public static void dVV()
  {
    int i = imm.getCpuArchitecture();
    int j = imm.getNumCores();
    long l1 = imm.getMaxCpuFreq();
    long l2 = aqgz.getSystemTotalMemory() / 1048576L;
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cpuArch", String.valueOf(i));
    localHashMap.put("numCores", String.valueOf(j));
    localHashMap.put("maxFreq", String.valueOf(l1));
    localHashMap.put("memory", String.valueOf(l2));
    localHashMap.put("param_FailCode", String.valueOf(i));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttCpuArch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void dVW()
  {
    dVX();
    dVY();
  }
  
  private static void dVX()
  {
    if (c.poll() != null)
    {
      dPV += 1;
      cNj = false;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "gc occurred:" + dPV);
      }
    }
    if (!cNj)
    {
      a = new PhantomReference(new Object(), c);
      cNj = true;
      if (QLog.isColorLevel()) {
        QLog.e("PttInfoCollector", 2, "add object enqueue to detect gc");
      }
    }
  }
  
  private static void dVY()
  {
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      long l1 = localRuntime.freeMemory();
      long l2 = localRuntime.totalMemory();
      if (aqd != 0L)
      {
        if (l2 - l1 <= aqd) {
          break label64;
        }
        aqe += l2 - l1 - aqd;
        dPW += 1;
      }
      for (;;)
      {
        aqd = l2 - l1;
        return;
        label64:
        aqf += aqd - (l2 - l1);
        releaseCount += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      paramInt1 = 9999;
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", paramInt1, paramInt2, "", "", "", "3.4.4");
      return;
    }
  }
  
  public static void jK(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    if (dPW != 0) {}
    for (long l1 = aqe / dPW;; l1 = 0L)
    {
      if (releaseCount != 0) {}
      for (long l2 = aqf / releaseCount;; l2 = 0L)
      {
        localHashMap.put("consumePerFrame", String.valueOf(l1));
        localHashMap.put("releasePerGc", String.valueOf(l2));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (QLog.isColorLevel())
        {
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost gcCount=" + dPV + " type=" + paramInt1 + " time" + paramInt2);
          QLog.e("PttInfoCollector", 2, "reportSoundProcessCost consume=" + l1 + " release=" + l2);
        }
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPttGcCount", true, paramInt2, dPV, localHashMap, "");
        dPV = 0;
        cNj = false;
        c.poll();
        aqd = 0L;
        aqe = 0L;
        aqf = 0L;
        dPW = 0;
        releaseCount = 0;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomq
 * JD-Core Version:    0.7.0.1
 */