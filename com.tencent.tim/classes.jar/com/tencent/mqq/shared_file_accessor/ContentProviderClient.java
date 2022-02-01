package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ContentProviderClient
{
  private static final String CP_URI_BASE = "content://com.tencent.tim.shared_file_accessor.ContentProviderImpl";
  private static final String DEFAULT_SP_NAME = "default";
  private static final String LOG_TAG = "ContentProviderClient";
  private WeakReference<Context> mContext = null;
  private Uri mUri = null;
  
  public ContentProviderClient(WeakReference<Context> paramWeakReference, String paramString)
  {
    this.mContext = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder().append("content://com.tencent.tim.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.mUri = Uri.parse(paramWeakReference);
  }
  
  private static ContentValues castPair(String paramString, Object paramObject)
  {
    ContentValues localContentValues = new ContentValues(1);
    if ((paramObject instanceof Integer))
    {
      localContentValues.put(paramString, (Integer)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Long))
    {
      localContentValues.put(paramString, (Long)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Float))
    {
      localContentValues.put(paramString, (Float)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof String))
    {
      localContentValues.put(paramString, (String)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Boolean))
    {
      localContentValues.put(paramString, (Boolean)paramObject);
      return localContentValues;
    }
    localContentValues.put(paramString, "");
    return localContentValues;
  }
  
  private static Object getDataFromCursor(Cursor paramCursor, CommonConstants.ValueType paramValueType)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramCursor == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramValueType.mEnumValue)
        {
        case 0: 
          if (paramCursor.getCount() != 0) {
            return Boolean.valueOf(bool1);
          }
        case 5: 
          if (paramCursor.getInt(0) == 0) {
            break label185;
          }
          bool1 = bool2;
          return Boolean.valueOf(bool1);
        case 3: 
          return Float.valueOf(paramCursor.getFloat(0));
        case 1: 
          return Integer.valueOf(paramCursor.getInt(0));
        case 2: 
          return Long.valueOf(paramCursor.getLong(0));
        case 4: 
          return paramCursor.getString(0);
        case 6: 
          paramValueType = new HashSet();
          String str = paramCursor.getString(0);
          if (!TextUtils.isEmpty(str)) {
            paramValueType.add(str);
          }
          bool1 = paramCursor.moveToNext();
          if (bool1) {
            continue;
          }
          return paramValueType;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramCursor)
      {
        return null;
      }
      label185:
      bool1 = false;
    }
  }
  
  public void clear(String paramString)
  {
    delete("*");
  }
  
  public void commit()
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return;
      Object localObject1 = (Context)this.mContext.get();
      if (localObject1 == null) {
        continue;
      }
      try
      {
        localObject1 = ((Context)localObject1).getContentResolver().query(this.mUri, new String[] { "cmd", "5" }, null, null, null);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((Cursor)localObject1).close();
          return;
        }
        catch (Throwable localThrowable) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void delete(String paramString)
  {
    if (this.mContext == null) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.mContext.get();
    } while (localContext == null);
    try
    {
      localContext.getContentResolver().delete(this.mUri, paramString, null);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public Object read(String paramString, CommonConstants.ValueType paramValueType, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mqq/shared_file_accessor/ContentProviderClient:mContext	Ljava/lang/ref/WeakReference;
    //   4: ifnonnull +5 -> 9
    //   7: aload_3
    //   8: areturn
    //   9: aload_0
    //   10: getfield 26	com/tencent/mqq/shared_file_accessor/ContentProviderClient:mContext	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 167	android/content/Context
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull -16 -> 7
    //   26: aload 5
    //   28: invokevirtual 171	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_0
    //   32: getfield 28	com/tencent/mqq/shared_file_accessor/ContentProviderClient:mUri	Landroid/net/Uri;
    //   35: bipush 8
    //   37: anewarray 75	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 173
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 191
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 193
    //   54: aastore
    //   55: dup
    //   56: iconst_3
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc 195
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: aload_2
    //   67: getfield 95	com/tencent/mqq/shared_file_accessor/CommonConstants$ValueType:mEnumValue	I
    //   70: invokestatic 197	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   73: aastore
    //   74: dup
    //   75: bipush 6
    //   77: ldc 11
    //   79: aastore
    //   80: dup
    //   81: bipush 7
    //   83: new 30	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   90: ldc 85
    //   92: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_3
    //   96: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aastore
    //   103: aconst_null
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull -104 -> 7
    //   114: aload_1
    //   115: invokeinterface 203 1 0
    //   120: istore 4
    //   122: iload 4
    //   124: ifne +20 -> 144
    //   127: aload_1
    //   128: invokeinterface 184 1 0
    //   133: aload_3
    //   134: areturn
    //   135: astore_1
    //   136: aload_3
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -31 -> 110
    //   144: aload_1
    //   145: aload_2
    //   146: invokestatic 205	com/tencent/mqq/shared_file_accessor/ContentProviderClient:getDataFromCursor	(Landroid/database/Cursor;Lcom/tencent/mqq/shared_file_accessor/CommonConstants$ValueType;)Ljava/lang/Object;
    //   149: astore_2
    //   150: aload_2
    //   151: ifnull +11 -> 162
    //   154: aload_1
    //   155: invokeinterface 184 1 0
    //   160: aload_2
    //   161: areturn
    //   162: aload_1
    //   163: invokeinterface 184 1 0
    //   168: aload_3
    //   169: areturn
    //   170: astore_1
    //   171: aload_3
    //   172: areturn
    //   173: astore_2
    //   174: aload_1
    //   175: invokeinterface 184 1 0
    //   180: aload_3
    //   181: areturn
    //   182: astore_1
    //   183: aload_3
    //   184: areturn
    //   185: astore_2
    //   186: aload_1
    //   187: invokeinterface 184 1 0
    //   192: aload_2
    //   193: athrow
    //   194: astore_1
    //   195: goto -35 -> 160
    //   198: astore_1
    //   199: goto -7 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	ContentProviderClient
    //   0	202	1	paramString	String
    //   0	202	2	paramValueType	CommonConstants.ValueType
    //   0	202	3	paramObject	Object
    //   120	3	4	bool	boolean
    //   19	8	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   127	133	135	java/lang/Throwable
    //   26	110	138	java/lang/Exception
    //   162	168	170	java/lang/Throwable
    //   114	122	173	java/lang/Throwable
    //   144	150	173	java/lang/Throwable
    //   174	180	182	java/lang/Throwable
    //   114	122	185	finally
    //   144	150	185	finally
    //   154	160	194	java/lang/Throwable
    //   186	192	198	java/lang/Throwable
  }
  
  public Map<String, ?> readAll()
  {
    return null;
  }
  
  public void write(String paramString, Object paramObject, CommonConstants.ValueType paramValueType)
  {
    if (this.mContext == null) {}
    do
    {
      return;
      paramValueType = (Context)this.mContext.get();
    } while (paramValueType == null);
    if (paramObject == null)
    {
      delete(paramString);
      return;
    }
    try
    {
      paramValueType.getContentResolver().insert(this.mUri, castPair(paramString, paramObject));
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.ContentProviderClient
 * JD-Core Version:    0.7.0.1
 */