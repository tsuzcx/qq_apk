package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.aa;
import okhttp3.e;
import okhttp3.f;
import okhttp3.z;

public class cz
  extends Handler
{
  private final int a = 4;
  private da b;
  private long c;
  private volatile boolean d = false;
  private AtomicInteger e = new AtomicInteger(0);
  private AtomicInteger f = new AtomicInteger(0);
  private AtomicInteger g = new AtomicInteger(0);
  private db h;
  private long[] i;
  private File[] j;
  private File k;
  private volatile boolean l;
  private volatile boolean m;
  private cx n;
  
  public cz(da paramda, cx paramcx)
  {
    this.b = paramda;
    this.n = paramcx;
    this.i = new long[4];
    this.j = new File[4];
    this.h = db.a();
  }
  
  private void a(final long paramLong1, long paramLong2, final int paramInt)
  {
    Object localObject1 = this.b.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("thread");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.b.a());
    ((StringBuilder)localObject2).append(".cache");
    localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
    this.j[paramInt] = localObject1;
    localObject2 = new RandomAccessFile((File)localObject1, "rwd");
    final long l1;
    if (((File)localObject1).exists())
    {
      String str = ((RandomAccessFile)localObject2).readLine();
      if (str != null) {}
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          l1 = Integer.parseInt(str);
        }
        else
        {
          if (this.n != null) {
            this.n.b();
          }
          l1 = paramLong1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    else
    {
      l1 = paramLong1;
    }
    this.h.a(this.b.b(), l1, paramLong2, new f()
    {
      public void a(e paramAnonymouse, IOException paramAnonymousIOException)
      {
        cz.a(cz.this, false);
      }
      
      public void a(e paramAnonymouse, z paramAnonymousz)
      {
        if (paramAnonymousz.b() != 206)
        {
          cz.a(cz.this);
          return;
        }
        paramAnonymouse = paramAnonymousz.e().b();
        RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(cz.c(cz.this), "rw");
        localRandomAccessFile1.seek(l1);
        byte[] arrayOfByte = new byte[4096];
        int i = 0;
        for (;;)
        {
          int j = paramAnonymouse.read(arrayOfByte);
          if (j <= 0) {
            break;
          }
          if (cz.e(cz.this))
          {
            cz.a(cz.this, new Closeable[] { this.b, paramAnonymouse, paramAnonymousz.e() });
            cz.a(cz.this, new File[] { paramInt });
            cz.this.sendEmptyMessage(4);
            return;
          }
          if (cz.f(cz.this))
          {
            cz.a(cz.this, new Closeable[] { this.b, paramAnonymouse, paramAnonymousz.e() });
            cz.this.sendEmptyMessage(3);
            return;
          }
          localRandomAccessFile1.write(arrayOfByte, 0, j);
          i += j;
          long l = l1 + i;
          this.b.seek(0L);
          RandomAccessFile localRandomAccessFile2 = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(l);
          localStringBuilder.append("");
          localRandomAccessFile2.write(localStringBuilder.toString().getBytes("UTF-8"));
          cz.g(cz.this)[paramLong1] = (l - this.e);
          cz.this.sendEmptyMessage(1);
        }
        cz.a(cz.this, new Closeable[] { this.b, paramAnonymouse, paramAnonymousz.e() });
        cz.a(cz.this, new File[] { paramInt });
        cz.this.sendEmptyMessage(2);
      }
    });
  }
  
  /* Error */
  private void a(Closeable... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore 7
    //   4: iconst_0
    //   5: istore 5
    //   7: iconst_0
    //   8: istore 6
    //   10: iconst_0
    //   11: istore 4
    //   13: iconst_0
    //   14: istore_2
    //   15: iload 6
    //   17: istore_3
    //   18: iload_2
    //   19: iload 7
    //   21: if_icmpge +79 -> 100
    //   24: aload_1
    //   25: iload_2
    //   26: aaload
    //   27: ifnull +11 -> 38
    //   30: aload_1
    //   31: iload_2
    //   32: aaload
    //   33: invokeinterface 170 1 0
    //   38: iload_2
    //   39: iconst_1
    //   40: iadd
    //   41: istore_2
    //   42: goto -27 -> 15
    //   45: astore 8
    //   47: iload 5
    //   49: istore_2
    //   50: goto +30 -> 80
    //   53: astore 8
    //   55: aload 8
    //   57: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   60: iload 4
    //   62: istore_2
    //   63: iload_2
    //   64: iload 7
    //   66: if_icmpge +51 -> 117
    //   69: aload_1
    //   70: iload_2
    //   71: aconst_null
    //   72: aastore
    //   73: iload_2
    //   74: iconst_1
    //   75: iadd
    //   76: istore_2
    //   77: goto -14 -> 63
    //   80: iload_2
    //   81: iload 7
    //   83: if_icmpge +14 -> 97
    //   86: aload_1
    //   87: iload_2
    //   88: aconst_null
    //   89: aastore
    //   90: iload_2
    //   91: iconst_1
    //   92: iadd
    //   93: istore_2
    //   94: goto -14 -> 80
    //   97: aload 8
    //   99: athrow
    //   100: iload_3
    //   101: iload 7
    //   103: if_icmpge +14 -> 117
    //   106: aload_1
    //   107: iload_3
    //   108: aconst_null
    //   109: aastore
    //   110: iload_3
    //   111: iconst_1
    //   112: iadd
    //   113: istore_3
    //   114: goto -14 -> 100
    //   117: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	cz
    //   0	118	1	paramVarArgs	Closeable[]
    //   14	80	2	i1	int
    //   17	97	3	i2	int
    //   11	50	4	i3	int
    //   5	43	5	i4	int
    //   8	8	6	i5	int
    //   2	102	7	i6	int
    //   45	1	8	localObject	Object
    //   53	45	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   30	38	45	finally
    //   55	60	45	finally
    //   30	38	53	java/io/IOException
  }
  
  private void a(File... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramVarArgs[i1] != null) {
        paramVarArgs[i1].delete();
      }
      i1 += 1;
    }
  }
  
  private boolean a(AtomicInteger paramAtomicInteger)
  {
    return paramAtomicInteger.incrementAndGet() % 4 != 0;
  }
  
  private void d()
  {
    this.l = false;
    this.m = false;
    this.d = false;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 191
    //   13: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 41	com/tencent/token/cz:d	Z
    //   22: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: ldc 196
    //   29: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 54	com/tencent/token/cz:b	Lcom/tencent/token/da;
    //   38: invokevirtual 143	com/tencent/token/da:b	()Ljava/lang/String;
    //   41: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 198
    //   47: aload_2
    //   48: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 41	com/tencent/token/cz:d	Z
    //   59: istore_1
    //   60: iload_1
    //   61: ifeq +6 -> 67
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 41	com/tencent/token/cz:d	Z
    //   72: aload_0
    //   73: getfield 69	com/tencent/token/cz:h	Lcom/tencent/token/db;
    //   76: aload_0
    //   77: getfield 54	com/tencent/token/cz:b	Lcom/tencent/token/da;
    //   80: invokevirtual 143	com/tencent/token/da:b	()Ljava/lang/String;
    //   83: new 6	com/tencent/token/cz$1
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 205	com/tencent/token/cz$1:<init>	(Lcom/tencent/token/cz;)V
    //   91: invokevirtual 208	com/tencent/token/db:a	(Ljava/lang/String;Lokhttp3/f;)V
    //   94: goto +16 -> 110
    //   97: astore_2
    //   98: goto +15 -> 113
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   106: aload_0
    //   107: invokespecial 152	com/tencent/token/cz:d	()V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	cz
    //   59	2	1	bool	boolean
    //   9	39	2	localStringBuilder	StringBuilder
    //   97	1	2	localObject	Object
    //   101	15	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	60	97	finally
    //   67	94	97	finally
    //   102	110	97	finally
    //   2	60	101	java/io/IOException
    //   67	94	101	java/io/IOException
  }
  
  public void b()
  {
    this.l = true;
    this.d = false;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.n == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4: 
      if (a(this.e)) {
        return;
      }
      d();
      this.i = new long[4];
      this.n.c();
      return;
    case 3: 
      this.n.b();
      if (a(this.f)) {
        return;
      }
      d();
      return;
    case 2: 
      if (a(this.g)) {
        return;
      }
      this.k.renameTo(new File(this.b.c(), this.b.a()));
      d();
      this.n.a();
      return;
    }
    long l1 = 0L;
    int i1 = 0;
    int i2 = this.i.length;
    while (i1 < i2)
    {
      l1 += this.i[i1];
      i1 += 1;
    }
    this.n.a((float)l1 * 1.0F / (float)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cz
 * JD-Core Version:    0.7.0.1
 */