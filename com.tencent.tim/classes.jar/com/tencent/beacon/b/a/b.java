package com.tencent.beacon.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.beacon.a.c.c;
import java.nio.charset.Charset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class b
{
  private static b a;
  private static byte[] b = { 33, 94, 120, 74, 111, 43, 35 };
  private SharedPreferences c;
  private SharedPreferences.Editor d;
  private Lock e = new ReentrantLock();
  private Runnable f = new a(this);
  
  public b()
  {
    Context localContext = c.d().c();
    if (localContext != null) {
      this.c = localContext.getSharedPreferences("DENGTA_META", 0);
    }
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    int i = 0;
    paramString = Base64.decode(paramString, 2);
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return new String(paramString, Charset.defaultCharset());
  }
  
  private static String b(String paramString)
  {
    int i = 0;
    paramString = paramString.getBytes(Charset.defaultCharset());
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return Base64.encodeToString(paramString, 2);
  }
  
  private void b()
  {
    try
    {
      if (this.e.tryLock())
      {
        this.d.commit();
        this.e.unlock();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.c.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public String a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/beacon/b/a/b:c	Landroid/content/SharedPreferences;
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: ldc 112
    //   13: invokeinterface 109 3 0
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +67 -> 89
    //   25: aload 4
    //   27: invokevirtual 116	java/lang/String:trim	()Ljava/lang/String;
    //   30: ldc 112
    //   32: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +54 -> 89
    //   38: aload 4
    //   40: invokestatic 122	com/tencent/beacon/b/a/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_3
    //   44: aload 5
    //   46: invokeinterface 126 1 0
    //   51: astore 5
    //   53: aload 5
    //   55: invokestatic 131	com/tencent/beacon/base/util/b:a	(Landroid/content/SharedPreferences$Editor;)Z
    //   58: ifeq +24 -> 82
    //   61: aload 5
    //   63: aload_1
    //   64: invokeinterface 135 2 0
    //   69: aload_2
    //   70: aload_3
    //   71: invokeinterface 139 3 0
    //   76: invokeinterface 100 1 0
    //   81: pop
    //   82: aload 4
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: areturn
    //   89: aload 5
    //   91: aload_2
    //   92: ldc 112
    //   94: invokeinterface 109 3 0
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: aload_2
    //   103: ifnull -18 -> 85
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: invokevirtual 116	java/lang/String:trim	()Ljava/lang/String;
    //   112: ldc 112
    //   114: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne -32 -> 85
    //   120: aload_2
    //   121: invokestatic 141	com/tencent/beacon/b/a/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore_1
    //   125: goto -40 -> 85
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	b
    //   0	133	1	paramString1	String
    //   0	133	2	paramString2	String
    //   0	133	3	paramString3	String
    //   18	65	4	str	String
    //   6	84	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	128	finally
    //   25	82	128	finally
    //   89	100	128	finally
    //   108	125	128	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.b.a.b
 * JD-Core Version:    0.7.0.1
 */