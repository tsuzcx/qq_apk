package com.tencent.qmsp.sdk.g.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

public class c
{
  public static volatile c g;
  public b a = new b("udid");
  public b b = new b("oaid");
  public b c = new b("aaid");
  public b d = new b("vaid");
  public Boolean e;
  public BroadcastReceiver f;
  
  public static final c a()
  {
    if (g == null) {}
    try
    {
      g = new c();
      return g;
    }
    finally {}
  }
  
  public static e a(Cursor paramCursor)
  {
    e locale = new e(null, 0);
    if (paramCursor == null)
    {
      b("parseValue fail, cursor is null.");
      return locale;
    }
    if (!paramCursor.isClosed())
    {
      paramCursor.moveToFirst();
      int i = paramCursor.getColumnIndex("value");
      if (i >= 0)
      {
        locale.c = paramCursor.getString(i);
        i = paramCursor.getColumnIndex("code");
        if (i < 0) {
          break label119;
        }
        locale.a = paramCursor.getInt(i);
      }
      for (;;)
      {
        i = paramCursor.getColumnIndex("expired");
        if (i < 0) {
          break label127;
        }
        locale.b = paramCursor.getLong(i);
        return locale;
        b("parseValue fail, index < 0.");
        break;
        label119:
        b("parseCode fail, index < 0.");
      }
      label127:
      b("parseExpired fail, index < 0.");
      return locale;
    }
    b("parseValue fail, cursor is closed.");
    return locale;
  }
  
  public static void b(String paramString)
  {
    com.tencent.qmsp.sdk.base.c.a("MzOpenIdManager " + paramString);
  }
  
  public b a(String paramString)
  {
    if ("oaid".equals(paramString)) {
      return this.b;
    }
    if ("vaid".equals(paramString)) {
      return this.d;
    }
    if ("aaid".equals(paramString)) {
      return this.c;
    }
    if (!"udid".equals(paramString)) {
      return null;
    }
    return this.a;
  }
  
