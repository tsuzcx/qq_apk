package btmsdkobf;

import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.util.Log;

public class e
{
  public static volatile e d;
  public static boolean e;
  public a f = new a("udid");
  public a g = new a("oaid");
  public a h = new a("aaid");
  public a i = new a("vaid");
  public Boolean j;
  public BroadcastReceiver k;
  
  public static c a(Cursor paramCursor)
  {
    c localc = new c(null, 0);
    if (paramCursor == null)
    {
      b("parseValue fail, cursor is null.");
      return localc;
    }
    if (paramCursor.isClosed())
    {
      b("parseValue fail, cursor is closed.");
      return localc;
    }
    paramCursor.moveToFirst();
    int m = paramCursor.getColumnIndex("value");
    if (m >= 0)
    {
      localc.value = paramCursor.getString(m);
      m = paramCursor.getColumnIndex("code");
      if (m < 0) {
        break label126;
      }
      localc.b = paramCursor.getInt(m);
    }
    for (;;)
    {
      m = paramCursor.getColumnIndex("expired");
      if (m < 0) {
        break label134;
      }
      localc.c = paramCursor.getLong(m);
      return localc;
      b("parseValue fail, index < 0.");
      break;
      label126:
      b("parseCode fail, index < 0.");
    }
    label134:
    b("parseExpired fail, index < 0.");
    return localc;
  }
  
  public static final e b()
  {
    if (d == null) {}
    try
    {
      d = new e();
      return d;
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    if (e) {
      Log.d("OpenIdManager", paramString);
    }
  }
  
  /* Error */
  public final String a(android.content.Context paramContext, a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_2
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: areturn
    //   11: aload_2
    //   12: invokevirtual 123	btmsdkobf/a:isValid	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_2
    //   19: getfield 124	btmsdkobf/a:value	Ljava/lang/String;
    //   22: areturn
    //   23: new 126	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   30: ldc 129
    //   32: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: getfield 136	btmsdkobf/a:type	Ljava/lang/String;
    //   39: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   48: ldc 142
    //   50: invokestatic 148	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   53: astore 4
    //   55: aload_1
    //   56: invokevirtual 154	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   59: aload 4
    //   61: aconst_null
    //   62: aconst_null
    //   63: iconst_1
    //   64: anewarray 156	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_2
    //   70: getfield 136	btmsdkobf/a:type	Ljava/lang/String;
    //   73: aastore
    //   74: aconst_null
    //   75: invokevirtual 162	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +245 -> 327
    //   85: aload 4
    //   87: astore 5
    //   89: aload 4
    //   91: invokestatic 164	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   94: astore 8
    //   96: aload 4
    //   98: astore 5
    //   100: aload 8
    //   102: getfield 79	btmsdkobf/c:value	Ljava/lang/String;
    //   105: astore 7
    //   107: aload 7
    //   109: astore 6
    //   111: aload 4
    //   113: astore 5
    //   115: aload_2
    //   116: aload 7
    //   118: invokevirtual 166	btmsdkobf/a:a	(Ljava/lang/String;)V
    //   121: aload 7
    //   123: astore 6
    //   125: aload 4
    //   127: astore 5
    //   129: aload_2
    //   130: aload 8
    //   132: getfield 98	btmsdkobf/c:c	J
    //   135: invokevirtual 169	btmsdkobf/a:a	(J)V
    //   138: aload 7
    //   140: astore 6
    //   142: aload 4
    //   144: astore 5
    //   146: aload_2
    //   147: aload 8
    //   149: getfield 88	btmsdkobf/c:b	I
    //   152: invokevirtual 172	btmsdkobf/a:a	(I)V
    //   155: aload 7
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: new 126	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   170: aload_2
    //   171: getfield 136	btmsdkobf/a:type	Ljava/lang/String;
    //   174: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 174
    //   179: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: getfield 175	btmsdkobf/a:b	I
    //   186: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   195: aload 7
    //   197: astore_2
    //   198: aload 7
    //   200: astore 6
    //   202: aload 4
    //   204: astore 5
    //   206: aload 8
    //   208: getfield 88	btmsdkobf/c:b	I
    //   211: sipush 1000
    //   214: if_icmpeq +95 -> 309
    //   217: aload 7
    //   219: astore 6
    //   221: aload 4
    //   223: astore 5
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual 181	btmsdkobf/e:b	(Landroid/content/Context;)V
    //   230: aload 7
    //   232: astore_2
    //   233: aload 7
    //   235: astore 6
    //   237: aload 4
    //   239: astore 5
    //   241: aload_0
    //   242: aload_1
    //   243: iconst_0
    //   244: invokevirtual 184	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   247: ifne +62 -> 309
    //   250: aload 7
    //   252: astore 6
    //   254: aload 4
    //   256: astore 5
    //   258: aload_0
    //   259: aload_1
    //   260: iconst_1
    //   261: invokevirtual 184	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   264: istore_3
    //   265: aload 7
    //   267: astore 6
    //   269: aload 4
    //   271: astore 5
    //   273: new 126	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   280: ldc 186
    //   282: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: iload_3
    //   286: invokevirtual 189	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: astore_2
    //   290: aload 7
    //   292: astore_1
    //   293: aload_1
    //   294: astore 6
    //   296: aload 4
    //   298: astore 5
    //   300: aload_2
    //   301: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   307: aload_1
    //   308: astore_2
    //   309: aload_2
    //   310: astore_1
    //   311: aload_1
    //   312: astore_2
    //   313: aload 4
    //   315: ifnull -306 -> 9
    //   318: aload 4
    //   320: invokeinterface 192 1 0
    //   325: aload_1
    //   326: areturn
    //   327: aload 4
    //   329: astore 5
    //   331: aload_0
    //   332: aload_1
    //   333: iconst_0
    //   334: invokevirtual 184	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   337: ifeq +121 -> 458
    //   340: aload 4
    //   342: astore 5
    //   344: aload_0
    //   345: aload_1
    //   346: iconst_1
    //   347: invokevirtual 184	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   350: istore_3
    //   351: aload 4
    //   353: astore 5
    //   355: new 126	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   362: ldc 194
    //   364: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload_3
    //   368: invokevirtual 189	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   371: astore_2
    //   372: aload 6
    //   374: astore_1
    //   375: goto -82 -> 293
    //   378: astore_2
    //   379: aconst_null
    //   380: astore 4
    //   382: aconst_null
    //   383: astore_1
    //   384: aload 4
    //   386: astore 5
    //   388: new 126	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   395: ldc 196
    //   397: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 199	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   413: aload_1
    //   414: astore_2
    //   415: aload 4
    //   417: ifnull -408 -> 9
    //   420: goto -102 -> 318
    //   423: astore_1
    //   424: aconst_null
    //   425: astore 5
    //   427: aload 5
    //   429: ifnull +10 -> 439
    //   432: aload 5
    //   434: invokeinterface 192 1 0
    //   439: aload_1
    //   440: athrow
    //   441: astore_2
    //   442: aconst_null
    //   443: astore_1
    //   444: goto -60 -> 384
    //   447: astore_2
    //   448: aload 6
    //   450: astore_1
    //   451: goto -67 -> 384
    //   454: astore_1
    //   455: goto -28 -> 427
    //   458: aconst_null
    //   459: astore_1
    //   460: goto -149 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	e
    //   0	463	1	paramContext	android.content.Context
    //   0	463	2	parama	a
    //   264	104	3	bool	boolean
    //   53	363	4	localObject1	Object
    //   87	346	5	localObject2	Object
    //   1	448	6	localObject3	Object
    //   105	186	7	str	String
    //   94	113	8	localc	c
    // Exception table:
    //   from	to	target	type
    //   55	80	378	java/lang/Exception
    //   55	80	423	finally
    //   89	96	441	java/lang/Exception
    //   100	107	441	java/lang/Exception
    //   331	340	441	java/lang/Exception
    //   344	351	441	java/lang/Exception
    //   355	372	441	java/lang/Exception
    //   115	121	447	java/lang/Exception
    //   129	138	447	java/lang/Exception
    //   146	155	447	java/lang/Exception
    //   163	195	447	java/lang/Exception
    //   206	217	447	java/lang/Exception
    //   225	230	447	java/lang/Exception
    //   241	250	447	java/lang/Exception
    //   258	265	447	java/lang/Exception
    //   273	290	447	java/lang/Exception
    //   300	307	447	java/lang/Exception
    //   89	96	454	finally
    //   100	107	454	finally
    //   115	121	454	finally
    //   129	138	454	finally
    //   146	155	454	finally
    //   163	195	454	finally
    //   206	217	454	finally
    //   225	230	454	finally
    //   241	250	454	finally
    //   258	265	454	finally
    //   273	290	454	finally
    //   300	307	454	finally
    //   331	340	454	finally
    //   344	351	454	finally
    //   355	372	454	finally
    //   388	413	454	finally
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
    //   6: getfield 201	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +13 -> 26
    //   16: iload_2
    //   17: ifne +9 -> 26
    //   20: aload 5
    //   22: invokevirtual 206	java/lang/Boolean:booleanValue	()Z
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull +14 -> 41
    //   30: aload_1
    //   31: invokevirtual 210	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnonnull +24 -> 62
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: ifne +32 -> 76
    //   47: ldc 212
    //   49: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: iconst_0
    //   54: invokestatic 216	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: putfield 201	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   60: iconst_0
    //   61: ireturn
    //   62: aload 5
    //   64: ldc 218
    //   66: iconst_0
    //   67: invokevirtual 224	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   70: ifnull -29 -> 41
    //   73: goto -30 -> 43
    //   76: ldc 142
    //   78: invokestatic 148	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   81: astore 5
    //   83: aload_1
    //   84: invokevirtual 154	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   87: aload 5
    //   89: aconst_null
    //   90: aconst_null
    //   91: iconst_1
    //   92: anewarray 156	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: ldc 226
    //   99: aastore
    //   100: aconst_null
    //   101: invokevirtual 162	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +67 -> 173
    //   109: aload_1
    //   110: astore 4
    //   112: aload_1
    //   113: invokestatic 164	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   116: getfield 79	btmsdkobf/c:value	Ljava/lang/String;
    //   119: astore 5
    //   121: aload_1
    //   122: invokeinterface 192 1 0
    //   127: aload 5
    //   129: astore_1
    //   130: new 126	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   137: ldc 228
    //   139: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: ldc 230
    //   155: aload_1
    //   156: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: invokestatic 216	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   162: putfield 201	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   165: aload_0
    //   166: getfield 201	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   169: invokevirtual 206	java/lang/Boolean:booleanValue	()Z
    //   172: ireturn
    //   173: aload_1
    //   174: ifnull +9 -> 183
    //   177: aload_1
    //   178: invokeinterface 192 1 0
    //   183: aconst_null
    //   184: astore_1
    //   185: goto -55 -> 130
    //   188: astore 5
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore 4
    //   195: new 126	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   202: ldc 236
    //   204: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 5
    //   209: invokevirtual 199	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 55	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: ifnull -39 -> 183
    //   225: goto -48 -> 177
    //   228: astore_1
    //   229: aload 4
    //   231: ifnull +10 -> 241
    //   234: aload 4
    //   236: invokeinterface 192 1 0
    //   241: aload_1
    //   242: athrow
    //   243: astore 5
    //   245: goto -53 -> 192
    //   248: astore_1
    //   249: goto -20 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	e
    //   0	252	1	paramContext	android.content.Context
    //   0	252	2	paramBoolean	boolean
    //   1	43	3	m	int
    //   3	232	4	localContext	android.content.Context
    //   9	119	5	localObject	Object
    //   188	20	5	localException1	java.lang.Exception
    //   243	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   83	105	188	java/lang/Exception
    //   83	105	228	finally
    //   112	121	243	java/lang/Exception
    //   112	121	248	finally
    //   195	221	248	finally
  }
  
  /* Error */
  public final void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 238	btmsdkobf/e:k	Landroid/content/BroadcastReceiver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 240	android/content/IntentFilter
    //   17: dup
    //   18: invokespecial 241	android/content/IntentFilter:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 243
    //   25: invokevirtual 246	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: new 248	btmsdkobf/d
    //   32: dup
    //   33: invokespecial 249	btmsdkobf/d:<init>	()V
    //   36: putfield 238	btmsdkobf/e:k	Landroid/content/BroadcastReceiver;
    //   39: aload_1
    //   40: aload_0
    //   41: getfield 238	btmsdkobf/e:k	Landroid/content/BroadcastReceiver;
    //   44: aload_2
    //   45: ldc 251
    //   47: aconst_null
    //   48: invokevirtual 255	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   51: pop
    //   52: goto -41 -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	e
    //   0	60	1	paramContext	android.content.Context
    //   6	39	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  public a c(String paramString)
  {
    if ("oaid".equals(paramString)) {
      return this.g;
    }
    if ("vaid".equals(paramString)) {
      return this.i;
    }
    if ("aaid".equals(paramString)) {
      return this.h;
    }
    if ("udid".equals(paramString)) {
      return this.f;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.e
 * JD-Core Version:    0.7.0.1
 */