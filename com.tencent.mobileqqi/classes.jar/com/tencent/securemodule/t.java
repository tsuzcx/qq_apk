package com.tencent.securemodule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.tencent.securemodule.jni.SecureEngine;
import com.tencent.securemodule.ui.TransparentActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class t
{
  private static t e = null;
  private Context a;
  private SecureEngine b;
  private List<e> c;
  private boolean d = false;
  
  private t(Context paramContext)
  {
    this.b = new SecureEngine(paramContext);
    this.a = paramContext;
  }
  
  public static t a(Context paramContext)
  {
    if (e == null) {
      e = new t(paramContext);
    }
    return e;
  }
  
  /* Error */
  private void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 42	com/tencent/securemodule/e:c	()Ljava/util/ArrayList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_3
    //   15: invokeinterface 48 1 0
    //   20: astore_3
    //   21: aload_3
    //   22: invokeinterface 54 1 0
    //   27: ifeq -16 -> 11
    //   30: aload_0
    //   31: aload_1
    //   32: aload_3
    //   33: invokeinterface 58 1 0
    //   38: checkcast 60	com/tencent/securemodule/c
    //   41: invokevirtual 63	com/tencent/securemodule/t:a	(Lcom/tencent/securemodule/e;Lcom/tencent/securemodule/c;)I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne -35 -> 11
    //   49: goto -28 -> 21
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	t
    //   0	57	1	parame	e
    //   44	2	2	i	int
    //   6	27	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	52	finally
    //   14	21	52	finally
    //   21	45	52	finally
  }
  
  private void c()
  {
    Object localObject3;
    try
    {
      Object localObject1 = new ArrayList();
      localObject3 = this.c.iterator();
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext())
        {
          if (((List)localObject1).size() > 0)
          {
            localObject1 = ((List)localObject1).iterator();
            boolean bool = ((Iterator)localObject1).hasNext();
            if (bool) {
              break;
            }
          }
          return;
        }
        localObject4 = (e)((Iterator)localObject3).next();
        if ((localObject4 != null) && (((e)localObject4).a().a() == 1)) {
          ((List)localObject1).add(localObject4);
        }
      }
      localObject3 = (e)localObject2.next();
    }
    finally {}
    Object localObject4 = ((e)localObject3).a();
    if ((((e)localObject3).a().b() != 0) && (System.currentTimeMillis() / 1000L >= ((o)localObject4).b())) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject4 = ((e)localObject3).b();
        if (localObject4 != null) {
          switch (((p)localObject4).c())
          {
          }
        }
      }
      for (;;)
      {
        this.c.remove(localObject3);
        break;
        this.d = true;
        localObject4 = new Intent();
        ((Intent)localObject4).setClass(this.a, TransparentActivity.class);
        ((Intent)localObject4).addFlags(268435456);
        ((Intent)localObject4).setAction("1000040");
        ((Intent)localObject4).putExtra("data", (Serializable)localObject3);
        this.a.startActivity((Intent)localObject4);
        continue;
        a((e)localObject3);
      }
    }
  }
  
  public final int a(e parame, c paramc)
  {
    boolean bool = false;
    int j = 0;
    Object localObject = new UniAttribute();
    ((UniAttribute)localObject).setEncodeName("UTF-8");
    ((UniAttribute)localObject).decode(paramc.b());
    int i;
    switch (paramc.a())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (j == 0) {
        i = this.b.a(paramc.a(), paramc.b());
      }
      return i;
      localObject = new UniAttribute();
      ((UniAttribute)localObject).decode(paramc.b());
      localObject = (n)((UniAttribute)localObject).getByClass("cloudcmd", new n());
      if (localObject == null) {
        break;
      }
      if (parame.a().a() == 1) {
        bool = true;
      }
      i = ad.a(this.a, ((n)localObject).a(), bool);
      j = 1;
    }
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final int b()
  {
    Object localObject2 = this.a;
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(new b(4, SecureEngine.b((Context)localObject2) + "&productid=" + ((Context)localObject2).getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30003) }), 0), ""));
    ((List)localObject1).add(new b(8, "buildno=" + ((Context)localObject2).getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30004) }), 0) + "&version=" + ((Context)localObject2).getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(30001) }), "") + "&productid=" + ((Context)localObject2).getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30003) }), 0), ""));
    localObject2 = new AtomicReference();
    Object localObject3 = this.a;
    if (ac.a == null) {
      ac.a = new ac((Context)localObject3);
    }
    localObject3 = ac.a;
    UniPacket localUniPacket1 = new UniPacket(true);
    UniPacket localUniPacket2 = new UniPacket(true);
    int i = ((ac)localObject3).a(1, localUniPacket1, localUniPacket2);
    if (i != 0) {}
    while (i != 0)
    {
      return i;
      localUniPacket1.put("phonetype", ((ac)localObject3).b.a());
      localUniPacket1.put("userinfo", ((ac)localObject3).b.b());
      localUniPacket1.put("vecclient", localObject1);
      int j = ((ac)localObject3).a(localUniPacket1, localUniPacket2);
      i = j;
      if (j == 0)
      {
        localObject1 = (m)localUniPacket2.getByClass("cmdinfo", new m());
        if (localObject1 != null) {
          ((AtomicReference)localObject2).set(localObject1);
        }
        i = 0;
      }
    }
    localObject1 = (m)((AtomicReference)localObject2).get();
    if (localObject1 != null)
    {
      this.c = ((m)localObject1).a();
      c();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.t
 * JD-Core Version:    0.7.0.1
 */