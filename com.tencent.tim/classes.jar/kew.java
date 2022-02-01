import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper.1;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityManagerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.manager.Manager;

public class kew
  implements Manager
{
  private PublicAccountEntityManagerFactory a;
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  
  public kew(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.a = a(this.mApp);
    this.mEntityManager = this.a.createEntityManager();
  }
  
  private PublicAccountEntityManagerFactory a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getAccount();
    if (paramQQAppInterface == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    if (this.a != null) {
      return this.a;
    }
    try
    {
      if (this.a == null)
      {
        paramQQAppInterface = new PublicAccountEntityManagerFactory(paramQQAppInterface);
        ThreadManager.post(new PublicAccountEntityHelper.1(this, paramQQAppInterface), 8, null, false);
        this.a = paramQQAppInterface;
      }
      return this.a;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: invokevirtual 65	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   21: sipush 1000
    //   24: if_icmpne +31 -> 55
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 69	kew:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   32: aload_0
    //   33: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: aload_1
    //   37: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   40: aload_1
    //   41: invokevirtual 65	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   44: sipush 1001
    //   47: if_icmpne -34 -> 13
    //   50: iconst_1
    //   51: istore_2
    //   52: goto -39 -> 13
    //   55: aload_1
    //   56: invokevirtual 65	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1001
    //   62: if_icmpeq +13 -> 75
    //   65: aload_1
    //   66: invokevirtual 65	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   69: sipush 1002
    //   72: if_icmpne -59 -> 13
    //   75: aload_0
    //   76: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   79: aload_1
    //   80: invokevirtual 77	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   83: istore_2
    //   84: goto -71 -> 13
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	kew
    //   0	92	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   1	83	2	bool	boolean
    //   8	2	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   4	9	87	finally
    //   17	40	87	finally
    //   40	50	87	finally
    //   55	65	87	finally
    //   65	75	87	finally
    //   75	84	87	finally
  }
  
  /* Error */
  public void b(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_1
    //   19: instanceof 79
    //   22: ifeq +60 -> 82
    //   25: aload_3
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: ldc 79
    //   33: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   36: invokevirtual 88	com/tencent/mobileqq/persistence/EntityManager:tabbleIsExist	(Ljava/lang/String;)Z
    //   39: ifeq +43 -> 82
    //   42: aload_1
    //   43: checkcast 79	com/tencent/biz/pubaccount/persistence/entity/PAAdPreloadTask
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: getfield 92	com/tencent/biz/pubaccount/persistence/entity/PAAdPreloadTask:mVideoVid	Ljava/lang/String;
    //   53: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +26 -> 82
    //   59: aload_0
    //   60: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   63: ldc 79
    //   65: ldc 100
    //   67: iconst_1
    //   68: anewarray 102	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: getfield 92	com/tencent/biz/pubaccount/persistence/entity/PAAdPreloadTask:mVideoVid	Ljava/lang/String;
    //   77: aastore
    //   78: invokevirtual 106	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull -72 -> 11
    //   86: aload_0
    //   87: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: aload_2
    //   91: invokevirtual 109	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   94: pop
    //   95: goto -84 -> 11
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	kew
    //   0	103	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    //   6	85	2	localObject1	Object
    //   15	33	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	98	finally
    //   18	25	98	finally
    //   27	47	98	finally
    //   49	82	98	finally
    //   86	95	98	finally
  }
  
  /* Error */
  public void lY(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: new 112	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   25: ldc 115
    //   27: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokevirtual 125	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   40: pop
    //   41: goto -30 -> 11
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	kew
    //   0	49	1	paramString	java.lang.String
    //   6	2	2	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   14	41	44	finally
  }
  
  public void onDestroy()
  {
    if (this.mEntityManager != null) {
      this.mEntityManager.close();
    }
    if (this.a != null) {
      this.a.close();
    }
    this.mApp = null;
  }
  
  /* Error */
  public java.util.List<? extends com.tencent.mobileqq.persistence.Entity> query(java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity> paramClass, boolean paramBoolean, java.lang.String paramString1, java.lang.String[] paramArrayOfString, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +9 -> 19
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 32	kew:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: iload_2
    //   25: aload_3
    //   26: aload 4
    //   28: aload 5
    //   30: aload 6
    //   32: aload 7
    //   34: aload 8
    //   36: invokevirtual 134	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   39: astore_1
    //   40: goto -25 -> 15
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	kew
    //   0	48	1	paramClass	java.lang.Class<? extends com.tencent.mobileqq.persistence.Entity>
    //   0	48	2	paramBoolean	boolean
    //   0	48	3	paramString1	java.lang.String
    //   0	48	4	paramArrayOfString	java.lang.String[]
    //   0	48	5	paramString2	java.lang.String
    //   0	48	6	paramString3	java.lang.String
    //   0	48	7	paramString4	java.lang.String
    //   0	48	8	paramString5	java.lang.String
    //   6	3	9	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	8	43	finally
    //   19	40	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kew
 * JD-Core Version:    0.7.0.1
 */