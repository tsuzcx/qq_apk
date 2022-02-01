package com.android.safeguard;

import android.content.Context;

public class Safeguard
  extends h
{
  String a = "UTF-8";
  i b;
  private Context c = null;
  
  public Safeguard(Context paramContext, String paramString)
  {
    this.c = paramContext;
    try
    {
      this.b = new i();
      j.a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      a(paramContext);
    }
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 5
    //   11: astore_2
    //   12: aload 6
    //   14: astore_3
    //   15: invokestatic 43	com/android/safeguard/j:e	()Z
    //   18: ifeq +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload 5
    //   25: astore_2
    //   26: aload 6
    //   28: astore_3
    //   29: invokestatic 46	com/android/safeguard/j:d	()V
    //   32: aload 5
    //   34: astore_2
    //   35: aload 6
    //   37: astore_3
    //   38: new 30	com/android/safeguard/j
    //   41: dup
    //   42: invokespecial 47	com/android/safeguard/j:<init>	()V
    //   45: astore_1
    //   46: aload 5
    //   48: astore_2
    //   49: aload 6
    //   51: astore_3
    //   52: new 49	com/android/safeguard/b
    //   55: dup
    //   56: aload_0
    //   57: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   60: invokespecial 52	com/android/safeguard/b:<init>	(Landroid/content/Context;)V
    //   63: astore 10
    //   65: aload 5
    //   67: astore_2
    //   68: aload 6
    //   70: astore_3
    //   71: new 54	com/android/safeguard/c
    //   74: dup
    //   75: aload_0
    //   76: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   79: invokespecial 55	com/android/safeguard/c:<init>	(Landroid/content/Context;)V
    //   82: astore 7
    //   84: aload 5
    //   86: astore_2
    //   87: aload 6
    //   89: astore_3
    //   90: new 57	com/android/safeguard/a
    //   93: dup
    //   94: invokespecial 58	com/android/safeguard/a:<init>	()V
    //   97: astore 8
    //   99: aload 5
    //   101: astore_2
    //   102: aload 6
    //   104: astore_3
    //   105: new 60	com/android/safeguard/g
    //   108: dup
    //   109: aload_0
    //   110: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   113: invokespecial 61	com/android/safeguard/g:<init>	(Landroid/content/Context;)V
    //   116: astore 9
    //   118: aload 10
    //   120: invokevirtual 64	com/android/safeguard/b:a	()Ljava/lang/String;
    //   123: astore_2
    //   124: aload_1
    //   125: aload 8
    //   127: aload 7
    //   129: aload_2
    //   130: invokevirtual 67	com/android/safeguard/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: aload 8
    //   142: aload 7
    //   144: aload_2
    //   145: invokevirtual 73	com/android/safeguard/c:e	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: aload 8
    //   157: aload 7
    //   159: aload_2
    //   160: invokevirtual 76	com/android/safeguard/c:g	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: aload 8
    //   172: aload 7
    //   174: invokevirtual 77	com/android/safeguard/c:a	()Ljava/lang/String;
    //   177: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   180: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: aload 8
    //   186: aload 7
    //   188: aload_2
    //   189: invokevirtual 79	com/android/safeguard/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   192: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   198: aload_1
    //   199: aload 8
    //   201: aload_2
    //   202: invokevirtual 81	com/android/safeguard/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   208: aload_1
    //   209: aload 8
    //   211: aload_2
    //   212: invokevirtual 82	com/android/safeguard/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   218: aload_1
    //   219: aload 8
    //   221: invokestatic 84	com/android/safeguard/j:c	()Ljava/lang/String;
    //   224: invokevirtual 86	com/android/safeguard/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   230: aload_1
    //   231: aload 10
    //   233: invokevirtual 89	com/android/safeguard/b:m	()Ljava/lang/String;
    //   236: putfield 92	com/android/safeguard/j:u	Ljava/lang/String;
    //   239: aload_1
    //   240: aload 10
    //   242: invokevirtual 95	com/android/safeguard/b:l	()Ljava/lang/String;
    //   245: putfield 98	com/android/safeguard/j:t	Ljava/lang/String;
    //   248: aload_1
    //   249: aload 10
    //   251: invokevirtual 99	com/android/safeguard/b:c	()Ljava/lang/String;
    //   254: putfield 102	com/android/safeguard/j:k	Ljava/lang/String;
    //   257: aload_1
    //   258: aload 10
    //   260: invokevirtual 105	com/android/safeguard/b:i	()Ljava/lang/String;
    //   263: putfield 108	com/android/safeguard/j:q	Ljava/lang/String;
    //   266: aload_1
    //   267: aload 10
    //   269: invokevirtual 110	com/android/safeguard/b:k	()Ljava/lang/String;
    //   272: putfield 113	com/android/safeguard/j:s	Ljava/lang/String;
    //   275: aload_1
    //   276: aload 10
    //   278: invokevirtual 116	com/android/safeguard/b:n	()Ljava/lang/String;
    //   281: putfield 119	com/android/safeguard/j:v	Ljava/lang/String;
    //   284: aload_1
    //   285: aload 10
    //   287: invokevirtual 122	com/android/safeguard/b:j	()Ljava/lang/String;
    //   290: putfield 125	com/android/safeguard/j:r	Ljava/lang/String;
    //   293: aload_1
    //   294: aload 10
    //   296: invokevirtual 128	com/android/safeguard/b:o	()Ljava/lang/String;
    //   299: putfield 131	com/android/safeguard/j:w	Ljava/lang/String;
    //   302: aload_1
    //   303: aload 10
    //   305: invokevirtual 134	com/android/safeguard/b:p	()Ljava/lang/String;
    //   308: putfield 137	com/android/safeguard/j:x	Ljava/lang/String;
    //   311: aload_1
    //   312: aload 10
    //   314: invokevirtual 140	com/android/safeguard/b:f	()Ljava/lang/String;
    //   317: putfield 142	com/android/safeguard/j:n	Ljava/lang/String;
    //   320: aload_1
    //   321: aload 10
    //   323: invokevirtual 144	com/android/safeguard/b:b	()Ljava/lang/String;
    //   326: putfield 146	com/android/safeguard/j:j	Ljava/lang/String;
    //   329: aload_1
    //   330: aload 10
    //   332: invokevirtual 149	com/android/safeguard/b:g	()I
    //   335: putfield 152	com/android/safeguard/j:o	I
    //   338: aload_1
    //   339: aload 10
    //   341: invokevirtual 154	com/android/safeguard/b:d	()Ljava/lang/String;
    //   344: putfield 156	com/android/safeguard/j:l	Ljava/lang/String;
    //   347: aload_1
    //   348: aload 10
    //   350: invokevirtual 158	com/android/safeguard/b:q	()Ljava/lang/String;
    //   353: putfield 161	com/android/safeguard/j:y	Ljava/lang/String;
    //   356: aload_1
    //   357: aload 10
    //   359: invokevirtual 163	com/android/safeguard/b:e	()I
    //   362: putfield 165	com/android/safeguard/j:m	I
    //   365: aload_1
    //   366: aload 10
    //   368: invokevirtual 168	com/android/safeguard/b:h	()Ljava/lang/String;
    //   371: putfield 170	com/android/safeguard/j:p	Ljava/lang/String;
    //   374: aload_1
    //   375: aload 10
    //   377: invokevirtual 172	com/android/safeguard/b:r	()Ljava/lang/String;
    //   380: putfield 175	com/android/safeguard/j:z	Ljava/lang/String;
    //   383: aload_1
    //   384: aload 10
    //   386: invokevirtual 177	com/android/safeguard/b:s	()Ljava/lang/String;
    //   389: putfield 180	com/android/safeguard/j:A	Ljava/lang/String;
    //   392: aload_1
    //   393: aload 9
    //   395: invokevirtual 181	com/android/safeguard/g:b	()Ljava/lang/String;
    //   398: putfield 183	com/android/safeguard/j:g	Ljava/lang/String;
    //   401: aload_1
    //   402: aload 9
    //   404: invokevirtual 184	com/android/safeguard/g:d	()Ljava/lang/String;
    //   407: putfield 186	com/android/safeguard/j:i	Ljava/lang/String;
    //   410: aload_1
    //   411: aload 9
    //   413: invokevirtual 187	com/android/safeguard/g:a	()Ljava/lang/String;
    //   416: putfield 189	com/android/safeguard/j:f	Ljava/lang/String;
    //   419: aload_1
    //   420: aload 9
    //   422: invokevirtual 190	com/android/safeguard/g:c	()Ljava/lang/String;
    //   425: putfield 192	com/android/safeguard/j:h	Ljava/lang/String;
    //   428: aload 8
    //   430: aload 8
    //   432: aload_1
    //   433: invokevirtual 194	com/android/safeguard/j:b	()[B
    //   436: invokevirtual 197	com/android/safeguard/a:b	([B)[B
    //   439: invokevirtual 199	com/android/safeguard/a:c	([B)[B
    //   442: astore_1
    //   443: aload_1
    //   444: astore_2
    //   445: aload_1
    //   446: astore_3
    //   447: new 201	java/lang/StringBuilder
    //   450: dup
    //   451: aload 10
    //   453: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   456: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   459: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   462: astore 4
    //   464: aload_1
    //   465: astore_2
    //   466: aload_1
    //   467: astore_3
    //   468: aload 4
    //   470: aload 7
    //   472: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   475: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_1
    //   480: astore_2
    //   481: aload_1
    //   482: astore_3
    //   483: aload 4
    //   485: aload 8
    //   487: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   490: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_1
    //   495: astore_2
    //   496: aload_1
    //   497: astore_3
    //   498: aload 4
    //   500: aload 9
    //   502: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   505: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: astore_2
    //   511: aload_1
    //   512: astore_3
    //   513: aload 4
    //   515: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: astore 4
    //   520: aload_1
    //   521: astore_2
    //   522: aload_1
    //   523: astore_3
    //   524: aload_0
    //   525: aload 4
    //   527: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   530: aload_1
    //   531: areturn
    //   532: astore_1
    //   533: goto +199 -> 732
    //   536: astore_1
    //   537: aload_0
    //   538: aload_1
    //   539: invokevirtual 35	com/android/safeguard/Safeguard:a	(Ljava/lang/Throwable;)V
    //   542: aload 5
    //   544: astore_2
    //   545: aload 6
    //   547: astore_3
    //   548: new 201	java/lang/StringBuilder
    //   551: dup
    //   552: aload 10
    //   554: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   557: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   560: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   563: astore_1
    //   564: aload 5
    //   566: astore_2
    //   567: aload 6
    //   569: astore_3
    //   570: aload_1
    //   571: aload 7
    //   573: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   576: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: astore_2
    //   583: aload 6
    //   585: astore_3
    //   586: aload_1
    //   587: aload 8
    //   589: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   592: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 5
    //   598: astore_2
    //   599: aload 6
    //   601: astore_3
    //   602: aload_1
    //   603: aload 9
    //   605: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   608: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 5
    //   614: astore_2
    //   615: aload 6
    //   617: astore_3
    //   618: aload_1
    //   619: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: astore 5
    //   624: aload 4
    //   626: astore_1
    //   627: aload 5
    //   629: astore 4
    //   631: goto -111 -> 520
    //   634: astore_1
    //   635: aload_0
    //   636: aload_1
    //   637: invokevirtual 226	com/android/safeguard/Safeguard:a	(Ljava/lang/Exception;)V
    //   640: aload 5
    //   642: astore_2
    //   643: aload 6
    //   645: astore_3
    //   646: new 201	java/lang/StringBuilder
    //   649: dup
    //   650: aload 10
    //   652: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   655: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   658: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   661: astore_1
    //   662: aload 5
    //   664: astore_2
    //   665: aload 6
    //   667: astore_3
    //   668: aload_1
    //   669: aload 7
    //   671: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   674: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 5
    //   680: astore_2
    //   681: aload 6
    //   683: astore_3
    //   684: aload_1
    //   685: aload 8
    //   687: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   690: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 5
    //   696: astore_2
    //   697: aload 6
    //   699: astore_3
    //   700: aload_1
    //   701: aload 9
    //   703: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   706: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 5
    //   712: astore_2
    //   713: aload 6
    //   715: astore_3
    //   716: aload_1
    //   717: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: astore 5
    //   722: aload 4
    //   724: astore_1
    //   725: aload 5
    //   727: astore 4
    //   729: goto -209 -> 520
    //   732: aload 5
    //   734: astore_2
    //   735: aload 6
    //   737: astore_3
    //   738: new 201	java/lang/StringBuilder
    //   741: dup
    //   742: aload 10
    //   744: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   747: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   750: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   753: astore 4
    //   755: aload 5
    //   757: astore_2
    //   758: aload 6
    //   760: astore_3
    //   761: aload 4
    //   763: aload 7
    //   765: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   768: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload 5
    //   774: astore_2
    //   775: aload 6
    //   777: astore_3
    //   778: aload 4
    //   780: aload 8
    //   782: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   785: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 5
    //   791: astore_2
    //   792: aload 6
    //   794: astore_3
    //   795: aload 4
    //   797: aload 9
    //   799: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   802: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload 5
    //   808: astore_2
    //   809: aload 6
    //   811: astore_3
    //   812: aload_0
    //   813: aload 4
    //   815: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   821: aload 5
    //   823: astore_2
    //   824: aload 6
    //   826: astore_3
    //   827: aload_1
    //   828: athrow
    //   829: astore_1
    //   830: aload_0
    //   831: aload_1
    //   832: invokevirtual 35	com/android/safeguard/Safeguard:a	(Ljava/lang/Throwable;)V
    //   835: aload_2
    //   836: areturn
    //   837: astore_1
    //   838: aload_0
    //   839: aload_1
    //   840: invokevirtual 226	com/android/safeguard/Safeguard:a	(Ljava/lang/Exception;)V
    //   843: aload_3
    //   844: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	845	0	this	Safeguard
    //   45	486	1	localObject1	Object
    //   532	1	1	localObject2	Object
    //   536	3	1	localThrowable1	Throwable
    //   563	64	1	localObject3	Object
    //   634	3	1	localException1	java.lang.Exception
    //   661	167	1	localObject4	Object
    //   829	3	1	localThrowable2	Throwable
    //   837	3	1	localException2	java.lang.Exception
    //   11	825	2	localObject5	Object
    //   14	830	3	localObject6	Object
    //   7	807	4	localObject7	Object
    //   1	821	5	str	String
    //   4	821	6	localObject8	Object
    //   82	682	7	localc	c
    //   97	684	8	locala	a
    //   116	682	9	localg	g
    //   63	680	10	localb	b
    // Exception table:
    //   from	to	target	type
    //   118	443	532	finally
    //   537	542	532	finally
    //   635	640	532	finally
    //   118	443	536	java/lang/Throwable
    //   118	443	634	java/lang/Exception
    //   15	21	829	java/lang/Throwable
    //   29	32	829	java/lang/Throwable
    //   38	46	829	java/lang/Throwable
    //   52	65	829	java/lang/Throwable
    //   71	84	829	java/lang/Throwable
    //   90	99	829	java/lang/Throwable
    //   105	118	829	java/lang/Throwable
    //   447	464	829	java/lang/Throwable
    //   468	479	829	java/lang/Throwable
    //   483	494	829	java/lang/Throwable
    //   498	509	829	java/lang/Throwable
    //   513	520	829	java/lang/Throwable
    //   524	530	829	java/lang/Throwable
    //   548	564	829	java/lang/Throwable
    //   570	580	829	java/lang/Throwable
    //   586	596	829	java/lang/Throwable
    //   602	612	829	java/lang/Throwable
    //   618	624	829	java/lang/Throwable
    //   646	662	829	java/lang/Throwable
    //   668	678	829	java/lang/Throwable
    //   684	694	829	java/lang/Throwable
    //   700	710	829	java/lang/Throwable
    //   716	722	829	java/lang/Throwable
    //   738	755	829	java/lang/Throwable
    //   761	772	829	java/lang/Throwable
    //   778	789	829	java/lang/Throwable
    //   795	806	829	java/lang/Throwable
    //   812	821	829	java/lang/Throwable
    //   827	829	829	java/lang/Throwable
    //   15	21	837	java/lang/Exception
    //   29	32	837	java/lang/Exception
    //   38	46	837	java/lang/Exception
    //   52	65	837	java/lang/Exception
    //   71	84	837	java/lang/Exception
    //   90	99	837	java/lang/Exception
    //   105	118	837	java/lang/Exception
    //   447	464	837	java/lang/Exception
    //   468	479	837	java/lang/Exception
    //   483	494	837	java/lang/Exception
    //   498	509	837	java/lang/Exception
    //   513	520	837	java/lang/Exception
    //   524	530	837	java/lang/Exception
    //   548	564	837	java/lang/Exception
    //   570	580	837	java/lang/Exception
    //   586	596	837	java/lang/Exception
    //   602	612	837	java/lang/Exception
    //   618	624	837	java/lang/Exception
    //   646	662	837	java/lang/Exception
    //   668	678	837	java/lang/Exception
    //   684	694	837	java/lang/Exception
    //   700	710	837	java/lang/Exception
    //   716	722	837	java/lang/Exception
    //   738	755	837	java/lang/Exception
    //   761	772	837	java/lang/Exception
    //   778	789	837	java/lang/Exception
    //   795	806	837	java/lang/Exception
    //   812	821	837	java/lang/Exception
    //   827	829	837	java/lang/Exception
  }
  
  public String getSafeguardInfo()
  {
    String str3 = "";
    byte[] arrayOfByte = a();
    String str2 = str3;
    String str1;
    if (arrayOfByte != null) {
      str1 = str3;
    }
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        a locala = new a();
        i = 0;
        str1 = str3;
        String str4 = t();
        str2 = str3;
        str1 = str3;
        if (str4.length() > 1024)
        {
          str1 = str3;
          i = str4.length() - 1024;
          str2 = str3;
        }
        str1 = str2;
        str3 = a(str4, str4.length() - i);
        str1 = str2;
        str3 = locala.a(this.b.a(arrayOfByte, locala.b(str3.getBytes(this.a))));
        str1 = str3;
        if (i < str4.length()) {
          break label222;
        }
        str1 = str3;
        if (i == str4.length())
        {
          str1 = str3;
          str2 = str3;
          if (str3.length() > 1024) {
            return "";
          }
        }
        else
        {
          str1 = str3;
          i = str4.length();
          str1 = str3;
          int j = str3.length();
          str2 = str3;
          if (j > 1024) {
            continue;
          }
          return str3;
        }
      }
      catch (Throwable localThrowable)
      {
        a(localThrowable);
        localObject = str1;
      }
      return localObject;
      label222:
      i += 10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.Safeguard
 * JD-Core Version:    0.7.0.1
 */