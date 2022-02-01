import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ikp
{
  private static String NB;
  public static int aog;
  private static Handler.Callback b = new ikq();
  private static Map<String, String> cS = new HashMap();
  private static Handler handler;
  private static HandlerThread handlerThread;
  private static VideoAppInterface mApp;
  
  public static void A(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      if (!paramBoolean)
      {
        try
        {
          if (kW() != 0) {
            continue;
          }
          anv();
          igd.aH("VideoNodeManager", "--> checkAndClearSession() ***********************************");
          continue;
        }
        finally {}
      }
      else if (!tE())
      {
        anw();
        igd.aI("VideoNodeManager", "--> checkAndClearSession()  temp ***********************************");
      }
    }
  }
  
  private static int a(Map<String, ?> paramMap)
  {
    long l = getTotalMemory();
    return (int)((float)Long.valueOf(b("22", "0", paramMap)).longValue() / (float)l * 100.0F);
  }
  
  public static boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (paramInt != 0)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 31) || (paramInt == 32));
      if ((!paramBoolean1) && (dm(paramInt + "") != null))
      {
        igd.aI("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + iko.aJ(paramInt));
        return true;
      }
    } while ((!paramBoolean1) || (cS.get(paramInt + "") == null));
    igd.aI("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + iko.aJ(paramInt));
    return true;
  }
  
  public static boolean am(long paramLong)
  {
    return (bB() == -1L) || (bB() == 0L) || (paramLong == bB());
  }
  
  public static void anA()
  {
    igd.aI("VideoNodeManager", "=========> SYNC Start !!---------------------------  mTempSeesionRecord.size() = " + cS.size());
    if (tE())
    {
      anv();
      if (cS.size() > 0)
      {
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).edit();
        Iterator localIterator = cS.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          igd.aI("VideoNodeManager", "=========> SYNC Temp !!   node= " + iko.aJ(Integer.valueOf((String)localEntry.getKey()).intValue()) + "     Value = " + (String)localEntry.getValue());
          localEditor.putString((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        localEditor.commit();
      }
    }
    igd.aI("VideoNodeManager", "=========> SYNC end !!----------------------------------");
    anw();
  }
  
  public static void ant()
  {
    bT(bB());
  }
  
  public static void anu()
  {
    if (handler == null) {
      return;
    }
    igd.aH("VideoNodeManager", "--> reportToServer() ----------------------------------------");
    handler.sendEmptyMessage(3);
  }
  
  public static void anv()
  {
    QLog.d("VideoNodeManager", 1, "--> resetVideoNode() ----------------------------------------");
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public static void anw()
  {
    QLog.e("VideoNodeManager", 1, "--> resetTempSeesionRecord() ----------------------------------------");
    cS.clear();
  }
  
  public static void anx()
  {
    try
    {
      int i = kW();
      igd.aH("VideoNodeManager", "--> checkAndReport() reportStatus = " + i);
      if (i == 1)
      {
        igd.aH("VideoNodeManager", "--> checkAndReport() ***********************************");
        anu();
      }
      return;
    }
    finally {}
  }
  
  public static void any()
  {
    igd.aI("VideoNodeManager", "--> checkAndReportTempRecord() ***********************************");
    if (tE()) {
      anz();
    }
  }
  
  public static void anz()
  {
    if (handler == null) {
      return;
    }
    igd.aI("VideoNodeManager", "--> reportTempRecordToServer() =================================");
    handler.sendEmptyMessage(5);
  }
  
  private static String b(String paramString1, String paramString2, Map<String, ?> paramMap)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramMap == null)) {
      return null;
    }
    if (paramMap.containsKey(paramString1)) {
      return (String)paramMap.get(paramString1);
    }
    return paramString2;
  }
  
  private static void b(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (mApp == null)
        {
          QLog.e("VideoNodeManager", 1, "reportToHandler param is null  !!!!!!!!!-------------------");
          return;
        }
        if (!mApp.RD) {
          break label92;
        }
        break label92;
        if ((tE()) && (cj(paramInt)))
        {
          d(paramLong1, paramInt, paramLong2, paramBoolean);
          c(paramLong1, paramInt, paramLong2, paramBoolean);
          continue;
        }
        if (am(paramLong1)) {
          continue;
        }
      }
      finally {}
      d(paramLong1, paramInt, paramLong2, paramBoolean);
      continue;
      label92:
      if ((paramLong1 == 0L) || (paramLong1 != -1L)) {}
    }
  }
  
  public static long bB()
  {
    iiv localiiv = igv.a().a();
    if (localiiv == null) {
      return 0L;
    }
    return localiiv.getRoomId();
  }
  
  public static void bT(long paramLong)
  {
    igd.aH("VideoNodeManager", "--> onSessionCreate() roomId = " + paramLong);
    if (handler != null)
    {
      handler.removeMessages(1);
      handler.sendEmptyMessage(1);
    }
    if (am(paramLong)) {
      anx();
    }
    d(paramLong, 0, 1L);
  }
  
  public static void bU(long paramLong)
  {
    if (handler == null) {
      return;
    }
    handler.removeMessages(1);
    if (am(paramLong))
    {
      igd.aH("VideoNodeManager", "--> onSessionDestroy() roomId = " + paramLong);
      anx();
      return;
    }
    igd.aI("VideoNodeManager", "--> onSessionDestroy() TempSessionRecord roomId = " + paramLong);
    any();
  }
  
  private static void c(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    if (handler == null) {
      return;
    }
    Message localMessage = handler.obtainMessage();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    localMessage.setData(localBundle);
    handler.sendMessage(localMessage);
  }
  
  private static boolean cj(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 19) || (paramInt == 18) || (paramInt == 23) || (paramInt == 21) || (paramInt == 22);
  }
  
  private static boolean ck(int paramInt)
  {
    return (paramInt != 24) && (paramInt != 18) && (paramInt != 23) && (paramInt != 21) && (paramInt != 22);
  }
  
  public static void d(long paramLong1, int paramInt, long paramLong2)
  {
    b(paramLong1, paramInt, paramLong2, false);
  }
  
  private static void d(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    if (handler == null) {
      return;
    }
    Message localMessage = handler.obtainMessage();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    localMessage.setData(localBundle);
    handler.sendMessage(localMessage);
  }
  
  private static String dm(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).getString(paramString, null);
  }
  
  private static String e(Map<String, ?> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    while (((Build.MODEL != null) && ("Android SDK built for x86".equals(Build.MODEL))) || (!b("15", "0", paramMap).equals("1"))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localStringBuilder.append("Android").append('|');
      localStringBuilder.append(String.valueOf(Build.VERSION.SDK_INT)).append('|');
      localStringBuilder.append("3.4.4").append('|');
      localStringBuilder.append(Build.MANUFACTURER).append('|');
      localStringBuilder.append(Build.MODEL).append('|');
      localStringBuilder.append(b("9", "0", paramMap)).append('|');
      localStringBuilder.append(getSelfUin()).append('|');
      localStringBuilder.append(b("11", "0", paramMap)).append('|');
      localStringBuilder.append(b("12", "0", paramMap)).append('|');
      localStringBuilder.append(b("13", "0", paramMap)).append('|');
      localStringBuilder.append(b("14", "0", paramMap)).append('|');
      localStringBuilder.append(b("15", "0", paramMap)).append('|');
      localStringBuilder.append(b("16", "0", paramMap)).append('|');
      localStringBuilder.append(b("17", "0", paramMap)).append('|');
      localStringBuilder.append(b("18", "0", paramMap)).append('|');
      localStringBuilder.append(b("19", "0", paramMap)).append('|');
      localStringBuilder.append(b("20", "0", paramMap)).append('|');
      localStringBuilder.append(getTotalMemory() + "").append('|');
      localStringBuilder.append(b("22", "0", paramMap)).append('|');
      localStringBuilder.append(b("23", "0", paramMap)).append('|');
      localStringBuilder.append(b("24", "0", paramMap)).append('|');
      localStringBuilder.append(b("25", "0", paramMap)).append('|');
      localStringBuilder.append(b("26", "0", paramMap)).append('|');
      localStringBuilder.append(b("27", "0", paramMap)).append('|');
      localStringBuilder.append(b("28", "0", paramMap)).append('|');
      localStringBuilder.append(b("29", "0", paramMap)).append('|');
      localStringBuilder.append(b("30", "0", paramMap)).append('|');
      localStringBuilder.append(b("31", "0", paramMap)).append('|');
      localStringBuilder.append(b("32", "0", paramMap)).append('|');
      localStringBuilder.append(b("33", "0", paramMap)).append('|');
      localStringBuilder.append(b("34", "0", paramMap)).append('|');
      localStringBuilder.append(b("35", "0", paramMap)).append('|');
      localStringBuilder.append(b("36", "0", paramMap)).append('|');
      localStringBuilder.append(b("37", "0", paramMap)).append('|');
      localStringBuilder.append(b("38", "0", paramMap)).append('|');
      localStringBuilder.append(b("39", "0", paramMap)).append('|');
      localStringBuilder.append("7").append('|');
      localStringBuilder.append(b("41", "0", paramMap)).append('|');
      localStringBuilder.append(a(paramMap)).append('|');
    }
    return localStringBuilder.toString();
  }
  
  public static void e(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramInt == 20) {
      aog = (int)paramLong;
    }
    for (;;)
    {
      return;
      if ((paramInt == 27) || (paramInt == 28) || (paramInt == 36) || (paramInt == 29) || (paramInt == 31) || (paramInt == 32) || (paramInt == 30))
      {
        if (ivv.isAppOnForeground(BaseApplicationImpl.getApplication())) {}
        for (int i = 1; i != aog; i = 2)
        {
          aog = i;
          igd.aH("VideoNodeManager", "checkAppOnForeground()  isAppOnForeground change !!! = " + aog);
          if (paramBoolean) {
            break label161;
          }
          k(paramInt + "", aog + "", false);
          return;
        }
      }
    }
    label161:
    j(paramInt + "", aog + "", false);
  }
  
  public static void e(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.contains("+")) {
      paramString.replace("+", "");
    }
    try
    {
      b(paramLong, paramInt, Long.valueOf(paramString.trim()).longValue(), false);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public static void e(VideoAppInterface paramVideoAppInterface)
  {
    igd.aH("VideoNodeManager", "--> init()");
    mApp = paramVideoAppInterface;
    String[] arrayOfString = BaseApplicationImpl.processName.split(":");
    Object localObject = null;
    paramVideoAppInterface = localObject;
    if (arrayOfString != null)
    {
      paramVideoAppInterface = localObject;
      if (arrayOfString.length == 2) {
        paramVideoAppInterface = arrayOfString[1];
      }
    }
    NB = "video_node_manager_" + paramVideoAppInterface;
    if (handler == null)
    {
      handlerThread = new HandlerThread("VideoNodeReportThread");
      handlerThread.start();
      handler = new Handler(handlerThread.getLooper(), b);
    }
  }
  
  public static boolean g(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (dm(paramInt + "") != null))
    {
      igd.aI("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + iko.aJ(paramInt));
      return true;
    }
    if ((paramBoolean) && (cS.get(paramInt + "") != null))
    {
      igd.aI("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + iko.aJ(paramInt));
      return true;
    }
    return false;
  }
  
  private static String gN()
  {
    return e(BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).getAll());
  }
  
  private static String gO()
  {
    return e(cS);
  }
  
  private static long getCurrentTime()
  {
    return System.currentTimeMillis();
  }
  
  public static long getDuration()
  {
    if (igv.a().a().lj == 0L) {
      return 0L;
    }
    return (SystemClock.elapsedRealtime() - igv.a().a().lj) / 1000L + igv.a().a().lk;
  }
  
  private static String getSelfUin()
  {
    if ((mApp != null) && (mApp.getCurrentAccountUin() != null)) {
      return mApp.getCurrentAccountUin();
    }
    return "0";
  }
  
  public static long getTotalMemory()
  {
    return aqgz.getSystemTotalMemory() / 1024L / 1024L;
  }
  
  private static void j(String paramString1, String paramString2, boolean paramBoolean)
  {
    cS.put(paramString1, paramString2);
    if (paramBoolean) {
      cS.put("17", paramString1);
    }
  }
  
  private static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(NB, 0).edit();
    localEditor.putString(paramString1, paramString2);
    if (paramBoolean) {
      localEditor.putString("17", paramString1 + "");
    }
    localEditor.commit();
  }
  
  public static void kQ(int paramInt)
  {
    b(bB(), paramInt, getCurrentTime(), true);
  }
  
  public static void kR(int paramInt)
  {
    igd.aH("VideoNodeManager", "=========> setSessionType()  original sessionType = " + paramInt);
    if ((paramInt == 1) || (paramInt == 2)) {
      r(15, 1L);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    r(15, 2L);
  }
  
  private static int kW()
  {
    String str = dm("0");
    if ((str == null) || (str.equals("0"))) {
      return 0;
    }
    return 1;
  }
  
  public static void r(int paramInt, long paramLong)
  {
    b(bB(), paramInt, paramLong, false);
  }
  
  public static void release()
  {
    igd.aH("VideoNodeManager", "--> release()");
    mApp = null;
    if (handler != null)
    {
      handler.removeCallbacksAndMessages(null);
      handler = null;
      handlerThread.quit();
      handlerThread = null;
    }
  }
  
  public static void report(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.contains("+")) {
      paramString.replace("+", "");
    }
    try
    {
      long l = Long.valueOf(paramString.trim()).longValue();
      b(bB(), paramInt, l, false);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public static void reportMemory()
  {
    try
    {
      long l1 = aqgz.getSystemAvaialbeMemory() / 1024L / 1024L;
      long l2 = aqgz.L(Process.myPid()) / 1024L / 1024L;
      r(22, l1);
      r(23, l2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeManager", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  public static void s(long paramLong, int paramInt)
  {
    b(paramLong, paramInt, getCurrentTime(), true);
  }
  
  private static boolean tE()
  {
    String str = (String)cS.get("0");
    return (str != null) && (str.equals("1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikp
 * JD-Core Version:    0.7.0.1
 */