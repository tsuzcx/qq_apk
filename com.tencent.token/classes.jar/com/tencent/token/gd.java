package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gd
{
  private static final byte[] a = { 42 };
  private static final String[] b = new String[0];
  private static final String[] c = { "*" };
  private static final gd d = new gd();
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final CountDownLatch f = new CountDownLatch(1);
  private byte[] g;
  private byte[] h;
  
  public static gd a()
  {
    return d;
  }
  
  private static String a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int j = 0;
    int i = paramArrayOfByte.length;
    if (j < i)
    {
      int k = (j + i) / 2;
      while ((k > -1) && (paramArrayOfByte[k] != 10)) {
        k -= 1;
      }
      int i5 = k + 1;
      int i2 = 1;
      while (paramArrayOfByte[(i5 + i2)] != 10) {
        i2 += 1;
      }
      int i6 = i5 + i2 - i5;
      int m = 0;
      k = 0;
      int n = 0;
      int i3 = paramInt;
      label96:
      int i1;
      label108:
      int i7;
      if (n != 0)
      {
        i1 = 46;
        n = 0;
        i7 = i1 - (paramArrayOfByte[(i5 + k)] & 0xFF);
        if (i7 == 0) {
          break label158;
        }
        label129:
        if (i7 >= 0) {
          break label233;
        }
        i = i5 - 1;
      }
      for (;;)
      {
        break;
        i1 = paramArrayOfByte1[i3][m] & 0xFF;
        break label108;
        label158:
        k += 1;
        m += 1;
        if (k == i6) {
          break label129;
        }
        i1 = m;
        int i4 = i3;
        if (paramArrayOfByte1[i3].length == m)
        {
          if (i3 == paramArrayOfByte1.length - 1) {
            break label129;
          }
          i4 = i3 + 1;
          i1 = -1;
          n = 1;
        }
        m = i1;
        i3 = i4;
        break label96;
        label233:
        if (i7 > 0)
        {
          j = i2 + i5 + 1;
        }
        else
        {
          n = i6 - k;
          m = paramArrayOfByte1[i3].length - m;
          k = i3 + 1;
          while (k < paramArrayOfByte1.length)
          {
            m += paramArrayOfByte1[k].length;
            k += 1;
          }
          if (m < n)
          {
            i = i5 - 1;
          }
          else
          {
            if (m <= n) {
              break label333;
            }
            j = i2 + i5 + 1;
          }
        }
      }
      label333:
      return new String(paramArrayOfByte, i5, i6, fc.e);
    }
    return null;
  }
  
  private String[] a(String[] paramArrayOfString)
  {
    Object localObject3 = null;
    int j = 0;
    if ((!this.e.get()) && (this.e.compareAndSet(false, true))) {
      b();
    }
    for (;;)
    {
      try
      {
        if (this.g != null) {
          break;
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
      }
      finally {}
      try
      {
        this.f.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
    byte[][] arrayOfByte = new byte[paramArrayOfString.length][];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfByte[i] = paramArrayOfString[i].getBytes(fc.e);
      i += 1;
    }
    i = 0;
    if (i < arrayOfByte.length)
    {
      paramArrayOfString = a(this.g, arrayOfByte, i);
      if (paramArrayOfString == null) {}
    }
    for (;;)
    {
      Object localObject2;
      label156:
      Object localObject1;
      if (arrayOfByte.length > 1)
      {
        localObject2 = (byte[][])arrayOfByte.clone();
        i = 0;
        if (i < localObject2.length - 1)
        {
          localObject2[i] = a;
          localObject1 = a(this.g, (byte[][])localObject2, i);
          if (localObject1 == null) {}
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (localObject1 != null) {
          i = j;
        }
        for (;;)
        {
          localObject2 = localObject3;
          if (i < arrayOfByte.length - 1)
          {
            localObject2 = a(this.h, arrayOfByte, i);
            if (localObject2 == null) {}
          }
          else
          {
            if (localObject2 == null) {
              break label286;
            }
            localObject1 = ("!" + (String)localObject2).split("\\.");
            return localObject1;
            i += 1;
            break;
            i += 1;
            break label156;
          }
          i += 1;
        }
        label286:
        if ((paramArrayOfString == null) && (localObject1 == null)) {
          return c;
        }
        if (paramArrayOfString != null)
        {
          localObject2 = paramArrayOfString.split("\\.");
          label311:
          if (localObject1 == null) {
            break label346;
          }
        }
        label346:
        for (paramArrayOfString = ((String)localObject1).split("\\.");; paramArrayOfString = b)
        {
          localObject1 = paramArrayOfString;
          if (localObject2.length <= paramArrayOfString.length) {
            break;
          }
          return localObject2;
          localObject2 = b;
          break label311;
        }
        localObject1 = null;
      }
      paramArrayOfString = null;
    }
  }
  
  private void b()
  {
    int i = 0;
    try
    {
      c();
      return;
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      for (;;)
      {
        i = 1;
      }
    }
    catch (IOException localIOException)
    {
      gc.c().a(5, "Failed to read public suffix list", localIOException);
      return;
    }
    finally
    {
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: ldc 146
    //   4: invokevirtual 152	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 154	okio/i
    //   16: dup
    //   17: aload_1
    //   18: invokestatic 159	okio/k:a	(Ljava/io/InputStream;)Lokio/q;
    //   21: invokespecial 162	okio/i:<init>	(Lokio/q;)V
    //   24: invokestatic 165	okio/k:a	(Lokio/q;)Lokio/e;
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 171 1 0
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface 174 2 0
    //   44: aload_1
    //   45: invokeinterface 171 1 0
    //   50: newarray byte
    //   52: astore_3
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 174 2 0
    //   60: aload_1
    //   61: invokestatic 177	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: aload_2
    //   68: putfield 75	com/tencent/token/gd:g	[B
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 109	com/tencent/token/gd:h	[B
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 50	com/tencent/token/gd:f	Ljava/util/concurrent/CountDownLatch;
    //   82: invokevirtual 180	java/util/concurrent/CountDownLatch:countDown	()V
    //   85: return
    //   86: astore_2
    //   87: aload_1
    //   88: invokestatic 177	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	gd
    //   7	81	1	localObject1	Object
    //   93	4	1	localObject2	Object
    //   36	32	2	arrayOfByte1	byte[]
    //   86	6	2	localObject3	Object
    //   52	21	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	60	86	finally
    //   66	78	93	finally
    //   94	96	93	finally
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("domain == null");
    }
    Object localObject = IDN.toUnicode(paramString).split("\\.");
    String[] arrayOfString = a((String[])localObject);
    if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!')) {
      return null;
    }
    if (arrayOfString[0].charAt(0) == '!') {}
    for (int i = localObject.length - arrayOfString.length;; i = localObject.length - (arrayOfString.length + 1))
    {
      localObject = new StringBuilder();
      paramString = paramString.split("\\.");
      while (i < paramString.length)
      {
        ((StringBuilder)localObject).append(paramString[i]).append('.');
        i += 1;
      }
    }
    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gd
 * JD-Core Version:    0.7.0.1
 */