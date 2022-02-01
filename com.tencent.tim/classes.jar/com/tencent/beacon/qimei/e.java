package com.tencent.beacon.qimei;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.util.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static com.tencent.beacon.a.d.g a;
  
  static String a(Context paramContext)
  {
    paramContext = b(paramContext);
    Object localObject;
    if (paramContext != null)
    {
      localObject = (String)paramContext.a("Q_V3", "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    com.tencent.beacon.b.a.b localb = com.tencent.beacon.b.a.b.a();
    if (com.tencent.beacon.a.c.g.a() != 1) {}
    for (paramContext = localb.a("BEACON_QIMEI_1", "");; paramContext = localb.a("QIMEI_DENGTA", "qimei_v2", ""))
    {
      localObject = paramContext;
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
      return localb.a("QIMEI_DENGTA", "");
    }
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap(3);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
        }
      }
      return localHashMap;
    }
    catch (JSONException localJSONException)
    {
      c.a("[qimei] jsonToMap error: " + localJSONException.getMessage(), new Object[0]);
      localHashMap.put("A3", paramString);
    }
    return localHashMap;
  }
  
  public static void a(long paramLong)
  {
    a.a locala = a.a().edit();
    if (com.tencent.beacon.base.util.b.a(locala)) {
      locala.putLong("q_i_t", paramLong);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramContext).b("Q_V3", paramString);
  }
  
  public static boolean a()
  {
    return "n".equalsIgnoreCase(com.tencent.beacon.e.g.b().a("enableQimei"));
  }
  
  /* Error */
  private static com.tencent.beacon.a.d.g b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 160	com/tencent/beacon/qimei/e:a	Lcom/tencent/beacon/a/d/g;
    //   6: ifnonnull +12 -> 18
    //   9: aload_0
    //   10: ldc 13
    //   12: invokestatic 163	com/tencent/beacon/a/d/g:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/beacon/a/d/g;
    //   15: putstatic 160	com/tencent/beacon/qimei/e:a	Lcom/tencent/beacon/a/d/g;
    //   18: getstatic 160	com/tencent/beacon/qimei/e:a	Lcom/tencent/beacon/a/d/g;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: new 89	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   35: ldc 165
    //   37: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   44: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 110	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: invokestatic 171	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   60: ldc 173
    //   62: ldc 175
    //   64: aload_0
    //   65: invokevirtual 178	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: goto -50 -> 18
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   9	18	27	java/lang/Exception
    //   3	9	71	finally
    //   9	18	71	finally
    //   18	22	71	finally
    //   28	68	71	finally
  }
  
  public static boolean b()
  {
    long l = a.a().getLong("q_i_t", 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l >= 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      c.a("[qimei] lastUpdateQimei time: " + l + ", isOver24h: " + bool, new Object[0]);
      return bool;
    }
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    String str = com.tencent.beacon.e.g.b().a("qimeiZeroPeak");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if ("y".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (Calendar.getInstance().get(11) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void d()
  {
    com.tencent.beacon.a.d.g localg = a;
    if (localg != null) {
      localg.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.qimei.e
 * JD-Core Version:    0.7.0.1
 */