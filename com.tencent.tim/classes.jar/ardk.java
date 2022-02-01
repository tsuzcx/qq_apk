import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ardk
{
  public static final String cAb = aqul.getSDKPrivatePath(CO() + "tencent/MobileQQ/webso/offline/");
  public static String cAc;
  public static final String cAd = BaseApplicationImpl.getContext().getFilesDir() + "/webso/offline/";
  
  private static String CM()
  {
    if (aqhq.aCJ()) {
      if (!TextUtils.isEmpty(cAc)) {}
    }
    for (;;)
    {
      try
      {
        cAc = cAb;
        Object localObject = cAc;
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        String str2 = ((File)localObject).getAbsolutePath();
        localObject = str2;
        if (!str2.endsWith(File.separator)) {
          localObject = str2 + File.separator;
        }
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("WebSoUtils", 1, "error getting sdcard root path " + localException);
        continue;
      }
      String str1 = cAd;
    }
  }
  
  public static String CN()
  {
    Object localObject = "Android Qzone/" + avpq.getQUA3();
    String str;
    switch (jqc.getNetWorkType())
    {
    case 0: 
    default: 
      str = "";
    }
    for (;;)
    {
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append(" ").append("QQ/").append("3.4.4").append(".").append("3058").append(str).append(" Pixel/").append(rV()).append(" StatusBarHeight/" + i);
      return ((StringBuilder)localObject).toString();
      str = " NetType/UNKNOWN";
      continue;
      str = " NetType/WIFI";
      continue;
      str = " NetType/2G";
      continue;
      str = " NetType/3G";
      continue;
      str = " NetType/4G";
    }
  }
  
  private static String CO()
  {
    try
    {
      String str = acbn.SDCARD_PATH;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void Wo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSo", 1, paramString);
    }
  }
  
  public static String addTagInfo(String paramString1, String paramString2, String paramString3)
  {
    Wo("addTag");
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localStringBuilder.append("<script> var _WebSoLocalTime=" + paramString2 + ";</script>");
      localStringBuilder.append("<script> var _WebSoNetTime=" + paramString3 + ";</script>");
      QLog.i("WebSoService", 1, "add _WebSoLocalTime=" + paramString2 + ", add _WebSoNetTime=" + paramString3);
      return localStringBuilder.toString();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return "";
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  private static boolean b(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_proxyByURL");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  public static String cc(String paramString1, String paramString2)
  {
    String str = String.valueOf(System.currentTimeMillis());
    WebSoService.a().iC(paramString1, str);
    return addTagInfo(paramString2, str, null);
  }
  
  public static String ce(String paramString1, String paramString2)
  {
    paramString2 = addTagInfo(paramString2, WebSoService.a().qf(paramString1), String.valueOf(System.currentTimeMillis()));
    WebSoService.a().Wm(paramString1);
    return paramString2;
  }
  
  public static void ehx()
  {
    try
    {
      aqhq.cm(CM());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebSoUtils", 1, localException, new Object[0]);
    }
  }
  
  public static String g(Uri paramUri)
  {
    try
    {
      if (b(paramUri)) {}
      for (String str = paramUri.toString();; str = paramUri.getAuthority() + paramUri.getPath()) {
        return arwv.toMD5(str);
      }
      return paramUri.toString();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getUrlKey..uri", localThrowable);
      }
    }
  }
  
  public static String getHtmlData(String paramString)
  {
    Wo("getHtmlData");
    try
    {
      paramString = new File(h(Uri.parse(paramString)));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
        }
        paramString = null;
      }
      try
      {
        paramString = aqhq.readFileToString(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static String h(Uri paramUri)
  {
    paramUri = j(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + ".txt";
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramUri == null) {
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      try
      {
        String str = paramUri.getQueryParameter("_proxy");
        bool1 = bool2;
        if (str != null) {
          if (!"1".equals(str))
          {
            bool1 = bool2;
            if (!"true".equals(str)) {}
          }
          else
          {
            boolean bool3 = TextUtils.isEmpty(qj(paramUri.toString()));
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (bool1) {
          return bool1;
        }
      }
      catch (Exception paramUri) {}
    }
    return false;
  }
  
  public static String i(Uri paramUri)
  {
    paramUri = j(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + "_template.txt";
  }
  
  /* Error */
  public static boolean i(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 7
    //   18: ldc_w 314
    //   21: invokestatic 187	ardk:Wo	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: ifnull +10 -> 35
    //   28: aload_1
    //   29: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +7 -> 39
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: ireturn
    //   39: new 75	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 81	java/io/File:exists	()Z
    //   54: ifeq +9 -> 63
    //   57: aload 6
    //   59: invokevirtual 317	java/io/File:delete	()Z
    //   62: pop
    //   63: aload 6
    //   65: invokevirtual 320	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: new 322	java/io/ByteArrayInputStream
    //   72: dup
    //   73: aload_0
    //   74: iconst_0
    //   75: aload_0
    //   76: arraylength
    //   77: invokespecial 325	java/io/ByteArrayInputStream:<init>	([BII)V
    //   80: astore_1
    //   81: new 327	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 329	java/io/FileOutputStream
    //   88: dup
    //   89: aload 6
    //   91: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: sipush 4096
    //   97: invokespecial 335	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   100: astore 6
    //   102: aload 10
    //   104: astore_0
    //   105: aload 6
    //   107: astore 5
    //   109: aload_1
    //   110: astore 4
    //   112: aload 9
    //   114: astore 8
    //   116: invokestatic 341	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   119: sipush 4096
    //   122: invokevirtual 345	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   125: astore 9
    //   127: aload 9
    //   129: astore 7
    //   131: aload 9
    //   133: astore_0
    //   134: aload 6
    //   136: astore 5
    //   138: aload_1
    //   139: astore 4
    //   141: aload 9
    //   143: astore 8
    //   145: aload_1
    //   146: aload 9
    //   148: invokevirtual 351	java/io/InputStream:read	([B)I
    //   151: istore_2
    //   152: iload_2
    //   153: iconst_m1
    //   154: if_icmpeq +84 -> 238
    //   157: aload 9
    //   159: astore 7
    //   161: aload 9
    //   163: astore_0
    //   164: aload 6
    //   166: astore 5
    //   168: aload_1
    //   169: astore 4
    //   171: aload 9
    //   173: astore 8
    //   175: aload 6
    //   177: aload 9
    //   179: iconst_0
    //   180: iload_2
    //   181: invokevirtual 356	java/io/OutputStream:write	([BII)V
    //   184: goto -57 -> 127
    //   187: astore_0
    //   188: aload 7
    //   190: astore 8
    //   192: aload_0
    //   193: astore 7
    //   195: aload 8
    //   197: astore_0
    //   198: aload 6
    //   200: astore 5
    //   202: aload_1
    //   203: astore 4
    //   205: aload 7
    //   207: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   210: invokestatic 341	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   213: aload 8
    //   215: invokevirtual 361	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 364	java/io/InputStream:close	()V
    //   226: aload 6
    //   228: ifnull +8 -> 236
    //   231: aload 6
    //   233: invokevirtual 365	java/io/OutputStream:close	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: aload 9
    //   240: astore 7
    //   242: aload 9
    //   244: astore_0
    //   245: aload 6
    //   247: astore 5
    //   249: aload_1
    //   250: astore 4
    //   252: aload 9
    //   254: astore 8
    //   256: aload 6
    //   258: invokevirtual 368	java/io/OutputStream:flush	()V
    //   261: iconst_1
    //   262: istore_3
    //   263: invokestatic 341	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   266: aload 9
    //   268: invokevirtual 361	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 364	java/io/InputStream:close	()V
    //   279: aload 6
    //   281: ifnull -244 -> 37
    //   284: aload 6
    //   286: invokevirtual 365	java/io/OutputStream:close	()V
    //   289: iconst_1
    //   290: ireturn
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   296: iconst_0
    //   297: ireturn
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore 7
    //   307: aconst_null
    //   308: astore 6
    //   310: aconst_null
    //   311: astore_1
    //   312: aload 8
    //   314: astore_0
    //   315: aload 6
    //   317: astore 5
    //   319: aload_1
    //   320: astore 4
    //   322: aload 7
    //   324: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   327: invokestatic 341	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   330: aload 8
    //   332: invokevirtual 361	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 364	java/io/InputStream:close	()V
    //   343: aload 6
    //   345: ifnull +8 -> 353
    //   348: aload 6
    //   350: invokevirtual 365	java/io/OutputStream:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   360: iconst_0
    //   361: ireturn
    //   362: astore 6
    //   364: aconst_null
    //   365: astore 5
    //   367: aconst_null
    //   368: astore_1
    //   369: aload 4
    //   371: astore_0
    //   372: invokestatic 341	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   375: aload_0
    //   376: invokevirtual 361	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   379: aload_1
    //   380: ifnull +7 -> 387
    //   383: aload_1
    //   384: invokevirtual 364	java/io/InputStream:close	()V
    //   387: aload 5
    //   389: ifnull +8 -> 397
    //   392: aload 5
    //   394: invokevirtual 365	java/io/OutputStream:close	()V
    //   397: aload 6
    //   399: athrow
    //   400: astore_0
    //   401: aload_0
    //   402: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   405: goto -8 -> 397
    //   408: astore 6
    //   410: aconst_null
    //   411: astore 5
    //   413: aload 4
    //   415: astore_0
    //   416: goto -44 -> 372
    //   419: astore 6
    //   421: aload 4
    //   423: astore_1
    //   424: goto -52 -> 372
    //   427: astore 7
    //   429: aconst_null
    //   430: astore 6
    //   432: goto -120 -> 312
    //   435: astore 7
    //   437: goto -125 -> 312
    //   440: astore 7
    //   442: aconst_null
    //   443: astore 6
    //   445: aconst_null
    //   446: astore_1
    //   447: aload 5
    //   449: astore 8
    //   451: goto -256 -> 195
    //   454: astore 7
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 5
    //   461: astore 8
    //   463: goto -268 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramArrayOfByte	byte[]
    //   0	466	1	paramString	String
    //   151	30	2	i	int
    //   36	227	3	bool	boolean
    //   7	415	4	str	String
    //   1	459	5	localObject1	Object
    //   47	302	6	localObject2	Object
    //   362	36	6	localObject3	Object
    //   408	1	6	localObject4	Object
    //   419	1	6	localObject5	Object
    //   430	28	6	localObject6	Object
    //   16	225	7	arrayOfByte1	byte[]
    //   305	18	7	localException1	Exception
    //   427	1	7	localException2	Exception
    //   435	1	7	localException3	Exception
    //   440	1	7	localIOException1	java.io.IOException
    //   454	1	7	localIOException2	java.io.IOException
    //   4	458	8	localObject7	Object
    //   13	254	9	arrayOfByte2	byte[]
    //   10	93	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   116	127	187	java/io/IOException
    //   145	152	187	java/io/IOException
    //   175	184	187	java/io/IOException
    //   256	261	187	java/io/IOException
    //   263	271	291	java/lang/Exception
    //   275	279	291	java/lang/Exception
    //   284	289	291	java/lang/Exception
    //   210	218	298	java/lang/Exception
    //   222	226	298	java/lang/Exception
    //   231	236	298	java/lang/Exception
    //   49	63	305	java/lang/Exception
    //   63	81	305	java/lang/Exception
    //   327	335	355	java/lang/Exception
    //   339	343	355	java/lang/Exception
    //   348	353	355	java/lang/Exception
    //   49	63	362	finally
    //   63	81	362	finally
    //   372	379	400	java/lang/Exception
    //   383	387	400	java/lang/Exception
    //   392	397	400	java/lang/Exception
    //   81	102	408	finally
    //   116	127	419	finally
    //   145	152	419	finally
    //   175	184	419	finally
    //   205	210	419	finally
    //   256	261	419	finally
    //   322	327	419	finally
    //   81	102	427	java/lang/Exception
    //   116	127	435	java/lang/Exception
    //   145	152	435	java/lang/Exception
    //   175	184	435	java/lang/Exception
    //   256	261	435	java/lang/Exception
    //   49	63	440	java/io/IOException
    //   63	81	440	java/io/IOException
    //   81	102	454	java/io/IOException
  }
  
  public static String j(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    String str2 = CM();
    if (b(paramUri)) {
      paramUri = paramUri.toString();
    }
    for (;;)
    {
      String str1 = paramUri + String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      try
      {
        paramUri = arwv.toMD5(str1);
        return str2 + paramUri;
        paramUri = paramUri.getAuthority() + paramUri.getPath();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          paramUri = str1;
          if (QLog.isColorLevel())
          {
            QLog.d("WebSoUtils", 2, "getFileBasePath..uri", localThrowable);
            paramUri = str1;
          }
        }
      }
    }
  }
  
  public static void k(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    sb(h(paramUri));
    sb(i(paramUri));
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    String str = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    paramUri = g(paramUri);
    localEditor.remove("eTag_" + str + paramUri);
    localEditor.remove("templateTag_" + str + paramUri);
    localEditor.remove("htmlSha1_" + str + paramUri);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static void l(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    k(paramUri);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    paramUri = g(paramUri);
    localEditor.putLong("webso_" + String.valueOf(l) + paramUri + "_503", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static String qg(String paramString)
  {
    try
    {
      str = g(Uri.parse(paramString));
      return str;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("WebSoUtils", 2, "getUrlKey..url", localThrowable);
    }
    return paramString;
  }
  
  public static String qh(String paramString)
  {
    if (paramString == null) {
      return "error";
    }
    return CM() + qg(paramString) + ".screenshot";
  }
  
  public static String qi(String paramString)
  {
    String str1 = getHtmlData(paramString);
    if (TextUtils.isEmpty(str1)) {
      paramString = "";
    }
    Object localObject;
    String str2;
    do
    {
      return paramString;
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      str2 = qg(paramString);
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localObject = ((SharedPreferences)localObject).getString("htmlSha1_" + String.valueOf(l) + str2, "");
      str2 = arcy.getSHA1(str1);
      if (!str2.equals(localObject)) {
        break;
      }
      paramString = str1;
    } while (!QLog.isColorLevel());
    QLog.d("WebSoUtils", 2, "getHtmlDataAndCheck success");
    return str1;
    if (QLog.isColorLevel()) {
      QLog.w("WebSoUtils", 2, "校验缓存etag 不一致，html-sha1 check fail. http rsp etag=" + (String)localObject + ",cache_sha1=" + str2);
    }
    try
    {
      k(Uri.parse(paramString));
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "clean web so data exception=" + paramString.getMessage());
        }
        paramString.printStackTrace();
      }
    }
  }
  
  public static String qj(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\".weishi.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\".weishi.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          localObject = (JSONObject)((JSONObject)localObject).get(str);
          paramString = ((JSONObject)localObject).optString("command");
          localObject = ((JSONObject)localObject).optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            return localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("WebSoUtils", 1, "getWnsCommand error:", paramString);
      return null;
    }
    return null;
  }
  
  public static String qk(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"},\"vv.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"qzpb.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\"vv6.video.qq.com\":{\"command\":\"qzoneh5.video.vv\",\"msfCommand\":\"qzoneh5.video.vv\"},\".urlshare.cn\":{\"command\":\"qzoneh5.urlshare.webso\",\"msfCommand\":\"qzoneh5.urlshare.webso\"},\"now.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\"nearby.qq.com\":{\"command\":\"ilive_node.node.nearby\",\"msfCommand\":\"ilive_node.node.nearby\"},\".weishi.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\".weishi.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"h5.gdt.qq.com\":{\"command\":\"nemoh5.gdt.lp\",\"msfCommand\":\"nemoh5.gdt.lp\"},\"club.vip.qq.com\":{\"command\":\"qzoneh5.club.wnshtml\",\"msfCommand\":\"qzoneh5.club.wnshtml\"},\".q.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\".ilive.qq.com\":{\"command\":\"iliveh5.ilive.wnshtml\",\"msfCommand\":\"iliveh5.ilive.wnshtml\"},\"qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"},\".qvideo.qq.com\":{\"command\":\"qvideoh5.qvideo.wnshtml\",\"msfCommand\":\"qvideoh5.qvideo.wnshtml\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          paramString = (JSONObject)((JSONObject)localObject).get(str);
          localObject = paramString.optString("command");
          paramString = paramString.optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            paramString = (String)localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static String ql(String paramString)
  {
    Wo("removeTag");
    return paramString.replaceFirst("<script>.*_WebSoLocalTime.*_WebSoNetTime.*;</script>", "");
  }
  
  private static int rV()
  {
    try
    {
      int i = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static boolean rW(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("_updateProxy");
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool3 = "0".equals(paramString);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean rX(String paramString)
  {
    try
    {
      boolean bool = hasProxyParam(Uri.parse(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean rY(String paramString)
  {
    boolean bool2 = false;
    try
    {
      String str1 = QzoneConfig.getInstance().getConfig("QzoneCover", "dynamicCoverPreviewUrl", "h5.qzone.qq.com/bgstore/dynamiccover");
      String str2 = QzoneConfig.getInstance().getConfig("QzoneCover", "dynamicCoverPreviewKeyword", "tplId=");
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.contains(str1))
        {
          boolean bool3 = paramString.contains(str2);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean rZ(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new File(h(Uri.parse(paramString)));
        if (paramString != null) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label87;
        }
        QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
        break label87;
        if ((!paramString.exists()) || (!paramString.canRead())) {
          continue;
        }
        long l = paramString.length();
        if (l <= 0L) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("WebSoUtils", 2, "getHtmlData", paramString);
        return false;
      }
      return false;
      label87:
      paramString = null;
    }
  }
  
  public static boolean sa(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    do
    {
      do
      {
        return false;
      } while (!rW(paramString));
      Object localObject = Uri.parse(paramString);
      paramString = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      localObject = g((Uri)localObject);
      l = paramString.getLong("webso_" + String.valueOf(l) + (String)localObject + "_503", -1L);
    } while ((l == -1L) || (System.currentTimeMillis() - l >= 43200000L));
    if (QLog.isColorLevel()) {
      QLog.e("WebSoUtils", 2, "now hit webso time, so return true");
    }
    return true;
  }
  
  private static boolean sb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return aqhq.deleteFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardk
 * JD-Core Version:    0.7.0.1
 */