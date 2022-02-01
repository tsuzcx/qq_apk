package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aet
{
  public static Set<Integer> a = new HashSet();
  public static LruCache<String, String> b = new LruCache(200);
  public static afu c;
  public static long d = -1L;
  public static long e = -1L;
  public static long f = 180000L;
  public static AtomicBoolean g = new AtomicBoolean(false);
  public static a h;
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 62	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   6: astore 8
    //   8: iconst_0
    //   9: istore_1
    //   10: aload 8
    //   12: aload_0
    //   13: ldc 64
    //   15: iconst_0
    //   16: invokevirtual 67	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +7 -> 28
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   31: lstore 6
    //   33: getstatic 42	com/tencent/token/aet:d	J
    //   36: lconst_0
    //   37: lcmp
    //   38: ifge +33 -> 71
    //   41: getstatic 78	com/tencent/turingfd/sdk/qps/Peach:a	Ljava/lang/String;
    //   44: astore 8
    //   46: aload_0
    //   47: ldc 80
    //   49: invokestatic 83	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 89	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   55: invokevirtual 92	java/lang/Long:longValue	()J
    //   58: lstore 4
    //   60: goto +6 -> 66
    //   63: lconst_0
    //   64: lstore 4
    //   66: lload 4
    //   68: putstatic 42	com/tencent/token/aet:d	J
    //   71: getstatic 44	com/tencent/token/aet:e	J
    //   74: lconst_0
    //   75: lcmp
    //   76: ifge +49 -> 125
    //   79: getstatic 62	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   82: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   85: pop
    //   86: getstatic 62	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   89: aload_0
    //   90: invokevirtual 99	com/tencent/turingfd/sdk/qps/Pistachio:b	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/qps/Gooseberry;
    //   93: getfield 105	com/tencent/turingfd/sdk/qps/Gooseberry:k	Ljava/util/Map;
    //   96: ldc 107
    //   98: invokeinterface 113 2 0
    //   103: checkcast 115	java/lang/String
    //   106: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: iload_2
    //   111: i2l
    //   112: lstore 4
    //   114: goto +6 -> 120
    //   117: lconst_1
    //   118: lstore 4
    //   120: lload 4
    //   122: putstatic 44	com/tencent/token/aet:e	J
    //   125: getstatic 42	com/tencent/token/aet:d	J
    //   128: lload 6
    //   130: lsub
    //   131: invokestatic 127	java/lang/Math:abs	(J)J
    //   134: lstore 4
    //   136: getstatic 44	com/tencent/token/aet:e	J
    //   139: lstore 6
    //   141: lload 4
    //   143: lload 6
    //   145: ldc2_w 128
    //   148: lmul
    //   149: ldc2_w 130
    //   152: lmul
    //   153: lcmp
    //   154: ifgt +7 -> 161
    //   157: ldc 2
    //   159: monitorexit
    //   160: return
    //   161: getstatic 55	com/tencent/token/aet:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   164: invokevirtual 134	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   167: istore_3
    //   168: iload_3
    //   169: ifeq +7 -> 176
    //   172: ldc 2
    //   174: monitorexit
    //   175: return
    //   176: iload_1
    //   177: iconst_3
    //   178: if_icmpge +67 -> 245
    //   181: aload_0
    //   182: invokestatic 137	com/tencent/token/aet:b	(Landroid/content/Context;)Lcom/tencent/token/aeu;
    //   185: getfield 142	com/tencent/token/aeu:a	I
    //   188: ifne +50 -> 238
    //   191: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   194: lstore 4
    //   196: lload 4
    //   198: putstatic 42	com/tencent/token/aet:d	J
    //   201: getstatic 78	com/tencent/turingfd/sdk/qps/Peach:a	Ljava/lang/String;
    //   204: astore 8
    //   206: new 144	java/util/HashMap
    //   209: dup
    //   210: invokespecial 145	java/util/HashMap:<init>	()V
    //   213: astore 8
    //   215: aload 8
    //   217: ldc 80
    //   219: lload 4
    //   221: invokestatic 148	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   224: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload_0
    //   229: aload 8
    //   231: invokestatic 155	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   234: ldc 2
    //   236: monitorexit
    //   237: return
    //   238: iload_1
    //   239: iconst_1
    //   240: iadd
    //   241: istore_1
    //   242: goto -66 -> 176
    //   245: ldc 2
    //   247: monitorexit
    //   248: return
    //   249: astore_0
    //   250: ldc 2
    //   252: monitorexit
    //   253: aload_0
    //   254: athrow
    //   255: astore 8
    //   257: goto -194 -> 63
    //   260: astore 8
    //   262: goto -145 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramContext	Context
    //   9	233	1	i	int
    //   109	2	2	j	int
    //   19	150	3	bool	boolean
    //   58	162	4	l1	long
    //   31	113	6	l2	long
    //   6	224	8	localObject1	Object
    //   255	1	8	localObject2	Object
    //   260	1	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	249	finally
    //   10	20	249	finally
    //   28	46	249	finally
    //   66	71	249	finally
    //   71	86	249	finally
    //   120	125	249	finally
    //   125	141	249	finally
    //   161	168	249	finally
    //   181	234	249	finally
    //   46	60	255	finally
    //   86	110	260	finally
  }
  
  /* Error */
  private static aeu b(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 161	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 164	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpne +16 -> 22
    //   9: new 139	com/tencent/token/aeu
    //   12: dup
    //   13: sipush -10008
    //   16: ldc 166
    //   18: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   21: areturn
    //   22: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   25: lstore 5
    //   27: getstatic 31	com/tencent/token/aet:a	Ljava/util/Set;
    //   30: astore 8
    //   32: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   35: lstore_3
    //   36: new 144	java/util/HashMap
    //   39: dup
    //   40: invokespecial 145	java/util/HashMap:<init>	()V
    //   43: astore 10
    //   45: new 171	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   52: astore 9
    //   54: aload 9
    //   56: getstatic 175	com/tencent/token/agb:a	I
    //   59: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 10
    //   65: ldc 181
    //   67: aload 9
    //   69: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: getstatic 190	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   79: astore 11
    //   81: aload 11
    //   83: aload_0
    //   84: new 192	com/tencent/token/aes
    //   87: dup
    //   88: aload 8
    //   90: invokespecial 195	com/tencent/token/aes:<init>	(Ljava/util/Set;)V
    //   93: invokevirtual 198	com/tencent/token/afn:a	(Landroid/content/Context;Lcom/tencent/token/afm;)J
    //   96: pop2
    //   97: aload 11
    //   99: bipush 28
    //   101: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   104: ifeq +72 -> 176
    //   107: getstatic 203	com/tencent/token/aet:c	Lcom/tencent/token/afu;
    //   110: getfield 209	com/tencent/token/afu:p	Z
    //   113: istore 7
    //   115: iconst_0
    //   116: istore_1
    //   117: iload_1
    //   118: iconst_3
    //   119: if_icmpge +49 -> 168
    //   122: getstatic 214	com/tencent/token/afc:a	Lcom/tencent/token/afc;
    //   125: aload_0
    //   126: iconst_1
    //   127: iconst_1
    //   128: invokevirtual 217	com/tencent/token/afc:a	(Landroid/content/Context;ZI)Lcom/tencent/token/aew;
    //   131: astore 8
    //   133: aload 8
    //   135: getfield 221	com/tencent/token/aew:d	I
    //   138: ifeq +17 -> 155
    //   141: getstatic 203	com/tencent/token/aet:c	Lcom/tencent/token/afu;
    //   144: iconst_1
    //   145: putfield 209	com/tencent/token/afu:p	Z
    //   148: iload_1
    //   149: iconst_1
    //   150: iadd
    //   151: istore_1
    //   152: goto -35 -> 117
    //   155: aload 10
    //   157: ldc 223
    //   159: aload 8
    //   161: getfield 225	com/tencent/token/aew:b	Ljava/lang/String;
    //   164: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: getstatic 203	com/tencent/token/aet:c	Lcom/tencent/token/afu;
    //   171: iload 7
    //   173: putfield 209	com/tencent/token/afu:p	Z
    //   176: aload 11
    //   178: bipush 22
    //   180: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   183: ifeq +15 -> 198
    //   186: aload 10
    //   188: ldc 227
    //   190: aload_0
    //   191: invokestatic 232	com/tencent/token/ags:a	(Landroid/content/Context;)Ljava/lang/String;
    //   194: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: aload 11
    //   200: bipush 100
    //   202: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   205: ifeq +32 -> 237
    //   208: aload_0
    //   209: invokestatic 236	com/tencent/token/ahr:f	(Landroid/content/Context;)Ljava/lang/String;
    //   212: astore 9
    //   214: aload 9
    //   216: astore 8
    //   218: aload 9
    //   220: ifnonnull +7 -> 227
    //   223: ldc 166
    //   225: astore 8
    //   227: aload 10
    //   229: ldc 238
    //   231: aload 8
    //   233: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   236: pop
    //   237: aload 11
    //   239: bipush 101
    //   241: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   244: ifeq +31 -> 275
    //   247: aload_0
    //   248: invokestatic 243	com/tencent/token/acn:a	(Landroid/content/Context;)I
    //   251: ifle +10 -> 261
    //   254: ldc 181
    //   256: astore 8
    //   258: goto +7 -> 265
    //   261: ldc 245
    //   263: astore 8
    //   265: aload 10
    //   267: ldc 247
    //   269: aload 8
    //   271: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: aload 11
    //   277: bipush 102
    //   279: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   282: ifeq +49 -> 331
    //   285: aload_0
    //   286: invokevirtual 253	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   289: ldc 255
    //   291: iconst_0
    //   292: invokestatic 261	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   295: ifeq +8 -> 303
    //   298: iconst_1
    //   299: istore_1
    //   300: goto +5 -> 305
    //   303: iconst_0
    //   304: istore_1
    //   305: iload_1
    //   306: ifeq +10 -> 316
    //   309: ldc 181
    //   311: astore 8
    //   313: goto +7 -> 320
    //   316: ldc 245
    //   318: astore 8
    //   320: aload 10
    //   322: ldc_w 263
    //   325: aload 8
    //   327: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   330: pop
    //   331: aload 11
    //   333: bipush 103
    //   335: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   338: ifeq +36 -> 374
    //   341: new 171	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   348: astore 8
    //   350: aload 8
    //   352: aload_0
    //   353: invokestatic 265	com/tencent/token/ahr:b	(Landroid/content/Context;)I
    //   356: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 10
    //   362: ldc_w 267
    //   365: aload 8
    //   367: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: aload 11
    //   376: bipush 104
    //   378: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   381: ifeq +36 -> 417
    //   384: new 171	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   391: astore 8
    //   393: aload 8
    //   395: aload_0
    //   396: invokestatic 268	com/tencent/token/ahr:a	(Landroid/content/Context;)I
    //   399: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 10
    //   405: ldc_w 270
    //   408: aload 8
    //   410: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   416: pop
    //   417: aload 11
    //   419: bipush 105
    //   421: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   424: ifeq +36 -> 460
    //   427: new 171	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   434: astore 8
    //   436: aload 8
    //   438: aload_0
    //   439: invokestatic 273	com/tencent/token/agr:a	(Landroid/content/Context;)I
    //   442: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 10
    //   448: ldc_w 275
    //   451: aload 8
    //   453: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload 11
    //   462: bipush 106
    //   464: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   467: ifeq +32 -> 499
    //   470: invokestatic 277	com/tencent/token/ahr:d	()Ljava/lang/String;
    //   473: astore 9
    //   475: aload 9
    //   477: astore 8
    //   479: aload 9
    //   481: ifnonnull +7 -> 488
    //   484: ldc 166
    //   486: astore 8
    //   488: aload 10
    //   490: ldc_w 279
    //   493: aload 8
    //   495: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: pop
    //   499: aload 11
    //   501: bipush 115
    //   503: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   506: ifeq +32 -> 538
    //   509: invokestatic 281	com/tencent/token/ahr:e	()Ljava/lang/String;
    //   512: astore 9
    //   514: aload 9
    //   516: astore 8
    //   518: aload 9
    //   520: ifnonnull +7 -> 527
    //   523: ldc 166
    //   525: astore 8
    //   527: aload 10
    //   529: ldc_w 283
    //   532: aload 8
    //   534: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: aload 11
    //   540: bipush 116
    //   542: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   545: ifeq +32 -> 577
    //   548: invokestatic 285	com/tencent/token/ahr:h	()Ljava/lang/String;
    //   551: astore 9
    //   553: aload 9
    //   555: astore 8
    //   557: aload 9
    //   559: ifnonnull +7 -> 566
    //   562: ldc 166
    //   564: astore 8
    //   566: aload 10
    //   568: ldc_w 287
    //   571: aload 8
    //   573: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   576: pop
    //   577: aload 11
    //   579: bipush 107
    //   581: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   584: ifeq +33 -> 617
    //   587: aload_0
    //   588: invokestatic 289	com/tencent/token/ahr:c	(Landroid/content/Context;)Ljava/lang/String;
    //   591: astore 9
    //   593: aload 9
    //   595: astore 8
    //   597: aload 9
    //   599: ifnonnull +7 -> 606
    //   602: ldc 166
    //   604: astore 8
    //   606: aload 10
    //   608: ldc_w 291
    //   611: aload 8
    //   613: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   616: pop
    //   617: aload 11
    //   619: bipush 113
    //   621: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   624: ifeq +31 -> 655
    //   627: invokestatic 293	com/tencent/token/ahr:f	()Z
    //   630: ifeq +10 -> 640
    //   633: ldc 181
    //   635: astore 8
    //   637: goto +7 -> 644
    //   640: ldc 245
    //   642: astore 8
    //   644: aload 10
    //   646: ldc_w 295
    //   649: aload 8
    //   651: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: aload 11
    //   657: bipush 114
    //   659: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   662: ifeq +42 -> 704
    //   665: aload_0
    //   666: invokestatic 298	com/tencent/token/ahr:e	(Landroid/content/Context;)Z
    //   669: istore 7
    //   671: goto +6 -> 677
    //   674: iconst_0
    //   675: istore 7
    //   677: iload 7
    //   679: ifeq +10 -> 689
    //   682: ldc 181
    //   684: astore 8
    //   686: goto +7 -> 693
    //   689: ldc 245
    //   691: astore 8
    //   693: aload 10
    //   695: ldc_w 300
    //   698: aload 8
    //   700: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   703: pop
    //   704: new 171	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   711: astore 8
    //   713: aload 8
    //   715: aload_0
    //   716: invokestatic 302	com/tencent/token/ahr:d	(Landroid/content/Context;)I
    //   719: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 10
    //   725: ldc_w 304
    //   728: aload 8
    //   730: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   736: pop
    //   737: aload 11
    //   739: bipush 44
    //   741: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   744: ifeq +15 -> 759
    //   747: aload 10
    //   749: ldc_w 306
    //   752: invokestatic 308	com/tencent/token/ahr:g	()Ljava/lang/String;
    //   755: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   758: pop
    //   759: aload 11
    //   761: bipush 17
    //   763: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   766: ifeq +253 -> 1019
    //   769: new 310	android/util/SparseArray
    //   772: dup
    //   773: invokespecial 311	android/util/SparseArray:<init>	()V
    //   776: aload_0
    //   777: new 144	java/util/HashMap
    //   780: dup
    //   781: invokespecial 145	java/util/HashMap:<init>	()V
    //   784: iconst_0
    //   785: invokestatic 316	com/tencent/turingfd/sdk/qps/TNative$aa:h	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   788: astore 8
    //   790: aload 8
    //   792: invokestatic 319	com/tencent/token/ahr:a	(Landroid/util/SparseArray;)I
    //   795: ifne +209 -> 1004
    //   798: aload 8
    //   800: sipush 205
    //   803: ldc 115
    //   805: invokestatic 322	com/tencent/token/ahr:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   808: checkcast 115	java/lang/String
    //   811: astore 9
    //   813: aload 9
    //   815: astore 8
    //   817: aload 9
    //   819: ifnonnull +7 -> 826
    //   822: ldc 166
    //   824: astore 8
    //   826: new 171	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   833: astore 9
    //   835: aload 8
    //   837: ldc_w 324
    //   840: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   843: astore 11
    //   845: aload 11
    //   847: arraylength
    //   848: istore_2
    //   849: iconst_0
    //   850: istore_1
    //   851: iload_1
    //   852: iload_2
    //   853: if_icmpge +141 -> 994
    //   856: aload 11
    //   858: iload_1
    //   859: aaload
    //   860: astore 8
    //   862: aload 8
    //   864: ldc_w 330
    //   867: invokevirtual 328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   870: astore 12
    //   872: aload 12
    //   874: iconst_0
    //   875: aaload
    //   876: ldc 245
    //   878: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   881: ifne +106 -> 987
    //   884: aload 9
    //   886: aload 8
    //   888: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 9
    //   894: ldc_w 330
    //   897: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload 12
    //   903: aload 12
    //   905: arraylength
    //   906: iconst_1
    //   907: isub
    //   908: aaload
    //   909: astore 8
    //   911: aload 8
    //   913: invokestatic 340	com/tencent/token/ahr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   916: astore 12
    //   918: getstatic 38	com/tencent/token/aet:b	Landroid/util/LruCache;
    //   921: aload 8
    //   923: invokestatic 340	com/tencent/token/ahr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   926: invokevirtual 341	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   929: ifnull +22 -> 951
    //   932: getstatic 38	com/tencent/token/aet:b	Landroid/util/LruCache;
    //   935: aload 8
    //   937: invokestatic 340	com/tencent/token/ahr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   940: invokevirtual 341	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   943: checkcast 115	java/lang/String
    //   946: astore 8
    //   948: goto +22 -> 970
    //   951: aload_0
    //   952: aload 8
    //   954: invokestatic 345	com/tencent/token/ade:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   957: astore 8
    //   959: getstatic 38	com/tencent/token/aet:b	Landroid/util/LruCache;
    //   962: aload 12
    //   964: aload 8
    //   966: invokevirtual 346	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   969: pop
    //   970: aload 9
    //   972: aload 8
    //   974: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload 9
    //   980: ldc_w 324
    //   983: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: iload_1
    //   988: iconst_1
    //   989: iadd
    //   990: istore_1
    //   991: goto -140 -> 851
    //   994: aload 9
    //   996: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: astore 8
    //   1001: goto +7 -> 1008
    //   1004: ldc 166
    //   1006: astore 8
    //   1008: aload 10
    //   1010: ldc_w 348
    //   1013: aload 8
    //   1015: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1018: pop
    //   1019: new 171	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1026: astore 8
    //   1028: aload 8
    //   1030: aload_0
    //   1031: invokestatic 350	com/tencent/token/ahr:g	(Landroid/content/Context;)I
    //   1034: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 10
    //   1040: ldc_w 352
    //   1043: aload 8
    //   1045: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1051: pop
    //   1052: aload 10
    //   1054: ldc_w 354
    //   1057: aload_0
    //   1058: ldc_w 356
    //   1061: invokestatic 83	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1064: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1067: pop
    //   1068: getstatic 190	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   1071: sipush 10002
    //   1074: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   1077: ifne +14 -> 1091
    //   1080: aload 10
    //   1082: ldc_w 358
    //   1085: ldc 245
    //   1087: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1090: pop
    //   1091: aload 10
    //   1093: ldc_w 360
    //   1096: getstatic 190	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   1099: invokevirtual 362	com/tencent/token/afn:a	()Ljava/lang/String;
    //   1102: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1105: pop
    //   1106: new 171	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1113: astore 8
    //   1115: getstatic 367	com/tencent/token/aeo:b	Lcom/tencent/token/add;
    //   1118: getfield 372	com/tencent/token/add:b	Ljava/util/LinkedList;
    //   1121: invokevirtual 378	java/util/LinkedList:size	()I
    //   1124: istore_2
    //   1125: iconst_0
    //   1126: istore_1
    //   1127: iload_1
    //   1128: iload_2
    //   1129: if_icmpge +72 -> 1201
    //   1132: getstatic 380	com/tencent/token/aeo:a	Lcom/tencent/token/add;
    //   1135: astore 9
    //   1137: aload 9
    //   1139: monitorenter
    //   1140: getstatic 367	com/tencent/token/aeo:b	Lcom/tencent/token/add;
    //   1143: getfield 372	com/tencent/token/add:b	Ljava/util/LinkedList;
    //   1146: invokevirtual 384	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   1149: checkcast 386	com/tencent/token/aeq
    //   1152: astore 11
    //   1154: aload 9
    //   1156: monitorexit
    //   1157: getstatic 389	com/tencent/token/aeo:c	Ljava/util/List;
    //   1160: aload 11
    //   1162: invokeinterface 394 2 0
    //   1167: pop
    //   1168: aload 8
    //   1170: aload 11
    //   1172: invokevirtual 395	com/tencent/token/aeq:a	()Ljava/lang/String;
    //   1175: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 8
    //   1181: ldc_w 397
    //   1184: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: iload_1
    //   1189: iconst_1
    //   1190: iadd
    //   1191: istore_1
    //   1192: goto -65 -> 1127
    //   1195: astore_0
    //   1196: aload 9
    //   1198: monitorexit
    //   1199: aload_0
    //   1200: athrow
    //   1201: getstatic 380	com/tencent/token/aeo:a	Lcom/tencent/token/add;
    //   1204: getfield 372	com/tencent/token/add:b	Ljava/util/LinkedList;
    //   1207: invokevirtual 378	java/util/LinkedList:size	()I
    //   1210: istore_2
    //   1211: iconst_0
    //   1212: istore_1
    //   1213: iload_1
    //   1214: iload_2
    //   1215: if_icmpge +72 -> 1287
    //   1218: getstatic 380	com/tencent/token/aeo:a	Lcom/tencent/token/add;
    //   1221: astore 9
    //   1223: aload 9
    //   1225: monitorenter
    //   1226: getstatic 380	com/tencent/token/aeo:a	Lcom/tencent/token/add;
    //   1229: getfield 372	com/tencent/token/add:b	Ljava/util/LinkedList;
    //   1232: invokevirtual 384	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   1235: checkcast 386	com/tencent/token/aeq
    //   1238: astore 11
    //   1240: aload 9
    //   1242: monitorexit
    //   1243: getstatic 389	com/tencent/token/aeo:c	Ljava/util/List;
    //   1246: aload 11
    //   1248: invokeinterface 394 2 0
    //   1253: pop
    //   1254: aload 8
    //   1256: aload 11
    //   1258: invokevirtual 395	com/tencent/token/aeq:a	()Ljava/lang/String;
    //   1261: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 8
    //   1267: ldc_w 397
    //   1270: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: iload_1
    //   1275: iconst_1
    //   1276: iadd
    //   1277: istore_1
    //   1278: goto -65 -> 1213
    //   1281: astore_0
    //   1282: aload 9
    //   1284: monitorexit
    //   1285: aload_0
    //   1286: athrow
    //   1287: aload 8
    //   1289: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1292: astore 9
    //   1294: aload 9
    //   1296: astore 8
    //   1298: aload 9
    //   1300: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1303: ifeq +8 -> 1311
    //   1306: ldc_w 405
    //   1309: astore 8
    //   1311: aload 10
    //   1313: ldc_w 407
    //   1316: aload 8
    //   1318: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1321: pop
    //   1322: getstatic 203	com/tencent/token/aet:c	Lcom/tencent/token/afu;
    //   1325: getfield 410	com/tencent/token/afu:m	Ljava/util/Map;
    //   1328: astore 8
    //   1330: new 171	java/lang/StringBuilder
    //   1333: dup
    //   1334: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1337: astore 9
    //   1339: aload 8
    //   1341: invokeinterface 414 1 0
    //   1346: invokeinterface 420 1 0
    //   1351: astore 11
    //   1353: aload 11
    //   1355: invokeinterface 425 1 0
    //   1360: ifeq +93 -> 1453
    //   1363: aload 11
    //   1365: invokeinterface 428 1 0
    //   1370: checkcast 117	java/lang/Integer
    //   1373: invokevirtual 431	java/lang/Integer:intValue	()I
    //   1376: istore_1
    //   1377: aload 9
    //   1379: iload_1
    //   1380: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload 9
    //   1386: ldc_w 433
    //   1389: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: pop
    //   1393: aload 9
    //   1395: ldc_w 324
    //   1398: ldc_w 435
    //   1401: ldc_w 433
    //   1404: ldc_w 437
    //   1407: aload 8
    //   1409: iload_1
    //   1410: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1413: invokeinterface 113 2 0
    //   1418: checkcast 115	java/lang/String
    //   1421: invokestatic 443	com/tencent/token/ahr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1424: invokestatic 443	com/tencent/token/ahr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1427: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 11
    //   1433: invokeinterface 425 1 0
    //   1438: ifeq -85 -> 1353
    //   1441: aload 9
    //   1443: ldc_w 324
    //   1446: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: goto -97 -> 1353
    //   1453: aload 10
    //   1455: ldc_w 445
    //   1458: aload 9
    //   1460: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1463: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1466: pop
    //   1467: getstatic 62	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   1470: aload_0
    //   1471: ldc_w 447
    //   1474: iconst_0
    //   1475: invokevirtual 67	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   1478: ifeq +14 -> 1492
    //   1481: aload 10
    //   1483: ldc_w 449
    //   1486: ldc 181
    //   1488: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1491: pop
    //   1492: aload 10
    //   1494: ldc_w 451
    //   1497: aload_0
    //   1498: ldc_w 453
    //   1501: invokestatic 83	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1504: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1507: pop
    //   1508: new 171	java/lang/StringBuilder
    //   1511: dup
    //   1512: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1515: astore 8
    //   1517: aload 8
    //   1519: invokestatic 457	com/tencent/token/ach:b	()Ljava/lang/String;
    //   1522: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 10
    //   1528: ldc_w 459
    //   1531: aload 8
    //   1533: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1539: pop
    //   1540: getstatic 190	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   1543: bipush 120
    //   1545: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   1548: ifeq +35 -> 1583
    //   1551: new 171	java/lang/StringBuilder
    //   1554: dup
    //   1555: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1558: astore 8
    //   1560: aload 8
    //   1562: invokestatic 462	com/tencent/token/ahr:i	()Ljava/lang/String;
    //   1565: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload 10
    //   1571: ldc_w 464
    //   1574: aload 8
    //   1576: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1582: pop
    //   1583: new 310	android/util/SparseArray
    //   1586: dup
    //   1587: invokespecial 311	android/util/SparseArray:<init>	()V
    //   1590: aload_0
    //   1591: aload 10
    //   1593: iconst_1
    //   1594: invokestatic 466	com/tencent/turingfd/sdk/qps/TNative$aa:g	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   1597: astore 8
    //   1599: aload 8
    //   1601: invokestatic 319	com/tencent/token/ahr:a	(Landroid/util/SparseArray;)I
    //   1604: ifeq +11 -> 1615
    //   1607: iconst_0
    //   1608: newarray byte
    //   1610: astore 9
    //   1612: goto +74 -> 1686
    //   1615: aload 8
    //   1617: invokestatic 469	com/tencent/token/ahr:b	(Landroid/util/SparseArray;)[B
    //   1620: astore 9
    //   1622: new 171	java/lang/StringBuilder
    //   1625: dup
    //   1626: ldc_w 471
    //   1629: invokespecial 474	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1632: astore 8
    //   1634: aload 8
    //   1636: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   1639: lload_3
    //   1640: lsub
    //   1641: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1644: pop
    //   1645: aload 8
    //   1647: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1650: astore 8
    //   1652: new 144	java/util/HashMap
    //   1655: dup
    //   1656: invokespecial 145	java/util/HashMap:<init>	()V
    //   1659: astore 10
    //   1661: aload 10
    //   1663: ldc_w 479
    //   1666: aload 8
    //   1668: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1671: pop
    //   1672: aload_0
    //   1673: aload 10
    //   1675: invokestatic 155	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   1678: goto +8 -> 1686
    //   1681: iconst_0
    //   1682: newarray byte
    //   1684: astore 9
    //   1686: aload 9
    //   1688: arraylength
    //   1689: ifne +20 -> 1709
    //   1692: new 139	com/tencent/token/aeu
    //   1695: dup
    //   1696: sipush -1000
    //   1699: ldc 166
    //   1701: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1704: astore 8
    //   1706: goto +239 -> 1945
    //   1709: iconst_0
    //   1710: newarray byte
    //   1712: astore 8
    //   1714: getstatic 203	com/tencent/token/aet:c	Lcom/tencent/token/afu;
    //   1717: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1720: pop
    //   1721: new 481	com/tencent/token/acs
    //   1724: dup
    //   1725: ldc_w 483
    //   1728: invokespecial 484	com/tencent/token/acs:<init>	(Ljava/lang/String;)V
    //   1731: aload 9
    //   1733: invokevirtual 487	com/tencent/token/acs:a	([B)Lcom/tencent/token/acf$a;
    //   1736: astore 10
    //   1738: aload 10
    //   1740: getfield 490	com/tencent/token/acf$a:a	I
    //   1743: istore_1
    //   1744: iload_1
    //   1745: ifeq +22 -> 1767
    //   1748: new 139	com/tencent/token/aeu
    //   1751: dup
    //   1752: iload_1
    //   1753: ldc 166
    //   1755: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1758: astore 10
    //   1760: aload 10
    //   1762: astore 8
    //   1764: goto +181 -> 1945
    //   1767: aload 10
    //   1769: getfield 493	com/tencent/token/acf$a:b	[B
    //   1772: astore 10
    //   1774: aload 10
    //   1776: astore 8
    //   1778: new 495	com/tencent/turingfd/sdk/qps/Haw
    //   1781: dup
    //   1782: invokespecial 496	com/tencent/turingfd/sdk/qps/Haw:<init>	()V
    //   1785: astore 10
    //   1787: aload 10
    //   1789: sipush -999
    //   1792: putfield 498	com/tencent/turingfd/sdk/qps/Haw:b	I
    //   1795: aload 10
    //   1797: aload 8
    //   1799: invokestatic 501	com/tencent/token/ahr:a	(Lcom/tencent/turingfd/sdk/qps/Orion;[B)Lcom/tencent/turingfd/sdk/qps/Orion;
    //   1802: checkcast 495	com/tencent/turingfd/sdk/qps/Haw
    //   1805: astore 8
    //   1807: aload 8
    //   1809: ifnonnull +20 -> 1829
    //   1812: new 139	com/tencent/token/aeu
    //   1815: dup
    //   1816: sipush -1002
    //   1819: ldc 166
    //   1821: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1824: astore 8
    //   1826: goto +119 -> 1945
    //   1829: aload 8
    //   1831: getfield 498	com/tencent/turingfd/sdk/qps/Haw:b	I
    //   1834: ifne +71 -> 1905
    //   1837: getstatic 389	com/tencent/token/aeo:c	Ljava/util/List;
    //   1840: invokeinterface 502 1 0
    //   1845: ifle +11 -> 1856
    //   1848: getstatic 389	com/tencent/token/aeo:c	Ljava/util/List;
    //   1851: invokeinterface 505 1 0
    //   1856: aload 8
    //   1858: getfield 507	com/tencent/turingfd/sdk/qps/Haw:c	Ljava/lang/String;
    //   1861: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1864: ifeq +23 -> 1887
    //   1867: new 139	com/tencent/token/aeu
    //   1870: dup
    //   1871: sipush -1001
    //   1874: aload 8
    //   1876: getfield 507	com/tencent/turingfd/sdk/qps/Haw:c	Ljava/lang/String;
    //   1879: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1882: astore 8
    //   1884: goto +61 -> 1945
    //   1887: new 139	com/tencent/token/aeu
    //   1890: dup
    //   1891: iconst_0
    //   1892: aload 8
    //   1894: getfield 507	com/tencent/turingfd/sdk/qps/Haw:c	Ljava/lang/String;
    //   1897: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1900: astore 8
    //   1902: goto +43 -> 1945
    //   1905: invokestatic 509	com/tencent/token/aeo:a	()V
    //   1908: new 139	com/tencent/token/aeu
    //   1911: dup
    //   1912: sipush -2000
    //   1915: aload 8
    //   1917: getfield 498	com/tencent/turingfd/sdk/qps/Haw:b	I
    //   1920: isub
    //   1921: ldc 166
    //   1923: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1926: astore 8
    //   1928: goto +17 -> 1945
    //   1931: new 139	com/tencent/token/aeu
    //   1934: dup
    //   1935: sipush -999
    //   1938: ldc 166
    //   1940: invokespecial 169	com/tencent/token/aeu:<init>	(ILjava/lang/String;)V
    //   1943: astore 8
    //   1945: new 171	java/lang/StringBuilder
    //   1948: dup
    //   1949: ldc_w 511
    //   1952: invokespecial 474	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1955: astore 11
    //   1957: aload 11
    //   1959: ldc 181
    //   1961: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: pop
    //   1965: aload 11
    //   1967: ldc_w 433
    //   1970: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: pop
    //   1974: lconst_0
    //   1975: lstore_3
    //   1976: getstatic 190	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   1979: bipush 28
    //   1981: invokevirtual 201	com/tencent/token/afn:a	(I)Z
    //   1984: ifeq +17 -> 2001
    //   1987: getstatic 214	com/tencent/token/afc:a	Lcom/tencent/token/afc;
    //   1990: aload_0
    //   1991: iconst_1
    //   1992: iconst_1
    //   1993: invokevirtual 217	com/tencent/token/afc:a	(Landroid/content/Context;ZI)Lcom/tencent/token/aew;
    //   1996: getfield 221	com/tencent/token/aew:d	I
    //   1999: i2l
    //   2000: lstore_3
    //   2001: aload 11
    //   2003: lload_3
    //   2004: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2007: pop
    //   2008: aload 11
    //   2010: ldc_w 433
    //   2013: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: pop
    //   2017: aload 11
    //   2019: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   2022: lload 5
    //   2024: lsub
    //   2025: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2028: pop
    //   2029: aload 11
    //   2031: ldc_w 433
    //   2034: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2037: pop
    //   2038: aload 11
    //   2040: aload 9
    //   2042: arraylength
    //   2043: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2046: pop
    //   2047: aload 11
    //   2049: ldc_w 433
    //   2052: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: pop
    //   2056: getstatic 214	com/tencent/token/afc:a	Lcom/tencent/token/afc;
    //   2059: astore 12
    //   2061: aload 12
    //   2063: aload_0
    //   2064: invokevirtual 514	com/tencent/token/afc:a	(Landroid/content/Context;)Lcom/tencent/token/aew;
    //   2067: astore 10
    //   2069: aload 12
    //   2071: getfield 516	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   2074: ifnonnull +14 -> 2088
    //   2077: sipush -10002
    //   2080: invokestatic 519	com/tencent/token/aew:a	(I)Lcom/tencent/token/aew;
    //   2083: astore 9
    //   2085: goto +59 -> 2144
    //   2088: aload 12
    //   2090: aload 10
    //   2092: invokevirtual 522	com/tencent/token/afc:a	(Lcom/tencent/token/aew;)I
    //   2095: istore_1
    //   2096: aload 10
    //   2098: astore 9
    //   2100: iload_1
    //   2101: iconst_1
    //   2102: if_icmpeq +42 -> 2144
    //   2105: iload_1
    //   2106: iconst_2
    //   2107: if_icmpne +19 -> 2126
    //   2110: aload 12
    //   2112: invokevirtual 523	com/tencent/token/afc:a	()V
    //   2115: sipush -10009
    //   2118: invokestatic 519	com/tencent/token/aew:a	(I)Lcom/tencent/token/aew;
    //   2121: astore 9
    //   2123: goto +21 -> 2144
    //   2126: aload 10
    //   2128: astore 9
    //   2130: iload_1
    //   2131: iconst_3
    //   2132: if_icmpne +12 -> 2144
    //   2135: aload 12
    //   2137: invokevirtual 523	com/tencent/token/afc:a	()V
    //   2140: aload 10
    //   2142: astore 9
    //   2144: aload 11
    //   2146: aload 9
    //   2148: getfield 221	com/tencent/token/aew:d	I
    //   2151: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: aload 11
    //   2157: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: astore 9
    //   2162: getstatic 78	com/tencent/turingfd/sdk/qps/Peach:a	Ljava/lang/String;
    //   2165: astore 10
    //   2167: new 144	java/util/HashMap
    //   2170: dup
    //   2171: invokespecial 145	java/util/HashMap:<init>	()V
    //   2174: astore 10
    //   2176: aload 10
    //   2178: ldc_w 356
    //   2181: aload 9
    //   2183: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2186: pop
    //   2187: aload_0
    //   2188: aload 10
    //   2190: invokestatic 155	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   2193: aload 8
    //   2195: areturn
    //   2196: astore 8
    //   2198: goto -1524 -> 674
    //   2201: astore 8
    //   2203: goto -1199 -> 1004
    //   2206: astore 8
    //   2208: goto -527 -> 1681
    //   2211: astore 10
    //   2213: goto -435 -> 1778
    //   2216: astore 8
    //   2218: goto -287 -> 1931
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2221	0	paramContext	Context
    //   116	2017	1	i	int
    //   848	368	2	j	int
    //   35	1969	3	l1	long
    //   25	1998	5	l2	long
    //   113	565	7	bool	boolean
    //   30	2164	8	localObject1	Object
    //   2196	1	8	localObject2	Object
    //   2201	1	8	localObject3	Object
    //   2206	1	8	localObject4	Object
    //   2216	1	8	localObject5	Object
    //   52	2130	9	localObject6	Object
    //   43	2146	10	localObject7	Object
    //   2211	1	10	localObject8	Object
    //   79	2077	11	localObject9	Object
    //   870	1266	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   1140	1157	1195	finally
    //   1196	1199	1195	finally
    //   1226	1243	1281	finally
    //   1282	1285	1281	finally
    //   665	671	2196	finally
    //   769	790	2201	finally
    //   1583	1599	2206	finally
    //   1714	1721	2211	finally
    //   1721	1744	2211	finally
    //   1748	1760	2211	finally
    //   1767	1774	2211	finally
    //   1778	1807	2216	finally
    //   1812	1826	2216	finally
    //   1829	1856	2216	finally
    //   1856	1884	2216	finally
    //   1887	1902	2216	finally
    //   1905	1928	2216	finally
  }
  
  public static final class a
    extends Handler
  {
    public Context a;
    
    public a(Looper paramLooper, Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {}
      try
      {
        aet.a(this.a);
        label15:
        sendEmptyMessageDelayed(1, aet.f);
        return;
      }
      finally
      {
        break label15;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aet
 * JD-Core Version:    0.7.0.1
 */