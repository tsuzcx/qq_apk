import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adfb
{
  public static boolean SP;
  public static volatile boolean bMx;
  private static final Object cR = new Object();
  public static volatile boolean isReleasing;
  
  public static boolean aec()
  {
    if ((!kU("fc_eval.rpdm")) || (!kU("rpn_fr_cluster_256_norelu.model")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanModelsLoader", 2, "modules is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static boolean be(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext == null) {
      return bool2;
    }
    if (bMx) {
      return bMx;
    }
    FaceCluster.getInstance();
    YTCommonInterface.initAuthForQQ(paramContext);
    if (FaceCluster.getInstance().isLoadSoSuccess()) {
      bool1 = bf(paramContext);
    }
    for (;;)
    {
      bMx = bool1;
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FaceScanModelsLoader", 2, "initModels result = " + bool1);
      return bool1;
      QLog.d("FaceScanModelsLoader", 1, "initModels loadSo failed");
    }
  }
  
  public static boolean bf(Context paramContext)
  {
    String str2 = sp();
    paramContext = str2 + File.separator + "ufdmtcc.bin";
    String str1 = str2 + File.separator + "ufat.bin";
    str2 = str2 + File.separator;
    return FaceCluster.getInstance().init(paramContext, str1, str2) == 0;
  }
  
  public static void cRb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "uninitModels start hasFaceModelInit = " + bMx);
    }
    isReleasing = true;
    if (bMx)
    {
      FaceCluster.getInstance().release();
      bMx = false;
    }
    isReleasing = false;
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "uninitModels finish");
    }
  }
  
  public static boolean d(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    int i;
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
        QLog.e("FaceScanModelsLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      i = localXmlPullParser.next();
      break label168;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("fc_eval.rpdm"))
      {
        paramHashMap.put("fc_eval.rpdm", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (!str.equalsIgnoreCase("rpn_fr_cluster_256_norelu.model")) {
          continue;
        }
        paramHashMap.put("rpn_fr_cluster_256_norelu.model", localXmlPullParser.nextText());
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FaceScanModelsLoader", 2, "parseConfig success|config=" + paramHashMap);
      return true;
      label168:
      if (i != 1) {
        switch (i)
        {
        }
      }
    }
  }
  
  /* Error */
  public static byte e(String arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 177	adfb:SP	Z
    //   4: new 86	java/io/File
    //   7: dup
    //   8: invokestatic 180	adfb:sq	()Ljava/lang/String;
    //   11: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 186	java/io/File:exists	()Z
    //   21: ifeq +40 -> 61
    //   24: aload 4
    //   26: invokestatic 192	ahbj:deleteFile	(Ljava/io/File;)Z
    //   29: istore_3
    //   30: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +28 -> 61
    //   36: ldc 35
    //   38: iconst_2
    //   39: new 65	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   46: ldc 194
    //   48: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 75	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 84	adfb:sp	()Ljava/lang/String;
    //   65: invokestatic 198	adfb:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 119	java/util/HashMap
    //   71: dup
    //   72: invokespecial 199	java/util/HashMap:<init>	()V
    //   75: astore 6
    //   77: getstatic 205	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   80: ldc 207
    //   82: iconst_0
    //   83: invokevirtual 211	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: invokeinterface 217 1 0
    //   91: astore 5
    //   93: new 86	java/io/File
    //   96: dup
    //   97: new 65	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   104: invokestatic 84	adfb:sp	()Ljava/lang/String;
    //   107: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 219
    //   112: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 186	java/io/File:exists	()Z
    //   128: ifeq +318 -> 446
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 4
    //   135: invokestatic 225	aqhq:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +278 -> 422
    //   147: aload_0
    //   148: aload 6
    //   150: invokestatic 227	adfb:d	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   153: ifeq +269 -> 422
    //   156: getstatic 17	adfb:cR	Ljava/lang/Object;
    //   159: astore_0
    //   160: aload_0
    //   161: monitorenter
    //   162: aload 6
    //   164: invokevirtual 231	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   167: invokeinterface 237 1 0
    //   172: astore 4
    //   174: aload 4
    //   176: invokeinterface 242 1 0
    //   181: ifeq +285 -> 466
    //   184: aload 4
    //   186: invokeinterface 245 1 0
    //   191: checkcast 247	java/util/Map$Entry
    //   194: astore 6
    //   196: new 65	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   203: invokestatic 84	adfb:sp	()Ljava/lang/String;
    //   206: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: getstatic 90	java/io/File:separator	Ljava/lang/String;
    //   212: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokeinterface 250 1 0
    //   222: checkcast 126	java/lang/String
    //   225: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 8
    //   233: new 86	java/io/File
    //   236: dup
    //   237: aload 8
    //   239: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 186	java/io/File:exists	()Z
    //   249: ifeq +168 -> 417
    //   252: aload 8
    //   254: invokestatic 256	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 8
    //   259: aload 6
    //   261: invokeinterface 259 1 0
    //   266: checkcast 126	java/lang/String
    //   269: aload 8
    //   271: invokevirtual 154	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   274: ifne +86 -> 360
    //   277: aload 7
    //   279: invokevirtual 262	java/io/File:delete	()Z
    //   282: pop
    //   283: iconst_2
    //   284: istore_1
    //   285: aload 5
    //   287: invokeinterface 267 1 0
    //   292: pop
    //   293: aload_0
    //   294: monitorexit
    //   295: iconst_0
    //   296: putstatic 177	adfb:SP	Z
    //   299: iload_1
    //   300: ireturn
    //   301: astore_0
    //   302: iconst_0
    //   303: putstatic 177	adfb:SP	Z
    //   306: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +32 -> 341
    //   312: ldc 35
    //   314: iconst_2
    //   315: new 65	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 269
    //   325: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: invokevirtual 272	java/io/IOException:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: invokestatic 84	adfb:sp	()Ljava/lang/String;
    //   344: iconst_0
    //   345: invokestatic 275	aqhq:delete	(Ljava/lang/String;Z)V
    //   348: iconst_m1
    //   349: ireturn
    //   350: astore 4
    //   352: aload 4
    //   354: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   357: goto -214 -> 143
    //   360: aload 5
    //   362: new 65	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 280
    //   372: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 6
    //   377: invokeinterface 250 1 0
    //   382: checkcast 126	java/lang/String
    //   385: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: aload 6
    //   393: invokeinterface 259 1 0
    //   398: checkcast 126	java/lang/String
    //   401: invokeinterface 284 3 0
    //   406: pop
    //   407: goto -233 -> 174
    //   410: astore 4
    //   412: aload_0
    //   413: monitorexit
    //   414: aload 4
    //   416: athrow
    //   417: iconst_3
    //   418: istore_1
    //   419: goto -134 -> 285
    //   422: iconst_4
    //   423: istore_2
    //   424: iload_2
    //   425: istore_1
    //   426: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -134 -> 295
    //   432: ldc 35
    //   434: iconst_2
    //   435: ldc_w 286
    //   438: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: iload_2
    //   442: istore_1
    //   443: goto -148 -> 295
    //   446: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +12 -> 461
    //   452: ldc 35
    //   454: iconst_2
    //   455: ldc_w 288
    //   458: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: iconst_0
    //   462: istore_1
    //   463: goto -168 -> 295
    //   466: iconst_0
    //   467: istore_1
    //   468: goto -183 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   284	184	1	b1	byte
    //   423	19	2	b2	byte
    //   29	23	3	bool	boolean
    //   14	171	4	localObject1	Object
    //   350	3	4	localIOException	java.io.IOException
    //   410	5	4	localObject2	Object
    //   91	270	5	localEditor	android.content.SharedPreferences.Editor
    //   75	317	6	localObject3	Object
    //   242	36	7	localFile	File
    //   231	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   61	68	301	java/io/IOException
    //   133	140	350	java/io/IOException
    //   162	174	410	finally
    //   174	283	410	finally
    //   285	295	410	finally
    //   360	407	410	finally
    //   412	414	410	finally
  }
  
  /* Error */
  public static void fn(String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 35
    //   10: iconst_2
    //   11: new 65	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 290
    //   21: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 292	com/tencent/commonsdk/zip/QZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 293	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 297	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   49: astore 7
    //   51: sipush 8192
    //   54: newarray byte
    //   56: astore 6
    //   58: aload 7
    //   60: invokeinterface 302 1 0
    //   65: ifeq +333 -> 398
    //   68: aload 7
    //   70: invokeinterface 305 1 0
    //   75: checkcast 307	java/util/zip/ZipEntry
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 308	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +413 -> 500
    //   90: aload_0
    //   91: ldc_w 310
    //   94: invokevirtual 314	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +6 -> 103
    //   100: goto -42 -> 58
    //   103: new 65	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   110: aload_1
    //   111: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 90	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload 5
    //   130: invokevirtual 317	java/util/zip/ZipEntry:isDirectory	()Z
    //   133: ifeq +27 -> 160
    //   136: new 86	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 186	java/io/File:exists	()Z
    //   149: ifne +354 -> 503
    //   152: aload_0
    //   153: invokevirtual 320	java/io/File:mkdir	()Z
    //   156: pop
    //   157: goto +346 -> 503
    //   160: aload_0
    //   161: getstatic 90	java/io/File:separator	Ljava/lang/String;
    //   164: invokevirtual 324	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   167: istore_2
    //   168: aload_0
    //   169: iconst_0
    //   170: iload_2
    //   171: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: astore 8
    //   176: aload_0
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: invokevirtual 331	java/lang/String:substring	(I)Ljava/lang/String;
    //   183: ldc_w 333
    //   186: invokevirtual 336	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   189: ifeq +6 -> 195
    //   192: goto -134 -> 58
    //   195: new 86	java/io/File
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore 8
    //   206: aload 8
    //   208: invokevirtual 186	java/io/File:exists	()Z
    //   211: ifne +9 -> 220
    //   214: aload 8
    //   216: invokevirtual 320	java/io/File:mkdir	()Z
    //   219: pop
    //   220: new 86	java/io/File
    //   223: dup
    //   224: new 65	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   231: aload_0
    //   232: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 338
    //   238: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore 8
    //   249: new 86	java/io/File
    //   252: dup
    //   253: aload_0
    //   254: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore 9
    //   259: aload 8
    //   261: invokevirtual 186	java/io/File:exists	()Z
    //   264: ifeq +9 -> 273
    //   267: aload 8
    //   269: invokevirtual 262	java/io/File:delete	()Z
    //   272: pop
    //   273: new 340	java/io/FileOutputStream
    //   276: dup
    //   277: aload 8
    //   279: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore_0
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 347	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   290: astore 5
    //   292: aload 5
    //   294: aload 6
    //   296: iconst_0
    //   297: aload 6
    //   299: arraylength
    //   300: invokevirtual 353	java/io/InputStream:read	([BII)I
    //   303: istore_2
    //   304: iload_2
    //   305: iconst_m1
    //   306: if_icmpeq +52 -> 358
    //   309: aload_0
    //   310: aload 6
    //   312: iconst_0
    //   313: iload_2
    //   314: invokevirtual 357	java/io/FileOutputStream:write	([BII)V
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
    //   335: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 361	java/io/InputStream:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 362	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   356: aload_0
    //   357: athrow
    //   358: aload_0
    //   359: invokevirtual 365	java/io/FileOutputStream:flush	()V
    //   362: aload_0
    //   363: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   366: aload 5
    //   368: invokevirtual 361	java/io/InputStream:close	()V
    //   371: aload 8
    //   373: aload 9
    //   375: invokestatic 369	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   378: ifne +125 -> 503
    //   381: aload 8
    //   383: aload 9
    //   385: invokestatic 372	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   388: pop
    //   389: goto +114 -> 503
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -65 -> 330
    //   398: iconst_0
    //   399: ifeq +11 -> 410
    //   402: new 374	java/lang/NullPointerException
    //   405: dup
    //   406: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   409: athrow
    //   410: iconst_0
    //   411: ifeq +11 -> 422
    //   414: new 374	java/lang/NullPointerException
    //   417: dup
    //   418: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   421: athrow
    //   422: aload 4
    //   424: ifnull +8 -> 432
    //   427: aload 4
    //   429: invokevirtual 362	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   432: return
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   438: goto -28 -> 410
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   446: goto -24 -> 422
    //   449: astore_0
    //   450: aload_0
    //   451: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   454: return
    //   455: astore_3
    //   456: aload_3
    //   457: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   460: goto -122 -> 338
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   468: goto -122 -> 346
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 278	java/io/IOException:printStackTrace	()V
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
  
  public static boolean kU(String paramString)
  {
    boolean bool2 = false;
    String str1 = sp() + File.separator + paramString;
    ??? = new File(str1);
    if ((!SP) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (cR)
        {
          String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("face_models_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(alab.getFileMD5String(str1)))
            {
              break label174;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FaceScanModelsLoader", 2, "isModelFileExist: modelName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label174:
        boolean bool1 = true;
      }
    }
    return false;
  }
  
  public static String sp()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanModelsLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_models";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanModelsLoader", 2, "getFaceModelsPath ,path = " + str);
    return str;
  }
  
  public static String sq()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_models";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfb
 * JD-Core Version:    0.7.0.1
 */