package com.tencent.mobileqq.activity.qwallet.config;

import Wallet.RspWalletConfig;
import aaah;
import aaai;
import aaai.a;
import aaai.b;
import aagi;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWalletConfig
  implements Serializable
{
  public static final int OCCASION_FOREGROUND = 4;
  public static final int OCCASION_FOREGROUND_WAIT = 1024;
  public static final int OCCASION_INVALID = -1;
  public static final int OCCASION_LOGIN = 1;
  public static final int OCCASION_LOGIN_WAIT = 256;
  public static final int OCCASION_PUSH = 0;
  public static final int OCCASION_RECONNECT = 2;
  public static final int OCCASION_RECONNECT_WAIT = 512;
  public static final int REFRESH_TYPE_DEFAULT = 0;
  public static final int REQ_TYPE_ALL = 0;
  public static final long REQ_TYPE_GOLDMSG = 1L;
  private static final byte[] cl = new byte[0];
  private static final long serialVersionUID = 1L;
  private int action;
  private transient int cfP;
  public String commonMsg;
  public Map<String, String> configs = new HashMap();
  private transient byte[] cu;
  private transient byte[] cv;
  private transient Map<String, List<aaai.b>> iv;
  private transient Map<String, Object> iw;
  public int lastAppId;
  public long lastReqTime;
  private Map<Long, Long> lastReqTimes = new HashMap();
  private Map<String, Long> localVersions = new HashMap();
  private transient String mCurUin;
  private transient String mSavePath;
  public int refreshTime;
  private Map<Long, Integer> refreshTimes = new HashMap();
  public int refreshType;
  public long seriesNo;
  
  private void D(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mSavePath = paramString;
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();; paramQQAppInterface = "")
    {
      this.mCurUin = paramQQAppInterface;
      this.iv = new HashMap();
      this.iw = new ConcurrentHashMap();
      this.cu = new byte[0];
      this.cv = new byte[0];
      if (this.localVersions == null) {
        this.localVersions = new HashMap();
      }
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, RspWalletConfig paramRspWalletConfig)
  {
    long l2 = 1L;
    long l1 = paramLong2;
    paramLong2 = l2;
    while (l1 != 0L) {
      if ((paramLong2 & l1) != 0L)
      {
        this.lastReqTimes.put(Long.valueOf(paramLong2), Long.valueOf(paramLong1));
        this.refreshTimes.put(Long.valueOf(paramLong2), Integer.valueOf(paramRspWalletConfig.refreshTime));
        l1 &= (0xFFFFFFFF ^ paramLong2);
        paramLong2 <<= 1;
      }
    }
  }
  
  /* Error */
  private void a(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: new 134	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 135	java/util/LinkedList:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 103	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:cv	[B
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: iload_2
    //   19: ifeq +176 -> 195
    //   22: aload_1
    //   23: ifnull +163 -> 186
    //   26: aload_0
    //   27: getfield 74	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   30: invokeinterface 139 1 0
    //   35: invokeinterface 145 1 0
    //   40: astore 7
    //   42: aload 7
    //   44: invokeinterface 151 1 0
    //   49: ifeq +89 -> 138
    //   52: aload 7
    //   54: invokeinterface 155 1 0
    //   59: checkcast 157	java/util/Map$Entry
    //   62: astore 8
    //   64: aload_1
    //   65: aload 8
    //   67: invokeinterface 160 1 0
    //   72: invokeinterface 164 2 0
    //   77: ifne -35 -> 42
    //   80: aload 6
    //   82: aload 8
    //   84: invokeinterface 160 1 0
    //   89: invokevirtual 167	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -51 -> 42
    //   96: astore_1
    //   97: aload 5
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +31 -> 137
    //   109: ldc 174
    //   111: iconst_2
    //   112: new 176	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   119: ldc 179
    //   121: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 186	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: return
    //   138: aload 6
    //   140: invokevirtual 194	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   143: astore 7
    //   145: aload 7
    //   147: invokeinterface 151 1 0
    //   152: ifeq +34 -> 186
    //   155: aload 7
    //   157: invokeinterface 155 1 0
    //   162: checkcast 196	java/lang/String
    //   165: astore 8
    //   167: aload_0
    //   168: getfield 80	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:localVersions	Ljava/util/Map;
    //   171: aload 8
    //   173: lload_3
    //   174: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   177: invokeinterface 118 3 0
    //   182: pop
    //   183: goto -38 -> 145
    //   186: aload_0
    //   187: getfield 74	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   190: invokeinterface 199 1 0
    //   195: aload_1
    //   196: ifnull +86 -> 282
    //   199: aload_1
    //   200: invokeinterface 139 1 0
    //   205: invokeinterface 145 1 0
    //   210: astore 7
    //   212: aload 7
    //   214: invokeinterface 151 1 0
    //   219: ifeq +63 -> 282
    //   222: aload 7
    //   224: invokeinterface 155 1 0
    //   229: checkcast 157	java/util/Map$Entry
    //   232: astore 8
    //   234: aload_0
    //   235: getfield 74	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   238: aload 8
    //   240: invokeinterface 160 1 0
    //   245: aload 8
    //   247: invokeinterface 202 1 0
    //   252: invokeinterface 118 3 0
    //   257: pop
    //   258: aload_0
    //   259: getfield 80	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:localVersions	Ljava/util/Map;
    //   262: aload 8
    //   264: invokeinterface 160 1 0
    //   269: lload_3
    //   270: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: invokeinterface 118 3 0
    //   278: pop
    //   279: goto -67 -> 212
    //   282: aload 5
    //   284: monitorexit
    //   285: aload_1
    //   286: astore 5
    //   288: iload_2
    //   289: ifeq +60 -> 349
    //   292: aload_1
    //   293: astore 5
    //   295: aload 6
    //   297: invokevirtual 206	java/util/LinkedList:size	()I
    //   300: ifle +49 -> 349
    //   303: new 71	java/util/HashMap
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 209	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   311: astore 5
    //   313: aload 6
    //   315: invokevirtual 194	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   318: astore_1
    //   319: aload_1
    //   320: invokeinterface 151 1 0
    //   325: ifeq +33 -> 358
    //   328: aload 5
    //   330: aload_1
    //   331: invokeinterface 155 1 0
    //   336: checkcast 196	java/lang/String
    //   339: aconst_null
    //   340: invokeinterface 118 3 0
    //   345: pop
    //   346: goto -27 -> 319
    //   349: aload_0
    //   350: aload 5
    //   352: iload_2
    //   353: lload_3
    //   354: invokespecial 212	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:b	(Ljava/util/Map;ZJ)V
    //   357: return
    //   358: goto -9 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	QWalletConfig
    //   0	361	1	paramMap	Map<String, String>
    //   0	361	2	paramBoolean	boolean
    //   0	361	3	paramLong	long
    //   13	338	5	localObject1	Object
    //   7	307	6	localLinkedList	LinkedList
    //   40	183	7	localIterator	Iterator
    //   62	201	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	42	96	finally
    //   42	93	96	finally
    //   97	100	96	finally
    //   138	145	96	finally
    //   145	183	96	finally
    //   186	195	96	finally
    //   199	212	96	finally
    //   212	279	96	finally
    //   282	285	96	finally
    //   0	18	102	java/lang/Throwable
    //   100	102	102	java/lang/Throwable
    //   295	319	102	java/lang/Throwable
    //   319	346	102	java/lang/Throwable
    //   349	357	102	java/lang/Throwable
  }
  
  private void b(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    Iterator localIterator;
    Map.Entry localEntry;
    if (paramMap != null)
    {
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        aaah.an(this.mCurUin, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (!paramBoolean) {
        break label89;
      }
      this.iw.clear();
    }
    for (;;)
    {
      notifyUpdateListeners(paramMap, paramLong);
      return;
      label89:
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.iw.remove(localEntry.getKey());
      }
    }
  }
  
  private void gE(long paramLong)
  {
    this.lastReqTime = paramLong;
    Iterator localIterator = this.lastReqTimes.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.lastReqTimes.put(localEntry.getKey(), Long.valueOf(paramLong));
    }
  }
  
  private static String getConfigPath(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramAppRuntime.getAccount()))) {
      return null;
    }
    paramAppRuntime = new StringBuilder(aagi.bcS).append(paramAppRuntime.getAccount()).append("/.config/");
    paramAppRuntime.append(".config");
    return paramAppRuntime.toString();
  }
  
  /* Error */
  public static QWalletConfig readConfig(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokestatic 267	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:getConfigPath	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +104 -> 119
    //   18: aload_3
    //   19: astore_1
    //   20: getstatic 65	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:cl	[B
    //   23: astore 5
    //   25: aload_3
    //   26: astore_1
    //   27: aload 5
    //   29: monitorenter
    //   30: aload 4
    //   32: invokestatic 273	aagd:o	(Ljava/lang/String;)Ljava/lang/Object;
    //   35: checkcast 2	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig
    //   38: astore_1
    //   39: aload 5
    //   41: monitorexit
    //   42: aload_1
    //   43: astore_2
    //   44: aload_1
    //   45: ifnonnull +11 -> 56
    //   48: new 2	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig
    //   51: dup
    //   52: invokespecial 274	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_0
    //   58: aload 4
    //   60: invokespecial 276	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   63: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 174
    //   71: iconst_2
    //   72: new 176	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 278
    //   82: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_3
    //   98: aload_2
    //   99: astore_1
    //   100: aload_1
    //   101: astore_2
    //   102: aload 5
    //   104: monitorexit
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   112: goto -70 -> 42
    //   115: astore_3
    //   116: goto -16 -> 100
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -79 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramQQAppInterface	QQAppInterface
    //   19	102	1	localObject1	Object
    //   3	99	2	localObject2	Object
    //   107	2	2	localException	java.lang.Exception
    //   1	25	3	localObject3	Object
    //   97	9	3	localObject4	Object
    //   115	1	3	localObject5	Object
    //   8	51	4	str	String
    //   23	80	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	39	97	finally
    //   102	105	97	finally
    //   20	25	107	java/lang/Exception
    //   27	30	107	java/lang/Exception
    //   105	107	107	java/lang/Exception
    //   39	42	115	finally
  }
  
  public void addUpdateListener(String paramString, aaai.b paramb)
  {
    synchronized (this.cu)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramb != null))
      {
        List localList = (List)this.iv.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.iv.put(paramString, localObject);
        }
        if (!((List)localObject).contains(paramb)) {
          ((List)localObject).add(paramb);
        }
      }
      return;
    }
  }
  
  public String getConfig(String paramString)
  {
    synchronized (this.cv)
    {
      paramString = (String)this.configs.get(paramString);
      return paramString;
    }
  }
  
  public a getConfigInfo(String paramString)
  {
    a locala = new a();
    locala.module = paramString;
    for (;;)
    {
      synchronized (this.cv)
      {
        locala.configStr = getConfig(paramString);
        paramString = (Long)this.localVersions.get(paramString);
        if (paramString != null)
        {
          l = paramString.longValue();
          locala.version = l;
          return locala;
        }
      }
      long l = 0L;
    }
  }
  
  public Object getParsedConfig(String paramString)
  {
    JSONArray localJSONArray = null;
    String str = getConfig(paramString);
    paramString = localJSONArray;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      paramString = new JSONObject(str);
      if (paramString != null) {}
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray(str);
          paramString = localJSONArray;
          return paramString;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
  
  public int getValidReqOcca(int paramInt)
  {
    if ((this.refreshType == 0) || (this.action == 3) || (isVersionUpdate())) {
      return paramInt;
    }
    int i;
    if (NetConnInfoCenter.getServerTimeMillis() - this.lastReqTime >= this.refreshTime * 1000)
    {
      i = 1;
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return -1;
          i = 0;
          break;
          if ((this.refreshType & 0x1) != 0) {
            return 1;
          }
        } while ((i == 0) || ((this.refreshType & 0x100) == 0));
        return 256;
        if ((this.refreshType & 0x2) != 0) {
          return 2;
        }
      } while ((i == 0) || ((this.refreshType & 0x200) == 0));
      return 512;
      if ((this.refreshType & 0x4) != 0) {
        return 4;
      }
    } while ((i == 0) || ((this.refreshType & 0x400) == 0));
    return 1024;
  }
  
  public void handleRsp(RspWalletConfig paramRspWalletConfig, long paramLong, aaai.a parama, aaai paramaaai)
  {
    if ((paramRspWalletConfig == null) || (paramRspWalletConfig.result != RspWalletConfig.RET_SUCC)) {
      return;
    }
    int i;
    long l;
    if (paramRspWalletConfig.refreshTime > 86400)
    {
      i = 86400;
      paramRspWalletConfig.refreshTime = i;
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLong != 0L) {
        break label351;
      }
      gE(l);
      this.action = paramRspWalletConfig.action;
      if (paramRspWalletConfig.action != 1) {
        break label135;
      }
      label69:
      if (paramRspWalletConfig.action != 3) {
        this.cfP = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfig", 2, "after update|" + this);
      }
      this.lastAppId = AppSetting.getAppId();
      saveConfig();
      return;
      i = paramRspWalletConfig.refreshTime;
      break;
      label135:
      if (paramRspWalletConfig.action == 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, true, l);
        break label69;
      }
      if (paramRspWalletConfig.action == 2)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        break label69;
      }
      if (paramRspWalletConfig.action != 3) {
        break label69;
      }
      if (this.seriesNo == paramRspWalletConfig.seriesNo) {}
      for (i = 1;; i = 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        if ((paramaaai == null) || (i != 0) || (this.cfP >= 100)) {
          break;
        }
        paramaaai.ctg();
        this.cfP += 1;
        break;
      }
      label351:
      a(l, paramLong, paramRspWalletConfig);
      a(paramRspWalletConfig.mConfig, false, l);
      notifyListener(parama);
    }
  }
  
  public boolean isValidToReq(long paramLong)
  {
    boolean bool = false;
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = 1L;
    long l1 = paramLong;
    paramLong = l2;
    for (;;)
    {
      if (l1 != 0L) {
        if ((paramLong & l1) != 0L) {
          if (this.lastReqTimes.containsKey(Long.valueOf(paramLong)))
          {
            l2 = ((Long)this.lastReqTimes.get(Long.valueOf(paramLong))).longValue();
            if (!this.refreshTimes.containsKey(Long.valueOf(paramLong))) {
              break label185;
            }
            i = ((Integer)this.refreshTimes.get(Long.valueOf(paramLong))).intValue();
            if (Math.abs(l3 - Long.valueOf(l2).longValue()) < i * 1000) {
              break label190;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QWalletConfig", 2, "isValidToReq true when" + l1 + "|" + paramLong);
            }
            bool = true;
          }
        }
      }
    }
    label185:
    label190:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return bool;
        l2 = 0L;
        continue;
        int i = 0;
      }
      l1 &= (0xFFFFFFFF ^ paramLong);
      paramLong <<= 1;
      break;
    }
    QLog.d("QWalletConfig", 2, "isValidToReq false" + l1);
    return false;
  }
  
  public boolean isVersionUpdate()
  {
    return this.lastAppId != AppSetting.getAppId();
  }
  
  public void notifyListener(aaai.a parama)
  {
    if (parama != null) {}
    synchronized (this.cv)
    {
      HashMap localHashMap = new HashMap(this.configs);
      parama.g(this.mCurUin, localHashMap);
      return;
    }
  }
  
  public void notifyUpdateListeners(Map<String, String> paramMap, long paramLong)
  {
    synchronized (this.cu)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      Object localObject1;
      String str;
      label116:
      do
      {
        paramMap = paramMap.entrySet().iterator();
        break label116;
        do
        {
          do
          {
            if (!paramMap.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)paramMap.next();
            str = (String)((Map.Entry)localObject1).getKey();
            localObject1 = (String)((Map.Entry)localObject1).getValue();
          } while (TextUtils.isEmpty(str));
          localObject2 = (List)this.iv.get(str);
        } while (localObject2 == null);
        Object localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          aaai.b localb = (aaai.b)((Iterator)localObject2).next();
          try
          {
            localb.a(str, (String)localObject1, new a(str, (String)localObject1, paramLong));
          }
          catch (Throwable localThrowable) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("QWalletConfig", 2, "notifyUpdateListeners|key=" + str + "|config=" + (String)localObject1 + "|errmsg=" + localThrowable.getMessage());
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.cu)
    {
      this.iv.clear();
      this.iw.clear();
      return;
    }
  }
  
  public void removeUpdateListener(String paramString, aaai.b paramb)
  {
    synchronized (this.cu)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramb != null))
      {
        paramString = (List)this.iv.get(paramString);
        if (paramString != null) {
          paramString.remove(paramb);
        }
      }
      return;
    }
  }
  
  public void saveConfig()
  {
    if (!TextUtils.isEmpty(this.mSavePath)) {
      ThreadManager.getFileThreadHandler().post(new QWalletConfig.1(this));
    }
  }
  
  public String toString()
  {
    return "QWalletConfig{seriesNo=" + this.seriesNo + ", refreshType=" + this.refreshType + ", refreshTime=" + this.refreshTime + ", lastReqTime=" + this.lastReqTime + ", commonMsg='" + this.commonMsg + '\'' + ", configs=" + this.configs + ", refreshTimes=" + this.refreshTimes + ", lastReqTimes=" + this.lastReqTimes + ", mSavePath='" + this.mSavePath + '\'' + ", mCurUin='" + this.mCurUin + '\'' + '}';
  }
  
  public static class a
  {
    public String configStr;
    public String module;
    public long version;
    
    public a() {}
    
    public a(String paramString1, String paramString2, long paramLong)
    {
      this.module = paramString1;
      this.configStr = paramString2;
      this.version = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfig
 * JD-Core Version:    0.7.0.1
 */