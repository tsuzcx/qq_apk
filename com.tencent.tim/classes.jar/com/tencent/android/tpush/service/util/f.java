package com.tencent.android.tpush.service.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
{
  static List<String> a = new ArrayList();
  private static long b = 0L;
  private static long c = 0L;
  private static int d = -1;
  
  public static Intent a(int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
    if ((paramString != null) && (paramString.length() != 0)) {
      localIntent.setPackage(paramString);
    }
    localIntent.putExtra("TPUSH.FEEDBACK", paramInt2);
    localIntent.putExtra("TPUSH.ERRORCODE", paramInt1);
    return localIntent;
  }
  
  public static List<String> a()
  {
    if (a.isEmpty())
    {
      a.add("com.jingdong.app.mall");
      a.add("com.ifeng.news2");
    }
    return a;
  }
  
  public static List<ResolveInfo> a(Context paramContext)
  {
    TLogger.d("ServiceUtil", "action - getLocalPushAppsInfo");
    HashMap localHashMap;
    if (paramContext != null) {
      try
      {
        localHashMap = new HashMap();
        paramContext = paramContext.getPackageManager();
        Object localObject = paramContext.queryIntentActivities(new Intent("android.intent.action"), 32);
        ((List)localObject).addAll(paramContext.queryIntentActivities(new Intent(""), 32));
        ((List)localObject).addAll(paramContext.queryBroadcastReceivers(new Intent("com.tencent.android.xg.vip.action.SDK"), 512));
        paramContext = ((List)localObject).iterator();
        while (paramContext.hasNext())
        {
          localObject = (ResolveInfo)paramContext.next();
          localHashMap.put(((ResolveInfo)localObject).activityInfo.applicationInfo.packageName, localObject);
          continue;
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("ServiceUtil", "getLocalPushAppsInfo", paramContext);
      }
    }
    paramContext = new ArrayList(localHashMap.values());
    return paramContext;
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str1;
    do
    {
      return;
      str1 = paramJSONObject.optString("name", "");
    } while ((i.b(str1)) || (h(paramContext, str1)) || (g(paramContext, str1)));
    TLogger.d("ServiceUtil", "action - pullUpOtherServiceByProviderAndActivityJSONOject, proName:" + str1);
    String str2 = paramJSONObject.optString("intent", "");
    if (!i.b(str2)) {}
    for (;;)
    {
      try
      {
        Intent localIntent1 = new Intent(str2);
        localIntent1.setFlags(268435456);
        paramContext.startActivity(localIntent1);
        paramJSONObject = paramJSONObject.optString("url", "");
        if (i.b(paramJSONObject)) {
          break;
        }
        CommonWorkingThread.getInstance().execute(new f.1(paramContext, str1, paramJSONObject), 2000L);
        return;
      }
      catch (Throwable localThrowable1)
      {
        TLogger.d("ServiceUtil", "unexpected for start activity for action:" + str2);
        continue;
      }
      str2 = paramJSONObject.optString("schema", "");
      if (!i.b(str2)) {
        try
        {
          Intent localIntent2 = new Intent("android.intent.action.VIEW");
          localIntent2.setData(Uri.parse(str2));
          localIntent2.setFlags(268435456);
          paramContext.startActivity(localIntent2);
        }
        catch (Throwable localThrowable2)
        {
          TLogger.d("ServiceUtil", "unexpected for start activity for schema:" + str2);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.queryIntentServices(new Intent(paramContext.createPackageContext(paramString, 0), XGVipPushService.class), 0);
      if ((paramContext == null) || (paramContext.isEmpty())) {
        break label117;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        boolean bool = ((ResolveInfo)paramContext.next()).serviceInfo.processName.contains("xg_vip_service");
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.w("ServiceUtil", "unexpected for isXGServiceV4ProcssNameConfigByName:" + paramContext.getMessage());
    }
    return false;
    label117:
    return false;
  }
  
  public static boolean a(Intent paramIntent)
  {
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new JSONObject(Rijndael.decrypt(paramIntent.getStringExtra("content")));
        if (paramIntent.isNull("accept_time")) {
          return true;
        }
        paramIntent = paramIntent.getString("accept_time");
        JSONArray localJSONArray = new JSONArray(paramIntent);
        if (localJSONArray.length() != 0)
        {
          Object localObject = Calendar.getInstance();
          int j = ((Calendar)localObject).get(11) * 60 + ((Calendar)localObject).get(12);
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject = new JSONObject(localJSONArray.getString(i));
            JSONObject localJSONObject = new JSONObject(((JSONObject)localObject).getString("start"));
            int k = Integer.valueOf(localJSONObject.getString("hour")).intValue();
            k = Integer.valueOf(localJSONObject.getString("min")).intValue() + k * 60;
            localObject = new JSONObject(((JSONObject)localObject).getString("end"));
            int m = Integer.valueOf(((JSONObject)localObject).getString("hour")).intValue() * 60 + Integer.valueOf(((JSONObject)localObject).getString("min")).intValue();
            TLogger.i("ServiceUtil", ">> check accept time, current:" + j + ", startTime:" + k + ", endTime:" + m);
            if (k > j) {
              break label338;
            }
            if (j > m) {
              break label338;
            }
          }
          else
          {
            TLogger.w("Utils", " discurd the msg due to time not accepted! acceptTime = " + paramIntent + " , curTime= " + j);
            return false;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        TLogger.d("ServiceUtil", "checkAcceptTime " + paramIntent.toString());
      }
      return true;
      label338:
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    return a().contains(paramString);
  }
  
  public static long b(Intent paramIntent)
  {
    int i = 0;
    for (;;)
    {
      int j;
      int m;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        localObject2 = paramIntent.getStringExtra("date");
        localObject1 = localObject2;
        if (i.b((String)localObject2)) {
          localObject1 = localSimpleDateFormat.format(new Date());
        }
        l = localSimpleDateFormat.parse((String)localObject1).getTime();
        paramIntent = new JSONObject(Rijndael.decrypt(paramIntent.getStringExtra("content")));
        if (paramIntent.isNull("accept_time")) {
          return l;
        }
        paramIntent = paramIntent.getString("accept_time");
        localObject1 = new JSONArray(paramIntent);
        if (((JSONArray)localObject1).length() != 0) {
          break label295;
        }
        return l;
      }
      catch (Throwable paramIntent)
      {
        Object localObject2;
        Object localObject1;
        long l;
        TLogger.d("ServiceUtil", "getAcceptBeginTime " + paramIntent.toString());
        return 0L;
      }
      if (j < ((JSONArray)localObject1).length())
      {
        localObject2 = new JSONObject(new JSONObject(((JSONArray)localObject1).getString(j)).getString("start"));
        m = Integer.valueOf(((JSONObject)localObject2).getString("hour")).intValue() * 60 + Integer.valueOf(((JSONObject)localObject2).getString("min")).intValue();
        if (m >= i)
        {
          k = i;
          if (i != 0) {
            break label303;
          }
        }
      }
      else
      {
        l = i * 60 * 1000L + l;
        TLogger.i("Utils", "get acceptTime = " + paramIntent + " , acceptBeginTime= " + l);
        return l;
        label295:
        j = 0;
        continue;
      }
      int k = m;
      label303:
      j += 1;
      i = k;
    }
  }
  
  public static void b(Context paramContext)
  {
    TLogger.d("ServiceUtil", "action - pullUpServerConfigPkgs");
    label318:
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.android.tpush.service.a.a.a(paramContext).K;
        if (localObject != null)
        {
          Iterator localIterator = ((Map)localObject).entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            try
            {
              if (h(paramContext, (String)localEntry.getKey())) {
                continue;
              }
              String str = "am startservice -n " + (String)localEntry.getKey() + "/" + (String)localEntry.getValue();
              localObject = Runtime.getRuntime().exec(str);
              int i = ((Process)localObject).waitFor();
              if (i == 0) {
                break label318;
              }
              str = "am startservice --user 0 -n " + (String)localEntry.getKey() + "/" + (String)localEntry.getValue();
              TLogger.d("ServiceUtil", "start service:" + str);
              localObject = Runtime.getRuntime().exec(str);
              i = ((Process)localObject).waitFor();
              if (i == 0) {
                continue;
              }
              TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + str + ",exitValud:" + ((Process)localObject).exitValue());
            }
            catch (Throwable localThrowable)
            {
              TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + localThrowable);
            }
            continue;
          }
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("ServiceUtil", "", paramContext);
      }
      TLogger.d("ServiceUtil", "pullUpServerConfigPkgs no pull up packages map");
      return;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramContext = XGVipPushService.class.getName();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ActivityManager.RunningServiceInfo)((Iterator)localObject1).next();
          if ((((ActivityManager.RunningServiceInfo)localObject2).pid != 0) && (paramContext.equals(((ActivityManager.RunningServiceInfo)localObject2).service.getClassName())))
          {
            localObject2 = ((ActivityManager.RunningServiceInfo)localObject2).service.getPackageName();
            if ((i.c((String)localObject2)) && (((String)localObject2).equals(paramString)))
            {
              TLogger.d("ServiceUtil", "isSurvive srvPkg :" + (String)localObject2);
              return true;
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ServiceUtil", "checkXGServiceV3IsRunningByPkgName", paramContext);
    }
    return false;
  }
  
  public static List<ResolveInfo> c(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramString = new Intent(paramString);
      try
      {
        paramContext = paramContext.getPackageManager().queryIntentServices(paramString, 512);
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("ServiceUtil", "getLocalPushServicesInfo", paramContext);
        return null;
      }
    }
    TLogger.e("ServiceUtil", "getLocalPushServicesInfo the context == null");
    return null;
  }
  
  public static void c(Context paramContext)
  {
    JSONArray localJSONArray;
    try
    {
      if (CloudManager.getInstance(paramContext).getAppClsAlive() == 1)
      {
        TLogger.d("ServiceUtil", "disable pull up group");
        return;
      }
      localJSONArray = CloudManager.getInstance(paramContext).getPullupArrProviderAndActivity();
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        TLogger.i("ServiceUtil", "pullupOtherServiceByProviderAndActivity no running");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ServiceUtil", "pullupOtherServiceByProviderAndActivity" + paramContext);
      return;
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      a(paramContext, localJSONArray.optJSONObject(i));
      i += 1;
    }
  }
  
  public static void d(Context paramContext)
  {
    if (com.tencent.android.tpush.f.a.a(paramContext))
    {
      TLogger.dd("ServiceUtil", "Run As SysPush, Not pull up other XGService");
      return;
    }
    if (GuidInfoManager.isServerDestroy(paramContext))
    {
      TLogger.ii("ServiceUtil", "server destroy, Not pull up other app");
      return;
    }
    if (ChannelUtils.isMiuiV12())
    {
      TLogger.dd("ServiceUtil", "Run As MIUI 12, Not pull up other XGService");
      return;
    }
    if (CloudManager.getInstance(paramContext).disablePullUp())
    {
      TLogger.dd("ServiceUtil", " Not pullup other XGService with cloud");
      return;
    }
    if (a(paramContext.getPackageName()))
    {
      TLogger.dd("ServiceUtil", paramContext.getPackageName() + " ignore pull up");
      return;
    }
    TLogger.d("ServiceUtil", "not in ignore app list");
    if (PushPreferences.getBoolean(paramContext, "pull.up.other.app", false)) {
      TLogger.i("ServiceUtil", "default pull up other app");
    }
    try
    {
      f(paramContext);
      c(paramContext);
      b(paramContext);
      return;
      TLogger.ii("ServiceUtil", "disable pull up other app");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TLogger.e("ServiceUtil", "pullUpXGServiceByProvider" + localThrowable);
      }
    }
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      Object localObject = CacheManager.getRegisterInfos(paramContext);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if ((((String)((Iterator)localObject).next()).equals(paramString)) && (!paramContext.getPackageName().equals(paramString))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void e(Context paramContext)
  {
    try
    {
      paramContext = b.d(paramContext);
      TLogger.d("ServiceUtil", "serviceSafeExit @ " + paramContext);
      if ((paramContext != null) && (paramContext.contains(":xg_vip_service"))) {
        XGVipPushService.a().stopSelf();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ServiceUtil", "unexpected for serviceSafeExit", paramContext);
    }
  }
  
  private static void f(Context paramContext)
  {
    TLogger.d("ServiceUtil", "action - pullUpXGServiceByProvider on 2s later");
    CommonWorkingThread.getInstance().execute(new f.2(paramContext), 2000L);
  }
  
  private static boolean g(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.startsWith(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h(Context paramContext, String paramString)
  {
    if (i.b(paramString)) {}
    do
    {
      return false;
      paramContext = CloudManager.getInstance(paramContext).getPullupBlackList();
    } while (i.b(paramContext));
    return paramContext.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.f
 * JD-Core Version:    0.7.0.1
 */