package com.tencent.beacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.beacon.a.b.a;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.open.EventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class g
{
  private static final Map<String, g> a = new ConcurrentHashMap(5);
  private static volatile Handler b;
  private final String c = "normal_log_id";
  private final String d = "realtime_log_id";
  private final String e = "immediate_log_id";
  private final String f = "on_date";
  private final Context g;
  private final String h;
  private final List<String> i = new ArrayList();
  private String j;
  private AtomicLong k = new AtomicLong(0L);
  private AtomicLong l = new AtomicLong(0L);
  private AtomicLong m = new AtomicLong(0L);
  private SharedPreferences n;
  private final Runnable o = new e(this);
  private boolean p = false;
  
  private g(Context paramContext, String paramString)
  {
    this.g = paramContext;
    this.h = paramString;
  }
  
  private SharedPreferences a(Context paramContext)
  {
    if (this.n == null) {
      this.n = paramContext.getSharedPreferences("b_log_ID_" + b.c(paramContext) + "_" + this.h, 0);
    }
    return this.n;
  }
  
  public static g a(Context paramContext, @NonNull String paramString)
  {
    try
    {
      g localg2 = (g)a.get(paramString);
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramContext, paramString);
        a.put(paramString, localg1);
      }
      return localg1;
    }
    finally {}
  }
  
  private String a(EventType paramEventType)
  {
    switch (f.a[paramEventType.ordinal()])
    {
    default: 
      return "";
    case 5: 
    case 6: 
      return String.valueOf(this.m.incrementAndGet());
    case 3: 
    case 4: 
      return String.valueOf(this.l.incrementAndGet());
    }
    return String.valueOf(this.k.incrementAndGet());
  }
  
  private void b()
  {
    try
    {
      if (b == null) {
        b = a.a().a(113);
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = a(this.g);
    this.j = localSharedPreferences.getString("on_date", "");
    this.l.set(localSharedPreferences.getLong("realtime_log_id", 0L));
    this.k.set(localSharedPreferences.getLong("normal_log_id", 0L));
    this.m.set(localSharedPreferences.getLong("immediate_log_id", 0L));
    c.a("[LogID " + this.h + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d, immediate: %d", new Object[] { this.j, Long.valueOf(this.l.get()), Long.valueOf(this.k.get()), Long.valueOf(this.m.get()) });
  }
  
  /* Error */
  public String a(String paramString, EventType paramEventType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/beacon/event/c/g:p	Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: invokevirtual 210	com/tencent/beacon/event/c/g:a	()V
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 86	com/tencent/beacon/event/c/g:p	Z
    //   18: aload_0
    //   19: getfield 66	com/tencent/beacon/event/c/g:i	Ljava/util/List;
    //   22: aload_1
    //   23: invokeinterface 216 2 0
    //   28: ifeq +10 -> 38
    //   31: ldc 151
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: aload_0
    //   39: aload_2
    //   40: invokespecial 218	com/tencent/beacon/event/c/g:a	(Lcom/tencent/beacon/event/open/EventType;)Ljava/lang/String;
    //   43: astore_3
    //   44: new 95	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   51: ldc 220
    //   53: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 90	com/tencent/beacon/event/c/g:h	Ljava/lang/String;
    //   60: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 191
    //   65: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: ldc 222
    //   73: iconst_3
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_2
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_1
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: aload_3
    //   88: aastore
    //   89: invokestatic 205	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: getstatic 164	com/tencent/beacon/event/c/g:b	Landroid/os/Handler;
    //   95: aload_0
    //   96: getfield 84	com/tencent/beacon/event/c/g:o	Ljava/lang/Runnable;
    //   99: invokevirtual 228	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   102: pop
    //   103: aload_3
    //   104: astore_1
    //   105: goto -71 -> 34
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	g
    //   0	113	1	paramString	String
    //   0	113	2	paramEventType	EventType
    //   43	61	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	18	108	finally
    //   18	31	108	finally
    //   38	103	108	finally
  }
  
  public void a()
  {
    b();
    this.i.add("rqd_model");
    this.i.add("rqd_appresumed");
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c.g
 * JD-Core Version:    0.7.0.1
 */