package com.tencent.token;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ky
  implements la
{
  private static String r = "CommReq";
  private boolean A = false;
  protected String a;
  public List b = null;
  public b c = new b();
  protected Map d = null;
  public int e = 0;
  public String f = "";
  public boolean g = false;
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public long o = -1L;
  public List p = null;
  public lg q;
  private String s;
  private int t = 4096;
  private int u = 8;
  private URL v = null;
  private HttpURLConnection w = null;
  private InputStream x = null;
  private long y = -1L;
  private volatile boolean z = false;
  
  private void a(String paramString)
  {
    Object localObject = "";
    HttpURLConnection localHttpURLConnection = this.w;
    if (localHttpURLConnection != null) {
      localObject = localHttpURLConnection.getHeaderField("X-Extra-Servers");
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      boolean bool = "http".equals(new URL(paramString).getProtocol());
      if (!bool) {
        return;
      }
      if (!paramString.startsWith("http://")) {
        return;
      }
      int i1 = paramString.indexOf("/", 7);
      if (i1 == -1) {
        return;
      }
      paramString.substring(7, i1);
      paramString = paramString.substring(i1);
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        this.p = new ArrayList();
        int i2 = localObject.length;
        i1 = 0;
        while (i1 < i2)
        {
          localHttpURLConnection = localObject[i1];
          List localList = this.p;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(localHttpURLConnection);
          localStringBuilder.append(paramString);
          localList.add(localStringBuilder.toString());
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    lh.a(r, "handleException:", paramThrowable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getName());
    localStringBuilder.append("|");
    localStringBuilder.append(paramThrowable);
    this.f = localStringBuilder.toString();
    int i1;
    if (this.z) {
      i1 = -66;
    }
    for (;;)
    {
      this.e = i1;
      return;
      if (!lc.f()) {
        i1 = -15;
      } else if (lc.h()) {
        i1 = -52;
      } else if (!lm.a()) {
        i1 = -16;
      } else {
        i1 = b(paramThrowable);
      }
    }
  }
  
  private static int b(Throwable paramThrowable)
  {
    try
    {
      boolean bool = paramThrowable.getMessage().contains("Permission");
      if (bool) {
        return -71;
      }
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    if (!(paramThrowable instanceof Exception)) {
      return -70;
    }
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return -25;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return -29;
      }
      if ((paramThrowable instanceof ConnectException)) {
        return -24;
      }
      if ((paramThrowable instanceof SocketException)) {
        return -26;
      }
      if ((paramThrowable instanceof IOException)) {
        return -27;
      }
    }
    return -48;
  }
  
  private static long b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        try
        {
          long l1 = Long.valueOf(paramString[1]).longValue();
          return l1;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  private static long c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        return l1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -1L;
  }
  
  private void g()
  {
    if (this.c.a.size() > 0) {
      this.w.addRequestProperty("Range", this.c.toString());
    }
    int i2 = 0;
    int i1 = 0;
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)this.d.get(str1);
        this.w.addRequestProperty(str1, str2);
        if ("User-Agent".equalsIgnoreCase(str1)) {
          i1 = 1;
        }
      }
    }
    if (i2 == 0) {
      this.w.addRequestProperty("User-Agent", "HalleyService/2.0");
    }
  }
  
  public final String a()
  {
    return lq.a(this.s, false);
  }
  
  /* Error */
  public final void a(kz paramkz)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 81	com/tencent/token/ky:w	Ljava/net/HttpURLConnection;
    //   5: invokevirtual 315	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: putfield 83	com/tencent/token/ky:x	Ljava/io/InputStream;
    //   11: aload_0
    //   12: getfield 61	com/tencent/token/ky:c	Lcom/tencent/token/ky$b;
    //   15: astore 20
    //   17: aload 20
    //   19: getfield 260	com/tencent/token/ky$b:a	Ljava/util/List;
    //   22: invokeinterface 264 1 0
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore 20
    //   33: goto +491 -> 524
    //   36: aload 20
    //   38: getfield 260	com/tencent/token/ky$b:a	Ljava/util/List;
    //   41: iconst_0
    //   42: invokeinterface 318 2 0
    //   47: checkcast 8	com/tencent/token/ky$a
    //   50: astore 20
    //   52: goto +472 -> 524
    //   55: aload_0
    //   56: getfield 99	com/tencent/token/ky:o	J
    //   59: lstore 5
    //   61: goto +31 -> 92
    //   64: aload 20
    //   66: getfield 320	com/tencent/token/ky$a:b	J
    //   69: aload 20
    //   71: getfield 322	com/tencent/token/ky$a:a	J
    //   74: lsub
    //   75: lstore 5
    //   77: aload 20
    //   79: getfield 320	com/tencent/token/ky$a:b	J
    //   82: ldc2_w 96
    //   85: lcmp
    //   86: ifne +6 -> 92
    //   89: goto -34 -> 55
    //   92: aload_0
    //   93: getfield 71	com/tencent/token/ky:t	I
    //   96: newarray byte
    //   98: astore 20
    //   100: iconst_1
    //   101: istore 18
    //   103: lconst_0
    //   104: lstore 15
    //   106: lconst_0
    //   107: lstore_3
    //   108: lconst_0
    //   109: lstore 7
    //   111: iconst_1
    //   112: istore 17
    //   114: lload 5
    //   116: lstore 13
    //   118: lload 15
    //   120: lload 13
    //   122: lcmp
    //   123: ifge +289 -> 412
    //   126: aload_0
    //   127: getfield 324	com/tencent/token/ky:q	Lcom/tencent/token/lg;
    //   130: invokeinterface 327 1 0
    //   135: istore 19
    //   137: iload 19
    //   139: ifeq +39 -> 178
    //   142: lload 7
    //   144: lstore 5
    //   146: aload_0
    //   147: invokevirtual 329	com/tencent/token/ky:e	()V
    //   150: aload_0
    //   151: getfield 103	com/tencent/token/ky:y	J
    //   154: lstore 7
    //   156: lload_3
    //   157: lload 5
    //   159: lsub
    //   160: lstore 5
    //   162: lload 7
    //   164: lstore_3
    //   165: lload_3
    //   166: lload 5
    //   168: invokestatic 335	java/lang/Math:max	(JJ)J
    //   171: lstore_3
    //   172: aload_0
    //   173: lload_3
    //   174: putfield 103	com/tencent/token/ky:y	J
    //   177: return
    //   178: iload 18
    //   180: ifne +10 -> 190
    //   183: lload 7
    //   185: lstore 5
    //   187: goto -41 -> 146
    //   190: aload_0
    //   191: getfield 71	com/tencent/token/ky:t	I
    //   194: istore_2
    //   195: iload_2
    //   196: i2l
    //   197: lstore 5
    //   199: lload 7
    //   201: lstore 9
    //   203: lload 7
    //   205: lstore 11
    //   207: lload 5
    //   209: lload 13
    //   211: lload 15
    //   213: lsub
    //   214: invokestatic 338	java/lang/Math:min	(JJ)J
    //   217: l2i
    //   218: istore_2
    //   219: lload 7
    //   221: lstore 5
    //   223: lload 15
    //   225: lconst_0
    //   226: lcmp
    //   227: ifne +16 -> 243
    //   230: lload 7
    //   232: lstore 9
    //   234: lload 7
    //   236: lstore 11
    //   238: invokestatic 343	android/os/SystemClock:elapsedRealtime	()J
    //   241: lstore 5
    //   243: lload 5
    //   245: lstore 9
    //   247: lload 5
    //   249: lstore 11
    //   251: aload_0
    //   252: getfield 83	com/tencent/token/ky:x	Ljava/io/InputStream;
    //   255: aload 20
    //   257: iconst_0
    //   258: iload_2
    //   259: invokevirtual 349	java/io/InputStream:read	([BII)I
    //   262: istore_2
    //   263: lload 15
    //   265: lconst_0
    //   266: lcmp
    //   267: ifne +22 -> 289
    //   270: lload 5
    //   272: lstore 9
    //   274: lload 5
    //   276: lstore 11
    //   278: invokestatic 343	android/os/SystemClock:elapsedRealtime	()J
    //   281: lstore 7
    //   283: lload 7
    //   285: lstore_3
    //   286: goto +3 -> 289
    //   289: iload_2
    //   290: iconst_m1
    //   291: if_icmpeq +31 -> 322
    //   294: aload_0
    //   295: getfield 324	com/tencent/token/ky:q	Lcom/tencent/token/lg;
    //   298: invokeinterface 327 1 0
    //   303: ifne +229 -> 532
    //   306: aload_1
    //   307: aload 20
    //   309: iload_2
    //   310: iload 17
    //   312: invokeinterface 354 4 0
    //   317: istore 18
    //   319: goto +213 -> 532
    //   322: aload_0
    //   323: bipush 194
    //   325: putfield 65	com/tencent/token/ky:e	I
    //   328: new 170	java/lang/StringBuilder
    //   331: dup
    //   332: ldc_w 356
    //   335: invokespecial 357	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: astore_1
    //   339: aload_1
    //   340: lload 15
    //   342: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_1
    //   347: ldc_w 362
    //   350: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_1
    //   355: lload 13
    //   357: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_0
    //   362: aload_1
    //   363: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: putfield 69	com/tencent/token/ky:f	Ljava/lang/String;
    //   369: goto -223 -> 146
    //   372: astore_1
    //   373: goto +130 -> 503
    //   376: astore_1
    //   377: goto +32 -> 409
    //   380: astore_1
    //   381: lload 9
    //   383: lstore 5
    //   385: goto +118 -> 503
    //   388: astore_1
    //   389: lload 11
    //   391: lstore 5
    //   393: goto +60 -> 453
    //   396: astore_1
    //   397: lload 7
    //   399: lstore 5
    //   401: goto +102 -> 503
    //   404: astore_1
    //   405: lload 7
    //   407: lstore 5
    //   409: goto +44 -> 453
    //   412: aload_0
    //   413: invokevirtual 329	com/tencent/token/ky:e	()V
    //   416: aload_0
    //   417: getfield 103	com/tencent/token/ky:y	J
    //   420: lstore 5
    //   422: lload_3
    //   423: lload 7
    //   425: lsub
    //   426: lstore 7
    //   428: lload 5
    //   430: lstore_3
    //   431: lload 7
    //   433: lstore 5
    //   435: goto -270 -> 165
    //   438: astore_1
    //   439: lconst_0
    //   440: lstore_3
    //   441: lconst_0
    //   442: lstore 5
    //   444: goto +59 -> 503
    //   447: astore_1
    //   448: lconst_0
    //   449: lstore 5
    //   451: lconst_0
    //   452: lstore_3
    //   453: aload_0
    //   454: aload_1
    //   455: invokespecial 364	com/tencent/token/ky:a	(Ljava/lang/Throwable;)V
    //   458: lload_3
    //   459: lstore 7
    //   461: lload 5
    //   463: lconst_0
    //   464: lcmp
    //   465: ifeq +17 -> 482
    //   468: lload_3
    //   469: lstore 7
    //   471: lload_3
    //   472: lconst_0
    //   473: lcmp
    //   474: ifne +8 -> 482
    //   477: invokestatic 343	android/os/SystemClock:elapsedRealtime	()J
    //   480: lstore 7
    //   482: aload_0
    //   483: invokevirtual 329	com/tencent/token/ky:e	()V
    //   486: aload_0
    //   487: getfield 103	com/tencent/token/ky:y	J
    //   490: lload 7
    //   492: lload 5
    //   494: lsub
    //   495: invokestatic 335	java/lang/Math:max	(JJ)J
    //   498: lstore_3
    //   499: goto -327 -> 172
    //   502: astore_1
    //   503: aload_0
    //   504: invokevirtual 329	com/tencent/token/ky:e	()V
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 103	com/tencent/token/ky:y	J
    //   512: lload_3
    //   513: lload 5
    //   515: lsub
    //   516: invokestatic 335	java/lang/Math:max	(JJ)J
    //   519: putfield 103	com/tencent/token/ky:y	J
    //   522: aload_1
    //   523: athrow
    //   524: aload 20
    //   526: ifnonnull -462 -> 64
    //   529: goto -474 -> 55
    //   532: iload 17
    //   534: ifeq +9 -> 543
    //   537: iconst_0
    //   538: istore 17
    //   540: goto +3 -> 543
    //   543: lload 15
    //   545: iload_2
    //   546: i2l
    //   547: ladd
    //   548: lstore 15
    //   550: lload 5
    //   552: lstore 7
    //   554: goto -436 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	ky
    //   0	557	1	paramkz	kz
    //   194	352	2	i1	int
    //   107	406	3	l1	long
    //   59	492	5	l2	long
    //   109	444	7	l3	long
    //   201	181	9	l4	long
    //   205	185	11	l5	long
    //   116	240	13	l6	long
    //   104	445	15	l7	long
    //   112	427	17	bool1	boolean
    //   101	217	18	bool2	boolean
    //   135	3	19	bool3	boolean
    //   15	510	20	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   294	319	372	finally
    //   322	369	372	finally
    //   294	319	376	java/lang/Throwable
    //   322	369	376	java/lang/Throwable
    //   207	219	380	finally
    //   238	243	380	finally
    //   251	263	380	finally
    //   278	283	380	finally
    //   207	219	388	java/lang/Throwable
    //   238	243	388	java/lang/Throwable
    //   251	263	388	java/lang/Throwable
    //   278	283	388	java/lang/Throwable
    //   126	137	396	finally
    //   190	195	396	finally
    //   126	137	404	java/lang/Throwable
    //   190	195	404	java/lang/Throwable
    //   0	30	438	finally
    //   36	52	438	finally
    //   55	61	438	finally
    //   64	77	438	finally
    //   77	89	438	finally
    //   92	100	438	finally
    //   0	30	447	java/lang/Throwable
    //   36	52	447	java/lang/Throwable
    //   55	61	447	java/lang/Throwable
    //   64	77	447	java/lang/Throwable
    //   77	89	447	java/lang/Throwable
    //   92	100	447	java/lang/Throwable
    //   453	458	502	finally
    //   477	482	502	finally
  }
  
  public final String b()
  {
    String str = "";
    List localList = this.b;
    Object localObject = str;
    if (localList != null)
    {
      localObject = str;
      if (localList.size() > 0)
      {
        localObject = this.b;
        localObject = (String)((List)localObject).get(((List)localObject).size() - 1);
      }
    }
    return lq.a((String)localObject, false);
  }
  
  public final String c()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i2 = this.b.size();
      int i1 = 0;
      while (i1 < i2 - 1)
      {
        ((StringBuilder)localObject).append(lq.a((String)this.b.get(i1), false));
        ((StringBuilder)localObject).append("-");
        i1 += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public final void d()
  {
    if (TextUtils.isEmpty(this.s)) {
      this.s = this.a;
    }
    e();
    int i1 = 0;
    if (i1 < this.u)
    {
      if (this.q.a()) {
        return;
      }
      this.e = 0;
      this.f = "";
    }
    for (;;)
    {
      try
      {
        this.v = new URL(this.s);
        Object localObject = lc.c();
        if (localObject != null) {}
        try
        {
          localObject = (HttpURLConnection)this.v.openConnection((Proxy)localObject);
          this.w = ((HttpURLConnection)localObject);
          continue;
          localObject = (HttpURLConnection)this.v.openConnection();
          continue;
          this.w.setConnectTimeout(kx.c());
          this.w.setReadTimeout(kx.d());
          this.w.setUseCaches(false);
          localObject = this.w;
          int i3 = 1;
          i2 = 1;
          ((HttpURLConnection)localObject).setDoInput(true);
          this.w.setInstanceFollowRedirects(false);
          g();
          try
          {
            int i4 = this.w.getResponseCode();
            this.A = true;
            if ((i4 != 200) && (i4 != 206)) {
              if (i4 != 307) {
                if ((i4 == 413) || (i4 == 500)) {}
              }
            }
            switch (i4)
            {
            case 301: 
              this.e = i4;
              break;
              if ((!lc.d()) || (this.g)) {
                continue;
              }
              if (this.c.a() <= 0) {
                break label878;
              }
              if (i2 == 0) {
                continue;
              }
              this.e = -59;
              break;
            case 302: 
            case 303: 
              localObject = this.w.getHeaderField("location");
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                this.e = -58;
                localObject = "location:".concat(String.valueOf(localObject));
                this.f = ((String)localObject);
                break;
              }
              this.s = ((String)localObject);
              if (this.b == null) {
                this.b = new ArrayList();
              }
              this.b.add(localObject);
              this.s = ((String)localObject);
              a((String)localObject);
              this.e = -57;
              break;
              this.i = this.w.getHeaderField("Content-Type");
              localObject = this.i;
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label888;
              }
              localObject = ((String)localObject).toLowerCase();
              if ((((String)localObject).startsWith("text/html")) || (((String)localObject).startsWith("text/vnd.wap.wml"))) {
                break label883;
              }
              if (!((String)localObject).startsWith("text/webviewhtml")) {
                break label888;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            a(localThrowable);
            break label798;
          }
          if (i2 != 0)
          {
            this.e = -11;
            localObject = this.s;
            continue;
          }
          this.j = this.w.getHeaderField("Content-Range");
          this.k = this.w.getHeaderField("Content-Length");
          if (this.c.a() <= 0) {
            break label893;
          }
          i2 = i3;
          if (i2 != 0)
          {
            if (!TextUtils.isEmpty(this.j))
            {
              this.o = b(this.j);
              if (this.o == -1L)
              {
                this.e = -54;
                localObject = new StringBuilder("content-range header:");
                ((StringBuilder)localObject).append(this.j);
                localObject = ((StringBuilder)localObject).toString();
              }
            }
            else
            {
              this.e = -53;
              break label798;
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.k)) {
              continue;
            }
            this.o = c(this.k);
            if (this.o == -1L)
            {
              this.e = -56;
              localObject = new StringBuilder("content-range header:");
              ((StringBuilder)localObject).append(this.k);
              localObject = ((StringBuilder)localObject).toString();
              continue;
            }
          }
          this.m = this.w.getHeaderField("etag");
          this.n = this.w.getHeaderField("Last-Modified");
          this.l = this.w.getHeaderField("Content-Disposition");
          break label798;
          this.e = -55;
        }
        catch (IOException localIOException)
        {
          a(localIOException);
          localIOException.printStackTrace();
        }
        if (i1 != 0) {
          break label836;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.e = -51;
        this.f = localMalformedURLException.getMessage();
        localMalformedURLException.printStackTrace();
      }
      label798:
      if (this.A) {
        try
        {
          this.h = InetAddress.getByName(this.v.getHost()).getHostAddress();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      label836:
      if (this.e == -57)
      {
        i1 += 1;
        break;
      }
      if ((i1 >= this.u) && (this.e == -57)) {
        this.e = -1;
      }
      return;
      continue;
      label878:
      int i2 = 0;
      continue;
      label883:
      i2 = 1;
      continue;
      label888:
      i2 = 0;
      continue;
      label893:
      i2 = 0;
    }
  }
  
  public final void e()
  {
    HttpURLConnection localHttpURLConnection = this.w;
    if (localHttpURLConnection != null) {}
    try
    {
      localHttpURLConnection.disconnect();
      this.x.close();
      label20:
      this.w = null;
      this.x = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label20;
    }
  }
  
  public final void f()
  {
    this.z = true;
  }
  
  public static final class a
  {
    public long a = 0L;
    public long b = 0L;
    
    public a(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b)) {
          return true;
        }
      }
      return false;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
  {
    List a = new ArrayList();
    
    public final int a()
    {
      return this.a.size();
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("bytes=");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ky.a locala = (ky.a)localIterator.next();
        localStringBuilder.append(locala.a);
        localStringBuilder.append("-");
        if (locala.b != -1L) {
          localStringBuilder.append(locala.b);
        }
        localStringBuilder.append(",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ky
 * JD-Core Version:    0.7.0.1
 */