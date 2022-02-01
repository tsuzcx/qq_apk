package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.halley.common.d;
import com.tencent.halley.common.h;
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

public abstract class m
  implements o
{
  private static String e = "CommReq";
  private boolean A = false;
  protected String a;
  protected Map b = null;
  public boolean c = false;
  public u d;
  private List f = null;
  private String g;
  private b h = new b();
  private int i = 0;
  private String j = "";
  private int k = 4096;
  private int l = 8;
  private String m = "";
  private URL n = null;
  private HttpURLConnection o = null;
  private InputStream p = null;
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  private long w = -1L;
  private List x = null;
  private long y = -1L;
  private volatile boolean z = false;
  
  private void a(String paramString)
  {
    Object localObject = "";
    HttpURLConnection localHttpURLConnection = this.o;
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
        this.x = new ArrayList();
        int i2 = localObject.length;
        i1 = 0;
        while (i1 < i2)
        {
          localHttpURLConnection = localObject[i1];
          List localList = this.x;
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
    b.a(e, "handleException:", paramThrowable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getName());
    localStringBuilder.append("|");
    localStringBuilder.append(paramThrowable);
    this.j = localStringBuilder.toString();
    int i1;
    if (this.z) {
      i1 = -66;
    }
    for (;;)
    {
      this.i = i1;
      return;
      if (!q.f()) {
        i1 = -15;
      } else if (q.h()) {
        i1 = -52;
      } else if (!d.a()) {
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
  
  private void s()
  {
    if (b.a(this.h).size() > 0) {
      this.o.addRequestProperty("Range", this.h.toString());
    }
    int i2 = 0;
    int i1 = 0;
    Object localObject = this.b;
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
        String str2 = (String)this.b.get(str1);
        this.o.addRequestProperty(str1, str2);
        if ("User-Agent".equalsIgnoreCase(str1)) {
          i1 = 1;
        }
      }
    }
    if (i2 == 0) {
      this.o.addRequestProperty("User-Agent", "HalleyService/2.0");
    }
  }
  
  public final int a()
  {
    return this.i;
  }
  
  public final String a(boolean paramBoolean)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i2 = this.f.size();
      int i1 = 0;
      while (i1 < i2 - 1)
      {
        ((StringBuilder)localObject).append(h.a((String)this.f.get(i1), false));
        ((StringBuilder)localObject).append("-");
        i1 += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public final void a(a parama)
  {
    this.h.a(parama);
  }
  
  /* Error */
  public final void a(n paramn)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 81	com/tencent/token/m:o	Ljava/net/HttpURLConnection;
    //   5: invokevirtual 323	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: putfield 83	com/tencent/token/m:p	Ljava/io/InputStream;
    //   11: aload_0
    //   12: getfield 61	com/tencent/token/m:h	Lcom/tencent/token/m$b;
    //   15: invokevirtual 326	com/tencent/token/m$b:b	()Lcom/tencent/token/m$a;
    //   18: astore 25
    //   20: aload 25
    //   22: ifnonnull +12 -> 34
    //   25: aload_0
    //   26: getfield 99	com/tencent/token/m:w	J
    //   29: lstore 17
    //   31: goto +31 -> 62
    //   34: aload 25
    //   36: getfield 328	com/tencent/token/m$a:b	J
    //   39: lstore_3
    //   40: aload 25
    //   42: getfield 330	com/tencent/token/m$a:a	J
    //   45: lstore 5
    //   47: aload 25
    //   49: getfield 328	com/tencent/token/m$a:b	J
    //   52: ldc2_w 96
    //   55: lcmp
    //   56: ifne +617 -> 673
    //   59: goto -34 -> 25
    //   62: aload_0
    //   63: getfield 71	com/tencent/token/m:k	I
    //   66: newarray byte
    //   68: astore 25
    //   70: lconst_0
    //   71: lstore 19
    //   73: lconst_0
    //   74: lstore 5
    //   76: lconst_0
    //   77: lstore_3
    //   78: iconst_1
    //   79: istore 21
    //   81: iconst_1
    //   82: istore 22
    //   84: lload 19
    //   86: lload 17
    //   88: lcmp
    //   89: ifge +466 -> 555
    //   92: aload_0
    //   93: getfield 332	com/tencent/token/m:d	Lcom/tencent/token/u;
    //   96: invokeinterface 335 1 0
    //   101: istore 23
    //   103: iload 23
    //   105: ifeq +35 -> 140
    //   108: aload_0
    //   109: invokevirtual 337	com/tencent/token/m:q	()V
    //   112: aload_0
    //   113: getfield 103	com/tencent/token/m:y	J
    //   116: lstore 7
    //   118: lload 5
    //   120: lload_3
    //   121: lsub
    //   122: lstore 5
    //   124: lload 7
    //   126: lstore_3
    //   127: lload_3
    //   128: lload 5
    //   130: invokestatic 343	java/lang/Math:max	(JJ)J
    //   133: lstore_3
    //   134: aload_0
    //   135: lload_3
    //   136: putfield 103	com/tencent/token/m:y	J
    //   139: return
    //   140: iload 21
    //   142: ifne +6 -> 148
    //   145: goto -37 -> 108
    //   148: aload_0
    //   149: getfield 71	com/tencent/token/m:k	I
    //   152: istore_2
    //   153: iload_2
    //   154: i2l
    //   155: lstore 7
    //   157: lload_3
    //   158: lstore 13
    //   160: lload 5
    //   162: lstore 9
    //   164: lload_3
    //   165: lstore 15
    //   167: lload 5
    //   169: lstore 11
    //   171: lload 7
    //   173: lload 17
    //   175: lload 19
    //   177: lsub
    //   178: invokestatic 346	java/lang/Math:min	(JJ)J
    //   181: l2i
    //   182: istore_2
    //   183: lload_3
    //   184: lstore 7
    //   186: lload 19
    //   188: lconst_0
    //   189: lcmp
    //   190: ifne +22 -> 212
    //   193: lload_3
    //   194: lstore 13
    //   196: lload 5
    //   198: lstore 9
    //   200: lload_3
    //   201: lstore 15
    //   203: lload 5
    //   205: lstore 11
    //   207: invokestatic 351	android/os/SystemClock:elapsedRealtime	()J
    //   210: lstore 7
    //   212: lload 7
    //   214: lstore 13
    //   216: lload 5
    //   218: lstore 9
    //   220: lload 7
    //   222: lstore 15
    //   224: lload 5
    //   226: lstore 11
    //   228: aload_0
    //   229: getfield 83	com/tencent/token/m:p	Ljava/io/InputStream;
    //   232: aload 25
    //   234: iconst_0
    //   235: iload_2
    //   236: invokevirtual 357	java/io/InputStream:read	([BII)I
    //   239: istore_2
    //   240: lload 5
    //   242: lstore_3
    //   243: lload 19
    //   245: lconst_0
    //   246: lcmp
    //   247: ifne +23 -> 270
    //   250: lload 7
    //   252: lstore 13
    //   254: lload 5
    //   256: lstore 9
    //   258: lload 7
    //   260: lstore 15
    //   262: lload 5
    //   264: lstore 11
    //   266: invokestatic 351	android/os/SystemClock:elapsedRealtime	()J
    //   269: lstore_3
    //   270: iload_2
    //   271: iconst_m1
    //   272: if_icmpeq +97 -> 369
    //   275: aload_1
    //   276: ifnull +59 -> 335
    //   279: lload 7
    //   281: lstore 13
    //   283: lload_3
    //   284: lstore 9
    //   286: lload 7
    //   288: lstore 15
    //   290: lload_3
    //   291: lstore 11
    //   293: aload_0
    //   294: getfield 332	com/tencent/token/m:d	Lcom/tencent/token/u;
    //   297: invokeinterface 335 1 0
    //   302: ifne +380 -> 682
    //   305: lload 7
    //   307: lstore 13
    //   309: lload_3
    //   310: lstore 9
    //   312: lload 7
    //   314: lstore 15
    //   316: lload_3
    //   317: lstore 11
    //   319: aload_1
    //   320: aload 25
    //   322: iload_2
    //   323: iload 22
    //   325: invokeinterface 362 4 0
    //   330: istore 21
    //   332: goto +350 -> 682
    //   335: lload 7
    //   337: lstore 13
    //   339: lload_3
    //   340: lstore 9
    //   342: lload 7
    //   344: lstore 15
    //   346: lload_3
    //   347: lstore 11
    //   349: getstatic 191	com/tencent/token/m:e	Ljava/lang/String;
    //   352: ldc_w 364
    //   355: invokestatic 366	com/tencent/halley/common/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: iload 21
    //   360: istore 24
    //   362: iload 22
    //   364: istore 23
    //   366: goto +336 -> 702
    //   369: lload 7
    //   371: lstore 13
    //   373: lload_3
    //   374: lstore 9
    //   376: lload 7
    //   378: lstore 15
    //   380: lload_3
    //   381: lstore 11
    //   383: aload_0
    //   384: bipush 194
    //   386: putfield 65	com/tencent/token/m:i	I
    //   389: lload 7
    //   391: lstore 13
    //   393: lload_3
    //   394: lstore 9
    //   396: lload 7
    //   398: lstore 15
    //   400: lload_3
    //   401: lstore 11
    //   403: new 170	java/lang/StringBuilder
    //   406: dup
    //   407: ldc_w 368
    //   410: invokespecial 369	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: astore_1
    //   414: lload 7
    //   416: lstore 13
    //   418: lload_3
    //   419: lstore 9
    //   421: lload 7
    //   423: lstore 15
    //   425: lload_3
    //   426: lstore 11
    //   428: aload_1
    //   429: lload 19
    //   431: invokevirtual 372	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: lload 7
    //   437: lstore 13
    //   439: lload_3
    //   440: lstore 9
    //   442: lload 7
    //   444: lstore 15
    //   446: lload_3
    //   447: lstore 11
    //   449: aload_1
    //   450: ldc_w 374
    //   453: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: lload 7
    //   459: lstore 13
    //   461: lload_3
    //   462: lstore 9
    //   464: lload 7
    //   466: lstore 15
    //   468: lload_3
    //   469: lstore 11
    //   471: aload_1
    //   472: lload 17
    //   474: invokevirtual 372	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: lload 7
    //   480: lstore 13
    //   482: lload_3
    //   483: lstore 9
    //   485: lload 7
    //   487: lstore 15
    //   489: lload_3
    //   490: lstore 11
    //   492: aload_0
    //   493: aload_1
    //   494: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: putfield 69	com/tencent/token/m:j	Ljava/lang/String;
    //   500: aload_0
    //   501: invokevirtual 337	com/tencent/token/m:q	()V
    //   504: aload_0
    //   505: getfield 103	com/tencent/token/m:y	J
    //   508: lload_3
    //   509: lload 7
    //   511: lsub
    //   512: invokestatic 343	java/lang/Math:max	(JJ)J
    //   515: lstore_3
    //   516: goto -382 -> 134
    //   519: astore_1
    //   520: lload 13
    //   522: lstore_3
    //   523: lload 9
    //   525: lstore 5
    //   527: goto +125 -> 652
    //   530: astore_1
    //   531: lload 15
    //   533: lstore_3
    //   534: goto +12 -> 546
    //   537: astore_1
    //   538: goto +114 -> 652
    //   541: astore_1
    //   542: lload 5
    //   544: lstore 11
    //   546: lload_3
    //   547: lstore 5
    //   549: lload 11
    //   551: lstore_3
    //   552: goto +40 -> 592
    //   555: aload_0
    //   556: invokevirtual 337	com/tencent/token/m:q	()V
    //   559: aload_0
    //   560: getfield 103	com/tencent/token/m:y	J
    //   563: lstore 7
    //   565: lload 5
    //   567: lload_3
    //   568: lsub
    //   569: lstore 5
    //   571: lload 7
    //   573: lstore_3
    //   574: goto -447 -> 127
    //   577: astore_1
    //   578: lconst_0
    //   579: lstore_3
    //   580: lconst_0
    //   581: lstore 5
    //   583: goto +69 -> 652
    //   586: astore_1
    //   587: lconst_0
    //   588: lstore 5
    //   590: lconst_0
    //   591: lstore_3
    //   592: aload_0
    //   593: aload_1
    //   594: invokespecial 376	com/tencent/token/m:a	(Ljava/lang/Throwable;)V
    //   597: lload_3
    //   598: lstore 7
    //   600: lload 5
    //   602: lconst_0
    //   603: lcmp
    //   604: ifeq +17 -> 621
    //   607: lload_3
    //   608: lstore 7
    //   610: lload_3
    //   611: lconst_0
    //   612: lcmp
    //   613: ifne +8 -> 621
    //   616: invokestatic 351	android/os/SystemClock:elapsedRealtime	()J
    //   619: lstore 7
    //   621: aload_0
    //   622: invokevirtual 337	com/tencent/token/m:q	()V
    //   625: aload_0
    //   626: getfield 103	com/tencent/token/m:y	J
    //   629: lload 7
    //   631: lload 5
    //   633: lsub
    //   634: invokestatic 343	java/lang/Math:max	(JJ)J
    //   637: lstore_3
    //   638: goto -504 -> 134
    //   641: astore_1
    //   642: lload 5
    //   644: lstore 7
    //   646: lload_3
    //   647: lstore 5
    //   649: lload 7
    //   651: lstore_3
    //   652: aload_0
    //   653: invokevirtual 337	com/tencent/token/m:q	()V
    //   656: aload_0
    //   657: aload_0
    //   658: getfield 103	com/tencent/token/m:y	J
    //   661: lload 5
    //   663: lload_3
    //   664: lsub
    //   665: invokestatic 343	java/lang/Math:max	(JJ)J
    //   668: putfield 103	com/tencent/token/m:y	J
    //   671: aload_1
    //   672: athrow
    //   673: lload_3
    //   674: lload 5
    //   676: lsub
    //   677: lstore 17
    //   679: goto -617 -> 62
    //   682: iload 21
    //   684: istore 24
    //   686: iload 22
    //   688: istore 23
    //   690: iload 22
    //   692: ifeq +10 -> 702
    //   695: iconst_0
    //   696: istore 23
    //   698: iload 21
    //   700: istore 24
    //   702: lload 19
    //   704: iload_2
    //   705: i2l
    //   706: ladd
    //   707: lstore 19
    //   709: lload_3
    //   710: lstore 5
    //   712: lload 7
    //   714: lstore_3
    //   715: iload 24
    //   717: istore 21
    //   719: iload 23
    //   721: istore 22
    //   723: goto -639 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	m
    //   0	726	1	paramn	n
    //   152	553	2	i1	int
    //   39	676	3	l1	long
    //   45	666	5	l2	long
    //   116	597	7	l3	long
    //   162	362	9	l4	long
    //   169	381	11	l5	long
    //   158	363	13	l6	long
    //   165	367	15	l7	long
    //   29	649	17	l8	long
    //   71	637	19	l9	long
    //   79	639	21	bool1	boolean
    //   82	640	22	bool2	boolean
    //   101	619	23	bool3	boolean
    //   360	356	24	bool4	boolean
    //   18	303	25	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   171	183	519	finally
    //   207	212	519	finally
    //   228	240	519	finally
    //   266	270	519	finally
    //   293	305	519	finally
    //   319	332	519	finally
    //   349	358	519	finally
    //   383	389	519	finally
    //   403	414	519	finally
    //   428	435	519	finally
    //   449	457	519	finally
    //   471	478	519	finally
    //   492	500	519	finally
    //   171	183	530	java/lang/Throwable
    //   207	212	530	java/lang/Throwable
    //   228	240	530	java/lang/Throwable
    //   266	270	530	java/lang/Throwable
    //   293	305	530	java/lang/Throwable
    //   319	332	530	java/lang/Throwable
    //   349	358	530	java/lang/Throwable
    //   383	389	530	java/lang/Throwable
    //   403	414	530	java/lang/Throwable
    //   428	435	530	java/lang/Throwable
    //   449	457	530	java/lang/Throwable
    //   471	478	530	java/lang/Throwable
    //   492	500	530	java/lang/Throwable
    //   92	103	537	finally
    //   148	153	537	finally
    //   92	103	541	java/lang/Throwable
    //   148	153	541	java/lang/Throwable
    //   0	20	577	finally
    //   25	31	577	finally
    //   34	59	577	finally
    //   62	70	577	finally
    //   0	20	586	java/lang/Throwable
    //   25	31	586	java/lang/Throwable
    //   34	59	586	java/lang/Throwable
    //   62	70	586	java/lang/Throwable
    //   592	597	641	finally
    //   616	621	641	finally
  }
  
  public final String b()
  {
    return this.j;
  }
  
  public final long c()
  {
    return this.w;
  }
  
  public final String d()
  {
    return h.a(this.g, false);
  }
  
  public final String e()
  {
    List localList = this.f;
    if ((localList != null) && (localList.size() > 0))
    {
      localList = this.f;
      return (String)localList.get(localList.size() - 1);
    }
    return null;
  }
  
  public final String f()
  {
    String str = "";
    List localList = this.f;
    Object localObject = str;
    if (localList != null)
    {
      localObject = str;
      if (localList.size() > 0)
      {
        localObject = this.f;
        localObject = (String)((List)localObject).get(((List)localObject).size() - 1);
      }
    }
    return h.a((String)localObject, false);
  }
  
  public final String g()
  {
    return this.m;
  }
  
  public final String h()
  {
    return this.q;
  }
  
  public final String i()
  {
    return this.r;
  }
  
  public final String j()
  {
    return this.s;
  }
  
  public final String k()
  {
    return this.u;
  }
  
  public final String l()
  {
    return this.v;
  }
  
  public final String m()
  {
    return this.t;
  }
  
  public final List n()
  {
    return this.x;
  }
  
  public final boolean o()
  {
    return this.h.a() > 0;
  }
  
  public final void p()
  {
    if (TextUtils.isEmpty(this.g)) {
      this.g = this.a;
    }
    q();
    int i1 = 0;
    if (i1 < this.l)
    {
      if (this.d.a()) {
        return;
      }
      this.i = 0;
      this.j = "";
    }
    for (;;)
    {
      try
      {
        this.n = new URL(this.g);
        Object localObject = q.c();
        if (localObject != null) {}
        try
        {
          localObject = (HttpURLConnection)this.n.openConnection((Proxy)localObject);
          this.o = ((HttpURLConnection)localObject);
          continue;
          localObject = (HttpURLConnection)this.n.openConnection();
          continue;
          this.o.setConnectTimeout(l.c());
          this.o.setReadTimeout(l.d());
          this.o.setUseCaches(false);
          localObject = this.o;
          int i3 = 1;
          i2 = 1;
          ((HttpURLConnection)localObject).setDoInput(true);
          this.o.setInstanceFollowRedirects(false);
          s();
          try
          {
            int i4 = this.o.getResponseCode();
            this.A = true;
            if ((i4 != 200) && (i4 != 206)) {
              if (i4 != 307) {
                if ((i4 == 413) || (i4 == 500)) {}
              }
            }
            switch (i4)
            {
            case 301: 
              this.i = i4;
              continue;
              if ((!q.d()) || (this.c)) {
                continue;
              }
              if (this.h.a() <= 0) {
                break label897;
              }
              if (i2 == 0) {
                continue;
              }
              this.i = -59;
              break;
            case 302: 
            case 303: 
              localObject = this.o.getHeaderField("location");
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                this.i = -58;
                StringBuilder localStringBuilder = new StringBuilder("location:");
                localStringBuilder.append((String)localObject);
                localObject = localStringBuilder.toString();
                this.j = ((String)localObject);
                continue;
              }
              this.g = ((String)localObject);
              if (this.f == null) {
                this.f = new ArrayList();
              }
              this.f.add(localObject);
              this.g = ((String)localObject);
              a((String)localObject);
              this.i = -57;
              continue;
              this.q = this.o.getHeaderField("Content-Type");
              localObject = this.q;
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label907;
              }
              localObject = ((String)localObject).toLowerCase();
              if ((((String)localObject).startsWith("text/html")) || (((String)localObject).startsWith("text/vnd.wap.wml"))) {
                break label902;
              }
              if (!((String)localObject).startsWith("text/webviewhtml")) {
                break label907;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            a(localThrowable);
          }
          if (i2 != 0)
          {
            this.i = -11;
            localObject = this.g;
            continue;
          }
          this.r = this.o.getHeaderField("Content-Range");
          this.s = this.o.getHeaderField("Content-Length");
          if (this.h.a() <= 0) {
            break label912;
          }
          i2 = i3;
          if (i2 != 0)
          {
            if (!TextUtils.isEmpty(this.r))
            {
              this.w = b(this.r);
              if (this.w == -1L)
              {
                this.i = -54;
                localObject = new StringBuilder("content-range header:");
                ((StringBuilder)localObject).append(this.r);
                localObject = ((StringBuilder)localObject).toString();
              }
            }
            else
            {
              this.i = -53;
              continue;
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.s)) {
              continue;
            }
            this.w = c(this.s);
            if (this.w == -1L)
            {
              this.i = -56;
              localObject = new StringBuilder("content-range header:");
              ((StringBuilder)localObject).append(this.s);
              localObject = ((StringBuilder)localObject).toString();
              continue;
            }
          }
          this.u = this.o.getHeaderField("etag");
          this.v = this.o.getHeaderField("Last-Modified");
          this.t = this.o.getHeaderField("Content-Disposition");
          continue;
          this.i = -55;
          i2 = this.i;
        }
        catch (IOException localIOException)
        {
          a(localIOException);
          localIOException.printStackTrace();
        }
        if (i1 != 0) {
          break label855;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.i = -51;
        this.j = localMalformedURLException.getMessage();
        localMalformedURLException.printStackTrace();
      }
      if (this.A) {
        try
        {
          this.m = InetAddress.getByName(this.n.getHost()).getHostAddress();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      label855:
      if (this.i == -57)
      {
        i1 += 1;
        break;
      }
      if ((i1 >= this.l) && (this.i == -57)) {
        this.i = -1;
      }
      return;
      continue;
      label897:
      int i2 = 0;
      continue;
      label902:
      i2 = 1;
      continue;
      label907:
      i2 = 0;
      continue;
      label912:
      i2 = 0;
    }
  }
  
  public final void q()
  {
    HttpURLConnection localHttpURLConnection = this.o;
    if (localHttpURLConnection != null) {}
    try
    {
      localHttpURLConnection.disconnect();
      this.p.close();
      label20:
      this.o = null;
      this.p = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label20;
    }
  }
  
  public final void r()
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
    private List a = new ArrayList();
    
    public final int a()
    {
      return this.a.size();
    }
    
    public final void a(m.a parama)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((m.a)localIterator.next()).equals(parama))
        {
          i = 1;
          break label42;
        }
      }
      int i = 0;
      label42:
      if (i == 0) {
        this.a.add(parama);
      }
    }
    
    public final m.a b()
    {
      if (this.a.size() == 0) {
        return null;
      }
      return (m.a)this.a.get(0);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("bytes=");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        m.a locala = (m.a)localIterator.next();
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
 * Qualified Name:     com.tencent.token.m
 * JD-Core Version:    0.7.0.1
 */