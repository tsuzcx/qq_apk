import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamSettingManager.1;
import com.tencent.mobileqq.app.RoamSettingManager.2;
import com.tencent.mobileqq.app.RoamSettingManager.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class acld
  implements Manager
{
  RoamSetting a;
  public boolean bJj = false;
  public QQHashMap<String, RoamSetting> c;
  public QQHashMap<String, RoamSetting> d;
  public EntityManager em;
  public Lock lock;
  
  public acld(QQAppInterface paramQQAppInterface)
  {
    this.em = paramQQAppInterface.a().createEntityManager();
    this.c = new QQHashMap(1003, 0, 60);
    this.d = new QQHashMap(1004, 0, 60);
    this.lock = new ReentrantLock();
    init();
  }
  
  private boolean kq(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i == -2) || (i == -1) || (i == 1) || (i == 2) || (i == 3) || (i == 4)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("RoamSettingManager", 1, paramString + "");
    }
    return false;
  }
  
  public void EL(String paramString)
  {
    RoamSetting localRoamSetting = a(paramString);
    if ((localRoamSetting == null) || (localRoamSetting.path == null) || (localRoamSetting.value == null)) {
      return;
    }
    this.lock.lock();
    try
    {
      if (aqlz.fk(paramString) == 1) {
        this.d.remove(localRoamSetting.path);
      }
      for (;;)
      {
        this.lock.unlock();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
          break;
        }
        ThreadManager.post(new RoamSettingManager.3(this, localRoamSetting), 5, null, false);
        return;
        this.c.remove(localRoamSetting.path);
      }
      d(localRoamSetting);
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void JJ(int paramInt)
  {
    Object localObject;
    if (this.a != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.a.value)) {
        return;
      }
      this.a.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.a);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.a = ((RoamSetting)localObject);
    }
  }
  
  public int U(String paramString, int paramInt)
  {
    RoamSetting localRoamSetting2 = a(paramString);
    RoamSetting localRoamSetting1 = localRoamSetting2;
    if (localRoamSetting2 == null)
    {
      localRoamSetting1 = localRoamSetting2;
      if (!TextUtils.isEmpty(paramString))
      {
        localRoamSetting1 = new RoamSetting(paramString, Integer.toString(paramInt));
        a(localRoamSetting1);
      }
    }
    return RoamSetting.getIntValue(localRoamSetting1, paramInt);
  }
  
  /* Error */
  public RoamSetting a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 52	acld:lock	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 105 1 0
    //   15: aload_1
    //   16: invokestatic 110	aqlz:fk	(Ljava/lang/String;)I
    //   19: istore_2
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmpne +106 -> 128
    //   25: aload_0
    //   26: getfield 47	acld:d	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   29: aload_1
    //   30: invokevirtual 185	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 94	com/tencent/mobileqq/data/RoamSetting
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: ifnonnull +75 -> 116
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 25	acld:bJj	Z
    //   51: ifne +65 -> 116
    //   54: aload_0
    //   55: getfield 38	acld:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: ldc 94
    //   60: aload_1
    //   61: invokevirtual 191	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   64: checkcast 94	com/tencent/mobileqq/data/RoamSetting
    //   67: astore_1
    //   68: aload_1
    //   69: astore 4
    //   71: aload_1
    //   72: ifnull +44 -> 116
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: getfield 98	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   82: ifnull +34 -> 116
    //   85: aload_1
    //   86: astore 4
    //   88: aload_1
    //   89: getfield 101	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   92: ifnull +24 -> 116
    //   95: iload_2
    //   96: iconst_1
    //   97: if_icmpne +46 -> 143
    //   100: aload_0
    //   101: getfield 47	acld:d	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   104: aload_1
    //   105: getfield 98	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   108: aload_1
    //   109: invokevirtual 195	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_1
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 52	acld:lock	Ljava/util/concurrent/locks/Lock;
    //   120: invokeinterface 117 1 0
    //   125: aload 4
    //   127: areturn
    //   128: aload_0
    //   129: getfield 45	acld:c	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   132: aload_1
    //   133: invokevirtual 185	com/tencent/commonsdk/cache/QQHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 94	com/tencent/mobileqq/data/RoamSetting
    //   139: astore_3
    //   140: goto -103 -> 37
    //   143: aload_0
    //   144: getfield 45	acld:c	Lcom/tencent/commonsdk/cache/QQHashMap;
    //   147: aload_1
    //   148: getfield 98	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   151: aload_1
    //   152: invokevirtual 195	com/tencent/commonsdk/cache/QQHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_1
    //   157: astore 4
    //   159: goto -43 -> 116
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 52	acld:lock	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 117 1 0
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	acld
    //   0	174	1	paramString	String
    //   19	79	2	i	int
    //   36	104	3	localRoamSetting	RoamSetting
    //   38	120	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	162	finally
    //   25	37	162	finally
    //   47	68	162	finally
    //   78	85	162	finally
    //   88	95	162	finally
    //   100	113	162	finally
    //   128	140	162	finally
    //   143	156	162	finally
  }
  
  public RoamSetting a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    RoamSetting localRoamSetting = a(paramString1);
    if (localRoamSetting == null)
    {
      localRoamSetting = new RoamSetting(paramString1, paramString2);
      this.lock.lock();
    }
    for (;;)
    {
      try
      {
        if (aqlz.fk(paramString1) == 1)
        {
          if (kq(paramString2))
          {
            this.d.put(localRoamSetting.path, localRoamSetting);
            return localRoamSetting;
            if (paramString2.equals(localRoamSetting.value)) {
              return null;
            }
            localRoamSetting.value = paramString2;
            break;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramString1 + ", value:" + paramString2);
          continue;
        }
        this.c.put(localRoamSetting.path, localRoamSetting);
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public void a(RoamSetting paramRoamSetting)
  {
    if ((paramRoamSetting == null) || (paramRoamSetting.path == null) || (paramRoamSetting.value == null)) {
      return;
    }
    int j = aqlz.fk(paramRoamSetting.path);
    this.lock.lock();
    if (j == 1) {}
    for (;;)
    {
      try
      {
        if (kq(paramRoamSetting.value))
        {
          this.d.put(paramRoamSetting.path, paramRoamSetting);
          i = 1;
          this.lock.unlock();
          if ((j == 1) && (i == 0)) {
            break;
          }
          if (Looper.myLooper() == Looper.getMainLooper()) {
            break label182;
          }
          a(paramRoamSetting);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label199;
        }
        QLog.e("RoamSettingManager", 2, "isTroopRoamSettingLegal false. path:" + paramRoamSetting.path + ", value:" + paramRoamSetting.value);
        i = 0;
        continue;
        this.c.put(paramRoamSetting.path, paramRoamSetting);
        i = 1;
        continue;
        ThreadManagerV2.excute(new RoamSettingManager.2(this, paramRoamSetting), 32, null, false);
      }
      finally
      {
        this.lock.unlock();
      }
      label182:
      return;
      label199:
      int i = 0;
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.em.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.em.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.em.update(paramEntity);
  }
  
  public boolean d(Entity paramEntity)
  {
    if (this.em.isOpen()) {
      return this.em.remove(paramEntity);
    }
    return false;
  }
  
  public int getRevision()
  {
    if (this.a == null) {
      this.a = ((RoamSetting)this.em.find(RoamSetting.class, "setting_revision"));
    }
    if (this.a == null) {
      return 0;
    }
    if (this.a.value == null)
    {
      this.a = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.a.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.a.value);
        }
        int i = 0;
      }
    }
  }
  
  public void init()
  {
    ThreadManager.post(new RoamSettingManager.1(this), 8, null, false);
  }
  
  public void jg(List<RoamSetting> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      EntityTransaction localEntityTransaction = this.em.getTransaction();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.begin();
      if (paramList != null)
      {
        int i = 0;
        for (;;)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (i >= paramList.size()) {
            break;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a((Entity)paramList.get(i));
          i += 1;
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.commit();
      return;
    }
    catch (Exception paramList)
    {
      localObject2 = localObject1;
      paramList.printStackTrace();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.w("RoamSettingManager", 2, "insert write exception: " + paramList.getMessage());
      }
      return;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.end();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if ((this.em != null) && (this.em.isOpen())) {
      this.em.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acld
 * JD-Core Version:    0.7.0.1
 */