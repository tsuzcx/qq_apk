import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class acso
{
  private acsk jdField_a_of_type_Acsk;
  private akvb jdField_a_of_type_Akvb;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  
  private void I(String paramString, List<? extends Entity> paramList)
  {
    if (this.jdField_a_of_type_Acsk != null) {
      this.jdField_a_of_type_Acsk.F(paramString, paramList);
    }
  }
  
  private ArrayList<String> b(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = paramArrayOfString[i];
        if ((((String)localObject).endsWith("_New")) && ((((String)localObject).startsWith("mr_friend_")) || (((String)localObject).startsWith("mr_troop_")) || (((String)localObject).startsWith("mr_discusssion_")))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  /* Error */
  protected List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString, android.database.Cursor paramCursor, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   4: ifnull +437 -> 441
    //   7: aload_0
    //   8: getfield 60	acso:jdField_a_of_type_Akvb	Lakvb;
    //   11: ifnonnull +14 -> 25
    //   14: aload_0
    //   15: new 62	akvb
    //   18: dup
    //   19: invokespecial 63	akvb:<init>	()V
    //   22: putfield 60	acso:jdField_a_of_type_Akvb	Lakvb;
    //   25: aload_3
    //   26: ifnull +415 -> 441
    //   29: aload_3
    //   30: invokeinterface 69 1 0
    //   35: ifeq +406 -> 441
    //   38: aload_0
    //   39: getfield 60	acso:jdField_a_of_type_Akvb	Lakvb;
    //   42: aload_1
    //   43: aload_2
    //   44: aload_3
    //   45: invokevirtual 73	akvb:cursor2Entity	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   48: astore 8
    //   50: aload_0
    //   51: getfield 17	acso:jdField_a_of_type_Acsk	Lacsk;
    //   54: ifnull +15 -> 69
    //   57: aload_0
    //   58: getfield 17	acso:jdField_a_of_type_Acsk	Lacsk;
    //   61: aload_2
    //   62: aload 8
    //   64: invokeinterface 76 3 0
    //   69: aload_3
    //   70: invokeinterface 69 1 0
    //   75: ifeq +366 -> 441
    //   78: aload_3
    //   79: invokeinterface 80 1 0
    //   84: istore 4
    //   86: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +38 -> 127
    //   92: ldc 87
    //   94: iconst_2
    //   95: new 89	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   102: ldc 92
    //   104: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 98
    //   113: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 4
    //   118: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aconst_null
    //   128: astore 8
    //   130: aload 8
    //   132: astore 9
    //   134: iload 4
    //   136: istore 6
    //   138: aload 8
    //   140: astore 11
    //   142: aload_0
    //   143: getfield 60	acso:jdField_a_of_type_Akvb	Lakvb;
    //   146: ifnull +281 -> 427
    //   149: aload 8
    //   151: astore 9
    //   153: aload_0
    //   154: getfield 60	acso:jdField_a_of_type_Akvb	Lakvb;
    //   157: aload_1
    //   158: aload_2
    //   159: aload_3
    //   160: invokevirtual 73	akvb:cursor2Entity	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   163: astore 11
    //   165: iload 4
    //   167: istore 5
    //   169: aload 8
    //   171: astore 10
    //   173: aload 11
    //   175: ifnull +62 -> 237
    //   178: iload 4
    //   180: istore 5
    //   182: aload 8
    //   184: astore 10
    //   186: aload 8
    //   188: ifnonnull +35 -> 223
    //   191: iload 4
    //   193: istore 5
    //   195: iload 4
    //   197: sipush 1000
    //   200: if_icmple +8 -> 208
    //   203: sipush 1000
    //   206: istore 5
    //   208: aload 8
    //   210: astore 9
    //   212: new 28	java/util/ArrayList
    //   215: dup
    //   216: iload 5
    //   218: invokespecial 112	java/util/ArrayList:<init>	(I)V
    //   221: astore 10
    //   223: aload 10
    //   225: astore 9
    //   227: aload 10
    //   229: aload 11
    //   231: invokeinterface 115 2 0
    //   236: pop
    //   237: iload 5
    //   239: istore 6
    //   241: aload 10
    //   243: astore 11
    //   245: aload 10
    //   247: ifnull +180 -> 427
    //   250: aload 10
    //   252: astore 9
    //   254: iload 5
    //   256: istore 6
    //   258: aload 10
    //   260: astore 11
    //   262: aload 10
    //   264: invokeinterface 118 1 0
    //   269: sipush 1000
    //   272: if_icmpne +155 -> 427
    //   275: aload 10
    //   277: astore 9
    //   279: iload 5
    //   281: istore 6
    //   283: aload 10
    //   285: astore 11
    //   287: aload_0
    //   288: getfield 17	acso:jdField_a_of_type_Acsk	Lacsk;
    //   291: ifnull +136 -> 427
    //   294: aload 10
    //   296: astore 9
    //   298: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +32 -> 333
    //   304: aload 10
    //   306: astore 9
    //   308: ldc 87
    //   310: iconst_2
    //   311: new 89	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   318: ldc 120
    //   320: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 10
    //   335: astore 9
    //   337: aload_0
    //   338: aload_2
    //   339: aload 10
    //   341: invokespecial 122	acso:I	(Ljava/lang/String;Ljava/util/List;)V
    //   344: aload 10
    //   346: astore 9
    //   348: aload 10
    //   350: invokeinterface 125 1 0
    //   355: iload 5
    //   357: istore 4
    //   359: aconst_null
    //   360: astore 8
    //   362: aload_3
    //   363: invokeinterface 128 1 0
    //   368: istore 7
    //   370: iload 7
    //   372: ifne +66 -> 438
    //   375: aload 8
    //   377: astore_2
    //   378: aload_2
    //   379: areturn
    //   380: astore 9
    //   382: iload 5
    //   384: istore 4
    //   386: goto -24 -> 362
    //   389: astore_1
    //   390: aconst_null
    //   391: astore 8
    //   393: aload 8
    //   395: astore_2
    //   396: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -21 -> 378
    //   402: ldc 87
    //   404: iconst_2
    //   405: aload_1
    //   406: invokestatic 134	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   409: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload 8
    //   414: areturn
    //   415: astore_1
    //   416: aload 9
    //   418: astore 8
    //   420: goto -27 -> 393
    //   423: astore_1
    //   424: goto -31 -> 393
    //   427: aload 11
    //   429: astore 8
    //   431: iload 6
    //   433: istore 4
    //   435: goto -73 -> 362
    //   438: goto -308 -> 130
    //   441: aconst_null
    //   442: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	acso
    //   0	443	1	paramClass	Class<? extends Entity>
    //   0	443	2	paramString	String
    //   0	443	3	paramCursor	android.database.Cursor
    //   0	443	4	paramInt	int
    //   167	216	5	i	int
    //   136	296	6	j	int
    //   368	3	7	bool	boolean
    //   48	382	8	localObject1	Object
    //   132	215	9	localObject2	Object
    //   380	37	9	localThrowable	java.lang.Throwable
    //   171	178	10	localObject3	Object
    //   140	288	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   212	223	380	java/lang/Throwable
    //   7	25	389	java/lang/Exception
    //   29	69	389	java/lang/Exception
    //   69	127	389	java/lang/Exception
    //   142	149	415	java/lang/Exception
    //   153	165	415	java/lang/Exception
    //   212	223	415	java/lang/Exception
    //   227	237	415	java/lang/Exception
    //   262	275	415	java/lang/Exception
    //   287	294	415	java/lang/Exception
    //   298	304	415	java/lang/Exception
    //   308	333	415	java/lang/Exception
    //   337	344	415	java/lang/Exception
    //   348	355	415	java/lang/Exception
    //   362	370	423	java/lang/Exception
  }
  
  public List<MessageRecord> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
  
  /* Error */
  public List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 8
    //   8: astore 7
    //   10: aload_0
    //   11: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   14: ifnull +103 -> 117
    //   17: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 87
    //   25: iconst_2
    //   26: new 89	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   33: ldc 145
    //   35: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload 6
    //   50: iconst_1
    //   51: if_icmpne +69 -> 120
    //   54: aload_0
    //   55: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   58: invokevirtual 151	com/tencent/mobileqq/app/PeakAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   61: astore 7
    //   63: aload 7
    //   65: aload_2
    //   66: aload_3
    //   67: aload 4
    //   69: aload 5
    //   71: invokevirtual 157	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_2
    //   75: aload 9
    //   77: astore 4
    //   79: aload_2
    //   80: ifnull +19 -> 99
    //   83: aload_2
    //   84: astore 4
    //   86: aload_0
    //   87: aload_1
    //   88: aload_3
    //   89: aload_2
    //   90: iload 6
    //   92: invokevirtual 159	acso:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;I)Ljava/util/List;
    //   95: astore_1
    //   96: aload_1
    //   97: astore 4
    //   99: aload 4
    //   101: astore 7
    //   103: aload_2
    //   104: ifnull +13 -> 117
    //   107: aload_2
    //   108: invokeinterface 162 1 0
    //   113: aload 4
    //   115: astore 7
    //   117: aload 7
    //   119: areturn
    //   120: iload 6
    //   122: iconst_2
    //   123: if_icmpne +15 -> 138
    //   126: aload_0
    //   127: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   130: invokevirtual 164	com/tencent/mobileqq/app/PeakAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   133: astore 7
    //   135: goto -72 -> 63
    //   138: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +29 -> 170
    //   144: ldc 87
    //   146: iconst_2
    //   147: new 89	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   154: ldc 166
    //   156: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 6
    //   161: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 8
    //   172: astore 7
    //   174: iconst_0
    //   175: ifeq -58 -> 117
    //   178: new 168	java/lang/NullPointerException
    //   181: dup
    //   182: invokespecial 169	java/lang/NullPointerException:<init>	()V
    //   185: athrow
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_2
    //   189: aload_2
    //   190: astore 4
    //   192: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +16 -> 211
    //   198: aload_2
    //   199: astore 4
    //   201: ldc 87
    //   203: iconst_2
    //   204: aload_1
    //   205: invokestatic 134	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   208: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 8
    //   213: astore 7
    //   215: aload_2
    //   216: ifnull -99 -> 117
    //   219: aload_2
    //   220: invokeinterface 162 1 0
    //   225: aconst_null
    //   226: areturn
    //   227: astore_1
    //   228: aconst_null
    //   229: astore 4
    //   231: aload 4
    //   233: ifnull +10 -> 243
    //   236: aload 4
    //   238: invokeinterface 162 1 0
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: goto -15 -> 231
    //   249: astore_1
    //   250: goto -61 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	acso
    //   0	253	1	paramClass	Class<? extends Entity>
    //   0	253	2	paramString1	String
    //   0	253	3	paramString2	String
    //   0	253	4	paramString3	String
    //   0	253	5	paramArrayOfString	String[]
    //   0	253	6	paramInt	int
    //   8	206	7	localObject1	Object
    //   1	211	8	localObject2	Object
    //   4	72	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	48	186	java/lang/Exception
    //   54	63	186	java/lang/Exception
    //   63	75	186	java/lang/Exception
    //   126	135	186	java/lang/Exception
    //   138	170	186	java/lang/Exception
    //   17	48	227	finally
    //   54	63	227	finally
    //   63	75	227	finally
    //   126	135	227	finally
    //   138	170	227	finally
    //   86	96	245	finally
    //   192	198	245	finally
    //   201	211	245	finally
    //   86	96	249	java/lang/Exception
  }
  
  public List<RecentUser> a(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.b().rawQuery(paramClass, paramString, paramArrayOfString);
      if (paramString != null)
      {
        paramClass = paramString;
        if (!paramString.isEmpty()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getRecentUserList list is empty");
        }
        paramClass = null;
      }
      return paramClass;
    }
    return null;
  }
  
  public void a(acsk paramacsk)
  {
    this.jdField_a_of_type_Acsk = paramacsk;
  }
  
  public List<MessageRecord> b(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableRecord");
    }
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 2);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
  
  public List<MessageRecord> c(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMultiMessage");
    }
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
  
  /* Error */
  public void c(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: new 89	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   18: ldc 202
    //   20: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   27: invokevirtual 205	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   30: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   33: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 220	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   42: iconst_3
    //   43: anewarray 33	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 222
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc 224
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: ldc 226
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokestatic 232	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 8
    //   69: aload 8
    //   71: ifnull +105 -> 176
    //   74: aload 8
    //   76: astore 7
    //   78: aload 8
    //   80: invokeinterface 69 1 0
    //   85: ifeq +91 -> 176
    //   88: aload 8
    //   90: astore 7
    //   92: aload 8
    //   94: ldc 222
    //   96: invokeinterface 236 2 0
    //   101: istore_3
    //   102: aload 8
    //   104: astore 7
    //   106: aload 8
    //   108: ldc 224
    //   110: invokeinterface 236 2 0
    //   115: istore 4
    //   117: aload 8
    //   119: astore 7
    //   121: aload 8
    //   123: ldc 226
    //   125: invokeinterface 236 2 0
    //   130: istore 5
    //   132: aload 8
    //   134: astore 7
    //   136: aload 8
    //   138: iload_3
    //   139: invokeinterface 240 2 0
    //   144: astore 9
    //   146: aload 8
    //   148: astore 7
    //   150: aload 9
    //   152: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifeq +34 -> 189
    //   158: aload 8
    //   160: astore 7
    //   162: aload 8
    //   164: invokeinterface 128 1 0
    //   169: istore 6
    //   171: iload 6
    //   173: ifne -41 -> 132
    //   176: aload 8
    //   178: ifnull -174 -> 4
    //   181: aload 8
    //   183: invokeinterface 162 1 0
    //   188: return
    //   189: aload 8
    //   191: astore 7
    //   193: new 33	java/lang/String
    //   196: dup
    //   197: aload 9
    //   199: invokevirtual 249	java/lang/String:getBytes	()[B
    //   202: ldc 251
    //   204: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   207: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 11
    //   212: aload 8
    //   214: astore 7
    //   216: aload 8
    //   218: iload 4
    //   220: invokeinterface 240 2 0
    //   225: astore 9
    //   227: aload 8
    //   229: astore 7
    //   231: aload 9
    //   233: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifne +124 -> 360
    //   239: aload 8
    //   241: astore 7
    //   243: new 33	java/lang/String
    //   246: dup
    //   247: aload 9
    //   249: invokevirtual 249	java/lang/String:getBytes	()[B
    //   252: ldc 251
    //   254: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   260: astore 9
    //   262: aload 8
    //   264: astore 7
    //   266: aload_2
    //   267: new 89	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   274: aload 11
    //   276: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload_1
    //   280: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: aload 9
    //   288: invokevirtual 266	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: goto -134 -> 158
    //   295: astore_2
    //   296: aload 8
    //   298: astore 7
    //   300: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +36 -> 339
    //   306: aload 8
    //   308: astore 7
    //   310: ldc 87
    //   312: iconst_2
    //   313: new 89	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 268
    //   323: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload 8
    //   341: astore 7
    //   343: aload_2
    //   344: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   347: aload 8
    //   349: ifnull -345 -> 4
    //   352: aload 8
    //   354: invokeinterface 162 1 0
    //   359: return
    //   360: aload 8
    //   362: astore 7
    //   364: aload 8
    //   366: iload 5
    //   368: invokeinterface 240 2 0
    //   373: astore 9
    //   375: aload 8
    //   377: astore 7
    //   379: aload 9
    //   381: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   384: ifne -226 -> 158
    //   387: aload 8
    //   389: astore 7
    //   391: new 33	java/lang/String
    //   394: dup
    //   395: aload 9
    //   397: invokevirtual 249	java/lang/String:getBytes	()[B
    //   400: ldc 251
    //   402: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   405: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   408: astore 10
    //   410: aload 10
    //   412: astore 9
    //   414: aload 8
    //   416: astore 7
    //   418: aload 10
    //   420: invokevirtual 277	java/lang/String:length	()I
    //   423: iconst_1
    //   424: if_icmple +47 -> 471
    //   427: aload 10
    //   429: astore 9
    //   431: aload 8
    //   433: astore 7
    //   435: aload 10
    //   437: aload 10
    //   439: invokevirtual 277	java/lang/String:length	()I
    //   442: iconst_1
    //   443: isub
    //   444: invokevirtual 281	java/lang/String:charAt	(I)C
    //   447: bipush 10
    //   449: if_icmpne +22 -> 471
    //   452: aload 8
    //   454: astore 7
    //   456: aload 10
    //   458: iconst_0
    //   459: aload 10
    //   461: invokevirtual 277	java/lang/String:length	()I
    //   464: iconst_1
    //   465: isub
    //   466: invokevirtual 285	java/lang/String:substring	(II)Ljava/lang/String;
    //   469: astore 9
    //   471: aload 8
    //   473: astore 7
    //   475: aload_2
    //   476: new 89	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   483: aload 11
    //   485: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload_1
    //   489: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: aload 9
    //   497: invokevirtual 266	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: goto -343 -> 158
    //   504: astore_2
    //   505: aload 7
    //   507: ifnull +10 -> 517
    //   510: aload 7
    //   512: invokeinterface 162 1 0
    //   517: aload_2
    //   518: athrow
    //   519: astore_2
    //   520: aconst_null
    //   521: astore 7
    //   523: goto -18 -> 505
    //   526: astore_2
    //   527: aconst_null
    //   528: astore 8
    //   530: goto -234 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	acso
    //   0	533	1	paramInt	int
    //   0	533	2	paramHashMap	java.util.HashMap<String, String>
    //   101	38	3	i	int
    //   115	104	4	j	int
    //   130	237	5	k	int
    //   169	3	6	bool	boolean
    //   76	446	7	localCursor1	android.database.Cursor
    //   67	462	8	localCursor2	android.database.Cursor
    //   144	352	9	localObject	Object
    //   408	52	10	str1	String
    //   210	274	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   78	88	295	java/lang/Throwable
    //   92	102	295	java/lang/Throwable
    //   106	117	295	java/lang/Throwable
    //   121	132	295	java/lang/Throwable
    //   136	146	295	java/lang/Throwable
    //   150	158	295	java/lang/Throwable
    //   162	171	295	java/lang/Throwable
    //   193	212	295	java/lang/Throwable
    //   216	227	295	java/lang/Throwable
    //   231	239	295	java/lang/Throwable
    //   243	262	295	java/lang/Throwable
    //   266	292	295	java/lang/Throwable
    //   364	375	295	java/lang/Throwable
    //   379	387	295	java/lang/Throwable
    //   391	410	295	java/lang/Throwable
    //   418	427	295	java/lang/Throwable
    //   435	452	295	java/lang/Throwable
    //   456	471	295	java/lang/Throwable
    //   475	501	295	java/lang/Throwable
    //   78	88	504	finally
    //   92	102	504	finally
    //   106	117	504	finally
    //   121	132	504	finally
    //   136	146	504	finally
    //   150	158	504	finally
    //   162	171	504	finally
    //   193	212	504	finally
    //   216	227	504	finally
    //   231	239	504	finally
    //   243	262	504	finally
    //   266	292	504	finally
    //   300	306	504	finally
    //   310	339	504	finally
    //   343	347	504	finally
    //   364	375	504	finally
    //   379	387	504	finally
    //   391	410	504	finally
    //   418	427	504	finally
    //   435	452	504	finally
    //   456	471	504	finally
    //   475	501	504	finally
    //   5	69	519	finally
    //   5	69	526	java/lang/Throwable
  }
  
  public ArrayList<String> cG()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageTableNames");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      try
      {
        ArrayList localArrayList = b(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getReadableDatabase().getAllTableNameFromDB());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getMessageTableNames exception = " + localException.getMessage());
        }
      }
    }
    return null;
  }
  
  public ArrayList<String> cH()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableNames");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      try
      {
        ArrayList localArrayList = b(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a().getAllTableNameFromDB());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getMessageSlowTableNames exception = " + localException.getMessage());
        }
      }
    }
    return null;
  }
  
  /* Error */
  public void d(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: new 89	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 308
    //   21: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   28: invokevirtual 205	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   31: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   34: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 220	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: iconst_2
    //   44: anewarray 33	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 310
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 312
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokestatic 232	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnull +92 -> 161
    //   72: aload 7
    //   74: astore 6
    //   76: aload 7
    //   78: invokeinterface 69 1 0
    //   83: ifeq +78 -> 161
    //   86: aload 7
    //   88: astore 6
    //   90: aload 7
    //   92: ldc_w 310
    //   95: invokeinterface 236 2 0
    //   100: istore_3
    //   101: aload 7
    //   103: astore 6
    //   105: aload 7
    //   107: ldc_w 312
    //   110: invokeinterface 236 2 0
    //   115: istore 4
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: iload_3
    //   124: invokeinterface 240 2 0
    //   129: astore 8
    //   131: aload 7
    //   133: astore 6
    //   135: aload 8
    //   137: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifeq +34 -> 174
    //   143: aload 7
    //   145: astore 6
    //   147: aload 7
    //   149: invokeinterface 128 1 0
    //   154: istore 5
    //   156: iload 5
    //   158: ifne -41 -> 117
    //   161: aload 7
    //   163: ifnull -159 -> 4
    //   166: aload 7
    //   168: invokeinterface 162 1 0
    //   173: return
    //   174: aload 7
    //   176: astore 6
    //   178: new 33	java/lang/String
    //   181: dup
    //   182: aload 8
    //   184: invokevirtual 249	java/lang/String:getBytes	()[B
    //   187: ldc 251
    //   189: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   192: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 7
    //   199: astore 6
    //   201: aload 7
    //   203: iload 4
    //   205: invokeinterface 240 2 0
    //   210: astore 9
    //   212: aload 7
    //   214: astore 6
    //   216: aload 9
    //   218: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne -78 -> 143
    //   224: aload 7
    //   226: astore 6
    //   228: new 33	java/lang/String
    //   231: dup
    //   232: aload 9
    //   234: invokevirtual 249	java/lang/String:getBytes	()[B
    //   237: ldc 251
    //   239: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   242: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 9
    //   247: aload 7
    //   249: astore 6
    //   251: aload_2
    //   252: new 89	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   259: aload 8
    //   261: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload_1
    //   265: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aload 9
    //   273: invokevirtual 266	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: goto -134 -> 143
    //   280: astore_2
    //   281: aload 7
    //   283: astore 6
    //   285: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +36 -> 324
    //   291: aload 7
    //   293: astore 6
    //   295: ldc 87
    //   297: iconst_2
    //   298: new 89	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 314
    //   308: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore 6
    //   328: aload_2
    //   329: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   332: aload 7
    //   334: ifnull -330 -> 4
    //   337: aload 7
    //   339: invokeinterface 162 1 0
    //   344: return
    //   345: astore_2
    //   346: aconst_null
    //   347: astore 6
    //   349: aload 6
    //   351: ifnull +10 -> 361
    //   354: aload 6
    //   356: invokeinterface 162 1 0
    //   361: aload_2
    //   362: athrow
    //   363: astore_2
    //   364: goto -15 -> 349
    //   367: astore_2
    //   368: aconst_null
    //   369: astore 7
    //   371: goto -90 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	acso
    //   0	374	1	paramInt	int
    //   0	374	2	paramHashMap	java.util.HashMap<String, String>
    //   100	24	3	i	int
    //   115	89	4	j	int
    //   154	3	5	bool	boolean
    //   74	281	6	localCursor1	android.database.Cursor
    //   65	305	7	localCursor2	android.database.Cursor
    //   129	131	8	str1	String
    //   210	62	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   76	86	280	java/lang/Throwable
    //   90	101	280	java/lang/Throwable
    //   105	117	280	java/lang/Throwable
    //   121	131	280	java/lang/Throwable
    //   135	143	280	java/lang/Throwable
    //   147	156	280	java/lang/Throwable
    //   178	197	280	java/lang/Throwable
    //   201	212	280	java/lang/Throwable
    //   216	224	280	java/lang/Throwable
    //   228	247	280	java/lang/Throwable
    //   251	277	280	java/lang/Throwable
    //   5	67	345	finally
    //   76	86	363	finally
    //   90	101	363	finally
    //   105	117	363	finally
    //   121	131	363	finally
    //   135	143	363	finally
    //   147	156	363	finally
    //   178	197	363	finally
    //   201	212	363	finally
    //   216	224	363	finally
    //   228	247	363	finally
    //   251	277	363	finally
    //   285	291	363	finally
    //   295	324	363	finally
    //   328	332	363	finally
    //   5	67	367	java/lang/Throwable
  }
  
  public AppInterface getAppInterface()
  {
    AppInterface localAppInterface = QQStoryContext.c();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  }
  
  /* Error */
  public String getDiscussMemberName(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +9 -> 20
    //   14: ldc_w 324
    //   17: astore_3
    //   18: aload_3
    //   19: areturn
    //   20: new 89	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 326
    //   30: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   37: invokevirtual 205	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc_w 328
    //   49: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 328
    //   59: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_2
    //   63: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 220	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   72: astore_1
    //   73: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   76: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   79: aload_1
    //   80: iconst_2
    //   81: anewarray 33	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: ldc_w 330
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: ldc_w 332
    //   95: aastore
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokestatic 232	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +216 -> 320
    //   107: aload_2
    //   108: astore_1
    //   109: aload_2
    //   110: invokeinterface 69 1 0
    //   115: ifeq +205 -> 320
    //   118: aload_2
    //   119: astore_1
    //   120: aload_2
    //   121: aload_2
    //   122: ldc_w 332
    //   125: invokeinterface 236 2 0
    //   130: invokeinterface 240 2 0
    //   135: astore_3
    //   136: aload_2
    //   137: astore_1
    //   138: aload_3
    //   139: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +38 -> 180
    //   145: aload_2
    //   146: astore_1
    //   147: new 33	java/lang/String
    //   150: dup
    //   151: aload_3
    //   152: invokevirtual 249	java/lang/String:getBytes	()[B
    //   155: ldc 251
    //   157: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   160: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_3
    //   164: aload_3
    //   165: astore_1
    //   166: aload_1
    //   167: astore_3
    //   168: aload_2
    //   169: ifnull -151 -> 18
    //   172: aload_2
    //   173: invokeinterface 162 1 0
    //   178: aload_1
    //   179: areturn
    //   180: aload_2
    //   181: astore_1
    //   182: aload_2
    //   183: aload_2
    //   184: ldc_w 330
    //   187: invokeinterface 236 2 0
    //   192: invokeinterface 240 2 0
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: aload_3
    //   201: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +116 -> 320
    //   207: aload_2
    //   208: astore_1
    //   209: new 33	java/lang/String
    //   212: dup
    //   213: aload_3
    //   214: invokevirtual 249	java/lang/String:getBytes	()[B
    //   217: ldc 251
    //   219: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   222: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_3
    //   226: aload_3
    //   227: astore_1
    //   228: goto -62 -> 166
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aload_2
    //   235: astore_1
    //   236: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +34 -> 273
    //   242: aload_2
    //   243: astore_1
    //   244: ldc 87
    //   246: iconst_2
    //   247: new 89	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 334
    //   257: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_3
    //   261: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_2
    //   274: astore_1
    //   275: aload_3
    //   276: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   279: aload_2
    //   280: ifnull +36 -> 316
    //   283: aload_2
    //   284: invokeinterface 162 1 0
    //   289: ldc_w 324
    //   292: areturn
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +9 -> 306
    //   300: aload_1
    //   301: invokeinterface 162 1 0
    //   306: aload_2
    //   307: athrow
    //   308: astore_2
    //   309: goto -13 -> 296
    //   312: astore_3
    //   313: goto -79 -> 234
    //   316: ldc_w 324
    //   319: areturn
    //   320: ldc_w 324
    //   323: astore_1
    //   324: goto -158 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	acso
    //   0	327	1	paramString1	String
    //   0	327	2	paramString2	String
    //   17	210	3	str	String
    //   231	45	3	localThrowable1	java.lang.Throwable
    //   312	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   20	103	231	java/lang/Throwable
    //   20	103	293	finally
    //   109	118	308	finally
    //   120	136	308	finally
    //   138	145	308	finally
    //   147	164	308	finally
    //   182	198	308	finally
    //   200	207	308	finally
    //   209	226	308	finally
    //   236	242	308	finally
    //   244	273	308	finally
    //   275	279	308	finally
    //   109	118	312	java/lang/Throwable
    //   120	136	312	java/lang/Throwable
    //   138	145	312	java/lang/Throwable
    //   147	164	312	java/lang/Throwable
    //   182	198	312	java/lang/Throwable
    //   200	207	312	java/lang/Throwable
    //   209	226	312	java/lang/Throwable
  }
  
  /* Error */
  public String jB(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: ldc_w 324
    //   10: astore_3
    //   11: aload_3
    //   12: areturn
    //   13: new 89	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 337
    //   23: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 58	acso:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   30: invokevirtual 205	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   33: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: ldc_w 328
    //   42: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 220	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   55: astore_1
    //   56: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   59: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   62: aload_1
    //   63: iconst_1
    //   64: anewarray 33	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc_w 339
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokestatic 232	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +165 -> 246
    //   84: aload_1
    //   85: astore_2
    //   86: aload_1
    //   87: invokeinterface 69 1 0
    //   92: ifeq +154 -> 246
    //   95: aload_1
    //   96: astore_2
    //   97: aload_1
    //   98: aload_1
    //   99: ldc_w 339
    //   102: invokeinterface 236 2 0
    //   107: invokeinterface 240 2 0
    //   112: astore_3
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +127 -> 246
    //   122: aload_1
    //   123: astore_2
    //   124: new 33	java/lang/String
    //   127: dup
    //   128: aload_3
    //   129: invokevirtual 249	java/lang/String:getBytes	()[B
    //   132: ldc 251
    //   134: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   137: invokestatic 260	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore_3
    //   141: aload_3
    //   142: astore_2
    //   143: aload_2
    //   144: astore_3
    //   145: aload_1
    //   146: ifnull -135 -> 11
    //   149: aload_1
    //   150: invokeinterface 162 1 0
    //   155: aload_2
    //   156: areturn
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: astore_2
    //   162: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +34 -> 199
    //   168: aload_1
    //   169: astore_2
    //   170: ldc 87
    //   172: iconst_2
    //   173: new 89	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 341
    //   183: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_1
    //   200: astore_2
    //   201: aload_3
    //   202: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   205: aload_1
    //   206: ifnull +36 -> 242
    //   209: aload_1
    //   210: invokeinterface 162 1 0
    //   215: ldc_w 324
    //   218: areturn
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +9 -> 232
    //   226: aload_2
    //   227: invokeinterface 162 1 0
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: goto -13 -> 222
    //   238: astore_3
    //   239: goto -79 -> 160
    //   242: ldc_w 324
    //   245: areturn
    //   246: ldc_w 324
    //   249: astore_2
    //   250: goto -107 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	acso
    //   0	253	1	paramString	String
    //   85	165	2	localObject1	Object
    //   10	135	3	localObject2	Object
    //   157	45	3	localThrowable1	java.lang.Throwable
    //   238	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   13	80	157	java/lang/Throwable
    //   13	80	219	finally
    //   86	95	234	finally
    //   97	113	234	finally
    //   115	122	234	finally
    //   124	141	234	finally
    //   162	168	234	finally
    //   170	199	234	finally
    //   201	205	234	finally
    //   86	95	238	java/lang/Throwable
    //   97	113	238	java/lang/Throwable
    //   115	122	238	java/lang/Throwable
    //   124	141	238	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    a(null);
    if (this.jdField_a_of_type_Akvb != null)
    {
      this.jdField_a_of_type_Akvb.clean();
      this.jdField_a_of_type_Akvb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acso
 * JD-Core Version:    0.7.0.1
 */