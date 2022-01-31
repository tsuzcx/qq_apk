package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    this.jdField_b_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 42	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 44
    //   23: iconst_4
    //   24: ldc 46
    //   26: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 54	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +20 -> 52
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: return
    //   52: new 59	java/io/File
    //   55: dup
    //   56: getstatic 65	com/tencent/mobileqq/app/AppConstants:av	Ljava/lang/String;
    //   59: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 71	java/io/File:exists	()Z
    //   69: ifne +9 -> 78
    //   72: aload 5
    //   74: invokevirtual 74	java/io/File:mkdir	()Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   82: new 76	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   89: getstatic 65	com/tencent/mobileqq/app/AppConstants:av	Ljava/lang/String;
    //   92: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   99: getfield 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   102: invokevirtual 93	java/lang/String:getBytes	()[B
    //   105: invokestatic 98	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 100
    //   113: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: putfield 107	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   122: new 59	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   130: getfield 107	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   133: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 7
    //   138: aload 7
    //   140: invokevirtual 71	java/io/File:exists	()Z
    //   143: ifne +9 -> 152
    //   146: aload 7
    //   148: invokevirtual 110	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: aload_0
    //   153: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   156: aload 7
    //   158: invokevirtual 114	java/io/File:length	()J
    //   161: putfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   164: aload_0
    //   165: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   168: getfield 121	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   171: aload_0
    //   172: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   175: getfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   178: lcmp
    //   179: ifle +760 -> 939
    //   182: iconst_0
    //   183: istore_1
    //   184: iload_1
    //   185: iconst_3
    //   186: if_icmplt +38 -> 224
    //   189: aload_0
    //   190: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   193: aload_0
    //   194: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   197: bipush 10
    //   199: bipush 105
    //   201: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   204: return
    //   205: astore 5
    //   207: aload_0
    //   208: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   211: aload_0
    //   212: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   215: bipush 10
    //   217: sipush 303
    //   220: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   223: return
    //   224: iload_1
    //   225: ifle +100 -> 325
    //   228: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   231: invokestatic 133	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   234: ifne +19 -> 253
    //   237: aload_0
    //   238: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   241: aload_0
    //   242: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   245: bipush 10
    //   247: bipush 106
    //   249: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   252: return
    //   253: iconst_0
    //   254: istore_2
    //   255: iload_2
    //   256: iload_1
    //   257: bipush 100
    //   259: imul
    //   260: if_icmpge +65 -> 325
    //   263: ldc2_w 134
    //   266: invokestatic 141	java/lang/Thread:sleep	(J)V
    //   269: aload_0
    //   270: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   273: aload_0
    //   274: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   277: invokevirtual 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   280: ifne -266 -> 14
    //   283: invokestatic 127	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   286: invokestatic 133	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   289: ifne +29 -> 318
    //   292: aload_0
    //   293: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   296: aload_0
    //   297: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   300: bipush 10
    //   302: bipush 106
    //   304: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   307: return
    //   308: astore 5
    //   310: aload 5
    //   312: invokevirtual 144	java/lang/InterruptedException:printStackTrace	()V
    //   315: goto -46 -> 269
    //   318: iload_2
    //   319: iconst_1
    //   320: iadd
    //   321: istore_2
    //   322: goto -67 -> 255
    //   325: aload_0
    //   326: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   329: aload_0
    //   330: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   333: invokevirtual 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   336: ifne -322 -> 14
    //   339: iload_1
    //   340: iconst_1
    //   341: iadd
    //   342: istore_1
    //   343: new 76	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   350: aload_0
    //   351: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   354: getfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   357: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: ldc 149
    //   362: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   369: getfield 121	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   372: lconst_1
    //   373: lsub
    //   374: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   377: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: astore 5
    //   382: new 76	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   389: ldc 151
    //   391: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   398: getfield 154	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   401: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 156
    //   406: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_0
    //   410: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   413: getfield 159	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   416: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc 161
    //   421: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   428: getfield 87	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   431: invokestatic 164	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 166
    //   439: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 5
    //   444: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc 168
    //   449: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: astore 6
    //   457: new 170	java/net/URL
    //   460: dup
    //   461: aload 6
    //   463: invokespecial 171	java/net/URL:<init>	(Ljava/lang/String;)V
    //   466: astore 6
    //   468: iload_1
    //   469: istore_2
    //   470: aload 6
    //   472: invokevirtual 175	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   475: checkcast 177	java/net/HttpURLConnection
    //   478: astore 6
    //   480: iload_1
    //   481: istore_2
    //   482: aload 6
    //   484: sipush 30000
    //   487: invokevirtual 181	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   490: iload_1
    //   491: istore_2
    //   492: aload 6
    //   494: sipush 30000
    //   497: invokevirtual 184	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   500: iload_1
    //   501: istore_2
    //   502: aload 6
    //   504: ldc 186
    //   506: invokevirtual 189	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   509: iload_1
    //   510: istore_2
    //   511: aload 6
    //   513: ldc 191
    //   515: ldc 193
    //   517: invokevirtual 197	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: iload_1
    //   521: istore_2
    //   522: aload 6
    //   524: ldc 199
    //   526: new 76	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   533: ldc 201
    //   535: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 5
    //   540: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokevirtual 197	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: iload_1
    //   550: istore_2
    //   551: aload 6
    //   553: ldc 203
    //   555: ldc 205
    //   557: invokevirtual 197	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: iload_1
    //   561: istore_2
    //   562: aload 6
    //   564: ldc 207
    //   566: new 76	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   573: ldc 209
    //   575: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   582: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   585: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokevirtual 197	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iload_1
    //   595: istore_2
    //   596: aload 6
    //   598: invokevirtual 216	java/net/HttpURLConnection:getResponseCode	()I
    //   601: sipush 200
    //   604: if_icmpeq +16 -> 620
    //   607: iload_1
    //   608: istore_2
    //   609: aload 6
    //   611: invokevirtual 216	java/net/HttpURLConnection:getResponseCode	()I
    //   614: sipush 206
    //   617: if_icmpne +617 -> 1234
    //   620: iload_1
    //   621: istore_2
    //   622: aload 6
    //   624: invokevirtual 220	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   627: astore 8
    //   629: iload_1
    //   630: istore_2
    //   631: new 222	java/io/FileOutputStream
    //   634: dup
    //   635: aload 7
    //   637: iconst_1
    //   638: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   641: astore 6
    //   643: iload_1
    //   644: istore_2
    //   645: sipush 4096
    //   648: newarray byte
    //   650: astore 5
    //   652: iload_1
    //   653: istore_2
    //   654: aload 8
    //   656: aload 5
    //   658: invokevirtual 231	java/io/InputStream:read	([B)I
    //   661: istore_3
    //   662: iload_3
    //   663: iconst_m1
    //   664: if_icmpeq +265 -> 929
    //   667: iload_1
    //   668: istore_2
    //   669: aload_0
    //   670: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   673: getfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   676: iload_3
    //   677: i2l
    //   678: ladd
    //   679: aload_0
    //   680: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   683: getfield 121	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   686: lcmp
    //   687: ifle +112 -> 799
    //   690: iload_1
    //   691: istore_2
    //   692: aload_0
    //   693: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   696: aload_0
    //   697: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   700: bipush 10
    //   702: sipush 305
    //   705: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   708: aload 8
    //   710: invokevirtual 234	java/io/InputStream:close	()V
    //   713: aload 6
    //   715: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   718: return
    //   719: astore 5
    //   721: return
    //   722: astore 5
    //   724: aload_0
    //   725: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   728: aload_0
    //   729: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   732: bipush 10
    //   734: bipush 102
    //   736: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   739: return
    //   740: astore 5
    //   742: iload_1
    //   743: istore_2
    //   744: aload_0
    //   745: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   748: aload_0
    //   749: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   752: bipush 10
    //   754: sipush 304
    //   757: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   760: return
    //   761: astore 5
    //   763: iload_2
    //   764: istore_1
    //   765: invokestatic 42	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   768: ifeq +28 -> 796
    //   771: ldc 44
    //   773: iconst_4
    //   774: new 76	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   781: ldc 237
    //   783: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: iload_1
    //   787: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: goto -612 -> 184
    //   799: iload_1
    //   800: istore_2
    //   801: aload 6
    //   803: aload 5
    //   805: iconst_0
    //   806: iload_3
    //   807: invokevirtual 247	java/io/FileOutputStream:write	([BII)V
    //   810: iload_1
    //   811: istore_2
    //   812: aload_0
    //   813: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   816: astore 9
    //   818: iload_1
    //   819: istore_2
    //   820: aload 9
    //   822: aload 9
    //   824: getfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   827: iload_3
    //   828: i2l
    //   829: ladd
    //   830: putfield 118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   833: iload_1
    //   834: istore_2
    //   835: aload_0
    //   836: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   839: iconst_1
    //   840: iload_3
    //   841: i2l
    //   842: invokevirtual 250	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   845: iload_1
    //   846: istore_2
    //   847: aload_0
    //   848: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   851: aload_0
    //   852: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   855: invokevirtual 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   858: istore 4
    //   860: iload 4
    //   862: ifeq +51 -> 913
    //   865: aload 8
    //   867: invokevirtual 234	java/io/InputStream:close	()V
    //   870: aload 6
    //   872: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   875: return
    //   876: astore 5
    //   878: return
    //   879: astore 5
    //   881: iload_1
    //   882: istore_2
    //   883: aload_0
    //   884: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   887: aload_0
    //   888: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   891: bipush 10
    //   893: sipush 306
    //   896: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   899: aload 8
    //   901: invokevirtual 234	java/io/InputStream:close	()V
    //   904: aload 6
    //   906: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   909: return
    //   910: astore 5
    //   912: return
    //   913: aload_0
    //   914: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   917: aload_0
    //   918: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   921: invokevirtual 253	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   924: iconst_0
    //   925: istore_1
    //   926: goto -274 -> 652
    //   929: aload 8
    //   931: invokevirtual 234	java/io/InputStream:close	()V
    //   934: aload 6
    //   936: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   939: aload_0
    //   940: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   943: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   946: invokevirtual 258	java/lang/String:length	()I
    //   949: bipush 85
    //   951: if_icmple +62 -> 1013
    //   954: aload_0
    //   955: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   958: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   961: bipush 46
    //   963: invokevirtual 262	java/lang/String:lastIndexOf	(I)I
    //   966: istore_2
    //   967: iload_2
    //   968: istore_1
    //   969: iload_2
    //   970: ifge +5 -> 975
    //   973: iconst_0
    //   974: istore_1
    //   975: aload_0
    //   976: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   979: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   982: invokevirtual 258	java/lang/String:length	()I
    //   985: bipush 85
    //   987: isub
    //   988: istore_2
    //   989: iload_1
    //   990: ifne +247 -> 1237
    //   993: aload_0
    //   994: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   997: aload_0
    //   998: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1001: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1004: iconst_0
    //   1005: bipush 85
    //   1007: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   1010: putfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1013: aload_0
    //   1014: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1017: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1020: astore 6
    //   1022: aload 6
    //   1024: astore 5
    //   1026: aload_0
    //   1027: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1030: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1033: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1036: ifne +27 -> 1063
    //   1039: aload 6
    //   1041: astore 5
    //   1043: aload_0
    //   1044: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1047: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   1050: iconst_2
    //   1051: if_icmpne +12 -> 1063
    //   1054: aload_0
    //   1055: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1058: getfield 269	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1061: astore 5
    //   1063: iconst_0
    //   1064: istore_1
    //   1065: iload_1
    //   1066: sipush 1000
    //   1069: if_icmpge +261 -> 1330
    //   1072: iload_1
    //   1073: ifle +224 -> 1297
    //   1076: aload 5
    //   1078: bipush 46
    //   1080: invokevirtual 262	java/lang/String:lastIndexOf	(I)I
    //   1083: istore_3
    //   1084: iload_3
    //   1085: istore_2
    //   1086: iload_3
    //   1087: ifge +5 -> 1092
    //   1090: iconst_0
    //   1091: istore_2
    //   1092: new 76	java/lang/StringBuilder
    //   1095: dup
    //   1096: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1099: getstatic 282	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   1102: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload 5
    //   1107: iconst_0
    //   1108: iload_2
    //   1109: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   1112: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: ldc_w 284
    //   1118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: iload_1
    //   1122: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1125: ldc_w 286
    //   1128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload 5
    //   1133: iload_2
    //   1134: invokevirtual 289	java/lang/String:substring	(I)Ljava/lang/String;
    //   1137: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: astore 6
    //   1145: new 59	java/io/File
    //   1148: dup
    //   1149: aload 6
    //   1151: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   1154: astore 8
    //   1156: aload 8
    //   1158: invokevirtual 71	java/io/File:exists	()Z
    //   1161: ifne +162 -> 1323
    //   1164: aload 7
    //   1166: aload 8
    //   1168: invokevirtual 293	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1171: ifeq +152 -> 1323
    //   1174: aload_0
    //   1175: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1178: aload 6
    //   1180: putfield 296	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   1183: aload_0
    //   1184: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1187: aload_0
    //   1188: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1191: bipush 11
    //   1193: invokevirtual 299	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1196: aload_0
    //   1197: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1200: aload_0
    //   1201: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1204: aload_0
    //   1205: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1208: getfield 302	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1211: invokevirtual 306	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1214: iconst_0
    //   1215: invokevirtual 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1218: return
    //   1219: astore 5
    //   1221: aload 8
    //   1223: invokevirtual 234	java/io/InputStream:close	()V
    //   1226: aload 6
    //   1228: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   1231: aload 5
    //   1233: athrow
    //   1234: goto -469 -> 765
    //   1237: iload_1
    //   1238: iload_2
    //   1239: if_icmple -226 -> 1013
    //   1242: new 76	java/lang/StringBuilder
    //   1245: dup
    //   1246: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1249: aload_0
    //   1250: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1253: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1256: iconst_0
    //   1257: iload_1
    //   1258: iload_2
    //   1259: isub
    //   1260: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   1263: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: aload_0
    //   1267: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1270: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1273: iload_1
    //   1274: invokevirtual 289	java/lang/String:substring	(I)Ljava/lang/String;
    //   1277: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: astore 5
    //   1285: aload_0
    //   1286: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1289: aload 5
    //   1291: putfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1294: goto -281 -> 1013
    //   1297: new 76	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1304: getstatic 282	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   1307: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: aload 5
    //   1312: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: astore 6
    //   1320: goto -175 -> 1145
    //   1323: iload_1
    //   1324: iconst_1
    //   1325: iadd
    //   1326: istore_1
    //   1327: goto -262 -> 1065
    //   1330: aload_0
    //   1331: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1334: aload_0
    //   1335: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1338: bipush 10
    //   1340: sipush 307
    //   1343: invokevirtual 57	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1346: return
    //   1347: astore 5
    //   1349: goto -636 -> 713
    //   1352: astore 5
    //   1354: goto -450 -> 904
    //   1357: astore 5
    //   1359: goto -489 -> 870
    //   1362: astore 5
    //   1364: goto -430 -> 934
    //   1367: astore 5
    //   1369: goto -430 -> 939
    //   1372: astore 8
    //   1374: goto -148 -> 1226
    //   1377: astore 6
    //   1379: goto -148 -> 1231
    //   1382: astore 5
    //   1384: iconst_0
    //   1385: istore_2
    //   1386: goto -165 -> 1221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1389	0	this	TaskHttpDownload
    //   183	1144	1	i	int
    //   254	1132	2	j	int
    //   661	426	3	k	int
    //   858	3	4	bool	boolean
    //   62	11	5	localFile1	java.io.File
    //   205	1	5	localIOException1	java.io.IOException
    //   308	3	5	localInterruptedException	java.lang.InterruptedException
    //   380	277	5	localObject1	java.lang.Object
    //   719	1	5	localIOException2	java.io.IOException
    //   722	1	5	localMalformedURLException	java.net.MalformedURLException
    //   740	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   761	43	5	localIOException3	java.io.IOException
    //   876	1	5	localIOException4	java.io.IOException
    //   879	1	5	localIOException5	java.io.IOException
    //   910	1	5	localIOException6	java.io.IOException
    //   1024	108	5	localObject2	java.lang.Object
    //   1219	13	5	localObject3	java.lang.Object
    //   1283	28	5	str	java.lang.String
    //   1347	1	5	localIOException7	java.io.IOException
    //   1352	1	5	localIOException8	java.io.IOException
    //   1357	1	5	localIOException9	java.io.IOException
    //   1362	1	5	localIOException10	java.io.IOException
    //   1367	1	5	localIOException11	java.io.IOException
    //   1382	1	5	localObject4	java.lang.Object
    //   455	864	6	localObject5	java.lang.Object
    //   1377	1	6	localIOException12	java.io.IOException
    //   136	1029	7	localFile2	java.io.File
    //   627	595	8	localObject6	java.lang.Object
    //   1372	1	8	localIOException13	java.io.IOException
    //   816	7	9	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   146	152	205	java/io/IOException
    //   263	269	308	java/lang/InterruptedException
    //   713	718	719	java/io/IOException
    //   457	468	722	java/net/MalformedURLException
    //   631	643	740	java/io/FileNotFoundException
    //   470	480	761	java/io/IOException
    //   482	490	761	java/io/IOException
    //   492	500	761	java/io/IOException
    //   502	509	761	java/io/IOException
    //   511	520	761	java/io/IOException
    //   522	549	761	java/io/IOException
    //   551	560	761	java/io/IOException
    //   562	594	761	java/io/IOException
    //   596	607	761	java/io/IOException
    //   609	620	761	java/io/IOException
    //   622	629	761	java/io/IOException
    //   631	643	761	java/io/IOException
    //   744	760	761	java/io/IOException
    //   1231	1234	761	java/io/IOException
    //   870	875	876	java/io/IOException
    //   801	810	879	java/io/IOException
    //   904	909	910	java/io/IOException
    //   645	652	1219	finally
    //   654	662	1219	finally
    //   669	690	1219	finally
    //   692	708	1219	finally
    //   801	810	1219	finally
    //   812	818	1219	finally
    //   820	833	1219	finally
    //   835	845	1219	finally
    //   847	860	1219	finally
    //   883	899	1219	finally
    //   708	713	1347	java/io/IOException
    //   899	904	1352	java/io/IOException
    //   865	870	1357	java/io/IOException
    //   929	934	1362	java/io/IOException
    //   934	939	1367	java/io/IOException
    //   1221	1226	1372	java/io/IOException
    //   1226	1231	1377	java/io/IOException
    //   913	924	1382	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */