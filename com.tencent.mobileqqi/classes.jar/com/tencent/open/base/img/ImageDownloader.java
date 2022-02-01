package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ImageDownloader
{
  protected static int a = 0;
  protected static String a;
  protected static int b = 1048576;
  public static final int c = 1800000;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ImageDownloader";
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
  
  protected static HttpURLConnection a(ImageInfo paramImageInfo)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramImageInfo.jdField_b_of_type_JavaLangString;
        if (APNUtil.a(CommonDataAdapter.a().a()))
        {
          i = "http://".length();
          localObject3 = APNUtil.c(CommonDataAdapter.a().a());
          String str = APNUtil.d(CommonDataAdapter.a().a());
          j = ((String)localObject1).indexOf('/', i);
          if (j < 0)
          {
            localObject2 = ((String)localObject1).substring(i);
            localObject1 = "";
            LogUtility.c(jdField_a_of_type_JavaLangString, "http://" + (String)localObject3 + ":" + str + (String)localObject1);
            localObject3 = (HttpURLConnection)new URL("http://" + (String)localObject3 + ":" + str + (String)localObject1).openConnection();
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception paramImageInfo)
      {
        int j;
        Object localObject2;
        localObject3 = null;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- Exception!!!", paramImageInfo);
        a((HttpURLConnection)localObject3);
        return null;
      }
      try
      {
        ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
        localObject1 = localObject3;
        localObject3 = localObject1;
      }
      catch (Exception paramImageInfo)
      {
        localObject3 = localObject1;
        continue;
      }
      try
      {
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setConnectTimeout(60000);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setReadTimeout(120000);
        localObject3 = localObject1;
        if (paramImageInfo.jdField_c_of_type_Long > 0L)
        {
          localObject3 = localObject1;
          localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
          localObject3 = localObject1;
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(paramImageInfo.jdField_c_of_type_Long)));
        }
        localObject3 = localObject1;
        i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- reponseCode=" + i);
        if ((i == 302) || (i == 301))
        {
          localObject3 = localObject1;
          paramImageInfo = ((HttpURLConnection)localObject1).getHeaderField("Location");
          localObject3 = localObject1;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- loc=" + paramImageInfo);
          localObject3 = localObject1;
          a((HttpURLConnection)localObject1);
          paramImageInfo = null;
          localObject1 = paramImageInfo;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- uc=" + paramImageInfo);
          return paramImageInfo;
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
          break label738;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
          break label738;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text") == -1) {
          break label743;
        }
      }
      catch (Exception paramImageInfo)
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
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject2) * 1000L);
        localObject3 = localObject2;
        if (paramImageInfo.jdField_a_of_type_Long == 0L)
        {
          localObject3 = localObject2;
          paramImageInfo.jdField_a_of_type_Long = 86400000L;
        }
      }
      localObject3 = localObject2;
      paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      paramImageInfo = (ImageInfo)localObject2;
      continue;
      localObject3 = localObject1;
      localObject2 = ((String)localObject2).toLowerCase();
      continue;
      if (i == 304)
      {
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getimg-- " + paramImageInfo.jdField_b_of_type_JavaLangString + " not modified");
        localObject3 = localObject1;
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject1) * 1000L);
        localObject3 = localObject1;
        paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
      else
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
    }
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
      LogUtility.c("", "", paramHttpURLConnection);
    }
  }
  
  /* Error */
  public static boolean a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: invokestatic 269	com/tencent/open/base/img/ImageDownloader:a	(Lcom/tencent/open/base/img/ImageInfo;)Ljava/net/HttpURLConnection;
    //   13: astore 7
    //   15: aload 7
    //   17: ifnonnull +91 -> 108
    //   20: getstatic 17	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: new 111	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 271
    //   33: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 76	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 273
    //   46: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 126	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 275	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 276	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 275	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 276	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: iload 6
    //   81: istore 5
    //   83: aload 7
    //   85: ifnull +12 -> 97
    //   88: aload 7
    //   90: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   93: iload 6
    //   95: istore 5
    //   97: iload 5
    //   99: ireturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   105: goto -26 -> 79
    //   108: aload 7
    //   110: invokevirtual 282	java/net/HttpURLConnection:getContentLength	()I
    //   113: i2l
    //   114: lstore_3
    //   115: invokestatic 286	com/tencent/open/appcommon/Common:a	()J
    //   118: lload_3
    //   119: lcmp
    //   120: ifge +86 -> 206
    //   123: getstatic 17	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   126: new 111	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 271
    //   136: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: getfield 76	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 288
    //   149: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 126	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iconst_0
    //   159: ifeq +11 -> 170
    //   162: new 275	java/lang/NullPointerException
    //   165: dup
    //   166: invokespecial 276	java/lang/NullPointerException:<init>	()V
    //   169: athrow
    //   170: iconst_0
    //   171: ifeq +11 -> 182
    //   174: new 275	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 276	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: iload 6
    //   184: istore 5
    //   186: aload 7
    //   188: ifnull -91 -> 97
    //   191: aload 7
    //   193: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   203: goto -21 -> 182
    //   206: aload 7
    //   208: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   211: astore 8
    //   213: lconst_0
    //   214: lstore_3
    //   215: getstatic 19	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   218: newarray byte
    //   220: astore 9
    //   222: new 294	java/io/ByteArrayOutputStream
    //   225: dup
    //   226: invokespecial 295	java/io/ByteArrayOutputStream:<init>	()V
    //   229: astore 13
    //   231: aload 8
    //   233: aload 9
    //   235: iconst_0
    //   236: getstatic 19	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   239: invokevirtual 301	java/io/InputStream:read	([BII)I
    //   242: istore_1
    //   243: iload_1
    //   244: ifle +77 -> 321
    //   247: getstatic 22	com/tencent/open/base/img/ImageDownloader:b	I
    //   250: istore_2
    //   251: lload_3
    //   252: iload_2
    //   253: i2l
    //   254: lcmp
    //   255: iflt +49 -> 304
    //   258: iconst_0
    //   259: ifeq +11 -> 270
    //   262: new 275	java/lang/NullPointerException
    //   265: dup
    //   266: invokespecial 276	java/lang/NullPointerException:<init>	()V
    //   269: athrow
    //   270: aload 8
    //   272: ifnull +8 -> 280
    //   275: aload 8
    //   277: invokevirtual 304	java/io/InputStream:close	()V
    //   280: iload 6
    //   282: istore 5
    //   284: aload 7
    //   286: ifnull -189 -> 97
    //   289: aload 7
    //   291: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   301: goto -21 -> 280
    //   304: aload 13
    //   306: aload 9
    //   308: iconst_0
    //   309: iload_1
    //   310: invokevirtual 308	java/io/ByteArrayOutputStream:write	([BII)V
    //   313: lload_3
    //   314: iload_1
    //   315: i2l
    //   316: ladd
    //   317: lstore_3
    //   318: goto -87 -> 231
    //   321: new 111	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   328: invokestatic 310	com/tencent/open/appcommon/Common:b	()Ljava/lang/String;
    //   331: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: getstatic 313	com/tencent/open/base/img/ImageCache:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   337: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: getfield 315	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   344: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: getstatic 320	java/io/File:separator	Ljava/lang/String;
    //   350: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 76	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokestatic 324	com/tencent/open/base/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   360: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore 14
    //   368: new 317	java/io/File
    //   371: dup
    //   372: new 111	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   379: aload 14
    //   381: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 326
    //   387: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: astore 10
    //   398: aload 10
    //   400: invokevirtual 330	java/io/File:getParent	()Ljava/lang/String;
    //   403: ifnull +23 -> 426
    //   406: aload 10
    //   408: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   411: invokevirtual 338	java/io/File:exists	()Z
    //   414: ifne +12 -> 426
    //   417: aload 10
    //   419: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   422: invokevirtual 341	java/io/File:mkdirs	()Z
    //   425: pop
    //   426: aload 10
    //   428: invokevirtual 338	java/io/File:exists	()Z
    //   431: ifeq +9 -> 440
    //   434: aload 10
    //   436: invokevirtual 344	java/io/File:delete	()Z
    //   439: pop
    //   440: aload 10
    //   442: invokevirtual 347	java/io/File:createNewFile	()Z
    //   445: pop
    //   446: new 349	java/io/FileOutputStream
    //   449: dup
    //   450: new 111	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   457: aload 14
    //   459: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 326
    //   465: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokespecial 350	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   474: astore 9
    //   476: aload 9
    //   478: aload 13
    //   480: invokevirtual 354	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   483: invokevirtual 357	java/io/FileOutputStream:write	([B)V
    //   486: aload 9
    //   488: invokevirtual 360	java/io/FileOutputStream:flush	()V
    //   491: new 317	java/io/File
    //   494: dup
    //   495: aload 14
    //   497: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   500: astore 12
    //   502: aload 12
    //   504: invokevirtual 338	java/io/File:exists	()Z
    //   507: ifeq +9 -> 516
    //   510: aload 12
    //   512: invokevirtual 344	java/io/File:delete	()Z
    //   515: pop
    //   516: aload 10
    //   518: aload 12
    //   520: invokevirtual 364	java/io/File:renameTo	(Ljava/io/File;)Z
    //   523: pop
    //   524: ldc_w 366
    //   527: aload_0
    //   528: getfield 367	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   531: invokestatic 126	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_0
    //   535: aload 7
    //   537: invokevirtual 370	java/net/HttpURLConnection:getLastModified	()J
    //   540: putfield 164	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   543: iconst_1
    //   544: istore 5
    //   546: aload 9
    //   548: ifnull +8 -> 556
    //   551: aload 9
    //   553: invokevirtual 371	java/io/FileOutputStream:close	()V
    //   556: aload 8
    //   558: ifnull +8 -> 566
    //   561: aload 8
    //   563: invokevirtual 304	java/io/InputStream:close	()V
    //   566: aload 7
    //   568: ifnull -471 -> 97
    //   571: aload 7
    //   573: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   576: iconst_1
    //   577: ireturn
    //   578: astore_0
    //   579: aload_0
    //   580: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   583: goto -17 -> 566
    //   586: astore 9
    //   588: aconst_null
    //   589: astore 10
    //   591: aconst_null
    //   592: astore_0
    //   593: aconst_null
    //   594: astore 7
    //   596: aconst_null
    //   597: astore 8
    //   599: getstatic 17	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   602: ldc_w 373
    //   605: aload 9
    //   607: invokestatic 263	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   610: aload 10
    //   612: ifnull +17 -> 629
    //   615: aload 10
    //   617: invokevirtual 338	java/io/File:exists	()Z
    //   620: ifeq +9 -> 629
    //   623: aload 10
    //   625: invokevirtual 344	java/io/File:delete	()Z
    //   628: pop
    //   629: aload 11
    //   631: ifnull +17 -> 648
    //   634: aload 11
    //   636: invokevirtual 338	java/io/File:exists	()Z
    //   639: ifeq +9 -> 648
    //   642: aload 11
    //   644: invokevirtual 344	java/io/File:delete	()Z
    //   647: pop
    //   648: aload_0
    //   649: ifnull +7 -> 656
    //   652: aload_0
    //   653: invokevirtual 371	java/io/FileOutputStream:close	()V
    //   656: aload 7
    //   658: ifnull +8 -> 666
    //   661: aload 7
    //   663: invokevirtual 304	java/io/InputStream:close	()V
    //   666: iload 6
    //   668: istore 5
    //   670: aload 8
    //   672: ifnull -575 -> 97
    //   675: aload 8
    //   677: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   680: iconst_0
    //   681: ireturn
    //   682: astore_0
    //   683: aload_0
    //   684: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   687: goto -21 -> 666
    //   690: astore_0
    //   691: aconst_null
    //   692: astore 8
    //   694: aconst_null
    //   695: astore 7
    //   697: aload 12
    //   699: astore 9
    //   701: aload 9
    //   703: ifnull +8 -> 711
    //   706: aload 9
    //   708: invokevirtual 371	java/io/FileOutputStream:close	()V
    //   711: aload 8
    //   713: ifnull +8 -> 721
    //   716: aload 8
    //   718: invokevirtual 304	java/io/InputStream:close	()V
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 266	java/net/HttpURLConnection:disconnect	()V
    //   731: aload_0
    //   732: athrow
    //   733: astore 8
    //   735: aload 8
    //   737: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   740: goto -19 -> 721
    //   743: astore_0
    //   744: aconst_null
    //   745: astore 8
    //   747: aload 12
    //   749: astore 9
    //   751: goto -50 -> 701
    //   754: astore_0
    //   755: aload 12
    //   757: astore 9
    //   759: goto -58 -> 701
    //   762: astore_0
    //   763: goto -62 -> 701
    //   766: astore 11
    //   768: aload_0
    //   769: astore 9
    //   771: aload 8
    //   773: astore 10
    //   775: aload 11
    //   777: astore_0
    //   778: aload 7
    //   780: astore 8
    //   782: aload 10
    //   784: astore 7
    //   786: goto -85 -> 701
    //   789: astore 9
    //   791: aconst_null
    //   792: astore 10
    //   794: aconst_null
    //   795: astore_0
    //   796: aconst_null
    //   797: astore 12
    //   799: aload 7
    //   801: astore 8
    //   803: aload 12
    //   805: astore 7
    //   807: goto -208 -> 599
    //   810: astore 9
    //   812: aconst_null
    //   813: astore 10
    //   815: aconst_null
    //   816: astore_0
    //   817: aload 8
    //   819: astore 12
    //   821: aload 7
    //   823: astore 8
    //   825: aload 12
    //   827: astore 7
    //   829: goto -230 -> 599
    //   832: astore 9
    //   834: aload 8
    //   836: astore 12
    //   838: aconst_null
    //   839: astore_0
    //   840: aload 7
    //   842: astore 8
    //   844: aload 12
    //   846: astore 7
    //   848: goto -249 -> 599
    //   851: astore 13
    //   853: aload 9
    //   855: astore_0
    //   856: aload 7
    //   858: astore 12
    //   860: aload 13
    //   862: astore 9
    //   864: aload 8
    //   866: astore 7
    //   868: aload 12
    //   870: astore 8
    //   872: goto -273 -> 599
    //   875: astore 13
    //   877: aload 12
    //   879: astore 11
    //   881: aload 9
    //   883: astore_0
    //   884: aload 7
    //   886: astore 12
    //   888: aload 13
    //   890: astore 9
    //   892: aload 8
    //   894: astore 7
    //   896: aload 12
    //   898: astore 8
    //   900: goto -301 -> 599
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	paramImageInfo	ImageInfo
    //   242	73	1	i	int
    //   250	3	2	j	int
    //   114	204	3	l	long
    //   81	588	5	bool1	boolean
    //   7	660	6	bool2	boolean
    //   13	882	7	localObject1	Object
    //   211	506	8	localInputStream	java.io.InputStream
    //   733	3	8	localException1	Exception
    //   745	154	8	localObject2	Object
    //   220	332	9	localObject3	Object
    //   586	20	9	localException2	Exception
    //   699	71	9	localObject4	Object
    //   789	1	9	localException3	Exception
    //   810	1	9	localException4	Exception
    //   832	22	9	localException5	Exception
    //   862	29	9	localObject5	Object
    //   396	418	10	localObject6	Object
    //   4	639	11	localObject7	Object
    //   766	10	11	localObject8	Object
    //   879	1	11	localObject9	Object
    //   1	896	12	localObject10	Object
    //   229	250	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   851	10	13	localException6	Exception
    //   875	14	13	localException7	Exception
    //   366	130	14	str	String
    // Exception table:
    //   from	to	target	type
    //   59	67	100	java/lang/Exception
    //   71	79	100	java/lang/Exception
    //   162	170	198	java/lang/Exception
    //   174	182	198	java/lang/Exception
    //   262	270	296	java/lang/Exception
    //   275	280	296	java/lang/Exception
    //   551	556	578	java/lang/Exception
    //   561	566	578	java/lang/Exception
    //   9	15	586	java/lang/Exception
    //   652	656	682	java/lang/Exception
    //   661	666	682	java/lang/Exception
    //   9	15	690	finally
    //   706	711	733	java/lang/Exception
    //   716	721	733	java/lang/Exception
    //   20	55	743	finally
    //   108	158	743	finally
    //   206	213	743	finally
    //   215	231	754	finally
    //   231	243	754	finally
    //   247	251	754	finally
    //   304	313	754	finally
    //   321	398	754	finally
    //   398	426	754	finally
    //   426	440	754	finally
    //   440	476	754	finally
    //   476	502	762	finally
    //   502	516	762	finally
    //   516	543	762	finally
    //   599	610	766	finally
    //   615	629	766	finally
    //   634	648	766	finally
    //   20	55	789	java/lang/Exception
    //   108	158	789	java/lang/Exception
    //   206	213	789	java/lang/Exception
    //   215	231	810	java/lang/Exception
    //   231	243	810	java/lang/Exception
    //   247	251	810	java/lang/Exception
    //   304	313	810	java/lang/Exception
    //   321	398	810	java/lang/Exception
    //   398	426	832	java/lang/Exception
    //   426	440	832	java/lang/Exception
    //   440	476	832	java/lang/Exception
    //   476	502	851	java/lang/Exception
    //   502	516	875	java/lang/Exception
    //   516	543	875	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */