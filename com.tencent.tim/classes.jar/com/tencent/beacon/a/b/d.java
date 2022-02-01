package com.tencent.beacon.a.b;

import android.text.TextUtils;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import java.util.LinkedHashMap;
import java.util.Map;

public class d
{
  private static volatile d a;
  private static final Map<String, String> b = new LinkedHashMap();
  private boolean c = false;
  private boolean d = false;
  
  public static d b()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/beacon/a/b/d:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   17: ldc 34
    //   19: ldc 36
    //   21: invokeinterface 42 3 0
    //   26: pop
    //   27: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   30: ldc 44
    //   32: ldc 46
    //   34: invokeinterface 42 3 0
    //   39: pop
    //   40: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   43: ldc 48
    //   45: ldc 50
    //   47: invokeinterface 42 3 0
    //   52: pop
    //   53: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   56: ldc 52
    //   58: ldc 54
    //   60: invokeinterface 42 3 0
    //   65: pop
    //   66: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   69: ldc 56
    //   71: invokestatic 62	com/tencent/beacon/a/c/e:l	()Lcom/tencent/beacon/a/c/e;
    //   74: invokevirtual 65	com/tencent/beacon/a/c/e:d	()Ljava/lang/String;
    //   77: invokeinterface 42 3 0
    //   82: pop
    //   83: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   86: ldc 67
    //   88: new 69	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 76	android/os/Build:BOARD	Ljava/lang/String;
    //   98: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 82
    //   103: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokestatic 88	com/tencent/beacon/a/c/f:e	()Lcom/tencent/beacon/a/c/f;
    //   109: invokevirtual 91	com/tencent/beacon/a/c/f:h	()Ljava/lang/String;
    //   112: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokeinterface 42 3 0
    //   123: pop
    //   124: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   127: ldc 96
    //   129: invokestatic 62	com/tencent/beacon/a/c/e:l	()Lcom/tencent/beacon/a/c/e;
    //   132: invokevirtual 99	com/tencent/beacon/a/c/e:s	()Ljava/lang/String;
    //   135: invokeinterface 42 3 0
    //   140: pop
    //   141: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   144: ldc 101
    //   146: ldc 50
    //   148: invokeinterface 42 3 0
    //   153: pop
    //   154: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   157: ldc 103
    //   159: ldc 50
    //   161: invokeinterface 42 3 0
    //   166: pop
    //   167: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   170: ldc 105
    //   172: invokestatic 109	com/tencent/beacon/a/c/b:a	()Ljava/lang/String;
    //   175: invokeinterface 42 3 0
    //   180: pop
    //   181: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   184: ldc 111
    //   186: invokestatic 116	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   189: invokevirtual 119	com/tencent/beacon/a/c/c:i	()Ljava/lang/String;
    //   192: invokeinterface 42 3 0
    //   197: pop
    //   198: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   201: ldc 121
    //   203: invokestatic 116	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   206: invokevirtual 124	com/tencent/beacon/a/c/c:f	()Ljava/lang/String;
    //   209: invokeinterface 42 3 0
    //   214: pop
    //   215: getstatic 21	com/tencent/beacon/a/b/d:b	Ljava/util/Map;
    //   218: ldc 126
    //   220: ldc 50
    //   222: invokeinterface 42 3 0
    //   227: pop
    //   228: aload_0
    //   229: iconst_1
    //   230: putfield 25	com/tencent/beacon/a/b/d:c	Z
    //   233: goto -222 -> 11
    //   236: astore_2
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	d
    //   6	2	1	bool	boolean
    //   236	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	236	finally
    //   14	233	236	finally
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1, paramString2, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      a(paramString1, paramString2, paramThrowable, new b(this));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable, Callback<BResponse> paramCallback)
  {
    for (;;)
    {
      try
      {
        boolean bool = c();
        if (!bool) {
          return;
        }
        if (!this.c) {
          d();
        }
        if (TextUtils.isEmpty(paramString1)) {
          com.tencent.beacon.base.util.c.b("[atta] errorCode isn't valid value!", new Object[0]);
        } else {
          a.a().a(new c(this, paramString1, paramString2, paramThrowable, paramCallback));
        }
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.d) {}
    String str;
    do
    {
      return true;
      if (com.tencent.beacon.base.util.c.a()) {
        return false;
      }
      str = e.l().d();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
    } while (Math.abs(str.hashCode() % 10000) < 100.0D);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.d
 * JD-Core Version:    0.7.0.1
 */