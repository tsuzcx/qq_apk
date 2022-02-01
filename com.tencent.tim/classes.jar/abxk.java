import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager.1;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager.3;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloKapuEntranceTips;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abxk
  implements Manager
{
  private boolean bGh = true;
  public boolean bGi;
  private boolean bGj;
  private final Object cl = new Object();
  private volatile int cty = 1;
  public ConcurrentHashMap<Integer, String> dE = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloActionData> dF = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloActionData> dG = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> dH = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloGameRoamData> dI = new ConcurrentHashMap();
  public ConcurrentHashMap<String, ApolloPreDownloadData> dJ = new ConcurrentHashMap();
  public ConcurrentHashMap<Integer, ApolloWhiteFaceID> dK = new ConcurrentHashMap();
  public List<ApolloActionData> dQ = Collections.synchronizedList(new ArrayList());
  private Runnable fF = new ApolloDaoManager.1(this);
  public QQAppInterface mApp;
  public List<ApolloActionPackage> packageList = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPackageData> wH = Collections.synchronizedList(new ArrayList());
  public List<ApolloFavActionData> wI = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameData> wJ = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRoamData> wK = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionPush> wL = Collections.synchronizedList(new ArrayList());
  public List<ApolloObtainedActionData> wM = Collections.synchronizedList(new ArrayList());
  private List<AioPushData> wN = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRedDot> wO = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameScoreData> wP = Collections.synchronizedList(new ArrayList());
  public List<ApolloGameRankData> wQ = Collections.synchronizedList(new ArrayList());
  private List<ApolloKapuEntranceTips> wR = Collections.synchronizedList(new ArrayList());
  private List<ApolloKapuEntranceTips> wS = Collections.synchronizedList(new ArrayList());
  
  public abxk(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    abvl.a().setApp(paramQQAppInterface);
    ThreadManager.getFileThreadHandler().post(this.fF);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.persist(paramApolloActionRecentData);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData1 == null) || (paramApolloActionRecentData2 == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.remove(paramApolloActionRecentData2);
    paramQQAppInterface.persist(paramApolloActionRecentData1);
  }
  
  public static List<ApolloActionRecentData> c(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    String str = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.query(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { str, paramString }, null, null, null, null);; paramQQAppInterface = localArrayList) {
      return paramQQAppInterface;
    }
  }
  
  private void cGe()
  {
    if (this.wN != null)
    {
      Iterator localIterator;
      synchronized (this.wN)
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        ArrayList localArrayList = new ArrayList();
        localIterator = this.wN.iterator();
        while (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData != null) && ((localAioPushData.endTs <= i) || (localAioPushData.begTs >= localAioPushData.endTs))) {
            localArrayList.add(localAioPushData);
          }
        }
      }
      if (localCollection.size() > 0)
      {
        localIterator = localCollection.iterator();
        while (localIterator.hasNext()) {
          a((AioPushData)localIterator.next());
        }
        this.wN.removeAll(localCollection);
      }
    }
  }
  
  private void e(ApolloActionData paramApolloActionData)
  {
    Object localObject = paramApolloActionData.keywords;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramApolloActionData.minVer)) || (TextUtils.isEmpty(paramApolloActionData.maxVer)) || (abxh.l(AppSetting.getVersion(), paramApolloActionData.minVer, paramApolloActionData.maxVer)))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject[i];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            this.dH.put(localCharSequence, Integer.valueOf(paramApolloActionData.actionId));
            if (localCharSequence.length() > this.cty) {
              this.cty = localCharSequence.length();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void in(List<ApolloActionPackage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((paramList.get(0) == null) || (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[makesureGameFirst]");
    }
    Iterator localIterator = paramList.iterator();
    int i = -1;
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      int j = i + 1;
      i = j;
      if (localApolloActionPackage.packageId == 100) {
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "index:" + i);
      }
      if ((i <= 0) || (localApolloActionPackage == null)) {
        break;
      }
      paramList.remove(i);
      paramList.add(0, localApolloActionPackage);
      return;
      localApolloActionPackage = null;
    }
  }
  
  /* Error */
  private void is(List<ApolloObtainedActionData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 246 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   28: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +148 -> 181
    //   36: aload_3
    //   37: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: new 330	java/lang/StringBuilder
    //   48: dup
    //   49: sipush 500
    //   52: invokespecial 364	java/lang/StringBuilder:<init>	(I)V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 366
    //   62: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: invokeinterface 220 1 0
    //   72: astore 5
    //   74: aload 5
    //   76: invokeinterface 226 1 0
    //   81: ifeq +165 -> 246
    //   84: aload 5
    //   86: invokeinterface 230 1 0
    //   91: checkcast 368	com/tencent/mobileqq/data/ApolloObtainedActionData
    //   94: astore 6
    //   96: aload_0
    //   97: aload_3
    //   98: aload 6
    //   100: invokevirtual 372	abxk:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -33 -> 74
    //   110: aload 4
    //   112: ldc_w 374
    //   115: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 377	com/tencent/mobileqq/data/ApolloObtainedActionData:id	I
    //   123: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   132: sipush 500
    //   135: if_icmplt -61 -> 74
    //   138: ldc_w 322
    //   141: iconst_2
    //   142: aload 4
    //   144: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload 4
    //   152: iconst_0
    //   153: aload 4
    //   155: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   158: invokevirtual 382	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: goto -88 -> 74
    //   165: astore_3
    //   166: ldc_w 322
    //   169: iconst_2
    //   170: ldc_w 384
    //   173: aload_3
    //   174: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_2
    //   178: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   181: aload_0
    //   182: getfield 95	abxk:wM	Ljava/util/List;
    //   185: ifnull +32 -> 217
    //   188: aload_0
    //   189: getfield 95	abxk:wM	Ljava/util/List;
    //   192: astore_2
    //   193: aload_2
    //   194: monitorenter
    //   195: aload_0
    //   196: getfield 95	abxk:wM	Ljava/util/List;
    //   199: invokeinterface 393 1 0
    //   204: aload_0
    //   205: getfield 95	abxk:wM	Ljava/util/List;
    //   208: aload_1
    //   209: invokeinterface 396 2 0
    //   214: pop
    //   215: aload_2
    //   216: monitorexit
    //   217: aload_0
    //   218: getfield 99	abxk:dG	Ljava/util/concurrent/ConcurrentHashMap;
    //   221: ifnull +10 -> 231
    //   224: aload_0
    //   225: getfield 99	abxk:dG	Ljava/util/concurrent/ConcurrentHashMap;
    //   228: invokevirtual 397	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   231: aload_0
    //   232: getfield 97	abxk:dF	Ljava/util/concurrent/ConcurrentHashMap;
    //   235: ifnull -215 -> 20
    //   238: aload_0
    //   239: getfield 97	abxk:dF	Ljava/util/concurrent/ConcurrentHashMap;
    //   242: invokevirtual 397	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   245: return
    //   246: aload 4
    //   248: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   251: sipush 500
    //   254: if_icmpge +35 -> 289
    //   257: aload 4
    //   259: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   262: ifle +27 -> 289
    //   265: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +21 -> 289
    //   271: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +15 -> 289
    //   277: ldc_w 322
    //   280: iconst_2
    //   281: aload 4
    //   283: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_2
    //   290: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   293: aload_2
    //   294: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   297: goto -116 -> 181
    //   300: astore_1
    //   301: aload_2
    //   302: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: aload_2
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	abxk
    //   0	312	1	paramList	List<ApolloObtainedActionData>
    //   31	67	3	localEntityManager	EntityManager
    //   165	9	3	localException	Exception
    //   55	227	4	localStringBuilder	StringBuilder
    //   72	13	5	localIterator	Iterator
    //   94	25	6	localApolloObtainedActionData	ApolloObtainedActionData
    // Exception table:
    //   from	to	target	type
    //   45	74	165	java/lang/Exception
    //   74	162	165	java/lang/Exception
    //   246	289	165	java/lang/Exception
    //   289	293	165	java/lang/Exception
    //   45	74	300	finally
    //   74	162	300	finally
    //   166	177	300	finally
    //   246	289	300	finally
    //   289	293	300	finally
    //   195	217	307	finally
    //   308	310	307	finally
  }
  
  public HashMap<String, Integer> C()
  {
    HashMap localHashMap = new HashMap();
    if (this.dH != null) {
      localHashMap.putAll(this.dH);
    }
    return localHashMap;
  }
  
  public boolean C(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (this.mApp == null)) {
      return false;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (ApolloGameRoamData)paramArrayList.get(i);
      ((ApolloGameRoamData)localObject1).type = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] userPlayedList[", Integer.valueOf(i), "], gameId=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
      }
      i += 1;
    }
    ??? = new ArrayList();
    Object localObject1 = null;
    if (this.wK != null) {}
    label695:
    label754:
    label885:
    label894:
    for (;;)
    {
      Object localObject4;
      int k;
      ApolloGameRoamData localApolloGameRoamData1;
      synchronized (this.wK)
      {
        if (this.wK.size() > 0)
        {
          localObject1 = new ArrayList();
          int m = paramArrayList.size();
          j = 0;
          i = 0;
          if (j < m)
          {
            localObject4 = (ApolloGameRoamData)paramArrayList.get(j);
            int n = this.wK.size();
            k = 0;
            i = 0;
            if (k >= n) {
              break label878;
            }
            localApolloGameRoamData1 = (ApolloGameRoamData)this.wK.get(k);
            if (((ApolloGameRoamData)localObject4).gameId == localApolloGameRoamData1.gameId)
            {
              localApolloGameRoamData1.type = 2;
              ((ArrayList)???).add(localApolloGameRoamData1);
              break label878;
            }
            if (k == n - 1) {
              ((ArrayList)localObject1).add(localObject4);
            }
            if (TextUtils.isEmpty(localApolloGameRoamData1.tagUrl)) {
              break label869;
            }
            i += 1;
            break label885;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label894;
          }
          k = ((ArrayList)localObject1).size();
          j = 0;
          if (j >= k) {
            break label894;
          }
          localObject4 = (ApolloGameRoamData)((ArrayList)localObject1).get(j);
          this.wK.add(j + i, localObject4);
          j += 1;
          continue;
          localObject4 = this.mApp.a().createEntityManager();
          if (localObject4 == null) {
            break label695;
          }
          ??? = ((EntityManager)localObject4).getTransaction();
          ((EntityTransaction)???).begin();
          if (localObject1 == null) {
            break label754;
          }
        }
      }
      try
      {
        if (((ArrayList)localObject1).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] clear and rewrite game list");
          }
          ((EntityManager)localObject4).execSQL(" DELETE FROM ApolloGameRoamData ");
          if (this.wK != null) {}
          synchronized (this.wK)
          {
            paramArrayList = new ArrayList(this.wK.size());
            paramArrayList.addAll(this.wK);
            ??? = new StringBuilder();
            j = paramArrayList.size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                localApolloGameRoamData1 = (ApolloGameRoamData)paramArrayList.get(i);
                ApolloGameRoamData localApolloGameRoamData2 = new ApolloGameRoamData();
                localApolloGameRoamData2.gameId = localApolloGameRoamData1.gameId;
                localApolloGameRoamData2.type = localApolloGameRoamData1.type;
                localApolloGameRoamData2.tagUrl = localApolloGameRoamData1.tagUrl;
                localApolloGameRoamData2.tagType = localApolloGameRoamData1.tagType;
                localApolloGameRoamData2.tagBegTs = localApolloGameRoamData1.tagBegTs;
                localApolloGameRoamData2.tagEndTs = localApolloGameRoamData1.tagEndTs;
                updateEntity((EntityManager)localObject4, localApolloGameRoamData2);
                ((StringBuilder)???).append("gameId:").append(localApolloGameRoamData2.gameId).append(",type:").append(localApolloGameRoamData2.type).append(",");
                i += 1;
                continue;
                D(this.wK, paramArrayList);
                ((ArrayList)???).addAll(paramArrayList);
                it(paramArrayList);
                break;
                paramArrayList = finally;
                throw paramArrayList;
              }
            }
          }
        }
        return false;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("ApolloDaoManager", 1, "[saveUserPlayedGameRoamData] update db error=", paramArrayList);
        ((EntityTransaction)???).end();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] add game ", ((StringBuilder)???).toString() });
          }
          for (;;)
          {
            ((EntityTransaction)???).commit();
            ((EntityTransaction)???).end();
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "[saveUserPlayedGameRoamData] just update type");
            }
            paramArrayList = ((ArrayList)???).iterator();
            while (paramArrayList.hasNext())
            {
              ??? = (ApolloGameRoamData)paramArrayList.next();
              updateEntity((EntityManager)localObject4, (Entity)???);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloDaoManager", 2, new Object[] { "[saveUserPlayedGameRoamData] update game, id=", Integer.valueOf(((ApolloGameRoamData)???).gameId), ", type=", Integer.valueOf(((ApolloGameRoamData)???).type) });
              }
            }
          }
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      break label885;
      localObject1 = null;
      continue;
      j += 1;
      continue;
      k += 1;
    }
  }
  
  public void D(List<ApolloGameRoamData> paramList1, List<ApolloGameRoamData> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    Object localObject = paramList1.iterator();
    int i = 0;
    int j;
    if ((!((Iterator)localObject).hasNext()) || (TextUtils.isEmpty(((ApolloGameRoamData)((Iterator)localObject).next()).tagUrl)))
    {
      j = 0;
      label51:
      if (j >= paramList2.size()) {
        break label123;
      }
      localObject = (ApolloGameRoamData)paramList2.get(j);
      if (!TextUtils.isEmpty(((ApolloGameRoamData)localObject).tagUrl)) {
        break label111;
      }
      paramList1.add(i, localObject);
    }
    for (;;)
    {
      j += 1;
      break label51;
      i += 1;
      break;
      label111:
      paramList1.add(0, localObject);
    }
    label123:
    paramList1.addAll(i, paramList2);
  }
  
  public void Em(boolean paramBoolean)
  {
    ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
    localApolloActionPackage.packageId = 100;
    localApolloActionPackage.type = 100;
    localApolloActionPackage.isUpdate = paramBoolean;
    if (abxh.bm != null)
    {
      localApolloActionPackage.mIconUnselectedUrl = abxh.bm.optString("apImg");
      localApolloActionPackage.mIconSelectedUrl = abxh.bm.optString("apcImg");
      Io(2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localApolloActionPackage);
      io(localArrayList);
      return;
    }
    QLog.e("ApolloDaoManager", 1, "updateGamePackageInfo sAioGameTabContent is not ready");
    this.bGi = true;
  }
  
  public void I(boolean paramBoolean, List<ApolloWhiteFaceID> paramList)
  {
    if (this.mApp == null) {
      return;
    }
    Object localObject = this.mApp.a().createEntityManager();
    if (localObject == null)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping err em");
      return;
    }
    EntityTransaction localEntityTransaction = ((EntityManager)localObject).getTransaction();
    localEntityTransaction.begin();
    if (paramBoolean) {}
    try
    {
      paramList = ((EntityManager)localObject).query(ApolloWhiteFaceID.class);
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping init size:", Integer.valueOf(paramList.size()) });
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ApolloWhiteFaceID)paramList.next();
          this.dK.put(Integer.valueOf(((ApolloWhiteFaceID)localObject).terminalId), localObject);
        }
      }
    }
    catch (Exception paramList)
    {
      QLog.e("ApolloDaoManager", 1, "saveWhiteFaceIdMapping exception: ", paramList);
      return;
      if (paramList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "saveWhiteFaceIdMapping save size:", Integer.valueOf(paramList.size()) });
        }
        ((EntityManager)localObject).execSQL(" DELETE FROM ApolloWhiteFaceID ");
        this.dK.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)paramList.next();
          this.dK.put(Integer.valueOf(localApolloWhiteFaceID.terminalId), localApolloWhiteFaceID);
          ((EntityManager)localObject).persist(localApolloWhiteFaceID);
        }
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityTransaction.end();
  }
  
  public void In(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = dM();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        if (paramInt != localApolloGameData.gameId) {
          continue;
        }
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(abxi.biF).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder.append("errInfo->game version file not exists, gameId: ").append(localApolloGameData.gameId);
          continue;
        }
        localObject2 = new JSONObject(aqhq.readFileToString((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.dE.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver: ").append((String)localObject2).append("===");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString());
  }
  
  /* Error */
  public void Io(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 78	abxk:packageList	Ljava/util/List;
    //   12: ifnull +125 -> 137
    //   15: aload_0
    //   16: getfield 78	abxk:packageList	Ljava/util/List;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: iconst_1
    //   25: iload_1
    //   26: if_icmpne +165 -> 191
    //   29: aload_0
    //   30: getfield 78	abxk:packageList	Ljava/util/List;
    //   33: invokeinterface 220 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 226 1 0
    //   47: ifeq +339 -> 386
    //   50: aload 5
    //   52: invokeinterface 230 1 0
    //   57: checkcast 312	com/tencent/mobileqq/data/ApolloActionPackage
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull -24 -> 40
    //   67: aload 6
    //   69: getfield 315	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   72: bipush 100
    //   74: if_icmpne -34 -> 40
    //   77: aload 6
    //   79: invokevirtual 601	com/tencent/mobileqq/data/ApolloActionPackage:getCopy	()Lcom/tencent/mobileqq/data/ApolloActionPackage;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 5
    //   88: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +17 -> 108
    //   94: ldc_w 322
    //   97: iconst_2
    //   98: ldc_w 603
    //   101: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 78	abxk:packageList	Ljava/util/List;
    //   112: invokeinterface 393 1 0
    //   117: aload 5
    //   119: ifnull +15 -> 134
    //   122: aload_0
    //   123: getfield 78	abxk:packageList	Ljava/util/List;
    //   126: aload 5
    //   128: invokeinterface 242 2 0
    //   133: pop
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   144: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull -144 -> 7
    //   154: aload 6
    //   156: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   166: iconst_1
    //   167: iload_1
    //   168: if_icmpne +178 -> 346
    //   171: aload 6
    //   173: ldc_w 605
    //   176: invokevirtual 443	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   179: pop
    //   180: aload 5
    //   182: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   185: aload 5
    //   187: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   190: return
    //   191: iconst_2
    //   192: iload_1
    //   193: if_icmpne -59 -> 134
    //   196: iconst_m1
    //   197: istore_2
    //   198: aload_0
    //   199: getfield 78	abxk:packageList	Ljava/util/List;
    //   202: invokeinterface 220 1 0
    //   207: astore 5
    //   209: iload_2
    //   210: istore 4
    //   212: aload 5
    //   214: invokeinterface 226 1 0
    //   219: ifeq +77 -> 296
    //   222: aload 5
    //   224: invokeinterface 230 1 0
    //   229: checkcast 312	com/tencent/mobileqq/data/ApolloActionPackage
    //   232: astore 6
    //   234: iload_2
    //   235: iconst_1
    //   236: iadd
    //   237: istore_3
    //   238: iload_3
    //   239: istore_2
    //   240: aload 6
    //   242: ifnull -33 -> 209
    //   245: iload_3
    //   246: istore_2
    //   247: aload 6
    //   249: getfield 315	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   252: bipush 100
    //   254: if_icmpne -45 -> 209
    //   257: iload_3
    //   258: istore 4
    //   260: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +33 -> 296
    //   266: ldc_w 322
    //   269: iconst_2
    //   270: new 330	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 607
    //   280: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_3
    //   284: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iload_3
    //   294: istore 4
    //   296: iload 4
    //   298: ifle -164 -> 134
    //   301: aload_0
    //   302: getfield 78	abxk:packageList	Ljava/util/List;
    //   305: iload 4
    //   307: invokeinterface 310 2 0
    //   312: checkcast 312	com/tencent/mobileqq/data/ApolloActionPackage
    //   315: getfield 315	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   318: bipush 100
    //   320: if_icmpne -186 -> 134
    //   323: aload_0
    //   324: getfield 78	abxk:packageList	Ljava/util/List;
    //   327: iload 4
    //   329: invokeinterface 345 2 0
    //   334: pop
    //   335: goto -201 -> 134
    //   338: astore 5
    //   340: aload 7
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: iconst_2
    //   347: iload_1
    //   348: if_icmpne -168 -> 180
    //   351: aload 6
    //   353: ldc_w 609
    //   356: invokevirtual 443	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   359: pop
    //   360: goto -180 -> 180
    //   363: astore 6
    //   365: aload 6
    //   367: invokevirtual 612	java/lang/Exception:printStackTrace	()V
    //   370: aload 5
    //   372: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   375: return
    //   376: astore 6
    //   378: aload 5
    //   380: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   383: aload 6
    //   385: athrow
    //   386: aconst_null
    //   387: astore 5
    //   389: goto -281 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	abxk
    //   0	392	1	paramInt	int
    //   197	50	2	i	int
    //   237	57	3	j	int
    //   210	118	4	k	int
    //   38	185	5	localObject1	Object
    //   338	41	5	localObject2	Object
    //   387	1	5	localObject3	Object
    //   60	292	6	localObject4	Object
    //   363	3	6	localException	Exception
    //   376	8	6	localObject5	Object
    //   19	322	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   29	40	338	finally
    //   40	62	338	finally
    //   67	84	338	finally
    //   88	104	338	finally
    //   108	117	338	finally
    //   122	134	338	finally
    //   134	137	338	finally
    //   198	209	338	finally
    //   212	234	338	finally
    //   247	257	338	finally
    //   260	293	338	finally
    //   301	335	338	finally
    //   340	343	338	finally
    //   161	166	363	java/lang/Exception
    //   171	180	363	java/lang/Exception
    //   180	185	363	java/lang/Exception
    //   351	360	363	java/lang/Exception
    //   161	166	376	finally
    //   171	180	376	finally
    //   180	185	376	finally
    //   351	360	376	finally
    //   365	370	376	finally
  }
  
  public List<ApolloActionData> K(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.dQ != null) && (this.dQ.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.dQ)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.dQ.size())
        {
          if (((ApolloActionData)this.dQ.get(i)).feeType == paramInt) {
            break label178;
          }
          localArrayList.add(this.dQ.get(i));
          break label178;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.mApp.a().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "feeType!=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label178:
      i += 1;
    }
  }
  
  public List<ApolloActionData> L(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    List localList = N(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        if ((((ApolloActionData)localList.get(paramInt)).status == 0) && (((ApolloActionData)localList.get(paramInt)).isShow == 1)) {
          localArrayList.add(localList.get(paramInt));
        }
        paramInt += 1;
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return localArrayList;
      }
    }
    return null;
  }
  
  public List<ApolloActionPackage> M(int paramInt)
  {
    if (this.mApp == null) {}
    Object localObject2;
    do
    {
      return null;
      if ((paramInt == 0) || (paramInt == 1)) {
        localObject1 = String.valueOf(paramInt);
      }
      while ((this.packageList != null) && (this.packageList.size() > 0))
      {
        localObject2 = new ArrayList();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.packageList.size())
          {
            if ((((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == Integer.parseInt((String)localObject1)) || (((ApolloActionPackage)this.packageList.get(paramInt)).sessionType == 0)) {
              ((List)localObject2).add(this.packageList.get(paramInt));
            }
            paramInt += 1;
            continue;
            if (paramInt == 3000)
            {
              localObject1 = String.valueOf(1);
              break;
            }
            QLog.e("ApolloDaoManager", 1, "[getPackageInfoBySession], error type:" + paramInt);
            return null;
          }
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "return packageInfoBySession from cache");
          }
          in((List)localObject2);
          return localObject2;
        }
      }
      localObject2 = this.mApp.a().createEntityManager();
    } while (localObject2 == null);
    Object localObject1 = ((EntityManager)localObject2).query(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", localObject1 }, null, null, null, null);
    in((List)localObject1);
    return localObject1;
  }
  
  public List<ApolloActionData> N(int paramInt)
  {
    ??? = null;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if ((this.wH != null) && (this.wH.size() > 0))
    {
      ??? = this.wH;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.wH.size())
        {
          if (((ApolloActionPackageData)this.wH.get(i)).packageId != paramInt) {
            break label459;
          }
          localArrayList1.add(this.wH.get(i));
          break label459;
        }
        if (localArrayList1 == null) {
          break label453;
        }
        paramInt = 0;
        i = 1;
        if (paramInt >= localArrayList1.size()) {
          break label399;
        }
        ??? = a(((ApolloActionPackageData)localArrayList1.get(paramInt)).acitonId);
        if (??? == null) {
          break label297;
        }
        localArrayList2.add(???);
        paramInt += 1;
        continue;
        if (this.mApp != null) {
          break label180;
        }
      }
      finally {}
      return null;
      label180:
      Object localObject5 = this.mApp.a().createEntityManager();
      if (localObject5 != null)
      {
        localObject5 = ((EntityManager)localObject5).query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
        if (QLog.isColorLevel()) {
          if (localObject5 != null) {
            break label283;
          }
        }
        label283:
        for (Object localObject2 = ???;; localObject2 = Integer.valueOf(((List)localObject5).size()))
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "getActionByPackageId from db, size:", localObject2 });
          localObject2 = localObject5;
          break;
        }
        label297:
        if ((this.wH != null) && (this.wH.size() > 0))
        {
          synchronized (this.wH)
          {
            this.wH.remove(((List)localObject2).get(paramInt));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "remove paciton id=" + ((ApolloActionPackageData)((List)localObject2).get(paramInt)).acitonId);
            }
          }
          if (i == 0)
          {
            QLog.e("ApolloDaoManager", 1, "[getActionByPackageId] has some action not exit and check action json");
            if ((this.mApp != null) && (this.bGh))
            {
              this.bGh = false;
              ((abhh)this.mApp.getManager(153)).o(false, "getActionByPackageId action not exit", 1);
            }
          }
          label453:
          return localArrayList2;
        }
      }
      else
      {
        label399:
        continue;
        label459:
        i += 1;
        continue;
      }
      i = 0;
    }
  }
  
  public List<ApolloActionPackageData> O(int paramInt)
  {
    ??? = null;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if ((this.wH != null) && (this.wH.size() > 0)) {}
    List localList;
    for (;;)
    {
      synchronized (this.wH)
      {
        if (i < this.wH.size())
        {
          if (((ApolloActionPackageData)this.wH.get(i)).packageId != paramInt) {
            break label259;
          }
          localArrayList.add(this.wH.get(i));
          break label259;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from cache, size:", Integer.valueOf(localArrayList.size()) });
        }
        return localArrayList;
      }
      if (this.mApp == null) {
        break;
      }
      EntityManager localEntityManager = this.mApp.a().createEntityManager();
      if (localEntityManager != null) {
        localList = localEntityManager.query(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          if (localList != null) {
            break label242;
          }
        }
        for (;;)
        {
          QLog.d("ApolloDaoManager", 2, new Object[] { "return getPackageActionDataById from db, size:", ??? });
          return localList;
          label242:
          ??? = Integer.valueOf(localList.size());
        }
      }
      label259:
      i += 1;
    }
    return localList;
  }
  
  /* Error */
  public void O(List<AioPushData> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokeinterface 246 1 0
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: new 67	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 68	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 101	abxk:wN	Ljava/util/List;
    //   34: ifnull +277 -> 311
    //   37: aload_0
    //   38: getfield 101	abxk:wN	Ljava/util/List;
    //   41: astore 6
    //   43: aload 6
    //   45: monitorenter
    //   46: aload_1
    //   47: invokestatic 695	java/util/Collections:sort	(Ljava/util/List;)V
    //   50: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   53: ldc2_w 213
    //   56: ldiv
    //   57: l2i
    //   58: istore_3
    //   59: aload_1
    //   60: invokeinterface 220 1 0
    //   65: astore 7
    //   67: aload 7
    //   69: invokeinterface 226 1 0
    //   74: ifeq +234 -> 308
    //   77: aload 7
    //   79: invokeinterface 230 1 0
    //   84: checkcast 232	com/tencent/mobileqq/data/AioPushData
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull -24 -> 67
    //   94: aload 8
    //   96: getfield 238	com/tencent/mobileqq/data/AioPushData:begTs	I
    //   99: aload 8
    //   101: getfield 235	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   104: if_icmpgt -37 -> 67
    //   107: aload 8
    //   109: getfield 235	com/tencent/mobileqq/data/AioPushData:endTs	I
    //   112: iload_3
    //   113: if_icmple -46 -> 67
    //   116: aload 8
    //   118: getfield 697	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   121: ifne -54 -> 67
    //   124: aload_0
    //   125: getfield 101	abxk:wN	Ljava/util/List;
    //   128: aload 8
    //   130: invokeinterface 701 2 0
    //   135: istore 4
    //   137: iload 4
    //   139: iflt +67 -> 206
    //   142: aload_0
    //   143: getfield 101	abxk:wN	Ljava/util/List;
    //   146: iload 4
    //   148: invokeinterface 310 2 0
    //   153: checkcast 232	com/tencent/mobileqq/data/AioPushData
    //   156: astore 9
    //   158: aload 9
    //   160: ifnull +27 -> 187
    //   163: aload 9
    //   165: getfield 697	com/tencent/mobileqq/data/AioPushData:isShow	Z
    //   168: ifeq +19 -> 187
    //   171: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +13 -> 187
    //   177: ldc_w 322
    //   180: iconst_2
    //   181: ldc_w 703
    //   184: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 5
    //   189: aload 8
    //   191: invokeinterface 242 2 0
    //   196: pop
    //   197: goto -130 -> 67
    //   200: astore_1
    //   201: aload 6
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +31 -> 240
    //   212: ldc_w 322
    //   215: iconst_2
    //   216: new 330	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 705
    //   226: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: if_icmpne +38 -> 280
    //   245: aload_0
    //   246: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: sipush 255
    //   252: invokevirtual 677	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 710	acfs
    //   258: astore 9
    //   260: aload 9
    //   262: ifnull +33 -> 295
    //   265: aload 9
    //   267: aload 8
    //   269: getfield 713	com/tencent/mobileqq/data/AioPushData:them	Ljava/lang/String;
    //   272: aload 8
    //   274: getfield 716	com/tencent/mobileqq/data/AioPushData:wording	Ljava/lang/String;
    //   277: invokevirtual 720	acfs:eL	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 101	abxk:wN	Ljava/util/List;
    //   284: aload 8
    //   286: invokeinterface 242 2 0
    //   291: pop
    //   292: goto -225 -> 67
    //   295: ldc_w 322
    //   298: iconst_1
    //   299: ldc_w 722
    //   302: invokestatic 520	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -25 -> 280
    //   308: aload 6
    //   310: monitorexit
    //   311: aload_0
    //   312: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   315: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   318: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   321: astore 7
    //   323: aload 7
    //   325: ifnull +105 -> 430
    //   328: aload 7
    //   330: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   333: astore 6
    //   335: aload 6
    //   337: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   340: aload 5
    //   342: invokeinterface 246 1 0
    //   347: ifle +12 -> 359
    //   350: aload_1
    //   351: aload 5
    //   353: invokeinterface 253 2 0
    //   358: pop
    //   359: aload_1
    //   360: invokeinterface 220 1 0
    //   365: astore_1
    //   366: aload_1
    //   367: invokeinterface 226 1 0
    //   372: ifeq +63 -> 435
    //   375: aload_0
    //   376: aload 7
    //   378: aload_1
    //   379: invokeinterface 230 1 0
    //   384: checkcast 232	com/tencent/mobileqq/data/AioPushData
    //   387: invokevirtual 372	abxk:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   390: pop
    //   391: goto -25 -> 366
    //   394: astore_1
    //   395: ldc_w 322
    //   398: iconst_1
    //   399: new 330	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 724
    //   409: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 520	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 6
    //   427: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   430: aload_0
    //   431: invokespecial 726	abxk:cGe	()V
    //   434: return
    //   435: aload 6
    //   437: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   440: aload 6
    //   442: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   445: goto -15 -> 430
    //   448: astore_1
    //   449: aload 6
    //   451: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   454: aload_1
    //   455: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	abxk
    //   0	456	1	paramList	List<AioPushData>
    //   0	456	2	paramInt	int
    //   58	56	3	i	int
    //   135	12	4	j	int
    //   28	324	5	localArrayList	ArrayList
    //   41	409	6	localObject1	Object
    //   65	312	7	localObject2	Object
    //   87	198	8	localAioPushData	AioPushData
    //   156	110	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	67	200	finally
    //   67	89	200	finally
    //   94	137	200	finally
    //   142	158	200	finally
    //   163	187	200	finally
    //   187	197	200	finally
    //   201	204	200	finally
    //   206	240	200	finally
    //   245	260	200	finally
    //   265	280	200	finally
    //   280	292	200	finally
    //   295	305	200	finally
    //   308	311	200	finally
    //   340	359	394	java/lang/Exception
    //   359	366	394	java/lang/Exception
    //   366	391	394	java/lang/Exception
    //   435	440	394	java/lang/Exception
    //   340	359	448	finally
    //   359	366	448	finally
    //   366	391	448	finally
    //   395	425	448	finally
    //   435	440	448	finally
  }
  
  public List<ApolloObtainedActionData> P(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.wM != null) && (this.wM.size() > 0))
    {
      List localList = this.wM;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < this.wM.size())
          {
            if (((ApolloObtainedActionData)this.wM.get(i)).type != paramInt) {
              break label112;
            }
            localArrayList.add(this.wM.get(i));
          }
        }
        finally {}
        label112:
        i += 1;
      }
    }
    return localList1;
  }
  
  public List<ApolloGameRankData> Q(int paramInt)
  {
    if ((this.wQ != null) && (paramInt >= 0))
    {
      if (paramInt >= this.wQ.size()) {
        return new ArrayList(this.wQ);
      }
      return new ArrayList(this.wQ.subList(0, paramInt));
    }
    return null;
  }
  
  public AioPushData a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0) && (this.wN != null))
    {
      Object localObject2;
      synchronized (this.wN)
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        Iterator localIterator = this.wN.iterator();
        if (localIterator.hasNext())
        {
          AioPushData localAioPushData = (AioPushData)localIterator.next();
          if ((localAioPushData == null) || (!localAioPushData.them.equals(paramString)) || (paramInt != localAioPushData.busId) || (localAioPushData.isShow) || (localAioPushData.endTs <= i)) {
            break label166;
          }
          if (localObject1 == null)
          {
            localObject2 = localAioPushData;
          }
          else
          {
            localObject2 = localAioPushData;
            if (localAioPushData.begTs <= ((AioPushData)localObject1).begTs) {
              break label166;
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        label166:
        localObject2 = localObject1;
      }
    }
    return null;
  }
  
  public ApolloActionData a(int paramInt)
  {
    Object localObject1 = null;
    if (this.mApp == null) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = b(paramInt);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = this.mApp.a().createEntityManager();
      } while (localObject2 == null);
      localObject2 = (ApolloActionData)((EntityManager)localObject2).find(ApolloActionData.class, paramInt + "");
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, new Object[] { "findActionById from db:", Integer.valueOf(paramInt) });
    return localObject2;
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.packageList != null) {
      for (;;)
      {
        int i;
        synchronized (this.packageList)
        {
          i = this.packageList.size() - 1;
          if (i < 0) {
            break;
          }
          if (((ApolloActionPackage)this.packageList.get(i)).packageId == paramInt)
          {
            ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)this.packageList.get(i);
            return localApolloActionPackage;
          }
        }
        i -= 1;
      }
    }
    ??? = this.mApp.a().createEntityManager();
    if (??? != null) {
      return (ApolloActionPackage)((EntityManager)???).find(ApolloActionPackage.class, paramInt + "");
    }
    return null;
  }
  
  public ApolloActionPush a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    Object localObject = dO();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloActionPush localApolloActionPush = (ApolloActionPush)((Iterator)localObject).next();
      if ((localApolloActionPush != null) && (localApolloActionPush.mAioType == paramSessionInfo.cZ) && (!TextUtils.isEmpty(paramSessionInfo.aTl)) && (paramSessionInfo.aTl.equals(localApolloActionPush.mSessionId + ""))) {
        return localApolloActionPush;
      }
    }
    return null;
  }
  
  public ApolloFavActionData a(long paramLong)
  {
    Object localObject4 = null;
    List localList;
    int i;
    if (this.wI != null)
    {
      localList = this.wI;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      try
      {
        if (i < this.wI.size())
        {
          if (((ApolloFavActionData)this.wI.get(i)).favId != paramLong) {
            break label170;
          }
          localObject1 = (ApolloFavActionData)this.wI.get(i);
        }
        return localObject1;
      }
      finally {}
      if (this.mApp != null)
      {
        Object localObject3 = this.mApp.a().createEntityManager();
        if (localObject3 != null) {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "find ApolloFavActionData favid=" + paramLong);
          }
        }
        for (localObject3 = (ApolloFavActionData)((EntityManager)localObject3).find(ApolloFavActionData.class, paramLong);; localObject3 = null) {
          return localObject3;
        }
      }
      return null;
      label170:
      i += 1;
    }
  }
  
  public ApolloGameData a(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 0) {
      localObject1 = null;
    }
    ApolloGameData localApolloGameData2;
    do
    {
      return localObject1;
      if (this.wJ != null)
      {
        localObject1 = this.wJ;
        int i = 0;
        for (;;)
        {
          try
          {
            if (i >= this.wJ.size()) {
              break;
            }
            if (((ApolloGameData)this.wJ.get(i)).gameId == paramInt)
            {
              ApolloGameData localApolloGameData1 = (ApolloGameData)this.wJ.get(i);
              return localApolloGameData1;
            }
          }
          finally {}
          i += 1;
        }
      }
      if (this.mApp == null) {
        return null;
      }
      localObject1 = this.mApp.a().createEntityManager();
      if (localObject1 == null) {
        break;
      }
      localApolloGameData2 = (ApolloGameData)((EntityManager)localObject1).find(ApolloGameData.class, paramInt + "");
      localObject1 = localApolloGameData2;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloDaoManager", 2, "findGameById from db");
    return localApolloGameData2;
    return null;
  }
  
  @Deprecated
  public ApolloGameData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    return null;
  }
  
  public ApolloKapuEntranceTips a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      synchronized (this.wR)
      {
        if (this.wR.size() <= 0) {
          break label183;
        }
        i = this.wR.size() - 1;
        if (i < 0) {
          break label183;
        }
        ApolloKapuEntranceTips localApolloKapuEntranceTips1 = (ApolloKapuEntranceTips)this.wR.get(i);
        if (localApolloKapuEntranceTips1.isValid()) {
          return localApolloKapuEntranceTips1;
        }
        this.wR.remove(i);
        i -= 1;
      }
      for (;;)
      {
        synchronized (this.wS)
        {
          if (this.wS.size() <= 0) {
            break label178;
          }
          i = this.wS.size() - 1;
          if (i < 0) {
            break label178;
          }
          ApolloKapuEntranceTips localApolloKapuEntranceTips2 = (ApolloKapuEntranceTips)this.wS.get(i);
          if (localApolloKapuEntranceTips2.isValid()) {
            return localApolloKapuEntranceTips2;
          }
        }
        this.wS.remove(i);
        i -= 1;
        continue;
        label178:
        localObject3 = null;
      }
      label183:
      Object localObject3 = null;
    }
  }
  
  public List<ApolloActionPackage> a(SessionInfo paramSessionInfo)
  {
    if ((this.mApp == null) || (paramSessionInfo == null)) {
      return null;
    }
    return M(paramSessionInfo.cZ);
  }
  
  public List<ApolloGameScoreData> a(String arg1, String paramString2, int paramInt, List<ApolloGameData> paramList)
  {
    Object localObject1 = e(???, paramInt, paramList);
    paramList = new ArrayList();
    if ((localObject1 != null) && (this.wP != null)) {}
    for (;;)
    {
      synchronized (this.wP)
      {
        localObject1 = ((List)localObject1).iterator();
        i = paramInt;
        ApolloGameScoreData localApolloGameScoreData1;
        if (((Iterator)localObject1).hasNext())
        {
          localApolloGameScoreData1 = (ApolloGameScoreData)((Iterator)localObject1).next();
          if (i >= -1) {}
        }
        else
        {
          return paramList;
        }
        Object localObject2 = a(localApolloGameScoreData1.mGameId);
        if ((localObject2 == null) || (((ApolloGameData)localObject2).isShow == 0)) {
          continue;
        }
        localObject2 = this.wP.iterator();
        j = 0;
        paramInt = i;
        if (((Iterator)localObject2).hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData2 = (ApolloGameScoreData)((Iterator)localObject2).next();
          if ((paramString2.equals(localApolloGameScoreData2.mUin)) && (localApolloGameScoreData1.mGameId == localApolloGameScoreData2.mGameId))
          {
            paramList.add(localApolloGameScoreData2);
            i = paramInt - 1;
            paramInt = 1;
            break label261;
          }
        }
        else
        {
          i = paramInt;
          if (j != 0) {
            continue;
          }
          localObject2 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject2).mUin = paramString2;
          ((ApolloGameScoreData)localObject2).mGameId = localApolloGameScoreData1.mGameId;
          ((ApolloGameScoreData)localObject2).mFromDb = false;
          paramList.add(localObject2);
          i = paramInt - 1;
        }
      }
      int i = paramInt;
      paramInt = j;
      break label261;
      return paramList;
      label261:
      int j = paramInt;
      paramInt = i;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramBaseChatPie == null) || (paramBaseChatPie.getApp() == null)) {
      return;
    }
    Object localObject = (abhh)paramBaseChatPie.getApp().getManager(153);
    boolean bool = ((abhh)localObject).jl(paramBaseChatPie.getApp().getCurrentAccountUin());
    int j = ((abhh)localObject).cc(paramBaseChatPie.getApp().getCurrentAccountUin());
    paramBaseChatPie = new ArrayList();
    localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      ApolloActionData localApolloActionData = (ApolloActionData)paramList.get(i);
      if (hZ(localApolloActionData.actionId)) {
        paramBaseChatPie.add(localApolloActionData);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!TextUtils.isEmpty(localApolloActionData.iconUrl)) {
          localArrayList1.add(localApolloActionData);
        } else if (hY(localApolloActionData.actionId)) {
          ((List)localObject).add(localApolloActionData);
        } else if (localApolloActionData.feeType == 1) {
          localArrayList2.add(localApolloActionData);
        } else if (localApolloActionData.feeType == 9)
        {
          if ((bool) && (localApolloActionData.vipLevel <= j))
          {
            localApolloActionData.obtainedTime = (localApolloActionData.version / 1000L);
            ((List)localObject).add(localApolloActionData);
          }
          else
          {
            localArrayList3.add(localApolloActionData);
          }
        }
        else {
          localArrayList3.add(localApolloActionData);
        }
      }
    }
    Collections.sort(paramBaseChatPie, new abxm(this));
    Collections.sort(localArrayList1, new abxn(this));
    Collections.sort((List)localObject, new abxo(this));
    Collections.sort(localArrayList2, new abxp(this));
    Collections.sort(localArrayList3, new abxq(this));
    paramList.clear();
    paramList.addAll(paramBaseChatPie);
    paramList.addAll(localArrayList1);
    paramList.addAll((Collection)localObject);
    paramList.addAll(localArrayList2);
    paramList.addAll(localArrayList3);
  }
  
  public void a(ApolloPreDownloadData paramApolloPreDownloadData)
  {
    this.dJ.remove(paramApolloPreDownloadData.resId);
    this.dJ.put(paramApolloPreDownloadData.resId, paramApolloPreDownloadData);
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localEntityManager.update(paramApolloPreDownloadData);
      localEntityTransaction.commit();
      return;
    }
    catch (Exception paramApolloPreDownloadData)
    {
      QLog.e("ApolloDaoManager", 1, "updatePreDownloadRes exception: ", paramApolloPreDownloadData);
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public void a(AioPushData paramAioPushData)
  {
    if (paramAioPushData == null) {}
    for (;;)
    {
      return;
      if (this.wN != null) {}
      boolean bool;
      EntityManager localEntityManager;
      synchronized (this.wN)
      {
        bool = this.wN.remove(paramAioPushData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "[realDelAioPushData] from cache " + String.valueOf(bool));
        }
        localEntityManager = this.mApp.a().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
    }
  }
  
  public void a(ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.packageList != null) {}
      synchronized (this.packageList)
      {
        int i = this.packageList.size() - 1;
        if (i >= 0)
        {
          if ((this.packageList.get(i) != null) && (((ApolloActionPackage)this.packageList.get(i)).packageId == paramApolloActionPackage.packageId))
          {
            this.packageList.remove(i);
            this.packageList.add(i, paramApolloActionPackage);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionPackage);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.wI != null) {}
      synchronized (this.wI)
      {
        this.wI.add(paramApolloFavActionData);
        if (this.mApp == null) {
          continue;
        }
        ??? = this.mApp.a().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.acitonId + " text=" + paramApolloFavActionData.text);
        }
        ((EntityManager)???).persist(paramApolloFavActionData);
        return;
      }
    }
  }
  
  public void a(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (this.dI != null) {
      this.dI.remove(Integer.valueOf(paramApolloGameRoamData.gameId));
    }
  }
  
  public void a(ApolloKapuEntranceTips paramApolloKapuEntranceTips)
  {
    if ((paramApolloKapuEntranceTips == null) || (this.mApp == null)) {
      return;
    }
    QLog.d("ApolloDaoManager", 1, new Object[] { "updateKapuEntranceTips, tips=", paramApolloKapuEntranceTips });
    int i;
    if (paramApolloKapuEntranceTips.isInstall) {
      synchronized (this.wR)
      {
        if (paramApolloKapuEntranceTips.isValid())
        {
          i = this.wR.size() - 1;
          for (;;)
          {
            if (i >= 0)
            {
              if (((ApolloKapuEntranceTips)this.wR.get(i)).adId == paramApolloKapuEntranceTips.adId) {
                this.wR.set(i, paramApolloKapuEntranceTips);
              }
            }
            else
            {
              this.mApp.a().createEntityManager().update(paramApolloKapuEntranceTips);
              return;
            }
            i -= 1;
          }
        }
        this.wR.remove(paramApolloKapuEntranceTips);
      }
    }
    for (;;)
    {
      synchronized (this.wS)
      {
        if (!paramApolloKapuEntranceTips.isValid()) {
          break label231;
        }
        i = this.wS.size() - 1;
        if (i >= 0)
        {
          if (((ApolloKapuEntranceTips)this.wS.get(i)).adId != paramApolloKapuEntranceTips.adId) {
            break label224;
          }
          this.wS.set(i, paramApolloKapuEntranceTips);
        }
      }
      label224:
      i -= 1;
      continue;
      label231:
      this.wS.remove(paramApolloKapuEntranceTips);
    }
  }
  
  public void a(ApolloObtainedActionData paramApolloObtainedActionData)
  {
    if (paramApolloObtainedActionData == null) {}
    for (;;)
    {
      return;
      if (this.wM != null) {}
      synchronized (this.wM)
      {
        this.wM.add(paramApolloObtainedActionData);
        if (this.dF != null) {
          this.dF.clear();
        }
        if (this.mApp == null) {
          continue;
        }
        ??? = this.mApp.a().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloObtainedActionData:" + paramApolloObtainedActionData.toString());
        }
        ((EntityManager)???).persist(paramApolloObtainedActionData);
        return;
      }
    }
  }
  
  public boolean a(AioPushData paramAioPushData)
  {
    boolean bool = false;
    if ((paramAioPushData != null) && (this.wN != null)) {
      synchronized (this.wN)
      {
        if (this.wN.indexOf(paramAioPushData) >= 0) {
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public boolean a(ApolloGameRoamData paramApolloGameRoamData)
  {
    if (paramApolloGameRoamData == null) {
      return false;
    }
    Object localObject = dM();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject).next();
      if ((localApolloGameData != null) && (localApolloGameData.gameId == paramApolloGameRoamData.gameId)) {
        return true;
      }
    }
    return false;
  }
  
  public Map<String, ApolloPreDownloadData> ac()
  {
    if (this.mApp == null) {
      return new HashMap();
    }
    if (this.dJ.size() > 0) {
      return this.dJ;
    }
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject1 = localObject3;
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null)
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      localObject1 = (ArrayList)localEntityManager.query(ApolloPreDownloadData.class);
      return this.dJ;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("ApolloDaoManager", 1, "getPreDownloadRes exception: ", (Throwable)localObject3);
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public int ar(int paramInt1, int paramInt2)
  {
    if (this.dK == null) {
      return 0;
    }
    ApolloWhiteFaceID localApolloWhiteFaceID = (ApolloWhiteFaceID)this.dK.get(Integer.valueOf(paramInt1));
    if (localApolloWhiteFaceID != null)
    {
      if (paramInt2 == 1) {
        return localApolloWhiteFaceID.action2d;
      }
      return localApolloWhiteFaceID.action3d;
    }
    return 0;
  }
  
  public ApolloActionData b(int paramInt)
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.dQ != null) && (this.dQ.size() > 0)) {
      for (;;)
      {
        int i;
        synchronized (this.dQ)
        {
          i = this.dQ.size() - 1;
          if (i < 0) {
            break;
          }
          ApolloActionData localApolloActionData = (ApolloActionData)this.dQ.get(i);
          if ((localApolloActionData != null) && (localApolloActionData.actionId == paramInt)) {
            return localApolloActionData;
          }
        }
        i -= 1;
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("ApolloDaoManager", 2, new Object[] { "[findActionInCache] actionList no action:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public ApolloGameData b(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    List localList;
    if (this.wJ != null)
    {
      localList = this.wJ;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i >= this.wJ.size()) {
            break;
          }
          if (((ApolloGameData)this.wJ.get(i)).gameId == paramInt)
          {
            ApolloGameData localApolloGameData = (ApolloGameData)this.wJ.get(i);
            return localApolloGameData;
          }
        }
        finally {}
        i += 1;
      }
    }
    return null;
  }
  
  public void b(AioPushData paramAioPushData)
  {
    if ((paramAioPushData == null) || (this.mApp == null)) {
      QLog.e("ApolloDaoManager", 1, "[removeAioPushData] app or data is null");
    }
    Object localObject2;
    do
    {
      return;
      if (this.wN != null) {
        synchronized (this.wN)
        {
          localObject2 = this.wN.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AioPushData localAioPushData = (AioPushData)((Iterator)localObject2).next();
            if (localAioPushData.equals(paramAioPushData)) {
              localAioPushData.isShow = true;
            }
          }
        }
      }
      localObject2 = this.mApp.a().createEntityManager();
    } while (localObject2 == null);
    ??? = ((EntityManager)localObject2).getTransaction();
    ((EntityTransaction)???).begin();
    try
    {
      paramAioPushData.isShow = true;
      boolean bool = ((EntityManager)localObject2).update(paramAioPushData);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, "[removeAioPushData] " + String.valueOf(bool) + " # " + paramAioPushData);
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception paramAioPushData)
    {
      QLog.e("ApolloDaoManager", 1, "removeAioPushData errInfo-> " + paramAioPushData.getMessage());
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void b(ApolloActionPush paramApolloActionPush)
  {
    if ((paramApolloActionPush == null) || (this.mApp == null)) {
      return;
    }
    if (this.wL != null) {}
    for (;;)
    {
      int i;
      Object localObject2;
      synchronized (this.wL)
      {
        i = this.wL.size() - 1;
        if (i >= 0)
        {
          localObject2 = (ApolloActionPush)this.wL.get(i);
          if ((localObject2 != null) && (((ApolloActionPush)localObject2).mAioType == paramApolloActionPush.mAioType) && (((ApolloActionPush)localObject2).mSessionId == paramApolloActionPush.mSessionId)) {
            this.wL.remove(localObject2);
          }
        }
        else
        {
          this.wL.add(paramApolloActionPush);
          localObject2 = this.mApp.a().createEntityManager();
          if (localObject2 == null) {
            break;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
      i -= 1;
    }
  }
  
  public void b(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.wI != null) {}
      synchronized (this.wI)
      {
        int i = this.wI.size() - 1;
        if (i >= 0)
        {
          if (((ApolloFavActionData)this.wI.get(i)).favId == paramApolloFavActionData.favId) {
            this.wI.remove(i);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.toString());
          }
          ((EntityManager)???).remove(paramApolloFavActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void b(EntityManager paramEntityManager, List<ApolloGameScoreData> paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.wP != null)
      {
        this.wP.removeAll(paramList);
        this.wP.addAll(paramList);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        paramEntityManager.persistOrReplace(localApolloGameScoreData);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, new Object[] { "[updateGameScore] ", localApolloGameScoreData });
        }
      }
    }
  }
  
  public ApolloActionData c(int paramInt)
  {
    if (this.mApp == null) {}
    for (;;)
    {
      return null;
      if ((this.dQ != null) && (this.dQ.size() > 0)) {}
      synchronized (this.dQ)
      {
        Iterator localIterator = this.dQ.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          if (localApolloActionData.actionId == paramInt) {
            return localApolloActionData;
          }
        }
        ??? = this.mApp.a().createEntityManager();
        if (??? == null) {
          continue;
        }
        ??? = ((EntityManager)???).query(ApolloActionData.class, false, "actionId=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        if ((??? == null) || (((List)???).size() <= 0)) {
          continue;
        }
        return (ApolloActionData)((List)???).get(0);
      }
    }
  }
  
  /* Error */
  public void c(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +134 -> 135
    //   4: aload_2
    //   5: ifnull +130 -> 135
    //   8: aload_2
    //   9: invokeinterface 246 1 0
    //   14: ifle +121 -> 135
    //   17: aload_0
    //   18: getfield 109	abxk:wQ	Ljava/util/List;
    //   21: ifnull +114 -> 135
    //   24: aload_0
    //   25: getfield 109	abxk:wQ	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 109	abxk:wQ	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 253 2 0
    //   41: pop
    //   42: aload_0
    //   43: getfield 109	abxk:wQ	Ljava/util/List;
    //   46: aload_2
    //   47: invokeinterface 396 2 0
    //   52: pop
    //   53: aload_3
    //   54: monitorexit
    //   55: aload_2
    //   56: invokeinterface 220 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 226 1 0
    //   68: ifeq +67 -> 135
    //   71: aload_2
    //   72: invokeinterface 230 1 0
    //   77: checkcast 982	com/tencent/mobileqq/data/ApolloGameRankData
    //   80: astore_3
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 973	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   86: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq -27 -> 62
    //   92: ldc_w 322
    //   95: iconst_2
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 984
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   113: goto -51 -> 62
    //   116: astore_1
    //   117: ldc_w 322
    //   120: iconst_1
    //   121: aload_1
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: ldc_w 986
    //   131: aastore
    //   132: invokestatic 989	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: return
    //   136: astore_1
    //   137: aload_3
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	abxk
    //   0	141	1	paramEntityManager	EntityManager
    //   0	141	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	116	java/lang/Throwable
    //   55	62	116	java/lang/Throwable
    //   62	113	116	java/lang/Throwable
    //   139	141	116	java/lang/Throwable
    //   31	55	136	finally
    //   137	139	136	finally
  }
  
  public void cFZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[readApolloGameVerFromFile]");
    }
    Object localObject1 = dM();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.i("ApolloDaoManager", 1, "errInfo->gameList is null.");
      return;
    }
    StringBuilder localStringBuilder2;
    for (;;)
    {
      ApolloGameData localApolloGameData;
      Object localObject2;
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("readGameVersion:");
        localStringBuilder2.append("\nerrInfo(config.json not exists):");
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localApolloGameData = (ApolloGameData)((Iterator)localObject1).next();
        localObject2 = new StringBuilder(100);
        ((StringBuilder)localObject2).append(abxi.biF).append(localApolloGameData.gameId).append(File.separator).append("config.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists())
        {
          localStringBuilder2.append(localApolloGameData.gameId).append(", ");
          continue;
        }
        localObject2 = new JSONObject(aqhq.readFileToString((File)localObject2)).optString("version");
      }
      catch (Exception localException)
      {
        QLog.e("ApolloDaoManager", 1, "catch errInfo:" + localException.getMessage());
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.dE.put(Integer.valueOf(localApolloGameData.gameId), localObject2);
      }
      localException.append("gId:").append(localApolloGameData.gameId).append(",ver:").append((String)localObject2).append("|");
    }
    QLog.i("ApolloDaoManager", 1, localException.toString() + localStringBuilder2.toString());
  }
  
  public void cGa()
  {
    if (this.mApp == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      QLog.i("ApolloDaoManager", 1, "removeAllAction");
      if (this.dQ != null) {}
      synchronized (this.dQ)
      {
        this.dQ.clear();
        if (this.dH != null)
        {
          this.dH.clear();
          this.cty = 1;
        }
        localEntityManager = this.mApp.a().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i = 0;
      while (i < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(i);
        if (localApolloActionData != null) {
          localEntityManager.remove(localApolloActionData);
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void cGb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "[removeGameRoamData]");
    }
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      if (this.wK != null) {}
      EntityManager localEntityManager;
      synchronized (this.wK)
      {
        this.wK.clear();
        if (this.dI != null) {
          this.dI.clear();
        }
        localEntityManager = this.mApp.a().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
      }
    }
  }
  
  public void cGc()
  {
    if (this.wH != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.wH)
      {
        this.wH.clear();
        if (this.mApp == null) {
          return;
        }
      }
      localEntityManager = this.mApp.a().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPackageData ");
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void cGd()
  {
    if (this.mApp == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.wM != null) {}
      synchronized (this.wM)
      {
        this.wM.clear();
        localEntityManager = this.mApp.a().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.query(ApolloObtainedActionData.class);
          if (localList != null) {
            ??? = localEntityManager.getTransaction();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).begin();
      int i = 0;
      while (i < localList.size())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)localList.get(i);
        if (localApolloObtainedActionData != null) {
          localEntityManager.remove(localApolloObtainedActionData);
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloDaoManager", 1, "[removeAllObtainedAction] exception: ", localException);
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public List<ApolloGameData> cN()
  {
    List localList = dM();
    if (localList == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no game data info");
      return null;
    }
    Object localObject = dN();
    if (localObject == null)
    {
      QLog.i("ApolloDaoManager", 1, "[getPanelGameList] no user game list");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject).next();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ApolloGameData localApolloGameData = (ApolloGameData)localIterator.next();
        if ((localApolloGameData != null) && (localApolloGameRoamData != null) && (localApolloGameData.gameId == localApolloGameRoamData.gameId) && (localApolloGameData.isShow != 0) && (localApolloGameData.gameId != 1) && (localApolloGameData.gameId != 2) && (!localApolloGameData.isGameApp) && (abxh.l("3.4.4", localApolloGameData.minVer, localApolloGameData.maxVer)))
        {
          localApolloGameData.type = localApolloGameRoamData.type;
          localApolloGameData.tagUrl = localApolloGameRoamData.tagUrl;
          localApolloGameData.tagType = localApolloGameRoamData.tagType;
          localArrayList.add(localApolloGameData);
        }
      }
      if ((localApolloGameRoamData == null) || (TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) || (localApolloGameRoamData.tagEndTs >= NetConnInfoCenter.getServerTime())) {
        break label349;
      }
      i = 1;
    }
    label349:
    for (;;)
    {
      break;
      if ((this.mApp != null) && (i != 0) && (!this.bGj))
      {
        QLog.w("ApolloDaoManager", 1, "getPanelGameList, tab game is out of data");
        ((abhe)this.mApp.getManager(211)).cBE();
        this.bGj = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "[getPanelGameList] panelGameList size:", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
  }
  
  public List<ApolloGameRankData> d(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.wQ != null) && (this.wQ.size() > 0))
    {
      Object localObject = new ArrayList(this.wQ);
      if ((paramInt > 0) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject).next();
          if ((localApolloGameRankData != null) && (paramInt >= 0) && (paramString.equals(localApolloGameRankData.mFriendUin)))
          {
            localArrayList.add(localApolloGameRankData);
            paramInt -= 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void d(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.dQ != null) {}
      synchronized (this.dQ)
      {
        int i = this.dQ.size() - 1;
        if (i >= 0)
        {
          if ((this.dQ.get(i) != null) && (((ApolloActionData)this.dQ.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.dQ.remove(i);
            this.dQ.add(i, paramApolloActionData);
          }
        }
        else
        {
          if (this.mApp == null) {
            continue;
          }
          ??? = this.mApp.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  /* Error */
  public void d(EntityManager paramEntityManager, List<ApolloGameRankData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +124 -> 125
    //   4: aload_2
    //   5: ifnull +120 -> 125
    //   8: aload_2
    //   9: invokeinterface 246 1 0
    //   14: ifle +111 -> 125
    //   17: aload_0
    //   18: getfield 109	abxk:wQ	Ljava/util/List;
    //   21: ifnull +104 -> 125
    //   24: aload_0
    //   25: getfield 109	abxk:wQ	Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 109	abxk:wQ	Ljava/util/List;
    //   35: aload_2
    //   36: invokeinterface 253 2 0
    //   41: pop
    //   42: aload_3
    //   43: monitorexit
    //   44: aload_2
    //   45: invokeinterface 220 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 226 1 0
    //   57: ifeq +68 -> 125
    //   60: aload_2
    //   61: invokeinterface 230 1 0
    //   66: checkcast 982	com/tencent/mobileqq/data/ApolloGameRankData
    //   69: astore_3
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 187	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq -28 -> 51
    //   82: ldc_w 322
    //   85: iconst_2
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: ldc_w 984
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: aastore
    //   100: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   103: goto -52 -> 51
    //   106: astore_1
    //   107: ldc_w 322
    //   110: iconst_1
    //   111: aload_1
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 1058
    //   121: aastore
    //   122: invokestatic 989	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   125: return
    //   126: astore_1
    //   127: aload_3
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	abxk
    //   0	131	1	paramEntityManager	EntityManager
    //   0	131	2	paramList	List<ApolloGameRankData>
    // Exception table:
    //   from	to	target	type
    //   24	31	106	java/lang/Throwable
    //   44	51	106	java/lang/Throwable
    //   51	103	106	java/lang/Throwable
    //   129	131	106	java/lang/Throwable
    //   31	44	126	finally
    //   127	129	126	finally
  }
  
  public List<ApolloActionData> dI()
  {
    if (this.mApp == null) {
      return null;
    }
    if ((this.dQ != null) && (this.dQ.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.dQ)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.dQ.size())
        {
          if (((ApolloActionData)this.dQ.get(i)).isShow != 0) {
            break label170;
          }
          localArrayList.add(this.dQ.get(i));
          break label170;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.mApp.a().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).query(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label170:
      i += 1;
    }
  }
  
  public List<ApolloActionData> dJ()
  {
    label122:
    for (;;)
    {
      try
      {
        Object localObject1 = this.mApp;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        List localList = (List)e().second;
        int i;
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = new ArrayList();
          i = 0;
          if (i < localList.size())
          {
            if (((ApolloActionData)localList.get(i)).status != 0) {
              break label122;
            }
            ((List)localObject1).add(localList.get(i));
            break label122;
          }
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            if (i > 0) {
              continue;
            }
          }
        }
        localObject1 = null;
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  public List<ApolloFavActionData> dK()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.wI != null) {
      localObject = this.wI;
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return localObject;
        localObject = localArrayList;
      } while (this.mApp == null);
      localEntityManager = this.mApp.a().createEntityManager();
      localObject = localArrayList;
    } while (localEntityManager == null);
    return localEntityManager.query(ApolloFavActionData.class);
  }
  
  public List<ApolloActionData> dL()
  {
    ArrayList localArrayList = new ArrayList();
    List localList;
    int i;
    if (this.wI != null)
    {
      localList = this.wI;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.wI.size())
        {
          ApolloActionData localApolloActionData = a(((ApolloFavActionData)this.wI.get(i)).acitonId);
          if (localApolloActionData == null) {
            break label103;
          }
          localArrayList.add(localApolloActionData);
          break label103;
        }
        return localArrayList;
      }
      finally {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloDaoManager", 2, "favActionList is null");
      return localList1;
      label103:
      i += 1;
    }
    return localList1;
  }
  
  public List<ApolloGameData> dM()
  {
    if (this.mApp == null) {}
    do
    {
      return null;
      if ((this.wJ != null) && (this.wJ.size() > 0)) {
        synchronized (this.wJ)
        {
          ArrayList localArrayList = new ArrayList(this.wJ.size());
          localArrayList.addAll(this.wJ);
          return localArrayList;
        }
      }
      ??? = this.mApp.a().createEntityManager();
    } while (??? == null);
    return ((EntityManager)???).query(ApolloGameData.class);
  }
  
  public List<ApolloGameRoamData> dN()
  {
    ??? = null;
    if (this.mApp == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return ???;
          if ((this.wK != null) && (this.wK.size() > 0)) {
            synchronized (this.wK)
            {
              ArrayList localArrayList = new ArrayList(this.wK.size());
              localArrayList.addAll(this.wK);
              return localArrayList;
            }
          }
          localObject3 = this.mApp.a().createEntityManager();
        } while (localObject3 == null);
        localObject3 = ((EntityManager)localObject3).query(ApolloGameRoamData.class);
        ??? = localObject3;
      } while (this.wK == null);
      ??? = localObject3;
    } while (localObject3 == null);
    synchronized (this.wK)
    {
      this.wK.addAll((Collection)localObject3);
      return localObject3;
    }
  }
  
  public List<ApolloActionPush> dO()
  {
    ArrayList localArrayList = null;
    if ((this.wL != null) && (this.wL.size() > 0)) {
      synchronized (this.wL)
      {
        localArrayList = new ArrayList(this.wL.size());
        localArrayList.addAll(this.wL);
        return localArrayList;
      }
    }
    ??? = localObject2;
    if (this.mApp != null)
    {
      EntityManager localEntityManager = this.mApp.a().createEntityManager();
      ??? = localObject2;
      if (localEntityManager != null)
      {
        List localList = localEntityManager.query(ApolloActionPush.class);
        ??? = localList;
        if (this.wL != null)
        {
          ??? = localList;
          if (localList != null)
          {
            ??? = localList;
            if (localList.size() > 0) {
              synchronized (this.wL)
              {
                this.wL.addAll(localList);
                return localList;
              }
            }
          }
        }
      }
    }
    return ???;
  }
  
  /* Error */
  public void dv(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: invokevirtual 418	java/util/ArrayList:size	()I
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 86	abxk:wK	Ljava/util/List;
    //   23: ifnull +130 -> 153
    //   26: aload_0
    //   27: getfield 86	abxk:wK	Ljava/util/List;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_1
    //   34: invokevirtual 474	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 226 1 0
    //   44: ifeq +107 -> 151
    //   47: aload_3
    //   48: invokeinterface 230 1 0
    //   53: checkcast 421	com/tencent/mobileqq/data/ApolloGameRoamData
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 86	abxk:wK	Ljava/util/List;
    //   62: invokeinterface 220 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 226 1 0
    //   76: ifeq -38 -> 38
    //   79: aload 5
    //   81: invokeinterface 230 1 0
    //   86: checkcast 421	com/tencent/mobileqq/data/ApolloGameRoamData
    //   89: astore 6
    //   91: aload 4
    //   93: ifnull -24 -> 69
    //   96: aload 6
    //   98: ifnull -29 -> 69
    //   101: aload 6
    //   103: getfield 431	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   106: aload 4
    //   108: getfield 431	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   111: if_icmpne -42 -> 69
    //   114: aload_0
    //   115: getfield 86	abxk:wK	Ljava/util/List;
    //   118: aload 6
    //   120: invokeinterface 669 2 0
    //   125: pop
    //   126: aload 6
    //   128: getfield 435	com/tencent/mobileqq/data/ApolloGameRoamData:tagUrl	Ljava/lang/String;
    //   131: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifeq -96 -> 38
    //   137: aload_0
    //   138: aload 6
    //   140: invokevirtual 1079	abxk:a	(Lcom/tencent/mobileqq/data/ApolloGameRoamData;)V
    //   143: goto -105 -> 38
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   157: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   160: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull -147 -> 18
    //   168: aload_3
    //   169: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: aload_1
    //   178: invokevirtual 474	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   181: astore_1
    //   182: aload_1
    //   183: invokeinterface 226 1 0
    //   188: ifeq +61 -> 249
    //   191: aload_1
    //   192: invokeinterface 230 1 0
    //   197: checkcast 421	com/tencent/mobileqq/data/ApolloGameRoamData
    //   200: astore 4
    //   202: aload 4
    //   204: ifnull -22 -> 182
    //   207: aload_3
    //   208: new 330	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 1081
    //   218: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 4
    //   223: getfield 431	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   226: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokevirtual 443	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   235: pop
    //   236: goto -54 -> 182
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 612	java/lang/Exception:printStackTrace	()V
    //   244: aload_2
    //   245: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: return
    //   249: aload_2
    //   250: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   253: aload_2
    //   254: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   257: return
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	abxk
    //   0	265	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   30	230	2	localObject1	Object
    //   37	171	3	localObject2	Object
    //   56	166	4	localApolloGameRoamData1	ApolloGameRoamData
    //   67	13	5	localIterator	Iterator
    //   89	50	6	localApolloGameRoamData2	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   33	38	146	finally
    //   38	69	146	finally
    //   69	91	146	finally
    //   101	143	146	finally
    //   147	149	146	finally
    //   151	153	146	finally
    //   173	182	239	java/lang/Exception
    //   182	202	239	java/lang/Exception
    //   207	236	239	java/lang/Exception
    //   249	253	239	java/lang/Exception
    //   173	182	258	finally
    //   182	202	258	finally
    //   207	236	258	finally
    //   240	244	258	finally
    //   249	253	258	finally
  }
  
  /* Error */
  public void dw(ArrayList<ApolloGameRoamData> paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 322
    //   9: iconst_2
    //   10: ldc_w 1085
    //   13: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 418	java/util/ArrayList:size	()I
    //   24: ifne +14 -> 38
    //   27: ldc_w 322
    //   30: iconst_1
    //   31: ldc_w 1087
    //   34: invokestatic 1043	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: ldc_w 322
    //   41: iconst_1
    //   42: new 330	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 1089
    //   52: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 418	java/util/ArrayList:size	()I
    //   59: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 554	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: getfield 86	abxk:wK	Ljava/util/List;
    //   72: ifnull +29 -> 101
    //   75: aload_0
    //   76: getfield 86	abxk:wK	Ljava/util/List;
    //   79: astore_2
    //   80: aload_2
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 86	abxk:wK	Ljava/util/List;
    //   86: iconst_0
    //   87: aload_1
    //   88: invokeinterface 482 3 0
    //   93: pop
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 467	abxk:it	(Ljava/util/List;)V
    //   99: aload_2
    //   100: monitorexit
    //   101: aload_0
    //   102: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: ifnull -68 -> 37
    //   108: aload_0
    //   109: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   112: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   115: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull -83 -> 37
    //   123: aload_3
    //   124: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   127: astore_2
    //   128: aload_2
    //   129: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   132: new 330	java/lang/StringBuilder
    //   135: dup
    //   136: sipush 500
    //   139: invokespecial 364	java/lang/StringBuilder:<init>	(I)V
    //   142: astore 4
    //   144: aload_1
    //   145: invokevirtual 474	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   148: astore_1
    //   149: aload_1
    //   150: invokeinterface 226 1 0
    //   155: ifeq +76 -> 231
    //   158: aload_1
    //   159: invokeinterface 230 1 0
    //   164: checkcast 421	com/tencent/mobileqq/data/ApolloGameRoamData
    //   167: astore 5
    //   169: aload_0
    //   170: aload_3
    //   171: aload 5
    //   173: invokevirtual 372	abxk:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   176: pop
    //   177: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -31 -> 149
    //   183: aload 4
    //   185: ldc_w 1091
    //   188: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 5
    //   193: getfield 431	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   196: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -51 -> 149
    //   203: astore_1
    //   204: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +14 -> 221
    //   210: ldc_w 322
    //   213: iconst_2
    //   214: ldc_w 1093
    //   217: aload_1
    //   218: invokestatic 1095	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload_2
    //   222: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   225: return
    //   226: astore_1
    //   227: aload_2
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: aload 4
    //   233: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   236: sipush 500
    //   239: if_icmpge +21 -> 260
    //   242: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +15 -> 260
    //   248: ldc_w 322
    //   251: iconst_2
    //   252: aload 4
    //   254: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_2
    //   261: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   264: aload_2
    //   265: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   268: return
    //   269: astore_1
    //   270: aload_2
    //   271: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   274: aload_1
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	abxk
    //   0	276	1	paramArrayList	ArrayList<ApolloGameRoamData>
    //   79	192	2	localObject	Object
    //   118	53	3	localEntityManager	EntityManager
    //   142	111	4	localStringBuilder	StringBuilder
    //   167	25	5	localApolloGameRoamData	ApolloGameRoamData
    // Exception table:
    //   from	to	target	type
    //   132	149	203	java/lang/Exception
    //   149	200	203	java/lang/Exception
    //   231	260	203	java/lang/Exception
    //   260	264	203	java/lang/Exception
    //   82	101	226	finally
    //   227	229	226	finally
    //   132	149	269	finally
    //   149	200	269	finally
    //   204	221	269	finally
    //   231	260	269	finally
    //   260	264	269	finally
  }
  
  public Pair<List<ApolloFavActionData>, List<ApolloActionData>> e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDaoManager", 2, "getFavPanelActionPairInfo");
    }
    List localList = dK();
    Collections.sort(localList, new abxl(this));
    ArrayList localArrayList = new ArrayList(localList.size());
    int k = localList.size();
    int j = 0;
    int i = 1;
    if (j < k)
    {
      Object localObject = (ApolloFavActionData)localList.get(j);
      if (localObject == null) {
        break label190;
      }
      localObject = a(((ApolloFavActionData)localObject).acitonId);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    label190:
    for (;;)
    {
      j += 1;
      break;
      i = 0;
      continue;
      if (i == 0)
      {
        QLog.e("ApolloDaoManager", 1, "[getFavPanelActionPairInfo] has some action not exit and check action json");
        if ((this.mApp != null) && (this.bGh))
        {
          this.bGh = false;
          ((abhh)this.mApp.getManager(153)).o(false, "getFavPanelActionPairInfo action not exit", 1);
        }
      }
      return new Pair(localList, localArrayList);
    }
  }
  
  public List<ApolloGameScoreData> e(String paramString, int paramInt, List<ApolloGameData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.wP != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      synchronized (this.wP)
      {
        paramList = new ArrayList(paramList).iterator();
        i = paramInt;
        ApolloGameData localApolloGameData;
        if (paramList.hasNext())
        {
          localApolloGameData = (ApolloGameData)paramList.next();
          if (i >= -1) {}
        }
        else
        {
          return localArrayList;
        }
        Object localObject = a(localApolloGameData.gameId);
        if ((localObject == null) || (((ApolloGameData)localObject).isShow == 0)) {
          continue;
        }
        Iterator localIterator = new ArrayList(this.wP).iterator();
        j = 0;
        paramInt = i;
        if (localIterator.hasNext())
        {
          ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)localIterator.next();
          if ((paramString.equals(localApolloGameScoreData.mUin)) && (localApolloGameData.gameId == localApolloGameScoreData.mGameId))
          {
            localArrayList.add(localApolloGameScoreData);
            i = paramInt - 1;
            paramInt = 1;
            break label306;
          }
        }
        else
        {
          i = paramInt;
          if (j != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "[getScoreDataByUin] append " + ((ApolloGameData)localObject).gameId);
          }
          localObject = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject).mUin = paramString;
          ((ApolloGameScoreData)localObject).mGameId = localApolloGameData.gameId;
          ((ApolloGameScoreData)localObject).mFromDb = false;
          localArrayList.add(localObject);
          i = paramInt - 1;
        }
      }
      int i = paramInt;
      paramInt = j;
      break label306;
      return localArrayList;
      label306:
      int j = paramInt;
      paramInt = i;
    }
  }
  
  /* Error */
  public void e(Map<String, ApolloPreDownloadData> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +10 -> 11
    //   4: aload_0
    //   5: getfield 113	abxk:dJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 397	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   11: aload_0
    //   12: getfield 113	abxk:dJ	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_1
    //   16: invokevirtual 1115	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   19: aload_0
    //   20: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   26: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +80 -> 113
    //   36: aload 4
    //   38: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   46: iload_2
    //   47: ifeq +12 -> 59
    //   50: aload 4
    //   52: ldc_w 1117
    //   55: invokevirtual 443	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   58: pop
    //   59: aload_1
    //   60: invokeinterface 1123 1 0
    //   65: invokeinterface 1126 1 0
    //   70: astore_1
    //   71: aload_1
    //   72: invokeinterface 226 1 0
    //   77: ifeq +37 -> 114
    //   80: aload 4
    //   82: aload_1
    //   83: invokeinterface 230 1 0
    //   88: checkcast 882	com/tencent/mobileqq/apollo/data/ApolloPreDownloadData
    //   91: invokevirtual 182	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   94: goto -23 -> 71
    //   97: astore_1
    //   98: ldc_w 322
    //   101: iconst_1
    //   102: ldc_w 1128
    //   105: aload_1
    //   106: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_3
    //   110: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   113: return
    //   114: aload_3
    //   115: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   118: aload_3
    //   119: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   122: return
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	abxk
    //   0	130	1	paramMap	Map<String, ApolloPreDownloadData>
    //   0	130	2	paramBoolean	boolean
    //   41	84	3	localEntityTransaction	EntityTransaction
    //   29	52	4	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   50	59	97	java/lang/Exception
    //   59	71	97	java/lang/Exception
    //   71	94	97	java/lang/Exception
    //   114	118	97	java/lang/Exception
    //   50	59	123	finally
    //   59	71	123	finally
    //   71	94	123	finally
    //   98	109	123	finally
    //   114	118	123	finally
  }
  
  public void f(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      if (this.dQ != null) {}
      synchronized (this.dQ)
      {
        int i = this.dQ.size() - 1;
        if (i >= 0)
        {
          if ((this.dQ != null) && (this.dQ.get(i) != null) && (((ApolloActionData)this.dQ.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.dQ.remove(i);
            this.dQ.add(i, paramApolloActionData);
          }
        }
        else
        {
          ??? = this.mApp.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).update(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public List<ApolloActionData> getActionList()
  {
    Integer localInteger = null;
    if (this.mApp == null) {}
    do
    {
      return null;
      if ((this.dQ != null) && (this.dQ.size() > 0)) {
        return this.dQ;
      }
      localObject = this.mApp.a().createEntityManager();
    } while (localObject == null);
    Object localObject = ((EntityManager)localObject).query(ApolloActionData.class);
    if (QLog.isColorLevel()) {
      if (localObject != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.d("ApolloDaoManager", 2, new Object[] { "[getActionList] db list size:", localInteger });
      return localObject;
      label90:
      localInteger = Integer.valueOf(((List)localObject).size());
    }
  }
  
  public boolean hX(int paramInt)
  {
    if (this.wK == null) {
      return false;
    }
    List localList = this.wK;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.wK.size()) {
          break;
        }
        if (((ApolloGameRoamData)this.wK.get(i)).gameId == paramInt) {
          return true;
        }
      }
      finally {}
      i += 1;
    }
    return false;
  }
  
  public boolean hY(int paramInt)
  {
    return l().containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean hZ(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = m();
    if (localConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (((ApolloActionData)localConcurrentHashMap.get(Integer.valueOf(paramInt))).limitEnd >= NetConnInfoCenter.getServerTime()) {
        return true;
      }
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      ThreadManager.post(new ApolloDaoManager.3(this, paramInt), 5, null, true);
    }
    return false;
  }
  
  public void hg(long paramLong)
  {
    if (this.wL != null) {}
    EntityManager localEntityManager;
    do
    {
      synchronized (this.wL)
      {
        Iterator localIterator = this.wL.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPush localApolloActionPush = (ApolloActionPush)localIterator.next();
          if ((localApolloActionPush != null) && (localApolloActionPush.mId == paramLong)) {
            this.wL.remove(localApolloActionPush);
          }
        }
        if (this.mApp == null) {
          return;
        }
      }
      localEntityManager = this.mApp.a().createEntityManager();
    } while (localEntityManager == null);
    ??? = localEntityManager.getTransaction();
    try
    {
      ((EntityTransaction)???).begin();
      localEntityManager.execSQL(" DELETE FROM ApolloActionPush WHERE mId = " + paramLong);
      ((EntityTransaction)???).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).end();
    }
  }
  
  public void il(List<ApolloActionData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.mApp.a().createEntityManager();
      if (localEntityManager != null)
      {
        ??? = localEntityManager.getTransaction();
        ((EntityTransaction)???).begin();
      }
      try
      {
        localStringBuilder = new StringBuilder(500);
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          e(localApolloActionData);
          updateEntity(localEntityManager, localApolloActionData);
          if (QLog.isColorLevel())
          {
            localStringBuilder.append(" saveAction ID:").append(localApolloActionData.actionId);
            if (localStringBuilder.length() >= 500)
            {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
            }
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", localException);
        }
        ((EntityTransaction)???).end();
        while (this.dQ != null)
        {
          synchronized (this.dQ)
          {
            this.dQ.addAll(paramList);
            return;
          }
          if ((localStringBuilder.length() < 500) && (localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
            QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
          }
          ((EntityTransaction)???).commit();
          ((EntityTransaction)???).end();
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  public void im(List<ApolloActionData> paramList)
  {
    if ((this.mApp == null) || (paramList == null)) {
      return;
    }
    if ((this.dQ != null) && (paramList != null)) {}
    for (;;)
    {
      int i;
      int j;
      EntityManager localEntityManager;
      synchronized (this.dQ)
      {
        i = this.dQ.size() - 1;
        if (i >= 0)
        {
          j = paramList.size() - 1;
          if (j <= 0) {
            break label230;
          }
          if (((ApolloActionData)paramList.get(j)).actionId != ((ApolloActionData)this.dQ.get(i)).actionId) {
            break label223;
          }
          this.dQ.remove(i);
          this.dQ.add(i, paramList.get(j));
          break label223;
        }
        localEntityManager = this.mApp.a().createEntityManager();
        ??? = localEntityManager.getTransaction();
      }
      try
      {
        ((EntityTransaction)???).begin();
        i = 0;
        while (i < paramList.size())
        {
          updateEntity(localEntityManager, (Entity)paramList.get(i));
          i += 1;
          continue;
          paramList = finally;
          throw paramList;
        }
        ((EntityTransaction)???).commit();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      label223:
      j -= 1;
      continue;
      label230:
      i -= 1;
    }
  }
  
  public void io(List<ApolloActionPackage> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.packageList != null) {}
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.packageList)
      {
        if ((paramList.size() == 1) && (paramList.get(0) != null) && (((ApolloActionPackage)paramList.get(0)).packageId == 100)) {
          if (i < this.packageList.size())
          {
            if (((ApolloActionPackage)this.packageList.get(i)).packageId == 100)
            {
              this.packageList.remove(i);
              QLog.i("ApolloDaoManager", 1, "repeat game package.");
            }
          }
          else
          {
            this.packageList.add(0, paramList.get(0));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, "add game package.");
            }
            if (this.mApp == null) {
              break;
            }
            localEntityManager = this.mApp.a().createEntityManager();
            if (localEntityManager == null) {
              break;
            }
            ??? = localEntityManager.getTransaction();
            ((EntityTransaction)???).begin();
          }
        }
      }
      try
      {
        localStringBuilder = new StringBuilder(200);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList.next();
          updateEntity(localEntityManager, localApolloActionPackage);
          localStringBuilder.append(" savePackage ID:").append(localApolloActionPackage.packageId);
          if (localStringBuilder.length() >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
            }
            localStringBuilder.delete(0, localStringBuilder.length());
          }
        }
      }
      catch (Exception paramList)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", paramList);
        }
        return;
        i += 1;
        continue;
        this.packageList.addAll(paramList);
        continue;
        paramList = finally;
        throw paramList;
        if ((localStringBuilder.length() < 200) && (QLog.isColorLevel())) {
          QLog.d("ApolloDaoManager", 2, localStringBuilder.toString());
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  /* Error */
  public void ip(List<ApolloActionPackageData> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 246 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 80	abxk:wH	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 80	abxk:wH	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 80	abxk:wH	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 396 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   55: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: new 330	java/lang/StringBuilder
    //   75: dup
    //   76: sipush 500
    //   79: invokespecial 364	java/lang/StringBuilder:<init>	(I)V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 220 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 226 1 0
    //   97: ifeq +117 -> 214
    //   100: aload_1
    //   101: invokeinterface 230 1 0
    //   106: checkcast 654	com/tencent/mobileqq/data/ApolloActionPackageData
    //   109: astore 5
    //   111: aload_0
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 372	abxk:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   118: pop
    //   119: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +20 -> 142
    //   125: aload 4
    //   127: ldc_w 1177
    //   130: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: getfield 658	com/tencent/mobileqq/data/ApolloActionPackageData:acitonId	I
    //   138: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   147: sipush 500
    //   150: if_icmplt -59 -> 91
    //   153: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -65 -> 91
    //   159: ldc_w 322
    //   162: iconst_2
    //   163: aload 4
    //   165: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 4
    //   173: iconst_0
    //   174: aload 4
    //   176: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   179: invokevirtual 382	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: goto -92 -> 91
    //   186: astore_1
    //   187: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +14 -> 204
    //   193: ldc_w 322
    //   196: iconst_2
    //   197: ldc_w 1164
    //   200: aload_1
    //   201: invokestatic 1095	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   208: return
    //   209: astore_1
    //   210: aload_2
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: aload 4
    //   216: invokevirtual 378	java/lang/StringBuilder:length	()I
    //   219: sipush 500
    //   222: if_icmpge +21 -> 243
    //   225: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +15 -> 243
    //   231: ldc_w 322
    //   234: iconst_2
    //   235: aload 4
    //   237: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   247: aload_2
    //   248: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   251: return
    //   252: astore_1
    //   253: aload_2
    //   254: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	abxk
    //   0	259	1	paramList	List<ApolloActionPackageData>
    //   25	229	2	localObject	Object
    //   58	55	3	localEntityManager	EntityManager
    //   82	154	4	localStringBuilder	StringBuilder
    //   109	25	5	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   72	91	186	java/lang/Exception
    //   91	142	186	java/lang/Exception
    //   142	183	186	java/lang/Exception
    //   214	243	186	java/lang/Exception
    //   243	247	186	java/lang/Exception
    //   28	41	209	finally
    //   210	212	209	finally
    //   72	91	252	finally
    //   91	142	252	finally
    //   142	183	252	finally
    //   187	204	252	finally
    //   214	243	252	finally
    //   243	247	252	finally
  }
  
  public void iq(List<ApolloGameData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject3;
    for (;;)
    {
      return;
      localObject2 = new StringBuilder();
      localStringBuilder = new StringBuilder();
      localObject3 = new ArrayList();
      if (this.wJ != null) {}
      synchronized (this.wJ)
      {
        if (this.wJ.size() == 0)
        {
          this.wJ.addAll(paramList);
          ((StringBuilder)localObject2).append("add All");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList cache:", ((StringBuilder)localObject2).toString(), ", insert:", localStringBuilder.toString() });
          }
          if (this.mApp == null) {
            continue;
          }
          localObject2 = this.mApp.a().createEntityManager();
          if (localObject2 == null) {
            continue;
          }
          ??? = ((EntityManager)localObject2).getTransaction();
          ((EntityTransaction)???).begin();
        }
      }
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete gameId:");
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          ApolloGameData localApolloGameData = (ApolloGameData)((Iterator)localObject3).next();
          ((EntityManager)localObject2).execSQL(" DELETE FROM ApolloGameData WHERE gameId = " + localApolloGameData.gameId);
          localStringBuilder.append(localApolloGameData.gameId).append(",");
          continue;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloDaoManager", 1, "updateGameInfoList exception: ", paramList);
        return;
        ((StringBuilder)localObject2).append("repeat gameId:");
        j = 0;
        if (j >= paramList.size()) {
          break;
        }
        k = 0;
        int i = 0;
        if (k < this.wJ.size())
        {
          if (((ApolloGameData)paramList.get(j)).gameId != ((ApolloGameData)this.wJ.get(k)).gameId) {
            break label608;
          }
          ((List)localObject3).add(paramList.get(j));
          this.wJ.remove(k);
          this.wJ.add(k, paramList.get(j));
          ((StringBuilder)localObject2).append(((ApolloGameData)paramList.get(j)).gameId).append(",");
          i = 1;
          break label608;
        }
        if (i != 0) {
          break label617;
        }
        this.wJ.add(paramList.get(j));
        localStringBuilder.append(((ApolloGameData)paramList.get(j)).gameId).append(",");
        break label617;
        paramList = finally;
        throw paramList;
        localStringBuilder.append("; insert gameId:");
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject3 = (ApolloGameData)paramList.next();
          updateEntity((EntityManager)localObject2, (Entity)localObject3);
          localStringBuilder.append(((ApolloGameData)localObject3).gameId).append(",");
          continue;
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDaoManager", 2, new Object[] { "updateGameInfoList db:", localStringBuilder.toString() });
      }
      ((EntityTransaction)???).commit();
      ((EntityTransaction)???).end();
      return;
      label608:
      k += 1;
      continue;
      label617:
      j += 1;
    }
  }
  
  /* Error */
  public void ir(List<ApolloFavActionData> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 82	abxk:wI	Ljava/util/List;
    //   12: ifnull +90 -> 102
    //   15: aload_0
    //   16: getfield 82	abxk:wI	Ljava/util/List;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: aload_1
    //   28: invokeinterface 246 1 0
    //   33: if_icmpge +66 -> 99
    //   36: aload_0
    //   37: getfield 82	abxk:wI	Ljava/util/List;
    //   40: invokeinterface 246 1 0
    //   45: iconst_1
    //   46: isub
    //   47: istore_3
    //   48: iload_3
    //   49: iflt +163 -> 212
    //   52: aload_0
    //   53: getfield 82	abxk:wI	Ljava/util/List;
    //   56: iload_3
    //   57: invokeinterface 310 2 0
    //   62: checkcast 782	com/tencent/mobileqq/data/ApolloFavActionData
    //   65: getfield 785	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   68: aload_1
    //   69: iload_2
    //   70: invokeinterface 310 2 0
    //   75: checkcast 782	com/tencent/mobileqq/data/ApolloFavActionData
    //   78: getfield 785	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   81: lcmp
    //   82: ifne +123 -> 205
    //   85: aload_0
    //   86: getfield 82	abxk:wI	Ljava/util/List;
    //   89: iload_3
    //   90: invokeinterface 345 2 0
    //   95: pop
    //   96: goto +109 -> 205
    //   99: aload 5
    //   101: monitorexit
    //   102: aload_0
    //   103: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: ifnull -99 -> 7
    //   109: aload_0
    //   110: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   113: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   116: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   119: astore 6
    //   121: aload 6
    //   123: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   126: astore 5
    //   128: aload 5
    //   130: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   133: iload 4
    //   135: istore_2
    //   136: iload_2
    //   137: aload_1
    //   138: invokeinterface 246 1 0
    //   143: if_icmpge +32 -> 175
    //   146: aload 6
    //   148: aload_1
    //   149: iload_2
    //   150: invokeinterface 310 2 0
    //   155: checkcast 1168	com/tencent/mobileqq/persistence/Entity
    //   158: invokevirtual 187	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   161: pop
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -30 -> 136
    //   169: astore_1
    //   170: aload 5
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: aload 5
    //   177: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   180: aload 5
    //   182: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   185: return
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 612	java/lang/Exception:printStackTrace	()V
    //   191: aload 5
    //   193: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   196: return
    //   197: astore_1
    //   198: aload 5
    //   200: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: aload_1
    //   204: athrow
    //   205: iload_3
    //   206: iconst_1
    //   207: isub
    //   208: istore_3
    //   209: goto -161 -> 48
    //   212: iload_2
    //   213: iconst_1
    //   214: iadd
    //   215: istore_2
    //   216: goto -190 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	abxk
    //   0	219	1	paramList	List<ApolloFavActionData>
    //   25	191	2	i	int
    //   47	162	3	j	int
    //   1	133	4	k	int
    //   19	180	5	localObject	Object
    //   119	28	6	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   26	48	169	finally
    //   52	96	169	finally
    //   99	102	169	finally
    //   170	173	169	finally
    //   128	133	186	java/lang/Exception
    //   136	162	186	java/lang/Exception
    //   175	180	186	java/lang/Exception
    //   128	133	197	finally
    //   136	162	197	finally
    //   175	180	197	finally
    //   187	191	197	finally
  }
  
  public void it(List<ApolloGameRoamData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramList.next();
        if ((!TextUtils.isEmpty(localApolloGameRoamData.tagUrl)) && (this.dI != null)) {
          this.dI.put(Integer.valueOf(localApolloGameRoamData.gameId), localApolloGameRoamData);
        }
      }
    }
  }
  
  /* Error */
  public void iu(List<ApolloKapuEntranceTips> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 322
    //   11: iconst_2
    //   12: ldc_w 1204
    //   15: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 134	abxk:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   37: invokevirtual 176	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: astore 4
    //   42: new 67	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 68	java/util/ArrayList:<init>	()V
    //   49: astore_3
    //   50: aload 4
    //   52: ifnull +67 -> 119
    //   55: aload 4
    //   57: ldc_w 799
    //   60: invokevirtual 530	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +52 -> 119
    //   70: aload 5
    //   72: invokeinterface 246 1 0
    //   77: ifle +42 -> 119
    //   80: ldc_w 322
    //   83: iconst_1
    //   84: iconst_2
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc_w 1206
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload 5
    //   98: invokeinterface 246 1 0
    //   103: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: aload 5
    //   113: invokeinterface 396 2 0
    //   118: pop
    //   119: new 67	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 68	java/util/ArrayList:<init>	()V
    //   126: astore 5
    //   128: aload_1
    //   129: ifnull +171 -> 300
    //   132: aload_1
    //   133: invokeinterface 246 1 0
    //   138: ifle +162 -> 300
    //   141: ldc_w 322
    //   144: iconst_1
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: ldc_w 1208
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_1
    //   158: invokeinterface 246 1 0
    //   163: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: invokeinterface 220 1 0
    //   176: astore_1
    //   177: aload_1
    //   178: invokeinterface 226 1 0
    //   183: ifeq +117 -> 300
    //   186: aload_1
    //   187: invokeinterface 230 1 0
    //   192: checkcast 799	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   195: astore 6
    //   197: aload_3
    //   198: invokeinterface 220 1 0
    //   203: astore 7
    //   205: aload 7
    //   207: invokeinterface 226 1 0
    //   212: ifeq +361 -> 573
    //   215: aload 7
    //   217: invokeinterface 230 1 0
    //   222: checkcast 799	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   225: astore 8
    //   227: aload 6
    //   229: getfield 922	com/tencent/mobileqq/data/ApolloKapuEntranceTips:adId	I
    //   232: aload 8
    //   234: getfield 922	com/tencent/mobileqq/data/ApolloKapuEntranceTips:adId	I
    //   237: if_icmpne -32 -> 205
    //   240: iconst_1
    //   241: istore_2
    //   242: iload_2
    //   243: ifne -66 -> 177
    //   246: aload 6
    //   248: invokevirtual 802	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isValid	()Z
    //   251: ifeq -74 -> 177
    //   254: aload 5
    //   256: aload 6
    //   258: invokeinterface 242 2 0
    //   263: pop
    //   264: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -90 -> 177
    //   270: ldc_w 322
    //   273: iconst_1
    //   274: iconst_2
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 1210
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 6
    //   288: aastore
    //   289: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: goto -115 -> 177
    //   295: astore_1
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    //   300: ldc_w 322
    //   303: iconst_1
    //   304: iconst_2
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 1212
    //   313: aastore
    //   314: dup
    //   315: iconst_1
    //   316: aload 5
    //   318: invokeinterface 246 1 0
    //   323: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: aastore
    //   327: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   330: aload 5
    //   332: ifnull +91 -> 423
    //   335: aload 5
    //   337: invokeinterface 246 1 0
    //   342: ifle +81 -> 423
    //   345: aload 4
    //   347: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 361	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   355: aload 5
    //   357: invokeinterface 220 1 0
    //   362: astore 5
    //   364: aload 5
    //   366: invokeinterface 226 1 0
    //   371: ifeq +124 -> 495
    //   374: aload 5
    //   376: invokeinterface 230 1 0
    //   381: checkcast 799	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   384: astore 6
    //   386: aload 4
    //   388: aload 6
    //   390: invokevirtual 973	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   393: aload_3
    //   394: aload 6
    //   396: invokeinterface 242 2 0
    //   401: pop
    //   402: goto -38 -> 364
    //   405: astore 4
    //   407: ldc_w 322
    //   410: iconst_1
    //   411: ldc_w 1214
    //   414: aload 4
    //   416: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   419: aload_1
    //   420: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   423: aload_3
    //   424: invokeinterface 220 1 0
    //   429: astore_1
    //   430: aload_1
    //   431: invokeinterface 226 1 0
    //   436: ifeq +109 -> 545
    //   439: aload_1
    //   440: invokeinterface 230 1 0
    //   445: checkcast 799	com/tencent/mobileqq/data/ApolloKapuEntranceTips
    //   448: astore_3
    //   449: aload_3
    //   450: invokevirtual 802	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isValid	()Z
    //   453: ifeq -23 -> 430
    //   456: aload_3
    //   457: getfield 919	com/tencent/mobileqq/data/ApolloKapuEntranceTips:isInstall	Z
    //   460: ifeq +53 -> 513
    //   463: aload_0
    //   464: getfield 117	abxk:wR	Ljava/util/List;
    //   467: astore 4
    //   469: aload 4
    //   471: monitorenter
    //   472: aload_0
    //   473: getfield 117	abxk:wR	Ljava/util/List;
    //   476: aload_3
    //   477: invokeinterface 242 2 0
    //   482: pop
    //   483: aload 4
    //   485: monitorexit
    //   486: goto -56 -> 430
    //   489: astore_1
    //   490: aload 4
    //   492: monitorexit
    //   493: aload_1
    //   494: athrow
    //   495: aload_1
    //   496: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   499: aload_1
    //   500: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   503: goto -80 -> 423
    //   506: astore_3
    //   507: aload_1
    //   508: invokevirtual 390	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   511: aload_3
    //   512: athrow
    //   513: aload_0
    //   514: getfield 119	abxk:wS	Ljava/util/List;
    //   517: astore 4
    //   519: aload 4
    //   521: monitorenter
    //   522: aload_0
    //   523: getfield 119	abxk:wS	Ljava/util/List;
    //   526: aload_3
    //   527: invokeinterface 242 2 0
    //   532: pop
    //   533: aload 4
    //   535: monitorexit
    //   536: goto -106 -> 430
    //   539: astore_1
    //   540: aload 4
    //   542: monitorexit
    //   543: aload_1
    //   544: athrow
    //   545: new 1216	abxr
    //   548: dup
    //   549: aload_0
    //   550: invokespecial 1217	abxr:<init>	(Labxk;)V
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 117	abxk:wR	Ljava/util/List;
    //   558: aload_1
    //   559: invokestatic 866	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   562: aload_0
    //   563: getfield 119	abxk:wS	Ljava/util/List;
    //   566: aload_1
    //   567: invokestatic 866	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   570: goto -543 -> 27
    //   573: iconst_0
    //   574: istore_2
    //   575: goto -333 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	abxk
    //   0	578	1	paramList	List<ApolloKapuEntranceTips>
    //   241	334	2	i	int
    //   22	455	3	localObject1	Object
    //   506	21	3	localObject2	Object
    //   40	347	4	localEntityManager	EntityManager
    //   405	10	4	localException	Exception
    //   63	312	5	localObject3	Object
    //   195	200	6	localApolloKapuEntranceTips1	ApolloKapuEntranceTips
    //   203	13	7	localIterator	Iterator
    //   225	8	8	localApolloKapuEntranceTips2	ApolloKapuEntranceTips
    // Exception table:
    //   from	to	target	type
    //   2	18	295	finally
    //   18	23	295	finally
    //   30	50	295	finally
    //   55	65	295	finally
    //   70	119	295	finally
    //   119	128	295	finally
    //   132	177	295	finally
    //   177	205	295	finally
    //   205	240	295	finally
    //   246	292	295	finally
    //   300	330	295	finally
    //   335	351	295	finally
    //   419	423	295	finally
    //   423	430	295	finally
    //   430	472	295	finally
    //   493	495	295	finally
    //   499	503	295	finally
    //   507	513	295	finally
    //   513	522	295	finally
    //   543	545	295	finally
    //   545	570	295	finally
    //   351	364	405	java/lang/Exception
    //   364	402	405	java/lang/Exception
    //   495	499	405	java/lang/Exception
    //   472	486	489	finally
    //   490	493	489	finally
    //   351	364	506	finally
    //   364	402	506	finally
    //   407	419	506	finally
    //   495	499	506	finally
    //   522	536	539	finally
    //   540	543	539	finally
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> l()
  {
    if ((this.dF != null) && (this.dF.size() > 0)) {
      return this.dF;
    }
    Object localObject = P(0);
    if (this.dF == null) {
      this.dF = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        ApolloActionData localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = localApolloObtainedActionData.id;
        localApolloActionData.obtainedTime = localApolloObtainedActionData.beginTs;
        this.dF.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
      }
    }
    return this.dF;
  }
  
  public ConcurrentHashMap<Integer, ApolloActionData> m()
  {
    if ((this.dG != null) && (this.dG.size() > 0)) {
      return this.dG;
    }
    Object localObject = P(6);
    if (this.dG == null) {
      this.dG = new ConcurrentHashMap();
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloObtainedActionData localApolloObtainedActionData = (ApolloObtainedActionData)((Iterator)localObject).next();
        if ((!hY(localApolloObtainedActionData.id)) && (localApolloObtainedActionData.endts >= NetConnInfoCenter.getServerTime()))
        {
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionId = localApolloObtainedActionData.id;
          localApolloActionData.limitStart = localApolloObtainedActionData.beginTs;
          localApolloActionData.limitEnd = localApolloObtainedActionData.endts;
          this.dG.put(Integer.valueOf(localApolloActionData.actionId), localApolloActionData);
        }
      }
    }
    return this.dG;
  }
  
  public ConcurrentHashMap<Integer, ApolloGameRoamData> n()
  {
    if (this.dI == null) {
      return new ConcurrentHashMap();
    }
    return this.dI;
  }
  
  public void onDestroy()
  {
    if (this.dQ != null)
    {
      this.dQ.clear();
      this.dQ = null;
    }
    if (this.packageList != null)
    {
      this.packageList.clear();
      this.packageList = null;
    }
    if (this.wH != null)
    {
      this.wH.clear();
      this.wH = null;
    }
    if (this.wI != null)
    {
      this.wI.clear();
      this.wI = null;
    }
    if (this.wJ != null)
    {
      this.wJ.clear();
      this.wJ = null;
    }
    if (this.wL != null)
    {
      this.wL.clear();
      this.wL = null;
    }
    if (this.wM != null)
    {
      this.wM.clear();
      this.wM = null;
    }
    if (this.dF != null)
    {
      this.dF.clear();
      this.dF = null;
    }
    if (this.dG != null)
    {
      this.dG.clear();
      this.dG = null;
    }
    if (this.dH != null)
    {
      this.dH.clear();
      this.dH = null;
    }
    if (this.wQ != null)
    {
      this.wQ.clear();
      this.wQ = null;
    }
    if (this.wP != null)
    {
      this.wP.clear();
      this.wP = null;
    }
    if (this.dJ != null) {
      this.dJ.clear();
    }
    if (this.dK != null) {
      this.dK.clear();
    }
    ApolloGameUtil.releaseCache();
  }
  
  public void q(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            ApolloObtainedActionData localApolloObtainedActionData = new ApolloObtainedActionData();
            localApolloObtainedActionData.id = localJSONObject.optInt("id");
            localApolloObtainedActionData.beginTs = localJSONObject.optLong("beginTs");
            localApolloObtainedActionData.endts = localJSONObject.optLong("endts");
            localApolloObtainedActionData.way = localJSONObject.optInt("way");
            localApolloObtainedActionData.type = localJSONObject.optInt("type");
            localArrayList.add(localApolloObtainedActionData);
          }
        }
        else
        {
          cGd();
          is(localArrayList);
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ApolloDaoManager", 1, "[saveApolloObtainedActionList] Exception =", paramJSONArray);
        return;
      }
      i += 1;
    }
  }
  
  public boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    QLog.d("ApolloDaoManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public int zY()
  {
    return this.cty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxk
 * JD-Core Version:    0.7.0.1
 */