import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tyt
{
  private static final long EV = ;
  private static tyt b;
  private tyu a;
  private SQLiteDatabase database;
  
  private tyt(Context paramContext)
  {
    this.a = tyu.a(paramContext);
    try
    {
      this.database = this.a.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Magnifier_DBHandler", 2, paramContext, new Object[0]);
    }
  }
  
  private ResultObject a(Cursor paramCursor)
    throws JSONException
  {
    if (paramCursor == null) {
      return null;
    }
    ResultObject localResultObject = new ResultObject();
    localResultObject.dbId = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    localResultObject.params = new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localResultObject.isRealTime = bool;
      localResultObject.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      return localResultObject;
    }
  }
  
  public static tyt a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new tyt(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((this.database == null) || (!this.database.isOpen())) {
      return -2;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_DBHandler", 2, new Object[] { "dropframe delete table", paramString1 });
      }
      int i = this.database.delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramString1)
    {
      QLog.e("Magnifier_DBHandler", 1, "delete dropframe table has a exception", paramString1);
    }
    return -1;
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    int j = -1;
    int i;
    if ((this.database == null) || (!this.database.isOpen())) {
      i = -2;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == 1) {
          break;
        }
        i = j;
      } while (paramInt != 2);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(paramInt));
      try
      {
        paramInt = this.database.update(paramString, localContentValues, "_id=" + paramLong, null);
        return paramInt;
      }
      catch (Exception paramString)
      {
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
    return -1;
  }
  
  public long a(ResultObject paramResultObject)
  {
    if ((this.database == null) || (!this.database.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("params", paramResultObject.params.toString());
    localContentValues.put("is_real_time", Boolean.valueOf(paramResultObject.isRealTime));
    localContentValues.put("uin", Long.valueOf(paramResultObject.uin));
    localContentValues.put("status", Integer.valueOf(1));
    try
    {
      l1 = paramResultObject.params.getJSONObject("clientinfo").optLong("event_time");
      long l2 = l1;
      if (l1 == 0L) {
        l2 = EV;
      }
      localContentValues.put("occur_time", Long.valueOf(l2));
    }
    catch (Exception paramResultObject)
    {
      for (;;)
      {
        try
        {
          l1 = this.database.insert("result_objects", "name", localContentValues);
          return l1;
        }
        catch (Exception paramResultObject)
        {
          long l1;
          if (!QLog.isColorLevel()) {
            break label164;
          }
          QLog.e("Magnifier_DBHandler", 2, paramResultObject, new Object[0]);
        }
        paramResultObject = paramResultObject;
        l1 = 0L;
      }
    }
    label164:
    return -1L;
  }
  
  public int g(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return delete(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(2), String.valueOf(System.currentTimeMillis() - 86400000L) });
    }
    return delete(paramString, "status=?", new String[] { String.valueOf(2) });
  }
  
  /* Error */
  public java.util.List<ResultObject> m(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 20	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 235	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 236	java/util/ArrayList:<init>	()V
    //   14: astore 7
    //   16: aload_0
    //   17: getfield 42	tyt:database	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 42	tyt:database	Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 119	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   30: ifne +6 -> 36
    //   33: aload 7
    //   35: areturn
    //   36: iconst_1
    //   37: iload_1
    //   38: if_icmpne +62 -> 100
    //   41: aload_0
    //   42: getfield 42	tyt:database	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc 207
    //   47: aconst_null
    //   48: ldc 238
    //   50: iconst_2
    //   51: anewarray 221	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: iconst_1
    //   57: invokestatic 223	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: lload_2
    //   64: ldc2_w 224
    //   67: lsub
    //   68: invokestatic 228	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: invokevirtual 242	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnonnull +38 -> 120
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: invokeinterface 245 1 0
    //   97: aload 7
    //   99: areturn
    //   100: aload_0
    //   101: getfield 42	tyt:database	Landroid/database/sqlite/SQLiteDatabase;
    //   104: ldc 207
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: aconst_null
    //   112: invokevirtual 242	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore 4
    //   117: goto -37 -> 80
    //   120: aload 4
    //   122: astore 5
    //   124: aload 4
    //   126: invokeinterface 248 1 0
    //   131: pop
    //   132: aload 4
    //   134: astore 5
    //   136: aload 4
    //   138: invokeinterface 251 1 0
    //   143: ifne +92 -> 235
    //   146: aload 4
    //   148: astore 5
    //   150: aload_0
    //   151: aload 4
    //   153: invokespecial 253	tyt:a	(Landroid/database/Cursor;)Lcom/tencent/mfsdk/collector/ResultObject;
    //   156: astore 6
    //   158: aload 6
    //   160: ifnull +17 -> 177
    //   163: aload 4
    //   165: astore 5
    //   167: aload 7
    //   169: aload 6
    //   171: invokeinterface 259 2 0
    //   176: pop
    //   177: aload 4
    //   179: astore 5
    //   181: aload 4
    //   183: invokeinterface 262 1 0
    //   188: pop
    //   189: goto -57 -> 132
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +19 -> 220
    //   204: aload 4
    //   206: astore 5
    //   208: ldc 50
    //   210: iconst_2
    //   211: aload 6
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 54	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   220: aload 4
    //   222: ifnull +10 -> 232
    //   225: aload 4
    //   227: invokeinterface 245 1 0
    //   232: aload 7
    //   234: areturn
    //   235: aload 4
    //   237: ifnull -5 -> 232
    //   240: aload 4
    //   242: invokeinterface 245 1 0
    //   247: goto -15 -> 232
    //   250: astore 4
    //   252: aload 5
    //   254: ifnull +10 -> 264
    //   257: aload 5
    //   259: invokeinterface 245 1 0
    //   264: aload 4
    //   266: athrow
    //   267: astore 4
    //   269: goto -17 -> 252
    //   272: astore 6
    //   274: aconst_null
    //   275: astore 4
    //   277: goto -83 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	tyt
    //   0	280	1	paramBoolean	boolean
    //   6	58	2	l	long
    //   78	163	4	localCursor	Cursor
    //   250	15	4	localObject1	Object
    //   267	1	4	localObject2	Object
    //   275	1	4	localObject3	Object
    //   1	257	5	localObject4	Object
    //   156	14	6	localResultObject	ResultObject
    //   192	20	6	localException1	Exception
    //   272	1	6	localException2	Exception
    //   14	219	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   124	132	192	java/lang/Exception
    //   136	146	192	java/lang/Exception
    //   150	158	192	java/lang/Exception
    //   167	177	192	java/lang/Exception
    //   181	189	192	java/lang/Exception
    //   41	80	250	finally
    //   100	117	250	finally
    //   124	132	267	finally
    //   136	146	267	finally
    //   150	158	267	finally
    //   167	177	267	finally
    //   181	189	267	finally
    //   198	204	267	finally
    //   208	220	267	finally
    //   41	80	272	java/lang/Exception
    //   100	117	272	java/lang/Exception
  }
  
  public int vi()
  {
    return delete("result_objects", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */