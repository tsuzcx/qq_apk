import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.util.LRULinkedHashMap;
import mqq.util.WeakReference;

public class arcm
{
  private static WeakReference<sud> bi;
  private static final LRULinkedHashMap<String, arcm.a> s = new LRULinkedHashMap(4);
  
  public static arcm.a a(String paramString)
  {
    if (AppSetting.aNT) {
      return null;
    }
    paramString = jpa.getFilePath(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = (arcm.a)s.get(paramString))
    {
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (!paramString.isExpired()) {}
      }
      else
      {
        str = null;
      }
      return str;
    }
  }
  
  /* Error */
  public static boolean rT(String paramString)
  {
    // Byte code:
    //   0: getstatic 31	com/tencent/common/config/AppSetting:aNT	Z
    //   3: ifeq +7 -> 10
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_3
    //   9: ireturn
    //   10: aload_0
    //   11: invokestatic 59	arcm:a	(Ljava/lang/String;)Larcm$a;
    //   14: ifnull +19 -> 33
    //   17: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc 66
    //   25: iconst_2
    //   26: ldc 68
    //   28: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_1
    //   32: ireturn
    //   33: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +11 -> 47
    //   39: ldc 66
    //   41: iconst_2
    //   42: ldc 74
    //   44: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokestatic 80	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: ldc 82
    //   53: invokevirtual 85	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 14
    //   58: aload 14
    //   60: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   71: lstore 4
    //   73: getstatic 95	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +42 -> 118
    //   79: getstatic 95	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: aload 14
    //   84: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   87: ifeq +31 -> 118
    //   90: getstatic 95	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   93: aload 14
    //   95: invokevirtual 102	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 104	java/lang/String
    //   101: astore 12
    //   103: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   106: lstore 6
    //   108: aload 12
    //   110: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +150 -> 263
    //   116: iconst_0
    //   117: ireturn
    //   118: new 106	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   125: aload 14
    //   127: invokestatic 113	jpe:dO	(Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 14
    //   135: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 119
    //   140: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 12
    //   148: new 125	java/io/File
    //   151: dup
    //   152: aload 12
    //   154: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   157: invokevirtual 131	java/io/File:exists	()Z
    //   160: istore_2
    //   161: iload_2
    //   162: ifne +5 -> 167
    //   165: iconst_0
    //   166: ireturn
    //   167: aconst_null
    //   168: astore 13
    //   170: new 133	java/io/BufferedInputStream
    //   173: dup
    //   174: new 135	java/io/FileInputStream
    //   177: dup
    //   178: aload 12
    //   180: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   183: invokespecial 139	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore 12
    //   188: aload 12
    //   190: invokestatic 145	jqj:b	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   193: astore 13
    //   195: getstatic 95	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   198: aload 14
    //   200: aload 13
    //   202: invokevirtual 149	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 12
    //   208: ifnull +704 -> 912
    //   211: aload 12
    //   213: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   216: aload 13
    //   218: astore 12
    //   220: goto -117 -> 103
    //   223: aload 12
    //   225: ifnull +681 -> 906
    //   228: aload 12
    //   230: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   233: aconst_null
    //   234: astore 12
    //   236: goto -133 -> 103
    //   239: aload 12
    //   241: ifnull +8 -> 249
    //   244: aload 12
    //   246: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: ldc 66
    //   254: iconst_1
    //   255: ldc 154
    //   257: aload_0
    //   258: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: new 160	org/json/JSONObject
    //   266: dup
    //   267: aload 12
    //   269: invokespecial 161	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   272: astore 12
    //   274: aload_0
    //   275: invokestatic 37	jpa:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 15
    //   280: aload 15
    //   282: ifnonnull +5 -> 287
    //   285: iconst_0
    //   286: ireturn
    //   287: aload 12
    //   289: aload 15
    //   291: invokevirtual 164	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   294: astore 13
    //   296: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   299: lstore 8
    //   301: getstatic 166	arcm:bi	Lmqq/util/WeakReference;
    //   304: ifnull +12 -> 316
    //   307: getstatic 166	arcm:bi	Lmqq/util/WeakReference;
    //   310: invokevirtual 171	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   313: ifnonnull +90 -> 403
    //   316: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   319: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   322: astore 12
    //   324: aload 12
    //   326: instanceof 183
    //   329: ifeq +49 -> 378
    //   332: aload 12
    //   334: ldc 185
    //   336: invokevirtual 191	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   339: astore 12
    //   341: aload 12
    //   343: instanceof 193
    //   346: ifeq +554 -> 900
    //   349: new 195	sud
    //   352: dup
    //   353: aload 12
    //   355: checkcast 193	com/tencent/common/app/AppInterface
    //   358: invokespecial 198	sud:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   361: astore 12
    //   363: new 168	mqq/util/WeakReference
    //   366: dup
    //   367: aload 12
    //   369: invokespecial 201	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   372: putstatic 166	arcm:bi	Lmqq/util/WeakReference;
    //   375: goto +560 -> 935
    //   378: aload 12
    //   380: instanceof 193
    //   383: ifeq +511 -> 894
    //   386: new 195	sud
    //   389: dup
    //   390: aload 12
    //   392: checkcast 193	com/tencent/common/app/AppInterface
    //   395: invokespecial 198	sud:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   398: astore 12
    //   400: goto -37 -> 363
    //   403: getstatic 166	arcm:bi	Lmqq/util/WeakReference;
    //   406: invokevirtual 171	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   409: checkcast 195	sud
    //   412: astore 12
    //   414: goto +521 -> 935
    //   417: aload 12
    //   419: aload 13
    //   421: invokevirtual 204	sud:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   424: astore 12
    //   426: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   429: lstore 10
    //   431: aload 12
    //   433: ifnonnull +5 -> 438
    //   436: iconst_0
    //   437: ireturn
    //   438: new 125	java/io/File
    //   441: dup
    //   442: invokestatic 208	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   445: invokevirtual 214	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   448: ldc 216
    //   450: invokespecial 219	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   453: astore 13
    //   455: aload 13
    //   457: invokevirtual 131	java/io/File:exists	()Z
    //   460: ifne +5 -> 465
    //   463: iconst_0
    //   464: ireturn
    //   465: new 125	java/io/File
    //   468: dup
    //   469: aload 13
    //   471: aload 12
    //   473: getfield 225	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   476: invokespecial 219	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   479: astore 13
    //   481: aload 13
    //   483: invokevirtual 131	java/io/File:exists	()Z
    //   486: ifne +5 -> 491
    //   489: iconst_0
    //   490: ireturn
    //   491: ldc 227
    //   493: astore 12
    //   495: aload 15
    //   497: ldc 229
    //   499: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   502: ifeq +46 -> 548
    //   505: ldc 234
    //   507: astore 12
    //   509: new 135	java/io/FileInputStream
    //   512: dup
    //   513: aload 13
    //   515: invokespecial 237	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   518: astore 14
    //   520: aload 14
    //   522: astore 13
    //   524: aload 14
    //   526: invokevirtual 243	java/io/InputStream:available	()I
    //   529: istore_1
    //   530: iload_1
    //   531: ifne +83 -> 614
    //   534: iconst_0
    //   535: istore_3
    //   536: aload 14
    //   538: ifnull -530 -> 8
    //   541: aload 14
    //   543: invokevirtual 244	java/io/InputStream:close	()V
    //   546: iconst_0
    //   547: ireturn
    //   548: aload 15
    //   550: ldc 246
    //   552: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   555: ifeq +10 -> 565
    //   558: ldc 248
    //   560: astore 12
    //   562: goto -53 -> 509
    //   565: aload 15
    //   567: ldc 250
    //   569: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   572: ifne +34 -> 606
    //   575: aload 15
    //   577: ldc 252
    //   579: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   582: ifne +24 -> 606
    //   585: aload 15
    //   587: ldc 254
    //   589: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   592: ifne +14 -> 606
    //   595: aload 15
    //   597: ldc_w 256
    //   600: invokevirtual 232	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   603: ifeq -94 -> 509
    //   606: ldc_w 258
    //   609: astore 12
    //   611: goto -102 -> 509
    //   614: aload 14
    //   616: astore 13
    //   618: iload_1
    //   619: newarray byte
    //   621: astore 16
    //   623: aload 14
    //   625: astore 13
    //   627: iload_1
    //   628: aload 14
    //   630: aload 16
    //   632: invokevirtual 262	java/io/InputStream:read	([B)I
    //   635: if_icmpne +254 -> 889
    //   638: aload 14
    //   640: astore 13
    //   642: new 104	java/lang/String
    //   645: dup
    //   646: aload 16
    //   648: ldc_w 264
    //   651: invokespecial 267	java/lang/String:<init>	([BLjava/lang/String;)V
    //   654: astore 16
    //   656: aload 14
    //   658: astore 13
    //   660: getstatic 23	arcm:s	Lcom/tencent/util/LRULinkedHashMap;
    //   663: aload 15
    //   665: new 6	arcm$a
    //   668: dup
    //   669: aload 12
    //   671: aload 16
    //   673: ldc_w 264
    //   676: invokespecial 270	arcm$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   679: invokevirtual 271	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   682: pop
    //   683: iconst_1
    //   684: istore_3
    //   685: iload_3
    //   686: istore_2
    //   687: aload 14
    //   689: ifnull +10 -> 699
    //   692: aload 14
    //   694: invokevirtual 244	java/io/InputStream:close	()V
    //   697: iload_3
    //   698: istore_2
    //   699: iload_2
    //   700: istore_3
    //   701: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   704: ifeq -696 -> 8
    //   707: ldc 66
    //   709: iconst_2
    //   710: new 106	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   717: ldc_w 273
    //   720: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: lload 6
    //   725: lload 4
    //   727: lsub
    //   728: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   731: ldc_w 278
    //   734: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: lload 8
    //   739: lload 6
    //   741: lsub
    //   742: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   745: ldc_w 280
    //   748: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: lload 10
    //   753: lload 8
    //   755: lsub
    //   756: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   759: ldc_w 282
    //   762: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   768: lload 4
    //   770: lsub
    //   771: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   774: ldc_w 284
    //   777: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_0
    //   781: invokestatic 37	jpa:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: iload_2
    //   794: ireturn
    //   795: aload 12
    //   797: ifnull +87 -> 884
    //   800: aload 12
    //   802: invokevirtual 244	java/io/InputStream:close	()V
    //   805: iconst_0
    //   806: istore_2
    //   807: goto -108 -> 699
    //   810: astore 12
    //   812: aconst_null
    //   813: astore 14
    //   815: aload 14
    //   817: astore 13
    //   819: ldc 66
    //   821: iconst_1
    //   822: aload 12
    //   824: invokevirtual 287	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   827: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aload 14
    //   832: ifnull +52 -> 884
    //   835: aload 14
    //   837: invokevirtual 244	java/io/InputStream:close	()V
    //   840: iconst_0
    //   841: istore_2
    //   842: goto -143 -> 699
    //   845: aload 13
    //   847: ifnull +8 -> 855
    //   850: aload 13
    //   852: invokevirtual 244	java/io/InputStream:close	()V
    //   855: aload_0
    //   856: athrow
    //   857: astore_0
    //   858: goto -13 -> 845
    //   861: astore 12
    //   863: goto -48 -> 815
    //   866: astore 12
    //   868: aload 14
    //   870: astore 12
    //   872: goto -77 -> 795
    //   875: astore_0
    //   876: goto -637 -> 239
    //   879: astore 13
    //   881: goto -658 -> 223
    //   884: iconst_0
    //   885: istore_2
    //   886: goto -187 -> 699
    //   889: iconst_0
    //   890: istore_3
    //   891: goto -206 -> 685
    //   894: aconst_null
    //   895: astore 12
    //   897: goto -534 -> 363
    //   900: aconst_null
    //   901: astore 12
    //   903: goto -540 -> 363
    //   906: aconst_null
    //   907: astore 12
    //   909: goto -806 -> 103
    //   912: aload 13
    //   914: astore 12
    //   916: goto -813 -> 103
    //   919: astore 12
    //   921: aconst_null
    //   922: astore 12
    //   924: goto -701 -> 223
    //   927: astore_0
    //   928: aload 13
    //   930: astore 12
    //   932: goto -693 -> 239
    //   935: aload 12
    //   937: ifnonnull -520 -> 417
    //   940: iconst_0
    //   941: ireturn
    //   942: astore 12
    //   944: aconst_null
    //   945: astore 12
    //   947: goto -152 -> 795
    //   950: astore_0
    //   951: aconst_null
    //   952: astore 13
    //   954: goto -109 -> 845
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	paramString	String
    //   529	107	1	i	int
    //   160	726	2	bool1	boolean
    //   7	884	3	bool2	boolean
    //   71	698	4	l1	long
    //   106	634	6	l2	long
    //   299	455	8	l3	long
    //   429	323	10	l4	long
    //   101	700	12	localObject1	Object
    //   810	13	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   861	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   866	1	12	localException1	java.lang.Exception
    //   870	45	12	localObject2	Object
    //   919	1	12	localException2	java.lang.Exception
    //   922	14	12	localObject3	Object
    //   942	1	12	localException3	java.lang.Exception
    //   945	1	12	localObject4	Object
    //   168	683	13	localObject5	Object
    //   879	50	13	localException4	java.lang.Exception
    //   952	1	13	localObject6	Object
    //   56	813	14	localObject7	Object
    //   278	386	15	str	String
    //   621	51	16	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   33	47	251	java/lang/Exception
    //   47	66	251	java/lang/Exception
    //   68	103	251	java/lang/Exception
    //   103	116	251	java/lang/Exception
    //   118	161	251	java/lang/Exception
    //   211	216	251	java/lang/Exception
    //   228	233	251	java/lang/Exception
    //   244	249	251	java/lang/Exception
    //   249	251	251	java/lang/Exception
    //   263	280	251	java/lang/Exception
    //   287	316	251	java/lang/Exception
    //   316	363	251	java/lang/Exception
    //   363	375	251	java/lang/Exception
    //   378	400	251	java/lang/Exception
    //   403	414	251	java/lang/Exception
    //   417	431	251	java/lang/Exception
    //   438	463	251	java/lang/Exception
    //   465	489	251	java/lang/Exception
    //   495	505	251	java/lang/Exception
    //   541	546	251	java/lang/Exception
    //   548	558	251	java/lang/Exception
    //   565	595	251	java/lang/Exception
    //   595	606	251	java/lang/Exception
    //   692	697	251	java/lang/Exception
    //   701	793	251	java/lang/Exception
    //   800	805	251	java/lang/Exception
    //   835	840	251	java/lang/Exception
    //   850	855	251	java/lang/Exception
    //   855	857	251	java/lang/Exception
    //   509	520	810	java/lang/OutOfMemoryError
    //   524	530	857	finally
    //   618	623	857	finally
    //   627	638	857	finally
    //   642	656	857	finally
    //   660	683	857	finally
    //   819	830	857	finally
    //   524	530	861	java/lang/OutOfMemoryError
    //   618	623	861	java/lang/OutOfMemoryError
    //   627	638	861	java/lang/OutOfMemoryError
    //   642	656	861	java/lang/OutOfMemoryError
    //   660	683	861	java/lang/OutOfMemoryError
    //   524	530	866	java/lang/Exception
    //   618	623	866	java/lang/Exception
    //   627	638	866	java/lang/Exception
    //   642	656	866	java/lang/Exception
    //   660	683	866	java/lang/Exception
    //   188	206	875	finally
    //   188	206	879	java/lang/Exception
    //   170	188	919	java/lang/Exception
    //   170	188	927	finally
    //   509	520	942	java/lang/Exception
    //   509	520	950	finally
  }
  
  public static class a
  {
    final long cacheTime;
    public final String data;
    public final String encoding;
    public final String mime;
    
    a(String paramString1, String paramString2, String paramString3)
    {
      this.mime = paramString1;
      this.data = paramString2;
      this.encoding = paramString3;
      this.cacheTime = SystemClock.elapsedRealtime();
    }
    
    boolean isExpired()
    {
      return SystemClock.elapsedRealtime() - this.cacheTime > 300000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcm
 * JD-Core Version:    0.7.0.1
 */