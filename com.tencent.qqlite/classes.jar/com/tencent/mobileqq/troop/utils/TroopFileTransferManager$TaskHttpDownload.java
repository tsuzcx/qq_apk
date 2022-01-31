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
  private java.net.HttpURLConnection a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, long paramLong1, long paramLong2, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 25	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   7: lload 4
    //   9: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12: ldc 34
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload 6
    //   19: lconst_1
    //   20: lsub
    //   21: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 12
    //   29: lload 4
    //   31: lconst_0
    //   32: lcmp
    //   33: ifne +79 -> 112
    //   36: new 25	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   43: ldc 43
    //   45: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 45
    //   54: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 47
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 52	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 54
    //   80: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_1
    //   87: new 56	java/net/URL
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 59	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 63	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   100: checkcast 65	java/net/HttpURLConnection
    //   103: astore_2
    //   104: aload_2
    //   105: ifnonnull +94 -> 199
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: areturn
    //   112: new 25	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   119: ldc 43
    //   121: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 45
    //   130: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_2
    //   134: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 47
    //   139: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokestatic 52	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 67
    //   151: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 12
    //   156: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 9
    //   161: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 54
    //   166: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore_1
    //   173: goto -86 -> 87
    //   176: astore_1
    //   177: iload 10
    //   179: ifeq +18 -> 197
    //   182: aload_0
    //   183: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   186: aload_0
    //   187: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   190: bipush 10
    //   192: bipush 102
    //   194: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   197: aconst_null
    //   198: areturn
    //   199: aload_2
    //   200: sipush 30000
    //   203: invokevirtual 79	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   206: aload_2
    //   207: sipush 30000
    //   210: invokevirtual 82	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   213: aload_2
    //   214: ldc 84
    //   216: invokevirtual 87	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   219: aload_2
    //   220: ldc 89
    //   222: ldc 91
    //   224: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: lload 6
    //   229: lconst_0
    //   230: lcmp
    //   231: ifeq +29 -> 260
    //   234: aload_2
    //   235: ldc 97
    //   237: new 25	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   244: ldc 99
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 12
    //   251: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_2
    //   261: ldc 101
    //   263: ldc 103
    //   265: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_2
    //   269: ldc 105
    //   271: new 25	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   278: ldc 107
    //   280: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 8
    //   285: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: astore_1
    //   296: aload_2
    //   297: invokevirtual 111	java/net/HttpURLConnection:getResponseCode	()I
    //   300: sipush 200
    //   303: if_icmpeq -193 -> 110
    //   306: aload_2
    //   307: invokevirtual 111	java/net/HttpURLConnection:getResponseCode	()I
    //   310: istore 11
    //   312: aload_2
    //   313: astore_1
    //   314: iload 11
    //   316: sipush 206
    //   319: if_icmpeq -209 -> 110
    //   322: aconst_null
    //   323: areturn
    //   324: astore_1
    //   325: aload_1
    //   326: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	TaskHttpDownload
    //   0	331	1	paramString1	java.lang.String
    //   0	331	2	paramString2	java.lang.String
    //   0	331	3	paramString3	java.lang.String
    //   0	331	4	paramLong1	long
    //   0	331	6	paramLong2	long
    //   0	331	8	paramString4	java.lang.String
    //   0	331	9	paramString5	java.lang.String
    //   0	331	10	paramBoolean	boolean
    //   310	10	11	i	int
    //   27	223	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   87	96	176	java/net/MalformedURLException
    //   96	104	324	java/io/IOException
    //   199	227	324	java/io/IOException
    //   234	260	324	java/io/IOException
    //   260	294	324	java/io/IOException
    //   296	312	324	java/io/IOException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 128	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 130
    //   23: iconst_4
    //   24: ldc 132
    //   26: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 140	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +20 -> 52
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: return
    //   52: new 142	java/io/File
    //   55: dup
    //   56: getstatic 148	com/tencent/mobileqq/app/AppConstants:aB	Ljava/lang/String;
    //   59: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 152	java/io/File:exists	()Z
    //   69: ifne +9 -> 78
    //   72: aload 5
    //   74: invokevirtual 155	java/io/File:mkdir	()Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   82: new 25	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   89: getstatic 148	com/tencent/mobileqq/app/AppConstants:aB	Ljava/lang/String;
    //   92: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   99: getfield 160	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   102: invokevirtual 166	java/lang/String:getBytes	()[B
    //   105: invokestatic 169	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   108: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 171
    //   113: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   122: new 142	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   130: getfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   133: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 8
    //   138: aload 8
    //   140: invokevirtual 152	java/io/File:exists	()Z
    //   143: ifne +9 -> 152
    //   146: aload 8
    //   148: invokevirtual 177	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: aload_0
    //   153: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   156: aload 8
    //   158: invokevirtual 181	java/io/File:length	()J
    //   161: putfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   164: iconst_0
    //   165: istore_1
    //   166: iload_1
    //   167: istore_2
    //   168: aload_0
    //   169: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   172: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   175: aload_0
    //   176: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   179: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   182: lcmp
    //   183: ifgt +17 -> 200
    //   186: aload_0
    //   187: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   190: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   193: lconst_0
    //   194: lcmp
    //   195: ifne +858 -> 1053
    //   198: iload_1
    //   199: istore_2
    //   200: iload_2
    //   201: iconst_3
    //   202: if_icmplt +38 -> 240
    //   205: aload_0
    //   206: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   209: aload_0
    //   210: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   213: bipush 10
    //   215: bipush 105
    //   217: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   220: return
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   227: aload_0
    //   228: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   231: bipush 10
    //   233: sipush 303
    //   236: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   239: return
    //   240: iload_2
    //   241: ifle +100 -> 341
    //   244: invokestatic 194	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   247: invokestatic 200	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   250: ifne +19 -> 269
    //   253: aload_0
    //   254: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   257: aload_0
    //   258: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   261: bipush 10
    //   263: bipush 106
    //   265: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   268: return
    //   269: iconst_0
    //   270: istore_1
    //   271: iload_1
    //   272: iload_2
    //   273: bipush 100
    //   275: imul
    //   276: if_icmpge +65 -> 341
    //   279: ldc2_w 201
    //   282: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   285: aload_0
    //   286: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   289: aload_0
    //   290: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: invokevirtual 122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   296: ifne -282 -> 14
    //   299: invokestatic 194	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   302: invokestatic 200	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   305: ifne +29 -> 334
    //   308: aload_0
    //   309: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   312: aload_0
    //   313: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   316: bipush 10
    //   318: bipush 106
    //   320: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   323: return
    //   324: astore 5
    //   326: aload 5
    //   328: invokevirtual 209	java/lang/InterruptedException:printStackTrace	()V
    //   331: goto -46 -> 285
    //   334: iload_1
    //   335: iconst_1
    //   336: iadd
    //   337: istore_1
    //   338: goto -67 -> 271
    //   341: aload_0
    //   342: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   345: aload_0
    //   346: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   349: invokevirtual 122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   352: ifne -338 -> 14
    //   355: iload_2
    //   356: iconst_1
    //   357: iadd
    //   358: istore_1
    //   359: aconst_null
    //   360: astore 7
    //   362: aconst_null
    //   363: astore 6
    //   365: aload 7
    //   367: astore 5
    //   369: aload_0
    //   370: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   373: invokevirtual 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   376: ifnull +234 -> 610
    //   379: aload_0
    //   380: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   383: invokevirtual 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   386: iconst_5
    //   387: invokeinterface 218 2 0
    //   392: astore 9
    //   394: aload 7
    //   396: astore 5
    //   398: aload 9
    //   400: ifnull +210 -> 610
    //   403: aload 7
    //   405: astore 5
    //   407: aload 9
    //   409: invokeinterface 223 1 0
    //   414: ifne +196 -> 610
    //   417: aload 9
    //   419: invokeinterface 227 1 0
    //   424: astore 7
    //   426: aload 6
    //   428: astore 5
    //   430: aload 7
    //   432: invokeinterface 232 1 0
    //   437: ifeq +173 -> 610
    //   440: aload 7
    //   442: invokeinterface 236 1 0
    //   447: checkcast 238	mqq/manager/ProxyIpManager$ProxyIp
    //   450: astore 5
    //   452: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +37 -> 492
    //   458: ldc 130
    //   460: iconst_2
    //   461: ldc 243
    //   463: iconst_2
    //   464: anewarray 245	java/lang/Object
    //   467: dup
    //   468: iconst_0
    //   469: aload 5
    //   471: getfield 248	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   474: aastore
    //   475: dup
    //   476: iconst_1
    //   477: aload 5
    //   479: getfield 252	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   482: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: invokestatic 262	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   489: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: ldc_w 264
    //   495: iconst_2
    //   496: anewarray 245	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: aload_0
    //   502: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   505: getfield 267	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: bipush 80
    //   513: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: aastore
    //   517: invokestatic 262	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   520: astore 6
    //   522: aload_0
    //   523: aload 5
    //   525: getfield 248	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   528: aload_0
    //   529: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   532: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   535: aload_0
    //   536: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   539: getfield 160	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   542: aload_0
    //   543: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   546: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   549: aload_0
    //   550: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   553: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   556: aload_0
    //   557: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   560: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   563: aload 6
    //   565: iconst_0
    //   566: invokespecial 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   569: astore 6
    //   571: aload 6
    //   573: astore 5
    //   575: aload 6
    //   577: ifnull -147 -> 430
    //   580: aload 6
    //   582: astore 5
    //   584: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +23 -> 610
    //   590: ldc 130
    //   592: iconst_2
    //   593: ldc_w 277
    //   596: iconst_0
    //   597: anewarray 245	java/lang/Object
    //   600: invokestatic 262	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   603: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload 6
    //   608: astore 5
    //   610: aload 5
    //   612: astore 6
    //   614: aload 5
    //   616: ifnonnull +92 -> 708
    //   619: aload_0
    //   620: aload_0
    //   621: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   624: getfield 267	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   627: aload_0
    //   628: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   631: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   634: aload_0
    //   635: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   638: getfield 160	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   641: aload_0
    //   642: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   645: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   648: aload_0
    //   649: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   652: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   655: aload_0
    //   656: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   659: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   662: ldc_w 279
    //   665: iconst_1
    //   666: invokespecial 275	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   669: astore 5
    //   671: iload_1
    //   672: istore_2
    //   673: aload 5
    //   675: ifnull -475 -> 200
    //   678: aload 5
    //   680: astore 6
    //   682: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +23 -> 708
    //   688: ldc 130
    //   690: iconst_2
    //   691: ldc_w 281
    //   694: iconst_0
    //   695: anewarray 245	java/lang/Object
    //   698: invokestatic 262	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   701: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: aload 5
    //   706: astore 6
    //   708: aload 6
    //   710: invokevirtual 285	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   713: astore 7
    //   715: aload_0
    //   716: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   719: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   722: lconst_0
    //   723: lcmp
    //   724: ifne +16 -> 740
    //   727: aload_0
    //   728: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   731: aload 6
    //   733: invokevirtual 288	java/net/HttpURLConnection:getContentLength	()I
    //   736: i2l
    //   737: putfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   740: new 290	java/io/FileOutputStream
    //   743: dup
    //   744: aload 8
    //   746: iconst_1
    //   747: invokespecial 293	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   750: astore 6
    //   752: sipush 4096
    //   755: newarray byte
    //   757: astore 5
    //   759: iload_1
    //   760: istore_2
    //   761: iload_2
    //   762: istore_1
    //   763: aload 7
    //   765: aload 5
    //   767: invokevirtual 299	java/io/InputStream:read	([B)I
    //   770: istore_3
    //   771: iload_3
    //   772: iconst_m1
    //   773: if_icmpeq +270 -> 1043
    //   776: iload_2
    //   777: istore_1
    //   778: aload_0
    //   779: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   782: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   785: iload_3
    //   786: i2l
    //   787: ladd
    //   788: aload_0
    //   789: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   792: getfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   795: lcmp
    //   796: ifle +95 -> 891
    //   799: iload_2
    //   800: istore_1
    //   801: aload_0
    //   802: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   805: aload_0
    //   806: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   809: bipush 10
    //   811: sipush 305
    //   814: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   817: aload 7
    //   819: invokevirtual 302	java/io/InputStream:close	()V
    //   822: aload 6
    //   824: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   827: return
    //   828: astore 5
    //   830: return
    //   831: astore 5
    //   833: aload_0
    //   834: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   837: aload_0
    //   838: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   841: bipush 10
    //   843: sipush 304
    //   846: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   849: return
    //   850: astore 5
    //   852: iload_1
    //   853: istore_2
    //   854: invokestatic 128	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   857: ifeq -657 -> 200
    //   860: ldc 130
    //   862: iconst_4
    //   863: new 25	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   870: ldc_w 305
    //   873: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: iload_1
    //   877: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: iload_1
    //   887: istore_2
    //   888: goto -688 -> 200
    //   891: iload_2
    //   892: istore_1
    //   893: aload 6
    //   895: aload 5
    //   897: iconst_0
    //   898: iload_3
    //   899: invokevirtual 315	java/io/FileOutputStream:write	([BII)V
    //   902: iload_2
    //   903: istore_1
    //   904: aload_0
    //   905: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   908: astore 9
    //   910: iload_2
    //   911: istore_1
    //   912: aload 9
    //   914: aload 9
    //   916: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   919: iload_3
    //   920: i2l
    //   921: ladd
    //   922: putfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   925: iload_2
    //   926: istore_1
    //   927: aload_0
    //   928: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   931: iconst_1
    //   932: iload_3
    //   933: i2l
    //   934: invokevirtual 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   937: iload_2
    //   938: istore_1
    //   939: aload_0
    //   940: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   943: aload_0
    //   944: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   947: invokevirtual 122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   950: istore 4
    //   952: iload 4
    //   954: ifeq +51 -> 1005
    //   957: aload 7
    //   959: invokevirtual 302	java/io/InputStream:close	()V
    //   962: aload 6
    //   964: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   967: return
    //   968: astore 5
    //   970: return
    //   971: astore 5
    //   973: iload_2
    //   974: istore_1
    //   975: aload_0
    //   976: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   979: aload_0
    //   980: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   983: bipush 10
    //   985: sipush 306
    //   988: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   991: aload 7
    //   993: invokevirtual 302	java/io/InputStream:close	()V
    //   996: aload 6
    //   998: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   1001: return
    //   1002: astore 5
    //   1004: return
    //   1005: iconst_0
    //   1006: istore_1
    //   1007: iconst_0
    //   1008: istore_2
    //   1009: aload_0
    //   1010: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1013: aload_0
    //   1014: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1017: invokevirtual 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1020: goto -259 -> 761
    //   1023: astore 5
    //   1025: aload 7
    //   1027: invokevirtual 302	java/io/InputStream:close	()V
    //   1030: aload 6
    //   1032: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   1035: aload 5
    //   1037: athrow
    //   1038: astore 5
    //   1040: goto -188 -> 852
    //   1043: aload 7
    //   1045: invokevirtual 302	java/io/InputStream:close	()V
    //   1048: aload 6
    //   1050: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   1053: aload_0
    //   1054: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1057: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1060: invokevirtual 326	java/lang/String:length	()I
    //   1063: bipush 85
    //   1065: if_icmple +62 -> 1127
    //   1068: aload_0
    //   1069: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1072: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1075: bipush 46
    //   1077: invokevirtual 330	java/lang/String:lastIndexOf	(I)I
    //   1080: istore_2
    //   1081: iload_2
    //   1082: istore_1
    //   1083: iload_2
    //   1084: ifge +5 -> 1089
    //   1087: iconst_0
    //   1088: istore_1
    //   1089: aload_0
    //   1090: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1093: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1096: invokevirtual 326	java/lang/String:length	()I
    //   1099: bipush 85
    //   1101: isub
    //   1102: istore_2
    //   1103: iload_1
    //   1104: ifne +229 -> 1333
    //   1107: aload_0
    //   1108: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1111: aload_0
    //   1112: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1115: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1118: iconst_0
    //   1119: bipush 85
    //   1121: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   1124: putfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1127: aload_0
    //   1128: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1131: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1134: astore 6
    //   1136: aload 6
    //   1138: astore 5
    //   1140: aload_0
    //   1141: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1144: getfield 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1147: invokestatic 342	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1150: ifne +27 -> 1177
    //   1153: aload 6
    //   1155: astore 5
    //   1157: aload_0
    //   1158: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1161: getfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   1164: iconst_2
    //   1165: if_icmpne +12 -> 1177
    //   1168: aload_0
    //   1169: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1172: getfield 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1175: astore 5
    //   1177: iconst_0
    //   1178: istore_1
    //   1179: iload_1
    //   1180: sipush 1000
    //   1183: if_icmpge +243 -> 1426
    //   1186: iload_1
    //   1187: ifle +206 -> 1393
    //   1190: aload 5
    //   1192: bipush 46
    //   1194: invokevirtual 330	java/lang/String:lastIndexOf	(I)I
    //   1197: istore_3
    //   1198: iload_3
    //   1199: istore_2
    //   1200: iload_3
    //   1201: ifge +5 -> 1206
    //   1204: iconst_0
    //   1205: istore_2
    //   1206: new 25	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1213: getstatic 348	com/tencent/mobileqq/app/AppConstants:ay	Ljava/lang/String;
    //   1216: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload 5
    //   1221: iconst_0
    //   1222: iload_2
    //   1223: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   1226: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: ldc_w 350
    //   1232: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: iload_1
    //   1236: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: ldc_w 352
    //   1242: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: aload 5
    //   1247: iload_2
    //   1248: invokevirtual 355	java/lang/String:substring	(I)Ljava/lang/String;
    //   1251: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: astore 6
    //   1259: new 142	java/io/File
    //   1262: dup
    //   1263: aload 6
    //   1265: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   1268: astore 7
    //   1270: aload 7
    //   1272: invokevirtual 152	java/io/File:exists	()Z
    //   1275: ifne +144 -> 1419
    //   1278: aload 8
    //   1280: aload 7
    //   1282: invokevirtual 359	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1285: ifeq +134 -> 1419
    //   1288: aload_0
    //   1289: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1292: aload 6
    //   1294: putfield 362	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   1297: aload_0
    //   1298: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1301: aload_0
    //   1302: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1305: bipush 11
    //   1307: invokevirtual 365	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1310: aload_0
    //   1311: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1314: aload_0
    //   1315: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1318: aload_0
    //   1319: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1322: getfield 368	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1325: invokevirtual 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1328: iconst_0
    //   1329: invokevirtual 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1332: return
    //   1333: iload_1
    //   1334: iload_2
    //   1335: if_icmple -208 -> 1127
    //   1338: new 25	java/lang/StringBuilder
    //   1341: dup
    //   1342: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1345: aload_0
    //   1346: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1349: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1352: iconst_0
    //   1353: iload_1
    //   1354: iload_2
    //   1355: isub
    //   1356: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   1359: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: aload_0
    //   1363: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1366: getfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1369: iload_1
    //   1370: invokevirtual 355	java/lang/String:substring	(I)Ljava/lang/String;
    //   1373: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: astore 5
    //   1381: aload_0
    //   1382: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1385: aload 5
    //   1387: putfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1390: goto -263 -> 1127
    //   1393: new 25	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1400: getstatic 348	com/tencent/mobileqq/app/AppConstants:ay	Ljava/lang/String;
    //   1403: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 5
    //   1408: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: astore 6
    //   1416: goto -157 -> 1259
    //   1419: iload_1
    //   1420: iconst_1
    //   1421: iadd
    //   1422: istore_1
    //   1423: goto -244 -> 1179
    //   1426: aload_0
    //   1427: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1430: aload_0
    //   1431: getfield 70	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1434: bipush 10
    //   1436: sipush 307
    //   1439: invokevirtual 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1442: return
    //   1443: astore 5
    //   1445: goto -623 -> 822
    //   1448: astore 5
    //   1450: goto -454 -> 996
    //   1453: astore 5
    //   1455: goto -493 -> 962
    //   1458: astore 5
    //   1460: goto -412 -> 1048
    //   1463: astore 5
    //   1465: goto -412 -> 1053
    //   1468: astore 7
    //   1470: goto -440 -> 1030
    //   1473: astore 6
    //   1475: goto -440 -> 1035
    //   1478: astore 5
    //   1480: goto -455 -> 1025
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1483	0	this	TaskHttpDownload
    //   165	1258	1	i	int
    //   167	1189	2	j	int
    //   770	431	3	k	int
    //   950	3	4	bool	boolean
    //   62	11	5	localFile1	java.io.File
    //   221	1	5	localIOException1	java.io.IOException
    //   324	3	5	localInterruptedException	java.lang.InterruptedException
    //   367	399	5	localObject1	java.lang.Object
    //   828	1	5	localIOException2	java.io.IOException
    //   831	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   850	46	5	localIOException3	java.io.IOException
    //   968	1	5	localIOException4	java.io.IOException
    //   971	1	5	localIOException5	java.io.IOException
    //   1002	1	5	localIOException6	java.io.IOException
    //   1023	13	5	localObject2	java.lang.Object
    //   1038	1	5	localIOException7	java.io.IOException
    //   1138	269	5	localObject3	java.lang.Object
    //   1443	1	5	localIOException8	java.io.IOException
    //   1448	1	5	localIOException9	java.io.IOException
    //   1453	1	5	localIOException10	java.io.IOException
    //   1458	1	5	localIOException11	java.io.IOException
    //   1463	1	5	localIOException12	java.io.IOException
    //   1478	1	5	localObject4	java.lang.Object
    //   363	1052	6	localObject5	java.lang.Object
    //   1473	1	6	localIOException13	java.io.IOException
    //   360	921	7	localObject6	java.lang.Object
    //   1468	1	7	localIOException14	java.io.IOException
    //   136	1143	8	localFile2	java.io.File
    //   392	523	9	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   146	152	221	java/io/IOException
    //   279	285	324	java/lang/InterruptedException
    //   822	827	828	java/io/IOException
    //   740	752	831	java/io/FileNotFoundException
    //   708	740	850	java/io/IOException
    //   740	752	850	java/io/IOException
    //   833	849	850	java/io/IOException
    //   962	967	968	java/io/IOException
    //   893	902	971	java/io/IOException
    //   996	1001	1002	java/io/IOException
    //   763	771	1023	finally
    //   778	799	1023	finally
    //   801	817	1023	finally
    //   893	902	1023	finally
    //   904	910	1023	finally
    //   912	925	1023	finally
    //   927	937	1023	finally
    //   939	952	1023	finally
    //   975	991	1023	finally
    //   1009	1020	1023	finally
    //   1035	1038	1038	java/io/IOException
    //   817	822	1443	java/io/IOException
    //   991	996	1448	java/io/IOException
    //   957	962	1453	java/io/IOException
    //   1043	1048	1458	java/io/IOException
    //   1048	1053	1463	java/io/IOException
    //   1025	1030	1468	java/io/IOException
    //   1030	1035	1473	java/io/IOException
    //   752	759	1478	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */