package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class et
{
  private static eq a;
  private static Context b;
  private static String c = "token";
  
  public static int a(ev paramev, String paramString)
  {
    for (;;)
    {
      try
      {
        a(paramev);
        paramev = a().query(paramString, new String[] { "count(*)" }, null, null, null, null, null, null);
        if (paramev.getCount() > 0)
        {
          paramev.moveToFirst();
          i = paramev.getInt(0);
          paramev.close();
          paramev = new StringBuilder();
          paramev.append("test database, tablecount=");
          paramev.append(i);
          g.c(paramev.toString());
          return i;
        }
      }
      catch (Throwable paramev)
      {
        paramString = new StringBuilder();
        paramString.append("status_kk");
        paramString.append(paramev.toString());
        paramString.append(paramev.getMessage());
        g.c(paramString.toString());
        return 0;
      }
      catch (Exception paramev)
      {
        paramString = new StringBuilder();
        paramString.append("status_kk");
        paramString.append(paramev.toString());
        paramString.append(paramev.getMessage());
        g.c(paramString.toString());
        return 0;
      }
      int i = 0;
    }
  }
  
  public static int a(ev paramev, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(paramev);
      int i = a().update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
    }
    catch (Exception paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
    }
    return 0;
  }
  
  public static int a(ev paramev, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(paramev);
      int i = a().delete(paramString1, paramString2, paramArrayOfString);
      paramev = new StringBuilder();
      paramev.append("test database, del=");
      paramev.append(i);
      g.c(paramev.toString());
      return i;
    }
    catch (Throwable paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
    }
    catch (Exception paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
    }
    return 0;
  }
  
  public static long a(ev paramev, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        a(paramev);
        paramev = a().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
        if (paramev.getCount() > 0)
        {
          if (paramBoolean)
          {
            paramev.moveToFirst();
            l = paramev.getLong(0);
          }
          else
          {
            paramev.moveToLast();
            l = paramev.getLong(0);
          }
          paramev.close();
          paramev = new StringBuilder();
          paramev.append("test database, time=");
          paramev.append(l);
          g.c(paramev.toString());
          return l;
        }
      }
      catch (Throwable paramev)
      {
        paramString1 = new StringBuilder();
        paramString1.append("status_kk");
        paramString1.append(paramev.toString());
        paramString1.append(paramev.getMessage());
        g.c(paramString1.toString());
        return 0L;
      }
      catch (Exception paramev)
      {
        paramString1 = new StringBuilder();
        paramString1.append("status_kk");
        paramString1.append(paramev.toString());
        paramString1.append(paramev.getMessage());
        g.c(paramString1.toString());
        return 0L;
      }
      long l = 0L;
    }
  }
  
  public static ev a(ev paramev, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    return b(paramev, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null, null);
  }
  
  /* Error */
  public static SQLiteDatabase a()
  {
    // Byte code:
    //   0: getstatic 115	com/tencent/token/et:a	Lcom/tencent/token/eq;
    //   3: ifnonnull +379 -> 382
    //   6: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   9: ifnonnull +9 -> 18
    //   12: invokestatic 123	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   15: putstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   18: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   21: ldc 125
    //   23: invokevirtual 131	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +15 -> 43
    //   31: aload_0
    //   32: invokevirtual 136	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_0
    //   39: invokevirtual 138	java/io/File:delete	()Z
    //   42: pop
    //   43: new 140	com/tencent/wcdb/database/SQLiteCipherSpec
    //   46: dup
    //   47: invokespecial 141	com/tencent/wcdb/database/SQLiteCipherSpec:<init>	()V
    //   50: sipush 1024
    //   53: invokevirtual 145	com/tencent/wcdb/database/SQLiteCipherSpec:setPageSize	(I)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   56: iconst_2
    //   57: invokevirtual 148	com/tencent/wcdb/database/SQLiteCipherSpec:setSQLCipherVersion	(I)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   60: ldc 150
    //   62: invokevirtual 154	com/tencent/wcdb/database/SQLiteCipherSpec:setCipher	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   65: astore 5
    //   67: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   70: ldc 156
    //   72: invokevirtual 131	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 136	java/io/File:exists	()Z
    //   80: ifne +221 -> 301
    //   83: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   86: ldc 158
    //   88: invokevirtual 131	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 136	java/io/File:exists	()Z
    //   96: ifeq +214 -> 310
    //   99: aload_1
    //   100: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: aconst_null
    //   104: iconst_1
    //   105: new 163	com/tencent/token/eo
    //   108: dup
    //   109: invokespecial 164	com/tencent/token/eo:<init>	()V
    //   112: invokestatic 168	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   115: astore_1
    //   116: aload_0
    //   117: getstatic 170	com/tencent/token/et:c	Ljava/lang/String;
    //   120: invokevirtual 174	java/lang/String:getBytes	()[B
    //   123: aload 5
    //   125: aconst_null
    //   126: new 163	com/tencent/token/eo
    //   129: dup
    //   130: invokespecial 164	com/tencent/token/eo:<init>	()V
    //   133: invokestatic 178	com/tencent/wcdb/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Lcom/tencent/wcdb/DatabaseErrorHandler;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   136: astore_0
    //   137: aload_0
    //   138: astore_2
    //   139: aload_1
    //   140: astore_3
    //   141: aload_1
    //   142: aload_0
    //   143: invokestatic 181	com/tencent/token/et:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Lcom/tencent/wcdb/database/SQLiteDatabase;)Z
    //   146: pop
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   155: aload_0
    //   156: ifnull +154 -> 310
    //   159: aload_0
    //   160: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   163: goto +147 -> 310
    //   166: astore 4
    //   168: goto +30 -> 198
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_2
    //   174: goto +109 -> 283
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_0
    //   181: goto +17 -> 198
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore_1
    //   189: goto +94 -> 283
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: astore_1
    //   198: aload_0
    //   199: astore_2
    //   200: aload_1
    //   201: astore_3
    //   202: new 55	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   209: astore 6
    //   211: aload_0
    //   212: astore_2
    //   213: aload_1
    //   214: astore_3
    //   215: aload 6
    //   217: ldc 78
    //   219: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_0
    //   224: astore_2
    //   225: aload_1
    //   226: astore_3
    //   227: aload 6
    //   229: aload 4
    //   231: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   234: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_0
    //   239: astore_2
    //   240: aload_1
    //   241: astore_3
    //   242: aload 6
    //   244: aload 4
    //   246: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   249: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: astore_2
    //   255: aload_1
    //   256: astore_3
    //   257: aload 6
    //   259: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   273: aload_0
    //   274: ifnull +36 -> 310
    //   277: goto -118 -> 159
    //   280: astore_0
    //   281: aload_3
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   304: ldc 158
    //   306: invokevirtual 131	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   309: pop
    //   310: new 184	com/tencent/token/eq
    //   313: dup
    //   314: getstatic 117	com/tencent/token/et:b	Landroid/content/Context;
    //   317: getstatic 170	com/tencent/token/et:c	Ljava/lang/String;
    //   320: invokestatic 188	com/tencent/token/global/c:a	()I
    //   323: aload 5
    //   325: invokespecial 191	com/tencent/token/eq:<init>	(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/wcdb/database/SQLiteCipherSpec;)V
    //   328: putstatic 115	com/tencent/token/et:a	Lcom/tencent/token/eq;
    //   331: goto +51 -> 382
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   339: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   342: new 55	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   349: astore_1
    //   350: aload_1
    //   351: ldc 78
    //   353: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_1
    //   358: aload_0
    //   359: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   362: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: aload_0
    //   368: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   371: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   382: getstatic 115	com/tencent/token/et:a	Lcom/tencent/token/eq;
    //   385: invokevirtual 194	com/tencent/token/eq:getWritableDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   388: astore_0
    //   389: aload_0
    //   390: areturn
    //   391: astore_0
    //   392: new 55	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   399: astore_1
    //   400: aload_1
    //   401: ldc 78
    //   403: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_1
    //   408: aload_0
    //   409: invokevirtual 79	java/lang/Throwable:toString	()Ljava/lang/String;
    //   412: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_1
    //   417: aload_0
    //   418: invokevirtual 82	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   432: aconst_null
    //   433: areturn
    //   434: astore_0
    //   435: aload_0
    //   436: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   442: new 55	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   449: astore_1
    //   450: aload_1
    //   451: ldc 78
    //   453: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload_1
    //   458: aload_0
    //   459: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   462: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_1
    //   467: aload_0
    //   468: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_1
    //   476: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 76	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   482: aconst_null
    //   483: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	134	0	localObject1	Object
    //   171	1	0	localObject2	Object
    //   180	1	0	localObject3	Object
    //   184	1	0	localObject4	Object
    //   195	79	0	localObject5	Object
    //   280	20	0	localObject6	Object
    //   334	34	0	localException1	Exception
    //   388	2	0	localSQLiteDatabase	SQLiteDatabase
    //   391	27	0	localThrowable	Throwable
    //   434	34	0	localException2	Exception
    //   91	385	1	localObject7	Object
    //   138	158	2	localObject8	Object
    //   140	142	3	localObject9	Object
    //   166	1	4	localException3	Exception
    //   177	1	4	localException4	Exception
    //   192	53	4	localException5	Exception
    //   65	259	5	localSQLiteCipherSpec	com.tencent.wcdb.database.SQLiteCipherSpec
    //   209	49	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   141	147	166	java/lang/Exception
    //   116	137	171	finally
    //   116	137	177	java/lang/Exception
    //   99	116	184	finally
    //   99	116	192	java/lang/Exception
    //   141	147	280	finally
    //   202	211	280	finally
    //   215	223	280	finally
    //   227	238	280	finally
    //   242	253	280	finally
    //   257	265	280	finally
    //   310	331	334	java/lang/Exception
    //   382	389	391	java/lang/Throwable
    //   382	389	434	java/lang/Exception
  }
  
  public static List<ev> a(ev paramev, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      a(paramev);
      paramString1 = a().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        do
        {
          localArrayList.add(paramev.a(paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return localArrayList;
    }
    catch (Throwable paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
      return localArrayList;
    }
    catch (Exception paramev)
    {
      paramString1 = new StringBuilder();
      paramString1.append("status_kk");
      paramString1.append(paramev.toString());
      paramString1.append(paramev.getMessage());
      g.c(paramString1.toString());
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void a(ev paramev)
  {
    try
    {
      paramev.a(a());
      return;
    }
    catch (Throwable paramev)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
      return;
    }
    catch (Exception paramev)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE IF EXISTS ");
      localStringBuilder.append(paramString);
      ((SQLiteDatabase)localObject).execSQL(localStringBuilder.toString());
      ((SQLiteDatabase)localObject).close();
      return;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      g.c(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status_kk");
      ((StringBuilder)localObject).append(paramString.toString());
      ((StringBuilder)localObject).append(paramString.getMessage());
      g.c(((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("sqlite_sequence");
    StringBuilder localStringBuilder = new StringBuilder("select DISTINCT  tbl_name from sqlite_master");
    com.tencent.wcdb.Cursor localCursor1 = paramSQLiteDatabase1.rawQuery(localStringBuilder.toString(), null);
    if (localCursor1 != null)
    {
      int j;
      for (int i = localCursor1.getCount(); localCursor1.moveToNext(); i = j)
      {
        j = i - 1;
        Object localObject2 = localCursor1.getString(0);
        localStringBuilder.setLength(0);
        localStringBuilder.append("select sql from sqlite_master where tbl_name = '");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("'");
        com.tencent.wcdb.Cursor localCursor2 = paramSQLiteDatabase1.rawQuery(localStringBuilder.toString(), null);
        if (localCursor2 != null)
        {
          if (localCursor2.moveToNext())
          {
            if (localHashSet.contains(localObject2))
            {
              localCursor2.close();
              continue;
            }
            paramSQLiteDatabase2.execSQL(localCursor2.getString(0));
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("select * from ");
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject1 = paramSQLiteDatabase1.rawQuery(((StringBuilder)localObject1).toString(), null);
            if ((localObject1 != null) && (((com.tencent.wcdb.Cursor)localObject1).getCount() > 0))
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("insert into ");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("(");
              if (((com.tencent.wcdb.Cursor)localObject1).getColumnCount() > 0)
              {
                localObject2 = new StringBuilder(" values(");
                localObject3 = ((com.tencent.wcdb.Cursor)localObject1).getColumnNames();
                k = localObject3.length;
                i = 0;
                while (i < k)
                {
                  localStringBuilder.append(localObject3[i]);
                  localStringBuilder.append(",");
                  ((StringBuilder)localObject2).append("?,");
                  i += 1;
                }
                ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                localStringBuilder.append(")");
                localStringBuilder.append((CharSequence)localObject2);
                localStringBuilder.append(")");
              }
              localObject2 = paramSQLiteDatabase2.compileStatement(localStringBuilder.toString());
              paramSQLiteDatabase2.beginTransaction();
              int k = ((com.tencent.wcdb.Cursor)localObject1).getColumnCount();
              Object localObject3 = new int[k];
              ((com.tencent.wcdb.Cursor)localObject1).moveToFirst();
              i = 0;
              while (i < k)
              {
                localObject3[i] = ((com.tencent.wcdb.Cursor)localObject1).getType(i);
                i += 1;
              }
              for (;;)
              {
                i = 0;
                while (i < k)
                {
                  Object localObject4;
                  switch (localObject3[i])
                  {
                  default: 
                    break;
                  case 4: 
                    localObject4 = ((com.tencent.wcdb.Cursor)localObject1).getBlob(i);
                    if (localObject4 != null) {
                      ((SQLiteStatement)localObject2).bindBlob(i + 1, (byte[])localObject4);
                    } else {
                      ((SQLiteStatement)localObject2).bindNull(i + 1);
                    }
                    break;
                  case 3: 
                    localObject4 = ((com.tencent.wcdb.Cursor)localObject1).getString(i);
                    if (localObject4 != null) {
                      ((SQLiteStatement)localObject2).bindString(i + 1, (String)localObject4);
                    } else {
                      ((SQLiteStatement)localObject2).bindNull(i + 1);
                    }
                    break;
                  case 2: 
                    ((SQLiteStatement)localObject2).bindDouble(i + 1, ((com.tencent.wcdb.Cursor)localObject1).getDouble(i));
                    break;
                  case 1: 
                    ((SQLiteStatement)localObject2).bindLong(i + 1, ((com.tencent.wcdb.Cursor)localObject1).getLong(i));
                    break;
                  case 0: 
                    ((SQLiteStatement)localObject2).bindNull(i + 1);
                  }
                  i += 1;
                }
                ((SQLiteStatement)localObject2).executeInsert();
                if (!((com.tencent.wcdb.Cursor)localObject1).moveToNext())
                {
                  paramSQLiteDatabase2.setTransactionSuccessful();
                  paramSQLiteDatabase2.endTransaction();
                  ((com.tencent.wcdb.Cursor)localObject1).close();
                  break;
                }
              }
            }
          }
          localCursor2.close();
        }
      }
      localCursor1.close();
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  public static long b(ev paramev)
  {
    try
    {
      a(paramev);
      long l = paramev.b(a());
      return l;
    }
    catch (Throwable paramev)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
    }
    catch (Exception paramev)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static ev b(ev paramev, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramev = a(paramev, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    if ((paramev != null) && (paramev.size() > 0)) {
      return (ev)paramev.get(0);
    }
    return null;
  }
  
  public static void b()
  {
    eq localeq = a;
    if (localeq != null) {
      try
      {
        localeq.close();
        a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("status_kk");
        localStringBuilder.append(localThrowable.toString());
        localStringBuilder.append(localThrowable.getMessage());
        g.c(localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("status_kk");
        localStringBuilder.append(localException.toString());
        localStringBuilder.append(localException.getMessage());
        g.c(localStringBuilder.toString());
      }
    }
  }
  
  public static long c(ev paramev)
  {
    try
    {
      a(paramev);
      long l = a().replace(paramev.b(), null, paramev.c());
      return l;
    }
    catch (Throwable paramev)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
    }
    catch (Exception paramev)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("status_kk");
      localStringBuilder.append(paramev.toString());
      localStringBuilder.append(paramev.getMessage());
      g.c(localStringBuilder.toString());
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.et
 * JD-Core Version:    0.7.0.1
 */