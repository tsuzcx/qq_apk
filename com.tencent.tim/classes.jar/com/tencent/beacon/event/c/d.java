package com.tencent.beacon.event.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.JceRequestEntity.a;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.pack.EventRecordV2;
import com.tencent.beacon.pack.RequestPackageV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  public static int a(EventType paramEventType)
  {
    switch (c.a[paramEventType.ordinal()])
    {
    default: 
      return 0;
    case 6: 
      return 3;
    case 5: 
      return 2;
    }
    return 1;
  }
  
  public static JceRequestEntity a(List<EventBean> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      paramList = a(paramList);
      String str = com.tencent.beacon.a.c.c.d().f();
      return JceRequestEntity.builder().a(RequestType.EVENT).a(i).b(com.tencent.beacon.base.net.b.b.a(false)).a(com.tencent.beacon.base.net.b.b.a(true), 8081).a(str).a("version", "v2").a(paramList).a();
    }
  }
  
  public static RequestPackageV2 a(EventBean paramEventBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEventBean);
    return a(localArrayList);
  }
  
  public static RequestPackageV2 a(List<EventBean> paramList)
  {
    RequestPackageV2 localRequestPackageV2 = new RequestPackageV2();
    localRequestPackageV2.appVersion = com.tencent.beacon.a.c.b.a();
    localRequestPackageV2.common = a();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EventRecordV2 localEventRecordV2 = b((EventBean)paramList.next());
      if (localEventRecordV2 != null) {
        localArrayList.add(localEventRecordV2);
      }
    }
    localRequestPackageV2.events = localArrayList;
    paramList = com.tencent.beacon.a.c.c.d();
    localRequestPackageV2.mainAppKey = paramList.f();
    localRequestPackageV2.model = f.e().h();
    localRequestPackageV2.osVersion = com.tencent.beacon.a.c.e.l().s();
    localRequestPackageV2.packageName = com.tencent.beacon.a.c.b.b();
    localRequestPackageV2.platformId = paramList.g();
    localRequestPackageV2.sdkId = paramList.h();
    localRequestPackageV2.sdkVersion = paramList.i();
    localRequestPackageV2.reserved = "";
    return localRequestPackageV2;
  }
  
  public static String a(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label23;
      }
      str1 = str2;
    }
    label23:
    do
    {
      return str1;
      if (!f(paramString.trim())) {
        break;
      }
      paramString = paramString.trim();
      str1 = paramString;
    } while (paramString.length() <= 16);
    return paramString.substring(0, 16);
    com.tencent.beacon.base.util.c.e("[core] channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  private static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    com.tencent.beacon.a.c.e locale = com.tencent.beacon.a.c.e.l();
    Object localObject = com.tencent.beacon.a.c.c.d();
    f localf = f.e();
    localHashMap.put("A31", "" + locale.p());
    localHashMap.put("A67", com.tencent.beacon.a.c.b.c(((com.tencent.beacon.a.c.c)localObject).c()));
    localHashMap.put("A76", com.tencent.beacon.a.c.b.d());
    localHashMap.put("A89", locale.a(((com.tencent.beacon.a.c.c)localObject).c()));
    localHashMap.put("A52", String.valueOf(locale.y()));
    if (locale.m()) {}
    for (localObject = "Y";; localObject = "N")
    {
      localHashMap.put("A58", localObject);
      localHashMap.put("A12", locale.n());
      localHashMap.put("A17", locale.u());
      localHashMap.put("A10", localf.h());
      localHashMap.put("A2", "" + localf.b());
      localHashMap.put("A4", localf.d());
      localHashMap.put("A6", localf.f());
      localHashMap.put("A7", localf.a());
      localHashMap.put("A20", localf.j());
      localHashMap.put("A69", localf.k());
      localHashMap.put("A60", localf.j());
      localHashMap.put("A9", Build.BRAND);
      localHashMap.put("A158", locale.d());
      return localHashMap;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {}
      return true;
    }
    return false;
  }
  
  private static EventRecordV2 b(EventBean paramEventBean)
  {
    if (paramEventBean == null) {
      return null;
    }
    EventRecordV2 localEventRecordV2 = new EventRecordV2();
    localEventRecordV2.appKey = paramEventBean.getAppKey();
    if (paramEventBean.getApn() != null)
    {
      str = paramEventBean.getApn();
      localEventRecordV2.apn = str;
      if (paramEventBean.getSrcIp() == null) {
        break label128;
      }
    }
    label128:
    for (String str = paramEventBean.getSrcIp();; str = "")
    {
      localEventRecordV2.srcIp = str;
      localEventRecordV2.eventCode = paramEventBean.getEventCode();
      localEventRecordV2.valueType = paramEventBean.getValueType();
      localEventRecordV2.mapValue = paramEventBean.getEventValue();
      localEventRecordV2.byteValue = paramEventBean.getByteValue();
      localEventRecordV2.eventTime = paramEventBean.getEventTime();
      localEventRecordV2.eventResult = paramEventBean.getEventResult();
      localEventRecordV2.eventType = paramEventBean.getEventType();
      localEventRecordV2.reserved = paramEventBean.getReserved();
      return localEventRecordV2;
      str = "";
      break;
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (com.tencent.beacon.base.util.e.a.get())
      {
        com.tencent.beacon.a.b.d.b().a("101", "eventCode == null");
        com.tencent.beacon.base.util.e.a("eventCode == null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = paramString.replace('|', '_').trim();
      if (!f(str)) {
        break;
      }
      localObject = str;
    } while (str.length() <= 128);
    paramString = paramString + " length > 128.";
    com.tencent.beacon.a.b.d.b().a("101", paramString);
    com.tencent.beacon.base.util.e.a(paramString);
    return str.substring(0, 128);
    paramString = paramString + " is not ASCII";
    com.tencent.beacon.a.b.d.b().a("101", paramString);
    com.tencent.beacon.base.util.e.a(paramString);
    return "";
  }
  
  public static String c(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "DefaultPageID";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 50);
    return paramString.substring(0, 50);
  }
  
  public static String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "10000";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replace('|', '_').trim();
      if (!f(str)) {
        break;
      }
      if (str.length() < 5) {
        com.tencent.beacon.base.util.c.e("[core] userID length should < 5!", new Object[0]);
      }
      paramString = str;
    } while (str.length() <= 128);
    return str.substring(0, 128);
    com.tencent.beacon.base.util.c.e("[core] userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
  }
  
  public static BeaconModule e(String paramString)
    throws Exception
  {
    return (BeaconModule)Class.forName(paramString).newInstance();
  }
  
  private static boolean f(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c.d
 * JD-Core Version:    0.7.0.1
 */