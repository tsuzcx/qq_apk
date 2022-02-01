import android.text.TextUtils;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class voz
{
  protected static int a;
  protected static String a;
  private static voz jdField_a_of_type_Voz;
  protected static int b = 2097152;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, vpb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = QCircleFeedPicLoader.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_Int = 2048;
  }
  
  protected static long a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (paramHttpURLConnection == null) {
      return 0L;
    }
    paramHttpURLConnection = TextUtils.split(paramHttpURLConnection, ",");
    int i = 0;
    if (i < paramHttpURLConnection.length) {
      if (!paramHttpURLConnection[i].contains("max-age")) {}
    }
    for (long l = Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));; l = 0L)
    {
      return l;
      i += 1;
      break;
    }
  }
  
  protected static HttpURLConnection a(biua parambiua)
  {
    for (;;)
    {
      try
      {
        localObject1 = MsfSdkUtils.insertMtype("yingyongbao", parambiua.jdField_b_of_type_JavaLangString);
        if (bist.a(biip.a().a()))
        {
          i = "http://".length();
          localObject3 = bist.c(biip.a().a());
          String str = bist.d(biip.a().a());
          j = ((String)localObject1).indexOf('/', i);
          if (j < 0)
          {
            localObject2 = ((String)localObject1).substring(i);
            localObject1 = "";
            bisy.c(jdField_a_of_type_JavaLangString, "https://" + (String)localObject3 + ":" + str + (String)localObject1);
            localObject3 = (HttpURLConnection)new URL("https://" + (String)localObject3 + ":" + str + (String)localObject1).openConnection();
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception parambiua)
      {
        int j;
        Object localObject2;
        localObject3 = null;
        bisy.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- Exception!!!", parambiua);
        a((HttpURLConnection)localObject3);
        return null;
      }
      try
      {
        ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
        localObject1 = localObject3;
        localObject3 = localObject1;
      }
      catch (Exception parambiua)
      {
        localObject3 = localObject1;
        continue;
      }
      try
      {
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setConnectTimeout(60000);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setReadTimeout(120000);
        localObject3 = localObject1;
        if (parambiua.jdField_c_of_type_Long > 0L)
        {
          localObject3 = localObject1;
          localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
          localObject3 = localObject1;
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(parambiua.jdField_c_of_type_Long)));
        }
        localObject3 = localObject1;
        i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject3 = localObject1;
        bisy.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- reponseCode=" + i);
        if ((i == 302) || (i == 301))
        {
          localObject3 = localObject1;
          parambiua = ((HttpURLConnection)localObject1).getHeaderField("Location");
          localObject3 = localObject1;
          bisy.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- loc=" + parambiua);
          localObject3 = localObject1;
          a((HttpURLConnection)localObject1);
          parambiua = null;
          localObject1 = parambiua;
          bisy.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- uc=" + parambiua);
          return parambiua;
          localObject2 = ((String)localObject1).substring(i, j);
          localObject1 = ((String)localObject1).substring(j);
          continue;
          localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
          continue;
        }
        if ((i != 200) && (i != 206)) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = ((HttpURLConnection)localObject1).getContentType();
        if (localObject2 != null) {
          continue;
        }
        localObject2 = "";
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text/vnd.wap.wml") != -1) {
          break label755;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
          break label755;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text") == -1) {
          break label760;
        }
      }
      catch (Exception parambiua)
      {
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      localObject2 = localObject1;
      if (i != 0)
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        parambiua.jdField_a_of_type_Long = (a((HttpURLConnection)localObject2) * 1000L);
        localObject3 = localObject2;
        if (parambiua.jdField_a_of_type_Long == 0L)
        {
          localObject3 = localObject2;
          parambiua.jdField_a_of_type_Long = 86400000L;
        }
      }
      localObject3 = localObject2;
      parambiua.jdField_b_of_type_Long = System.currentTimeMillis();
      parambiua = (biua)localObject2;
      continue;
      localObject3 = localObject1;
      localObject2 = ((String)localObject2).toLowerCase();
      continue;
      if (i == 304)
      {
        localObject3 = localObject1;
        bisy.c(jdField_a_of_type_JavaLangString, "--getimg-- " + parambiua.jdField_b_of_type_JavaLangString + " not modified");
        localObject3 = localObject1;
        parambiua.jdField_a_of_type_Long = (a((HttpURLConnection)localObject1) * 1000L);
        localObject3 = localObject1;
        parambiua.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        parambiua = null;
      }
      else
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        parambiua = null;
      }
    }
  }
  
  public static voz a()
  {
    if (jdField_a_of_type_Voz == null) {}
    try
    {
      if (jdField_a_of_type_Voz == null) {
        jdField_a_of_type_Voz = new voz();
      }
      return jdField_a_of_type_Voz;
    }
    finally {}
  }
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      bisy.c("", "", paramHttpURLConnection);
    }
  }
  
  private void a(@NotNull vou paramvou)
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new vpa(this, paramvou);
    localbdvs.jdField_a_of_type_JavaLangString = paramvou.a();
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_c_of_type_JavaLangString = paramvou.c();
    localbdvs.b = bgnt.a(bdwu.a().a());
    paramvou = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramvou instanceof QQAppInterface)) {
      ((QQAppInterface)paramvou).getNetEngine(0).a(localbdvs);
    }
  }
  
  private void a(vou paramvou, boolean paramBoolean, int paramInt)
  {
    if (paramvou != null)
    {
      paramvou = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramvou.c());
      if (paramvou != null)
      {
        Iterator localIterator = paramvou.keySet().iterator();
        while (localIterator.hasNext())
        {
          vpb localvpb = (vpb)paramvou.get((Integer)localIterator.next());
          if (localvpb != null) {
            localvpb.a(paramBoolean, paramInt);
          }
        }
      }
    }
  }
  
  private void b(vou paramvou, vpb paramvpb)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put(Integer.valueOf(paramvpb.hashCode()), paramvpb);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramvou.c(), localConcurrentHashMap);
    paramvpb = new biua();
    paramvpb.jdField_c_of_type_JavaLangString = paramvou.c();
    paramvpb.jdField_c_of_type_Long = 0L;
    paramvpb.jdField_a_of_type_JavaLangString = paramvou.b();
    paramvpb.jdField_b_of_type_JavaLangString = paramvou.a();
    if (a(paramvpb))
    {
      a(paramvou, true, 0);
      return;
    }
    a(paramvou);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(vou paramvou, vpb paramvpb)
  {
    if ((paramvou != null) && (paramvpb != null))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvou.c()))
      {
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvou.c());
        if (!localConcurrentHashMap.containsKey(Integer.valueOf(paramvpb.hashCode())))
        {
          localConcurrentHashMap.put(Integer.valueOf(paramvpb.hashCode()), paramvpb);
          QLog.e(jdField_a_of_type_JavaLangString, 1, paramvou.b() + ", is on Downloading  ifFromPreload:" + paramvou.b());
          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramvou.c()))
          {
            if (!atwl.a(paramvou.c())) {
              break label170;
            }
            a(paramvou, true, 0);
            QLog.e(jdField_a_of_type_JavaLangString, 1, paramvou.b() + ",lost callback  return success ifFromPreload:" + paramvou.b());
          }
        }
        return;
        label170:
        b(paramvou, paramvpb);
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramvou.b() + ",lost callback  reDownload ifFromPreload:" + paramvou.b());
        return;
      }
      b(paramvou, paramvpb);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 4, "illegal args");
  }
  
  /* Error */
  public boolean a(biua parambiua)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 16
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 17
    //   9: aconst_null
    //   10: astore 15
    //   12: iconst_0
    //   13: istore 5
    //   15: aload_1
    //   16: invokestatic 446	voz:a	(Lbiua;)Ljava/net/HttpURLConnection;
    //   19: astore 8
    //   21: aload 8
    //   23: ifnonnull +91 -> 114
    //   26: getstatic 18	voz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: new 126	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 448
    //   39: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 84	biua:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 450
    //   52: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 143	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_0
    //   62: ifeq +11 -> 73
    //   65: new 452	java/lang/NullPointerException
    //   68: dup
    //   69: invokespecial 453	java/lang/NullPointerException:<init>	()V
    //   72: athrow
    //   73: iconst_0
    //   74: ifeq +11 -> 85
    //   77: new 452	java/lang/NullPointerException
    //   80: dup
    //   81: invokespecial 453	java/lang/NullPointerException:<init>	()V
    //   84: athrow
    //   85: iload 5
    //   87: istore 4
    //   89: aload 8
    //   91: ifnull +12 -> 103
    //   94: aload 8
    //   96: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   99: iload 5
    //   101: istore 4
    //   103: iload 4
    //   105: ireturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   111: goto -26 -> 85
    //   114: aload 8
    //   116: invokevirtual 459	java/net/HttpURLConnection:getContentLength	()I
    //   119: i2l
    //   120: lstore 6
    //   122: invokestatic 463	biqd:a	()J
    //   125: lload 6
    //   127: lcmp
    //   128: ifge +86 -> 214
    //   131: getstatic 18	voz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: new 126	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 448
    //   144: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: getfield 84	biua:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   151: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 465
    //   157: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 143	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: iconst_0
    //   167: ifeq +11 -> 178
    //   170: new 452	java/lang/NullPointerException
    //   173: dup
    //   174: invokespecial 453	java/lang/NullPointerException:<init>	()V
    //   177: athrow
    //   178: iconst_0
    //   179: ifeq +11 -> 190
    //   182: new 452	java/lang/NullPointerException
    //   185: dup
    //   186: invokespecial 453	java/lang/NullPointerException:<init>	()V
    //   189: athrow
    //   190: iload 5
    //   192: istore 4
    //   194: aload 8
    //   196: ifnull -93 -> 103
    //   199: aload 8
    //   201: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   211: goto -21 -> 190
    //   214: aload 8
    //   216: invokevirtual 469	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   219: astore 9
    //   221: lconst_0
    //   222: lstore 6
    //   224: aload 17
    //   226: astore 13
    //   228: aload 9
    //   230: astore 12
    //   232: aload 8
    //   234: astore 11
    //   236: getstatic 20	voz:jdField_a_of_type_Int	I
    //   239: newarray byte
    //   241: astore 10
    //   243: aload 17
    //   245: astore 13
    //   247: aload 9
    //   249: astore 12
    //   251: aload 8
    //   253: astore 11
    //   255: new 471	java/io/ByteArrayOutputStream
    //   258: dup
    //   259: invokespecial 472	java/io/ByteArrayOutputStream:<init>	()V
    //   262: astore 18
    //   264: aload 17
    //   266: astore 13
    //   268: aload 9
    //   270: astore 12
    //   272: aload 8
    //   274: astore 11
    //   276: aload 9
    //   278: aload 10
    //   280: iconst_0
    //   281: getstatic 20	voz:jdField_a_of_type_Int	I
    //   284: invokevirtual 478	java/io/InputStream:read	([BII)I
    //   287: istore_2
    //   288: iload_2
    //   289: ifle +104 -> 393
    //   292: aload 17
    //   294: astore 13
    //   296: aload 9
    //   298: astore 12
    //   300: aload 8
    //   302: astore 11
    //   304: getstatic 23	voz:b	I
    //   307: istore_3
    //   308: lload 6
    //   310: iload_3
    //   311: i2l
    //   312: lcmp
    //   313: iflt +49 -> 362
    //   316: iconst_0
    //   317: ifeq +11 -> 328
    //   320: new 452	java/lang/NullPointerException
    //   323: dup
    //   324: invokespecial 453	java/lang/NullPointerException:<init>	()V
    //   327: athrow
    //   328: aload 9
    //   330: ifnull +8 -> 338
    //   333: aload 9
    //   335: invokevirtual 481	java/io/InputStream:close	()V
    //   338: iload 5
    //   340: istore 4
    //   342: aload 8
    //   344: ifnull -241 -> 103
    //   347: aload 8
    //   349: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   352: iconst_0
    //   353: ireturn
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   359: goto -21 -> 338
    //   362: aload 17
    //   364: astore 13
    //   366: aload 9
    //   368: astore 12
    //   370: aload 8
    //   372: astore 11
    //   374: aload 18
    //   376: aload 10
    //   378: iconst_0
    //   379: iload_2
    //   380: invokevirtual 485	java/io/ByteArrayOutputStream:write	([BII)V
    //   383: lload 6
    //   385: iload_2
    //   386: i2l
    //   387: ladd
    //   388: lstore 6
    //   390: goto -126 -> 264
    //   393: aload 17
    //   395: astore 13
    //   397: aload 9
    //   399: astore 12
    //   401: aload 8
    //   403: astore 11
    //   405: aload_1
    //   406: getfield 401	biua:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   409: astore 19
    //   411: aload 17
    //   413: astore 13
    //   415: aload 9
    //   417: astore 12
    //   419: aload 8
    //   421: astore 11
    //   423: new 487	java/io/File
    //   426: dup
    //   427: new 126	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   434: aload 19
    //   436: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 489
    //   442: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   451: astore 14
    //   453: aload 17
    //   455: astore 13
    //   457: aload 9
    //   459: astore 12
    //   461: aload 8
    //   463: astore 11
    //   465: aload 14
    //   467: invokevirtual 493	java/io/File:getParent	()Ljava/lang/String;
    //   470: ifnull +47 -> 517
    //   473: aload 17
    //   475: astore 13
    //   477: aload 9
    //   479: astore 12
    //   481: aload 8
    //   483: astore 11
    //   485: aload 14
    //   487: invokevirtual 497	java/io/File:getParentFile	()Ljava/io/File;
    //   490: invokevirtual 500	java/io/File:exists	()Z
    //   493: ifne +24 -> 517
    //   496: aload 17
    //   498: astore 13
    //   500: aload 9
    //   502: astore 12
    //   504: aload 8
    //   506: astore 11
    //   508: aload 14
    //   510: invokevirtual 497	java/io/File:getParentFile	()Ljava/io/File;
    //   513: invokevirtual 503	java/io/File:mkdirs	()Z
    //   516: pop
    //   517: aload 17
    //   519: astore 13
    //   521: aload 9
    //   523: astore 12
    //   525: aload 8
    //   527: astore 11
    //   529: aload 14
    //   531: invokevirtual 500	java/io/File:exists	()Z
    //   534: ifeq +21 -> 555
    //   537: aload 17
    //   539: astore 13
    //   541: aload 9
    //   543: astore 12
    //   545: aload 8
    //   547: astore 11
    //   549: aload 14
    //   551: invokevirtual 506	java/io/File:delete	()Z
    //   554: pop
    //   555: aload 17
    //   557: astore 13
    //   559: aload 9
    //   561: astore 12
    //   563: aload 8
    //   565: astore 11
    //   567: aload 14
    //   569: invokevirtual 509	java/io/File:createNewFile	()Z
    //   572: pop
    //   573: aload 17
    //   575: astore 13
    //   577: aload 9
    //   579: astore 12
    //   581: aload 8
    //   583: astore 11
    //   585: new 511	java/io/FileOutputStream
    //   588: dup
    //   589: new 126	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   596: aload 19
    //   598: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 489
    //   604: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 512	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   613: astore 10
    //   615: aload 10
    //   617: aload 18
    //   619: invokevirtual 516	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   622: invokevirtual 519	java/io/FileOutputStream:write	([B)V
    //   625: aload 10
    //   627: invokevirtual 522	java/io/FileOutputStream:flush	()V
    //   630: new 487	java/io/File
    //   633: dup
    //   634: aload 19
    //   636: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   639: astore 12
    //   641: aload 12
    //   643: invokevirtual 500	java/io/File:exists	()Z
    //   646: ifeq +9 -> 655
    //   649: aload 12
    //   651: invokevirtual 506	java/io/File:delete	()Z
    //   654: pop
    //   655: aload 14
    //   657: aload 12
    //   659: invokevirtual 526	java/io/File:renameTo	(Ljava/io/File;)Z
    //   662: pop
    //   663: ldc_w 528
    //   666: aload_1
    //   667: getfield 404	biua:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   670: invokestatic 143	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload_1
    //   674: aload 8
    //   676: invokevirtual 531	java/net/HttpURLConnection:getLastModified	()J
    //   679: putfield 185	biua:jdField_c_of_type_Long	J
    //   682: iconst_1
    //   683: istore 4
    //   685: aload 10
    //   687: ifnull +8 -> 695
    //   690: aload 10
    //   692: invokevirtual 532	java/io/FileOutputStream:close	()V
    //   695: aload 9
    //   697: ifnull +8 -> 705
    //   700: aload 9
    //   702: invokevirtual 481	java/io/InputStream:close	()V
    //   705: aload 8
    //   707: ifnull -604 -> 103
    //   710: aload 8
    //   712: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   715: iconst_1
    //   716: ireturn
    //   717: astore_1
    //   718: aload_1
    //   719: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   722: goto -17 -> 705
    //   725: astore 10
    //   727: aconst_null
    //   728: astore 11
    //   730: aconst_null
    //   731: astore_1
    //   732: aconst_null
    //   733: astore 8
    //   735: aconst_null
    //   736: astore 9
    //   738: aload 15
    //   740: astore 12
    //   742: getstatic 18	voz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   745: ldc_w 534
    //   748: aload 10
    //   750: invokestatic 284	bisy:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   753: aload 11
    //   755: ifnull +17 -> 772
    //   758: aload 11
    //   760: invokevirtual 500	java/io/File:exists	()Z
    //   763: ifeq +9 -> 772
    //   766: aload 11
    //   768: invokevirtual 506	java/io/File:delete	()Z
    //   771: pop
    //   772: aload 12
    //   774: ifnull +17 -> 791
    //   777: aload 12
    //   779: invokevirtual 500	java/io/File:exists	()Z
    //   782: ifeq +9 -> 791
    //   785: aload 12
    //   787: invokevirtual 506	java/io/File:delete	()Z
    //   790: pop
    //   791: aload_1
    //   792: ifnull +7 -> 799
    //   795: aload_1
    //   796: invokevirtual 532	java/io/FileOutputStream:close	()V
    //   799: aload 8
    //   801: ifnull +8 -> 809
    //   804: aload 8
    //   806: invokevirtual 481	java/io/InputStream:close	()V
    //   809: iload 5
    //   811: istore 4
    //   813: aload 9
    //   815: ifnull -712 -> 103
    //   818: aload 9
    //   820: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   823: iconst_0
    //   824: ireturn
    //   825: astore_1
    //   826: aload_1
    //   827: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   830: goto -21 -> 809
    //   833: astore_1
    //   834: aconst_null
    //   835: astore 9
    //   837: aconst_null
    //   838: astore 8
    //   840: aload 16
    //   842: astore 10
    //   844: aload 10
    //   846: astore 13
    //   848: aload 9
    //   850: astore 12
    //   852: aload 8
    //   854: astore 11
    //   856: getstatic 18	voz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   859: new 126	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 534
    //   869: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload_1
    //   873: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 536	bisy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload 10
    //   884: ifnull +8 -> 892
    //   887: aload 10
    //   889: invokevirtual 532	java/io/FileOutputStream:close	()V
    //   892: aload 9
    //   894: ifnull +8 -> 902
    //   897: aload 9
    //   899: invokevirtual 481	java/io/InputStream:close	()V
    //   902: iload 5
    //   904: istore 4
    //   906: aload 8
    //   908: ifnull -805 -> 103
    //   911: aload 8
    //   913: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   916: iconst_0
    //   917: ireturn
    //   918: astore_1
    //   919: aload_1
    //   920: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   923: goto -21 -> 902
    //   926: astore_1
    //   927: aconst_null
    //   928: astore 9
    //   930: aconst_null
    //   931: astore 8
    //   933: aload 10
    //   935: ifnull +8 -> 943
    //   938: aload 10
    //   940: invokevirtual 532	java/io/FileOutputStream:close	()V
    //   943: aload 9
    //   945: ifnull +8 -> 953
    //   948: aload 9
    //   950: invokevirtual 481	java/io/InputStream:close	()V
    //   953: aload 8
    //   955: ifnull +8 -> 963
    //   958: aload 8
    //   960: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
    //   963: aload_1
    //   964: athrow
    //   965: astore 9
    //   967: aload 9
    //   969: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   972: goto -19 -> 953
    //   975: astore_1
    //   976: aconst_null
    //   977: astore 9
    //   979: goto -46 -> 933
    //   982: astore_1
    //   983: aload 13
    //   985: astore 10
    //   987: aload 12
    //   989: astore 9
    //   991: aload 11
    //   993: astore 8
    //   995: goto -62 -> 933
    //   998: astore_1
    //   999: goto -66 -> 933
    //   1002: astore 12
    //   1004: aload_1
    //   1005: astore 10
    //   1007: aload 9
    //   1009: astore 11
    //   1011: aload 12
    //   1013: astore_1
    //   1014: aload 8
    //   1016: astore 9
    //   1018: aload 11
    //   1020: astore 8
    //   1022: goto -89 -> 933
    //   1025: astore_1
    //   1026: aconst_null
    //   1027: astore 9
    //   1029: aload 16
    //   1031: astore 10
    //   1033: goto -189 -> 844
    //   1036: astore_1
    //   1037: aload 16
    //   1039: astore 10
    //   1041: goto -197 -> 844
    //   1044: astore_1
    //   1045: goto -201 -> 844
    //   1048: astore 10
    //   1050: aconst_null
    //   1051: astore 11
    //   1053: aconst_null
    //   1054: astore_1
    //   1055: aconst_null
    //   1056: astore 13
    //   1058: aload 8
    //   1060: astore 9
    //   1062: aload 15
    //   1064: astore 12
    //   1066: aload 13
    //   1068: astore 8
    //   1070: goto -328 -> 742
    //   1073: astore 10
    //   1075: aconst_null
    //   1076: astore 11
    //   1078: aconst_null
    //   1079: astore_1
    //   1080: aload 8
    //   1082: astore 13
    //   1084: aload 15
    //   1086: astore 12
    //   1088: aload 9
    //   1090: astore 8
    //   1092: aload 13
    //   1094: astore 9
    //   1096: goto -354 -> 742
    //   1099: astore 10
    //   1101: aload 14
    //   1103: astore 11
    //   1105: aload 9
    //   1107: astore 13
    //   1109: aconst_null
    //   1110: astore_1
    //   1111: aload 8
    //   1113: astore 9
    //   1115: aload 15
    //   1117: astore 12
    //   1119: aload 13
    //   1121: astore 8
    //   1123: goto -381 -> 742
    //   1126: astore 12
    //   1128: aload 14
    //   1130: astore 11
    //   1132: aload 10
    //   1134: astore_1
    //   1135: aload 8
    //   1137: astore 13
    //   1139: aload 12
    //   1141: astore 10
    //   1143: aload 15
    //   1145: astore 12
    //   1147: aload 9
    //   1149: astore 8
    //   1151: aload 13
    //   1153: astore 9
    //   1155: goto -413 -> 742
    //   1158: astore 15
    //   1160: aload 14
    //   1162: astore 11
    //   1164: aload 10
    //   1166: astore_1
    //   1167: aload 8
    //   1169: astore 13
    //   1171: aload 15
    //   1173: astore 10
    //   1175: aload 9
    //   1177: astore 8
    //   1179: aload 13
    //   1181: astore 9
    //   1183: goto -441 -> 742
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1186	0	this	voz
    //   0	1186	1	parambiua	biua
    //   287	99	2	i	int
    //   307	4	3	j	int
    //   87	818	4	bool1	boolean
    //   13	890	5	bool2	boolean
    //   120	269	6	l	long
    //   19	1159	8	localObject1	Object
    //   219	730	9	localInputStream	java.io.InputStream
    //   965	3	9	localException1	Exception
    //   977	205	9	localObject2	Object
    //   4	687	10	localObject3	Object
    //   725	24	10	localException2	Exception
    //   842	198	10	localObject4	Object
    //   1048	1	10	localException3	Exception
    //   1073	1	10	localException4	Exception
    //   1099	34	10	localException5	Exception
    //   1141	33	10	localObject5	Object
    //   234	929	11	localObject6	Object
    //   230	758	12	localObject7	Object
    //   1002	10	12	localObject8	Object
    //   1064	54	12	localObject9	Object
    //   1126	14	12	localException6	Exception
    //   1145	1	12	localObject10	Object
    //   226	954	13	localObject11	Object
    //   451	710	14	localFile	java.io.File
    //   10	1134	15	localObject12	Object
    //   1158	14	15	localException7	Exception
    //   1	1037	16	localObject13	Object
    //   7	567	17	localObject14	Object
    //   262	356	18	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   409	226	19	str	String
    // Exception table:
    //   from	to	target	type
    //   65	73	106	java/lang/Exception
    //   77	85	106	java/lang/Exception
    //   170	178	206	java/lang/Exception
    //   182	190	206	java/lang/Exception
    //   320	328	354	java/lang/Exception
    //   333	338	354	java/lang/Exception
    //   690	695	717	java/lang/Exception
    //   700	705	717	java/lang/Exception
    //   15	21	725	java/lang/Exception
    //   795	799	825	java/lang/Exception
    //   804	809	825	java/lang/Exception
    //   15	21	833	java/lang/OutOfMemoryError
    //   887	892	918	java/lang/Exception
    //   897	902	918	java/lang/Exception
    //   15	21	926	finally
    //   938	943	965	java/lang/Exception
    //   948	953	965	java/lang/Exception
    //   26	61	975	finally
    //   114	166	975	finally
    //   214	221	975	finally
    //   236	243	982	finally
    //   255	264	982	finally
    //   276	288	982	finally
    //   304	308	982	finally
    //   374	383	982	finally
    //   405	411	982	finally
    //   423	453	982	finally
    //   465	473	982	finally
    //   485	496	982	finally
    //   508	517	982	finally
    //   529	537	982	finally
    //   549	555	982	finally
    //   567	573	982	finally
    //   585	615	982	finally
    //   856	882	982	finally
    //   615	641	998	finally
    //   641	655	998	finally
    //   655	682	998	finally
    //   742	753	1002	finally
    //   758	772	1002	finally
    //   777	791	1002	finally
    //   26	61	1025	java/lang/OutOfMemoryError
    //   114	166	1025	java/lang/OutOfMemoryError
    //   214	221	1025	java/lang/OutOfMemoryError
    //   236	243	1036	java/lang/OutOfMemoryError
    //   255	264	1036	java/lang/OutOfMemoryError
    //   276	288	1036	java/lang/OutOfMemoryError
    //   304	308	1036	java/lang/OutOfMemoryError
    //   374	383	1036	java/lang/OutOfMemoryError
    //   405	411	1036	java/lang/OutOfMemoryError
    //   423	453	1036	java/lang/OutOfMemoryError
    //   465	473	1036	java/lang/OutOfMemoryError
    //   485	496	1036	java/lang/OutOfMemoryError
    //   508	517	1036	java/lang/OutOfMemoryError
    //   529	537	1036	java/lang/OutOfMemoryError
    //   549	555	1036	java/lang/OutOfMemoryError
    //   567	573	1036	java/lang/OutOfMemoryError
    //   585	615	1036	java/lang/OutOfMemoryError
    //   615	641	1044	java/lang/OutOfMemoryError
    //   641	655	1044	java/lang/OutOfMemoryError
    //   655	682	1044	java/lang/OutOfMemoryError
    //   26	61	1048	java/lang/Exception
    //   114	166	1048	java/lang/Exception
    //   214	221	1048	java/lang/Exception
    //   236	243	1073	java/lang/Exception
    //   255	264	1073	java/lang/Exception
    //   276	288	1073	java/lang/Exception
    //   304	308	1073	java/lang/Exception
    //   374	383	1073	java/lang/Exception
    //   405	411	1073	java/lang/Exception
    //   423	453	1073	java/lang/Exception
    //   465	473	1099	java/lang/Exception
    //   485	496	1099	java/lang/Exception
    //   508	517	1099	java/lang/Exception
    //   529	537	1099	java/lang/Exception
    //   549	555	1099	java/lang/Exception
    //   567	573	1099	java/lang/Exception
    //   585	615	1099	java/lang/Exception
    //   615	641	1126	java/lang/Exception
    //   641	655	1158	java/lang/Exception
    //   655	682	1158	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voz
 * JD-Core Version:    0.7.0.1
 */