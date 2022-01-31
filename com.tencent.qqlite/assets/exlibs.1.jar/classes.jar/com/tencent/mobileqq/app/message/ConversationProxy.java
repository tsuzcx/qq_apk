package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConversationProxy
  extends BaseProxy
{
  static final String jdField_a_of_type_JavaLangString = "Q.unread.Proxy";
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ConversationProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  /* Error */
  protected int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 69	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ConversationProxy
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  /* Error */
  protected long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   33: lstore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: lload_3
    //   37: lreturn
    //   38: lconst_0
    //   39: lstore_3
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ConversationProxy
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    //   33	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  /* Error */
  protected ConversationInfo a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +19 -> 35
    //   19: aload_0
    //   20: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aconst_null
    //   36: astore_1
    //   37: goto -6 -> 31
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ConversationProxy
    //   0	45	1	paramString	String
    //   0	45	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	31	40	finally
  }
  
  protected Set a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.unread.Proxy", 2, "cloneConversationInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  protected void a() {}
  
  protected void a(String paramString, int paramInt)
  {
    try
    {
      String str = MsgProxyUtils.a(paramString, paramInt);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        c(paramString, paramInt, (ConversationInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +28 -> 46
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: aload_0
    //   25: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload 4
    //   30: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   36: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   39: iload_3
    //   40: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: aload_1
    //   48: iload_2
    //   49: lconst_0
    //   50: iload_3
    //   51: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   54: goto -11 -> 43
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	ConversationProxy
    //   0	62	1	paramString	String
    //   0	62	2	paramInt1	int
    //   0	62	3	paramInt2	int
    //   7	22	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	43	57	finally
    //   46	54	57	finally
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = MsgProxyUtils.a(paramString, paramInt1);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (((((ConversationInfo)localObject).lastread < paramLong) && (ConversationFacade.a(paramInt1))) || ((((ConversationInfo)localObject).lastread != paramLong) && (!ConversationFacade.a(paramInt1))) || (((ConversationInfo)localObject).unreadCount != paramInt2))
          {
            long l = paramLong;
            if (ConversationFacade.a(paramInt1)) {
              l = Math.max(((ConversationInfo)localObject).lastread, paramLong);
            }
            ((ConversationInfo)localObject).lastread = l;
            ((ConversationInfo)localObject).unreadCount = Math.max(0, paramInt2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread update=" + ((ConversationInfo)localObject).toString());
            }
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, paramLong, Math.max(0, paramInt2));
      }
      finally {}
      ConversationInfo localConversationInfo;
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread insert=" + localConversationInfo.toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 4, null);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  /* Error */
  protected void b(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +38 -> 56
    //   21: aload_0
    //   22: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   33: astore 4
    //   35: aload_0
    //   36: aload_1
    //   37: iload_2
    //   38: aload 4
    //   40: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   43: aload 4
    //   45: getfield 69	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   48: iload_3
    //   49: iadd
    //   50: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: aload_1
    //   58: iload_2
    //   59: lconst_0
    //   60: iload_3
    //   61: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   64: goto -11 -> 53
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ConversationProxy
    //   0	72	1	paramString	String
    //   0	72	2	paramInt1	int
    //   0	72	3	paramInt2	int
    //   7	37	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	67	finally
    //   56	64	67	finally
  }
  
  protected void b(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 3, null);
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 8
    //   8: iconst_2
    //   9: ldc 178
    //   11: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: ifnull +10 -> 28
    //   21: aload_0
    //   22: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   28: aload_0
    //   29: invokespecial 183	com/tencent/mobileqq/app/message/ConversationProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: ldc 65
    //   34: invokevirtual 186	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +4 -> 43
    //   42: return
    //   43: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +33 -> 79
    //   49: ldc 8
    //   51: iconst_2
    //   52: new 127	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   59: ldc 188
    //   61: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokeinterface 194 1 0
    //   70: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iconst_0
    //   80: istore_1
    //   81: iload_1
    //   82: aload_2
    //   83: invokeinterface 194 1 0
    //   88: if_icmpge -46 -> 42
    //   91: aload_0
    //   92: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: aload_2
    //   96: iload_1
    //   97: invokeinterface 200 2 0
    //   102: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   105: getfield 203	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   108: aload_2
    //   109: iload_1
    //   110: invokeinterface 200 2 0
    //   115: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   118: getfield 206	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   121: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   124: aload_2
    //   125: iload_1
    //   126: invokeinterface 200 2 0
    //   131: invokevirtual 155	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: pop
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: goto -58 -> 81
    //   142: astore_2
    //   143: aload_2
    //   144: athrow
    //   145: astore_2
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ConversationProxy
    //   80	59	1	i	int
    //   37	88	2	localList	java.util.List
    //   142	2	2	localObject	Object
    //   145	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	135	142	finally
    //   81	135	145	java/lang/Exception
  }
  
  protected void c(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 5, null);
  }
  
  protected void d()
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
          if (localConversationInfo.unreadCount > 0)
          {
            localConversationInfo.unreadCount = 0;
            a(localConversationInfo.uin, localConversationInfo.type, localConversationInfo);
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ConversationProxy
 * JD-Core Version:    0.7.0.1
 */