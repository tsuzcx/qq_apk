import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.HotChatCenterManager.1;
import com.tencent.mobileqq.app.HotChatCenterManager.5;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class acfs
  implements Manager
{
  public Set<String> H;
  private CopyOnWriteArrayList<HotChatItemData> Q;
  private boolean bHG;
  protected Map<String, HotChatItemData> jl;
  public SharedPreferences k;
  private WeakReference<QQAppInterface> mAppRef;
  protected long mLastReadTime;
  
  public acfs(QQAppInterface paramQQAppInterface)
  {
    QLog.i("HotChatCenterManager", 1, "create HotChatFolderManager.");
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.Q = new CopyOnWriteArrayList();
    this.jl = Collections.synchronizedMap(new HashMap());
    this.H = Collections.synchronizedSet(new HashSet());
    this.k = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    if (this.k != null)
    {
      this.mLastReadTime = this.k.getLong("hotchat_last_read_time", 0L);
      this.bHG = this.k.getBoolean("troop_assis_show_on_top", false);
    }
  }
  
  private void DU(String paramString)
  {
    if ((this.Q.size() == 0) || (TextUtils.isEmpty(paramString))) {}
    label89:
    label90:
    for (;;)
    {
      return;
      Object localObject = null;
      Iterator localIterator = this.Q.iterator();
      if (localIterator.hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
        if (!paramString.equals(localHotChatItemData.mTroopUin)) {
          break label89;
        }
        this.Q.remove(localHotChatItemData);
        localObject = localHotChatItemData;
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label90;
        }
        this.Q.add(0, localObject);
        return;
      }
    }
  }
  
  private void DV(String paramString)
  {
    Object localObject = getApp();
    if (localObject == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      do
      {
        do
        {
          return;
          localHotChatItemData = b(paramString);
        } while ((localHotChatItemData == null) || (localHotChatItemData.mGameId > 0));
        paramString = ((HotChatManager)((QQAppInterface)localObject).getManager(60)).a(paramString);
        if ((paramString != null) && (paramString.apolloGameId > 0))
        {
          localHotChatItemData.mGameId = paramString.apolloGameId;
          return;
        }
        localObject = ((abxk)((QQAppInterface)localObject).getManager(155)).a(localHotChatItemData.mHotChatCode);
      } while (localObject == null);
      localHotChatItemData.mGameId = ((ApolloGameData)localObject).gameId;
    } while (paramString == null);
    paramString.apolloGameId = localHotChatItemData.mGameId;
  }
  
  private HotChatItemData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    cJi();
    Object localObject2 = (HotChatItemData)this.jl.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HotChatItemData();
      ((HotChatItemData)localObject1).mTroopUin = paramString;
      localObject2 = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString);
      if (localObject2 != null)
      {
        ((HotChatItemData)localObject1).mHotChatCode = ((HotChatInfo)localObject2).name;
        if (((HotChatInfo)localObject2).apolloGameId <= 0)
        {
          ApolloGameData localApolloGameData = ((abxk)paramQQAppInterface.getManager(155)).a(((HotChatInfo)localObject2).name);
          if (localApolloGameData != null) {
            ((HotChatInfo)localObject2).apolloGameId = localApolloGameData.gameId;
          }
        }
        ((HotChatItemData)localObject1).mGameId = ((HotChatInfo)localObject2).apolloGameId;
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "code:", ((HotChatInfo)localObject2).name, ",gameId:", Integer.valueOf(((HotChatInfo)localObject2).apolloGameId) });
        }
        if (((HotChatInfo)localObject2).apolloGameId > 0) {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "creat_reliao_enter", 0, 0, new String[] { "" + ((HotChatInfo)localObject2).apolloGameId });
        }
      }
      paramQQAppInterface = paramQQAppInterface.b();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramString, 1);
        if (paramQQAppInterface != null) {
          ((HotChatItemData)localObject1).mDraftSec = paramQQAppInterface.getTime();
        }
      }
    }
    return localObject1;
  }
  
  private HotChatItemData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.Q.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if (paramString.equals(localHotChatItemData.mHotChatCode)) {
        return localHotChatItemData;
      }
    }
    return null;
  }
  
  private void a(HotChatItemData paramHotChatItemData)
  {
    if ((paramHotChatItemData == null) || (TextUtils.isEmpty(paramHotChatItemData.mTroopUin))) {
      return;
    }
    this.jl.put(paramHotChatItemData.mTroopUin, paramHotChatItemData);
    if (!paramHotChatItemData.mIsMakeTop)
    {
      Object localObject = this.Q.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject).next();
        if (paramHotChatItemData.mTroopUin.equals(localHotChatItemData.mTroopUin)) {
          this.Q.remove(localHotChatItemData);
        }
      }
      int j = this.Q.size();
      i = 0;
      if (i >= j) {
        break label246;
      }
      localObject = (HotChatItemData)this.Q.get(i);
      if ((((HotChatItemData)localObject).mIsMakeTop) || (Math.max(paramHotChatItemData.mLatestMsgSec, paramHotChatItemData.mDraftSec) <= Math.max(((HotChatItemData)localObject).mLatestMsgSec, ((HotChatItemData)localObject).mDraftSec))) {
        break label239;
      }
      this.Q.add(i, paramHotChatItemData);
    }
    label239:
    label246:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.Q.add(this.Q.size(), paramHotChatItemData);
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, "saveHotChatItemData data=" + paramHotChatItemData);
      }
      ThreadManager.getSubThreadHandler().post(new HotChatCenterManager.1(this, paramHotChatItemData));
      return;
      i += 1;
      break;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread) && (!this.H.contains(paramString))) {
      this.H.add(paramString);
    }
    aBK();
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while ((paramQQAppInterface.a().A(paramString, 1) <= 0) || (this.H == null) || (this.H.contains(paramString))) {
      return;
    }
    this.H.add(paramString);
    aBK();
  }
  
  private void aBK()
  {
    if (getApp() == null) {
      return;
    }
    ThreadManager.post(new HotChatCenterManager.5(this), 5, null, false);
  }
  
  private void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramQQAppInterface.a().A(paramString, 1) > 0) && (this.H != null) && (this.H.contains(paramString))) {
      this.H.remove(paramString);
    }
    aBK();
  }
  
  private void cJe()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      acxw localacxw;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      try
      {
        localacxw = localQQAppInterface.a().a();
        localObject2 = localacxw.q(false);
        localObject1 = new ArrayList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentUser)((Iterator)localObject2).next();
            if ((((RecentUser)localObject3).getType() == 1) && ((((RecentUser)localObject3).lFlag & 1L) != 0L)) {
              ((List)localObject1).add(localObject3);
            }
          }
          QLog.i("HotChatCenterManager", 1, "[initHotChatFolder], hotchat.size:" + ((List)localObject1).size());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        return;
      }
      if (((List)localObject1).size() > 0)
      {
        long l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(localThrowable, ((RecentUser)localObject2).uin);
          ((HotChatItemData)localObject3).mDraftSec = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = localThrowable.b().a(((HotChatItemData)localObject3).mTroopUin, 1);
            if (localMessage == null) {}
          }
          for (((HotChatItemData)localObject3).mLatestMsgSec = localMessage.time;; ((HotChatItemData)localObject3).mLatestMsgSec = ((RecentUser)localObject2).lastmsgtime)
          {
            a((HotChatItemData)localObject3);
            localacxw.f((RecentUser)localObject2);
            a(((HotChatItemData)localObject3).mTroopUin, localThrowable);
            break;
          }
        }
        bF(l);
      }
    } while (this.k == null);
    this.k.edit().putBoolean("init_hotchat_folder", false).commit();
  }
  
  private void cJf()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      Object localObject1;
      if (this.k != null)
      {
        localObject1 = aqmk.a(this.k, "hotchat_new_unread_list", null);
        if (localObject1 != null) {
          this.H = ((Set)localObject1);
        }
      }
      if (this.H.size() == 0)
      {
        this.H = Collections.synchronizedSet(new HashSet());
        localObject1 = localQQAppInterface.b();
        if (localObject1 != null)
        {
          Object localObject2 = dW();
          if ((localObject2 != null) && (((List)localObject2).size() != 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject2).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(localHotChatItemData.mTroopUin, 1);
              if ((localQQAppInterface.a().A(localHotChatItemData.mTroopUin, 1) > 0) && (localMessage.time > this.mLastReadTime)) {
                a(localMessage.frienduin, localQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  private void cJh()
  {
    if (this.Q.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject3 = this.Q.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject3).next();
        if (localHotChatItemData.mIsMakeTop) {
          ((List)localObject2).add(localHotChatItemData);
        } else {
          ((List)localObject1).add(localHotChatItemData);
        }
      }
      Collections.sort((List)localObject2, new acft(this));
      Collections.sort((List)localObject1, new acfu(this));
      this.Q.clear();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotChatItemData)((Iterator)localObject2).next();
        this.Q.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "[sort],", ((HotChatItemData)localObject3).mHotChatCode, ",isMakeTop:", Boolean.valueOf(((HotChatItemData)localObject3).mIsMakeTop), ",topTime:", Long.valueOf(((HotChatItemData)localObject3).mMakeTopTime) });
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotChatItemData)((Iterator)localObject1).next();
        this.Q.add(localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "[sort],", ((HotChatItemData)localObject2).mHotChatCode, ",isMakeTop:", Boolean.valueOf(((HotChatItemData)localObject2).mIsMakeTop), ",topTime:", Long.valueOf(((HotChatItemData)localObject2).mMakeTopTime) });
        }
      }
    }
  }
  
  /* Error */
  private void cJj()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: invokevirtual 157	acfs:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull -7 -> 10
    //   20: aload_3
    //   21: bipush 60
    //   23: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 171	com/tencent/mobileqq/app/HotChatManager
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   35: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   38: istore_1
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_3
    //   42: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   45: invokevirtual 493	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: iload_1
    //   52: iconst_1
    //   53: isub
    //   54: istore_1
    //   55: iload_1
    //   56: iflt +107 -> 163
    //   59: aload_0
    //   60: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: iload_1
    //   64: invokevirtual 278	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   67: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   70: astore_3
    //   71: aload_0
    //   72: aload_3
    //   73: getfield 140	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   76: invokespecial 495	acfs:DV	(Ljava/lang/String;)V
    //   79: aload 4
    //   81: aload_3
    //   82: getfield 140	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   85: invokevirtual 499	com/tencent/mobileqq/app/HotChatManager:kj	(Ljava/lang/String;)Z
    //   88: ifne +68 -> 156
    //   91: aload_3
    //   92: getfield 165	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   95: ifne +61 -> 156
    //   98: ldc 31
    //   100: iconst_1
    //   101: new 232	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   108: aload_3
    //   109: getfield 185	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   112: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 501
    //   118: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 39	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 62	acfs:jl	Ljava/util/Map;
    //   131: aload_3
    //   132: getfield 140	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   135: invokeinterface 503 2 0
    //   140: pop
    //   141: aload_0
    //   142: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   145: iload_1
    //   146: invokevirtual 505	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   149: pop
    //   150: aload_2
    //   151: aload_3
    //   152: invokevirtual 510	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   155: pop
    //   156: iload_1
    //   157: iconst_1
    //   158: isub
    //   159: istore_1
    //   160: goto -105 -> 55
    //   163: aload_2
    //   164: ifnull -154 -> 10
    //   167: aload_2
    //   168: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   171: return
    //   172: astore_3
    //   173: ldc 31
    //   175: iconst_1
    //   176: aload_3
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   184: aload_2
    //   185: ifnull -175 -> 10
    //   188: aload_2
    //   189: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   192: return
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   204: aload_3
    //   205: athrow
    //   206: astore_3
    //   207: goto -11 -> 196
    //   210: astore_3
    //   211: goto -15 -> 196
    //   214: astore_3
    //   215: goto -42 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	acfs
    //   38	122	1	i	int
    //   40	161	2	localObject1	Object
    //   15	137	3	localObject2	Object
    //   172	5	3	localThrowable1	Throwable
    //   193	12	3	localObject3	Object
    //   206	1	3	localObject4	Object
    //   210	1	3	localObject5	Object
    //   214	1	3	localThrowable2	Throwable
    //   29	51	4	localHotChatManager	HotChatManager
    // Exception table:
    //   from	to	target	type
    //   41	49	172	java/lang/Throwable
    //   41	49	193	finally
    //   59	156	206	finally
    //   173	184	210	finally
    //   59	156	214	java/lang/Throwable
  }
  
  private void dx(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    acxw localacxw;
    do
    {
      return;
      localacxw = localQQAppInterface.a().a();
      paramString = localacxw.b(paramString, paramInt);
    } while ((paramString == null) || (paramString.shouldShowInRecentList(localQQAppInterface)));
    localacxw.f(paramString);
  }
  
  public int Aw()
  {
    if (this.H != null) {
      return this.H.size();
    }
    return 0;
  }
  
  public void DS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    HotChatItemData localHotChatItemData;
    do
    {
      return;
      localHotChatItemData = b(paramString);
      if (localHotChatItemData != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HotChatCenterManager", 2, "findItemByTroopUin HotChatItemData null troopUin= " + paramString);
    return;
    localHotChatItemData.mIsMakeTop = true;
    localHotChatItemData.mMakeTopTime = NetConnInfoCenter.getServerTimeMillis();
    DU(paramString);
    a(localHotChatItemData);
  }
  
  public void DT(String paramString)
  {
    if ((this.Q.size() == 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.Q.iterator();
      HotChatItemData localHotChatItemData;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localHotChatItemData = (HotChatItemData)localIterator.next();
      } while ((!localHotChatItemData.mIsMakeTop) || (!paramString.equals(localHotChatItemData.mTroopUin)));
      for (paramString = localHotChatItemData; paramString != null; paramString = null)
      {
        paramString.mIsMakeTop = false;
        cJh();
        a(paramString);
        return;
      }
    }
  }
  
  public boolean O(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      return false;
      DV(paramString);
      localHotChatItemData = b(paramString);
    } while (localHotChatItemData == null);
    if (localHotChatItemData.mGameId > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[removeHotChatData], troopUin:", paramString, ",state:", Integer.valueOf(paramInt), ",isCmShowGame:", Boolean.valueOf(bool) });
      }
      if ((bool) && (HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL.targetState == paramInt))
      {
        ((aqrb)localQQAppInterface.getBusinessHandler(71)).a(localHotChatItemData.mGameId, "android.aio", false, 2, localHotChatItemData.mHotChatCode);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "delete_reliao_enter", 1, 0, new String[] { String.valueOf(localHotChatItemData.mGameId) });
      }
      if ((!bool) || ((HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY.targetState != paramInt) && (HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT.targetState != paramInt))) {
        break;
      }
      QLog.i("HotChatCenterManager", 1, "kicked out from hotchat as long time no say or hotchat is overcount.");
      if (localHotChatItemData != null) {}
      try
      {
        localHotChatItemData.mState = 1;
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "[removeHotChatData], code:", localHotChatItemData.mHotChatCode });
        }
        a(localHotChatItemData);
        return false;
      }
      catch (Throwable paramString)
      {
        QLog.e("HotChatCenterManager", 1, paramString, new Object[0]);
        return false;
      }
    }
    kg(paramString);
    return true;
  }
  
  public void R(MessageRecord paramMessageRecord)
  {
    Object localObject = getApp();
    if ((localObject == null) || (paramMessageRecord == null)) {}
    while ((!TextUtils.isEmpty(paramMessageRecord.frienduin)) && (afck.G((QQAppInterface)localObject, paramMessageRecord.frienduin))) {
      return;
    }
    for (;;)
    {
      long l1;
      HotChatItemData localHotChatItemData;
      try
      {
        String str = paramMessageRecord.frienduin;
        l1 = paramMessageRecord.time;
        localHotChatItemData = a((QQAppInterface)localObject, str);
        if ((paramMessageRecord != null) && (paramMessageRecord.time > l1))
        {
          localHotChatItemData.mLatestMsgSec = paramMessageRecord.time;
          localObject = ((QQAppInterface)localObject).b().a(localHotChatItemData.mTroopUin, 1);
          if (localObject != null)
          {
            long l2 = ((QQMessageFacade.Message)localObject).time;
            if (l2 > localHotChatItemData.mLatestMsgSec) {
              localHotChatItemData.mLatestMsgSec = l2;
            }
          }
          a(localHotChatItemData);
          a(paramMessageRecord, str);
          dx(str, 1);
          bF(l1);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("HotChatCenterManager", 1, paramMessageRecord, new Object[0]);
        return;
      }
      localHotChatItemData.mLatestMsgSec = l1;
    }
  }
  
  public HotChatItemData a()
  {
    if (getApp() == null) {}
    do
    {
      return null;
      cJi();
    } while (this.Q.size() <= 0);
    return (HotChatItemData)this.Q.get(0);
  }
  
  public boolean aM(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return false;
    }
    this.bHG = paramBoolean;
    if (this.k != null) {
      this.k.edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    }
    bF(0L);
    MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
    if (paramBoolean) {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "top_reliao_folder", 0, 0, new String[0]);
    }
    return this.bHG;
  }
  
  public boolean aam()
  {
    if (getApp() == null) {}
    while (this.k == null) {
      return false;
    }
    return this.k.getBoolean("init_hotchat_folder", true);
  }
  
  public boolean aan()
  {
    return this.bHG;
  }
  
  public HotChatItemData b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.Q.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if (paramString.equals(localHotChatItemData.mTroopUin)) {
        return localHotChatItemData;
      }
    }
    return null;
  }
  
  public boolean bF(long paramLong)
  {
    Object localObject1 = getApp();
    if (localObject1 == null) {}
    do
    {
      return false;
      if (this.Q.size() == 0)
      {
        QLog.w("HotChatCenterManager", 1, "no item in folder, don't add to ru.");
        return false;
      }
      localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(52);
      localObject1 = ((QQAppInterface)localObject1).a().a();
    } while (localObject2 == null);
    Object localObject3;
    int i;
    if (!((acxw)localObject1).R(acbn.blI, 5001))
    {
      localObject2 = (HotChatItemData)this.Q.get(0);
      if (localObject2 != null)
      {
        localObject3 = getApp();
        if (((HotChatItemData)localObject2).mGameId <= 0) {
          break label200;
        }
        i = 0;
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "reliao_folder_show", i, 0, new String[0]);
      }
    }
    Object localObject2 = ((acxw)localObject1).a(acbn.blI, 5001);
    ((RecentUser)localObject2).uin = acbn.blI;
    ((RecentUser)localObject2).setType(5001);
    if (((RecentUser)localObject2).lastmsgtime < paramLong) {
      ((RecentUser)localObject2).lastmsgtime = paramLong;
    }
    if (aan()) {}
    for (((RecentUser)localObject2).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject2).showUpTime = 0L)
    {
      ((acxw)localObject1).e((RecentUser)localObject2);
      return true;
      label200:
      i = 1;
      break;
      localObject3 = a();
      if (localObject3 != null)
      {
        ((RecentUser)localObject2).lastmsgtime = ((HotChatItemData)localObject3).mLatestMsgSec;
        ((RecentUser)localObject2).lastmsgdrafttime = ((HotChatItemData)localObject3).mDraftSec;
      }
    }
  }
  
  public void cJg()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.H == null) {
          break label111;
        }
        localIterator = this.H.iterator();
        i = 0;
      }
      catch (Exception localException1)
      {
        try
        {
          Iterator localIterator;
          if (!localIterator.hasNext()) {
            break label95;
          }
          String str = (String)localIterator.next();
          if (localQQAppInterface.a().A(str, 1) > 0) {
            break label108;
          }
          localIterator.remove();
          i = 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      int j = i;
      QLog.e("HotChatCenterManager", 1, localException1, new Object[0]);
      label95:
      label108:
      label111:
      for (j = i; j != 0; j = 0)
      {
        aBK();
        return;
      }
    }
  }
  
  /* Error */
  public void cJi()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   9: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   12: ifle +4 -> 16
    //   15: return
    //   16: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +31 -> 50
    //   22: ldc 31
    //   24: iconst_2
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 662
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: invokestatic 668	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   40: invokevirtual 671	java/lang/Thread:getId	()J
    //   43: invokestatic 483	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: aastore
    //   47: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: invokevirtual 157	acfs:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull -41 -> 15
    //   59: aload_2
    //   60: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   63: invokevirtual 493	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_2
    //   67: aload_2
    //   68: ldc 136
    //   70: iconst_0
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 673
    //   78: aconst_null
    //   79: invokevirtual 677	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +276 -> 360
    //   87: aload_1
    //   88: invokeinterface 370 1 0
    //   93: ifle +267 -> 360
    //   96: aload_1
    //   97: checkcast 366	java/util/ArrayList
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 678	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 130 1 0
    //   112: ifeq +50 -> 162
    //   115: aload_3
    //   116: invokeinterface 134 1 0
    //   121: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   124: astore 4
    //   126: aload_0
    //   127: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   130: aload 4
    //   132: invokevirtual 464	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -30 -> 106
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: ldc 31
    //   144: iconst_1
    //   145: aload_3
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: ifnull -139 -> 15
    //   157: aload_2
    //   158: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   161: return
    //   162: aload_0
    //   163: invokespecial 536	acfs:cJh	()V
    //   166: aload_0
    //   167: getfield 62	acfs:jl	Ljava/util/Map;
    //   170: invokeinterface 679 1 0
    //   175: aload_1
    //   176: invokevirtual 678	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   179: astore_1
    //   180: aload_1
    //   181: invokeinterface 130 1 0
    //   186: ifeq +46 -> 232
    //   189: aload_1
    //   190: invokeinterface 134 1 0
    //   195: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 62	acfs:jl	Ljava/util/Map;
    //   203: aload_3
    //   204: getfield 140	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   207: aload_3
    //   208: invokeinterface 272 3 0
    //   213: pop
    //   214: goto -34 -> 180
    //   217: astore_1
    //   218: aload_2
    //   219: astore_3
    //   220: aload_1
    //   221: astore_2
    //   222: aload_3
    //   223: ifnull +7 -> 230
    //   226: aload_3
    //   227: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   230: aload_2
    //   231: athrow
    //   232: aload_0
    //   233: invokespecial 681	acfs:cJj	()V
    //   236: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +121 -> 360
    //   242: ldc 31
    //   244: iconst_2
    //   245: new 232	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 683
    //   255: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   262: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   265: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   278: invokevirtual 124	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   281: astore_1
    //   282: aload_1
    //   283: invokeinterface 130 1 0
    //   288: ifeq +72 -> 360
    //   291: aload_1
    //   292: invokeinterface 134 1 0
    //   297: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   300: astore_3
    //   301: ldc 31
    //   303: iconst_2
    //   304: bipush 6
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: ldc_w 685
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_3
    //   318: getfield 165	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   321: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: ldc_w 542
    //   330: aastore
    //   331: dup
    //   332: iconst_3
    //   333: aload_3
    //   334: getfield 580	com/tencent/mobileqq/data/HotChatItemData:mState	I
    //   337: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_4
    //   343: ldc_w 687
    //   346: aastore
    //   347: dup
    //   348: iconst_5
    //   349: aload_3
    //   350: getfield 185	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   357: goto -75 -> 282
    //   360: aload_2
    //   361: ifnull -346 -> 15
    //   364: aload_2
    //   365: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   368: return
    //   369: astore_2
    //   370: aload_1
    //   371: astore_3
    //   372: goto -150 -> 222
    //   375: astore_3
    //   376: aload 4
    //   378: astore_2
    //   379: goto -239 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	acfs
    //   1	189	1	localObject1	Object
    //   217	4	1	localObject2	Object
    //   281	90	1	localIterator1	Iterator
    //   54	311	2	localObject3	Object
    //   369	1	2	localObject4	Object
    //   378	1	2	localHotChatItemData1	HotChatItemData
    //   105	11	3	localIterator2	Iterator
    //   139	7	3	localThrowable1	Throwable
    //   198	174	3	localObject5	Object
    //   375	1	3	localThrowable2	Throwable
    //   3	374	4	localHotChatItemData2	HotChatItemData
    // Exception table:
    //   from	to	target	type
    //   67	83	139	java/lang/Throwable
    //   87	106	139	java/lang/Throwable
    //   106	136	139	java/lang/Throwable
    //   162	180	139	java/lang/Throwable
    //   180	214	139	java/lang/Throwable
    //   232	282	139	java/lang/Throwable
    //   282	357	139	java/lang/Throwable
    //   67	83	217	finally
    //   87	106	217	finally
    //   106	136	217	finally
    //   162	180	217	finally
    //   180	214	217	finally
    //   232	282	217	finally
    //   282	357	217	finally
    //   59	67	369	finally
    //   142	153	369	finally
    //   59	67	375	java/lang/Throwable
  }
  
  public List<HotChatItemData> dW()
  {
    Object localObject;
    if (getApp() == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = new ArrayList();
      cJi();
      localObject = localArrayList;
    } while (this.Q.size() <= 0);
    localArrayList.addAll(this.Q);
    return localArrayList;
  }
  
  public void dy(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[read promotion], troopUin:", paramString });
      }
      paramString = b(paramString);
    } while (paramString == null);
    if (paramInt == 1) {
      paramString.mIsRead4Folder = true;
    }
    for (;;)
    {
      a(paramString);
      return;
      if (paramInt == 2) {
        paramString.mIsRead4List = true;
      }
    }
  }
  
  public void eL(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        HotChatItemData localHotChatItemData = a(paramString1);
        if (localHotChatItemData == null)
        {
          QLog.w("HotChatCenterManager", 1, "[setPromotionInfo], fail to find hotchat, code:" + paramString1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "[setPromotionInfo], code:", paramString1, ",content:", paramString2 });
        }
        localHotChatItemData.mIsRead4List = false;
        localHotChatItemData.mIsRead4Folder = false;
        localHotChatItemData.mADsContent = paramString2;
        DS(localHotChatItemData.mTroopUin);
        a(localHotChatItemData);
        paramString1 = getApp();
      } while (paramString1 == null);
      paramString1 = paramString1.getHandler(Conversation.class);
    } while (paramString1 == null);
    paramString1.sendEmptyMessage(1009);
  }
  
  public void eh(long paramLong)
  {
    if (getApp() == null) {
      return;
    }
    if (this.k != null) {
      this.k.edit().putLong("hotchat_last_read_time", paramLong).commit();
    }
    this.mLastReadTime = paramLong;
    if (this.H != null) {
      this.H.clear();
    }
    aBK();
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef != null) {
      return (QQAppInterface)this.mAppRef.get();
    }
    return null;
  }
  
  public void initManager()
  {
    QLog.i("HotChatCenterManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
    if (aam()) {
      cJe();
    }
    cJf();
    dW();
    if (this.Q.size() > 0) {
      bF(0L);
    }
  }
  
  public boolean kf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    DV(paramString);
    Iterator localIterator = this.Q.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if ((localHotChatItemData != null) && (paramString.equals(localHotChatItemData.mTroopUin)) && (localHotChatItemData.mGameId > 0)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public boolean kg(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: aload_0
    //   6: invokevirtual 157	acfs:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +9 -> 29
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: ireturn
    //   29: aload 6
    //   31: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   34: invokevirtual 493	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 62	acfs:jl	Ljava/util/Map;
    //   43: aload_1
    //   44: invokeinterface 503 2 0
    //   49: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   52: astore 7
    //   54: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +259 -> 316
    //   60: ldc 31
    //   62: iconst_2
    //   63: iconst_4
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: ldc_w 540
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_1
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: ldc_w 741
    //   82: aastore
    //   83: dup
    //   84: iconst_3
    //   85: aload 7
    //   87: getfield 185	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: goto +222 -> 316
    //   97: iload_2
    //   98: aload_0
    //   99: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   102: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   105: if_icmpge +36 -> 141
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   113: iload_2
    //   114: invokevirtual 278	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   117: checkcast 136	com/tencent/mobileqq/data/HotChatItemData
    //   120: getfield 140	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   123: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifeq +195 -> 321
    //   129: aload_0
    //   130: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   133: iload_2
    //   134: invokevirtual 505	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   137: pop
    //   138: goto +183 -> 321
    //   141: aload 7
    //   143: ifnull +167 -> 310
    //   146: new 743	com/tencent/mobileqq/app/HotChatCenterManager$2
    //   149: dup
    //   150: aload_0
    //   151: aload 5
    //   153: aload 7
    //   155: invokespecial 746	com/tencent/mobileqq/app/HotChatCenterManager$2:<init>	(Lacfs;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/HotChatItemData;)V
    //   158: bipush 8
    //   160: aconst_null
    //   161: iconst_0
    //   162: invokestatic 345	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload 6
    //   169: invokespecial 748	acfs:c	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: iload 4
    //   174: istore_3
    //   175: aload_0
    //   176: getfield 51	acfs:Q	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   179: invokevirtual 114	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   182: ifne +39 -> 221
    //   185: iload 4
    //   187: istore_3
    //   188: aload_0
    //   189: getstatic 628	acbn:blI	Ljava/lang/String;
    //   192: sipush 5001
    //   195: invokespecial 599	acfs:dx	(Ljava/lang/String;I)V
    //   198: iload 4
    //   200: istore_3
    //   201: aload_0
    //   202: invokevirtual 157	acfs:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   205: ldc 226
    //   207: ldc 228
    //   209: ldc_w 750
    //   212: iconst_1
    //   213: iconst_0
    //   214: iconst_0
    //   215: anewarray 142	java/lang/String
    //   218: invokestatic 250	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   221: aload 5
    //   223: ifnull +84 -> 307
    //   226: aload 5
    //   228: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   231: iload 4
    //   233: ireturn
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_1
    //   237: iconst_0
    //   238: istore_3
    //   239: ldc 31
    //   241: iconst_1
    //   242: ldc 235
    //   244: invokestatic 752	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_1
    //   251: ifnull -225 -> 26
    //   254: aload_1
    //   255: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   258: iload_3
    //   259: ireturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 513	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: goto -13 -> 264
    //   280: astore 6
    //   282: aload_1
    //   283: astore 5
    //   285: aload 6
    //   287: astore_1
    //   288: goto -24 -> 264
    //   291: astore_1
    //   292: aload 5
    //   294: astore_1
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -58 -> 239
    //   300: astore_1
    //   301: aload 5
    //   303: astore_1
    //   304: goto -65 -> 239
    //   307: iload 4
    //   309: ireturn
    //   310: iconst_0
    //   311: istore 4
    //   313: goto -141 -> 172
    //   316: iconst_0
    //   317: istore_2
    //   318: goto -221 -> 97
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: goto -228 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	acfs
    //   0	328	1	paramString	String
    //   97	228	2	i	int
    //   1	296	3	bool1	boolean
    //   3	309	4	bool2	boolean
    //   37	265	5	localObject1	Object
    //   9	159	6	localQQAppInterface	QQAppInterface
    //   280	6	6	localObject2	Object
    //   52	102	7	localHotChatItemData	HotChatItemData
    // Exception table:
    //   from	to	target	type
    //   29	39	234	java/lang/Throwable
    //   29	39	260	finally
    //   39	94	276	finally
    //   97	138	276	finally
    //   146	165	276	finally
    //   165	172	276	finally
    //   175	185	276	finally
    //   188	198	276	finally
    //   201	221	276	finally
    //   239	247	280	finally
    //   39	94	291	java/lang/Throwable
    //   97	138	291	java/lang/Throwable
    //   146	165	291	java/lang/Throwable
    //   165	172	300	java/lang/Throwable
    //   175	185	300	java/lang/Throwable
    //   188	198	300	java/lang/Throwable
    //   201	221	300	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    QLog.i("HotChatCenterManager", 1, "destroy HotChatFolderManager.");
    this.Q.clear();
    this.jl.clear();
    if (this.H != null) {
      this.H.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfs
 * JD-Core Version:    0.7.0.1
 */