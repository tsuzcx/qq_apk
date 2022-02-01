package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.HandlerThread;
import android.util.LruCache;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static volatile a o = null;
  public byte[] a;
  public c b;
  public HandlerThread c;
  public volatile Location d;
  public volatile Location e;
  public volatile List<b> f;
  public volatile List<ScanResult> g;
  public long h;
  public long i;
  public long j;
  public long k;
  private Context l;
  private volatile b m;
  private LruCache<String, Pair<Double, Double>> n;
  
  /* Error */
  public a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: newarray byte
    //   8: putfield 45	c/t/m/g/a:a	[B
    //   11: aload_0
    //   12: ldc2_w 46
    //   15: putfield 49	c/t/m/g/a:h	J
    //   18: aload_0
    //   19: lconst_0
    //   20: putfield 51	c/t/m/g/a:i	J
    //   23: aload_0
    //   24: lconst_0
    //   25: putfield 53	c/t/m/g/a:j	J
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 55	c/t/m/g/a:k	J
    //   33: aload_1
    //   34: ifnonnull +27 -> 61
    //   37: aconst_null
    //   38: astore_3
    //   39: aload_0
    //   40: aload_3
    //   41: putfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   44: aload_0
    //   45: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   48: ifnonnull +21 -> 69
    //   51: new 59	java/lang/IllegalArgumentException
    //   54: dup
    //   55: ldc 61
    //   57: invokespecial 64	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: aload_1
    //   62: invokevirtual 70	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   65: astore_3
    //   66: goto -27 -> 39
    //   69: aload_1
    //   70: invokestatic 74	c/t/m/g/ad:a	(Landroid/content/Context;)V
    //   73: aload_0
    //   74: new 76	android/util/LruCache
    //   77: dup
    //   78: bipush 100
    //   80: invokespecial 79	android/util/LruCache:<init>	(I)V
    //   83: putfield 81	c/t/m/g/a:n	Landroid/util/LruCache;
    //   86: getstatic 86	c/t/m/g/h:a	Z
    //   89: istore_2
    //   90: getstatic 88	c/t/m/g/h:b	Z
    //   93: istore_2
    //   94: aload_0
    //   95: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   98: ldc 90
    //   100: invokevirtual 94	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   103: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: astore_3
    //   107: aload_3
    //   108: astore_1
    //   109: aload_3
    //   110: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +32 -> 145
    //   116: new 108	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   127: invokevirtual 113	android/content/Context:getFilesDir	()Ljava/io/File;
    //   130: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 119
    //   138: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +23 -> 172
    //   152: aload_0
    //   153: new 124	c/t/m/g/c
    //   156: dup
    //   157: aload_0
    //   158: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   161: aload_1
    //   162: invokespecial 127	c/t/m/g/c:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   165: putfield 129	c/t/m/g/a:b	Lc/t/m/g/c;
    //   168: aload_0
    //   169: invokespecial 131	c/t/m/g/a:f	()V
    //   172: aload_0
    //   173: putstatic 36	c/t/m/g/a:o	Lc/t/m/g/a;
    //   176: return
    //   177: astore_1
    //   178: ldc 133
    //   180: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +79 -> 262
    //   186: new 108	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   193: aload_0
    //   194: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   197: invokevirtual 113	android/content/Context:getFilesDir	()Ljava/io/File;
    //   200: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   203: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 119
    //   208: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore_1
    //   215: goto -70 -> 145
    //   218: astore_1
    //   219: ldc 133
    //   221: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifeq +29 -> 253
    //   227: new 108	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   234: aload_0
    //   235: getfield 57	c/t/m/g/a:l	Landroid/content/Context;
    //   238: invokevirtual 113	android/content/Context:getFilesDir	()Ljava/io/File;
    //   241: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   244: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 119
    //   249: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aload_0
    //   257: aconst_null
    //   258: putfield 129	c/t/m/g/a:b	Lc/t/m/g/c;
    //   261: return
    //   262: ldc 133
    //   264: astore_1
    //   265: goto -120 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	a
    //   0	268	1	paramContext	Context
    //   89	5	2	bool	boolean
    //   38	72	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	107	177	java/lang/Throwable
    //   86	107	218	finally
    //   109	145	255	java/lang/Throwable
    //   145	172	255	java/lang/Throwable
    //   172	176	255	java/lang/Throwable
    //   178	215	255	java/lang/Throwable
    //   219	253	255	java/lang/Throwable
    //   253	255	255	java/lang/Throwable
  }
  
  public static Location a(Location paramLocation1, Location paramLocation2)
  {
    Location localLocation = paramLocation1;
    if (paramLocation1 == null) {
      localLocation = new Location("gps");
    }
    if (paramLocation2 != null) {
      localLocation.set(paramLocation2);
    }
    return localLocation;
  }
  
  public static String e()
  {
    return "1.7.1_210628";
  }
  
  private void f()
  {
    Iterator localIterator = h.b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      if ((this.b != null) && (this.b.d())) {
        this.b.e();
      }
      if (this.c != null)
      {
        ah.a("th_loc_extra", 300L);
        this.c = null;
      }
      d();
      ai.a(3, "TxCoreDC", "shutdown", null);
      return;
    }
  }
  
  public final void a(b paramb, List<b> paramList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      String str;
      Object localObject;
      int i1;
      synchronized (this.a)
      {
        if (!c()) {
          return;
        }
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label407;
        }
        b localb = (b)paramList.next();
        if (!g.a(localb.f, localb.a, localb.b, localb.c, localb.e)) {
          continue;
        }
        str = localb.c + "_" + localb.e;
        localObject = this.d;
        if ((ai.c(str)) || (localObject == null) || (((Location)localObject).getLatitude() == 0.0D)) {
          break label444;
        }
        if (((Location)localObject).getLongitude() == 0.0D)
        {
          break label444;
          if (i1 == 0) {
            continue;
          }
          localArrayList.add(localb);
        }
      }
      Pair localPair = (Pair)this.n.get(str);
      if (localPair == null)
      {
        localObject = Pair.create(Double.valueOf(((Location)localObject).getLatitude()), Double.valueOf(((Location)localObject).getLongitude()));
        this.n.put(str, localObject);
        i1 = 1;
      }
      else
      {
        double d1 = ((Location)localObject).getLatitude();
        double d3 = ((Location)localObject).getLongitude();
        double d2 = ((Double)localPair.first).doubleValue();
        double d4 = ((Double)localPair.second).doubleValue();
        d1 = ai.a(d1);
        d2 = ai.a(d2);
        d3 = ai.a(d3);
        d4 = ai.a(d4);
        double d5 = Math.pow(Math.sin((d1 - d2) / 2.0D), 2.0D);
        d1 = Math.cos(d1);
        d2 = Math.cos(d2);
        if (Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d4) / 2.0D), 2.0D) * (d1 * d2) + d5)) * 2.0D * 6378.1369999999997D * 1000.0D * 1000.0D) / 1000.0D < 6000.0D)
        {
          i1 = 1;
          continue;
          label407:
          this.f = localArrayList;
          this.i = System.currentTimeMillis();
          if (!paramb.equals(this.m))
          {
            this.m = paramb;
            b();
          }
          return;
          label444:
          i1 = 0;
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    synchronized (this.a)
    {
      if ((this.b == null) || (ai.c(paramString2))) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        if (ai.a()) {
          ai.a(3, "TxCoreDC", "setSetting(" + paramString1 + "," + paramString2 + ")", null);
        }
        if (!"D_CH_ID".equals(paramString1)) {
          continue;
        }
        i.a(paramString2);
      }
      catch (Throwable localThrowable)
      {
        if (!ai.a()) {
          continue;
        }
        ai.a("TxCoreDC", "set setting data[" + paramString1 + "," + paramString2 + "] error.", localThrowable);
        continue;
        if (!"D_POS_COLL".equals(paramString1)) {
          continue;
        }
        h.c = Boolean.parseBoolean(paramString2.toLowerCase());
        continue;
        if (!"D_WRITE_MAC".equals(paramString1)) {
          continue;
        }
        h.d = Boolean.parseBoolean(paramString2.toLowerCase());
        continue;
        if (!"D_UP_NET".equals(paramString1)) {
          continue;
        }
        if (!"m".equals(paramString2.toLowerCase())) {
          continue;
        }
        h.f = true;
        continue;
        if (!"w".equals(paramString2.toLowerCase())) {
          continue;
        }
        h.f = false;
        h.g = false;
        continue;
        if (!"w_m1".equals(paramString2.toLowerCase())) {
          continue;
        }
        h.f = false;
        h.g = true;
        continue;
        if (!"D_EXTRA_SET_SN".equals(paramString1)) {
          break;
        }
      }
      return;
      paramString1 = finally;
      throw paramString1;
      if ("D_FC_SRC".equals(paramString1)) {
        i.b(paramString2);
      } else {
        if (!ai.c(paramString2)) {
          break label662;
        }
      }
    }
    label662:
    for (Object localObject = "";; localObject = paramString2)
    {
      k.a = (String)localObject;
      break;
      localObject = this.b;
      if ("D_UP_INTERVAL".equals(paramString1))
      {
        ((c)localObject).b = Math.max(900000L, Long.parseLong(paramString2));
        break;
      }
      if ("D_UP_USE_HTTPS".equals(paramString1))
      {
        h.e = Boolean.parseBoolean(paramString2);
        break;
      }
      if ("D_MAX_1F_SIZE".equals(paramString1))
      {
        ((c)localObject).a = c.a(Long.parseLong(paramString2), 10240L, 512000L);
        break;
      }
      if ("D_NUM_UP".equals(paramString1))
      {
        ((c)localObject).c = ((int)c.a(Long.parseLong(paramString2), 1L, 5L));
        break;
      }
      if ("D_MAX_BUF_WF".equals(paramString1))
      {
        ((c)localObject).d = ((int)c.a(Long.parseLong(paramString2), 5120L, 51200L));
        break;
      }
      if ("D_MAX_FOLDER_SIZE".equals(paramString1))
      {
        ((c)localObject).e = c.a(Long.parseLong(paramString2), 10485760L, 209715200L);
        break;
      }
      if ("D_MAX_SIZE_UP_1DAY".equals(paramString1))
      {
        ((c)localObject).f = Math.max(Long.parseLong(paramString2), 0L);
        break;
      }
      if ("D_MAX_DAY_RENAME".equals(paramString1))
      {
        ((c)localObject).g = (c.a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
        break;
      }
      if ("D_MAX_DAY_DELETE".equals(paramString1))
      {
        ((c)localObject).h = (c.a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
        break;
      }
      if ("D_UP_WF_INFO".equals(paramString1))
      {
        ((c)localObject).i = Boolean.parseBoolean(paramString2);
        break;
      }
      if ("D_UP_U_TRACK_INFO".equals(paramString1))
      {
        ((c)localObject).j = Boolean.parseBoolean(paramString2);
        break;
      }
      if (!"D_UP_GPS_FOR_NAVI".equals(paramString1)) {
        break;
      }
      ((c)localObject).k = Boolean.parseBoolean(paramString2);
      break;
    }
  }
  
  public final void b()
  {
    if ((!ai.a(new Object[] { this.b, this.d })) || (ai.a(this.f))) {}
    long l1;
    do
    {
      do
      {
        return;
      } while ((h.f) && (l.a(this.l) == 3));
      l1 = System.currentTimeMillis();
    } while (l1 - this.i >= this.h);
    this.k = l1;
    this.e = a(this.e, this.d);
    this.b.a(this.d, null, this.f);
  }
  
  public final boolean c()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.d();
  }
  
  public final void d()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.m = null;
    this.g = null;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.n.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.a
 * JD-Core Version:    0.7.0.1
 */