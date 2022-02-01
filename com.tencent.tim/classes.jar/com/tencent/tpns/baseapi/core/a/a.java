package com.tencent.tpns.baseapi.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.NetworkUtil;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.StatHelper;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  private static boolean a = false;
  private static boolean b = false;
  private static String c = null;
  private static String d = null;
  private static long e = 0L;
  private static boolean f = false;
  private static long g = 0L;
  private static boolean h = false;
  
  public static GUIDInfo a(Context paramContext, int paramInt)
  {
    GUIDInfo localGUIDInfo = new GUIDInfo();
    if (paramContext == null)
    {
      Logger.e("GuidInfoManagerImpl", "context null");
      localGUIDInfo.errCode = -1;
      return localGUIDInfo;
    }
    if (GuidInfoManager.isServerDestroy(paramContext))
    {
      Logger.e("GuidInfoManagerImpl", "refreshConnectInfoSynchronized: Resources have been destroyed");
      localGUIDInfo.errCode = 10030006;
      return localGUIDInfo;
    }
    Logger.d("GuidInfoManagerImpl", "action - refreshConnectInfoSynchronized");
    if ((!Util.checkAccessId(XGApiConfig.getAccessId(paramContext))) || (!Util.checkAccessKey(XGApiConfig.getAccessKey(paramContext))))
    {
      localGUIDInfo.errCode = -501;
      return localGUIDInfo;
    }
    long l1 = System.currentTimeMillis();
    Logger.i("GuidInfoManagerImpl", "RefreshTime: " + l1);
    localObject1 = new JSONObject();
    long l2 = XGApiConfig.getAccessId(paramContext);
    localObject2 = XGApiConfig.getAccessKey(paramContext);
    long l3 = System.currentTimeMillis();
    try
    {
      ((JSONObject)localObject1).put("accessId", l2);
      ((JSONObject)localObject1).put("accessKey", localObject2);
      ((JSONObject)localObject1).put("deviceType", 0);
      ((JSONObject)localObject1).put("sdkVersion", "1.2.7.3");
      ((JSONObject)localObject1).put("seq", l1);
      ((JSONObject)localObject1).put("cloudVersion", CloudManager.getInstance(paramContext).getCloudVersion());
      Object localObject3 = new b();
      ((b)localObject3).a = Util.getCurAppVersion(paramContext);
      ((b)localObject3).b = TGlobalHelper.getDM(null);
      ((b)localObject3).d = "android";
      ((b)localObject3).e = paramContext.getPackageName();
      ((b)localObject3).f = Build.VERSION.RELEASE;
      ((JSONObject)localObject1).put("deviceInfo", ((b)localObject3).a());
      Object localObject4 = s(paramContext);
      localObject3 = (String)((Pair)localObject4).first;
      Object localObject6 = (String)((Pair)localObject4).second;
      if (localObject3 != null) {
        ((JSONObject)localObject1).put("token", localObject3);
      }
      if (!Util.isNullOrEmptyString((String)localObject6)) {
        ((JSONObject)localObject1).put("tokenList", new JSONArray((String)localObject6));
      }
      for (;;)
      {
        ((JSONObject)localObject1).put("protocolVersion", 2);
        ((JSONObject)localObject1).put("timestamp", l3);
        TBaseLogger.ii("GuidInfoManagerImpl", "Send request to GuidServer with token: " + (String)localObject3);
        TBaseLogger.i("GuidInfoManagerImpl", "Send request to GuidServer: " + ((JSONObject)localObject1).toString());
        localObject4 = com.tencent.tpns.baseapi.core.a.d(paramContext);
        localObject3 = com.tencent.tpns.baseapi.core.net.a.a((String)localObject4);
        localObject4 = c(paramContext, (String)localObject4);
        Logger.i("GuidInfoManagerImpl", "Send to GuidServerIpAddr: " + (String)localObject4);
        localObject1 = com.tencent.tpns.baseapi.core.net.a.a(paramContext).a((String)localObject4, (String)localObject3, ((JSONObject)localObject1).toString(), new a.1(paramContext, l1), true);
        if (!Util.isNullOrEmptyString((String)localObject1)) {
          break;
        }
        localGUIDInfo.errCode = -502;
        return localGUIDInfo;
        ((JSONObject)localObject1).put("tokenList", new JSONArray());
      }
      try
      {
        localObject2 = "cf5f04cd36" + l2 + (String)localObject2;
        TBaseLogger.ii("GuidInfoManagerImpl", "Get response from GuidServer: " + (String)localObject1);
        localObject3 = new JSONObject((String)localObject1);
        localObject4 = ((JSONObject)localObject3).optString("data", "");
        if (Util.isNullOrEmptyString((String)localObject4)) {
          break label1700;
        }
        localObject2 = new String(RC4.decrypt(Base64.decode((String)localObject4, 0), ((String)localObject2).getBytes("UTF-8")), "UTF-8");
        localObject1 = localObject2;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          JSONObject localJSONObject;
          String str1;
          String str2;
          Object localObject5;
          long l4;
          int i;
          JSONArray localJSONArray;
          continue;
          continue;
          localObject2 = localObject1;
          continue;
          if (paramInt != 0) {
            if (paramInt == 10030007)
            {
              continue;
              if ((str1 != null) && (str2 != null) && (localObject3 != null)) {
                if (localObject4 != null) {}
              }
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.ee("GuidInfoManagerImpl", "Send request to GuidServer: ", paramContext);
      localGUIDInfo.errCode = -101;
      return localGUIDInfo;
    }
    try
    {
      TBaseLogger.d("GuidInfoManagerImpl", "decode response:" + (String)localObject2);
      localObject1 = localObject2;
      localGUIDInfo.result = ((String)localObject2);
      localObject1 = localObject2;
      localJSONObject = new JSONObject((String)localObject2);
      localObject1 = localObject2;
      paramInt = ((JSONObject)localObject3).optInt("retCode", -1);
      localObject1 = localObject2;
      localObject4 = ((JSONObject)localObject3).optString("msg", "");
      if (paramInt != -1) {
        break label1707;
      }
      localObject1 = localObject2;
      Logger.e("GuidInfoManagerImpl", "GUID server error code " + paramInt + " error msg " + (String)localObject4);
      localObject1 = localObject2;
      localGUIDInfo.errCode = -502;
      return localGUIDInfo;
    }
    catch (Throwable paramContext) {}
    localObject1 = localObject2;
    CloudManager.getInstance(paramContext).parseCloudConfig(localJSONObject.optString("cloud", null), l1);
    localObject1 = localObject2;
    str1 = ((JSONObject)localObject3).optString("token", null);
    localObject1 = localObject2;
    str2 = localJSONObject.optString("mqttServer", null);
    localObject1 = localObject2;
    localObject3 = localJSONObject.optString("userName", null);
    localObject1 = localObject2;
    if (Util.isNullOrEmptyString((String)localObject3))
    {
      localObject1 = localObject2;
      localObject3 = localJSONObject.optString("mqttKey", null);
      localObject1 = localObject2;
      localObject5 = localJSONObject.optString("passWord", null);
      localObject1 = localObject2;
      localObject4 = localObject5;
      if (!Util.isNullOrEmptyString((String)localObject5)) {
        break label1721;
      }
      localObject1 = localObject2;
      localObject4 = localJSONObject.optString("mqttSecret", null);
      break label1721;
      localObject1 = localObject2;
      Logger.e("GuidInfoManagerImpl", "GUID_INFO_INCOMPLETE, result: " + (String)localObject2);
      localObject1 = localObject2;
      localGUIDInfo.errCode = -502;
      return localGUIDInfo;
      localObject1 = localObject2;
      l3 = localJSONObject.optInt("guid", 0);
      localObject1 = localObject2;
      l4 = localJSONObject.optLong("expiredSeconds", 0L);
      localObject1 = localObject2;
      i = localJSONObject.optInt("encrypt", 0);
      localObject1 = localObject2;
      localGUIDInfo.token = str1;
      localObject1 = localObject2;
      localJSONArray = localJSONObject.optJSONArray("invalidTokenList");
      localObject5 = localObject6;
      if (localJSONArray != null)
      {
        localObject1 = localObject2;
        Logger.i("GuidInfoManagerImpl", "Get invalidTokenList: " + localJSONArray);
        localObject1 = localObject2;
        localObject5 = a(localJSONArray, (String)localObject6);
      }
      localObject1 = localObject2;
      localObject5 = b(str1, (String)localObject5);
      localObject1 = localObject2;
      localObject6 = localJSONObject.optJSONArray("mqttPortList");
      if (localObject6 != null)
      {
        localObject1 = localObject2;
        localGUIDInfo.mqttPortList = ((JSONArray)localObject6).toString();
      }
      localObject1 = localObject2;
      localGUIDInfo.tokenList = ((String)localObject5);
      localObject1 = localObject2;
      localObject6 = localJSONObject.optString("sslMqttServer", null);
      localObject1 = localObject2;
      if (!Util.isNullOrEmptyString((String)localObject6))
      {
        localObject1 = localObject2;
        localGUIDInfo.mqttServer = ((String)localObject6);
        localObject1 = localObject2;
        localGUIDInfo.passWord = ((String)localObject4);
        localObject1 = localObject2;
        localGUIDInfo.userName = ((String)localObject3);
        localObject1 = localObject2;
        localGUIDInfo.refreshTime = l1;
        localObject1 = localObject2;
        localGUIDInfo.guid = l3;
        localObject1 = localObject2;
        localGUIDInfo.expiredSeconds = l4;
        localObject1 = localObject2;
        localGUIDInfo.guidLastAccessid = l2;
        localObject1 = localObject2;
        localGUIDInfo.encrypt = i;
        if (paramInt != 10030007) {
          break label1512;
        }
        localObject1 = localObject2;
        localGUIDInfo.refuseRate = localJSONObject.optInt("refuseRate", 0);
        localObject1 = localObject2;
        l1 = localJSONObject.optLong("penaltySeconds", 0L);
        if (l1 != 0L) {
          break label1460;
        }
        localObject1 = localObject2;
        PushPreferences.putLong(paramContext, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L);
      }
      for (;;)
      {
        localObject1 = localObject2;
        Logger.d("GuidInfoManagerImpl", "GUID -> write token: " + (String)localObject2);
        localObject1 = localObject2;
        localGUIDInfo.saveGuidToSha(paramContext);
        localObject1 = localObject2;
        b(paramContext, str1, (String)localObject5);
        return localGUIDInfo;
        localObject1 = localObject2;
        localGUIDInfo.mqttServer = str2;
        break;
        Logger.e("GuidInfoManagerImpl", "GUID server service code ", paramContext);
        localGUIDInfo.errCode = -503;
        localGUIDInfo.result = ((String)localObject1 + "\n " + Util.getThrowableToString(paramContext));
        return localGUIDInfo;
        label1460:
        localObject1 = localObject2;
        TBaseLogger.ww("GuidInfoManagerImpl", "GUID exceed receive penaltySeconds: " + l1);
        localObject1 = localObject2;
        PushPreferences.putLong(paramContext, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", l1 * 1000L + System.currentTimeMillis());
        continue;
        label1512:
        localObject1 = localObject2;
        localGUIDInfo.refuseRate = 0;
      }
      if (paramInt == 10030006)
      {
        localObject1 = localObject2;
        l1 = localJSONObject.optLong("penaltySeconds", 0L);
        if (l1 == 0L)
        {
          localObject1 = localObject2;
          PushPreferences.putLong(paramContext, "XG_GUID_SERVER_PENALTY_TIME", 0L);
        }
        for (;;)
        {
          localObject1 = localObject2;
          TBaseLogger.ww("GuidInfoManagerImpl", "GUID -> Server has been destroy");
          localObject1 = localObject2;
          localGUIDInfo.errCode = paramInt;
          return localGUIDInfo;
          localObject1 = localObject2;
          TBaseLogger.ww("GuidInfoManagerImpl", "GUID destroy receive penaltySeconds: " + l1);
          localObject1 = localObject2;
          PushPreferences.putLong(paramContext, "XG_GUID_SERVER_PENALTY_TIME", l1 * 1000L + System.currentTimeMillis());
        }
      }
      localObject1 = localObject2;
      TBaseLogger.ee("GuidInfoManagerImpl", "GUID server service code " + paramInt + " error msg " + (String)localObject4);
      localObject1 = localObject2;
      localGUIDInfo.errCode = paramInt;
      return localGUIDInfo;
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_TOKEN", null);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("GuidInfoManagerImpl", "getToken Throwable: ", paramContext);
    }
    return "";
  }
  
  private static String a(String paramString)
  {
    return Util.getKey(paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    try
    {
      localObject = Pattern.compile("(?<=//|)((\\w|-)+\\.)+(\\w|-)+(:\\d*)?").matcher(paramString1);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        paramString2 = paramString1.replace((CharSequence)localObject, paramString2);
        paramString1 = paramString2;
        try
        {
          Logger.d("GuidInfoManagerImpl", "replaceHostWithIp | host : " + (String)localObject + "; ipAddr : " + paramString1);
          return paramString1;
        }
        catch (Throwable paramString2) {}
        TBaseLogger.ee("GuidInfoManagerImpl", "replaceHostWithIp exception ", paramString2);
        return paramString1;
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        continue;
        Object localObject = "";
      }
    }
  }
  
  private static String a(JSONArray paramJSONArray, String paramString)
  {
    int k = 0;
    if (paramString != null) {}
    try
    {
      if (paramString.isEmpty()) {}
      ArrayList localArrayList;
      int j;
      for (paramString = new JSONArray();; paramString = new JSONArray(paramString))
      {
        localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= paramString.length()) {
            break;
          }
          localArrayList.add(paramString.getString(i));
          i += 1;
        }
      }
      while (j < paramJSONArray.length())
      {
        localArrayList.remove(paramJSONArray.getString(j));
        j += 1;
      }
      paramJSONArray = new JSONArray(localArrayList);
      Logger.i("GuidInfoManagerImpl", "Update tokenList: " + paramJSONArray.toString());
      paramJSONArray = paramJSONArray.toString();
      return paramJSONArray;
    }
    catch (Throwable paramJSONArray) {}
    return null;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    Logger.i("GuidInfoManagerImpl", "Last time: " + g + ", this time: " + paramLong);
    if (g != paramLong)
    {
      Logger.i("GuidInfoManagerImpl", "Save mqttServerLastRefreshTime: " + paramLong);
      g = paramLong;
      PushPreferences.putLong(paramContext.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", paramLong);
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 206	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: ldc 44
    //   18: new 96	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 524
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 23	com/tencent/tpns/baseapi/core/a/a:c	Ljava/lang/String;
    //   34: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 526
    //   40: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 113	com/tencent/tpns/baseapi/base/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: getstatic 23	com/tencent/tpns/baseapi/core/a/a:c	Ljava/lang/String;
    //   57: invokevirtual 529	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifne -48 -> 12
    //   63: aload_1
    //   64: putstatic 23	com/tencent/tpns/baseapi/core/a/a:c	Ljava/lang/String;
    //   67: aload_0
    //   68: invokevirtual 439	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   71: ldc_w 531
    //   74: aload_1
    //   75: invokestatic 534	com/tencent/tpns/baseapi/base/PushPreferences:putString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   78: goto -66 -> 12
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramContext	Context
    //   0	87	1	paramString	String
    //   7	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	81	finally
    //   16	78	81	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    PushPreferences.putString(paramContext, "XG_GUID_TOKEN", paramString2);
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_SERVER", paramString1);
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_USERNAME", "c34c9f3c514aa3560c38f74407f1a5bb");
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_PASSWORD", "9d8afb2ae393e47e7f3bbd254ed8c72e");
    PushPreferences.putLong(paramContext, "XG_GUID_EXPIRED_SECONDS", 172800L);
    PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", l);
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_TOKEN_LIST", null);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("GuidInfoManagerImpl", "getGuid Throwable: ", paramContext);
    }
    return "";
  }
  
  private static String b(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString2 != null) {}
    ArrayList localArrayList;
    try
    {
      if (paramString2.isEmpty()) {}
      for (paramString2 = new JSONArray();; paramString2 = new JSONArray(paramString2))
      {
        localArrayList = new ArrayList();
        while (i < paramString2.length())
        {
          localArrayList.add(paramString2.getString(i));
          i += 1;
        }
      }
      if (!localArrayList.contains(paramString1)) {
        break label93;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    localArrayList.remove(paramString1);
    label93:
    localArrayList.add(0, paramString1);
    while (localArrayList.size() > 10) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    paramString1 = new JSONArray(localArrayList);
    Logger.i("GuidInfoManagerImpl", "Update tokenList: " + paramString1.toString());
    paramString1 = paramString1.toString();
    return paramString1;
  }
  
  /* Error */
  public static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 206	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: ldc 44
    //   18: new 96	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 572
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 113	com/tencent/tpns/baseapi/base/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_1
    //   42: getstatic 25	com/tencent/tpns/baseapi/core/a/a:d	Ljava/lang/String;
    //   45: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne -36 -> 12
    //   51: aload_1
    //   52: putstatic 25	com/tencent/tpns/baseapi/core/a/a:d	Ljava/lang/String;
    //   55: aload_0
    //   56: invokevirtual 439	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   59: ldc_w 577
    //   62: aload_1
    //   63: invokestatic 534	com/tencent/tpns/baseapi/base/PushPreferences:putString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -54 -> 12
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   0	75	1	paramString	String
    //   7	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	69	finally
    //   16	66	69	finally
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("tpush.vip.service.shareprefs", 0).edit();
    paramContext.putString(a("XG_GUID_TOKEN"), paramString1);
    paramContext.putString(a("XG_GUID_TOKEN_LIST"), paramString2);
    paramContext.commit();
  }
  
  public static long c(Context paramContext)
  {
    return PushPreferences.getLong(paramContext.getApplicationContext(), "XG_GUID_GUID", 0L);
  }
  
  private static String c(Context paramContext, String paramString)
  {
    Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | XGConfig guidServerHostAddr : " + paramString);
    if (paramContext == null) {
      return paramString;
    }
    i = 0;
    for (;;)
    {
      try
      {
        localObject = new URL(paramString);
        if (localObject == null) {
          continue;
        }
        localObject = InetAddress.getByName(((URL)localObject).getHost());
        if (!(localObject instanceof Inet6Address)) {
          continue;
        }
        if (localObject == null) {
          continue;
        }
        localObject = "[" + ((InetAddress)localObject).getHostAddress() + "]";
        Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | update lastResolvedGuidServerIP , guidServerIPAddr : " + "" + "; guidServerIp : " + (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          GuidInfoManager.setLastResolvedGuidServerIP(paramContext, (String)localObject);
        }
        localObject = a(paramString, (String)localObject);
      }
      catch (UnknownHostException localUnknownHostException)
      {
        Throwable localThrowable1;
        i = -506;
        localObject = "";
        continue;
      }
      catch (Throwable localThrowable2)
      {
        i = -505;
        Object localObject = "";
        continue;
        Logger.w("GuidInfoManagerImpl", "getGuidServerAddress Throw Error: network unavailable");
        localObject = paramString;
        continue;
        localObject = "";
        continue;
      }
      localThrowable1 = null;
      if (localThrowable1 != null)
      {
        paramString = d(paramContext, paramString);
        TBaseLogger.ee("GuidInfoManagerImpl", "getGuidServerAddress | exception " + localThrowable1.toString(), localThrowable1);
        localObject = paramString;
        if (!b)
        {
          if (!NetworkUtil.isNetworkConnected(paramContext)) {
            continue;
          }
          StatHelper.reportErrCode(paramContext, i, "GUID DNS Throw Error: " + localThrowable1.getMessage(), 0L, "");
          b = true;
          localObject = paramString;
        }
      }
      Logger.d("GuidInfoManagerImpl", "getGuidServerIPAddress | result guidServerIPAddress : " + (String)localObject);
      return localObject;
      localObject = "";
      continue;
      if (localObject != null) {
        localObject = ((InetAddress)localObject).getHostAddress();
      } else {
        localObject = "";
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    return PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_MQTT_SERVER", null);
  }
  
  private static String d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      str = GuidInfoManager.getLastResolvedGuidServerIP(paramContext);
      paramContext = paramString;
    } while (TextUtils.isEmpty(str));
    paramContext = a(paramString, str);
    Logger.d("GuidInfoManagerImpl", "replaceGuidHostWithLastResolvedIP | lastResolvedIp : " + str + "; guidServerAddr : " + paramString + "; ipAddr : " + paramContext);
    return paramContext;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        c = PushPreferences.getString(paramContext.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", "");
        Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp is null, get from Shar");
      }
      Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp : " + c);
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      if (d == null)
      {
        Logger.i("GuidInfoManagerImpl", "MqttServerAddr null, get from Shar");
        d = PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", "");
      }
      Logger.i("GuidInfoManagerImpl", "Get mqttServerIP: " + d);
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public static String g(Context paramContext)
  {
    return PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_MQTT_USERNAME", null);
  }
  
  public static String h(Context paramContext)
  {
    return PushPreferences.getString(paramContext.getApplicationContext(), "XG_GUID_MQTT_PASSWORD", null);
  }
  
  public static long i(Context paramContext)
  {
    return PushPreferences.getLong(paramContext.getApplicationContext(), "XG_GUID_EXPIRED_SECONDS", 43200L);
  }
  
  public static long j(Context paramContext)
  {
    return PushPreferences.getLong(paramContext.getApplicationContext(), "XG_GUID_LAST_REFRESH_TIME", 0L);
  }
  
  public static boolean k(Context paramContext)
  {
    long l = j(paramContext.getApplicationContext());
    if (!f)
    {
      f = true;
      if (XGApiConfig.getAccessId(paramContext) != PushPreferences.getLong(paramContext, "XG_GUID_LAST_ACCESSID", 0L))
      {
        Logger.d("GuidInfoManagerImpl", "New AccessId need to refresh token");
        o(paramContext);
      }
    }
    do
    {
      return true;
      l = (System.currentTimeMillis() - l) / 1000L;
      Logger.i("GuidInfoManagerImpl", "GuidInfo gapSeconds = " + l + ", compare to " + i(paramContext.getApplicationContext()));
    } while (l > i(paramContext.getApplicationContext()));
    return false;
  }
  
  public static long l(Context paramContext)
  {
    if (g == 0L)
    {
      Logger.i("GuidInfoManagerImpl", "MqttServerLastRefreshTime null, get from Shar");
      g = PushPreferences.getLong(paramContext.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0L);
    }
    Logger.i("GuidInfoManagerImpl", "Get mqttServerLastRefreshTime: " + g);
    return g;
  }
  
  public static boolean m(Context paramContext)
  {
    Logger.d("GuidInfoManagerImpl", "Check MqttServer expired?");
    long l = l(paramContext);
    l = (System.currentTimeMillis() - l) / 1000L;
    Logger.i("GuidInfoManagerImpl", "MqttServerAddr gapSeconds = " + l + ", " + 1800L);
    return l > 1800L;
  }
  
  public static void n(Context paramContext)
  {
    TBaseLogger.ii("GuidInfoManagerImpl", "Force expired guidInfo, let its refreshTime 0");
    PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", 0L);
  }
  
  public static void o(Context paramContext)
  {
    b(paramContext, "", "");
    PushPreferences.putString(paramContext, "XG_GUID_TOKEN", "");
    PushPreferences.putString(paramContext, "XG_GUID_TOKEN_LIST", null);
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_SERVER", "");
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_USERNAME", "");
    PushPreferences.putString(paramContext, "XG_GUID_MQTT_PASSWORD", "");
    PushPreferences.putLong(paramContext, "XG_GUID_EXPIRED_SECONDS", 172800L);
    PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", 0L);
    PushPreferences.putLong(paramContext, "XG_GUID_SERVER_PENALTY_TIME", 0L);
    PushPreferences.putLong(paramContext, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L);
    CloudManager.getInstance(paramContext).reset();
  }
  
  public static boolean p(Context paramContext)
  {
    boolean bool = true;
    if (!h)
    {
      h = true;
      if (t(paramContext))
      {
        PushPreferences.putLong(paramContext, "XG_GUID_SERVER_PENALTY_TIME", 0L);
        return false;
      }
    }
    if (PushPreferences.getLong(paramContext, "XG_GUID_SERVER_PENALTY_TIME", 0L) > System.currentTimeMillis()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int q(Context paramContext)
  {
    if (PushPreferences.getLong(paramContext, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L) <= System.currentTimeMillis())
    {
      PushPreferences.putLong(paramContext, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L);
      return 0;
    }
    return PushPreferences.getInt(paramContext.getApplicationContext(), "XG_GUID_SERVER_ABANDON_RATE", 0);
  }
  
  public static int r(Context paramContext)
  {
    return PushPreferences.getInt(paramContext.getApplicationContext(), "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
  }
  
  private static Pair<String, String> s(Context paramContext)
  {
    Object localObject1 = paramContext.getSharedPreferences("tpush.vip.service.shareprefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(a("XG_GUID_TOKEN"), null);
    String str = ((SharedPreferences)localObject1).getString(a("XG_GUID_TOKEN_LIST"), null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramContext);
    }
    localObject2 = str;
    if (str == null) {
      localObject2 = b(paramContext);
    }
    return new Pair(localObject1, localObject2);
  }
  
  private static boolean t(Context paramContext)
  {
    long l1 = PushPreferences.getLong(paramContext, "XG_GUID_LAST_APP_VERSION_CODE", 0L);
    long l2 = Util.getCurVersionCode(paramContext);
    if (l1 != l2)
    {
      PushPreferences.putLong(paramContext, "XG_GUID_LAST_APP_VERSION_CODE", l2);
      if (l2 > l1)
      {
        Logger.i("GuidInfoManagerImpl", "App is Update");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a.a
 * JD-Core Version:    0.7.0.1
 */