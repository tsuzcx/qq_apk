import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import com.tencent.mobileqq.data.PrecoverRetryInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.precover.PrecoverManager.1;
import com.tencent.mobileqq.precover.PrecoverManager.2;
import com.tencent.mobileqq.precover.PrecoverManager.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class alaj
  implements alai, Manager
{
  private static Set<Integer> cL = new HashSet();
  private alah jdField_a_of_type_Alah;
  private alak jdField_a_of_type_Alak;
  private alal jdField_a_of_type_Alal;
  private alaf[] jdField_a_of_type_ArrayOfAlaf = new alaf[cL.size()];
  private HashSet<PrecoverResource> aD;
  private QQAppInterface app;
  private boolean cvH;
  private final byte[] fd = new byte[0];
  private EntityManager mEntityManager;
  private final HashMap<String, List<PrecoverResource>> mm = new HashMap();
  private final HashMap<String, PrecoverResource> mn = new HashMap();
  
  static
  {
    cL.add(Integer.valueOf(0));
  }
  
  public alaj(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Alal = new alal(paramQQAppInterface, this);
    this.jdField_a_of_type_Alah = alah.a();
    this.jdField_a_of_type_Alak = new alak(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new PrecoverManager.1(this), 10, null, false);
      return;
    }
    qh();
  }
  
  private PrecoverRetryInfo a(PrecoverResource paramPrecoverResource)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "getRetryInfo, res=" + paramPrecoverResource);
    }
    if (paramPrecoverResource == null) {
      return null;
    }
    try
    {
      paramPrecoverResource = this.mEntityManager.query(PrecoverRetryInfo.class, false, "pk = ?", new String[] { paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5 }, null, null, null, null);
      if ((paramPrecoverResource != null) && (paramPrecoverResource.size() > 0))
      {
        paramPrecoverResource = (PrecoverRetryInfo)paramPrecoverResource.get(0);
        return paramPrecoverResource;
      }
    }
    catch (Exception paramPrecoverResource)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverManager", 2, new Object[] { "getRetryInfo, exception=", paramPrecoverResource.getMessage() });
          paramPrecoverResource.printStackTrace();
        }
        paramPrecoverResource = null;
        continue;
        paramPrecoverResource = null;
      }
    }
  }
  
  private static String a(PrecoverResource paramPrecoverResource)
  {
    return paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5;
  }
  
  private <T extends PrecoverResource> List<T> a(String paramString, Class<T> paramClass)
  {
    return a("businessId = ?", new String[] { paramString }, paramClass);
  }
  
  private void a(PrecoverRetryInfo paramPrecoverRetryInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramPrecoverRetryInfo != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramPrecoverRetryInfo)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "updateRetryInfo, retryInfo=", localObject });
      if (paramPrecoverRetryInfo != null) {
        break;
      }
      return;
    }
    d(paramPrecoverRetryInfo);
  }
  
  private boolean ati()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "isNetworkCanDown");
    }
    int i = this.jdField_a_of_type_Alah.network;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "isNetworkCanDown, return true, param == 2");
      }
      return true;
    }
    int j = aqiw.getSystemNetwork(BaseApplicationImpl.getContext());
    boolean bool;
    if (i == 0) {
      if (j == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "isNetworkCanDown, param=", Integer.valueOf(i), ", netType=", Integer.valueOf(j), ", result=", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      continue;
      if (i == 1)
      {
        if ((j == 1) || (j == 4) || (j == 3)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (i == 3)
      {
        if ((j == 1) || (j == 4)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  /* Error */
  private boolean b(String paramString, Class<? extends Entity> paramClass)
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: aload_1
    //   7: ifnonnull +74 -> 81
    //   10: ldc 235
    //   12: astore_3
    //   13: ldc 150
    //   15: iconst_2
    //   16: iconst_4
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 282
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_3
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 284
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: aload_2
    //   39: invokevirtual 289	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   46: aload_1
    //   47: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +29 -> 79
    //   53: aload_2
    //   54: ldc 178
    //   56: if_acmpeq +30 -> 86
    //   59: aload_2
    //   60: ldc_w 297
    //   63: if_acmpeq +23 -> 86
    //   66: aload_2
    //   67: ldc 172
    //   69: if_acmpeq +17 -> 86
    //   72: aload_2
    //   73: ldc_w 299
    //   76: if_acmpeq +10 -> 86
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_1
    //   82: astore_3
    //   83: goto -70 -> 13
    //   86: aload_0
    //   87: getfield 88	alaj:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: invokevirtual 303	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 308	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   98: aload_2
    //   99: invokevirtual 289	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   102: astore_2
    //   103: aload_1
    //   104: ldc_w 310
    //   107: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifeq +63 -> 173
    //   113: ldc_w 315
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_2
    //   123: aastore
    //   124: invokestatic 319	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   127: astore_1
    //   128: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +23 -> 154
    //   134: ldc 150
    //   136: iconst_2
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc_w 321
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_1
    //   150: aastore
    //   151: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 88	alaj:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   158: aload_1
    //   159: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   162: pop
    //   163: aload_3
    //   164: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   167: aload_3
    //   168: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   171: iconst_1
    //   172: ireturn
    //   173: ldc_w 333
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_1
    //   187: aastore
    //   188: invokestatic 319	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   191: astore_1
    //   192: goto -64 -> 128
    //   195: astore_1
    //   196: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +30 -> 229
    //   202: ldc 150
    //   204: iconst_2
    //   205: iconst_2
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 335
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload_1
    //   218: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   225: aload_1
    //   226: invokevirtual 211	java/lang/Exception:printStackTrace	()V
    //   229: aload_3
    //   230: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: aload_3
    //   237: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	alaj
    //   0	242	1	paramString	String
    //   0	242	2	paramClass	Class<? extends Entity>
    //   12	225	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   94	128	195	java/lang/Exception
    //   128	154	195	java/lang/Exception
    //   154	167	195	java/lang/Exception
    //   173	192	195	java/lang/Exception
    //   94	128	235	finally
    //   128	154	235	finally
    //   154	167	235	finally
    //   173	192	235	finally
    //   196	229	235	finally
  }
  
  private void d(Entity paramEntity)
  {
    if (QLog.isColorLevel()) {
      if (paramEntity != null) {
        break label38;
      }
    }
    label38:
    for (Object localObject = "null";; localObject = paramEntity)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity=", localObject });
      if (paramEntity != null) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity.Name=", paramEntity.getClass().getSimpleName() });
    }
    localObject = this.mEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)localObject).begin();
      this.mEntityManager.persistOrReplace(paramEntity);
      ((EntityTransaction)localObject).commit();
      return;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, exception=", paramEntity.getMessage() });
        paramEntity.printStackTrace();
      }
      return;
    }
    finally
    {
      ((EntityTransaction)localObject).end();
    }
  }
  
  private boolean e(Class<? extends Entity> paramClass)
  {
    return b("delete_all", paramClass);
  }
  
  private void qh()
  {
    Object localObject5;
    Object localObject6;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "initCache");
      }
      Object localObject1 = a(null, null, PrecoverResource.class);
      localObject5 = a(null, null, PrecoverResourceBusiness.class);
      synchronized (this.fd)
      {
        this.mm.clear();
        this.mn.clear();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            PrecoverResource localPrecoverResource = (PrecoverResource)((Iterator)localObject6).next();
            if (localPrecoverResource.isValid())
            {
              localList = (List)this.mm.get(localPrecoverResource.businessId);
              localObject1 = localList;
              if (localList == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localPrecoverResource);
              this.mm.put(localPrecoverResource.businessId, localObject1);
              this.mn.put(a(localPrecoverResource), localPrecoverResource);
            }
          }
        }
      }
      if (localObject5 == null) {
        break label315;
      }
    }
    finally {}
    if (((List)localObject5).size() > 0)
    {
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (PrecoverResource)((Iterator)localObject5).next();
        if (((PrecoverResource)localObject6).isValid())
        {
          localList = (List)this.mm.get(((PrecoverResource)localObject6).businessId);
          Object localObject4 = localList;
          if (localList == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject6);
          this.mm.put(((PrecoverResource)localObject6).businessId, localObject4);
          this.mn.put(a((PrecoverResource)localObject6), localObject6);
        }
      }
    }
    label315:
  }
  
  public int Hq()
  {
    if (this.jdField_a_of_type_Alah != null) {
      return this.jdField_a_of_type_Alah.network;
    }
    return 0;
  }
  
  public void Nz(boolean paramBoolean)
  {
    boolean bool = alan.V(this.app.getApp(), this.app.getCurrentAccountUin() + "_config_cover");
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "checkReportConfigCover, succ=", Boolean.valueOf(paramBoolean), ", need=", Boolean.valueOf(bool) });
    }
    if (bool)
    {
      alan.bL(this.app.getApp(), this.app.getCurrentAccountUin() + "_config_cover");
      this.jdField_a_of_type_Alak.NA(paramBoolean);
    }
  }
  
  protected HashMap<String, List<PrecoverResource>> T()
  {
    return this.mm;
  }
  
  public alak a()
  {
    return this.jdField_a_of_type_Alak;
  }
  
  public alal a()
  {
    return this.jdField_a_of_type_Alal;
  }
  
  public PrecoverResource a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    return (PrecoverResource)this.mn.get(paramString1 + "_" + paramString2);
  }
  
  protected <T extends Entity> List<T> a(String paramString, String[] paramArrayOfString, Class<T> paramClass)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        break label111;
      }
      str = "null";
      if (paramArrayOfString != null) {
        break label117;
      }
    }
    label111:
    label117:
    for (Object localObject = "null";; localObject = paramArrayOfString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "queryAll, selction=", str, ", selectionArgs=", localObject, ", clz=", paramClass.getSimpleName() });
      if ((paramClass == PrecoverResource.class) || (paramClass == PrecoverResourceBusiness.class) || (paramClass == PrecoverRetryInfo.class) || (paramClass == PrecoverConfig.class)) {
        break label123;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "queryAll, clz not valid");
      }
      return null;
      str = paramString;
      break;
    }
    try
    {
      label123:
      paramString = this.mEntityManager.query(paramClass, false, paramString, paramArrayOfString, null, null, null, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "queryAll, exception=", paramString.getMessage() });
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((!this.cvH) || (this.aD == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "onDownloadFinish, needReport, mReportSet.size=", Integer.valueOf(this.aD.size()), ", res=", paramPrecoverResource });
      }
      this.aD.remove(paramPrecoverResource);
    } while (this.aD.size() != 0);
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "onDownloadFinish, download finish, doing report");
    }
    this.jdField_a_of_type_Alal.b(this);
    this.cvH = false;
    this.aD = null;
    ThreadManager.post(new PrecoverManager.4(this), 5, null, false);
  }
  
  protected void a(PrecoverResource paramPrecoverResource)
  {
    if (paramPrecoverResource == null) {}
    PrecoverRetryInfo localPrecoverRetryInfo;
    do
    {
      return;
      localPrecoverRetryInfo = a(paramPrecoverResource);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "deleteRertyInfo, info=" + localPrecoverRetryInfo);
      }
    } while (localPrecoverRetryInfo == null);
    paramPrecoverResource = this.mEntityManager.getTransaction();
    try
    {
      paramPrecoverResource.begin();
      this.mEntityManager.remove(localPrecoverRetryInfo);
      paramPrecoverResource.commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "deleteRertyInfo, exception=", localException.getMessage() });
        localException.printStackTrace();
      }
      return;
    }
    finally
    {
      paramPrecoverResource.end();
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
  
  protected boolean a(PrecoverResource paramPrecoverResource)
  {
    if ((paramPrecoverResource == null) || (!paramPrecoverResource.isValid())) {}
    do
    {
      PrecoverRetryInfo localPrecoverRetryInfo;
      long l;
      do
      {
        do
        {
          return false;
          if (ati()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PrecoverManager", 2, "canDownload, networkRight, return false");
        return false;
        localPrecoverRetryInfo = a(paramPrecoverResource);
        l = System.currentTimeMillis();
        if (localPrecoverRetryInfo == null)
        {
          localPrecoverRetryInfo = new PrecoverRetryInfo();
          localPrecoverRetryInfo.businessId = paramPrecoverResource.businessId;
          localPrecoverRetryInfo.md5 = paramPrecoverResource.md5;
          localPrecoverRetryInfo.itemRetryCount = 1;
          localPrecoverRetryInfo.totalRetryCount = 1;
          localPrecoverRetryInfo.retryUpdateTime = l;
          d(localPrecoverRetryInfo);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "canDownload, info == null, return true");
          }
          return true;
        }
        if (localPrecoverRetryInfo.totalRetryCount <= this.jdField_a_of_type_Alah.dre) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PrecoverManager", 2, "canDownload, info.totalRetryCount > mControl.totalRetry, return false");
      return false;
      if (Math.abs(l - localPrecoverRetryInfo.retryUpdateTime) > 86400000L)
      {
        localPrecoverRetryInfo.itemRetryCount = 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, daily count expire, return true");
        }
        return true;
      }
      if (localPrecoverRetryInfo.itemRetryCount < this.jdField_a_of_type_Alah.drd)
      {
        localPrecoverRetryInfo.itemRetryCount += 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, info.itemRetryCount < mControl.itemRetry, return true");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PrecoverManager", 2, "canDownload, return false");
    return false;
  }
  
  protected void aT(String paramString)
  {
    if (paramString == null) {}
    for (String str = "null";; str = paramString)
    {
      QLog.d("PrecoverManager", 1, new Object[] { "startDownload, businessId=", str });
      ThreadManager.post(new PrecoverManager.2(this, paramString), 5, null, false);
      return;
    }
  }
  
  public boolean atj()
  {
    boolean bool = alan.V(this.app.getApp(), "get_config_time");
    int j = alan.c(this.app, "get_config_count", 0);
    if (bool)
    {
      alan.bL(this.app.getApp(), "get_config_time");
      alan.B(this.app, "get_config_count", 1);
      return true;
    }
    if (b() != null) {}
    for (int i = b().drg; j >= i; i = 5) {
      return false;
    }
    alan.B(this.app, "get_config_count", j + 1);
    return true;
  }
  
  public alah b()
  {
    return this.jdField_a_of_type_Alah;
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public void lM(List<Pair<Integer, String>> arg1)
  {
    Object localObject1;
    if (??? == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      try
      {
        QLog.d("PrecoverManager", 1, new Object[] { "onHandleConfigs, configList.size=", localObject1 });
        if ((??? == null) || (???.size() == 0))
        {
          e(PrecoverConfig.class);
          e(PrecoverResource.class);
          return;
          localObject1 = Integer.valueOf(???.size());
          continue;
        }
        e(PrecoverConfig.class);
        localObject3 = new HashMap();
        localObject1 = new HashMap();
        ??? = ???.iterator();
        Object localObject4;
        if (???.hasNext())
        {
          localObject4 = (Pair)???.next();
          if ((localObject4 == null) || (TextUtils.isEmpty((CharSequence)((Pair)localObject4).second))) {
            continue;
          }
          int i = ((Integer)((Pair)localObject4).first).intValue();
          localObject5 = alan.g((String)((Pair)localObject4).second);
          if ((localObject5 == null) || (((Pair)localObject5).first == null) || (((Pair)localObject5).second == null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "onHandleConfigs, businessid=", ((alag)((Pair)localObject5).first).businessId, ", name=", ((alag)((Pair)localObject5).first).name, ", list.size=", Integer.valueOf(((List)((Pair)localObject5).second).size()) });
          }
          if (TextUtils.isEmpty(((alag)((Pair)localObject5).first).businessId)) {
            continue;
          }
          String str = ((alag)((Pair)localObject5).first).businessId;
          if ((((HashMap)localObject3).containsKey(str)) && (((Integer)((HashMap)localObject3).get(str)).intValue() >= i)) {
            continue;
          }
          ((HashMap)localObject3).put(str, Integer.valueOf(i));
          ((HashMap)localObject1).put(str, ((Pair)localObject5).second);
          d(new PrecoverConfig(str, (String)((Pair)localObject4).second, i));
          continue;
        }
        synchronized (this.fd)
        {
          e(PrecoverResource.class);
          localObject3 = ((HashMap)localObject1).keySet().iterator();
          do
          {
            while (!((Iterator)localObject4).hasNext())
            {
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (List)((HashMap)localObject1).get((String)((Iterator)localObject3).next());
              } while ((localObject4 == null) || (((List)localObject4).size() <= 0));
              localObject4 = ((List)localObject4).iterator();
            }
            localObject5 = (PrecoverResource)((Iterator)localObject4).next();
            if (!((PrecoverResource)localObject5).isValid()) {
              break;
            }
            d((Entity)localObject5);
          } while (!QLog.isColorLevel());
          QLog.d("PrecoverManager", 2, "onHandleConfigs, insert res:" + localObject5);
        }
      }
      finally {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "onHandleConfigs, res invalid:" + localObject5);
        }
      }
      ??? = new StringBuilder();
      if (localObject2.size() > 0)
      {
        ???.append(" WHERE businessId NOT IN (");
        Iterator localIterator = localObject2.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          ???.append("'").append((String)localObject3).append("',");
        }
        ???.setCharAt(???.length() - 1, ')');
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "onHandleConfigs, selection of sql=" + ???.toString());
      }
      nW("DELETE FROM " + PrecoverResourceBusiness.class.getSimpleName() + ???.toString());
      nW("DELETE FROM " + PrecoverRetryInfo.class.getSimpleName() + ???.toString());
      qh();
    }
  }
  
  protected boolean nW(String paramString)
  {
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label64;
      }
    }
    for (localObject = "null";; localObject = paramString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "execSql, businessId=", localObject });
      localObject = this.mEntityManager.getTransaction();
      try
      {
        ((EntityTransaction)localObject).begin();
        this.mEntityManager.execSQL(paramString);
        ((EntityTransaction)localObject).commit();
        return true;
      }
      catch (Exception paramString)
      {
        label64:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PrecoverManager", 2, new Object[] { "execSql, exception=", paramString.getMessage() });
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        ((EntityTransaction)localObject).end();
      }
    }
  }
  
  public void onDestroy() {}
  
  public void startDownload()
  {
    try
    {
      aT(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alaj
 * JD-Core Version:    0.7.0.1
 */