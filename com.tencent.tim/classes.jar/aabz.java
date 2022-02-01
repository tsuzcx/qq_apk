import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class aabz
  extends SQLiteOpenHelper
{
  public aabz(Context paramContext)
  {
    super(paramContext, "QWalletNotifyMsg.db", null, 1);
  }
  
  private void m(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("record");
    localStringBuilder.append(" (");
    localStringBuilder.append("no").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uin").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("btype").append(" INTEGER(16) DEFAULT 0, ");
    localStringBuilder.append("bid").append(" VARCHAR(64) , ");
    localStringBuilder.append("create_time").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("ext").append(" VARCHAR(128) ");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void a(long paramLong, int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      long l = NetConnInfoCenter.getServerTime();
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        if (paramArrayOfInt != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramArrayOfInt.length > 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            if (i < paramArrayOfInt.length)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localStringBuilder.append(paramArrayOfInt[i]);
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              if (i + 1 >= paramArrayOfInt.length) {
                break label333;
              }
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localStringBuilder.append(',');
              break label333;
            }
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localSQLiteDatabase.delete("record", " btype in (" + localStringBuilder.toString() + ") AND" + "create_time" + "< ? ", new String[] { String.valueOf(l - paramLong) });
          }
        }
        while (localSQLiteDatabase != null)
        {
          try
          {
            localSQLiteDatabase.close();
            return;
          }
          catch (Exception paramArrayOfInt)
          {
            paramArrayOfInt.printStackTrace();
            return;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.delete("record", " create_time< ? ", new String[] { String.valueOf(l - paramLong) });
        }
      }
      catch (Exception paramArrayOfInt)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.i("NotifyMsgDBHelper", 2, "clearOverTimeRecords err:" + paramArrayOfInt.getMessage());
        }
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.close();
          return;
        }
        catch (Exception paramArrayOfInt)
        {
          paramArrayOfInt.printStackTrace();
          return;
        }
      }
      finally
      {
        for (;;)
        {
          if (localObject2 != null) {}
          try
          {
            localObject2.close();
            throw paramArrayOfInt;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          label333:
          i += 1;
        }
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    m(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  /* Error */
  public void v(String paramString, java.util.List<aabz.a> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_1
    //   15: ifnull +7 -> 22
    //   18: aload_2
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: invokeinterface 138 1 0
    //   29: aload_0
    //   30: invokevirtual 141	aabz:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore 4
    //   35: aload 8
    //   37: astore_3
    //   38: aload 4
    //   40: ifnull +264 -> 304
    //   43: aload 7
    //   45: astore 6
    //   47: aload 5
    //   49: astore_3
    //   50: aload 4
    //   52: astore 5
    //   54: aload 4
    //   56: new 19	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   63: ldc 143
    //   65: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aconst_null
    //   76: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +200 -> 281
    //   84: aload_1
    //   85: astore 6
    //   87: aload_1
    //   88: astore_3
    //   89: aload 4
    //   91: astore 5
    //   93: aload_1
    //   94: invokeinterface 153 1 0
    //   99: ifle +182 -> 281
    //   102: aload_1
    //   103: astore 6
    //   105: aload_1
    //   106: astore_3
    //   107: aload 4
    //   109: astore 5
    //   111: aload_1
    //   112: invokeinterface 156 1 0
    //   117: pop
    //   118: aload_1
    //   119: astore 6
    //   121: aload_1
    //   122: astore_3
    //   123: aload 4
    //   125: astore 5
    //   127: aload_1
    //   128: invokeinterface 159 1 0
    //   133: ifne +148 -> 281
    //   136: aload_1
    //   137: astore 6
    //   139: aload_1
    //   140: astore_3
    //   141: aload 4
    //   143: astore 5
    //   145: aload_1
    //   146: invokestatic 162	aabz$a:a	(Landroid/database/Cursor;)Laabz$a;
    //   149: astore 7
    //   151: aload 7
    //   153: ifnull +21 -> 174
    //   156: aload_1
    //   157: astore 6
    //   159: aload_1
    //   160: astore_3
    //   161: aload 4
    //   163: astore 5
    //   165: aload_2
    //   166: aload 7
    //   168: invokeinterface 166 2 0
    //   173: pop
    //   174: aload_1
    //   175: astore 6
    //   177: aload_1
    //   178: astore_3
    //   179: aload 4
    //   181: astore 5
    //   183: aload_1
    //   184: invokeinterface 169 1 0
    //   189: pop
    //   190: goto -72 -> 118
    //   193: astore_1
    //   194: aload 6
    //   196: astore_3
    //   197: aload 4
    //   199: astore 5
    //   201: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +38 -> 242
    //   207: aload 6
    //   209: astore_3
    //   210: aload 4
    //   212: astore 5
    //   214: ldc 117
    //   216: iconst_2
    //   217: new 19	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   224: ldc 171
    //   226: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 6
    //   244: ifnull +20 -> 264
    //   247: aload 6
    //   249: invokeinterface 174 1 0
    //   254: ifne +10 -> 264
    //   257: aload 6
    //   259: invokeinterface 175 1 0
    //   264: aload 4
    //   266: ifnull -244 -> 22
    //   269: aload 4
    //   271: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   274: return
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   280: return
    //   281: aload_1
    //   282: astore_3
    //   283: aload_1
    //   284: ifnull +20 -> 304
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: astore_3
    //   292: aload 4
    //   294: astore 5
    //   296: aload_1
    //   297: invokeinterface 175 1 0
    //   302: aload_1
    //   303: astore_3
    //   304: aload_3
    //   305: ifnull +18 -> 323
    //   308: aload_3
    //   309: invokeinterface 174 1 0
    //   314: ifne +9 -> 323
    //   317: aload_3
    //   318: invokeinterface 175 1 0
    //   323: aload 4
    //   325: ifnull -303 -> 22
    //   328: aload 4
    //   330: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: return
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   339: return
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   345: goto -22 -> 323
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   353: goto -89 -> 264
    //   356: astore_1
    //   357: aconst_null
    //   358: astore 5
    //   360: aload_3
    //   361: ifnull +18 -> 379
    //   364: aload_3
    //   365: invokeinterface 174 1 0
    //   370: ifne +9 -> 379
    //   373: aload_3
    //   374: invokeinterface 175 1 0
    //   379: aload 5
    //   381: ifnull +8 -> 389
    //   384: aload 5
    //   386: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore_2
    //   392: aload_2
    //   393: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   396: goto -17 -> 379
    //   399: astore_2
    //   400: aload_2
    //   401: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   404: goto -15 -> 389
    //   407: astore_1
    //   408: goto -48 -> 360
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 4
    //   415: goto -221 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	aabz
    //   0	418	1	paramString	String
    //   0	418	2	paramList	java.util.List<aabz.a>
    //   7	367	3	localObject1	Object
    //   33	381	4	localSQLiteDatabase	SQLiteDatabase
    //   9	376	5	localObject2	Object
    //   1	288	6	localObject3	Object
    //   12	155	7	locala	aabz.a
    //   4	32	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	80	193	java/lang/Exception
    //   93	102	193	java/lang/Exception
    //   111	118	193	java/lang/Exception
    //   127	136	193	java/lang/Exception
    //   145	151	193	java/lang/Exception
    //   165	174	193	java/lang/Exception
    //   183	190	193	java/lang/Exception
    //   296	302	193	java/lang/Exception
    //   269	274	275	java/lang/Exception
    //   328	333	334	java/lang/Exception
    //   308	323	340	java/lang/Exception
    //   247	264	348	java/lang/Exception
    //   29	35	356	finally
    //   364	379	391	java/lang/Exception
    //   384	389	399	java/lang/Exception
    //   54	80	407	finally
    //   93	102	407	finally
    //   111	118	407	finally
    //   127	136	407	finally
    //   145	151	407	finally
    //   165	174	407	finally
    //   183	190	407	finally
    //   201	207	407	finally
    //   214	242	407	finally
    //   296	302	407	finally
    //   29	35	411	java/lang/Exception
  }
  
  /* Error */
  public void w(String paramString, java.util.List<aabz.a> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_2
    //   7: ifnull +12 -> 19
    //   10: aload_2
    //   11: invokeinterface 181 1 0
    //   16: ifgt +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 79	aabz:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_1
    //   25: aload_2
    //   26: invokeinterface 185 1 0
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface 190 1 0
    //   38: ifeq +279 -> 317
    //   41: aload_3
    //   42: invokeinterface 194 1 0
    //   47: checkcast 6	aabz$a
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull -22 -> 32
    //   57: new 196	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 197	android/content/ContentValues:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc 38
    //   70: aload 4
    //   72: getfield 201	aabz$a:mUin	J
    //   75: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   78: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   81: aload 5
    //   83: ldc 42
    //   85: aload 4
    //   87: getfield 214	aabz$a:EP	I
    //   90: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: invokevirtual 222	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   96: aload 4
    //   98: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   101: ifnonnull +195 -> 296
    //   104: ldc 228
    //   106: astore_2
    //   107: aload 5
    //   109: ldc 46
    //   111: aload_2
    //   112: invokevirtual 231	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: ldc 50
    //   119: invokestatic 75	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   122: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   128: aload 4
    //   130: getfield 235	aabz$a:bb	Lorg/json/JSONObject;
    //   133: ifnonnull +172 -> 305
    //   136: ldc 228
    //   138: astore_2
    //   139: aload 5
    //   141: ldc 52
    //   143: aload_2
    //   144: invokevirtual 231	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_1
    //   148: ldc 30
    //   150: aconst_null
    //   151: aload 5
    //   153: invokevirtual 239	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   156: pop2
    //   157: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -128 -> 32
    //   163: ldc 117
    //   165: iconst_2
    //   166: new 19	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   173: ldc 241
    //   175: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 4
    //   180: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   183: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -160 -> 32
    //   195: astore_2
    //   196: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -167 -> 32
    //   202: ldc 117
    //   204: iconst_2
    //   205: new 19	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   212: ldc 243
    //   214: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 4
    //   219: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   222: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 245
    //   227: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -211 -> 32
    //   246: astore_2
    //   247: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +31 -> 281
    //   253: ldc 117
    //   255: iconst_2
    //   256: new 19	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   263: ldc 247
    //   265: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_2
    //   269: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_1
    //   282: ifnull -263 -> 19
    //   285: aload_1
    //   286: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   289: return
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   295: return
    //   296: aload 4
    //   298: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   301: astore_2
    //   302: goto -195 -> 107
    //   305: aload 4
    //   307: getfield 235	aabz$a:bb	Lorg/json/JSONObject;
    //   310: invokevirtual 250	org/json/JSONObject:toString	()Ljava/lang/String;
    //   313: astore_2
    //   314: goto -175 -> 139
    //   317: aload_1
    //   318: ifnull -299 -> 19
    //   321: aload_1
    //   322: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: return
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   331: return
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   343: aload_2
    //   344: athrow
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   350: goto -7 -> 343
    //   353: astore_2
    //   354: goto -19 -> 335
    //   357: astore_2
    //   358: goto -23 -> 335
    //   361: astore_2
    //   362: aload_3
    //   363: astore_1
    //   364: goto -117 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	aabz
    //   0	367	1	paramString	String
    //   0	367	2	paramList	java.util.List<aabz.a>
    //   1	362	3	localIterator	java.util.Iterator
    //   50	256	4	locala	aabz.a
    //   64	88	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   147	192	195	java/lang/Exception
    //   25	32	246	java/lang/Exception
    //   32	52	246	java/lang/Exception
    //   57	104	246	java/lang/Exception
    //   107	136	246	java/lang/Exception
    //   139	147	246	java/lang/Exception
    //   196	243	246	java/lang/Exception
    //   296	302	246	java/lang/Exception
    //   305	314	246	java/lang/Exception
    //   285	289	290	java/lang/Exception
    //   321	325	326	java/lang/Exception
    //   20	25	332	finally
    //   339	343	345	java/lang/Exception
    //   25	32	353	finally
    //   32	52	353	finally
    //   57	104	353	finally
    //   107	136	353	finally
    //   139	147	353	finally
    //   147	192	353	finally
    //   196	243	353	finally
    //   296	302	353	finally
    //   305	314	353	finally
    //   247	281	357	finally
    //   20	25	361	java/lang/Exception
  }
  
  /* Error */
  public void x(String paramString, java.util.List<aabz.a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_2
    //   5: ifnull +12 -> 17
    //   8: aload_2
    //   9: invokeinterface 181 1 0
    //   14: ifgt +4 -> 18
    //   17: return
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 79	aabz:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: aload 4
    //   28: astore_3
    //   29: aload_2
    //   30: invokeinterface 185 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 190 1 0
    //   44: ifeq +300 -> 344
    //   47: aload 4
    //   49: invokeinterface 194 1 0
    //   54: checkcast 6	aabz$a
    //   57: astore 5
    //   59: aload 5
    //   61: ifnull -24 -> 37
    //   64: new 196	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 197	android/content/ContentValues:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: ldc 38
    //   77: aload 5
    //   79: getfield 201	aabz$a:mUin	J
    //   82: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   88: aload 6
    //   90: ldc 42
    //   92: aload 5
    //   94: getfield 214	aabz$a:EP	I
    //   97: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: invokevirtual 222	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   103: aload 5
    //   105: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   108: ifnonnull +215 -> 323
    //   111: ldc 228
    //   113: astore_2
    //   114: aload 6
    //   116: ldc 46
    //   118: aload_2
    //   119: invokevirtual 231	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: getfield 235	aabz$a:bb	Lorg/json/JSONObject;
    //   127: ifnonnull +205 -> 332
    //   130: ldc 228
    //   132: astore_2
    //   133: aload 6
    //   135: ldc 52
    //   137: aload_2
    //   138: invokevirtual 231	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_3
    //   142: ldc 30
    //   144: aload 6
    //   146: ldc 253
    //   148: iconst_3
    //   149: anewarray 93	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload_1
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload 5
    //   160: getfield 214	aabz$a:EP	I
    //   163: invokestatic 256	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: aload 5
    //   171: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   174: aastore
    //   175: invokevirtual 260	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   178: pop
    //   179: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -145 -> 37
    //   185: ldc 117
    //   187: iconst_2
    //   188: new 19	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 262
    //   198: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 5
    //   203: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   206: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: goto -178 -> 37
    //   218: astore_2
    //   219: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -185 -> 37
    //   225: ldc 117
    //   227: iconst_2
    //   228: new 19	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 264
    //   238: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 5
    //   243: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   246: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 245
    //   251: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_2
    //   255: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: goto -230 -> 37
    //   270: astore_2
    //   271: aload_3
    //   272: astore_1
    //   273: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +32 -> 308
    //   279: ldc 117
    //   281: iconst_2
    //   282: new 19	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 266
    //   292: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_2
    //   296: invokevirtual 122	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_1
    //   309: ifnull -292 -> 17
    //   312: aload_1
    //   313: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   316: return
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   322: return
    //   323: aload 5
    //   325: getfield 226	aabz$a:mBusinessId	Ljava/lang/String;
    //   328: astore_2
    //   329: goto -215 -> 114
    //   332: aload 5
    //   334: getfield 235	aabz$a:bb	Lorg/json/JSONObject;
    //   337: invokevirtual 250	org/json/JSONObject:toString	()Ljava/lang/String;
    //   340: astore_2
    //   341: goto -208 -> 133
    //   344: aload_3
    //   345: ifnull -328 -> 17
    //   348: aload_3
    //   349: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   352: return
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   358: return
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_3
    //   362: aload_3
    //   363: ifnull +7 -> 370
    //   366: aload_3
    //   367: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   370: aload_1
    //   371: athrow
    //   372: astore_2
    //   373: aload_2
    //   374: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   377: goto -7 -> 370
    //   380: astore_1
    //   381: goto -19 -> 362
    //   384: astore_2
    //   385: aload_1
    //   386: astore_3
    //   387: aload_2
    //   388: astore_1
    //   389: goto -27 -> 362
    //   392: astore_2
    //   393: aload_3
    //   394: astore_1
    //   395: goto -122 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	aabz
    //   0	398	1	paramString	String
    //   0	398	2	paramList	java.util.List<aabz.a>
    //   19	375	3	localObject1	Object
    //   24	24	4	localObject2	Object
    //   57	276	5	locala	aabz.a
    //   71	74	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   141	215	218	java/lang/Exception
    //   29	37	270	java/lang/Exception
    //   37	59	270	java/lang/Exception
    //   64	111	270	java/lang/Exception
    //   114	130	270	java/lang/Exception
    //   133	141	270	java/lang/Exception
    //   219	267	270	java/lang/Exception
    //   323	329	270	java/lang/Exception
    //   332	341	270	java/lang/Exception
    //   312	316	317	java/lang/Exception
    //   348	352	353	java/lang/Exception
    //   20	26	359	finally
    //   366	370	372	java/lang/Exception
    //   29	37	380	finally
    //   37	59	380	finally
    //   64	111	380	finally
    //   114	130	380	finally
    //   133	141	380	finally
    //   141	215	380	finally
    //   219	267	380	finally
    //   323	329	380	finally
    //   332	341	380	finally
    //   273	308	384	finally
    //   20	26	392	java/lang/Exception
  }
  
  public static class a
  {
    public int EP;
    public JSONObject bb;
    protected String bcp;
    public int cgb;
    public String mBusinessId;
    public long mCreateTime;
    public long mUin;
    
    protected a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2)
    {
      this.cgb = paramInt1;
      this.mUin = paramLong1;
      this.EP = paramInt2;
      this.mBusinessId = paramString1;
      this.mCreateTime = paramLong2;
      this.bcp = paramString2;
    }
    
    protected static a a(Cursor paramCursor)
    {
      if (paramCursor == null) {
        return null;
      }
      int i1 = paramCursor.getColumnIndexOrThrow("no");
      int m = paramCursor.getColumnIndexOrThrow("uin");
      int n = paramCursor.getColumnIndexOrThrow("btype");
      int i = paramCursor.getColumnIndexOrThrow("bid");
      int j = paramCursor.getColumnIndexOrThrow("create_time");
      int k = paramCursor.getColumnIndexOrThrow("ext");
      i1 = paramCursor.getInt(i1);
      long l1 = paramCursor.getLong(m);
      m = paramCursor.getInt(n);
      String str = paramCursor.getString(i);
      long l2 = paramCursor.getLong(j);
      paramCursor = paramCursor.getString(k);
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgDBHelper", 2, "fromCursorOrThrow bId:" + str + " extJson:" + paramCursor);
      }
      return new a(i1, l1, m, str, l2, paramCursor);
    }
    
    protected void Cb(boolean paramBoolean)
    {
      if (this.bb != null) {}
      label65:
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ((this.bcp == null) || (this.bcp.length() <= 0)) {
              break label65;
            }
            try
            {
              this.bb = new JSONObject(this.bcp);
              return;
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel())
              {
                localJSONException.printStackTrace();
                return;
              }
            }
            catch (Throwable localThrowable) {}
          }
        } while (!QLog.isColorLevel());
        localThrowable.printStackTrace();
        return;
      } while ((!paramBoolean) || (this.bb != null));
      this.bb = new JSONObject();
    }
    
    public int S(String paramString, int paramInt)
    {
      Cb(false);
      if (this.bb == null) {
        return paramInt;
      }
      return this.bb.optInt(paramString, paramInt);
    }
    
    public void cR(String paramString, int paramInt)
    {
      Cb(true);
      try
      {
        this.bb.put(paramString, paramInt);
        return;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        paramString.printStackTrace();
      }
    }
    
    public void ea(String paramString1, String paramString2)
    {
      Cb(true);
      try
      {
        this.bb.put(paramString1, paramString2);
        return;
      }
      catch (JSONException paramString1)
      {
        while (!QLog.isColorLevel()) {}
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabz
 * JD-Core Version:    0.7.0.1
 */