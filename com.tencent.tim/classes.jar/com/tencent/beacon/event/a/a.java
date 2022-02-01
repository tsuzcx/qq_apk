package com.tencent.beacon.event.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import com.tencent.beacon.event.EventBean;
import java.util.ArrayList;
import java.util.List;

public class a
  implements com.tencent.beacon.a.d.d<EventBean>
{
  private final SQLiteStatement a;
  private final SQLiteStatement b;
  private final Object c = new Object();
  private final Object d = new Object();
  private com.tencent.beacon.event.c.b e = com.tencent.beacon.event.c.b.a();
  private SQLiteDatabase f;
  private SQLiteDatabase g;
  private long h;
  private long i;
  
  public a()
  {
    Object localObject = new com.tencent.beacon.a.d.c(com.tencent.beacon.a.c.b.c(com.tencent.beacon.a.c.c.d().c()));
    this.f = ((SQLiteOpenHelper)localObject).getWritableDatabase();
    this.g = ((SQLiteOpenHelper)localObject).getReadableDatabase();
    this.a = this.g.compileStatement("INSERT INTO t_r_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
    this.b = this.g.compileStatement("INSERT INTO t_n_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
    this.h = a("t_r_e");
    this.i = a("t_n_e");
    if ((this.h != 0L) || (this.i != 0L))
    {
      localObject = " realtime: " + this.h + ", normal: " + this.i;
      com.tencent.beacon.base.util.c.a("[EventDAO]", (String)localObject, new Object[0]);
      com.tencent.beacon.a.b.d.b().a("607", "[EventDAO]" + (String)localObject);
    }
  }
  
  private List<EventBean> a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramCursor.moveToNext())
    {
      b localb = new b();
      localb.a = paramCursor.getLong(0);
      localb.d = paramCursor.getString(1);
      localb.b = paramCursor.getInt(2);
      localb.c = paramCursor.getLong(3);
      localb.e = paramCursor.getBlob(4);
      localArrayList.add((EventBean)this.e.c().a(localb));
    }
    if (!paramCursor.isClosed()) {
      paramCursor.close();
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean1)
    {
      localObject1 = this.c;
      if (paramBoolean2) {}
      for (;;)
      {
        try
        {
          this.h += paramLong;
          com.tencent.beacon.base.util.c.a("[EventDAO]", "current db realtime:%s", new Object[] { Long.valueOf(this.h) });
          return;
        }
        finally {}
        this.h -= paramLong;
      }
    }
    Object localObject1 = this.d;
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        this.i += paramLong;
        com.tencent.beacon.base.util.c.a("[EventDAO]", "current db normal:%s", new Object[] { Long.valueOf(this.i) });
        return;
      }
      finally {}
      this.i -= paramLong;
    }
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 207
    //   3: lstore 4
    //   5: aconst_null
    //   6: astore 7
    //   8: new 94	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   15: astore 6
    //   17: aload 6
    //   19: ldc 210
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 6
    //   33: aload_0
    //   34: getfield 67	com/tencent/beacon/event/a/a:g	Landroid/database/sqlite/SQLiteDatabase;
    //   37: aload 6
    //   39: iconst_1
    //   40: anewarray 212	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc 214
    //   47: aastore
    //   48: invokevirtual 218	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 6
    //   53: aload 6
    //   55: invokeinterface 221 1 0
    //   60: pop
    //   61: aload 6
    //   63: iconst_0
    //   64: invokeinterface 148 2 0
    //   69: lstore_2
    //   70: lload_2
    //   71: lstore 4
    //   73: lload 4
    //   75: lstore_2
    //   76: aload 6
    //   78: ifnull +26 -> 104
    //   81: lload 4
    //   83: lstore_2
    //   84: aload 6
    //   86: invokeinterface 135 1 0
    //   91: ifne +13 -> 104
    //   94: aload 6
    //   96: invokeinterface 191 1 0
    //   101: lload 4
    //   103: lstore_2
    //   104: lload_2
    //   105: lreturn
    //   106: astore_1
    //   107: aload 6
    //   109: ifnull +20 -> 129
    //   112: aload 6
    //   114: invokeinterface 135 1 0
    //   119: ifne +10 -> 129
    //   122: aload 6
    //   124: invokeinterface 191 1 0
    //   129: aload_1
    //   130: athrow
    //   131: astore 7
    //   133: invokestatic 122	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   136: astore 8
    //   138: new 94	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   145: astore 9
    //   147: aload 9
    //   149: ldc 223
    //   151: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: astore_1
    //   159: aload 8
    //   161: ldc 225
    //   163: aload_1
    //   164: ldc 227
    //   166: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: invokevirtual 230	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: aload 7
    //   182: invokevirtual 233	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload 7
    //   187: invokestatic 236	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   190: lload 4
    //   192: lstore_2
    //   193: aload 6
    //   195: ifnull -91 -> 104
    //   198: lload 4
    //   200: lstore_2
    //   201: aload 6
    //   203: invokeinterface 135 1 0
    //   208: ifne -104 -> 104
    //   211: aload 6
    //   213: invokeinterface 191 1 0
    //   218: ldc2_w 207
    //   221: lreturn
    //   222: astore 8
    //   224: aload 7
    //   226: astore 6
    //   228: aload 8
    //   230: astore 7
    //   232: goto -99 -> 133
    //   235: astore_1
    //   236: aconst_null
    //   237: astore 6
    //   239: goto -132 -> 107
    //   242: astore_1
    //   243: goto -136 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	a
    //   0	246	1	paramString	String
    //   69	132	2	l1	long
    //   3	196	4	l2	long
    //   15	223	6	localObject1	Object
    //   6	1	7	localObject2	Object
    //   131	94	7	localException1	Exception
    //   230	1	7	localObject3	Object
    //   136	24	8	locald	com.tencent.beacon.a.b.d
    //   222	7	8	localException2	Exception
    //   145	3	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   53	70	106	finally
    //   53	70	131	java/lang/Exception
    //   8	17	222	java/lang/Exception
    //   17	33	222	java/lang/Exception
    //   33	53	222	java/lang/Exception
    //   8	17	235	finally
    //   17	33	235	finally
    //   33	53	235	finally
    //   133	138	242	finally
    //   138	147	242	finally
    //   147	159	242	finally
    //   159	190	242	finally
  }
  
  public List<EventBean> a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = null;
    long l = System.currentTimeMillis();
    try
    {
      Object localObject2 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject2).append(" SELECT * FROM ").append(paramString1);
      localObject2 = ((StringBuilder)localObject2).append(" WHERE ");
      localObject2 = ((StringBuilder)localObject2).append("_id");
      localObject2 = ((StringBuilder)localObject2).append(" NOT IN (").append(paramString2);
      localObject2 = ((StringBuilder)localObject2).append(") ORDER BY ");
      localObject2 = ((StringBuilder)localObject2).append("_time");
      localObject2 = " DESC LIMIT " + paramInt;
      localObject2 = a(this.g.rawQuery((String)localObject2, null));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.beacon.base.util.c.a(localException);
        com.tencent.beacon.a.b.d.b().a("605", "type: " + paramString1 + " query err: " + localException.getMessage(), localException);
      }
    }
    com.tencent.beacon.base.util.c.a("[EventDAO]", "query tableName: %s, args: %s", new Object[] { paramString1, paramString2 });
    com.tencent.beacon.base.util.c.a("[EventDAO]", "query cost time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject1;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 1) {}
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.h < com.tencent.beacon.e.b.a().b()) {
          break label90;
        }
        return bool1;
      }
      for (;;)
      {
        synchronized (this.d)
        {
          if (this.i >= com.tencent.beacon.e.b.a().b())
          {
            bool1 = bool2;
            return bool1;
          }
        }
        bool1 = false;
      }
      label90:
      bool1 = false;
    }
  }
  
  public boolean a(EventBean paramEventBean)
  {
    if (paramEventBean == null) {
      return false;
    }
    Object localObject = (b)this.e.b().a(paramEventBean);
    boolean bool2 = com.tencent.beacon.event.c.d.a(paramEventBean.getEventType());
    try
    {
      this.f.beginTransactionNonExclusive();
      this.a.clearBindings();
      if (!bool2) {
        break label151;
      }
      this.a.bindString(1, ((b)localObject).d);
      this.a.bindLong(2, ((b)localObject).b);
      this.a.bindLong(3, ((b)localObject).c);
      this.a.bindBlob(4, ((b)localObject).e);
    }
    catch (Exception paramEventBean)
    {
      try
      {
        for (;;)
        {
          this.f.setTransactionSuccessful();
          this.f.endTransaction();
          if (!bool1) {
            break;
          }
          a(bool2, true, 1L);
          return bool1;
          this.b.bindString(1, ((b)localObject).d);
          this.b.bindLong(2, ((b)localObject).b);
          this.b.bindLong(3, ((b)localObject).c);
          this.b.bindBlob(4, ((b)localObject).e);
        }
        paramEventBean = paramEventBean;
        localObject = com.tencent.beacon.a.b.d.b();
        localStringBuilder = new StringBuilder();
        localStringBuilder = localStringBuilder.append("type: ").append(bool2);
        ((com.tencent.beacon.a.b.d)localObject).a("603", " insert err: " + paramEventBean.getMessage(), paramEventBean);
        com.tencent.beacon.base.util.c.a(paramEventBean);
      }
      catch (Exception paramEventBean)
      {
        boolean bool1;
        try
        {
          for (;;)
          {
            this.f.setTransactionSuccessful();
            this.f.endTransaction();
            bool1 = false;
            continue;
            long l = this.b.executeInsert();
            if (l < 0L) {
              bool1 = false;
            }
          }
          paramEventBean = paramEventBean;
          com.tencent.beacon.a.b.d.b().a("603", "type: " + bool2 + " insert err: " + paramEventBean.getMessage(), paramEventBean);
          com.tencent.beacon.base.util.c.a(paramEventBean);
        }
        catch (Exception paramEventBean)
        {
          for (;;)
          {
            com.tencent.beacon.a.b.d.b().a("603", "type: " + bool2 + " insert err: " + paramEventBean.getMessage(), paramEventBean);
            com.tencent.beacon.base.util.c.a(paramEventBean);
          }
        }
        com.tencent.beacon.a.b.d.b().a("603", "type: " + bool2 + " insert result: " + false);
        return bool1;
      }
    }
    finally {}
    if (bool2)
    {
      l = this.a.executeInsert();
      if (l < 0L) {
        break label300;
      }
      bool1 = true;
    }
    try
    {
      label151:
      StringBuilder localStringBuilder;
      label300:
      this.f.setTransactionSuccessful();
      this.f.endTransaction();
      throw paramEventBean;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.beacon.a.b.d.b().a("603", "type: " + bool2 + " insert err: " + localException.getMessage(), localException);
        com.tencent.beacon.base.util.c.a(localException);
      }
    }
  }
  
  public boolean a(@NonNull String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      Object localObject = new StringBuilder();
      localObject = ((StringBuilder)localObject).append("_id IN (").append(paramString2);
      localObject = ")";
      int j = this.f.delete(paramString1, (String)localObject, null);
      a(paramString1.equals("t_r_e"), false, j);
      if (j >= 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.b.d.b().a("606", "type: " + paramString1 + " delete err: " + localException.getMessage() + " target: " + paramString2, localException);
      com.tencent.beacon.base.util.c.a(localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.a.a
 * JD-Core Version:    0.7.0.1
 */