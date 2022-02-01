package com.tencent.token;

import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.a;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public final class ahr
  extends ahe
{
  public static final SQLiteDatabase.a j = new SQLiteDatabase.a()
  {
    public final ahi a(ahs paramAnonymousahs, String paramAnonymousString, ahw paramAnonymousahw)
    {
      return new ahr(paramAnonymousahs, paramAnonymousString, (ahx)paramAnonymousahw);
    }
    
    public final ahw a(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, aie paramAnonymousaie)
    {
      return new ahx(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousaie);
    }
  };
  private final String k;
  private final String[] l;
  private final ahx m;
  private final ahs n;
  private int o = -1;
  private int p;
  private Map<String, Integer> q;
  private final Throwable r;
  
  public ahr(ahs paramahs, String paramString, ahx paramahx)
  {
    if (paramahx != null)
    {
      this.r = null;
      this.n = paramahs;
      this.k = paramString;
      this.q = null;
      this.m = paramahx;
      this.l = paramahx.d;
      this.c = ahk.a(this.l);
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  private void b(int paramInt)
  {
    a(this.m.a.o());
    try
    {
      if (this.o == -1)
      {
        i = ahk.a(paramInt, 0);
        this.o = this.m.a(this.i, i, paramInt, true);
        this.p = this.i.b();
        return;
      }
      int i = ahk.a(paramInt, this.p);
      this.m.a(this.i, i, paramInt, false);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      c();
      throw localRuntimeException;
    }
  }
  
  public final boolean a(int paramInt)
  {
    if ((this.i == null) || (paramInt < this.i.b) || (paramInt >= this.i.b + this.i.b())) {
      b(paramInt);
    }
    return true;
  }
  
  public final void close()
  {
    super.close();
    try
    {
      this.m.close();
      return;
    }
    finally {}
  }
  
  public final void deactivate()
  {
    super.deactivate();
  }
  
  public final void finalize()
  {
    try
    {
      if (this.i != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getColumnIndex(String paramString)
  {
    if (this.q == null)
    {
      localObject = this.l;
      int i1 = localObject.length;
      HashMap localHashMap = new HashMap(i1, 1.0F);
      i = 0;
      while (i < i1)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      this.q = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      Log.a("WCDB.SQLiteCursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.q.get(localObject);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public final String[] getColumnNames()
  {
    return this.l;
  }
  
  public final int getCount()
  {
    if (this.o == -1) {
      b(0);
    }
    return this.o;
  }
  
  /* Error */
  public final boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 187	com/tencent/token/ahr:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 46	com/tencent/token/ahr:m	Lcom/tencent/token/ahx;
    //   15: getfield 76	com/tencent/token/ahw:a	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   18: invokevirtual 189	com/tencent/wcdb/database/SQLiteDatabase:n	()Z
    //   21: ifne +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 90	com/tencent/token/ahr:i	Lcom/tencent/wcdb/CursorWindow;
    //   32: ifnull +10 -> 42
    //   35: aload_0
    //   36: getfield 90	com/tencent/token/ahr:i	Lcom/tencent/wcdb/CursorWindow;
    //   39: invokevirtual 191	com/tencent/wcdb/CursorWindow:a	()V
    //   42: aload_0
    //   43: iconst_m1
    //   44: putfield 192	com/tencent/token/ahr:b	I
    //   47: aload_0
    //   48: iconst_m1
    //   49: putfield 36	com/tencent/token/ahr:o	I
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: invokespecial 194	com/tencent/token/ahe:requery	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ireturn
    //   61: astore_2
    //   62: new 196	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 198
    //   68: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: astore_3
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual 202	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 148
    //   83: aload_3
    //   84: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: iconst_1
    //   88: anewarray 159	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: invokestatic 211	com/tencent/wcdb/support/Log:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ahr
    //   58	2	1	bool	boolean
    //   61	33	2	localIllegalStateException	java.lang.IllegalStateException
    //   100	4	2	localObject	Object
    //   71	13	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	59	61	java/lang/IllegalStateException
    //   11	26	100	finally
    //   28	42	100	finally
    //   42	54	100	finally
    //   101	103	100	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahr
 * JD-Core Version:    0.7.0.1
 */