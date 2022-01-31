package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownloadThumbnail
  extends TroopFileTransferManager.Task
{
  public int f = 0;
  
  public TroopFileTransferManager$TaskHttpDownloadThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 4);
    this.f = paramInt;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 35
    //   8: iconst_4
    //   9: ldc 37
    //   11: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 43	java/io/File
    //   17: dup
    //   18: getstatic 49	com/tencent/mobileqq/app/AppConstants:av	Ljava/lang/String;
    //   21: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 55	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 5
    //   36: invokevirtual 58	java/io/File:mkdir	()Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   48: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   51: aload_0
    //   52: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   55: invokevirtual 74	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   58: astore 9
    //   60: new 76	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   67: aload 9
    //   69: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 84
    //   74: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 10
    //   82: iconst_0
    //   83: istore_1
    //   84: new 76	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   91: ldc 90
    //   93: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   100: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   103: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 95
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   115: getfield 98	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 100
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   130: getfield 103	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 105
    //   138: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   145: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 110
    //   150: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   157: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: ldc 112
    //   162: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 5
    //   170: new 114	java/net/URL
    //   173: dup
    //   174: aload 5
    //   176: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   179: astore 11
    //   181: iload_1
    //   182: sipush 1000
    //   185: imul
    //   186: i2l
    //   187: lstore_3
    //   188: lload_3
    //   189: invokestatic 121	java/lang/Thread:sleep	(J)V
    //   192: new 43	java/io/File
    //   195: dup
    //   196: aload 10
    //   198: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 124	java/io/File:delete	()Z
    //   208: pop
    //   209: iload_1
    //   210: iconst_1
    //   211: iadd
    //   212: istore_1
    //   213: iload_1
    //   214: iconst_3
    //   215: if_icmple +121 -> 336
    //   218: aload_0
    //   219: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   222: sipush 128
    //   225: if_icmpne +92 -> 317
    //   228: aload_0
    //   229: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   232: iconst_0
    //   233: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   236: return
    //   237: astore 5
    //   239: aload_0
    //   240: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   243: sipush 128
    //   246: if_icmpne +12 -> 258
    //   249: aload_0
    //   250: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   253: iconst_0
    //   254: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   257: return
    //   258: aload_0
    //   259: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   262: sipush 640
    //   265: if_icmpne -29 -> 236
    //   268: aload_0
    //   269: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   272: iconst_0
    //   273: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   276: return
    //   277: astore 5
    //   279: aload_0
    //   280: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   283: sipush 128
    //   286: if_icmpne +12 -> 298
    //   289: aload_0
    //   290: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: iconst_0
    //   294: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   297: return
    //   298: aload_0
    //   299: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   302: sipush 640
    //   305: if_icmpne -69 -> 236
    //   308: aload_0
    //   309: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   312: iconst_0
    //   313: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   316: return
    //   317: aload_0
    //   318: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   321: sipush 640
    //   324: if_icmpne -88 -> 236
    //   327: aload_0
    //   328: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   331: iconst_0
    //   332: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   335: return
    //   336: aload 8
    //   338: invokevirtual 134	java/io/File:createNewFile	()Z
    //   341: pop
    //   342: aconst_null
    //   343: astore 7
    //   345: aload 11
    //   347: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   350: checkcast 140	java/net/HttpURLConnection
    //   353: astore 5
    //   355: aload 5
    //   357: sipush 30000
    //   360: invokevirtual 144	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   363: aload 5
    //   365: ldc 146
    //   367: invokevirtual 149	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   370: aload 5
    //   372: ldc 151
    //   374: ldc 153
    //   376: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 5
    //   381: ldc 159
    //   383: ldc 161
    //   385: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload 5
    //   390: ldc 163
    //   392: new 76	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   399: ldc 165
    //   401: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   408: getfield 168	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   411: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload 5
    //   422: invokevirtual 172	java/net/HttpURLConnection:getResponseCode	()I
    //   425: sipush 200
    //   428: if_icmpeq +14 -> 442
    //   431: aload 5
    //   433: invokevirtual 172	java/net/HttpURLConnection:getResponseCode	()I
    //   436: sipush 206
    //   439: if_icmpne +497 -> 936
    //   442: aload 5
    //   444: invokevirtual 176	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   447: astore 12
    //   449: new 178	java/io/FileOutputStream
    //   452: dup
    //   453: aload 8
    //   455: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   458: astore 7
    //   460: sipush 4096
    //   463: newarray byte
    //   465: astore 6
    //   467: aload 12
    //   469: aload 6
    //   471: invokevirtual 187	java/io/InputStream:read	([B)I
    //   474: istore_2
    //   475: iload_2
    //   476: iconst_m1
    //   477: if_icmpeq +238 -> 715
    //   480: aload 7
    //   482: aload 6
    //   484: iconst_0
    //   485: iload_2
    //   486: invokevirtual 191	java/io/FileOutputStream:write	([BII)V
    //   489: aload_0
    //   490: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   493: iconst_1
    //   494: iload_2
    //   495: i2l
    //   496: invokevirtual 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   499: iconst_0
    //   500: istore_1
    //   501: goto -34 -> 467
    //   504: astore 5
    //   506: aload_0
    //   507: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   510: sipush 128
    //   513: if_icmpne +12 -> 525
    //   516: aload_0
    //   517: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   520: iconst_0
    //   521: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   524: return
    //   525: aload_0
    //   526: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   529: sipush 640
    //   532: if_icmpne -296 -> 236
    //   535: aload_0
    //   536: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   539: iconst_0
    //   540: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   543: return
    //   544: astore 6
    //   546: aload_0
    //   547: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   550: sipush 128
    //   553: if_icmpne +28 -> 581
    //   556: aload_0
    //   557: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   560: iconst_0
    //   561: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   564: aload 5
    //   566: ifnull +8 -> 574
    //   569: aload 5
    //   571: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   574: aload 8
    //   576: invokevirtual 124	java/io/File:delete	()Z
    //   579: pop
    //   580: return
    //   581: aload_0
    //   582: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   585: sipush 640
    //   588: if_icmpne -24 -> 564
    //   591: aload_0
    //   592: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   595: iconst_0
    //   596: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   599: goto -35 -> 564
    //   602: astore 6
    //   604: aload 5
    //   606: ifnull +8 -> 614
    //   609: aload 5
    //   611: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   614: aload 8
    //   616: invokevirtual 124	java/io/File:delete	()Z
    //   619: pop
    //   620: goto -439 -> 181
    //   623: astore 6
    //   625: aload_0
    //   626: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   629: sipush 128
    //   632: if_icmpne +38 -> 670
    //   635: aload_0
    //   636: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   639: iconst_0
    //   640: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   643: aload 12
    //   645: invokevirtual 200	java/io/InputStream:close	()V
    //   648: aload 7
    //   650: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   653: aload 5
    //   655: ifnull +8 -> 663
    //   658: aload 5
    //   660: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   663: aload 8
    //   665: invokevirtual 124	java/io/File:delete	()Z
    //   668: pop
    //   669: return
    //   670: aload_0
    //   671: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   674: sipush 640
    //   677: if_icmpne -34 -> 643
    //   680: aload_0
    //   681: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   684: iconst_0
    //   685: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   688: goto -45 -> 643
    //   691: astore 6
    //   693: aload 12
    //   695: invokevirtual 200	java/io/InputStream:close	()V
    //   698: aload 7
    //   700: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   703: iload_1
    //   704: istore_2
    //   705: aload 6
    //   707: athrow
    //   708: astore 6
    //   710: iload_2
    //   711: istore_1
    //   712: goto -108 -> 604
    //   715: aload 12
    //   717: invokevirtual 200	java/io/InputStream:close	()V
    //   720: aload 7
    //   722: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   725: iload_1
    //   726: istore_2
    //   727: new 43	java/io/File
    //   730: dup
    //   731: aload 10
    //   733: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   736: astore 6
    //   738: iload_1
    //   739: istore_2
    //   740: aload 6
    //   742: new 43	java/io/File
    //   745: dup
    //   746: aload 9
    //   748: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   751: invokevirtual 205	java/io/File:renameTo	(Ljava/io/File;)Z
    //   754: pop
    //   755: iload_1
    //   756: istore_2
    //   757: aload 6
    //   759: invokevirtual 208	java/io/File:deleteOnExit	()V
    //   762: iload_1
    //   763: istore_2
    //   764: aload_0
    //   765: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   768: astore 6
    //   770: iload_1
    //   771: istore_2
    //   772: aload 6
    //   774: monitorenter
    //   775: aload_0
    //   776: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   779: sipush 128
    //   782: if_icmpne +87 -> 869
    //   785: aload_0
    //   786: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   789: iconst_0
    //   790: putfield 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   793: aload_0
    //   794: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   797: aload_0
    //   798: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   801: sipush 128
    //   804: invokevirtual 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   807: pop
    //   808: aload_0
    //   809: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   812: lconst_0
    //   813: putfield 214	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   816: aload_0
    //   817: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   820: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Ljava/util/Map;
    //   823: aload_0
    //   824: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   827: getfield 221	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   830: invokeinterface 227 2 0
    //   835: ifeq +14 -> 849
    //   838: aload_0
    //   839: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   842: aload_0
    //   843: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   846: invokevirtual 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   849: aload 6
    //   851: monitorexit
    //   852: aload 5
    //   854: ifnull +8 -> 862
    //   857: aload 5
    //   859: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   862: aload 8
    //   864: invokevirtual 124	java/io/File:delete	()Z
    //   867: pop
    //   868: return
    //   869: aload_0
    //   870: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   873: sipush 640
    //   876: if_icmpne -68 -> 808
    //   879: aload_0
    //   880: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   883: iconst_0
    //   884: putfield 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   887: aload_0
    //   888: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   891: aload_0
    //   892: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   895: sipush 640
    //   898: invokevirtual 211	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   901: pop
    //   902: goto -94 -> 808
    //   905: astore 7
    //   907: aload 6
    //   909: monitorexit
    //   910: iload_1
    //   911: istore_2
    //   912: aload 7
    //   914: athrow
    //   915: astore 6
    //   917: aload 5
    //   919: ifnull +8 -> 927
    //   922: aload 5
    //   924: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   927: aload 8
    //   929: invokevirtual 124	java/io/File:delete	()Z
    //   932: pop
    //   933: aload 6
    //   935: athrow
    //   936: aload 5
    //   938: ifnull +8 -> 946
    //   941: aload 5
    //   943: invokevirtual 197	java/net/HttpURLConnection:disconnect	()V
    //   946: aload 8
    //   948: invokevirtual 124	java/io/File:delete	()Z
    //   951: pop
    //   952: goto -771 -> 181
    //   955: astore 6
    //   957: goto -309 -> 648
    //   960: astore 6
    //   962: goto -309 -> 653
    //   965: astore 6
    //   967: goto -247 -> 720
    //   970: astore 6
    //   972: goto -247 -> 725
    //   975: astore 12
    //   977: goto -279 -> 698
    //   980: astore 7
    //   982: goto -279 -> 703
    //   985: astore 6
    //   987: aload 7
    //   989: astore 5
    //   991: goto -74 -> 917
    //   994: astore 5
    //   996: aconst_null
    //   997: astore 5
    //   999: goto -395 -> 604
    //   1002: astore 6
    //   1004: goto -311 -> 693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	TaskHttpDownloadThumbnail
    //   83	828	1	i	int
    //   474	438	2	j	int
    //   187	2	3	l	long
    //   24	151	5	localObject1	java.lang.Object
    //   237	1	5	localMalformedURLException	java.net.MalformedURLException
    //   277	1	5	localInterruptedException	java.lang.InterruptedException
    //   353	90	5	localHttpURLConnection	java.net.HttpURLConnection
    //   504	438	5	localIOException1	java.io.IOException
    //   989	1	5	localObject2	java.lang.Object
    //   994	1	5	localIOException2	java.io.IOException
    //   997	1	5	localObject3	java.lang.Object
    //   465	18	6	arrayOfByte	byte[]
    //   544	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   602	1	6	localIOException3	java.io.IOException
    //   623	1	6	localIOException4	java.io.IOException
    //   691	15	6	localObject4	java.lang.Object
    //   708	1	6	localIOException5	java.io.IOException
    //   736	172	6	localObject5	java.lang.Object
    //   915	19	6	localObject6	java.lang.Object
    //   955	1	6	localIOException6	java.io.IOException
    //   960	1	6	localIOException7	java.io.IOException
    //   965	1	6	localIOException8	java.io.IOException
    //   970	1	6	localIOException9	java.io.IOException
    //   985	1	6	localObject7	java.lang.Object
    //   1002	1	6	localObject8	java.lang.Object
    //   343	378	7	localFileOutputStream	java.io.FileOutputStream
    //   905	8	7	localObject9	java.lang.Object
    //   980	8	7	localIOException10	java.io.IOException
    //   201	746	8	localFile	java.io.File
    //   58	689	9	str1	java.lang.String
    //   80	652	10	str2	java.lang.String
    //   179	167	11	localURL	java.net.URL
    //   447	269	12	localInputStream	java.io.InputStream
    //   975	1	12	localIOException11	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   170	181	237	java/net/MalformedURLException
    //   188	192	277	java/lang/InterruptedException
    //   336	342	504	java/io/IOException
    //   449	460	544	java/io/FileNotFoundException
    //   355	442	602	java/io/IOException
    //   442	449	602	java/io/IOException
    //   449	460	602	java/io/IOException
    //   546	564	602	java/io/IOException
    //   581	599	602	java/io/IOException
    //   480	499	623	java/io/IOException
    //   467	475	691	finally
    //   480	499	691	finally
    //   625	643	691	finally
    //   670	688	691	finally
    //   705	708	708	java/io/IOException
    //   727	738	708	java/io/IOException
    //   740	755	708	java/io/IOException
    //   757	762	708	java/io/IOException
    //   764	770	708	java/io/IOException
    //   772	775	708	java/io/IOException
    //   912	915	708	java/io/IOException
    //   775	808	905	finally
    //   808	849	905	finally
    //   849	852	905	finally
    //   869	902	905	finally
    //   907	910	905	finally
    //   355	442	915	finally
    //   442	449	915	finally
    //   449	460	915	finally
    //   546	564	915	finally
    //   581	599	915	finally
    //   643	648	915	finally
    //   648	653	915	finally
    //   693	698	915	finally
    //   698	703	915	finally
    //   705	708	915	finally
    //   715	720	915	finally
    //   720	725	915	finally
    //   727	738	915	finally
    //   740	755	915	finally
    //   757	762	915	finally
    //   764	770	915	finally
    //   772	775	915	finally
    //   912	915	915	finally
    //   643	648	955	java/io/IOException
    //   648	653	960	java/io/IOException
    //   715	720	965	java/io/IOException
    //   720	725	970	java/io/IOException
    //   693	698	975	java/io/IOException
    //   698	703	980	java/io/IOException
    //   345	355	985	finally
    //   345	355	994	java/io/IOException
    //   460	467	1002	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail
 * JD-Core Version:    0.7.0.1
 */