package com.tencent.tim.todo;

import auoi;
import java.util.List;

public class TodoManager$3
  implements Runnable
{
  public TodoManager$3(auoi paramauoi, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 14	com/tencent/tim/todo/TodoManager$3:this$0	Lauoi;
    //   6: invokestatic 29	auoi:a	(Lauoi;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 40	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   21: aload_0
    //   22: getfield 14	com/tencent/tim/todo/TodoManager$3:this$0	Lauoi;
    //   25: invokestatic 29	auoi:a	(Lauoi;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: invokevirtual 44	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifne +12 -> 45
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 47	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   44: return
    //   45: aload_0
    //   46: getfield 16	com/tencent/tim/todo/TodoManager$3:Lg	Ljava/util/List;
    //   49: invokeinterface 53 1 0
    //   54: astore 4
    //   56: aload 4
    //   58: invokeinterface 58 1 0
    //   63: ifeq +164 -> 227
    //   66: aload 4
    //   68: invokeinterface 62 1 0
    //   73: checkcast 64	com/tencent/util/Pair
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull -24 -> 56
    //   83: aload 5
    //   85: getfield 68	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   88: ifnull -32 -> 56
    //   91: aload 5
    //   93: getfield 71	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   96: checkcast 73	java/lang/Integer
    //   99: invokevirtual 77	java/lang/Integer:intValue	()I
    //   102: istore_1
    //   103: aload 5
    //   105: getfield 68	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   108: checkcast 79	com/tencent/tim/todo/data/TodoInfo
    //   111: astore 5
    //   113: iload_1
    //   114: tableswitch	default:+149 -> 263, 1:+26->140, 2:+26->140, 3:+57->171
    //   141: getfield 14	com/tencent/tim/todo/TodoManager$3:this$0	Lauoi;
    //   144: invokestatic 29	auoi:a	(Lauoi;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: aload 5
    //   149: invokevirtual 83	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   152: goto -96 -> 56
    //   155: astore 4
    //   157: aload 4
    //   159: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   162: aload_3
    //   163: ifnull -119 -> 44
    //   166: aload_3
    //   167: invokevirtual 47	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   170: return
    //   171: aload_0
    //   172: getfield 14	com/tencent/tim/todo/TodoManager$3:this$0	Lauoi;
    //   175: invokestatic 29	auoi:a	(Lauoi;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   178: aload 5
    //   180: invokevirtual 90	com/tencent/tim/todo/data/TodoInfo:getTableName	()Ljava/lang/String;
    //   183: ldc 92
    //   185: iconst_1
    //   186: anewarray 94	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: aload 5
    //   193: getfield 98	com/tencent/tim/todo/data/TodoInfo:todoId	Ljava/lang/String;
    //   196: invokestatic 102	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: aastore
    //   200: invokevirtual 106	com/tencent/mobileqq/persistence/EntityManager:remove	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   203: pop
    //   204: goto -148 -> 56
    //   207: astore 5
    //   209: aload_3
    //   210: astore 4
    //   212: aload 5
    //   214: astore_3
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 47	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   225: aload_3
    //   226: athrow
    //   227: aload_3
    //   228: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   231: aload_3
    //   232: ifnull -188 -> 44
    //   235: aload_3
    //   236: invokevirtual 47	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   239: return
    //   240: astore_3
    //   241: aconst_null
    //   242: astore 4
    //   244: goto -29 -> 215
    //   247: astore 5
    //   249: aload_3
    //   250: astore 4
    //   252: aload 5
    //   254: astore_3
    //   255: goto -40 -> 215
    //   258: astore 4
    //   260: goto -103 -> 157
    //   263: goto -207 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	3
    //   102	12	1	i	int
    //   31	2	2	bool	boolean
    //   1	235	3	localObject1	Object
    //   240	10	3	localObject2	Object
    //   254	1	3	localObject3	Object
    //   12	55	4	localObject4	Object
    //   155	3	4	localException1	java.lang.Exception
    //   210	41	4	localObject5	Object
    //   258	1	4	localException2	java.lang.Exception
    //   76	116	5	localObject6	Object
    //   207	6	5	localObject7	Object
    //   247	6	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   17	32	155	java/lang/Exception
    //   45	56	155	java/lang/Exception
    //   56	78	155	java/lang/Exception
    //   83	113	155	java/lang/Exception
    //   140	152	155	java/lang/Exception
    //   171	204	155	java/lang/Exception
    //   227	231	155	java/lang/Exception
    //   17	32	207	finally
    //   45	56	207	finally
    //   56	78	207	finally
    //   83	113	207	finally
    //   140	152	207	finally
    //   171	204	207	finally
    //   227	231	207	finally
    //   2	14	240	finally
    //   157	162	247	finally
    //   2	14	258	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.TodoManager.3
 * JD-Core Version:    0.7.0.1
 */