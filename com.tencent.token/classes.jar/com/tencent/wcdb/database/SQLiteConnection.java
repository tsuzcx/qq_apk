package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import com.tencent.token.afz;
import com.tencent.token.agi;
import com.tencent.token.agt;
import com.tencent.token.agt.a;
import com.tencent.token.agv;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements agt.a
{
  private static final String[] d = new String[0];
  private static final byte[] e = new byte[0];
  private static final Pattern f = Pattern.compile("[\\s]*\\n+[\\s]*");
  final boolean a;
  final b b = new b((byte)0);
  boolean c;
  private final SQLiteConnectionPool g;
  private final agi h;
  private final int i;
  private final boolean j;
  private final d k;
  private c l;
  private Thread m;
  private int n;
  private long o;
  private int p;
  private byte[] q;
  private SQLiteCipherSpec r;
  private a s;
  private int t;
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, agi paramagi, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.q = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = new SQLiteCipherSpec(paramSQLiteCipherSpec);
    }
    this.r = paramArrayOfByte;
    this.g = paramSQLiteConnectionPool;
    this.h = new agi(paramagi);
    this.i = paramInt;
    this.a = paramBoolean;
    paramInt = paramagi.d;
    paramBoolean = true;
    if ((paramInt & 0x1) == 0) {
      paramBoolean = false;
    }
    this.j = paramBoolean;
    this.k = new d(this.h.e);
  }
  
  static SQLiteConnection a(SQLiteConnectionPool paramSQLiteConnectionPool, agi paramagi, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    paramagi = new SQLiteConnection(paramSQLiteConnectionPool, paramagi, paramInt, paramBoolean, paramArrayOfByte, paramSQLiteCipherSpec);
    for (;;)
    {
      try
      {
        paramagi.o = paramagi.nativeOpen(paramagi.h.a, paramagi.h.d, paramagi.h.c);
        if ((paramagi.q != null) && (paramagi.q.length == 0)) {
          paramagi.q = null;
        }
        if (paramagi.q != null)
        {
          nativeSetKey(paramagi.o, paramagi.q);
          if (paramagi.r != null)
          {
            if (paramagi.r.cipher != null)
            {
              paramSQLiteConnectionPool = new StringBuilder("PRAGMA cipher=");
              paramSQLiteConnectionPool.append(afz.a(paramagi.r.cipher));
              paramagi.a(paramSQLiteConnectionPool.toString(), null, null);
            }
            if (paramagi.r.kdfIteration != 0)
            {
              paramSQLiteConnectionPool = new StringBuilder("PRAGMA kdf_iter=");
              paramSQLiteConnectionPool.append(paramagi.r.kdfIteration);
              paramagi.a(paramSQLiteConnectionPool.toString(), null, null);
            }
            paramSQLiteConnectionPool = new StringBuilder("PRAGMA cipher_use_hmac=");
            paramSQLiteConnectionPool.append(paramagi.r.hmacEnabled);
            paramagi.a(paramSQLiteConnectionPool.toString(), null, null);
          }
        }
        if (!paramagi.h.a())
        {
          if (paramagi.q != null)
          {
            paramSQLiteConnectionPool = "PRAGMA cipher_page_size";
            if ((paramagi.r != null) && (paramagi.r.pageSize > 0))
            {
              paramInt = paramagi.r.pageSize;
              break label472;
            }
            paramInt = SQLiteGlobal.a;
            break label472;
          }
          paramSQLiteConnectionPool = "PRAGMA page_size";
          l1 = SQLiteGlobal.a;
          if (paramagi.a(paramSQLiteConnectionPool, null) != l1)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append(paramSQLiteConnectionPool);
            paramArrayOfByte.append("=");
            paramArrayOfByte.append(l1);
            paramagi.a(paramArrayOfByte.toString(), null, null);
          }
        }
        if (paramagi.j) {
          paramagi.a("PRAGMA query_only = 1", null, null);
        }
        paramagi.g();
        paramagi.h();
        paramagi.i();
        if ((!paramagi.h.a()) && (!paramagi.j) && (paramagi.a("PRAGMA journal_size_limit", null) != 524288L)) {
          paramagi.a("PRAGMA journal_size_limit=524288", null);
        }
        paramagi.f();
        paramagi.j();
        paramagi.k();
        int i1 = paramagi.h.l.size();
        paramInt = 0;
        if (paramInt < i1)
        {
          paramSQLiteConnectionPool = (SQLiteCustomFunction)paramagi.h.l.get(paramInt);
          nativeRegisterCustomFunction(paramagi.o, paramSQLiteConnectionPool);
          paramInt += 1;
          continue;
        }
        return paramagi;
      }
      catch (SQLiteException paramSQLiteConnectionPool)
      {
        SQLiteDebug.a(paramagi);
        paramagi.e();
        throw paramSQLiteConnectionPool;
      }
      label472:
      long l1 = paramInt;
    }
  }
  
  private void a(agt paramagt)
  {
    if (paramagt != null)
    {
      paramagt.a();
      this.p += 1;
      if (this.p == 1)
      {
        nativeResetCancel(this.o, true);
        paramagt.a(this);
      }
    }
  }
  
  private void a(c paramc, Object[] paramArrayOfObject)
  {
    int i2 = 0;
    int i1;
    if (paramArrayOfObject != null) {
      i1 = paramArrayOfObject.length;
    } else {
      i1 = 0;
    }
    if (i1 == paramc.e)
    {
      if (i1 == 0) {
        return;
      }
      long l2 = paramc.d;
      while (i2 < i1)
      {
        paramc = paramArrayOfObject[i2];
        int i3 = afz.a(paramc);
        if (i3 != 4) {
          switch (i3)
          {
          default: 
            if ((paramc instanceof Boolean))
            {
              long l3 = this.o;
              long l1;
              if (((Boolean)paramc).booleanValue()) {
                l1 = 1L;
              } else {
                l1 = 0L;
              }
              nativeBindLong(l3, l2, i2 + 1, l1);
            }
            else
            {
              nativeBindString(this.o, l2, i2 + 1, paramc.toString());
            }
            break;
          case 2: 
            nativeBindDouble(this.o, l2, i2 + 1, ((Number)paramc).doubleValue());
            break;
          case 1: 
            nativeBindLong(this.o, l2, i2 + 1, ((Number)paramc).longValue());
            break;
          case 0: 
            nativeBindNull(this.o, l2, i2 + 1);
            break;
          }
        } else {
          nativeBindBlob(this.o, l2, i2 + 1, (byte[])paramc);
        }
        i2 += 1;
      }
      return;
    }
    paramArrayOfObject = new StringBuilder("Expected ");
    paramArrayOfObject.append(paramc.e);
    paramArrayOfObject.append(" bind arguments but ");
    paramArrayOfObject.append(i1);
    paramArrayOfObject.append(" were provided.");
    throw new SQLiteBindOrColumnIndexOutOfRangeException(paramArrayOfObject.toString());
  }
  
  private void b(agt paramagt)
  {
    if (paramagt != null)
    {
      this.p -= 1;
      if (this.p == 0)
      {
        paramagt.a(null);
        nativeResetCancel(this.o, false);
      }
    }
  }
  
  private void b(c paramc)
  {
    nativeFinalizeStatement(this.o, paramc.d);
    e(paramc);
  }
  
  private void c(c paramc)
  {
    nativeResetStatement(this.o, paramc.d, true);
  }
  
  private void d(c paramc)
  {
    if (this.c)
    {
      if (paramc.g) {
        return;
      }
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private void d(String paramString)
  {
    String str = e("PRAGMA journal_mode");
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      boolean bool = e("PRAGMA journal_mode=".concat(String.valueOf(paramString))).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      label40:
      StringBuilder localStringBuilder;
      break label40;
    }
    localStringBuilder = new StringBuilder("Could not change the database journal mode of '");
    localStringBuilder.append(this.h.b);
    localStringBuilder.append("' from '");
    localStringBuilder.append(str);
    localStringBuilder.append("' to '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    Log.b("WCDB.SQLiteConnection", localStringBuilder.toString());
  }
  
  /* Error */
  private String e(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +144 -> 145
    //   4: aload_0
    //   5: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   8: ldc_w 388
    //   11: aload_1
    //   12: aconst_null
    //   13: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   16: astore_3
    //   17: aload_3
    //   18: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   27: astore_1
    //   28: aload_3
    //   29: aload_1
    //   30: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   33: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   41: aload_0
    //   42: aload_1
    //   43: aconst_null
    //   44: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aconst_null
    //   49: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   52: aload_0
    //   53: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   56: aload_1
    //   57: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   60: invokestatic 409	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForString	(JJ)Ljava/lang/String;
    //   63: astore_3
    //   64: aload_0
    //   65: aconst_null
    //   66: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   74: aload_0
    //   75: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   78: iload_2
    //   79: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   82: aload_3
    //   83: areturn
    //   84: astore_3
    //   85: aload_0
    //   86: aconst_null
    //   87: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   90: aload_3
    //   91: athrow
    //   92: astore_3
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   98: aload_3
    //   99: athrow
    //   100: astore_1
    //   101: goto +34 -> 135
    //   104: astore_1
    //   105: aload_1
    //   106: instanceof 349
    //   109: ifne +10 -> 119
    //   112: aload_1
    //   113: instanceof 416
    //   116: ifeq +17 -> 133
    //   119: aload_0
    //   120: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   123: ifnull +10 -> 133
    //   126: aload_0
    //   127: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   130: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   133: aload_1
    //   134: athrow
    //   135: aload_0
    //   136: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   139: iload_2
    //   140: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   143: aload_1
    //   144: athrow
    //   145: new 421	java/lang/IllegalArgumentException
    //   148: dup
    //   149: ldc_w 423
    //   152: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	SQLiteConnection
    //   0	156	1	paramString	String
    //   21	119	2	i1	int
    //   16	67	3	localObject1	Object
    //   84	7	3	localObject2	Object
    //   92	7	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	64	84	finally
    //   36	52	92	finally
    //   64	69	92	finally
    //   85	92	92	finally
    //   22	36	100	finally
    //   69	74	100	finally
    //   93	100	100	finally
    //   105	119	100	finally
    //   119	133	100	finally
    //   133	135	100	finally
    //   22	36	104	java/lang/RuntimeException
    //   69	74	104	java/lang/RuntimeException
    //   93	100	104	java/lang/RuntimeException
  }
  
  private void e()
  {
    if (this.o != 0L)
    {
      int i1 = this.b.a("close", null, null).h;
      try
      {
        this.k.a();
        nativeClose(this.o);
        this.o = 0L;
        return;
      }
      finally
      {
        this.b.a(i1);
      }
    }
  }
  
  private void e(c paramc)
  {
    paramc.c = null;
    paramc.b = this.l;
    this.l = paramc;
  }
  
  private c f(String paramString)
  {
    c localc = (c)this.k.b(paramString);
    int i2 = 0;
    int i1;
    if (localc != null)
    {
      if (!localc.i)
      {
        localc.i = true;
        return localc;
      }
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    long l1 = nativePrepareStatement(this.o, paramString);
    try
    {
      int i4 = nativeGetParameterCount(this.o, l1);
      int i3 = afz.b(paramString);
      boolean bool = nativeIsReadOnly(this.o, l1);
      Object localObject = this.l;
      if (localObject != null)
      {
        this.l = ((c)localObject).b;
        ((c)localObject).b = null;
        ((c)localObject).h = false;
      }
      else
      {
        localObject = new c(this);
      }
      ((c)localObject).c = paramString;
      ((c)localObject).d = l1;
      ((c)localObject).e = i4;
      ((c)localObject).f = i3;
      ((c)localObject).g = bool;
      if (i1 == 0)
      {
        if (i3 != 2)
        {
          i1 = i2;
          if (i3 != 1) {}
        }
        else
        {
          i1 = 1;
        }
        if (i1 != 0) {
          try
          {
            this.k.a(paramString, localObject);
            ((c)localObject).h = true;
          }
          catch (RuntimeException localRuntimeException2)
          {
            paramString = (String)localObject;
            localObject = localRuntimeException2;
            break label231;
          }
        }
      }
      ((c)localObject).i = true;
      return localObject;
    }
    catch (RuntimeException localRuntimeException1)
    {
      paramString = localRuntimeException2;
      label231:
      if ((paramString == null) || (!paramString.h)) {
        nativeFinalizeStatement(this.o, l1);
      }
      throw localRuntimeException1;
    }
  }
  
  private void f()
  {
    if ((!this.h.a()) && (!this.j))
    {
      if (this.h.h)
      {
        nativeSetWalHook(this.o);
        return;
      }
      if (a("PRAGMA wal_autocheckpoint", null) != 100L) {
        a("PRAGMA wal_autocheckpoint=100", null);
      }
    }
  }
  
  private void g()
  {
    if (!this.j)
    {
      long l1;
      if (this.h.g) {
        l1 = 1L;
      } else {
        l1 = 0L;
      }
      if (a("PRAGMA foreign_keys", null) != l1) {
        a("PRAGMA foreign_keys=".concat(String.valueOf(l1)), null, null);
      }
    }
  }
  
  private void h()
  {
    if ((!this.h.a()) && (!this.j))
    {
      String str;
      if ((this.h.d & 0x20000000) != 0) {
        str = "WAL";
      } else {
        str = "PERSIST";
      }
      d(str);
    }
  }
  
  private void i()
  {
    a("PRAGMA synchronous=".concat(String.valueOf(this.h.i)), null, null);
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/wcdb/database/SQLiteConnection:h	Lcom/tencent/token/agi;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 100	com/tencent/token/agi:d	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 100	com/tencent/token/agi:d	I
    //   16: aload_0
    //   17: getfield 94	com/tencent/wcdb/database/SQLiteConnection:h	Lcom/tencent/token/agi;
    //   20: getfield 100	com/tencent/token/agi:d	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 94	com/tencent/wcdb/database/SQLiteConnection:h	Lcom/tencent/token/agi;
    //   34: getfield 497	com/tencent/token/agi:f	Ljava/util/Locale;
    //   37: invokevirtual 500	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   45: aload_1
    //   46: invokestatic 504	com/tencent/wcdb/database/SQLiteConnection:nativeRegisterLocalizedCollators	(JLjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 102	com/tencent/wcdb/database/SQLiteConnection:j	Z
    //   53: ifeq +4 -> 57
    //   56: return
    //   57: aload_0
    //   58: ldc_w 506
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   66: aload_0
    //   67: ldc_w 508
    //   70: invokespecial 353	com/tencent/wcdb/database/SQLiteConnection:e	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +12 -> 87
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual 512	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +4 -> 87
    //   86: return
    //   87: aload_0
    //   88: ldc_w 514
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   96: aload_0
    //   97: ldc_w 516
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   105: aload_0
    //   106: ldc_w 518
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   121: aload_0
    //   122: ldc_w 520
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   130: aload_0
    //   131: ldc_w 522
    //   134: aconst_null
    //   135: aconst_null
    //   136: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   139: return
    //   140: astore_2
    //   141: aload_0
    //   142: ldc_w 524
    //   145: aconst_null
    //   146: aconst_null
    //   147: invokevirtual 156	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/token/agt;)V
    //   150: aload_2
    //   151: athrow
    //   152: astore_2
    //   153: new 135	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 526
    //   160: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: astore_3
    //   164: aload_3
    //   165: aload_0
    //   166: getfield 94	com/tencent/wcdb/database/SQLiteConnection:h	Lcom/tencent/token/agi;
    //   169: getfield 370	com/tencent/token/agi:b	Ljava/lang/String;
    //   172: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: ldc_w 374
    //   180: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_3
    //   191: ldc_w 528
    //   194: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: new 113	com/tencent/wcdb/database/SQLiteException
    //   201: dup
    //   202: aload_3
    //   203: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aload_2
    //   207: invokespecial 531	com/tencent/wcdb/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	SQLiteConnection
    //   4	182	1	localObject1	Object
    //   73	6	2	str	String
    //   140	11	2	localObject2	Object
    //   152	55	2	localRuntimeException	RuntimeException
    //   163	40	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   96	130	140	finally
    //   57	74	152	java/lang/RuntimeException
    //   78	86	152	java/lang/RuntimeException
    //   87	96	152	java/lang/RuntimeException
    //   130	139	152	java/lang/RuntimeException
    //   141	152	152	java/lang/RuntimeException
  }
  
  private void k()
  {
    nativeSetUpdateNotification(this.o, this.h.j, this.h.k);
  }
  
  private static native void nativeBindBlob(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(long paramLong1, long paramLong2, int paramInt, double paramDouble);
  
  private static native void nativeBindLong(long paramLong1, long paramLong2, int paramInt, long paramLong3);
  
  private static native void nativeBindNull(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nativeBindString(long paramLong1, long paramLong2, int paramInt, String paramString);
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeClose(long paramLong);
  
  private static native void nativeExecute(long paramLong1, long paramLong2);
  
  private static native int nativeExecuteForChangedRowCount(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForCursorWindow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForLong(long paramLong1, long paramLong2);
  
  private static native String nativeExecuteForString(long paramLong1, long paramLong2);
  
  private static native void nativeFinalizeStatement(long paramLong1, long paramLong2);
  
  private static native int nativeGetColumnCount(long paramLong1, long paramLong2);
  
  private static native String nativeGetColumnName(long paramLong1, long paramLong2, int paramInt);
  
  private static native int nativeGetDbLookaside(long paramLong);
  
  private static native int nativeGetParameterCount(long paramLong1, long paramLong2);
  
  private static native boolean nativeIsReadOnly(long paramLong1, long paramLong2);
  
  private native long nativeOpen(String paramString1, int paramInt, String paramString2);
  
  private static native long nativePrepareStatement(long paramLong, String paramString);
  
  private static native void nativeRegisterCustomFunction(long paramLong, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(long paramLong, String paramString);
  
  private static native void nativeResetCancel(long paramLong, boolean paramBoolean);
  
  private static native void nativeResetStatement(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native long nativeSQLiteHandle(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetKey(long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetUpdateNotification(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nativeSetWalHook(long paramLong);
  
  private static native long nativeWalCheckpoint(long paramLong, String paramString);
  
  private void notifyChange(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramString1 = this.g;
    paramString1.a.get();
    paramString1 = paramString1.b;
  }
  
  private void notifyCheckpoint(String paramString, int paramInt)
  {
    paramString = this.g;
    paramString.a.get();
    paramString = paramString.d;
  }
  
  /* Error */
  public final int a(String paramString, Object[] paramArrayOfObject, com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, agt paramagt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +642 -> 643
    //   4: aload_3
    //   5: ifnull +627 -> 632
    //   8: aload_3
    //   9: invokevirtual 577	com/tencent/wcdb/CursorWindow:d	()V
    //   12: aload_0
    //   13: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   16: ldc_w 579
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   24: astore 21
    //   26: aload 21
    //   28: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   31: istore 13
    //   33: iconst_m1
    //   34: istore 9
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   41: astore 20
    //   43: aload 21
    //   45: aload 20
    //   47: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   50: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   53: aload_0
    //   54: aload 20
    //   56: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   59: aload_0
    //   60: aload 20
    //   62: aload_2
    //   63: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 7
    //   69: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   72: aload_0
    //   73: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   76: lstore 14
    //   78: aload 20
    //   80: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   83: lstore 16
    //   85: aload_3
    //   86: getfield 581	com/tencent/wcdb/CursorWindow:a	J
    //   89: lstore 18
    //   91: lload 14
    //   93: lload 16
    //   95: lload 18
    //   97: iload 4
    //   99: iload 5
    //   101: iload 6
    //   103: invokestatic 583	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForCursorWindow	(JJJIIZ)J
    //   106: lstore 14
    //   108: lload 14
    //   110: bipush 32
    //   112: lshr
    //   113: l2i
    //   114: istore 5
    //   116: lload 14
    //   118: l2i
    //   119: istore 8
    //   121: aload_3
    //   122: invokevirtual 585	com/tencent/wcdb/CursorWindow:b	()I
    //   125: istore 9
    //   127: aload_3
    //   128: iload 5
    //   130: putfield 587	com/tencent/wcdb/CursorWindow:b	I
    //   133: aload_0
    //   134: aload 7
    //   136: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   139: aload_0
    //   140: aload 20
    //   142: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   145: aload_0
    //   146: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   149: iload 13
    //   151: invokevirtual 590	com/tencent/wcdb/database/SQLiteConnection$b:b	(I)Z
    //   154: ifeq +95 -> 249
    //   157: aload_0
    //   158: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   161: astore_1
    //   162: new 135	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 592
    //   169: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_3
    //   175: invokevirtual 595	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: ldc_w 597
    //   183: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: iload 4
    //   190: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: ldc_w 599
    //   198: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: iload 5
    //   205: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: ldc_w 601
    //   213: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_2
    //   218: iload 9
    //   220: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: ldc_w 603
    //   228: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_2
    //   233: iload 8
    //   235: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: iload 13
    //   242: aload_2
    //   243: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 606	com/tencent/wcdb/database/SQLiteConnection$b:a	(ILjava/lang/String;)V
    //   249: aload_3
    //   250: invokevirtual 607	com/tencent/wcdb/CursorWindow:e	()V
    //   253: iload 8
    //   255: ireturn
    //   256: astore_1
    //   257: goto +251 -> 508
    //   260: astore_1
    //   261: iload 5
    //   263: istore 10
    //   265: iload 9
    //   267: istore 5
    //   269: iload 10
    //   271: istore 9
    //   273: goto +132 -> 405
    //   276: astore_1
    //   277: iload 5
    //   279: istore 10
    //   281: iload 9
    //   283: istore 5
    //   285: iload 10
    //   287: istore 9
    //   289: goto +60 -> 349
    //   292: astore_1
    //   293: iload 5
    //   295: istore 10
    //   297: iload 9
    //   299: istore 5
    //   301: iload 10
    //   303: istore 9
    //   305: goto +25 -> 330
    //   308: astore_1
    //   309: iload 5
    //   311: istore 9
    //   313: iconst_m1
    //   314: istore 5
    //   316: goto +14 -> 330
    //   319: astore_1
    //   320: goto +4 -> 324
    //   323: astore_1
    //   324: iconst_m1
    //   325: istore 5
    //   327: iconst_m1
    //   328: istore 8
    //   330: aload_0
    //   331: aload 7
    //   333: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   336: aload_1
    //   337: athrow
    //   338: astore_1
    //   339: goto +10 -> 349
    //   342: astore_1
    //   343: iconst_m1
    //   344: istore 5
    //   346: iconst_m1
    //   347: istore 8
    //   349: iload 5
    //   351: istore 10
    //   353: iload 8
    //   355: istore 11
    //   357: iload 9
    //   359: istore 12
    //   361: aload_0
    //   362: aload 20
    //   364: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   367: iload 5
    //   369: istore 10
    //   371: iload 8
    //   373: istore 11
    //   375: iload 9
    //   377: istore 12
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: goto +23 -> 405
    //   385: astore_1
    //   386: iconst_m1
    //   387: istore 9
    //   389: iconst_m1
    //   390: istore 8
    //   392: iconst_m1
    //   393: istore 5
    //   395: goto +113 -> 508
    //   398: astore_1
    //   399: iconst_m1
    //   400: istore 5
    //   402: iconst_m1
    //   403: istore 8
    //   405: iload 5
    //   407: istore 10
    //   409: iload 8
    //   411: istore 11
    //   413: iload 9
    //   415: istore 12
    //   417: aload_1
    //   418: instanceof 349
    //   421: ifne +22 -> 443
    //   424: iload 5
    //   426: istore 10
    //   428: iload 8
    //   430: istore 11
    //   432: iload 9
    //   434: istore 12
    //   436: aload_1
    //   437: instanceof 416
    //   440: ifeq +41 -> 481
    //   443: iload 5
    //   445: istore 10
    //   447: iload 8
    //   449: istore 11
    //   451: iload 9
    //   453: istore 12
    //   455: aload_0
    //   456: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   459: ifnull +22 -> 481
    //   462: iload 5
    //   464: istore 10
    //   466: iload 8
    //   468: istore 11
    //   470: iload 9
    //   472: istore 12
    //   474: aload_0
    //   475: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   478: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   481: iload 5
    //   483: istore 10
    //   485: iload 8
    //   487: istore 11
    //   489: iload 9
    //   491: istore 12
    //   493: aload_1
    //   494: athrow
    //   495: astore_1
    //   496: iload 12
    //   498: istore 5
    //   500: iload 11
    //   502: istore 8
    //   504: iload 10
    //   506: istore 9
    //   508: aload_0
    //   509: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   512: iload 13
    //   514: invokevirtual 590	com/tencent/wcdb/database/SQLiteConnection$b:b	(I)Z
    //   517: ifeq +106 -> 623
    //   520: aload_0
    //   521: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   524: astore_2
    //   525: new 135	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 592
    //   532: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: astore 7
    //   537: aload 7
    //   539: aload_3
    //   540: invokevirtual 595	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 7
    //   546: ldc_w 597
    //   549: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 7
    //   555: iload 4
    //   557: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 7
    //   563: ldc_w 599
    //   566: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 7
    //   572: iload 5
    //   574: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 7
    //   580: ldc_w 601
    //   583: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 7
    //   589: iload 9
    //   591: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 7
    //   597: ldc_w 603
    //   600: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 7
    //   606: iload 8
    //   608: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_2
    //   613: iload 13
    //   615: aload 7
    //   617: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 606	com/tencent/wcdb/database/SQLiteConnection$b:a	(ILjava/lang/String;)V
    //   623: aload_1
    //   624: athrow
    //   625: astore_1
    //   626: aload_3
    //   627: invokevirtual 607	com/tencent/wcdb/CursorWindow:e	()V
    //   630: aload_1
    //   631: athrow
    //   632: new 421	java/lang/IllegalArgumentException
    //   635: dup
    //   636: ldc_w 609
    //   639: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   642: athrow
    //   643: new 421	java/lang/IllegalArgumentException
    //   646: dup
    //   647: ldc_w 423
    //   650: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   653: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	SQLiteConnection
    //   0	654	1	paramString	String
    //   0	654	2	paramArrayOfObject	Object[]
    //   0	654	3	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	654	4	paramInt1	int
    //   0	654	5	paramInt2	int
    //   0	654	6	paramBoolean	boolean
    //   0	654	7	paramagt	agt
    //   119	488	8	i1	int
    //   34	556	9	i2	int
    //   263	242	10	i3	int
    //   355	146	11	i4	int
    //   359	138	12	i5	int
    //   31	583	13	i6	int
    //   76	41	14	l1	long
    //   83	11	16	l2	long
    //   89	7	18	l3	long
    //   41	322	20	localc	c
    //   24	20	21	locala	a
    // Exception table:
    //   from	to	target	type
    //   139	145	256	finally
    //   139	145	260	java/lang/RuntimeException
    //   133	139	276	finally
    //   127	133	292	finally
    //   121	127	308	finally
    //   91	108	319	finally
    //   72	91	323	finally
    //   330	338	338	finally
    //   53	72	342	finally
    //   361	367	381	java/lang/RuntimeException
    //   379	381	381	java/lang/RuntimeException
    //   36	53	385	finally
    //   36	53	398	java/lang/RuntimeException
    //   361	367	495	finally
    //   379	381	495	finally
    //   417	424	495	finally
    //   436	443	495	finally
    //   455	462	495	finally
    //   474	481	495	finally
    //   493	495	495	finally
    //   12	33	625	finally
    //   145	249	625	finally
    //   508	623	625	finally
    //   623	625	625	finally
  }
  
  final long a(String paramString)
  {
    if (this.o == 0L) {
      return 0L;
    }
    if ((paramString != null) && (this.s == null))
    {
      this.s = this.b.a(paramString, null, null);
      this.s.i = 99;
    }
    this.t += 1;
    return nativeSQLiteHandle(this.o, true);
  }
  
  /* Error */
  public final long a(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +149 -> 150
    //   4: aload_0
    //   5: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   8: ldc_w 618
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   23: istore_3
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   29: astore_1
    //   30: aload 6
    //   32: aload_1
    //   33: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   36: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   44: aload_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: aconst_null
    //   52: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   55: aload_0
    //   56: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   59: aload_1
    //   60: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   63: invokestatic 620	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLong	(JJ)J
    //   66: lstore 4
    //   68: aload_0
    //   69: aconst_null
    //   70: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   78: aload_0
    //   79: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   82: iload_3
    //   83: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   86: lload 4
    //   88: lreturn
    //   89: astore_2
    //   90: aload_0
    //   91: aconst_null
    //   92: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: goto +34 -> 140
    //   109: astore_1
    //   110: aload_1
    //   111: instanceof 349
    //   114: ifne +10 -> 124
    //   117: aload_1
    //   118: instanceof 416
    //   121: ifeq +17 -> 138
    //   124: aload_0
    //   125: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   128: ifnull +10 -> 138
    //   131: aload_0
    //   132: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   135: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   138: aload_1
    //   139: athrow
    //   140: aload_0
    //   141: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   144: iload_3
    //   145: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: new 421	java/lang/IllegalArgumentException
    //   153: dup
    //   154: ldc_w 423
    //   157: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	SQLiteConnection
    //   0	161	1	paramString	String
    //   0	161	2	paramArrayOfObject	Object[]
    //   23	122	3	i1	int
    //   66	21	4	l1	long
    //   16	15	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   55	68	89	finally
    //   39	55	97	finally
    //   68	73	97	finally
    //   90	97	97	finally
    //   24	39	105	finally
    //   73	78	105	finally
    //   98	105	105	finally
    //   110	124	105	finally
    //   124	138	105	finally
    //   138	140	105	finally
    //   24	39	109	java/lang/RuntimeException
    //   73	78	109	java/lang/RuntimeException
    //   98	105	109	java/lang/RuntimeException
  }
  
  final void a()
  {
    int i1 = this.t - 1;
    this.t = i1;
    if ((i1 == 0) && (this.s != null))
    {
      nativeSQLiteHandle(this.o, false);
      this.b.b(this.s.h);
      this.s = null;
    }
  }
  
  final void a(agi paramagi)
  {
    int i5 = 0;
    this.c = false;
    int i2 = paramagi.l.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = (SQLiteCustomFunction)paramagi.l.get(i1);
      if (!this.h.l.contains(localObject)) {
        nativeRegisterCustomFunction(this.o, (SQLiteCustomFunction)localObject);
      }
      i1 += 1;
    }
    if (((paramagi.d ^ this.h.d) & 0x20000000) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramagi.g != this.h.g) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool = paramagi.f.equals(this.h.f);
    int i3;
    if (paramagi.h != this.h.h) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if (paramagi.i != this.h.i) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    if ((paramagi.j != this.h.j) || (paramagi.k != this.h.k)) {
      i5 = 1;
    }
    this.h.a(paramagi);
    Object localObject = this.k;
    int i6 = paramagi.e;
    if (i6 > 0) {
      try
      {
        ((agv)localObject).b = i6;
        ((agv)localObject).a(i6);
        if (i2 != 0) {
          g();
        }
        if (i1 != 0) {
          h();
        }
        if (i4 != 0) {
          i();
        }
        if (i3 != 0) {
          f();
        }
        if ((bool ^ true)) {
          j();
        }
        if (i5 != 0) {
          k();
        }
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final void a(c paramc)
  {
    paramc.i = false;
    if (paramc.h) {}
    try
    {
      c(paramc);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      label18:
      break label18;
    }
    this.k.c(paramc.c);
    return;
    b(paramc);
  }
  
  /* Error */
  public final void a(String paramString, com.tencent.token.agq paramagq)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +194 -> 195
    //   4: aload_0
    //   5: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   8: ldc_w 639
    //   11: aload_1
    //   12: aconst_null
    //   13: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   30: astore_1
    //   31: aload 6
    //   33: aload_1
    //   34: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   37: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   40: aload_2
    //   41: aload_1
    //   42: getfield 257	com/tencent/wcdb/database/SQLiteConnection$c:e	I
    //   45: putfield 642	com/tencent/token/agq:a	I
    //   48: aload_2
    //   49: aload_1
    //   50: getfield 344	com/tencent/wcdb/database/SQLiteConnection$c:g	Z
    //   53: putfield 643	com/tencent/token/agq:c	Z
    //   56: aload_0
    //   57: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   60: aload_1
    //   61: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   64: invokestatic 645	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnCount	(JJ)I
    //   67: istore 5
    //   69: iload 5
    //   71: ifne +13 -> 84
    //   74: aload_2
    //   75: getstatic 54	com/tencent/wcdb/database/SQLiteConnection:d	[Ljava/lang/String;
    //   78: putfield 647	com/tencent/token/agq:b	[Ljava/lang/String;
    //   81: goto +45 -> 126
    //   84: aload_2
    //   85: iload 5
    //   87: anewarray 52	java/lang/String
    //   90: putfield 647	com/tencent/token/agq:b	[Ljava/lang/String;
    //   93: iconst_0
    //   94: istore_3
    //   95: iload_3
    //   96: iload 5
    //   98: if_icmpge +28 -> 126
    //   101: aload_2
    //   102: getfield 647	com/tencent/token/agq:b	[Ljava/lang/String;
    //   105: iload_3
    //   106: aload_0
    //   107: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   110: aload_1
    //   111: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   114: iload_3
    //   115: invokestatic 649	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnName	(JJI)Ljava/lang/String;
    //   118: aastore
    //   119: iload_3
    //   120: iconst_1
    //   121: iadd
    //   122: istore_3
    //   123: goto -28 -> 95
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   131: aload_0
    //   132: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   135: iload 4
    //   137: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   140: return
    //   141: astore_2
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: goto +34 -> 184
    //   153: astore_1
    //   154: aload_1
    //   155: instanceof 349
    //   158: ifne +10 -> 168
    //   161: aload_1
    //   162: instanceof 416
    //   165: ifeq +17 -> 182
    //   168: aload_0
    //   169: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   172: ifnull +10 -> 182
    //   175: aload_0
    //   176: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   179: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   188: iload 4
    //   190: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: new 421	java/lang/IllegalArgumentException
    //   198: dup
    //   199: ldc_w 423
    //   202: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	SQLiteConnection
    //   0	206	1	paramString	String
    //   0	206	2	paramagq	com.tencent.token.agq
    //   94	29	3	i1	int
    //   23	166	4	i2	int
    //   67	32	5	i3	int
    //   16	16	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   40	69	141	finally
    //   74	81	141	finally
    //   84	93	141	finally
    //   101	119	141	finally
    //   25	40	149	finally
    //   126	131	149	finally
    //   142	149	149	finally
    //   154	168	149	finally
    //   168	182	149	finally
    //   182	184	149	finally
    //   25	40	153	java/lang/RuntimeException
    //   126	131	153	java/lang/RuntimeException
    //   142	149	153	java/lang/RuntimeException
  }
  
  /* Error */
  public final void a(String paramString, Object[] paramArrayOfObject, agt paramagt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +148 -> 149
    //   4: aload_0
    //   5: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   8: ldc_w 651
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   16: astore 5
    //   18: aload 5
    //   20: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   37: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   56: aload_0
    //   57: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   60: aload_1
    //   61: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   64: invokestatic 653	com/tencent/wcdb/database/SQLiteConnection:nativeExecute	(JJ)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   77: aload_0
    //   78: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   81: iload 4
    //   83: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   86: return
    //   87: astore_2
    //   88: aload_0
    //   89: aload_3
    //   90: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: aload_0
    //   97: aload_1
    //   98: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   101: aload_2
    //   102: athrow
    //   103: astore_1
    //   104: goto +34 -> 138
    //   107: astore_1
    //   108: aload_1
    //   109: instanceof 349
    //   112: ifne +10 -> 122
    //   115: aload_1
    //   116: instanceof 416
    //   119: ifeq +17 -> 136
    //   122: aload_0
    //   123: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   126: ifnull +10 -> 136
    //   129: aload_0
    //   130: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   133: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   136: aload_1
    //   137: athrow
    //   138: aload_0
    //   139: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   142: iload 4
    //   144: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   147: aload_1
    //   148: athrow
    //   149: new 421	java/lang/IllegalArgumentException
    //   152: dup
    //   153: ldc_w 423
    //   156: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	SQLiteConnection
    //   0	160	1	paramString	String
    //   0	160	2	paramArrayOfObject	Object[]
    //   0	160	3	paramagt	agt
    //   23	120	4	i1	int
    //   16	16	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   56	67	87	finally
    //   40	56	95	finally
    //   67	72	95	finally
    //   88	95	95	finally
    //   25	40	103	finally
    //   72	77	103	finally
    //   96	103	103	finally
    //   108	122	103	finally
    //   122	136	103	finally
    //   136	138	103	finally
    //   25	40	107	java/lang/RuntimeException
    //   72	77	107	java/lang/RuntimeException
    //   96	103	107	java/lang/RuntimeException
  }
  
  public final void a(Thread paramThread, int paramInt)
  {
    this.m = paramThread;
    this.n = paramInt;
  }
  
  /* Error */
  public final int b(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +280 -> 281
    //   4: iconst_0
    //   5: istore 5
    //   7: iconst_0
    //   8: istore 6
    //   10: iconst_0
    //   11: istore 7
    //   13: aload_0
    //   14: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   17: ldc_w 659
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   25: astore 9
    //   27: aload 9
    //   29: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   32: istore 8
    //   34: iload 5
    //   36: istore_3
    //   37: iload 6
    //   39: istore 4
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   46: astore_1
    //   47: iload 5
    //   49: istore_3
    //   50: iload 6
    //   52: istore 4
    //   54: aload 9
    //   56: aload_1
    //   57: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   60: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   63: iload 7
    //   65: istore 5
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   72: iload 7
    //   74: istore 5
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   82: iload 7
    //   84: istore 5
    //   86: aload_0
    //   87: aconst_null
    //   88: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   91: aload_0
    //   92: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   95: aload_1
    //   96: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   99: invokestatic 661	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForChangedRowCount	(JJ)I
    //   102: istore 6
    //   104: iload 6
    //   106: istore 5
    //   108: aload_0
    //   109: aconst_null
    //   110: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   113: iload 6
    //   115: istore_3
    //   116: iload 6
    //   118: istore 4
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   125: aload_0
    //   126: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   129: iload 8
    //   131: invokevirtual 590	com/tencent/wcdb/database/SQLiteConnection$b:b	(I)Z
    //   134: ifeq +23 -> 157
    //   137: aload_0
    //   138: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   141: iload 8
    //   143: ldc_w 663
    //   146: iload 6
    //   148: invokestatic 494	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   151: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 606	com/tencent/wcdb/database/SQLiteConnection$b:a	(ILjava/lang/String;)V
    //   157: iload 6
    //   159: ireturn
    //   160: astore_2
    //   161: iload 7
    //   163: istore 5
    //   165: aload_0
    //   166: aconst_null
    //   167: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   170: iload 7
    //   172: istore 5
    //   174: aload_2
    //   175: athrow
    //   176: astore_2
    //   177: iload 5
    //   179: istore_3
    //   180: iload 5
    //   182: istore 4
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   189: iload 5
    //   191: istore_3
    //   192: iload 5
    //   194: istore 4
    //   196: aload_2
    //   197: athrow
    //   198: astore_1
    //   199: goto +49 -> 248
    //   202: astore_1
    //   203: iload 4
    //   205: istore_3
    //   206: aload_1
    //   207: instanceof 349
    //   210: ifne +13 -> 223
    //   213: iload 4
    //   215: istore_3
    //   216: aload_1
    //   217: instanceof 416
    //   220: ifeq +23 -> 243
    //   223: iload 4
    //   225: istore_3
    //   226: aload_0
    //   227: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   230: ifnull +13 -> 243
    //   233: iload 4
    //   235: istore_3
    //   236: aload_0
    //   237: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   240: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   243: iload 4
    //   245: istore_3
    //   246: aload_1
    //   247: athrow
    //   248: aload_0
    //   249: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   252: iload 8
    //   254: invokevirtual 590	com/tencent/wcdb/database/SQLiteConnection$b:b	(I)Z
    //   257: ifeq +22 -> 279
    //   260: aload_0
    //   261: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   264: iload 8
    //   266: ldc_w 663
    //   269: iload_3
    //   270: invokestatic 494	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   273: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokevirtual 606	com/tencent/wcdb/database/SQLiteConnection$b:a	(ILjava/lang/String;)V
    //   279: aload_1
    //   280: athrow
    //   281: new 421	java/lang/IllegalArgumentException
    //   284: dup
    //   285: ldc_w 423
    //   288: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	SQLiteConnection
    //   0	292	1	paramString	String
    //   0	292	2	paramArrayOfObject	Object[]
    //   36	234	3	i1	int
    //   39	205	4	i2	int
    //   5	188	5	i3	int
    //   8	150	6	i4	int
    //   11	160	7	i5	int
    //   32	233	8	i6	int
    //   25	30	9	locala	a
    // Exception table:
    //   from	to	target	type
    //   91	104	160	finally
    //   67	72	176	finally
    //   76	82	176	finally
    //   86	91	176	finally
    //   108	113	176	finally
    //   165	170	176	finally
    //   174	176	176	finally
    //   41	47	198	finally
    //   54	63	198	finally
    //   120	125	198	finally
    //   184	189	198	finally
    //   196	198	198	finally
    //   206	213	198	finally
    //   216	223	198	finally
    //   226	233	198	finally
    //   236	243	198	finally
    //   246	248	198	finally
    //   41	47	202	java/lang/RuntimeException
    //   54	63	202	java/lang/RuntimeException
    //   120	125	202	java/lang/RuntimeException
    //   184	189	202	java/lang/RuntimeException
    //   196	198	202	java/lang/RuntimeException
  }
  
  final void b()
  {
    e();
  }
  
  final boolean b(String paramString)
  {
    return this.k.b(paramString) != null;
  }
  
  /* Error */
  public final long c(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +149 -> 150
    //   4: aload_0
    //   5: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   8: ldc_w 665
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 391	com/tencent/wcdb/database/SQLiteConnection$b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$a;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 393	com/tencent/wcdb/database/SQLiteConnection$a:h	I
    //   23: istore_3
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 396	com/tencent/wcdb/database/SQLiteConnection:f	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$c;
    //   29: astore_1
    //   30: aload 6
    //   32: aload_1
    //   33: getfield 398	com/tencent/wcdb/database/SQLiteConnection$c:f	I
    //   36: putfield 399	com/tencent/wcdb/database/SQLiteConnection$a:i	I
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 401	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   44: aload_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 403	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: aconst_null
    //   52: invokespecial 405	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/token/agt;)V
    //   55: aload_0
    //   56: getfield 126	com/tencent/wcdb/database/SQLiteConnection:o	J
    //   59: aload_1
    //   60: getfield 259	com/tencent/wcdb/database/SQLiteConnection$c:d	J
    //   63: invokestatic 667	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(JJ)J
    //   66: lstore 4
    //   68: aload_0
    //   69: aconst_null
    //   70: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   78: aload_0
    //   79: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   82: iload_3
    //   83: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   86: lload 4
    //   88: lreturn
    //   89: astore_2
    //   90: aload_0
    //   91: aconst_null
    //   92: invokespecial 311	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/token/agt;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 411	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$c;)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: goto +34 -> 140
    //   109: astore_1
    //   110: aload_1
    //   111: instanceof 349
    //   114: ifne +10 -> 124
    //   117: aload_1
    //   118: instanceof 416
    //   121: ifeq +17 -> 138
    //   124: aload_0
    //   125: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   128: ifnull +10 -> 138
    //   131: aload_0
    //   132: getfield 87	com/tencent/wcdb/database/SQLiteConnection:g	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   135: invokevirtual 419	com/tencent/wcdb/database/SQLiteConnectionPool:a	()V
    //   138: aload_1
    //   139: athrow
    //   140: aload_0
    //   141: getfield 76	com/tencent/wcdb/database/SQLiteConnection:b	Lcom/tencent/wcdb/database/SQLiteConnection$b;
    //   144: iload_3
    //   145: invokevirtual 414	com/tencent/wcdb/database/SQLiteConnection$b:a	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: new 421	java/lang/IllegalArgumentException
    //   153: dup
    //   154: ldc_w 423
    //   157: invokespecial 424	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	SQLiteConnection
    //   0	161	1	paramString	String
    //   0	161	2	paramArrayOfObject	Object[]
    //   23	122	3	i1	int
    //   66	21	4	l1	long
    //   16	15	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   55	68	89	finally
    //   39	55	97	finally
    //   68	73	97	finally
    //   90	97	97	finally
    //   24	39	105	finally
    //   73	78	105	finally
    //   98	105	105	finally
    //   110	124	105	finally
    //   124	138	105	finally
    //   138	140	105	finally
    //   24	39	109	java/lang/RuntimeException
    //   73	78	109	java/lang/RuntimeException
    //   98	105	109	java/lang/RuntimeException
  }
  
  public final void c()
  {
    nativeCancel(this.o);
  }
  
  protected final void finalize()
  {
    try
    {
      if ((this.g != null) && (this.o != 0L))
      {
        SQLiteConnectionPool localSQLiteConnectionPool = this.g;
        StringBuilder localStringBuilder = new StringBuilder("A SQLiteConnection object for database '");
        localStringBuilder.append(localSQLiteConnectionPool.f.b);
        localStringBuilder.append("' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        Log.b("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
        localSQLiteConnectionPool.e.set(true);
      }
      e();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SQLiteConnection: ");
    localStringBuilder.append(this.h.a);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.i);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"SimpleDateFormat"})
  static final class a
  {
    private static final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public long a;
    public long b;
    public String c;
    public String d;
    public ArrayList<Object> e;
    public boolean f;
    public Exception g;
    public int h;
    public int i;
    public int j;
    
    public final void a(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.c);
      if (this.f)
      {
        paramStringBuilder.append(" took ");
        paramStringBuilder.append(this.b - this.a);
        paramStringBuilder.append("ms");
      }
      else
      {
        paramStringBuilder.append(" started ");
        paramStringBuilder.append(System.currentTimeMillis() - this.a);
        paramStringBuilder.append("ms ago");
      }
      paramStringBuilder.append(" - ");
      if (!this.f) {
        localObject = "running";
      } else if (this.g != null) {
        localObject = "failed";
      } else {
        localObject = "succeeded";
      }
      paramStringBuilder.append((String)localObject);
      if (this.d != null)
      {
        paramStringBuilder.append(", sql=\"");
        paramStringBuilder.append(SQLiteConnection.c(this.d));
        paramStringBuilder.append("\"");
      }
      if (this.j > 0)
      {
        paramStringBuilder.append(", tid=");
        paramStringBuilder.append(this.j);
      }
      Object localObject = this.g;
      if ((localObject != null) && (((Exception)localObject).getMessage() != null))
      {
        paramStringBuilder.append(", exception=\"");
        paramStringBuilder.append(this.g.getMessage());
        paramStringBuilder.append("\"");
      }
    }
  }
  
  final class b
  {
    private final SQLiteConnection.a[] b = new SQLiteConnection.a[20];
    private int c;
    private int d;
    
    private b() {}
    
    private static void a(SQLiteConnection.a parama, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      parama.a(localStringBuilder);
      if (paramString != null)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
      }
      Log.c("WCDB.SQLiteConnection", localStringBuilder.toString());
    }
    
    private static boolean a(SQLiteConnection.a parama)
    {
      if (parama != null)
      {
        parama.b = System.currentTimeMillis();
        parama.f = true;
        if ((parama.g != null) && (parama.g.getMessage() != null)) {
          return true;
        }
        return SQLiteDebug.a(parama.b - parama.a);
      }
      return false;
    }
    
    private SQLiteConnection.a c(int paramInt)
    {
      SQLiteConnection.a locala = this.b[(paramInt & 0xFF)];
      if (locala.h == paramInt) {
        return locala;
      }
      return null;
    }
    
    public final SQLiteConnection.a a(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
      for (;;)
      {
        int i;
        synchronized (this.b)
        {
          int j = (this.c + 1) % 20;
          SQLiteConnection.a locala2 = this.b[j];
          i = 0;
          SQLiteConnection.a locala1;
          if (locala2 == null)
          {
            locala1 = new SQLiteConnection.a((byte)0);
            this.b[j] = locala1;
          }
          else
          {
            locala2.f = false;
            locala2.g = null;
            locala1 = locala2;
            if (locala2.e != null)
            {
              locala2.e.clear();
              locala1 = locala2;
            }
          }
          locala1.a = System.currentTimeMillis();
          locala1.c = paramString1;
          locala1.d = paramString2;
          if (paramArrayOfObject != null)
          {
            if (locala1.e == null) {
              locala1.e = new ArrayList();
            } else {
              locala1.e.clear();
            }
            if (i < paramArrayOfObject.length)
            {
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 != null) && ((paramString1 instanceof byte[])))
              {
                locala1.e.add(SQLiteConnection.d());
                break label258;
              }
              locala1.e.add(paramString1);
              break label258;
            }
          }
          i = this.d;
          this.d = (i + 1);
          locala1.h = (i << 8 | j);
          locala1.j = SQLiteConnection.b(SQLiteConnection.this);
          this.c = j;
          return locala1;
        }
        label258:
        i += 1;
      }
    }
    
    public final String a()
    {
      synchronized (this.b)
      {
        Object localObject1 = this.b[this.c];
        if ((localObject1 != null) && (!((SQLiteConnection.a)localObject1).f))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          ((SQLiteConnection.a)localObject1).a(localStringBuilder);
          localObject1 = localStringBuilder.toString();
          return localObject1;
        }
        return null;
      }
    }
    
    public final void a(int paramInt)
    {
      synchronized (this.b)
      {
        Object localObject1 = c(paramInt);
        if (a((SQLiteConnection.a)localObject1)) {
          a((SQLiteConnection.a)localObject1, null);
        }
        localObject1 = ((SQLiteConnection.a)localObject1).c;
        if (!"prepare".equals(localObject1)) {
          SQLiteConnection.c(SQLiteConnection.this).b();
        }
        return;
      }
    }
    
    public final void a(int paramInt, String paramString)
    {
      synchronized (this.b)
      {
        SQLiteConnection.a locala = c(paramInt);
        if (locala != null) {
          a(locala, paramString);
        }
        return;
      }
    }
    
    public final boolean b(int paramInt)
    {
      synchronized (this.b)
      {
        Object localObject1 = c(paramInt);
        if (localObject1 == null) {
          return false;
        }
        boolean bool = a((SQLiteConnection.a)localObject1);
        localObject1 = ((SQLiteConnection.a)localObject1).c;
        if (!"prepare".equals(localObject1)) {
          SQLiteConnection.c(SQLiteConnection.this).b();
        }
        return bool;
      }
    }
  }
  
  public static final class c
  {
    WeakReference<SQLiteConnection> a;
    c b;
    String c;
    long d;
    int e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    SQLiteConnection.a j;
    
    c(SQLiteConnection paramSQLiteConnection)
    {
      this.a = new WeakReference(paramSQLiteConnection);
    }
  }
  
  final class d
    extends agv<String, SQLiteConnection.c>
  {
    public d(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */