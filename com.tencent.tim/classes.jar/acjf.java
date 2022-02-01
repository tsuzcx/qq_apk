import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QIMNewFriendManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class acjf
  implements Manager
{
  QQAppInterface app;
  private Object cB = new Object();
  private AtomicBoolean cF = new AtomicBoolean(false);
  private AtomicBoolean cG = new AtomicBoolean(false);
  private WeakReference<acjf.a> dQ;
  EntityManager mEntityManager;
  public Handler mUiHandler;
  private ArrayList<QIMNotifyAddFriend> tw = new ArrayList();
  
  public acjf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.mUiHandler = new Handler(Looper.getMainLooper());
    ThreadManager.postImmediately(new QIMNewFriendManager.1(this, paramQQAppInterface), null, true);
  }
  
  public void a(acjf.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "addListener");
    }
    this.dQ = new WeakReference(parama);
  }
  
  public void a(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "addNewNotifyFromQIM " + paramQIMNotifyAddFriend.toString());
    }
    if (!this.cF.get()) {
      cA();
    }
    synchronized (this.cB)
    {
      if (this.tw.contains(paramQIMNotifyAddFriend))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM already has data !");
        }
        return;
      }
      this.tw.add(paramQIMNotifyAddFriend);
      this.mEntityManager.persistOrReplace(paramQIMNotifyAddFriend);
      ((ysf)this.app.getManager(34)).cln();
      this.app.cLO();
      ??? = (FlashChatManager)this.app.getManager(217);
      if ((!((FlashChatManager)???).amZ()) || (!((FlashChatManager)???).ana())) {
        break label202;
      }
      if (this.dQ != null)
      {
        paramQIMNotifyAddFriend = (acjf.a)this.dQ.get();
        if (paramQIMNotifyAddFriend == null) {
          return;
        }
        paramQIMNotifyAddFriend.cIG();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM|mListener is null ");
      return;
      label202:
      if (QLog.isColorLevel()) {
        QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM | popUp enable close " + paramQIMNotifyAddFriend.uin);
      }
    }
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.mEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEntityManager.update(paramEntity);
      }
    }
    QLog.d("QIMNewFriendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public ArrayList<yug> b(boolean paramBoolean)
  {
    ??? = (FlashChatManager)this.app.getManager(217);
    ArrayList localArrayList = new ArrayList();
    if (!this.cF.get()) {
      cA();
    }
    if (((FlashChatManager)???).amZ())
    {
      synchronized (this.cB)
      {
        if (this.tw.size() <= 0) {
          break label156;
        }
        localIterator = this.tw.iterator();
        if (localIterator.hasNext()) {
          localArrayList.add(new yug((QIMNotifyAddFriend)localIterator.next()));
        }
      }
      this.cG.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg | list size = " + localArrayList1.size() + paramBoolean);
      }
    }
    label156:
    while (!QLog.isColorLevel())
    {
      Iterator localIterator;
      return localArrayList1;
    }
    QLog.e("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg qim notify has close");
    return localArrayList1;
  }
  
  public void b(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (paramQIMNotifyAddFriend == null) {
      return;
    }
    synchronized (this.cB)
    {
      Iterator localIterator = this.tw.iterator();
      while (localIterator.hasNext()) {
        if (((QIMNotifyAddFriend)localIterator.next()).uin == paramQIMNotifyAddFriend.uin) {
          localIterator.remove();
        }
      }
      this.app.a().createEntityManager().remove(paramQIMNotifyAddFriend);
      return;
    }
  }
  
  public ArrayList<QIMNotifyAddFriend> cA()
  {
    synchronized (this.cB)
    {
      ArrayList localArrayList = (ArrayList)this.mEntityManager.query(QIMNotifyAddFriend.class);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.tw.addAll(localArrayList);
      }
      this.cF.set(true);
      return this.tw;
    }
  }
  
  public ArrayList<QIMNotifyAddFriend> cB()
  {
    ??? = (FlashChatManager)this.app.getManager(217);
    ArrayList localArrayList = new ArrayList();
    if ((((FlashChatManager)???).amZ()) && (((FlashChatManager)???).ana()))
    {
      synchronized (this.cB)
      {
        localIterator = this.tw.iterator();
        while (localIterator.hasNext())
        {
          localQIMNotifyAddFriend = (QIMNotifyAddFriend)localIterator.next();
          if (!localQIMNotifyAddFriend.hasShowToast) {
            localArrayList.add(localQIMNotifyAddFriend);
          }
        }
      }
      Collections.sort(localList, new acjg(this));
    }
    while (!QLog.isColorLevel())
    {
      Iterator localIterator;
      QIMNotifyAddFriend localQIMNotifyAddFriend;
      return localList;
    }
    QLog.d("QIMNewFriendManager", 2, "getQIMAddFriendPopUpData enable close");
    return localList;
  }
  
  /* Error */
  public void cLk()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	acjf:cG	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 129	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +97 -> 104
    //   10: aload_0
    //   11: getfield 38	acjf:cB	Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 62	acjf:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 285	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   29: aload_0
    //   30: getfield 36	acjf:tw	Ljava/util/ArrayList;
    //   33: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 220 1 0
    //   43: ifeq +62 -> 105
    //   46: aload_3
    //   47: invokeinterface 225 1 0
    //   52: checkcast 121	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   55: astore 4
    //   57: aload 4
    //   59: getfield 288	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   62: ifne -25 -> 37
    //   65: aload 4
    //   67: iconst_1
    //   68: putfield 288	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   71: aload_0
    //   72: aload 4
    //   74: invokevirtual 290	acjf:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   77: pop
    //   78: goto -41 -> 37
    //   81: astore_3
    //   82: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +13 -> 98
    //   88: ldc 96
    //   90: iconst_2
    //   91: ldc_w 292
    //   94: aload_3
    //   95: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   102: aload_1
    //   103: monitorexit
    //   104: return
    //   105: aload_2
    //   106: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   109: aload_2
    //   110: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   113: goto -11 -> 102
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_3
    //   122: aload_2
    //   123: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   126: aload_3
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	acjf
    //   14	104	1	localObject1	Object
    //   24	86	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   116	7	2	localObject2	Object
    //   36	11	3	localIterator	Iterator
    //   81	14	3	localException	java.lang.Exception
    //   121	6	3	localObject3	Object
    //   55	18	4	localQIMNotifyAddFriend	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   25	37	81	java/lang/Exception
    //   37	78	81	java/lang/Exception
    //   105	109	81	java/lang/Exception
    //   17	25	116	finally
    //   98	102	116	finally
    //   102	104	116	finally
    //   109	113	116	finally
    //   117	119	116	finally
    //   122	128	116	finally
    //   25	37	121	finally
    //   37	78	121	finally
    //   82	98	121	finally
    //   105	109	121	finally
  }
  
  /* Error */
  public void dJ(ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	acjf:cB	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 62	acjf:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 285	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_1
    //   20: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 220 1 0
    //   30: ifeq +99 -> 129
    //   33: aload_1
    //   34: invokeinterface 225 1 0
    //   39: checkcast 121	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 36	acjf:tw	Ljava/util/ArrayList;
    //   48: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 220 1 0
    //   60: ifeq -36 -> 24
    //   63: aload 5
    //   65: invokeinterface 225 1 0
    //   70: checkcast 121	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   73: astore 6
    //   75: aload 4
    //   77: getfield 185	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   80: aload 6
    //   82: getfield 185	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   85: lcmp
    //   86: ifne -33 -> 53
    //   89: aload 6
    //   91: iconst_1
    //   92: putfield 260	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasShowToast	Z
    //   95: aload_0
    //   96: aload 6
    //   98: invokevirtual 290	acjf:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: goto -78 -> 24
    //   105: astore_1
    //   106: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +13 -> 122
    //   112: ldc 96
    //   114: iconst_2
    //   115: ldc_w 305
    //   118: aload_1
    //   119: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_3
    //   123: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   126: aload_2
    //   127: monitorexit
    //   128: return
    //   129: aload_3
    //   130: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   133: aload_3
    //   134: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   137: goto -11 -> 126
    //   140: astore_1
    //   141: aload_2
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_3
    //   147: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	acjf
    //   0	152	1	paramArrayList	ArrayList<QIMNotifyAddFriend>
    //   4	138	2	localObject	Object
    //   14	133	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   42	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   51	13	5	localIterator	Iterator
    //   73	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	24	105	java/lang/Exception
    //   24	53	105	java/lang/Exception
    //   53	102	105	java/lang/Exception
    //   129	133	105	java/lang/Exception
    //   7	15	140	finally
    //   122	126	140	finally
    //   126	128	140	finally
    //   133	137	140	finally
    //   141	143	140	finally
    //   146	152	140	finally
    //   15	24	145	finally
    //   24	53	145	finally
    //   53	102	145	finally
    //   106	122	145	finally
    //   129	133	145	finally
  }
  
  public String g(long paramLong1, long paramLong2)
  {
    String str = aqgv.A(this.app, String.valueOf(paramLong2));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|uinStr is null " + paramLong2);
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|nickName " + str);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ好友：").append(str);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public void jd(List<QIMNotifyAddFriend> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	acjf:cB	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 62	acjf:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 285	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_1
    //   20: invokeinterface 337 1 0
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 220 1 0
    //   32: ifeq +114 -> 146
    //   35: aload_1
    //   36: invokeinterface 225 1 0
    //   41: checkcast 121	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   44: astore 4
    //   46: aload_0
    //   47: getfield 36	acjf:tw	Ljava/util/ArrayList;
    //   50: invokevirtual 215	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   53: astore 5
    //   55: aload 5
    //   57: invokeinterface 220 1 0
    //   62: ifeq -36 -> 26
    //   65: aload 5
    //   67: invokeinterface 225 1 0
    //   72: checkcast 121	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   75: astore 6
    //   77: aload 4
    //   79: getfield 185	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   82: aload 6
    //   84: getfield 185	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   87: lcmp
    //   88: ifne -33 -> 55
    //   91: aload 6
    //   93: iconst_1
    //   94: putfield 288	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   97: aload_0
    //   98: aload 6
    //   100: invokevirtual 290	acjf:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: goto -78 -> 26
    //   107: astore_1
    //   108: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +13 -> 124
    //   114: ldc 96
    //   116: iconst_2
    //   117: ldc_w 292
    //   120: aload_1
    //   121: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 49	acjf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 34
    //   136: invokevirtual 155	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 157	ysf
    //   142: invokevirtual 160	ysf:cln	()V
    //   145: return
    //   146: aload_3
    //   147: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   150: aload_3
    //   151: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   154: goto -26 -> 128
    //   157: astore_1
    //   158: aload_2
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	acjf
    //   0	169	1	paramList	List<QIMNotifyAddFriend>
    //   4	155	2	localObject	Object
    //   14	150	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   44	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   53	13	5	localIterator	Iterator
    //   75	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	26	107	java/lang/Exception
    //   26	55	107	java/lang/Exception
    //   55	104	107	java/lang/Exception
    //   146	150	107	java/lang/Exception
    //   7	15	157	finally
    //   124	128	157	finally
    //   128	130	157	finally
    //   150	154	157	finally
    //   158	160	157	finally
    //   163	169	157	finally
    //   15	26	162	finally
    //   26	55	162	finally
    //   55	104	162	finally
    //   108	124	162	finally
    //   146	150	162	finally
  }
  
  public void onDestroy()
  {
    this.dQ = null;
  }
  
  public void removeListener()
  {
    if (this.dQ == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "removeListener");
    }
    this.dQ = null;
  }
  
  public static abstract interface a
  {
    public abstract void cIG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acjf
 * JD-Core Version:    0.7.0.1
 */