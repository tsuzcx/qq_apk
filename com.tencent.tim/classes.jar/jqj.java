import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class jqj
{
  private static String Ua = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  protected static String businessId;
  private static char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static boolean D(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verify");
    }
    ld(paramString2);
    if (dl(paramString1)) {
      return dm(paramString1);
    }
    return false;
  }
  
  /* Error */
  private static boolean E(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 44
    //   8: iconst_2
    //   9: new 70	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   16: ldc 75
    //   18: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 81
    //   27: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +10 -> 54
    //   47: aload_1
    //   48: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +5 -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: new 93	java/io/File
    //   59: dup
    //   60: new 70	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   67: aload_0
    //   68: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   74: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: invokevirtual 101	java/io/File:exists	()Z
    //   90: ifeq -36 -> 54
    //   93: new 103	java/io/BufferedInputStream
    //   96: dup
    //   97: new 105	java/io/FileInputStream
    //   100: dup
    //   101: new 70	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   108: aload_0
    //   109: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 107
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   129: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   132: astore 4
    //   134: new 113	org/json/JSONObject
    //   137: dup
    //   138: aload 4
    //   140: invokestatic 117	jqj:b	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   143: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   146: astore_3
    //   147: aload 4
    //   149: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   152: aload_3
    //   153: ldc 123
    //   155: invokevirtual 127	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   158: astore 5
    //   160: aload_3
    //   161: ldc 129
    //   163: invokevirtual 127	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   166: astore 6
    //   168: new 131	java/util/HashMap
    //   171: dup
    //   172: invokespecial 132	java/util/HashMap:<init>	()V
    //   175: astore 4
    //   177: aload 5
    //   179: ifnull +140 -> 319
    //   182: aload 5
    //   184: invokevirtual 136	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   187: astore 7
    //   189: aload 7
    //   191: invokeinterface 141 1 0
    //   196: ifeq +123 -> 319
    //   199: aload 7
    //   201: invokeinterface 145 1 0
    //   206: invokevirtual 146	java/lang/Object:toString	()Ljava/lang/String;
    //   209: astore 8
    //   211: aload 5
    //   213: aload 8
    //   215: invokevirtual 150	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   218: astore_3
    //   219: aload_3
    //   220: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifne -34 -> 189
    //   226: aload 4
    //   228: aload 8
    //   230: aload_3
    //   231: invokeinterface 156 3 0
    //   236: pop
    //   237: goto -48 -> 189
    //   240: astore_0
    //   241: iconst_1
    //   242: invokestatic 160	jqj:report	(I)V
    //   245: aload_0
    //   246: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_0
    //   252: iconst_3
    //   253: invokestatic 160	jqj:report	(I)V
    //   256: aload_0
    //   257: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: iconst_2
    //   264: invokestatic 160	jqj:report	(I)V
    //   267: aload_0
    //   268: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_3
    //   274: aload_3
    //   275: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   278: iconst_5
    //   279: invokestatic 160	jqj:report	(I)V
    //   282: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +29 -> 314
    //   288: ldc 44
    //   290: iconst_2
    //   291: new 70	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   298: ldc 167
    //   300: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 8
    //   305: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aconst_null
    //   315: astore_3
    //   316: goto -97 -> 219
    //   319: aload 6
    //   321: ifnull +525 -> 846
    //   324: aload 6
    //   326: invokevirtual 136	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   329: astore_3
    //   330: aload_3
    //   331: invokeinterface 141 1 0
    //   336: ifeq +510 -> 846
    //   339: aload_3
    //   340: invokeinterface 145 1 0
    //   345: invokevirtual 146	java/lang/Object:toString	()Ljava/lang/String;
    //   348: astore 5
    //   350: aload 5
    //   352: ifnull -22 -> 330
    //   355: aload_1
    //   356: aload 5
    //   358: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq -31 -> 330
    //   364: aload 4
    //   366: aload_1
    //   367: invokeinterface 177 2 0
    //   372: checkcast 169	java/lang/String
    //   375: astore_3
    //   376: new 70	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   383: aload_0
    //   384: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   390: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 180	jqj:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   403: astore_1
    //   404: aload_3
    //   405: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +11 -> 419
    //   411: aload_3
    //   412: aload_1
    //   413: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifne +55 -> 471
    //   419: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -368 -> 54
    //   425: ldc 44
    //   427: iconst_2
    //   428: new 70	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   435: ldc 182
    //   437: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 5
    //   442: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc 184
    //   447: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 186
    //   456: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_1
    //   460: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: iconst_0
    //   470: ireturn
    //   471: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +34 -> 508
    //   477: ldc 44
    //   479: iconst_2
    //   480: new 70	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   487: ldc 188
    //   489: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 5
    //   494: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc 190
    //   499: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aload 6
    //   510: aload 5
    //   512: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   515: astore_3
    //   516: aload_3
    //   517: ifnull +329 -> 846
    //   520: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +41 -> 564
    //   526: ldc 44
    //   528: iconst_2
    //   529: new 70	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   536: ldc 188
    //   538: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 5
    //   543: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc 196
    //   548: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_3
    //   552: invokevirtual 199	org/json/JSONArray:toString	()Ljava/lang/String;
    //   555: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: iconst_0
    //   565: istore_2
    //   566: iload_2
    //   567: aload_3
    //   568: invokevirtual 203	org/json/JSONArray:length	()I
    //   571: if_icmpge +275 -> 846
    //   574: aload_3
    //   575: iload_2
    //   576: invokevirtual 206	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   579: astore_1
    //   580: aload_1
    //   581: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +200 -> 784
    //   587: aload 4
    //   589: aload_1
    //   590: invokeinterface 177 2 0
    //   595: checkcast 169	java/lang/String
    //   598: astore 6
    //   600: new 70	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   607: aload_0
    //   608: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   614: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_1
    //   618: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 180	jqj:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   627: astore 7
    //   629: aload 6
    //   631: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: ifne +13 -> 647
    //   637: aload 6
    //   639: aload 7
    //   641: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifne +140 -> 784
    //   647: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq -596 -> 54
    //   653: ldc 44
    //   655: iconst_2
    //   656: new 70	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   663: ldc 208
    //   665: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 5
    //   670: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc 210
    //   675: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_1
    //   679: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 212
    //   684: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 6
    //   689: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc 214
    //   694: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 7
    //   699: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: iconst_0
    //   709: ireturn
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   715: iconst_5
    //   716: invokestatic 160	jqj:report	(I)V
    //   719: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   722: ifeq +29 -> 751
    //   725: ldc 44
    //   727: iconst_2
    //   728: new 70	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   735: ldc 167
    //   737: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 5
    //   742: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore_3
    //   753: goto -237 -> 516
    //   756: astore_1
    //   757: aload_1
    //   758: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   761: iconst_5
    //   762: invokestatic 160	jqj:report	(I)V
    //   765: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +11 -> 779
    //   771: ldc 44
    //   773: iconst_2
    //   774: ldc 216
    //   776: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aconst_null
    //   780: astore_1
    //   781: goto -201 -> 580
    //   784: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq +46 -> 833
    //   790: new 70	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   797: ldc 218
    //   799: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload 5
    //   804: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc 220
    //   809: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: astore 6
    //   814: aload_1
    //   815: ifnull +25 -> 840
    //   818: ldc 44
    //   820: iconst_2
    //   821: aload 6
    //   823: aload_1
    //   824: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   833: iload_2
    //   834: iconst_1
    //   835: iadd
    //   836: istore_2
    //   837: goto -271 -> 566
    //   840: ldc 222
    //   842: astore_1
    //   843: goto -25 -> 818
    //   846: iconst_1
    //   847: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	paramString1	String
    //   0	848	1	paramString2	String
    //   565	272	2	i	int
    //   146	85	3	localObject1	Object
    //   273	2	3	localJSONException	org.json.JSONException
    //   315	438	3	localObject2	Object
    //   132	456	4	localObject3	Object
    //   158	645	5	localObject4	Object
    //   166	656	6	localObject5	Object
    //   187	511	7	localObject6	Object
    //   209	95	8	str	String
    // Exception table:
    //   from	to	target	type
    //   93	168	240	java/io/FileNotFoundException
    //   93	168	251	org/json/JSONException
    //   93	168	262	java/io/IOException
    //   211	219	273	org/json/JSONException
    //   508	516	710	org/json/JSONException
    //   574	580	756	org/json/JSONException
  }
  
  public static boolean F(String paramString1, String paramString2)
  {
    ld(paramString2);
    return dl(paramString1);
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify");
      }
      paramString = aqgo.decode(paramString.getBytes("UTF-8"), 0);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localKeyFactory.generatePublic(new X509EncodedKeySpec(paramString)));
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify error:" + paramString.toString());
      }
      paramString.printStackTrace();
      report(4);
    }
    return false;
  }
  
  public static byte[] a(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramBufferedInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramBufferedInputStream;
  }
  
  public static String b(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3)
  {
    ld(paramString3);
    if (dl(paramString1)) {
      return E(paramString1, paramString2);
    }
    return false;
  }
  
  /* Error */
  private static boolean dl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 44
    //   10: iconst_2
    //   11: ldc_w 311
    //   14: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: new 93	java/io/File
    //   20: dup
    //   21: new 70	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 313
    //   35: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 101	java/io/File:exists	()Z
    //   49: ifne +20 -> 69
    //   52: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +12 -> 67
    //   58: ldc 44
    //   60: iconst_2
    //   61: ldc_w 315
    //   64: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: new 103	java/io/BufferedInputStream
    //   72: dup
    //   73: new 105	java/io/FileInputStream
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_3
    //   85: aload_3
    //   86: invokestatic 320	jqj:a	(Ljava/io/BufferedInputStream;)[B
    //   89: astore 4
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   99: new 93	java/io/File
    //   102: dup
    //   103: new 70	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 322
    //   117: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 101	java/io/File:exists	()Z
    //   131: ifne +85 -> 216
    //   134: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -70 -> 67
    //   140: ldc 44
    //   142: iconst_2
    //   143: ldc_w 324
    //   146: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +12 -> 167
    //   158: ldc 44
    //   160: iconst_2
    //   161: ldc_w 326
    //   164: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iconst_1
    //   168: invokestatic 160	jqj:report	(I)V
    //   171: aload_0
    //   172: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_0
    //   191: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +12 -> 206
    //   197: ldc 44
    //   199: iconst_2
    //   200: ldc_w 328
    //   203: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iconst_2
    //   207: invokestatic 160	jqj:report	(I)V
    //   210: aload_0
    //   211: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   214: iconst_0
    //   215: ireturn
    //   216: new 103	java/io/BufferedInputStream
    //   219: dup
    //   220: new 105	java/io/FileInputStream
    //   223: dup
    //   224: aload_0
    //   225: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   228: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   231: astore_0
    //   232: aload_0
    //   233: invokestatic 320	jqj:a	(Ljava/io/BufferedInputStream;)[B
    //   236: astore_2
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   245: getstatic 15	jqj:Ua	Ljava/lang/String;
    //   248: aload 4
    //   250: aload_2
    //   251: invokestatic 330	jqj:a	(Ljava/lang/String;[B[B)Z
    //   254: istore_1
    //   255: iload_1
    //   256: ireturn
    //   257: astore_0
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_3
    //   269: goto -170 -> 99
    //   272: astore_2
    //   273: goto -85 -> 188
    //   276: astore_0
    //   277: goto -32 -> 245
    //   280: astore_2
    //   281: goto -15 -> 266
    //   284: astore_3
    //   285: aload_0
    //   286: astore_2
    //   287: aload_3
    //   288: astore_0
    //   289: goto -31 -> 258
    //   292: astore_0
    //   293: aload_3
    //   294: astore_2
    //   295: goto -115 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramString	String
    //   254	2	1	bool	boolean
    //   1	262	2	arrayOfByte1	byte[]
    //   272	1	2	localIOException1	IOException
    //   280	1	2	localIOException2	IOException
    //   286	9	2	localObject1	Object
    //   44	52	3	localObject2	Object
    //   268	1	3	localIOException3	IOException
    //   284	10	3	localObject3	Object
    //   89	160	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	67	151	java/io/FileNotFoundException
    //   95	99	151	java/io/FileNotFoundException
    //   99	149	151	java/io/FileNotFoundException
    //   184	188	151	java/io/FileNotFoundException
    //   188	190	151	java/io/FileNotFoundException
    //   241	245	151	java/io/FileNotFoundException
    //   245	255	151	java/io/FileNotFoundException
    //   262	266	151	java/io/FileNotFoundException
    //   266	268	151	java/io/FileNotFoundException
    //   69	85	177	finally
    //   17	67	190	java/io/IOException
    //   99	149	190	java/io/IOException
    //   188	190	190	java/io/IOException
    //   245	255	190	java/io/IOException
    //   266	268	190	java/io/IOException
    //   216	232	257	finally
    //   95	99	268	java/io/IOException
    //   184	188	272	java/io/IOException
    //   241	245	276	java/io/IOException
    //   262	266	280	java/io/IOException
    //   232	237	284	finally
    //   85	91	292	finally
  }
  
  /* Error */
  private static boolean dm(String paramString)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 44
    //   8: iconst_2
    //   9: ldc_w 332
    //   12: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_3
    //   22: new 103	java/io/BufferedInputStream
    //   25: dup
    //   26: new 105	java/io/FileInputStream
    //   29: dup
    //   30: new 70	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 313
    //   44: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_1
    //   57: aload_1
    //   58: astore_2
    //   59: new 113	org/json/JSONObject
    //   62: dup
    //   63: aload_1
    //   64: invokestatic 117	jqj:b	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   67: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_3
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   79: aload_3
    //   80: invokevirtual 136	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   83: astore_1
    //   84: aload_1
    //   85: invokeinterface 141 1 0
    //   90: ifeq +289 -> 379
    //   93: aload_1
    //   94: invokeinterface 145 1 0
    //   99: invokevirtual 146	java/lang/Object:toString	()Ljava/lang/String;
    //   102: astore_2
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual 150	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: new 70	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   122: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 180	jqj:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne -54 -> 84
    //   141: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +29 -> 173
    //   147: ldc 44
    //   149: iconst_2
    //   150: new 70	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 334
    //   160: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: bipush 6
    //   175: invokestatic 160	jqj:report	(I)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: astore_2
    //   185: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +14 -> 202
    //   191: aload_1
    //   192: astore_2
    //   193: ldc 44
    //   195: iconst_2
    //   196: ldc_w 336
    //   199: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_1
    //   203: astore_2
    //   204: iconst_1
    //   205: invokestatic 160	jqj:report	(I)V
    //   208: aload_1
    //   209: astore_2
    //   210: aload_0
    //   211: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull -37 -> 178
    //   218: aload_1
    //   219: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_1
    //   228: aload_3
    //   229: astore_0
    //   230: aload_0
    //   231: astore_2
    //   232: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +14 -> 249
    //   238: aload_0
    //   239: astore_2
    //   240: ldc 44
    //   242: iconst_2
    //   243: ldc_w 338
    //   246: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: astore_2
    //   251: iconst_3
    //   252: invokestatic 160	jqj:report	(I)V
    //   255: aload_0
    //   256: astore_2
    //   257: aload_1
    //   258: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   261: aload_0
    //   262: ifnull -84 -> 178
    //   265: aload_0
    //   266: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_0
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_1
    //   275: aload 4
    //   277: astore_0
    //   278: aload_0
    //   279: astore_2
    //   280: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +14 -> 297
    //   286: aload_0
    //   287: astore_2
    //   288: ldc 44
    //   290: iconst_2
    //   291: ldc_w 340
    //   294: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: astore_2
    //   299: iconst_2
    //   300: invokestatic 160	jqj:report	(I)V
    //   303: aload_0
    //   304: astore_2
    //   305: aload_1
    //   306: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   309: aload_0
    //   310: ifnull -132 -> 178
    //   313: aload_0
    //   314: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_0
    //   323: aload_2
    //   324: ifnull +7 -> 331
    //   327: aload_2
    //   328: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   331: aload_0
    //   332: athrow
    //   333: astore 4
    //   335: aload 4
    //   337: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   340: iconst_5
    //   341: invokestatic 160	jqj:report	(I)V
    //   344: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -263 -> 84
    //   350: ldc 44
    //   352: iconst_2
    //   353: new 70	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 342
    //   363: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_2
    //   367: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: goto -292 -> 84
    //   379: iconst_1
    //   380: ireturn
    //   381: astore_1
    //   382: goto -303 -> 79
    //   385: astore_1
    //   386: goto -55 -> 331
    //   389: astore_0
    //   390: goto -67 -> 323
    //   393: astore_2
    //   394: aload_1
    //   395: astore_0
    //   396: aload_2
    //   397: astore_1
    //   398: goto -120 -> 278
    //   401: astore_2
    //   402: aload_1
    //   403: astore_0
    //   404: aload_2
    //   405: astore_1
    //   406: goto -176 -> 230
    //   409: astore_0
    //   410: goto -227 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString	String
    //   56	163	1	localObject1	Object
    //   227	31	1	localJSONException1	org.json.JSONException
    //   274	32	1	localIOException1	IOException
    //   381	1	1	localIOException2	IOException
    //   385	10	1	localIOException3	IOException
    //   397	9	1	localObject2	Object
    //   19	348	2	localObject3	Object
    //   393	4	2	localIOException4	IOException
    //   401	4	2	localJSONException2	org.json.JSONException
    //   21	208	3	localJSONObject	org.json.JSONObject
    //   16	260	4	localObject4	Object
    //   333	3	4	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   22	57	180	java/io/FileNotFoundException
    //   218	222	224	java/io/IOException
    //   22	57	227	org/json/JSONException
    //   265	269	271	java/io/IOException
    //   22	57	274	java/io/IOException
    //   313	317	319	java/io/IOException
    //   22	57	322	finally
    //   232	238	322	finally
    //   240	249	322	finally
    //   251	255	322	finally
    //   257	261	322	finally
    //   280	286	322	finally
    //   288	297	322	finally
    //   299	303	322	finally
    //   305	309	322	finally
    //   103	173	333	org/json/JSONException
    //   173	178	333	org/json/JSONException
    //   75	79	381	java/io/IOException
    //   327	331	385	java/io/IOException
    //   59	71	389	finally
    //   185	191	389	finally
    //   193	202	389	finally
    //   204	208	389	finally
    //   210	214	389	finally
    //   59	71	393	java/io/IOException
    //   59	71	401	org/json/JSONException
    //   59	71	409	java/io/FileNotFoundException
  }
  
  public static boolean e(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
    }
    ld(paramString3);
    if (dl(paramString2)) {
      return f(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  /* Error */
  public static boolean f(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 345
    //   9: iconst_2
    //   10: ldc_w 352
    //   13: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokestatic 54	jqj:ld	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +17 -> 41
    //   27: aload_1
    //   28: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +10 -> 41
    //   34: aload_2
    //   35: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 9
    //   49: aconst_null
    //   50: astore 10
    //   52: aconst_null
    //   53: astore 11
    //   55: aconst_null
    //   56: astore 4
    //   58: aload 8
    //   60: astore 5
    //   62: aload 9
    //   64: astore 6
    //   66: aload 10
    //   68: astore 7
    //   70: aload 11
    //   72: astore_3
    //   73: getstatic 358	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +123 -> 199
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: astore 6
    //   87: aload 10
    //   89: astore 7
    //   91: aload 11
    //   93: astore_3
    //   94: getstatic 358	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: invokevirtual 363	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq +98 -> 199
    //   104: aload 8
    //   106: astore 5
    //   108: aload 9
    //   110: astore 6
    //   112: aload 10
    //   114: astore 7
    //   116: aload 11
    //   118: astore_3
    //   119: getstatic 358	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: aload_2
    //   123: invokevirtual 364	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 169	java/lang/String
    //   129: astore 8
    //   131: aload 4
    //   133: astore_2
    //   134: aload 8
    //   136: astore 4
    //   138: aload_2
    //   139: astore 5
    //   141: aload_2
    //   142: astore 6
    //   144: aload_2
    //   145: astore 7
    //   147: aload_2
    //   148: astore_3
    //   149: new 113	org/json/JSONObject
    //   152: dup
    //   153: aload 4
    //   155: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   158: astore 4
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   168: aload 4
    //   170: aload_0
    //   171: invokevirtual 367	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: aload_2
    //   176: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +323 -> 502
    //   182: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 44
    //   190: iconst_2
    //   191: ldc_w 369
    //   194: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: aload 8
    //   201: astore 5
    //   203: aload 9
    //   205: astore 6
    //   207: aload 10
    //   209: astore 7
    //   211: aload 11
    //   213: astore_3
    //   214: new 103	java/io/BufferedInputStream
    //   217: dup
    //   218: new 105	java/io/FileInputStream
    //   221: dup
    //   222: new 70	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   229: aload_1
    //   230: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 313
    //   236: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   245: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   248: astore 4
    //   250: aload 4
    //   252: invokestatic 117	jqj:b	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   255: astore_3
    //   256: getstatic 358	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   259: aload_2
    //   260: aload_3
    //   261: invokevirtual 370	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: aload 4
    //   267: astore_2
    //   268: aload_3
    //   269: astore 4
    //   271: goto -133 -> 138
    //   274: astore_2
    //   275: ldc 44
    //   277: iconst_1
    //   278: ldc_w 372
    //   281: aload_2
    //   282: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -117 -> 168
    //   288: astore_0
    //   289: aload 5
    //   291: astore_3
    //   292: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +16 -> 311
    //   298: aload 5
    //   300: astore_3
    //   301: ldc_w 345
    //   304: iconst_2
    //   305: ldc_w 377
    //   308: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload 5
    //   313: astore_3
    //   314: iconst_1
    //   315: invokestatic 160	jqj:report	(I)V
    //   318: aload 5
    //   320: astore_3
    //   321: aload_0
    //   322: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_0
    //   338: ldc 44
    //   340: iconst_1
    //   341: ldc_w 372
    //   344: aload_0
    //   345: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -13 -> 335
    //   351: astore_0
    //   352: aload 6
    //   354: astore_3
    //   355: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +16 -> 374
    //   361: aload 6
    //   363: astore_3
    //   364: ldc_w 345
    //   367: iconst_2
    //   368: ldc_w 379
    //   371: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 6
    //   376: astore_3
    //   377: iconst_3
    //   378: invokestatic 160	jqj:report	(I)V
    //   381: aload 6
    //   383: astore_3
    //   384: aload_0
    //   385: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   388: aload 6
    //   390: ifnull +8 -> 398
    //   393: aload 6
    //   395: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   398: iconst_0
    //   399: ireturn
    //   400: astore_0
    //   401: ldc 44
    //   403: iconst_1
    //   404: ldc_w 372
    //   407: aload_0
    //   408: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: goto -13 -> 398
    //   414: astore_0
    //   415: aload 7
    //   417: astore_3
    //   418: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +16 -> 437
    //   424: aload 7
    //   426: astore_3
    //   427: ldc_w 345
    //   430: iconst_2
    //   431: ldc_w 381
    //   434: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 7
    //   439: astore_3
    //   440: iconst_2
    //   441: invokestatic 160	jqj:report	(I)V
    //   444: aload 7
    //   446: astore_3
    //   447: aload_0
    //   448: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   451: aload 7
    //   453: ifnull +8 -> 461
    //   456: aload 7
    //   458: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   461: iconst_0
    //   462: ireturn
    //   463: astore_0
    //   464: ldc 44
    //   466: iconst_1
    //   467: ldc_w 372
    //   470: aload_0
    //   471: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: goto -13 -> 461
    //   477: astore_0
    //   478: aload_3
    //   479: ifnull +7 -> 486
    //   482: aload_3
    //   483: invokevirtual 121	java/io/BufferedInputStream:close	()V
    //   486: aload_0
    //   487: athrow
    //   488: astore_1
    //   489: ldc 44
    //   491: iconst_1
    //   492: ldc_w 372
    //   495: aload_1
    //   496: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   499: goto -13 -> 486
    //   502: aload_2
    //   503: new 70	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   510: aload_1
    //   511: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   517: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_0
    //   521: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 180	jqj:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   533: ifne +42 -> 575
    //   536: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +29 -> 568
    //   542: ldc 44
    //   544: iconst_2
    //   545: new 70	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 383
    //   555: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_0
    //   559: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: bipush 6
    //   570: invokestatic 160	jqj:report	(I)V
    //   573: iconst_0
    //   574: ireturn
    //   575: iconst_1
    //   576: ireturn
    //   577: astore_0
    //   578: aload 4
    //   580: astore_3
    //   581: goto -103 -> 478
    //   584: astore_0
    //   585: aload 4
    //   587: astore 7
    //   589: goto -174 -> 415
    //   592: astore_0
    //   593: aload 4
    //   595: astore 6
    //   597: goto -245 -> 352
    //   600: astore_0
    //   601: aload 4
    //   603: astore 5
    //   605: goto -316 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramString1	String
    //   0	608	1	paramString2	String
    //   0	608	2	paramString3	String
    //   72	509	3	localObject1	Object
    //   56	546	4	localObject2	Object
    //   60	544	5	localObject3	Object
    //   64	532	6	localObject4	Object
    //   68	520	7	localObject5	Object
    //   44	156	8	str	String
    //   47	157	9	localObject6	Object
    //   50	158	10	localObject7	Object
    //   53	159	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   164	168	274	java/lang/Exception
    //   73	79	288	java/io/FileNotFoundException
    //   94	104	288	java/io/FileNotFoundException
    //   119	131	288	java/io/FileNotFoundException
    //   149	160	288	java/io/FileNotFoundException
    //   214	250	288	java/io/FileNotFoundException
    //   330	335	337	java/lang/Exception
    //   73	79	351	org/json/JSONException
    //   94	104	351	org/json/JSONException
    //   119	131	351	org/json/JSONException
    //   149	160	351	org/json/JSONException
    //   214	250	351	org/json/JSONException
    //   393	398	400	java/lang/Exception
    //   73	79	414	java/io/IOException
    //   94	104	414	java/io/IOException
    //   119	131	414	java/io/IOException
    //   149	160	414	java/io/IOException
    //   214	250	414	java/io/IOException
    //   456	461	463	java/lang/Exception
    //   73	79	477	finally
    //   94	104	477	finally
    //   119	131	477	finally
    //   149	160	477	finally
    //   214	250	477	finally
    //   292	298	477	finally
    //   301	311	477	finally
    //   314	318	477	finally
    //   321	325	477	finally
    //   355	361	477	finally
    //   364	374	477	finally
    //   377	381	477	finally
    //   384	388	477	finally
    //   418	424	477	finally
    //   427	437	477	finally
    //   440	444	477	finally
    //   447	451	477	finally
    //   482	486	488	java/lang/Exception
    //   250	265	577	finally
    //   250	265	584	java/io/IOException
    //   250	265	592	org/json/JSONException
    //   250	265	600	java/io/FileNotFoundException
  }
  
  public static String getFileSHA1(String paramString)
  {
    try
    {
      paramString = getHash(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static String getHash(String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: new 103	java/io/BufferedInputStream
    //   3: dup
    //   4: new 105	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 396	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 399	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +28 -> 62
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 401	java/security/MessageDigest:update	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 402	java/io/InputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 402	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 405	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 409	jqj:toHexString	([B)Ljava/lang/String;
    //   77: areturn
    //   78: astore_0
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -37 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   32	9	2	i	int
    //   21	18	3	arrayOfByte	byte[]
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   66	70	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   0	16	86	finally
  }
  
  private static void ld(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    businessId = str;
  }
  
  private static void report(int paramInt)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(businessId).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label14:
      break label14;
    }
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("offlneSecurity", 2, "report:" + paramInt);
    }
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(hexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqj
 * JD-Core Version:    0.7.0.1
 */