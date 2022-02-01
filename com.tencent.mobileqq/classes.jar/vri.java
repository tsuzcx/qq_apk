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

public class vri
{
  protected static int a;
  protected static String a;
  private static vri jdField_a_of_type_Vri;
  protected static int b = 2097152;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, vrk>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
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
  
  protected static HttpURLConnection a(bjuz parambjuz, vrd paramvrd)
  {
    Object localObject5 = null;
    if ((parambjuz == null) || (paramvrd == null)) {
      return null;
    }
    Object localObject1 = localObject5;
    for (;;)
    {
      try
      {
        localObject3 = MsfSdkUtils.insertMtype("yingyongbao", parambjuz.jdField_b_of_type_JavaLangString);
        localObject1 = localObject5;
        if (!bjts.a(bjjo.a().a())) {
          continue;
        }
        localObject1 = localObject5;
        i = "http://".length();
        localObject1 = localObject5;
        String str1 = bjts.c(bjjo.a().a());
        localObject1 = localObject5;
        String str2 = bjts.d(bjjo.a().a());
        localObject1 = localObject5;
        j = ((String)localObject3).indexOf('/', i);
        if (j >= 0) {
          continue;
        }
        localObject1 = localObject5;
        localObject4 = ((String)localObject3).substring(i);
        localObject3 = "";
        localObject1 = localObject5;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " https://" + str1 + ":" + str2 + (String)localObject3);
        localObject1 = localObject5;
        localObject5 = (HttpURLConnection)new URL("https://" + str1 + ":" + str2 + (String)localObject3).openConnection();
        localObject3 = localObject5;
        try
        {
          ((HttpURLConnection)localObject5).setRequestProperty("X-Online-Host", (String)localObject4);
          localObject3 = localObject5;
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setRequestMethod("GET");
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setRequestProperty("Connection", "Keep-Alive");
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setDoInput(true);
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setAllowUserInteraction(true);
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setConnectTimeout(60000);
          localObject1 = localObject3;
          ((HttpURLConnection)localObject3).setReadTimeout(120000);
          localObject1 = localObject3;
          if (parambjuz.jdField_c_of_type_Long > 0L)
          {
            localObject1 = localObject3;
            localObject4 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            localObject1 = localObject3;
            ((SimpleDateFormat)localObject4).setTimeZone(TimeZone.getTimeZone("GMT"));
            localObject1 = localObject3;
            ((HttpURLConnection)localObject3).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject4).format(new Date(parambjuz.jdField_c_of_type_Long)));
          }
          localObject1 = localObject3;
          i = ((HttpURLConnection)localObject3).getResponseCode();
          localObject1 = localObject3;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " reponseCode=" + i);
          if ((i != 302) && (i != 301)) {
            continue;
          }
          localObject1 = localObject3;
          localObject4 = ((HttpURLConnection)localObject3).getHeaderField("Location");
          localObject1 = localObject3;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " loc=" + (String)localObject4);
          localObject1 = localObject3;
          a((HttpURLConnection)localObject3);
          localObject1 = null;
          localObject3 = localObject1;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " uc=" + localObject1);
          return localObject1;
        }
        catch (Exception localException1)
        {
          localObject4 = localObject3;
          localObject3 = localException1;
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        int j;
        Object localObject2;
        Object localObject4 = localObject2;
        continue;
        if (i == 200) {
          continue;
        }
        if (i != 206) {
          continue;
        }
        continue;
        int i = 1;
        continue;
        i = 0;
        continue;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " Exception!!!", (Throwable)localObject3);
      a((HttpURLConnection)localObject4);
      return null;
      localObject2 = localObject5;
      localObject4 = ((String)localObject3).substring(i, j);
      localObject2 = localObject5;
      localObject3 = ((String)localObject3).substring(j);
      continue;
      localObject2 = localObject5;
      localObject3 = (HttpURLConnection)new URL((String)localObject3).openConnection();
      continue;
      localObject2 = localObject3;
      localObject4 = ((HttpURLConnection)localObject3).getContentType();
      if (localObject4 == null)
      {
        localObject5 = "";
        localObject2 = localObject3;
        if (((String)localObject5).indexOf("text/vnd.wap.wml") != -1) {
          continue;
        }
        localObject2 = localObject3;
        if (((String)localObject5).indexOf("application/vnd.wap.wmlc") != -1) {
          continue;
        }
        localObject2 = localObject3;
        if (((String)localObject5).indexOf("text") == -1) {
          continue;
        }
        continue;
        localObject4 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          a((HttpURLConnection)localObject3);
          localObject4 = null;
        }
        if (localObject4 != null)
        {
          localObject2 = localObject4;
          parambjuz.jdField_a_of_type_Long = (a((HttpURLConnection)localObject4) * 1000L);
          localObject2 = localObject4;
          if (parambjuz.jdField_a_of_type_Long == 0L)
          {
            localObject2 = localObject4;
            parambjuz.jdField_a_of_type_Long = 86400000L;
          }
        }
        localObject2 = localObject4;
        parambjuz.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject2 = localObject4;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " contentType=" + (String)localObject5);
        localObject2 = localObject4;
      }
      else
      {
        localObject2 = localObject3;
        localObject5 = ((String)localObject4).toLowerCase();
        continue;
        if (i == 304)
        {
          localObject2 = localObject3;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + "--getHttpConnection-- cacheKey = " + parambjuz.jdField_a_of_type_JavaLangString + " --getimg-- " + parambjuz.jdField_b_of_type_JavaLangString + " not modified");
          localObject2 = localObject3;
          parambjuz.jdField_a_of_type_Long = (a((HttpURLConnection)localObject3) * 1000L);
          localObject2 = localObject3;
          parambjuz.jdField_b_of_type_Long = System.currentTimeMillis();
          localObject2 = localObject3;
          a((HttpURLConnection)localObject3);
          localObject2 = null;
        }
        else
        {
          localObject2 = localObject3;
          a((HttpURLConnection)localObject3);
          localObject2 = null;
        }
      }
    }
  }
  
  public static vri a()
  {
    if (jdField_a_of_type_Vri == null) {}
    try
    {
      if (jdField_a_of_type_Vri == null) {
        jdField_a_of_type_Vri = new vri();
      }
      return jdField_a_of_type_Vri;
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
      bjtx.c("", "", paramHttpURLConnection);
    }
  }
  
  private void a(@NotNull vrd paramvrd)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new vrj(this, paramvrd);
    localbeum.jdField_a_of_type_JavaLangString = paramvrd.a();
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_c_of_type_JavaLangString = paramvrd.c();
    localbeum.b = bhnv.a(bevn.a().a());
    paramvrd = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramvrd instanceof QQAppInterface)) {
      ((QQAppInterface)paramvrd).getNetEngine(0).a(localbeum);
    }
  }
  
  private void a(vrd paramvrd, boolean paramBoolean, int paramInt)
  {
    if (paramvrd != null)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvrd.c());
      if (localConcurrentHashMap != null)
      {
        Iterator localIterator = localConcurrentHashMap.keySet().iterator();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " call back size:" + localConcurrentHashMap.size());
        while (localIterator.hasNext())
        {
          vrk localvrk = (vrk)localConcurrentHashMap.remove((Integer)localIterator.next());
          if (localvrk != null) {
            localvrk.a(paramBoolean, paramInt);
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + " ifFromPreload:" + paramvrd.b() + " callBackResult success = " + paramBoolean + " resultCode = " + paramInt);
      }
    }
  }
  
  private void b(vrd paramvrd, vrk paramvrk)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvrd.c());
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramvrk.hashCode()), paramvrk);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramvrd.c(), localConcurrentHashMap1);
    paramvrk = new bjuz();
    paramvrk.jdField_c_of_type_JavaLangString = paramvrd.c();
    paramvrk.jdField_c_of_type_Long = 0L;
    paramvrk.jdField_a_of_type_JavaLangString = paramvrd.b();
    paramvrk.jdField_b_of_type_JavaLangString = paramvrd.a();
    if (a(paramvrk, paramvrd))
    {
      a(paramvrd, true, 0);
      return;
    }
    a(paramvrd);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(vrd paramvrd, vrk paramvrk)
  {
    if ((paramvrd != null) && (paramvrk != null))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvrd.c());
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0))
      {
        localConcurrentHashMap.put(Integer.valueOf(paramvrk.hashCode()), paramvrk);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + ", is on Downloading ifFromPreload:" + paramvrd.b());
        if (localConcurrentHashMap.size() == 1)
        {
          if (auog.a(paramvrd.c()))
          {
            a(paramvrd, true, 0);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + ",lost callback  return success ifFromPreload:" + paramvrd.b());
          }
        }
        else {
          return;
        }
        b(paramvrd, paramvrk);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "seq = " + paramvrd.a() + " cacheKey = " + paramvrd.b() + ",lost callback  reDownload ifFromPreload:" + paramvrd.b());
        return;
      }
      b(paramvrd, paramvrk);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "illegal args");
  }
  
  /* Error */
  public boolean a(bjuz parambjuz, vrd paramvrd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 19
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 17
    //   15: aconst_null
    //   16: astore 16
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic 465	vri:a	(Lbjuz;Lvrd;)Ljava/net/HttpURLConnection;
    //   23: astore 10
    //   25: aload 10
    //   27: astore 9
    //   29: aload 9
    //   31: ifnonnull +120 -> 151
    //   34: getstatic 18	vri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: iconst_1
    //   38: new 126	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   45: ldc 129
    //   47: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 137	vrd:a	()I
    //   54: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 467
    //   60: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 143	bjuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 469
    //   73: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 84	bjuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 471
    //   86: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iconst_0
    //   96: istore 6
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 473	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 473	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: iload 6
    //   124: istore 5
    //   126: aload 9
    //   128: ifnull +12 -> 140
    //   131: aload 9
    //   133: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   136: iload 6
    //   138: istore 5
    //   140: iload 5
    //   142: ireturn
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   148: goto -26 -> 122
    //   151: aload 9
    //   153: invokevirtual 480	java/net/HttpURLConnection:getContentLength	()I
    //   156: i2l
    //   157: lstore 7
    //   159: invokestatic 484	bjrc:a	()J
    //   162: lload 7
    //   164: lcmp
    //   165: ifge +111 -> 276
    //   168: getstatic 18	vri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   171: iconst_1
    //   172: new 126	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   179: ldc 129
    //   181: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 137	vrd:a	()I
    //   188: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc_w 467
    //   194: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: getfield 143	bjuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 469
    //   207: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: getfield 84	bjuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   214: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 486
    //   220: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iconst_0
    //   230: istore 5
    //   232: iconst_0
    //   233: ifeq +11 -> 244
    //   236: new 473	java/lang/NullPointerException
    //   239: dup
    //   240: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   243: athrow
    //   244: iconst_0
    //   245: ifeq +11 -> 256
    //   248: new 473	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   255: athrow
    //   256: aload 9
    //   258: ifnull -118 -> 140
    //   261: aload 9
    //   263: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   273: goto -17 -> 256
    //   276: aload 9
    //   278: invokevirtual 490	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   281: astore 10
    //   283: lconst_0
    //   284: lstore 7
    //   286: aload 19
    //   288: astore 14
    //   290: aload 10
    //   292: astore 13
    //   294: aload 9
    //   296: astore 12
    //   298: getstatic 20	vri:jdField_a_of_type_Int	I
    //   301: newarray byte
    //   303: astore 11
    //   305: aload 19
    //   307: astore 14
    //   309: aload 10
    //   311: astore 13
    //   313: aload 9
    //   315: astore 12
    //   317: new 492	java/io/ByteArrayOutputStream
    //   320: dup
    //   321: invokespecial 493	java/io/ByteArrayOutputStream:<init>	()V
    //   324: astore 20
    //   326: aload 19
    //   328: astore 14
    //   330: aload 10
    //   332: astore 13
    //   334: aload 9
    //   336: astore 12
    //   338: aload 10
    //   340: aload 11
    //   342: iconst_0
    //   343: getstatic 20	vri:jdField_a_of_type_Int	I
    //   346: invokevirtual 499	java/io/InputStream:read	([BII)I
    //   349: istore 4
    //   351: iload 4
    //   353: ifle +105 -> 458
    //   356: aload 19
    //   358: astore 14
    //   360: aload 10
    //   362: astore 13
    //   364: aload 9
    //   366: astore 12
    //   368: getstatic 23	vri:b	I
    //   371: istore_3
    //   372: lload 7
    //   374: iload_3
    //   375: i2l
    //   376: lcmp
    //   377: iflt +48 -> 425
    //   380: iconst_0
    //   381: istore 5
    //   383: iconst_0
    //   384: ifeq +11 -> 395
    //   387: new 473	java/lang/NullPointerException
    //   390: dup
    //   391: invokespecial 474	java/lang/NullPointerException:<init>	()V
    //   394: athrow
    //   395: aload 10
    //   397: ifnull +8 -> 405
    //   400: aload 10
    //   402: invokevirtual 502	java/io/InputStream:close	()V
    //   405: aload 9
    //   407: ifnull -267 -> 140
    //   410: aload 9
    //   412: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   415: iconst_0
    //   416: ireturn
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   422: goto -17 -> 405
    //   425: aload 19
    //   427: astore 14
    //   429: aload 10
    //   431: astore 13
    //   433: aload 9
    //   435: astore 12
    //   437: aload 20
    //   439: aload 11
    //   441: iconst_0
    //   442: iload 4
    //   444: invokevirtual 506	java/io/ByteArrayOutputStream:write	([BII)V
    //   447: lload 7
    //   449: iload 4
    //   451: i2l
    //   452: ladd
    //   453: lstore 7
    //   455: goto -129 -> 326
    //   458: aload 19
    //   460: astore 14
    //   462: aload 10
    //   464: astore 13
    //   466: aload 9
    //   468: astore 12
    //   470: aload_1
    //   471: getfield 438	bjuz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   474: astore 21
    //   476: aload 19
    //   478: astore 14
    //   480: aload 10
    //   482: astore 13
    //   484: aload 9
    //   486: astore 12
    //   488: new 508	java/io/File
    //   491: dup
    //   492: new 126	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   499: aload 21
    //   501: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc_w 510
    //   507: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokespecial 511	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: astore 15
    //   518: aload 19
    //   520: astore 14
    //   522: aload 10
    //   524: astore 13
    //   526: aload 9
    //   528: astore 12
    //   530: aload 15
    //   532: invokevirtual 514	java/io/File:getParent	()Ljava/lang/String;
    //   535: ifnull +47 -> 582
    //   538: aload 19
    //   540: astore 14
    //   542: aload 10
    //   544: astore 13
    //   546: aload 9
    //   548: astore 12
    //   550: aload 15
    //   552: invokevirtual 518	java/io/File:getParentFile	()Ljava/io/File;
    //   555: invokevirtual 521	java/io/File:exists	()Z
    //   558: ifne +24 -> 582
    //   561: aload 19
    //   563: astore 14
    //   565: aload 10
    //   567: astore 13
    //   569: aload 9
    //   571: astore 12
    //   573: aload 15
    //   575: invokevirtual 518	java/io/File:getParentFile	()Ljava/io/File;
    //   578: invokevirtual 524	java/io/File:mkdirs	()Z
    //   581: pop
    //   582: aload 19
    //   584: astore 14
    //   586: aload 10
    //   588: astore 13
    //   590: aload 9
    //   592: astore 12
    //   594: aload 15
    //   596: invokevirtual 521	java/io/File:exists	()Z
    //   599: ifeq +21 -> 620
    //   602: aload 19
    //   604: astore 14
    //   606: aload 10
    //   608: astore 13
    //   610: aload 9
    //   612: astore 12
    //   614: aload 15
    //   616: invokevirtual 527	java/io/File:delete	()Z
    //   619: pop
    //   620: aload 19
    //   622: astore 14
    //   624: aload 10
    //   626: astore 13
    //   628: aload 9
    //   630: astore 12
    //   632: aload 15
    //   634: invokevirtual 530	java/io/File:createNewFile	()Z
    //   637: pop
    //   638: aload 19
    //   640: astore 14
    //   642: aload 10
    //   644: astore 13
    //   646: aload 9
    //   648: astore 12
    //   650: new 532	java/io/FileOutputStream
    //   653: dup
    //   654: new 126	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   661: aload 21
    //   663: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc_w 510
    //   669: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokespecial 533	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   678: astore 11
    //   680: aload 11
    //   682: aload 20
    //   684: invokevirtual 537	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   687: invokevirtual 540	java/io/FileOutputStream:write	([B)V
    //   690: aload 11
    //   692: invokevirtual 543	java/io/FileOutputStream:flush	()V
    //   695: new 508	java/io/File
    //   698: dup
    //   699: aload 21
    //   701: invokespecial 511	java/io/File:<init>	(Ljava/lang/String;)V
    //   704: astore 14
    //   706: aload 14
    //   708: invokevirtual 521	java/io/File:exists	()Z
    //   711: ifeq +9 -> 720
    //   714: aload 14
    //   716: invokevirtual 527	java/io/File:delete	()Z
    //   719: pop
    //   720: aload 15
    //   722: aload 14
    //   724: invokevirtual 547	java/io/File:renameTo	(Ljava/io/File;)Z
    //   727: pop
    //   728: getstatic 18	vri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   731: iconst_1
    //   732: new 126	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   739: ldc 129
    //   741: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_2
    //   745: invokevirtual 137	vrd:a	()I
    //   748: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: ldc_w 549
    //   754: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: getfield 143	bjuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   761: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc_w 469
    //   767: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_1
    //   771: getfield 84	bjuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   774: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_1
    //   784: aload 9
    //   786: invokevirtual 552	java/net/HttpURLConnection:getLastModified	()J
    //   789: putfield 201	bjuz:jdField_c_of_type_Long	J
    //   792: iconst_1
    //   793: istore 5
    //   795: aload 11
    //   797: ifnull +8 -> 805
    //   800: aload 11
    //   802: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   805: aload 10
    //   807: ifnull +8 -> 815
    //   810: aload 10
    //   812: invokevirtual 502	java/io/InputStream:close	()V
    //   815: aload 9
    //   817: ifnull -677 -> 140
    //   820: aload 9
    //   822: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   825: iconst_1
    //   826: ireturn
    //   827: astore_1
    //   828: aload_1
    //   829: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   832: goto -17 -> 815
    //   835: astore 12
    //   837: aconst_null
    //   838: astore 10
    //   840: aconst_null
    //   841: astore 13
    //   843: aload 9
    //   845: astore 11
    //   847: aload 13
    //   849: astore 9
    //   851: aload 17
    //   853: astore 13
    //   855: aload 16
    //   857: astore 14
    //   859: getstatic 18	vri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   862: iconst_1
    //   863: new 126	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   870: ldc 129
    //   872: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload_2
    //   876: invokevirtual 137	vrd:a	()I
    //   879: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: ldc_w 555
    //   885: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload_1
    //   889: getfield 143	bjuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   892: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc_w 557
    //   898: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload 12
    //   903: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 560	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aload 13
    //   914: ifnull +17 -> 931
    //   917: aload 13
    //   919: invokevirtual 521	java/io/File:exists	()Z
    //   922: ifeq +9 -> 931
    //   925: aload 13
    //   927: invokevirtual 527	java/io/File:delete	()Z
    //   930: pop
    //   931: aload 14
    //   933: ifnull +17 -> 950
    //   936: aload 14
    //   938: invokevirtual 521	java/io/File:exists	()Z
    //   941: ifeq +9 -> 950
    //   944: aload 14
    //   946: invokevirtual 527	java/io/File:delete	()Z
    //   949: pop
    //   950: aload 9
    //   952: ifnull +8 -> 960
    //   955: aload 9
    //   957: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   960: aload 10
    //   962: ifnull +8 -> 970
    //   965: aload 10
    //   967: invokevirtual 502	java/io/InputStream:close	()V
    //   970: aload 11
    //   972: ifnull +8 -> 980
    //   975: aload 11
    //   977: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   980: iconst_0
    //   981: ireturn
    //   982: astore_1
    //   983: aload_1
    //   984: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   987: goto -17 -> 970
    //   990: astore 11
    //   992: aconst_null
    //   993: astore 10
    //   995: aconst_null
    //   996: astore 9
    //   998: aload 18
    //   1000: astore 15
    //   1002: aload 15
    //   1004: astore 14
    //   1006: aload 10
    //   1008: astore 13
    //   1010: aload 9
    //   1012: astore 12
    //   1014: getstatic 18	vri:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1017: iconst_1
    //   1018: new 126	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1025: ldc 129
    //   1027: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload_2
    //   1031: invokevirtual 137	vrd:a	()I
    //   1034: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1037: ldc_w 555
    //   1040: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload_1
    //   1044: getfield 143	bjuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1047: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc_w 562
    //   1053: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 11
    //   1058: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 560	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: iconst_0
    //   1068: istore 5
    //   1070: aload 15
    //   1072: ifnull +8 -> 1080
    //   1075: aload 15
    //   1077: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   1080: aload 10
    //   1082: ifnull +8 -> 1090
    //   1085: aload 10
    //   1087: invokevirtual 502	java/io/InputStream:close	()V
    //   1090: aload 9
    //   1092: ifnull -952 -> 140
    //   1095: aload 9
    //   1097: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   1100: iconst_0
    //   1101: ireturn
    //   1102: astore_1
    //   1103: aload_1
    //   1104: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   1107: goto -17 -> 1090
    //   1110: astore_1
    //   1111: aconst_null
    //   1112: astore 10
    //   1114: aconst_null
    //   1115: astore 9
    //   1117: aload 11
    //   1119: astore_2
    //   1120: aload_2
    //   1121: ifnull +7 -> 1128
    //   1124: aload_2
    //   1125: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   1128: aload 10
    //   1130: ifnull +8 -> 1138
    //   1133: aload 10
    //   1135: invokevirtual 502	java/io/InputStream:close	()V
    //   1138: aload 9
    //   1140: ifnull +8 -> 1148
    //   1143: aload 9
    //   1145: invokevirtual 306	java/net/HttpURLConnection:disconnect	()V
    //   1148: aload_1
    //   1149: athrow
    //   1150: astore_2
    //   1151: aload_2
    //   1152: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   1155: goto -17 -> 1138
    //   1158: astore_1
    //   1159: aconst_null
    //   1160: astore 10
    //   1162: aload 11
    //   1164: astore_2
    //   1165: goto -45 -> 1120
    //   1168: astore_1
    //   1169: aload 14
    //   1171: astore_2
    //   1172: aload 13
    //   1174: astore 10
    //   1176: aload 12
    //   1178: astore 9
    //   1180: goto -60 -> 1120
    //   1183: astore_1
    //   1184: aload 11
    //   1186: astore_2
    //   1187: goto -67 -> 1120
    //   1190: astore_1
    //   1191: aload 9
    //   1193: astore_2
    //   1194: aload 11
    //   1196: astore 9
    //   1198: goto -78 -> 1120
    //   1201: astore 11
    //   1203: aconst_null
    //   1204: astore 10
    //   1206: aload 18
    //   1208: astore 15
    //   1210: goto -208 -> 1002
    //   1213: astore 11
    //   1215: aload 18
    //   1217: astore 15
    //   1219: goto -217 -> 1002
    //   1222: astore 12
    //   1224: aload 11
    //   1226: astore 15
    //   1228: aload 12
    //   1230: astore 11
    //   1232: goto -230 -> 1002
    //   1235: astore 12
    //   1237: aload 9
    //   1239: astore 11
    //   1241: aconst_null
    //   1242: astore 9
    //   1244: aconst_null
    //   1245: astore 10
    //   1247: aload 16
    //   1249: astore 14
    //   1251: aload 17
    //   1253: astore 13
    //   1255: goto -396 -> 859
    //   1258: astore 12
    //   1260: aconst_null
    //   1261: astore 15
    //   1263: aload 9
    //   1265: astore 11
    //   1267: aload 16
    //   1269: astore 14
    //   1271: aload 17
    //   1273: astore 13
    //   1275: aload 15
    //   1277: astore 9
    //   1279: goto -420 -> 859
    //   1282: astore 12
    //   1284: aload 15
    //   1286: astore 13
    //   1288: aload 9
    //   1290: astore 11
    //   1292: aconst_null
    //   1293: astore 9
    //   1295: aload 16
    //   1297: astore 14
    //   1299: goto -440 -> 859
    //   1302: astore 12
    //   1304: aload 15
    //   1306: astore 13
    //   1308: aload 11
    //   1310: astore 15
    //   1312: aload 9
    //   1314: astore 11
    //   1316: aload 16
    //   1318: astore 14
    //   1320: aload 15
    //   1322: astore 9
    //   1324: goto -465 -> 859
    //   1327: astore 12
    //   1329: aload 15
    //   1331: astore 13
    //   1333: aload 11
    //   1335: astore 15
    //   1337: aload 9
    //   1339: astore 11
    //   1341: aload 15
    //   1343: astore 9
    //   1345: goto -486 -> 859
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1348	0	this	vri
    //   0	1348	1	parambjuz	bjuz
    //   0	1348	2	paramvrd	vrd
    //   371	4	3	i	int
    //   349	101	4	j	int
    //   124	945	5	bool1	boolean
    //   96	41	6	bool2	boolean
    //   157	297	7	l	long
    //   1	1343	9	localObject1	Object
    //   23	1223	10	localObject2	Object
    //   4	972	11	localObject3	Object
    //   990	205	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1201	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1213	12	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1230	110	11	localObject4	Object
    //   296	353	12	localObject5	Object
    //   835	67	12	localException1	Exception
    //   1012	165	12	localObject6	Object
    //   1222	7	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1235	1	12	localException2	Exception
    //   1258	1	12	localException3	Exception
    //   1282	1	12	localException4	Exception
    //   1302	1	12	localException5	Exception
    //   1327	1	12	localException6	Exception
    //   292	1040	13	localObject7	Object
    //   288	1031	14	localObject8	Object
    //   516	826	15	localObject9	Object
    //   16	1301	16	localObject10	Object
    //   13	1259	17	localObject11	Object
    //   10	1206	18	localObject12	Object
    //   7	632	19	localObject13	Object
    //   324	359	20	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   474	226	21	str	String
    // Exception table:
    //   from	to	target	type
    //   102	110	143	java/lang/Exception
    //   114	122	143	java/lang/Exception
    //   236	244	268	java/lang/Exception
    //   248	256	268	java/lang/Exception
    //   387	395	417	java/lang/Exception
    //   400	405	417	java/lang/Exception
    //   800	805	827	java/lang/Exception
    //   810	815	827	java/lang/Exception
    //   18	25	835	java/lang/Exception
    //   955	960	982	java/lang/Exception
    //   965	970	982	java/lang/Exception
    //   18	25	990	java/lang/OutOfMemoryError
    //   1075	1080	1102	java/lang/Exception
    //   1085	1090	1102	java/lang/Exception
    //   18	25	1110	finally
    //   1124	1128	1150	java/lang/Exception
    //   1133	1138	1150	java/lang/Exception
    //   34	95	1158	finally
    //   151	229	1158	finally
    //   276	283	1158	finally
    //   298	305	1168	finally
    //   317	326	1168	finally
    //   338	351	1168	finally
    //   368	372	1168	finally
    //   437	447	1168	finally
    //   470	476	1168	finally
    //   488	518	1168	finally
    //   530	538	1168	finally
    //   550	561	1168	finally
    //   573	582	1168	finally
    //   594	602	1168	finally
    //   614	620	1168	finally
    //   632	638	1168	finally
    //   650	680	1168	finally
    //   1014	1067	1168	finally
    //   680	706	1183	finally
    //   706	720	1183	finally
    //   720	792	1183	finally
    //   859	912	1190	finally
    //   917	931	1190	finally
    //   936	950	1190	finally
    //   34	95	1201	java/lang/OutOfMemoryError
    //   151	229	1201	java/lang/OutOfMemoryError
    //   276	283	1201	java/lang/OutOfMemoryError
    //   298	305	1213	java/lang/OutOfMemoryError
    //   317	326	1213	java/lang/OutOfMemoryError
    //   338	351	1213	java/lang/OutOfMemoryError
    //   368	372	1213	java/lang/OutOfMemoryError
    //   437	447	1213	java/lang/OutOfMemoryError
    //   470	476	1213	java/lang/OutOfMemoryError
    //   488	518	1213	java/lang/OutOfMemoryError
    //   530	538	1213	java/lang/OutOfMemoryError
    //   550	561	1213	java/lang/OutOfMemoryError
    //   573	582	1213	java/lang/OutOfMemoryError
    //   594	602	1213	java/lang/OutOfMemoryError
    //   614	620	1213	java/lang/OutOfMemoryError
    //   632	638	1213	java/lang/OutOfMemoryError
    //   650	680	1213	java/lang/OutOfMemoryError
    //   680	706	1222	java/lang/OutOfMemoryError
    //   706	720	1222	java/lang/OutOfMemoryError
    //   720	792	1222	java/lang/OutOfMemoryError
    //   34	95	1235	java/lang/Exception
    //   151	229	1235	java/lang/Exception
    //   276	283	1235	java/lang/Exception
    //   298	305	1258	java/lang/Exception
    //   317	326	1258	java/lang/Exception
    //   338	351	1258	java/lang/Exception
    //   368	372	1258	java/lang/Exception
    //   437	447	1258	java/lang/Exception
    //   470	476	1258	java/lang/Exception
    //   488	518	1258	java/lang/Exception
    //   530	538	1282	java/lang/Exception
    //   550	561	1282	java/lang/Exception
    //   573	582	1282	java/lang/Exception
    //   594	602	1282	java/lang/Exception
    //   614	620	1282	java/lang/Exception
    //   632	638	1282	java/lang/Exception
    //   650	680	1282	java/lang/Exception
    //   680	706	1302	java/lang/Exception
    //   706	720	1327	java/lang/Exception
    //   720	792	1327	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vri
 * JD-Core Version:    0.7.0.1
 */