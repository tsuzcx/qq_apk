package com.tencent.beacon.base.net.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.RequestPackage;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public final class d
{
  private static Map<String, String> a;
  
  public static RequestPackage a(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString)
  {
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    com.tencent.beacon.a.c.e locale = com.tencent.beacon.a.c.e.l();
    RequestPackage localRequestPackage = new RequestPackage();
    localRequestPackage.model = f.e().h();
    localRequestPackage.osVersion = locale.s();
    localRequestPackage.platformId = localc.g();
    localRequestPackage.appkey = paramString;
    localRequestPackage.appVersion = b.a();
    localRequestPackage.sdkId = localc.h();
    localRequestPackage.sdkVersion = localc.i();
    localRequestPackage.cmd = paramInt;
    localRequestPackage.encryType = 3;
    localRequestPackage.zipType = 2;
    localRequestPackage.sBuffer = paramArrayOfByte;
    localRequestPackage.reserved = b(paramMap);
    return localRequestPackage;
  }
  
  public static Map<String, String> a()
  {
    try
    {
      if (a == null)
      {
        a = new HashMap(4);
        a.put("wup_version", "3.0");
        a.put("TYPE_COMPRESS", String.valueOf(2));
        a.put("encr_type", "rsapost");
        a.put("Content-Type", "jce");
        localObject1 = g.b();
        if (localObject1 != null) {
          a.put("bea_key", ((g)localObject1).d());
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  @Nullable
  public static Map<String, String> a(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = (String)localEntry.getKey();
      int j = paramMap.trim().length();
      if ((j > 0) && (a(paramMap)))
      {
        Object localObject = paramMap.trim();
        paramMap = (Map<String, String>)localObject;
        if (j > 64)
        {
          paramMap = ((String)localObject).substring(0, 64);
          localObject = "[event] eventName: " + paramString + ", key: " + paramMap + " should be less than 64!";
          com.tencent.beacon.a.b.d.b().a("102", (String)localObject);
          com.tencent.beacon.base.util.e.a((String)localObject);
        }
        String str = paramMap.replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
        paramMap = (String)localEntry.getValue();
        if (paramMap == null) {}
        for (paramMap = "";; paramMap = paramMap.trim())
        {
          localObject = paramMap;
          if (paramMap.length() > 10240)
          {
            localObject = "[event] eventName: " + paramString + ", key: " + str + "'s value > 10K.";
            com.tencent.beacon.a.b.d.b().a("103", (String)localObject);
            com.tencent.beacon.base.util.e.a((String)localObject);
            localObject = paramMap.substring(0, 10240);
          }
          paramMap = ((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
          localHashMap.put(str, paramMap);
          j = str.length();
          i = paramMap.length() + j + i;
          break;
        }
      }
      com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", new Object[] { paramMap });
      com.tencent.beacon.a.b.d.b().a("102", "[event] eventName: " + paramString + ", key: " + paramMap + " should be ASCII code in 32-126!");
    }
    if (i > 46080)
    {
      paramString = "[event] eventName: " + paramString + " params > 45K";
      com.tencent.beacon.a.b.d.b().a("104", paramString);
      com.tencent.beacon.base.util.e.a(paramString);
      return null;
    }
    return localHashMap;
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString)
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "fixBeaconInfo, serverTime: " + paramLong2 + ",ip: " + paramString, new Object[0]);
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    localc.b(paramString);
    localc.a(paramLong2 - (new Date().getTime() + paramLong1) / 2L);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "update strategy sid: %s, max_time: %s", new Object[] { paramString1, paramString2 });
    g.b().a(paramString1, paramString2);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    int i = paramString.length();
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
  
  public static boolean a(Map<String, List<String>> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    if (paramMap.containsKey("encrypt-status"))
    {
      com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
      return false;
    }
    List localList;
    Object localObject;
    if ((paramMap.containsKey("session_id")) && (paramMap.containsKey("max_time")))
    {
      localList = (List)paramMap.get("session_id");
      localObject = (List)paramMap.get("max_time");
      if (localList == null) {
        break label133;
      }
    }
    label133:
    for (paramMap = (String)localList.get(0);; paramMap = null)
    {
      if (localObject != null) {}
      for (localObject = (String)((List)localObject).get(0);; localObject = null)
      {
        if ((paramMap != null) && (localObject != null)) {
          a(paramMap, (String)localObject);
        }
        return true;
      }
    }
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static NetworkInfo b()
  {
    Object localObject = com.tencent.beacon.a.c.c.d().c();
    try
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    return null;
  }
  
  public static String b(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return "";
      localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if ((str.trim().length() > 0) && (a(str)))
        {
          str = str.trim();
          localStringBuilder.append("&");
          localStringBuilder.append(str.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
          localStringBuilder.append("=");
          localObject = (String)((Map.Entry)localObject).getValue();
          if (localObject != null) {
            localStringBuilder.append(((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
          }
        }
        else
        {
          com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", new Object[] { str });
        }
      }
    } while (localStringBuilder.length() <= 0);
    return localStringBuilder.substring(1);
  }
  
  public static String c()
  {
    Object localObject = b();
    if (localObject == null) {
      return "unknown";
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return "wifi";
    }
    String str = ((NetworkInfo)localObject).getExtraInfo();
    localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 64) {
        localObject = str.substring(0, 64);
      }
    }
    return "" + (String)localObject;
  }
  
  public static void c(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.containsKey("encrypt-status")) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
      }
      if ((paramMap.containsKey("session_id")) && (paramMap.containsKey("max_time"))) {
        a((String)paramMap.get("session_id"), (String)paramMap.get("max_time"));
      }
    }
  }
  
  public static boolean d()
  {
    NetworkInfo localNetworkInfo = b();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.d
 * JD-Core Version:    0.7.0.1
 */