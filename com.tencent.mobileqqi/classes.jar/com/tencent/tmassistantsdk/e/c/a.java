package com.tencent.tmassistantsdk.e.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.e.a.b;
import com.tencent.tmassistantsdk.e.a.c;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements g
{
  /* Error */
  public final b a(int paramInt)
  {
    // Byte code:
    //   0: new 17	com/tencent/tmassistantsdk/e/c/b
    //   3: dup
    //   4: invokespecial 18	com/tencent/tmassistantsdk/e/c/b:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: new 20	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 21	java/util/ArrayList:<init>	()V
    //   18: putfield 24	com/tencent/tmassistantsdk/e/c/b:a	Ljava/util/List;
    //   21: aload 7
    //   23: new 20	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 21	java/util/ArrayList:<init>	()V
    //   30: putfield 27	com/tencent/tmassistantsdk/e/c/b:b	Ljava/util/List;
    //   33: new 29	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 31
    //   39: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: sipush 1000
    //   45: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 5
    //   53: invokestatic 47	com/tencent/tmassistantsdk/e/a/b:a	()Lcom/tencent/tmassistantsdk/e/a/c;
    //   56: invokevirtual 53	com/tencent/tmassistantsdk/e/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 6
    //   61: aload 6
    //   63: aload_0
    //   64: invokevirtual 56	com/tencent/tmassistantsdk/e/c/a:c	()Ljava/lang/String;
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: ldc 58
    //   74: aload 5
    //   76: invokevirtual 64	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +114 -> 197
    //   86: aload 6
    //   88: astore 5
    //   90: aload 6
    //   92: invokeinterface 70 1 0
    //   97: ifeq +100 -> 197
    //   100: aload 6
    //   102: astore 5
    //   104: aload 6
    //   106: aload 6
    //   108: ldc 72
    //   110: invokeinterface 76 2 0
    //   115: invokeinterface 80 2 0
    //   120: lstore_2
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: getfield 24	com/tencent/tmassistantsdk/e/c/b:a	Ljava/util/List;
    //   130: lload_2
    //   131: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokeinterface 92 2 0
    //   139: pop
    //   140: aload 6
    //   142: astore 5
    //   144: aload 6
    //   146: aload 6
    //   148: ldc 94
    //   150: invokeinterface 76 2 0
    //   155: invokeinterface 98 2 0
    //   160: astore 8
    //   162: aload 6
    //   164: astore 5
    //   166: aload 7
    //   168: getfield 27	com/tencent/tmassistantsdk/e/c/b:b	Ljava/util/List;
    //   171: aload 8
    //   173: invokeinterface 92 2 0
    //   178: pop
    //   179: aload 6
    //   181: astore 5
    //   183: aload 6
    //   185: invokeinterface 101 1 0
    //   190: istore 4
    //   192: iload 4
    //   194: ifne -94 -> 100
    //   197: aload 6
    //   199: ifnull +10 -> 209
    //   202: aload 6
    //   204: invokeinterface 104 1 0
    //   209: aload 7
    //   211: areturn
    //   212: astore 7
    //   214: aconst_null
    //   215: astore 6
    //   217: aload 6
    //   219: astore 5
    //   221: aload 7
    //   223: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   226: aload 6
    //   228: ifnull +10 -> 238
    //   231: aload 6
    //   233: invokeinterface 104 1 0
    //   238: aconst_null
    //   239: areturn
    //   240: astore 6
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokeinterface 104 1 0
    //   257: aload 6
    //   259: athrow
    //   260: astore 6
    //   262: goto -17 -> 245
    //   265: astore 7
    //   267: goto -50 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	a
    //   0	270	1	paramInt	int
    //   120	11	2	l	long
    //   190	3	4	bool	boolean
    //   51	200	5	localObject1	Object
    //   59	173	6	localObject2	Object
    //   240	18	6	localObject3	Object
    //   260	1	6	localObject4	Object
    //   7	203	7	localb	b
    //   212	10	7	localException1	java.lang.Exception
    //   265	1	7	localException2	java.lang.Exception
    //   160	12	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	81	212	java/lang/Exception
    //   61	81	240	finally
    //   90	100	260	finally
    //   104	121	260	finally
    //   125	140	260	finally
    //   144	162	260	finally
    //   166	179	260	finally
    //   183	192	260	finally
    //   221	226	260	finally
    //   90	100	265	java/lang/Exception
    //   104	121	265	java/lang/Exception
    //   125	140	265	java/lang/Exception
    //   144	162	265	java/lang/Exception
    //   166	179	265	java/lang/Exception
    //   183	192	265	java/lang/Exception
  }
  
  public final String a()
  {
    return c();
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2) {}
  
  public final boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer("(");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuffer.append((Long)paramList.next());
      localStringBuffer.append(",");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    localStringBuffer.append(")");
    b.a().getWritableDatabase().delete(c(), "_id in " + localStringBuffer, null);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("logData", paramArrayOfByte);
    return b.a().getWritableDatabase().insert(c(), null, localContentValues) > 0L;
  }
  
  public final String[] a(int paramInt1, int paramInt2)
  {
    return b(paramInt2);
  }
  
  public final String b()
  {
    return d();
  }
  
  protected abstract String[] b(int paramInt);
  
  protected abstract String c();
  
  protected abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.a
 * JD-Core Version:    0.7.0.1
 */