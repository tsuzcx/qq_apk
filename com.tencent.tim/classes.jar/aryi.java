import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;

public class aryi
  extends SQLiteOpenHelper
{
  protected static HashMap<Long, aryi> sInstanceMap = new HashMap();
  protected String cDw;
  protected int mAttachCount;
  protected Context mContext;
  protected HashSet<Integer> w = new HashSet();
  protected volatile boolean xj;
  protected boolean xk = true;
  
  protected aryi(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.cDw = paramString;
    this.mContext = paramContext;
  }
  
  public static aryi a(Context paramContext, long paramLong)
  {
    try
    {
      aryi localaryi2 = (aryi)sInstanceMap.get(Long.valueOf(paramLong));
      aryi localaryi1 = localaryi2;
      if (localaryi2 == null)
      {
        localaryi1 = new aryi(paramContext, arwv.encodeHexStr(String.valueOf(paramLong) + "_opensdk"), null, 74);
        sInstanceMap.put(Long.valueOf(paramLong), localaryi1);
      }
      return localaryi1;
    }
    finally {}
  }
  
  public void Mj()
  {
    this.mContext.deleteDatabase(this.cDw);
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 97	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 99	aryi:xj	Z
    //   17: ifeq +29 -> 46
    //   20: aload_1
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: invokevirtual 104	android/database/sqlite/SQLiteDatabase:close	()V
    //   28: aload_0
    //   29: invokevirtual 106	aryi:Mj	()V
    //   32: aload_0
    //   33: invokespecial 97	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 99	aryi:xj	Z
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 106	aryi:Mj	()V
    //   55: aload_0
    //   56: invokespecial 97	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 99	aryi:xj	Z
    //   68: ifeq -22 -> 46
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 99	aryi:xj	Z
    //   76: aload_1
    //   77: astore_2
    //   78: goto -32 -> 46
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 99	aryi:xj	Z
    //   91: ifeq +29 -> 120
    //   94: iconst_0
    //   95: ifeq +11 -> 106
    //   98: new 108	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 109	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: aload_0
    //   107: invokevirtual 106	aryi:Mj	()V
    //   110: aload_0
    //   111: invokespecial 97	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   114: pop
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 99	aryi:xj	Z
    //   120: aload_1
    //   121: athrow
    //   122: astore_2
    //   123: goto -84 -> 39
    //   126: astore_2
    //   127: goto -65 -> 62
    //   130: astore_2
    //   131: goto -16 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	aryi
    //   3	74	1	localObject1	Object
    //   81	4	1	localObject2	Object
    //   86	35	1	localObject3	Object
    //   8	41	2	localObject4	Object
    //   50	1	2	localThrowable1	java.lang.Throwable
    //   59	19	2	localObject5	Object
    //   122	1	2	localThrowable2	java.lang.Throwable
    //   126	1	2	localThrowable3	java.lang.Throwable
    //   130	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	9	50	java/lang/Throwable
    //   13	20	81	finally
    //   24	28	81	finally
    //   28	32	81	finally
    //   32	37	81	finally
    //   39	44	81	finally
    //   46	48	81	finally
    //   64	76	81	finally
    //   82	84	81	finally
    //   87	94	81	finally
    //   98	106	81	finally
    //   106	110	81	finally
    //   110	115	81	finally
    //   115	120	81	finally
    //   120	122	81	finally
    //   4	9	86	finally
    //   51	55	86	finally
    //   55	60	86	finally
    //   32	37	122	java/lang/Throwable
    //   55	60	126	java/lang/Throwable
    //   110	115	130	java/lang/Throwable
  }
  
  public void gz(int paramInt)
  {
    try
    {
      if (this.w.add(Integer.valueOf(paramInt))) {
        this.mAttachCount += 1;
      }
      return;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.xj = true;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.xj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryi
 * JD-Core Version:    0.7.0.1
 */