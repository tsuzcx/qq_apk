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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload 4
    //   9: astore_3
    //   10: invokestatic 43	com/android/safeguard/j:e	()Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_1
    //   19: astore_2
    //   20: aload 4
    //   22: astore_3
    //   23: invokestatic 46	com/android/safeguard/j:d	()V
    //   26: aload_1
    //   27: astore_2
    //   28: aload 4
    //   30: astore_3
    //   31: new 30	com/android/safeguard/j
    //   34: dup
    //   35: invokespecial 47	com/android/safeguard/j:<init>	()V
    //   38: astore 9
    //   40: aload_1
    //   41: astore_2
    //   42: aload 4
    //   44: astore_3
    //   45: new 49	com/android/safeguard/b
    //   48: dup
    //   49: aload_0
    //   50: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   53: invokespecial 52	com/android/safeguard/b:<init>	(Landroid/content/Context;)V
    //   56: astore 5
    //   58: aload_1
    //   59: astore_2
    //   60: aload 4
    //   62: astore_3
    //   63: new 54	com/android/safeguard/c
    //   66: dup
    //   67: aload_0
    //   68: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   71: invokespecial 55	com/android/safeguard/c:<init>	(Landroid/content/Context;)V
    //   74: astore 6
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: astore_3
    //   81: new 57	com/android/safeguard/a
    //   84: dup
    //   85: invokespecial 58	com/android/safeguard/a:<init>	()V
    //   88: astore 7
    //   90: aload_1
    //   91: astore_2
    //   92: aload 4
    //   94: astore_3
    //   95: new 60	com/android/safeguard/g
    //   98: dup
    //   99: aload_0
    //   100: getfield 19	com/android/safeguard/Safeguard:c	Landroid/content/Context;
    //   103: invokespecial 61	com/android/safeguard/g:<init>	(Landroid/content/Context;)V
    //   106: astore 8
    //   108: aload 5
    //   110: invokevirtual 64	com/android/safeguard/b:a	()Ljava/lang/String;
    //   113: astore_2
    //   114: aload 9
    //   116: aload 7
    //   118: aload 6
    //   120: aload_2
    //   121: invokevirtual 67	com/android/safeguard/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   124: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   130: aload 9
    //   132: aload 7
    //   134: aload 6
    //   136: aload_2
    //   137: invokevirtual 73	com/android/safeguard/c:e	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   143: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   146: aload 9
    //   148: aload 7
    //   150: aload 6
    //   152: aload_2
    //   153: invokevirtual 76	com/android/safeguard/c:g	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   162: aload 9
    //   164: aload 7
    //   166: aload 6
    //   168: invokevirtual 77	com/android/safeguard/c:a	()Ljava/lang/String;
    //   171: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   177: aload 9
    //   179: aload 7
    //   181: aload 6
    //   183: aload_2
    //   184: invokevirtual 79	com/android/safeguard/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 69	com/android/safeguard/a:e	(Ljava/lang/String;)Ljava/lang/String;
    //   190: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   193: aload 9
    //   195: aload 7
    //   197: aload_2
    //   198: invokevirtual 81	com/android/safeguard/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   204: aload 9
    //   206: aload 7
    //   208: aload_2
    //   209: invokevirtual 82	com/android/safeguard/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   215: aload 9
    //   217: aload 7
    //   219: invokestatic 84	com/android/safeguard/j:c	()Ljava/lang/String;
    //   222: invokevirtual 86	com/android/safeguard/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   225: invokevirtual 72	com/android/safeguard/j:a	(Ljava/lang/String;)V
    //   228: aload 9
    //   230: aload 5
    //   232: invokevirtual 89	com/android/safeguard/b:m	()Ljava/lang/String;
    //   235: putfield 92	com/android/safeguard/j:u	Ljava/lang/String;
    //   238: aload 9
    //   240: aload 5
    //   242: invokevirtual 95	com/android/safeguard/b:l	()Ljava/lang/String;
    //   245: putfield 98	com/android/safeguard/j:t	Ljava/lang/String;
    //   248: aload 9
    //   250: aload 5
    //   252: invokevirtual 99	com/android/safeguard/b:c	()Ljava/lang/String;
    //   255: putfield 102	com/android/safeguard/j:k	Ljava/lang/String;
    //   258: aload 9
    //   260: aload 5
    //   262: invokevirtual 105	com/android/safeguard/b:i	()Ljava/lang/String;
    //   265: putfield 108	com/android/safeguard/j:q	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 5
    //   272: invokevirtual 110	com/android/safeguard/b:k	()Ljava/lang/String;
    //   275: putfield 113	com/android/safeguard/j:s	Ljava/lang/String;
    //   278: aload 9
    //   280: aload 5
    //   282: invokevirtual 116	com/android/safeguard/b:n	()Ljava/lang/String;
    //   285: putfield 119	com/android/safeguard/j:v	Ljava/lang/String;
    //   288: aload 9
    //   290: aload 5
    //   292: invokevirtual 122	com/android/safeguard/b:j	()Ljava/lang/String;
    //   295: putfield 125	com/android/safeguard/j:r	Ljava/lang/String;
    //   298: aload 9
    //   300: aload 5
    //   302: invokevirtual 128	com/android/safeguard/b:o	()Ljava/lang/String;
    //   305: putfield 131	com/android/safeguard/j:w	Ljava/lang/String;
    //   308: aload 9
    //   310: aload 5
    //   312: invokevirtual 134	com/android/safeguard/b:p	()Ljava/lang/String;
    //   315: putfield 137	com/android/safeguard/j:x	Ljava/lang/String;
    //   318: aload 9
    //   320: aload 5
    //   322: invokevirtual 140	com/android/safeguard/b:f	()Ljava/lang/String;
    //   325: putfield 142	com/android/safeguard/j:n	Ljava/lang/String;
    //   328: aload 9
    //   330: aload 5
    //   332: invokevirtual 144	com/android/safeguard/b:b	()Ljava/lang/String;
    //   335: putfield 146	com/android/safeguard/j:j	Ljava/lang/String;
    //   338: aload 9
    //   340: aload 5
    //   342: invokevirtual 149	com/android/safeguard/b:g	()I
    //   345: putfield 152	com/android/safeguard/j:o	I
    //   348: aload 9
    //   350: aload 5
    //   352: invokevirtual 154	com/android/safeguard/b:d	()Ljava/lang/String;
    //   355: putfield 156	com/android/safeguard/j:l	Ljava/lang/String;
    //   358: aload 9
    //   360: aload 5
    //   362: invokevirtual 158	com/android/safeguard/b:q	()Ljava/lang/String;
    //   365: putfield 161	com/android/safeguard/j:y	Ljava/lang/String;
    //   368: aload 9
    //   370: aload 5
    //   372: invokevirtual 163	com/android/safeguard/b:e	()I
    //   375: putfield 165	com/android/safeguard/j:m	I
    //   378: aload 9
    //   380: aload 5
    //   382: invokevirtual 168	com/android/safeguard/b:h	()Ljava/lang/String;
    //   385: putfield 170	com/android/safeguard/j:p	Ljava/lang/String;
    //   388: aload 9
    //   390: aload 5
    //   392: invokevirtual 172	com/android/safeguard/b:r	()Ljava/lang/String;
    //   395: putfield 175	com/android/safeguard/j:z	Ljava/lang/String;
    //   398: aload 9
    //   400: aload 5
    //   402: invokevirtual 177	com/android/safeguard/b:s	()Ljava/lang/String;
    //   405: putfield 180	com/android/safeguard/j:A	Ljava/lang/String;
    //   408: aload 9
    //   410: aload 8
    //   412: invokevirtual 181	com/android/safeguard/g:b	()Ljava/lang/String;
    //   415: putfield 183	com/android/safeguard/j:g	Ljava/lang/String;
    //   418: aload 9
    //   420: aload 8
    //   422: invokevirtual 184	com/android/safeguard/g:d	()Ljava/lang/String;
    //   425: putfield 186	com/android/safeguard/j:i	Ljava/lang/String;
    //   428: aload 9
    //   430: aload 8
    //   432: invokevirtual 187	com/android/safeguard/g:a	()Ljava/lang/String;
    //   435: putfield 189	com/android/safeguard/j:f	Ljava/lang/String;
    //   438: aload 9
    //   440: aload 8
    //   442: invokevirtual 190	com/android/safeguard/g:c	()Ljava/lang/String;
    //   445: putfield 192	com/android/safeguard/j:h	Ljava/lang/String;
    //   448: aload 7
    //   450: aload 7
    //   452: aload 9
    //   454: invokevirtual 194	com/android/safeguard/j:b	()[B
    //   457: invokevirtual 197	com/android/safeguard/a:b	([B)[B
    //   460: invokevirtual 199	com/android/safeguard/a:c	([B)[B
    //   463: astore_2
    //   464: aload_2
    //   465: astore_1
    //   466: aload_1
    //   467: astore_2
    //   468: aload_1
    //   469: astore_3
    //   470: aload_0
    //   471: new 201	java/lang/StringBuilder
    //   474: dup
    //   475: aload 5
    //   477: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   480: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   483: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: aload 6
    //   488: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   491: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 7
    //   496: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   499: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 8
    //   504: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   507: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   516: aload_1
    //   517: areturn
    //   518: astore_1
    //   519: aload_0
    //   520: aload_1
    //   521: invokevirtual 226	com/android/safeguard/Safeguard:a	(Ljava/lang/Exception;)V
    //   524: aload_2
    //   525: areturn
    //   526: astore_2
    //   527: aload_0
    //   528: aload_2
    //   529: invokevirtual 226	com/android/safeguard/Safeguard:a	(Ljava/lang/Exception;)V
    //   532: aload_1
    //   533: astore_2
    //   534: aload 4
    //   536: astore_3
    //   537: aload_0
    //   538: new 201	java/lang/StringBuilder
    //   541: dup
    //   542: aload 5
    //   544: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   547: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   550: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload 6
    //   555: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   558: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 7
    //   563: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   566: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 8
    //   571: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   574: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   583: aconst_null
    //   584: areturn
    //   585: astore_1
    //   586: aload_0
    //   587: aload_1
    //   588: invokevirtual 35	com/android/safeguard/Safeguard:a	(Ljava/lang/Throwable;)V
    //   591: aload_3
    //   592: areturn
    //   593: astore_2
    //   594: aload_0
    //   595: aload_2
    //   596: invokevirtual 35	com/android/safeguard/Safeguard:a	(Ljava/lang/Throwable;)V
    //   599: aload_1
    //   600: astore_2
    //   601: aload 4
    //   603: astore_3
    //   604: aload_0
    //   605: new 201	java/lang/StringBuilder
    //   608: dup
    //   609: aload 5
    //   611: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   614: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   617: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   620: aload 6
    //   622: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   625: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload 7
    //   630: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   633: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 8
    //   638: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   641: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   650: aconst_null
    //   651: areturn
    //   652: astore 9
    //   654: aload_1
    //   655: astore_2
    //   656: aload 4
    //   658: astore_3
    //   659: aload_0
    //   660: new 201	java/lang/StringBuilder
    //   663: dup
    //   664: aload 5
    //   666: invokevirtual 203	com/android/safeguard/b:t	()Ljava/lang/String;
    //   669: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   672: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   675: aload 6
    //   677: invokevirtual 212	com/android/safeguard/c:t	()Ljava/lang/String;
    //   680: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload 7
    //   685: invokevirtual 217	com/android/safeguard/a:t	()Ljava/lang/String;
    //   688: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 8
    //   693: invokevirtual 218	com/android/safeguard/g:t	()Ljava/lang/String;
    //   696: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokevirtual 223	com/android/safeguard/Safeguard:i	(Ljava/lang/String;)V
    //   705: aload_1
    //   706: astore_2
    //   707: aload 4
    //   709: astore_3
    //   710: aload 9
    //   712: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	this	Safeguard
    //   4	513	1	localObject1	java.lang.Object
    //   518	15	1	localException1	java.lang.Exception
    //   585	121	1	localThrowable1	Throwable
    //   6	519	2	localObject2	java.lang.Object
    //   526	3	2	localException2	java.lang.Exception
    //   533	1	2	localException3	java.lang.Exception
    //   593	3	2	localThrowable2	Throwable
    //   600	107	2	localThrowable3	Throwable
    //   9	701	3	localObject3	java.lang.Object
    //   1	707	4	localObject4	java.lang.Object
    //   56	609	5	localb	b
    //   74	602	6	localc	c
    //   88	596	7	locala	a
    //   106	586	8	localg	g
    //   38	415	9	localj	j
    //   652	59	9	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   10	16	518	java/lang/Exception
    //   23	26	518	java/lang/Exception
    //   31	40	518	java/lang/Exception
    //   45	58	518	java/lang/Exception
    //   63	76	518	java/lang/Exception
    //   81	90	518	java/lang/Exception
    //   95	108	518	java/lang/Exception
    //   470	516	518	java/lang/Exception
    //   537	583	518	java/lang/Exception
    //   604	650	518	java/lang/Exception
    //   659	705	518	java/lang/Exception
    //   710	713	518	java/lang/Exception
    //   108	464	526	java/lang/Exception
    //   10	16	585	java/lang/Throwable
    //   23	26	585	java/lang/Throwable
    //   31	40	585	java/lang/Throwable
    //   45	58	585	java/lang/Throwable
    //   63	76	585	java/lang/Throwable
    //   81	90	585	java/lang/Throwable
    //   95	108	585	java/lang/Throwable
    //   470	516	585	java/lang/Throwable
    //   537	583	585	java/lang/Throwable
    //   604	650	585	java/lang/Throwable
    //   659	705	585	java/lang/Throwable
    //   710	713	585	java/lang/Throwable
    //   108	464	593	java/lang/Throwable
    //   108	464	652	finally
    //   527	532	652	finally
    //   594	599	652	finally
  }
  
  /* Error */
  public String getSafeguardInfo()
  {
    // Byte code:
    //   0: ldc 229
    //   2: astore_3
    //   3: aload_0
    //   4: invokevirtual 231	com/android/safeguard/Safeguard:a	()[B
    //   7: astore 6
    //   9: aload_3
    //   10: astore 5
    //   12: aload 6
    //   14: ifnull +216 -> 230
    //   17: aload_3
    //   18: astore 4
    //   20: new 57	com/android/safeguard/a
    //   23: dup
    //   24: invokespecial 58	com/android/safeguard/a:<init>	()V
    //   27: astore 7
    //   29: iconst_0
    //   30: istore_1
    //   31: aload_3
    //   32: astore 4
    //   34: aload_0
    //   35: invokevirtual 232	com/android/safeguard/Safeguard:t	()Ljava/lang/String;
    //   38: astore 8
    //   40: aload_3
    //   41: astore 5
    //   43: aload_3
    //   44: astore 4
    //   46: aload 8
    //   48: invokevirtual 235	java/lang/String:length	()I
    //   51: sipush 1024
    //   54: if_icmple +142 -> 196
    //   57: aload_3
    //   58: astore 4
    //   60: aload 8
    //   62: invokevirtual 235	java/lang/String:length	()I
    //   65: istore_1
    //   66: iload_1
    //   67: sipush 1024
    //   70: isub
    //   71: istore_1
    //   72: ldc 229
    //   74: astore_3
    //   75: aload_0
    //   76: aload 8
    //   78: aload 8
    //   80: invokevirtual 235	java/lang/String:length	()I
    //   83: iload_1
    //   84: isub
    //   85: invokevirtual 238	com/android/safeguard/Safeguard:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 7
    //   92: aload_0
    //   93: getfield 28	com/android/safeguard/Safeguard:b	Lcom/android/safeguard/i;
    //   96: aload 6
    //   98: aload 7
    //   100: aload 4
    //   102: aload_0
    //   103: getfield 23	com/android/safeguard/Safeguard:a	Ljava/lang/String;
    //   106: invokevirtual 242	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   109: invokevirtual 197	com/android/safeguard/a:b	([B)[B
    //   112: invokevirtual 245	com/android/safeguard/i:a	([B[B)[B
    //   115: invokevirtual 248	com/android/safeguard/a:a	([B)Ljava/lang/String;
    //   118: astore 4
    //   120: aload 4
    //   122: astore_3
    //   123: aload_3
    //   124: astore 4
    //   126: iload_1
    //   127: aload 8
    //   129: invokevirtual 235	java/lang/String:length	()I
    //   132: if_icmplt +70 -> 202
    //   135: aload_3
    //   136: astore 4
    //   138: iload_1
    //   139: aload 8
    //   141: invokevirtual 235	java/lang/String:length	()I
    //   144: if_icmpne +22 -> 166
    //   147: aload_3
    //   148: astore 4
    //   150: aload_3
    //   151: astore 5
    //   153: aload_3
    //   154: invokevirtual 235	java/lang/String:length	()I
    //   157: sipush 1024
    //   160: if_icmple +70 -> 230
    //   163: ldc 229
    //   165: areturn
    //   166: aload_3
    //   167: astore 4
    //   169: aload 8
    //   171: invokevirtual 235	java/lang/String:length	()I
    //   174: istore_1
    //   175: aload_3
    //   176: astore 4
    //   178: aload_3
    //   179: invokevirtual 235	java/lang/String:length	()I
    //   182: istore_2
    //   183: aload_3
    //   184: astore 5
    //   186: iload_2
    //   187: sipush 1024
    //   190: if_icmple +40 -> 230
    //   193: aload_3
    //   194: astore 5
    //   196: aload 5
    //   198: astore_3
    //   199: goto -124 -> 75
    //   202: iload_1
    //   203: bipush 10
    //   205: iadd
    //   206: istore_1
    //   207: goto -32 -> 175
    //   210: astore_3
    //   211: aload_0
    //   212: aload_3
    //   213: invokevirtual 35	com/android/safeguard/Safeguard:a	(Ljava/lang/Throwable;)V
    //   216: aload 4
    //   218: areturn
    //   219: astore 5
    //   221: aload_3
    //   222: astore 4
    //   224: aload 5
    //   226: astore_3
    //   227: goto -16 -> 211
    //   230: aload 5
    //   232: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	Safeguard
    //   30	177	1	i	int
    //   182	9	2	j	int
    //   2	197	3	localObject1	java.lang.Object
    //   210	12	3	localThrowable1	Throwable
    //   226	1	3	localObject2	java.lang.Object
    //   18	205	4	localObject3	java.lang.Object
    //   10	187	5	localObject4	java.lang.Object
    //   219	12	5	localThrowable2	Throwable
    //   7	90	6	arrayOfByte	byte[]
    //   27	72	7	locala	a
    //   38	132	8	str	String
    // Exception table:
    //   from	to	target	type
    //   20	29	210	java/lang/Throwable
    //   34	40	210	java/lang/Throwable
    //   46	57	210	java/lang/Throwable
    //   60	66	210	java/lang/Throwable
    //   126	135	210	java/lang/Throwable
    //   138	147	210	java/lang/Throwable
    //   153	163	210	java/lang/Throwable
    //   169	175	210	java/lang/Throwable
    //   178	183	210	java/lang/Throwable
    //   75	120	219	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.Safeguard
 * JD-Core Version:    0.7.0.1
 */