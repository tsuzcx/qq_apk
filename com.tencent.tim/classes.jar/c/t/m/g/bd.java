package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

final class bd
{
  final LinkedBlockingQueue<a> a;
  final ap b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  long h;
  
  bd(ap paramap)
  {
    this.b = paramap;
    this.a = new LinkedBlockingQueue(3);
  }
  
  static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) < 0) {
        return av.a(paramInt, 0);
      }
      paramArrayOfByte = av.a(paramInt, 1);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 61	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: invokespecial 62	java/io/ByteArrayOutputStream:<init>	(I)V
    //   9: astore_1
    //   10: new 64	java/util/zip/GZIPOutputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 67	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: aload_0
    //   21: invokevirtual 71	java/util/zip/GZIPOutputStream:write	([B)V
    //   24: aload_2
    //   25: invokevirtual 74	java/util/zip/GZIPOutputStream:close	()V
    //   28: aload_1
    //   29: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 79	java/io/ByteArrayOutputStream:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_1
    //   52: invokevirtual 83	java/lang/Error:printStackTrace	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: goto -7 -> 51
    //   61: astore_1
    //   62: goto -20 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramArrayOfByte	byte[]
    //   9	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   39	4	1	localException1	Exception
    //   48	4	1	localError1	Error
    //   57	1	1	localError2	Error
    //   61	1	1	localException2	Exception
    //   18	7	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	33	39	java/lang/Exception
    //   0	33	48	java/lang/Error
    //   33	37	57	java/lang/Error
    //   33	37	61	java/lang/Exception
  }
  
  private void b()
  {
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
  }
  
  public final void a()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    this.a.clear();
    this.a.offer(a.e);
    this.h = 0L;
    if (this.f != 0L)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.f;
      String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l1 - l2) / 1000L), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.c) });
    }
    b();
  }
  
  final void a(a parama)
  {
    a.e(parama);
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a.b((a)localIterator.next()) != a.b(parama));
    for (int i = 1;; i = 0)
    {
      if ((a.f(parama) > 0) && (i == 0) && (a.b(parama) != 2))
      {
        new StringBuilder("retryIfNeed: times=").append(a.f(parama));
        this.a.offer(parama);
      }
      return;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = a(paramString.getBytes("UTF-8"));
      e.o((byte[])localObject, 2);
      localObject = new a(2, (byte[])localObject, "https://ue.indoorloc.map.qq.com/", null);
      ((a)localObject).b = paramString;
      if (a.a((a)localObject) != null)
      {
        this.a.offer(localObject);
        return;
      }
    }
    catch (Exception paramString) {}catch (Error paramString) {}
  }
  
  static final class a
  {
    public static final a e = new a();
    final Object a;
    public String b;
    public long c;
    public int d = -1;
    private int f;
    private final byte[] g;
    private String h;
    private int i = 1;
    
    private a()
    {
      this.f = 0;
      this.g = null;
      this.h = null;
      this.a = null;
    }
    
    a(int paramInt, byte[] paramArrayOfByte, String paramString, Object paramObject)
    {
      this.f = paramInt;
      this.g = paramArrayOfByte;
      this.h = paramString;
      this.a = paramObject;
      if (3 == paramInt) {
        this.i = 3;
      }
    }
    
    public final String toString()
    {
      return "type=" + this.f + ",url=" + this.h + ",coorType=" + this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bd
 * JD-Core Version:    0.7.0.1
 */