package com.tencent.mobileqq.apollo;

import abhh;

public class ApolloManager$17
  implements Runnable
{
  public ApolloManager$17(abhh paramabhh) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   4: invokestatic 25	abhh:a	(Labhh;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: invokevirtual 31	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 36	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   15: aload_0
    //   16: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   19: invokestatic 39	abhh:a	(Labhh;)Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   29: invokestatic 42	abhh:a	(Labhh;)Ljava/util/List;
    //   32: ifnull +154 -> 186
    //   35: new 44	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 45	java/util/ArrayList:<init>	()V
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   47: invokestatic 42	abhh:a	(Labhh;)Ljava/util/List;
    //   50: invokeinterface 51 1 0
    //   55: astore 4
    //   57: aload 4
    //   59: invokeinterface 57 1 0
    //   64: ifeq +55 -> 119
    //   67: aload 4
    //   69: invokeinterface 61 1 0
    //   74: checkcast 63	com/tencent/mobileqq/DrawerPushItem
    //   77: astore 5
    //   79: aload 5
    //   81: getfield 67	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   84: ifne -27 -> 57
    //   87: aload_3
    //   88: aload 5
    //   90: invokeinterface 71 2 0
    //   95: pop
    //   96: goto -39 -> 57
    //   99: astore_3
    //   100: aload_2
    //   101: monitorexit
    //   102: aload_3
    //   103: athrow
    //   104: astore_2
    //   105: ldc 73
    //   107: iconst_1
    //   108: ldc 75
    //   110: aload_2
    //   111: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_1
    //   115: invokevirtual 84	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   118: return
    //   119: aload_3
    //   120: invokeinterface 88 1 0
    //   125: ifle +61 -> 186
    //   128: aload_3
    //   129: invokeinterface 51 1 0
    //   134: astore_3
    //   135: aload_3
    //   136: invokeinterface 57 1 0
    //   141: ifeq +45 -> 186
    //   144: aload_3
    //   145: invokeinterface 61 1 0
    //   150: checkcast 63	com/tencent/mobileqq/DrawerPushItem
    //   153: astore 4
    //   155: aload_0
    //   156: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   159: invokestatic 42	abhh:a	(Labhh;)Ljava/util/List;
    //   162: aload 4
    //   164: invokeinterface 91 2 0
    //   169: pop
    //   170: aload_0
    //   171: getfield 12	com/tencent/mobileqq/apollo/ApolloManager$17:this$0	Labhh;
    //   174: invokestatic 25	abhh:a	(Labhh;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   177: aload 4
    //   179: invokevirtual 94	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   182: pop
    //   183: goto -48 -> 135
    //   186: aload_2
    //   187: monitorexit
    //   188: aload_1
    //   189: invokevirtual 97	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   192: aload_1
    //   193: invokevirtual 84	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   196: return
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 84	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   202: aload_2
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	17
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.17
 * JD-Core Version:    0.7.0.1
 */