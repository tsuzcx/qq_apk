package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.a;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.proguard.r;>;
import java.util.Map;

public final class p
{
  public static boolean a = false;
  private static p b = null;
  private static q c = null;
  
  private p(Context paramContext, List<a> paramList)
  {
    c = new q(paramContext, paramList);
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: getstatic 18	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   17: invokevirtual 41	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 10
    //   22: aload 10
    //   24: ifnull +21 -> 45
    //   27: aload 10
    //   29: astore 8
    //   31: aload 10
    //   33: astore 9
    //   35: aload 10
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   43: istore 5
    //   45: aload 4
    //   47: ifnull +3 -> 50
    //   50: iload 5
    //   52: istore 6
    //   54: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   57: ifeq +21 -> 78
    //   60: iload 5
    //   62: istore 6
    //   64: aload 10
    //   66: ifnull +12 -> 78
    //   69: aload 10
    //   71: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   74: iload 5
    //   76: istore 6
    //   78: aload_0
    //   79: monitorexit
    //   80: iload 6
    //   82: ireturn
    //   83: astore_1
    //   84: aload 8
    //   86: astore 9
    //   88: aload_1
    //   89: invokestatic 55	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   92: ifne +11 -> 103
    //   95: aload 8
    //   97: astore 9
    //   99: aload_1
    //   100: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   103: aload 4
    //   105: ifnull +3 -> 108
    //   108: iload 7
    //   110: istore 6
    //   112: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   115: ifeq -37 -> 78
    //   118: iload 7
    //   120: istore 6
    //   122: aload 8
    //   124: ifnull -46 -> 78
    //   127: aload 8
    //   129: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: iload 7
    //   134: istore 6
    //   136: goto -58 -> 78
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload 4
    //   147: ifnull +3 -> 150
    //   150: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   153: ifeq +13 -> 166
    //   156: aload 9
    //   158: ifnull +8 -> 166
    //   161: aload 9
    //   163: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	p
    //   0	168	1	paramString1	String
    //   0	168	2	paramString2	String
    //   0	168	3	paramArrayOfString	String[]
    //   0	168	4	paramo	o
    //   4	71	5	i	int
    //   52	83	6	j	int
    //   1	132	7	k	int
    //   12	116	8	localObject1	Object
    //   9	153	9	localObject2	Object
    //   20	50	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	22	83	java/lang/Throwable
    //   35	45	83	java/lang/Throwable
    //   54	60	139	finally
    //   69	74	139	finally
    //   112	118	139	finally
    //   127	132	139	finally
    //   150	156	139	finally
    //   161	166	139	finally
    //   166	168	139	finally
    //   14	22	144	finally
    //   35	45	144	finally
    //   88	95	144	finally
    //   99	103	144	finally
  }
  
