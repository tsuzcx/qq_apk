package com.tencent.token;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.halley.common.d;
import com.tencent.halley.common.h;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class l
  implements n
{
  private static String e = "CommReq";
  private boolean A = false;
  protected String a;
  protected Map b = null;
  public boolean c = false;
  public t d;
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
    if (this.o != null) {
      localObject = this.o.getHeaderField("X-Extra-Servers");
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        boolean bool = "http".equals(new URL(paramString).getProtocol());
        if ((!bool) || (!paramString.startsWith("http://"))) {
          continue;
        }
        int i1 = "http://".length();
        int i2 = paramString.indexOf("/", i1);
        if (i2 == -1) {
          continue;
        }
        paramString.substring(i1, i2);
        paramString = paramString.substring(i2);
        localObject = ((String)localObject).split(";");
        if ((localObject == null) || (localObject.length <= 0)) {
          continue;
        }
        this.x = new ArrayList();
        i2 = localObject.length;
        i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1];
          this.x.add("http://" + str + paramString);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    b.a(e, "handleException:", paramThrowable);
    this.j = (paramThrowable.getClass().getName() + "|" + paramThrowable);
    if (this.z)
    {
      this.i = -66;
      return;
    }
    if (!p.f())
    {
      this.i = -15;
      return;
    }
    if (p.h())
    {
      this.i = -52;
      return;
    }
    if (!d.a())
    {
      this.i = -16;
      return;
    }
    this.i = b(paramThrowable);
  }
  
  private static int b(Throwable paramThrowable)
  {
    int i2 = -48;
    try
    {
      boolean bool = paramThrowable.getMessage().contains("Permission");
      if (!bool) {
        break label24;
      }
      i1 = -71;
    }
    catch (Throwable localThrowable)
    {
      label24:
      do
      {
        do
        {
          if (!(paramThrowable instanceof Exception)) {
            return -70;
          }
          i1 = i2;
        } while (paramThrowable == null);
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
        int i1 = i2;
      } while (!(paramThrowable instanceof IOException));
    }
    return i1;
    return -27;
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
    int i2;
    if (this.b != null)
    {
      Iterator localIterator = this.b.keySet().iterator();
      int i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label123;
      }
      String str1 = (String)localIterator.next();
      String str2 = (String)this.b.get(str1);
      this.o.addRequestProperty(str1, str2);
      if (!"User-Agent".equalsIgnoreCase(str1)) {
        break label141;
      }
      i1 = 1;
    }
    label141:
    for (;;)
    {
      break;
      i2 = 0;
      label123:
      if (i2 == 0) {
        this.o.addRequestProperty("User-Agent", "HalleyService/2.0");
      }
      return;
    }
  }
  
  public final int a()
  {
    return this.i;
  }
  
  public final String a(boolean paramBoolean)
  {
    if ((this.f == null) || (this.f.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2 - 1)
    {
      localStringBuilder.append(h.a((String)this.f.get(i1), false)).append("-");
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final void a(a parama)
  {
    this.h.a(parama);
  }
  
  public final void a(m paramm)
  {
    long l7 = 0L;
    long l5 = 0L;
    long l3 = l5;
    long l1 = l7;
    long l2 = l5;
    long l4 = l7;
    for (;;)
    {
      long l9;
      long l6;
      int i1;
      try
      {
        this.p = this.o.getInputStream();
        l3 = l5;
        l1 = l7;
        l2 = l5;
        l4 = l7;
        Object localObject = this.h.b();
        if (localObject == null)
        {
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          l8 = this.w;
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          localObject = new byte[this.k];
          l9 = 0L;
          bool2 = true;
          bool1 = true;
          if (l9 >= l8) {
            continue;
          }
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          bool3 = this.d.a();
          if (bool3)
          {
            q();
            this.y = Math.max(this.y, l5 - l7);
          }
        }
        else
        {
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          l6 = ((a)localObject).b;
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          l8 = ((a)localObject).a;
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          if (((a)localObject).b != -1L) {
            break label712;
          }
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          l8 = this.w;
          continue;
        }
        if (!bool1)
        {
          q();
          this.y = Math.max(this.y, l5 - l7);
          return;
        }
        l3 = l5;
        l1 = l7;
        l2 = l5;
        l4 = l7;
        i1 = (int)Math.min(this.k, l8 - l9);
        l6 = l7;
        if (l9 == 0L)
        {
          l3 = l5;
          l1 = l7;
          l2 = l5;
          l4 = l7;
          l6 = SystemClock.elapsedRealtime();
        }
        l3 = l5;
        l1 = l6;
        l2 = l5;
        l4 = l6;
        i1 = this.p.read((byte[])localObject, 0, i1);
        l7 = l5;
        if (l9 == 0L)
        {
          l3 = l5;
          l1 = l6;
          l2 = l5;
          l4 = l6;
          l7 = SystemClock.elapsedRealtime();
        }
        if (i1 != -1)
        {
          if (paramm != null)
          {
            l3 = l7;
            l1 = l6;
            l2 = l7;
            l4 = l6;
            if (this.d.a()) {
              break label722;
            }
            l3 = l7;
            l1 = l6;
            l2 = l7;
            l4 = l6;
            bool1 = paramm.a((byte[])localObject, i1, bool2);
            break label722;
          }
          l3 = l7;
          l1 = l6;
          l2 = l7;
          l4 = l6;
          b.d(e, "dataReceiver is null");
          bool4 = bool1;
          bool3 = bool2;
        }
      }
      catch (Throwable paramm)
      {
        try
        {
          a(paramm);
          l2 = l3;
          if (l1 != 0L)
          {
            l2 = l3;
            if (l3 == 0L) {
              l2 = SystemClock.elapsedRealtime();
            }
          }
          q();
          this.y = Math.max(this.y, l2 - l1);
          return;
        }
        finally
        {
          l2 = l3;
          continue;
        }
        l3 = l7;
        l1 = l6;
        l2 = l7;
        l4 = l6;
        this.i = -62;
        l3 = l7;
        l1 = l6;
        l2 = l7;
        l4 = l6;
        this.j = ("readLen:" + l9 + ",dataLen:" + l8);
        q();
        this.y = Math.max(this.y, l7 - l6);
        return;
        q();
        this.y = Math.max(this.y, l5 - l7);
        return;
      }
      finally
      {
        l1 = l4;
        q();
        this.y = Math.max(this.y, l2 - l1);
      }
      label712:
      long l8 = l6 - l8;
      continue;
      label722:
      boolean bool4 = bool1;
      boolean bool3 = bool2;
      if (bool2)
      {
        bool3 = false;
        bool4 = bool1;
      }
      l9 += i1;
      boolean bool1 = bool4;
      boolean bool2 = bool3;
      l5 = l7;
      l7 = l6;
    }
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
    if ((this.f != null) && (this.f.size() > 0)) {
      return (String)this.f.get(this.f.size() - 1);
    }
    return null;
  }
  
  public final String f()
  {
    String str2 = "";
    String str1 = str2;
    if (this.f != null)
    {
      str1 = str2;
      if (this.f.size() > 0) {
        str1 = (String)this.f.get(this.f.size() - 1);
      }
    }
    return h.a(str1, false);
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
  
  /* Error */
  public final void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   4: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +11 -> 18
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 388	com/tencent/token/l:a	Ljava/lang/String;
    //   15: putfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   18: aload_0
    //   19: invokevirtual 336	com/tencent/token/l:q	()V
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 77	com/tencent/token/l:l	I
    //   29: if_icmpge +824 -> 853
    //   32: aload_0
    //   33: getfield 331	com/tencent/token/l:d	Lcom/tencent/token/t;
    //   36: invokeinterface 334 1 0
    //   41: ifeq +4 -> 45
    //   44: return
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 67	com/tencent/token/l:i	I
    //   50: aload_0
    //   51: ldc 69
    //   53: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   56: aload_0
    //   57: new 130	java/net/URL
    //   60: dup
    //   61: aload_0
    //   62: getfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   65: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: putfield 81	com/tencent/token/l:n	Ljava/net/URL;
    //   71: invokestatic 391	com/tencent/token/p:c	()Ljava/net/Proxy;
    //   74: astore 4
    //   76: aload 4
    //   78: ifnull +233 -> 311
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 81	com/tencent/token/l:n	Ljava/net/URL;
    //   86: aload 4
    //   88: invokevirtual 395	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   91: checkcast 116	java/net/HttpURLConnection
    //   94: putfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   97: aload_0
    //   98: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   101: invokestatic 399	com/tencent/token/k:c	()I
    //   104: invokevirtual 403	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   107: aload_0
    //   108: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   111: invokestatic 405	com/tencent/token/k:d	()I
    //   114: invokevirtual 408	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   117: aload_0
    //   118: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   121: iconst_0
    //   122: invokevirtual 412	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   125: aload_0
    //   126: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   129: iconst_1
    //   130: invokevirtual 415	java/net/HttpURLConnection:setDoInput	(Z)V
    //   133: aload_0
    //   134: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   137: iconst_0
    //   138: invokevirtual 418	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   141: aload_0
    //   142: invokespecial 420	com/tencent/token/l:s	()V
    //   145: aload_0
    //   146: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   149: invokevirtual 423	java/net/HttpURLConnection:getResponseCode	()I
    //   152: istore_3
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 109	com/tencent/token/l:A	Z
    //   158: iload_3
    //   159: lookupswitch	default:+717->876, 200:+185->344, 206:+185->344, 301:+530->689, 302:+530->689, 303:+530->689, 307:+530->689, 413:+638->797, 500:+638->797
    //   233: iload_3
    //   234: putfield 67	com/tencent/token/l:i	I
    //   237: aload_0
    //   238: getfield 67	com/tencent/token/l:i	I
    //   241: istore_2
    //   242: iload_1
    //   243: ifne +27 -> 270
    //   246: aload_0
    //   247: getfield 109	com/tencent/token/l:A	Z
    //   250: ifeq +20 -> 270
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 81	com/tencent/token/l:n	Ljava/net/URL;
    //   258: invokevirtual 426	java/net/URL:getHost	()Ljava/lang/String;
    //   261: invokestatic 432	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   264: invokevirtual 435	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   267: putfield 79	com/tencent/token/l:m	Ljava/lang/String;
    //   270: aload_0
    //   271: getfield 67	com/tencent/token/l:i	I
    //   274: bipush 199
    //   276: if_icmpne +577 -> 853
    //   279: iload_1
    //   280: iconst_1
    //   281: iadd
    //   282: istore_1
    //   283: goto -259 -> 24
    //   286: astore 4
    //   288: aload_0
    //   289: bipush 205
    //   291: putfield 67	com/tencent/token/l:i	I
    //   294: aload_0
    //   295: aload 4
    //   297: invokevirtual 436	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   300: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   303: aload 4
    //   305: invokevirtual 437	java/net/MalformedURLException:printStackTrace	()V
    //   308: goto -66 -> 242
    //   311: aload_0
    //   312: aload_0
    //   313: getfield 81	com/tencent/token/l:n	Ljava/net/URL;
    //   316: invokevirtual 440	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   319: checkcast 116	java/net/HttpURLConnection
    //   322: putfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   325: goto -228 -> 97
    //   328: astore 4
    //   330: aload_0
    //   331: aload 4
    //   333: invokespecial 371	com/tencent/token/l:a	(Ljava/lang/Throwable;)V
    //   336: aload 4
    //   338: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   341: goto -99 -> 242
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   349: ldc_w 443
    //   352: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 87	com/tencent/token/l:q	Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 87	com/tencent/token/l:q	Ljava/lang/String;
    //   362: astore 4
    //   364: aload 4
    //   366: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   369: ifne +78 -> 447
    //   372: aload 4
    //   374: invokevirtual 446	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   377: astore 4
    //   379: aload 4
    //   381: ldc_w 448
    //   384: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   387: ifne +492 -> 879
    //   390: aload 4
    //   392: ldc_w 450
    //   395: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   398: ifne +481 -> 879
    //   401: aload 4
    //   403: ldc_w 452
    //   406: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   409: ifeq +38 -> 447
    //   412: goto +467 -> 879
    //   415: iload_2
    //   416: ifeq +36 -> 452
    //   419: aload_0
    //   420: bipush 245
    //   422: putfield 67	com/tencent/token/l:i	I
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   430: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   433: goto -196 -> 237
    //   436: astore 4
    //   438: aload_0
    //   439: aload 4
    //   441: invokespecial 371	com/tencent/token/l:a	(Ljava/lang/Throwable;)V
    //   444: goto -207 -> 237
    //   447: iconst_0
    //   448: istore_2
    //   449: goto -34 -> 415
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   457: ldc_w 454
    //   460: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   463: putfield 89	com/tencent/token/l:r	Ljava/lang/String;
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   471: ldc_w 456
    //   474: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   477: putfield 91	com/tencent/token/l:s	Ljava/lang/String;
    //   480: aload_0
    //   481: getfield 63	com/tencent/token/l:h	Lcom/tencent/token/l$b;
    //   484: invokevirtual 384	com/tencent/token/l$b:a	()I
    //   487: ifle +397 -> 884
    //   490: iconst_1
    //   491: istore_2
    //   492: iload_2
    //   493: ifeq +77 -> 570
    //   496: aload_0
    //   497: getfield 89	com/tencent/token/l:r	Ljava/lang/String;
    //   500: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +58 -> 561
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 89	com/tencent/token/l:r	Ljava/lang/String;
    //   511: invokestatic 458	com/tencent/token/l:b	(Ljava/lang/String;)J
    //   514: putfield 101	com/tencent/token/l:w	J
    //   517: aload_0
    //   518: getfield 101	com/tencent/token/l:w	J
    //   521: ldc2_w 98
    //   524: lcmp
    //   525: ifne +119 -> 644
    //   528: aload_0
    //   529: bipush 202
    //   531: putfield 67	com/tencent/token/l:i	I
    //   534: aload_0
    //   535: new 176	java/lang/StringBuilder
    //   538: dup
    //   539: ldc_w 460
    //   542: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: aload_0
    //   546: getfield 89	com/tencent/token/l:r	Ljava/lang/String;
    //   549: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   558: goto -321 -> 237
    //   561: aload_0
    //   562: bipush 203
    //   564: putfield 67	com/tencent/token/l:i	I
    //   567: goto -330 -> 237
    //   570: aload_0
    //   571: getfield 91	com/tencent/token/l:s	Ljava/lang/String;
    //   574: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   577: ifne +58 -> 635
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 91	com/tencent/token/l:s	Ljava/lang/String;
    //   585: invokestatic 462	com/tencent/token/l:c	(Ljava/lang/String;)J
    //   588: putfield 101	com/tencent/token/l:w	J
    //   591: aload_0
    //   592: getfield 101	com/tencent/token/l:w	J
    //   595: ldc2_w 98
    //   598: lcmp
    //   599: ifne +45 -> 644
    //   602: aload_0
    //   603: bipush 200
    //   605: putfield 67	com/tencent/token/l:i	I
    //   608: aload_0
    //   609: new 176	java/lang/StringBuilder
    //   612: dup
    //   613: ldc_w 460
    //   616: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   619: aload_0
    //   620: getfield 91	com/tencent/token/l:s	Ljava/lang/String;
    //   623: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   632: goto -395 -> 237
    //   635: aload_0
    //   636: bipush 201
    //   638: putfield 67	com/tencent/token/l:i	I
    //   641: goto -404 -> 237
    //   644: aload_0
    //   645: aload_0
    //   646: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   649: ldc_w 464
    //   652: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 95	com/tencent/token/l:u	Ljava/lang/String;
    //   658: aload_0
    //   659: aload_0
    //   660: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   663: ldc_w 466
    //   666: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   669: putfield 97	com/tencent/token/l:v	Ljava/lang/String;
    //   672: aload_0
    //   673: aload_0
    //   674: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   677: ldc_w 468
    //   680: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   683: putfield 93	com/tencent/token/l:t	Ljava/lang/String;
    //   686: goto -449 -> 237
    //   689: aload_0
    //   690: getfield 83	com/tencent/token/l:o	Ljava/net/HttpURLConnection;
    //   693: ldc_w 470
    //   696: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   699: astore 4
    //   701: aload 4
    //   703: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   706: ifeq +34 -> 740
    //   709: aload_0
    //   710: bipush 198
    //   712: putfield 67	com/tencent/token/l:i	I
    //   715: aload_0
    //   716: new 176	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 472
    //   723: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 4
    //   728: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: putfield 71	com/tencent/token/l:j	Ljava/lang/String;
    //   737: goto -500 -> 237
    //   740: aload_0
    //   741: aload 4
    //   743: putfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   746: aload_0
    //   747: getfield 60	com/tencent/token/l:f	Ljava/util/List;
    //   750: ifnonnull +14 -> 764
    //   753: aload_0
    //   754: new 173	java/util/ArrayList
    //   757: dup
    //   758: invokespecial 174	java/util/ArrayList:<init>	()V
    //   761: putfield 60	com/tencent/token/l:f	Ljava/util/List;
    //   764: aload_0
    //   765: getfield 60	com/tencent/token/l:f	Ljava/util/List;
    //   768: aload 4
    //   770: invokeinterface 189 2 0
    //   775: pop
    //   776: aload_0
    //   777: aload 4
    //   779: putfield 381	com/tencent/token/l:g	Ljava/lang/String;
    //   782: aload_0
    //   783: aload 4
    //   785: invokespecial 474	com/tencent/token/l:a	(Ljava/lang/String;)V
    //   788: aload_0
    //   789: bipush 199
    //   791: putfield 67	com/tencent/token/l:i	I
    //   794: goto -557 -> 237
    //   797: invokestatic 476	com/tencent/token/p:d	()Z
    //   800: ifeq +35 -> 835
    //   803: aload_0
    //   804: getfield 75	com/tencent/token/l:c	Z
    //   807: ifne +28 -> 835
    //   810: aload_0
    //   811: getfield 63	com/tencent/token/l:h	Lcom/tencent/token/l$b;
    //   814: invokevirtual 384	com/tencent/token/l$b:a	()I
    //   817: ifle +72 -> 889
    //   820: iconst_1
    //   821: istore_2
    //   822: iload_2
    //   823: ifeq +12 -> 835
    //   826: aload_0
    //   827: bipush 197
    //   829: putfield 67	com/tencent/token/l:i	I
    //   832: goto -595 -> 237
    //   835: aload_0
    //   836: iload_3
    //   837: putfield 67	com/tencent/token/l:i	I
    //   840: goto -603 -> 237
    //   843: astore 4
    //   845: aload 4
    //   847: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   850: goto -580 -> 270
    //   853: iload_1
    //   854: aload_0
    //   855: getfield 77	com/tencent/token/l:l	I
    //   858: if_icmplt -814 -> 44
    //   861: aload_0
    //   862: getfield 67	com/tencent/token/l:i	I
    //   865: bipush 199
    //   867: if_icmpne -823 -> 44
    //   870: aload_0
    //   871: iconst_m1
    //   872: putfield 67	com/tencent/token/l:i	I
    //   875: return
    //   876: goto -644 -> 232
    //   879: iconst_1
    //   880: istore_2
    //   881: goto -466 -> 415
    //   884: iconst_0
    //   885: istore_2
    //   886: goto -394 -> 492
    //   889: iconst_0
    //   890: istore_2
    //   891: goto -69 -> 822
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	894	0	this	l
    //   23	836	1	i1	int
    //   241	650	2	i2	int
    //   152	685	3	i3	int
    //   74	13	4	localProxy	java.net.Proxy
    //   286	18	4	localMalformedURLException	java.net.MalformedURLException
    //   328	9	4	localIOException	IOException
    //   362	40	4	str1	String
    //   436	4	4	localThrowable	Throwable
    //   699	85	4	str2	String
    //   843	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   56	71	286	java/net/MalformedURLException
    //   81	97	328	java/io/IOException
    //   311	325	328	java/io/IOException
    //   145	158	436	java/lang/Throwable
    //   232	237	436	java/lang/Throwable
    //   344	412	436	java/lang/Throwable
    //   419	433	436	java/lang/Throwable
    //   452	490	436	java/lang/Throwable
    //   496	558	436	java/lang/Throwable
    //   561	567	436	java/lang/Throwable
    //   570	632	436	java/lang/Throwable
    //   635	641	436	java/lang/Throwable
    //   644	686	436	java/lang/Throwable
    //   689	737	436	java/lang/Throwable
    //   740	764	436	java/lang/Throwable
    //   764	794	436	java/lang/Throwable
    //   797	820	436	java/lang/Throwable
    //   826	832	436	java/lang/Throwable
    //   835	840	436	java/lang/Throwable
    //   253	270	843	java/lang/Exception
  }
  
  public final void q()
  {
    if (this.o != null) {}
    try
    {
      this.o.disconnect();
      this.p.close();
      label21:
      this.o = null;
      this.p = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label21;
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
      return "[" + this.a + "," + this.b + "]";
    }
  }
  
  public static final class b
  {
    private List a = new ArrayList();
    
    public final int a()
    {
      return this.a.size();
    }
    
    public final void a(l.a parama)
    {
      Iterator localIterator = this.a.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((l.a)localIterator.next()).equals(parama));
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          this.a.add(parama);
        }
        return;
      }
    }
    
    public final l.a b()
    {
      if (this.a.size() == 0) {
        return null;
      }
      return (l.a)this.a.get(0);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("bytes=");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        l.a locala = (l.a)localIterator.next();
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
 * Qualified Name:     com.tencent.token.l
 * JD-Core Version:    0.7.0.1
 */