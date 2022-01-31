package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadGlobalStrategy
{
  public static final StrategyInfo Strategy_BACKUPIP = new StrategyInfo(4, false, false, true);
  public static final StrategyInfo Strategy_DOMAIN_FORCE = new StrategyInfo(5, false, false, false, true);
  public static final StrategyInfo Strategy_DomainDirect = new StrategyInfo(1, false, false, false);
  public static final StrategyInfo Strategy_DomainProxy_CON;
  public static final StrategyInfo Strategy_DomainProxy_SYS = new StrategyInfo(2, true, false, false);
  private static ArrayList<StrategyInfo> a = new ArrayList();
  private static ArrayList<StrategyInfo> b = new ArrayList();
  private static ArrayList<StrategyInfo> c = new ArrayList();
  private static volatile DownloadGlobalStrategy d = null;
  private static final byte[] e = new byte[0];
  private static Context f;
  private SharedPreferences g;
  private ConcurrentHashMap<String, StrategyInfo> h = new ConcurrentHashMap();
  private PortConfigStrategy i;
  private volatile int j = 0;
  
  static
  {
    Strategy_DomainProxy_CON = new StrategyInfo(3, true, true, false);
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    this.i = DownloaderFactory.getInstance(paramContext).getPortStrategy();
    a.add(Strategy_DomainProxy_CON);
    a.add(Strategy_DomainDirect);
    a.add(Strategy_DomainDirect);
    a.add(Strategy_DOMAIN_FORCE);
    a.add(Strategy_DOMAIN_FORCE);
    a.add(Strategy_BACKUPIP);
    a.add(Strategy_BACKUPIP);
    a.add(Strategy_DomainProxy_SYS);
    b.add(Strategy_DomainProxy_SYS);
    b.add(Strategy_DomainDirect);
    b.add(Strategy_DomainDirect);
    b.add(Strategy_DOMAIN_FORCE);
    b.add(Strategy_DOMAIN_FORCE);
    b.add(Strategy_BACKUPIP);
    b.add(Strategy_BACKUPIP);
    b.add(Strategy_DomainProxy_CON);
    c.add(Strategy_DomainDirect);
    c.add(Strategy_DomainDirect);
    c.add(Strategy_DOMAIN_FORCE);
    c.add(Strategy_DOMAIN_FORCE);
    c.add(Strategy_BACKUPIP);
    c.add(Strategy_BACKUPIP);
    c.add(Strategy_DomainProxy_CON);
    c.add(Strategy_DomainProxy_SYS);
    f = paramContext;
    if (paramContext != null) {
      this.g = f.getSharedPreferences("downloa_stragegy", 0);
    }
    String str;
    if (this.g != null)
    {
      this.h.clear();
      str = this.g.getString("download_best_strategy", null);
      if (str != null) {
        paramContext = localParcel;
      }
    }
    try
    {
      localParcel = Const.a(Base64.decode(str, 0));
      paramContext = localParcel;
      localObject = localParcel;
      localParcel.readMap(this.h, f.getClassLoader());
      if (localParcel != null) {
        localParcel.recycle();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject = paramContext;
        Const.b("download", "download", localThrowable);
      } while (paramContext == null);
      paramContext.recycle();
      return;
    }
    finally
    {
      if (localObject != null) {
        ((Parcel)localObject).recycle();
      }
    }
  }
  
  private static String a(String paramString1, String paramString2)
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
    if (d == null) {}
    synchronized (e)
    {
      if (d == null) {
        d = new DownloadGlobalStrategy(paramContext);
      }
      return d;
    }
  }
  
  public static long getRecentIPValidCacheTime()
  {
    return 259200L;
  }
  
  public StrategyLib getStrategyLib(String paramString1, String paramString2)
  {
    StrategyLib localStrategyLib = new StrategyLib();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = null;
      StrategyLib.a(localStrategyLib, paramString1);
      if (NetworkManager.isWap()) {
        break label337;
      }
      StrategyLib.a(localStrategyLib, c);
      label46:
      if ((this.i == null) || (!this.i.supportExtraPort(paramString2)) || (StrategyLib.a(localStrategyLib) == null) || (StrategyLib.a(localStrategyLib).getIPInfo() == null) || (!StrategyLib.a(localStrategyLib).isIPValid())) {
        break label420;
      }
      int m = StrategyLib.a(localStrategyLib).getIPInfo().b;
      k = m;
      if (Const.a(m)) {}
    }
    label420:
    for (int k = 80;; k = 80)
    {
      localStrategyLib.setPort(k);
      if ((StrategyLib.a(localStrategyLib) != null) && (StrategyLib.a(localStrategyLib).getIPInfo() != null) && (StrategyLib.a(localStrategyLib).isIPValid()) && (!TextUtils.isEmpty(StrategyLib.a(localStrategyLib).getIPInfo().a)))
      {
        if (StrategyLib.a(localStrategyLib).id != Strategy_BACKUPIP.id) {
          break label348;
        }
        localStrategyLib.setBackupIP(StrategyLib.a(localStrategyLib).getIPInfo().a);
      }
      label335:
      label337:
      label348:
      do
      {
        return localStrategyLib;
        paramString1 = a(paramString2, NetworkManager.getApnValue());
        StrategyInfo localStrategyInfo = (StrategyInfo)this.h.get(paramString1);
        paramString1 = localStrategyInfo;
        if (localStrategyInfo != null)
        {
          paramString1 = localStrategyInfo;
          if (!localStrategyInfo.isIPValid())
          {
            Const.c("DownloadGlobalStrategy", "best strategy invalid! domain:" + paramString2 + " threadId:" + Thread.currentThread().getId());
            paramString1 = null;
          }
        }
        boolean bool1 = com.tencent.component.network.module.a.a.c().a();
        boolean bool2 = com.tencent.component.network.module.a.a.c().b();
        if (paramString1 == null) {}
        for (k = 0;; k = 1)
        {
          if (k != 0) {
            break label335;
          }
          paramString1 = new StrategyInfo(bool1, bool2, false);
          break;
        }
        break;
        StrategyLib.a(localStrategyLib, a);
        break label46;
        if (StrategyLib.a(localStrategyLib).id == Strategy_DOMAIN_FORCE.id)
        {
          localStrategyLib.setDnsIP(StrategyLib.a(localStrategyLib).getIPInfo().a);
          return localStrategyLib;
        }
      } while (StrategyLib.a(localStrategyLib).id != Strategy_DomainDirect.id);
      localStrategyLib.setDirectIP(StrategyLib.a(localStrategyLib).getIPInfo().a);
      return localStrategyLib;
    }
  }
  
  public void report(Context paramContext, String paramString1, String paramString2, StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramStrategyInfo == null)) {
      return;
    }
    paramString1 = NetworkManager.getApnValue();
    if (paramString2 != null)
    {
      paramString1 = a(paramString2, paramString1);
      paramString2 = (StrategyInfo)this.h.get(paramString1);
      if (!paramBoolean) {
        break label140;
      }
      if (!paramStrategyInfo.equals(paramString2))
      {
        this.h.put(paramString1, paramStrategyInfo);
        this.j += 1;
        saveStrategy();
      }
    }
    for (;;)
    {
      if (this.j > 0) {
        saveStrategy();
      }
      if ((!paramBoolean) || ((paramStrategyInfo.id != Strategy_DomainProxy_CON.id) && (paramStrategyInfo.id != Strategy_DomainProxy_SYS.id))) {
        break;
      }
      com.tencent.component.network.module.a.a.c().a(paramContext, paramStrategyInfo.allowProxy, paramStrategyInfo.useConfigApn);
      return;
      label140:
      if (paramStrategyInfo.equals(paramString2))
      {
        this.h.remove(paramString1);
        this.j += 1;
        saveStrategy();
      }
    }
  }
  
  /* Error */
  public void saveStrategy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:g	Landroid/content/SharedPreferences;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 326	com/tencent/component/network/downloader/impl/a:b	()I
    //   24: ifle +11 -> 35
    //   27: aload_0
    //   28: getfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   31: iconst_5
    //   32: if_icmplt -14 -> 18
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   40: ldc_w 259
    //   43: ldc_w 328
    //   46: invokestatic 330	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aconst_null
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: invokestatic 334	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   56: astore 4
    //   58: aload 4
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 79	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: invokevirtual 338	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   73: aload 4
    //   75: astore_2
    //   76: aload 4
    //   78: astore_3
    //   79: new 156	java/lang/String
    //   82: dup
    //   83: aload 4
    //   85: invokevirtual 342	android/os/Parcel:marshall	()[B
    //   88: iconst_0
    //   89: invokestatic 346	com/tencent/component/network/utils/Base64:encode	([BI)[B
    //   92: invokespecial 349	java/lang/String:<init>	([B)V
    //   95: astore 5
    //   97: aload 4
    //   99: astore_2
    //   100: aload 4
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 109	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:g	Landroid/content/SharedPreferences;
    //   107: invokeinterface 353 1 0
    //   112: ldc 114
    //   114: aload 5
    //   116: invokeinterface 359 3 0
    //   121: invokeinterface 362 1 0
    //   126: pop
    //   127: aload 4
    //   129: ifnull -111 -> 18
    //   132: aload 4
    //   134: invokevirtual 144	android/os/Parcel:recycle	()V
    //   137: goto -119 -> 18
    //   140: astore_2
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore 4
    //   147: aload_2
    //   148: astore_3
    //   149: ldc 146
    //   151: ldc 146
    //   153: aload 4
    //   155: invokestatic 149	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: ifnull -141 -> 18
    //   162: aload_2
    //   163: invokevirtual 144	android/os/Parcel:recycle	()V
    //   166: goto -148 -> 18
    //   169: astore_2
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 144	android/os/Parcel:recycle	()V
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	DownloadGlobalStrategy
    //   13	2	1	k	int
    //   52	48	2	localObject1	Object
    //   140	23	2	localObject2	Object
    //   169	10	2	localObject3	Object
    //   50	125	3	localObject4	Object
    //   56	77	4	localParcel	Parcel
    //   145	9	4	localException	java.lang.Exception
    //   95	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	140	finally
    //   21	35	140	finally
    //   35	49	140	finally
    //   132	137	140	finally
    //   162	166	140	finally
    //   174	178	140	finally
    //   178	180	140	finally
    //   53	58	145	java/lang/Exception
    //   64	73	145	java/lang/Exception
    //   79	97	145	java/lang/Exception
    //   103	127	145	java/lang/Exception
    //   53	58	169	finally
    //   64	73	169	finally
    //   79	97	169	finally
    //   103	127	169	finally
    //   149	158	169	finally
  }
  
  public static class StrategyInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new a();
    private IPInfo a;
    public boolean allowProxy;
    private long b;
    public boolean enableBackupIP;
    public boolean forceDomain = false;
    public int id;
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
      this.b = System.currentTimeMillis();
      if (this.enableBackupIP) {
        this.allowProxy = false;
      }
      if (!this.allowProxy) {
        this.useConfigApn = false;
      }
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
    
    public StrategyInfo(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.id = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.allowProxy = bool1;
        if (paramParcel.readInt() != 1) {
          break label115;
        }
        bool1 = true;
        label49:
        this.useConfigApn = bool1;
        if (paramParcel.readInt() != 1) {
          break label120;
        }
        bool1 = true;
        label64:
        this.enableBackupIP = bool1;
        if (paramParcel.readInt() != 1) {
          break label125;
        }
      }
      label115:
      label120:
      label125:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.forceDomain = bool1;
        this.a = ((IPInfo)paramParcel.readParcelable(DownloadGlobalStrategy.a().getClassLoader()));
        this.b = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label49;
        bool1 = false;
        break label64;
      }
    }
    
    public StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
    }
    
    public StrategyInfo clone()
    {
      StrategyInfo localStrategyInfo = new StrategyInfo(this.id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
      if (this.id > 0) {
        localStrategyInfo.id = this.id;
      }
      return localStrategyInfo;
    }
    
    public int describeContents()
    {
      return 0;
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
      } while ((paramObject.forceDomain == this.forceDomain) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.a, this.a)));
      return false;
      return false;
    }
    
    public boolean equalWith(IPInfo paramIPInfo1, IPInfo paramIPInfo2)
    {
      if (paramIPInfo1 != null) {
        return paramIPInfo1.equals(paramIPInfo2);
      }
      return paramIPInfo2 == null;
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
      } while ((paramObject.id == this.id) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.a, this.a)));
      return false;
      return false;
    }
    
    public IPInfo getIPInfo()
    {
      return this.a;
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
      long l2 = System.currentTimeMillis() - this.b;
      return (l2 >= 0L) && (l2 <= l1);
    }
    
    public void setIPInfo(IPInfo paramIPInfo)
    {
      this.a = paramIPInfo;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("(id:").append(this.id).append(",").append(this.allowProxy).append(",").append(this.useConfigApn).append(",").append(this.enableBackupIP).append(",");
      if (this.a != null) {}
      for (String str = this.a.toString();; str = "N/A") {
        return new String(str + ")");
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeInt(this.id);
      if (this.allowProxy)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.useConfigApn) {
          break label94;
        }
        paramInt = 1;
        label38:
        paramParcel.writeInt(paramInt);
        if (!this.enableBackupIP) {
          break label99;
        }
        paramInt = 1;
        label52:
        paramParcel.writeInt(paramInt);
        if (!this.forceDomain) {
          break label104;
        }
      }
      label94:
      label99:
      label104:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeParcelable(this.a, 0);
        paramParcel.writeLong(this.b);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label38;
        paramInt = 0;
        break label52;
      }
    }
  }
  
  public class StrategyLib
  {
    private ArrayList<DownloadGlobalStrategy.StrategyInfo> a;
    private DownloadGlobalStrategy.StrategyInfo b;
    private String c;
    private String d;
    private String e;
    private int f;
    private DownloadGlobalStrategy.StrategyInfo g;
    private boolean h = true;
    
    public StrategyLib()
    {
      if (this.a == null) {
        if (NetworkManager.isWap()) {
          break label36;
        }
      }
      label36:
      for (this.a = DownloadGlobalStrategy.b();; this.a = DownloadGlobalStrategy.c())
      {
        this.f = 80;
        return;
      }
    }
    
    private void a()
    {
      if (!this.h) {
        return;
      }
      boolean bool1 = com.tencent.component.network.module.a.a.c().a();
      boolean bool2 = com.tencent.component.network.module.a.a.c().b();
      if (!bool1)
      {
        this.a = DownloadGlobalStrategy.b();
        return;
      }
      if (bool2)
      {
        this.a = DownloadGlobalStrategy.c();
        return;
      }
      this.a = DownloadGlobalStrategy.d();
    }
    
    public void addStrategy(List<DownloadGlobalStrategy.StrategyInfo> paramList)
    {
      if ((this.a == null) || (paramList == null)) {
        return;
      }
      this.a.addAll(paramList);
    }
    
    public void copyStrageList()
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        return;
      }
      this.a = new ArrayList(this.a);
    }
    
    public void enableUpdate(boolean paramBoolean)
    {
      this.h = paramBoolean;
    }
    
    public String getBackupIP()
    {
      return this.d;
    }
    
    public int getBestId()
    {
      if (this.b != null) {
        return this.b.id;
      }
      return 0;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getBestStrategy()
    {
      return this.b;
    }
    
    public String getDirectIP()
    {
      return this.c;
    }
    
    public String getDnsIP()
    {
      return this.e;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getOldStrategyInfo()
    {
      return this.g;
    }
    
    public int getPort()
    {
      return this.f;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getStrategyInfo(int paramInt)
    {
      int j = -1;
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo1;
      if (this.b == null) {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
      }
      for (;;)
      {
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = localStrategyInfo1;
        if (localStrategyInfo1 == null)
        {
          if (NetworkManager.isWap()) {
            localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.c().get(0);
          }
        }
        else
        {
          return localStrategyInfo2;
          if (i <= 0)
          {
            localStrategyInfo1 = this.b;
            continue;
          }
          if ((this.b.id != DownloadGlobalStrategy.Strategy_DomainDirect.id) && (this.b.id != DownloadGlobalStrategy.Strategy_BACKUPIP.id) && (this.b.id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id))
          {
            if (i == 1) {
              a();
            }
            paramInt = 0;
            for (;;)
            {
              if (paramInt >= this.a.size()) {
                j = -1;
              }
              do
              {
                if ((i <= 0) || (i > j)) {
                  break label213;
                }
                localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i - 1);
                break;
                j = paramInt;
              } while (((DownloadGlobalStrategy.StrategyInfo)this.a.get(paramInt)).id == this.b.id);
              paramInt += 1;
            }
            label213:
            localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
            continue;
          }
          if (i == 1)
          {
            a();
            return this.b;
          }
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.a.size())
            {
              if ((i <= 1) || (i > j)) {
                break label325;
              }
              localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i - 2);
              break;
            }
            if (((DownloadGlobalStrategy.StrategyInfo)this.a.get(paramInt)).id == this.b.id) {
              j = paramInt;
            }
            paramInt += 1;
          }
          label325:
          if (i <= j) {
            break label365;
          }
          localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
          continue;
        }
        return (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.b().get(0);
        label365:
        localStrategyInfo1 = null;
      }
    }
    
    public List<DownloadGlobalStrategy.StrategyInfo> getStrategyList()
    {
      return this.a;
    }
    
    public int getSuggestMaxTimes()
    {
      if (this.a != null) {
        return this.a.size();
      }
      return 0;
    }
    
    public void setBackupIP(String paramString)
    {
      this.d = paramString;
    }
    
    public void setDirectIP(String paramString)
    {
      this.c = paramString;
    }
    
    public void setDnsIP(String paramString)
    {
      this.e = paramString;
    }
    
    public void setOldStrategyInfo(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo)
    {
      this.g = paramStrategyInfo;
    }
    
    public void setPort(int paramInt)
    {
      this.f = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */