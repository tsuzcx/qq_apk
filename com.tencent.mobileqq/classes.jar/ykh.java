import com.tencent.mobileqq.apollo.ApolloManager;

public class ykh
  implements Runnable
{
  public ykh(ApolloManager paramApolloManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   4: invokestatic 24	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: invokevirtual 29	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 33	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   15: aload_0
    //   16: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   19: invokestatic 36	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   29: invokestatic 39	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Ljava/util/List;
    //   32: ifnull +154 -> 186
    //   35: new 41	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 42	java/util/ArrayList:<init>	()V
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   47: invokestatic 39	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Ljava/util/List;
    //   50: invokeinterface 48 1 0
    //   55: astore 4
    //   57: aload 4
    //   59: invokeinterface 54 1 0
    //   64: ifeq +55 -> 119
    //   67: aload 4
    //   69: invokeinterface 58 1 0
    //   74: checkcast 60	com/tencent/mobileqq/DrawerPushItem
    //   77: astore 5
    //   79: aload 5
    //   81: getfield 64	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   84: ifne -27 -> 57
    //   87: aload_3
    //   88: aload 5
    //   90: invokeinterface 68 2 0
    //   95: pop
    //   96: goto -39 -> 57
    //   99: astore_3
    //   100: aload_2
    //   101: monitorexit
    //   102: aload_3
    //   103: athrow
    //   104: astore_2
    //   105: ldc 70
    //   107: iconst_1
    //   108: ldc 72
    //   110: aload_2
    //   111: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_1
    //   115: invokevirtual 81	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   118: return
    //   119: aload_3
    //   120: invokeinterface 85 1 0
    //   125: ifle +61 -> 186
    //   128: aload_3
    //   129: invokeinterface 48 1 0
    //   134: astore_3
    //   135: aload_3
    //   136: invokeinterface 54 1 0
    //   141: ifeq +45 -> 186
    //   144: aload_3
    //   145: invokeinterface 58 1 0
    //   150: checkcast 60	com/tencent/mobileqq/DrawerPushItem
    //   153: astore 4
    //   155: aload_0
    //   156: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   159: invokestatic 39	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Ljava/util/List;
    //   162: aload 4
    //   164: invokeinterface 88 2 0
    //   169: pop
    //   170: aload_0
    //   171: getfield 12	ykh:a	Lcom/tencent/mobileqq/apollo/ApolloManager;
    //   174: invokestatic 24	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/apollo/ApolloManager;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   177: aload 4
    //   179: invokevirtual 91	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   182: pop
    //   183: goto -48 -> 135
    //   186: aload_2
    //   187: monitorexit
    //   188: aload_1
    //   189: invokevirtual 94	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   192: aload_1
    //   193: invokevirtual 81	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   196: return
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 81	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   202: aload_2
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	ykh
    //   10	189	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   104	83	2	localException	java.lang.Exception
    //   197	6	2	localObject2	Object
    //   42	46	3	localArrayList	java.util.ArrayList
    //   99	30	3	localObject3	Object
    //   134	11	3	localIterator	java.util.Iterator
    //   55	123	4	localObject4	Object
    //   77	12	5	localDrawerPushItem	com.tencent.mobileqq.DrawerPushItem
    // Exception table:
    //   from	to	target	type
    //   25	57	99	finally
    //   57	96	99	finally
    //   100	102	99	finally
    //   119	135	99	finally
    //   135	183	99	finally
    //   186	188	99	finally
    //   11	25	104	java/lang/Exception
    //   102	104	104	java/lang/Exception
    //   188	192	104	java/lang/Exception
    //   11	25	197	finally
    //   102	104	197	finally
    //   105	114	197	finally
    //   188	192	197	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykh
 * JD-Core Version:    0.7.0.1
 */