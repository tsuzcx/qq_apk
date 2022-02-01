package com.tencent.android.tpush.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;

public class a
{
  private static long a = 0L;
  private static long b = 172800000L;
  private static com.tencent.android.tpush.e.a.a c;
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      if (paramContext.delete("messagetoshow", null, null) <= 0)
      {
        TLogger.w("MessageInfoManager", "delAllCacheMessage but no mssgage in db");
        bool = false;
      }
      paramContext.close();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "delAllCacheMessage Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    e(paramContext);
    return a(paramContext, paramLong, 1);
  }
  
  private static boolean a(Context paramContext, long paramLong, int paramInt)
  {
    boolean bool = true;
    ContentValues localContentValues = new ContentValues();
    if ((paramInt == 1) || (paramInt == 2)) {
      localContentValues.put("showedtime", Long.valueOf(System.currentTimeMillis()));
    }
    localContentValues.put("status", Integer.valueOf(paramInt));
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      if (paramContext.update("messagetoshow", localContentValues, "msgid=?", new String[] { paramLong + "" }) <= 0L)
      {
        TLogger.d("MessageInfoManager", "updateCacheMessage Error! msgId:" + paramLong + ", status:" + paramInt);
        bool = false;
      }
      paramContext.close();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "updateCacheMessage Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    long l = paramIntent.getLongExtra("msgId", -1L);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgid", Long.valueOf(l));
    localContentValues.put("message", Rijndael.encrypt(paramIntent.toUri(1)));
    localContentValues.put("time", Long.valueOf(f.b(paramIntent)));
    localContentValues.put("busiid", Long.valueOf(paramIntent.getLongExtra("busiMsgId", 0L)));
    localContentValues.put("showedtime", Integer.valueOf(0));
    localContentValues.put("status", Integer.valueOf(0));
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      if (paramContext.insert("messagetoshow", null, localContentValues) <= 0L)
      {
        TLogger.e("MessageInfoManager", "addCacheMessage Error! ");
        bool = false;
      }
      paramContext.close();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "addNewCacheMessage Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      if (paramContext.delete("messagetoshow", "msgid < 0", null) <= 0)
      {
        TLogger.d("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! ");
        bool = false;
      }
      paramContext.close();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, long paramLong)
  {
    e(paramContext);
    return a(paramContext, paramLong, 2);
  }
  
  /* Error */
  public static java.util.ArrayList<Intent> c(Context paramContext)
  {
    // Byte code:
    //   0: new 190	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 191	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 28	com/tencent/android/tpush/e/a:d	(Landroid/content/Context;)Lcom/tencent/android/tpush/e/a/a;
    //   12: invokevirtual 194	com/tencent/android/tpush/e/a/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_0
    //   16: new 196	android/database/sqlite/SQLiteQueryBuilder
    //   19: dup
    //   20: invokespecial 197	android/database/sqlite/SQLiteQueryBuilder:<init>	()V
    //   23: astore 4
    //   25: aload 4
    //   27: ldc 36
    //   29: invokevirtual 201	android/database/sqlite/SQLiteQueryBuilder:setTables	(Ljava/lang/String;)V
    //   32: aload 4
    //   34: aload_0
    //   35: iconst_1
    //   36: anewarray 115	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc 150
    //   43: aastore
    //   44: ldc 203
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 207	android/database/sqlite/SQLiteQueryBuilder:query	(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +181 -> 238
    //   60: aload 4
    //   62: invokeinterface 213 1 0
    //   67: istore_2
    //   68: iload_2
    //   69: ifeq +162 -> 231
    //   72: aload 4
    //   74: iconst_0
    //   75: invokeinterface 216 2 0
    //   80: invokestatic 219	com/tencent/android/tpush/encrypt/Rijndael:decrypt	(Ljava/lang/String;)Ljava/lang/String;
    //   83: iconst_1
    //   84: invokestatic 223	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   87: astore 5
    //   89: aload 5
    //   91: ldc 225
    //   93: invokevirtual 229	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   96: pop
    //   97: aload 5
    //   99: aconst_null
    //   100: invokevirtual 233	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   103: pop
    //   104: getstatic 239	android/os/Build$VERSION:SDK_INT	I
    //   107: istore_1
    //   108: iload_1
    //   109: bipush 15
    //   111: if_icmplt +36 -> 147
    //   114: aload 5
    //   116: invokevirtual 243	java/lang/Object:getClass	()Ljava/lang/Class;
    //   119: ldc 245
    //   121: iconst_1
    //   122: anewarray 247	java/lang/Class
    //   125: dup
    //   126: iconst_0
    //   127: ldc 142
    //   129: aastore
    //   130: invokevirtual 251	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   133: aload 5
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aconst_null
    //   142: aastore
    //   143: invokevirtual 257	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload_3
    //   148: aload 5
    //   150: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   153: pop
    //   154: goto -94 -> 60
    //   157: astore 5
    //   159: ldc 44
    //   161: new 57	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 263
    //   171: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 5
    //   176: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 74	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -125 -> 60
    //   188: astore_0
    //   189: ldc 44
    //   191: new 57	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 265
    //   201: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 74	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_3
    //   215: areturn
    //   216: astore 6
    //   218: ldc 44
    //   220: ldc_w 267
    //   223: aload 6
    //   225: invokestatic 270	com/tencent/android/tpush/logging/TLogger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: goto -81 -> 147
    //   231: aload 4
    //   233: invokeinterface 271 1 0
    //   238: aload_0
    //   239: invokevirtual 55	android/database/sqlite/SQLiteDatabase:close	()V
    //   242: aload_3
    //   243: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	Context
    //   107	5	1	i	int
    //   67	2	2	bool	boolean
    //   7	236	3	localArrayList	java.util.ArrayList
    //   23	209	4	localObject	Object
    //   87	62	5	localIntent	Intent
    //   157	18	5	localURISyntaxException	java.net.URISyntaxException
    //   216	8	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   72	108	157	java/net/URISyntaxException
    //   114	147	157	java/net/URISyntaxException
    //   147	154	157	java/net/URISyntaxException
    //   218	228	157	java/net/URISyntaxException
    //   8	55	188	java/lang/Throwable
    //   60	68	188	java/lang/Throwable
    //   72	108	188	java/lang/Throwable
    //   147	154	188	java/lang/Throwable
    //   159	185	188	java/lang/Throwable
    //   218	228	188	java/lang/Throwable
    //   231	238	188	java/lang/Throwable
    //   238	242	188	java/lang/Throwable
    //   114	147	216	java/lang/Throwable
  }
  
  public static boolean c(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, 3);
  }
  
  private static com.tencent.android.tpush.e.a.a d(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new com.tencent.android.tpush.e.a.a(paramContext.getApplicationContext());
      }
      return c;
    }
    finally {}
  }
  
  public static boolean d(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, 4);
  }
  
  private static boolean e(Context paramContext)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    long l = System.currentTimeMillis();
    if ((a == 0L) || (l - a > 86400000L))
    {
      a = l;
      l -= b;
    }
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      bool1 = bool2;
      if (paramContext.delete("messagetoshow", "status >= ? AND showedtime < ? ", new String[] { "1", l + "" }) <= 0)
      {
        TLogger.d("MessageInfoManager", "delOldShowedCacheMessage Error! toDelTime: " + l);
        bool1 = false;
      }
      paramContext.close();
      return bool1;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "delOldShowedCacheMessage Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean e(Context paramContext, long paramLong)
  {
    Object localObject = null;
    Context localContext = null;
    for (;;)
    {
      try
      {
        paramContext = d(paramContext).getWritableDatabase();
        localContext = paramContext;
        localObject = paramContext;
        if (paramContext.delete("messagetoshow", "msgid=?", new String[] { paramLong + "" }) > 0) {
          continue;
        }
        localContext = paramContext;
        localObject = paramContext;
        TLogger.d("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + paramLong);
      }
      catch (Throwable paramContext)
      {
        localObject = localContext;
        TLogger.e("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + paramLong + paramContext);
        if (localContext == null) {
          continue;
        }
        try
        {
          localContext.close();
          return false;
        }
        catch (Throwable paramContext)
        {
          TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
          return false;
        }
      }
      finally
      {
        if (localObject == null) {
          break label193;
        }
      }
      try
      {
        paramContext.close();
        return false;
      }
      catch (Throwable paramContext)
      {
        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
        return false;
      }
    }
    if (paramContext != null) {}
    try
    {
      paramContext.close();
      return true;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
      }
    }
    try
    {
      ((SQLiteDatabase)localObject).close();
      label193:
      throw paramContext;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
      }
    }
  }
  
  public static boolean f(Context paramContext, long paramLong)
  {
    boolean bool = true;
    try
    {
      paramContext = d(paramContext).getWritableDatabase();
      if (paramContext.delete("messagetoshow", "busiid=?", new String[] { paramLong + "" }) <= 0)
      {
        TLogger.d("MessageInfoManager", "delCacheMessageByBusiId Error! msgid to delete which busiId = : " + paramLong);
        bool = false;
      }
      paramContext.close();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageInfoManager", "delCacheMessageByBusiId Error! " + paramContext);
    }
    return false;
  }
  
  public static boolean g(Context paramContext, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramContext = d(paramContext).getReadableDatabase();
        Object localObject = new SQLiteQueryBuilder();
        ((SQLiteQueryBuilder)localObject).setTables("messagetoshow");
        String str = paramLong + "";
        localObject = ((SQLiteQueryBuilder)localObject).query(paramContext, new String[] { "message" }, "msgid=?", new String[] { str }, null, null, null);
        if (localObject != null) {
          bool = ((Cursor)localObject).moveToFirst();
        }
        boolean bool = false;
      }
      catch (Throwable paramContext)
      {
        try
        {
          ((Cursor)localObject).close();
        }
        catch (Throwable paramContext)
        {
          continue;
        }
        try
        {
          paramContext.close();
          return bool;
        }
        catch (Throwable paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        TLogger.e("MessageInfoManager", "isMessageCached Error! " + paramContext);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.e.a
 * JD-Core Version:    0.7.0.1
 */