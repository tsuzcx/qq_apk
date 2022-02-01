package com.tencent.mobileqq.highway.openup;

public class SessionInfo
{
  private static final String HW_SESSION_EXT_NAME = ".highways";
  private static final String HW_SESSION_INFO_DIRNAME = "highway_session_info_dir";
  private static final String HW_SESSION_INFO_FILENAME = "highway_session_info";
  private static volatile SessionInfo sessionInfo;
  private byte[] bytes_httpconn_sig_session;
  private byte[] bytes_session_key;
  private String mUin;
  
  private SessionInfo(String paramString)
  {
    this.mUin = paramString;
    loadFromDisk(paramString);
  }
  
  /* Error */
  public static void clearOldSession()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 34
    //   5: ldc 36
    //   7: invokestatic 42	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 48	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: new 50	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   30: ldc 14
    //   32: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 63	java/io/File:exists	()Z
    //   40: ifeq -22 -> 18
    //   43: aload_0
    //   44: invokevirtual 66	java/io/File:delete	()Z
    //   47: pop
    //   48: goto -30 -> 18
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	31	0	localObject1	Object
    //   51	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	51	finally
    //   22	48	51	finally
  }
  
  public static SessionInfo getInstance(String paramString)
  {
    try
    {
      if ((sessionInfo == null) || (sessionInfo.mUin == null) || (!sessionInfo.mUin.equals(paramString))) {
        sessionInfo = new SessionInfo(paramString);
      }
      return sessionInfo;
    }
    finally {}
  }
  
  /* Error */
  private void loadFromDisk(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: invokestatic 48	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull -8 -> 6
    //   17: new 50	java/io/File
    //   20: dup
    //   21: new 50	java/io/File
    //   24: dup
    //   25: aload 4
    //   27: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   30: ldc 11
    //   32: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: new 84	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   42: aload_1
    //   43: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 8
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 63	java/io/File:exists	()Z
    //   62: ifeq +129 -> 191
    //   65: new 95	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   68: dup
    //   69: invokespecial 96	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   72: astore 7
    //   74: new 98	java/io/FileInputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: astore_1
    //   83: new 103	java/io/ByteArrayOutputStream
    //   86: dup
    //   87: invokespecial 104	java/io/ByteArrayOutputStream:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: astore 6
    //   96: aload_1
    //   97: astore 5
    //   99: sipush 128
    //   102: newarray byte
    //   104: astore_3
    //   105: aload 4
    //   107: astore 6
    //   109: aload_1
    //   110: astore 5
    //   112: aload_1
    //   113: aload_3
    //   114: iconst_0
    //   115: aload_3
    //   116: arraylength
    //   117: invokevirtual 108	java/io/FileInputStream:read	([BII)I
    //   120: istore_2
    //   121: iload_2
    //   122: iconst_m1
    //   123: if_icmpeq +103 -> 226
    //   126: aload 4
    //   128: astore 6
    //   130: aload_1
    //   131: astore 5
    //   133: aload 4
    //   135: aload_3
    //   136: iconst_0
    //   137: iload_2
    //   138: invokevirtual 112	java/io/ByteArrayOutputStream:write	([BII)V
    //   141: goto -36 -> 105
    //   144: astore 5
    //   146: aload_1
    //   147: astore_3
    //   148: aload 4
    //   150: astore_1
    //   151: aload 5
    //   153: astore 4
    //   155: ldc 34
    //   157: ldc 114
    //   159: aload 4
    //   161: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 121	java/io/FileInputStream:close	()V
    //   172: aload_1
    //   173: ifnull -167 -> 6
    //   176: aload_1
    //   177: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   180: return
    //   181: astore_1
    //   182: ldc 34
    //   184: ldc 114
    //   186: aload_1
    //   187: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: return
    //   191: new 50	java/io/File
    //   194: dup
    //   195: aload 4
    //   197: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   200: ldc 14
    //   202: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 4
    //   209: astore_1
    //   210: aload 4
    //   212: invokevirtual 63	java/io/File:exists	()Z
    //   215: ifne -150 -> 65
    //   218: ldc 34
    //   220: ldc 124
    //   222: invokestatic 42	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: return
    //   226: aload 4
    //   228: astore 6
    //   230: aload_1
    //   231: astore 5
    //   233: aload 4
    //   235: invokevirtual 127	java/io/ByteArrayOutputStream:flush	()V
    //   238: aload 4
    //   240: astore 6
    //   242: aload_1
    //   243: astore 5
    //   245: aload 7
    //   247: aload 4
    //   249: invokevirtual 131	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   252: invokevirtual 135	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   255: pop
    //   256: aload 4
    //   258: astore 6
    //   260: aload_1
    //   261: astore 5
    //   263: aload 7
    //   265: getfield 138	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   268: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   271: ifeq +25 -> 296
    //   274: aload 4
    //   276: astore 6
    //   278: aload_1
    //   279: astore 5
    //   281: aload_0
    //   282: aload 7
    //   284: getfield 138	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   287: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   290: invokevirtual 150	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   293: putfield 152	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_httpconn_sig_session	[B
    //   296: aload 4
    //   298: astore 6
    //   300: aload_1
    //   301: astore 5
    //   303: aload 7
    //   305: getfield 154	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   308: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   311: ifeq +25 -> 336
    //   314: aload 4
    //   316: astore 6
    //   318: aload_1
    //   319: astore 5
    //   321: aload_0
    //   322: aload 7
    //   324: getfield 154	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   327: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   330: invokevirtual 150	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   333: putfield 156	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_session_key	[B
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 121	java/io/FileInputStream:close	()V
    //   344: aload 4
    //   346: ifnull -340 -> 6
    //   349: aload 4
    //   351: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   354: return
    //   355: astore_1
    //   356: ldc 34
    //   358: ldc 114
    //   360: aload_1
    //   361: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   364: return
    //   365: astore_1
    //   366: ldc 34
    //   368: ldc 114
    //   370: aload_1
    //   371: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: goto -30 -> 344
    //   377: astore_3
    //   378: ldc 34
    //   380: ldc 114
    //   382: aload_3
    //   383: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   386: goto -214 -> 172
    //   389: astore 7
    //   391: aconst_null
    //   392: astore_3
    //   393: aconst_null
    //   394: astore_1
    //   395: aload_3
    //   396: astore 6
    //   398: aload_1
    //   399: astore 5
    //   401: ldc 34
    //   403: ldc 114
    //   405: aload 7
    //   407: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_1
    //   411: ifnull +7 -> 418
    //   414: aload_1
    //   415: invokevirtual 121	java/io/FileInputStream:close	()V
    //   418: aload_3
    //   419: ifnull -413 -> 6
    //   422: aload_3
    //   423: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   426: return
    //   427: astore_1
    //   428: ldc 34
    //   430: ldc 114
    //   432: aload_1
    //   433: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   436: return
    //   437: astore_1
    //   438: ldc 34
    //   440: ldc 114
    //   442: aload_1
    //   443: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: goto -28 -> 418
    //   449: astore_3
    //   450: aconst_null
    //   451: astore 4
    //   453: aconst_null
    //   454: astore_1
    //   455: aload_1
    //   456: ifnull +7 -> 463
    //   459: aload_1
    //   460: invokevirtual 121	java/io/FileInputStream:close	()V
    //   463: aload 4
    //   465: ifnull +8 -> 473
    //   468: aload 4
    //   470: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   473: aload_3
    //   474: athrow
    //   475: astore_1
    //   476: ldc 34
    //   478: ldc 114
    //   480: aload_1
    //   481: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   484: goto -21 -> 463
    //   487: astore_1
    //   488: ldc 34
    //   490: ldc 114
    //   492: aload_1
    //   493: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   496: goto -23 -> 473
    //   499: astore_3
    //   500: aconst_null
    //   501: astore 4
    //   503: goto -48 -> 455
    //   506: astore_3
    //   507: aload 6
    //   509: astore 4
    //   511: aload 5
    //   513: astore_1
    //   514: goto -59 -> 455
    //   517: astore 4
    //   519: aload_3
    //   520: astore 5
    //   522: aload 4
    //   524: astore_3
    //   525: aload_1
    //   526: astore 4
    //   528: aload 5
    //   530: astore_1
    //   531: goto -76 -> 455
    //   534: astore 7
    //   536: aconst_null
    //   537: astore_3
    //   538: goto -143 -> 395
    //   541: astore 7
    //   543: aload 4
    //   545: astore_3
    //   546: goto -151 -> 395
    //   549: astore 4
    //   551: aconst_null
    //   552: astore_1
    //   553: goto -398 -> 155
    //   556: astore 4
    //   558: aconst_null
    //   559: astore 5
    //   561: aload_1
    //   562: astore_3
    //   563: aload 5
    //   565: astore_1
    //   566: goto -411 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	SessionInfo
    //   0	569	1	paramString	String
    //   120	18	2	i	int
    //   1	168	3	localObject1	Object
    //   377	6	3	localIOException1	java.io.IOException
    //   392	31	3	localObject2	Object
    //   449	25	3	localObject3	Object
    //   499	1	3	localObject4	Object
    //   506	14	3	localObject5	Object
    //   524	39	3	localObject6	Object
    //   10	500	4	localObject7	Object
    //   517	6	4	localObject8	Object
    //   526	18	4	str1	String
    //   549	1	4	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   556	1	4	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   97	35	5	str2	String
    //   144	8	5	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   231	333	5	localObject9	Object
    //   94	414	6	localObject10	Object
    //   72	251	7	localHwSessionInfoPB	com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB.HwSessionInfoPB
    //   389	17	7	localIOException2	java.io.IOException
    //   534	1	7	localIOException3	java.io.IOException
    //   541	1	7	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   99	105	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   112	121	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   133	141	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   233	238	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   245	256	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   263	274	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	296	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   303	314	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   321	336	144	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   176	180	181	java/io/IOException
    //   349	354	355	java/io/IOException
    //   340	344	365	java/io/IOException
    //   168	172	377	java/io/IOException
    //   74	83	389	java/io/IOException
    //   422	426	427	java/io/IOException
    //   414	418	437	java/io/IOException
    //   74	83	449	finally
    //   459	463	475	java/io/IOException
    //   468	473	487	java/io/IOException
    //   83	92	499	finally
    //   99	105	506	finally
    //   112	121	506	finally
    //   133	141	506	finally
    //   233	238	506	finally
    //   245	256	506	finally
    //   263	274	506	finally
    //   281	296	506	finally
    //   303	314	506	finally
    //   321	336	506	finally
    //   401	410	506	finally
    //   155	164	517	finally
    //   83	92	534	java/io/IOException
    //   99	105	541	java/io/IOException
    //   112	121	541	java/io/IOException
    //   133	141	541	java/io/IOException
    //   233	238	541	java/io/IOException
    //   245	256	541	java/io/IOException
    //   263	274	541	java/io/IOException
    //   281	296	541	java/io/IOException
    //   303	314	541	java/io/IOException
    //   321	336	541	java/io/IOException
    //   74	83	549	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   83	92	556	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public static void updateSessionInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 34
    //   5: ldc 159
    //   7: invokestatic 42	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: ifnull +23 -> 34
    //   14: aload_0
    //   15: arraylength
    //   16: ifeq +18 -> 34
    //   19: aload_1
    //   20: ifnull +14 -> 34
    //   23: aload_1
    //   24: arraylength
    //   25: istore_3
    //   26: iload_3
    //   27: ifeq +7 -> 34
    //   30: aload_2
    //   31: ifnonnull +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: invokestatic 161	com/tencent/mobileqq/highway/openup/SessionInfo:clearOldSession	()V
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokestatic 165	com/tencent/mobileqq/highway/openup/SessionInfo:write2Disk	([B[BLjava/lang/String;)Z
    //   47: ifeq -13 -> 34
    //   50: aconst_null
    //   51: putstatic 70	com/tencent/mobileqq/highway/openup/SessionInfo:sessionInfo	Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   54: goto -20 -> 34
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramArrayOfByte1	byte[]
    //   0	63	1	paramArrayOfByte2	byte[]
    //   0	63	2	paramString	String
    //   25	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   3	10	57	finally
    //   14	19	57	finally
    //   23	26	57	finally
    //   38	54	57	finally
  }
  
  /* Error */
  private static boolean write2Disk(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: invokestatic 48	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: new 50	java/io/File
    //   13: dup
    //   14: aload_3
    //   15: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: ldc 11
    //   20: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 63	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_3
    //   32: invokevirtual 170	java/io/File:mkdir	()Z
    //   35: pop
    //   36: new 50	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: invokevirtual 173	java/io/File:getPath	()Ljava/lang/String;
    //   44: new 84	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 8
    //   57: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 63	java/io/File:exists	()Z
    //   71: ifeq +8 -> 79
    //   74: aload_2
    //   75: invokevirtual 66	java/io/File:delete	()Z
    //   78: pop
    //   79: new 177	java/io/FileOutputStream
    //   82: dup
    //   83: aload_2
    //   84: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_3
    //   88: aload_3
    //   89: astore_2
    //   90: new 95	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   93: dup
    //   94: invokespecial 96	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   97: astore 4
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: getfield 138	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: aload_0
    //   107: invokestatic 182	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: getfield 154	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: aload_1
    //   121: invokestatic 182	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 186	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   127: aload_3
    //   128: astore_2
    //   129: aload_3
    //   130: aload 4
    //   132: invokevirtual 187	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:toByteArray	()[B
    //   135: invokevirtual 190	java/io/FileOutputStream:write	([B)V
    //   138: aload_3
    //   139: astore_2
    //   140: ldc 34
    //   142: ldc 192
    //   144: invokestatic 42	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_0
    //   158: ldc 34
    //   160: ldc 195
    //   162: aload_0
    //   163: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_2
    //   173: ldc 34
    //   175: ldc 195
    //   177: aload_0
    //   178: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_3
    //   182: ifnull -174 -> 8
    //   185: aload_3
    //   186: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_0
    //   192: ldc 34
    //   194: ldc 195
    //   196: aload_0
    //   197: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: ldc 34
    //   209: ldc 195
    //   211: aload_0
    //   212: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload_3
    //   216: ifnull -208 -> 8
    //   219: aload_3
    //   220: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: ldc 34
    //   228: ldc 195
    //   230: aload_0
    //   231: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   247: aload_0
    //   248: athrow
    //   249: astore_1
    //   250: ldc 34
    //   252: ldc 195
    //   254: aload_1
    //   255: invokestatic 118	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: goto -11 -> 247
    //   261: astore_0
    //   262: goto -23 -> 239
    //   265: astore_0
    //   266: goto -61 -> 205
    //   269: astore_0
    //   270: goto -99 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramArrayOfByte1	byte[]
    //   0	273	1	paramArrayOfByte2	byte[]
    //   0	273	2	paramString	String
    //   3	217	3	localObject	Object
    //   97	34	4	localHwSessionInfoPB	com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB.HwSessionInfoPB
    // Exception table:
    //   from	to	target	type
    //   151	155	157	java/io/IOException
    //   79	88	168	java/io/FileNotFoundException
    //   185	189	191	java/io/IOException
    //   79	88	202	java/io/IOException
    //   219	223	225	java/io/IOException
    //   79	88	236	finally
    //   243	247	249	java/io/IOException
    //   90	99	261	finally
    //   101	113	261	finally
    //   115	127	261	finally
    //   129	138	261	finally
    //   140	147	261	finally
    //   173	181	261	finally
    //   207	215	261	finally
    //   90	99	265	java/io/IOException
    //   101	113	265	java/io/IOException
    //   115	127	265	java/io/IOException
    //   129	138	265	java/io/IOException
    //   140	147	265	java/io/IOException
    //   90	99	269	java/io/FileNotFoundException
    //   101	113	269	java/io/FileNotFoundException
    //   115	127	269	java/io/FileNotFoundException
    //   129	138	269	java/io/FileNotFoundException
    //   140	147	269	java/io/FileNotFoundException
  }
  
  public byte[] getHttpconn_sig_session()
  {
    return this.bytes_httpconn_sig_session;
  }
  
  public byte[] getSessionKey()
  {
    return this.bytes_session_key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.openup.SessionInfo
 * JD-Core Version:    0.7.0.1
 */