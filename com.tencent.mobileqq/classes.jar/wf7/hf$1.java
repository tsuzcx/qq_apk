package wf7;

import android.os.Handler;
import android.os.Looper;

class hf$1
  extends Handler
{
  hf$1(hf paramhf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: getfield 24	android/os/Message:what	I
    //   8: tableswitch	default:+40 -> 48, 1:+41->49, 2:+706->714, 3:+851->859, 4:+937->945, 5:+987->995, 6:+1036->1044
    //   49: invokestatic 30	java/lang/System:currentTimeMillis	()J
    //   52: aload_0
    //   53: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   56: invokestatic 36	wf7/hf:a	(Lwf7/hf;)J
    //   59: lsub
    //   60: invokestatic 42	java/lang/Math:abs	(J)J
    //   63: lstore 5
    //   65: lload 5
    //   67: aload_0
    //   68: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   71: invokestatic 45	wf7/hf:b	(Lwf7/hf;)J
    //   74: lcmp
    //   75: ifge +41 -> 116
    //   78: aload_0
    //   79: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   82: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   85: iconst_1
    //   86: invokevirtual 53	android/os/Handler:removeMessages	(I)V
    //   89: aload_0
    //   90: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   93: invokestatic 45	wf7/hf:b	(Lwf7/hf;)J
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   102: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   105: iconst_1
    //   106: lload 7
    //   108: lload 5
    //   110: lsub
    //   111: invokevirtual 57	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   114: pop
    //   115: return
    //   116: lload 5
    //   118: aload_0
    //   119: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   122: invokestatic 45	wf7/hf:b	(Lwf7/hf;)J
    //   125: lsub
    //   126: getstatic 63	java/util/concurrent/TimeUnit:MINUTES	Ljava/util/concurrent/TimeUnit;
    //   129: lconst_1
    //   130: invokevirtual 66	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   133: lcmp
    //   134: ifle +219 -> 353
    //   137: aload_0
    //   138: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   141: getstatic 69	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   144: ldc2_w 70
    //   147: invokevirtual 66	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   150: invokestatic 74	wf7/hf:a	(Lwf7/hf;J)J
    //   153: pop2
    //   154: aload_0
    //   155: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   158: invokestatic 30	java/lang/System:currentTimeMillis	()J
    //   161: invokestatic 76	wf7/hf:b	(Lwf7/hf;J)J
    //   164: pop2
    //   165: new 78	java/util/HashSet
    //   168: dup
    //   169: invokespecial 81	java/util/HashSet:<init>	()V
    //   172: astore_1
    //   173: new 83	wf7/i
    //   176: dup
    //   177: invokespecial 84	wf7/i:<init>	()V
    //   180: astore 9
    //   182: aload 9
    //   184: new 86	java/util/ArrayList
    //   187: dup
    //   188: invokespecial 87	java/util/ArrayList:<init>	()V
    //   191: putfield 91	wf7/i:aE	Ljava/util/ArrayList;
    //   194: aload_0
    //   195: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   198: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   201: invokevirtual 101	wf7/he:getAll	()Ljava/util/Map;
    //   204: invokeinterface 107 1 0
    //   209: invokeinterface 113 1 0
    //   214: astore 10
    //   216: iconst_0
    //   217: istore_2
    //   218: aload 10
    //   220: invokeinterface 119 1 0
    //   225: ifeq +207 -> 432
    //   228: aload 10
    //   230: invokeinterface 123 1 0
    //   235: checkcast 125	java/util/Map$Entry
    //   238: astore 12
    //   240: aload 12
    //   242: invokeinterface 128 1 0
    //   247: checkcast 130	java/lang/String
    //   250: astore 11
    //   252: aload 12
    //   254: invokeinterface 133 1 0
    //   259: checkcast 135	wf7/j
    //   262: astore 12
    //   264: new 137	wf7/k
    //   267: dup
    //   268: invokespecial 138	wf7/k:<init>	()V
    //   271: astore 13
    //   273: aload 13
    //   275: aload 12
    //   277: getfield 141	wf7/j:aG	I
    //   280: putfield 142	wf7/k:aG	I
    //   283: aload 13
    //   285: aload 12
    //   287: getfield 145	wf7/j:aH	I
    //   290: putfield 146	wf7/k:aH	I
    //   293: aload 13
    //   295: aload 12
    //   297: getfield 149	wf7/j:count	I
    //   300: putfield 150	wf7/k:count	I
    //   303: aload 13
    //   305: aload 12
    //   307: getfield 153	wf7/j:aI	Ljava/util/ArrayList;
    //   310: putfield 154	wf7/k:aI	Ljava/util/ArrayList;
    //   313: aload 13
    //   315: aload 12
    //   317: getfield 157	wf7/j:aJ	Ljava/util/ArrayList;
    //   320: putfield 158	wf7/k:aJ	Ljava/util/ArrayList;
    //   323: aload 13
    //   325: invokevirtual 162	wf7/k:toByteArray	()[B
    //   328: arraylength
    //   329: istore 4
    //   331: iload 4
    //   333: ldc 163
    //   335: if_icmple +60 -> 395
    //   338: aload_0
    //   339: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   342: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   345: aload 11
    //   347: invokevirtual 167	wf7/he:remove	(Ljava/lang/String;)V
    //   350: goto -132 -> 218
    //   353: aload_0
    //   354: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   357: invokestatic 45	wf7/hf:b	(Lwf7/hf;)J
    //   360: invokestatic 170	wf7/hf:fn	()J
    //   363: lcmp
    //   364: ifge -210 -> 154
    //   367: aload_0
    //   368: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   371: aload_0
    //   372: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   375: invokestatic 45	wf7/hf:b	(Lwf7/hf;)J
    //   378: getstatic 69	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   381: ldc2_w 70
    //   384: invokevirtual 66	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   387: ladd
    //   388: invokestatic 74	wf7/hf:a	(Lwf7/hf;J)J
    //   391: pop2
    //   392: goto -238 -> 154
    //   395: iload_2
    //   396: iload 4
    //   398: iadd
    //   399: ldc 163
    //   401: if_icmpgt -183 -> 218
    //   404: aload_1
    //   405: aload 11
    //   407: invokeinterface 174 2 0
    //   412: pop
    //   413: aload 9
    //   415: getfield 91	wf7/i:aE	Ljava/util/ArrayList;
    //   418: aload 13
    //   420: invokevirtual 175	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   423: pop
    //   424: iload 4
    //   426: iload_2
    //   427: iadd
    //   428: istore_2
    //   429: goto -211 -> 218
    //   432: aload 9
    //   434: getfield 91	wf7/i:aE	Ljava/util/ArrayList;
    //   437: invokevirtual 179	java/util/ArrayList:size	()I
    //   440: ifle +30 -> 470
    //   443: aload_0
    //   444: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   447: invokestatic 183	wf7/hf:e	(Lwf7/hf;)Lcom/tencent/wifisdk/services/common/api/b;
    //   450: sipush 3651
    //   453: aload 9
    //   455: aconst_null
    //   456: new 185	wf7/hf$1$1
    //   459: dup
    //   460: aload_0
    //   461: aload_1
    //   462: invokespecial 188	wf7/hf$1$1:<init>	(Lwf7/hf$1;Ljava/util/Set;)V
    //   465: invokeinterface 193 5 0
    //   470: aload_0
    //   471: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   474: invokestatic 197	wf7/hf:f	(Lwf7/hf;)Lwf7/hg;
    //   477: invokevirtual 200	wf7/hg:getAll	()Ljava/util/Map;
    //   480: astore_1
    //   481: new 202	android/util/SparseArray
    //   484: dup
    //   485: invokespecial 203	android/util/SparseArray:<init>	()V
    //   488: astore 10
    //   490: aload_1
    //   491: invokeinterface 107 1 0
    //   496: invokeinterface 113 1 0
    //   501: astore 12
    //   503: new 78	java/util/HashSet
    //   506: dup
    //   507: invokespecial 81	java/util/HashSet:<init>	()V
    //   510: astore 11
    //   512: iconst_0
    //   513: istore_2
    //   514: aload 12
    //   516: invokeinterface 119 1 0
    //   521: ifeq +126 -> 647
    //   524: aload 12
    //   526: invokeinterface 123 1 0
    //   531: checkcast 125	java/util/Map$Entry
    //   534: astore 13
    //   536: aload 13
    //   538: invokeinterface 133 1 0
    //   543: checkcast 205	wf7/hg$a
    //   546: astore 14
    //   548: aload 14
    //   550: getfield 208	wf7/hg$a:td	I
    //   553: istore 4
    //   555: aload 10
    //   557: iload 4
    //   559: invokevirtual 212	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   562: checkcast 214	wf7/p
    //   565: astore 9
    //   567: aload 9
    //   569: astore_1
    //   570: aload 9
    //   572: ifnonnull +36 -> 608
    //   575: new 214	wf7/p
    //   578: dup
    //   579: invokespecial 215	wf7/p:<init>	()V
    //   582: astore_1
    //   583: aload_1
    //   584: iload 4
    //   586: putfield 218	wf7/p:bK	I
    //   589: aload_1
    //   590: new 86	java/util/ArrayList
    //   593: dup
    //   594: invokespecial 87	java/util/ArrayList:<init>	()V
    //   597: putfield 221	wf7/p:bL	Ljava/util/ArrayList;
    //   600: aload 10
    //   602: iload 4
    //   604: aload_1
    //   605: invokevirtual 225	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   608: aload_1
    //   609: getfield 221	wf7/p:bL	Ljava/util/ArrayList;
    //   612: aload 14
    //   614: getfield 229	wf7/hg$a:te	Lwf7/q;
    //   617: invokevirtual 175	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   620: pop
    //   621: iload_2
    //   622: iconst_1
    //   623: iadd
    //   624: istore_2
    //   625: aload 11
    //   627: aload 13
    //   629: invokeinterface 128 1 0
    //   634: invokeinterface 174 2 0
    //   639: pop
    //   640: iload_2
    //   641: sipush 200
    //   644: if_icmplt +67 -> 711
    //   647: aload 10
    //   649: invokevirtual 230	android/util/SparseArray:size	()I
    //   652: istore 4
    //   654: iload 4
    //   656: ifle -608 -> 48
    //   659: iload_3
    //   660: istore_2
    //   661: iload_2
    //   662: iload 4
    //   664: if_icmpge -616 -> 48
    //   667: aload 10
    //   669: iload_2
    //   670: invokevirtual 233	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   673: checkcast 214	wf7/p
    //   676: astore_1
    //   677: aload_0
    //   678: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   681: invokestatic 183	wf7/hf:e	(Lwf7/hf;)Lcom/tencent/wifisdk/services/common/api/b;
    //   684: sipush 4060
    //   687: aload_1
    //   688: aconst_null
    //   689: new 235	wf7/hf$1$2
    //   692: dup
    //   693: aload_0
    //   694: aload 11
    //   696: invokespecial 236	wf7/hf$1$2:<init>	(Lwf7/hf$1;Ljava/util/Set;)V
    //   699: invokeinterface 193 5 0
    //   704: iload_2
    //   705: iconst_1
    //   706: iadd
    //   707: istore_2
    //   708: goto -47 -> 661
    //   711: goto -197 -> 514
    //   714: aload_1
    //   715: getfield 240	android/os/Message:obj	Ljava/lang/Object;
    //   718: checkcast 135	wf7/j
    //   721: astore_1
    //   722: aload_1
    //   723: getfield 243	wf7/j:aK	I
    //   726: bipush 8
    //   728: if_icmpne +5 -> 733
    //   731: iconst_1
    //   732: istore_2
    //   733: iload_2
    //   734: ifeq +90 -> 824
    //   737: aload_0
    //   738: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   741: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   744: invokevirtual 101	wf7/he:getAll	()Ljava/util/Map;
    //   747: invokeinterface 107 1 0
    //   752: invokeinterface 113 1 0
    //   757: astore 9
    //   759: aload 9
    //   761: invokeinterface 119 1 0
    //   766: ifeq +58 -> 824
    //   769: aload 9
    //   771: invokeinterface 123 1 0
    //   776: checkcast 125	java/util/Map$Entry
    //   779: astore 10
    //   781: aload 10
    //   783: invokeinterface 133 1 0
    //   788: checkcast 135	wf7/j
    //   791: getfield 141	wf7/j:aG	I
    //   794: aload_1
    //   795: getfield 141	wf7/j:aG	I
    //   798: if_icmpne -39 -> 759
    //   801: aload_0
    //   802: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   805: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   808: aload 10
    //   810: invokeinterface 128 1 0
    //   815: checkcast 130	java/lang/String
    //   818: invokevirtual 167	wf7/he:remove	(Ljava/lang/String;)V
    //   821: goto -62 -> 759
    //   824: aload_0
    //   825: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   828: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   831: aload_1
    //   832: invokevirtual 246	wf7/he:a	(Lwf7/j;)V
    //   835: aload_0
    //   836: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   839: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   842: iconst_1
    //   843: invokevirtual 53	android/os/Handler:removeMessages	(I)V
    //   846: aload_0
    //   847: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   850: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   853: iconst_1
    //   854: invokevirtual 250	android/os/Handler:sendEmptyMessage	(I)Z
    //   857: pop
    //   858: return
    //   859: aload_1
    //   860: getfield 253	android/os/Message:arg1	I
    //   863: istore_2
    //   864: aload_0
    //   865: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   868: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   871: invokevirtual 101	wf7/he:getAll	()Ljava/util/Map;
    //   874: invokeinterface 107 1 0
    //   879: invokeinterface 113 1 0
    //   884: astore_1
    //   885: aload_1
    //   886: invokeinterface 119 1 0
    //   891: ifeq -843 -> 48
    //   894: aload_1
    //   895: invokeinterface 123 1 0
    //   900: checkcast 125	java/util/Map$Entry
    //   903: astore 9
    //   905: aload 9
    //   907: invokeinterface 133 1 0
    //   912: checkcast 135	wf7/j
    //   915: getfield 141	wf7/j:aG	I
    //   918: iload_2
    //   919: if_icmpne -34 -> 885
    //   922: aload_0
    //   923: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   926: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   929: aload 9
    //   931: invokeinterface 128 1 0
    //   936: checkcast 130	java/lang/String
    //   939: invokevirtual 167	wf7/he:remove	(Ljava/lang/String;)V
    //   942: goto -57 -> 885
    //   945: aload_1
    //   946: getfield 240	android/os/Message:obj	Ljava/lang/Object;
    //   949: checkcast 109	java/util/Set
    //   952: invokeinterface 113 1 0
    //   957: astore_1
    //   958: aload_1
    //   959: invokeinterface 119 1 0
    //   964: ifeq -916 -> 48
    //   967: aload_1
    //   968: invokeinterface 123 1 0
    //   973: checkcast 130	java/lang/String
    //   976: astore 9
    //   978: aload_0
    //   979: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   982: invokestatic 95	wf7/hf:d	(Lwf7/hf;)Lwf7/he;
    //   985: aload 9
    //   987: invokevirtual 167	wf7/he:remove	(Ljava/lang/String;)V
    //   990: goto -32 -> 958
    //   993: astore_1
    //   994: return
    //   995: aload_1
    //   996: getfield 253	android/os/Message:arg1	I
    //   999: istore_2
    //   1000: aload_1
    //   1001: getfield 240	android/os/Message:obj	Ljava/lang/Object;
    //   1004: checkcast 255	wf7/q
    //   1007: astore_1
    //   1008: aload_0
    //   1009: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   1012: invokestatic 197	wf7/hf:f	(Lwf7/hf;)Lwf7/hg;
    //   1015: iload_2
    //   1016: aload_1
    //   1017: invokevirtual 258	wf7/hg:b	(ILwf7/q;)V
    //   1020: aload_0
    //   1021: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   1024: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   1027: iconst_1
    //   1028: invokevirtual 53	android/os/Handler:removeMessages	(I)V
    //   1031: aload_0
    //   1032: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   1035: invokestatic 49	wf7/hf:c	(Lwf7/hf;)Landroid/os/Handler;
    //   1038: iconst_1
    //   1039: invokevirtual 250	android/os/Handler:sendEmptyMessage	(I)Z
    //   1042: pop
    //   1043: return
    //   1044: aload_1
    //   1045: getfield 240	android/os/Message:obj	Ljava/lang/Object;
    //   1048: checkcast 109	java/util/Set
    //   1051: invokeinterface 113 1 0
    //   1056: astore_1
    //   1057: aload_1
    //   1058: invokeinterface 119 1 0
    //   1063: ifeq -1015 -> 48
    //   1066: aload_1
    //   1067: invokeinterface 123 1 0
    //   1072: checkcast 130	java/lang/String
    //   1075: astore 9
    //   1077: aload_0
    //   1078: getfield 10	wf7/hf$1:sZ	Lwf7/hf;
    //   1081: invokestatic 197	wf7/hf:f	(Lwf7/hf;)Lwf7/hg;
    //   1084: aload 9
    //   1086: invokevirtual 259	wf7/hg:remove	(Ljava/lang/String;)V
    //   1089: goto -32 -> 1057
    //   1092: astore_1
    //   1093: return
    //   1094: astore_1
    //   1095: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1096	0	this	1
    //   0	1096	1	paramMessage	android.os.Message
    //   1	1015	2	i	int
    //   3	657	3	j	int
    //   329	336	4	k	int
    //   63	54	5	l1	long
    //   96	11	7	l2	long
    //   180	905	9	localObject1	java.lang.Object
    //   214	595	10	localObject2	java.lang.Object
    //   250	445	11	localObject3	java.lang.Object
    //   238	287	12	localObject4	java.lang.Object
    //   271	357	13	localObject5	java.lang.Object
    //   546	67	14	locala	hg.a
    // Exception table:
    //   from	to	target	type
    //   945	958	993	java/lang/Throwable
    //   958	990	993	java/lang/Throwable
    //   1044	1057	1092	java/lang/Throwable
    //   1057	1089	1092	java/lang/Throwable
    //   714	722	1094	java/lang/Throwable
    //   722	731	1094	java/lang/Throwable
    //   737	759	1094	java/lang/Throwable
    //   759	821	1094	java/lang/Throwable
    //   824	858	1094	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.hf.1
 * JD-Core Version:    0.7.0.1
 */