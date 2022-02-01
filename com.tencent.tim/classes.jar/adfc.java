import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adfc
{
  public static boolean SP;
  private static final Object cS = new Object();
  
  public static boolean aed()
  {
    if ((!ahbj.isFileExists(su())) || (!ahbj.isFileExists(st())) || (!kQ("YTFaceCluster")) || (!kQ("YTFaceExtFeature")) || (!ahbj.isFileExists(sv())) || (!kQ("YTFaceClusterJNI_V836")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady native so is not exist!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady true");
    }
    return true;
  }
  
  public static boolean c(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label195;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("YTFaceCluster"))
      {
        paramHashMap.put("YTFaceCluster", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("YTFaceExtFeature"))
        {
          paramHashMap.put("YTFaceExtFeature", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("YTFaceClusterJNI_V836")) {
          continue;
        }
        paramHashMap.put("YTFaceClusterJNI_V836", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FaceScanNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label195:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  /* Error */
  public static byte e(String arg0)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_2
    //   2: iconst_1
    //   3: putstatic 138	adfc:SP	Z
    //   6: new 140	java/io/File
    //   9: dup
    //   10: invokestatic 143	adfc:ss	()Ljava/lang/String;
    //   13: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 149	java/io/File:exists	()Z
    //   23: ifeq +40 -> 63
    //   26: aload 4
    //   28: invokestatic 153	ahbj:deleteFile	(Ljava/io/File;)Z
    //   31: istore_3
    //   32: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 50
    //   40: iconst_2
    //   41: new 118	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   48: ldc 155
    //   50: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_3
    //   54: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: invokestatic 161	adfc:sr	()Ljava/lang/String;
    //   67: invokestatic 165	adfc:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 70	java/util/HashMap
    //   73: dup
    //   74: invokespecial 166	java/util/HashMap:<init>	()V
    //   77: astore 6
    //   79: getstatic 172	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   82: ldc 174
    //   84: iconst_4
    //   85: invokevirtual 178	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   88: invokeinterface 184 1 0
    //   93: astore 5
    //   95: new 140	java/io/File
    //   98: dup
    //   99: new 118	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   106: invokestatic 161	adfc:sr	()Ljava/lang/String;
    //   109: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 186
    //   114: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 149	java/io/File:exists	()Z
    //   130: ifeq +378 -> 508
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 4
    //   137: invokestatic 192	aqhq:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore 4
    //   142: aload 4
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +340 -> 486
    //   149: aload_0
    //   150: aload 6
    //   152: invokestatic 194	adfc:c	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   155: ifeq +331 -> 486
    //   158: getstatic 15	adfc:cS	Ljava/lang/Object;
    //   161: astore_0
    //   162: aload_0
    //   163: monitorenter
    //   164: aload 6
    //   166: invokevirtual 198	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   169: invokeinterface 204 1 0
    //   174: astore 4
    //   176: aload 4
    //   178: invokeinterface 209 1 0
    //   183: ifeq +345 -> 528
    //   186: aload 4
    //   188: invokeinterface 212 1 0
    //   193: checkcast 214	java/util/Map$Entry
    //   196: astore 6
    //   198: new 118	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   205: invokestatic 161	adfc:sr	()Ljava/lang/String;
    //   208: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 216
    //   213: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 6
    //   218: invokeinterface 219 1 0
    //   223: checkcast 77	java/lang/String
    //   226: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 221
    //   231: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore 8
    //   239: new 140	java/io/File
    //   242: dup
    //   243: aload 8
    //   245: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore 7
    //   250: aload 7
    //   252: invokevirtual 149	java/io/File:exists	()Z
    //   255: ifeq +226 -> 481
    //   258: aload 8
    //   260: invokestatic 227	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 8
    //   265: aload 6
    //   267: invokeinterface 230 1 0
    //   272: checkcast 77	java/lang/String
    //   275: aload 8
    //   277: invokevirtual 105	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   280: ifne +85 -> 365
    //   283: aload 7
    //   285: invokevirtual 233	java/io/File:delete	()Z
    //   288: pop
    //   289: iconst_2
    //   290: istore_1
    //   291: aload 5
    //   293: invokeinterface 238 1 0
    //   298: pop
    //   299: aload_0
    //   300: monitorexit
    //   301: iconst_0
    //   302: putstatic 138	adfc:SP	Z
    //   305: iload_1
    //   306: ireturn
    //   307: astore_0
    //   308: iconst_0
    //   309: putstatic 138	adfc:SP	Z
    //   312: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +31 -> 346
    //   318: ldc 50
    //   320: iconst_2
    //   321: new 118	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   328: ldc 240
    //   330: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 243	java/io/IOException:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: invokestatic 161	adfc:sr	()Ljava/lang/String;
    //   349: iconst_0
    //   350: invokestatic 246	aqhq:delete	(Ljava/lang/String;Z)V
    //   353: iconst_m1
    //   354: ireturn
    //   355: astore 4
    //   357: aload 4
    //   359: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   362: goto -217 -> 145
    //   365: aload 5
    //   367: new 118	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   374: ldc 251
    //   376: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 6
    //   381: invokeinterface 219 1 0
    //   386: checkcast 77	java/lang/String
    //   389: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: aload 6
    //   397: invokeinterface 230 1 0
    //   402: checkcast 77	java/lang/String
    //   405: invokeinterface 255 3 0
    //   410: pop
    //   411: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -238 -> 176
    //   417: ldc 50
    //   419: iconst_2
    //   420: new 118	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 257
    //   430: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 6
    //   435: invokeinterface 219 1 0
    //   440: checkcast 77	java/lang/String
    //   443: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc_w 259
    //   449: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 6
    //   454: invokeinterface 230 1 0
    //   459: checkcast 77	java/lang/String
    //   462: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: goto -295 -> 176
    //   474: astore 4
    //   476: aload_0
    //   477: monitorexit
    //   478: aload 4
    //   480: athrow
    //   481: iconst_3
    //   482: istore_1
    //   483: goto -192 -> 291
    //   486: iload_2
    //   487: istore_1
    //   488: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq -190 -> 301
    //   494: ldc 50
    //   496: iconst_2
    //   497: ldc_w 261
    //   500: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: iload_2
    //   504: istore_1
    //   505: goto -204 -> 301
    //   508: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +12 -> 523
    //   514: ldc 50
    //   516: iconst_2
    //   517: ldc_w 263
    //   520: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: iconst_0
    //   524: istore_1
    //   525: goto -224 -> 301
    //   528: iconst_0
    //   529: istore_1
    //   530: goto -239 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   290	240	1	b1	byte
    //   1	503	2	b2	byte
    //   31	23	3	bool	boolean
    //   16	171	4	localObject1	Object
    //   355	3	4	localIOException	java.io.IOException
    //   474	5	4	localObject2	Object
    //   93	273	5	localEditor	android.content.SharedPreferences.Editor
    //   77	376	6	localObject3	Object
    //   248	36	7	localFile	File
    //   237	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   63	70	307	java/io/IOException
    //   135	142	355	java/io/IOException
    //   164	176	474	finally
    //   176	289	474	finally
    //   291	301	474	finally
    //   365	471	474	finally
    //   476	478	474	finally
  }
  
  public static byte f(String paramString)
  {
    byte b1 = 0;
    try
    {
      System.load(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "loadSoByPath ret = " + b1 + ",soPath = " + paramString);
      }
      return b1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        byte b2 = -2;
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", localUnsatisfiedLinkError);
          b1 = b2;
        }
      }
    }
  }
  
  /* Error */
  public static void fn(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 50
    //   10: iconst_2
    //   11: new 118	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 282
    //   21: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 284	com/tencent/commonsdk/zip/QZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 285	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 289	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   49: astore 7
    //   51: sipush 8192
    //   54: newarray byte
    //   56: astore 6
    //   58: aload 7
    //   60: invokeinterface 294 1 0
    //   65: ifeq +333 -> 398
    //   68: aload 7
    //   70: invokeinterface 297 1 0
    //   75: checkcast 299	java/util/zip/ZipEntry
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 300	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +413 -> 500
    //   90: aload_0
    //   91: ldc_w 302
    //   94: invokevirtual 306	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +6 -> 103
    //   100: goto -42 -> 58
    //   103: new 118	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   110: aload_1
    //   111: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 310	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload 5
    //   130: invokevirtual 313	java/util/zip/ZipEntry:isDirectory	()Z
    //   133: ifeq +27 -> 160
    //   136: new 140	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 149	java/io/File:exists	()Z
    //   149: ifne +354 -> 503
    //   152: aload_0
    //   153: invokevirtual 316	java/io/File:mkdir	()Z
    //   156: pop
    //   157: goto +346 -> 503
    //   160: aload_0
    //   161: getstatic 310	java/io/File:separator	Ljava/lang/String;
    //   164: invokevirtual 320	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   167: istore_2
    //   168: aload_0
    //   169: iconst_0
    //   170: iload_2
    //   171: invokevirtual 324	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: astore 8
    //   176: aload_0
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: invokevirtual 327	java/lang/String:substring	(I)Ljava/lang/String;
    //   183: ldc_w 329
    //   186: invokevirtual 332	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   189: ifeq +6 -> 195
    //   192: goto -134 -> 58
    //   195: new 140	java/io/File
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore 8
    //   206: aload 8
    //   208: invokevirtual 149	java/io/File:exists	()Z
    //   211: ifne +9 -> 220
    //   214: aload 8
    //   216: invokevirtual 316	java/io/File:mkdir	()Z
    //   219: pop
    //   220: new 140	java/io/File
    //   223: dup
    //   224: new 118	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   231: aload_0
    //   232: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 334
    //   238: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore 8
    //   249: new 140	java/io/File
    //   252: dup
    //   253: aload_0
    //   254: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore 9
    //   259: aload 8
    //   261: invokevirtual 149	java/io/File:exists	()Z
    //   264: ifeq +9 -> 273
    //   267: aload 8
    //   269: invokevirtual 233	java/io/File:delete	()Z
    //   272: pop
    //   273: new 336	java/io/FileOutputStream
    //   276: dup
    //   277: aload 8
    //   279: invokespecial 339	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore_0
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 343	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   290: astore 5
    //   292: aload 5
    //   294: aload 6
    //   296: iconst_0
    //   297: aload 6
    //   299: arraylength
    //   300: invokevirtual 349	java/io/InputStream:read	([BII)I
    //   303: istore_2
    //   304: iload_2
    //   305: iconst_m1
    //   306: if_icmpeq +52 -> 358
    //   309: aload_0
    //   310: aload 6
    //   312: iconst_0
    //   313: iload_2
    //   314: invokevirtual 353	java/io/FileOutputStream:write	([BII)V
    //   317: goto -25 -> 292
    //   320: astore 6
    //   322: aload 5
    //   324: astore_1
    //   325: aload_0
    //   326: astore_3
    //   327: aload 6
    //   329: astore_0
    //   330: aload_3
    //   331: ifnull +7 -> 338
    //   334: aload_3
    //   335: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 357	java/io/InputStream:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 358	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   356: aload_0
    //   357: athrow
    //   358: aload_0
    //   359: invokevirtual 361	java/io/FileOutputStream:flush	()V
    //   362: aload_0
    //   363: invokevirtual 356	java/io/FileOutputStream:close	()V
    //   366: aload 5
    //   368: invokevirtual 357	java/io/InputStream:close	()V
    //   371: aload 8
    //   373: aload 9
    //   375: invokestatic 365	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   378: ifne +125 -> 503
    //   381: aload 8
    //   383: aload 9
    //   385: invokestatic 368	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   388: pop
    //   389: goto +114 -> 503
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -65 -> 330
    //   398: iconst_0
    //   399: ifeq +11 -> 410
    //   402: new 370	java/lang/NullPointerException
    //   405: dup
    //   406: invokespecial 371	java/lang/NullPointerException:<init>	()V
    //   409: athrow
    //   410: iconst_0
    //   411: ifeq +11 -> 422
    //   414: new 370	java/lang/NullPointerException
    //   417: dup
    //   418: invokespecial 371	java/lang/NullPointerException:<init>	()V
    //   421: athrow
    //   422: aload 4
    //   424: ifnull +8 -> 432
    //   427: aload 4
    //   429: invokevirtual 358	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   432: return
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   438: goto -28 -> 410
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   446: goto -24 -> 422
    //   449: astore_0
    //   450: aload_0
    //   451: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   454: return
    //   455: astore_3
    //   456: aload_3
    //   457: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   460: goto -122 -> 338
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   468: goto -122 -> 346
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   476: goto -120 -> 356
    //   479: astore_0
    //   480: aconst_null
    //   481: astore 4
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -155 -> 330
    //   488: astore 5
    //   490: aconst_null
    //   491: astore_1
    //   492: aload_0
    //   493: astore_3
    //   494: aload 5
    //   496: astore_0
    //   497: goto -167 -> 330
    //   500: goto -442 -> 58
    //   503: goto -445 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramString1	String
    //   0	506	1	paramString2	String
    //   167	147	2	i	int
    //   1	334	3	str1	String
    //   455	2	3	localIOException	java.io.IOException
    //   493	1	3	str2	String
    //   42	440	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   78	289	5	localObject1	Object
    //   488	7	5	localObject2	Object
    //   56	255	6	arrayOfByte	byte[]
    //   320	8	6	localObject3	Object
    //   49	20	7	localEnumeration	java.util.Enumeration
    //   174	208	8	localObject4	Object
    //   257	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   292	304	320	finally
    //   309	317	320	finally
    //   358	371	320	finally
    //   44	58	392	finally
    //   58	86	392	finally
    //   90	100	392	finally
    //   103	157	392	finally
    //   160	192	392	finally
    //   195	220	392	finally
    //   220	273	392	finally
    //   273	283	392	finally
    //   371	389	392	finally
    //   402	410	433	java/io/IOException
    //   414	422	441	java/io/IOException
    //   427	432	449	java/io/IOException
    //   334	338	455	java/io/IOException
    //   342	346	463	java/io/IOException
    //   351	356	471	java/io/IOException
    //   34	44	479	finally
    //   283	292	488	finally
  }
  
  public static byte g(String paramString)
  {
    byte b3 = 0;
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = sr() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "loadFaceNativeSo start faceNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!SP) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("FaceScanNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo load from face dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
        b1 = -2;
        continue;
      }
      adic.ef(paramString, b1);
      return b1;
      byte b1 = b3;
      if (SP)
      {
        b1 = b3;
        if (!localFile.exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (SP)
      {
        b2 = b1;
        if (localFile.exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!SP)
      {
        b1 = b2;
        if (!localFile.exists()) {
          b1 = -5;
        }
      }
      QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo no face so in face dir,libName = " + paramString);
    }
  }
  
  public static String jM(String paramString)
  {
    new StringBuilder().append(sr()).append("/lib").append(paramString).append(".so").toString();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "getFaceSoMd5 ,soName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  public static boolean kQ(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = sr() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    boolean bool1 = bool3;
    if (!SP)
    {
      bool1 = bool3;
      if (!((File)???).exists()) {}
    }
    for (;;)
    {
      synchronized (cS)
      {
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
        str1 = alab.getFileMD5String(str1);
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label298;
            if (QLog.isColorLevel()) {
              QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + SP);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
          }
        }
      }
      label298:
      bool1 = true;
    }
  }
  
  public static String sr()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_so_v795";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanNativeSoLoader", 2, "getFaceLibPath ,path = " + str);
    return str;
  }
  
  public static String ss()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_scan";
  }
  
  public static String st()
  {
    return axce.a(axcd.c) + "libYTCommon.so";
  }
  
  public static String su()
  {
    return axce.a(axcd.c) + "libopencv_world.so";
  }
  
  public static String sv()
  {
    return axce.a(axcd.c) + "libYTFaceTrackPro.so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfc
 * JD-Core Version:    0.7.0.1
 */