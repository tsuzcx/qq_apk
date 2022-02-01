package com.tencent.token;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.r.a;
import okhttp3.t;
import okhttp3.z;
import okhttp3.z.a;
import okio.c;
import okio.d;
import okio.e;
import okio.k;
import okio.p;
import okio.q;

public final class fe
  implements t
{
  final fi a;
  
  public fe(fi paramfi)
  {
    this.a = paramfi;
  }
  
  private static okhttp3.r a(okhttp3.r paramr1, okhttp3.r paramr2)
  {
    r.a locala = new r.a();
    int k = paramr1.a();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str1 = paramr1.a(i);
      String str2 = paramr1.b(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((b(str1)) || (!a(str1)) || (paramr2.a(str1) == null))) {
        fa.a.a(locala, str1, str2);
      }
      i += 1;
    }
    k = paramr2.a();
    i = j;
    while (i < k)
    {
      paramr1 = paramr2.a(i);
      if ((!b(paramr1)) && (a(paramr1))) {
        fa.a.a(locala, paramr1, paramr2.b(i));
      }
      i += 1;
    }
    return locala.a();
  }
  
  private z a(final ff paramff, z paramz)
  {
    if (paramff == null) {
      return paramz;
    }
    Object localObject = paramff.a();
    if (localObject == null) {
      return paramz;
    }
    paramff = new q()
    {
      boolean a;
      
      public long a(c paramAnonymousc, long paramAnonymousLong)
      {
        try
        {
          paramAnonymousLong = this.b.a(paramAnonymousc, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.a)
            {
              this.a = true;
              this.d.close();
            }
            return -1L;
          }
          paramAnonymousc.a(this.d.c(), paramAnonymousc.b() - paramAnonymousLong, paramAnonymousLong);
          this.d.u();
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousc)
        {
          if (!this.a)
          {
            this.a = true;
            paramff.b();
          }
          throw paramAnonymousc;
        }
      }
      
      public okio.r a()
      {
        return this.b.a();
      }
      
      public void close()
      {
        if ((!this.a) && (!fc.a(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.a = true;
          paramff.b();
        }
        this.b.close();
      }
    };
    localObject = paramz.a("Content-Type");
    long l = paramz.e().a();
    return paramz.f().a(new fq((String)localObject, l, k.a(paramff))).a();
  }
  
  private static z a(z paramz)
  {
    z localz = paramz;
    if (paramz != null)
    {
      localz = paramz;
      if (paramz.e() != null) {
        localz = paramz.f().a(null).a();
      }
    }
    return localz;
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  static boolean b(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public z a(okhttp3.t.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +19 -> 25
    //   9: aload_2
    //   10: aload_1
    //   11: invokeinterface 145 1 0
    //   16: invokeinterface 150 2 0
    //   21: astore_2
    //   22: goto +5 -> 27
    //   25: aconst_null
    //   26: astore_2
    //   27: new 152	com/tencent/token/fg$a
    //   30: dup
    //   31: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   34: aload_1
    //   35: invokeinterface 145 1 0
    //   40: aload_2
    //   41: invokespecial 160	com/tencent/token/fg$a:<init>	(JLokhttp3/x;Lokhttp3/z;)V
    //   44: invokevirtual 163	com/tencent/token/fg$a:a	()Lcom/tencent/token/fg;
    //   47: astore 5
    //   49: aload 5
    //   51: getfield 168	com/tencent/token/fg:a	Lokhttp3/x;
    //   54: astore_3
    //   55: aload 5
    //   57: getfield 171	com/tencent/token/fg:b	Lokhttp3/z;
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull +12 -> 82
    //   73: aload 6
    //   75: aload 5
    //   77: invokeinterface 174 2 0
    //   82: aload_2
    //   83: ifnull +15 -> 98
    //   86: aload 4
    //   88: ifnonnull +10 -> 98
    //   91: aload_2
    //   92: invokevirtual 76	okhttp3/z:e	()Lokhttp3/aa;
    //   95: invokestatic 179	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   98: aload_3
    //   99: ifnonnull +63 -> 162
    //   102: aload 4
    //   104: ifnonnull +58 -> 162
    //   107: new 110	okhttp3/z$a
    //   110: dup
    //   111: invokespecial 180	okhttp3/z$a:<init>	()V
    //   114: aload_1
    //   115: invokeinterface 145 1 0
    //   120: invokevirtual 183	okhttp3/z$a:a	(Lokhttp3/x;)Lokhttp3/z$a;
    //   123: getstatic 189	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   126: invokevirtual 192	okhttp3/z$a:a	(Lokhttp3/Protocol;)Lokhttp3/z$a;
    //   129: sipush 504
    //   132: invokevirtual 195	okhttp3/z$a:a	(I)Lokhttp3/z$a;
    //   135: ldc 197
    //   137: invokevirtual 200	okhttp3/z$a:a	(Ljava/lang/String;)Lokhttp3/z$a;
    //   140: getstatic 203	com/tencent/token/fc:c	Lokhttp3/aa;
    //   143: invokevirtual 113	okhttp3/z$a:a	(Lokhttp3/aa;)Lokhttp3/z$a;
    //   146: ldc2_w 204
    //   149: invokevirtual 208	okhttp3/z$a:a	(J)Lokhttp3/z$a;
    //   152: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   155: invokevirtual 210	okhttp3/z$a:b	(J)Lokhttp3/z$a;
    //   158: invokevirtual 116	okhttp3/z$a:a	()Lokhttp3/z;
    //   161: areturn
    //   162: aload_3
    //   163: ifnonnull +20 -> 183
    //   166: aload 4
    //   168: invokevirtual 100	okhttp3/z:f	()Lokhttp3/z$a;
    //   171: aload 4
    //   173: invokestatic 212	com/tencent/token/fe:a	(Lokhttp3/z;)Lokhttp3/z;
    //   176: invokevirtual 215	okhttp3/z$a:b	(Lokhttp3/z;)Lokhttp3/z$a;
    //   179: invokevirtual 116	okhttp3/z$a:a	()Lokhttp3/z;
    //   182: areturn
    //   183: aload_1
    //   184: aload_3
    //   185: invokeinterface 216 2 0
    //   190: astore_1
    //   191: aload_1
    //   192: ifnonnull +14 -> 206
    //   195: aload_2
    //   196: ifnull +10 -> 206
    //   199: aload_2
    //   200: invokevirtual 76	okhttp3/z:e	()Lokhttp3/aa;
    //   203: invokestatic 179	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   206: aload 4
    //   208: ifnull +104 -> 312
    //   211: aload_1
    //   212: invokevirtual 218	okhttp3/z:b	()I
    //   215: sipush 304
    //   218: if_icmpne +86 -> 304
    //   221: aload 4
    //   223: invokevirtual 100	okhttp3/z:f	()Lokhttp3/z$a;
    //   226: aload 4
    //   228: invokevirtual 221	okhttp3/z:d	()Lokhttp3/r;
    //   231: aload_1
    //   232: invokevirtual 221	okhttp3/z:d	()Lokhttp3/r;
    //   235: invokestatic 223	com/tencent/token/fe:a	(Lokhttp3/r;Lokhttp3/r;)Lokhttp3/r;
    //   238: invokevirtual 226	okhttp3/z$a:a	(Lokhttp3/r;)Lokhttp3/z$a;
    //   241: aload_1
    //   242: invokevirtual 229	okhttp3/z:i	()J
    //   245: invokevirtual 208	okhttp3/z$a:a	(J)Lokhttp3/z$a;
    //   248: aload_1
    //   249: invokevirtual 232	okhttp3/z:j	()J
    //   252: invokevirtual 210	okhttp3/z$a:b	(J)Lokhttp3/z$a;
    //   255: aload 4
    //   257: invokestatic 212	com/tencent/token/fe:a	(Lokhttp3/z;)Lokhttp3/z;
    //   260: invokevirtual 215	okhttp3/z$a:b	(Lokhttp3/z;)Lokhttp3/z$a;
    //   263: aload_1
    //   264: invokestatic 212	com/tencent/token/fe:a	(Lokhttp3/z;)Lokhttp3/z;
    //   267: invokevirtual 234	okhttp3/z$a:a	(Lokhttp3/z;)Lokhttp3/z$a;
    //   270: invokevirtual 116	okhttp3/z$a:a	()Lokhttp3/z;
    //   273: astore_2
    //   274: aload_1
    //   275: invokevirtual 76	okhttp3/z:e	()Lokhttp3/aa;
    //   278: invokevirtual 237	okhttp3/aa:close	()V
    //   281: aload_0
    //   282: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   285: invokeinterface 239 1 0
    //   290: aload_0
    //   291: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   294: aload 4
    //   296: aload_2
    //   297: invokeinterface 242 3 0
    //   302: aload_2
    //   303: areturn
    //   304: aload 4
    //   306: invokevirtual 76	okhttp3/z:e	()Lokhttp3/aa;
    //   309: invokestatic 179	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   312: aload_1
    //   313: invokevirtual 100	okhttp3/z:f	()Lokhttp3/z$a;
    //   316: aload 4
    //   318: invokestatic 212	com/tencent/token/fe:a	(Lokhttp3/z;)Lokhttp3/z;
    //   321: invokevirtual 215	okhttp3/z$a:b	(Lokhttp3/z;)Lokhttp3/z$a;
    //   324: aload_1
    //   325: invokestatic 212	com/tencent/token/fe:a	(Lokhttp3/z;)Lokhttp3/z;
    //   328: invokevirtual 234	okhttp3/z$a:a	(Lokhttp3/z;)Lokhttp3/z$a;
    //   331: invokevirtual 116	okhttp3/z$a:a	()Lokhttp3/z;
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   339: ifnull +54 -> 393
    //   342: aload_1
    //   343: invokestatic 247	com/tencent/token/fn:b	(Lokhttp3/z;)Z
    //   346: ifeq +27 -> 373
    //   349: aload_1
    //   350: aload_3
    //   351: invokestatic 250	com/tencent/token/fg:a	(Lokhttp3/z;Lokhttp3/x;)Z
    //   354: ifeq +19 -> 373
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   362: aload_1
    //   363: invokeinterface 253 2 0
    //   368: aload_1
    //   369: invokespecial 255	com/tencent/token/fe:a	(Lcom/tencent/token/ff;Lokhttp3/z;)Lokhttp3/z;
    //   372: areturn
    //   373: aload_3
    //   374: invokevirtual 260	okhttp3/x:b	()Ljava/lang/String;
    //   377: invokestatic 263	com/tencent/token/fo:a	(Ljava/lang/String;)Z
    //   380: ifeq +13 -> 393
    //   383: aload_0
    //   384: getfield 17	com/tencent/token/fe:a	Lcom/tencent/token/fi;
    //   387: aload_3
    //   388: invokeinterface 266 2 0
    //   393: aload_1
    //   394: areturn
    //   395: astore_1
    //   396: aload_2
    //   397: ifnull +10 -> 407
    //   400: aload_2
    //   401: invokevirtual 76	okhttp3/z:e	()Lokhttp3/aa;
    //   404: invokestatic 179	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
    //   407: aload_1
    //   408: athrow
    //   409: astore_2
    //   410: aload_1
    //   411: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	fe
    //   0	412	1	parama	okhttp3.t.a
    //   4	397	2	localObject	Object
    //   409	1	2	localIOException	IOException
    //   54	334	3	localx	okhttp3.x
    //   60	257	4	localz	z
    //   47	29	5	localfg	fg
    //   66	8	6	localfi	fi
    // Exception table:
    //   from	to	target	type
    //   183	191	395	finally
    //   383	393	409	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fe
 * JD-Core Version:    0.7.0.1
 */