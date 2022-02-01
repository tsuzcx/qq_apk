package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.token.afw;
import com.tencent.token.afx;
import com.tencent.token.afy;
import com.tencent.token.afz;
import com.tencent.token.age;
import com.tencent.token.agg;
import com.tencent.token.agh;
import com.tencent.token.agi;
import com.tencent.token.agk;
import com.tencent.token.agm;
import com.tencent.token.agn;
import com.tencent.token.ago;
import com.tencent.token.agq;
import com.tencent.token.ags;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase
  extends age
{
  private static final WeakHashMap<SQLiteDatabase, Object> e = new WeakHashMap();
  private static final String[] j = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  public final Object a = new Object();
  public final agh b;
  public SQLiteConnectionPool c;
  private final ThreadLocal<agn> f = new ThreadLocal() {};
  private final a g;
  private final afx h;
  private boolean i;
  
  static
  {
    SQLiteGlobal.a();
  }
  
  private SQLiteDatabase(String paramString, int paramInt, a parama, afx paramafx)
  {
    this.g = parama;
    if (paramafx == null) {
      paramafx = new afz((byte)0);
    }
    this.h = paramafx;
    this.b = new agh(paramString, paramInt);
  }
  
  public static int a(boolean paramBoolean)
  {
    int m = 1;
    int k;
    if (paramBoolean) {
      k = 1;
    } else {
      k = 2;
    }
    Looper localLooper = Looper.myLooper();
    if ((localLooper == null) || (localLooper != Looper.getMainLooper())) {
      m = 0;
    }
    int n = k;
    if (m != 0) {
      n = k | 0x4;
    }
    return n;
  }
  
  private long a(String paramString, ContentValues paramContentValues, int paramInt)
  {
    d();
    for (;;)
    {
      Object[] arrayOfObject;
      int k;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("INSERT");
        localStringBuilder.append(j[paramInt]);
        localStringBuilder.append(" INTO ");
        localStringBuilder.append(paramString);
        localStringBuilder.append('(');
        int m = 0;
        if ((paramContentValues != null) && (paramContentValues.size() > 0))
        {
          paramInt = paramContentValues.size();
          paramString = null;
          if (paramInt > 0)
          {
            arrayOfObject = new Object[paramInt];
            Iterator localIterator = a(paramContentValues).iterator();
            k = 0;
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (k <= 0) {
                break label300;
              }
              paramString = ",";
              localStringBuilder.append(paramString);
              localStringBuilder.append(str);
              arrayOfObject[k] = paramContentValues.get(str);
              k += 1;
              continue;
            }
            localStringBuilder.append(')');
            localStringBuilder.append(" VALUES (");
            k = m;
            break label306;
            localStringBuilder.append(paramString);
            k += 1;
            break label306;
          }
          paramContentValues = new StringBuilder();
          paramContentValues.append(null);
          paramContentValues.append(") VALUES (NULL");
          localStringBuilder.append(paramContentValues.toString());
          localStringBuilder.append(')');
          paramString = new ago(this, localStringBuilder.toString(), paramString);
          try
          {
            long l = paramString.f();
            return l;
          }
          finally {}
        }
        paramInt = 0;
      }
      finally
      {
        e();
      }
      continue;
      label300:
      paramString = "";
      continue;
      label306:
      paramString = arrayOfObject;
      if (k < paramInt) {
        if (k > 0) {
          paramString = ",?";
        } else {
          paramString = "?";
        }
      }
    }
  }
  
  public static SQLiteDatabase a(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, afx paramafx)
  {
    return a(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, null, 268435456, paramafx);
  }
  
  public static SQLiteDatabase a(String paramString, int paramInt, afx paramafx)
  {
    return a(paramString, null, null, null, paramInt, paramafx);
  }
  
  public static SQLiteDatabase a(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, a parama, int paramInt, afx paramafx)
  {
    paramString = new SQLiteDatabase(paramString, paramInt, parama, paramafx);
    try
    {
      paramString.a(paramArrayOfByte, paramSQLiteCipherSpec);
      return paramString;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      break label38;
      paramString.a();
      paramString.a(paramArrayOfByte, paramSQLiteCipherSpec);
      return paramString;
      paramSQLiteCipherSpec = new StringBuilder("Failed to open database '");
      paramSQLiteCipherSpec.append(paramString.s());
      paramSQLiteCipherSpec.append("'.");
      Log.a("WCDB.SQLiteDatabase", paramSQLiteCipherSpec.toString(), new Object[] { paramArrayOfByte });
      paramString.close();
      throw paramArrayOfByte;
    }
    catch (SQLiteDatabaseCorruptException parama)
    {
      label26:
      label38:
      break label26;
    }
  }
  
  private static Set<String> a(ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT < 11) {
      try
      {
        Field localField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
        localField.setAccessible(true);
        paramContentValues = ((HashMap)localField.get(paramContentValues)).keySet();
        return paramContentValues;
      }
      catch (Exception paramContentValues)
      {
        throw new RuntimeException(paramContentValues);
      }
    }
    return paramContentValues.keySet();
  }
  
  private void a(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    synchronized (this.a)
    {
      if ((!d) && (this.c != null)) {
        throw new AssertionError();
      }
      this.c = SQLiteConnectionPool.a(this, this.b, ???, paramSQLiteCipherSpec);
      synchronized (e)
      {
        e.put(this, null);
        return;
      }
    }
  }
  
  private afw b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    d();
    for (;;)
    {
      int k;
      int m;
      try
      {
        paramString2 = agm.a(paramString1, paramArrayOfString1, paramString2, null, null, paramString3, paramString4);
        if (!TextUtils.isEmpty(paramString1))
        {
          k = paramString1.indexOf(' ');
          m = paramString1.indexOf(',');
          if ((k > 0) && ((k < m) || (m < 0)))
          {
            paramArrayOfString1 = paramString1.substring(0, k);
            continue;
            paramArrayOfString1 = paramString1.substring(0, m);
            paramString1 = a(paramString2, paramArrayOfString2, paramArrayOfString1);
            return paramString1;
          }
        }
        else
        {
          throw new IllegalStateException("Invalid tables");
        }
      }
      finally
      {
        e();
      }
      paramArrayOfString1 = paramString1;
      if (m > 0) {
        if (m >= k)
        {
          paramArrayOfString1 = paramString1;
          if (k >= 0) {}
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      SQLiteConnectionPool localSQLiteConnectionPool = this.c;
      this.c = null;
      if (!paramBoolean) {
        synchronized (e)
        {
          e.remove(this);
          if (localSQLiteConnectionPool != null)
          {
            localSQLiteConnectionPool.close();
            return;
          }
        }
      }
      return;
    }
  }
  
  public static SQLiteDatabase j()
  {
    return a(":memory:", 268435456, null);
  }
  
  private String s()
  {
    synchronized (this.a)
    {
      String str = this.b.b;
      return str;
    }
  }
  
  public final int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    if ((paramContentValues != null) && (paramContentValues.size() != 0)) {
      d();
    }
    for (;;)
    {
      Object localObject;
      int n;
      int k;
      int m;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(120);
        localStringBuilder.append("UPDATE ");
        localObject = j;
        n = 0;
        localStringBuilder.append(localObject[0]);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" SET ");
        k = paramContentValues.size();
        if (paramArrayOfString == null) {
          m = k;
        } else {
          m = paramArrayOfString.length + k;
        }
        localObject = new Object[m];
        Iterator localIterator = a(paramContentValues).iterator();
        if (!localIterator.hasNext()) {
          break label277;
        }
        String str = (String)localIterator.next();
        if (n > 0)
        {
          paramString1 = ",";
          localStringBuilder.append(paramString1);
          localStringBuilder.append(str);
          localObject[n] = paramContentValues.get(str);
          localStringBuilder.append("=?");
          n += 1;
          continue;
          if (!TextUtils.isEmpty(paramString2))
          {
            localStringBuilder.append(" WHERE ");
            localStringBuilder.append(paramString2);
          }
          paramString1 = new ago(this, localStringBuilder.toString(), (Object[])localObject);
          try
          {
            k = paramString1.b();
            return k;
          }
          finally {}
          throw new IllegalArgumentException("Empty values");
        }
      }
      finally
      {
        e();
      }
      paramString1 = "";
      continue;
      label277:
      if (paramArrayOfString != null)
      {
        n = k;
        while (n < m)
        {
          localObject[n] = paramArrayOfString[(n - k)];
          n += 1;
        }
      }
    }
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    d();
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("DELETE FROM ");
        localStringBuilder.append(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = " WHERE ".concat(String.valueOf(paramString2));
          localStringBuilder.append(paramString1);
          paramString1 = new ago(this, localStringBuilder.toString(), paramArrayOfString);
          try
          {
            int k = paramString1.b();
            return k;
          }
          finally {}
        }
        paramString1 = "";
      }
      finally
      {
        e();
      }
    }
  }
  
  public final long a(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = a(paramString, paramContentValues, 0);
      return l;
    }
    catch (SQLException paramString)
    {
      Log.a("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString)
    {
      throw paramString;
    }
  }
  
  public final afw a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    d();
    try
    {
      paramString1 = new agi(this, paramString1, paramString2).a(this.g, paramArrayOfString);
      return paramString1;
    }
    finally
    {
      e();
    }
  }
  
  public final afw a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return b(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4);
  }
  
  public final ago a(String paramString)
  {
    d();
    try
    {
      paramString = new ago(this, paramString, null);
      return paramString;
    }
    finally
    {
      e();
    }
  }
  
  public final void a()
  {
    this.h.a(this);
  }
  
  /* Error */
  public final int b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 111	com/tencent/wcdb/database/SQLiteDatabase:d	()V
    //   4: aload_1
    //   5: invokestatic 377	com/tencent/token/afy:b	(Ljava/lang/String;)I
    //   8: iconst_3
    //   9: if_icmpne +131 -> 140
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 82	com/tencent/wcdb/database/SQLiteDatabase:a	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 379	com/tencent/wcdb/database/SQLiteDatabase:i	Z
    //   25: ifne +10 -> 35
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 379	com/tencent/wcdb/database/SQLiteDatabase:i	Z
    //   33: iconst_1
    //   34: istore_2
    //   35: aload_3
    //   36: monitorexit
    //   37: iload_2
    //   38: ifeq +102 -> 140
    //   41: aload_0
    //   42: getfield 82	com/tencent/wcdb/database/SQLiteDatabase:a	Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_3
    //   47: monitorenter
    //   48: aload_0
    //   49: invokevirtual 382	com/tencent/wcdb/database/SQLiteDatabase:r	()V
    //   52: aload_0
    //   53: getfield 98	com/tencent/wcdb/database/SQLiteDatabase:b	Lcom/tencent/token/agh;
    //   56: getfield 384	com/tencent/token/agh:d	I
    //   59: ldc_w 385
    //   62: iand
    //   63: ifne +8 -> 71
    //   66: aload_3
    //   67: monitorexit
    //   68: goto +72 -> 140
    //   71: aload_0
    //   72: getfield 98	com/tencent/wcdb/database/SQLiteDatabase:b	Lcom/tencent/token/agh;
    //   75: astore 4
    //   77: aload 4
    //   79: aload 4
    //   81: getfield 384	com/tencent/token/agh:d	I
    //   84: ldc_w 386
    //   87: iand
    //   88: putfield 384	com/tencent/token/agh:d	I
    //   91: aload_0
    //   92: getfield 264	com/tencent/wcdb/database/SQLiteDatabase:c	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   95: aload_0
    //   96: getfield 98	com/tencent/wcdb/database/SQLiteDatabase:b	Lcom/tencent/token/agh;
    //   99: invokevirtual 389	com/tencent/wcdb/database/SQLiteConnectionPool:a	(Lcom/tencent/token/agh;)V
    //   102: aload_3
    //   103: monitorexit
    //   104: goto +36 -> 140
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 98	com/tencent/wcdb/database/SQLiteDatabase:b	Lcom/tencent/token/agh;
    //   112: astore 4
    //   114: aload 4
    //   116: ldc_w 385
    //   119: aload 4
    //   121: getfield 384	com/tencent/token/agh:d	I
    //   124: ior
    //   125: putfield 384	com/tencent/token/agh:d	I
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_3
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_3
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: new 165	com/tencent/token/ago
    //   143: dup
    //   144: aload_0
    //   145: aload_1
    //   146: aconst_null
    //   147: invokespecial 168	com/tencent/token/ago:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 330	com/tencent/token/ago:b	()I
    //   155: istore_2
    //   156: aload_1
    //   157: invokevirtual 174	com/tencent/token/ago:close	()V
    //   160: aload_0
    //   161: invokevirtual 176	com/tencent/wcdb/database/SQLiteDatabase:e	()V
    //   164: iload_2
    //   165: ireturn
    //   166: astore_3
    //   167: aload_1
    //   168: invokevirtual 174	com/tencent/token/ago:close	()V
    //   171: aload_3
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: invokevirtual 176	com/tencent/wcdb/database/SQLiteDatabase:e	()V
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	SQLiteDatabase
    //   0	180	1	paramString	String
    //   13	152	2	k	int
    //   166	6	3	localObject2	Object
    //   75	45	4	localagh	agh
    // Exception table:
    //   from	to	target	type
    //   91	102	107	java/lang/RuntimeException
    //   48	68	130	finally
    //   71	91	130	finally
    //   91	102	130	finally
    //   102	104	130	finally
    //   108	130	130	finally
    //   131	133	130	finally
    //   21	33	135	finally
    //   35	37	135	finally
    //   136	138	135	finally
    //   151	156	166	finally
    //   4	12	173	finally
    //   14	21	173	finally
    //   41	48	173	finally
    //   133	135	173	finally
    //   138	140	173	finally
    //   140	151	173	finally
    //   156	160	173	finally
    //   167	173	173	finally
  }
  
  public final long b(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = a(paramString, paramContentValues, 5);
      return l;
    }
    catch (SQLException paramString)
    {
      Log.a("WCDB.SQLiteDatabase", "Error inserting ".concat(String.valueOf(paramContentValues)), new Object[] { paramString });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString)
    {
      throw paramString;
    }
  }
  
  public final agn b()
  {
    return (agn)this.f.get();
  }
  
  public final void c()
  {
    b(false);
  }
  
  final agn f()
  {
    synchronized (this.a)
    {
      r();
      SQLiteConnectionPool localSQLiteConnectionPool = this.c;
      return new agn(localSQLiteConnectionPool);
    }
  }
  
  protected final void finalize()
  {
    try
    {
      b(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final void g()
  {
    d();
    try
    {
      b().a(a(false), null);
      return;
    }
    finally
    {
      e();
    }
  }
  
  public final void h()
  {
    d();
    try
    {
      b().a(null);
      return;
    }
    finally
    {
      e();
    }
  }
  
  public final void i()
  {
    d();
    try
    {
      b().a();
      return;
    }
    finally
    {
      e();
    }
  }
  
  public final int k()
  {
    return Long.valueOf(afy.a(this, "PRAGMA user_version;")).intValue();
  }
  
  public final boolean l()
  {
    synchronized (this.a)
    {
      boolean bool = m();
      return bool;
    }
  }
  
  public final boolean m()
  {
    return (this.b.d & 0x1) == 1;
  }
  
  public final boolean n()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.c != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final String o()
  {
    synchronized (this.a)
    {
      String str = this.b.a;
      return str;
    }
  }
  
  public final agq p()
  {
    synchronized (this.a)
    {
      r();
      agq localagq = this.c.c;
      return localagq;
    }
  }
  
  /* Error */
  public final java.util.List<android.util.Pair<String, String>> q()
  {
    // Byte code:
    //   0: new 448	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 449	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 82	com/tencent/wcdb/database/SQLiteDatabase:a	Ljava/lang/Object;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 264	com/tencent/wcdb/database/SQLiteDatabase:c	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_1
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_2
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: aload_0
    //   33: getfield 379	com/tencent/wcdb/database/SQLiteDatabase:i	Z
    //   36: ifne +29 -> 65
    //   39: aload_3
    //   40: new 451	android/util/Pair
    //   43: dup
    //   44: ldc_w 453
    //   47: aload_0
    //   48: getfield 98	com/tencent/wcdb/database/SQLiteDatabase:b	Lcom/tencent/token/agh;
    //   51: getfield 439	com/tencent/token/agh:a	Ljava/lang/String;
    //   54: invokespecial 456	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   57: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 111	com/tencent/wcdb/database/SQLiteDatabase:d	()V
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_0
    //   72: ldc_w 462
    //   75: aconst_null
    //   76: aconst_null
    //   77: invokevirtual 299	com/tencent/wcdb/database/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/afw;
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: invokeinterface 467 1 0
    //   89: ifeq +34 -> 123
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: new 451	android/util/Pair
    //   98: dup
    //   99: aload_2
    //   100: iconst_1
    //   101: invokeinterface 471 2 0
    //   106: aload_2
    //   107: iconst_2
    //   108: invokeinterface 471 2 0
    //   113: invokespecial 456	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   116: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: goto -39 -> 81
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 472 1 0
    //   133: aload_0
    //   134: invokevirtual 176	com/tencent/wcdb/database/SQLiteDatabase:e	()V
    //   137: aload_3
    //   138: areturn
    //   139: astore_2
    //   140: aload_1
    //   141: ifnull +9 -> 150
    //   144: aload_1
    //   145: invokeinterface 472 1 0
    //   150: aload_2
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: invokevirtual 176	com/tencent/wcdb/database/SQLiteDatabase:e	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	SQLiteDatabase
    //   22	123	1	localObject1	Object
    //   152	6	1	localObject2	Object
    //   159	4	1	localObject3	Object
    //   12	116	2	localObject4	Object
    //   139	22	2	localObject5	Object
    //   7	131	3	localArrayList	java.util.ArrayList
    //   19	5	4	localSQLiteConnectionPool	SQLiteConnectionPool
    // Exception table:
    //   from	to	target	type
    //   71	81	139	finally
    //   83	92	139	finally
    //   94	120	139	finally
    //   127	133	152	finally
    //   144	150	152	finally
    //   150	152	152	finally
    //   15	21	159	finally
    //   28	30	159	finally
    //   32	63	159	finally
    //   65	71	159	finally
    //   160	162	159	finally
  }
  
  public final void r()
  {
    if (this.c != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("The database '");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("' is not open.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SQLiteDatabase: ");
    localStringBuilder.append(o());
    return localStringBuilder.toString();
  }
  
  public static abstract interface CustomFunction {}
  
  public static abstract interface a
  {
    public abstract afw a(agg paramagg, String paramString, agk paramagk);
    
    public abstract agk a(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, ags paramags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */