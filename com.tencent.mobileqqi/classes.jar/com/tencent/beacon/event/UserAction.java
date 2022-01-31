package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.b.e;
import com.tencent.beacon.a.f;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.List;
import java.util.Map;

public class UserAction
{
  private static Context a = null;
  private static String b = "";
  private static String c = "10000";
  
  private static void a(Context paramContext, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, long paramLong)
  {
    a = paramContext.getApplicationContext();
    if (paramLong > 0L)
    {
      long l = paramLong;
      if (paramLong > 10000L) {
        l = 10000L;
      }
      com.tencent.beacon.a.b.d.a(l);
    }
    paramContext = m.a(a, paramBoolean);
    m.a(a, true, paramContext, null, null);
    com.tencent.beacon.b.d.a(a, paramContext);
  }
  
  public static void clearAppTotalConsume(Context paramContext)
  {
    f.c(paramContext);
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    f.c(paramContext);
  }
  
  public static void closeUseInfoEvent()
  {
    m localm = m.d();
    if (localm != null) {
      localm.f();
    }
  }
  
  public static void doUploadRecords()
  {
    m.g();
  }
  
  public static String getCloudParas(String paramString)
  {
    String str = null;
    Map localMap = e.a().d();
    if (localMap != null) {
      str = (String)localMap.get(paramString);
    }
    return str;
  }
  
  public static String getQIMEI()
  {
    if ((a == null) || (m.d() == null))
    {
      com.tencent.beacon.d.a.d("please initUserAction first!", new Object[0]);
      throw new RuntimeException("please initUserAction first!");
    }
    if (m.d().l() <= 0)
    {
      com.tencent.beacon.d.a.d("call this function getQIMEI untimely!", new Object[0]);
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = com.tencent.beacon.b.a.a(a).a();
      if (str == null) {
        break;
      }
      localObject = str;
    } while (!"".equals(str.trim()));
    Object localObject = com.tencent.beacon.a.d.m();
    if (localObject != null) {
      return ((com.tencent.beacon.a.d)localObject).i();
    }
    return "";
  }
  
  public static String getQQ()
  {
    return b;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = f.b(paramContext);
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      return paramContext.d + paramContext.e;
    }
    return -1L;
  }
  
  public static String getSDKVersion()
  {
    return "1.8.0";
  }
  
  public static d getUserActionRuntimeStrategy()
  {
    try
    {
      d locald = m.d().k();
      return locald;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String getUserID()
  {
    return c;
  }
  
  @Deprecated
  public static boolean heartbeatEvent()
  {
    com.tencent.beacon.d.a.c(" heartbeatEvent is Deprecated !", new Object[0]);
    return true;
  }
  
  public static void initUserAction(Context paramContext)
  {
    a(paramContext, null, true, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, null, paramBoolean, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    a(paramContext, null, paramBoolean, paramLong);
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    return m.a("wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static void onAppExited() {}
  
  public static boolean onMergeUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, CountItem... paramVarArgs)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      com.tencent.beacon.d.a.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
      return false;
    }
    return m.a(paramString, paramBoolean1, paramLong1, paramLong2, paramBoolean2, paramVarArgs);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      com.tencent.beacon.d.a.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
      return false;
    }
    return m.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2);
  }
  
  public static void setAppKey(Context paramContext, String paramString)
  {
    com.tencent.beacon.d.a.a(" setAppKey:" + paramString, new Object[0]);
    a = paramContext.getApplicationContext();
    if ((paramString != null) && (paramString.trim().length() > 0) && (paramString.trim().length() < 20))
    {
      paramContext = com.tencent.beacon.a.d.m();
      if (paramContext == null)
      {
        com.tencent.beacon.a.d.a(a);
        paramContext = com.tencent.beacon.a.d.m();
      }
      for (;;)
      {
        if (paramContext != null) {
          paramContext.c(paramString);
        }
        return;
        paramContext.c(paramString);
      }
    }
    com.tencent.beacon.d.a.c(" setAppKey: appkey is null or not available!", new Object[0]);
    throw new RuntimeException("appkey is null or not available! please check it!");
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    com.tencent.beacon.a.d locald2 = com.tencent.beacon.a.d.m();
    com.tencent.beacon.a.d locald1 = locald2;
    if (locald2 == null)
    {
      com.tencent.beacon.a.d.a(a);
      locald1 = com.tencent.beacon.a.d.m();
    }
    if (locald1 == null)
    {
      com.tencent.beacon.d.a.d("please set the channelID after call initUserAction!", new Object[0]);
      return;
    }
    locald1.b(paramString);
  }
  
  public static void setInitChannelPath(Context paramContext, String paramString)
  {
    if (a == null)
    {
      com.tencent.beacon.a.a.a(paramContext, paramString);
      return;
    }
    com.tencent.beacon.d.a.d("please set the channel path before call initUserAction!", new Object[0]);
    throw new RuntimeException("please set the channel path before call initUserAction!");
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.d.a.a = paramBoolean1;
    com.tencent.beacon.d.a.b = paramBoolean2;
  }
  
  @Deprecated
  public static void setNetSpeedMonitorUsable(boolean paramBoolean)
  {
    com.tencent.beacon.d.a.c(" SpeedMonitorModule is Deprecated !", new Object[0]);
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          b = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.d.a.c(" setQQ: set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.d.a.c(" setQQ: set qq is null !", new Object[0]);
  }
  
  public static void setUserActionUsable(boolean paramBoolean)
  {
    m localm = m.d();
    if (localm != null)
    {
      localm.a(paramBoolean);
      return;
    }
    com.tencent.beacon.d.a.c(" UserActionRecord.getInstance is null !", new Object[0]);
  }
  
  public static void setUserID(String paramString)
  {
    com.tencent.beacon.d.a.a(" setUserID:" + paramString, new Object[0]);
    if ((paramString != null) && (!"10000".equals(paramString)) && (paramString.trim().length() > 0)) {
      c = paramString;
    }
    if ((paramString != null) && (paramString.trim().length() < 5)) {
      com.tencent.beacon.d.a.c(" u set userID is too short, length less than 5!", new Object[0]);
    }
  }
  
  public static boolean testSpeedDomain(List<String> paramList)
  {
    m localm = m.d();
    if (localm != null) {
      return localm.b(paramList);
    }
    return false;
  }
  
  public static boolean testSpeedIp(List<String> paramList)
  {
    m localm = m.d();
    if (localm != null) {
      return localm.a(paramList);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */