package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.d;
import com.huawei.hms.framework.network.grs.b.h;
import com.huawei.hms.framework.network.grs.c.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static final String a = a.class.getSimpleName();
  private Map<String, Map<String, Map<String, String>>> b = new ConcurrentHashMap(16);
  private Map<String, Long> c = new ConcurrentHashMap(16);
  private c d;
  private h e;
  
  public a(c paramc, h paramh)
  {
    this.d = paramc;
    this.e = paramh;
    this.e.a(this);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, b paramb, Context paramContext, String paramString)
  {
    Object localObject = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    localObject = (Long)this.c.get(localObject);
    if (e.a((Long)localObject))
    {
      paramb.a(2);
      return;
    }
    if (e.a((Long)localObject, 300000L)) {
      this.e.a(paramGrsBaseInfo, paramContext, null, paramString);
    }
    paramb.a(1);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, String paramString, Context paramContext)
  {
    if (e.a((Long)this.c.get(paramString), 300000L)) {
      this.e.a(paramGrsBaseInfo, paramContext, null, null);
    }
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2, b paramb, Context paramContext)
  {
    paramGrsBaseInfo = a(paramGrsBaseInfo, paramString1, paramb, paramContext);
    if (paramGrsBaseInfo == null) {
      return null;
    }
    return (String)paramGrsBaseInfo.get(paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString, b paramb, Context paramContext)
  {
    Object localObject = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    localObject = (Map)this.b.get(localObject);
    if ((localObject == null) || (((Map)localObject).isEmpty())) {
      return new HashMap();
    }
    a(paramGrsBaseInfo, paramb, paramContext, paramString);
    return (Map)((Map)localObject).get(paramString);
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    long l2 = 0L;
    String str1 = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    String str2 = this.d.a(str1, "");
    String str3 = this.d.a(str1 + "time", "0");
    long l1 = l2;
    if (!TextUtils.isEmpty(str3))
    {
      l1 = l2;
      if (!str3.matches("\\d+")) {}
    }
    try
    {
      l1 = Long.parseLong(str3);
      this.b.put(str1, com.huawei.hms.framework.network.grs.a.a(str2));
      this.c.put(str1, Long.valueOf(l1));
      a(paramGrsBaseInfo, str1, paramContext);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Logger.w(a, "convert urlParamKey from String to Long catch NumberFormatException.", localNumberFormatException);
        l1 = l2;
      }
    }
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, d paramd, Context paramContext)
  {
    if (paramd.f() == 2)
    {
      Logger.w(a, "update cache from server failed");
      return;
    }
    paramGrsBaseInfo = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    this.d.b(paramGrsBaseInfo, paramd.c());
    this.d.b(paramGrsBaseInfo + "time", paramd.d());
    this.b.put(paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a(paramd.c()));
    this.c.put(paramGrsBaseInfo, Long.valueOf(Long.parseLong(paramd.d())));
  }
  
  public void b(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    paramGrsBaseInfo = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    this.d.b(paramGrsBaseInfo + "time", "0");
    this.c.remove(paramGrsBaseInfo + "time");
    this.b.remove(paramGrsBaseInfo);
    this.e.a(paramGrsBaseInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.a
 * JD-Core Version:    0.7.0.1
 */