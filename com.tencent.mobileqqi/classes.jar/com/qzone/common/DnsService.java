package com.qzone.common;

import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.NetworkManager;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.Utils;
import com.qzone.utils.thread.ThreadPool;
import com.qzone.utils.thread.ThreadPool.Job;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public class DnsService
{
  private static final int CACHE_TIME = 3600000;
  private static final byte[] DATA_LOCK = new byte[0];
  private static final byte[] INSTANCE_LOCK;
  private static final int SLEEP_INTERVAL = 20;
  private static final String TAG = "DnsService";
  private static final byte[] TASKLIST_LOCK = new byte[0];
  private static final String THREADPOOL_NAME_COMMON = "resolver_threadpool_name_common";
  private static final String THREADPOOL_NAME_INTERNAL = "resolver_threadpool_name_internal";
  private static final int THREADPOOL_SIZE_COMMON = 2;
  private static final int THREADPOOL_SIZE_INTERANL = 4;
  private static final int TIME_OUT = 20000;
  private static final int TRY_TIMES = 1;
  private static DnsService sIntance = null;
  private List<ResolverDomainTask> mActiveTaskList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, IpRecord> mDomainMap = new ConcurrentHashMap();
  private Executor mExecutor;
  private List<Pattern> mFilter;
  private String mKey = "none";
  private final HashMap<String, ThreadPool> mThreadPoolMap = new HashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> mTryTimes = new ConcurrentHashMap();
  private List<String> waitingList = Collections.synchronizedList(new ArrayList());
  
  static
  {
    INSTANCE_LOCK = new byte[0];
  }
  
  private DnsService()
  {
    initFilter();
  }
  
  private void addCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Iterator localIterator;
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) != null)
        {
          localConcurrentHashMap = (ConcurrentHashMap)this.mTryTimes.get(paramString);
          localIterator = localConcurrentHashMap.entrySet().iterator();
          if (localIterator.hasNext()) {}
        }
        else
        {
          return;
        }
      }
      Object localObject = (Map.Entry)localIterator.next();
      Long localLong = (Long)((Map.Entry)localObject).getKey();
      localObject = (Integer)((Map.Entry)localObject).getValue();
      int i = 0;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
      i += 1;
      localConcurrentHashMap.put(localLong, Integer.valueOf(i));
      QDLog.v("DnsService", "DNSService domain:" + paramString + " key:" + localLong + " times:" + i);
    }
  }
  
  private void clearCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (DATA_LOCK)
    {
      if (this.mTryTimes.get(paramString) != null)
      {
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        Long localLong = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localLong) != null) {
          paramString.remove(localLong);
        }
      }
      return;
    }
  }
  
  private boolean enableCustomDns()
  {
    if (DownloaderFactory.getDownloadConfig() != null) {
      return DownloaderFactory.getDownloadConfig().enableDns114();
    }
    return true;
  }
  
  private boolean ensureNotRepeat(String paramString)
  {
    return !isQuerying(paramString);
  }
  
  private int getCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = 0;
    for (;;)
    {
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) == null) {
          break label119;
        }
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label105;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          i = localInteger.intValue();
          return i;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      continue;
      label105:
      paramString.put(localObject, Integer.valueOf(0));
      continue;
      label119:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.mTryTimes.put(paramString, localObject);
    }
  }
  
  private ThreadPool getDomainResolverThreadPool(String paramString)
  {
    String str = getThreadPoolName(paramString);
    ThreadPool localThreadPool = (ThreadPool)this.mThreadPoolMap.get(str);
    paramString = localThreadPool;
    int i;
    if (localThreadPool == null)
    {
      i = 2;
      if ("resolver_threadpool_name_internal".equals(str)) {
        i = 4;
      }
      if (this.mExecutor == null) {
        break label72;
      }
    }
    label72:
    for (paramString = new ThreadPool(this.mExecutor);; paramString = new ThreadPool(str, i, i, new LinkedBlockingQueue()))
    {
      this.mThreadPoolMap.put(str, paramString);
      return paramString;
    }
  }
  
  private String getIPFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    IpRecord localIpRecord;
    do
    {
      return null;
      localIpRecord = (IpRecord)this.mDomainMap.get(paramString);
    } while (localIpRecord == null);
    if (localIpRecord.isValid()) {
      return localIpRecord.ip;
    }
    this.mDomainMap.remove(paramString);
    return null;
  }
  
  /* Error */
  public static DnsService getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	com/qzone/common/DnsService:sIntance	Lcom/qzone/common/DnsService;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 63	com/qzone/common/DnsService:INSTANCE_LOCK	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 61	com/qzone/common/DnsService:sIntance	Lcom/qzone/common/DnsService;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/qzone/common/DnsService
    //   24: dup
    //   25: invokespecial 280	com/qzone/common/DnsService:<init>	()V
    //   28: putstatic 61	com/qzone/common/DnsService:sIntance	Lcom/qzone/common/DnsService;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 61	com/qzone/common/DnsService:sIntance	Lcom/qzone/common/DnsService;
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
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private String getKey()
  {
    String str = null;
    if (NetworkManager.isMobile()) {
      str = NetworkManager.getApnValue();
    }
    while (!NetworkManager.isWifi()) {
      return str;
    }
    return NetworkManager.getBSSID();
  }
  
  private String getThreadPoolName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "resolver_threadpool_name_common";
    }
    Iterator localIterator = this.mFilter.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return "resolver_threadpool_name_common";
      }
    } while (!Utils.match((Pattern)localIterator.next(), paramString));
    return "resolver_threadpool_name_internal";
  }
  
  private void initFilter()
  {
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = "t[0-9].qpic.cn";
    arrayOfString[3] = "qlogo[0-9].store.qq.com";
    arrayOfString[4] = "mmsns.qpic.cn";
    arrayOfString[5] = "ugc.qpic.cn";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    this.mFilter = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length) {
        return;
      }
      Pattern localPattern = Pattern.compile(arrayOfString[i], 2);
      this.mFilter.add(localPattern);
      i += 1;
    }
  }
  
  private boolean isIPValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("192.168")) || (paramString.equals("127.0.0.1")) || (paramString.equals("0.0.0.0")) || (paramString.equals("255.255.255.255"))) {
      return false;
    }
    return true;
  }
  
  private void setResolveResult(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (isIPValid(paramString2))) {
      this.mDomainMap.put(paramString1, new IpRecord(paramString2, System.currentTimeMillis()));
    }
    this.waitingList.remove(paramString1);
    addCurrTryTimes(paramString1);
  }
  
  public void addQuery(String paramString)
  {
    ThreadPool localThreadPool;
    String str1;
    if ((!TextUtils.isEmpty(paramString)) && (ensureNotRepeat(paramString)))
    {
      this.waitingList.add(paramString);
      localThreadPool = getDomainResolverThreadPool(paramString);
      QDLog.v("DnsService", "add query:" + paramString);
      String str2 = NetworkManager.getApnValue();
      str1 = str2;
      if ("wifi".equals(str2)) {
        str1 = NetworkManager.getBSSID();
      }
    }
    try
    {
      localThreadPool.submit(new ResolverDomainTask(paramString, str1));
      return;
    }
    catch (Throwable paramString)
    {
      QDLog.e("DnsService", "exception when add query to DNSService.", paramString);
    }
  }
  
  public String getDomainIP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l2 = System.currentTimeMillis();
    String str2 = getIPFromCache(paramString);
    String str1 = str2;
    long l1;
    if (TextUtils.isEmpty(str2)) {
      l1 = 0L;
    }
    for (;;)
    {
      str2 = getIPFromCache(paramString);
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (l1 <= 20000L)
        {
          if (getCurrTryTimes(paramString) < 1) {
            break label149;
          }
          str1 = str2;
        }
      }
      clearCurrTryTimes(paramString);
      QDLog.i("DnsService", "DNSService domain:" + paramString + " ip:" + str1 + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
      return str1;
      try
      {
        label149:
        addQuery(paramString);
        Thread.sleep(20L);
        l1 += 20L;
      }
      catch (InterruptedException localInterruptedException)
      {
        QDLog.e("DnsService", "DNSService getDomainIP InterruptedException", localInterruptedException);
      }
    }
  }
  
  public boolean isQuerying(String paramString)
  {
    return this.waitingList.contains(paramString);
  }
  
  public void reset()
  {
    String str = getKey();
    QDLog.v("DnsService", "DNSService reset. Key:" + this.mKey + " currKey:" + str);
    if ((str == null) || (!str.equalsIgnoreCase(this.mKey))) {}
    synchronized (TASKLIST_LOCK)
    {
      Iterator localIterator = this.mActiveTaskList.iterator();
      if (!localIterator.hasNext())
      {
        this.mKey = str;
        this.mDomainMap.clear();
        addQuery("m.qpic.cn");
        return;
      }
      ((ResolverDomainTask)localIterator.next()).setIsExpired(true);
    }
  }
  
  public void setThreadPoolExecutor(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
  }
  
  public class IpRecord
  {
    public long createTime;
    public String ip;
    
    public IpRecord(String paramString, long paramLong)
    {
      this.ip = paramString;
      this.createTime = paramLong;
    }
    
    public boolean isValid()
    {
      long l = System.currentTimeMillis() - this.createTime;
      return (l >= 0L) && (l <= 3600000L) && (!TextUtils.isEmpty(this.ip));
    }
  }
  
  private class ResolverDomainTask
    implements ThreadPool.Job<Object>
  {
    private String mApn;
    private String mDomain;
    private volatile boolean mIsExpired = false;
    
    public ResolverDomainTask(String paramString1, String paramString2)
    {
      this.mDomain = paramString1;
      this.mApn = paramString2;
    }
    
    /* Error */
    public Object run(com.qzone.utils.thread.ThreadPool.JobContext arg1)
    {
      // Byte code:
      //   0: invokestatic 45	com/qzone/common/DnsService:access$0	()[B
      //   3: astore_1
      //   4: aload_1
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   10: invokestatic 49	com/qzone/common/DnsService:access$1	(Lcom/qzone/common/DnsService;)Ljava/util/List;
      //   13: aload_0
      //   14: invokeinterface 55 2 0
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
      //   49: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   52: astore_1
      //   53: aload_1
      //   54: astore 8
      //   56: ldc 63
      //   58: aload_1
      //   59: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   62: ifeq +8 -> 70
      //   65: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   68: astore 8
      //   70: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   73: lstore 4
      //   75: aload 6
      //   77: astore_1
      //   78: aload_0
      //   79: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   82: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   85: ifne +26 -> 111
      //   88: aload_0
      //   89: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   92: invokestatic 89	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   95: astore 16
      //   97: aload 6
      //   99: astore_1
      //   100: aload 16
      //   102: ifnull +9 -> 111
      //   105: aload 16
      //   107: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   110: astore_1
      //   111: ldc 94
      //   113: new 96	java/lang/StringBuilder
      //   116: dup
      //   117: ldc 98
      //   119: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   122: aload_1
      //   123: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   129: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   132: aload_1
      //   133: astore 6
      //   135: aload_0
      //   136: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   139: aload_1
      //   140: invokestatic 118	com/qzone/common/DnsService:access$2	(Lcom/qzone/common/DnsService;Ljava/lang/String;)Z
      //   143: ifne +131 -> 274
      //   146: aload_1
      //   147: astore 6
      //   149: aload_0
      //   150: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   153: invokestatic 122	com/qzone/common/DnsService:access$3	(Lcom/qzone/common/DnsService;)Z
      //   156: ifeq +118 -> 274
      //   159: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   162: lload 4
      //   164: lsub
      //   165: lstore_2
      //   166: aload_1
      //   167: astore 7
      //   169: aload_0
      //   170: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   173: astore 6
      //   175: ldc2_w 123
      //   178: lload_2
      //   179: lsub
      //   180: ldc2_w 125
      //   183: lcmp
      //   184: iflt +1637 -> 1821
      //   187: ldc2_w 123
      //   190: lload_2
      //   191: lsub
      //   192: lstore_2
      //   193: aload_1
      //   194: astore 7
      //   196: aload 6
      //   198: lload_2
      //   199: invokestatic 132	com/qzone/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   202: astore 9
      //   204: aload_1
      //   205: astore 6
      //   207: aload 9
      //   209: ifnull +65 -> 274
      //   212: aload_1
      //   213: astore 6
      //   215: aload_1
      //   216: astore 7
      //   218: aload 9
      //   220: arraylength
      //   221: ifle +53 -> 274
      //   224: aload_1
      //   225: astore 7
      //   227: aload 9
      //   229: iconst_0
      //   230: aaload
      //   231: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   234: astore 6
      //   236: aload 6
      //   238: astore 7
      //   240: ldc 94
      //   242: new 96	java/lang/StringBuilder
      //   245: dup
      //   246: ldc 134
      //   248: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   251: aload_0
      //   252: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   255: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   258: ldc 136
      //   260: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: aload 6
      //   265: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   271: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   274: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   277: astore 7
      //   279: aload 7
      //   281: astore_1
      //   282: ldc 63
      //   284: aload 7
      //   286: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   289: ifeq +7 -> 296
      //   292: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   295: astore_1
      //   296: ldc 94
      //   298: new 96	java/lang/StringBuilder
      //   301: dup
      //   302: ldc 138
      //   304: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   307: aload_0
      //   308: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   311: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   314: ldc 140
      //   316: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: aload 6
      //   321: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   324: ldc 142
      //   326: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   332: lload 4
      //   334: lsub
      //   335: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   338: ldc 147
      //   340: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   343: aload 8
      //   345: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: ldc 149
      //   350: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   353: aload_1
      //   354: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   357: ldc 151
      //   359: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   362: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   365: invokevirtual 160	java/lang/Thread:getId	()J
      //   368: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   371: ldc 162
      //   373: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   376: aload_0
      //   377: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   380: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   383: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   386: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   389: aload_0
      //   390: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   393: ifne +1451 -> 1844
      //   396: aload_0
      //   397: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   400: aload_0
      //   401: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   404: aload 6
      //   406: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   409: invokestatic 45	com/qzone/common/DnsService:access$0	()[B
      //   412: astore_1
      //   413: aload_1
      //   414: monitorenter
      //   415: aload_0
      //   416: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   419: invokestatic 49	com/qzone/common/DnsService:access$1	(Lcom/qzone/common/DnsService;)Ljava/util/List;
      //   422: aload_0
      //   423: invokeinterface 171 2 0
      //   428: pop
      //   429: aload_1
      //   430: monitorexit
      //   431: aconst_null
      //   432: areturn
      //   433: astore 6
      //   435: aload_1
      //   436: monitorexit
      //   437: aload 6
      //   439: athrow
      //   440: astore_1
      //   441: ldc 94
      //   443: ldc 173
      //   445: aload_1
      //   446: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   449: ldc 94
      //   451: new 96	java/lang/StringBuilder
      //   454: dup
      //   455: ldc 98
      //   457: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   460: aconst_null
      //   461: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   464: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   467: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   470: aload 10
      //   472: astore_1
      //   473: aload_0
      //   474: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   477: aconst_null
      //   478: invokestatic 118	com/qzone/common/DnsService:access$2	(Lcom/qzone/common/DnsService;Ljava/lang/String;)Z
      //   481: ifne +130 -> 611
      //   484: aload 10
      //   486: astore_1
      //   487: aload_0
      //   488: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   491: invokestatic 122	com/qzone/common/DnsService:access$3	(Lcom/qzone/common/DnsService;)Z
      //   494: ifeq +117 -> 611
      //   497: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   500: lload 4
      //   502: lsub
      //   503: lstore_2
      //   504: aload 11
      //   506: astore 6
      //   508: aload_0
      //   509: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   512: astore_1
      //   513: ldc2_w 123
      //   516: lload_2
      //   517: lsub
      //   518: ldc2_w 125
      //   521: lcmp
      //   522: iflt +228 -> 750
      //   525: ldc2_w 123
      //   528: lload_2
      //   529: lsub
      //   530: lstore_2
      //   531: aload 11
      //   533: astore 6
      //   535: aload_1
      //   536: lload_2
      //   537: invokestatic 132	com/qzone/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   540: astore 7
      //   542: aload 10
      //   544: astore_1
      //   545: aload 7
      //   547: ifnull +64 -> 611
      //   550: aload 10
      //   552: astore_1
      //   553: aload 11
      //   555: astore 6
      //   557: aload 7
      //   559: arraylength
      //   560: ifle +51 -> 611
      //   563: aload 11
      //   565: astore 6
      //   567: aload 7
      //   569: iconst_0
      //   570: aaload
      //   571: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   574: astore_1
      //   575: aload_1
      //   576: astore 6
      //   578: ldc 94
      //   580: new 96	java/lang/StringBuilder
      //   583: dup
      //   584: ldc 134
      //   586: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   589: aload_0
      //   590: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   593: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   596: ldc 136
      //   598: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   601: aload_1
      //   602: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   605: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   608: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   611: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   614: astore 7
      //   616: aload 7
      //   618: astore 6
      //   620: ldc 63
      //   622: aload 7
      //   624: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   627: ifeq +8 -> 635
      //   630: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   633: astore 6
      //   635: ldc 94
      //   637: new 96	java/lang/StringBuilder
      //   640: dup
      //   641: ldc 138
      //   643: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   646: aload_0
      //   647: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   650: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   653: ldc 140
      //   655: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   658: aload_1
      //   659: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   662: ldc 142
      //   664: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   667: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   670: lload 4
      //   672: lsub
      //   673: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   676: ldc 147
      //   678: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   681: aload 8
      //   683: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   686: ldc 149
      //   688: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   691: aload 6
      //   693: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   696: ldc 151
      //   698: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   701: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   704: invokevirtual 160	java/lang/Thread:getId	()J
      //   707: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   710: ldc 162
      //   712: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   715: aload_0
      //   716: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   719: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   722: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   725: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   728: aload_0
      //   729: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   732: ifne +40 -> 772
      //   735: aload_0
      //   736: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   739: aload_0
      //   740: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   743: aload_1
      //   744: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   747: goto -338 -> 409
      //   750: ldc2_w 125
      //   753: lstore_2
      //   754: goto -223 -> 531
      //   757: astore_1
      //   758: ldc 94
      //   760: ldc 179
      //   762: aload_1
      //   763: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   766: aload 6
      //   768: astore_1
      //   769: goto -158 -> 611
      //   772: aload_0
      //   773: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   776: aload_0
      //   777: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   780: aconst_null
      //   781: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   784: goto -375 -> 409
      //   787: astore_1
      //   788: ldc 94
      //   790: ldc 173
      //   792: aload_1
      //   793: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   796: ldc 94
      //   798: new 96	java/lang/StringBuilder
      //   801: dup
      //   802: ldc 98
      //   804: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   807: aconst_null
      //   808: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   811: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   814: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   817: aload 12
      //   819: astore_1
      //   820: aload_0
      //   821: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   824: aconst_null
      //   825: invokestatic 118	com/qzone/common/DnsService:access$2	(Lcom/qzone/common/DnsService;Ljava/lang/String;)Z
      //   828: ifne +130 -> 958
      //   831: aload 12
      //   833: astore_1
      //   834: aload_0
      //   835: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   838: invokestatic 122	com/qzone/common/DnsService:access$3	(Lcom/qzone/common/DnsService;)Z
      //   841: ifeq +117 -> 958
      //   844: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   847: lload 4
      //   849: lsub
      //   850: lstore_2
      //   851: aload 13
      //   853: astore 6
      //   855: aload_0
      //   856: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   859: astore_1
      //   860: ldc2_w 123
      //   863: lload_2
      //   864: lsub
      //   865: ldc2_w 125
      //   868: lcmp
      //   869: iflt +228 -> 1097
      //   872: ldc2_w 123
      //   875: lload_2
      //   876: lsub
      //   877: lstore_2
      //   878: aload 13
      //   880: astore 6
      //   882: aload_1
      //   883: lload_2
      //   884: invokestatic 132	com/qzone/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   887: astore 7
      //   889: aload 12
      //   891: astore_1
      //   892: aload 7
      //   894: ifnull +64 -> 958
      //   897: aload 12
      //   899: astore_1
      //   900: aload 13
      //   902: astore 6
      //   904: aload 7
      //   906: arraylength
      //   907: ifle +51 -> 958
      //   910: aload 13
      //   912: astore 6
      //   914: aload 7
      //   916: iconst_0
      //   917: aaload
      //   918: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   921: astore_1
      //   922: aload_1
      //   923: astore 6
      //   925: ldc 94
      //   927: new 96	java/lang/StringBuilder
      //   930: dup
      //   931: ldc 134
      //   933: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   936: aload_0
      //   937: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   940: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   943: ldc 136
      //   945: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   948: aload_1
      //   949: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   952: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   955: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   958: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   961: astore 7
      //   963: aload 7
      //   965: astore 6
      //   967: ldc 63
      //   969: aload 7
      //   971: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   974: ifeq +8 -> 982
      //   977: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   980: astore 6
      //   982: ldc 94
      //   984: new 96	java/lang/StringBuilder
      //   987: dup
      //   988: ldc 138
      //   990: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   993: aload_0
      //   994: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   997: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1000: ldc 140
      //   1002: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1005: aload_1
      //   1006: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1009: ldc 142
      //   1011: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1014: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   1017: lload 4
      //   1019: lsub
      //   1020: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1023: ldc 147
      //   1025: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1028: aload 8
      //   1030: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1033: ldc 149
      //   1035: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1038: aload 6
      //   1040: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1043: ldc 151
      //   1045: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1048: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1051: invokevirtual 160	java/lang/Thread:getId	()J
      //   1054: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1057: ldc 162
      //   1059: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1062: aload_0
      //   1063: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1066: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1069: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1072: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1075: aload_0
      //   1076: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1079: ifne +40 -> 1119
      //   1082: aload_0
      //   1083: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1086: aload_0
      //   1087: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1090: aload_1
      //   1091: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1094: goto -685 -> 409
      //   1097: ldc2_w 125
      //   1100: lstore_2
      //   1101: goto -223 -> 878
      //   1104: astore_1
      //   1105: ldc 94
      //   1107: ldc 179
      //   1109: aload_1
      //   1110: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1113: aload 6
      //   1115: astore_1
      //   1116: goto -158 -> 958
      //   1119: aload_0
      //   1120: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1123: aload_0
      //   1124: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1127: aconst_null
      //   1128: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1131: goto -722 -> 409
      //   1134: astore_1
      //   1135: ldc 94
      //   1137: ldc 181
      //   1139: aload_1
      //   1140: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1143: ldc 94
      //   1145: new 96	java/lang/StringBuilder
      //   1148: dup
      //   1149: ldc 98
      //   1151: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1154: aconst_null
      //   1155: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1158: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1161: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1164: aload 14
      //   1166: astore_1
      //   1167: aload_0
      //   1168: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1171: aconst_null
      //   1172: invokestatic 118	com/qzone/common/DnsService:access$2	(Lcom/qzone/common/DnsService;Ljava/lang/String;)Z
      //   1175: ifne +130 -> 1305
      //   1178: aload 14
      //   1180: astore_1
      //   1181: aload_0
      //   1182: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1185: invokestatic 122	com/qzone/common/DnsService:access$3	(Lcom/qzone/common/DnsService;)Z
      //   1188: ifeq +117 -> 1305
      //   1191: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   1194: lload 4
      //   1196: lsub
      //   1197: lstore_2
      //   1198: aload 15
      //   1200: astore 6
      //   1202: aload_0
      //   1203: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1206: astore_1
      //   1207: ldc2_w 123
      //   1210: lload_2
      //   1211: lsub
      //   1212: ldc2_w 125
      //   1215: lcmp
      //   1216: iflt +228 -> 1444
      //   1219: ldc2_w 123
      //   1222: lload_2
      //   1223: lsub
      //   1224: lstore_2
      //   1225: aload 15
      //   1227: astore 6
      //   1229: aload_1
      //   1230: lload_2
      //   1231: invokestatic 132	com/qzone/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1234: astore 7
      //   1236: aload 14
      //   1238: astore_1
      //   1239: aload 7
      //   1241: ifnull +64 -> 1305
      //   1244: aload 14
      //   1246: astore_1
      //   1247: aload 15
      //   1249: astore 6
      //   1251: aload 7
      //   1253: arraylength
      //   1254: ifle +51 -> 1305
      //   1257: aload 15
      //   1259: astore 6
      //   1261: aload 7
      //   1263: iconst_0
      //   1264: aaload
      //   1265: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1268: astore_1
      //   1269: aload_1
      //   1270: astore 6
      //   1272: ldc 94
      //   1274: new 96	java/lang/StringBuilder
      //   1277: dup
      //   1278: ldc 134
      //   1280: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1283: aload_0
      //   1284: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1287: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1290: ldc 136
      //   1292: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1295: aload_1
      //   1296: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1299: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1302: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1305: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1308: astore 7
      //   1310: aload 7
      //   1312: astore 6
      //   1314: ldc 63
      //   1316: aload 7
      //   1318: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1321: ifeq +8 -> 1329
      //   1324: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1327: astore 6
      //   1329: ldc 94
      //   1331: new 96	java/lang/StringBuilder
      //   1334: dup
      //   1335: ldc 138
      //   1337: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1340: aload_0
      //   1341: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1344: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1347: ldc 140
      //   1349: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1352: aload_1
      //   1353: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1356: ldc 142
      //   1358: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1361: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   1364: lload 4
      //   1366: lsub
      //   1367: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1370: ldc 147
      //   1372: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1375: aload 8
      //   1377: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1380: ldc 149
      //   1382: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1385: aload 6
      //   1387: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1390: ldc 151
      //   1392: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1395: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1398: invokevirtual 160	java/lang/Thread:getId	()J
      //   1401: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1404: ldc 162
      //   1406: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1409: aload_0
      //   1410: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1413: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1416: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1419: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1422: aload_0
      //   1423: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1426: ifne +40 -> 1466
      //   1429: aload_0
      //   1430: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1433: aload_0
      //   1434: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1437: aload_1
      //   1438: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1441: goto -1032 -> 409
      //   1444: ldc2_w 125
      //   1447: lstore_2
      //   1448: goto -223 -> 1225
      //   1451: astore_1
      //   1452: ldc 94
      //   1454: ldc 179
      //   1456: aload_1
      //   1457: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1460: aload 6
      //   1462: astore_1
      //   1463: goto -158 -> 1305
      //   1466: aload_0
      //   1467: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1470: aload_0
      //   1471: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1474: aconst_null
      //   1475: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1478: goto -1069 -> 409
      //   1481: astore 10
      //   1483: ldc 94
      //   1485: new 96	java/lang/StringBuilder
      //   1488: dup
      //   1489: ldc 98
      //   1491: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1494: aconst_null
      //   1495: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1498: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1501: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1504: aload 7
      //   1506: astore_1
      //   1507: aload_0
      //   1508: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1511: aconst_null
      //   1512: invokestatic 118	com/qzone/common/DnsService:access$2	(Lcom/qzone/common/DnsService;Ljava/lang/String;)Z
      //   1515: ifne +130 -> 1645
      //   1518: aload 7
      //   1520: astore_1
      //   1521: aload_0
      //   1522: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1525: invokestatic 122	com/qzone/common/DnsService:access$3	(Lcom/qzone/common/DnsService;)Z
      //   1528: ifeq +117 -> 1645
      //   1531: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   1534: lload 4
      //   1536: lsub
      //   1537: lstore_2
      //   1538: aload 9
      //   1540: astore 6
      //   1542: aload_0
      //   1543: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1546: astore_1
      //   1547: ldc2_w 123
      //   1550: lload_2
      //   1551: lsub
      //   1552: ldc2_w 125
      //   1555: lcmp
      //   1556: iflt +228 -> 1784
      //   1559: ldc2_w 123
      //   1562: lload_2
      //   1563: lsub
      //   1564: lstore_2
      //   1565: aload 9
      //   1567: astore 6
      //   1569: aload_1
      //   1570: lload_2
      //   1571: invokestatic 132	com/qzone/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1574: astore 11
      //   1576: aload 7
      //   1578: astore_1
      //   1579: aload 11
      //   1581: ifnull +64 -> 1645
      //   1584: aload 7
      //   1586: astore_1
      //   1587: aload 9
      //   1589: astore 6
      //   1591: aload 11
      //   1593: arraylength
      //   1594: ifle +51 -> 1645
      //   1597: aload 9
      //   1599: astore 6
      //   1601: aload 11
      //   1603: iconst_0
      //   1604: aaload
      //   1605: invokevirtual 92	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1608: astore_1
      //   1609: aload_1
      //   1610: astore 6
      //   1612: ldc 94
      //   1614: new 96	java/lang/StringBuilder
      //   1617: dup
      //   1618: ldc 134
      //   1620: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1623: aload_0
      //   1624: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1627: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1630: ldc 136
      //   1632: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1635: aload_1
      //   1636: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1639: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1642: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1645: invokestatic 61	com/qzone/download/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1648: astore 7
      //   1650: aload 7
      //   1652: astore 6
      //   1654: ldc 63
      //   1656: aload 7
      //   1658: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1661: ifeq +8 -> 1669
      //   1664: invokestatic 71	com/qzone/download/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1667: astore 6
      //   1669: ldc 94
      //   1671: new 96	java/lang/StringBuilder
      //   1674: dup
      //   1675: ldc 138
      //   1677: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1680: aload_0
      //   1681: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1684: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1687: ldc 140
      //   1689: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1692: aload_1
      //   1693: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1696: ldc 142
      //   1698: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1701: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   1704: lload 4
      //   1706: lsub
      //   1707: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1710: ldc 147
      //   1712: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1715: aload 8
      //   1717: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1720: ldc 149
      //   1722: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1725: aload 6
      //   1727: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1730: ldc 151
      //   1732: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1735: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1738: invokevirtual 160	java/lang/Thread:getId	()J
      //   1741: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1744: ldc 162
      //   1746: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1749: aload_0
      //   1750: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1753: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1756: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1759: invokestatic 114	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1762: aload_0
      //   1763: getfield 26	com/qzone/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1766: ifne +40 -> 1806
      //   1769: aload_0
      //   1770: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1773: aload_0
      //   1774: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1777: aload_1
      //   1778: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1781: aload 10
      //   1783: athrow
      //   1784: ldc2_w 125
      //   1787: lstore_2
      //   1788: goto -223 -> 1565
      //   1791: astore_1
      //   1792: ldc 94
      //   1794: ldc 179
      //   1796: aload_1
      //   1797: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1800: aload 6
      //   1802: astore_1
      //   1803: goto -158 -> 1645
      //   1806: aload_0
      //   1807: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1810: aload_0
      //   1811: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1814: aconst_null
      //   1815: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1818: goto -37 -> 1781
      //   1821: ldc2_w 125
      //   1824: lstore_2
      //   1825: goto -1632 -> 193
      //   1828: astore_1
      //   1829: ldc 94
      //   1831: ldc 179
      //   1833: aload_1
      //   1834: invokestatic 177	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1837: aload 7
      //   1839: astore 6
      //   1841: goto -1567 -> 274
      //   1844: aload_0
      //   1845: getfield 21	com/qzone/common/DnsService$ResolverDomainTask:this$0	Lcom/qzone/common/DnsService;
      //   1848: aload_0
      //   1849: getfield 28	com/qzone/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1852: aconst_null
      //   1853: invokestatic 168	com/qzone/common/DnsService:access$4	(Lcom/qzone/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1856: goto -1447 -> 409
      //   1859: astore 6
      //   1861: aload_1
      //   1862: monitorexit
      //   1863: aload 6
      //   1865: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1866	0	this	ResolverDomainTask
      //   165	1660	2	l1	long
      //   73	1632	4	l2	long
      //   47	358	6	localObject1	Object
      //   433	5	6	localObject2	Object
      //   506	1334	6	localObject3	Object
      //   1859	5	6	localObject4	Object
      //   41	1797	7	localObject5	Object
      //   54	1662	8	localObject6	Object
      //   44	1554	9	arrayOfInetAddress1	java.net.InetAddress[]
      //   23	528	10	localObject7	Object
      //   1481	301	10	localObject8	Object
      //   26	1576	11	arrayOfInetAddress2	java.net.InetAddress[]
      //   29	869	12	localObject9	Object
      //   32	879	13	localObject10	Object
      //   35	1210	14	localObject11	Object
      //   38	1220	15	localObject12	Object
      //   95	11	16	localInetAddress	java.net.InetAddress
      // Exception table:
      //   from	to	target	type
      //   6	22	433	finally
      //   435	437	433	finally
      //   78	97	440	java/net/UnknownHostException
      //   105	111	440	java/net/UnknownHostException
      //   508	513	757	java/lang/Throwable
      //   535	542	757	java/lang/Throwable
      //   557	563	757	java/lang/Throwable
      //   567	575	757	java/lang/Throwable
      //   578	611	757	java/lang/Throwable
      //   78	97	787	java/lang/Exception
      //   105	111	787	java/lang/Exception
      //   855	860	1104	java/lang/Throwable
      //   882	889	1104	java/lang/Throwable
      //   904	910	1104	java/lang/Throwable
      //   914	922	1104	java/lang/Throwable
      //   925	958	1104	java/lang/Throwable
      //   78	97	1134	java/lang/Error
      //   105	111	1134	java/lang/Error
      //   1202	1207	1451	java/lang/Throwable
      //   1229	1236	1451	java/lang/Throwable
      //   1251	1257	1451	java/lang/Throwable
      //   1261	1269	1451	java/lang/Throwable
      //   1272	1305	1451	java/lang/Throwable
      //   78	97	1481	finally
      //   105	111	1481	finally
      //   441	449	1481	finally
      //   788	796	1481	finally
      //   1135	1143	1481	finally
      //   1542	1547	1791	java/lang/Throwable
      //   1569	1576	1791	java/lang/Throwable
      //   1591	1597	1791	java/lang/Throwable
      //   1601	1609	1791	java/lang/Throwable
      //   1612	1645	1791	java/lang/Throwable
      //   169	175	1828	java/lang/Throwable
      //   196	204	1828	java/lang/Throwable
      //   218	224	1828	java/lang/Throwable
      //   227	236	1828	java/lang/Throwable
      //   240	274	1828	java/lang/Throwable
      //   415	431	1859	finally
      //   1861	1863	1859	finally
    }
    
    public void setIsExpired(boolean paramBoolean)
    {
      this.mIsExpired = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.DnsService
 * JD-Core Version:    0.7.0.1
 */