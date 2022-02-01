package com.tencent.android.tpush.stat;

import android.app.Service;
import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.a.a;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  static a a;
  static a b;
  static String c = "__HIBERNATE__";
  private static c d = ;
  private static StatReportStrategy e;
  private static boolean f;
  private static boolean g;
  private static boolean h = false;
  private static short i = 6;
  private static int j = 1024;
  private static int k = 30000;
  private static int l = 0;
  private static int m = 20;
  
  static
  {
    a = new a(2);
    b = new a(1);
    e = StatReportStrategy.APP_LAUNCH;
    f = true;
    g = true;
  }
  
  public static StatReportStrategy a()
  {
    return e;
  }
  
  static void a(long paramLong)
  {
    com.tencent.android.tpush.stat.b.d.b(f.a(), c, paramLong);
    b(false);
    d.c("MTA is disable for current SDK version");
  }
  
  static void a(Context paramContext, a parama)
  {
    if (parama.a == b.a)
    {
      b = parama;
      a(b.b);
    }
    while (parama.a != a.a) {
      return;
    }
    a = parama;
  }
  
  static void a(Context paramContext, a parama, JSONObject paramJSONObject)
  {
    int n = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.equalsIgnoreCase("v"))
          {
            int i1 = paramJSONObject.getInt(str);
            if (parama.d != i1)
            {
              n = 1;
              parama.d = i1;
              break;
            }
          }
          else
          {
            if (str.equalsIgnoreCase("c"))
            {
              str = paramJSONObject.getString("c");
              if (str.length() <= 0) {
                break label194;
              }
              parama.b = new JSONObject(str);
              break label194;
            }
            if (!str.equalsIgnoreCase("m")) {
              break label197;
            }
            parama.c = paramJSONObject.getString("m");
            break label197;
          }
        }
        else
        {
          if ((n != 0) && (parama.a == b.a))
          {
            a(parama.b);
            b(parama.b);
          }
          a(paramContext, parama);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        d.b(paramContext);
        return;
      }
      catch (Throwable paramContext)
      {
        d.b(paramContext);
        return;
      }
    }
    label194:
    label197:
    for (;;)
    {
      break;
    }
  }
  
  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (((String)localObject).equalsIgnoreCase(Integer.toString(b.a)))
          {
            localObject = paramJSONObject.getJSONObject((String)localObject);
            a(paramContext, b, (JSONObject)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramContext)
      {
        d.b(paramContext);
      }
      if (((String)localObject).equalsIgnoreCase(Integer.toString(a.a)))
      {
        localObject = paramJSONObject.getJSONObject((String)localObject);
        a(paramContext, a, (JSONObject)localObject);
      }
    }
  }
  
  public static void a(StatReportStrategy paramStatReportStrategy)
  {
    e = paramStatReportStrategy;
    if (b()) {
      d.h("Change to statSendStrategy: " + paramStatReportStrategy);
    }
  }
  
  static void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = StatReportStrategy.getStatReportStrategy(paramJSONObject.getInt("rs"));
      if (paramJSONObject != null) {
        a(paramJSONObject);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!b()) {}
      d.b("rs not found.");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    f = paramBoolean;
    b.b().a(paramBoolean);
  }
  
  static void b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.getString(c);
        if (b()) {
          d.h("hibernateVer:" + paramJSONObject + ", current version:" + "2.0.6");
        }
        long l1 = b.b(paramJSONObject);
        if (b.b("2.0.6") <= l1)
        {
          a(l1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        d.h("__HIBERNATE__ not found.");
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    g = paramBoolean;
    if (!paramBoolean) {
      d.c("!!!!!!MTA StatService has been disabled!!!!!!");
    }
  }
  
  public static boolean b()
  {
    return f;
  }
  
  public static void c(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public static boolean c()
  {
    boolean bool = true;
    Context localContext2 = XGPushManager.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null)
    {
      if (XGVipPushService.a() == null) {
        return false;
      }
      localContext1 = XGVipPushService.a().getApplicationContext();
    }
    if (localContext1 != null)
    {
      if ((g) && (a.a(localContext1.getApplicationContext()).B == 1)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return g;
  }
  
  public static boolean d()
  {
    return h;
  }
  
  public static short e()
  {
    return i;
  }
  
  public static int f()
  {
    return j;
  }
  
  static class a
  {
    int a;
    JSONObject b = new JSONObject();
    String c = "";
    int d = 0;
    
    a(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.d
 * JD-Core Version:    0.7.0.1
 */