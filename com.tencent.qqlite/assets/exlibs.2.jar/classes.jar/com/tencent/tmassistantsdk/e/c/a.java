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
    //   63: ifnull +151 -> 214
    //   66: aload 6
    //   68: aload_0
    //   69: invokevirtual 56	com/tencent/tmassistantsdk/e/c/a:c	()Ljava/lang/String;
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc 58
    //   79: aload 5
    //   81: invokevirtual 64	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +114 -> 202
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: invokeinterface 70 1 0
    //   102: ifeq +100 -> 202
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: aload 6
    //   113: ldc 72
    //   115: invokeinterface 76 2 0
    //   120: invokeinterface 80 2 0
    //   125: lstore_2
    //   126: aload 6
    //   128: astore 5
    //   130: aload 7
    //   132: getfield 24	com/tencent/tmassistantsdk/e/c/b:a	Ljava/util/List;
    //   135: lload_2
    //   136: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: invokeinterface 92 2 0
    //   144: pop
    //   145: aload 6
    //   147: astore 5
    //   149: aload 6
    //   151: aload 6
    //   153: ldc 94
    //   155: invokeinterface 76 2 0
    //   160: invokeinterface 98 2 0
    //   165: astore 8
    //   167: aload 6
    //   169: astore 5
    //   171: aload 7
    //   173: getfield 27	com/tencent/tmassistantsdk/e/c/b:b	Ljava/util/List;
    //   176: aload 8
    //   178: invokeinterface 92 2 0
    //   183: pop
    //   184: aload 6
    //   186: astore 5
    //   188: aload 6
    //   190: invokeinterface 101 1 0
    //   195: istore 4
    //   197: iload 4
    //   199: ifne -94 -> 105
    //   202: aload 6
    //   204: ifnull +10 -> 214
    //   207: aload 6
    //   209: invokeinterface 104 1 0
    //   214: aload 7
    //   216: areturn
    //   217: astore 7
    //   219: aconst_null
    //   220: astore 6
    //   222: aload 6
    //   224: astore 5
    //   226: aload 7
    //   228: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   231: aload 6
    //   233: ifnull +10 -> 243
    //   236: aload 6
    //   238: invokeinterface 104 1 0
    //   243: aconst_null
    //   244: areturn
    //   245: astore 6
    //   247: aconst_null
    //   248: astore 5
    //   250: aload 5
    //   252: ifnull +10 -> 262
    //   255: aload 5
    //   257: invokeinterface 104 1 0
    //   262: aload 6
    //   264: athrow
    //   265: astore 6
    //   267: goto -17 -> 250
    //   270: astore 7
    //   272: goto -50 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	a
    //   0	275	1	paramInt	int
    //   125	11	2	l	long
    //   195	3	4	bool	boolean
    //   51	205	5	localObject1	Object
    //   59	178	6	localObject2	Object
    //   245	18	6	localObject3	Object
    //   265	1	6	localObject4	Object
    //   7	208	7	localb	b
    //   217	10	7	localException1	java.lang.Exception
    //   270	1	7	localException2	java.lang.Exception
    //   165	12	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   66	86	217	java/lang/Exception
    //   66	86	245	finally
    //   95	105	265	finally
    //   109	126	265	finally
    //   130	145	265	finally
    //   149	167	265	finally
    //   171	184	265	finally
    //   188	197	265	finally
    //   226	231	265	finally
    //   95	105	270	java/lang/Exception
    //   109	126	270	java/lang/Exception
    //   130	145	270	java/lang/Exception
    //   149	167	270	java/lang/Exception
    //   171	184	270	java/lang/Exception
    //   188	197	270	java/lang/Exception
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
    paramList = b.a().getWritableDatabase();
    if (paramList != null) {
      paramList.delete(c(), "_id in " + localStringBuffer, null);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.a
 * JD-Core Version:    0.7.0.1
 */