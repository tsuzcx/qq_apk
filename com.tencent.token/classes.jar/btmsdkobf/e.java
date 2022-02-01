package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

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
  
  public static void b(String paramString) {}
  
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
    //   22: invokevirtual 115	btmsdkobf/a:isValid	()Z
    //   25: ifeq +8 -> 33
    //   28: aload_2
    //   29: getfield 116	btmsdkobf/a:value	Ljava/lang/String;
    //   32: areturn
    //   33: new 118	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 120
    //   39: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: aload_2
    //   47: getfield 124	btmsdkobf/a:type	Ljava/lang/String;
    //   50: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   62: ldc 134
    //   64: invokestatic 140	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   67: astore 5
    //   69: aload_1
    //   70: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   73: aload 5
    //   75: aconst_null
    //   76: aconst_null
    //   77: iconst_1
    //   78: anewarray 148	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: aload_2
    //   84: getfield 124	btmsdkobf/a:type	Ljava/lang/String;
    //   87: aastore
    //   88: aconst_null
    //   89: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +210 -> 306
    //   99: aload 7
    //   101: astore 4
    //   103: aload 5
    //   105: invokestatic 156	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   108: astore 8
    //   110: aload 7
    //   112: astore 4
    //   114: aload 8
    //   116: getfield 80	btmsdkobf/c:value	Ljava/lang/String;
    //   119: astore 6
    //   121: aload 6
    //   123: astore 4
    //   125: aload_2
    //   126: aload 6
    //   128: invokevirtual 158	btmsdkobf/a:a	(Ljava/lang/String;)V
    //   131: aload 6
    //   133: astore 4
    //   135: aload_2
    //   136: aload 8
    //   138: getfield 103	btmsdkobf/c:c	J
    //   141: invokevirtual 161	btmsdkobf/a:a	(J)V
    //   144: aload 6
    //   146: astore 4
    //   148: aload_2
    //   149: aload 8
    //   151: getfield 91	btmsdkobf/c:b	I
    //   154: invokevirtual 164	btmsdkobf/a:a	(I)V
    //   157: aload 6
    //   159: astore 4
    //   161: new 118	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   168: astore 7
    //   170: aload 6
    //   172: astore 4
    //   174: aload 7
    //   176: aload_2
    //   177: getfield 124	btmsdkobf/a:type	Ljava/lang/String;
    //   180: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 6
    //   186: astore 4
    //   188: aload 7
    //   190: ldc 167
    //   192: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: astore 4
    //   200: aload 7
    //   202: aload_2
    //   203: getfield 168	btmsdkobf/a:b	I
    //   206: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 6
    //   212: astore 4
    //   214: aload 7
    //   216: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   222: aload 6
    //   224: astore_2
    //   225: aload 6
    //   227: astore 4
    //   229: aload 8
    //   231: getfield 91	btmsdkobf/c:b	I
    //   234: sipush 1000
    //   237: if_icmpeq +133 -> 370
    //   240: aload 6
    //   242: astore 4
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 174	btmsdkobf/e:b	(Landroid/content/Context;)V
    //   249: aload 6
    //   251: astore_2
    //   252: aload 6
    //   254: astore 4
    //   256: aload_0
    //   257: aload_1
    //   258: iconst_0
    //   259: invokevirtual 177	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   262: ifne +108 -> 370
    //   265: aload 6
    //   267: astore 4
    //   269: aload_0
    //   270: aload_1
    //   271: iconst_1
    //   272: invokevirtual 177	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   275: istore_3
    //   276: aload 6
    //   278: astore 4
    //   280: new 118	java/lang/StringBuilder
    //   283: dup
    //   284: ldc 179
    //   286: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload 6
    //   292: astore 4
    //   294: aload_1
    //   295: iload_3
    //   296: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 6
    //   302: astore_2
    //   303: goto +57 -> 360
    //   306: aload 9
    //   308: astore_2
    //   309: aload 7
    //   311: astore 4
    //   313: aload_0
    //   314: aload_1
    //   315: iconst_0
    //   316: invokevirtual 177	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   319: ifeq +51 -> 370
    //   322: aload 7
    //   324: astore 4
    //   326: aload_0
    //   327: aload_1
    //   328: iconst_1
    //   329: invokevirtual 177	btmsdkobf/e:a	(Landroid/content/Context;Z)Z
    //   332: istore_3
    //   333: aload 7
    //   335: astore 4
    //   337: new 118	java/lang/StringBuilder
    //   340: dup
    //   341: ldc 184
    //   343: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: astore_1
    //   347: aload 7
    //   349: astore 4
    //   351: aload_1
    //   352: iload_3
    //   353: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 6
    //   359: astore_2
    //   360: aload_2
    //   361: astore 4
    //   363: aload_1
    //   364: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   370: aload 5
    //   372: ifnull +9 -> 381
    //   375: aload 5
    //   377: astore_1
    //   378: goto +85 -> 463
    //   381: aload_2
    //   382: areturn
    //   383: astore_1
    //   384: goto +91 -> 475
    //   387: astore 6
    //   389: aload 4
    //   391: astore_2
    //   392: aload 5
    //   394: astore_1
    //   395: aload 6
    //   397: astore 5
    //   399: goto +18 -> 417
    //   402: astore_1
    //   403: aload 4
    //   405: astore 5
    //   407: goto +68 -> 475
    //   410: astore 5
    //   412: aconst_null
    //   413: astore_2
    //   414: aload 8
    //   416: astore_1
    //   417: aload_1
    //   418: astore 4
    //   420: new 118	java/lang/StringBuilder
    //   423: dup
    //   424: ldc 186
    //   426: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: astore 6
    //   431: aload_1
    //   432: astore 4
    //   434: aload 6
    //   436: aload 5
    //   438: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   441: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: astore 4
    //   448: aload 6
    //   450: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   456: aload_2
    //   457: astore 4
    //   459: aload_1
    //   460: ifnull +12 -> 472
    //   463: aload_1
    //   464: invokeinterface 192 1 0
    //   469: aload_2
    //   470: astore 4
    //   472: aload 4
    //   474: areturn
    //   475: aload 5
    //   477: ifnull +10 -> 487
    //   480: aload 5
    //   482: invokeinterface 192 1 0
    //   487: aload_1
    //   488: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	e
    //   0	489	1	paramContext	Context
    //   0	489	2	parama	a
    //   275	78	3	bool	boolean
    //   7	466	4	localObject1	Object
    //   42	364	5	localObject2	Object
    //   410	71	5	localException1	java.lang.Exception
    //   13	345	6	str	String
    //   387	9	6	localException2	java.lang.Exception
    //   429	20	6	localStringBuilder1	java.lang.StringBuilder
    //   4	344	7	localStringBuilder2	java.lang.StringBuilder
    //   10	405	8	localc	c
    //   1	306	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   103	110	383	finally
    //   114	121	383	finally
    //   125	131	383	finally
    //   135	144	383	finally
    //   148	157	383	finally
    //   161	170	383	finally
    //   174	184	383	finally
    //   188	196	383	finally
    //   200	210	383	finally
    //   214	222	383	finally
    //   229	240	383	finally
    //   244	249	383	finally
    //   256	265	383	finally
    //   269	276	383	finally
    //   280	290	383	finally
    //   294	300	383	finally
    //   313	322	383	finally
    //   326	333	383	finally
    //   337	347	383	finally
    //   351	357	383	finally
    //   363	370	383	finally
    //   103	110	387	java/lang/Exception
    //   114	121	387	java/lang/Exception
    //   125	131	387	java/lang/Exception
    //   135	144	387	java/lang/Exception
    //   148	157	387	java/lang/Exception
    //   161	170	387	java/lang/Exception
    //   174	184	387	java/lang/Exception
    //   188	196	387	java/lang/Exception
    //   200	210	387	java/lang/Exception
    //   214	222	387	java/lang/Exception
    //   229	240	387	java/lang/Exception
    //   244	249	387	java/lang/Exception
    //   256	265	387	java/lang/Exception
    //   269	276	387	java/lang/Exception
    //   280	290	387	java/lang/Exception
    //   294	300	387	java/lang/Exception
    //   313	322	387	java/lang/Exception
    //   326	333	387	java/lang/Exception
    //   337	347	387	java/lang/Exception
    //   351	357	387	java/lang/Exception
    //   363	370	387	java/lang/Exception
    //   69	94	402	finally
    //   420	431	402	finally
    //   434	445	402	finally
    //   448	456	402	finally
    //   69	94	410	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +13 -> 21
    //   11: iload_2
    //   12: ifne +9 -> 21
    //   15: aload 4
    //   17: invokevirtual 199	java/lang/Boolean:booleanValue	()Z
    //   20: ireturn
    //   21: aload_1
    //   22: ifnull +30 -> 52
    //   25: aload_1
    //   26: invokevirtual 203	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +19 -> 52
    //   36: aload 4
    //   38: ldc 205
    //   40: iconst_0
    //   41: invokevirtual 211	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   44: ifnull +8 -> 52
    //   47: iconst_1
    //   48: istore_3
    //   49: goto +5 -> 54
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_3
    //   55: ifne +17 -> 72
    //   58: ldc 213
    //   60: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getstatic 216	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   67: putfield 194	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   70: iconst_0
    //   71: ireturn
    //   72: ldc 134
    //   74: invokestatic 140	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   77: astore 4
    //   79: aconst_null
    //   80: astore 7
    //   82: aconst_null
    //   83: astore 6
    //   85: aload_1
    //   86: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   89: aload 4
    //   91: aconst_null
    //   92: aconst_null
    //   93: iconst_1
    //   94: anewarray 148	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 218
    //   101: aastore
    //   102: aconst_null
    //   103: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +33 -> 141
    //   111: aload_1
    //   112: astore 4
    //   114: aload_1
    //   115: invokestatic 156	btmsdkobf/e:a	(Landroid/database/Cursor;)Lbtmsdkobf/c;
    //   118: getfield 80	btmsdkobf/c:value	Ljava/lang/String;
    //   121: astore 5
    //   123: aload 5
    //   125: astore 4
    //   127: aload_1
    //   128: invokeinterface 192 1 0
    //   133: goto +84 -> 217
    //   136: astore 5
    //   138: goto +25 -> 163
    //   141: aload 7
    //   143: astore 4
    //   145: aload_1
    //   146: ifnull +71 -> 217
    //   149: goto +61 -> 210
    //   152: astore_1
    //   153: aconst_null
    //   154: astore 4
    //   156: goto +97 -> 253
    //   159: astore 5
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: astore 4
    //   166: new 118	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 220
    //   172: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: astore 8
    //   177: aload_1
    //   178: astore 4
    //   180: aload 8
    //   182: aload 5
    //   184: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: astore 4
    //   194: aload 8
    //   196: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   202: aload 7
    //   204: astore 4
    //   206: aload_1
    //   207: ifnull +10 -> 217
    //   210: aload 6
    //   212: astore 4
    //   214: goto -87 -> 127
    //   217: ldc 222
    //   219: aload 4
    //   221: invokestatic 226	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic 56	btmsdkobf/e:b	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: ldc 232
    //   233: aload 4
    //   235: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   241: putfield 194	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   244: aload_0
    //   245: getfield 194	btmsdkobf/e:j	Ljava/lang/Boolean;
    //   248: invokevirtual 199	java/lang/Boolean:booleanValue	()Z
    //   251: ireturn
    //   252: astore_1
    //   253: aload 4
    //   255: ifnull +10 -> 265
    //   258: aload 4
    //   260: invokeinterface 192 1 0
    //   265: aload_1
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	e
    //   0	267	1	paramContext	Context
    //   0	267	2	paramBoolean	boolean
    //   48	7	3	m	int
    //   4	255	4	localObject1	Object
    //   121	3	5	str	String
    //   136	1	5	localException1	java.lang.Exception
    //   159	24	5	localException2	java.lang.Exception
    //   83	128	6	localObject2	Object
    //   80	123	7	localObject3	Object
    //   175	20	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   114	123	136	java/lang/Exception
    //   85	107	152	finally
    //   85	107	159	java/lang/Exception
    //   114	123	252	finally
    //   166	177	252	finally
    //   180	191	252	finally
    //   194	202	252	finally
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