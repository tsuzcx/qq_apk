package com.tencent.token;

public final class acn
{
  /* Error */
  public static int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: invokevirtual 20	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: astore 7
    //   10: iconst_1
    //   11: istore 6
    //   13: aload 7
    //   15: ifnonnull +6 -> 21
    //   18: goto +28 -> 46
    //   21: getstatic 26	com/tencent/token/afz:l	[I
    //   24: invokestatic 29	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   27: astore 8
    //   29: aload 7
    //   31: aload 8
    //   33: sipush 128
    //   36: invokevirtual 35	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   39: pop
    //   40: iconst_1
    //   41: istore 5
    //   43: goto +6 -> 49
    //   46: iconst_0
    //   47: istore 5
    //   49: iconst_0
    //   50: iload 5
    //   52: iconst_0
    //   53: invokestatic 40	com/tencent/token/ahr:a	(IZI)I
    //   56: istore_3
    //   57: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   60: pop2
    //   61: new 42	java/lang/String
    //   64: dup
    //   65: getstatic 45	com/tencent/token/afz:n	[I
    //   68: invokestatic 29	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   71: invokestatic 51	com/tencent/token/acy:b	(Ljava/lang/String;)[B
    //   74: invokespecial 55	java/lang/String:<init>	([B)V
    //   77: astore 7
    //   79: aload 7
    //   81: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +199 -> 283
    //   87: aload 7
    //   89: ldc 63
    //   91: invokevirtual 67	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   94: astore 7
    //   96: aload 7
    //   98: ifnull +185 -> 283
    //   101: aload 7
    //   103: arraylength
    //   104: ifeq +179 -> 283
    //   107: aload_0
    //   108: invokevirtual 71	android/content/Context:getPackageName	()Ljava/lang/String;
    //   111: astore 8
    //   113: aload 7
    //   115: arraylength
    //   116: istore 4
    //   118: iconst_0
    //   119: istore_2
    //   120: goto +352 -> 472
    //   123: aload 11
    //   125: bipush 47
    //   127: invokevirtual 75	java/lang/String:indexOf	(I)I
    //   130: istore_1
    //   131: iload_1
    //   132: iconst_m1
    //   133: if_icmpne +8 -> 141
    //   136: iconst_0
    //   137: istore_1
    //   138: goto +128 -> 266
    //   141: aload 11
    //   143: iload_1
    //   144: invokevirtual 79	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: invokevirtual 82	java/lang/String:trim	()Ljava/lang/String;
    //   150: astore 9
    //   152: aload 9
    //   154: ldc 84
    //   156: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   159: ifne +8 -> 167
    //   162: iconst_0
    //   163: istore_1
    //   164: goto +102 -> 266
    //   167: new 90	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 92
    //   173: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: astore 10
    //   178: aload 10
    //   180: aload 8
    //   182: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 10
    //   188: ldc 101
    //   190: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 9
    //   196: aload 10
    //   198: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifeq +8 -> 212
    //   207: iconst_0
    //   208: istore_1
    //   209: goto +57 -> 266
    //   212: aload 9
    //   214: ldc 106
    //   216: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: istore 5
    //   221: iload 5
    //   223: ifne +271 -> 494
    //   226: aload 9
    //   228: ldc 111
    //   230: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   233: ifeq +261 -> 494
    //   236: iconst_1
    //   237: istore_1
    //   238: goto +258 -> 496
    //   241: aload 11
    //   243: getstatic 114	com/tencent/token/afz:m	[I
    //   246: invokestatic 29	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   249: invokevirtual 117	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   252: istore 5
    //   254: iload 5
    //   256: ifeq +8 -> 264
    //   259: iconst_1
    //   260: istore_1
    //   261: goto +5 -> 266
    //   264: iconst_0
    //   265: istore_1
    //   266: iload_1
    //   267: ifeq +9 -> 276
    //   270: iconst_1
    //   271: istore 5
    //   273: goto +13 -> 286
    //   276: iload_2
    //   277: iconst_1
    //   278: iadd
    //   279: istore_2
    //   280: goto +192 -> 472
    //   283: iconst_0
    //   284: istore 5
    //   286: iload_3
    //   287: iload 5
    //   289: iconst_1
    //   290: invokestatic 40	com/tencent/token/ahr:a	(IZI)I
    //   293: istore_1
    //   294: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   297: pop2
    //   298: new 4	java/lang/Object
    //   301: dup
    //   302: invokespecial 120	java/lang/Object:<init>	()V
    //   305: astore 7
    //   307: new 122	java/util/concurrent/atomic/AtomicReference
    //   310: dup
    //   311: invokespecial 123	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   314: astore 8
    //   316: new 125	java/util/concurrent/atomic/AtomicBoolean
    //   319: dup
    //   320: iconst_0
    //   321: invokespecial 128	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   324: astore 9
    //   326: aload 8
    //   328: getstatic 134	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   331: invokevirtual 138	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   334: new 140	android/os/Handler
    //   337: dup
    //   338: aload_0
    //   339: invokevirtual 144	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   342: invokespecial 147	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   345: astore_0
    //   346: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   349: pop2
    //   350: aload_0
    //   351: new 149	com/tencent/token/acl
    //   354: dup
    //   355: aload 9
    //   357: aload 8
    //   359: aload 7
    //   361: invokespecial 152	com/tencent/token/acl:<init>	(Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   364: invokevirtual 156	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   367: pop
    //   368: aload 7
    //   370: monitorenter
    //   371: aload 7
    //   373: ldc2_w 157
    //   376: invokevirtual 162	java/lang/Object:wait	(J)V
    //   379: goto +7 -> 386
    //   382: astore_0
    //   383: goto +66 -> 449
    //   386: aload 7
    //   388: monitorexit
    //   389: aload 9
    //   391: iconst_1
    //   392: invokevirtual 164	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   395: iload_1
    //   396: aload 8
    //   398: invokevirtual 168	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   401: checkcast 130	java/lang/Boolean
    //   404: invokevirtual 172	java/lang/Boolean:booleanValue	()Z
    //   407: iconst_2
    //   408: invokestatic 40	com/tencent/token/ahr:a	(IZI)I
    //   411: istore_1
    //   412: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   415: pop2
    //   416: getstatic 175	com/tencent/token/afz:aG	[I
    //   419: invokestatic 29	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   422: astore_0
    //   423: invokestatic 181	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   426: aload_0
    //   427: invokevirtual 185	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   430: pop
    //   431: iload 6
    //   433: istore 5
    //   435: goto +6 -> 441
    //   438: iconst_0
    //   439: istore 5
    //   441: iload_1
    //   442: iload 5
    //   444: iconst_3
    //   445: invokestatic 40	com/tencent/token/ahr:a	(IZI)I
    //   448: ireturn
    //   449: aload 7
    //   451: monitorexit
    //   452: aload_0
    //   453: athrow
    //   454: astore 7
    //   456: goto -410 -> 46
    //   459: astore 7
    //   461: goto -178 -> 283
    //   464: astore_0
    //   465: goto -79 -> 386
    //   468: astore_0
    //   469: goto -31 -> 438
    //   472: iload_2
    //   473: iload 4
    //   475: if_icmpge -192 -> 283
    //   478: aload 7
    //   480: iload_2
    //   481: aaload
    //   482: astore 11
    //   484: aload 11
    //   486: ifnonnull -363 -> 123
    //   489: iconst_0
    //   490: istore_1
    //   491: goto -225 -> 266
    //   494: iconst_0
    //   495: istore_1
    //   496: iload 5
    //   498: ifne -257 -> 241
    //   501: iload_1
    //   502: ifne -261 -> 241
    //   505: iconst_0
    //   506: istore_1
    //   507: goto -241 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramContext	android.content.Context
    //   130	377	1	i	int
    //   119	362	2	j	int
    //   56	231	3	k	int
    //   116	360	4	m	int
    //   41	456	5	bool1	boolean
    //   11	421	6	bool2	boolean
    //   8	442	7	localObject1	Object
    //   454	1	7	localObject2	Object
    //   459	20	7	localObject3	Object
    //   27	370	8	localObject4	Object
    //   150	240	9	localObject5	Object
    //   176	21	10	localStringBuilder	java.lang.StringBuilder
    //   123	362	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   371	379	382	finally
    //   386	389	382	finally
    //   449	452	382	finally
    //   29	40	454	finally
    //   61	96	459	finally
    //   101	118	459	finally
    //   123	131	459	finally
    //   141	162	459	finally
    //   167	207	459	finally
    //   212	221	459	finally
    //   226	236	459	finally
    //   241	254	459	finally
    //   371	379	464	java/lang/InterruptedException
    //   416	431	468	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acn
 * JD-Core Version:    0.7.0.1
 */