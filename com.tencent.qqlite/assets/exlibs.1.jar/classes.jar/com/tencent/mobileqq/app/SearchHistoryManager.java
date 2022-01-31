package com.tencent.mobileqq.app;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class SearchHistoryManager
  implements Manager
{
  public static final int a = 8;
  public static final int b = 8;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final int c = 10000;
  private final int d = 10001;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  /* Error */
  public java.util.ArrayList a()
  {
    // Byte code:
    //   0: new 44	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 45	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 25	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 43
    //   15: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 51	com/tencent/mobileqq/app/FriendsManager
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 25	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 44
    //   29: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 53	com/tencent/mobileqq/app/TroopManager
    //   35: astore 7
    //   37: aload_0
    //   38: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: iconst_0
    //   42: ldc 55
    //   44: invokevirtual 61	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc 63
    //   54: aconst_null
    //   55: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 4
    //   60: iconst_0
    //   61: istore_2
    //   62: aload 4
    //   64: ifnull +306 -> 370
    //   67: aload 4
    //   69: invokeinterface 74 1 0
    //   74: ifeq +296 -> 370
    //   77: new 55	com/tencent/mobileqq/data/SearchHistory
    //   80: dup
    //   81: invokespecial 75	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   84: astore 8
    //   86: aload 8
    //   88: aload 4
    //   90: aload 4
    //   92: ldc 77
    //   94: invokeinterface 81 2 0
    //   99: invokeinterface 85 2 0
    //   104: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   107: aload 8
    //   109: aload 4
    //   111: aload 4
    //   113: ldc 90
    //   115: invokeinterface 81 2 0
    //   120: invokeinterface 85 2 0
    //   125: putfield 92	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   128: aload 8
    //   130: aload 4
    //   132: aload 4
    //   134: ldc 94
    //   136: invokeinterface 81 2 0
    //   141: invokeinterface 85 2 0
    //   146: putfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   149: aload 8
    //   151: aload 4
    //   153: aload 4
    //   155: ldc 98
    //   157: invokeinterface 81 2 0
    //   162: invokeinterface 85 2 0
    //   167: putfield 100	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   170: aload 8
    //   172: aload 4
    //   174: aload 4
    //   176: ldc 102
    //   178: invokeinterface 81 2 0
    //   183: invokeinterface 106 2 0
    //   188: putfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   191: aload 8
    //   193: aload 4
    //   195: aload 4
    //   197: ldc 110
    //   199: invokeinterface 81 2 0
    //   204: invokeinterface 85 2 0
    //   209: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   212: aload 8
    //   214: aload 4
    //   216: aload 4
    //   218: ldc 114
    //   220: invokeinterface 81 2 0
    //   225: invokeinterface 106 2 0
    //   230: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   233: aload 8
    //   235: aload 4
    //   237: aload 4
    //   239: ldc 118
    //   241: invokeinterface 81 2 0
    //   246: invokeinterface 122 2 0
    //   251: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   254: aload 8
    //   256: getfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   259: lookupswitch	default:+269->528, 0:+126->385, 1:+162->421, 1000:+144->403, 1004:+144->403, 3000:+180->439
    //   309: ifeq +158 -> 467
    //   312: aload_0
    //   313: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   316: ldc 55
    //   318: aload 8
    //   320: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   323: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   326: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   329: astore 8
    //   331: aload 8
    //   333: ifnull +13 -> 346
    //   336: aload_0
    //   337: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   340: aload 8
    //   342: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   345: pop
    //   346: aload 4
    //   348: invokeinterface 134 1 0
    //   353: istore_3
    //   354: iload_3
    //   355: ifeq +15 -> 370
    //   358: iload_2
    //   359: iconst_1
    //   360: iadd
    //   361: istore_1
    //   362: iload_1
    //   363: istore_2
    //   364: iload_1
    //   365: bipush 8
    //   367: if_icmplt -290 -> 77
    //   370: aload 4
    //   372: ifnull +10 -> 382
    //   375: aload 4
    //   377: invokeinterface 137 1 0
    //   382: aload 5
    //   384: areturn
    //   385: aload 6
    //   387: aload 8
    //   389: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   392: invokevirtual 140	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   395: ifne +133 -> 528
    //   398: iconst_1
    //   399: istore_1
    //   400: goto -92 -> 308
    //   403: aload 6
    //   405: aload 8
    //   407: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   410: invokevirtual 140	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   413: ifeq +115 -> 528
    //   416: iconst_1
    //   417: istore_1
    //   418: goto -110 -> 308
    //   421: aload 7
    //   423: aload 8
    //   425: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   428: invokevirtual 143	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   431: ifnonnull +97 -> 528
    //   434: iconst_1
    //   435: istore_1
    //   436: goto -128 -> 308
    //   439: aload_0
    //   440: getfield 25	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   443: bipush 45
    //   445: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   448: checkcast 145	com/tencent/mobileqq/app/DiscussionManager
    //   451: aload 8
    //   453: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   456: invokevirtual 148	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   459: ifnonnull +69 -> 528
    //   462: iconst_1
    //   463: istore_1
    //   464: goto -156 -> 308
    //   467: aload 5
    //   469: aload 8
    //   471: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   474: pop
    //   475: goto -129 -> 346
    //   478: astore 6
    //   480: aload 4
    //   482: ifnull -100 -> 382
    //   485: aload 4
    //   487: invokeinterface 137 1 0
    //   492: aload 5
    //   494: areturn
    //   495: astore 5
    //   497: aconst_null
    //   498: astore 4
    //   500: aload 4
    //   502: ifnull +10 -> 512
    //   505: aload 4
    //   507: invokeinterface 137 1 0
    //   512: aload 5
    //   514: athrow
    //   515: astore 5
    //   517: goto -17 -> 500
    //   520: astore 4
    //   522: aconst_null
    //   523: astore 4
    //   525: goto -45 -> 480
    //   528: iconst_0
    //   529: istore_1
    //   530: goto -222 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	SearchHistoryManager
    //   308	222	1	i	int
    //   61	303	2	j	int
    //   353	2	3	bool	boolean
    //   58	448	4	localCursor	android.database.Cursor
    //   520	1	4	localException1	java.lang.Exception
    //   523	1	4	localObject1	Object
    //   7	486	5	localArrayList	java.util.ArrayList
    //   495	18	5	localObject2	Object
    //   515	1	5	localObject3	Object
    //   21	383	6	localFriendsManager	FriendsManager
    //   478	1	6	localException2	java.lang.Exception
    //   35	387	7	localTroopManager	TroopManager
    //   84	386	8	localSearchHistory	com.tencent.mobileqq.data.SearchHistory
    // Exception table:
    //   from	to	target	type
    //   67	77	478	java/lang/Exception
    //   77	308	478	java/lang/Exception
    //   312	331	478	java/lang/Exception
    //   336	346	478	java/lang/Exception
    //   346	354	478	java/lang/Exception
    //   385	398	478	java/lang/Exception
    //   403	416	478	java/lang/Exception
    //   421	434	478	java/lang/Exception
    //   439	462	478	java/lang/Exception
    //   467	475	478	java/lang/Exception
    //   37	60	495	finally
    //   67	77	515	finally
    //   77	308	515	finally
    //   312	331	515	finally
    //   336	346	515	finally
    //   346	354	515	finally
    //   385	398	515	finally
    //   403	416	515	finally
    //   421	434	515	finally
    //   439	462	515	finally
    //   467	475	515	finally
    //   37	60	520	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   9: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+60->76, 0:+61->77, 1:+143->159, 1000:+251->267, 1004:+287->303, 1006:+215->231, 3000:+179->195
    //   77: aload_1
    //   78: ldc 161
    //   80: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   83: aload_1
    //   84: new 163	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   95: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: sipush 10001
    //   101: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   110: aload_0
    //   111: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   114: ldc 55
    //   116: aload_1
    //   117: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   120: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   123: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +211 -> 339
    //   131: aload_2
    //   132: aload_1
    //   133: getfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   136: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   139: aload_2
    //   140: aload_2
    //   141: getfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   144: iconst_1
    //   145: iadd
    //   146: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   149: aload_0
    //   150: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   153: aload_2
    //   154: invokevirtual 176	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   157: pop
    //   158: return
    //   159: aload_1
    //   160: ldc 178
    //   162: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   165: aload_1
    //   166: new 163	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   173: aload_1
    //   174: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   177: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: sipush 10000
    //   183: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   192: goto -82 -> 110
    //   195: aload_1
    //   196: ldc 180
    //   198: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   201: aload_1
    //   202: new 163	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   209: aload_1
    //   210: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   213: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: sipush 10000
    //   219: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   228: goto -118 -> 110
    //   231: aload_1
    //   232: ldc 182
    //   234: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   237: aload_1
    //   238: new 163	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   245: aload_1
    //   246: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   249: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: sipush 10001
    //   255: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   264: goto -154 -> 110
    //   267: aload_1
    //   268: ldc 184
    //   270: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   273: aload_1
    //   274: new 163	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   281: aload_1
    //   282: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   285: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: sipush 10001
    //   291: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   300: goto -190 -> 110
    //   303: aload_1
    //   304: ldc 186
    //   306: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   309: aload_1
    //   310: new 163	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   317: aload_1
    //   318: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   321: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: sipush 10001
    //   327: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   336: goto -226 -> 110
    //   339: aload_0
    //   340: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   343: iconst_0
    //   344: ldc 55
    //   346: invokevirtual 61	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   349: aconst_null
    //   350: aconst_null
    //   351: aconst_null
    //   352: aconst_null
    //   353: aconst_null
    //   354: ldc 188
    //   356: aconst_null
    //   357: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   360: astore_3
    //   361: aload_3
    //   362: ifnull +174 -> 536
    //   365: aload_3
    //   366: astore_2
    //   367: bipush 8
    //   369: aload_3
    //   370: invokeinterface 192 1 0
    //   375: if_icmpgt +161 -> 536
    //   378: aload_3
    //   379: astore_2
    //   380: aload_3
    //   381: invokeinterface 74 1 0
    //   386: ifeq +139 -> 525
    //   389: aload_3
    //   390: astore_2
    //   391: aload_3
    //   392: aload_3
    //   393: ldc 77
    //   395: invokeinterface 81 2 0
    //   400: invokeinterface 85 2 0
    //   405: astore 4
    //   407: aload_3
    //   408: astore_2
    //   409: aload_0
    //   410: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   413: ldc 55
    //   415: aload 4
    //   417: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   420: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   423: astore 4
    //   425: aload_3
    //   426: astore_2
    //   427: aload 4
    //   429: aload_1
    //   430: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   433: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   436: aload_3
    //   437: astore_2
    //   438: aload 4
    //   440: aload_1
    //   441: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   444: putfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   447: aload_3
    //   448: astore_2
    //   449: aload 4
    //   451: aload_1
    //   452: getfield 100	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   455: putfield 100	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   458: aload_3
    //   459: astore_2
    //   460: aload 4
    //   462: aload_1
    //   463: getfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   466: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   469: aload_3
    //   470: astore_2
    //   471: aload 4
    //   473: aload_1
    //   474: getfield 92	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   477: putfield 92	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   480: aload_3
    //   481: astore_2
    //   482: aload 4
    //   484: aload_1
    //   485: getfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   488: putfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   491: aload_3
    //   492: astore_2
    //   493: aload 4
    //   495: aload_1
    //   496: getfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   499: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   502: aload_3
    //   503: astore_2
    //   504: aload 4
    //   506: aload_1
    //   507: getfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   510: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   513: aload_3
    //   514: astore_2
    //   515: aload_0
    //   516: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   519: aload 4
    //   521: invokevirtual 176	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   524: pop
    //   525: aload_3
    //   526: ifnull -450 -> 76
    //   529: aload_3
    //   530: invokeinterface 137 1 0
    //   535: return
    //   536: aload_3
    //   537: astore_2
    //   538: aload_0
    //   539: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   542: aload_1
    //   543: invokevirtual 195	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   546: goto -21 -> 525
    //   549: astore_1
    //   550: aload_3
    //   551: astore_2
    //   552: aload_1
    //   553: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   556: aload_3
    //   557: ifnull -481 -> 76
    //   560: aload_3
    //   561: invokeinterface 137 1 0
    //   566: return
    //   567: astore_1
    //   568: aconst_null
    //   569: astore_2
    //   570: aload_2
    //   571: ifnull +9 -> 580
    //   574: aload_2
    //   575: invokeinterface 137 1 0
    //   580: aload_1
    //   581: athrow
    //   582: astore_1
    //   583: goto -13 -> 570
    //   586: astore_1
    //   587: aconst_null
    //   588: astore_3
    //   589: goto -39 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	SearchHistoryManager
    //   0	592	1	paramSearchHistory	com.tencent.mobileqq.data.SearchHistory
    //   126	449	2	localObject1	Object
    //   360	229	3	localCursor	android.database.Cursor
    //   405	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   367	378	549	java/lang/Exception
    //   380	389	549	java/lang/Exception
    //   391	407	549	java/lang/Exception
    //   409	425	549	java/lang/Exception
    //   427	436	549	java/lang/Exception
    //   438	447	549	java/lang/Exception
    //   449	458	549	java/lang/Exception
    //   460	469	549	java/lang/Exception
    //   471	480	549	java/lang/Exception
    //   482	491	549	java/lang/Exception
    //   493	502	549	java/lang/Exception
    //   504	513	549	java/lang/Exception
    //   515	525	549	java/lang/Exception
    //   538	546	549	java/lang/Exception
    //   339	361	567	finally
    //   367	378	582	finally
    //   380	389	582	finally
    //   391	407	582	finally
    //   409	425	582	finally
    //   427	436	582	finally
    //   438	447	582	finally
    //   449	458	582	finally
    //   460	469	582	finally
    //   471	480	582	finally
    //   482	491	582	finally
    //   493	502	582	finally
    //   504	513	582	finally
    //   515	525	582	finally
    //   538	546	582	finally
    //   552	556	582	finally
    //   339	361	586	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */