package com.tencent.qphone.base.util;

public class k
{
  private static final String a = "ThreadUtils";
  
  /* Error */
  public static void a(java.lang.StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 20	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7: ldc 23
    //   9: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: invokestatic 33	android/os/Process:myPid	()I
    //   15: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 38
    //   20: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 7
    //   28: aload_0
    //   29: ldc 44
    //   31: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   38: lstore_2
    //   39: new 52	java/io/File
    //   42: dup
    //   43: aload 7
    //   45: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 59	java/io/File:list	()[Ljava/lang/String;
    //   51: astore 8
    //   53: iconst_0
    //   54: istore_1
    //   55: aconst_null
    //   56: astore 4
    //   58: aload 4
    //   60: astore 6
    //   62: iload_1
    //   63: aload 8
    //   65: arraylength
    //   66: if_icmpge +100 -> 166
    //   69: aload 4
    //   71: astore 6
    //   73: new 52	java/io/File
    //   76: dup
    //   77: new 20	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   84: aload 7
    //   86: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 61
    //   91: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 8
    //   96: iload_1
    //   97: aaload
    //   98: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 63
    //   103: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload 4
    //   116: astore 6
    //   118: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   121: lload_2
    //   122: lsub
    //   123: ldc2_w 64
    //   126: lcmp
    //   127: ifle +119 -> 246
    //   130: aload 4
    //   132: astore 6
    //   134: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +29 -> 166
    //   140: aload 4
    //   142: astore 6
    //   144: ldc 8
    //   146: iconst_2
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: ldc 73
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_0
    //   159: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   166: aload 4
    //   168: astore 6
    //   170: aload_0
    //   171: ldc 79
    //   173: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 8
    //   178: arraylength
    //   179: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: astore 6
    //   187: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +45 -> 235
    //   193: aload 4
    //   195: astore 6
    //   197: ldc 8
    //   199: iconst_2
    //   200: iconst_4
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc 81
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   214: lload_2
    //   215: lsub
    //   216: invokestatic 87	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: ldc 89
    //   224: aastore
    //   225: dup
    //   226: iconst_3
    //   227: aload_0
    //   228: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aastore
    //   232: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 94	java/io/BufferedReader:close	()V
    //   245: return
    //   246: aload 4
    //   248: astore 6
    //   250: aload 5
    //   252: invokevirtual 97	java/io/File:exists	()Z
    //   255: ifeq +216 -> 471
    //   258: aload 4
    //   260: astore 6
    //   262: new 91	java/io/BufferedReader
    //   265: dup
    //   266: new 99	java/io/FileReader
    //   269: dup
    //   270: aload 5
    //   272: invokespecial 102	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   275: bipush 64
    //   277: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   280: astore 5
    //   282: aload 5
    //   284: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   287: astore 4
    //   289: aload 4
    //   291: ifnull +183 -> 474
    //   294: aload 4
    //   296: ldc 110
    //   298: invokevirtual 116	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   301: ifeq -19 -> 282
    //   304: aload 4
    //   306: ldc 118
    //   308: invokevirtual 122	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   311: iconst_1
    //   312: aaload
    //   313: invokevirtual 125	java/lang/String:trim	()Ljava/lang/String;
    //   316: astore 4
    //   318: aload_0
    //   319: aload 4
    //   321: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 127
    //   326: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: astore 4
    //   334: aload 5
    //   336: ifnull +11 -> 347
    //   339: aload 5
    //   341: invokevirtual 94	java/io/BufferedReader:close	()V
    //   344: aconst_null
    //   345: astore 4
    //   347: iload_1
    //   348: iconst_1
    //   349: iadd
    //   350: istore_1
    //   351: goto -293 -> 58
    //   354: astore 4
    //   356: ldc 8
    //   358: iconst_2
    //   359: ldc 129
    //   361: aload 4
    //   363: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload 5
    //   368: astore 4
    //   370: goto -23 -> 347
    //   373: astore_0
    //   374: aload 5
    //   376: astore 4
    //   378: aload 4
    //   380: astore 6
    //   382: ldc 8
    //   384: iconst_2
    //   385: ldc 129
    //   387: aload_0
    //   388: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload 4
    //   393: ifnull -148 -> 245
    //   396: aload 4
    //   398: invokevirtual 94	java/io/BufferedReader:close	()V
    //   401: return
    //   402: astore_0
    //   403: ldc 8
    //   405: iconst_2
    //   406: ldc 129
    //   408: aload_0
    //   409: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   412: return
    //   413: astore_0
    //   414: aconst_null
    //   415: astore 6
    //   417: aload 6
    //   419: ifnull +8 -> 427
    //   422: aload 6
    //   424: invokevirtual 94	java/io/BufferedReader:close	()V
    //   427: aload_0
    //   428: athrow
    //   429: astore 4
    //   431: ldc 8
    //   433: iconst_2
    //   434: ldc 129
    //   436: aload 4
    //   438: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: goto -14 -> 427
    //   444: astore_0
    //   445: goto -42 -> 403
    //   448: astore_0
    //   449: aload 5
    //   451: astore 6
    //   453: goto -36 -> 417
    //   456: astore_0
    //   457: goto -40 -> 417
    //   460: astore_0
    //   461: aconst_null
    //   462: astore 4
    //   464: goto -86 -> 378
    //   467: astore_0
    //   468: goto -90 -> 378
    //   471: goto -124 -> 347
    //   474: aconst_null
    //   475: astore 4
    //   477: goto -159 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramStringBuilder	java.lang.StringBuilder
    //   54	297	1	i	int
    //   38	177	2	l	long
    //   56	290	4	localObject1	Object
    //   354	8	4	localIOException1	java.io.IOException
    //   368	29	4	localObject2	Object
    //   429	8	4	localIOException2	java.io.IOException
    //   462	14	4	localObject3	Object
    //   112	338	5	localObject4	Object
    //   60	392	6	localObject5	Object
    //   26	59	7	str	String
    //   51	126	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   339	344	354	java/io/IOException
    //   282	289	373	java/lang/Exception
    //   294	318	373	java/lang/Exception
    //   318	330	373	java/lang/Exception
    //   339	344	373	java/lang/Exception
    //   356	366	373	java/lang/Exception
    //   396	401	402	java/io/IOException
    //   39	53	413	finally
    //   422	427	429	java/io/IOException
    //   240	245	444	java/io/IOException
    //   282	289	448	finally
    //   294	318	448	finally
    //   318	330	448	finally
    //   339	344	448	finally
    //   356	366	448	finally
    //   62	69	456	finally
    //   73	114	456	finally
    //   118	130	456	finally
    //   134	140	456	finally
    //   144	166	456	finally
    //   170	183	456	finally
    //   187	193	456	finally
    //   197	235	456	finally
    //   250	258	456	finally
    //   262	282	456	finally
    //   382	391	456	finally
    //   39	53	460	java/lang/Exception
    //   62	69	467	java/lang/Exception
    //   73	114	467	java/lang/Exception
    //   118	130	467	java/lang/Exception
    //   134	140	467	java/lang/Exception
    //   144	166	467	java/lang/Exception
    //   170	183	467	java/lang/Exception
    //   187	193	467	java/lang/Exception
    //   197	235	467	java/lang/Exception
    //   250	258	467	java/lang/Exception
    //   262	282	467	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.k
 * JD-Core Version:    0.7.0.1
 */