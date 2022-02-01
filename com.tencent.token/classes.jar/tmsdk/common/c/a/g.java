package tmsdk.common.c.a;

public class g
{
  /* Error */
  public static boolean a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 17	tmsdk/common/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore 5
    //   7: aload 5
    //   9: astore 4
    //   11: aload 5
    //   13: ifnonnull +148 -> 161
    //   16: aload_0
    //   17: invokevirtual 23	android/content/Context:getCacheDir	()Ljava/io/File;
    //   20: invokevirtual 29	java/io/File:toString	()Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: astore 4
    //   29: aload 5
    //   31: ldc 31
    //   33: invokevirtual 37	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: iconst_1
    //   37: if_icmpne +18 -> 55
    //   40: aload 5
    //   42: iconst_0
    //   43: aload 5
    //   45: invokevirtual 41	java/lang/String:length	()I
    //   48: iconst_2
    //   49: isub
    //   50: invokevirtual 45	java/lang/String:substring	(II)Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: bipush 47
    //   59: invokevirtual 49	java/lang/String:lastIndexOf	(I)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +47 -> 112
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_2
    //   72: invokevirtual 45	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: astore 4
    //   77: new 51	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   84: astore 5
    //   86: aload 5
    //   88: aload 4
    //   90: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 5
    //   96: ldc 61
    //   98: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 5
    //   104: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 4
    //   109: goto +52 -> 161
    //   112: ldc 64
    //   114: astore 4
    //   116: goto +45 -> 161
    //   119: new 51	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: aload 4
    //   130: ldc 66
    //   132: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 4
    //   138: aload_0
    //   139: invokevirtual 69	android/content/Context:getPackageName	()Ljava/lang/String;
    //   142: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: ldc 61
    //   150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 4
    //   156: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 4
    //   161: aload 4
    //   163: invokevirtual 41	java/lang/String:length	()I
    //   166: ifeq +413 -> 579
    //   169: new 51	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   176: astore_0
    //   177: aload_0
    //   178: aload 4
    //   180: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: new 25	java/io/File
    //   193: dup
    //   194: aload_0
    //   195: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: invokevirtual 76	java/io/File:exists	()Z
    //   204: ifeq +36 -> 240
    //   207: new 51	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   214: astore_0
    //   215: aload_0
    //   216: aload 4
    //   218: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_0
    //   229: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 81	java/lang/System:load	(Ljava/lang/String;)V
    //   235: iconst_1
    //   236: istore_3
    //   237: goto +5 -> 242
    //   240: iconst_0
    //   241: istore_3
    //   242: iload_3
    //   243: ifne +132 -> 375
    //   246: aload_1
    //   247: ldc 83
    //   249: invokevirtual 37	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   252: ifne +123 -> 375
    //   255: new 51	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   262: astore_0
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: ldc 83
    //   272: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 5
    //   282: new 51	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   289: astore 6
    //   291: aload 6
    //   293: aload 4
    //   295: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 6
    //   301: aload 5
    //   303: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: astore_0
    //   310: iload_3
    //   311: istore_2
    //   312: new 25	java/io/File
    //   315: dup
    //   316: aload 6
    //   318: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 76	java/io/File:exists	()Z
    //   327: ifeq +52 -> 379
    //   330: new 51	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   337: astore_0
    //   338: aload_0
    //   339: aload 4
    //   341: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: aload 5
    //   348: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_0
    //   353: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 81	java/lang/System:load	(Ljava/lang/String;)V
    //   359: iconst_1
    //   360: istore_2
    //   361: aload 5
    //   363: astore_0
    //   364: goto +15 -> 379
    //   367: aload 5
    //   369: astore_0
    //   370: iload_3
    //   371: istore_2
    //   372: goto +7 -> 379
    //   375: aload_1
    //   376: astore_0
    //   377: iload_3
    //   378: istore_2
    //   379: iload_2
    //   380: istore_3
    //   381: iload_2
    //   382: ifne +187 -> 569
    //   385: iload_2
    //   386: istore_3
    //   387: aload_0
    //   388: ldc 85
    //   390: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   393: ifne +176 -> 569
    //   396: new 51	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   403: astore 5
    //   405: aload 5
    //   407: ldc 85
    //   409: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 5
    //   415: aload_0
    //   416: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 5
    //   422: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: astore 7
    //   427: new 51	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   434: astore_0
    //   435: aload_0
    //   436: aload 4
    //   438: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_0
    //   443: aload 7
    //   445: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: new 25	java/io/File
    //   452: dup
    //   453: aload_0
    //   454: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   460: astore 6
    //   462: aload 4
    //   464: astore_0
    //   465: aload 6
    //   467: astore 5
    //   469: aload 6
    //   471: invokevirtual 76	java/io/File:exists	()Z
    //   474: ifne +51 -> 525
    //   477: aload 4
    //   479: ldc 61
    //   481: ldc 90
    //   483: invokevirtual 94	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   486: astore_0
    //   487: new 51	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   494: astore 4
    //   496: aload 4
    //   498: aload_0
    //   499: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 4
    //   505: aload 7
    //   507: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: new 25	java/io/File
    //   514: dup
    //   515: aload 4
    //   517: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   523: astore 5
    //   525: iload_2
    //   526: istore_3
    //   527: aload 5
    //   529: invokevirtual 76	java/io/File:exists	()Z
    //   532: ifeq +37 -> 569
    //   535: new 51	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   542: astore 4
    //   544: aload 4
    //   546: aload_0
    //   547: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 4
    //   553: aload 7
    //   555: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 4
    //   561: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 81	java/lang/System:load	(Ljava/lang/String;)V
    //   567: iconst_1
    //   568: istore_3
    //   569: iload_3
    //   570: ifne +13 -> 583
    //   573: aload_1
    //   574: invokestatic 97	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   577: iconst_1
    //   578: ireturn
    //   579: aload_1
    //   580: invokestatic 97	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   583: iconst_1
    //   584: ireturn
    //   585: astore 4
    //   587: goto -468 -> 119
    //   590: astore_0
    //   591: goto -351 -> 240
    //   594: astore_0
    //   595: goto -228 -> 367
    //   598: astore_0
    //   599: iload_2
    //   600: istore_3
    //   601: goto -32 -> 569
    //   604: astore_0
    //   605: iconst_0
    //   606: ireturn
    //   607: astore_0
    //   608: iconst_0
    //   609: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramContext	android.content.Context
    //   0	610	1	paramString	java.lang.String
    //   62	538	2	i	int
    //   236	365	3	j	int
    //   9	551	4	localObject1	Object
    //   585	1	4	localException	java.lang.Exception
    //   5	523	5	localObject2	Object
    //   289	181	6	localObject3	Object
    //   425	129	7	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   16	25	585	java/lang/Exception
    //   29	55	585	java/lang/Exception
    //   55	63	585	java/lang/Exception
    //   68	109	585	java/lang/Exception
    //   207	235	590	java/lang/UnsatisfiedLinkError
    //   330	359	594	java/lang/UnsatisfiedLinkError
    //   535	567	598	java/lang/UnsatisfiedLinkError
    //   573	577	604	java/lang/UnsatisfiedLinkError
    //   579	583	607	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.g
 * JD-Core Version:    0.7.0.1
 */