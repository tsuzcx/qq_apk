import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager.1;
import com.tencent.mobileqq.managers.TroopAssistantManager.2;
import com.tencent.mobileqq.managers.TroopAssistantManager.3;
import com.tencent.mobileqq.managers.TroopAssistantManager.4;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class aizp
{
  public static aizp b;
  protected List<TroopAssistantData> CN;
  public Set<String> H = new HashSet();
  protected boolean baU = true;
  protected int bfi;
  HashSet<String> bh = new HashSet();
  protected boolean cmX;
  protected boolean cmY;
  protected boolean cmZ;
  protected boolean cna;
  protected int dhk = -1;
  protected Object ee = new Object();
  protected final Map<String, TroopAssistantData> lF = new HashMap();
  protected String mAccount;
  protected long mLastReadTime;
  public Object object = new Object();
  
  public static aizp a()
  {
    try
    {
      if (b == null) {
        b = new aizp();
      }
      aizp localaizp = b;
      return localaizp;
    }
    finally {}
  }
  
  private TroopAssistantData a(QQAppInterface arg1, String paramString)
  {
    dh(???);
    synchronized (this.lF)
    {
      paramString = (TroopAssistantData)this.lF.get(paramString);
      return paramString;
    }
  }
  
  private TroopAssistantData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    dh(paramQQAppInterface);
    synchronized (this.lF)
    {
      TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.lF.get(paramString);
      paramEntityManager = localTroopAssistantData;
      if (localTroopAssistantData == null)
      {
        localTroopAssistantData = new TroopAssistantData();
        localTroopAssistantData.troopUin = paramString;
        paramQQAppInterface = paramQQAppInterface.b();
        paramEntityManager = localTroopAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1);
          paramEntityManager = localTroopAssistantData;
          if (paramQQAppInterface != null)
          {
            localTroopAssistantData.lastdrafttime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopAssistantData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.object;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.H.contains(paramString))) {
        this.H.add(paramString);
      }
      ao(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  private void a(EntityManager paramEntityManager, TroopAssistantData paramTroopAssistantData)
  {
    if ((paramTroopAssistantData == null) || (TextUtils.isEmpty(paramTroopAssistantData.troopUin))) {
      return;
    }
    synchronized (this.lF)
    {
      this.lF.put(paramTroopAssistantData.troopUin, paramTroopAssistantData);
    }
    for (;;)
    {
      synchronized (this.ee)
      {
        if (this.CN != null)
        {
          this.CN.remove(paramTroopAssistantData);
          int j = this.CN.size();
          i = 0;
          if (i >= j) {
            break label207;
          }
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.CN.get(i);
          if (Math.max(paramTroopAssistantData.lastmsgtime, paramTroopAssistantData.lastdrafttime) <= Math.max(localTroopAssistantData.lastmsgtime, localTroopAssistantData.lastdrafttime)) {
            continue;
          }
          this.CN.add(i, paramTroopAssistantData);
          i = 1;
          if (i == 0) {
            this.CN.add(this.CN.size(), paramTroopAssistantData);
          }
        }
        ThreadManager.post(new TroopAssistantManager.4(this, paramTroopAssistantData, paramEntityManager), 8, null, false);
        return;
        paramEntityManager = finally;
        throw paramEntityManager;
        i += 1;
      }
      label207:
      int i = 0;
    }
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.object)
    {
      if ((paramQQAppInterface.a().A(paramString, 1) > 0) && (!this.H.contains(paramString))) {
        this.H.add(paramString);
      }
      ao(paramQQAppInterface);
      return;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    boolean bool = false;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    acxw localacxw = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      if ((this.cmX) && (!this.cna) && (!((TroopManager)localObject).abK())) {
        bool = true;
      }
      break;
    case 2: 
      if (bool)
      {
        localObject = localacxw.a(acbn.bkz, 5000);
        ((RecentUser)localObject).uin = acbn.bkz;
        ((RecentUser)localObject).setType(5000);
        if (((RecentUser)localObject).lastmsgtime < paramLong) {
          ((RecentUser)localObject).lastmsgtime = paramLong;
        }
        if (aqe())
        {
          ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
          label150:
          localacxw.e((RecentUser)localObject);
        }
      }
      break;
    }
    for (;;)
    {
      return true;
      bool = true;
      break;
      bool = this.cmX;
      break;
      bool = false;
      break;
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface != null)
      {
        ((RecentUser)localObject).lastmsgtime = paramQQAppInterface.lastmsgtime;
        ((RecentUser)localObject).lastmsgdrafttime = paramQQAppInterface.lastdrafttime;
      }
      ((RecentUser)localObject).showUpTime = 0L;
      break label150;
      if (paramInt != 3)
      {
        paramQQAppInterface = localacxw.b(acbn.bkz, 5000);
        if (paramQQAppInterface != null) {
          localacxw.f(paramQQAppInterface);
        }
      }
    }
  }
  
  private boolean aX(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("should_update_troop_assistant", true);
  }
  
  private void ao(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new TroopAssistantManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  private void ao(QQAppInterface paramQQAppInterface, String paramString)
  {
    acxw localacxw = paramQQAppInterface.a().a();
    paramString = localacxw.b(paramString, 1);
    if ((paramString != null) && (!paramString.shouldShowInRecentList(paramQQAppInterface))) {
      localacxw.f(paramString);
    }
  }
  
  private void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.object)
    {
      if ((paramQQAppInterface.a().A(paramString, 1) > 0) && (this.H.contains(paramString))) {
        this.H.remove(paramString);
      }
      ao(paramQQAppInterface);
      return;
    }
  }
  
  private boolean c(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.lF)
    {
      paramString = (TroopAssistantData)this.lF.remove(paramString);
    }
    synchronized (this.ee)
    {
      if (this.CN != null) {
        this.CN.remove(paramString);
      }
      if (paramString != null)
      {
        ThreadManager.post(new TroopAssistantManager.3(this, paramEntityManager, paramString), 8, null, false);
        return true;
        paramEntityManager = finally;
        throw paramEntityManager;
      }
    }
    return false;
  }
  
  /* Error */
  private void d(EntityManager arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 77
    //   3: iconst_0
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc_w 297
    //   11: aconst_null
    //   12: invokevirtual 303	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +202 -> 219
    //   20: aload_2
    //   21: invokeinterface 141 1 0
    //   26: ifle +193 -> 219
    //   29: aload_2
    //   30: new 305	aizq
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 308	aizq:<init>	(Laizp;)V
    //   38: invokestatic 314	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   41: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: ldc_w 321
    //   50: iconst_2
    //   51: new 323	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 326
    //   61: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokeinterface 141 1 0
    //   70: invokevirtual 333	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: getfield 49	aizp:ee	Ljava/lang/Object;
    //   83: astore_1
    //   84: aload_1
    //   85: monitorenter
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 132	aizp:CN	Ljava/util/List;
    //   91: aload_0
    //   92: getfield 132	aizp:CN	Ljava/util/List;
    //   95: ifnonnull +16 -> 111
    //   98: aload_0
    //   99: new 342	java/util/ArrayList
    //   102: dup
    //   103: bipush 15
    //   105: invokespecial 344	java/util/ArrayList:<init>	(I)V
    //   108: putfield 132	aizp:CN	Ljava/util/List;
    //   111: aload_1
    //   112: monitorexit
    //   113: aload_0
    //   114: getfield 58	aizp:lF	Ljava/util/Map;
    //   117: astore_1
    //   118: aload_1
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 58	aizp:lF	Ljava/util/Map;
    //   124: invokeinterface 347 1 0
    //   129: aload_0
    //   130: getfield 132	aizp:CN	Ljava/util/List;
    //   133: invokeinterface 351 1 0
    //   138: astore_2
    //   139: aload_2
    //   140: invokeinterface 356 1 0
    //   145: ifeq +101 -> 246
    //   148: aload_2
    //   149: invokeinterface 360 1 0
    //   154: checkcast 77	com/tencent/mobileqq/data/TroopAssistantData
    //   157: astore_3
    //   158: aload_0
    //   159: getfield 58	aizp:lF	Ljava/util/Map;
    //   162: aload_3
    //   163: getfield 82	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   166: aload_3
    //   167: invokeinterface 130 3 0
    //   172: pop
    //   173: goto -34 -> 139
    //   176: astore_2
    //   177: aload_1
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    //   181: astore_1
    //   182: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +33 -> 218
    //   188: ldc_w 321
    //   191: iconst_2
    //   192: new 323	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 362
    //   202: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 365	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: return
    //   219: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -143 -> 79
    //   225: ldc_w 321
    //   228: iconst_2
    //   229: ldc_w 369
    //   232: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: goto -156 -> 79
    //   238: astore_1
    //   239: aload_1
    //   240: athrow
    //   241: astore_2
    //   242: aload_1
    //   243: monitorexit
    //   244: aload_2
    //   245: athrow
    //   246: aload_1
    //   247: monitorexit
    //   248: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	aizp
    //   15	134	2	localObject1	Object
    //   176	4	2	localObject2	Object
    //   241	4	2	localObject3	Object
    //   157	10	3	localTroopAssistantData	TroopAssistantData
    // Exception table:
    //   from	to	target	type
    //   120	139	176	finally
    //   139	173	176	finally
    //   177	179	176	finally
    //   246	248	176	finally
    //   0	16	181	java/lang/Exception
    //   20	79	181	java/lang/Exception
    //   79	86	181	java/lang/Exception
    //   113	120	181	java/lang/Exception
    //   179	181	181	java/lang/Exception
    //   219	235	181	java/lang/Exception
    //   244	246	181	java/lang/Exception
    //   0	16	238	finally
    //   20	79	238	finally
    //   79	86	238	finally
    //   113	120	238	finally
    //   179	181	238	finally
    //   182	218	238	finally
    //   219	235	238	finally
    //   244	246	238	finally
    //   86	111	241	finally
    //   111	113	241	finally
    //   242	244	241	finally
  }
  
  public static void destroy()
  {
    b = null;
  }
  
  private void dk(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("should_update_troop_assistant", false).commit();
  }
  
  public void G(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.mAccount = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.cmX = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_in_msg", true);
      this.cmY = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_on_top", false);
      this.mLastReadTime = ((SharedPreferences)localObject2).getLong("troop_assis_last_read_time", 0L);
      this.baU = aW(paramQQAppInterface);
      this.cna = ((SharedPreferences)localObject2).getBoolean("troop_assistant_be_del", false);
      synchronized (this.ee)
      {
        this.CN = null;
        localObject3 = l(paramQQAppInterface);
      }
    }
    synchronized (this.object)
    {
      this.H = aqmk.a((SharedPreferences)localObject2, "troop_assis_new_unread_list", null);
      if (this.H == null)
      {
        this.H = new HashSet();
        if (aX(paramQQAppInterface))
        {
          dk(paramQQAppInterface);
          localObject2 = paramQQAppInterface.b();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localTroopAssistantData.troopUin, 1);
            if ((paramQQAppInterface.a().A(localTroopAssistantData.troopUin, 1) > 0) && (localMessage.time > this.mLastReadTime)) {
              a(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void I(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assistant_be_del", paramBoolean).commit();
    this.cna = paramBoolean;
  }
  
  public boolean J(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.cs(paramString) == 2;
  }
  
  public boolean K(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        bool1 = bool2;
        if (paramQQAppInterface != null) {
          bool1 = paramQQAppInterface.getBoolean("tag_troop_ignore_tip_v2_" + paramString, false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopassist_guide", 2, "checkTroopIgnoreTip ignore=" + bool1);
    }
    return bool1;
  }
  
  public boolean L(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      for (;;)
      {
        return false;
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        if ((paramQQAppInterface != null) && (!paramQQAppInterface.getBoolean("tag_troop_ignore_tip_v2_" + paramString, false)))
        {
          paramQQAppInterface = paramQQAppInterface.getString("tag_troop_aio_enter_times_" + paramString, "");
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramQQAppInterface = paramQQAppInterface.split(";");
            int i = paramQQAppInterface.length;
            if (i >= 2)
            {
              paramQQAppInterface = paramQQAppInterface[(i - 2)];
              try
              {
                long l1 = Long.parseLong(paramQQAppInterface);
                long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
                if (l2 - l1 < 7200L) {
                  return true;
                }
              }
              catch (NumberFormatException paramQQAppInterface) {}
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAssistantManager", 2, QLog.getStackTraceString(paramQQAppInterface));
    return false;
  }
  
  public void LJ(boolean paramBoolean)
  {
    this.cmZ = paramBoolean;
  }
  
  public int a(QQMessageFacade arg1, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.object)
      {
        if (this.H != null)
        {
          Iterator localIterator = this.H.iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!TextUtils.isEmpty(str)) && (!wvo.a(str, 1, paramQQAppInterface))) {
              i += 1;
            }
          }
          else
          {
            this.bfi = i;
            return i;
          }
        }
        else
        {
          this.bfi = 0;
          return 0;
        }
      }
    }
  }
  
  public TroopAssistantData a(QQAppInterface paramQQAppInterface)
  {
    dh(paramQQAppInterface);
    for (;;)
    {
      synchronized (this.ee)
      {
        if ((this.CN != null) && (this.CN.size() > 0))
        {
          Iterator localIterator = this.CN.iterator();
          if (localIterator.hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
            if (wvo.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
              continue;
            }
            paramQQAppInterface = localTroopAssistantData;
            return paramQQAppInterface;
          }
        }
      }
      paramQQAppInterface = null;
    }
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    return paramQQAppInterface.d(paramList);
  }
  
  public Map<String, Integer> a(QQAppInterface paramQQAppInterface, String... paramVarArgs)
  {
    return a(paramQQAppInterface, Arrays.asList(paramVarArgs));
  }
  
  public void a(QQAppInterface paramQQAppInterface, jnm.d paramd)
  {
    ThreadManager.post(new TroopAssistantManager.2(this, paramQQAppInterface, paramd), 8, null, true);
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData;
    if (paramLong == 0L)
    {
      localTroopAssistantData = a(paramQQAppInterface, paramString);
      if (localTroopAssistantData != null)
      {
        localTroopAssistantData.lastdrafttime = paramLong;
        if ((paramLong != 0L) || (localTroopAssistantData.lastmsgtime != 0L)) {
          break label94;
        }
        ao(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.cna) {
        I(paramQQAppInterface, false);
      }
      ao(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
      localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label94:
      a(paramEntityManager, localTroopAssistantData);
    }
  }
  
  public boolean aV(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_assistant", true);
  }
  
  public boolean aW(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("show_troop_assistant_list_notity", true);
  }
  
  public boolean aY(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      bool = true;
    }
    long l;
    do
    {
      return bool;
      l = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troop_batch_setting_time", 0L);
    } while ((new Date().getTime() / 1000L < l) && (l != 0L));
    return true;
  }
  
  public boolean aZ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localBaseApplication = paramQQAppInterface.getApp();
    } while (localBaseApplication == null);
    return localBaseApplication.getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("troop_message_setting_first", true);
  }
  
  public void al(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edit().putBoolean("tag_troop_ignore_tip_v2_" + paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("troopassist_guide", 2, "setTroopIgnoreTip key=tag_troop_ignore_tip_v2_" + paramString);
        }
      }
    }
  }
  
  public void am(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("tag_troop_ignore_tip_v2_" + paramString, false))) {
        break label52;
      }
    }
    label52:
    label217:
    label225:
    for (;;)
    {
      return;
      paramQQAppInterface = ((SharedPreferences)localObject).getString("tag_troop_aio_enter_times_" + paramString, "");
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramQQAppInterface + ";" + NetConnInfoCenter.getServerTimeMillis() / 1000L;
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("tag_troop_aio_enter_times_" + paramString, paramQQAppInterface);
        if (Build.VERSION.SDK_INT <= 8) {
          break label217;
        }
        ((SharedPreferences.Editor)localObject).apply();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        QLog.d("troopassist_guide", 2, "addTroopAssistTipTime time=" + paramQQAppInterface);
        return;
        paramQQAppInterface = String.valueOf(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        break;
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void an(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().remove("tag_troop_aio_enter_times_" + paramString).commit();
      }
    }
  }
  
  public boolean aqd()
  {
    return this.cmX;
  }
  
  public boolean aqe()
  {
    return this.cmY;
  }
  
  public boolean aqf()
  {
    return this.baU;
  }
  
  public boolean aqg()
  {
    return this.cmZ;
  }
  
  public void as(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    ??? = ((acxw)localObject1).q(false);
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).getType() == 1) && (J(paramQQAppInterface, ((RecentUser)localObject5).uin)) && (!((RecentUser)localObject5).shouldShowInRecentList(paramQQAppInterface))) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
    }
    dh(paramQQAppInterface);
    Object localObject6;
    synchronized (this.ee)
    {
      if ((this.CN != null) && (this.CN.size() > 0))
      {
        localObject5 = this.CN.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopAssistantData)((Iterator)localObject5).next();
          if (!J(paramQQAppInterface, ((TroopAssistantData)localObject6).troopUin)) {
            ((ArrayList)localObject2).add(localObject6);
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject3).next();
        localObject5 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject6 = paramQQAppInterface.b().a(((TroopAssistantData)localObject5).troopUin, 1);
          if (localObject6 == null) {}
        }
        for (((TroopAssistantData)localObject5).lastmsgtime = ((QQMessageFacade.Message)localObject6).time;; ((TroopAssistantData)localObject5).lastmsgtime = ((RecentUser)???).lastmsgtime)
        {
          a(localEntityManager, (TroopAssistantData)localObject5);
          ((acxw)localObject1).f((RecentUser)???);
          a(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopAssistantData)((Iterator)localObject2).next();
        ??? = ((acxw)localObject1).a(((TroopAssistantData)localObject3).troopUin, 1);
        ((RecentUser)???).uin = ((TroopAssistantData)localObject3).troopUin;
        ((RecentUser)???).setType(1);
        ((RecentUser)???).lastmsgtime = ((TroopAssistantData)localObject3).lastmsgtime;
        ((RecentUser)???).lastmsgdrafttime = ((TroopAssistantData)localObject3).lastdrafttime;
        if (c(localEntityManager, ((TroopAssistantData)localObject3).troopUin))
        {
          ((acxw)localObject1).e((RecentUser)???);
          c(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, 0, ((TroopAssistantData)localObject1).lastmsgtime);
    }
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {}
    for (localTroopAssistantData.lastmsgtime = paramMessageRecord.time;; localTroopAssistantData.lastmsgtime = paramLong)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(localTroopAssistantData.troopUin, 1);
      if (localMessage != null)
      {
        long l = localMessage.time;
        if (l > localTroopAssistantData.lastmsgtime) {
          localTroopAssistantData.lastmsgtime = l;
        }
      }
      a(paramEntityManager, localTroopAssistantData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.cna) {
        I(paramQQAppInterface, false);
      }
      ao(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
    }
  }
  
  public void bH(QQAppInterface paramQQAppInterface)
  {
    ao(paramQQAppInterface);
  }
  
  public void c(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      dh(paramQQAppInterface);
      acxw localacxw = paramQQAppInterface.a().a();
      Object localObject2 = localacxw.q(false);
      long l1 = System.currentTimeMillis() / 1000L;
      this.baU = aW(paramQQAppInterface);
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((((RecentUser)localObject3).getType() == 1) && (J(paramQQAppInterface, ((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        long l2 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        l1 = l2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopAssistantData)localObject3).lastdrafttime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.b().a(((TroopAssistantData)localObject3).troopUin, 1);
            if (localMessage == null) {}
          }
          for (((TroopAssistantData)localObject3).lastmsgtime = localMessage.time;; ((TroopAssistantData)localObject3).lastmsgtime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramEntityManager, (TroopAssistantData)localObject3);
            localacxw.f((RecentUser)localObject2);
            a(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
            break;
          }
        }
      }
      a(paramQQAppInterface, 0, l1);
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_assistant", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void dh(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.ee)
    {
      if (this.CN == null)
      {
        i = 1;
        if (i != 0)
        {
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
          d(paramQQAppInterface);
          paramQQAppInterface.close();
        }
        return;
      }
      int i = 0;
    }
  }
  
  public void di(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantManager", 2, "app == null; what happen.");
      }
      return;
    }
    if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
      G(paramQQAppInterface);
    }
    a(paramQQAppInterface, 0, 0L);
  }
  
  public void dj(QQAppInterface paramQQAppInterface)
  {
    int m = 0;
    int k = 0;
    int i = 0;
    Object localObject = this.object;
    int j = m;
    try
    {
      if (this.H != null)
      {
        j = m;
        Iterator localIterator = this.H.iterator();
        j = i;
        k = i;
        if (localIterator.hasNext())
        {
          j = i;
          String str = (String)localIterator.next();
          j = i;
          if (paramQQAppInterface.a().A(str, 1) > 0) {
            break label129;
          }
          j = i;
          localIterator.remove();
          i = 1;
        }
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      k = j;
      if (k != 0) {
        ao(paramQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  public void dl(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("show_troop_assistant_list_notity", false).commit();
    this.baU = false;
  }
  
  public void dm(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (paramQQAppInterface.getApp() == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_message_setting_first", false).commit();
  }
  
  public void dn(QQAppInterface arg1)
  {
    this.bh.clear();
    dh(???);
    for (;;)
    {
      synchronized (this.ee)
      {
        if (this.CN == null) {
          break label117;
        }
        i = this.CN.size();
        ArrayList localArrayList = new ArrayList(i);
        if (this.CN != null)
        {
          localArrayList.addAll(this.CN);
          break label112;
          if (i < localArrayList.size())
          {
            this.bh.add(((TroopAssistantData)localArrayList.get(i)).troopUin);
            i += 1;
            continue;
          }
          return;
        }
      }
      label112:
      int i = 0;
      continue;
      label117:
      i = 0;
    }
  }
  
  public void jdMethod_do(QQAppInterface paramQQAppInterface)
  {
    dh(paramQQAppInterface);
    for (;;)
    {
      int i;
      synchronized (this.ee)
      {
        if ((this.CN == null) || (this.CN.size() <= 0)) {
          return;
        }
        i = this.CN.size() - 1;
        if (i >= 0)
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.CN.get(i);
          if (wvo.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
            k(localTroopAssistantData.troopUin, paramQQAppInterface);
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void dp(QQAppInterface paramQQAppInterface)
  {
    try
    {
      G(paramQQAppInterface);
      EntityManager localEntityManager;
      if (aV(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        a().c(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      di(paramQQAppInterface);
      if (aizr.a().ba(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        aizr.a().d(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.recent", 2, "initTroopManager error");
    }
  }
  
  public boolean e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
      G(paramQQAppInterface);
    }
    this.cmX = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_in_msg", paramBoolean).commit();
    int i;
    if (paramBoolean)
    {
      i = 1;
      paramBoolean = a(paramQQAppInterface, i, 0L);
      if ((!this.cmX) || (!paramBoolean)) {
        break label100;
      }
    }
    label100:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      i = 2;
      break;
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
      G(paramQQAppInterface);
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_assis_last_read_time", paramLong).commit();
    this.mLastReadTime = paramLong;
    synchronized (this.object)
    {
      if (this.H != null) {
        this.H.clear();
      }
      ao(paramQQAppInterface);
      return;
    }
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
      G(paramQQAppInterface);
    }
    this.cmY = paramBoolean;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    a(paramQQAppInterface, 3, 0L);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    return this.cmY;
  }
  
  public void h(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    b(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localEntityManager, paramQQAppInterface);
    localEntityManager.close();
  }
  
  public int j(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.cs(paramString);
  }
  
  public void j(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    acxw localacxw = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localacxw.b(paramString, 1);
    QQMessageFacade.Message localMessage;
    if (localRecentUser != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (localRecentUser.lastmsgtime != 0L) {
        break label271;
      }
      localMessage = paramQQAppInterface.b().a(paramString.troopUin, 1);
      if (localMessage == null) {}
    }
    label271:
    for (paramString.lastmsgtime = localMessage.time;; paramString.lastmsgtime = localRecentUser.lastmsgtime)
    {
      paramString.lastdrafttime = localRecentUser.lastmsgdrafttime;
      a(localEntityManager, paramString);
      a(paramString.troopUin, paramQQAppInterface);
      aajt.a().Av(localRecentUser.uin + "-" + localRecentUser.getType());
      if ((!(localRecentUser.msg instanceof aalp)) && (!(localRecentUser.msg instanceof aamf)) && (!(localRecentUser.msg instanceof aals)) && (!(localRecentUser.msg instanceof aalx)) && (!(localRecentUser.msg instanceof aalo)) && (!(localRecentUser.msg instanceof awke)) && (!(localRecentUser.msg instanceof aamc)) && (!(localRecentUser.msg instanceof aalw)) && (!(localRecentUser.msg instanceof aalz))) {
        localacxw.f(localRecentUser);
      }
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      localEntityManager.close();
      return;
    }
  }
  
  public List<Long> k(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = ((TroopManager)paramQQAppInterface.getManager(52)).cE();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    TroopInfo localTroopInfo;
    if (i < localArrayList1.size())
    {
      if (localArrayList1.get(i) == null) {
        break label114;
      }
      localTroopInfo = (TroopInfo)localArrayList1.get(i);
      if (localTroopInfo != null) {}
    }
    else
    {
      return localArrayList2;
    }
    Map localMap = a(paramQQAppInterface, new String[] { localTroopInfo.troopuin });
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(localTroopInfo.troopuin);
    }
    if (localInteger == null) {}
    for (;;)
    {
      label114:
      i += 1;
      break;
      if (localInteger.intValue() == 2) {
        localArrayList2.add(Long.valueOf(localTroopInfo.troopuin));
      }
    }
  }
  
  public void k(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (c(localEntityManager, paramString)) {
      c(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public List<TroopAssistantData> l(QQAppInterface paramQQAppInterface)
  {
    dh(paramQQAppInterface);
    ArrayList localArrayList;
    for (;;)
    {
      synchronized (this.ee)
      {
        if (this.CN != null)
        {
          i = this.CN.size();
          localArrayList = new ArrayList(i);
          if (this.CN == null) {
            break;
          }
          Iterator localIterator = this.CN.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
          if (wvo.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface)) {
            continue;
          }
          localArrayList.add(localTroopAssistantData);
        }
      }
      int i = 0;
    }
    return localArrayList;
  }
  
  public void l(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject = localEntityManager;
      TroopAssistantData localTroopAssistantData = a(paramQQAppInterface, paramString);
      localObject = localEntityManager;
      acxw localacxw = paramQQAppInterface.a().a();
      if (localTroopAssistantData != null)
      {
        localObject = localEntityManager;
        RecentUser localRecentUser = localacxw.a(String.valueOf(localTroopAssistantData.troopUin), 1);
        localObject = localEntityManager;
        localRecentUser.uin = localTroopAssistantData.troopUin;
        localObject = localEntityManager;
        localRecentUser.setType(1);
        localObject = localEntityManager;
        localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
        localObject = localEntityManager;
        localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
        localObject = localEntityManager;
        if (c(localEntityManager, paramString))
        {
          localObject = localEntityManager;
          localacxw.e(localRecentUser);
          localObject = localEntityManager;
          c(paramString, paramQQAppInterface);
        }
      }
      localObject = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject = localEntityManager;
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        localObject.close();
      }
    }
  }
  
  public List<RecentUser> m(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList;
    synchronized (this.ee)
    {
      localArrayList = new ArrayList(0);
      dh(paramQQAppInterface);
      if ((this.CN != null) && (this.CN.size() > 0))
      {
        Iterator localIterator = this.CN.iterator();
        while (localIterator.hasNext())
        {
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)localIterator.next();
          if (wvo.a(localTroopAssistantData.troopUin, 1, paramQQAppInterface))
          {
            RecentUser localRecentUser = new RecentUser(localTroopAssistantData.troopUin, 1);
            localRecentUser.isHiddenChat = 1;
            localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
            localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
            localArrayList.add(localRecentUser);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void m(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = new Date().getTime() + 86400L;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_batch_setting_time", l).commit();
  }
  
  public boolean ni(String paramString)
  {
    return this.bh.contains(paramString);
  }
  
  public void y(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.b(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizp
 * JD-Core Version:    0.7.0.1
 */