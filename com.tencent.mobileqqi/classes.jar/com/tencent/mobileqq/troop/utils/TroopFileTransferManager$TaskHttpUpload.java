package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpUpload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpUpload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 2);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 42	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   23: getfield 48	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   26: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 12
    //   31: sipush 1024
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_1
    //   37: aconst_null
    //   38: astore 11
    //   40: iload_1
    //   41: istore_2
    //   42: iload_1
    //   43: iconst_3
    //   44: if_icmpgt +254 -> 298
    //   47: iload_1
    //   48: ifle +117 -> 165
    //   51: invokestatic 57	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   54: invokestatic 63	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   57: ifne +54 -> 111
    //   60: aload_0
    //   61: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   64: aload_0
    //   65: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   68: iconst_3
    //   69: bipush 106
    //   71: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   74: return
    //   75: astore 10
    //   77: invokestatic 72	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   80: ifeq +11 -> 91
    //   83: ldc 74
    //   85: iconst_4
    //   86: ldc 76
    //   88: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: invokevirtual 83	java/lang/InterruptedException:printStackTrace	()V
    //   96: aload_0
    //   97: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   100: aload_0
    //   101: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   104: iconst_3
    //   105: bipush 102
    //   107: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   110: return
    //   111: iconst_0
    //   112: istore_2
    //   113: iload_2
    //   114: iload_1
    //   115: bipush 100
    //   117: imul
    //   118: if_icmpge +47 -> 165
    //   121: ldc2_w 84
    //   124: invokestatic 91	java/lang/Thread:sleep	(J)V
    //   127: aload_0
    //   128: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   131: aload_0
    //   132: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   135: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   138: ifne -124 -> 14
    //   141: invokestatic 57	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   144: invokestatic 63	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   147: ifne +1169 -> 1316
    //   150: aload_0
    //   151: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   154: aload_0
    //   155: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   158: iconst_3
    //   159: bipush 106
    //   161: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   164: return
    //   165: aload_0
    //   166: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   169: aload_0
    //   170: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   173: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   176: ifne -162 -> 14
    //   179: aload 12
    //   181: invokevirtual 95	java/io/File:length	()J
    //   184: aload_0
    //   185: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   188: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   191: lcmp
    //   192: ifeq +19 -> 211
    //   195: aload_0
    //   196: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   199: aload_0
    //   200: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: iconst_3
    //   204: sipush 206
    //   207: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   210: return
    //   211: aload 11
    //   213: astore 10
    //   215: aload 11
    //   217: ifnonnull +26 -> 243
    //   220: invokestatic 104	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   223: ifnull +111 -> 334
    //   226: iconst_1
    //   227: istore 5
    //   229: iconst_0
    //   230: iload 5
    //   232: sipush 10000
    //   235: sipush 20000
    //   238: invokestatic 107	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   241: astore 10
    //   243: iload_1
    //   244: iconst_1
    //   245: iadd
    //   246: istore_2
    //   247: iload_3
    //   248: newarray byte
    //   250: astore 11
    //   252: sipush 16384
    //   255: istore 4
    //   257: new 109	java/io/FileInputStream
    //   260: dup
    //   261: aload 12
    //   263: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   266: astore 13
    //   268: aload 13
    //   270: aload_0
    //   271: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   274: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   277: invokevirtual 119	java/io/FileInputStream:skip	(J)J
    //   280: pop2
    //   281: aload 13
    //   283: aload 11
    //   285: invokevirtual 123	java/io/FileInputStream:read	([B)I
    //   288: istore_1
    //   289: aload 13
    //   291: invokevirtual 126	java/io/FileInputStream:close	()V
    //   294: iload_1
    //   295: ifge +129 -> 424
    //   298: iload_2
    //   299: iconst_3
    //   300: if_icmple +927 -> 1227
    //   303: aload_0
    //   304: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   307: aload_0
    //   308: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   311: iconst_3
    //   312: bipush 105
    //   314: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   317: aload_0
    //   318: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   321: aconst_null
    //   322: putfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   325: aload_0
    //   326: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   329: aconst_null
    //   330: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   333: return
    //   334: iconst_0
    //   335: istore 5
    //   337: goto -108 -> 229
    //   340: astore 10
    //   342: aload_0
    //   343: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   346: aload_0
    //   347: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   350: iconst_3
    //   351: sipush 201
    //   354: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   357: return
    //   358: astore 13
    //   360: aload 13
    //   362: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   365: goto -71 -> 294
    //   368: astore 10
    //   370: aload 10
    //   372: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   375: aload_0
    //   376: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   379: aload_0
    //   380: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   383: iconst_3
    //   384: sipush 203
    //   387: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   390: aload 13
    //   392: invokevirtual 126	java/io/FileInputStream:close	()V
    //   395: return
    //   396: astore 10
    //   398: aload 10
    //   400: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   403: return
    //   404: astore 10
    //   406: aload 13
    //   408: invokevirtual 126	java/io/FileInputStream:close	()V
    //   411: aload 10
    //   413: athrow
    //   414: astore 11
    //   416: aload 11
    //   418: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   421: goto -10 -> 411
    //   424: aload_0
    //   425: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   428: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   431: arraylength
    //   432: iconst_2
    //   433: iadd
    //   434: iconst_2
    //   435: iadd
    //   436: aload_0
    //   437: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   440: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   443: arraylength
    //   444: iadd
    //   445: bipush 20
    //   447: iadd
    //   448: iload_1
    //   449: iadd
    //   450: istore_3
    //   451: new 139	java/io/ByteArrayOutputStream
    //   454: dup
    //   455: iload_3
    //   456: bipush 16
    //   458: iadd
    //   459: invokespecial 142	java/io/ByteArrayOutputStream:<init>	(I)V
    //   462: astore 13
    //   464: new 144	java/io/DataOutputStream
    //   467: dup
    //   468: aload 13
    //   470: invokespecial 147	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   473: astore 14
    //   475: aload 14
    //   477: ldc 148
    //   479: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   482: aload 14
    //   484: sipush 1007
    //   487: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   490: aload 14
    //   492: iconst_0
    //   493: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   496: aload 14
    //   498: iload_3
    //   499: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   502: aload 14
    //   504: aload_0
    //   505: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   508: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   511: arraylength
    //   512: invokevirtual 154	java/io/DataOutputStream:writeShort	(I)V
    //   515: aload 14
    //   517: aload_0
    //   518: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   521: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   524: invokevirtual 158	java/io/DataOutputStream:write	([B)V
    //   527: aload 14
    //   529: aload_0
    //   530: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   533: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   536: arraylength
    //   537: invokevirtual 154	java/io/DataOutputStream:writeShort	(I)V
    //   540: aload 14
    //   542: aload_0
    //   543: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   546: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   549: invokevirtual 158	java/io/DataOutputStream:write	([B)V
    //   552: aload 14
    //   554: aload_0
    //   555: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   558: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   561: ldc2_w 159
    //   564: land
    //   565: l2i
    //   566: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   569: aload 14
    //   571: aload_0
    //   572: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   575: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   578: ldc2_w 159
    //   581: land
    //   582: l2i
    //   583: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   586: aload 14
    //   588: iload_1
    //   589: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   592: aload 14
    //   594: aload_0
    //   595: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   598: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   601: bipush 32
    //   603: lshr
    //   604: l2i
    //   605: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   608: aload 14
    //   610: aload_0
    //   611: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   614: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   617: bipush 32
    //   619: lshr
    //   620: l2i
    //   621: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   624: aload 14
    //   626: aload 11
    //   628: iconst_0
    //   629: iload_1
    //   630: invokevirtual 163	java/io/DataOutputStream:write	([BII)V
    //   633: aload 13
    //   635: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   638: astore 11
    //   640: aload 13
    //   642: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   645: aload 14
    //   647: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   650: new 171	org/apache/http/client/methods/HttpPost
    //   653: dup
    //   654: new 173	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   661: ldc 177
    //   663: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_0
    //   667: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   670: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   673: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: ldc 183
    //   678: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_0
    //   682: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   685: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   688: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: ldc 188
    //   693: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload_0
    //   697: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   700: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   703: iload_1
    //   704: i2l
    //   705: ladd
    //   706: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   709: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokespecial 193	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   715: astore 13
    //   717: aload 13
    //   719: ldc 195
    //   721: ldc 197
    //   723: invokevirtual 201	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: aload 13
    //   728: ldc 203
    //   730: ldc 205
    //   732: invokevirtual 201	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   735: aload 13
    //   737: ldc 207
    //   739: ldc 209
    //   741: invokevirtual 201	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: invokestatic 57	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   747: invokestatic 212	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   750: ifeq +190 -> 940
    //   753: aload 13
    //   755: ldc 214
    //   757: ldc 216
    //   759: invokevirtual 201	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload 13
    //   764: new 218	org/apache/http/entity/ByteArrayEntity
    //   767: dup
    //   768: aload 11
    //   770: invokespecial 220	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   773: invokevirtual 224	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   776: aload 10
    //   778: aload 13
    //   780: invokeinterface 230 2 0
    //   785: astore 13
    //   787: aload 13
    //   789: invokeinterface 236 1 0
    //   794: astore 14
    //   796: aload 14
    //   798: invokeinterface 242 1 0
    //   803: sipush 200
    //   806: if_icmpeq +258 -> 1064
    //   809: aload 14
    //   811: invokeinterface 242 1 0
    //   816: sipush 206
    //   819: if_icmpeq +245 -> 1064
    //   822: aload 13
    //   824: ldc 244
    //   826: invokeinterface 248 2 0
    //   831: astore 13
    //   833: iload_2
    //   834: istore_1
    //   835: aload 10
    //   837: astore 11
    //   839: iload 4
    //   841: istore_3
    //   842: aload 13
    //   844: ifnull -804 -> 40
    //   847: iload_2
    //   848: istore_1
    //   849: aload 10
    //   851: astore 11
    //   853: iload 4
    //   855: istore_3
    //   856: aload 13
    //   858: invokeinterface 253 1 0
    //   863: ifnull -823 -> 40
    //   866: aload 13
    //   868: invokeinterface 253 1 0
    //   873: ldc 255
    //   875: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   878: istore 5
    //   880: iload 5
    //   882: ifeq +109 -> 991
    //   885: iconst_4
    //   886: istore_2
    //   887: goto -589 -> 298
    //   890: astore 10
    //   892: aload 10
    //   894: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   897: aload_0
    //   898: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   901: aload_0
    //   902: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   905: iconst_3
    //   906: bipush 102
    //   908: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   911: aload 13
    //   913: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   916: aload 14
    //   918: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   921: return
    //   922: astore 10
    //   924: return
    //   925: astore 10
    //   927: aload 13
    //   929: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   932: aload 14
    //   934: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   937: aload 10
    //   939: athrow
    //   940: aload 13
    //   942: ldc 214
    //   944: ldc_w 263
    //   947: invokevirtual 201	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: goto -188 -> 762
    //   953: astore 11
    //   955: aload 11
    //   957: invokevirtual 264	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   960: iload_2
    //   961: istore_1
    //   962: aload 10
    //   964: astore 11
    //   966: iload 4
    //   968: istore_3
    //   969: goto -929 -> 40
    //   972: astore 11
    //   974: aload 11
    //   976: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   979: iload_2
    //   980: istore_1
    //   981: aload 10
    //   983: astore 11
    //   985: iload 4
    //   987: istore_3
    //   988: goto -948 -> 40
    //   991: aload 13
    //   993: invokeinterface 253 1 0
    //   998: ldc_w 266
    //   1001: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1004: ifne +44 -> 1048
    //   1007: aload 13
    //   1009: invokeinterface 253 1 0
    //   1014: ldc_w 268
    //   1017: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1020: ifne +28 -> 1048
    //   1023: iload_2
    //   1024: istore_1
    //   1025: aload 10
    //   1027: astore 11
    //   1029: iload 4
    //   1031: istore_3
    //   1032: aload 13
    //   1034: invokeinterface 253 1 0
    //   1039: ldc_w 270
    //   1042: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1045: ifeq -1005 -> 40
    //   1048: aload_0
    //   1049: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1052: aload_0
    //   1053: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1056: iconst_3
    //   1057: sipush 206
    //   1060: invokevirtual 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1063: return
    //   1064: aload_0
    //   1065: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1068: iconst_0
    //   1069: aload 11
    //   1071: arraylength
    //   1072: i2l
    //   1073: invokevirtual 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1076: new 275	java/io/DataInputStream
    //   1079: dup
    //   1080: aload 13
    //   1082: invokeinterface 279 1 0
    //   1087: invokeinterface 285 1 0
    //   1092: invokespecial 288	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   1095: astore 11
    //   1097: aload 11
    //   1099: ldc2_w 289
    //   1102: invokevirtual 291	java/io/DataInputStream:skip	(J)J
    //   1105: pop2
    //   1106: aload 11
    //   1108: invokevirtual 295	java/io/DataInputStream:readByte	()B
    //   1111: ifeq +8 -> 1119
    //   1114: iconst_0
    //   1115: istore_2
    //   1116: goto -818 -> 298
    //   1119: aload 11
    //   1121: invokevirtual 298	java/io/DataInputStream:readInt	()I
    //   1124: i2l
    //   1125: lstore 6
    //   1127: aload 11
    //   1129: invokevirtual 298	java/io/DataInputStream:readInt	()I
    //   1132: i2l
    //   1133: lstore 8
    //   1135: aload 13
    //   1137: invokeinterface 279 1 0
    //   1142: invokeinterface 301 1 0
    //   1147: aload_0
    //   1148: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1151: lload 6
    //   1153: ldc2_w 302
    //   1156: land
    //   1157: lload 8
    //   1159: bipush 32
    //   1161: lshl
    //   1162: lor
    //   1163: putfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1166: aload_0
    //   1167: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1170: aload_0
    //   1171: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1174: invokevirtual 306	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1177: iconst_0
    //   1178: istore_1
    //   1179: aload 10
    //   1181: astore 11
    //   1183: iload 4
    //   1185: istore_3
    //   1186: goto -1146 -> 40
    //   1189: astore 11
    //   1191: aload 11
    //   1193: invokevirtual 307	java/lang/IllegalStateException:printStackTrace	()V
    //   1196: iload_2
    //   1197: istore_1
    //   1198: aload 10
    //   1200: astore 11
    //   1202: iload 4
    //   1204: istore_3
    //   1205: goto -1165 -> 40
    //   1208: astore 11
    //   1210: aload 11
    //   1212: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   1215: iload_2
    //   1216: istore_1
    //   1217: aload 10
    //   1219: astore 11
    //   1221: iload 4
    //   1223: istore_3
    //   1224: goto -1184 -> 40
    //   1227: aload_0
    //   1228: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1231: aload_0
    //   1232: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1235: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1238: putfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1241: aload_0
    //   1242: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1245: aload_0
    //   1246: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1249: bipush 6
    //   1251: invokevirtual 310	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1254: aload_0
    //   1255: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1258: aload_0
    //   1259: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1262: invokevirtual 312	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1265: aload_0
    //   1266: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1269: aconst_null
    //   1270: putfield 315	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   1273: aload_0
    //   1274: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1277: aconst_null
    //   1278: putfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1281: aload_0
    //   1282: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1285: aload_0
    //   1286: getfield 35	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1289: aload_0
    //   1290: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1293: getfield 317	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1296: invokevirtual 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1299: iconst_1
    //   1300: invokevirtual 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1303: goto -986 -> 317
    //   1306: astore 11
    //   1308: goto -371 -> 937
    //   1311: astore 13
    //   1313: goto -663 -> 650
    //   1316: iload_2
    //   1317: iconst_1
    //   1318: iadd
    //   1319: istore_2
    //   1320: goto -1207 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1323	0	this	TaskHttpUpload
    //   36	1181	1	i	int
    //   41	1279	2	j	int
    //   34	1190	3	k	int
    //   255	967	4	m	int
    //   227	654	5	bool	boolean
    //   1125	27	6	l1	long
    //   1133	25	8	l2	long
    //   75	17	10	localInterruptedException	java.lang.InterruptedException
    //   213	29	10	localObject1	java.lang.Object
    //   340	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   368	3	10	localIOException1	java.io.IOException
    //   396	3	10	localIOException2	java.io.IOException
    //   404	446	10	localObject2	java.lang.Object
    //   890	3	10	localIOException3	java.io.IOException
    //   922	1	10	localException1	java.lang.Exception
    //   925	293	10	localObject3	java.lang.Object
    //   38	246	11	arrayOfByte	byte[]
    //   414	213	11	localIOException4	java.io.IOException
    //   638	214	11	localObject4	java.lang.Object
    //   953	3	11	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   964	1	11	localObject5	java.lang.Object
    //   972	3	11	localIOException5	java.io.IOException
    //   983	199	11	localObject6	java.lang.Object
    //   1189	3	11	localIllegalStateException	java.lang.IllegalStateException
    //   1200	1	11	localObject7	java.lang.Object
    //   1208	3	11	localIOException6	java.io.IOException
    //   1219	1	11	localObject8	java.lang.Object
    //   1306	1	11	localException2	java.lang.Exception
    //   29	233	12	localFile	java.io.File
    //   266	24	13	localFileInputStream	java.io.FileInputStream
    //   358	49	13	localIOException7	java.io.IOException
    //   462	674	13	localObject9	java.lang.Object
    //   1311	1	13	localException3	java.lang.Exception
    //   473	460	14	localObject10	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   51	74	75	java/lang/InterruptedException
    //   121	164	75	java/lang/InterruptedException
    //   165	210	75	java/lang/InterruptedException
    //   220	226	75	java/lang/InterruptedException
    //   229	243	75	java/lang/InterruptedException
    //   247	252	75	java/lang/InterruptedException
    //   257	268	75	java/lang/InterruptedException
    //   289	294	75	java/lang/InterruptedException
    //   342	357	75	java/lang/InterruptedException
    //   360	365	75	java/lang/InterruptedException
    //   390	395	75	java/lang/InterruptedException
    //   398	403	75	java/lang/InterruptedException
    //   406	411	75	java/lang/InterruptedException
    //   411	414	75	java/lang/InterruptedException
    //   416	421	75	java/lang/InterruptedException
    //   424	475	75	java/lang/InterruptedException
    //   640	650	75	java/lang/InterruptedException
    //   650	762	75	java/lang/InterruptedException
    //   762	776	75	java/lang/InterruptedException
    //   776	787	75	java/lang/InterruptedException
    //   787	833	75	java/lang/InterruptedException
    //   856	880	75	java/lang/InterruptedException
    //   911	921	75	java/lang/InterruptedException
    //   927	937	75	java/lang/InterruptedException
    //   937	940	75	java/lang/InterruptedException
    //   940	950	75	java/lang/InterruptedException
    //   955	960	75	java/lang/InterruptedException
    //   974	979	75	java/lang/InterruptedException
    //   991	1023	75	java/lang/InterruptedException
    //   1032	1048	75	java/lang/InterruptedException
    //   1048	1063	75	java/lang/InterruptedException
    //   1064	1076	75	java/lang/InterruptedException
    //   1076	1114	75	java/lang/InterruptedException
    //   1119	1177	75	java/lang/InterruptedException
    //   1191	1196	75	java/lang/InterruptedException
    //   1210	1215	75	java/lang/InterruptedException
    //   257	268	340	java/io/FileNotFoundException
    //   289	294	358	java/io/IOException
    //   268	289	368	java/io/IOException
    //   390	395	396	java/io/IOException
    //   268	289	404	finally
    //   370	390	404	finally
    //   406	411	414	java/io/IOException
    //   475	640	890	java/io/IOException
    //   911	921	922	java/lang/Exception
    //   475	640	925	finally
    //   892	911	925	finally
    //   776	787	953	org/apache/http/client/ClientProtocolException
    //   776	787	972	java/io/IOException
    //   1076	1114	1189	java/lang/IllegalStateException
    //   1119	1177	1189	java/lang/IllegalStateException
    //   1076	1114	1208	java/io/IOException
    //   1119	1177	1208	java/io/IOException
    //   927	937	1306	java/lang/Exception
    //   640	650	1311	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */