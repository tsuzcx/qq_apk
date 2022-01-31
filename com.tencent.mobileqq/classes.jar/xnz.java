import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class xnz
  implements Runnable
{
  public xnz(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: ldc 27
    //   6: iconst_2
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   14: ldc 32
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: ldc 51
    //   31: iconst_2
    //   32: new 29	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   39: ldc 53
    //   41: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   48: invokestatic 59	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   51: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   64: invokestatic 59	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   67: aload_0
    //   68: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   71: invokestatic 65	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:g	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   74: if_icmple +450 -> 524
    //   77: aload_0
    //   78: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   81: aload_0
    //   82: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   85: invokestatic 59	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   88: aload_0
    //   89: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   92: invokestatic 65	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:g	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   95: idiv
    //   96: iconst_1
    //   97: iadd
    //   98: invokestatic 69	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:i	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;I)I
    //   101: pop
    //   102: new 71	java/io/File
    //   105: dup
    //   106: invokestatic 74	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:c	()Ljava/lang/String;
    //   109: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: new 71	java/io/File
    //   117: dup
    //   118: aload_0
    //   119: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   122: invokestatic 80	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   125: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 6
    //   130: aload 6
    //   132: invokevirtual 84	java/io/File:exists	()Z
    //   135: ifne +35 -> 170
    //   138: ldc 51
    //   140: iconst_2
    //   141: new 29	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   148: ldc 86
    //   150: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   157: invokestatic 80	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   160: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: return
    //   170: aload_0
    //   171: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   174: ldc 88
    //   176: invokestatic 92	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   179: pop
    //   180: iconst_0
    //   181: istore_1
    //   182: iload_1
    //   183: aload_0
    //   184: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   187: invokestatic 95	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:h	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   190: if_icmpge +56 -> 246
    //   193: aload_0
    //   194: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   197: new 29	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   204: aload_0
    //   205: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   208: invokestatic 97	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   211: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 99
    //   216: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 6
    //   221: invokevirtual 102	java/io/File:getName	()Ljava/lang/String;
    //   224: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 104
    //   229: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 92	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   238: pop
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: goto -61 -> 182
    //   246: ldc 51
    //   248: iconst_2
    //   249: new 29	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   256: ldc 106
    //   258: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   265: invokestatic 97	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   268: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload 5
    //   279: invokevirtual 84	java/io/File:exists	()Z
    //   282: ifne +585 -> 867
    //   285: ldc 51
    //   287: iconst_2
    //   288: ldc 108
    //   290: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload 5
    //   295: invokevirtual 110	java/io/File:createNewFile	()Z
    //   298: pop
    //   299: new 112	java/io/FileOutputStream
    //   302: dup
    //   303: invokestatic 74	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:c	()Ljava/lang/String;
    //   306: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   309: astore 6
    //   311: aload 6
    //   313: astore 5
    //   315: aload 6
    //   317: aload_0
    //   318: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   321: invokestatic 97	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   324: invokevirtual 119	java/lang/String:getBytes	()[B
    //   327: invokevirtual 123	java/io/FileOutputStream:write	([B)V
    //   330: aload 6
    //   332: astore 5
    //   334: ldc 51
    //   336: iconst_2
    //   337: ldc 125
    //   339: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload 6
    //   344: invokevirtual 128	java/io/FileOutputStream:close	()V
    //   347: ldc 51
    //   349: iconst_2
    //   350: ldc 130
    //   352: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: bipush 8
    //   357: anewarray 115	java/lang/String
    //   360: astore 5
    //   362: aload 5
    //   364: iconst_0
    //   365: ldc 132
    //   367: aastore
    //   368: aload 5
    //   370: iconst_1
    //   371: ldc 134
    //   373: aastore
    //   374: aload 5
    //   376: iconst_2
    //   377: ldc 136
    //   379: aastore
    //   380: aload 5
    //   382: iconst_3
    //   383: invokestatic 74	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:c	()Ljava/lang/String;
    //   386: aastore
    //   387: aload 5
    //   389: iconst_4
    //   390: ldc 138
    //   392: aastore
    //   393: aload 5
    //   395: iconst_5
    //   396: ldc 140
    //   398: aastore
    //   399: aload 5
    //   401: bipush 6
    //   403: ldc 142
    //   405: aastore
    //   406: aload 5
    //   408: bipush 7
    //   410: invokestatic 144	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	()Ljava/lang/String;
    //   413: aastore
    //   414: ldc 51
    //   416: iconst_2
    //   417: aload 5
    //   419: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   422: ldc 51
    //   424: iconst_2
    //   425: new 29	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   432: ldc 149
    //   434: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokestatic 74	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:c	()Ljava/lang/String;
    //   440: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: ldc 51
    //   451: iconst_2
    //   452: new 29	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   459: ldc 151
    //   461: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokestatic 144	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	()Ljava/lang/String;
    //   467: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: iconst_m1
    //   477: istore_1
    //   478: aload 5
    //   480: invokestatic 156	cooperation/qzone/video/QZoneVideoCompressor:a	([Ljava/lang/String;)I
    //   483: istore_2
    //   484: iload_2
    //   485: istore_1
    //   486: aload_0
    //   487: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   490: invokestatic 144	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	()Ljava/lang/String;
    //   493: invokestatic 158	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   496: pop
    //   497: iload_2
    //   498: istore_1
    //   499: ldc 51
    //   501: iconst_2
    //   502: new 29	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   509: ldc 160
    //   511: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iload_1
    //   515: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: bipush 7
    //   526: anewarray 115	java/lang/String
    //   529: dup
    //   530: iconst_0
    //   531: ldc 136
    //   533: aastore
    //   534: dup
    //   535: iconst_1
    //   536: aload_0
    //   537: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   540: invokestatic 162	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   543: aastore
    //   544: dup
    //   545: iconst_2
    //   546: ldc 164
    //   548: aastore
    //   549: dup
    //   550: iconst_3
    //   551: ldc 140
    //   553: aastore
    //   554: dup
    //   555: iconst_4
    //   556: ldc 166
    //   558: aastore
    //   559: dup
    //   560: iconst_5
    //   561: ldc 142
    //   563: aastore
    //   564: dup
    //   565: bipush 6
    //   567: invokestatic 168	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	()Ljava/lang/String;
    //   570: aastore
    //   571: invokestatic 156	cooperation/qzone/video/QZoneVideoCompressor:a	([Ljava/lang/String;)I
    //   574: istore_1
    //   575: iload_1
    //   576: ifne +400 -> 976
    //   579: bipush 12
    //   581: anewarray 115	java/lang/String
    //   584: dup
    //   585: iconst_0
    //   586: ldc 136
    //   588: aastore
    //   589: dup
    //   590: iconst_1
    //   591: invokestatic 168	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:e	()Ljava/lang/String;
    //   594: aastore
    //   595: dup
    //   596: iconst_2
    //   597: ldc 136
    //   599: aastore
    //   600: dup
    //   601: iconst_3
    //   602: aload_0
    //   603: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   606: invokestatic 80	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   609: aastore
    //   610: dup
    //   611: iconst_4
    //   612: ldc 170
    //   614: aastore
    //   615: dup
    //   616: iconst_5
    //   617: new 29	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   624: aload_0
    //   625: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   628: invokestatic 172	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:d	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)I
    //   631: i2l
    //   632: invokestatic 175	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	(J)Ljava/lang/String;
    //   635: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc 88
    //   640: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: aastore
    //   647: dup
    //   648: bipush 6
    //   650: ldc 164
    //   652: aastore
    //   653: dup
    //   654: bipush 7
    //   656: ldc 140
    //   658: aastore
    //   659: dup
    //   660: bipush 8
    //   662: ldc 177
    //   664: aastore
    //   665: dup
    //   666: bipush 9
    //   668: ldc 140
    //   670: aastore
    //   671: dup
    //   672: bipush 10
    //   674: ldc 142
    //   676: aastore
    //   677: dup
    //   678: bipush 11
    //   680: invokestatic 179	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	()Ljava/lang/String;
    //   683: aastore
    //   684: invokestatic 156	cooperation/qzone/video/QZoneVideoCompressor:a	([Ljava/lang/String;)I
    //   687: istore_1
    //   688: new 29	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   695: invokestatic 181	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:g	()Ljava/lang/String;
    //   698: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc 183
    //   703: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   709: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   712: ldc 185
    //   714: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: astore 5
    //   722: new 71	java/io/File
    //   725: dup
    //   726: invokestatic 179	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	()Ljava/lang/String;
    //   729: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   732: new 71	java/io/File
    //   735: dup
    //   736: aload 5
    //   738: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   741: invokestatic 191	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   744: ifeq +224 -> 968
    //   747: ldc 27
    //   749: iconst_2
    //   750: new 29	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   757: ldc 193
    //   759: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   766: invokestatic 162	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	(Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;)Ljava/lang/String;
    //   769: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: ldc 27
    //   780: iconst_2
    //   781: new 29	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   788: ldc 195
    //   790: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   796: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: ldc 27
    //   807: iconst_2
    //   808: new 29	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   815: ldc 197
    //   817: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   823: lload_3
    //   824: lsub
    //   825: invokevirtual 39	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   828: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_0
    //   835: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   838: getfield 200	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:a	Landroid/os/Handler;
    //   841: new 202	xoa
    //   844: dup
    //   845: aload_0
    //   846: iload_1
    //   847: aload 5
    //   849: invokespecial 205	xoa:<init>	(Lxnz;ILjava/lang/String;)V
    //   852: invokevirtual 211	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   855: pop
    //   856: return
    //   857: astore 5
    //   859: aload 5
    //   861: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   864: goto -565 -> 299
    //   867: ldc 51
    //   869: iconst_2
    //   870: ldc 216
    //   872: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: goto -576 -> 299
    //   878: astore 5
    //   880: aload 5
    //   882: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   885: goto -538 -> 347
    //   888: astore 7
    //   890: aconst_null
    //   891: astore 6
    //   893: aload 6
    //   895: astore 5
    //   897: ldc 51
    //   899: iconst_2
    //   900: ldc 218
    //   902: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload 6
    //   907: astore 5
    //   909: aload 7
    //   911: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   914: aload 6
    //   916: invokevirtual 128	java/io/FileOutputStream:close	()V
    //   919: goto -572 -> 347
    //   922: astore 5
    //   924: aload 5
    //   926: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   929: goto -582 -> 347
    //   932: astore 6
    //   934: aconst_null
    //   935: astore 5
    //   937: aload 5
    //   939: invokevirtual 128	java/io/FileOutputStream:close	()V
    //   942: aload 6
    //   944: athrow
    //   945: astore 5
    //   947: aload 5
    //   949: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   952: goto -10 -> 942
    //   955: astore 5
    //   957: ldc 51
    //   959: iconst_2
    //   960: ldc 220
    //   962: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: goto -466 -> 499
    //   968: invokestatic 179	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:f	()Ljava/lang/String;
    //   971: astore 5
    //   973: goto -195 -> 778
    //   976: aload_0
    //   977: getfield 12	xnz:a	Lcom/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity;
    //   980: ldc 224
    //   982: iconst_1
    //   983: invokestatic 229	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   986: invokevirtual 232	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   989: pop
    //   990: ldc 27
    //   992: iconst_2
    //   993: new 29	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1000: ldc 234
    //   1002: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: iload_1
    //   1006: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: return
    //   1016: astore 6
    //   1018: goto -81 -> 937
    //   1021: astore 7
    //   1023: goto -130 -> 893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1026	0	this	xnz
    //   181	825	1	i	int
    //   483	15	2	j	int
    //   3	821	3	l	long
    //   112	736	5	localObject1	Object
    //   857	3	5	localException1	java.lang.Exception
    //   878	3	5	localException2	java.lang.Exception
    //   895	13	5	localObject2	Object
    //   922	3	5	localException3	java.lang.Exception
    //   935	3	5	localObject3	Object
    //   945	3	5	localException4	java.lang.Exception
    //   955	1	5	localException5	java.lang.Exception
    //   971	1	5	str	java.lang.String
    //   128	787	6	localObject4	Object
    //   932	11	6	localObject5	Object
    //   1016	1	6	localObject6	Object
    //   888	22	7	localException6	java.lang.Exception
    //   1021	1	7	localException7	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   285	299	857	java/lang/Exception
    //   342	347	878	java/lang/Exception
    //   299	311	888	java/lang/Exception
    //   914	919	922	java/lang/Exception
    //   299	311	932	finally
    //   937	942	945	java/lang/Exception
    //   478	484	955	java/lang/Exception
    //   486	497	955	java/lang/Exception
    //   315	330	1016	finally
    //   334	342	1016	finally
    //   897	905	1016	finally
    //   909	914	1016	finally
    //   315	330	1021	java/lang/Exception
    //   334	342	1021	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */