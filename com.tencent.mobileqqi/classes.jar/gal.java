import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;

public class gal
  implements Runnable
{
  public gal(MagicfaceActionManager paramMagicfaceActionManager, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   4: invokestatic 27	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +18 -> 27
    //   12: aload_0
    //   13: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   16: aload_0
    //   17: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   20: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   23: invokestatic 34	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   31: invokestatic 37	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)V
    //   34: aconst_null
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 15	gal:jdField_a_of_type_Int	I
    //   40: ifne +184 -> 224
    //   43: aload_0
    //   44: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   47: invokestatic 40	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   50: ldc 42
    //   52: invokevirtual 47	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +152 -> 209
    //   60: aload_0
    //   61: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   64: aload_0
    //   65: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   68: invokestatic 50	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   71: aload_2
    //   72: invokevirtual 55	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   75: invokestatic 58	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   78: pop
    //   79: aload_0
    //   80: getfield 15	gal:jdField_a_of_type_Int	I
    //   83: iconst_1
    //   84: if_icmpne +10 -> 94
    //   87: aload_0
    //   88: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   91: invokestatic 60	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)V
    //   94: aload_0
    //   95: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   98: aload_0
    //   99: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   102: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   105: invokestatic 62	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   108: aload_0
    //   109: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   112: aload_0
    //   113: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   116: invokestatic 50	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   119: aload_2
    //   120: invokevirtual 65	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Ljava/util/List;
    //   123: invokestatic 68	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Ljava/util/List;)Ljava/util/List;
    //   126: pop
    //   127: aload_0
    //   128: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   131: invokestatic 71	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Ljava/util/List;
    //   134: invokeinterface 77 1 0
    //   139: astore_2
    //   140: aload_2
    //   141: invokeinterface 83 1 0
    //   146: ifeq +63 -> 209
    //   149: aload_2
    //   150: invokeinterface 87 1 0
    //   155: checkcast 89	com/tencent/mobileqq/magicface/magicfaceaction/Action
    //   158: astore_3
    //   159: aload_0
    //   160: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   163: aload_3
    //   164: invokestatic 92	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/Action;)Lcom/tencent/mobileqq/magicface/magicfaceaction/Action;
    //   167: pop
    //   168: aload_3
    //   169: aload_0
    //   170: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   173: invokestatic 95	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   176: putfield 98	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   179: aload_3
    //   180: aload_0
    //   181: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   184: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   187: putfield 101	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   190: aload_3
    //   191: invokevirtual 103	com/tencent/mobileqq/magicface/magicfaceaction/Action:a	()Z
    //   194: ifeq +15 -> 209
    //   197: aload_0
    //   198: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   201: invokestatic 105	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Z
    //   204: istore_1
    //   205: iload_1
    //   206: ifeq -66 -> 140
    //   209: aload_0
    //   210: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   213: aload_0
    //   214: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   217: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   220: invokestatic 34	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   223: return
    //   224: aload_0
    //   225: getfield 15	gal:jdField_a_of_type_Int	I
    //   228: iconst_1
    //   229: if_icmpne -173 -> 56
    //   232: aload_0
    //   233: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   236: invokestatic 40	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   239: ldc 107
    //   241: invokevirtual 47	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore_2
    //   245: goto -189 -> 56
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   253: aload_0
    //   254: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   257: aload_0
    //   258: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   261: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   264: invokestatic 34	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   267: return
    //   268: astore_2
    //   269: aload_0
    //   270: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   273: aload_0
    //   274: getfield 13	gal:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   277: invokestatic 30	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   280: invokestatic 34	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   283: aload_2
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	gal
    //   7	199	1	bool	boolean
    //   35	210	2	localObject1	Object
    //   248	2	2	localException	java.lang.Exception
    //   268	16	2	localObject2	Object
    //   158	33	3	localAction	com.tencent.mobileqq.magicface.magicfaceaction.Action
    // Exception table:
    //   from	to	target	type
    //   0	8	248	java/lang/Exception
    //   27	34	248	java/lang/Exception
    //   36	56	248	java/lang/Exception
    //   60	94	248	java/lang/Exception
    //   94	140	248	java/lang/Exception
    //   140	205	248	java/lang/Exception
    //   224	245	248	java/lang/Exception
    //   0	8	268	finally
    //   27	34	268	finally
    //   36	56	268	finally
    //   60	94	268	finally
    //   94	140	268	finally
    //   140	205	268	finally
    //   224	245	268	finally
    //   249	253	268	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gal
 * JD-Core Version:    0.7.0.1
 */