import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.utils.FileUtils.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class aqhq
{
  public static boolean cTY = true;
  public static Runnable hQ = new FileUtils.1();
  public static String unKnownFileTypeMark = "unknown_";
  
  public static void UD(String paramString)
  {
    if (!fileExists(paramString)) {}
    try
    {
      createFile(paramString);
      return;
    }
    catch (IOException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FileUtils", 2, "createFileIfNotExits", paramString);
    }
  }
  
  /* Error */
  public static void W(String paramString1, String paramString2, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +37 -> 43
    //   9: ldc 49
    //   11: iconst_2
    //   12: new 59	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   19: ldc 62
    //   21: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 68
    //   30: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: new 78	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: new 82	java/io/BufferedInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 8
    //   62: new 87	com/tencent/commonsdk/zip/QZipInputStream
    //   65: dup
    //   66: aload 8
    //   68: invokespecial 88	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 9
    //   73: new 90	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 94	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   88: sipush 8192
    //   91: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   94: astore 15
    //   96: aconst_null
    //   97: astore 10
    //   99: aconst_null
    //   100: astore 12
    //   102: aload 9
    //   104: invokevirtual 108	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   107: astore 11
    //   109: aload 11
    //   111: ifnonnull +87 -> 198
    //   114: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   117: aload 15
    //   119: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   122: invokestatic 118	java/lang/Math:random	()D
    //   125: ldc2_w 119
    //   128: dcmpg
    //   129: ifge +20 -> 149
    //   132: invokestatic 126	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   135: invokestatic 131	anpc:a	(Landroid/content/Context;)Lanpc;
    //   138: aconst_null
    //   139: ldc 133
    //   141: iconst_1
    //   142: lconst_0
    //   143: lconst_0
    //   144: aconst_null
    //   145: aconst_null
    //   146: invokevirtual 137	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   149: aload 9
    //   151: ifnull +8 -> 159
    //   154: aload 9
    //   156: invokevirtual 140	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   159: aload 8
    //   161: ifnull +8 -> 169
    //   164: aload 8
    //   166: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 142	java/io/FileInputStream:close	()V
    //   177: aload 12
    //   179: ifnull +8 -> 187
    //   182: aload 12
    //   184: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   187: aload 10
    //   189: ifnull +8 -> 197
    //   192: aload 10
    //   194: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   197: return
    //   198: aload 11
    //   200: invokevirtual 153	java/util/zip/ZipEntry:isDirectory	()Z
    //   203: ifne -101 -> 102
    //   206: aload 11
    //   208: invokevirtual 156	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   211: astore 11
    //   213: aload 11
    //   215: ifnull -113 -> 102
    //   218: aload 11
    //   220: ldc 158
    //   222: invokevirtual 164	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   225: ifne -123 -> 102
    //   228: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +29 -> 260
    //   234: ldc 49
    //   236: iconst_2
    //   237: new 59	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   244: ldc 166
    //   246: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 11
    //   251: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 11
    //   262: getstatic 170	java/io/File:separatorChar	C
    //   265: invokevirtual 174	java/lang/String:lastIndexOf	(I)I
    //   268: istore_3
    //   269: iload_3
    //   270: aload 11
    //   272: invokevirtual 178	java/lang/String:length	()I
    //   275: iconst_1
    //   276: isub
    //   277: if_icmpne +143 -> 420
    //   280: new 180	java/lang/IllegalArgumentException
    //   283: dup
    //   284: new 59	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   291: ldc 182
    //   293: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 11
    //   298: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokespecial 183	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   307: athrow
    //   308: astore 13
    //   310: aload_0
    //   311: astore 11
    //   313: aload 10
    //   315: astore_1
    //   316: iconst_0
    //   317: istore_3
    //   318: aload 13
    //   320: astore_0
    //   321: aload 8
    //   323: astore 10
    //   325: aload 12
    //   327: astore 8
    //   329: invokestatic 118	java/lang/Math:random	()D
    //   332: ldc2_w 119
    //   335: dcmpg
    //   336: ifge +30 -> 366
    //   339: invokestatic 126	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   342: invokestatic 131	anpc:a	(Landroid/content/Context;)Lanpc;
    //   345: astore 12
    //   347: iload_3
    //   348: ifne +426 -> 774
    //   351: iconst_1
    //   352: istore_2
    //   353: aload 12
    //   355: aconst_null
    //   356: ldc 133
    //   358: iload_2
    //   359: lconst_0
    //   360: lconst_0
    //   361: aconst_null
    //   362: aconst_null
    //   363: invokevirtual 137	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   366: aload 9
    //   368: ifnull +12 -> 380
    //   371: iload_3
    //   372: ifne +8 -> 380
    //   375: aload 9
    //   377: invokevirtual 140	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   380: aload 10
    //   382: ifnull +8 -> 390
    //   385: aload 10
    //   387: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   390: aload 11
    //   392: ifnull +8 -> 400
    //   395: aload 11
    //   397: invokevirtual 142	java/io/FileInputStream:close	()V
    //   400: aload 8
    //   402: ifnull +8 -> 410
    //   405: aload 8
    //   407: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   410: aload_1
    //   411: ifnull +7 -> 418
    //   414: aload_1
    //   415: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   418: aload_0
    //   419: athrow
    //   420: iload_3
    //   421: ifgt +213 -> 634
    //   424: iload_3
    //   425: ifge +195 -> 620
    //   428: aload_1
    //   429: astore 13
    //   431: aload 11
    //   433: astore 14
    //   435: iload_2
    //   436: ifeq +28 -> 464
    //   439: aload 11
    //   441: ldc 185
    //   443: invokevirtual 188	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   446: istore_3
    //   447: aload 11
    //   449: astore 14
    //   451: iload_3
    //   452: ifle +12 -> 464
    //   455: aload 11
    //   457: iconst_0
    //   458: iload_3
    //   459: invokevirtual 192	java/lang/String:substring	(II)Ljava/lang/String;
    //   462: astore 14
    //   464: new 90	java/io/File
    //   467: dup
    //   468: aload 13
    //   470: aload 14
    //   472: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: astore 11
    //   477: aload 11
    //   479: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   482: invokevirtual 202	java/io/File:exists	()Z
    //   485: ifne +12 -> 497
    //   488: aload 11
    //   490: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   493: invokevirtual 94	java/io/File:mkdirs	()Z
    //   496: pop
    //   497: aload 11
    //   499: invokevirtual 202	java/io/File:exists	()Z
    //   502: ifeq +9 -> 511
    //   505: aload 11
    //   507: invokevirtual 205	java/io/File:delete	()Z
    //   510: pop
    //   511: new 144	java/io/FileOutputStream
    //   514: dup
    //   515: aload 11
    //   517: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   520: astore 11
    //   522: new 147	java/io/BufferedOutputStream
    //   525: dup
    //   526: aload 11
    //   528: aload 15
    //   530: arraylength
    //   531: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   534: astore 12
    //   536: iconst_0
    //   537: istore 5
    //   539: iload 6
    //   541: istore_3
    //   542: aload 9
    //   544: aload 15
    //   546: iconst_0
    //   547: aload 15
    //   549: arraylength
    //   550: invokevirtual 215	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   553: istore 7
    //   555: iload 7
    //   557: iconst_m1
    //   558: if_icmpeq +181 -> 739
    //   561: iload 5
    //   563: istore 4
    //   565: iload 7
    //   567: ifne +152 -> 719
    //   570: iload 5
    //   572: iconst_1
    //   573: iadd
    //   574: istore_3
    //   575: iload_3
    //   576: istore 4
    //   578: iload_3
    //   579: bipush 10
    //   581: if_icmple +138 -> 719
    //   584: iconst_1
    //   585: istore_3
    //   586: new 33	java/io/IOException
    //   589: dup
    //   590: ldc 217
    //   592: invokespecial 218	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   595: athrow
    //   596: astore_1
    //   597: aload 8
    //   599: astore 10
    //   601: aload_0
    //   602: astore 13
    //   604: aload 11
    //   606: astore 8
    //   608: aload_1
    //   609: astore_0
    //   610: aload 12
    //   612: astore_1
    //   613: aload 13
    //   615: astore 11
    //   617: goto -288 -> 329
    //   620: aload 11
    //   622: iconst_1
    //   623: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   626: astore 11
    //   628: aload_1
    //   629: astore 13
    //   631: goto -200 -> 431
    //   634: aload 11
    //   636: iconst_0
    //   637: iload_3
    //   638: invokevirtual 192	java/lang/String:substring	(II)Ljava/lang/String;
    //   641: astore 13
    //   643: aload 13
    //   645: iconst_0
    //   646: invokevirtual 225	java/lang/String:charAt	(I)C
    //   649: getstatic 170	java/io/File:separatorChar	C
    //   652: if_icmpne +37 -> 689
    //   655: new 59	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   662: aload_1
    //   663: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 13
    //   668: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: astore 13
    //   676: aload 11
    //   678: iload_3
    //   679: iconst_1
    //   680: iadd
    //   681: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   684: astore 11
    //   686: goto -255 -> 431
    //   689: new 59	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   696: aload_1
    //   697: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: getstatic 170	java/io/File:separatorChar	C
    //   703: invokevirtual 228	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   706: aload 13
    //   708: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: astore 13
    //   716: goto -40 -> 676
    //   719: iload 6
    //   721: istore_3
    //   722: aload 12
    //   724: aload 15
    //   726: iconst_0
    //   727: iload 7
    //   729: invokevirtual 232	java/io/BufferedOutputStream:write	([BII)V
    //   732: iload 4
    //   734: istore 5
    //   736: goto -197 -> 539
    //   739: iload 6
    //   741: istore_3
    //   742: aload 12
    //   744: invokevirtual 235	java/io/BufferedOutputStream:flush	()V
    //   747: iload 6
    //   749: istore_3
    //   750: aload 12
    //   752: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   755: iload 6
    //   757: istore_3
    //   758: aload 11
    //   760: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   763: aload 12
    //   765: astore 10
    //   767: aload 11
    //   769: astore 12
    //   771: goto -669 -> 102
    //   774: iconst_0
    //   775: istore_2
    //   776: goto -423 -> 353
    //   779: astore_1
    //   780: goto -621 -> 159
    //   783: astore_1
    //   784: goto -615 -> 169
    //   787: astore_0
    //   788: goto -611 -> 177
    //   791: astore_0
    //   792: goto -605 -> 187
    //   795: astore_0
    //   796: return
    //   797: astore 9
    //   799: goto -419 -> 380
    //   802: astore 9
    //   804: goto -414 -> 390
    //   807: astore 9
    //   809: goto -409 -> 400
    //   812: astore 8
    //   814: goto -404 -> 410
    //   817: astore_1
    //   818: goto -400 -> 418
    //   821: astore_0
    //   822: iconst_0
    //   823: istore_3
    //   824: aconst_null
    //   825: astore_1
    //   826: aconst_null
    //   827: astore 8
    //   829: aconst_null
    //   830: astore 9
    //   832: aconst_null
    //   833: astore 10
    //   835: aconst_null
    //   836: astore 11
    //   838: goto -509 -> 329
    //   841: astore_1
    //   842: iconst_0
    //   843: istore_3
    //   844: aconst_null
    //   845: astore 12
    //   847: aconst_null
    //   848: astore 8
    //   850: aconst_null
    //   851: astore 10
    //   853: aload_0
    //   854: astore 11
    //   856: aconst_null
    //   857: astore 9
    //   859: aload_1
    //   860: astore_0
    //   861: aload 12
    //   863: astore_1
    //   864: goto -535 -> 329
    //   867: astore_1
    //   868: iconst_0
    //   869: istore_3
    //   870: aconst_null
    //   871: astore 9
    //   873: aload 8
    //   875: astore 10
    //   877: aload_0
    //   878: astore 11
    //   880: aconst_null
    //   881: astore 8
    //   883: aconst_null
    //   884: astore 12
    //   886: aload_1
    //   887: astore_0
    //   888: aload 9
    //   890: astore_1
    //   891: aload 12
    //   893: astore 9
    //   895: goto -566 -> 329
    //   898: astore_1
    //   899: iconst_0
    //   900: istore_3
    //   901: aload 8
    //   903: astore 10
    //   905: aload_0
    //   906: astore 11
    //   908: aconst_null
    //   909: astore 8
    //   911: aconst_null
    //   912: astore 12
    //   914: aload_1
    //   915: astore_0
    //   916: aload 12
    //   918: astore_1
    //   919: goto -590 -> 329
    //   922: astore 14
    //   924: iconst_0
    //   925: istore_3
    //   926: aload 8
    //   928: astore 12
    //   930: aload_0
    //   931: astore 13
    //   933: aload 11
    //   935: astore 8
    //   937: aload 10
    //   939: astore_1
    //   940: aload 14
    //   942: astore_0
    //   943: aload 12
    //   945: astore 10
    //   947: aload 13
    //   949: astore 11
    //   951: goto -622 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	954	0	paramString1	String
    //   0	954	1	paramString2	String
    //   0	954	2	paramBoolean	boolean
    //   268	658	3	i	int
    //   563	170	4	j	int
    //   537	198	5	k	int
    //   1	755	6	m	int
    //   553	175	7	n	int
    //   60	547	8	localObject1	Object
    //   812	1	8	localIOException1	IOException
    //   827	109	8	localObject2	Object
    //   71	472	9	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   797	1	9	localIOException2	IOException
    //   802	1	9	localIOException3	IOException
    //   807	1	9	localIOException4	IOException
    //   830	64	9	localObject3	Object
    //   97	849	10	localObject4	Object
    //   107	843	11	localObject5	Object
    //   100	844	12	localObject6	Object
    //   308	11	13	localObject7	Object
    //   429	519	13	str	String
    //   433	38	14	localObject8	Object
    //   922	19	14	localObject9	Object
    //   94	631	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   102	109	308	finally
    //   114	122	308	finally
    //   198	213	308	finally
    //   218	260	308	finally
    //   260	308	308	finally
    //   439	447	308	finally
    //   455	464	308	finally
    //   464	497	308	finally
    //   497	511	308	finally
    //   511	522	308	finally
    //   620	628	308	finally
    //   634	676	308	finally
    //   676	686	308	finally
    //   689	716	308	finally
    //   542	555	596	finally
    //   586	596	596	finally
    //   722	732	596	finally
    //   742	747	596	finally
    //   750	755	596	finally
    //   758	763	596	finally
    //   154	159	779	java/io/IOException
    //   164	169	783	java/io/IOException
    //   173	177	787	java/io/IOException
    //   182	187	791	java/io/IOException
    //   192	197	795	java/io/IOException
    //   375	380	797	java/io/IOException
    //   385	390	802	java/io/IOException
    //   395	400	807	java/io/IOException
    //   405	410	812	java/io/IOException
    //   414	418	817	java/io/IOException
    //   3	43	821	finally
    //   43	52	821	finally
    //   52	62	841	finally
    //   62	73	867	finally
    //   73	96	898	finally
    //   522	536	922	finally
  }
  
  public static int a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    paramString1 = new File(paramString1);
    int i;
    if (!paramString1.exists()) {
      i = -1;
    }
    File localFile1;
    int j;
    do
    {
      return i;
      paramString1 = paramString1.listFiles();
      if (paramString1 == null) {
        return -1;
      }
      localFile1 = new File(paramString2);
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      j = 0;
      i = k;
    } while (j >= paramString1.length);
    if (paramString1[j].isDirectory()) {
      c(paramString1[j].getPath() + "/", paramString2 + paramString1[j].getName() + "/", paramBoolean1);
    }
    for (;;)
    {
      j += 1;
      break;
      localFile1 = new File(paramString1[j].getPath());
      File localFile2 = new File(paramString2 + paramString1[j].getName());
      if ((localFile1 != null) && (localFile2 != null) && (localFile1.exists()))
      {
        if ((paramBoolean2) && (localFile2.exists()) && (!localFile2.delete()) && (paramBoolean3)) {
          QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, delete file name:", localFile1.getPath() });
        }
        if (localFile2.exists()) {}
      }
      try
      {
        localFile2.createNewFile();
        if ((!copyFile(localFile1, localFile2, paramBoolean3)) && (paramBoolean3)) {
          QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, file name:", localFile1.getPath() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (paramBoolean3) {
            QLog.e("FileUtils", 1, "copyDirectory error, ", localIOException);
          }
        }
      }
      if (paramBoolean1) {
        localFile1.delete();
      }
    }
  }
  
  /* Error */
  public static long a(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: new 78	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokevirtual 279	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore_0
    //   18: aload 9
    //   20: astore 8
    //   22: new 144	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokevirtual 280	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore_1
    //   34: iload_2
    //   35: i2l
    //   36: lstore 4
    //   38: iload_3
    //   39: i2l
    //   40: lstore 6
    //   42: aload_1
    //   43: astore 8
    //   45: aload_1
    //   46: aload_0
    //   47: lload 4
    //   49: lload 6
    //   51: invokevirtual 286	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   54: lstore 4
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   64: aload_1
    //   65: ifnull +89 -> 154
    //   68: aload_1
    //   69: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   72: lload 4
    //   74: lreturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   86: aload 8
    //   88: ifnull +64 -> 152
    //   91: aload 8
    //   93: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   96: lconst_0
    //   97: lreturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore 8
    //   102: aconst_null
    //   103: astore_1
    //   104: aload 8
    //   106: ifnull +8 -> 114
    //   109: aload 8
    //   111: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 287	java/nio/channels/FileChannel:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore 9
    //   126: aload_0
    //   127: astore 8
    //   129: aconst_null
    //   130: astore_1
    //   131: aload 9
    //   133: astore_0
    //   134: goto -30 -> 104
    //   137: astore 9
    //   139: aload_0
    //   140: astore 8
    //   142: aload 9
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -71 -> 78
    //   152: lconst_0
    //   153: lreturn
    //   154: lload 4
    //   156: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile1	File
    //   0	157	1	paramFile2	File
    //   0	157	2	paramInt1	int
    //   0	157	3	paramInt2	int
    //   36	119	4	l1	long
    //   40	10	6	l2	long
    //   4	137	8	localObject1	Object
    //   1	18	9	localObject2	Object
    //   124	8	9	localObject3	Object
    //   137	6	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	75	java/io/FileNotFoundException
    //   6	18	98	finally
    //   22	34	124	finally
    //   45	56	137	finally
    //   22	34	148	java/io/FileNotFoundException
    //   45	56	148	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: ifnonnull +8 -> 19
    //   14: iload 4
    //   16: istore_3
    //   17: iload_3
    //   18: ireturn
    //   19: aconst_null
    //   20: astore 6
    //   22: new 147	java/io/BufferedOutputStream
    //   25: dup
    //   26: new 144	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   34: ldc_w 290
    //   37: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   40: astore 5
    //   42: aload 5
    //   44: astore_1
    //   45: aload_0
    //   46: aload_2
    //   47: bipush 70
    //   49: aload 5
    //   51: invokevirtual 296	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: istore 4
    //   58: iload 4
    //   60: istore_3
    //   61: aload 5
    //   63: ifnull -46 -> 17
    //   66: aload 5
    //   68: invokevirtual 299	java/io/OutputStream:flush	()V
    //   71: aload 5
    //   73: invokevirtual 300	java/io/OutputStream:close	()V
    //   76: iload 4
    //   78: ireturn
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   84: iload 4
    //   86: ireturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   96: iload 4
    //   98: istore_3
    //   99: aload_0
    //   100: ifnull -83 -> 17
    //   103: aload_0
    //   104: invokevirtual 299	java/io/OutputStream:flush	()V
    //   107: aload_0
    //   108: invokevirtual 300	java/io/OutputStream:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_0
    //   121: aload 6
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +11 -> 136
    //   128: aload_1
    //   129: invokevirtual 299	java/io/OutputStream:flush	()V
    //   132: aload_1
    //   133: invokevirtual 300	java/io/OutputStream:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   143: goto -7 -> 136
    //   146: astore_0
    //   147: goto -23 -> 124
    //   150: astore_2
    //   151: aload 5
    //   153: astore_0
    //   154: goto -64 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramBitmap	android.graphics.Bitmap
    //   0	157	1	paramString	String
    //   0	157	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   5	94	3	bool1	boolean
    //   1	96	4	bool2	boolean
    //   40	112	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   20	102	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	76	79	java/io/IOException
    //   22	42	87	java/io/IOException
    //   103	111	113	java/io/IOException
    //   22	42	120	finally
    //   128	136	138	java/io/IOException
    //   45	55	146	finally
    //   92	96	146	finally
    //   45	55	150	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString, StringBuffer paramStringBuffer, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 90	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload_1
    //   11: ifnonnull +9 -> 20
    //   14: iconst_0
    //   15: istore 5
    //   17: iload 5
    //   19: ireturn
    //   20: aload_1
    //   21: invokevirtual 307	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   24: ldc_w 309
    //   27: ldc_w 311
    //   30: invokevirtual 315	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: new 90	java/io/File
    //   37: dup
    //   38: new 59	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: iconst_1
    //   61: istore 4
    //   63: aload 6
    //   65: invokevirtual 202	java/io/File:exists	()Z
    //   68: ifne +21 -> 89
    //   71: aload 6
    //   73: invokevirtual 94	java/io/File:mkdirs	()Z
    //   76: istore 5
    //   78: iload 5
    //   80: istore 4
    //   82: iload 5
    //   84: ifne +5 -> 89
    //   87: iconst_0
    //   88: ireturn
    //   89: iload 4
    //   91: istore 5
    //   93: aload 6
    //   95: invokevirtual 202	java/io/File:exists	()Z
    //   98: ifeq -81 -> 17
    //   101: aload_0
    //   102: invokevirtual 202	java/io/File:exists	()Z
    //   105: ifne +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 260	java/io/File:createNewFile	()Z
    //   112: pop
    //   113: new 144	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   122: astore_0
    //   123: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   126: sipush 4096
    //   129: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   132: astore_1
    //   133: aload_2
    //   134: aload_1
    //   135: invokevirtual 323	java/io/InputStream:read	([B)I
    //   138: istore_3
    //   139: iload_3
    //   140: iconst_m1
    //   141: if_icmpeq +38 -> 179
    //   144: aload_0
    //   145: aload_1
    //   146: iconst_0
    //   147: iload_3
    //   148: invokevirtual 324	java/io/FileOutputStream:write	([BII)V
    //   151: goto -18 -> 133
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_0
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 325	java/io/FileNotFoundException:printStackTrace	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   182: aload_1
    //   183: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   186: aload_0
    //   187: invokevirtual 326	java/io/FileOutputStream:flush	()V
    //   190: iload 4
    //   192: istore 5
    //   194: aload_0
    //   195: ifnull -178 -> 17
    //   198: aload_0
    //   199: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   202: iload 4
    //   204: ireturn
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   210: iload 4
    //   212: ireturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   218: goto -51 -> 167
    //   221: astore_1
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   237: goto -7 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramStringBuffer	StringBuffer
    //   0	240	2	paramInputStream	InputStream
    //   138	10	3	i	int
    //   61	150	4	bool1	boolean
    //   15	178	5	bool2	boolean
    //   8	86	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	133	154	java/io/IOException
    //   133	139	154	java/io/IOException
    //   144	151	154	java/io/IOException
    //   179	190	154	java/io/IOException
    //   108	113	169	java/io/IOException
    //   113	123	172	java/io/FileNotFoundException
    //   198	202	205	java/io/IOException
    //   163	167	213	java/io/IOException
    //   123	133	221	finally
    //   133	139	221	finally
    //   144	151	221	finally
    //   155	159	221	finally
    //   179	190	221	finally
    //   226	230	232	java/io/IOException
  }
  
  public static boolean a(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile2 = new File(paramString1);
    File localFile1 = new File(paramString1 + paramStringBuffer.toString());
    boolean bool = true;
    if (!localFile2.exists()) {
      bool = localFile2.mkdirs();
    }
    if ((localFile2.exists()) && (localFile1.exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = localFile1; paramString2.exists(); paramString2 = new File(paramString1 + paramStringBuffer))
      {
        int i = paramStringBuffer.lastIndexOf("(") + 1;
        int j = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(i, j, String.valueOf(Integer.parseInt(paramStringBuffer.substring(i, j)) + 1));
      }
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +28 -> 35
    //   10: iload 4
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual 178	java/lang/String:length	()I
    //   17: ifeq +18 -> 35
    //   20: iload 4
    //   22: istore_3
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_1
    //   28: arraylength
    //   29: ifne +8 -> 37
    //   32: iload 4
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: astore 5
    //   40: iload_2
    //   41: ifeq +57 -> 98
    //   44: new 362	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc_w 364
    //   51: getstatic 370	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: invokespecial 373	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   57: new 375	java/util/Date
    //   60: dup
    //   61: invokestatic 381	java/lang/System:currentTimeMillis	()J
    //   64: invokespecial 384	java/util/Date:<init>	(J)V
    //   67: invokevirtual 388	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore 5
    //   72: new 59	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   79: aload_0
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 185
    //   85: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 5
    //   90: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 5
    //   98: new 90	java/io/File
    //   101: dup
    //   102: aload 5
    //   104: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 8
    //   109: aconst_null
    //   110: astore 7
    //   112: aconst_null
    //   113: astore 5
    //   115: aconst_null
    //   116: astore 6
    //   118: aload 5
    //   120: astore_0
    //   121: aload 8
    //   123: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   126: astore 9
    //   128: aload 5
    //   130: astore_0
    //   131: aload 9
    //   133: invokevirtual 202	java/io/File:exists	()Z
    //   136: ifne +12 -> 148
    //   139: aload 5
    //   141: astore_0
    //   142: aload 9
    //   144: invokevirtual 94	java/io/File:mkdirs	()Z
    //   147: pop
    //   148: aload 5
    //   150: astore_0
    //   151: aload 8
    //   153: invokevirtual 202	java/io/File:exists	()Z
    //   156: ifeq +12 -> 168
    //   159: aload 5
    //   161: astore_0
    //   162: aload 8
    //   164: invokevirtual 205	java/io/File:delete	()Z
    //   167: pop
    //   168: aload 5
    //   170: astore_0
    //   171: new 144	java/io/FileOutputStream
    //   174: dup
    //   175: aload 8
    //   177: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   180: astore 5
    //   182: aload 5
    //   184: aload_1
    //   185: invokevirtual 390	java/io/FileOutputStream:write	([B)V
    //   188: aload 5
    //   190: invokevirtual 326	java/io/FileOutputStream:flush	()V
    //   193: iconst_1
    //   194: istore_3
    //   195: aload 5
    //   197: ifnull -162 -> 35
    //   200: aload 5
    //   202: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 391	java/lang/Exception:printStackTrace	()V
    //   212: iconst_1
    //   213: ireturn
    //   214: astore 5
    //   216: aload 6
    //   218: astore_1
    //   219: aload_1
    //   220: astore_0
    //   221: aload 5
    //   223: invokevirtual 325	java/io/FileNotFoundException:printStackTrace	()V
    //   226: iload 4
    //   228: istore_3
    //   229: aload_1
    //   230: ifnull -195 -> 35
    //   233: aload_1
    //   234: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 391	java/lang/Exception:printStackTrace	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore 5
    //   248: aload 7
    //   250: astore_1
    //   251: aload_1
    //   252: astore_0
    //   253: aload 5
    //   255: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   258: iload 4
    //   260: istore_3
    //   261: aload_1
    //   262: ifnull -227 -> 35
    //   265: aload_1
    //   266: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 391	java/lang/Exception:printStackTrace	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore 5
    //   280: aload_0
    //   281: astore_1
    //   282: aload 5
    //   284: astore_0
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 391	java/lang/Exception:printStackTrace	()V
    //   300: goto -7 -> 293
    //   303: astore_0
    //   304: aload 5
    //   306: astore_1
    //   307: goto -22 -> 285
    //   310: astore_0
    //   311: aload 5
    //   313: astore_1
    //   314: aload_0
    //   315: astore 5
    //   317: goto -66 -> 251
    //   320: astore_0
    //   321: aload 5
    //   323: astore_1
    //   324: aload_0
    //   325: astore 5
    //   327: goto -108 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramString	String
    //   0	330	1	paramArrayOfByte	byte[]
    //   0	330	2	paramBoolean	boolean
    //   5	256	3	bool1	boolean
    //   1	258	4	bool2	boolean
    //   38	163	5	localObject1	Object
    //   214	8	5	localFileNotFoundException	FileNotFoundException
    //   246	8	5	localIOException	IOException
    //   278	34	5	localObject2	Object
    //   315	11	5	str	String
    //   116	101	6	localObject3	Object
    //   110	139	7	localObject4	Object
    //   107	69	8	localFile1	File
    //   126	17	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   200	205	207	java/lang/Exception
    //   121	128	214	java/io/FileNotFoundException
    //   131	139	214	java/io/FileNotFoundException
    //   142	148	214	java/io/FileNotFoundException
    //   151	159	214	java/io/FileNotFoundException
    //   162	168	214	java/io/FileNotFoundException
    //   171	182	214	java/io/FileNotFoundException
    //   233	237	239	java/lang/Exception
    //   121	128	246	java/io/IOException
    //   131	139	246	java/io/IOException
    //   142	148	246	java/io/IOException
    //   151	159	246	java/io/IOException
    //   162	168	246	java/io/IOException
    //   171	182	246	java/io/IOException
    //   265	269	271	java/lang/Exception
    //   121	128	278	finally
    //   131	139	278	finally
    //   142	148	278	finally
    //   151	159	278	finally
    //   162	168	278	finally
    //   171	182	278	finally
    //   221	226	278	finally
    //   253	258	278	finally
    //   289	293	295	java/lang/Exception
    //   182	193	303	finally
    //   182	193	310	java/io/IOException
    //   182	193	320	java/io/FileNotFoundException
  }
  
  /* Error */
  public static Object[] a(String paramString, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: new 394	java/io/ObjectInputStream
    //   3: dup
    //   4: new 82	java/io/BufferedInputStream
    //   7: dup
    //   8: invokestatic 398	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: aload_0
    //   12: invokevirtual 404	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: invokespecial 405	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: arraylength
    //   28: anewarray 4	java/lang/Object
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_2
    //   35: aload 4
    //   37: astore_3
    //   38: iload_2
    //   39: aload_1
    //   40: arraylength
    //   41: if_icmpge +209 -> 250
    //   44: aload_1
    //   45: iload_2
    //   46: aaload
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 407
    //   52: if_acmpne +21 -> 73
    //   55: aload 4
    //   57: astore_3
    //   58: aload 5
    //   60: iload_2
    //   61: aload 4
    //   63: invokevirtual 411	java/io/ObjectInputStream:readByte	()B
    //   66: invokestatic 414	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   69: aastore
    //   70: goto +234 -> 304
    //   73: aload_3
    //   74: ldc_w 416
    //   77: if_acmpne +97 -> 174
    //   80: aload 4
    //   82: astore_3
    //   83: aload 5
    //   85: iload_2
    //   86: aload 4
    //   88: invokevirtual 419	java/io/ObjectInputStream:readBoolean	()Z
    //   91: invokestatic 422	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: goto +209 -> 304
    //   98: astore_3
    //   99: aload 4
    //   101: astore_1
    //   102: aload_3
    //   103: astore 4
    //   105: aload_1
    //   106: astore_3
    //   107: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +46 -> 156
    //   113: aload_1
    //   114: astore_3
    //   115: ldc_w 424
    //   118: iconst_2
    //   119: new 59	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 426
    //   129: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 428
    //   139: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 431	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   164: aconst_null
    //   165: astore_0
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: ifeq +116 -> 285
    //   172: aload_0
    //   173: areturn
    //   174: aload_3
    //   175: ldc_w 344
    //   178: if_acmpne +32 -> 210
    //   181: aload 4
    //   183: astore_3
    //   184: aload 5
    //   186: iload_2
    //   187: aload 4
    //   189: invokevirtual 435	java/io/ObjectInputStream:readInt	()I
    //   192: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: aastore
    //   196: goto +108 -> 304
    //   199: astore_0
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: aload_3
    //   211: ldc_w 440
    //   214: if_acmpne +21 -> 235
    //   217: aload 4
    //   219: astore_3
    //   220: aload 5
    //   222: iload_2
    //   223: aload 4
    //   225: invokevirtual 443	java/io/ObjectInputStream:readLong	()J
    //   228: invokestatic 446	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: goto +72 -> 304
    //   235: aload 4
    //   237: astore_3
    //   238: aload 5
    //   240: iload_2
    //   241: aload 4
    //   243: invokevirtual 450	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   246: aastore
    //   247: goto +57 -> 304
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   260: iconst_1
    //   261: istore_2
    //   262: aload 5
    //   264: astore_0
    //   265: goto -97 -> 168
    //   268: astore_0
    //   269: iconst_1
    //   270: istore_2
    //   271: aload 5
    //   273: astore_0
    //   274: goto -106 -> 168
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_0
    //   280: iconst_0
    //   281: istore_2
    //   282: goto -114 -> 168
    //   285: aconst_null
    //   286: areturn
    //   287: astore_1
    //   288: goto -80 -> 208
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -94 -> 200
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -196 -> 105
    //   304: iload_2
    //   305: iconst_1
    //   306: iadd
    //   307: istore_2
    //   308: goto -273 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   0	311	1	paramArrayOfClass	Class[]
    //   34	274	2	i	int
    //   25	58	3	localObject1	Object
    //   98	5	3	localException1	Exception
    //   106	188	3	localObject2	Object
    //   21	235	4	localObject3	Object
    //   297	1	4	localException2	Exception
    //   31	241	5	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   26	33	98	java/lang/Exception
    //   38	44	98	java/lang/Exception
    //   58	70	98	java/lang/Exception
    //   83	95	98	java/lang/Exception
    //   184	196	98	java/lang/Exception
    //   220	232	98	java/lang/Exception
    //   238	247	98	java/lang/Exception
    //   26	33	199	finally
    //   38	44	199	finally
    //   58	70	199	finally
    //   83	95	199	finally
    //   107	113	199	finally
    //   115	156	199	finally
    //   184	196	199	finally
    //   220	232	199	finally
    //   238	247	199	finally
    //   255	260	268	java/io/IOException
    //   160	164	277	java/io/IOException
    //   204	208	287	java/io/IOException
    //   0	23	291	finally
    //   0	23	297	java/lang/Exception
  }
  
  public static boolean aCJ()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      if ((localFile.exists()) && (localFile.canWrite())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileUtils", 2, "existAndCanWrite=" + bool1 + " externalDir.canWrite()= " + localFile.canWrite() + " state=" + Environment.getExternalStorageState().equals("mounted"));
        }
        boolean bool2 = Environment.getExternalStorageState().equals("mounted");
        if ((!bool2) || (!bool1)) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileUtils", 2, "hasSDCardAndWritable", localException);
      }
    }
    return false;
  }
  
  public static boolean aCK()
  {
    return fileExists(acbn.SDCARD_ROOT + "/Tencent/");
  }
  
  public static boolean aCL()
  {
    return fileExists(acbn.SDCARD_PATH);
  }
  
  public static boolean aCM()
  {
    return fileExists(aqul.getSDKPrivatePath(acbn.SDCARD_PATH) + "/" + "diskcache");
  }
  
  public static int ad(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if ((!paramString1.exists()) && (paramString2.exists())) {
      return 1;
    }
    if ((!paramString2.getParentFile().exists()) && (!paramString2.getParentFile().mkdirs())) {
      return 2;
    }
    if (paramString1.renameTo(paramString2)) {
      return 0;
    }
    return 3;
  }
  
  public static ArrayList<String> ag(String paramString)
  {
    return getChildFiles(paramString, false);
  }
  
  /* Error */
  public static String b(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc 49
    //   12: iconst_1
    //   13: ldc_w 522
    //   16: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload 9
    //   21: astore 5
    //   23: aload 5
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 202	java/io/File:exists	()Z
    //   30: ifeq +10 -> 40
    //   33: aload_0
    //   34: invokevirtual 525	java/io/File:canRead	()Z
    //   37: ifne +47 -> 84
    //   40: ldc 49
    //   42: iconst_1
    //   43: new 59	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 527
    //   53: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: invokevirtual 202	java/io/File:exists	()Z
    //   60: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: ldc_w 529
    //   66: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 525	java/io/File:canRead	()Z
    //   73: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aconst_null
    //   83: areturn
    //   84: new 82	java/io/BufferedInputStream
    //   87: dup
    //   88: new 78	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 5
    //   101: new 531	java/io/InputStreamReader
    //   104: dup
    //   105: aload 5
    //   107: ldc_w 533
    //   110: invokespecial 536	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   113: astore 8
    //   115: aload 8
    //   117: astore 7
    //   119: aload 5
    //   121: astore 6
    //   123: iload_1
    //   124: istore_3
    //   125: aload_0
    //   126: invokevirtual 538	java/io/File:length	()J
    //   129: l2i
    //   130: istore 4
    //   132: iload 4
    //   134: sipush 12288
    //   137: if_icmple +259 -> 396
    //   140: iload_1
    //   141: istore_2
    //   142: iload_1
    //   143: iconst_m1
    //   144: if_icmpne +29 -> 173
    //   147: aload 8
    //   149: astore 7
    //   151: aload 5
    //   153: astore 6
    //   155: iload_1
    //   156: istore_3
    //   157: iload 4
    //   159: sipush 6144
    //   162: idiv
    //   163: istore_1
    //   164: iload_1
    //   165: bipush 12
    //   167: if_icmpge +166 -> 333
    //   170: bipush 12
    //   172: istore_2
    //   173: aload 8
    //   175: astore 7
    //   177: aload 5
    //   179: astore 6
    //   181: iload_2
    //   182: istore_3
    //   183: sipush 4096
    //   186: newarray char
    //   188: astore 11
    //   190: aload 8
    //   192: astore 7
    //   194: aload 5
    //   196: astore 6
    //   198: iload_2
    //   199: istore_3
    //   200: new 59	java/lang/StringBuilder
    //   203: dup
    //   204: iload_2
    //   205: sipush 1024
    //   208: imul
    //   209: invokespecial 541	java/lang/StringBuilder:<init>	(I)V
    //   212: astore 12
    //   214: aload 8
    //   216: astore 7
    //   218: aload 5
    //   220: astore 6
    //   222: iload_2
    //   223: istore_3
    //   224: aload 8
    //   226: aload 11
    //   228: invokevirtual 544	java/io/InputStreamReader:read	([C)I
    //   231: istore_1
    //   232: iconst_m1
    //   233: iload_1
    //   234: if_icmpeq +113 -> 347
    //   237: aload 8
    //   239: astore 7
    //   241: aload 5
    //   243: astore 6
    //   245: iload_2
    //   246: istore_3
    //   247: aload 12
    //   249: aload 11
    //   251: iconst_0
    //   252: iload_1
    //   253: invokevirtual 547	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: goto -43 -> 214
    //   260: astore 6
    //   262: aload 8
    //   264: astore_0
    //   265: aload 6
    //   267: astore 8
    //   269: aload_0
    //   270: astore 7
    //   272: aload 5
    //   274: astore 6
    //   276: ldc 49
    //   278: iconst_1
    //   279: new 59	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 549
    //   289: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 8
    //   294: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   297: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 5
    //   308: ifnull +8 -> 316
    //   311: aload 5
    //   313: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   316: aload 9
    //   318: astore 5
    //   320: aload_0
    //   321: ifnull -298 -> 23
    //   324: aload_0
    //   325: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   328: aconst_null
    //   329: areturn
    //   330: astore_0
    //   331: aconst_null
    //   332: areturn
    //   333: iload_1
    //   334: istore_2
    //   335: iload_1
    //   336: bipush 60
    //   338: if_icmple -165 -> 173
    //   341: bipush 60
    //   343: istore_2
    //   344: goto -171 -> 173
    //   347: aload 8
    //   349: astore 7
    //   351: aload 5
    //   353: astore 6
    //   355: iload_2
    //   356: istore_3
    //   357: aload 12
    //   359: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 11
    //   364: aload 11
    //   366: astore_0
    //   367: aload 5
    //   369: ifnull +8 -> 377
    //   372: aload 5
    //   374: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   377: aload_0
    //   378: astore 5
    //   380: aload 8
    //   382: ifnull -359 -> 23
    //   385: aload 8
    //   387: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   390: aload_0
    //   391: areturn
    //   392: astore 5
    //   394: aload_0
    //   395: areturn
    //   396: aload 8
    //   398: astore 7
    //   400: aload 5
    //   402: astore 6
    //   404: iload_1
    //   405: istore_3
    //   406: iload 4
    //   408: newarray char
    //   410: astore 11
    //   412: aload 8
    //   414: astore 7
    //   416: aload 5
    //   418: astore 6
    //   420: iload_1
    //   421: istore_3
    //   422: new 160	java/lang/String
    //   425: dup
    //   426: aload 11
    //   428: iconst_0
    //   429: aload 8
    //   431: aload 11
    //   433: invokevirtual 544	java/io/InputStreamReader:read	([C)I
    //   436: invokespecial 554	java/lang/String:<init>	([CII)V
    //   439: astore 11
    //   441: aload 11
    //   443: astore_0
    //   444: goto -77 -> 367
    //   447: astore 5
    //   449: aconst_null
    //   450: astore 8
    //   452: aconst_null
    //   453: astore 5
    //   455: aload 8
    //   457: astore 7
    //   459: aload 5
    //   461: astore 6
    //   463: ldc 49
    //   465: iconst_1
    //   466: new 59	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 556
    //   476: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: invokevirtual 248	java/io/File:getName	()Ljava/lang/String;
    //   483: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload 10
    //   494: astore 6
    //   496: iload_1
    //   497: iconst_m1
    //   498: if_icmpne +21 -> 519
    //   501: aload 8
    //   503: astore 7
    //   505: aload 5
    //   507: astore 6
    //   509: aload_0
    //   510: bipush 6
    //   512: invokestatic 558	aqhq:b	(Ljava/io/File;I)Ljava/lang/String;
    //   515: astore_0
    //   516: aload_0
    //   517: astore 6
    //   519: aload 5
    //   521: ifnull +8 -> 529
    //   524: aload 5
    //   526: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   529: aload 6
    //   531: astore 5
    //   533: aload 8
    //   535: ifnull -512 -> 23
    //   538: aload 8
    //   540: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   543: aload 6
    //   545: areturn
    //   546: astore_0
    //   547: aload 6
    //   549: areturn
    //   550: astore_0
    //   551: aconst_null
    //   552: astore 7
    //   554: aconst_null
    //   555: astore 5
    //   557: aload 5
    //   559: ifnull +8 -> 567
    //   562: aload 5
    //   564: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   567: aload 7
    //   569: ifnull +8 -> 577
    //   572: aload 7
    //   574: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   577: aload_0
    //   578: athrow
    //   579: astore 5
    //   581: goto -204 -> 377
    //   584: astore 5
    //   586: goto -270 -> 316
    //   589: astore_0
    //   590: goto -61 -> 529
    //   593: astore 5
    //   595: goto -28 -> 567
    //   598: astore 5
    //   600: goto -23 -> 577
    //   603: astore_0
    //   604: aconst_null
    //   605: astore 7
    //   607: goto -50 -> 557
    //   610: astore_0
    //   611: aload 6
    //   613: astore 5
    //   615: goto -58 -> 557
    //   618: astore 6
    //   620: aconst_null
    //   621: astore 8
    //   623: goto -168 -> 455
    //   626: astore 6
    //   628: iload_3
    //   629: istore_1
    //   630: goto -175 -> 455
    //   633: astore 8
    //   635: aconst_null
    //   636: astore_0
    //   637: aconst_null
    //   638: astore 5
    //   640: goto -371 -> 269
    //   643: astore 8
    //   645: aconst_null
    //   646: astore_0
    //   647: goto -378 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	paramFile	File
    //   0	650	1	paramInt	int
    //   141	215	2	i	int
    //   124	505	3	j	int
    //   130	277	4	k	int
    //   21	358	5	localObject1	Object
    //   392	25	5	localException1	Exception
    //   447	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   453	110	5	localObject2	Object
    //   579	1	5	localException2	Exception
    //   584	1	5	localException3	Exception
    //   593	1	5	localException4	Exception
    //   598	1	5	localException5	Exception
    //   613	26	5	localObject3	Object
    //   121	123	6	localObject4	Object
    //   260	6	6	localException6	Exception
    //   274	338	6	localObject5	Object
    //   618	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   626	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   117	489	7	localObject6	Object
    //   113	509	8	localObject7	Object
    //   633	1	8	localException7	Exception
    //   643	1	8	localException8	Exception
    //   4	313	9	localObject8	Object
    //   1	492	10	localObject9	Object
    //   188	254	11	localObject10	Object
    //   212	146	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	132	260	java/lang/Exception
    //   157	164	260	java/lang/Exception
    //   183	190	260	java/lang/Exception
    //   200	214	260	java/lang/Exception
    //   224	232	260	java/lang/Exception
    //   247	257	260	java/lang/Exception
    //   357	364	260	java/lang/Exception
    //   406	412	260	java/lang/Exception
    //   422	441	260	java/lang/Exception
    //   324	328	330	java/lang/Exception
    //   385	390	392	java/lang/Exception
    //   84	101	447	java/lang/OutOfMemoryError
    //   538	543	546	java/lang/Exception
    //   84	101	550	finally
    //   372	377	579	java/lang/Exception
    //   311	316	584	java/lang/Exception
    //   524	529	589	java/lang/Exception
    //   562	567	593	java/lang/Exception
    //   572	577	598	java/lang/Exception
    //   101	115	603	finally
    //   125	132	610	finally
    //   157	164	610	finally
    //   183	190	610	finally
    //   200	214	610	finally
    //   224	232	610	finally
    //   247	257	610	finally
    //   276	306	610	finally
    //   357	364	610	finally
    //   406	412	610	finally
    //   422	441	610	finally
    //   463	492	610	finally
    //   509	516	610	finally
    //   101	115	618	java/lang/OutOfMemoryError
    //   125	132	626	java/lang/OutOfMemoryError
    //   157	164	626	java/lang/OutOfMemoryError
    //   183	190	626	java/lang/OutOfMemoryError
    //   200	214	626	java/lang/OutOfMemoryError
    //   224	232	626	java/lang/OutOfMemoryError
    //   247	257	626	java/lang/OutOfMemoryError
    //   357	364	626	java/lang/OutOfMemoryError
    //   406	412	626	java/lang/OutOfMemoryError
    //   422	441	626	java/lang/OutOfMemoryError
    //   84	101	633	java/lang/Exception
    //   101	115	643	java/lang/Exception
  }
  
  public static float bA()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getBlockCount();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static float bB()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static String bP(long paramLong)
  {
    return aqhp.bO(paramLong);
  }
  
  public static boolean bP(Context paramContext)
  {
    return n(paramContext, true);
  }
  
  public static String bY(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!new File(localFile, paramString2).exists()) {
      return paramString2;
    }
    if (paramString2.lastIndexOf('.') < 0) {}
    String str;
    for (paramString1 = "";; paramString1 = str)
    {
      int i = 1;
      for (;;)
      {
        str = paramString2 + "(" + i + ")" + paramString1;
        if (!new File(localFile, str).exists()) {
          break;
        }
        i += 1;
      }
      paramString1 = paramString2.substring(0, paramString2.lastIndexOf('.'));
      str = paramString2.substring(paramString1.length(), paramString2.length());
      paramString2 = paramString1;
    }
    return str;
  }
  
  /* Error */
  public static String bZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 90	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +17 -> 29
    //   15: aload_0
    //   16: invokevirtual 202	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 605	java/io/File:isFile	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokestatic 611	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 4
    //   37: new 78	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   49: sipush 8192
    //   52: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   55: astore 5
    //   57: bipush 16
    //   59: newarray char
    //   61: astore_0
    //   62: aload_0
    //   63: dup
    //   64: iconst_0
    //   65: ldc_w 612
    //   68: castore
    //   69: dup
    //   70: iconst_1
    //   71: ldc_w 613
    //   74: castore
    //   75: dup
    //   76: iconst_2
    //   77: ldc_w 614
    //   80: castore
    //   81: dup
    //   82: iconst_3
    //   83: ldc_w 615
    //   86: castore
    //   87: dup
    //   88: iconst_4
    //   89: ldc_w 616
    //   92: castore
    //   93: dup
    //   94: iconst_5
    //   95: ldc_w 617
    //   98: castore
    //   99: dup
    //   100: bipush 6
    //   102: ldc_w 618
    //   105: castore
    //   106: dup
    //   107: bipush 7
    //   109: ldc_w 619
    //   112: castore
    //   113: dup
    //   114: bipush 8
    //   116: ldc_w 620
    //   119: castore
    //   120: dup
    //   121: bipush 9
    //   123: ldc_w 621
    //   126: castore
    //   127: dup
    //   128: bipush 10
    //   130: ldc_w 622
    //   133: castore
    //   134: dup
    //   135: bipush 11
    //   137: ldc_w 623
    //   140: castore
    //   141: dup
    //   142: bipush 12
    //   144: ldc_w 624
    //   147: castore
    //   148: dup
    //   149: bipush 13
    //   151: ldc_w 625
    //   154: castore
    //   155: dup
    //   156: bipush 14
    //   158: ldc_w 626
    //   161: castore
    //   162: dup
    //   163: bipush 15
    //   165: ldc_w 627
    //   168: castore
    //   169: pop
    //   170: aload_1
    //   171: aload 5
    //   173: invokevirtual 628	java/io/FileInputStream:read	([B)I
    //   176: istore_3
    //   177: iload_3
    //   178: ifle +28 -> 206
    //   181: aload 4
    //   183: aload 5
    //   185: iconst_0
    //   186: iload_3
    //   187: invokevirtual 631	java/security/MessageDigest:update	([BII)V
    //   190: goto -20 -> 170
    //   193: astore_0
    //   194: aload_1
    //   195: ifnull +203 -> 398
    //   198: aload_1
    //   199: invokevirtual 142	java/io/FileInputStream:close	()V
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_0
    //   205: areturn
    //   206: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   209: aload 5
    //   211: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   214: aload 4
    //   216: invokevirtual 635	java/security/MessageDigest:digest	()[B
    //   219: astore 4
    //   221: aload 4
    //   223: ifnull +11 -> 234
    //   226: aload 4
    //   228: arraylength
    //   229: istore_3
    //   230: iload_3
    //   231: ifne +16 -> 247
    //   234: aload_1
    //   235: ifnull -206 -> 29
    //   238: aload_1
    //   239: invokevirtual 142	java/io/FileInputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: areturn
    //   247: aload 4
    //   249: arraylength
    //   250: iconst_2
    //   251: imul
    //   252: newarray char
    //   254: astore 5
    //   256: iload_2
    //   257: aload 4
    //   259: arraylength
    //   260: if_icmpge +44 -> 304
    //   263: aload 4
    //   265: iload_2
    //   266: baload
    //   267: istore_3
    //   268: aload 5
    //   270: iload_2
    //   271: iconst_2
    //   272: imul
    //   273: iconst_1
    //   274: iadd
    //   275: aload_0
    //   276: iload_3
    //   277: bipush 15
    //   279: iand
    //   280: caload
    //   281: castore
    //   282: aload 5
    //   284: iload_2
    //   285: iconst_2
    //   286: imul
    //   287: aload_0
    //   288: iload_3
    //   289: iconst_4
    //   290: iushr
    //   291: i2b
    //   292: bipush 15
    //   294: iand
    //   295: caload
    //   296: castore
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore_2
    //   301: goto -45 -> 256
    //   304: new 160	java/lang/String
    //   307: dup
    //   308: aload 5
    //   310: invokespecial 638	java/lang/String:<init>	([C)V
    //   313: astore 4
    //   315: aload 4
    //   317: astore_0
    //   318: aload_1
    //   319: ifnull -115 -> 204
    //   322: aload_1
    //   323: invokevirtual 142	java/io/FileInputStream:close	()V
    //   326: aload 4
    //   328: astore_0
    //   329: goto -125 -> 204
    //   332: astore_0
    //   333: aload 4
    //   335: astore_0
    //   336: goto -132 -> 204
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_0
    //   342: goto -138 -> 204
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_1
    //   348: aload_1
    //   349: ifnull +49 -> 398
    //   352: aload_1
    //   353: invokevirtual 142	java/io/FileInputStream:close	()V
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -154 -> 204
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -160 -> 204
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: ifnull +7 -> 378
    //   374: aload_1
    //   375: invokevirtual 142	java/io/FileInputStream:close	()V
    //   378: aload_0
    //   379: athrow
    //   380: astore_1
    //   381: goto -3 -> 378
    //   384: astore_0
    //   385: goto -15 -> 370
    //   388: astore_0
    //   389: goto -41 -> 348
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -201 -> 194
    //   398: aconst_null
    //   399: astore_0
    //   400: goto -196 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramString1	String
    //   0	403	1	paramString2	String
    //   1	300	2	i	int
    //   176	115	3	j	int
    //   35	299	4	localObject1	Object
    //   55	254	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	170	193	java/io/IOException
    //   170	177	193	java/io/IOException
    //   181	190	193	java/io/IOException
    //   206	221	193	java/io/IOException
    //   226	230	193	java/io/IOException
    //   247	256	193	java/io/IOException
    //   256	263	193	java/io/IOException
    //   304	315	193	java/io/IOException
    //   238	242	244	java/io/IOException
    //   322	326	332	java/io/IOException
    //   198	202	339	java/io/IOException
    //   31	46	345	java/security/NoSuchAlgorithmException
    //   352	356	361	java/io/IOException
    //   31	46	367	finally
    //   374	378	380	java/io/IOException
    //   46	170	384	finally
    //   170	177	384	finally
    //   181	190	384	finally
    //   206	221	384	finally
    //   226	230	384	finally
    //   247	256	384	finally
    //   256	263	384	finally
    //   304	315	384	finally
    //   46	170	388	java/security/NoSuchAlgorithmException
    //   170	177	388	java/security/NoSuchAlgorithmException
    //   181	190	388	java/security/NoSuchAlgorithmException
    //   206	221	388	java/security/NoSuchAlgorithmException
    //   226	230	388	java/security/NoSuchAlgorithmException
    //   247	256	388	java/security/NoSuchAlgorithmException
    //   256	263	388	java/security/NoSuchAlgorithmException
    //   304	315	388	java/security/NoSuchAlgorithmException
    //   31	46	392	java/io/IOException
  }
  
  public static long bb(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label33;
      }
      l1 = 1L;
    }
    label33:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists()) {
        if (!localObject.isDirectory()) {
          break label130;
        }
      }
    }
    label130:
    for (l1 = l2 + bb(localObject.getAbsolutePath());; l1 = l2 + 1L)
    {
      i += 1;
      l2 = l1;
      break;
    }
  }
  
  public static int c(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramBoolean, false, false);
  }
  
  /* Error */
  public static boolean c(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: aload_0
    //   5: ifnull +9 -> 14
    //   8: aload_1
    //   9: ifnonnull +7 -> 16
    //   12: iload_3
    //   13: istore_2
    //   14: iload_2
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 5
    //   19: new 147	java/io/BufferedOutputStream
    //   22: dup
    //   23: new 144	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   31: ldc_w 290
    //   34: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_1
    //   42: aload_0
    //   43: getstatic 651	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   46: bipush 70
    //   48: aload 4
    //   50: invokevirtual 296	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: istore_3
    //   56: iload_3
    //   57: istore_2
    //   58: aload 4
    //   60: ifnull -46 -> 14
    //   63: aload 4
    //   65: invokevirtual 299	java/io/OutputStream:flush	()V
    //   68: aload 4
    //   70: invokevirtual 300	java/io/OutputStream:close	()V
    //   73: iload_3
    //   74: ireturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   80: iload_3
    //   81: ireturn
    //   82: astore 5
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   93: iload_3
    //   94: istore_2
    //   95: aload_0
    //   96: ifnull -82 -> 14
    //   99: aload_0
    //   100: invokevirtual 299	java/io/OutputStream:flush	()V
    //   103: aload_0
    //   104: invokevirtual 300	java/io/OutputStream:close	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: aload 5
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +11 -> 132
    //   124: aload_1
    //   125: invokevirtual 299	java/io/OutputStream:flush	()V
    //   128: aload_1
    //   129: invokevirtual 300	java/io/OutputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_0
    //   143: goto -23 -> 120
    //   146: astore 5
    //   148: aload 4
    //   150: astore_0
    //   151: goto -65 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramBitmap	android.graphics.Bitmap
    //   0	154	1	paramString	String
    //   3	92	2	bool1	boolean
    //   1	93	3	bool2	boolean
    //   37	112	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   17	1	5	localObject	Object
    //   82	36	5	localIOException1	IOException
    //   146	1	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   63	73	75	java/io/IOException
    //   19	39	82	java/io/IOException
    //   99	107	109	java/io/IOException
    //   19	39	116	finally
    //   124	132	134	java/io/IOException
    //   42	54	142	finally
    //   88	93	142	finally
    //   42	54	146	java/io/IOException
  }
  
  public static void cm(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    do
    {
      return;
      paramString = new File(paramString).listFiles();
    } while ((paramString == null) || (paramString.length <= 0));
    int i = 0;
    label38:
    if (i < paramString.length)
    {
      if (!paramString[i].isDirectory()) {
        break label69;
      }
      cn(paramString[i].getAbsolutePath());
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label69:
      paramString[i].delete();
    }
  }
  
  public static void cn(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = 0;
      if (i < arrayOfFile.length)
      {
        if (arrayOfFile[i].isDirectory()) {
          cn(arrayOfFile[i].getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFile[i].delete();
        }
      }
    }
    paramString.delete();
  }
  
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    return copyFile(paramFile1, paramFile2, false);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: iconst_1
    //   13: istore 5
    //   15: aload_1
    //   16: invokevirtual 202	java/io/File:exists	()Z
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: invokevirtual 577	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual 577	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: invokestatic 664	amde:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 205	java/io/File:delete	()Z
    //   37: pop
    //   38: aload_1
    //   39: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   42: ifnull +21 -> 63
    //   45: aload_1
    //   46: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   49: invokevirtual 202	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_1
    //   56: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   59: invokevirtual 94	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: new 144	java/io/FileOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: aload 7
    //   74: astore 6
    //   76: aload_1
    //   77: astore 7
    //   79: new 82	java/io/BufferedInputStream
    //   82: dup
    //   83: new 78	java/io/FileInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_0
    //   95: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   98: sipush 4096
    //   101: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   104: astore 6
    //   106: aload_0
    //   107: aload 6
    //   109: invokevirtual 665	java/io/BufferedInputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: iconst_m1
    //   115: if_icmpeq +66 -> 181
    //   118: aload_1
    //   119: aload 6
    //   121: iconst_0
    //   122: iload_3
    //   123: invokevirtual 324	java/io/FileOutputStream:write	([BII)V
    //   126: aload_1
    //   127: invokevirtual 326	java/io/FileOutputStream:flush	()V
    //   130: goto -24 -> 106
    //   133: astore 7
    //   135: aload_0
    //   136: astore 6
    //   138: aload_1
    //   139: astore_0
    //   140: aload 7
    //   142: astore_1
    //   143: iload_2
    //   144: ifeq +13 -> 157
    //   147: ldc 49
    //   149: iconst_1
    //   150: ldc_w 667
    //   153: aload_1
    //   154: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   165: aload 6
    //   167: ifnull +331 -> 498
    //   170: aload 6
    //   172: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   175: iconst_0
    //   176: istore 4
    //   178: iload 4
    //   180: ireturn
    //   181: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   184: aload 6
    //   186: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   197: iload 5
    //   199: istore 4
    //   201: aload_0
    //   202: ifnull -24 -> 178
    //   205: aload_0
    //   206: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   209: iconst_1
    //   210: ireturn
    //   211: astore_0
    //   212: iload 5
    //   214: istore 4
    //   216: iload_2
    //   217: ifeq -39 -> 178
    //   220: ldc 49
    //   222: iconst_1
    //   223: ldc_w 667
    //   226: aload_0
    //   227: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: iconst_1
    //   231: ireturn
    //   232: astore_1
    //   233: iload_2
    //   234: ifeq -37 -> 197
    //   237: ldc 49
    //   239: iconst_1
    //   240: ldc_w 667
    //   243: aload_1
    //   244: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: goto -50 -> 197
    //   250: astore_0
    //   251: iload_2
    //   252: ifeq -87 -> 165
    //   255: ldc 49
    //   257: iconst_1
    //   258: ldc_w 667
    //   261: aload_0
    //   262: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto -100 -> 165
    //   268: astore_0
    //   269: iload_2
    //   270: ifeq +13 -> 283
    //   273: ldc 49
    //   275: iconst_1
    //   276: ldc_w 667
    //   279: aload_0
    //   280: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: iconst_0
    //   284: ireturn
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_1
    //   288: aload 9
    //   290: astore 8
    //   292: iload_2
    //   293: ifeq +20 -> 313
    //   296: aload 8
    //   298: astore 6
    //   300: aload_1
    //   301: astore 7
    //   303: ldc 49
    //   305: iconst_1
    //   306: ldc_w 667
    //   309: aload_0
    //   310: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   321: aload 8
    //   323: ifnull +175 -> 498
    //   326: aload 8
    //   328: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: iload_2
    //   335: ifeq -14 -> 321
    //   338: ldc 49
    //   340: iconst_1
    //   341: ldc_w 667
    //   344: aload_0
    //   345: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -27 -> 321
    //   351: astore_0
    //   352: iload_2
    //   353: ifeq +13 -> 366
    //   356: ldc 49
    //   358: iconst_1
    //   359: ldc_w 667
    //   362: aload_0
    //   363: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: iconst_0
    //   367: ireturn
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_1
    //   371: aload_1
    //   372: ifnull +7 -> 379
    //   375: aload_1
    //   376: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   389: aload_0
    //   390: athrow
    //   391: astore_1
    //   392: iload_2
    //   393: ifeq -14 -> 379
    //   396: ldc 49
    //   398: iconst_1
    //   399: ldc_w 667
    //   402: aload_1
    //   403: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto -27 -> 379
    //   409: astore_1
    //   410: iload_2
    //   411: ifeq -22 -> 389
    //   414: ldc 49
    //   416: iconst_1
    //   417: ldc_w 667
    //   420: aload_1
    //   421: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   424: goto -35 -> 389
    //   427: astore_0
    //   428: aload 7
    //   430: astore_1
    //   431: goto -60 -> 371
    //   434: astore 7
    //   436: aload_0
    //   437: astore 6
    //   439: aload 7
    //   441: astore_0
    //   442: goto -71 -> 371
    //   445: astore 7
    //   447: aload_0
    //   448: astore_1
    //   449: aload 7
    //   451: astore_0
    //   452: goto -81 -> 371
    //   455: astore_0
    //   456: aload 9
    //   458: astore 8
    //   460: goto -168 -> 292
    //   463: astore 6
    //   465: aload_0
    //   466: astore 8
    //   468: aload 6
    //   470: astore_0
    //   471: goto -179 -> 292
    //   474: astore_1
    //   475: aconst_null
    //   476: astore_0
    //   477: aload 8
    //   479: astore 6
    //   481: goto -338 -> 143
    //   484: astore 6
    //   486: aload_1
    //   487: astore_0
    //   488: aload 6
    //   490: astore_1
    //   491: aload 8
    //   493: astore 6
    //   495: goto -352 -> 143
    //   498: iconst_0
    //   499: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramFile1	File
    //   0	500	1	paramFile2	File
    //   0	500	2	paramBoolean	boolean
    //   112	11	3	i	int
    //   176	39	4	bool1	boolean
    //   13	200	5	bool2	boolean
    //   4	434	6	localObject1	Object
    //   463	6	6	localOutOfMemoryError	OutOfMemoryError
    //   479	1	6	localObject2	Object
    //   484	5	6	localIOException1	IOException
    //   493	1	6	localObject3	Object
    //   7	71	7	localFile1	File
    //   133	8	7	localIOException2	IOException
    //   301	128	7	localFile2	File
    //   434	6	7	localObject4	Object
    //   445	5	7	localObject5	Object
    //   10	482	8	localObject6	Object
    //   1	456	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   95	106	133	java/io/IOException
    //   106	113	133	java/io/IOException
    //   118	130	133	java/io/IOException
    //   181	189	133	java/io/IOException
    //   205	209	211	java/io/IOException
    //   193	197	232	java/io/IOException
    //   161	165	250	java/io/IOException
    //   170	175	268	java/io/IOException
    //   15	38	285	java/lang/OutOfMemoryError
    //   38	63	285	java/lang/OutOfMemoryError
    //   63	72	285	java/lang/OutOfMemoryError
    //   317	321	333	java/io/IOException
    //   326	331	351	java/io/IOException
    //   15	38	368	finally
    //   38	63	368	finally
    //   63	72	368	finally
    //   375	379	391	java/io/IOException
    //   384	389	409	java/io/IOException
    //   79	95	427	finally
    //   303	313	427	finally
    //   95	106	434	finally
    //   106	113	434	finally
    //   118	130	434	finally
    //   181	189	434	finally
    //   147	157	445	finally
    //   79	95	455	java/lang/OutOfMemoryError
    //   95	106	463	java/lang/OutOfMemoryError
    //   106	113	463	java/lang/OutOfMemoryError
    //   118	130	463	java/lang/OutOfMemoryError
    //   181	189	463	java/lang/OutOfMemoryError
    //   15	38	474	java/io/IOException
    //   38	63	474	java/io/IOException
    //   63	72	474	java/io/IOException
    //   79	95	484	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    File localFile = new File(paramString1);
    if (localFile.exists()) {}
    try
    {
      bool = copyFile(localFile, createFile(paramString2));
      return bool;
    }
    catch (IOException localIOException)
    {
      QLog.d("FileUtils", 2, "copy fail from " + paramString1 + " to " + paramString2 + " " + localIOException.getMessage());
    }
    return false;
  }
  
  public static File createFile(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static void deleteFile(File paramFile)
  {
    try
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int i = 0;
          while (i < arrayOfFile.length)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      paramFile.delete();
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("FileUtils", 1, "deleteFile error");
    }
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  /* Error */
  public static byte[] e(File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_0
    //   9: ifnull +116 -> 125
    //   12: new 78	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore 4
    //   22: aload 4
    //   24: astore_3
    //   25: aload_0
    //   26: invokevirtual 538	java/io/File:length	()J
    //   29: l2i
    //   30: newarray byte
    //   32: astore 5
    //   34: iconst_0
    //   35: istore_1
    //   36: aload 4
    //   38: astore_3
    //   39: iload_1
    //   40: aload 5
    //   42: arraylength
    //   43: if_icmpge +31 -> 74
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: aload 5
    //   53: iload_1
    //   54: aload 5
    //   56: arraylength
    //   57: iload_1
    //   58: isub
    //   59: invokevirtual 687	java/io/InputStream:read	([BII)I
    //   62: istore_2
    //   63: iload_2
    //   64: iflt +10 -> 74
    //   67: iload_1
    //   68: iload_2
    //   69: iadd
    //   70: istore_1
    //   71: goto -35 -> 36
    //   74: aload 4
    //   76: astore_3
    //   77: iload_1
    //   78: aload 5
    //   80: arraylength
    //   81: if_icmpge +192 -> 273
    //   84: aload 7
    //   86: astore_0
    //   87: aload 4
    //   89: astore_3
    //   90: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +18 -> 111
    //   96: aload 4
    //   98: astore_3
    //   99: ldc 49
    //   101: iconst_2
    //   102: ldc_w 689
    //   105: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload 7
    //   110: astore_0
    //   111: aload_0
    //   112: astore_3
    //   113: aload 4
    //   115: ifnull +10 -> 125
    //   118: aload 4
    //   120: invokevirtual 690	java/io/InputStream:close	()V
    //   123: aload_0
    //   124: astore_3
    //   125: aload_3
    //   126: areturn
    //   127: astore 4
    //   129: aload_0
    //   130: astore_3
    //   131: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq -9 -> 125
    //   137: ldc 49
    //   139: iconst_2
    //   140: ldc_w 692
    //   143: aload 4
    //   145: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_0
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 6
    //   157: astore_0
    //   158: aload 4
    //   160: astore_3
    //   161: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +17 -> 181
    //   167: aload 4
    //   169: astore_3
    //   170: ldc 49
    //   172: iconst_2
    //   173: ldc_w 694
    //   176: aload 5
    //   178: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_0
    //   182: astore_3
    //   183: aload 4
    //   185: ifnull -60 -> 125
    //   188: aload 4
    //   190: invokevirtual 690	java/io/InputStream:close	()V
    //   193: aload_0
    //   194: areturn
    //   195: astore 4
    //   197: aload_0
    //   198: astore_3
    //   199: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -77 -> 125
    //   205: ldc 49
    //   207: iconst_2
    //   208: ldc_w 692
    //   211: aload 4
    //   213: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_0
    //   217: areturn
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_3
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 690	java/io/InputStream:close	()V
    //   229: aload_0
    //   230: athrow
    //   231: astore_3
    //   232: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq -6 -> 229
    //   238: ldc 49
    //   240: iconst_2
    //   241: ldc_w 692
    //   244: aload_3
    //   245: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -19 -> 229
    //   251: astore_0
    //   252: goto -31 -> 221
    //   255: astore 5
    //   257: aload 6
    //   259: astore_0
    //   260: goto -102 -> 158
    //   263: astore_3
    //   264: aload 5
    //   266: astore_0
    //   267: aload_3
    //   268: astore 5
    //   270: goto -112 -> 158
    //   273: aload 5
    //   275: astore_0
    //   276: goto -165 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramFile	File
    //   35	47	1	i	int
    //   62	8	2	j	int
    //   1	225	3	localObject1	Object
    //   231	14	3	localIOException1	IOException
    //   263	5	3	localException1	Exception
    //   20	99	4	localFileInputStream	FileInputStream
    //   127	17	4	localIOException2	IOException
    //   153	36	4	localObject2	Object
    //   195	17	4	localIOException3	IOException
    //   32	47	5	arrayOfByte	byte[]
    //   150	27	5	localException2	Exception
    //   255	10	5	localException3	Exception
    //   268	6	5	localException4	Exception
    //   3	255	6	localObject3	Object
    //   6	103	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	127	java/io/IOException
    //   12	22	150	java/lang/Exception
    //   188	193	195	java/io/IOException
    //   12	22	218	finally
    //   225	229	231	java/io/IOException
    //   25	34	251	finally
    //   39	46	251	finally
    //   49	63	251	finally
    //   77	84	251	finally
    //   90	96	251	finally
    //   99	108	251	finally
    //   161	167	251	finally
    //   170	181	251	finally
    //   25	34	255	java/lang/Exception
    //   39	46	263	java/lang/Exception
    //   49	63	263	java/lang/Exception
    //   77	84	263	java/lang/Exception
    //   90	96	263	java/lang/Exception
    //   99	108	263	java/lang/Exception
  }
  
  /* Error */
  public static String estimateFileType(String paramString)
  {
    // Byte code:
    //   0: new 78	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray byte
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 628	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +134 -> 157
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 698	aqhq:estimateFileType	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 142	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 142	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc_w 311
    //   59: astore_0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 325	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: ifnull -18 -> 51
    //   72: aload_2
    //   73: invokevirtual 142	java/io/FileInputStream:close	()V
    //   76: aload_0
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: areturn
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: ldc_w 311
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: ifnull -46 -> 51
    //   100: aload_2
    //   101: invokevirtual 142	java/io/FileInputStream:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 142	java/io/FileInputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: areturn
    //   125: astore_1
    //   126: goto -6 -> 120
    //   129: astore_0
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: ldc_w 311
    //   137: astore_0
    //   138: goto -50 -> 88
    //   141: astore_3
    //   142: goto -54 -> 88
    //   145: astore_3
    //   146: ldc_w 311
    //   149: astore_0
    //   150: goto -90 -> 60
    //   153: astore_3
    //   154: goto -94 -> 60
    //   157: ldc_w 311
    //   160: astore_0
    //   161: goto -128 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   10	58	1	localObject1	Object
    //   78	1	1	localIOException1	IOException
    //   89	7	1	localObject2	Object
    //   106	1	1	localIOException2	IOException
    //   111	6	1	localObject3	Object
    //   122	1	1	localIOException3	IOException
    //   125	1	1	localIOException4	IOException
    //   8	93	2	localFileInputStream	FileInputStream
    //   53	10	3	localFileNotFoundException1	FileNotFoundException
    //   81	10	3	localIOException5	IOException
    //   133	1	3	localIOException6	IOException
    //   141	1	3	localIOException7	IOException
    //   145	1	3	localFileNotFoundException2	FileNotFoundException
    //   153	1	3	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   72	76	78	java/io/IOException
    //   0	9	81	java/io/IOException
    //   100	104	106	java/io/IOException
    //   0	9	109	finally
    //   45	49	122	java/io/IOException
    //   116	120	125	java/io/IOException
    //   11	15	129	finally
    //   17	26	129	finally
    //   28	33	129	finally
    //   35	39	129	finally
    //   62	66	129	finally
    //   90	94	129	finally
    //   11	15	133	java/io/IOException
    //   17	26	133	java/io/IOException
    //   28	33	133	java/io/IOException
    //   35	39	141	java/io/IOException
    //   11	15	145	java/io/FileNotFoundException
    //   17	26	145	java/io/FileNotFoundException
    //   28	33	145	java/io/FileNotFoundException
    //   35	39	153	java/io/FileNotFoundException
  }
  
  public static String estimateFileType(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return unKnownFileTypeMark + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return unKnownFileTypeMark + "";
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 202	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 82	java/io/BufferedInputStream
    //   12: dup
    //   13: new 78	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 538	java/io/File:length	()J
    //   30: lstore_3
    //   31: lload_3
    //   32: ldc2_w 723
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +54 -> 96
    //   45: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +29 -> 77
    //   51: ldc 49
    //   53: iconst_2
    //   54: new 59	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 726
    //   64: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload_3
    //   68: invokevirtual 729	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 5
    //   79: ifnull -72 -> 7
    //   82: aload 5
    //   84: invokevirtual 690	java/io/InputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 730	java/lang/Throwable:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: lload_3
    //   97: l2i
    //   98: istore_1
    //   99: iload_1
    //   100: newarray byte
    //   102: astore 6
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: aload 6
    //   109: arraylength
    //   110: if_icmpge +28 -> 138
    //   113: aload 5
    //   115: aload 6
    //   117: iload_1
    //   118: aload 6
    //   120: arraylength
    //   121: iload_1
    //   122: isub
    //   123: invokevirtual 687	java/io/InputStream:read	([BII)I
    //   126: istore_2
    //   127: iload_2
    //   128: iflt +10 -> 138
    //   131: iload_1
    //   132: iload_2
    //   133: iadd
    //   134: istore_1
    //   135: goto -29 -> 106
    //   138: iload_1
    //   139: aload 6
    //   141: arraylength
    //   142: if_icmpge +35 -> 177
    //   145: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +29 -> 177
    //   151: ldc 49
    //   153: iconst_2
    //   154: new 59	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 732
    //   164: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 690	java/io/InputStream:close	()V
    //   187: aload 6
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 730	java/lang/Throwable:printStackTrace	()V
    //   195: goto -8 -> 187
    //   198: astore 5
    //   200: aconst_null
    //   201: astore 5
    //   203: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 49
    //   211: iconst_2
    //   212: new 59	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 734
    //   222: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload 5
    //   237: ifnull -230 -> 7
    //   240: aload 5
    //   242: invokevirtual 690	java/io/InputStream:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 730	java/lang/Throwable:printStackTrace	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: aconst_null
    //   256: astore 5
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 690	java/io/InputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore 5
    //   272: aload 5
    //   274: invokevirtual 730	java/lang/Throwable:printStackTrace	()V
    //   277: goto -9 -> 268
    //   280: astore_0
    //   281: goto -23 -> 258
    //   284: astore_0
    //   285: goto -27 -> 258
    //   288: astore 6
    //   290: goto -87 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramFile	File
    //   98	45	1	i	int
    //   126	8	2	j	int
    //   30	67	3	l	long
    //   24	159	5	localBufferedInputStream	java.io.BufferedInputStream
    //   198	1	5	localThrowable1	java.lang.Throwable
    //   201	63	5	localObject	Object
    //   270	3	5	localThrowable2	java.lang.Throwable
    //   102	86	6	arrayOfByte	byte[]
    //   288	1	6	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   82	87	89	java/lang/Throwable
    //   182	187	190	java/lang/Throwable
    //   9	26	198	java/lang/Throwable
    //   240	245	247	java/lang/Throwable
    //   9	26	254	finally
    //   263	268	270	java/lang/Throwable
    //   26	31	280	finally
    //   45	77	280	finally
    //   99	104	280	finally
    //   106	127	280	finally
    //   138	177	280	finally
    //   203	235	284	finally
    //   26	31	288	java/lang/Throwable
    //   45	77	288	java/lang/Throwable
    //   99	104	288	java/lang/Throwable
    //   106	127	288	java/lang/Throwable
    //   138	177	288	java/lang/Throwable
  }
  
  public static float getAvailableInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static ArrayList<String> getChildFiles(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    for (;;)
    {
      try
      {
        int j = localObject.length;
        if (i < j) {
          if (localObject[i].isDirectory())
          {
            if (paramBoolean) {
              paramString.add(localObject[i].getCanonicalPath());
            }
            paramString.addAll(getChildFiles(localObject[i].getCanonicalPath(), paramBoolean));
          }
          else
          {
            paramString.add(localObject[i].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      i += 1;
    }
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label36;
      }
      l1 = paramString.length();
    }
    label36:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists())
      {
        if (!localObject.isDirectory()) {
          break label133;
        }
        l1 = l2 + getFileOrFolderSize(localObject.getAbsolutePath());
      }
    }
    for (;;)
    {
      i += 1;
      l2 = l1;
      break;
      label133:
      l1 = l2;
      if (localObject.isFile()) {
        l1 = l2 + localObject.length();
      }
    }
  }
  
  /* Error */
  public static long getFileSizes(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 90	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 202	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 78	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 756	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 142	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 758	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 759	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 142	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 142	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	i	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  /* Error */
  public static String l(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 766	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +7 -> 14
    //   10: aload_0
    //   11: ifnonnull +13 -> 24
    //   14: ldc 49
    //   16: ldc_w 768
    //   19: invokestatic 772	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_1
    //   25: invokestatic 778	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   28: astore 4
    //   30: aload_0
    //   31: invokevirtual 784	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: aload 4
    //   36: ldc_w 786
    //   39: invokevirtual 792	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   42: astore 6
    //   44: aload 6
    //   46: ifnonnull +31 -> 77
    //   49: ldc 49
    //   51: ldc_w 794
    //   54: invokestatic 772	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore 4
    //   61: ldc 49
    //   63: ldc_w 796
    //   66: aload 4
    //   68: invokestatic 799	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aconst_null
    //   72: astore 6
    //   74: goto -30 -> 44
    //   77: aload_1
    //   78: getstatic 802	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 188	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_3
    //   85: iload_3
    //   86: iconst_m1
    //   87: if_icmpne +260 -> 347
    //   90: iload_3
    //   91: aload_1
    //   92: invokevirtual 178	java/lang/String:length	()I
    //   95: if_icmpge +252 -> 347
    //   98: new 59	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   105: aload_0
    //   106: aconst_null
    //   107: invokevirtual 805	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   110: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: getstatic 802	java/io/File:separator	Ljava/lang/String;
    //   116: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 802	java/io/File:separator	Ljava/lang/String;
    //   126: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 7
    //   138: ldc 49
    //   140: iconst_1
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 807
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload 7
    //   155: aastore
    //   156: invokestatic 809	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   159: new 90	java/io/File
    //   162: dup
    //   163: aload 7
    //   165: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 202	java/io/File:exists	()Z
    //   173: ifeq +8 -> 181
    //   176: aload_0
    //   177: invokevirtual 205	java/io/File:delete	()Z
    //   180: pop
    //   181: aload_0
    //   182: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   185: ifnull +21 -> 206
    //   188: aload_0
    //   189: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   192: invokevirtual 202	java/io/File:exists	()Z
    //   195: ifne +11 -> 206
    //   198: aload_0
    //   199: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   202: invokevirtual 94	java/io/File:mkdirs	()Z
    //   205: pop
    //   206: new 144	java/io/FileOutputStream
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   214: astore_0
    //   215: new 82	java/io/BufferedInputStream
    //   218: dup
    //   219: new 78	java/io/FileInputStream
    //   222: dup
    //   223: aload 6
    //   225: invokevirtual 815	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   228: invokespecial 818	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   231: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   234: astore 4
    //   236: aload 4
    //   238: astore_2
    //   239: aload_0
    //   240: astore_1
    //   241: ldc_w 819
    //   244: newarray byte
    //   246: astore 5
    //   248: aload 4
    //   250: astore_2
    //   251: aload_0
    //   252: astore_1
    //   253: aload 4
    //   255: aload 5
    //   257: invokevirtual 665	java/io/BufferedInputStream:read	([B)I
    //   260: istore_3
    //   261: iload_3
    //   262: iconst_m1
    //   263: if_icmpeq +95 -> 358
    //   266: aload 4
    //   268: astore_2
    //   269: aload_0
    //   270: astore_1
    //   271: aload_0
    //   272: aload 5
    //   274: iconst_0
    //   275: iload_3
    //   276: invokevirtual 324	java/io/FileOutputStream:write	([BII)V
    //   279: aload 4
    //   281: astore_2
    //   282: aload_0
    //   283: astore_1
    //   284: aload_0
    //   285: invokevirtual 326	java/io/FileOutputStream:flush	()V
    //   288: goto -40 -> 248
    //   291: astore 5
    //   293: aload 4
    //   295: astore_2
    //   296: aload_0
    //   297: astore_1
    //   298: ldc 49
    //   300: ldc_w 821
    //   303: aload 5
    //   305: invokestatic 799	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 822	android/os/ParcelFileDescriptor:close	()V
    //   318: aload_0
    //   319: ifnull +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   326: aload 4
    //   328: ifnull +384 -> 712
    //   331: aload 4
    //   333: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   336: iconst_0
    //   337: istore_3
    //   338: iload_3
    //   339: ifeq +318 -> 657
    //   342: aload 7
    //   344: astore_0
    //   345: aload_0
    //   346: areturn
    //   347: aload_1
    //   348: iload_3
    //   349: iconst_1
    //   350: iadd
    //   351: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_1
    //   355: goto -257 -> 98
    //   358: aload 6
    //   360: ifnull +8 -> 368
    //   363: aload 6
    //   365: invokevirtual 822	android/os/ParcelFileDescriptor:close	()V
    //   368: aload_0
    //   369: ifnull +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   376: aload 4
    //   378: ifnull +339 -> 717
    //   381: aload 4
    //   383: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   386: iconst_1
    //   387: istore_3
    //   388: goto -50 -> 338
    //   391: astore_1
    //   392: ldc 49
    //   394: iconst_1
    //   395: ldc_w 824
    //   398: aload_1
    //   399: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -34 -> 368
    //   405: astore_0
    //   406: ldc 49
    //   408: iconst_1
    //   409: ldc_w 824
    //   412: aload_0
    //   413: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -40 -> 376
    //   419: astore_0
    //   420: ldc 49
    //   422: iconst_1
    //   423: ldc_w 824
    //   426: aload_0
    //   427: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: iconst_1
    //   431: istore_3
    //   432: goto -94 -> 338
    //   435: astore_1
    //   436: ldc 49
    //   438: iconst_1
    //   439: ldc_w 824
    //   442: aload_1
    //   443: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   446: goto -128 -> 318
    //   449: astore_0
    //   450: ldc 49
    //   452: iconst_1
    //   453: ldc_w 824
    //   456: aload_0
    //   457: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: goto -134 -> 326
    //   463: astore_0
    //   464: ldc 49
    //   466: iconst_1
    //   467: ldc_w 824
    //   470: aload_0
    //   471: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -138 -> 338
    //   479: astore 5
    //   481: aconst_null
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_0
    //   486: aload 4
    //   488: astore_2
    //   489: aload_0
    //   490: astore_1
    //   491: ldc 49
    //   493: ldc_w 826
    //   496: aload 5
    //   498: invokestatic 799	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 822	android/os/ParcelFileDescriptor:close	()V
    //   511: aload_0
    //   512: ifnull +7 -> 519
    //   515: aload_0
    //   516: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   519: aload 4
    //   521: ifnull +191 -> 712
    //   524: aload 4
    //   526: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -193 -> 338
    //   534: astore_1
    //   535: ldc 49
    //   537: iconst_1
    //   538: ldc_w 824
    //   541: aload_1
    //   542: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -34 -> 511
    //   548: astore_0
    //   549: ldc 49
    //   551: iconst_1
    //   552: ldc_w 824
    //   555: aload_0
    //   556: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   559: goto -40 -> 519
    //   562: astore_0
    //   563: ldc 49
    //   565: iconst_1
    //   566: ldc_w 824
    //   569: aload_0
    //   570: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: iconst_0
    //   574: istore_3
    //   575: goto -237 -> 338
    //   578: astore_2
    //   579: aconst_null
    //   580: astore_0
    //   581: aload 5
    //   583: astore 4
    //   585: aload 6
    //   587: ifnull +8 -> 595
    //   590: aload 6
    //   592: invokevirtual 822	android/os/ParcelFileDescriptor:close	()V
    //   595: aload_0
    //   596: ifnull +7 -> 603
    //   599: aload_0
    //   600: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   603: aload 4
    //   605: ifnull +8 -> 613
    //   608: aload 4
    //   610: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   613: aload_2
    //   614: athrow
    //   615: astore_1
    //   616: ldc 49
    //   618: iconst_1
    //   619: ldc_w 824
    //   622: aload_1
    //   623: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: goto -31 -> 595
    //   629: astore_0
    //   630: ldc 49
    //   632: iconst_1
    //   633: ldc_w 824
    //   636: aload_0
    //   637: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: goto -37 -> 603
    //   643: astore_0
    //   644: ldc 49
    //   646: iconst_1
    //   647: ldc_w 824
    //   650: aload_0
    //   651: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: goto -41 -> 613
    //   657: aconst_null
    //   658: astore_0
    //   659: goto -314 -> 345
    //   662: astore_2
    //   663: aload 5
    //   665: astore 4
    //   667: goto -82 -> 585
    //   670: astore_0
    //   671: aload_2
    //   672: astore 4
    //   674: aload_0
    //   675: astore_2
    //   676: aload_1
    //   677: astore_0
    //   678: goto -93 -> 585
    //   681: astore 5
    //   683: aconst_null
    //   684: astore 4
    //   686: goto -200 -> 486
    //   689: astore 5
    //   691: goto -205 -> 486
    //   694: astore 5
    //   696: aconst_null
    //   697: astore 4
    //   699: aconst_null
    //   700: astore_0
    //   701: goto -408 -> 293
    //   704: astore 5
    //   706: aconst_null
    //   707: astore 4
    //   709: goto -416 -> 293
    //   712: iconst_0
    //   713: istore_3
    //   714: goto -376 -> 338
    //   717: iconst_1
    //   718: istore_3
    //   719: goto -381 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	paramContext	Context
    //   0	722	1	paramString1	String
    //   0	722	2	paramString2	String
    //   84	635	3	i	int
    //   28	7	4	localUri	android.net.Uri
    //   59	8	4	localFileNotFoundException	FileNotFoundException
    //   234	474	4	localObject	Object
    //   1	272	5	arrayOfByte	byte[]
    //   291	13	5	localIOException1	IOException
    //   479	185	5	localOutOfMemoryError1	OutOfMemoryError
    //   681	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   689	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   694	1	5	localIOException2	IOException
    //   704	1	5	localIOException3	IOException
    //   42	549	6	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   136	207	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	44	59	java/io/FileNotFoundException
    //   241	248	291	java/io/IOException
    //   253	261	291	java/io/IOException
    //   271	279	291	java/io/IOException
    //   284	288	291	java/io/IOException
    //   363	368	391	java/io/IOException
    //   372	376	405	java/io/IOException
    //   381	386	419	java/io/IOException
    //   313	318	435	java/io/IOException
    //   322	326	449	java/io/IOException
    //   331	336	463	java/io/IOException
    //   169	181	479	java/lang/OutOfMemoryError
    //   181	206	479	java/lang/OutOfMemoryError
    //   206	215	479	java/lang/OutOfMemoryError
    //   506	511	534	java/io/IOException
    //   515	519	548	java/io/IOException
    //   524	529	562	java/io/IOException
    //   169	181	578	finally
    //   181	206	578	finally
    //   206	215	578	finally
    //   590	595	615	java/io/IOException
    //   599	603	629	java/io/IOException
    //   608	613	643	java/io/IOException
    //   215	236	662	finally
    //   241	248	670	finally
    //   253	261	670	finally
    //   271	279	670	finally
    //   284	288	670	finally
    //   298	308	670	finally
    //   491	501	670	finally
    //   215	236	681	java/lang/OutOfMemoryError
    //   241	248	689	java/lang/OutOfMemoryError
    //   253	261	689	java/lang/OutOfMemoryError
    //   271	279	689	java/lang/OutOfMemoryError
    //   284	288	689	java/lang/OutOfMemoryError
    //   169	181	694	java/io/IOException
    //   181	206	694	java/io/IOException
    //   206	215	694	java/io/IOException
    //   215	236	704	java/io/IOException
  }
  
  /* Error */
  public static void l(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: iload_1
    //   5: ifeq +10 -> 15
    //   8: aload_2
    //   9: invokestatic 766	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 831	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: iload_1
    //   21: invokevirtual 837	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   24: checkcast 839	com/tencent/theme/SkinnableBitmapDrawable
    //   27: astore_3
    //   28: new 90	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 202	java/io/File:exists	()Z
    //   41: ifne +16 -> 57
    //   44: aload_0
    //   45: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 94	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_0
    //   53: invokevirtual 260	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: new 144	java/io/FileOutputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_0
    //   66: aload_3
    //   67: invokevirtual 843	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   70: getstatic 846	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_0
    //   76: invokevirtual 296	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_0
    //   81: ifnull -66 -> 15
    //   84: aload_0
    //   85: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   88: return
    //   89: astore_0
    //   90: return
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   96: goto -39 -> 57
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull -88 -> 15
    //   106: aload_0
    //   107: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_0
    //   112: return
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -102 -> 15
    //   120: aload_0
    //   121: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: return
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_0
    //   141: goto -3 -> 138
    //   144: astore_2
    //   145: goto -15 -> 130
    //   148: astore_2
    //   149: goto -33 -> 116
    //   152: astore_2
    //   153: goto -51 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramContext	Context
    //   0	156	1	paramInt	int
    //   0	156	2	paramString	String
    //   27	40	3	localSkinnableBitmapDrawable	com.tencent.theme.SkinnableBitmapDrawable
    // Exception table:
    //   from	to	target	type
    //   84	88	89	java/io/IOException
    //   52	57	91	java/io/IOException
    //   57	66	99	java/io/IOException
    //   106	110	111	java/io/IOException
    //   57	66	113	java/lang/OutOfMemoryError
    //   120	124	125	java/io/IOException
    //   57	66	127	finally
    //   134	138	140	java/io/IOException
    //   66	80	144	finally
    //   66	80	148	java/lang/OutOfMemoryError
    //   66	80	152	java/io/IOException
  }
  
  public static File m(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.mkdirs();
      }
    }
    return paramString;
    label50:
    paramString.mkdirs();
    return paramString;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    try
    {
      copyFile(paramString1, createFile(paramString2));
      paramString1.delete();
      return true;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  /* Error */
  public static boolean n(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 473
    //   3: invokestatic 471	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +63 -> 74
    //   14: new 90	java/io/File
    //   17: dup
    //   18: getstatic 493	acbn:SDCARD_PATH	Ljava/lang/String;
    //   21: invokestatic 500	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: new 90	java/io/File
    //   32: dup
    //   33: aload 4
    //   35: ldc_w 502
    //   38: invokespecial 596	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 202	java/io/File:exists	()Z
    //   48: ifeq +37 -> 85
    //   51: iconst_1
    //   52: istore_3
    //   53: iload_3
    //   54: ireturn
    //   55: astore_0
    //   56: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: ldc 49
    //   64: iconst_2
    //   65: ldc_w 850
    //   68: aload_0
    //   69: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: getstatic 854	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   77: invokevirtual 857	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   80: astore 4
    //   82: goto -53 -> 29
    //   85: aload 4
    //   87: invokevirtual 94	java/io/File:mkdirs	()Z
    //   90: istore_2
    //   91: getstatic 17	aqhq:cTY	Z
    //   94: ifne +7 -> 101
    //   97: iconst_1
    //   98: putstatic 17	aqhq:cTY	Z
    //   101: iload_2
    //   102: ifne +36 -> 138
    //   105: invokestatic 859	aqhq:aCK	()Z
    //   108: ifeq +15 -> 123
    //   111: invokestatic 861	aqhq:aCL	()Z
    //   114: ifeq +9 -> 123
    //   117: invokestatic 863	aqhq:aCM	()Z
    //   120: ifne +18 -> 138
    //   123: invokestatic 869	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   126: new 871	com/tencent/mobileqq/utils/FileUtils$2
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 874	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   134: invokevirtual 880	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   137: pop
    //   138: iload_2
    //   139: istore_3
    //   140: iload_1
    //   141: ifeq -88 -> 53
    //   144: iload_2
    //   145: ifne +11 -> 156
    //   148: iload_2
    //   149: istore_3
    //   150: getstatic 17	aqhq:cTY	Z
    //   153: ifeq -100 -> 53
    //   156: iload_2
    //   157: invokestatic 886	akxp:Nt	(Z)V
    //   160: iload_2
    //   161: istore_3
    //   162: iload_2
    //   163: ifne -110 -> 53
    //   166: iconst_0
    //   167: putstatic 17	aqhq:cTY	Z
    //   170: iload_2
    //   171: ireturn
    //   172: astore 4
    //   174: invokestatic 859	aqhq:aCK	()Z
    //   177: ifeq +15 -> 192
    //   180: invokestatic 861	aqhq:aCL	()Z
    //   183: ifeq +9 -> 192
    //   186: invokestatic 863	aqhq:aCM	()Z
    //   189: ifne +18 -> 207
    //   192: invokestatic 869	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   195: new 871	com/tencent/mobileqq/utils/FileUtils$2
    //   198: dup
    //   199: aload_0
    //   200: invokespecial 874	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   203: invokevirtual 880	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   206: pop
    //   207: iload_1
    //   208: ifeq +94 -> 302
    //   211: getstatic 17	aqhq:cTY	Z
    //   214: ifeq +88 -> 302
    //   217: iconst_0
    //   218: invokestatic 886	akxp:Nt	(Z)V
    //   221: iconst_0
    //   222: putstatic 17	aqhq:cTY	Z
    //   225: iconst_0
    //   226: ireturn
    //   227: astore 4
    //   229: iconst_0
    //   230: istore_2
    //   231: iload_2
    //   232: ifne +36 -> 268
    //   235: invokestatic 859	aqhq:aCK	()Z
    //   238: ifeq +15 -> 253
    //   241: invokestatic 861	aqhq:aCL	()Z
    //   244: ifeq +9 -> 253
    //   247: invokestatic 863	aqhq:aCM	()Z
    //   250: ifne +18 -> 268
    //   253: invokestatic 869	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   256: new 871	com/tencent/mobileqq/utils/FileUtils$2
    //   259: dup
    //   260: aload_0
    //   261: invokespecial 874	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   264: invokevirtual 880	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   267: pop
    //   268: iload_1
    //   269: ifeq +25 -> 294
    //   272: iload_2
    //   273: ifne +9 -> 282
    //   276: getstatic 17	aqhq:cTY	Z
    //   279: ifeq +15 -> 294
    //   282: iload_2
    //   283: invokestatic 886	akxp:Nt	(Z)V
    //   286: iload_2
    //   287: ifne +7 -> 294
    //   290: iconst_0
    //   291: putstatic 17	aqhq:cTY	Z
    //   294: aload 4
    //   296: athrow
    //   297: astore 4
    //   299: goto -68 -> 231
    //   302: iconst_0
    //   303: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramBoolean	boolean
    //   9	278	2	bool1	boolean
    //   52	110	3	bool2	boolean
    //   27	59	4	localFile	File
    //   172	1	4	localException	Exception
    //   227	68	4	localObject1	Object
    //   297	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	55	java/lang/NullPointerException
    //   85	91	172	java/lang/Exception
    //   91	101	172	java/lang/Exception
    //   85	91	227	finally
    //   91	101	297	finally
  }
  
  /* Error */
  public static Object o(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 766	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: new 394	java/io/ObjectInputStream
    //   18: dup
    //   19: new 82	java/io/BufferedInputStream
    //   22: dup
    //   23: invokestatic 398	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: aload_0
    //   27: invokevirtual 404	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 405	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 450	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: ifnull -36 -> 13
    //   52: aload_2
    //   53: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_0
    //   59: aload_1
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +44 -> 113
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 49
    //   76: iconst_2
    //   77: new 59	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 890
    //   87: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 892
    //   97: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 894	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 4
    //   115: astore_0
    //   116: aload_2
    //   117: ifnull -104 -> 13
    //   120: aload_2
    //   121: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 432	java/io/ObjectInputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: astore_1
    //   143: goto -3 -> 140
    //   146: astore_0
    //   147: goto -15 -> 132
    //   150: astore_3
    //   151: goto -87 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   38	99	1	localObject1	Object
    //   142	1	1	localIOException	IOException
    //   36	85	2	localObjectInputStream	java.io.ObjectInputStream
    //   43	2	3	localObject2	Object
    //   61	40	3	localException1	Exception
    //   150	1	3	localException2	Exception
    //   1	113	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	58	java/io/IOException
    //   15	37	61	java/lang/Exception
    //   120	124	126	java/io/IOException
    //   15	37	129	finally
    //   136	140	142	java/io/IOException
    //   39	44	146	finally
    //   66	72	146	finally
    //   74	113	146	finally
    //   39	44	150	java/lang/Exception
  }
  
  /* Error */
  public static boolean p(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 5
    //   12: new 144	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore 6
    //   24: aload 9
    //   26: astore 7
    //   28: new 82	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 900	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   36: aload_1
    //   37: invokevirtual 906	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: sipush 8192
    //   47: newarray byte
    //   49: astore_1
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 665	java/io/BufferedInputStream:read	([B)I
    //   55: istore_3
    //   56: iload_3
    //   57: iconst_m1
    //   58: if_icmpeq +57 -> 115
    //   61: aload_2
    //   62: aload_1
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 907	java/io/OutputStream:write	([BII)V
    //   68: goto -18 -> 50
    //   71: astore 6
    //   73: aload_0
    //   74: astore_1
    //   75: aload 6
    //   77: astore_0
    //   78: aload_2
    //   79: astore 6
    //   81: aload_1
    //   82: astore 7
    //   84: aload_0
    //   85: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   96: iload 5
    //   98: istore 4
    //   100: aload_2
    //   101: ifnull +11 -> 112
    //   104: aload_2
    //   105: invokevirtual 300	java/io/OutputStream:close	()V
    //   108: iload 5
    //   110: istore 4
    //   112: iload 4
    //   114: ireturn
    //   115: iconst_1
    //   116: istore 4
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   126: aload_2
    //   127: ifnull -15 -> 112
    //   130: aload_2
    //   131: invokevirtual 300	java/io/OutputStream:close	()V
    //   134: iconst_1
    //   135: ireturn
    //   136: astore_0
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_2
    //   142: aload 7
    //   144: ifnull +8 -> 152
    //   147: aload 7
    //   149: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 300	java/io/OutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -37 -> 126
    //   166: astore_0
    //   167: goto -71 -> 96
    //   170: astore_0
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_1
    //   174: goto -22 -> 152
    //   177: astore_1
    //   178: goto -18 -> 160
    //   181: astore_0
    //   182: aload 6
    //   184: astore_2
    //   185: goto -43 -> 142
    //   188: astore_1
    //   189: aload_0
    //   190: astore 7
    //   192: aload_1
    //   193: astore_0
    //   194: goto -52 -> 142
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_2
    //   200: aload 8
    //   202: astore_1
    //   203: goto -125 -> 78
    //   206: astore_0
    //   207: aload 8
    //   209: astore_1
    //   210: goto -132 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramContext	Context
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   55	10	3	i	int
    //   98	19	4	bool1	boolean
    //   10	99	5	bool2	boolean
    //   22	1	6	str1	String
    //   71	5	6	localIOException	IOException
    //   79	104	6	str2	String
    //   1	190	7	localObject1	Object
    //   7	201	8	localObject2	Object
    //   4	21	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	71	java/io/IOException
    //   50	56	71	java/io/IOException
    //   61	68	71	java/io/IOException
    //   130	134	136	java/io/IOException
    //   12	21	139	finally
    //   122	126	162	java/io/IOException
    //   92	96	166	java/io/IOException
    //   104	108	170	java/io/IOException
    //   147	152	173	java/io/IOException
    //   156	160	177	java/io/IOException
    //   28	44	181	finally
    //   84	88	181	finally
    //   44	50	188	finally
    //   50	56	188	finally
    //   61	68	188	finally
    //   12	21	197	java/io/IOException
    //   28	44	206	java/io/IOException
  }
  
  /* Error */
  public static String pw(String paramString)
  {
    // Byte code:
    //   0: new 78	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_2
    //   13: bipush 10
    //   15: newarray byte
    //   17: astore_0
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: aload_0
    //   24: invokevirtual 628	java/io/FileInputStream:read	([B)I
    //   27: iconst_m1
    //   28: if_icmpeq +354 -> 382
    //   31: aload 4
    //   33: astore_2
    //   34: new 59	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: iconst_0
    //   43: istore_1
    //   44: aload 4
    //   46: astore_2
    //   47: iload_1
    //   48: aload_0
    //   49: arraylength
    //   50: if_icmpge +25 -> 75
    //   53: aload 4
    //   55: astore_2
    //   56: aload_3
    //   57: aload_0
    //   58: iload_1
    //   59: baload
    //   60: sipush 255
    //   63: iand
    //   64: invokevirtual 599	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -28 -> 44
    //   75: aload 4
    //   77: astore_2
    //   78: aload_3
    //   79: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: ldc_w 910
    //   85: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +19 -> 107
    //   91: aload 4
    //   93: astore_2
    //   94: aload_3
    //   95: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: ldc_w 912
    //   101: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +31 -> 135
    //   107: ldc_w 914
    //   110: astore_0
    //   111: aload 4
    //   113: astore_2
    //   114: aload 4
    //   116: invokevirtual 142	java/io/FileInputStream:close	()V
    //   119: aload_0
    //   120: astore_2
    //   121: aload 4
    //   123: ifnull +10 -> 133
    //   126: aload 4
    //   128: invokevirtual 142	java/io/FileInputStream:close	()V
    //   131: aload_0
    //   132: astore_2
    //   133: aload_2
    //   134: areturn
    //   135: aload 4
    //   137: astore_2
    //   138: aload_3
    //   139: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: ldc_w 916
    //   145: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifeq +10 -> 158
    //   151: ldc_w 918
    //   154: astore_0
    //   155: goto -44 -> 111
    //   158: aload 4
    //   160: astore_2
    //   161: aload_3
    //   162: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: ldc_w 920
    //   168: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +10 -> 181
    //   174: ldc_w 922
    //   177: astore_0
    //   178: goto -67 -> 111
    //   181: aload 4
    //   183: astore_2
    //   184: aload_3
    //   185: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: ldc_w 924
    //   191: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +10 -> 204
    //   197: ldc_w 926
    //   200: astore_0
    //   201: goto -90 -> 111
    //   204: aload 4
    //   206: astore_2
    //   207: aload_3
    //   208: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: ldc_w 928
    //   214: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq +10 -> 227
    //   220: ldc_w 930
    //   223: astore_0
    //   224: goto -113 -> 111
    //   227: aload 4
    //   229: astore_2
    //   230: new 59	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   237: getstatic 28	aqhq:unKnownFileTypeMark	Ljava/lang/String;
    //   240: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore_0
    //   251: goto -140 -> 111
    //   254: astore_3
    //   255: aconst_null
    //   256: astore 4
    //   258: ldc_w 311
    //   261: astore_0
    //   262: aload 4
    //   264: astore_2
    //   265: aload_3
    //   266: invokevirtual 325	java/io/FileNotFoundException:printStackTrace	()V
    //   269: aload_0
    //   270: astore_2
    //   271: aload 4
    //   273: ifnull -140 -> 133
    //   276: aload 4
    //   278: invokevirtual 142	java/io/FileInputStream:close	()V
    //   281: aload_0
    //   282: areturn
    //   283: astore_2
    //   284: aload_0
    //   285: areturn
    //   286: astore_3
    //   287: aconst_null
    //   288: astore 4
    //   290: ldc_w 311
    //   293: astore_0
    //   294: aload 4
    //   296: astore_2
    //   297: aload_3
    //   298: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   301: aload_0
    //   302: astore_2
    //   303: aload 4
    //   305: ifnull -172 -> 133
    //   308: aload 4
    //   310: invokevirtual 142	java/io/FileInputStream:close	()V
    //   313: aload_0
    //   314: areturn
    //   315: astore_2
    //   316: aload_0
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +7 -> 329
    //   325: aload_2
    //   326: invokevirtual 142	java/io/FileInputStream:close	()V
    //   329: aload_0
    //   330: athrow
    //   331: astore_2
    //   332: aload_0
    //   333: areturn
    //   334: astore_2
    //   335: goto -6 -> 329
    //   338: astore_0
    //   339: goto -18 -> 321
    //   342: astore_3
    //   343: ldc_w 311
    //   346: astore_0
    //   347: goto -53 -> 294
    //   350: astore_3
    //   351: ldc_w 311
    //   354: astore_0
    //   355: goto -61 -> 294
    //   358: astore_3
    //   359: goto -65 -> 294
    //   362: astore_3
    //   363: ldc_w 311
    //   366: astore_0
    //   367: goto -105 -> 262
    //   370: astore_3
    //   371: ldc_w 311
    //   374: astore_0
    //   375: goto -113 -> 262
    //   378: astore_3
    //   379: goto -117 -> 262
    //   382: ldc_w 311
    //   385: astore_0
    //   386: goto -275 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString	String
    //   43	29	1	i	int
    //   12	259	2	localObject1	Object
    //   283	1	2	localIOException1	IOException
    //   296	7	2	localObject2	Object
    //   315	1	2	localIOException2	IOException
    //   320	6	2	localObject3	Object
    //   331	1	2	localIOException3	IOException
    //   334	1	2	localIOException4	IOException
    //   41	203	3	localStringBuilder	java.lang.StringBuilder
    //   254	12	3	localFileNotFoundException1	FileNotFoundException
    //   286	12	3	localIOException5	IOException
    //   342	1	3	localIOException6	IOException
    //   350	1	3	localIOException7	IOException
    //   358	1	3	localIOException8	IOException
    //   362	1	3	localFileNotFoundException2	FileNotFoundException
    //   370	1	3	localFileNotFoundException3	FileNotFoundException
    //   378	1	3	localFileNotFoundException4	FileNotFoundException
    //   8	301	4	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	10	254	java/io/FileNotFoundException
    //   276	281	283	java/io/IOException
    //   0	10	286	java/io/IOException
    //   308	313	315	java/io/IOException
    //   0	10	318	finally
    //   126	131	331	java/io/IOException
    //   325	329	334	java/io/IOException
    //   13	18	338	finally
    //   21	31	338	finally
    //   34	42	338	finally
    //   47	53	338	finally
    //   56	68	338	finally
    //   78	91	338	finally
    //   94	107	338	finally
    //   114	119	338	finally
    //   138	151	338	finally
    //   161	174	338	finally
    //   184	197	338	finally
    //   207	220	338	finally
    //   230	251	338	finally
    //   265	269	338	finally
    //   297	301	338	finally
    //   13	18	342	java/io/IOException
    //   21	31	342	java/io/IOException
    //   34	42	350	java/io/IOException
    //   47	53	350	java/io/IOException
    //   56	68	350	java/io/IOException
    //   78	91	350	java/io/IOException
    //   94	107	350	java/io/IOException
    //   138	151	350	java/io/IOException
    //   161	174	350	java/io/IOException
    //   184	197	350	java/io/IOException
    //   207	220	350	java/io/IOException
    //   230	251	350	java/io/IOException
    //   114	119	358	java/io/IOException
    //   13	18	362	java/io/FileNotFoundException
    //   21	31	362	java/io/FileNotFoundException
    //   34	42	370	java/io/FileNotFoundException
    //   47	53	370	java/io/FileNotFoundException
    //   56	68	370	java/io/FileNotFoundException
    //   78	91	370	java/io/FileNotFoundException
    //   94	107	370	java/io/FileNotFoundException
    //   138	151	370	java/io/FileNotFoundException
    //   161	174	370	java/io/FileNotFoundException
    //   184	197	370	java/io/FileNotFoundException
    //   207	220	370	java/io/FileNotFoundException
    //   230	251	370	java/io/FileNotFoundException
    //   114	119	378	java/io/FileNotFoundException
  }
  
  public static String px(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    long l;
    do
    {
      return null;
      l = localFile.length();
    } while (l == 0L);
    return z(paramString, l);
  }
  
  public static String py(String paramString)
  {
    String str1 = "";
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getAssets().open(paramString);
        localObject1 = paramString;
        localObject2 = paramString;
        String str2 = jqo.e(paramString);
        localObject1 = str2;
        localObject2 = localObject1;
      }
      catch (IOException paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject1;
        paramString.printStackTrace();
        localObject2 = str1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          return "";
        }
        catch (Exception paramString)
        {
          localObject2 = str1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return "";
      }
      finally
      {
        if (localObject2 == null) {
          break label116;
        }
      }
      try
      {
        paramString.close();
        localObject2 = localObject1;
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return localObject1;
      }
    }
    return localObject2;
    try
    {
      ((InputStream)localObject2).close();
      label116:
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 766	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 90	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 202	java/io/File:exists	()Z
    //   26: ifeq -17 -> 9
    //   29: aload 4
    //   31: invokevirtual 538	java/io/File:length	()J
    //   34: l2i
    //   35: istore_2
    //   36: new 947	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: iload_2
    //   41: invokespecial 948	java/io/ByteArrayOutputStream:<init>	(I)V
    //   44: astore_0
    //   45: new 78	java/io/FileInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 6
    //   56: iload_2
    //   57: sipush 4096
    //   60: if_icmpge +63 -> 123
    //   63: aload_0
    //   64: astore 5
    //   66: aload 6
    //   68: astore 4
    //   70: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   73: sipush 4096
    //   76: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   79: astore 7
    //   81: iload_1
    //   82: iload_2
    //   83: if_icmpge +84 -> 167
    //   86: aload_0
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: aload 6
    //   95: aload 7
    //   97: invokevirtual 628	java/io/FileInputStream:read	([B)I
    //   100: istore_3
    //   101: aload_0
    //   102: astore 5
    //   104: aload 6
    //   106: astore 4
    //   108: aload_0
    //   109: aload 7
    //   111: iconst_0
    //   112: iload_3
    //   113: invokevirtual 949	java/io/ByteArrayOutputStream:write	([BII)V
    //   116: iload_1
    //   117: iload_3
    //   118: iadd
    //   119: istore_1
    //   120: goto -39 -> 81
    //   123: aload_0
    //   124: astore 5
    //   126: aload 6
    //   128: astore 4
    //   130: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   133: sipush 12288
    //   136: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   139: astore 7
    //   141: goto -60 -> 81
    //   144: astore 4
    //   146: aload_0
    //   147: astore 5
    //   149: aload 6
    //   151: astore 4
    //   153: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   156: sipush 4096
    //   159: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   162: astore 7
    //   164: goto -83 -> 81
    //   167: aload_0
    //   168: astore 5
    //   170: aload 6
    //   172: astore 4
    //   174: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   177: aload 7
    //   179: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   182: aload_0
    //   183: astore 5
    //   185: aload 6
    //   187: astore 4
    //   189: aload_0
    //   190: invokevirtual 952	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: astore 7
    //   195: aload 7
    //   197: astore 4
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   207: aload 4
    //   209: astore_0
    //   210: aload 6
    //   212: ifnull +11 -> 223
    //   215: aload 6
    //   217: invokevirtual 142	java/io/FileInputStream:close	()V
    //   220: aload 4
    //   222: astore_0
    //   223: aload_0
    //   224: areturn
    //   225: astore_0
    //   226: ldc 49
    //   228: iconst_1
    //   229: ldc_w 955
    //   232: aload_0
    //   233: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload 4
    //   238: astore_0
    //   239: goto -16 -> 223
    //   242: astore 7
    //   244: aconst_null
    //   245: astore 8
    //   247: aconst_null
    //   248: astore_0
    //   249: aload 8
    //   251: astore 5
    //   253: aload_0
    //   254: astore 4
    //   256: ldc 49
    //   258: iconst_1
    //   259: ldc_w 955
    //   262: aload 7
    //   264: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload 8
    //   269: ifnull +8 -> 277
    //   272: aload 8
    //   274: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 142	java/io/FileInputStream:close	()V
    //   285: aconst_null
    //   286: astore_0
    //   287: goto -64 -> 223
    //   290: astore_0
    //   291: ldc 49
    //   293: iconst_1
    //   294: ldc_w 955
    //   297: aload_0
    //   298: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aconst_null
    //   302: astore_0
    //   303: goto -80 -> 223
    //   306: astore 7
    //   308: aconst_null
    //   309: astore 8
    //   311: aconst_null
    //   312: astore_0
    //   313: aload 8
    //   315: astore 5
    //   317: aload_0
    //   318: astore 4
    //   320: ldc 49
    //   322: iconst_1
    //   323: ldc_w 957
    //   326: aload 7
    //   328: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload 8
    //   333: ifnull +8 -> 341
    //   336: aload 8
    //   338: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   341: aload_0
    //   342: ifnull +7 -> 349
    //   345: aload_0
    //   346: invokevirtual 142	java/io/FileInputStream:close	()V
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -128 -> 223
    //   354: astore_0
    //   355: ldc 49
    //   357: iconst_1
    //   358: ldc_w 955
    //   361: aload_0
    //   362: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aconst_null
    //   366: astore_0
    //   367: goto -144 -> 223
    //   370: astore 6
    //   372: aconst_null
    //   373: astore_0
    //   374: aconst_null
    //   375: astore 4
    //   377: aload_0
    //   378: ifnull +7 -> 385
    //   381: aload_0
    //   382: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   385: aload 4
    //   387: ifnull +8 -> 395
    //   390: aload 4
    //   392: invokevirtual 142	java/io/FileInputStream:close	()V
    //   395: aload 6
    //   397: athrow
    //   398: astore_0
    //   399: ldc 49
    //   401: iconst_1
    //   402: ldc_w 955
    //   405: aload_0
    //   406: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   409: goto -14 -> 395
    //   412: astore 6
    //   414: aconst_null
    //   415: astore 4
    //   417: goto -40 -> 377
    //   420: astore 6
    //   422: aload 5
    //   424: astore_0
    //   425: goto -48 -> 377
    //   428: astore 7
    //   430: aconst_null
    //   431: astore 4
    //   433: aload_0
    //   434: astore 8
    //   436: aload 4
    //   438: astore_0
    //   439: goto -126 -> 313
    //   442: astore 7
    //   444: aload_0
    //   445: astore 8
    //   447: aload 6
    //   449: astore_0
    //   450: goto -137 -> 313
    //   453: astore 7
    //   455: aconst_null
    //   456: astore 4
    //   458: aload_0
    //   459: astore 8
    //   461: aload 4
    //   463: astore_0
    //   464: goto -215 -> 249
    //   467: astore 7
    //   469: aload_0
    //   470: astore 8
    //   472: aload 6
    //   474: astore_0
    //   475: goto -226 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramString	String
    //   1	119	1	i	int
    //   35	49	2	j	int
    //   100	19	3	k	int
    //   19	110	4	localObject1	Object
    //   144	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   151	311	4	localObject2	Object
    //   64	359	5	localObject3	Object
    //   54	162	6	localFileInputStream	FileInputStream
    //   370	26	6	localObject4	Object
    //   412	1	6	localObject5	Object
    //   420	53	6	localObject6	Object
    //   79	117	7	arrayOfByte	byte[]
    //   242	21	7	localException1	Exception
    //   306	21	7	localOutOfMemoryError2	OutOfMemoryError
    //   428	1	7	localOutOfMemoryError3	OutOfMemoryError
    //   442	1	7	localOutOfMemoryError4	OutOfMemoryError
    //   453	1	7	localException2	Exception
    //   467	1	7	localException3	Exception
    //   245	226	8	str	String
    // Exception table:
    //   from	to	target	type
    //   70	81	144	java/lang/OutOfMemoryError
    //   130	141	144	java/lang/OutOfMemoryError
    //   203	207	225	java/io/IOException
    //   215	220	225	java/io/IOException
    //   29	45	242	java/lang/Exception
    //   272	277	290	java/io/IOException
    //   281	285	290	java/io/IOException
    //   29	45	306	java/lang/OutOfMemoryError
    //   336	341	354	java/io/IOException
    //   345	349	354	java/io/IOException
    //   29	45	370	finally
    //   381	385	398	java/io/IOException
    //   390	395	398	java/io/IOException
    //   45	56	412	finally
    //   70	81	420	finally
    //   93	101	420	finally
    //   108	116	420	finally
    //   130	141	420	finally
    //   153	164	420	finally
    //   174	182	420	finally
    //   189	195	420	finally
    //   256	267	420	finally
    //   320	331	420	finally
    //   45	56	428	java/lang/OutOfMemoryError
    //   93	101	442	java/lang/OutOfMemoryError
    //   108	116	442	java/lang/OutOfMemoryError
    //   153	164	442	java/lang/OutOfMemoryError
    //   174	182	442	java/lang/OutOfMemoryError
    //   189	195	442	java/lang/OutOfMemoryError
    //   45	56	453	java/lang/Exception
    //   70	81	467	java/lang/Exception
    //   93	101	467	java/lang/Exception
    //   108	116	467	java/lang/Exception
    //   130	141	467	java/lang/Exception
    //   153	164	467	java/lang/Exception
    //   174	182	467	java/lang/Exception
    //   189	195	467	java/lang/Exception
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: invokevirtual 538	java/io/File:length	()J
    //   9: l2i
    //   10: istore_2
    //   11: new 947	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: iload_2
    //   16: invokespecial 948	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore 4
    //   21: new 82	java/io/BufferedInputStream
    //   24: dup
    //   25: new 78	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore 5
    //   38: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   41: sipush 12288
    //   44: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   47: astore_0
    //   48: iload_1
    //   49: iload_2
    //   50: if_icmpge +39 -> 89
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 323	java/io/InputStream:read	([B)I
    //   59: istore_3
    //   60: aload 4
    //   62: aload_0
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 949	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: iload_1
    //   69: iload_3
    //   70: iadd
    //   71: istore_1
    //   72: goto -24 -> 48
    //   75: astore_0
    //   76: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   79: sipush 4096
    //   82: invokevirtual 104	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   85: astore_0
    //   86: goto -38 -> 48
    //   89: invokestatic 100	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   92: aload_0
    //   93: invokevirtual 112	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   96: aload 4
    //   98: ldc_w 960
    //   101: invokevirtual 962	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_0
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   115: aload_0
    //   116: astore 4
    //   118: aload 5
    //   120: ifnull +11 -> 131
    //   123: aload 5
    //   125: invokevirtual 690	java/io/InputStream:close	()V
    //   128: aload_0
    //   129: astore 4
    //   131: aload 4
    //   133: areturn
    //   134: astore 5
    //   136: aload_0
    //   137: astore 4
    //   139: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq -11 -> 131
    //   145: ldc 49
    //   147: iconst_2
    //   148: ldc_w 955
    //   151: aload 5
    //   153: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   174: aload 6
    //   176: astore 4
    //   178: aload_0
    //   179: ifnull -48 -> 131
    //   182: aload_0
    //   183: invokevirtual 690	java/io/InputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aload 6
    //   191: astore 4
    //   193: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq -65 -> 131
    //   199: ldc 49
    //   201: iconst_2
    //   202: ldc_w 955
    //   205: aload_0
    //   206: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_0
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore 6
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 953	java/io/ByteArrayOutputStream:close	()V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 690	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 4
    //   242: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -7 -> 238
    //   248: ldc 49
    //   250: iconst_2
    //   251: ldc_w 955
    //   254: aload 4
    //   256: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -21 -> 238
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 5
    //   266: aload 4
    //   268: astore 6
    //   270: aload 5
    //   272: astore 4
    //   274: goto -56 -> 218
    //   277: astore_0
    //   278: aload 4
    //   280: astore 6
    //   282: aload 5
    //   284: astore 4
    //   286: goto -68 -> 218
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_0
    //   292: goto -128 -> 164
    //   295: astore_0
    //   296: aload 5
    //   298: astore_0
    //   299: goto -135 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramFile	File
    //   1	71	1	i	int
    //   10	41	2	j	int
    //   59	12	3	k	int
    //   19	215	4	localObject1	Object
    //   240	27	4	localIOException1	IOException
    //   272	13	4	localObject2	Object
    //   36	88	5	localBufferedInputStream	java.io.BufferedInputStream
    //   134	18	5	localIOException2	IOException
    //   264	33	5	localObject3	Object
    //   3	278	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   38	48	75	java/lang/OutOfMemoryError
    //   110	115	134	java/io/IOException
    //   123	128	134	java/io/IOException
    //   5	21	158	java/lang/Throwable
    //   169	174	188	java/io/IOException
    //   182	186	188	java/io/IOException
    //   5	21	211	finally
    //   223	228	240	java/io/IOException
    //   233	238	240	java/io/IOException
    //   21	38	262	finally
    //   38	48	277	finally
    //   53	68	277	finally
    //   76	86	277	finally
    //   89	105	277	finally
    //   21	38	289	java/lang/Throwable
    //   38	48	295	java/lang/Throwable
    //   53	68	295	java/lang/Throwable
    //   76	86	295	java/lang/Throwable
    //   89	105	295	java/lang/Throwable
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 202	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 242	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 33	java/io/IOException
    //   29: dup
    //   30: new 59	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 965
    //   40: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 967
    //   50: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 218	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 525	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 33	java/io/IOException
    //   70: dup
    //   71: new 59	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 965
    //   81: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 969
    //   91: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 218	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 274	java/io/FileNotFoundException
    //   104: dup
    //   105: new 59	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 965
    //   115: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 971
    //   125: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 972	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 78	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 531	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc_w 533
    //   152: invokespecial 536	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_0
    //   157: invokevirtual 538	java/io/File:length	()J
    //   160: l2i
    //   161: istore_1
    //   162: iload_1
    //   163: sipush 12288
    //   166: if_icmple +100 -> 266
    //   169: sipush 4096
    //   172: newarray char
    //   174: astore_0
    //   175: new 59	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 541	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 5
    //   187: aload_2
    //   188: aload_0
    //   189: invokevirtual 544	java/io/InputStreamReader:read	([C)I
    //   192: istore_1
    //   193: iconst_m1
    //   194: iload_1
    //   195: if_icmpeq +42 -> 237
    //   198: aload 5
    //   200: aload_0
    //   201: iconst_0
    //   202: iload_1
    //   203: invokevirtual 547	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -20 -> 187
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 142	java/io/FileInputStream:close	()V
    //   221: aload 4
    //   223: astore_3
    //   224: aload_0
    //   225: ifnull -215 -> 10
    //   228: aload_0
    //   229: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 142	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: astore_3
    //   253: aload_2
    //   254: ifnull -244 -> 10
    //   257: aload_2
    //   258: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_2
    //   264: aload_0
    //   265: areturn
    //   266: iload_1
    //   267: newarray char
    //   269: astore_0
    //   270: new 160	java/lang/String
    //   273: dup
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_2
    //   277: aload_0
    //   278: invokevirtual 544	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 554	java/lang/String:<init>	([CII)V
    //   284: astore_0
    //   285: goto -42 -> 243
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 142	java/io/FileInputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 551	java/io/InputStreamReader:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: goto -61 -> 251
    //   315: astore_2
    //   316: goto -95 -> 221
    //   319: astore_3
    //   320: goto -19 -> 301
    //   323: astore_2
    //   324: goto -15 -> 309
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -37 -> 293
    //   333: astore_0
    //   334: goto -41 -> 293
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -129 -> 213
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -135 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   161	106	1	i	int
    //   155	103	2	localInputStreamReader	java.io.InputStreamReader
    //   263	14	2	localException1	Exception
    //   292	14	2	localObject1	Object
    //   315	1	2	localException2	Exception
    //   323	1	2	localException3	Exception
    //   329	1	2	localObject2	Object
    //   9	289	3	localObject3	Object
    //   311	1	3	localException4	Exception
    //   319	1	3	localException5	Exception
    //   341	1	3	localObject4	Object
    //   1	221	4	localObject5	Object
    //   185	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	210	java/lang/Exception
    //   169	187	210	java/lang/Exception
    //   187	193	210	java/lang/Exception
    //   198	207	210	java/lang/Exception
    //   237	243	210	java/lang/Exception
    //   266	285	210	java/lang/Exception
    //   228	232	234	java/lang/Exception
    //   257	261	263	java/lang/Exception
    //   135	144	288	finally
    //   247	251	311	java/lang/Exception
    //   217	221	315	java/lang/Exception
    //   297	301	319	java/lang/Exception
    //   305	309	323	java/lang/Exception
    //   144	156	327	finally
    //   156	162	333	finally
    //   169	187	333	finally
    //   187	193	333	finally
    //   198	207	333	finally
    //   237	243	333	finally
    //   266	285	333	finally
    //   135	144	337	java/lang/Exception
    //   144	156	345	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean rq(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(acbn.SDCARD_ROOT)) && (!paramString.startsWith("/data/media/")))
      {
        bool1 = bool2;
        if (!new File(paramString).exists()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean rr(String paramString)
  {
    boolean bool = false;
    paramString = estimateFileType(paramString);
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean rs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("png"))) {
      return false;
    }
    return true;
  }
  
  @TargetApi(9)
  public static List<aqhq.a> s(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = (StorageManager)paramContext.getSystemService("storage");
      localObject1 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Object[])((Method)localObject1).invoke(paramContext, new Object[0]);
      if (localObject1 == null) {
        break label259;
      }
      i = 0;
    }
    catch (NoSuchMethodException paramContext)
    {
      Object localObject1;
      Object localObject2;
      aqhq.a locala;
      Object localObject3;
      paramContext.printStackTrace();
      localArrayList.trimToSize();
      return localArrayList;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        int i;
        paramContext.printStackTrace();
        continue;
        i += 1;
      }
    }
    if (i < localObject1.length)
    {
      localObject2 = localObject1[i];
      locala = new aqhq.a((String)localObject2.getClass().getMethod("getPath", new Class[0]).invoke(localObject2, new Object[0]));
      localObject3 = new File(locala.path);
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isDirectory()) || (!((File)localObject3).canWrite())) {
        break label289;
      }
      localObject3 = localObject2.getClass().getMethod("isRemovable", new Class[0]);
      try
      {
        locala.state = ((String)StorageManager.class.getMethod("getVolumeState", new Class[] { String.class }).invoke(paramContext, new Object[] { locala.path }));
        if (locala.isMounted())
        {
          locala.cTZ = ((Boolean)((Method)localObject3).invoke(localObject2, new Object[0])).booleanValue();
          localArrayList.add(locala);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    return writeFile(paramString1, paramString2, true);
  }
  
  public static boolean writeFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
      bool1 = bool2;
      String str;
      return false;
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          str = paramString2;
          if (paramBoolean) {}
          try
          {
            str = paramString2 + "\r\n";
            paramBoolean = bool1;
            if (paramString1 != null)
            {
              paramString1.write(str.getBytes());
              paramBoolean = bool1;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              paramBoolean = false;
            }
          }
          bool1 = paramBoolean;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool1 = paramBoolean;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            return bool1;
          }
          catch (IOException paramString1) {}
          localIOException = localIOException;
          bool1 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool1 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 90	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 202	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 202	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 199	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 94	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 260	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 144	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 324	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 326	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: aload_1
    //   124: astore_0
    //   125: goto -44 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramArrayOfByte	byte[]
    //   0	128	1	paramString	String
    //   0	128	2	paramBoolean	boolean
    //   0	128	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	122	java/io/IOException
  }
  
  /* Error */
  public static void x(String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 178	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 1075	java/io/ObjectOutputStream
    //   15: dup
    //   16: new 147	java/io/BufferedOutputStream
    //   19: dup
    //   20: invokestatic 398	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: aload_0
    //   24: iconst_0
    //   25: invokevirtual 1079	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   28: invokespecial 1082	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 1083	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload_1
    //   41: arraylength
    //   42: istore_3
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: iload_3
    //   47: if_icmpge +248 -> 295
    //   50: aload_1
    //   51: iload_2
    //   52: aaload
    //   53: astore 6
    //   55: aload 5
    //   57: astore 4
    //   59: aload 6
    //   61: instanceof 416
    //   64: ifeq +23 -> 87
    //   67: aload 5
    //   69: astore 4
    //   71: aload 5
    //   73: aload 6
    //   75: checkcast 416	java/lang/Boolean
    //   78: invokevirtual 1043	java/lang/Boolean:booleanValue	()Z
    //   81: invokevirtual 1086	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   84: goto +259 -> 343
    //   87: aload 5
    //   89: astore 4
    //   91: aload 6
    //   93: instanceof 407
    //   96: ifeq +108 -> 204
    //   99: aload 5
    //   101: astore 4
    //   103: aload 5
    //   105: aload 6
    //   107: checkcast 407	java/lang/Byte
    //   110: invokevirtual 1089	java/lang/Byte:byteValue	()B
    //   113: invokevirtual 1092	java/io/ObjectOutputStream:writeByte	(I)V
    //   116: goto +227 -> 343
    //   119: astore 4
    //   121: aload 5
    //   123: astore_1
    //   124: aload 4
    //   126: astore 5
    //   128: aload_1
    //   129: astore 4
    //   131: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +47 -> 181
    //   137: aload_1
    //   138: astore 4
    //   140: ldc_w 424
    //   143: iconst_2
    //   144: new 59	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 1094
    //   154: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 428
    //   164: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 431	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: astore 4
    //   184: aload 5
    //   186: invokevirtual 391	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: ifnull -179 -> 11
    //   193: aload_1
    //   194: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   197: return
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   203: return
    //   204: aload 5
    //   206: astore 4
    //   208: aload 6
    //   210: instanceof 344
    //   213: ifeq +36 -> 249
    //   216: aload 5
    //   218: astore 4
    //   220: aload 5
    //   222: aload 6
    //   224: checkcast 344	java/lang/Integer
    //   227: invokevirtual 1098	java/lang/Integer:intValue	()I
    //   230: invokevirtual 1101	java/io/ObjectOutputStream:writeInt	(I)V
    //   233: goto +110 -> 343
    //   236: astore_0
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   247: aload_0
    //   248: athrow
    //   249: aload 5
    //   251: astore 4
    //   253: aload 6
    //   255: instanceof 440
    //   258: ifeq +23 -> 281
    //   261: aload 5
    //   263: astore 4
    //   265: aload 5
    //   267: aload 6
    //   269: checkcast 440	java/lang/Long
    //   272: invokevirtual 1104	java/lang/Long:longValue	()J
    //   275: invokevirtual 1107	java/io/ObjectOutputStream:writeLong	(J)V
    //   278: goto +65 -> 343
    //   281: aload 5
    //   283: astore 4
    //   285: aload 5
    //   287: aload 6
    //   289: invokevirtual 1111	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   292: goto +51 -> 343
    //   295: aload 5
    //   297: astore 4
    //   299: aload 5
    //   301: invokevirtual 1112	java/io/ObjectOutputStream:flush	()V
    //   304: aload 5
    //   306: ifnull -295 -> 11
    //   309: aload 5
    //   311: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   314: return
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   320: return
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   326: goto -79 -> 247
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 4
    //   333: goto -96 -> 237
    //   336: astore 5
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -212 -> 128
    //   343: iload_2
    //   344: iconst_1
    //   345: iadd
    //   346: istore_2
    //   347: goto -302 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString	String
    //   0	350	1	paramVarArgs	Object[]
    //   44	303	2	i	int
    //   42	6	3	j	int
    //   38	64	4	localObject1	Object
    //   119	6	4	localException1	Exception
    //   129	203	4	localObject2	Object
    //   34	276	5	localObject3	Object
    //   336	1	5	localException2	Exception
    //   53	235	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	43	119	java/lang/Exception
    //   59	67	119	java/lang/Exception
    //   71	84	119	java/lang/Exception
    //   91	99	119	java/lang/Exception
    //   103	116	119	java/lang/Exception
    //   208	216	119	java/lang/Exception
    //   220	233	119	java/lang/Exception
    //   253	261	119	java/lang/Exception
    //   265	278	119	java/lang/Exception
    //   285	292	119	java/lang/Exception
    //   299	304	119	java/lang/Exception
    //   193	197	198	java/io/IOException
    //   40	43	236	finally
    //   59	67	236	finally
    //   71	84	236	finally
    //   91	99	236	finally
    //   103	116	236	finally
    //   131	137	236	finally
    //   140	181	236	finally
    //   184	189	236	finally
    //   208	216	236	finally
    //   220	233	236	finally
    //   253	261	236	finally
    //   265	278	236	finally
    //   285	292	236	finally
    //   299	304	236	finally
    //   309	314	315	java/io/IOException
    //   242	247	321	java/io/IOException
    //   12	36	329	finally
    //   12	36	336	java/lang/Exception
  }
  
  /* Error */
  public static void y(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 766	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 1075	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 147	java/io/BufferedOutputStream
    //   15: dup
    //   16: invokestatic 398	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: iconst_0
    //   21: invokevirtual 1079	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: invokespecial 1082	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 1083	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 1111	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 1112	java/io/ObjectOutputStream:flush	()V
    //   44: aload_3
    //   45: ifnull -38 -> 7
    //   48: aload_3
    //   49: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_2
    //   65: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +45 -> 113
    //   71: aload_1
    //   72: astore_2
    //   73: ldc 49
    //   75: iconst_2
    //   76: new 59	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 1116
    //   86: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 892
    //   96: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 4
    //   101: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 894	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: ifnull -107 -> 7
    //   117: aload_1
    //   118: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   127: return
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 1095	java/io/ObjectOutputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   146: goto -7 -> 139
    //   149: astore_0
    //   150: goto -19 -> 131
    //   153: astore 4
    //   155: aload_3
    //   156: astore_1
    //   157: goto -94 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString	String
    //   0	160	1	paramObject	Object
    //   32	104	2	localObject	Object
    //   30	126	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   59	41	4	localException1	Exception
    //   153	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   8	31	59	java/lang/Exception
    //   117	121	122	java/io/IOException
    //   8	31	128	finally
    //   135	139	141	java/io/IOException
    //   33	38	149	finally
    //   40	44	149	finally
    //   65	71	149	finally
    //   73	113	149	finally
    //   33	38	153	java/lang/Exception
    //   40	44	153	java/lang/Exception
  }
  
  public static String z(String paramString, long paramLong)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      if (paramString == null) {
        break label81;
      }
      String str = HexUtil.bytes2HexStr(MD5.toMD5Byte(paramString, paramLong));
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        break label58;
      }
    }
    catch (FileNotFoundException paramString)
    {
      do
      {
        paramString.printStackTrace();
        if (0 == 0) {
          break;
        }
        paramString = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong));
      } while (TextUtils.isEmpty(paramString));
      label58:
      return paramString;
    }
    finally
    {
      do
      {
        if (0 == 0) {
          break;
        }
      } while (TextUtils.isEmpty(HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong))));
    }
    return null;
    for (;;)
    {
      label81:
      paramString = null;
    }
  }
  
  public static boolean z(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString1);
    String str = paramString2;
    if (paramString2 != null) {
      str = paramString2.replaceAll("[\\\\/*?<>:\"|]", "");
    }
    paramString1 = new File(paramString1 + str);
    bool1 = true;
    if (!localFile.exists()) {
      bool1 = localFile.mkdirs();
    }
    boolean bool3 = bool1;
    if (localFile.exists())
    {
      bool2 = bool1;
      if (paramString1.exists()) {}
    }
    try
    {
      paramString1.createNewFile();
      bool2 = bool1;
      return false;
    }
    catch (IOException paramString2)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          try
          {
            paramString2 = paramString3 + "\r\n";
            bool1 = bool2;
            if (paramString1 != null)
            {
              paramString1.write(paramString2.getBytes());
              bool1 = bool2;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          catch (OutOfMemoryError paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool2 = bool1;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool2 = false;
            }
          }
          bool3 = bool2;
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            bool3 = bool2;
            return bool3;
          }
          catch (IOException paramString1) {}
          paramString2 = paramString2;
          bool2 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool2 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean zipFiles(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore 6
    //   6: new 144	java/io/FileOutputStream
    //   9: dup
    //   10: new 90	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore 7
    //   23: new 147	java/io/BufferedOutputStream
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 1082	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: new 1131	java/util/zip/ZipOutputStream
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 1132	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_1
    //   44: new 90	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 241	java/io/File:listFiles	()[Ljava/io/File;
    //   55: astore_0
    //   56: aload_0
    //   57: arraylength
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpge +221 -> 284
    //   66: aload_0
    //   67: iload_2
    //   68: aaload
    //   69: astore 9
    //   71: aload 9
    //   73: ifnull +204 -> 277
    //   76: aload 9
    //   78: invokevirtual 605	java/io/File:isFile	()Z
    //   81: ifeq +196 -> 277
    //   84: aload_1
    //   85: new 150	java/util/zip/ZipEntry
    //   88: dup
    //   89: aload 9
    //   91: invokevirtual 248	java/io/File:getName	()Ljava/lang/String;
    //   94: invokespecial 1133	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 1137	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   100: aload_1
    //   101: bipush 9
    //   103: invokevirtual 1140	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   106: new 78	java/io/FileInputStream
    //   109: dup
    //   110: aload 9
    //   112: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: astore 9
    //   117: sipush 20480
    //   120: newarray byte
    //   122: astore 10
    //   124: aload 9
    //   126: aload 10
    //   128: iconst_0
    //   129: sipush 20480
    //   132: invokevirtual 1141	java/io/FileInputStream:read	([BII)I
    //   135: istore 4
    //   137: iload 4
    //   139: iconst_m1
    //   140: if_icmpeq +115 -> 255
    //   143: aload_1
    //   144: aload 10
    //   146: iconst_0
    //   147: iload 4
    //   149: invokevirtual 1142	java/util/zip/ZipOutputStream:write	([BII)V
    //   152: goto -28 -> 124
    //   155: astore_0
    //   156: aload 9
    //   158: ifnull +8 -> 166
    //   161: aload 9
    //   163: invokevirtual 142	java/io/FileInputStream:close	()V
    //   166: aload_1
    //   167: ifnull +11 -> 178
    //   170: aload_1
    //   171: invokevirtual 1143	java/util/zip/ZipOutputStream:flush	()V
    //   174: aload_1
    //   175: invokevirtual 1146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore 10
    //   182: aload_1
    //   183: astore_0
    //   184: aload 8
    //   186: astore 9
    //   188: aload 7
    //   190: astore_1
    //   191: aload_0
    //   192: astore 8
    //   194: aload 9
    //   196: astore_0
    //   197: aload 10
    //   199: astore 7
    //   201: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +14 -> 218
    //   207: ldc 49
    //   209: iconst_2
    //   210: ldc_w 1148
    //   213: aload 7
    //   215: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload 8
    //   220: ifnull +8 -> 228
    //   223: aload 8
    //   225: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   236: iload 6
    //   238: istore 5
    //   240: aload_1
    //   241: ifnull +11 -> 252
    //   244: aload_1
    //   245: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   248: iload 6
    //   250: istore 5
    //   252: iload 5
    //   254: ireturn
    //   255: aload 9
    //   257: ifnull +8 -> 265
    //   260: aload 9
    //   262: invokevirtual 142	java/io/FileInputStream:close	()V
    //   265: aload_1
    //   266: ifnull +11 -> 277
    //   269: aload_1
    //   270: invokevirtual 1143	java/util/zip/ZipOutputStream:flush	()V
    //   273: aload_1
    //   274: invokevirtual 1146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -220 -> 61
    //   284: iconst_1
    //   285: istore 6
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   295: aload 8
    //   297: ifnull +8 -> 305
    //   300: aload 8
    //   302: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   305: iload 6
    //   307: istore 5
    //   309: aload 7
    //   311: ifnull -59 -> 252
    //   314: aload 7
    //   316: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   319: iconst_1
    //   320: ireturn
    //   321: astore_0
    //   322: iload 6
    //   324: istore 5
    //   326: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -77 -> 252
    //   332: ldc 49
    //   334: iconst_2
    //   335: ldc_w 1151
    //   338: aload_0
    //   339: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: iconst_1
    //   343: ireturn
    //   344: astore_0
    //   345: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -53 -> 295
    //   351: ldc 49
    //   353: iconst_2
    //   354: ldc_w 1151
    //   357: aload_0
    //   358: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: goto -66 -> 295
    //   364: astore_0
    //   365: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq -63 -> 305
    //   371: ldc 49
    //   373: iconst_2
    //   374: ldc_w 1151
    //   377: aload_0
    //   378: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -76 -> 305
    //   384: astore 7
    //   386: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq -161 -> 228
    //   392: ldc 49
    //   394: iconst_2
    //   395: ldc_w 1151
    //   398: aload 7
    //   400: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: goto -175 -> 228
    //   406: astore_0
    //   407: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -174 -> 236
    //   413: ldc 49
    //   415: iconst_2
    //   416: ldc_w 1151
    //   419: aload_0
    //   420: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   423: goto -187 -> 236
    //   426: astore_0
    //   427: iload 6
    //   429: istore 5
    //   431: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -182 -> 252
    //   437: ldc 49
    //   439: iconst_2
    //   440: ldc_w 1151
    //   443: aload_0
    //   444: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_0
    //   450: aconst_null
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 8
    //   455: aconst_null
    //   456: astore 7
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   466: aload 8
    //   468: ifnull +8 -> 476
    //   471: aload 8
    //   473: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   476: aload 7
    //   478: ifnull +8 -> 486
    //   481: aload 7
    //   483: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   486: aload_0
    //   487: athrow
    //   488: astore_1
    //   489: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -26 -> 466
    //   495: ldc 49
    //   497: iconst_2
    //   498: ldc_w 1151
    //   501: aload_1
    //   502: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: goto -39 -> 466
    //   508: astore_1
    //   509: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq -36 -> 476
    //   515: ldc 49
    //   517: iconst_2
    //   518: ldc_w 1151
    //   521: aload_1
    //   522: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   525: goto -49 -> 476
    //   528: astore_1
    //   529: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -46 -> 486
    //   535: ldc 49
    //   537: iconst_2
    //   538: ldc_w 1151
    //   541: aload_1
    //   542: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -59 -> 486
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: aconst_null
    //   552: astore 8
    //   554: goto -96 -> 458
    //   557: astore_0
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -102 -> 458
    //   563: astore_0
    //   564: goto -106 -> 458
    //   567: astore 10
    //   569: aload_0
    //   570: astore 7
    //   572: aload_1
    //   573: astore 9
    //   575: aload 8
    //   577: astore_1
    //   578: aload 10
    //   580: astore_0
    //   581: aload 7
    //   583: astore 8
    //   585: aload 9
    //   587: astore 7
    //   589: goto -131 -> 458
    //   592: astore 7
    //   594: aconst_null
    //   595: astore_0
    //   596: aconst_null
    //   597: astore_1
    //   598: aload 9
    //   600: astore 8
    //   602: goto -401 -> 201
    //   605: astore 8
    //   607: aconst_null
    //   608: astore_0
    //   609: aload 7
    //   611: astore_1
    //   612: aload 8
    //   614: astore 7
    //   616: aload 9
    //   618: astore 8
    //   620: goto -419 -> 201
    //   623: astore 10
    //   625: aload 8
    //   627: astore_0
    //   628: aload 7
    //   630: astore_1
    //   631: aload 10
    //   633: astore 7
    //   635: aload 9
    //   637: astore 8
    //   639: goto -438 -> 201
    //   642: astore_0
    //   643: aconst_null
    //   644: astore 9
    //   646: goto -490 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	paramString1	String
    //   0	649	1	paramString2	String
    //   60	221	2	i	int
    //   58	6	3	j	int
    //   135	13	4	k	int
    //   238	192	5	bool1	boolean
    //   4	424	6	bool2	boolean
    //   21	294	7	localObject1	Object
    //   384	15	7	localIOException	IOException
    //   456	132	7	localObject2	Object
    //   592	18	7	localException1	Exception
    //   614	20	7	localObject3	Object
    //   32	569	8	localObject4	Object
    //   605	8	8	localException2	Exception
    //   618	20	8	localObject5	Object
    //   1	644	9	localObject6	Object
    //   122	23	10	arrayOfByte	byte[]
    //   180	18	10	localException3	Exception
    //   567	12	10	localObject7	Object
    //   623	9	10	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   117	124	155	finally
    //   124	137	155	finally
    //   143	152	155	finally
    //   44	59	180	java/lang/Exception
    //   76	106	180	java/lang/Exception
    //   161	166	180	java/lang/Exception
    //   170	178	180	java/lang/Exception
    //   178	180	180	java/lang/Exception
    //   260	265	180	java/lang/Exception
    //   269	277	180	java/lang/Exception
    //   314	319	321	java/io/IOException
    //   291	295	344	java/io/IOException
    //   300	305	364	java/io/IOException
    //   223	228	384	java/io/IOException
    //   232	236	406	java/io/IOException
    //   244	248	426	java/io/IOException
    //   6	23	449	finally
    //   462	466	488	java/io/IOException
    //   471	476	508	java/io/IOException
    //   481	486	528	java/io/IOException
    //   23	34	548	finally
    //   34	44	557	finally
    //   44	59	563	finally
    //   76	106	563	finally
    //   161	166	563	finally
    //   170	178	563	finally
    //   178	180	563	finally
    //   260	265	563	finally
    //   269	277	563	finally
    //   201	218	567	finally
    //   6	23	592	java/lang/Exception
    //   23	34	605	java/lang/Exception
    //   34	44	623	java/lang/Exception
    //   106	117	642	finally
  }
  
  /* Error */
  public static boolean zipFiles(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 144	java/io/FileOutputStream
    //   6: dup
    //   7: new 90	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore 5
    //   20: new 147	java/io/BufferedOutputStream
    //   23: dup
    //   24: aload 5
    //   26: invokespecial 1082	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore 6
    //   31: new 1131	java/util/zip/ZipOutputStream
    //   34: dup
    //   35: aload 6
    //   37: invokespecial 1132	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: invokeinterface 1158 1 0
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 1163 1 0
    //   54: ifeq +251 -> 305
    //   57: new 90	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: invokeinterface 1166 1 0
    //   67: checkcast 160	java/lang/String
    //   70: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 7
    //   77: ifnull -29 -> 48
    //   80: aload 7
    //   82: invokevirtual 202	java/io/File:exists	()Z
    //   85: ifeq -37 -> 48
    //   88: aload_1
    //   89: new 150	java/util/zip/ZipEntry
    //   92: dup
    //   93: aload 7
    //   95: invokevirtual 248	java/io/File:getName	()Ljava/lang/String;
    //   98: invokespecial 1133	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 1137	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   104: aload_1
    //   105: bipush 9
    //   107: invokevirtual 1140	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   110: new 78	java/io/FileInputStream
    //   113: dup
    //   114: aload 7
    //   116: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: astore 7
    //   121: sipush 20480
    //   124: newarray byte
    //   126: astore 8
    //   128: aload 7
    //   130: aload 8
    //   132: iconst_0
    //   133: sipush 20480
    //   136: invokevirtual 1141	java/io/FileInputStream:read	([BII)I
    //   139: istore_2
    //   140: iload_2
    //   141: iconst_m1
    //   142: if_icmpeq +107 -> 249
    //   145: aload_1
    //   146: aload 8
    //   148: iconst_0
    //   149: iload_2
    //   150: invokevirtual 1142	java/util/zip/ZipOutputStream:write	([BII)V
    //   153: goto -25 -> 128
    //   156: astore_0
    //   157: aload 7
    //   159: ifnull +8 -> 167
    //   162: aload 7
    //   164: invokevirtual 142	java/io/FileInputStream:close	()V
    //   167: aload_1
    //   168: ifnull +11 -> 179
    //   171: aload_1
    //   172: invokevirtual 1143	java/util/zip/ZipOutputStream:flush	()V
    //   175: aload_1
    //   176: invokevirtual 1146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   179: aload_0
    //   180: athrow
    //   181: astore 8
    //   183: aload_1
    //   184: astore_0
    //   185: aload 6
    //   187: astore 7
    //   189: aload 5
    //   191: astore_1
    //   192: aload_0
    //   193: astore 6
    //   195: aload 7
    //   197: astore_0
    //   198: aload 8
    //   200: astore 5
    //   202: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +14 -> 219
    //   208: ldc 49
    //   210: iconst_2
    //   211: ldc_w 1148
    //   214: aload 5
    //   216: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload 6
    //   221: ifnull +8 -> 229
    //   224: aload 6
    //   226: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   237: aload_1
    //   238: ifnull +395 -> 633
    //   241: aload_1
    //   242: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   245: iconst_0
    //   246: istore_3
    //   247: iload_3
    //   248: ireturn
    //   249: aload 7
    //   251: ifnull +8 -> 259
    //   254: aload 7
    //   256: invokevirtual 142	java/io/FileInputStream:close	()V
    //   259: aload_1
    //   260: ifnull -212 -> 48
    //   263: aload_1
    //   264: invokevirtual 1143	java/util/zip/ZipOutputStream:flush	()V
    //   267: aload_1
    //   268: invokevirtual 1146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   271: goto -223 -> 48
    //   274: astore_0
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   283: aload 6
    //   285: ifnull +8 -> 293
    //   288: aload 6
    //   290: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   293: aload 5
    //   295: ifnull +8 -> 303
    //   298: aload 5
    //   300: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: iconst_1
    //   306: istore 4
    //   308: aload_1
    //   309: ifnull +7 -> 316
    //   312: aload_1
    //   313: invokevirtual 1149	java/util/zip/ZipOutputStream:close	()V
    //   316: aload 6
    //   318: ifnull +8 -> 326
    //   321: aload 6
    //   323: invokevirtual 148	java/io/BufferedOutputStream:close	()V
    //   326: iload 4
    //   328: istore_3
    //   329: aload 5
    //   331: ifnull -84 -> 247
    //   334: aload 5
    //   336: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   339: iconst_1
    //   340: ireturn
    //   341: astore_0
    //   342: iload 4
    //   344: istore_3
    //   345: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -101 -> 247
    //   351: ldc 49
    //   353: iconst_2
    //   354: ldc_w 1151
    //   357: aload_0
    //   358: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: iconst_1
    //   362: ireturn
    //   363: astore_0
    //   364: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq -51 -> 316
    //   370: ldc 49
    //   372: iconst_2
    //   373: ldc_w 1151
    //   376: aload_0
    //   377: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: goto -64 -> 316
    //   383: astore_0
    //   384: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -61 -> 326
    //   390: ldc 49
    //   392: iconst_2
    //   393: ldc_w 1151
    //   396: aload_0
    //   397: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: goto -74 -> 326
    //   403: astore 5
    //   405: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -179 -> 229
    //   411: ldc 49
    //   413: iconst_2
    //   414: ldc_w 1151
    //   417: aload 5
    //   419: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: goto -193 -> 229
    //   425: astore_0
    //   426: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -192 -> 237
    //   432: ldc 49
    //   434: iconst_2
    //   435: ldc_w 1151
    //   438: aload_0
    //   439: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -205 -> 237
    //   445: astore_0
    //   446: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc 49
    //   454: iconst_2
    //   455: ldc_w 1151
    //   458: aload_0
    //   459: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: iconst_0
    //   463: ireturn
    //   464: astore_1
    //   465: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq -185 -> 283
    //   471: ldc 49
    //   473: iconst_2
    //   474: ldc_w 1151
    //   477: aload_1
    //   478: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -198 -> 283
    //   484: astore_1
    //   485: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq -195 -> 293
    //   491: ldc 49
    //   493: iconst_2
    //   494: ldc_w 1151
    //   497: aload_1
    //   498: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: goto -208 -> 293
    //   504: astore_1
    //   505: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq -205 -> 303
    //   511: ldc 49
    //   513: iconst_2
    //   514: ldc_w 1151
    //   517: aload_1
    //   518: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: goto -218 -> 303
    //   524: astore_0
    //   525: aconst_null
    //   526: astore_1
    //   527: aconst_null
    //   528: astore 6
    //   530: aconst_null
    //   531: astore 5
    //   533: goto -258 -> 275
    //   536: astore_0
    //   537: aconst_null
    //   538: astore_1
    //   539: aconst_null
    //   540: astore 6
    //   542: goto -267 -> 275
    //   545: astore_0
    //   546: aconst_null
    //   547: astore_1
    //   548: goto -273 -> 275
    //   551: astore 8
    //   553: aload_0
    //   554: astore 5
    //   556: aload_1
    //   557: astore 7
    //   559: aload 6
    //   561: astore_1
    //   562: aload 8
    //   564: astore_0
    //   565: aload 5
    //   567: astore 6
    //   569: aload 7
    //   571: astore 5
    //   573: goto -298 -> 275
    //   576: astore 5
    //   578: aconst_null
    //   579: astore_0
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 7
    //   584: astore 6
    //   586: goto -384 -> 202
    //   589: astore 6
    //   591: aconst_null
    //   592: astore_0
    //   593: aload 5
    //   595: astore_1
    //   596: aload 6
    //   598: astore 5
    //   600: aload 7
    //   602: astore 6
    //   604: goto -402 -> 202
    //   607: astore 8
    //   609: aload 6
    //   611: astore_0
    //   612: aload 5
    //   614: astore_1
    //   615: aload 8
    //   617: astore 5
    //   619: aload 7
    //   621: astore 6
    //   623: goto -421 -> 202
    //   626: astore_0
    //   627: aconst_null
    //   628: astore 7
    //   630: goto -473 -> 157
    //   633: iconst_0
    //   634: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	paramList	List<String>
    //   0	635	1	paramString	String
    //   139	11	2	i	int
    //   246	99	3	bool1	boolean
    //   306	37	4	bool2	boolean
    //   18	317	5	localObject1	Object
    //   403	15	5	localIOException	IOException
    //   531	41	5	localObject2	Object
    //   576	18	5	localException1	Exception
    //   598	20	5	localObject3	Object
    //   29	556	6	localObject4	Object
    //   589	8	6	localException2	Exception
    //   602	20	6	localObject5	Object
    //   1	628	7	localObject6	Object
    //   126	21	8	arrayOfByte	byte[]
    //   181	18	8	localException3	Exception
    //   551	12	8	localObject7	Object
    //   607	9	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   121	128	156	finally
    //   128	140	156	finally
    //   145	153	156	finally
    //   41	48	181	java/lang/Exception
    //   48	75	181	java/lang/Exception
    //   80	110	181	java/lang/Exception
    //   162	167	181	java/lang/Exception
    //   171	179	181	java/lang/Exception
    //   179	181	181	java/lang/Exception
    //   254	259	181	java/lang/Exception
    //   263	271	181	java/lang/Exception
    //   41	48	274	finally
    //   48	75	274	finally
    //   80	110	274	finally
    //   162	167	274	finally
    //   171	179	274	finally
    //   179	181	274	finally
    //   254	259	274	finally
    //   263	271	274	finally
    //   334	339	341	java/io/IOException
    //   312	316	363	java/io/IOException
    //   321	326	383	java/io/IOException
    //   224	229	403	java/io/IOException
    //   233	237	425	java/io/IOException
    //   241	245	445	java/io/IOException
    //   279	283	464	java/io/IOException
    //   288	293	484	java/io/IOException
    //   298	303	504	java/io/IOException
    //   3	20	524	finally
    //   20	31	536	finally
    //   31	41	545	finally
    //   202	219	551	finally
    //   3	20	576	java/lang/Exception
    //   20	31	589	java/lang/Exception
    //   31	41	607	java/lang/Exception
    //   110	121	626	finally
  }
  
  public static class a
  {
    public boolean cTZ;
    public String path;
    public String state;
    
    public a(String paramString)
    {
      this.path = paramString;
    }
    
    public boolean isMounted()
    {
      return "mounted".equals(this.state);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhq
 * JD-Core Version:    0.7.0.1
 */