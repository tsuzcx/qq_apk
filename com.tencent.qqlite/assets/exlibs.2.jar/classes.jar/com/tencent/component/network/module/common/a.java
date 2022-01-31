package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public final class a
{
  private static a a = null;
  private static final byte[] b = new byte[0];
  private static final byte[] c = new byte[0];
  private static final byte[] d = new byte[0];
  private final HashMap<String, ThreadPool> e = new HashMap();
  private String f = "none";
  private List<String> g = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, a> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> i = new ConcurrentHashMap();
  private List<b> j = Collections.synchronizedList(new ArrayList());
  private List<Pattern> k;
  private Executor l;
  
  private a()
  {
    e();
  }
  
  /* Error */
  public static a a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 39	com/tencent/component/network/module/common/a:b	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 37	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/component/network/module/common/a
    //   24: dup
    //   25: invokespecial 80	com/tencent/component/network/module/common/a:<init>	()V
    //   28: putstatic 37	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 37	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   43	47	47	finally
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    a locala = (a)this.h.get(paramString);
    if (locala == null) {
      return null;
    }
    long l1 = System.currentTimeMillis() - locala.a;
    if ((l1 >= 0L) && (l1 <= 3600000L) && (!TextUtils.isEmpty(locala.b))) {}
    for (int m = 1; m != 0; m = 0) {
      return locala.b;
    }
    this.h.remove(paramString);
    return null;
  }
  
  private int d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (c)
      {
        if (this.i.get(paramString) == null) {
          break label121;
        }
        paramString = (ConcurrentHashMap)this.i.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label105;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          m = localInteger.intValue();
          return m;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      int m = 0;
      continue;
      label105:
      paramString.put(localObject, Integer.valueOf(0));
      m = 0;
      continue;
      label121:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.i.put(paramString, localObject);
      m = 0;
    }
  }
  
  private void e()
  {
    int m = 0;
    this.k = new ArrayList();
    for (;;)
    {
      if (m >= 7) {
        return;
      }
      Pattern localPattern = Pattern.compile(new String[] { "a[0-9].qpic.cn", "m.qpic.cn", "t[0-9].qpic.cn", "qlogo[0-9].store.qq.com", "mmsns.qpic.cn", "ugc.qpic.cn", "b\\d+.photo.store.qq.com" }[m], 2);
      this.k.add(localPattern);
      m += 1;
    }
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("192.168")) || (paramString.equals("127.0.0.1")) || (paramString.equals("0.0.0.0")) || (paramString.equals("255.255.255.255"))) {
      return false;
    }
    return true;
  }
  
  private void f(String paramString)
  {
    int m;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!this.g.contains(paramString)) {
        break label169;
      }
      m = 0;
      if (m != 0)
      {
        this.g.add(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          break label174;
        }
        localObject = "resolver_threadpool_name_common";
        label48:
        ThreadPool localThreadPool2 = (ThreadPool)this.e.get(localObject);
        localThreadPool1 = localThreadPool2;
        if (localThreadPool2 == null)
        {
          m = 2;
          if ("resolver_threadpool_name_internal".equals(localObject)) {
            m = 4;
          }
          if (this.l == null) {
            break label223;
          }
        }
      }
    }
    label169:
    label174:
    label223:
    for (ThreadPool localThreadPool1 = new ThreadPool(this.l);; localThreadPool1 = new ThreadPool((String)localObject, m, m, new LinkedBlockingQueue()))
    {
      this.e.put(localObject, localThreadPool1);
      Const.a("DnsService", "add query:" + paramString);
      if ("wifi".equals(NetworkManager.getApnValue())) {
        NetworkManager.getBSSID();
      }
      try
      {
        localThreadPool1.submit(new b(paramString));
        return;
      }
      catch (Throwable paramString)
      {
        Const.d("DnsService", "exception when add query to DNSService.", paramString);
      }
      m = 1;
      break;
      localObject = this.k.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext())
        {
          localObject = "resolver_threadpool_name_common";
          break;
        }
      } while (!Const.a((Pattern)((Iterator)localObject).next(), paramString));
      localObject = "resolver_threadpool_name_internal";
      break label48;
    }
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l2 = System.currentTimeMillis();
    String str = c(paramString);
    long l1;
    if (TextUtils.isEmpty(str))
    {
      l1 = 0L;
      str = c(paramString);
      if ((TextUtils.isEmpty(str)) && (l1 <= 20000L) && (d(paramString) <= 0)) {}
    }
    for (;;)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString)) {}
        synchronized (c)
        {
          for (;;)
          {
            if (this.i.get(paramString) != null)
            {
              ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.i.get(paramString);
              Long localLong = Long.valueOf(Thread.currentThread().getId());
              if (localConcurrentHashMap.get(localLong) != null) {
                localConcurrentHashMap.remove(localLong);
              }
            }
            Const.c("DnsService", "DNSService domain:" + paramString + " ip:" + str + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
            return str;
            try
            {
              f(paramString);
              Thread.sleep(20L);
              l1 += 20L;
            }
            catch (InterruptedException localInterruptedException)
            {
              Const.d("DnsService", "DNSService getDomainIP InterruptedException", localInterruptedException);
            }
          }
        }
      }
    }
  }
  
  public final void a(Executor paramExecutor)
  {
    if (this.l != null) {
      this.l = paramExecutor;
    }
  }
  
  public final void b()
  {
    if (NetworkManager.isMobile()) {}
    Object localObject2;
    for (String str = NetworkManager.getApnValue();; localObject2 = null) {
      for (;;)
      {
        Const.a("DnsService", "DNSService reset. Key:" + this.f + " currKey:" + str);
        if ((str == null) || (!str.equalsIgnoreCase(this.f))) {}
        synchronized (d)
        {
          Iterator localIterator = this.j.iterator();
          if (!localIterator.hasNext())
          {
            this.f = str;
            this.h.clear();
            f("m.qpic.cn");
            return;
            if (NetworkManager.isWifi()) {
              str = NetworkManager.getBSSID();
            }
          }
          else
          {
            ((b)localIterator.next()).a();
          }
        }
      }
    }
  }
  
  public final class a
  {
    public long a;
    
    public a(long paramLong)
    {
      this.a = paramLong;
    }
  }
  
  final class b
    implements ThreadPool.Job<Object>
  {
    private String a;
    private volatile boolean b = false;
    
    public b(String paramString)
    {
      this.a = paramString;
    }
    
    public final void a()
    {
      this.b = true;
    }
    
    /* Error */
    public final Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext arg1)
    {
      // Byte code:
      //   0: invokestatic 40	com/tencent/component/network/module/common/a:c	()[B
      //   3: astore_1
      //   4: aload_1
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   10: invokestatic 43	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;)Ljava/util/List;
      //   13: aload_0
      //   14: invokeinterface 49 2 0
      //   19: pop
      //   20: aload_1
      //   21: monitorexit
      //   22: aconst_null
      //   23: astore 10
      //   25: aconst_null
      //   26: astore 11
      //   28: aconst_null
      //   29: astore 12
      //   31: aconst_null
      //   32: astore 13
      //   34: aconst_null
      //   35: astore 14
      //   37: aconst_null
      //   38: astore 15
      //   40: aconst_null
      //   41: astore 7
      //   43: aconst_null
      //   44: astore 9
      //   46: aconst_null
      //   47: astore 6
      //   49: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   52: astore_1
      //   53: aload_1
      //   54: astore 8
      //   56: ldc 57
      //   58: aload_1
      //   59: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   62: ifeq +8 -> 70
      //   65: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   68: astore 8
      //   70: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   73: lstore 4
      //   75: aload 6
      //   77: astore_1
      //   78: aload_0
      //   79: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   82: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   85: ifne +26 -> 111
      //   88: aload_0
      //   89: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   92: invokestatic 83	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   95: astore 16
      //   97: aload 6
      //   99: astore_1
      //   100: aload 16
      //   102: ifnull +9 -> 111
      //   105: aload 16
      //   107: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   110: astore_1
      //   111: ldc 88
      //   113: new 90	java/lang/StringBuilder
      //   116: dup
      //   117: ldc 92
      //   119: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   122: aload_1
      //   123: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   129: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   132: aload_0
      //   133: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   136: astore 6
      //   138: aload_1
      //   139: astore 6
      //   141: aload_1
      //   142: invokestatic 110	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   145: ifne +133 -> 278
      //   148: aload_0
      //   149: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   152: astore 6
      //   154: aload_1
      //   155: astore 6
      //   157: invokestatic 114	com/tencent/component/network/module/common/a:d	()Z
      //   160: ifeq +118 -> 278
      //   163: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   166: lload 4
      //   168: lsub
      //   169: lstore_2
      //   170: aload_1
      //   171: astore 7
      //   173: aload_0
      //   174: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   177: astore 6
      //   179: ldc2_w 115
      //   182: lload_2
      //   183: lsub
      //   184: ldc2_w 117
      //   187: lcmp
      //   188: iflt +1645 -> 1833
      //   191: ldc2_w 115
      //   194: lload_2
      //   195: lsub
      //   196: lstore_2
      //   197: aload_1
      //   198: astore 7
      //   200: aload 6
      //   202: lload_2
      //   203: invokestatic 121	com/tencent/component/network/downloader/impl/ipc/Const:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   206: astore 9
      //   208: aload_1
      //   209: astore 6
      //   211: aload 9
      //   213: ifnull +65 -> 278
      //   216: aload_1
      //   217: astore 6
      //   219: aload_1
      //   220: astore 7
      //   222: aload 9
      //   224: arraylength
      //   225: ifle +53 -> 278
      //   228: aload_1
      //   229: astore 7
      //   231: aload 9
      //   233: iconst_0
      //   234: aaload
      //   235: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   238: astore 6
      //   240: aload 6
      //   242: astore 7
      //   244: ldc 88
      //   246: new 90	java/lang/StringBuilder
      //   249: dup
      //   250: ldc 123
      //   252: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   255: aload_0
      //   256: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   259: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   262: ldc 125
      //   264: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   267: aload 6
      //   269: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   272: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   275: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   281: astore 7
      //   283: aload 7
      //   285: astore_1
      //   286: ldc 57
      //   288: aload 7
      //   290: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   293: ifeq +7 -> 300
      //   296: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   299: astore_1
      //   300: ldc 88
      //   302: new 90	java/lang/StringBuilder
      //   305: dup
      //   306: ldc 127
      //   308: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   311: aload_0
      //   312: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   315: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   318: ldc 129
      //   320: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   323: aload 6
      //   325: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   328: ldc 131
      //   330: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   333: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   336: lload 4
      //   338: lsub
      //   339: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   342: ldc 136
      //   344: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   347: aload 8
      //   349: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: ldc 138
      //   354: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   357: aload_1
      //   358: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   361: ldc 140
      //   363: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   369: invokevirtual 149	java/lang/Thread:getId	()J
      //   372: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   375: ldc 151
      //   377: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   380: aload_0
      //   381: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   384: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   387: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   390: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   393: aload_0
      //   394: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   397: ifne +1459 -> 1856
      //   400: aload_0
      //   401: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   404: aload_0
      //   405: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   408: aload 6
      //   410: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   413: invokestatic 40	com/tencent/component/network/module/common/a:c	()[B
      //   416: astore_1
      //   417: aload_1
      //   418: monitorenter
      //   419: aload_0
      //   420: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   423: invokestatic 43	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;)Ljava/util/List;
      //   426: aload_0
      //   427: invokeinterface 160 2 0
      //   432: pop
      //   433: aload_1
      //   434: monitorexit
      //   435: aconst_null
      //   436: areturn
      //   437: astore 6
      //   439: aload_1
      //   440: monitorexit
      //   441: aload 6
      //   443: athrow
      //   444: astore_1
      //   445: ldc 88
      //   447: ldc 162
      //   449: aload_1
      //   450: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   453: ldc 88
      //   455: new 90	java/lang/StringBuilder
      //   458: dup
      //   459: ldc 92
      //   461: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   464: aconst_null
      //   465: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   468: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   471: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   474: aload_0
      //   475: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   478: astore_1
      //   479: aload 10
      //   481: astore_1
      //   482: aconst_null
      //   483: invokestatic 110	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   486: ifne +131 -> 617
      //   489: aload_0
      //   490: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   493: astore_1
      //   494: aload 10
      //   496: astore_1
      //   497: invokestatic 114	com/tencent/component/network/module/common/a:d	()Z
      //   500: ifeq +117 -> 617
      //   503: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   506: lload 4
      //   508: lsub
      //   509: lstore_2
      //   510: aload 11
      //   512: astore 6
      //   514: aload_0
      //   515: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   518: astore_1
      //   519: ldc2_w 115
      //   522: lload_2
      //   523: lsub
      //   524: ldc2_w 117
      //   527: lcmp
      //   528: iflt +228 -> 756
      //   531: ldc2_w 115
      //   534: lload_2
      //   535: lsub
      //   536: lstore_2
      //   537: aload 11
      //   539: astore 6
      //   541: aload_1
      //   542: lload_2
      //   543: invokestatic 121	com/tencent/component/network/downloader/impl/ipc/Const:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   546: astore 7
      //   548: aload 10
      //   550: astore_1
      //   551: aload 7
      //   553: ifnull +64 -> 617
      //   556: aload 10
      //   558: astore_1
      //   559: aload 11
      //   561: astore 6
      //   563: aload 7
      //   565: arraylength
      //   566: ifle +51 -> 617
      //   569: aload 11
      //   571: astore 6
      //   573: aload 7
      //   575: iconst_0
      //   576: aaload
      //   577: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   580: astore_1
      //   581: aload_1
      //   582: astore 6
      //   584: ldc 88
      //   586: new 90	java/lang/StringBuilder
      //   589: dup
      //   590: ldc 123
      //   592: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   595: aload_0
      //   596: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   599: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   602: ldc 125
      //   604: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   607: aload_1
      //   608: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   611: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   614: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   617: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   620: astore 7
      //   622: aload 7
      //   624: astore 6
      //   626: ldc 57
      //   628: aload 7
      //   630: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   633: ifeq +8 -> 641
      //   636: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   639: astore 6
      //   641: ldc 88
      //   643: new 90	java/lang/StringBuilder
      //   646: dup
      //   647: ldc 127
      //   649: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   652: aload_0
      //   653: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   656: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: ldc 129
      //   661: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   664: aload_1
      //   665: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   668: ldc 131
      //   670: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   673: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   676: lload 4
      //   678: lsub
      //   679: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   682: ldc 136
      //   684: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   687: aload 8
      //   689: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   692: ldc 138
      //   694: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   697: aload 6
      //   699: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   702: ldc 140
      //   704: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   707: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   710: invokevirtual 149	java/lang/Thread:getId	()J
      //   713: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   716: ldc 151
      //   718: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   721: aload_0
      //   722: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   725: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   728: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   731: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   734: aload_0
      //   735: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   738: ifne +40 -> 778
      //   741: aload_0
      //   742: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   745: aload_0
      //   746: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   749: aload_1
      //   750: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   753: goto -340 -> 413
      //   756: ldc2_w 117
      //   759: lstore_2
      //   760: goto -223 -> 537
      //   763: astore_1
      //   764: ldc 88
      //   766: ldc 167
      //   768: aload_1
      //   769: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   772: aload 6
      //   774: astore_1
      //   775: goto -158 -> 617
      //   778: aload_0
      //   779: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   782: aload_0
      //   783: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   786: aconst_null
      //   787: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   790: goto -377 -> 413
      //   793: astore_1
      //   794: ldc 88
      //   796: ldc 162
      //   798: aload_1
      //   799: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   802: ldc 88
      //   804: new 90	java/lang/StringBuilder
      //   807: dup
      //   808: ldc 92
      //   810: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   813: aconst_null
      //   814: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   817: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   820: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   823: aload_0
      //   824: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   827: astore_1
      //   828: aload 12
      //   830: astore_1
      //   831: aconst_null
      //   832: invokestatic 110	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   835: ifne +131 -> 966
      //   838: aload_0
      //   839: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   842: astore_1
      //   843: aload 12
      //   845: astore_1
      //   846: invokestatic 114	com/tencent/component/network/module/common/a:d	()Z
      //   849: ifeq +117 -> 966
      //   852: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   855: lload 4
      //   857: lsub
      //   858: lstore_2
      //   859: aload 13
      //   861: astore 6
      //   863: aload_0
      //   864: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   867: astore_1
      //   868: ldc2_w 115
      //   871: lload_2
      //   872: lsub
      //   873: ldc2_w 117
      //   876: lcmp
      //   877: iflt +228 -> 1105
      //   880: ldc2_w 115
      //   883: lload_2
      //   884: lsub
      //   885: lstore_2
      //   886: aload 13
      //   888: astore 6
      //   890: aload_1
      //   891: lload_2
      //   892: invokestatic 121	com/tencent/component/network/downloader/impl/ipc/Const:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   895: astore 7
      //   897: aload 12
      //   899: astore_1
      //   900: aload 7
      //   902: ifnull +64 -> 966
      //   905: aload 12
      //   907: astore_1
      //   908: aload 13
      //   910: astore 6
      //   912: aload 7
      //   914: arraylength
      //   915: ifle +51 -> 966
      //   918: aload 13
      //   920: astore 6
      //   922: aload 7
      //   924: iconst_0
      //   925: aaload
      //   926: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   929: astore_1
      //   930: aload_1
      //   931: astore 6
      //   933: ldc 88
      //   935: new 90	java/lang/StringBuilder
      //   938: dup
      //   939: ldc 123
      //   941: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   944: aload_0
      //   945: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   948: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   951: ldc 125
      //   953: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   956: aload_1
      //   957: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   960: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   963: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   966: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   969: astore 7
      //   971: aload 7
      //   973: astore 6
      //   975: ldc 57
      //   977: aload 7
      //   979: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   982: ifeq +8 -> 990
      //   985: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   988: astore 6
      //   990: ldc 88
      //   992: new 90	java/lang/StringBuilder
      //   995: dup
      //   996: ldc 127
      //   998: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1001: aload_0
      //   1002: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1005: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1008: ldc 129
      //   1010: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1013: aload_1
      //   1014: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1017: ldc 131
      //   1019: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1022: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1025: lload 4
      //   1027: lsub
      //   1028: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1031: ldc 136
      //   1033: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1036: aload 8
      //   1038: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1041: ldc 138
      //   1043: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1046: aload 6
      //   1048: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1051: ldc 140
      //   1053: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1056: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1059: invokevirtual 149	java/lang/Thread:getId	()J
      //   1062: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1065: ldc 151
      //   1067: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1070: aload_0
      //   1071: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1074: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1077: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1080: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1083: aload_0
      //   1084: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1087: ifne +40 -> 1127
      //   1090: aload_0
      //   1091: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1094: aload_0
      //   1095: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1098: aload_1
      //   1099: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1102: goto -689 -> 413
      //   1105: ldc2_w 117
      //   1108: lstore_2
      //   1109: goto -223 -> 886
      //   1112: astore_1
      //   1113: ldc 88
      //   1115: ldc 167
      //   1117: aload_1
      //   1118: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1121: aload 6
      //   1123: astore_1
      //   1124: goto -158 -> 966
      //   1127: aload_0
      //   1128: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1131: aload_0
      //   1132: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1135: aconst_null
      //   1136: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1139: goto -726 -> 413
      //   1142: astore_1
      //   1143: ldc 88
      //   1145: ldc 169
      //   1147: aload_1
      //   1148: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1151: ldc 88
      //   1153: new 90	java/lang/StringBuilder
      //   1156: dup
      //   1157: ldc 92
      //   1159: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1162: aconst_null
      //   1163: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1166: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1169: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1172: aload_0
      //   1173: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1176: astore_1
      //   1177: aload 14
      //   1179: astore_1
      //   1180: aconst_null
      //   1181: invokestatic 110	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   1184: ifne +131 -> 1315
      //   1187: aload_0
      //   1188: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1191: astore_1
      //   1192: aload 14
      //   1194: astore_1
      //   1195: invokestatic 114	com/tencent/component/network/module/common/a:d	()Z
      //   1198: ifeq +117 -> 1315
      //   1201: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1204: lload 4
      //   1206: lsub
      //   1207: lstore_2
      //   1208: aload 15
      //   1210: astore 6
      //   1212: aload_0
      //   1213: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1216: astore_1
      //   1217: ldc2_w 115
      //   1220: lload_2
      //   1221: lsub
      //   1222: ldc2_w 117
      //   1225: lcmp
      //   1226: iflt +228 -> 1454
      //   1229: ldc2_w 115
      //   1232: lload_2
      //   1233: lsub
      //   1234: lstore_2
      //   1235: aload 15
      //   1237: astore 6
      //   1239: aload_1
      //   1240: lload_2
      //   1241: invokestatic 121	com/tencent/component/network/downloader/impl/ipc/Const:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1244: astore 7
      //   1246: aload 14
      //   1248: astore_1
      //   1249: aload 7
      //   1251: ifnull +64 -> 1315
      //   1254: aload 14
      //   1256: astore_1
      //   1257: aload 15
      //   1259: astore 6
      //   1261: aload 7
      //   1263: arraylength
      //   1264: ifle +51 -> 1315
      //   1267: aload 15
      //   1269: astore 6
      //   1271: aload 7
      //   1273: iconst_0
      //   1274: aaload
      //   1275: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1278: astore_1
      //   1279: aload_1
      //   1280: astore 6
      //   1282: ldc 88
      //   1284: new 90	java/lang/StringBuilder
      //   1287: dup
      //   1288: ldc 123
      //   1290: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1293: aload_0
      //   1294: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1297: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1300: ldc 125
      //   1302: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1305: aload_1
      //   1306: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1309: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1312: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1315: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1318: astore 7
      //   1320: aload 7
      //   1322: astore 6
      //   1324: ldc 57
      //   1326: aload 7
      //   1328: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1331: ifeq +8 -> 1339
      //   1334: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1337: astore 6
      //   1339: ldc 88
      //   1341: new 90	java/lang/StringBuilder
      //   1344: dup
      //   1345: ldc 127
      //   1347: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1350: aload_0
      //   1351: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1354: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1357: ldc 129
      //   1359: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1362: aload_1
      //   1363: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1366: ldc 131
      //   1368: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1371: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1374: lload 4
      //   1376: lsub
      //   1377: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1380: ldc 136
      //   1382: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1385: aload 8
      //   1387: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1390: ldc 138
      //   1392: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1395: aload 6
      //   1397: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1400: ldc 140
      //   1402: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1405: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1408: invokevirtual 149	java/lang/Thread:getId	()J
      //   1411: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1414: ldc 151
      //   1416: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1419: aload_0
      //   1420: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1423: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1426: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1429: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1432: aload_0
      //   1433: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1436: ifne +40 -> 1476
      //   1439: aload_0
      //   1440: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1443: aload_0
      //   1444: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1447: aload_1
      //   1448: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1451: goto -1038 -> 413
      //   1454: ldc2_w 117
      //   1457: lstore_2
      //   1458: goto -223 -> 1235
      //   1461: astore_1
      //   1462: ldc 88
      //   1464: ldc 167
      //   1466: aload_1
      //   1467: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1470: aload 6
      //   1472: astore_1
      //   1473: goto -158 -> 1315
      //   1476: aload_0
      //   1477: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1480: aload_0
      //   1481: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1484: aconst_null
      //   1485: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1488: goto -1075 -> 413
      //   1491: astore 10
      //   1493: ldc 88
      //   1495: new 90	java/lang/StringBuilder
      //   1498: dup
      //   1499: ldc 92
      //   1501: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1504: aconst_null
      //   1505: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1508: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1511: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1514: aload_0
      //   1515: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1518: astore_1
      //   1519: aload 7
      //   1521: astore_1
      //   1522: aconst_null
      //   1523: invokestatic 110	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   1526: ifne +131 -> 1657
      //   1529: aload_0
      //   1530: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1533: astore_1
      //   1534: aload 7
      //   1536: astore_1
      //   1537: invokestatic 114	com/tencent/component/network/module/common/a:d	()Z
      //   1540: ifeq +117 -> 1657
      //   1543: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1546: lload 4
      //   1548: lsub
      //   1549: lstore_2
      //   1550: aload 9
      //   1552: astore 6
      //   1554: aload_0
      //   1555: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1558: astore_1
      //   1559: ldc2_w 115
      //   1562: lload_2
      //   1563: lsub
      //   1564: ldc2_w 117
      //   1567: lcmp
      //   1568: iflt +228 -> 1796
      //   1571: ldc2_w 115
      //   1574: lload_2
      //   1575: lsub
      //   1576: lstore_2
      //   1577: aload 9
      //   1579: astore 6
      //   1581: aload_1
      //   1582: lload_2
      //   1583: invokestatic 121	com/tencent/component/network/downloader/impl/ipc/Const:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1586: astore 11
      //   1588: aload 7
      //   1590: astore_1
      //   1591: aload 11
      //   1593: ifnull +64 -> 1657
      //   1596: aload 7
      //   1598: astore_1
      //   1599: aload 9
      //   1601: astore 6
      //   1603: aload 11
      //   1605: arraylength
      //   1606: ifle +51 -> 1657
      //   1609: aload 9
      //   1611: astore 6
      //   1613: aload 11
      //   1615: iconst_0
      //   1616: aaload
      //   1617: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1620: astore_1
      //   1621: aload_1
      //   1622: astore 6
      //   1624: ldc 88
      //   1626: new 90	java/lang/StringBuilder
      //   1629: dup
      //   1630: ldc 123
      //   1632: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1635: aload_0
      //   1636: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1639: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1642: ldc 125
      //   1644: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1647: aload_1
      //   1648: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1651: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1654: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1657: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1660: astore 7
      //   1662: aload 7
      //   1664: astore 6
      //   1666: ldc 57
      //   1668: aload 7
      //   1670: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1673: ifeq +8 -> 1681
      //   1676: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1679: astore 6
      //   1681: ldc 88
      //   1683: new 90	java/lang/StringBuilder
      //   1686: dup
      //   1687: ldc 127
      //   1689: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1692: aload_0
      //   1693: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1696: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1699: ldc 129
      //   1701: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1704: aload_1
      //   1705: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1708: ldc 131
      //   1710: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1713: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1716: lload 4
      //   1718: lsub
      //   1719: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1722: ldc 136
      //   1724: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1727: aload 8
      //   1729: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1732: ldc 138
      //   1734: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1737: aload 6
      //   1739: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1742: ldc 140
      //   1744: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1747: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1750: invokevirtual 149	java/lang/Thread:getId	()J
      //   1753: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1756: ldc 151
      //   1758: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1761: aload_0
      //   1762: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1765: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1768: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1771: invokestatic 107	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   1774: aload_0
      //   1775: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1778: ifne +40 -> 1818
      //   1781: aload_0
      //   1782: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1785: aload_0
      //   1786: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1789: aload_1
      //   1790: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1793: aload 10
      //   1795: athrow
      //   1796: ldc2_w 117
      //   1799: lstore_2
      //   1800: goto -223 -> 1577
      //   1803: astore_1
      //   1804: ldc 88
      //   1806: ldc 167
      //   1808: aload_1
      //   1809: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1812: aload 6
      //   1814: astore_1
      //   1815: goto -158 -> 1657
      //   1818: aload_0
      //   1819: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1822: aload_0
      //   1823: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1826: aconst_null
      //   1827: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1830: goto -37 -> 1793
      //   1833: ldc2_w 117
      //   1836: lstore_2
      //   1837: goto -1640 -> 197
      //   1840: astore_1
      //   1841: ldc 88
      //   1843: ldc 167
      //   1845: aload_1
      //   1846: invokestatic 165	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1849: aload 7
      //   1851: astore 6
      //   1853: goto -1575 -> 278
      //   1856: aload_0
      //   1857: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1860: aload_0
      //   1861: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1864: aconst_null
      //   1865: invokestatic 157	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1868: goto -1455 -> 413
      //   1871: astore 6
      //   1873: aload_1
      //   1874: monitorexit
      //   1875: aload 6
      //   1877: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1878	0	this	b
      //   169	1668	2	l1	long
      //   73	1644	4	l2	long
      //   47	362	6	localObject1	Object
      //   437	5	6	localObject2	Object
      //   512	1340	6	localObject3	Object
      //   1871	5	6	localObject4	Object
      //   41	1809	7	localObject5	Object
      //   54	1674	8	localObject6	Object
      //   44	1566	9	arrayOfInetAddress1	java.net.InetAddress[]
      //   23	534	10	localObject7	Object
      //   1491	303	10	localObject8	Object
      //   26	1588	11	arrayOfInetAddress2	java.net.InetAddress[]
      //   29	877	12	localObject9	Object
      //   32	887	13	localObject10	Object
      //   35	1220	14	localObject11	Object
      //   38	1230	15	localObject12	Object
      //   95	11	16	localInetAddress	java.net.InetAddress
      // Exception table:
      //   from	to	target	type
      //   6	22	437	finally
      //   78	97	444	java/net/UnknownHostException
      //   105	111	444	java/net/UnknownHostException
      //   514	519	763	java/lang/Throwable
      //   541	548	763	java/lang/Throwable
      //   563	569	763	java/lang/Throwable
      //   573	581	763	java/lang/Throwable
      //   584	617	763	java/lang/Throwable
      //   78	97	793	java/lang/Exception
      //   105	111	793	java/lang/Exception
      //   863	868	1112	java/lang/Throwable
      //   890	897	1112	java/lang/Throwable
      //   912	918	1112	java/lang/Throwable
      //   922	930	1112	java/lang/Throwable
      //   933	966	1112	java/lang/Throwable
      //   78	97	1142	java/lang/Error
      //   105	111	1142	java/lang/Error
      //   1212	1217	1461	java/lang/Throwable
      //   1239	1246	1461	java/lang/Throwable
      //   1261	1267	1461	java/lang/Throwable
      //   1271	1279	1461	java/lang/Throwable
      //   1282	1315	1461	java/lang/Throwable
      //   78	97	1491	finally
      //   105	111	1491	finally
      //   445	453	1491	finally
      //   794	802	1491	finally
      //   1143	1151	1491	finally
      //   1554	1559	1803	java/lang/Throwable
      //   1581	1588	1803	java/lang/Throwable
      //   1603	1609	1803	java/lang/Throwable
      //   1613	1621	1803	java/lang/Throwable
      //   1624	1657	1803	java/lang/Throwable
      //   173	179	1840	java/lang/Throwable
      //   200	208	1840	java/lang/Throwable
      //   222	228	1840	java/lang/Throwable
      //   231	240	1840	java/lang/Throwable
      //   244	278	1840	java/lang/Throwable
      //   419	435	1871	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a
 * JD-Core Version:    0.7.0.1
 */