  /* Error */
  public final String a(Context paramContext, b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_2
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aload_2
    //   12: invokevirtual 132	com/tencent/qmsp/sdk/g/e/b:a	()Z
    //   15: ifne +369 -> 384
    //   18: new 105	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   25: ldc 134
    //   27: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   34: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   43: ldc 137
    //   45: invokestatic 143	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: astore 5
    //   50: aload_1
    //   51: invokevirtual 149	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 5
    //   56: aconst_null
    //   57: aconst_null
    //   58: iconst_1
    //   59: anewarray 123	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   68: aastore
    //   69: aconst_null
    //   70: invokestatic 155	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 5
    //   75: aload 5
    //   77: ifnonnull +60 -> 137
    //   80: aload_0
    //   81: aload_1
    //   82: iconst_0
    //   83: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   86: pop
    //   87: aload_0
    //   88: aload_1
    //   89: iconst_1
    //   90: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   93: istore 4
    //   95: new 105	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   102: astore_1
    //   103: aload_1
    //   104: ldc 160
    //   106: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload 4
    //   111: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   120: aload 6
    //   122: astore_1
    //   123: aload 5
    //   125: ifnull -116 -> 9
    //   128: aload 5
    //   130: invokeinterface 166 1 0
    //   135: aconst_null
    //   136: areturn
    //   137: aload 5
    //   139: invokestatic 168	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/database/Cursor;)Lcom/tencent/qmsp/sdk/g/e/e;
    //   142: astore 8
    //   144: aload 8
    //   146: getfield 77	com/tencent/qmsp/sdk/g/e/e:c	Ljava/lang/String;
    //   149: astore 7
    //   151: aload_2
    //   152: aload 7
    //   154: invokevirtual 169	com/tencent/qmsp/sdk/g/e/b:a	(Ljava/lang/String;)V
    //   157: aload_2
    //   158: aload 8
    //   160: getfield 95	com/tencent/qmsp/sdk/g/e/e:b	J
    //   163: invokevirtual 172	com/tencent/qmsp/sdk/g/e/b:a	(J)V
    //   166: aload_2
    //   167: aload 8
    //   169: getfield 86	com/tencent/qmsp/sdk/g/e/e:a	I
    //   172: invokevirtual 175	com/tencent/qmsp/sdk/g/e/b:a	(I)V
    //   175: new 105	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   182: aload_2
    //   183: getfield 135	com/tencent/qmsp/sdk/g/e/b:c	Ljava/lang/String;
    //   186: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: astore 6
    //   191: aload 6
    //   193: ldc 177
    //   195: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_2
    //   199: getfield 178	com/tencent/qmsp/sdk/g/e/b:a	I
    //   202: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   211: aload 8
    //   213: getfield 86	com/tencent/qmsp/sdk/g/e/e:a	I
    //   216: istore_3
    //   217: iload_3
    //   218: sipush 1000
    //   221: if_icmpne +18 -> 239
    //   224: aload 5
    //   226: ifnull +10 -> 236
    //   229: aload 5
    //   231: invokeinterface 166 1 0
    //   236: aload 7
    //   238: areturn
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 184	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;)V
    //   244: aload_0
    //   245: aload_1
    //   246: iconst_0
    //   247: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   250: istore 4
    //   252: iload 4
    //   254: ifeq +18 -> 272
    //   257: aload 5
    //   259: ifnull +10 -> 269
    //   262: aload 5
    //   264: invokeinterface 166 1 0
    //   269: aload 7
    //   271: areturn
    //   272: aload_0
    //   273: aload_1
    //   274: iconst_1
    //   275: invokevirtual 158	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/content/Context;Z)Z
    //   278: istore 4
    //   280: new 105	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   287: astore_1
    //   288: aload_1
    //   289: ldc 186
    //   291: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: iload 4
    //   296: invokevirtual 163	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   305: aload 5
    //   307: ifnull +10 -> 317
    //   310: aload 5
    //   312: invokeinterface 166 1 0
    //   317: aload 7
    //   319: areturn
    //   320: astore_1
    //   321: aload 5
    //   323: ifnull -316 -> 7
    //   326: aload 5
    //   328: invokeinterface 166 1 0
    //   333: goto -326 -> 7
    //   336: astore_1
    //   337: aload 6
    //   339: astore_1
    //   340: aload 5
    //   342: ifnull -333 -> 9
    //   345: aload 5
    //   347: invokeinterface 166 1 0
    //   352: aconst_null
    //   353: areturn
    //   354: astore_1
    //   355: aconst_null
    //   356: astore 5
    //   358: aload 5
    //   360: ifnull +10 -> 370
    //   363: aload 5
    //   365: invokeinterface 166 1 0
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 5
    //   376: aload 5
    //   378: ifnull -371 -> 7
    //   381: goto -55 -> 326
    //   384: aload_2
    //   385: getfield 188	com/tencent/qmsp/sdk/g/e/b:d	Ljava/lang/String;
    //   388: astore_1
    //   389: goto -380 -> 9
    //   392: astore_1
    //   393: goto -35 -> 358
    //   396: astore_1
    //   397: goto -21 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	c
    //   0	400	1	paramContext	Context
    //   0	400	2	paramb	b
    //   216	6	3	i	int
    //   93	202	4	bool	boolean
    //   48	329	5	localObject	Object
    //   1	337	6	localStringBuilder	java.lang.StringBuilder
    //   149	169	7	str	String
    //   142	70	8	locale	e
    // Exception table:
    //   from	to	target	type
    //   151	191	320	java/lang/Exception
    //   191	217	320	java/lang/Exception
    //   239	252	320	java/lang/Exception
    //   272	288	320	java/lang/Exception
    //   288	305	320	java/lang/Exception
    //   137	151	336	java/lang/Exception
    //   50	75	354	finally
    //   50	75	372	java/lang/Exception
    //   80	103	392	finally
    //   103	120	392	finally
    //   137	151	392	finally
    //   151	191	392	finally
    //   191	217	392	finally
    //   239	252	392	finally
    //   272	288	392	finally
    //   288	305	392	finally
    //   80	103	396	java/lang/Exception
    //   103	120	396	java/lang/Exception
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (this.f == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.f = new a();
        BroadcastReceiver localBroadcastReceiver = this.f;
        paramContext.registerReceiver(localBroadcastReceiver, localIntentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: getfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +15 -> 28
    //   16: iload_2
    //   17: ifne +11 -> 28
    //   20: aload 5
    //   22: invokevirtual 214	java/lang/Boolean:booleanValue	()Z
    //   25: istore_2
    //   26: iload_2
    //   27: ireturn
    //   28: aload_1
    //   29: ifnonnull +24 -> 53
    //   32: iconst_0
    //   33: istore_3
    //   34: iload_3
    //   35: ifne +47 -> 82
    //   38: ldc 216
    //   40: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: iconst_0
    //   45: invokestatic 220	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_1
    //   54: invokevirtual 224	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   57: astore 5
    //   59: aload 5
    //   61: ifnonnull +5 -> 66
    //   64: iconst_0
    //   65: istore_3
    //   66: aload 5
    //   68: ldc 226
    //   70: iconst_0
    //   71: invokevirtual 232	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   74: ifnonnull -40 -> 34
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -45 -> 34
    //   82: ldc 137
    //   84: invokestatic 143	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   87: astore 5
    //   89: aload_1
    //   90: invokevirtual 149	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   93: astore_1
    //   94: aload_1
    //   95: aload 5
    //   97: aconst_null
    //   98: aconst_null
    //   99: iconst_1
    //   100: anewarray 123	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: ldc 234
    //   107: aastore
    //   108: aconst_null
    //   109: invokestatic 155	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore_1
    //   113: aload_1
    //   114: ifnonnull +11 -> 125
    //   117: aload_0
    //   118: iconst_0
    //   119: invokestatic 220	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   122: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   125: aload_1
    //   126: invokestatic 168	com/tencent/qmsp/sdk/g/e/c:a	(Landroid/database/Cursor;)Lcom/tencent/qmsp/sdk/g/e/e;
    //   129: getfield 77	com/tencent/qmsp/sdk/g/e/e:c	Ljava/lang/String;
    //   132: astore 5
    //   134: new 105	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   141: astore 6
    //   143: aload 6
    //   145: ldc 236
    //   147: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 5
    //   152: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 55	com/tencent/qmsp/sdk/g/e/c:b	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: ldc 238
    //   164: aload 5
    //   166: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: invokestatic 220	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: putfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   175: aload_0
    //   176: getfield 209	com/tencent/qmsp/sdk/g/e/c:e	Ljava/lang/Boolean;
    //   179: invokevirtual 214	java/lang/Boolean:booleanValue	()Z
    //   182: istore_2
    //   183: iload_2
    //   184: istore 4
    //   186: iload 4
    //   188: istore_2
    //   189: aload_1
    //   190: ifnull -164 -> 26
    //   193: aload_1
    //   194: invokeinterface 166 1 0
    //   199: iload 4
    //   201: ireturn
    //   202: astore 5
    //   204: iload 4
    //   206: istore_2
    //   207: aload_1
    //   208: ifnull -182 -> 26
    //   211: aload_1
    //   212: invokeinterface 166 1 0
    //   217: iconst_0
    //   218: ireturn
    //   219: astore 5
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +9 -> 233
    //   227: aload_1
    //   228: invokeinterface 166 1 0
    //   233: aload 5
    //   235: athrow
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_1
    //   239: iload 4
    //   241: istore_2
    //   242: aload_1
    //   243: ifnull -217 -> 26
    //   246: goto -35 -> 211
    //   249: astore 5
    //   251: goto -12 -> 239
    //   254: astore 5
    //   256: goto -33 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	c
    //   0	259	1	paramContext	Context
    //   0	259	2	paramBoolean	boolean
    //   1	78	3	i	int
    //   3	237	4	bool	boolean
    //   9	156	5	localObject1	Object
    //   202	1	5	localException1	java.lang.Exception
    //   219	15	5	localObject2	Object
    //   249	1	5	localException2	java.lang.Exception
    //   254	1	5	localObject3	Object
    //   141	3	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	143	202	java/lang/Exception
    //   143	161	202	java/lang/Exception
    //   161	183	202	java/lang/Exception
    //   89	94	219	finally
    //   94	113	219	finally
    //   89	94	236	java/lang/Exception
    //   94	113	236	java/lang/Exception
    //   117	125	249	java/lang/Exception
    //   117	125	254	finally
    //   125	143	254	finally
    //   143	161	254	finally
    //   161	183	254	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.c
 * JD-Core Version:    0.7.0.1
 */