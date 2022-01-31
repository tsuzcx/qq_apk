import com.tencent.mobileqq.config.LebaConfig;

public class fms
  implements Runnable
{
  public fms(LebaConfig paramLebaConfig) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	fms:a	Lcom/tencent/mobileqq/config/LebaConfig;
    //   4: invokestatic 24	com/tencent/mobileqq/config/LebaConfig:a	(Lcom/tencent/mobileqq/config/LebaConfig;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_1
    //   15: bipush 64
    //   17: iconst_0
    //   18: invokestatic 41	com/tencent/mobileqq/data/ResourcePluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;IZ)Ljava/util/List;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +67 -> 90
    //   26: aload_2
    //   27: invokeinterface 47 1 0
    //   32: astore_2
    //   33: aload_2
    //   34: invokeinterface 53 1 0
    //   39: ifeq +51 -> 90
    //   42: aload_2
    //   43: invokeinterface 57 1 0
    //   48: checkcast 37	com/tencent/mobileqq/data/ResourcePluginInfo
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull -20 -> 33
    //   56: aload_3
    //   57: getfield 61	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   60: iconst_1
    //   61: if_icmpne -28 -> 33
    //   64: aload_3
    //   65: getfield 65	com/tencent/mobileqq/data/ResourcePluginInfo:iPluginType	I
    //   68: bipush 64
    //   70: if_icmpne -37 -> 33
    //   73: aload_1
    //   74: aload_3
    //   75: getfield 69	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   78: invokestatic 73	com/tencent/mobileqq/data/ResourcePluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;)V
    //   81: goto -48 -> 33
    //   84: astore_2
    //   85: aload_1
    //   86: invokevirtual 77	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   89: return
    //   90: aload_1
    //   91: invokevirtual 77	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   94: return
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 77	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	fms
    //   13	84	1	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   21	22	2	localObject1	Object
    //   84	1	2	localException	java.lang.Exception
    //   95	6	2	localObject2	Object
    //   51	24	3	localResourcePluginInfo	com.tencent.mobileqq.data.ResourcePluginInfo
    // Exception table:
    //   from	to	target	type
    //   14	22	84	java/lang/Exception
    //   26	33	84	java/lang/Exception
    //   33	52	84	java/lang/Exception
    //   56	81	84	java/lang/Exception
    //   14	22	95	finally
    //   26	33	95	finally
    //   33	52	95	finally
    //   56	81	95	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fms
 * JD-Core Version:    0.7.0.1
 */