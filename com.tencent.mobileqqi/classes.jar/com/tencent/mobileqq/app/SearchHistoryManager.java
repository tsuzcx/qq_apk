package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.SearchHistory;
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
    //   13: bipush 46
    //   15: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 51	com/tencent/mobileqq/app/FriendsManager
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 25	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 47
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
    //   64: ifnull +314 -> 378
    //   67: aload 4
    //   69: invokeinterface 74 1 0
    //   74: ifeq +304 -> 378
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
    //   259: lookupswitch	default:+277->536, 0:+134->393, 1:+170->429, 1000:+152->411, 1004:+152->411, 1021:+152->411, 3000:+188->447
    //   317: ifeq +158 -> 475
    //   320: aload_0
    //   321: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   324: ldc 55
    //   326: aload 8
    //   328: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   331: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   334: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   337: astore 8
    //   339: aload 8
    //   341: ifnull +13 -> 354
    //   344: aload_0
    //   345: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   348: aload 8
    //   350: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   353: pop
    //   354: aload 4
    //   356: invokeinterface 134 1 0
    //   361: istore_3
    //   362: iload_3
    //   363: ifeq +15 -> 378
    //   366: iload_2
    //   367: iconst_1
    //   368: iadd
    //   369: istore_1
    //   370: iload_1
    //   371: istore_2
    //   372: iload_1
    //   373: bipush 8
    //   375: if_icmplt -298 -> 77
    //   378: aload 4
    //   380: ifnull +10 -> 390
    //   383: aload 4
    //   385: invokeinterface 137 1 0
    //   390: aload 5
    //   392: areturn
    //   393: aload 6
    //   395: aload 8
    //   397: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   400: invokevirtual 140	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   403: ifne +133 -> 536
    //   406: iconst_1
    //   407: istore_1
    //   408: goto -92 -> 316
    //   411: aload 6
    //   413: aload 8
    //   415: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   418: invokevirtual 140	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   421: ifeq +115 -> 536
    //   424: iconst_1
    //   425: istore_1
    //   426: goto -110 -> 316
    //   429: aload 7
    //   431: aload 8
    //   433: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   436: invokevirtual 143	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   439: ifnonnull +97 -> 536
    //   442: iconst_1
    //   443: istore_1
    //   444: goto -128 -> 316
    //   447: aload_0
    //   448: getfield 25	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   451: bipush 48
    //   453: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   456: checkcast 145	com/tencent/mobileqq/app/DiscussionManager
    //   459: aload 8
    //   461: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   464: invokevirtual 148	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   467: ifnonnull +69 -> 536
    //   470: iconst_1
    //   471: istore_1
    //   472: goto -156 -> 316
    //   475: aload 5
    //   477: aload 8
    //   479: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   482: pop
    //   483: goto -129 -> 354
    //   486: astore 6
    //   488: aload 4
    //   490: ifnull -100 -> 390
    //   493: aload 4
    //   495: invokeinterface 137 1 0
    //   500: aload 5
    //   502: areturn
    //   503: astore 5
    //   505: aconst_null
    //   506: astore 4
    //   508: aload 4
    //   510: ifnull +10 -> 520
    //   513: aload 4
    //   515: invokeinterface 137 1 0
    //   520: aload 5
    //   522: athrow
    //   523: astore 5
    //   525: goto -17 -> 508
    //   528: astore 4
    //   530: aconst_null
    //   531: astore 4
    //   533: goto -45 -> 488
    //   536: iconst_0
    //   537: istore_1
    //   538: goto -222 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	SearchHistoryManager
    //   316	222	1	i	int
    //   61	311	2	j	int
    //   361	2	3	bool	boolean
    //   58	456	4	localCursor	android.database.Cursor
    //   528	1	4	localException1	Exception
    //   531	1	4	localObject1	Object
    //   7	494	5	localArrayList	java.util.ArrayList
    //   503	18	5	localObject2	Object
    //   523	1	5	localObject3	Object
    //   21	391	6	localFriendsManager	FriendsManager
    //   486	1	6	localException2	Exception
    //   35	395	7	localTroopManager	TroopManager
    //   84	394	8	localSearchHistory	SearchHistory
    // Exception table:
    //   from	to	target	type
    //   67	77	486	java/lang/Exception
    //   77	316	486	java/lang/Exception
    //   320	339	486	java/lang/Exception
    //   344	354	486	java/lang/Exception
    //   354	362	486	java/lang/Exception
    //   393	406	486	java/lang/Exception
    //   411	424	486	java/lang/Exception
    //   429	442	486	java/lang/Exception
    //   447	470	486	java/lang/Exception
    //   475	483	486	java/lang/Exception
    //   37	60	503	finally
    //   67	77	523	finally
    //   77	316	523	finally
    //   320	339	523	finally
    //   344	354	523	finally
    //   354	362	523	finally
    //   393	406	523	finally
    //   411	424	523	finally
    //   429	442	523	finally
    //   447	470	523	finally
    //   475	483	523	finally
    //   37	60	528	java/lang/Exception
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
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
    //   16: lookupswitch	default:+68->84, 0:+69->85, 1:+157->173, 1000:+283->299, 1004:+325->341, 1006:+241->257, 1021:+367->383, 3000:+199->215
    //   85: aload_1
    //   86: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   89: ldc 166
    //   91: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   94: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   97: aload_1
    //   98: new 171	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   105: aload_1
    //   106: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   109: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: sipush 10001
    //   115: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   128: ldc 55
    //   130: aload_1
    //   131: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   134: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   137: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +283 -> 425
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   150: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   153: aload_2
    //   154: aload_2
    //   155: getfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   158: iconst_1
    //   159: iadd
    //   160: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   163: aload_0
    //   164: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   167: aload_2
    //   168: invokevirtual 184	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   171: pop
    //   172: return
    //   173: aload_1
    //   174: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   177: ldc 185
    //   179: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   182: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   185: aload_1
    //   186: new 171	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   193: aload_1
    //   194: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   197: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: sipush 10000
    //   203: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   212: goto -88 -> 124
    //   215: aload_1
    //   216: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   219: ldc 186
    //   221: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   224: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   227: aload_1
    //   228: new 171	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   235: aload_1
    //   236: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   239: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: sipush 10000
    //   245: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   254: goto -130 -> 124
    //   257: aload_1
    //   258: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   261: ldc 187
    //   263: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   266: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   269: aload_1
    //   270: new 171	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   277: aload_1
    //   278: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   281: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: sipush 10001
    //   287: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   296: goto -172 -> 124
    //   299: aload_1
    //   300: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   303: ldc 188
    //   305: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   308: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   311: aload_1
    //   312: new 171	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   319: aload_1
    //   320: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   323: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: sipush 10001
    //   329: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   338: goto -214 -> 124
    //   341: aload_1
    //   342: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   345: ldc 189
    //   347: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   350: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   353: aload_1
    //   354: new 171	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   361: aload_1
    //   362: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   365: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: sipush 10001
    //   371: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   380: goto -256 -> 124
    //   383: aload_1
    //   384: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   387: ldc 190
    //   389: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   392: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   395: aload_1
    //   396: new 171	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   403: aload_1
    //   404: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   407: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: sipush 10001
    //   413: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   422: goto -298 -> 124
    //   425: aload_0
    //   426: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   429: iconst_0
    //   430: ldc 55
    //   432: invokevirtual 61	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   435: aconst_null
    //   436: aconst_null
    //   437: aconst_null
    //   438: aconst_null
    //   439: aconst_null
    //   440: ldc 192
    //   442: aconst_null
    //   443: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   446: astore_3
    //   447: aload_3
    //   448: ifnull +174 -> 622
    //   451: aload_3
    //   452: astore_2
    //   453: bipush 8
    //   455: aload_3
    //   456: invokeinterface 196 1 0
    //   461: if_icmpgt +161 -> 622
    //   464: aload_3
    //   465: astore_2
    //   466: aload_3
    //   467: invokeinterface 74 1 0
    //   472: ifeq +139 -> 611
    //   475: aload_3
    //   476: astore_2
    //   477: aload_3
    //   478: aload_3
    //   479: ldc 77
    //   481: invokeinterface 81 2 0
    //   486: invokeinterface 85 2 0
    //   491: astore 4
    //   493: aload_3
    //   494: astore_2
    //   495: aload_0
    //   496: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   499: ldc 55
    //   501: aload 4
    //   503: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   506: checkcast 55	com/tencent/mobileqq/data/SearchHistory
    //   509: astore 4
    //   511: aload_3
    //   512: astore_2
    //   513: aload 4
    //   515: aload_1
    //   516: getfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   519: putfield 88	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   522: aload_3
    //   523: astore_2
    //   524: aload 4
    //   526: aload_1
    //   527: getfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   530: putfield 96	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   533: aload_3
    //   534: astore_2
    //   535: aload 4
    //   537: aload_1
    //   538: getfield 100	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   541: putfield 100	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   544: aload_3
    //   545: astore_2
    //   546: aload 4
    //   548: aload_1
    //   549: getfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   552: putfield 125	com/tencent/mobileqq/data/SearchHistory:time	J
    //   555: aload_3
    //   556: astore_2
    //   557: aload 4
    //   559: aload_1
    //   560: getfield 92	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   563: putfield 92	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   566: aload_3
    //   567: astore_2
    //   568: aload 4
    //   570: aload_1
    //   571: getfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   574: putfield 108	com/tencent/mobileqq/data/SearchHistory:type	I
    //   577: aload_3
    //   578: astore_2
    //   579: aload 4
    //   581: aload_1
    //   582: getfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   585: putfield 116	com/tencent/mobileqq/data/SearchHistory:count	I
    //   588: aload_3
    //   589: astore_2
    //   590: aload 4
    //   592: aload_1
    //   593: getfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   596: putfield 112	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   599: aload_3
    //   600: astore_2
    //   601: aload_0
    //   602: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   605: aload 4
    //   607: invokevirtual 184	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   610: pop
    //   611: aload_3
    //   612: ifnull -528 -> 84
    //   615: aload_3
    //   616: invokeinterface 137 1 0
    //   621: return
    //   622: aload_3
    //   623: astore_2
    //   624: aload_0
    //   625: getfield 38	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   628: aload_1
    //   629: invokevirtual 199	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   632: goto -21 -> 611
    //   635: astore_1
    //   636: aload_3
    //   637: astore_2
    //   638: aload_1
    //   639: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   642: aload_3
    //   643: ifnull -559 -> 84
    //   646: aload_3
    //   647: invokeinterface 137 1 0
    //   652: return
    //   653: astore_1
    //   654: aconst_null
    //   655: astore_2
    //   656: aload_2
    //   657: ifnull +9 -> 666
    //   660: aload_2
    //   661: invokeinterface 137 1 0
    //   666: aload_1
    //   667: athrow
    //   668: astore_1
    //   669: goto -13 -> 656
    //   672: astore_1
    //   673: aconst_null
    //   674: astore_3
    //   675: goto -39 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	SearchHistoryManager
    //   0	678	1	paramSearchHistory	SearchHistory
    //   140	521	2	localObject1	Object
    //   446	229	3	localCursor	android.database.Cursor
    //   491	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   453	464	635	java/lang/Exception
    //   466	475	635	java/lang/Exception
    //   477	493	635	java/lang/Exception
    //   495	511	635	java/lang/Exception
    //   513	522	635	java/lang/Exception
    //   524	533	635	java/lang/Exception
    //   535	544	635	java/lang/Exception
    //   546	555	635	java/lang/Exception
    //   557	566	635	java/lang/Exception
    //   568	577	635	java/lang/Exception
    //   579	588	635	java/lang/Exception
    //   590	599	635	java/lang/Exception
    //   601	611	635	java/lang/Exception
    //   624	632	635	java/lang/Exception
    //   425	447	653	finally
    //   453	464	668	finally
    //   466	475	668	finally
    //   477	493	668	finally
    //   495	511	668	finally
    //   513	522	668	finally
    //   524	533	668	finally
    //   535	544	668	finally
    //   546	555	668	finally
    //   557	566	668	finally
    //   568	577	668	finally
    //   579	588	668	finally
    //   590	599	668	finally
    //   601	611	668	finally
    //   624	632	668	finally
    //   638	642	668	finally
    //   425	447	672	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    try
    {
      paramString = (SearchHistory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SearchHistory.class, paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
        return true;
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */