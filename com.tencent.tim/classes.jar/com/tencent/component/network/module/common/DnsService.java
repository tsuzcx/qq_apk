package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
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
  private static final Pattern ipReg = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3}|(\\w{1,4}:){5}\\w{1,4})", 2);
  private static DnsService sIntance = null;
  private boolean enableHttpDns = false;
  private List<ResolverDomainTask> mActiveTaskList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, ArrayList<String>> mBackupIp = new ConcurrentHashMap();
  private HashSet<String> mBlackList = new HashSet();
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
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) != null)
        {
          ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mTryTimes.get(paramString);
          Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            Long localLong = (Long)((Map.Entry)localObject).getKey();
            localObject = (Integer)((Map.Entry)localObject).getValue();
            if (localObject == null) {
              break label183;
            }
            i = ((Integer)localObject).intValue();
            i += 1;
            localConcurrentHashMap.put(localLong, Integer.valueOf(i));
            if (!QDLog.isInfoEnable()) {
              continue;
            }
            QDLog.i("DnsService", "DNSService domain:" + paramString + " key:" + localLong + " times:" + i);
          }
        }
      }
      return;
      label183:
      int i = 0;
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
    return Config.enableDns114();
  }
  
  private boolean ensureNotRepeat(String paramString)
  {
    return !isQuerying(paramString);
  }
  
  private int getCurrTryTimes(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) == null) {
          break label122;
        }
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label108;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          i = localInteger.intValue();
          break;
          return i;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label108:
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label122:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.mTryTimes.put(paramString, localObject);
    }
    for (;;)
    {
      break;
      label167:
      i = 0;
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    IpRecord localIpRecord = (IpRecord)this.mDomainMap.get(paramString);
    if (localIpRecord == null) {
      return null;
    }
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
    //   3: getstatic 70	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 72	com/tencent/component/network/module/common/DnsService:INSTANCE_LOCK	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 70	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/component/network/module/common/DnsService
    //   24: dup
    //   25: invokespecial 309	com/tencent/component/network/module/common/DnsService:<init>	()V
    //   28: putstatic 70	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 70	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
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
    while (localIterator.hasNext()) {
      if (Utils.match((Pattern)localIterator.next(), paramString)) {
        return "resolver_threadpool_name_internal";
      }
    }
    return "resolver_threadpool_name_common";
  }
  
  private void initFilter()
  {
    int i = 0;
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = "t[0-9].qpic.cn";
    arrayOfString[3] = "qlogo[0-9].store.qq.com";
    arrayOfString[4] = "mmsns.qpic.cn";
    arrayOfString[5] = "ugc.qpic.cn";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    this.mFilter = new ArrayList();
    while (i < arrayOfString.length)
    {
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
      if (QDLog.isInfoEnable()) {
        QDLog.i("DnsService", "add query:" + paramString);
      }
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
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (ipReg.matcher(paramString).find());
    long l2 = System.currentTimeMillis();
    String str = getIPFromCache(paramString);
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      long l1 = 0L;
      for (;;)
      {
        localObject = getIPFromCache(paramString);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) || (l1 > 20000L) || (getCurrTryTimes(paramString) >= 1)) {
          break;
        }
        try
        {
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
    clearCurrTryTimes(paramString);
    QDLog.w("DnsService", "DNSService domain:" + paramString + " ip:" + localInterruptedException + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
    return localInterruptedException;
  }
  
  public boolean isQuerying(String paramString)
  {
    return this.waitingList.contains(paramString);
  }
  
  public void reset()
  {
    String str = getKey();
    if (QDLog.isInfoEnable()) {
      QDLog.i("DnsService", "DNSService reset. Key:" + this.mKey + " currKey:" + str);
    }
    if ((str == null) || (!str.equalsIgnoreCase(this.mKey))) {
      synchronized (TASKLIST_LOCK)
      {
        Iterator localIterator = this.mActiveTaskList.iterator();
        if (localIterator.hasNext()) {
          ((ResolverDomainTask)localIterator.next()).setIsExpired(true);
        }
      }
    }
    this.mKey = localObject;
    this.mDomainMap.clear();
    addQuery("m.qpic.cn");
  }
  
  public void setThreadPoolExecutor(Executor paramExecutor)
  {
    if (this.mExecutor != null) {
      this.mExecutor = paramExecutor;
    }
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
  
  class ResolverDomainTask
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
    
    private String tryHttpDNS(int paramInt)
    {
      if (paramInt == 0) {
        try
        {
          Object localObject1 = new URL("http://182.254.116.117/d?dn=" + this.mDomain + "&ttl=1");
          localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          ((HttpURLConnection)localObject1).setUseCaches(false);
          ((HttpURLConnection)localObject1).setDoInput(true);
          ((HttpURLConnection)localObject1).setConnectTimeout(10000);
          ((HttpURLConnection)localObject1).setReadTimeout(10000);
          ((HttpURLConnection)localObject1).connect();
          if ((((HttpURLConnection)localObject1).getContentLength() == 0) || (((HttpURLConnection)localObject1).getResponseCode() != 200)) {
            throw new Exception("HttpDNS get fail in " + paramInt);
          }
        }
        catch (Exception localException)
        {
          QDLog.e("DnsService", "httpDNS error", localException);
          localException.printStackTrace();
        }
      }
      Object localObject2;
      do
      {
        return null;
        localObject2 = new URL("http://182.254.116.116/d?dn=" + this.mDomain + "&ttl=1");
        break;
        localObject3 = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject2).getInputStream()));
        while (localBufferedReader != null)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          ((StringBuilder)localObject3).append(str);
        }
        ((HttpURLConnection)localObject2).disconnect();
        localObject2 = ((StringBuilder)localObject3).toString();
        if (((String)localObject2).length() == 0)
        {
          QDLog.i("DnsService", "httpDNS failed in " + paramInt);
          return null;
        }
        localObject2 = ((String)localObject2).split(",");
        localObject3 = localObject2[0];
        if (localObject2.length > 1) {
          Integer.valueOf(localObject2[1]).intValue();
        }
        localObject2 = ((String)localObject3).split(";");
      } while (localObject2.length <= 0);
      DnsService.this.mBackupIp.remove(this.mDomain);
      Object localObject3 = new ArrayList();
      paramInt = 0;
      for (;;)
      {
        if (paramInt < localObject2.length)
        {
          if (DnsService.this.isIPValid(localObject2[paramInt])) {
            ((ArrayList)localObject3).add(localObject2[paramInt]);
          }
        }
        else
        {
          DnsService.this.mBackupIp.put(this.mDomain, localObject3);
          if (((ArrayList)localObject3).size() <= 0) {
            break;
          }
          localObject2 = (String)((ArrayList)localObject3).get(0);
          return localObject2;
        }
        paramInt += 1;
      }
    }
    
    /* Error */
    public Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext arg1)
    {
      // Byte code:
      //   0: invokestatic 198	com/tencent/component/network/module/common/DnsService:access$200	()[B
      //   3: astore_1
      //   4: aload_1
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   10: invokestatic 202	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
      //   13: aload_0
      //   14: invokeinterface 205 2 0
      //   19: pop
      //   20: aload_1
      //   21: monitorexit
      //   22: aconst_null
      //   23: astore_1
      //   24: aconst_null
      //   25: astore 6
      //   27: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   30: astore 7
      //   32: aload 7
      //   34: astore 8
      //   36: ldc 212
      //   38: aload 7
      //   40: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   43: ifeq +8 -> 51
      //   46: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   49: astore 8
      //   51: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   54: lstore 4
      //   56: aload_0
      //   57: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   60: invokestatic 228	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   63: ifeq +162 -> 225
      //   66: aload 6
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   73: invokestatic 232	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
      //   76: aload_0
      //   77: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   80: invokevirtual 237	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   83: ifne +24 -> 107
      //   86: aload_0
      //   87: iconst_0
      //   88: invokespecial 239	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
      //   91: astore 6
      //   93: aload 6
      //   95: astore_1
      //   96: aload 6
      //   98: ifnonnull +9 -> 107
      //   101: aload_0
      //   102: iconst_1
      //   103: invokespecial 239	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
      //   106: astore_1
      //   107: aload_1
      //   108: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   111: ifne +99 -> 210
      //   114: ldc 93
      //   116: new 39	java/lang/StringBuilder
      //   119: dup
      //   120: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   123: ldc 247
      //   125: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: aload_1
      //   129: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   132: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   135: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   138: aload_0
      //   139: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   142: ifne +46 -> 188
      //   145: aload_0
      //   146: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   149: aload_0
      //   150: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   153: aload_1
      //   154: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   157: invokestatic 198	com/tencent/component/network/module/common/DnsService:access$200	()[B
      //   160: astore_1
      //   161: aload_1
      //   162: monitorenter
      //   163: aload_0
      //   164: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   167: invokestatic 202	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
      //   170: aload_0
      //   171: invokeinterface 252 2 0
      //   176: pop
      //   177: aload_1
      //   178: monitorexit
      //   179: aconst_null
      //   180: areturn
      //   181: astore 6
      //   183: aload_1
      //   184: monitorexit
      //   185: aload 6
      //   187: athrow
      //   188: aload_0
      //   189: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   192: aload_0
      //   193: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   196: aconst_null
      //   197: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   200: goto -43 -> 157
      //   203: astore 6
      //   205: aload_1
      //   206: monitorexit
      //   207: aload 6
      //   209: athrow
      //   210: aload_0
      //   211: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   214: invokestatic 232	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
      //   217: aload_0
      //   218: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   221: invokevirtual 253	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   224: pop
      //   225: aload_1
      //   226: astore 6
      //   228: aload_0
      //   229: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   232: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   235: ifne +27 -> 262
      //   238: aload_0
      //   239: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   242: invokestatic 259	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   245: astore 7
      //   247: aload_1
      //   248: astore 6
      //   250: aload 7
      //   252: ifnull +10 -> 262
      //   255: aload 7
      //   257: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   260: astore 6
      //   262: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   265: ifeq +29 -> 294
      //   268: ldc 93
      //   270: new 39	java/lang/StringBuilder
      //   273: dup
      //   274: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   277: ldc_w 268
      //   280: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   283: aload 6
      //   285: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   288: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   291: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   294: aload 6
      //   296: astore_1
      //   297: aload_0
      //   298: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   301: aload 6
      //   303: invokestatic 171	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
      //   306: ifne +154 -> 460
      //   309: aload 6
      //   311: astore_1
      //   312: aload_0
      //   313: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   316: invokestatic 271	com/tencent/component/network/module/common/DnsService:access$700	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   319: ifeq +141 -> 460
      //   322: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   325: lload 4
      //   327: lsub
      //   328: lstore_2
      //   329: aload 6
      //   331: astore 7
      //   333: aload_0
      //   334: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   337: astore_1
      //   338: ldc2_w 272
      //   341: lload_2
      //   342: lsub
      //   343: ldc2_w 274
      //   346: lcmp
      //   347: iflt +289 -> 636
      //   350: ldc2_w 272
      //   353: lload_2
      //   354: lsub
      //   355: lstore_2
      //   356: aload 6
      //   358: astore 7
      //   360: aload_1
      //   361: lload_2
      //   362: invokestatic 281	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   365: astore 9
      //   367: aload 6
      //   369: astore_1
      //   370: aload 9
      //   372: ifnull +88 -> 460
      //   375: aload 6
      //   377: astore_1
      //   378: aload 6
      //   380: astore 7
      //   382: aload 9
      //   384: arraylength
      //   385: ifle +75 -> 460
      //   388: aload 6
      //   390: astore 7
      //   392: aload 9
      //   394: iconst_0
      //   395: aaload
      //   396: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   399: astore 6
      //   401: aload 6
      //   403: astore_1
      //   404: aload 6
      //   406: astore 7
      //   408: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   411: ifeq +49 -> 460
      //   414: aload 6
      //   416: astore 7
      //   418: ldc 93
      //   420: new 39	java/lang/StringBuilder
      //   423: dup
      //   424: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   427: ldc_w 283
      //   430: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   433: aload_0
      //   434: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   437: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   440: ldc_w 285
      //   443: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   446: aload 6
      //   448: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   451: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   454: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   457: aload 6
      //   459: astore_1
      //   460: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   463: astore 7
      //   465: aload 7
      //   467: astore 6
      //   469: ldc 212
      //   471: aload 7
      //   473: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   476: ifeq +8 -> 484
      //   479: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   482: astore 6
      //   484: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   487: ifeq +106 -> 593
      //   490: ldc 93
      //   492: new 39	java/lang/StringBuilder
      //   495: dup
      //   496: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   499: ldc_w 287
      //   502: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   505: aload_0
      //   506: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   509: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   512: ldc_w 289
      //   515: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   518: aload_1
      //   519: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   522: ldc_w 291
      //   525: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   528: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   531: lload 4
      //   533: lsub
      //   534: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   537: ldc_w 296
      //   540: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   543: aload 8
      //   545: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   548: ldc_w 298
      //   551: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   554: aload 6
      //   556: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   559: ldc_w 300
      //   562: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   565: invokestatic 306	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   568: invokevirtual 309	java/lang/Thread:getId	()J
      //   571: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   574: ldc_w 311
      //   577: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   580: aload_0
      //   581: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   584: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   587: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   590: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   593: aload_0
      //   594: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   597: ifne +62 -> 659
      //   600: aload_0
      //   601: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   604: aload_0
      //   605: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   608: aload_1
      //   609: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   612: invokestatic 198	com/tencent/component/network/module/common/DnsService:access$200	()[B
      //   615: astore_1
      //   616: aload_1
      //   617: monitorenter
      //   618: aload_0
      //   619: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   622: invokestatic 202	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
      //   625: aload_0
      //   626: invokeinterface 252 2 0
      //   631: pop
      //   632: aload_1
      //   633: monitorexit
      //   634: aconst_null
      //   635: areturn
      //   636: ldc2_w 274
      //   639: lstore_2
      //   640: goto -284 -> 356
      //   643: astore_1
      //   644: ldc 93
      //   646: ldc_w 316
      //   649: aload_1
      //   650: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   653: aload 7
      //   655: astore_1
      //   656: goto -196 -> 460
      //   659: aload_0
      //   660: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   663: aload_0
      //   664: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   667: aconst_null
      //   668: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   671: goto -59 -> 612
      //   674: astore 6
      //   676: ldc 93
      //   678: ldc_w 318
      //   681: aload 6
      //   683: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   686: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   689: ifeq +28 -> 717
      //   692: ldc 93
      //   694: new 39	java/lang/StringBuilder
      //   697: dup
      //   698: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   701: ldc_w 268
      //   704: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   707: aload_1
      //   708: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   711: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   714: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   717: aload_1
      //   718: astore 6
      //   720: aload_0
      //   721: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   724: aload_1
      //   725: invokestatic 171	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
      //   728: ifne +148 -> 876
      //   731: aload_1
      //   732: astore 6
      //   734: aload_0
      //   735: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   738: invokestatic 271	com/tencent/component/network/module/common/DnsService:access$700	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   741: ifeq +135 -> 876
      //   744: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   747: lload 4
      //   749: lsub
      //   750: lstore_2
      //   751: aload_1
      //   752: astore 7
      //   754: aload_0
      //   755: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   758: astore 6
      //   760: ldc2_w 272
      //   763: lload_2
      //   764: lsub
      //   765: ldc2_w 274
      //   768: lcmp
      //   769: iflt +261 -> 1030
      //   772: ldc2_w 272
      //   775: lload_2
      //   776: lsub
      //   777: lstore_2
      //   778: aload_1
      //   779: astore 7
      //   781: aload 6
      //   783: lload_2
      //   784: invokestatic 281	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   787: astore 9
      //   789: aload_1
      //   790: astore 6
      //   792: aload 9
      //   794: ifnull +82 -> 876
      //   797: aload_1
      //   798: astore 6
      //   800: aload_1
      //   801: astore 7
      //   803: aload 9
      //   805: arraylength
      //   806: ifle +70 -> 876
      //   809: aload_1
      //   810: astore 7
      //   812: aload 9
      //   814: iconst_0
      //   815: aaload
      //   816: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   819: astore_1
      //   820: aload_1
      //   821: astore 6
      //   823: aload_1
      //   824: astore 7
      //   826: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   829: ifeq +47 -> 876
      //   832: aload_1
      //   833: astore 7
      //   835: ldc 93
      //   837: new 39	java/lang/StringBuilder
      //   840: dup
      //   841: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   844: ldc_w 283
      //   847: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   850: aload_0
      //   851: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   854: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   857: ldc_w 285
      //   860: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   863: aload_1
      //   864: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   867: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   870: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   873: aload_1
      //   874: astore 6
      //   876: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   879: astore 7
      //   881: aload 7
      //   883: astore_1
      //   884: ldc 212
      //   886: aload 7
      //   888: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   891: ifeq +7 -> 898
      //   894: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   897: astore_1
      //   898: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   901: ifeq +106 -> 1007
      //   904: ldc 93
      //   906: new 39	java/lang/StringBuilder
      //   909: dup
      //   910: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   913: ldc_w 287
      //   916: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   919: aload_0
      //   920: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   923: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   926: ldc_w 289
      //   929: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   932: aload 6
      //   934: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   937: ldc_w 291
      //   940: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   943: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   946: lload 4
      //   948: lsub
      //   949: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   952: ldc_w 296
      //   955: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   958: aload 8
      //   960: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   963: ldc_w 298
      //   966: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   969: aload_1
      //   970: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   973: ldc_w 300
      //   976: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   979: invokestatic 306	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   982: invokevirtual 309	java/lang/Thread:getId	()J
      //   985: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   988: ldc_w 311
      //   991: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   994: aload_0
      //   995: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   998: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1001: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1004: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1007: aload_0
      //   1008: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1011: ifne +43 -> 1054
      //   1014: aload_0
      //   1015: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1018: aload_0
      //   1019: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1022: aload 6
      //   1024: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1027: goto -415 -> 612
      //   1030: ldc2_w 274
      //   1033: lstore_2
      //   1034: goto -256 -> 778
      //   1037: astore_1
      //   1038: ldc 93
      //   1040: ldc_w 316
      //   1043: aload_1
      //   1044: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1047: aload 7
      //   1049: astore 6
      //   1051: goto -175 -> 876
      //   1054: aload_0
      //   1055: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1058: aload_0
      //   1059: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1062: aconst_null
      //   1063: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1066: goto -454 -> 612
      //   1069: astore 6
      //   1071: ldc 93
      //   1073: ldc_w 318
      //   1076: aload 6
      //   1078: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1081: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1084: ifeq +28 -> 1112
      //   1087: ldc 93
      //   1089: new 39	java/lang/StringBuilder
      //   1092: dup
      //   1093: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1096: ldc_w 268
      //   1099: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1102: aload_1
      //   1103: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1106: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1109: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1112: aload_1
      //   1113: astore 6
      //   1115: aload_0
      //   1116: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1119: aload_1
      //   1120: invokestatic 171	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
      //   1123: ifne +148 -> 1271
      //   1126: aload_1
      //   1127: astore 6
      //   1129: aload_0
      //   1130: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1133: invokestatic 271	com/tencent/component/network/module/common/DnsService:access$700	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   1136: ifeq +135 -> 1271
      //   1139: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   1142: lload 4
      //   1144: lsub
      //   1145: lstore_2
      //   1146: aload_1
      //   1147: astore 7
      //   1149: aload_0
      //   1150: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1153: astore 6
      //   1155: ldc2_w 272
      //   1158: lload_2
      //   1159: lsub
      //   1160: ldc2_w 274
      //   1163: lcmp
      //   1164: iflt +261 -> 1425
      //   1167: ldc2_w 272
      //   1170: lload_2
      //   1171: lsub
      //   1172: lstore_2
      //   1173: aload_1
      //   1174: astore 7
      //   1176: aload 6
      //   1178: lload_2
      //   1179: invokestatic 281	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1182: astore 9
      //   1184: aload_1
      //   1185: astore 6
      //   1187: aload 9
      //   1189: ifnull +82 -> 1271
      //   1192: aload_1
      //   1193: astore 6
      //   1195: aload_1
      //   1196: astore 7
      //   1198: aload 9
      //   1200: arraylength
      //   1201: ifle +70 -> 1271
      //   1204: aload_1
      //   1205: astore 7
      //   1207: aload 9
      //   1209: iconst_0
      //   1210: aaload
      //   1211: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1214: astore_1
      //   1215: aload_1
      //   1216: astore 6
      //   1218: aload_1
      //   1219: astore 7
      //   1221: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1224: ifeq +47 -> 1271
      //   1227: aload_1
      //   1228: astore 7
      //   1230: ldc 93
      //   1232: new 39	java/lang/StringBuilder
      //   1235: dup
      //   1236: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1239: ldc_w 283
      //   1242: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1245: aload_0
      //   1246: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1249: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1252: ldc_w 285
      //   1255: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1258: aload_1
      //   1259: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1262: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1265: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1268: aload_1
      //   1269: astore 6
      //   1271: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1274: astore 7
      //   1276: aload 7
      //   1278: astore_1
      //   1279: ldc 212
      //   1281: aload 7
      //   1283: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1286: ifeq +7 -> 1293
      //   1289: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1292: astore_1
      //   1293: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1296: ifeq +106 -> 1402
      //   1299: ldc 93
      //   1301: new 39	java/lang/StringBuilder
      //   1304: dup
      //   1305: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1308: ldc_w 287
      //   1311: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1314: aload_0
      //   1315: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1318: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1321: ldc_w 289
      //   1324: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1327: aload 6
      //   1329: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1332: ldc_w 291
      //   1335: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1338: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   1341: lload 4
      //   1343: lsub
      //   1344: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1347: ldc_w 296
      //   1350: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1353: aload 8
      //   1355: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1358: ldc_w 298
      //   1361: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1364: aload_1
      //   1365: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1368: ldc_w 300
      //   1371: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1374: invokestatic 306	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1377: invokevirtual 309	java/lang/Thread:getId	()J
      //   1380: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1383: ldc_w 311
      //   1386: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1389: aload_0
      //   1390: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1393: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1396: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1399: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1402: aload_0
      //   1403: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1406: ifne +43 -> 1449
      //   1409: aload_0
      //   1410: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1413: aload_0
      //   1414: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1417: aload 6
      //   1419: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1422: goto -810 -> 612
      //   1425: ldc2_w 274
      //   1428: lstore_2
      //   1429: goto -256 -> 1173
      //   1432: astore_1
      //   1433: ldc 93
      //   1435: ldc_w 316
      //   1438: aload_1
      //   1439: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1442: aload 7
      //   1444: astore 6
      //   1446: goto -175 -> 1271
      //   1449: aload_0
      //   1450: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1453: aload_0
      //   1454: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1457: aconst_null
      //   1458: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1461: goto -849 -> 612
      //   1464: astore 6
      //   1466: ldc 93
      //   1468: ldc_w 320
      //   1471: aload 6
      //   1473: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1476: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1479: ifeq +28 -> 1507
      //   1482: ldc 93
      //   1484: new 39	java/lang/StringBuilder
      //   1487: dup
      //   1488: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1491: ldc_w 268
      //   1494: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1497: aload_1
      //   1498: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1501: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1504: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1507: aload_1
      //   1508: astore 6
      //   1510: aload_0
      //   1511: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1514: aload_1
      //   1515: invokestatic 171	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
      //   1518: ifne +148 -> 1666
      //   1521: aload_1
      //   1522: astore 6
      //   1524: aload_0
      //   1525: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1528: invokestatic 271	com/tencent/component/network/module/common/DnsService:access$700	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   1531: ifeq +135 -> 1666
      //   1534: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   1537: lload 4
      //   1539: lsub
      //   1540: lstore_2
      //   1541: aload_1
      //   1542: astore 7
      //   1544: aload_0
      //   1545: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1548: astore 6
      //   1550: ldc2_w 272
      //   1553: lload_2
      //   1554: lsub
      //   1555: ldc2_w 274
      //   1558: lcmp
      //   1559: iflt +261 -> 1820
      //   1562: ldc2_w 272
      //   1565: lload_2
      //   1566: lsub
      //   1567: lstore_2
      //   1568: aload_1
      //   1569: astore 7
      //   1571: aload 6
      //   1573: lload_2
      //   1574: invokestatic 281	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1577: astore 9
      //   1579: aload_1
      //   1580: astore 6
      //   1582: aload 9
      //   1584: ifnull +82 -> 1666
      //   1587: aload_1
      //   1588: astore 6
      //   1590: aload_1
      //   1591: astore 7
      //   1593: aload 9
      //   1595: arraylength
      //   1596: ifle +70 -> 1666
      //   1599: aload_1
      //   1600: astore 7
      //   1602: aload 9
      //   1604: iconst_0
      //   1605: aaload
      //   1606: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1609: astore_1
      //   1610: aload_1
      //   1611: astore 6
      //   1613: aload_1
      //   1614: astore 7
      //   1616: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1619: ifeq +47 -> 1666
      //   1622: aload_1
      //   1623: astore 7
      //   1625: ldc 93
      //   1627: new 39	java/lang/StringBuilder
      //   1630: dup
      //   1631: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1634: ldc_w 283
      //   1637: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1640: aload_0
      //   1641: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1644: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1647: ldc_w 285
      //   1650: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1653: aload_1
      //   1654: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1657: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1660: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1663: aload_1
      //   1664: astore 6
      //   1666: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1669: astore 7
      //   1671: aload 7
      //   1673: astore_1
      //   1674: ldc 212
      //   1676: aload 7
      //   1678: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1681: ifeq +7 -> 1688
      //   1684: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1687: astore_1
      //   1688: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1691: ifeq +106 -> 1797
      //   1694: ldc 93
      //   1696: new 39	java/lang/StringBuilder
      //   1699: dup
      //   1700: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1703: ldc_w 287
      //   1706: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1709: aload_0
      //   1710: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1713: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1716: ldc_w 289
      //   1719: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1722: aload 6
      //   1724: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1727: ldc_w 291
      //   1730: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1733: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   1736: lload 4
      //   1738: lsub
      //   1739: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1742: ldc_w 296
      //   1745: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1748: aload 8
      //   1750: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1753: ldc_w 298
      //   1756: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1759: aload_1
      //   1760: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1763: ldc_w 300
      //   1766: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1769: invokestatic 306	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1772: invokevirtual 309	java/lang/Thread:getId	()J
      //   1775: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1778: ldc_w 311
      //   1781: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1784: aload_0
      //   1785: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1788: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1791: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1794: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1797: aload_0
      //   1798: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   1801: ifne +43 -> 1844
      //   1804: aload_0
      //   1805: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1808: aload_0
      //   1809: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1812: aload 6
      //   1814: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1817: goto -1205 -> 612
      //   1820: ldc2_w 274
      //   1823: lstore_2
      //   1824: goto -256 -> 1568
      //   1827: astore_1
      //   1828: ldc 93
      //   1830: ldc_w 316
      //   1833: aload_1
      //   1834: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1837: aload 7
      //   1839: astore 6
      //   1841: goto -175 -> 1666
      //   1844: aload_0
      //   1845: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1848: aload_0
      //   1849: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1852: aconst_null
      //   1853: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   1856: goto -1244 -> 612
      //   1859: astore 9
      //   1861: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   1864: ifeq +28 -> 1892
      //   1867: ldc 93
      //   1869: new 39	java/lang/StringBuilder
      //   1872: dup
      //   1873: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   1876: ldc_w 268
      //   1879: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1882: aload_1
      //   1883: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1886: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1889: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1892: aload_1
      //   1893: astore 6
      //   1895: aload_0
      //   1896: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1899: aload_1
      //   1900: invokestatic 171	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
      //   1903: ifne +148 -> 2051
      //   1906: aload_1
      //   1907: astore 6
      //   1909: aload_0
      //   1910: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   1913: invokestatic 271	com/tencent/component/network/module/common/DnsService:access$700	(Lcom/tencent/component/network/module/common/DnsService;)Z
      //   1916: ifeq +135 -> 2051
      //   1919: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   1922: lload 4
      //   1924: lsub
      //   1925: lstore_2
      //   1926: aload_1
      //   1927: astore 7
      //   1929: aload_0
      //   1930: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   1933: astore 6
      //   1935: ldc2_w 272
      //   1938: lload_2
      //   1939: lsub
      //   1940: ldc2_w 274
      //   1943: lcmp
      //   1944: iflt +261 -> 2205
      //   1947: ldc2_w 272
      //   1950: lload_2
      //   1951: lsub
      //   1952: lstore_2
      //   1953: aload_1
      //   1954: astore 7
      //   1956: aload 6
      //   1958: lload_2
      //   1959: invokestatic 281	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1962: astore 10
      //   1964: aload_1
      //   1965: astore 6
      //   1967: aload 10
      //   1969: ifnull +82 -> 2051
      //   1972: aload_1
      //   1973: astore 6
      //   1975: aload_1
      //   1976: astore 7
      //   1978: aload 10
      //   1980: arraylength
      //   1981: ifle +70 -> 2051
      //   1984: aload_1
      //   1985: astore 7
      //   1987: aload 10
      //   1989: iconst_0
      //   1990: aaload
      //   1991: invokevirtual 262	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1994: astore_1
      //   1995: aload_1
      //   1996: astore 6
      //   1998: aload_1
      //   1999: astore 7
      //   2001: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   2004: ifeq +47 -> 2051
      //   2007: aload_1
      //   2008: astore 7
      //   2010: ldc 93
      //   2012: new 39	java/lang/StringBuilder
      //   2015: dup
      //   2016: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   2019: ldc_w 283
      //   2022: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2025: aload_0
      //   2026: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   2029: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2032: ldc_w 285
      //   2035: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2038: aload_1
      //   2039: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2042: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2045: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   2048: aload_1
      //   2049: astore 6
      //   2051: invokestatic 210	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   2054: astore 7
      //   2056: aload 7
      //   2058: astore_1
      //   2059: ldc 212
      //   2061: aload 7
      //   2063: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2066: ifeq +7 -> 2073
      //   2069: invokestatic 218	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   2072: astore_1
      //   2073: invokestatic 266	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
      //   2076: ifeq +106 -> 2182
      //   2079: ldc 93
      //   2081: new 39	java/lang/StringBuilder
      //   2084: dup
      //   2085: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   2088: ldc_w 287
      //   2091: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2094: aload_0
      //   2095: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   2098: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2101: ldc_w 289
      //   2104: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2107: aload 6
      //   2109: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2112: ldc_w 291
      //   2115: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2118: invokestatic 224	java/lang/System:currentTimeMillis	()J
      //   2121: lload 4
      //   2123: lsub
      //   2124: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2127: ldc_w 296
      //   2130: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2133: aload 8
      //   2135: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2138: ldc_w 298
      //   2141: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2144: aload_1
      //   2145: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2148: ldc_w 300
      //   2151: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2154: invokestatic 306	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   2157: invokevirtual 309	java/lang/Thread:getId	()J
      //   2160: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2163: ldc_w 311
      //   2166: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2169: aload_0
      //   2170: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   2173: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   2176: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2179: invokestatic 137	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   2182: aload_0
      //   2183: getfield 26	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
      //   2186: ifne +43 -> 2229
      //   2189: aload_0
      //   2190: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   2193: aload_0
      //   2194: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   2197: aload 6
      //   2199: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   2202: aload 9
      //   2204: athrow
      //   2205: ldc2_w 274
      //   2208: lstore_2
      //   2209: goto -256 -> 1953
      //   2212: astore_1
      //   2213: ldc 93
      //   2215: ldc_w 316
      //   2218: aload_1
      //   2219: invokestatic 101	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   2222: aload 7
      //   2224: astore 6
      //   2226: goto -175 -> 2051
      //   2229: aload_0
      //   2230: getfield 21	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
      //   2233: aload_0
      //   2234: getfield 28	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
      //   2237: aconst_null
      //   2238: invokestatic 250	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
      //   2241: goto -39 -> 2202
      //   2244: astore 6
      //   2246: aload_1
      //   2247: monitorexit
      //   2248: aload 6
      //   2250: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2251	0	this	ResolverDomainTask
      //   328	1881	2	l1	long
      //   54	2068	4	l2	long
      //   25	72	6	str	String
      //   181	5	6	localObject1	Object
      //   203	5	6	localObject2	Object
      //   226	329	6	localObject3	Object
      //   674	8	6	localUnknownHostException	java.net.UnknownHostException
      //   718	332	6	localObject4	Object
      //   1069	8	6	localException	Exception
      //   1113	332	6	localObject5	Object
      //   1464	8	6	localError	java.lang.Error
      //   1508	717	6	localObject6	Object
      //   2244	5	6	localObject7	Object
      //   30	2193	7	localObject8	Object
      //   34	2100	8	localObject9	Object
      //   365	1238	9	arrayOfInetAddress1	java.net.InetAddress[]
      //   1859	344	9	localObject10	Object
      //   1962	26	10	arrayOfInetAddress2	java.net.InetAddress[]
      // Exception table:
      //   from	to	target	type
      //   6	22	181	finally
      //   183	185	181	finally
      //   163	179	203	finally
      //   205	207	203	finally
      //   333	338	643	java/lang/Throwable
      //   360	367	643	java/lang/Throwable
      //   382	388	643	java/lang/Throwable
      //   392	401	643	java/lang/Throwable
      //   408	414	643	java/lang/Throwable
      //   418	457	643	java/lang/Throwable
      //   228	247	674	java/net/UnknownHostException
      //   255	262	674	java/net/UnknownHostException
      //   754	760	1037	java/lang/Throwable
      //   781	789	1037	java/lang/Throwable
      //   803	809	1037	java/lang/Throwable
      //   812	820	1037	java/lang/Throwable
      //   826	832	1037	java/lang/Throwable
      //   835	873	1037	java/lang/Throwable
      //   228	247	1069	java/lang/Exception
      //   255	262	1069	java/lang/Exception
      //   1149	1155	1432	java/lang/Throwable
      //   1176	1184	1432	java/lang/Throwable
      //   1198	1204	1432	java/lang/Throwable
      //   1207	1215	1432	java/lang/Throwable
      //   1221	1227	1432	java/lang/Throwable
      //   1230	1268	1432	java/lang/Throwable
      //   228	247	1464	java/lang/Error
      //   255	262	1464	java/lang/Error
      //   1544	1550	1827	java/lang/Throwable
      //   1571	1579	1827	java/lang/Throwable
      //   1593	1599	1827	java/lang/Throwable
      //   1602	1610	1827	java/lang/Throwable
      //   1616	1622	1827	java/lang/Throwable
      //   1625	1663	1827	java/lang/Throwable
      //   228	247	1859	finally
      //   255	262	1859	finally
      //   676	686	1859	finally
      //   1071	1081	1859	finally
      //   1466	1476	1859	finally
      //   1929	1935	2212	java/lang/Throwable
      //   1956	1964	2212	java/lang/Throwable
      //   1978	1984	2212	java/lang/Throwable
      //   1987	1995	2212	java/lang/Throwable
      //   2001	2007	2212	java/lang/Throwable
      //   2010	2048	2212	java/lang/Throwable
      //   618	634	2244	finally
      //   2246	2248	2244	finally
    }
    
    public void setIsExpired(boolean paramBoolean)
    {
      this.mIsExpired = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService
 * JD-Core Version:    0.7.0.1
 */