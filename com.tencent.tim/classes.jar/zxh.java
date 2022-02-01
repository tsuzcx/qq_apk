import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class zxh
{
  private zxg jdField_a_of_type_Zxg;
  private zxj jdField_a_of_type_Zxj;
  private SQLiteDatabase i;
  private Context mContext;
  private String mUin;
  
  public zxh(zxj paramzxj)
  {
    this.jdField_a_of_type_Zxg = new zxg(paramzxj.mContext, paramzxj.mUin);
    this.mContext = paramzxj.mContext;
    this.mUin = paramzxj.mUin;
    this.jdField_a_of_type_Zxj = paramzxj;
  }
  
  /* Error */
  public java.util.HashMap<String, String> B()
  {
    // Byte code:
    //   0: new 42	java/util/HashMap
    //   3: dup
    //   4: invokespecial 43	java/util/HashMap:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 31	zxh:jdField_a_of_type_Zxg	Lzxg;
    //   14: invokevirtual 47	zxg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 51
    //   26: iconst_4
    //   27: anewarray 53	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 55
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 57
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 59
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 61
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +239 -> 301
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 55
    //   73: invokeinterface 73 2 0
    //   78: istore_1
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ldc 57
    //   87: invokeinterface 73 2 0
    //   92: istore_2
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: ldc 59
    //   101: invokeinterface 73 2 0
    //   106: istore_3
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ldc 61
    //   115: invokeinterface 73 2 0
    //   120: istore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload 6
    //   128: invokeinterface 77 1 0
    //   133: ifeq +168 -> 301
    //   136: aload 6
    //   138: astore 5
    //   140: new 79	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 6
    //   151: astore 5
    //   153: aload 8
    //   155: aload 6
    //   157: iload_3
    //   158: invokeinterface 84 2 0
    //   163: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 8
    //   173: ldc 90
    //   175: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore 5
    //   183: aload 8
    //   185: aload 6
    //   187: iload_2
    //   188: invokeinterface 84 2 0
    //   193: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 8
    //   203: ldc 90
    //   205: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: astore 5
    //   213: aload 8
    //   215: aload 6
    //   217: iload_1
    //   218: invokeinterface 84 2 0
    //   223: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 6
    //   229: astore 5
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: iload 4
    //   242: invokeinterface 84 2 0
    //   247: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -129 -> 122
    //   254: astore 7
    //   256: aload 6
    //   258: astore 5
    //   260: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +15 -> 278
    //   266: aload 6
    //   268: astore 5
    //   270: ldc 105
    //   272: iconst_2
    //   273: ldc 107
    //   275: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload 6
    //   280: astore 5
    //   282: aload 7
    //   284: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   287: aload 6
    //   289: ifnull +60 -> 349
    //   292: aload 6
    //   294: invokeinterface 117 1 0
    //   299: aconst_null
    //   300: areturn
    //   301: aload 6
    //   303: ifnull +48 -> 351
    //   306: aload 6
    //   308: invokeinterface 117 1 0
    //   313: aload 7
    //   315: areturn
    //   316: astore 6
    //   318: aconst_null
    //   319: astore 5
    //   321: aload 5
    //   323: ifnull +10 -> 333
    //   326: aload 5
    //   328: invokeinterface 117 1 0
    //   333: aload 6
    //   335: athrow
    //   336: astore 6
    //   338: goto -17 -> 321
    //   341: astore 7
    //   343: aconst_null
    //   344: astore 6
    //   346: goto -90 -> 256
    //   349: aconst_null
    //   350: areturn
    //   351: aload 7
    //   353: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	zxh
    //   78	140	1	j	int
    //   92	96	2	k	int
    //   106	52	3	m	int
    //   120	121	4	n	int
    //   67	260	5	localCursor1	android.database.Cursor
    //   58	249	6	localCursor2	android.database.Cursor
    //   316	18	6	localObject1	Object
    //   336	1	6	localObject2	Object
    //   344	1	6	localObject3	Object
    //   7	225	7	localHashMap	java.util.HashMap
    //   254	60	7	localThrowable1	Throwable
    //   341	11	7	localThrowable2	Throwable
    //   147	87	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	79	254	java/lang/Throwable
    //   83	93	254	java/lang/Throwable
    //   97	107	254	java/lang/Throwable
    //   111	122	254	java/lang/Throwable
    //   126	136	254	java/lang/Throwable
    //   140	149	254	java/lang/Throwable
    //   153	167	254	java/lang/Throwable
    //   171	179	254	java/lang/Throwable
    //   183	197	254	java/lang/Throwable
    //   201	209	254	java/lang/Throwable
    //   213	227	254	java/lang/Throwable
    //   231	251	254	java/lang/Throwable
    //   9	60	316	finally
    //   69	79	336	finally
    //   83	93	336	finally
    //   97	107	336	finally
    //   111	122	336	finally
    //   126	136	336	finally
    //   140	149	336	finally
    //   153	167	336	finally
    //   171	179	336	finally
    //   183	197	336	finally
    //   201	209	336	finally
    //   213	227	336	finally
    //   231	251	336	finally
    //   260	266	336	finally
    //   270	278	336	finally
    //   282	287	336	finally
    //   9	60	341	java/lang/Throwable
  }
  
  /* Error */
  public java.util.List<zxr> F(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 125	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 126	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 31	zxh:jdField_a_of_type_Zxg	Lzxg;
    //   17: invokevirtual 47	zxg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: putfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_0
    //   24: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 4
    //   29: new 79	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   36: iload_1
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc 131
    //   42: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 6
    //   50: aload 4
    //   52: ldc 133
    //   54: iconst_2
    //   55: anewarray 53	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 57
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc 135
    //   67: aastore
    //   68: ldc 137
    //   70: iconst_1
    //   71: anewarray 53	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload 6
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 4
    //   87: aload 4
    //   89: astore 5
    //   91: aload 5
    //   93: ifnull +167 -> 260
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: ldc 57
    //   104: invokeinterface 73 2 0
    //   109: istore_2
    //   110: aload 5
    //   112: astore 4
    //   114: aload 5
    //   116: ldc 135
    //   118: invokeinterface 73 2 0
    //   123: istore_3
    //   124: aload 5
    //   126: astore 4
    //   128: aload 5
    //   130: invokeinterface 77 1 0
    //   135: ifeq +125 -> 260
    //   138: aload 5
    //   140: astore 4
    //   142: new 139	zxr
    //   145: dup
    //   146: invokespecial 140	zxr:<init>	()V
    //   149: astore 6
    //   151: aload 5
    //   153: astore 4
    //   155: aload 6
    //   157: iload_1
    //   158: putfield 143	zxr:source	I
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: aload 5
    //   169: iload_2
    //   170: invokeinterface 147 2 0
    //   175: putfield 151	zxr:LE	J
    //   178: aload 5
    //   180: astore 4
    //   182: aload 6
    //   184: aload 5
    //   186: iload_3
    //   187: invokeinterface 147 2 0
    //   192: putfield 154	zxr:lastUpdateTime	J
    //   195: aload 5
    //   197: astore 4
    //   199: aload 7
    //   201: aload 6
    //   203: invokeinterface 160 2 0
    //   208: pop
    //   209: goto -85 -> 124
    //   212: astore 6
    //   214: aload 5
    //   216: astore 4
    //   218: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +15 -> 236
    //   224: aload 5
    //   226: astore 4
    //   228: ldc 105
    //   230: iconst_2
    //   231: ldc 162
    //   233: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 5
    //   238: astore 4
    //   240: aload 6
    //   242: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokeinterface 117 1 0
    //   257: aload 7
    //   259: areturn
    //   260: aload 5
    //   262: ifnull -5 -> 257
    //   265: aload 5
    //   267: invokeinterface 117 1 0
    //   272: aload 7
    //   274: areturn
    //   275: astore 4
    //   277: aload 5
    //   279: ifnull +10 -> 289
    //   282: aload 5
    //   284: invokeinterface 117 1 0
    //   289: aload 4
    //   291: athrow
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 6
    //   300: astore 4
    //   302: goto -25 -> 277
    //   305: astore 6
    //   307: aconst_null
    //   308: astore 5
    //   310: goto -96 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	zxh
    //   0	313	1	paramInt	int
    //   109	61	2	j	int
    //   123	64	3	k	int
    //   27	212	4	localObject1	Object
    //   275	20	4	localObject2	Object
    //   300	1	4	localObject3	Object
    //   1	308	5	localObject4	Object
    //   48	154	6	localObject5	Object
    //   212	29	6	localException1	Exception
    //   292	7	6	localObject6	Object
    //   305	1	6	localException2	Exception
    //   10	263	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   100	110	212	java/lang/Exception
    //   114	124	212	java/lang/Exception
    //   128	138	212	java/lang/Exception
    //   142	151	212	java/lang/Exception
    //   155	161	212	java/lang/Exception
    //   165	178	212	java/lang/Exception
    //   182	195	212	java/lang/Exception
    //   199	209	212	java/lang/Exception
    //   12	87	275	finally
    //   100	110	292	finally
    //   114	124	292	finally
    //   128	138	292	finally
    //   142	151	292	finally
    //   155	161	292	finally
    //   165	178	292	finally
    //   182	195	292	finally
    //   199	209	292	finally
    //   218	224	292	finally
    //   228	236	292	finally
    //   240	245	292	finally
    //   12	87	305	java/lang/Exception
  }
  
  public void a(zxi paramzxi)
  {
    int k = 1;
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramzxi.redBagId);
      localContentValues.put("redbag_index", paramzxi.redBagIndex);
      localContentValues.put("uint64_creator_uin", paramzxi.baZ);
      localContentValues.put("expire_time", Long.valueOf(paramzxi.expireTime));
      localContentValues.put("password", paramzxi.bba);
      if (paramzxi.isOpen)
      {
        j = 1;
        localContentValues.put("is_open", Integer.valueOf(j));
        if (!paramzxi.isFinish) {
          break label195;
        }
        j = 1;
        label109:
        localContentValues.put("is_finish", Integer.valueOf(j));
        if (!paramzxi.bul) {
          break label200;
        }
      }
      label195:
      label200:
      for (int j = k;; j = 0)
      {
        localContentValues.put("is_overdue", Integer.valueOf(j));
        localContentValues.put("redbag_type", Integer.valueOf(paramzxi.type));
        localContentValues.put("last_password", paramzxi.bbb);
        localContentValues.put("ext_str", paramzxi.extStr);
        this.i.replace("red_bags", null, localContentValues);
        return;
        j = 0;
        break;
        j = 0;
        break label109;
      }
      return;
    }
    catch (Exception paramzxi)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBag failed ");
      }
      paramzxi.printStackTrace();
    }
  }
  
  public void al(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("last_password", paramString2);
      localContentValues.put("ext_str", paramString3);
      int j = this.i.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString1 });
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setLastPasswd success result " + j);
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setLastPasswd failed " + paramString1);
      }
      paramString1.printStackTrace();
    }
  }
  
  public void bj(String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "setOpen|id: " + paramString + " isOpen: " + paramBoolean);
    }
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_open", Integer.valueOf(j));
        j = this.i.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "setOpen result " + j);
        }
        return;
        j = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOpen failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  public void bk(String paramString, boolean paramBoolean)
  {
    int j = 1;
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_finish", Integer.valueOf(j));
        j = this.i.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "setFinish result " + j);
        }
        return;
        j = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setFinish failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  public void bl(String paramString, boolean paramBoolean)
  {
    int j = 1;
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_overdue", Integer.valueOf(j));
        this.i.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        j = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOverDue failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  public void csi()
  {
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.i.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "clearExpirePasswdRedBag failed ");
      }
      localException.printStackTrace();
    }
  }
  
  /* Error */
  public void csj()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 23
    //   6: aload_0
    //   7: getfield 32	zxh:mContext	Landroid/content/Context;
    //   10: ldc_w 311
    //   13: invokevirtual 317	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore 24
    //   18: aload 24
    //   20: invokevirtual 322	java/io/File:exists	()Z
    //   23: istore 20
    //   25: iload 20
    //   27: ifne +28 -> 55
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 324	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 325	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 324	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 325	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: return
    //   55: aload 24
    //   57: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aconst_null
    //   61: iconst_0
    //   62: invokestatic 332	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 24
    //   67: aload 24
    //   69: astore 22
    //   71: aload 22
    //   73: ifnonnull +26 -> 99
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 324	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 325	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: aload 22
    //   90: ifnull -36 -> 54
    //   93: aload 22
    //   95: invokevirtual 333	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: return
    //   99: aload 22
    //   101: ldc_w 335
    //   104: iconst_1
    //   105: anewarray 53	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: getfield 33	zxh:mUin	Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 339	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 24
    //   120: aload 24
    //   122: ifnull +405 -> 527
    //   125: aload 24
    //   127: ldc 55
    //   129: invokeinterface 73 2 0
    //   134: istore 4
    //   136: aload 24
    //   138: ldc 178
    //   140: invokeinterface 73 2 0
    //   145: istore 8
    //   147: aload 24
    //   149: ldc 183
    //   151: invokeinterface 73 2 0
    //   156: istore 12
    //   158: aload 24
    //   160: ldc 188
    //   162: invokeinterface 73 2 0
    //   167: istore 6
    //   169: aload 24
    //   171: ldc 202
    //   173: invokeinterface 73 2 0
    //   178: istore 14
    //   180: aload 24
    //   182: ldc 61
    //   184: invokeinterface 73 2 0
    //   189: istore 15
    //   191: aload 24
    //   193: ldc 57
    //   195: invokeinterface 73 2 0
    //   200: istore 13
    //   202: aload 24
    //   204: ldc 59
    //   206: invokeinterface 73 2 0
    //   211: istore_2
    //   212: aload 24
    //   214: ldc 211
    //   216: invokeinterface 73 2 0
    //   221: istore_3
    //   222: aload 24
    //   224: ldc 224
    //   226: invokeinterface 73 2 0
    //   231: istore_1
    //   232: aload 24
    //   234: ldc 231
    //   236: invokeinterface 73 2 0
    //   241: istore 7
    //   243: aload 24
    //   245: ldc 236
    //   247: invokeinterface 73 2 0
    //   252: istore 9
    //   254: aload 24
    //   256: ldc 241
    //   258: invokeinterface 73 2 0
    //   263: istore 5
    //   265: aload 24
    //   267: invokeinterface 77 1 0
    //   272: ifeq +255 -> 527
    //   275: aload_0
    //   276: getfield 35	zxh:jdField_a_of_type_Zxj	Lzxj;
    //   279: astore 28
    //   281: aload 24
    //   283: iload 4
    //   285: invokeinterface 84 2 0
    //   290: astore 25
    //   292: aload 24
    //   294: iload 8
    //   296: invokeinterface 84 2 0
    //   301: astore 23
    //   303: aload 24
    //   305: iload 14
    //   307: invokeinterface 84 2 0
    //   312: astore 26
    //   314: aload 24
    //   316: iload 12
    //   318: invokeinterface 147 2 0
    //   323: lstore 18
    //   325: aload 24
    //   327: iload 6
    //   329: invokeinterface 147 2 0
    //   334: lstore 16
    //   336: aload 24
    //   338: iload_2
    //   339: invokeinterface 343 2 0
    //   344: istore 11
    //   346: aload 24
    //   348: iload 13
    //   350: invokeinterface 343 2 0
    //   355: istore 10
    //   357: aload 24
    //   359: iload 15
    //   361: invokeinterface 84 2 0
    //   366: astore 27
    //   368: aload 24
    //   370: iload_3
    //   371: invokeinterface 343 2 0
    //   376: iconst_1
    //   377: if_icmpne +138 -> 515
    //   380: iconst_1
    //   381: istore 20
    //   383: aload 24
    //   385: iload_1
    //   386: invokeinterface 343 2 0
    //   391: iconst_1
    //   392: if_icmpne +129 -> 521
    //   395: iconst_1
    //   396: istore 21
    //   398: aload 28
    //   400: aload 25
    //   402: aload 23
    //   404: aload 26
    //   406: lload 18
    //   408: invokestatic 302	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   411: lload 16
    //   413: iload 11
    //   415: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   418: iload 10
    //   420: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   423: aload 27
    //   425: iload 20
    //   427: iload 21
    //   429: aload 24
    //   431: iload 7
    //   433: invokeinterface 343 2 0
    //   438: aload 24
    //   440: iload 9
    //   442: invokeinterface 84 2 0
    //   447: aload 24
    //   449: iload 5
    //   451: invokeinterface 84 2 0
    //   456: invokevirtual 348	zxj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V
    //   459: goto -194 -> 265
    //   462: astore 25
    //   464: aload 24
    //   466: astore 23
    //   468: aload 25
    //   470: astore 24
    //   472: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +12 -> 487
    //   478: ldc 105
    //   480: iconst_2
    //   481: ldc_w 350
    //   484: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload 24
    //   489: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   492: aload 23
    //   494: ifnull +10 -> 504
    //   497: aload 23
    //   499: invokeinterface 117 1 0
    //   504: aload 22
    //   506: ifnull -452 -> 54
    //   509: aload 22
    //   511: invokevirtual 333	android/database/sqlite/SQLiteDatabase:close	()V
    //   514: return
    //   515: iconst_0
    //   516: istore 20
    //   518: goto -135 -> 383
    //   521: iconst_0
    //   522: istore 21
    //   524: goto -126 -> 398
    //   527: aload 24
    //   529: ifnull +10 -> 539
    //   532: aload 24
    //   534: invokeinterface 117 1 0
    //   539: aload 22
    //   541: ifnull -487 -> 54
    //   544: aload 22
    //   546: invokevirtual 333	android/database/sqlite/SQLiteDatabase:close	()V
    //   549: return
    //   550: astore 23
    //   552: aconst_null
    //   553: astore 24
    //   555: aconst_null
    //   556: astore 22
    //   558: aload 24
    //   560: ifnull +10 -> 570
    //   563: aload 24
    //   565: invokeinterface 117 1 0
    //   570: aload 22
    //   572: ifnull +8 -> 580
    //   575: aload 22
    //   577: invokevirtual 333	android/database/sqlite/SQLiteDatabase:close	()V
    //   580: aload 23
    //   582: athrow
    //   583: astore 23
    //   585: aconst_null
    //   586: astore 24
    //   588: goto -30 -> 558
    //   591: astore 23
    //   593: goto -35 -> 558
    //   596: astore 25
    //   598: aload 23
    //   600: astore 24
    //   602: aload 25
    //   604: astore 23
    //   606: goto -48 -> 558
    //   609: astore 24
    //   611: goto -139 -> 472
    //   614: astore 24
    //   616: goto -144 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	zxh
    //   231	155	1	j	int
    //   211	128	2	k	int
    //   221	150	3	m	int
    //   134	150	4	n	int
    //   263	187	5	i1	int
    //   167	161	6	i2	int
    //   241	191	7	i3	int
    //   145	150	8	i4	int
    //   252	189	9	i5	int
    //   355	64	10	i6	int
    //   344	70	11	i7	int
    //   156	161	12	i8	int
    //   200	149	13	i9	int
    //   178	128	14	i10	int
    //   189	171	15	i11	int
    //   334	78	16	l1	long
    //   323	84	18	l2	long
    //   23	494	20	bool1	boolean
    //   396	127	21	bool2	boolean
    //   1	575	22	localObject1	Object
    //   4	494	23	localObject2	Object
    //   550	31	23	localObject3	Object
    //   583	1	23	localObject4	Object
    //   591	8	23	localObject5	Object
    //   604	1	23	localObject6	Object
    //   16	585	24	localObject7	Object
    //   609	1	24	localException1	Exception
    //   614	1	24	localException2	Exception
    //   290	111	25	str1	String
    //   462	7	25	localException3	Exception
    //   596	7	25	localObject8	Object
    //   312	93	26	str2	String
    //   366	58	27	str3	String
    //   279	120	28	localzxj	zxj
    // Exception table:
    //   from	to	target	type
    //   125	265	462	java/lang/Exception
    //   265	380	462	java/lang/Exception
    //   383	395	462	java/lang/Exception
    //   398	459	462	java/lang/Exception
    //   6	25	550	finally
    //   55	67	550	finally
    //   99	120	583	finally
    //   125	265	591	finally
    //   265	380	591	finally
    //   383	395	591	finally
    //   398	459	591	finally
    //   472	487	596	finally
    //   487	492	596	finally
    //   6	25	609	java/lang/Exception
    //   55	67	609	java/lang/Exception
    //   99	120	614	java/lang/Exception
  }
  
  /* Error */
  public java.util.List<zxi> ds()
  {
    // Byte code:
    //   0: new 125	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 126	java/util/ArrayList:<init>	()V
    //   7: astore 16
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 31	zxh:jdField_a_of_type_Zxg	Lzxg;
    //   14: invokevirtual 47	zxg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 246
    //   26: bipush 11
    //   28: anewarray 53	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 55
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 178
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 183
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 188
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 202
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 211
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 224
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 229
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 231
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 236
    //   84: aastore
    //   85: dup
    //   86: bipush 10
    //   88: ldc 241
    //   90: aastore
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: ldc_w 354
    //   98: invokevirtual 67	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 14
    //   103: aload 14
    //   105: ifnull +510 -> 615
    //   108: aload 14
    //   110: astore 13
    //   112: aload 14
    //   114: ldc 55
    //   116: invokeinterface 73 2 0
    //   121: istore_1
    //   122: aload 14
    //   124: astore 13
    //   126: aload 14
    //   128: ldc 178
    //   130: invokeinterface 73 2 0
    //   135: istore_2
    //   136: aload 14
    //   138: astore 13
    //   140: aload 14
    //   142: ldc 183
    //   144: invokeinterface 73 2 0
    //   149: istore_3
    //   150: aload 14
    //   152: astore 13
    //   154: aload 14
    //   156: ldc 188
    //   158: invokeinterface 73 2 0
    //   163: istore 4
    //   165: aload 14
    //   167: astore 13
    //   169: aload 14
    //   171: ldc 202
    //   173: invokeinterface 73 2 0
    //   178: istore 5
    //   180: aload 14
    //   182: astore 13
    //   184: aload 14
    //   186: ldc 211
    //   188: invokeinterface 73 2 0
    //   193: istore 6
    //   195: aload 14
    //   197: astore 13
    //   199: aload 14
    //   201: ldc 224
    //   203: invokeinterface 73 2 0
    //   208: istore 7
    //   210: aload 14
    //   212: astore 13
    //   214: aload 14
    //   216: ldc 229
    //   218: invokeinterface 73 2 0
    //   223: istore 8
    //   225: aload 14
    //   227: astore 13
    //   229: aload 14
    //   231: ldc 231
    //   233: invokeinterface 73 2 0
    //   238: istore 9
    //   240: aload 14
    //   242: astore 13
    //   244: aload 14
    //   246: ldc 236
    //   248: invokeinterface 73 2 0
    //   253: istore 10
    //   255: aload 14
    //   257: astore 13
    //   259: aload 14
    //   261: ldc 241
    //   263: invokeinterface 73 2 0
    //   268: istore 11
    //   270: aload 14
    //   272: astore 13
    //   274: aload 14
    //   276: invokeinterface 77 1 0
    //   281: ifeq +334 -> 615
    //   284: aload 14
    //   286: astore 13
    //   288: new 170	zxi
    //   291: dup
    //   292: invokespecial 355	zxi:<init>	()V
    //   295: astore 15
    //   297: aload 14
    //   299: astore 13
    //   301: aload 14
    //   303: iload 7
    //   305: invokeinterface 343 2 0
    //   310: iconst_1
    //   311: if_icmpne +286 -> 597
    //   314: iconst_1
    //   315: istore 12
    //   317: aload 14
    //   319: astore 13
    //   321: aload 15
    //   323: iload 12
    //   325: putfield 222	zxi:isFinish	Z
    //   328: aload 14
    //   330: astore 13
    //   332: aload 14
    //   334: iload 6
    //   336: invokeinterface 343 2 0
    //   341: iconst_1
    //   342: if_icmpne +261 -> 603
    //   345: iconst_1
    //   346: istore 12
    //   348: aload 14
    //   350: astore 13
    //   352: aload 15
    //   354: iload 12
    //   356: putfield 209	zxi:isOpen	Z
    //   359: aload 14
    //   361: astore 13
    //   363: aload 15
    //   365: aload 14
    //   367: iload 5
    //   369: invokeinterface 84 2 0
    //   374: putfield 205	zxi:bba	Ljava/lang/String;
    //   377: aload 14
    //   379: astore 13
    //   381: aload 15
    //   383: aload 14
    //   385: iload_1
    //   386: invokeinterface 84 2 0
    //   391: putfield 173	zxi:redBagId	Ljava/lang/String;
    //   394: aload 14
    //   396: astore 13
    //   398: aload 15
    //   400: aload 14
    //   402: iload_2
    //   403: invokeinterface 84 2 0
    //   408: putfield 181	zxi:redBagIndex	Ljava/lang/String;
    //   411: aload 14
    //   413: astore 13
    //   415: aload 15
    //   417: aload 14
    //   419: iload_3
    //   420: invokeinterface 84 2 0
    //   425: putfield 186	zxi:baZ	Ljava/lang/String;
    //   428: aload 14
    //   430: astore 13
    //   432: aload 15
    //   434: aload 14
    //   436: iload 4
    //   438: invokeinterface 147 2 0
    //   443: putfield 191	zxi:expireTime	J
    //   446: aload 14
    //   448: astore 13
    //   450: aload 14
    //   452: iload 8
    //   454: invokeinterface 343 2 0
    //   459: iconst_1
    //   460: if_icmpne +149 -> 609
    //   463: iconst_1
    //   464: istore 12
    //   466: aload 14
    //   468: astore 13
    //   470: aload 15
    //   472: iload 12
    //   474: putfield 227	zxi:bul	Z
    //   477: aload 14
    //   479: astore 13
    //   481: aload 15
    //   483: aload 14
    //   485: iload 9
    //   487: invokeinterface 343 2 0
    //   492: putfield 234	zxi:type	I
    //   495: aload 14
    //   497: astore 13
    //   499: aload 15
    //   501: aload 14
    //   503: iload 10
    //   505: invokeinterface 84 2 0
    //   510: putfield 239	zxi:bbb	Ljava/lang/String;
    //   513: aload 14
    //   515: astore 13
    //   517: aload 15
    //   519: aload 14
    //   521: iload 11
    //   523: invokeinterface 84 2 0
    //   528: putfield 244	zxi:extStr	Ljava/lang/String;
    //   531: aload 14
    //   533: astore 13
    //   535: aload 16
    //   537: aload 15
    //   539: invokeinterface 160 2 0
    //   544: pop
    //   545: goto -275 -> 270
    //   548: astore 15
    //   550: aload 14
    //   552: astore 13
    //   554: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +16 -> 573
    //   560: aload 14
    //   562: astore 13
    //   564: ldc 105
    //   566: iconst_2
    //   567: ldc_w 357
    //   570: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload 14
    //   575: astore 13
    //   577: aload 15
    //   579: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   582: aload 14
    //   584: ifnull +10 -> 594
    //   587: aload 14
    //   589: invokeinterface 117 1 0
    //   594: aload 16
    //   596: areturn
    //   597: iconst_0
    //   598: istore 12
    //   600: goto -283 -> 317
    //   603: iconst_0
    //   604: istore 12
    //   606: goto -258 -> 348
    //   609: iconst_0
    //   610: istore 12
    //   612: goto -146 -> 466
    //   615: aload 14
    //   617: ifnull -23 -> 594
    //   620: aload 14
    //   622: invokeinterface 117 1 0
    //   627: aload 16
    //   629: areturn
    //   630: astore 14
    //   632: aconst_null
    //   633: astore 13
    //   635: aload 13
    //   637: ifnull +10 -> 647
    //   640: aload 13
    //   642: invokeinterface 117 1 0
    //   647: aload 14
    //   649: athrow
    //   650: astore 14
    //   652: goto -17 -> 635
    //   655: astore 15
    //   657: aconst_null
    //   658: astore 14
    //   660: goto -110 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	zxh
    //   121	265	1	j	int
    //   135	268	2	k	int
    //   149	271	3	m	int
    //   163	274	4	n	int
    //   178	190	5	i1	int
    //   193	142	6	i2	int
    //   208	96	7	i3	int
    //   223	230	8	i4	int
    //   238	248	9	i5	int
    //   253	251	10	i6	int
    //   268	254	11	i7	int
    //   315	296	12	bool	boolean
    //   110	531	13	localCursor1	android.database.Cursor
    //   101	520	14	localCursor2	android.database.Cursor
    //   630	18	14	localObject1	Object
    //   650	1	14	localObject2	Object
    //   658	1	14	localObject3	Object
    //   295	243	15	localzxi	zxi
    //   548	30	15	localException1	Exception
    //   655	1	15	localException2	Exception
    //   7	621	16	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   112	122	548	java/lang/Exception
    //   126	136	548	java/lang/Exception
    //   140	150	548	java/lang/Exception
    //   154	165	548	java/lang/Exception
    //   169	180	548	java/lang/Exception
    //   184	195	548	java/lang/Exception
    //   199	210	548	java/lang/Exception
    //   214	225	548	java/lang/Exception
    //   229	240	548	java/lang/Exception
    //   244	255	548	java/lang/Exception
    //   259	270	548	java/lang/Exception
    //   274	284	548	java/lang/Exception
    //   288	297	548	java/lang/Exception
    //   301	314	548	java/lang/Exception
    //   321	328	548	java/lang/Exception
    //   332	345	548	java/lang/Exception
    //   352	359	548	java/lang/Exception
    //   363	377	548	java/lang/Exception
    //   381	394	548	java/lang/Exception
    //   398	411	548	java/lang/Exception
    //   415	428	548	java/lang/Exception
    //   432	446	548	java/lang/Exception
    //   450	463	548	java/lang/Exception
    //   470	477	548	java/lang/Exception
    //   481	495	548	java/lang/Exception
    //   499	513	548	java/lang/Exception
    //   517	531	548	java/lang/Exception
    //   535	545	548	java/lang/Exception
    //   9	103	630	finally
    //   112	122	650	finally
    //   126	136	650	finally
    //   140	150	650	finally
    //   154	165	650	finally
    //   169	180	650	finally
    //   184	195	650	finally
    //   199	210	650	finally
    //   214	225	650	finally
    //   229	240	650	finally
    //   244	255	650	finally
    //   259	270	650	finally
    //   274	284	650	finally
    //   288	297	650	finally
    //   301	314	650	finally
    //   321	328	650	finally
    //   332	345	650	finally
    //   352	359	650	finally
    //   363	377	650	finally
    //   381	394	650	finally
    //   398	411	650	finally
    //   415	428	650	finally
    //   432	446	650	finally
    //   450	463	650	finally
    //   470	477	650	finally
    //   481	495	650	finally
    //   499	513	650	finally
    //   517	531	650	finally
    //   535	545	650	finally
    //   554	560	650	finally
    //   564	573	650	finally
    //   577	582	650	finally
    //   9	103	655	java/lang/Exception
  }
  
  /* Error */
  public void hr(java.util.List<zxr> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 31	zxh:jdField_a_of_type_Zxg	Lzxg;
    //   7: invokevirtual 47	zxg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: putfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_0
    //   14: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokevirtual 363	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: new 167	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 168	android/content/ContentValues:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 367 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 372 1 0
    //   41: ifeq +103 -> 144
    //   44: aload_1
    //   45: invokeinterface 376 1 0
    //   50: checkcast 139	zxr
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 379	android/content/ContentValues:clear	()V
    //   58: aload_2
    //   59: ldc 57
    //   61: aload_3
    //   62: getfield 151	zxr:LE	J
    //   65: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   71: aload_2
    //   72: ldc 59
    //   74: aload_3
    //   75: getfield 143	zxr:source	I
    //   78: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   84: aload_2
    //   85: ldc 135
    //   87: aload_3
    //   88: getfield 154	zxr:lastUpdateTime	J
    //   91: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 200	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload_0
    //   98: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   101: ldc 133
    //   103: aconst_null
    //   104: aload_2
    //   105: invokevirtual 250	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   108: pop2
    //   109: goto -74 -> 35
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   117: aload_0
    //   118: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   121: ifnull +20 -> 141
    //   124: aload_0
    //   125: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   128: invokevirtual 382	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   131: ifeq +10 -> 141
    //   134: aload_0
    //   135: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   138: invokevirtual 385	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: aload_0
    //   145: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   148: invokevirtual 388	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   151: aload_0
    //   152: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   155: ifnull -14 -> 141
    //   158: aload_0
    //   159: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   162: invokevirtual 382	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   165: ifeq -24 -> 141
    //   168: aload_0
    //   169: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   172: invokevirtual 385	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   175: goto -34 -> 141
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   183: goto -42 -> 141
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   196: goto -55 -> 141
    //   199: astore_1
    //   200: aload_0
    //   201: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   204: ifnull +20 -> 224
    //   207: aload_0
    //   208: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   211: invokevirtual 382	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   214: ifeq +10 -> 224
    //   217: aload_0
    //   218: getfield 49	zxh:i	Landroid/database/sqlite/SQLiteDatabase;
    //   221: invokevirtual 385	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_2
    //   227: aload_2
    //   228: invokevirtual 114	java/lang/Throwable:printStackTrace	()V
    //   231: goto -7 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	zxh
    //   0	234	1	paramList	java.util.List<zxr>
    //   27	78	2	localContentValues	ContentValues
    //   226	2	2	localThrowable	Throwable
    //   53	35	3	localzxr	zxr
    // Exception table:
    //   from	to	target	type
    //   2	35	112	java/lang/Throwable
    //   35	109	112	java/lang/Throwable
    //   144	151	112	java/lang/Throwable
    //   151	175	178	java/lang/Throwable
    //   117	141	186	finally
    //   151	175	186	finally
    //   179	183	186	finally
    //   192	196	186	finally
    //   200	224	186	finally
    //   224	226	186	finally
    //   227	231	186	finally
    //   117	141	191	java/lang/Throwable
    //   2	35	199	finally
    //   35	109	199	finally
    //   113	117	199	finally
    //   144	151	199	finally
    //   200	224	226	java/lang/Throwable
  }
  
  public JSONObject o(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return new JSONObject();
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return new JSONObject();
  }
  
  public void onDestroy()
  {
    if (this.i != null) {
      this.i.close();
    }
  }
  
  public void v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.i = this.jdField_a_of_type_Zxg.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.i.replace("red_bag_relations", null, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBagRelation failed ");
      }
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxh
 * JD-Core Version:    0.7.0.1
 */