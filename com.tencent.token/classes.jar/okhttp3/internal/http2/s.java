package okhttp3.internal.http2;

import com.tencent.token.gm;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import okio.ByteString;
import okio.i;

class s
  extends gm
  implements y
{
  final w a;
  
  s(h paramh, w paramw)
  {
    super("OkHttp %s", new Object[] { paramh.d });
    this.a = paramw;
  }
  
  private void a(ai paramai)
  {
    try
    {
      h.b(this.c).execute(new v(this, "OkHttp %s ACK Settings", new Object[] { this.c.d }, paramai));
      return;
    }
    catch (RejectedExecutionException paramai) {}
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void a(int paramInt1, int paramInt2, List paramList)
  {
    this.c.a(paramInt2, paramList);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      synchronized (this.c)
      {
        h localh = this.c;
        localh.j += paramLong;
        this.c.notifyAll();
        return;
      }
    }
    ??? = this.c.a(paramInt);
    if (??? != null) {
      try
      {
        ((z)???).a(paramLong);
        return;
      }
      finally {}
    }
  }
  
  public void a(int paramInt, ErrorCode paramErrorCode)
  {
    if (this.c.c(paramInt)) {
      this.c.c(paramInt, paramErrorCode);
    }
    z localz;
    do
    {
      return;
      localz = this.c.b(paramInt);
    } while (localz == null);
    localz.c(paramErrorCode);
  }
  
  public void a(int paramInt, ErrorCode arg2, ByteString paramByteString)
  {
    if (paramByteString.g() > 0) {}
    synchronized (this.c)
    {
      paramByteString = (z[])this.c.c.values().toArray(new z[this.c.c.size()]);
      this.c.g = true;
      int j = paramByteString.length;
      int i = 0;
      if (i < j)
      {
        ??? = paramByteString[i];
        if ((???.a() > paramInt) && (???.c()))
        {
          ???.c(ErrorCode.REFUSED_STREAM);
          this.c.b(???.a());
        }
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      synchronized (this.c)
      {
        h.a(this.c, false);
        this.c.notifyAll();
        return;
      }
    }
    try
    {
      h.b(this.c).execute(new r(this.c, true, paramInt1, paramInt2));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List paramList)
  {
    if (this.c.c(paramInt1)) {
      this.c.a(paramInt1, paramList, paramBoolean);
    }
    z localz;
    label193:
    do
    {
      return;
      synchronized (this.c)
      {
        localz = this.c.a(paramInt1);
        if (localz != null) {
          break label193;
        }
        if (this.c.g) {
          return;
        }
      }
      if (paramInt1 <= this.c.e) {
        return;
      }
      if (paramInt1 % 2 == this.c.f % 2) {
        return;
      }
      paramList = new z(paramInt1, this.c, false, paramBoolean, paramList);
      this.c.e = paramInt1;
      this.c.c.put(Integer.valueOf(paramInt1), paramList);
      h.e().execute(new t(this, "OkHttp %s stream %d", new Object[] { this.c.d, Integer.valueOf(paramInt1) }, paramList));
      return;
      localz.a(paramList);
    } while (!paramBoolean);
    localz.i();
  }
  
  public void a(boolean paramBoolean, int paramInt1, i parami, int paramInt2)
  {
    if (this.c.c(paramInt1)) {
      this.c.a(paramInt1, parami, paramInt2, paramBoolean);
    }
    z localz;
    do
    {
      return;
      localz = this.c.a(paramInt1);
      if (localz == null)
      {
        this.c.a(paramInt1, ErrorCode.PROTOCOL_ERROR);
        this.c.a(paramInt2);
        parami.h(paramInt2);
        return;
      }
      localz.a(parami, paramInt2);
    } while (!paramBoolean);
    localz.i();
  }
  
  public void a(boolean paramBoolean, ai paramai)
  {
    for (;;)
    {
      int i;
      synchronized (this.c)
      {
        i = this.c.l.d();
        if (paramBoolean) {
          this.c.l.a();
        }
        this.c.l.a(paramai);
        a(paramai);
        int j = this.c.l.d();
        if ((j == -1) || (j == i)) {
          break label251;
        }
        l = j - i;
        if (!this.c.m) {
          this.c.m = true;
        }
        if (this.c.c.isEmpty()) {
          break label246;
        }
        paramai = (z[])this.c.c.values().toArray(new z[this.c.c.size()]);
        h.e().execute(new u(this, "OkHttp %s settings", new Object[] { this.c.d }));
        if ((paramai == null) || (l == 0L)) {
          break label245;
        }
        j = paramai.length;
        i = 0;
        if (i >= j) {
          break label245;
        }
      }
      synchronized (paramai[i])
      {
        ???.a(l);
        i += 1;
        continue;
        paramai = finally;
        throw paramai;
      }
      label245:
      return;
      label246:
      paramai = null;
      continue;
      label251:
      paramai = null;
      long l = 0L;
    }
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: getstatic 226	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   3: astore_3
    //   4: getstatic 226	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   7: astore 4
    //   9: aload_3
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 29	okhttp3/internal/http2/s:a	Lokhttp3/internal/http2/w;
    //   17: aload_0
    //   18: invokevirtual 231	okhttp3/internal/http2/w:a	(Lokhttp3/internal/http2/y;)V
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 29	okhttp3/internal/http2/s:a	Lokhttp3/internal/http2/w;
    //   29: iconst_0
    //   30: aload_0
    //   31: invokevirtual 234	okhttp3/internal/http2/w:a	(ZLokhttp3/internal/http2/y;)Z
    //   34: ifne -13 -> 21
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: getstatic 237	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: getstatic 240	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 14	okhttp3/internal/http2/s:c	Lokhttp3/internal/http2/h;
    //   58: aload_3
    //   59: aload 5
    //   61: invokevirtual 243	okhttp3/internal/http2/h:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   64: aload_0
    //   65: getfield 29	okhttp3/internal/http2/s:a	Lokhttp3/internal/http2/w;
    //   68: invokestatic 248	com/tencent/token/gn:a	(Ljava/io/Closeable;)V
    //   71: return
    //   72: astore_1
    //   73: aload_2
    //   74: astore_1
    //   75: getstatic 183	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   78: astore_3
    //   79: getstatic 183	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   82: astore_1
    //   83: aload_0
    //   84: getfield 14	okhttp3/internal/http2/s:c	Lokhttp3/internal/http2/h;
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 243	okhttp3/internal/http2/h:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   92: aload_0
    //   93: getfield 29	okhttp3/internal/http2/s:a	Lokhttp3/internal/http2/w;
    //   96: invokestatic 248	com/tencent/token/gn:a	(Ljava/io/Closeable;)V
    //   99: return
    //   100: astore_2
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 14	okhttp3/internal/http2/s:c	Lokhttp3/internal/http2/h;
    //   109: aload_3
    //   110: aload 4
    //   112: invokevirtual 243	okhttp3/internal/http2/h:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   115: aload_0
    //   116: getfield 29	okhttp3/internal/http2/s:a	Lokhttp3/internal/http2/w;
    //   119: invokestatic 248	com/tencent/token/gn:a	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_2
    //   125: goto -10 -> 115
    //   128: astore_1
    //   129: goto -24 -> 105
    //   132: astore_1
    //   133: goto -41 -> 92
    //   136: astore_1
    //   137: goto -73 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	s
    //   12	37	1	localObject1	Object
    //   72	1	1	localIOException1	java.io.IOException
    //   74	49	1	localObject2	Object
    //   128	1	1	localObject3	Object
    //   132	1	1	localIOException2	java.io.IOException
    //   136	1	1	localIOException3	java.io.IOException
    //   10	64	2	localObject4	Object
    //   100	4	2	localObject5	Object
    //   124	1	2	localIOException4	java.io.IOException
    //   3	107	3	localObject6	Object
    //   7	104	4	localErrorCode1	ErrorCode
    //   52	8	5	localErrorCode2	ErrorCode
    // Exception table:
    //   from	to	target	type
    //   13	21	72	java/io/IOException
    //   25	37	72	java/io/IOException
    //   41	45	72	java/io/IOException
    //   49	54	72	java/io/IOException
    //   13	21	100	finally
    //   25	37	100	finally
    //   41	45	100	finally
    //   49	54	100	finally
    //   75	79	100	finally
    //   105	115	124	java/io/IOException
    //   79	83	128	finally
    //   83	92	132	java/io/IOException
    //   54	64	136	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.s
 * JD-Core Version:    0.7.0.1
 */