package okhttp3.internal.publicsuffix;

import com.tencent.token.fc;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase
{
  private static final byte[] a = { 42 };
  private static final String[] b = new String[0];
  private static final String[] c = { "*" };
  private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final CountDownLatch f = new CountDownLatch(1);
  private byte[] g;
  private byte[] h;
  
  private static String a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int j = paramArrayOfByte.length;
    int k = 0;
    if (k < j)
    {
      int i = (k + j) / 2;
      while ((i > -1) && (paramArrayOfByte[i] != 10)) {
        i -= 1;
      }
      int i4 = i + 1;
      i = 1;
      int i5;
      for (;;)
      {
        i5 = i4 + i;
        if (paramArrayOfByte[i5] == 10) {
          break;
        }
        i += 1;
      }
      int i6 = i5 - i4;
      int m = paramInt;
      int i1 = 0;
      i = 0;
      int n = 0;
      for (;;)
      {
        int i2;
        if (i1 != 0)
        {
          i1 = 0;
          i2 = 46;
        }
        else
        {
          i2 = paramArrayOfByte1[m][i] & 0xFF;
        }
        int i7 = i2 - (paramArrayOfByte[(i4 + n)] & 0xFF);
        if (i7 == 0)
        {
          i2 = n + 1;
          int i3 = i + 1;
          if (i2 == i6)
          {
            i = i3;
            n = i2;
          }
          else
          {
            i = i3;
            n = i2;
            if (paramArrayOfByte1[m].length != i3) {
              continue;
            }
            if (m != paramArrayOfByte1.length - 1) {
              break label314;
            }
            n = i2;
            i = i3;
          }
        }
        if (i7 < 0)
        {
          j = i4 - 1;
          break;
        }
        if (i7 > 0)
        {
          k = i5 + 1;
          break;
        }
        n = i6 - n;
        i = paramArrayOfByte1[m].length - i;
        for (;;)
        {
          m += 1;
          if (m >= paramArrayOfByte1.length) {
            break;
          }
          i += paramArrayOfByte1[m].length;
        }
        if (i < n)
        {
          j = i4 - 1;
          break;
        }
        if (i > n)
        {
          k = i5 + 1;
          break;
        }
        return new String(paramArrayOfByte, i4, i6, fc.e);
        label314:
        m += 1;
        i1 = 1;
        i = -1;
        n = i2;
      }
    }
    return null;
  }
  
  public static PublicSuffixDatabase a()
  {
    return d;
  }
  
  private String[] a(String[] paramArrayOfString)
  {
    boolean bool = this.e.get();
    int j = 0;
    if ((!bool) && (this.e.compareAndSet(false, true))) {
      b();
    }
    try
    {
      this.f.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      label45:
      break label45;
    }
    Thread.currentThread().interrupt();
    try
    {
      if (this.g != null)
      {
        byte[][] arrayOfByte = new byte[paramArrayOfString.length][];
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          arrayOfByte[i] = paramArrayOfString[i].getBytes(fc.e);
          i += 1;
        }
        i = 0;
        while (i < arrayOfByte.length)
        {
          paramArrayOfString = a(this.g, arrayOfByte, i);
          if (paramArrayOfString != null) {
            break label133;
          }
          i += 1;
        }
        paramArrayOfString = null;
        label133:
        if (arrayOfByte.length > 1)
        {
          localObject2 = (byte[][])arrayOfByte.clone();
          i = 0;
          while (i < localObject2.length - 1)
          {
            localObject2[i] = a;
            localObject1 = a(this.g, (byte[][])localObject2, i);
            if (localObject1 != null) {
              break label198;
            }
            i += 1;
          }
        }
        Object localObject1 = null;
        label198:
        if (localObject1 != null)
        {
          i = j;
          while (i < arrayOfByte.length - 1)
          {
            localObject2 = a(this.h, arrayOfByte, i);
            if (localObject2 != null) {
              break label244;
            }
            i += 1;
          }
        }
        Object localObject2 = null;
        label244:
        if (localObject2 != null)
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("!");
          paramArrayOfString.append((String)localObject2);
          return paramArrayOfString.toString().split("\\.");
        }
        if ((paramArrayOfString == null) && (localObject1 == null)) {
          return c;
        }
        if (paramArrayOfString != null) {
          paramArrayOfString = paramArrayOfString.split("\\.");
        } else {
          paramArrayOfString = b;
        }
        if (localObject1 != null) {
          localObject1 = ((String)localObject1).split("\\.");
        } else {
          localObject1 = b;
        }
        if (paramArrayOfString.length > localObject1.length) {
          return paramArrayOfString;
        }
        return localObject1;
      }
      throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 134	okhttp3/internal/publicsuffix/PublicSuffixDatabase:c	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: goto +25 -> 43
    //   21: astore_2
    //   22: invokestatic 139	com/tencent/token/gc:c	()Lcom/tencent/token/gc;
    //   25: iconst_5
    //   26: ldc 141
    //   28: aload_2
    //   29: invokevirtual 144	com/tencent/token/gc:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   32: iload_1
    //   33: ifeq +9 -> 42
    //   36: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   39: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   42: return
    //   43: iload_1
    //   44: ifeq +9 -> 53
    //   47: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   50: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   53: aload_2
    //   54: athrow
    //   55: iconst_1
    //   56: istore_1
    //   57: goto -55 -> 2
    //   60: astore_2
    //   61: goto -6 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	PublicSuffixDatabase
    //   1	56	1	i	int
    //   17	1	2	localObject	Object
    //   21	33	2	localIOException	java.io.IOException
    //   60	1	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	finally
    //   22	32	17	finally
    //   2	6	21	java/io/IOException
    //   2	6	60	java/io/InterruptedIOException
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
    //   68: putfield 87	okhttp3/internal/publicsuffix/PublicSuffixDatabase:g	[B
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 102	okhttp3/internal/publicsuffix/PublicSuffixDatabase:h	[B
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 50	okhttp3/internal/publicsuffix/PublicSuffixDatabase:f	Ljava/util/concurrent/CountDownLatch;
    //   82: invokevirtual 180	java/util/concurrent/CountDownLatch:countDown	()V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic 177	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	PublicSuffixDatabase
    //   7	54	1	localObject1	Object
    //   86	7	1	localCloseable	java.io.Closeable
    //   36	32	2	arrayOfByte1	byte[]
    //   91	6	2	localObject2	Object
    //   52	21	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   66	78	86	finally
    //   87	89	86	finally
    //   28	60	91	finally
  }
  
  public String a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = IDN.toUnicode(paramString).split("\\.");
      String[] arrayOfString = a((String[])localObject);
      if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!')) {
        return null;
      }
      int i;
      if (arrayOfString[0].charAt(0) == '!') {
        i = localObject.length - arrayOfString.length;
      } else {
        i = localObject.length - (arrayOfString.length + 1);
      }
      localObject = new StringBuilder();
      paramString = paramString.split("\\.");
      while (i < paramString.length)
      {
        ((StringBuilder)localObject).append(paramString[i]);
        ((StringBuilder)localObject).append('.');
        i += 1;
      }
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      return ((StringBuilder)localObject).toString();
    }
    throw new NullPointerException("domain == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.publicsuffix.PublicSuffixDatabase
 * JD-Core Version:    0.7.0.1
 */