  private long a(String paramString, ContentValues paramContentValues, o paramo)
  {
    l2 = 0L;
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c.getWritableDatabase();
        l1 = l2;
        if (localSQLiteDatabase != null)
        {
          l1 = l2;
          if (paramContentValues != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            l1 = localSQLiteDatabase.replace(paramString, "_id", paramContentValues);
            if (l1 < 0L) {
              continue;
            }
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            x.c("[Database] insert %s success.", new Object[] { paramString });
          }
        }
        if (paramo != null) {}
        l3 = l1;
      }
      catch (Throwable paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        long l1;
        localObject2 = localObject1;
        if (!x.a(paramString))
        {
          localObject2 = localObject1;
          paramString.printStackTrace();
        }
        if (paramo != null) {}
        long l3 = l2;
        if (!a) {
          continue;
        }
        l3 = l2;
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        l3 = l2;
        continue;
      }
      finally
      {
        if ((paramo != null) && ((!a) || (localObject2 == null))) {
          continue;
        }
        localObject2.close();
      }
      try
      {
        if (a)
        {
          l3 = l1;
          if (localSQLiteDatabase != null)
          {
            localSQLiteDatabase.close();
            l3 = l1;
          }
        }
        return l3;
      }
      finally {}
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      x.d("[Database] replace %s error.", new Object[] { paramString });
    }
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
      if (localSQLiteDatabase == null) {
        break label80;
      }
      paramString1 = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        if (!x.a(paramString1)) {
          paramString1.printStackTrace();
        }
        if (paramo == null) {
          break;
        }
        paramString1 = null;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          throw paramString1;
        }
        finally {}
        paramString1 = null;
        continue;
        label80:
        paramString1 = null;
      }
    }
    if (paramo != null) {}
    return paramString1;
  }
  
  public static p a()
  {
    try
    {
      p localp = b;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static p a(Context paramContext, List<a> paramList)
  {
    try
    {
      if (b == null) {
        b = new p(paramContext, paramList);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static r a(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        r localr = new r();
        localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localr.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
        localr.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
        localr.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
        localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localr;
      }
      catch (Throwable paramCursor) {}
    } while (x.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private Map<String, byte[]> a(int paramInt, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 148	com/tencent/bugly/proguard/p:c	(I)Ljava/util/List;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +115 -> 124
    //   12: new 150	java/util/HashMap
    //   15: dup
    //   16: invokespecial 151	java/util/HashMap:<init>	()V
    //   19: astore_3
    //   20: aload 4
    //   22: invokeinterface 157 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 163 1 0
    //   36: ifeq +69 -> 105
    //   39: aload 4
    //   41: invokeinterface 167 1 0
    //   46: checkcast 93	com/tencent/bugly/proguard/r
    //   49: astore 5
    //   51: aload 5
    //   53: getfield 144	com/tencent/bugly/proguard/r:g	[B
    //   56: astore 6
    //   58: aload 6
    //   60: ifnull -31 -> 29
    //   63: aload_3
    //   64: aload 5
    //   66: getfield 170	com/tencent/bugly/proguard/r:f	Ljava/lang/String;
    //   69: aload 6
    //   71: invokeinterface 176 3 0
    //   76: pop
    //   77: goto -48 -> 29
    //   80: astore 4
    //   82: aload 4
    //   84: invokestatic 55	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   87: ifne +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   95: aload_3
    //   96: astore 4
    //   98: aload_2
    //   99: ifnull +3 -> 102
    //   102: aload 4
    //   104: areturn
    //   105: aload_3
    //   106: astore 4
    //   108: aload_2
    //   109: ifnull -7 -> 102
    //   112: aload_3
    //   113: areturn
    //   114: astore_2
    //   115: aload_2
    //   116: athrow
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_3
    //   121: goto -39 -> 82
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -21 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	p
    //   0	129	1	paramInt	int
    //   0	129	2	paramo	o
    //   19	107	3	localHashMap	java.util.HashMap
    //   5	35	4	localObject1	Object
    //   80	11	4	localThrowable1	Throwable
    //   96	11	4	localObject2	Object
    //   117	1	4	localThrowable2	Throwable
    //   49	16	5	localr	r
    //   56	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	29	80	java/lang/Throwable
    //   29	58	80	java/lang/Throwable
    //   63	77	80	java/lang/Throwable
    //   0	7	114	finally
    //   12	20	114	finally
    //   20	29	114	finally
    //   29	58	114	finally
    //   63	77	114	finally
    //   82	95	114	finally
    //   0	7	117	java/lang/Throwable
    //   12	20	117	java/lang/Throwable
  }
  
  private boolean a(int paramInt, String paramString, o paramo)
  {
    localObject2 = null;
    localObject1 = null;
    bool2 = true;
    bool3 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (z.a(paramString))
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            paramString = "_id = " + paramInt;
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            paramInt = localSQLiteDatabase.delete("t_pf", paramString, null);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            x.c("[Database] deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
            if (paramInt <= 0) {
              continue;
            }
            bool1 = bool2;
          }
        }
        else
        {
          if (paramo != null) {}
          bool2 = bool1;
        }
      }
      catch (Throwable paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        if (!x.a(paramString))
        {
          localObject2 = localObject1;
          paramString.printStackTrace();
        }
        if (paramo != null) {}
        bool2 = bool3;
        if (!a) {
          continue;
        }
        bool2 = bool3;
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        bool2 = bool3;
        continue;
      }
      finally
      {
        if ((paramo != null) && ((!a) || (localObject2 == null))) {
          continue;
        }
        localObject2.close();
      }
      try
      {
        if (a)
        {
          bool2 = bool1;
          if (localSQLiteDatabase != null)
          {
            localSQLiteDatabase.close();
            bool2 = bool1;
          }
        }
        return bool2;
      }
      finally {}
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      paramString = "_id = " + paramInt + " and _tp" + " = \"" + paramString + "\"";
      continue;
      bool1 = false;
    }
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo)
  {
    boolean bool1 = false;
    try
    {
      r localr = new r();
      localr.a = paramInt;
      localr.f = paramString;
      localr.e = System.currentTimeMillis();
      localr.g = paramArrayOfByte;
      boolean bool2 = b(localr);
      bool1 = bool2;
    }
    catch (Throwable paramString)
    {
      if (x.a(paramString)) {
        break label71;
      }
      paramString.printStackTrace();
      return false;
    }
    finally
    {
      if (paramo == null) {
        break label84;
      }
    }
    return bool1;
  }
  
  private static r b(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        r localr = new r();
        localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localr.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
        localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localr;
      }
      catch (Throwable paramCursor) {}
    } while (x.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  private boolean b(r paramr)
  {
    boolean bool2 = false;
    if (paramr == null) {}
    for (boolean bool1 = bool2;; bool1 = true) {
      for (;;)
      {
        return bool1;
        Object localObject2 = null;
        Object localObject1 = null;
        try
        {
          SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
          if (localSQLiteDatabase != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            ContentValues localContentValues = d(paramr);
            if (localContentValues != null)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              long l = localSQLiteDatabase.replace("t_pf", "_id", localContentValues);
              if (l >= 0L)
              {
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                x.c("[Database] insert %s success.", new Object[] { "t_pf" });
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                paramr.a = l;
              }
              try
              {
                if ((!a) || (localSQLiteDatabase == null)) {
                  break;
                }
                localSQLiteDatabase.close();
              }
              finally {}
              bool1 = bool2;
              if (!a) {
                continue;
              }
              bool1 = bool2;
              if (localSQLiteDatabase == null) {
                continue;
              }
              localSQLiteDatabase.close();
              bool1 = bool2;
              continue;
            }
          }
          bool1 = bool2;
          if (a)
          {
            bool1 = bool2;
            if (localSQLiteDatabase != null)
            {
              localSQLiteDatabase.close();
              bool1 = bool2;
            }
          }
        }
        catch (Throwable paramr)
        {
          localObject2 = localObject1;
          if (!x.a(paramr))
          {
            localObject2 = localObject1;
            paramr.printStackTrace();
          }
          bool1 = bool2;
          if (a)
          {
            bool1 = bool2;
            if (localObject1 != null)
            {
              localObject1.close();
              bool1 = bool2;
            }
          }
        }
        finally
        {
          if ((a) && (localObject2 != null)) {
            localObject2.close();
          }
        }
      }
    }
  }
  
  private static ContentValues c(r paramr)
  {
    if (paramr == null) {}
    do
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramr.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramr.a));
        }
        localContentValues.put("_tp", Integer.valueOf(paramr.b));
        localContentValues.put("_pc", paramr.c);
        localContentValues.put("_th", paramr.d);
        localContentValues.put("_tm", Long.valueOf(paramr.e));
        if (paramr.g != null) {
          localContentValues.put("_dt", paramr.g);
        }
        return localContentValues;
      }
      catch (Throwable paramr) {}
    } while (x.a(paramr));
    paramr.printStackTrace();
    return null;
  }
  
  /* Error */
  private List<r> c(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 18	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   8: invokevirtual 41	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +349 -> 362
    //   16: new 188	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 190
    //   22: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_1
    //   26: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload_2
    //   35: ldc 203
    //   37: aconst_null
    //   38: aload 5
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 262	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnonnull +33 -> 82
    //   52: aload_3
    //   53: ifnull +9 -> 62
    //   56: aload_3
    //   57: invokeinterface 263 1 0
    //   62: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   65: ifeq +11 -> 76
    //   68: aload_2
    //   69: ifnull +7 -> 76
    //   72: aload_2
    //   73: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: areturn
    //   82: new 188	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   89: astore 6
    //   91: new 266	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 267	java/util/ArrayList:<init>	()V
    //   98: astore 4
    //   100: aload_3
    //   101: invokeinterface 270 1 0
    //   106: ifeq +167 -> 273
    //   109: aload_3
    //   110: invokestatic 272	com/tencent/bugly/proguard/p:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   113: astore 7
    //   115: aload 7
    //   117: ifnull +60 -> 177
    //   120: aload 4
    //   122: aload 7
    //   124: invokeinterface 276 2 0
    //   129: pop
    //   130: goto -30 -> 100
    //   133: astore 4
    //   135: aload 4
    //   137: invokestatic 55	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   140: ifne +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   148: aload_3
    //   149: ifnull +9 -> 158
    //   152: aload_3
    //   153: invokeinterface 263 1 0
    //   158: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   161: ifeq +11 -> 172
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   172: aconst_null
    //   173: astore_2
    //   174: goto -96 -> 78
    //   177: aload_3
    //   178: aload_3
    //   179: ldc 109
    //   181: invokeinterface 100 2 0
    //   186: invokeinterface 122 2 0
    //   191: astore 7
    //   193: aload 6
    //   195: ldc_w 278
    //   198: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 280
    //   204: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 7
    //   209: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: goto -113 -> 100
    //   216: astore 7
    //   218: ldc_w 282
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 78	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   228: pop
    //   229: goto -129 -> 100
    //   232: astore 5
    //   234: aload_2
    //   235: astore 4
    //   237: aload 5
    //   239: astore_2
    //   240: aload_3
    //   241: ifnull +9 -> 250
    //   244: aload_3
    //   245: invokeinterface 263 1 0
    //   250: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   253: ifeq +13 -> 266
    //   256: aload 4
    //   258: ifnull +8 -> 266
    //   261: aload 4
    //   263: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   266: aload_2
    //   267: athrow
    //   268: astore_2
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_2
    //   272: athrow
    //   273: aload 6
    //   275: invokevirtual 286	java/lang/StringBuilder:length	()I
    //   278: ifle +57 -> 335
    //   281: aload 6
    //   283: ldc_w 288
    //   286: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 280
    //   292: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_1
    //   296: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: ldc_w 290
    //   303: iconst_2
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: ldc 203
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: aload_2
    //   315: ldc 203
    //   317: aload 5
    //   319: iconst_4
    //   320: invokevirtual 295	java/lang/String:substring	(I)Ljava/lang/String;
    //   323: aconst_null
    //   324: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   327: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: invokestatic 78	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   334: pop
    //   335: aload_3
    //   336: ifnull +9 -> 345
    //   339: aload_3
    //   340: invokeinterface 263 1 0
    //   345: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   348: ifeq +77 -> 425
    //   351: aload_2
    //   352: ifnull +73 -> 425
    //   355: aload_2
    //   356: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   359: goto +66 -> 425
    //   362: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   365: ifeq -193 -> 172
    //   368: aload_2
    //   369: ifnull -197 -> 172
    //   372: aload_2
    //   373: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   376: goto -204 -> 172
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_3
    //   382: goto -142 -> 240
    //   385: astore 5
    //   387: aconst_null
    //   388: astore_3
    //   389: aload_2
    //   390: astore 4
    //   392: aload 5
    //   394: astore_2
    //   395: goto -155 -> 240
    //   398: astore 5
    //   400: aload_2
    //   401: astore 4
    //   403: aload 5
    //   405: astore_2
    //   406: goto -166 -> 240
    //   409: astore 4
    //   411: aconst_null
    //   412: astore_2
    //   413: aconst_null
    //   414: astore_3
    //   415: goto -280 -> 135
    //   418: astore 4
    //   420: aconst_null
    //   421: astore_3
    //   422: goto -287 -> 135
    //   425: aload 4
    //   427: astore_2
    //   428: goto -350 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	p
    //   0	431	1	paramInt	int
    //   11	256	2	localObject1	Object
    //   268	105	2	localObject2	Object
    //   379	11	2	localObject3	Object
    //   394	34	2	localObject4	Object
    //   47	375	3	localCursor	Cursor
    //   1	120	4	localArrayList	java.util.ArrayList
    //   133	11	4	localThrowable1	Throwable
    //   235	167	4	localObject5	Object
    //   409	1	4	localThrowable2	Throwable
    //   418	8	4	localThrowable3	Throwable
    //   32	7	5	str	String
    //   232	86	5	localObject6	Object
    //   385	8	5	localObject7	Object
    //   398	6	5	localObject8	Object
    //   89	193	6	localStringBuilder	StringBuilder
    //   113	95	7	localObject9	Object
    //   216	1	7	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   82	100	133	java/lang/Throwable
    //   100	115	133	java/lang/Throwable
    //   120	130	133	java/lang/Throwable
    //   218	229	133	java/lang/Throwable
    //   273	335	133	java/lang/Throwable
    //   177	213	216	java/lang/Throwable
    //   82	100	232	finally
    //   100	115	232	finally
    //   120	130	232	finally
    //   177	213	232	finally
    //   218	229	232	finally
    //   273	335	232	finally
    //   56	62	268	finally
    //   62	68	268	finally
    //   72	76	268	finally
    //   152	158	268	finally
    //   158	164	268	finally
    //   168	172	268	finally
    //   244	250	268	finally
    //   250	256	268	finally
    //   261	266	268	finally
    //   266	268	268	finally
    //   339	345	268	finally
    //   345	351	268	finally
    //   355	359	268	finally
    //   362	368	268	finally
    //   372	376	268	finally
    //   5	12	379	finally
    //   16	48	385	finally
    //   135	148	398	finally
    //   5	12	409	java/lang/Throwable
    //   16	48	418	java/lang/Throwable
  }
  
  private static ContentValues d(r paramr)
  {
    Object localObject;
    if ((paramr == null) || (z.a(paramr.f))) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramr.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramr.a));
        }
        localContentValues.put("_tp", paramr.f);
        localContentValues.put("_tm", Long.valueOf(paramr.e));
        localObject = localContentValues;
        if (paramr.g != null)
        {
          localContentValues.put("_dt", paramr.g);
          return localContentValues;
        }
      }
      catch (Throwable paramr)
      {
        if (!x.a(paramr)) {
          paramr.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  /* Error */
  public final List<r> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 18	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual 41	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnull +214 -> 226
    //   15: iload_1
    //   16: iflt +80 -> 96
    //   19: new 188	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 301
    //   26: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_1
    //   30: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 4
    //   38: aload 7
    //   40: ldc_w 303
    //   43: aconst_null
    //   44: aload 4
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 262	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnonnull +45 -> 102
    //   60: aload 5
    //   62: ifnull +10 -> 72
    //   65: aload 5
    //   67: invokeinterface 263 1 0
    //   72: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   75: ifeq +13 -> 88
    //   78: aload 7
    //   80: ifnull +8 -> 88
    //   83: aload 7
    //   85: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   88: aconst_null
    //   89: astore 4
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: areturn
    //   96: aconst_null
    //   97: astore 4
    //   99: goto -61 -> 38
    //   102: aload 5
    //   104: astore 4
    //   106: new 188	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   113: astore 8
    //   115: aload 5
    //   117: astore 4
    //   119: new 266	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 267	java/util/ArrayList:<init>	()V
    //   126: astore 6
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: invokeinterface 270 1 0
    //   139: ifeq +208 -> 347
    //   142: aload 5
    //   144: astore 4
    //   146: aload 5
    //   148: invokestatic 305	com/tencent/bugly/proguard/p:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   151: astore 9
    //   153: aload 9
    //   155: ifnull +77 -> 232
    //   158: aload 5
    //   160: astore 4
    //   162: aload 6
    //   164: aload 9
    //   166: invokeinterface 276 2 0
    //   171: pop
    //   172: goto -44 -> 128
    //   175: astore 6
    //   177: aload 5
    //   179: astore 4
    //   181: aload 6
    //   183: invokestatic 55	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   186: ifne +12 -> 198
    //   189: aload 5
    //   191: astore 4
    //   193: aload 6
    //   195: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   198: aload 5
    //   200: ifnull +10 -> 210
    //   203: aload 5
    //   205: invokeinterface 263 1 0
    //   210: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   213: ifeq +13 -> 226
    //   216: aload 7
    //   218: ifnull +8 -> 226
    //   221: aload 7
    //   223: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   226: aconst_null
    //   227: astore 4
    //   229: goto -138 -> 91
    //   232: aload 5
    //   234: astore 4
    //   236: aload 5
    //   238: aload 5
    //   240: ldc 64
    //   242: invokeinterface 100 2 0
    //   247: invokeinterface 104 2 0
    //   252: lstore_2
    //   253: aload 5
    //   255: astore 4
    //   257: aload 8
    //   259: ldc_w 307
    //   262: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 280
    //   268: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: lload_2
    //   272: invokevirtual 310	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: goto -148 -> 128
    //   279: astore 4
    //   281: aload 5
    //   283: astore 4
    //   285: ldc_w 282
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 78	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -168 -> 128
    //   299: astore 6
    //   301: aload 4
    //   303: astore 5
    //   305: aload 6
    //   307: astore 4
    //   309: aload 5
    //   311: ifnull +10 -> 321
    //   314: aload 5
    //   316: invokeinterface 263 1 0
    //   321: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   324: ifeq +13 -> 337
    //   327: aload 7
    //   329: ifnull +8 -> 337
    //   332: aload 7
    //   334: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   337: aload 4
    //   339: athrow
    //   340: astore 4
    //   342: aload_0
    //   343: monitorexit
    //   344: aload 4
    //   346: athrow
    //   347: aload 5
    //   349: astore 4
    //   351: aload 8
    //   353: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore 8
    //   358: aload 5
    //   360: astore 4
    //   362: aload 8
    //   364: invokevirtual 311	java/lang/String:length	()I
    //   367: ifle +45 -> 412
    //   370: aload 5
    //   372: astore 4
    //   374: ldc_w 313
    //   377: iconst_2
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: ldc_w 303
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: aload 7
    //   391: ldc_w 303
    //   394: aload 8
    //   396: iconst_4
    //   397: invokevirtual 295	java/lang/String:substring	(I)Ljava/lang/String;
    //   400: aconst_null
    //   401: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   404: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokestatic 78	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   411: pop
    //   412: aload 5
    //   414: ifnull +10 -> 424
    //   417: aload 5
    //   419: invokeinterface 263 1 0
    //   424: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   427: ifeq +13 -> 440
    //   430: aload 7
    //   432: ifnull +8 -> 440
    //   435: aload 7
    //   437: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   440: aload 6
    //   442: astore 4
    //   444: goto -353 -> 91
    //   447: astore 4
    //   449: aconst_null
    //   450: astore 5
    //   452: goto -143 -> 309
    //   455: astore 6
    //   457: aconst_null
    //   458: astore 5
    //   460: goto -283 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	p
    //   0	463	1	paramInt	int
    //   252	20	2	l	long
    //   36	220	4	localObject1	Object
    //   279	1	4	localThrowable1	Throwable
    //   283	55	4	localObject2	Object
    //   340	5	4	localObject3	Object
    //   349	94	4	localObject4	Object
    //   447	1	4	localObject5	Object
    //   53	406	5	localObject6	Object
    //   126	37	6	localArrayList	java.util.ArrayList
    //   175	19	6	localThrowable2	Throwable
    //   299	142	6	localObject7	Object
    //   455	1	6	localThrowable3	Throwable
    //   8	428	7	localSQLiteDatabase	SQLiteDatabase
    //   113	282	8	localObject8	Object
    //   151	14	9	localr	r
    // Exception table:
    //   from	to	target	type
    //   106	115	175	java/lang/Throwable
    //   119	128	175	java/lang/Throwable
    //   132	142	175	java/lang/Throwable
    //   146	153	175	java/lang/Throwable
    //   162	172	175	java/lang/Throwable
    //   285	296	175	java/lang/Throwable
    //   351	358	175	java/lang/Throwable
    //   362	370	175	java/lang/Throwable
    //   374	412	175	java/lang/Throwable
    //   236	253	279	java/lang/Throwable
    //   257	276	279	java/lang/Throwable
    //   106	115	299	finally
    //   119	128	299	finally
    //   132	142	299	finally
    //   146	153	299	finally
    //   162	172	299	finally
    //   181	189	299	finally
    //   193	198	299	finally
    //   236	253	299	finally
    //   257	276	299	finally
    //   285	296	299	finally
    //   351	358	299	finally
    //   362	370	299	finally
    //   374	412	299	finally
    //   2	10	340	finally
    //   65	72	340	finally
    //   72	78	340	finally
    //   83	88	340	finally
    //   203	210	340	finally
    //   210	216	340	finally
    //   221	226	340	finally
    //   314	321	340	finally
    //   321	327	340	finally
    //   332	337	340	finally
    //   337	340	340	finally
    //   417	424	340	finally
    //   424	430	340	finally
    //   435	440	340	finally
    //   19	38	447	finally
    //   38	55	447	finally
    //   19	38	455	java/lang/Throwable
    //   38	55	455	java/lang/Throwable
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  public final void a(List<r> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      StringBuilder localStringBuilder;
      Object localObject;
      try
      {
        int i = paramList.size();
        if (i == 0) {
          return;
        }
        localSQLiteDatabase = c.getWritableDatabase();
        if (localSQLiteDatabase == null) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (r)paramList.next();
          localStringBuilder.append(" or _id").append(" = ").append(((r)localObject).a);
          continue;
        }
        localObject = localStringBuilder.toString();
      }
      finally {}
      paramList = (List<r>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        x.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", paramList, null)) });
        if (!a) {
          continue;
        }
        localSQLiteDatabase.close();
      }
      catch (Throwable paramList)
      {
        if (!x.a(paramList)) {
          paramList.printStackTrace();
        }
        if (!a) {
          continue;
        }
        localSQLiteDatabase.close();
      }
      finally
      {
        if (a) {
          localSQLiteDatabase.close();
        }
      }
    }
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramo = new a(4, null);
      paramo.a(paramInt, paramString, paramArrayOfByte);
      w.a().a(paramo);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  public final boolean a(r paramr)
  {
    boolean bool2 = false;
    if (paramr == null) {}
    for (boolean bool1 = bool2;; bool1 = true) {
      for (;;)
      {
        return bool1;
        Object localObject2 = null;
        Object localObject1 = null;
        try
        {
          SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
          if (localSQLiteDatabase != null)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            ContentValues localContentValues = c(paramr);
            if (localContentValues != null)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              long l = localSQLiteDatabase.replace("t_lr", "_id", localContentValues);
              if (l >= 0L)
              {
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                x.c("[Database] insert %s success.", new Object[] { "t_lr" });
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                paramr.a = l;
              }
              try
              {
                if ((!a) || (localSQLiteDatabase == null)) {
                  break;
                }
                localSQLiteDatabase.close();
              }
              finally {}
              bool1 = bool2;
              if (!a) {
                continue;
              }
              bool1 = bool2;
              if (localSQLiteDatabase == null) {
                continue;
              }
              localSQLiteDatabase.close();
              bool1 = bool2;
              continue;
            }
          }
          bool1 = bool2;
          if (a)
          {
            bool1 = bool2;
            if (localSQLiteDatabase != null)
            {
              localSQLiteDatabase.close();
              bool1 = bool2;
            }
          }
        }
        catch (Throwable paramr)
        {
          localObject2 = localObject1;
          if (!x.a(paramr))
          {
            localObject2 = localObject1;
            paramr.printStackTrace();
          }
          bool1 = bool2;
          if (a)
          {
            bool1 = bool2;
            if (localObject1 != null)
            {
              localObject1.close();
              bool1 = bool2;
            }
          }
        }
        finally
        {
          if ((a) && (localObject2 != null)) {
            localObject2.close();
          }
        }
      }
    }
  }
  
  /* Error */
  public final void b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 18	com/tencent/bugly/proguard/p:c	Lcom/tencent/bugly/proguard/q;
    //   7: invokevirtual 41	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +70 -> 82
    //   15: iload_1
    //   16: iflt +21 -> 37
    //   19: new 188	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 301
    //   26: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_1
    //   30: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: ldc 205
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: ldc_w 303
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_3
    //   52: ldc_w 303
    //   55: aload_2
    //   56: aconst_null
    //   57: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   60: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: invokestatic 73	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   71: ifeq +11 -> 82
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_2
    //   86: aload_2
    //   87: invokestatic 55	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   90: ifne +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 58	java/lang/Throwable:printStackTrace	()V
    //   97: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   100: ifeq -18 -> 82
    //   103: aload_3
    //   104: ifnull -22 -> 82
    //   107: aload_3
    //   108: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   111: goto -29 -> 82
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_2
    //   120: getstatic 20	com/tencent/bugly/proguard/p:a	Z
    //   123: ifeq +11 -> 134
    //   126: aload_3
    //   127: ifnull +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 50	android/database/sqlite/SQLiteDatabase:close	()V
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	p
    //   0	136	1	paramInt	int
    //   1	55	2	str	String
    //   85	9	2	localThrowable	Throwable
    //   114	4	2	localObject1	Object
    //   119	16	2	localObject2	Object
    //   10	121	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   19	37	85	java/lang/Throwable
    //   37	68	85	java/lang/Throwable
    //   4	11	114	finally
    //   68	74	114	finally
    //   78	82	114	finally
    //   97	103	114	finally
    //   107	111	114	finally
    //   120	126	114	finally
    //   130	134	114	finally
    //   134	136	114	finally
    //   19	37	119	finally
    //   37	68	119	finally
    //   86	97	119	finally
  }
  
  final class a
    extends Thread
  {
    private int a;
    private o b;
    private String c;
    private ContentValues d;
    private boolean e;
    private String[] f;
    private String g;
    private String[] h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String[] n;
    private int o;
    private String p;
    private byte[] q;
    
    public a(int paramInt, o paramo)
    {
      this.a = paramInt;
      this.b = paramo;
    }
    
    public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
    {
      this.o = paramInt;
      this.p = paramString;
      this.q = paramArrayOfByte;
    }
    
    public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.e = paramBoolean;
      this.c = paramString1;
      this.f = paramArrayOfString1;
      this.g = paramString2;
      this.h = paramArrayOfString2;
      this.i = paramString3;
      this.j = paramString4;
      this.k = paramString5;
      this.l = paramString6;
    }
    
    public final void run()
    {
      switch (this.a)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
        Cursor localCursor;
        do
        {
          return;
          p.a(p.this, this.c, this.d, this.b);
          return;
          p.a(p.this, this.c, this.m, this.n, this.b);
          return;
          localCursor = p.a(p.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        } while (localCursor == null);
        localCursor.close();
        return;
      case 4: 
        p.a(p.this, this.o, this.p, this.q, this.b);
        return;
      case 5: 
        p.a(p.this, this.o, this.b);
        return;
      }
      p.a(p.this, this.o, this.p, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.p
 * JD-Core Version:    0.7.0.1
 */