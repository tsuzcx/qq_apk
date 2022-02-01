import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class anod
{
  private static boolean bmR = true;
  private static boolean cIO;
  private static volatile int dKA;
  private static volatile int dKB;
  private static volatile int dKC;
  private static volatile int dKD;
  private static volatile int dKE;
  private static volatile int dKt;
  private static volatile int dKu;
  private static volatile int dKv;
  private static volatile int dKw;
  private static volatile int dKx;
  private static volatile int dKy;
  private static volatile int dKz;
  private static HashMap<String, Long> nw = new HashMap();
  private static volatile boolean sInit;
  private static long sLastReportTime;
  
  public static void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!cIO) || (!sInit)) {
      return;
    }
    int i;
    switch (paramInt3)
    {
    default: 
      i = 2;
      label39:
      if (paramInt1 == 0)
      {
        if (paramInt2 == 0) {
          jD(i, paramInt4);
        }
      }
      else {
        label53:
        if (paramInt1 == 1)
        {
          if (paramInt2 != 0) {
            break label135;
          }
          jF(i, paramInt4);
        }
      }
      break;
    }
    while (bmR)
    {
      QLog.d("FightMsgReporter", 1, "add count = " + paramInt4 + ",uinType = " + paramInt3);
      return;
      i = 0;
      break label39;
      i = 1;
      break label39;
      if (paramInt2 != 1) {
        break label53;
      }
      jC(i, paramInt4);
      break label53;
      label135:
      if (paramInt2 == 1) {
        jE(i, paramInt4);
      }
    }
  }
  
  private static long a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    paramString = b(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt1, paramString, paramInt2);
    if (nw.containsKey(paramString)) {
      paramLong = ((Long)nw.get(paramString)).longValue();
    }
    return paramLong;
  }
  
  private static String b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return String.format("%d_%s_%d_%s", new Object[] { Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString1 });
  }
  
  private static void b(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString = b(str, paramInt1, paramString, paramInt2);
    nw.put(paramString, Long.valueOf(paramLong));
    aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, paramString, Long.valueOf(paramLong));
  }
  
  public static void dSD()
  {
    if ((!cIO) || (!sInit)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend", Integer.valueOf(dKu));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop", Integer.valueOf(dKt));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other", Integer.valueOf(dKv));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(dKx));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(dKw));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other_aio", Integer.valueOf(dKy));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend", Integer.valueOf(dKA));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop", Integer.valueOf(dKz));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other", Integer.valueOf(dKB));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(dKD));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(dKC));
      aqmj.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(dKE));
    } while (!bmR);
    QLog.d("FightMsgReporter", 1, "saveToSp.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(cIO), Integer.valueOf(dKu), Integer.valueOf(dKt), Integer.valueOf(dKx), Integer.valueOf(dKw), Integer.valueOf(dKA), Integer.valueOf(dKz), Integer.valueOf(dKD), Integer.valueOf(dKC) }));
  }
  
  private static void init()
  {
    anom.a locala = (anom.a)aeif.a().o(577);
    if (locala != null) {
      cIO = locala.cIO;
    }
    dKu = ((Integer)aqmj.get("key_msg_funnel_report_new_friend", Integer.valueOf(0))).intValue();
    dKt = ((Integer)aqmj.get("key_msg_funnel_report_new_troop", Integer.valueOf(0))).intValue();
    dKv = ((Integer)aqmj.get("key_msg_funnel_report_new_other", Integer.valueOf(0))).intValue();
    dKx = ((Integer)aqmj.get("key_msg_funnel_report_new_friend_aio", Integer.valueOf(0))).intValue();
    dKw = ((Integer)aqmj.get("key_msg_funnel_report_new_troop_aio", Integer.valueOf(0))).intValue();
    dKy = ((Integer)aqmj.get("key_msg_funnel_report_new_other_aio", Integer.valueOf(0))).intValue();
    dKA = ((Integer)aqmj.get("key_msg_funnel_report_readed_friend", Integer.valueOf(0))).intValue();
    dKz = ((Integer)aqmj.get("key_msg_funnel_report_readed_troop", Integer.valueOf(0))).intValue();
    dKB = ((Integer)aqmj.get("key_msg_funnel_report_readed_other", Integer.valueOf(0))).intValue();
    dKD = ((Integer)aqmj.get("key_msg_funnel_report_readed_friend_aio", Integer.valueOf(0))).intValue();
    dKC = ((Integer)aqmj.get("key_msg_funnel_report_readed_troop_aio", Integer.valueOf(0))).intValue();
    dKE = ((Integer)aqmj.get("key_msg_funnel_report_readed_other_aio", Integer.valueOf(0))).intValue();
    sLastReportTime = ((Long)aqmj.get("key_msg_report_time", Long.valueOf(System.currentTimeMillis()))).longValue();
    if (bmR) {
      QLog.d("FightMsgReporter", 1, "init.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(cIO), Integer.valueOf(dKu), Integer.valueOf(dKt), Integer.valueOf(dKx), Integer.valueOf(dKw), Integer.valueOf(dKA), Integer.valueOf(dKz), Integer.valueOf(dKD), Integer.valueOf(dKC) }));
    }
    sInit = true;
  }
  
  private static void jC(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      dKu += paramInt2;
      return;
    case 1: 
      dKt += paramInt2;
      return;
    }
    dKv += paramInt2;
  }
  
  private static void jD(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      dKx += paramInt2;
      return;
    case 1: 
      dKw += paramInt2;
      return;
    }
    dKy += paramInt2;
  }
  
  private static void jE(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      dKA += paramInt2;
      return;
    case 1: 
      dKz += paramInt2;
      return;
    }
    dKB += paramInt2;
  }
  
  private static void jF(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      dKD += paramInt2;
      return;
    case 1: 
      dKC += paramInt2;
      return;
    }
    dKE += paramInt2;
  }
  
  public static void report()
  {
    if (!sInit) {
      init();
    }
    if (!cIO) {}
    while (System.currentTimeMillis() - sLastReportTime <= 86400000L) {
      return;
    }
    if (bmR) {
      QLog.d("FightMsgReporter", 1, "report.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(cIO), Integer.valueOf(dKu), Integer.valueOf(dKt), Integer.valueOf(dKx), Integer.valueOf(dKw), Integer.valueOf(dKA), Integer.valueOf(dKz), Integer.valueOf(dKD), Integer.valueOf(dKC) }));
    }
    anot.c(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, dKu, "", "", "", "");
    anot.c(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, dKt, "", "", "", "");
    anot.c(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, dKA, "" + dKD, "", "", "");
    anot.c(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, dKz, "" + dKC, "", "", "");
    dKu = 0;
    dKt = 0;
    dKv = 0;
    dKx = 0;
    dKw = 0;
    dKy = 0;
    dKA = 0;
    dKz = 0;
    dKB = 0;
    dKD = 0;
    dKC = 0;
    dKE = 0;
    dSD();
  }
  
  public static void t(String paramString, long paramLong1, long paramLong2)
  {
    if (!cIO) {}
    long l;
    int i;
    do
    {
      return;
      if (!sInit) {
        init();
      }
      l = a(0, paramString, 1, paramLong2);
      i = (int)(paramLong1 - Math.max(l, paramLong2));
      T(0, 1, 1, i);
      b(0, paramString, 1, paramLong1);
    } while (!bmR);
    QLog.d("FightMsgReporter", 1, "computeTroopMsgNew.value:" + String.format("%s_%d_%d_%d_%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anod
 * JD-Core Version:    0.7.0.1
 */