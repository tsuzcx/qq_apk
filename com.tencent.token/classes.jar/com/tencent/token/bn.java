package com.tencent.token;

public final class bn
{
  /* Error */
  public static android.view.animation.Interpolator a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: getstatic 16	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 21	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   13: areturn
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 8
    //   26: iload_1
    //   27: ldc 22
    //   29: if_icmpne +11 -> 40
    //   32: new 24	com/tencent/token/fg
    //   35: dup
    //   36: invokespecial 28	com/tencent/token/fg:<init>	()V
    //   39: areturn
    //   40: iload_1
    //   41: ldc 29
    //   43: if_icmpne +11 -> 54
    //   46: new 31	com/tencent/token/fh
    //   49: dup
    //   50: invokespecial 32	com/tencent/token/fh:<init>	()V
    //   53: areturn
    //   54: iload_1
    //   55: ldc 33
    //   57: if_icmpne +11 -> 68
    //   60: new 35	com/tencent/token/fi
    //   63: dup
    //   64: invokespecial 36	com/tencent/token/fi:<init>	()V
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual 42	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: iload_1
    //   73: invokevirtual 48	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   76: astore 5
    //   78: aload_0
    //   79: invokevirtual 42	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   82: pop
    //   83: aload_0
    //   84: invokevirtual 52	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   87: pop
    //   88: aload 5
    //   90: invokeinterface 58 1 0
    //   95: istore_2
    //   96: aload 8
    //   98: astore 4
    //   100: aload 5
    //   102: invokeinterface 61 1 0
    //   107: istore_3
    //   108: iload_3
    //   109: iconst_3
    //   110: if_icmpne +14 -> 124
    //   113: aload 5
    //   115: invokeinterface 58 1 0
    //   120: iload_2
    //   121: if_icmple +306 -> 427
    //   124: iload_3
    //   125: iconst_1
    //   126: if_icmpeq +301 -> 427
    //   129: iload_3
    //   130: iconst_2
    //   131: if_icmpne -31 -> 100
    //   134: aload 5
    //   136: invokestatic 67	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   139: astore 4
    //   141: aload 5
    //   143: invokeinterface 71 1 0
    //   148: astore 6
    //   150: aload 6
    //   152: ldc 73
    //   154: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq +15 -> 172
    //   160: new 81	android/view/animation/LinearInterpolator
    //   163: dup
    //   164: invokespecial 82	android/view/animation/LinearInterpolator:<init>	()V
    //   167: astore 4
    //   169: goto -69 -> 100
    //   172: aload 6
    //   174: ldc 84
    //   176: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +18 -> 197
    //   182: new 86	android/view/animation/AccelerateInterpolator
    //   185: dup
    //   186: aload_0
    //   187: aload 4
    //   189: invokespecial 89	android/view/animation/AccelerateInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   192: astore 4
    //   194: goto -94 -> 100
    //   197: aload 6
    //   199: ldc 91
    //   201: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +18 -> 222
    //   207: new 93	android/view/animation/DecelerateInterpolator
    //   210: dup
    //   211: aload_0
    //   212: aload 4
    //   214: invokespecial 94	android/view/animation/DecelerateInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   217: astore 4
    //   219: goto -119 -> 100
    //   222: aload 6
    //   224: ldc 96
    //   226: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +15 -> 244
    //   232: new 98	android/view/animation/AccelerateDecelerateInterpolator
    //   235: dup
    //   236: invokespecial 99	android/view/animation/AccelerateDecelerateInterpolator:<init>	()V
    //   239: astore 4
    //   241: goto -141 -> 100
    //   244: aload 6
    //   246: ldc 101
    //   248: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +18 -> 269
    //   254: new 103	android/view/animation/CycleInterpolator
    //   257: dup
    //   258: aload_0
    //   259: aload 4
    //   261: invokespecial 104	android/view/animation/CycleInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   264: astore 4
    //   266: goto -166 -> 100
    //   269: aload 6
    //   271: ldc 106
    //   273: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   276: ifeq +18 -> 294
    //   279: new 108	android/view/animation/AnticipateInterpolator
    //   282: dup
    //   283: aload_0
    //   284: aload 4
    //   286: invokespecial 109	android/view/animation/AnticipateInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   289: astore 4
    //   291: goto -191 -> 100
    //   294: aload 6
    //   296: ldc 111
    //   298: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq +18 -> 319
    //   304: new 113	android/view/animation/OvershootInterpolator
    //   307: dup
    //   308: aload_0
    //   309: aload 4
    //   311: invokespecial 114	android/view/animation/OvershootInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   314: astore 4
    //   316: goto -216 -> 100
    //   319: aload 6
    //   321: ldc 116
    //   323: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifeq +18 -> 344
    //   329: new 118	android/view/animation/AnticipateOvershootInterpolator
    //   332: dup
    //   333: aload_0
    //   334: aload 4
    //   336: invokespecial 119	android/view/animation/AnticipateOvershootInterpolator:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   339: astore 4
    //   341: goto -241 -> 100
    //   344: aload 6
    //   346: ldc 121
    //   348: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifeq +15 -> 366
    //   354: new 123	android/view/animation/BounceInterpolator
    //   357: dup
    //   358: invokespecial 124	android/view/animation/BounceInterpolator:<init>	()V
    //   361: astore 4
    //   363: goto -263 -> 100
    //   366: aload 6
    //   368: ldc 126
    //   370: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +20 -> 393
    //   376: new 128	com/tencent/token/bq
    //   379: dup
    //   380: aload_0
    //   381: aload 4
    //   383: aload 5
    //   385: invokespecial 131	com/tencent/token/bq:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)V
    //   388: astore 4
    //   390: goto -290 -> 100
    //   393: new 133	java/lang/StringBuilder
    //   396: dup
    //   397: ldc 135
    //   399: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: astore_0
    //   403: aload_0
    //   404: aload 5
    //   406: invokeinterface 71 1 0
    //   411: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: new 144	java/lang/RuntimeException
    //   418: dup
    //   419: aload_0
    //   420: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokespecial 148	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   426: athrow
    //   427: aload 5
    //   429: ifnull +10 -> 439
    //   432: aload 5
    //   434: invokeinterface 153 1 0
    //   439: aload 4
    //   441: areturn
    //   442: astore_0
    //   443: goto +149 -> 592
    //   446: astore 4
    //   448: aload 5
    //   450: astore_0
    //   451: aload 4
    //   453: astore 5
    //   455: goto +15 -> 470
    //   458: astore 4
    //   460: aload 5
    //   462: astore_0
    //   463: aload 4
    //   465: astore 5
    //   467: goto +64 -> 531
    //   470: aload_0
    //   471: astore 4
    //   473: new 133	java/lang/StringBuilder
    //   476: dup
    //   477: ldc 155
    //   479: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: astore 6
    //   484: aload_0
    //   485: astore 4
    //   487: aload 6
    //   489: iload_1
    //   490: invokestatic 161	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   493: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_0
    //   498: astore 4
    //   500: new 163	android/content/res/Resources$NotFoundException
    //   503: dup
    //   504: aload 6
    //   506: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokespecial 164	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   512: astore 6
    //   514: aload_0
    //   515: astore 4
    //   517: aload 6
    //   519: aload 5
    //   521: invokevirtual 168	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   524: pop
    //   525: aload_0
    //   526: astore 4
    //   528: aload 6
    //   530: athrow
    //   531: aload_0
    //   532: astore 4
    //   534: new 133	java/lang/StringBuilder
    //   537: dup
    //   538: ldc 155
    //   540: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: astore 6
    //   545: aload_0
    //   546: astore 4
    //   548: aload 6
    //   550: iload_1
    //   551: invokestatic 161	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   554: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_0
    //   559: astore 4
    //   561: new 163	android/content/res/Resources$NotFoundException
    //   564: dup
    //   565: aload 6
    //   567: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokespecial 164	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   573: astore 6
    //   575: aload_0
    //   576: astore 4
    //   578: aload 6
    //   580: aload 5
    //   582: invokevirtual 168	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   585: pop
    //   586: aload_0
    //   587: astore 4
    //   589: aload 6
    //   591: athrow
    //   592: aload 5
    //   594: ifnull +10 -> 604
    //   597: aload 5
    //   599: invokeinterface 153 1 0
    //   604: aload_0
    //   605: athrow
    //   606: astore_0
    //   607: aload 4
    //   609: astore 5
    //   611: goto -19 -> 592
    //   614: astore 5
    //   616: aload 6
    //   618: astore_0
    //   619: goto -149 -> 470
    //   622: astore 5
    //   624: aload 7
    //   626: astore_0
    //   627: goto -96 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramContext	android.content.Context
    //   0	630	1	paramInt	int
    //   95	27	2	i	int
    //   107	25	3	j	int
    //   21	419	4	localObject1	Object
    //   446	6	4	localIOException1	java.io.IOException
    //   458	6	4	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   471	137	4	localContext	android.content.Context
    //   76	534	5	localObject2	Object
    //   614	1	5	localIOException2	java.io.IOException
    //   622	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   15	602	6	localObject3	Object
    //   18	607	7	localObject4	Object
    //   24	73	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   78	96	442	finally
    //   100	108	442	finally
    //   113	124	442	finally
    //   134	169	442	finally
    //   172	194	442	finally
    //   197	219	442	finally
    //   222	241	442	finally
    //   244	266	442	finally
    //   269	291	442	finally
    //   294	316	442	finally
    //   319	341	442	finally
    //   344	363	442	finally
    //   366	390	442	finally
    //   393	427	442	finally
    //   78	96	446	java/io/IOException
    //   100	108	446	java/io/IOException
    //   113	124	446	java/io/IOException
    //   134	169	446	java/io/IOException
    //   172	194	446	java/io/IOException
    //   197	219	446	java/io/IOException
    //   222	241	446	java/io/IOException
    //   244	266	446	java/io/IOException
    //   269	291	446	java/io/IOException
    //   294	316	446	java/io/IOException
    //   319	341	446	java/io/IOException
    //   344	363	446	java/io/IOException
    //   366	390	446	java/io/IOException
    //   393	427	446	java/io/IOException
    //   78	96	458	org/xmlpull/v1/XmlPullParserException
    //   100	108	458	org/xmlpull/v1/XmlPullParserException
    //   113	124	458	org/xmlpull/v1/XmlPullParserException
    //   134	169	458	org/xmlpull/v1/XmlPullParserException
    //   172	194	458	org/xmlpull/v1/XmlPullParserException
    //   197	219	458	org/xmlpull/v1/XmlPullParserException
    //   222	241	458	org/xmlpull/v1/XmlPullParserException
    //   244	266	458	org/xmlpull/v1/XmlPullParserException
    //   269	291	458	org/xmlpull/v1/XmlPullParserException
    //   294	316	458	org/xmlpull/v1/XmlPullParserException
    //   319	341	458	org/xmlpull/v1/XmlPullParserException
    //   344	363	458	org/xmlpull/v1/XmlPullParserException
    //   366	390	458	org/xmlpull/v1/XmlPullParserException
    //   393	427	458	org/xmlpull/v1/XmlPullParserException
    //   32	40	606	finally
    //   46	54	606	finally
    //   60	68	606	finally
    //   68	78	606	finally
    //   473	484	606	finally
    //   487	497	606	finally
    //   500	514	606	finally
    //   517	525	606	finally
    //   528	531	606	finally
    //   534	545	606	finally
    //   548	558	606	finally
    //   561	575	606	finally
    //   578	586	606	finally
    //   589	592	606	finally
    //   32	40	614	java/io/IOException
    //   46	54	614	java/io/IOException
    //   60	68	614	java/io/IOException
    //   68	78	614	java/io/IOException
    //   32	40	622	org/xmlpull/v1/XmlPullParserException
    //   46	54	622	org/xmlpull/v1/XmlPullParserException
    //   60	68	622	org/xmlpull/v1/XmlPullParserException
    //   68	78	622	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bn
 * JD-Core Version:    0.7.0.1
 */