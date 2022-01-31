package com.tencent.turingfd.sdk.base;

import android.content.BroadcastReceiver;
import android.database.Cursor;

public class dn
{
  public static volatile dn a;
  public dx b = new dx("udid");
  public dx c = new dx("oaid");
  public dx d = new dx("aaid");
  public dx e = new dx("vaid");
  public Boolean f;
  public BroadcastReceiver g;
  
  public static final dn a()
  {
    if (a == null) {}
    try
    {
      a = new dn();
      return a;
    }
    finally {}
  }
  
  public static eq a(Cursor paramCursor)
  {
    eq localeq = new eq(null, 0);
    if (paramCursor == null) {}
    int i;
    do
    {
      do
      {
        return localeq;
      } while (paramCursor.isClosed());
      paramCursor.moveToFirst();
      i = paramCursor.getColumnIndex("value");
      if (i >= 0) {
        localeq.a = paramCursor.getString(i);
      }
      i = paramCursor.getColumnIndex("code");
      if (i >= 0) {
        localeq.b = paramCursor.getInt(i);
      }
      i = paramCursor.getColumnIndex("expired");
    } while (i < 0);
    localeq.c = paramCursor.getLong(i);
    return localeq;
  }
  
  public dx a(String paramString)
  {
    if ("oaid".equals(paramString)) {
      return this.c;
    }
    if ("vaid".equals(paramString)) {
      return this.e;
    }
    if ("aaid".equals(paramString)) {
      return this.d;
    }
    if ("udid".equals(paramString)) {
      return this.b;
    }
    return null;
  }
  
  /* Error */
  public final void a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/turingfd/sdk/base/dn:g	Landroid/content/BroadcastReceiver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 103	android/content/IntentFilter
    //   17: dup
    //   18: invokespecial 104	android/content/IntentFilter:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 106
    //   25: invokevirtual 109	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: new 111	com/tencent/turingfd/sdk/base/void
    //   32: dup
    //   33: invokespecial 112	com/tencent/turingfd/sdk/base/void:<init>	()V
    //   36: putfield 101	com/tencent/turingfd/sdk/base/dn:g	Landroid/content/BroadcastReceiver;
    //   39: aload_1
    //   40: aload_0
    //   41: getfield 101	com/tencent/turingfd/sdk/base/dn:g	Landroid/content/BroadcastReceiver;
    //   44: aload_2
    //   45: ldc 114
    //   47: aconst_null
    //   48: invokevirtual 120	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   51: pop
    //   52: goto -41 -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	dn
    //   0	60	1	paramContext	android.content.Context
    //   6	39	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  /* Error */
  public final boolean a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 125	com/tencent/turingfd/sdk/base/dn:f	Ljava/lang/Boolean;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +13 -> 26
    //   16: iload_2
    //   17: ifne +9 -> 26
    //   20: aload 5
    //   22: invokevirtual 130	java/lang/Boolean:booleanValue	()Z
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull +14 -> 41
    //   30: aload_1
    //   31: invokevirtual 134	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnonnull +19 -> 57
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: ifne +27 -> 71
    //   47: aload_0
    //   48: iconst_0
    //   49: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   52: putfield 125	com/tencent/turingfd/sdk/base/dn:f	Ljava/lang/Boolean;
    //   55: iconst_0
    //   56: ireturn
    //   57: aload 5
    //   59: ldc 140
    //   61: iconst_0
    //   62: invokevirtual 146	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   65: ifnull -24 -> 41
    //   68: goto -25 -> 43
    //   71: ldc 148
    //   73: invokestatic 154	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 158	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: astore_1
    //   83: aload_1
    //   84: aload 5
    //   86: aconst_null
    //   87: aconst_null
    //   88: iconst_1
    //   89: anewarray 94	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: ldc 160
    //   96: aastore
    //   97: aconst_null
    //   98: invokevirtual 166	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +62 -> 165
    //   106: aload_1
    //   107: invokestatic 168	com/tencent/turingfd/sdk/base/dn:a	(Landroid/database/Cursor;)Lcom/tencent/turingfd/sdk/base/eq;
    //   110: getfield 73	com/tencent/turingfd/sdk/base/eq:a	Ljava/lang/String;
    //   113: astore 4
    //   115: aload_1
    //   116: invokeinterface 171 1 0
    //   121: aload 4
    //   123: astore_1
    //   124: new 173	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   131: ldc 176
    //   133: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: pop
    //   144: aload_0
    //   145: ldc 186
    //   147: aload_1
    //   148: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   154: putfield 125	com/tencent/turingfd/sdk/base/dn:f	Ljava/lang/Boolean;
    //   157: aload_0
    //   158: getfield 125	com/tencent/turingfd/sdk/base/dn:f	Ljava/lang/Boolean;
    //   161: invokevirtual 130	java/lang/Boolean:booleanValue	()Z
    //   164: ireturn
    //   165: aload_1
    //   166: ifnull +9 -> 175
    //   169: aload_1
    //   170: invokeinterface 171 1 0
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -53 -> 124
    //   180: astore 5
    //   182: aload 4
    //   184: astore_1
    //   185: aload 5
    //   187: astore 4
    //   189: aload_1
    //   190: ifnull +9 -> 199
    //   193: aload_1
    //   194: invokeinterface 171 1 0
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: new 173	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload 5
    //   217: ldc 188
    //   219: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 4
    //   224: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: pop
    //   234: aload_1
    //   235: ifnull -60 -> 175
    //   238: goto -69 -> 169
    //   241: astore 4
    //   243: goto -54 -> 189
    //   246: astore 4
    //   248: goto -42 -> 206
    //   251: astore 4
    //   253: goto -64 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	dn
    //   0	256	1	paramContext	android.content.Context
    //   0	256	2	paramBoolean	boolean
    //   1	43	3	i	int
    //   3	197	4	localObject1	Object
    //   202	21	4	localException1	java.lang.Exception
    //   241	1	4	localObject2	Object
    //   246	1	4	localException2	java.lang.Exception
    //   251	1	4	localObject3	Object
    //   9	76	5	localObject4	Object
    //   180	6	5	localObject5	Object
    //   213	3	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	83	180	finally
    //   83	102	180	finally
    //   78	83	202	java/lang/Exception
    //   83	102	202	java/lang/Exception
    //   206	215	241	finally
    //   215	234	241	finally
    //   106	115	246	java/lang/Exception
    //   106	115	251	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.dn
 * JD-Core Version:    0.7.0.1
 */