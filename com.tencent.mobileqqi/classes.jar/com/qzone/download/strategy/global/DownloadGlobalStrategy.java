package com.qzone.download.strategy.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qzone.common.IPInfo;
import com.qzone.download.NetworkManager;
import com.qzone.statistics.ProxyStatistics;
import com.qzone.utils.Base64;
import com.qzone.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadGlobalStrategy
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static ArrayList<StrategyInfo> StrategyLib_NWAP;
  private static ArrayList<StrategyInfo> StrategyLib_WAP;
  private static ArrayList<StrategyInfo> StrategyLib_WAP1;
  public static final StrategyInfo Strategy_BACKUPIP;
  public static final StrategyInfo Strategy_DOMAIN_FORCE;
  public static final StrategyInfo Strategy_DomainDirect = new StrategyInfo(1, false, false, false);
  public static final StrategyInfo Strategy_DomainProxy_CON;
  public static final StrategyInfo Strategy_DomainProxy_SYS = new StrategyInfo(2, true, false, false);
  private static volatile DownloadGlobalStrategy mInstance;
  private SharedPreferences mSetting;
  private ConcurrentHashMap<String, StrategyInfo> mapBestDomainStrategyCache = new ConcurrentHashMap();
  
  static
  {
    Strategy_DomainProxy_CON = new StrategyInfo(3, true, true, false);
    Strategy_BACKUPIP = new StrategyInfo(4, false, false, true);
    Strategy_DOMAIN_FORCE = new StrategyInfo(5, false, false, false, true);
    StrategyLib_WAP = new ArrayList();
    StrategyLib_WAP1 = new ArrayList();
    StrategyLib_NWAP = new ArrayList();
    mInstance = null;
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    StrategyLib_WAP.add(Strategy_DomainProxy_CON);
    StrategyLib_WAP.add(Strategy_DomainDirect);
    StrategyLib_WAP.add(Strategy_DomainDirect);
    StrategyLib_WAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP.add(Strategy_BACKUPIP);
    StrategyLib_WAP.add(Strategy_BACKUPIP);
    StrategyLib_WAP.add(Strategy_DomainProxy_SYS);
    StrategyLib_WAP1.add(Strategy_DomainProxy_SYS);
    StrategyLib_WAP1.add(Strategy_DomainDirect);
    StrategyLib_WAP1.add(Strategy_DomainDirect);
    StrategyLib_WAP1.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP1.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP1.add(Strategy_BACKUPIP);
    StrategyLib_WAP1.add(Strategy_BACKUPIP);
    StrategyLib_WAP1.add(Strategy_DomainProxy_CON);
    StrategyLib_NWAP.add(Strategy_DomainDirect);
    StrategyLib_NWAP.add(Strategy_DomainDirect);
    StrategyLib_NWAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_NWAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_NWAP.add(Strategy_BACKUPIP);
    StrategyLib_NWAP.add(Strategy_BACKUPIP);
    StrategyLib_NWAP.add(Strategy_DomainProxy_CON);
    StrategyLib_NWAP.add(Strategy_DomainProxy_SYS);
    if (paramContext != null) {
      this.mSetting = paramContext.getSharedPreferences("downloa_stragegy_" + Utils.getCurrentProcessName(paramContext), 0);
    }
    loadStrategy();
  }
  
  private boolean checkStrategyValid(StrategyInfo paramStrategyInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramStrategyInfo != null;
  }
  
  private StrategyInfo getBestStrategyInfo(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return localObject;
      String str = Utils.getDomin(paramString);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = Utils.getDomin(paramString);
      }
      paramString = getDomainStrategyCacheKey((String)localObject, NetworkManager.getApnValue());
      localObject = (StrategyInfo)this.mapBestDomainStrategyCache.get(paramString);
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (!((StrategyInfo)localObject).isIPValid()) {
          paramString = null;
        }
      }
      bool1 = ProxyStatistics.getInstance().getAllowProxy();
      bool2 = ProxyStatistics.getInstance().getAPNProxy();
      localObject = paramString;
    } while (checkStrategyValid(paramString, bool1, bool2));
    return new StrategyInfo(bool1, bool2, false);
  }
  
  private String getDomainStrategyCacheKey(String paramString1, String paramString2)
  {
    String str = "";
    if ("wifi".equals(paramString2))
    {
      str = NetworkManager.getBSSID();
      if (!TextUtils.isEmpty(str)) {
        break label54;
      }
    }
    label54:
    for (str = "";; str = "_" + str) {
      return paramString1 + "_" + paramString2 + str;
    }
  }
  
  public static DownloadGlobalStrategy getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    synchronized (INSTANCE_LOCK)
    {
      if (mInstance == null) {
        mInstance = new DownloadGlobalStrategy(paramContext);
      }
      return mInstance;
    }
  }
  
  private void loadStrategy()
  {
    if (this.mSetting == null) {
      return;
    }
    synchronized (this.mapBestDomainStrategyCache)
    {
      this.mapBestDomainStrategyCache.clear();
      String str = this.mSetting.getString("download_best_strategy", null);
      if (str == null) {
        return;
      }
    }
    try
    {
      Object localObject2 = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(localObject1.getBytes(), 0)));
      if (localObject2 != null)
      {
        localObject2 = (Map)((ObjectInputStream)localObject2).readObject();
        this.mapBestDomainStrategyCache.putAll((Map)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label90;
    }
    catch (IOException localIOException)
    {
      break label90;
    }
    catch (StreamCorruptedException localStreamCorruptedException)
    {
      label90:
      break label90;
    }
  }
  
  /* Error */
  private void saveStrategy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	com/qzone/download/strategy/global/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 71	com/qzone/download/strategy/global/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: new 231	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 232	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_2
    //   23: new 234	java/io/ObjectOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 237	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +50 -> 83
    //   36: aload_3
    //   37: aload_0
    //   38: getfield 71	com/qzone/download/strategy/global/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   41: invokevirtual 241	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   44: new 165	java/lang/String
    //   47: dup
    //   48: aload_2
    //   49: invokevirtual 244	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   52: iconst_0
    //   53: invokestatic 247	com/qzone/utils/Base64:encode	([BI)[B
    //   56: invokespecial 248	java/lang/String:<init>	([B)V
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 104	com/qzone/download/strategy/global/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   64: invokeinterface 252 1 0
    //   69: ldc 193
    //   71: aload_2
    //   72: invokeinterface 258 3 0
    //   77: invokeinterface 261 1 0
    //   82: pop
    //   83: aload_1
    //   84: monitorexit
    //   85: return
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: goto -9 -> 83
    //   95: astore_2
    //   96: goto -13 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	DownloadGlobalStrategy
    //   12	76	1	localConcurrentHashMap	ConcurrentHashMap
    //   22	50	2	localObject1	Object
    //   86	4	2	localObject2	Object
    //   91	1	2	localThrowable1	Throwable
    //   95	1	2	localThrowable2	Throwable
    //   31	6	3	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	23	86	finally
    //   23	32	86	finally
    //   36	60	86	finally
    //   60	83	86	finally
    //   83	85	86	finally
    //   87	89	86	finally
    //   23	32	91	java/lang/Throwable
    //   36	60	91	java/lang/Throwable
    //   60	83	95	java/lang/Throwable
  }
  
  public StrategyLib getStrategyLib(String paramString)
  {
    StrategyLib localStrategyLib = new StrategyLib();
    localStrategyLib.mBestStrategyInfo = getBestStrategyInfo(paramString);
    if (!NetworkManager.isWap())
    {
      localStrategyLib.mStrategyList = StrategyLib_NWAP;
      int j = 80;
      Utils.getDomin(paramString);
      int i = j;
      if (localStrategyLib.mBestStrategyInfo != null)
      {
        i = j;
        if (localStrategyLib.mBestStrategyInfo.getIPInfo() != null)
        {
          i = j;
          if (localStrategyLib.mBestStrategyInfo.isIPValid())
          {
            j = localStrategyLib.mBestStrategyInfo.getIPInfo().port;
            i = j;
            if (!Utils.isPortValid(j)) {
              i = 80;
            }
          }
        }
      }
      localStrategyLib.setPort(i);
      if ((localStrategyLib.mBestStrategyInfo != null) && (localStrategyLib.mBestStrategyInfo.getIPInfo() != null) && (localStrategyLib.mBestStrategyInfo.isIPValid()) && (!TextUtils.isEmpty(localStrategyLib.mBestStrategyInfo.getIPInfo().ip)))
      {
        if (localStrategyLib.mBestStrategyInfo.id != Strategy_BACKUPIP.id) {
          break label202;
        }
        localStrategyLib.setBackupIP(localStrategyLib.mBestStrategyInfo.getIPInfo().ip);
      }
    }
    label202:
    do
    {
      return localStrategyLib;
      localStrategyLib.mStrategyList = StrategyLib_WAP;
      break;
      if (localStrategyLib.mBestStrategyInfo.id == Strategy_DOMAIN_FORCE.id)
      {
        localStrategyLib.setDnsIP(localStrategyLib.mBestStrategyInfo.getIPInfo().ip);
        return localStrategyLib;
      }
    } while (localStrategyLib.mBestStrategyInfo.id != Strategy_DomainDirect.id);
    localStrategyLib.setDirectIP(localStrategyLib.mBestStrategyInfo.getIPInfo().ip);
    return localStrategyLib;
  }
  
  public void report(Context paramContext, String paramString, StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyInfo == null)) {}
    for (;;)
    {
      return;
      String str = Utils.getDomin(paramString);
      Object localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = Utils.getDomin(paramString);
      }
      paramString = NetworkManager.getApnValue();
      if (localObject != null)
      {
        paramString = getDomainStrategyCacheKey((String)localObject, paramString);
        localObject = (StrategyInfo)this.mapBestDomainStrategyCache.get(paramString);
        if (!paramBoolean) {
          break label141;
        }
        if (!paramStrategyInfo.equals(localObject))
        {
          this.mapBestDomainStrategyCache.put(paramString, paramStrategyInfo);
          saveStrategy();
        }
      }
      while ((paramBoolean) && ((paramStrategyInfo.id == Strategy_DomainProxy_CON.id) || (paramStrategyInfo.id == Strategy_DomainProxy_SYS.id)))
      {
        ProxyStatistics.getInstance().report(paramContext, paramStrategyInfo.allowProxy, paramStrategyInfo.useConfigApn);
        return;
        label141:
        if (paramStrategyInfo.equals(localObject))
        {
          this.mapBestDomainStrategyCache.remove(paramString);
          saveStrategy();
        }
      }
    }
  }
  
  public static class StrategyInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean allowProxy;
    public boolean enableBackupIP;
    public boolean forceDomain = false;
    public int id;
    private IPInfo mIpInfo;
    private long mIpTimestamp;
    public boolean useConfigApn;
    
    public StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
    }
    
    public StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.id = paramInt;
      this.allowProxy = paramBoolean1;
      this.useConfigApn = paramBoolean2;
      this.enableBackupIP = paramBoolean3;
      this.forceDomain = paramBoolean4;
      this.mIpTimestamp = System.currentTimeMillis();
      filter();
      initID();
    }
    
    public StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
    }
    
    private void filter()
    {
      if (this.enableBackupIP) {
        this.allowProxy = false;
      }
      if (!this.allowProxy) {
        this.useConfigApn = false;
      }
    }
    
    private void initID()
    {
      if (equalValue(DownloadGlobalStrategy.Strategy_DomainDirect)) {
        this.id = DownloadGlobalStrategy.Strategy_DomainDirect.id;
      }
      do
      {
        return;
        if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_CON))
        {
          this.id = DownloadGlobalStrategy.Strategy_DomainProxy_CON.id;
          return;
        }
        if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_SYS))
        {
          this.id = DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id;
          return;
        }
        if (equalValue(DownloadGlobalStrategy.Strategy_BACKUPIP))
        {
          this.id = DownloadGlobalStrategy.Strategy_BACKUPIP.id;
          return;
        }
      } while (!equalValue(DownloadGlobalStrategy.Strategy_DOMAIN_FORCE));
      this.id = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id;
    }
    
    public StrategyInfo clone()
    {
      StrategyInfo localStrategyInfo = new StrategyInfo(this.id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
      if (this.id > 0) {
        localStrategyInfo.id = this.id;
      }
      return localStrategyInfo;
    }
    
    public boolean equalValue(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
          break;
        }
        paramObject = (StrategyInfo)paramObject;
      } while ((paramObject.forceDomain == this.forceDomain) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo)));
      return false;
      return false;
    }
    
    public boolean equalWith(IPInfo paramIPInfo1, IPInfo paramIPInfo2)
    {
      if (paramIPInfo1 != null) {
        return paramIPInfo1.equals(paramIPInfo2);
      }
      if (paramIPInfo2 != null) {
        return paramIPInfo2.equals(paramIPInfo1);
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
          break;
        }
        paramObject = (StrategyInfo)paramObject;
      } while ((paramObject.id == this.id) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo)));
      return false;
      return false;
    }
    
    public IPInfo getIPInfo()
    {
      return this.mIpInfo;
    }
    
    public long getIPValidTime()
    {
      if (this.id == DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id) {
        return 7200000L;
      }
      return 604800000L;
    }
    
    public boolean isIPValid()
    {
      long l1 = getIPValidTime();
      long l2 = System.currentTimeMillis() - this.mIpTimestamp;
      return (l2 >= 0L) && (l2 <= l1);
    }
    
    public void setIPInfo(IPInfo paramIPInfo)
    {
      this.mIpInfo = paramIPInfo;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("(id:").append(this.id).append(",").append(this.allowProxy).append(",").append(this.useConfigApn).append(",").append(this.enableBackupIP).append(",");
      if (this.mIpInfo != null) {}
      for (String str = this.mIpInfo.toString();; str = "N/A") {
        return new String(str + ")");
      }
    }
  }
  
  public class StrategyLib
  {
    private String mBackupIp;
    private DownloadGlobalStrategy.StrategyInfo mBestStrategyInfo;
    private String mDirectIp;
    private String mDnsIP;
    private DownloadGlobalStrategy.StrategyInfo mOldStrategyInfo;
    private int mPort;
    private ArrayList<DownloadGlobalStrategy.StrategyInfo> mStrategyList;
    private boolean updateEnable = true;
    
    public StrategyLib()
    {
      ensureData();
      this.mPort = 80;
    }
    
    private void ensureData()
    {
      if (this.mStrategyList != null) {
        return;
      }
      if (!NetworkManager.isWap())
      {
        this.mStrategyList = DownloadGlobalStrategy.StrategyLib_NWAP;
        return;
      }
      this.mStrategyList = DownloadGlobalStrategy.StrategyLib_NWAP;
    }
    
    private void updateStrategyLists()
    {
      if (!this.updateEnable) {
        return;
      }
      boolean bool1 = ProxyStatistics.getInstance().getAllowProxy();
      boolean bool2 = ProxyStatistics.getInstance().getAPNProxy();
      if (!bool1)
      {
        this.mStrategyList = DownloadGlobalStrategy.StrategyLib_NWAP;
        return;
      }
      if (bool2)
      {
        this.mStrategyList = DownloadGlobalStrategy.StrategyLib_WAP;
        return;
      }
      this.mStrategyList = DownloadGlobalStrategy.StrategyLib_WAP1;
    }
    
    public void addStrategy(List<DownloadGlobalStrategy.StrategyInfo> paramList)
    {
      if ((this.mStrategyList == null) || (paramList == null)) {
        return;
      }
      this.mStrategyList.addAll(paramList);
    }
    
    public void copyStrageList()
    {
      if (this.mStrategyList == null)
      {
        this.mStrategyList = new ArrayList();
        return;
      }
      this.mStrategyList = new ArrayList(this.mStrategyList);
    }
    
    public void enableUpdate(boolean paramBoolean)
    {
      this.updateEnable = paramBoolean;
    }
    
    public String getBackupIP()
    {
      return this.mBackupIp;
    }
    
    public int getBestId()
    {
      if (this.mBestStrategyInfo != null) {
        return this.mBestStrategyInfo.id;
      }
      return 0;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getBestStrategy()
    {
      return this.mBestStrategyInfo;
    }
    
    public String getDirectIP()
    {
      return this.mDirectIp;
    }
    
    public String getDnsIP()
    {
      return this.mDnsIP;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getOldStrategyInfo()
    {
      return this.mOldStrategyInfo;
    }
    
    public int getPort()
    {
      return this.mPort;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getStrategyInfo(int paramInt)
    {
      int k = paramInt;
      if (paramInt < 0) {
        k = 0;
      }
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = null;
      if (this.mBestStrategyInfo == null)
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());
        localStrategyInfo2 = localStrategyInfo1;
        if (localStrategyInfo1 == null) {
          if (!NetworkManager.isWap()) {
            break label401;
          }
        }
      }
      label401:
      for (DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.StrategyLib_WAP.get(0);; localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.StrategyLib_NWAP.get(0))
      {
        return localStrategyInfo2;
        if (k <= 0)
        {
          localStrategyInfo1 = this.mBestStrategyInfo;
          break;
        }
        if ((this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_DomainDirect.id) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_BACKUPIP.id) && (this.mBestStrategyInfo.id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id))
        {
          if (k == 1) {
            updateStrategyLists();
          }
          i = -1;
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.mStrategyList.size()) {
              paramInt = i;
            }
            while (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id == this.mBestStrategyInfo.id)
            {
              if ((k <= 0) || (k > paramInt)) {
                break label225;
              }
              localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 1);
              break;
            }
            paramInt += 1;
          }
          label225:
          localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());
          break;
        }
        if (k == 1)
        {
          updateStrategyLists();
          return this.mBestStrategyInfo;
        }
        int i = -1;
        int j = -1;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= this.mStrategyList.size())
          {
            if ((k <= 1) || (k > j)) {
              break label370;
            }
            localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k - 2);
            break;
          }
          int m = i;
          int n = j;
          if (((DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(paramInt)).id == this.mBestStrategyInfo.id)
          {
            j = i;
            if (i < 0) {
              j = paramInt;
            }
            n = paramInt;
            m = j;
          }
          paramInt += 1;
          i = m;
          j = n;
        }
        label370:
        if (k <= j) {
          break;
        }
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.mStrategyList.get(k % this.mStrategyList.size());
        break;
      }
    }
    
    public List<DownloadGlobalStrategy.StrategyInfo> getStrategyList()
    {
      return this.mStrategyList;
    }
    
    public int getSuggestMaxTimes()
    {
      if (this.mStrategyList != null) {
        return this.mStrategyList.size();
      }
      return 0;
    }
    
    public void setBackupIP(String paramString)
    {
      this.mBackupIp = paramString;
    }
    
    public void setDirectIP(String paramString)
    {
      this.mDirectIp = paramString;
    }
    
    public void setDnsIP(String paramString)
    {
      this.mDnsIP = paramString;
    }
    
    public void setOldStrategyInfo(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo)
    {
      this.mOldStrategyInfo = paramStrategyInfo;
    }
    
    public void setPort(int paramInt)
    {
      this.mPort = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.global.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */