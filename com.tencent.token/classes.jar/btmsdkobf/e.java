package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.util.Log;

public class e
{
  public static volatile e d;
  public static boolean e = false;
  public a f = new a("udid");
  public a g = new a("oaid");
  public a h = new a("aaid");
  public a i = new a("vaid");
  public Boolean j;
  public BroadcastReceiver k;
  
  public static c a(Cursor paramCursor)
  {
    c localc = new c(null, 0);
    if (paramCursor == null) {}
    for (paramCursor = "parseValue fail, cursor is null.";; paramCursor = "parseValue fail, cursor is closed.")
    {
      b(paramCursor);
      return localc;
      if (!paramCursor.isClosed()) {
        break;
      }
    }
    paramCursor.moveToFirst();
    int m = paramCursor.getColumnIndex("value");
    if (m >= 0) {
      localc.value = paramCursor.getString(m);
    } else {
      b("parseValue fail, index < 0.");
    }
    m = paramCursor.getColumnIndex("code");
    if (m >= 0) {
      localc.b = paramCursor.getInt(m);
    } else {
      b("parseCode fail, index < 0.");
    }
    m = paramCursor.getColumnIndex("expired");
    if (m >= 0)
    {
      localc.c = paramCursor.getLong(m);
      return localc;
    }
    b("parseExpired fail, index < 0.");
    return localc;
  }
  
  public static final e b()
  {
    if (d == null) {
      try
      {
        d = new e();
      }
      finally {}
    }
    return d;
  }
  
  public static void b(String paramString)
  {
    if (e) {
      Log.d("OpenIdManager", paramString);
    }
  }
  
  /* Error */
  public final String a(Context paramContext, a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_2
    //   16: ifnonnull +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: aload_2
    //   22: invokevirtual 124	btmsdkobf/a:isValid	()Z
    //   25: ifeq +8 -> 33
    //   28: aload_2
    //   29: getfield 125	btmsdkobf/a:value	Ljava/lang/String;
    //   32: areturn
    //   33: new 127	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload 5
    //   44: ldc 130
    //   46: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: aload_2
    //   53: getfield 137	btmsdkobf/a:type	Ljava/lang/String;
    //   56: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   68: ldc 143
    //   70: invokestatic 149	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   73: astore 5
    //   75: aload_1
    //   76: invokevirtual 155	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   79: aload 5
    //   81: aconst_null
    //   82: aconst_null
    //   83: iconst_1
    //   84: anewarray 157	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload_2
    //   90: getfield 137	btmsdkobf/a:type	Ljava/lang/String;
    //   93: aastore
    //   94: aconst_null
    //   95: invokevirtual 163	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore 5
    //   100: aload 5
    //   102: ifnull +219 -> 321
    //   105: aload 7
    //   107: astore 4
    //   109: aload 5
    //   111: invokestatic 165	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   114: astore 8
    //   116: aload 7
    //   118: astore 4
    //   120: aload 8
    //   122: getfield 80	btmsdkobf/c:value	Ljava/lang/String;
    //   125: astore 6
    //   127: aload 6
    //   129: astore 4
    //   131: aload_2
    //   132: aload 6
    //   134: invokevirtual 167	btmsdkobf/a:a	(Ljava/lang/String;)V
    //   137: aload 6
    //   139: astore 4
    //   141: aload_2
    //   142: aload 8
    //   144: getfield 103	btmsdkobf/c:c	J
    //   147: invokevirtual 170	btmsdkobf/a:a	(J)V
    //   150: aload 6
    //   152: astore 4
    //   154: aload_2
    //   155: aload 8
    //   157: getfield 91	btmsdkobf/c:b	I
    //   160: invokevirtual 173	btmsdkobf/a:a	(I)V
    //   163: aload 6
    //   165: astore 4
    //   167: new 127	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   174: astore 7
    //   176: aload 6
    //   178: astore 4
    //   180: aload 7
    //   182: aload_2
    //   183: getfield 137	btmsdkobf/a:type	Ljava/lang/String;
    //   186: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: astore 4
    //   194: aload 7
    //   196: ldc 175
    //   198: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 6
    //   204: astore 4
    //   206: aload 7
    //   208: aload_2
    //   209: getfield 176	btmsdkobf/a:b	I
    //   212: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 6
    //   218: astore 4
    //   220: aload 7
    //   222: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   228: aload 6
    //   230: astore_2
    //   231: aload 6
    //   233: astore 4
    //   235: aload 8
    //   237: getfield 91	btmsdkobf/c:b	I
    //   240: sipush 1000
    //   243: if_icmpeq +151 -> 394
    //   246: aload 6
    //   248: astore 4
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 182	btmsdkobf/e:b	(Landroid/content/Context;)V
    //   255: aload 6
    //   257: astore_2
    //   258: aload 6
    //   260: astore 4
    //   262: aload_0
    //   263: aload_1
    //   264: iconst_0
    //   265: invokevirtual 185	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   268: ifne +126 -> 394
    //   271: aload 6
    //   273: astore 4
    //   275: aload_0
    //   276: aload_1
    //   277: iconst_1
    //   278: invokevirtual 185	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   281: istore_3
    //   282: aload 6
    //   284: astore 4
    //   286: new 127	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   293: astore_1
    //   294: aload 6
    //   296: astore 4
    //   298: aload_1
    //   299: ldc 187
    //   301: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 6
    //   307: astore 4
    //   309: aload_1
    //   310: iload_3
    //   311: invokevirtual 190	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 6
    //   317: astore_2
    //   318: goto +66 -> 384
    //   321: aload 9
    //   323: astore_2
    //   324: aload 7
    //   326: astore 4
    //   328: aload_0
    //   329: aload_1
    //   330: iconst_0
    //   331: invokevirtual 185	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   334: ifeq +60 -> 394
    //   337: aload 7
    //   339: astore 4
    //   341: aload_0
    //   342: aload_1
    //   343: iconst_1
    //   344: invokevirtual 185	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   347: istore_3
    //   348: aload 7
    //   350: astore 4
    //   352: new 127	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   359: astore_1
    //   360: aload 7
    //   362: astore 4
    //   364: aload_1
    //   365: ldc 192
    //   367: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 7
    //   373: astore 4
    //   375: aload_1
    //   376: iload_3
    //   377: invokevirtual 190	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 6
    //   383: astore_2
    //   384: aload_2
    //   385: astore 4
    //   387: aload_1
    //   388: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: ifnull +9 -> 405
    //   399: aload 5
    //   401: astore_1
    //   402: goto +94 -> 496
    //   405: aload_2
    //   406: areturn
    //   407: astore_1
    //   408: goto +100 -> 508
    //   411: astore 6
    //   413: aload 4
    //   415: astore_2
    //   416: aload 5
    //   418: astore_1
    //   419: aload 6
    //   421: astore 5
    //   423: goto +18 -> 441
    //   426: astore_1
    //   427: aload 4
    //   429: astore 5
    //   431: goto +77 -> 508
    //   434: astore 5
    //   436: aconst_null
    //   437: astore_2
    //   438: aload 8
    //   440: astore_1
    //   441: aload_1
    //   442: astore 4
    //   444: new 127	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   451: astore 6
    //   453: aload_1
    //   454: astore 4
    //   456: aload 6
    //   458: ldc 194
    //   460: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_1
    //   465: astore 4
    //   467: aload 6
    //   469: aload 5
    //   471: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_1
    //   479: astore 4
    //   481: aload 6
    //   483: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   489: aload_2
    //   490: astore 4
    //   492: aload_1
    //   493: ifnull +12 -> 505
    //   496: aload_1
    //   497: invokeinterface 200 1 0
    //   502: aload_2
    //   503: astore 4
    //   505: aload 4
    //   507: areturn
    //   508: aload 5
    //   510: ifnull +10 -> 520
    //   513: aload 5
    //   515: invokeinterface 200 1 0
    //   520: aload_1
    //   521: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	e
    //   0	522	1	paramContext	Context
    //   0	522	2	parama	a
    //   281	96	3	bool	boolean
    //   7	499	4	localObject1	Object
    //   40	390	5	localObject2	Object
    //   434	80	5	localException1	java.lang.Exception
    //   13	369	6	str	String
    //   411	9	6	localException2	java.lang.Exception
    //   451	31	6	localStringBuilder1	java.lang.StringBuilder
    //   4	368	7	localStringBuilder2	java.lang.StringBuilder
    //   10	429	8	localc	c
    //   1	321	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   109	116	407	finally
    //   120	127	407	finally
    //   131	137	407	finally
    //   141	150	407	finally
    //   154	163	407	finally
    //   167	176	407	finally
    //   180	190	407	finally
    //   194	202	407	finally
    //   206	216	407	finally
    //   220	228	407	finally
    //   235	246	407	finally
    //   250	255	407	finally
    //   262	271	407	finally
    //   275	282	407	finally
    //   286	294	407	finally
    //   298	305	407	finally
    //   309	315	407	finally
    //   328	337	407	finally
    //   341	348	407	finally
    //   352	360	407	finally
    //   364	371	407	finally
    //   375	381	407	finally
    //   387	394	407	finally
    //   109	116	411	java/lang/Exception
    //   120	127	411	java/lang/Exception
    //   131	137	411	java/lang/Exception
    //   141	150	411	java/lang/Exception
    //   154	163	411	java/lang/Exception
    //   167	176	411	java/lang/Exception
    //   180	190	411	java/lang/Exception
    //   194	202	411	java/lang/Exception
    //   206	216	411	java/lang/Exception
    //   220	228	411	java/lang/Exception
    //   235	246	411	java/lang/Exception
    //   250	255	411	java/lang/Exception
    //   262	271	411	java/lang/Exception
    //   275	282	411	java/lang/Exception
    //   286	294	411	java/lang/Exception
    //   298	305	411	java/lang/Exception
    //   309	315	411	java/lang/Exception
    //   328	337	411	java/lang/Exception
    //   341	348	411	java/lang/Exception
    //   352	360	411	java/lang/Exception
    //   364	371	411	java/lang/Exception
    //   375	381	411	java/lang/Exception
    //   387	394	411	java/lang/Exception
    //   75	100	426	finally
    //   444	453	426	finally
    //   456	464	426	finally
    //   467	478	426	finally
    //   481	489	426	finally
    //   75	100	434	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 202	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +13 -> 21
    //   11: iload_2
    //   12: ifne +9 -> 21
    //   15: aload 4
    //   17: invokevirtual 207	java/lang/Boolean:booleanValue	()Z
    //   20: ireturn
    //   21: aload_1
    //   22: ifnull +33 -> 55
    //   25: aload_1
    //   26: invokevirtual 211	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnonnull +6 -> 39
    //   36: goto +19 -> 55
    //   39: aload 4
    //   41: ldc 213
    //   43: iconst_0
    //   44: invokevirtual 219	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   47: ifnull +8 -> 55
    //   50: iconst_1
    //   51: istore_3
    //   52: goto +5 -> 57
    //   55: iconst_0
    //   56: istore_3
    //   57: iload_3
    //   58: ifne +18 -> 76
    //   61: ldc 221
    //   63: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: iconst_0
    //   68: invokestatic 225	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   71: putfield 202	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   74: iconst_0
    //   75: ireturn
    //   76: ldc 143
    //   78: invokestatic 149	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   81: astore 4
    //   83: aconst_null
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 6
    //   89: aload_1
    //   90: invokevirtual 155	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   93: aload 4
    //   95: aconst_null
    //   96: aconst_null
    //   97: iconst_1
    //   98: anewarray 157	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc 227
    //   105: aastore
    //   106: aconst_null
    //   107: invokevirtual 163	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +33 -> 145
    //   115: aload_1
    //   116: astore 4
    //   118: aload_1
    //   119: invokestatic 165	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   122: getfield 80	btmsdkobf/c:value	Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: astore 4
    //   131: aload_1
    //   132: invokeinterface 200 1 0
    //   137: goto +93 -> 230
    //   140: astore 5
    //   142: goto +25 -> 167
    //   145: aload 7
    //   147: astore 4
    //   149: aload_1
    //   150: ifnull +80 -> 230
    //   153: goto +70 -> 223
    //   156: astore_1
    //   157: aconst_null
    //   158: astore 4
    //   160: goto +122 -> 282
    //   163: astore 5
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: astore 4
    //   170: new 127	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   177: astore 8
    //   179: aload_1
    //   180: astore 4
    //   182: aload 8
    //   184: ldc 229
    //   186: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: astore 4
    //   193: aload 8
    //   195: aload 5
    //   197: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: astore 4
    //   207: aload 8
    //   209: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   215: aload 7
    //   217: astore 4
    //   219: aload_1
    //   220: ifnull +10 -> 230
    //   223: aload 6
    //   225: astore 4
    //   227: goto -96 -> 131
    //   230: new 127	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   237: astore_1
    //   238: aload_1
    //   239: ldc 231
    //   241: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_1
    //   246: aload 4
    //   248: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   259: aload_0
    //   260: ldc 233
    //   262: aload 4
    //   264: invokevirtual 237	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: invokestatic 225	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: putfield 202	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   273: aload_0
    //   274: getfield 202	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   277: invokevirtual 207	java/lang/Boolean:booleanValue	()Z
    //   280: ireturn
    //   281: astore_1
    //   282: aload 4
    //   284: ifnull +10 -> 294
    //   287: aload 4
    //   289: invokeinterface 200 1 0
    //   294: aload_1
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	e
    //   0	296	1	paramContext	Context
    //   0	296	2	paramBoolean	boolean
    //   51	7	3	m	int
    //   4	284	4	localObject1	Object
    //   125	3	5	str	String
    //   140	1	5	localException1	java.lang.Exception
    //   163	33	5	localException2	java.lang.Exception
    //   87	137	6	localObject2	Object
    //   84	132	7	localObject3	Object
    //   177	31	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   118	127	140	java/lang/Exception
    //   89	111	156	finally
    //   89	111	163	java/lang/Exception
    //   118	127	281	finally
    //   170	179	281	finally
    //   182	190	281	finally
    //   193	204	281	finally
    //   207	215	281	finally
  }
  
  public final void b(Context paramContext)
  {
    try
    {
      Object localObject = this.k;
      if (localObject != null) {
        return;
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
      this.k = new d();
      paramContext.registerReceiver(this.k, (IntentFilter)localObject, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
      return;
    }
    finally {}
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