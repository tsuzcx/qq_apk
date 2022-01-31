package com.tencent.mobileqq.managers;

public class MessageRecordManagerImpl
  implements MessageRecordManager
{
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 17	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 19	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: aload_1
    //   22: invokevirtual 25	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   25: invokevirtual 30	com/tencent/mobileqq/app/SQLiteOpenHelper:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   28: astore 5
    //   30: aload 5
    //   32: ldc 32
    //   34: aconst_null
    //   35: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +60 -> 100
    //   43: aload_3
    //   44: astore_2
    //   45: aload_1
    //   46: invokeinterface 43 1 0
    //   51: ifeq +49 -> 100
    //   54: aload_3
    //   55: astore_2
    //   56: aload 5
    //   58: aload_1
    //   59: iconst_0
    //   60: invokeinterface 47 2 0
    //   65: invokestatic 53	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   74: pop
    //   75: goto -32 -> 43
    //   78: astore_3
    //   79: aload_1
    //   80: ifnull +9 -> 89
    //   83: aload_1
    //   84: invokeinterface 63 1 0
    //   89: aload_2
    //   90: ifnull -82 -> 8
    //   93: aload_2
    //   94: invokeinterface 63 1 0
    //   99: return
    //   100: aload_3
    //   101: astore_2
    //   102: aload 5
    //   104: ldc 65
    //   106: aconst_null
    //   107: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +69 -> 181
    //   115: aload_3
    //   116: astore_2
    //   117: aload_3
    //   118: invokeinterface 43 1 0
    //   123: ifeq +58 -> 181
    //   126: aload_3
    //   127: astore_2
    //   128: aload 5
    //   130: aload_3
    //   131: iconst_0
    //   132: invokeinterface 47 2 0
    //   137: invokestatic 53	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   143: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   146: pop
    //   147: goto -32 -> 115
    //   150: astore 4
    //   152: aload_3
    //   153: astore_2
    //   154: aload_1
    //   155: astore_3
    //   156: aload 4
    //   158: astore_1
    //   159: aload_3
    //   160: ifnull +9 -> 169
    //   163: aload_3
    //   164: invokeinterface 63 1 0
    //   169: aload_2
    //   170: ifnull +9 -> 179
    //   173: aload_2
    //   174: invokeinterface 63 1 0
    //   179: aload_1
    //   180: athrow
    //   181: aload_3
    //   182: astore_2
    //   183: aload 5
    //   185: new 67	com/tencent/mobileqq/data/RecentUser
    //   188: dup
    //   189: invokespecial 68	com/tencent/mobileqq/data/RecentUser:<init>	()V
    //   192: invokevirtual 72	com/tencent/mobileqq/data/RecentUser:getTableName	()Ljava/lang/String;
    //   195: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   201: pop
    //   202: aload_3
    //   203: astore_2
    //   204: aload 5
    //   206: new 74	com/tencent/mobileqq/data/TroopAssistantData
    //   209: dup
    //   210: invokespecial 75	com/tencent/mobileqq/data/TroopAssistantData:<init>	()V
    //   213: invokevirtual 76	com/tencent/mobileqq/data/TroopAssistantData:getTableName	()Ljava/lang/String;
    //   216: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   222: pop
    //   223: aload_3
    //   224: astore_2
    //   225: aload 5
    //   227: new 78	com/tencent/mobileqq/data/PubAccountAssistantData
    //   230: dup
    //   231: invokespecial 79	com/tencent/mobileqq/data/PubAccountAssistantData:<init>	()V
    //   234: invokevirtual 80	com/tencent/mobileqq/data/PubAccountAssistantData:getTableName	()Ljava/lang/String;
    //   237: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   243: pop
    //   244: aload_3
    //   245: astore_2
    //   246: aload 5
    //   248: new 82	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   251: dup
    //   252: invokespecial 83	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:<init>	()V
    //   255: invokevirtual 84	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:getTableName	()Ljava/lang/String;
    //   258: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   264: pop
    //   265: aload_3
    //   266: astore_2
    //   267: aload 5
    //   269: new 86	com/tencent/mobileqq/data/NeedHandleUserData
    //   272: dup
    //   273: invokespecial 87	com/tencent/mobileqq/data/NeedHandleUserData:<init>	()V
    //   276: invokevirtual 88	com/tencent/mobileqq/data/NeedHandleUserData:getTableName	()Ljava/lang/String;
    //   279: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   285: pop
    //   286: aload_3
    //   287: astore_2
    //   288: aload 5
    //   290: new 90	com/tencent/mobileqq/data/ConversationInfo
    //   293: dup
    //   294: invokespecial 91	com/tencent/mobileqq/data/ConversationInfo:<init>	()V
    //   297: invokevirtual 92	com/tencent/mobileqq/data/ConversationInfo:getTableName	()Ljava/lang/String;
    //   300: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   306: pop
    //   307: aload_3
    //   308: astore_2
    //   309: aload 5
    //   311: ldc 94
    //   313: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   319: pop
    //   320: aload_3
    //   321: astore_2
    //   322: aload 5
    //   324: ldc 96
    //   326: invokestatic 57	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   329: invokevirtual 60	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   332: pop
    //   333: aload_3
    //   334: astore_2
    //   335: aload 4
    //   337: invokevirtual 97	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   340: aload_1
    //   341: ifnull +9 -> 350
    //   344: aload_1
    //   345: invokeinterface 63 1 0
    //   350: aload_3
    //   351: ifnull -343 -> 8
    //   354: aload_3
    //   355: invokeinterface 63 1 0
    //   360: return
    //   361: astore_1
    //   362: aconst_null
    //   363: astore_3
    //   364: aconst_null
    //   365: astore_2
    //   366: goto -207 -> 159
    //   369: astore 4
    //   371: aload_1
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_2
    //   375: aload 4
    //   377: astore_1
    //   378: goto -219 -> 159
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_1
    //   384: goto -305 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	MessageRecordManagerImpl
    //   0	387	1	paramString	java.lang.String
    //   1	374	2	localObject1	Object
    //   3	52	3	localObject2	Object
    //   78	23	3	localException	java.lang.Exception
    //   110	263	3	localObject3	Object
    //   17	3	4	localQQEntityManagerFactory	com.tencent.mobileqq.data.QQEntityManagerFactory
    //   150	186	4	localObject4	Object
    //   369	7	4	localObject5	Object
    //   28	295	5	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   45	54	78	java/lang/Exception
    //   56	75	78	java/lang/Exception
    //   102	111	78	java/lang/Exception
    //   117	126	78	java/lang/Exception
    //   128	147	78	java/lang/Exception
    //   183	202	78	java/lang/Exception
    //   204	223	78	java/lang/Exception
    //   225	244	78	java/lang/Exception
    //   246	265	78	java/lang/Exception
    //   267	286	78	java/lang/Exception
    //   288	307	78	java/lang/Exception
    //   309	320	78	java/lang/Exception
    //   322	333	78	java/lang/Exception
    //   335	340	78	java/lang/Exception
    //   117	126	150	finally
    //   128	147	150	finally
    //   183	202	150	finally
    //   204	223	150	finally
    //   225	244	150	finally
    //   246	265	150	finally
    //   267	286	150	finally
    //   288	307	150	finally
    //   309	320	150	finally
    //   322	333	150	finally
    //   335	340	150	finally
    //   30	39	361	finally
    //   45	54	369	finally
    //   56	75	369	finally
    //   102	111	369	finally
    //   30	39	381	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.MessageRecordManagerImpl
 * JD-Core Version:    0.7.0.1
 */