import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.1;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class ahch
{
  public static Bitmap C(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject3 = new DisplayMetrics();
      ((DisplayMetrics)localObject3).setToDefaults();
      localObject1 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE }).invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
      localObject1 = (ApplicationInfo)localObject1.getClass().getDeclaredField("applicationInfo").get(localObject1);
      localObject3 = Class.forName("android.content.res.AssetManager");
      localObject2 = ((Class)localObject3).newInstance();
      ((Class)localObject3).getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = BaseApplication.getContext().getResources();
      paramString = (Resources)Resources.class.getConstructor(new Class[] { localObject2.getClass(), paramString.getDisplayMetrics().getClass(), paramString.getConfiguration().getClass() }).newInstance(new Object[] { localObject2, paramString.getDisplayMetrics(), paramString.getConfiguration() });
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).icon != 0))
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void JQ(String paramString)
  {
    fV(paramString, null);
  }
  
  public static int K(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    try
    {
      if (!new File(paramString1).exists())
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. file is not exsited. PH:" + paramString1);
        return -2;
      }
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).hookAM4Install();
      paramString1 = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), paramString1);
      paramString1.putExtra("big_brother_source_key", paramString2);
      BaseApplication.getContext().startActivity(paramString1);
      return 0;
    }
    catch (Exception paramString1)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. Exception 2");
      paramString1.printStackTrace();
    }
    return -3;
  }
  
  /* Error */
  public static ahch.a a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aconst_null
    //   3: astore 12
    //   5: ldc 218
    //   7: astore 10
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: invokevirtual 222	java/lang/String:length	()I
    //   17: iconst_1
    //   18: if_icmpge +13 -> 31
    //   21: new 6	ahch$a
    //   24: dup
    //   25: aconst_null
    //   26: lconst_0
    //   27: invokespecial 225	ahch$a:<init>	(Ljava/lang/String;J)V
    //   30: areturn
    //   31: new 227	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 228	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 232	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 234	java/net/HttpURLConnection
    //   45: astore 11
    //   47: lload_1
    //   48: lstore_3
    //   49: aload 10
    //   51: astore 12
    //   53: lload_1
    //   54: lstore 5
    //   56: aload 10
    //   58: astore 13
    //   60: lload_1
    //   61: lstore 7
    //   63: aload 10
    //   65: astore 14
    //   67: aload 11
    //   69: ldc 236
    //   71: ldc 238
    //   73: invokevirtual 241	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_1
    //   77: lstore_3
    //   78: aload 10
    //   80: astore 12
    //   82: lload_1
    //   83: lstore 5
    //   85: aload 10
    //   87: astore 13
    //   89: lload_1
    //   90: lstore 7
    //   92: aload 10
    //   94: astore 14
    //   96: aload 11
    //   98: ldc 243
    //   100: ldc 238
    //   102: invokevirtual 241	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: lload_1
    //   106: lstore_3
    //   107: aload 10
    //   109: astore 12
    //   111: lload_1
    //   112: lstore 5
    //   114: aload 10
    //   116: astore 13
    //   118: lload_1
    //   119: lstore 7
    //   121: aload 10
    //   123: astore 14
    //   125: aload 11
    //   127: ldc 236
    //   129: ldc 238
    //   131: invokevirtual 241	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: lload_1
    //   135: lstore_3
    //   136: aload 10
    //   138: astore 12
    //   140: lload_1
    //   141: lstore 5
    //   143: aload 10
    //   145: astore 13
    //   147: lload_1
    //   148: lstore 7
    //   150: aload 10
    //   152: astore 14
    //   154: aload 11
    //   156: ldc 243
    //   158: ldc 238
    //   160: invokevirtual 241	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: lload_1
    //   164: lstore_3
    //   165: aload 10
    //   167: astore 12
    //   169: lload_1
    //   170: lstore 5
    //   172: aload 10
    //   174: astore 13
    //   176: lload_1
    //   177: lstore 7
    //   179: aload 10
    //   181: astore 14
    //   183: aload 11
    //   185: invokevirtual 246	java/net/HttpURLConnection:connect	()V
    //   188: lload_1
    //   189: lstore_3
    //   190: aload 10
    //   192: astore 12
    //   194: lload_1
    //   195: lstore 5
    //   197: aload 10
    //   199: astore 13
    //   201: lload_1
    //   202: lstore 7
    //   204: aload 10
    //   206: astore 14
    //   208: aload 11
    //   210: invokevirtual 249	java/net/HttpURLConnection:getResponseCode	()I
    //   213: pop
    //   214: lload_1
    //   215: lstore_3
    //   216: aload 10
    //   218: astore 12
    //   220: lload_1
    //   221: lstore 5
    //   223: aload 10
    //   225: astore 13
    //   227: lload_1
    //   228: lstore 7
    //   230: aload 10
    //   232: astore 14
    //   234: aload 11
    //   236: invokevirtual 253	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   239: astore 16
    //   241: lload_1
    //   242: lstore_3
    //   243: aload 10
    //   245: astore 12
    //   247: lload_1
    //   248: lstore 5
    //   250: aload 10
    //   252: astore 13
    //   254: lload_1
    //   255: lstore 7
    //   257: aload 10
    //   259: astore 14
    //   261: ldc 255
    //   263: iconst_1
    //   264: new 168	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 257
    //   274: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 16
    //   279: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: lload_1
    //   289: lstore_3
    //   290: aload 10
    //   292: astore 12
    //   294: lload_1
    //   295: lstore 5
    //   297: aload 10
    //   299: astore 13
    //   301: lload_1
    //   302: lstore 7
    //   304: aload 10
    //   306: astore 14
    //   308: aload 11
    //   310: invokevirtual 263	java/net/HttpURLConnection:getContentLength	()I
    //   313: i2l
    //   314: lstore_1
    //   315: lload_1
    //   316: lstore_3
    //   317: aload 10
    //   319: astore 12
    //   321: lload_1
    //   322: lstore 5
    //   324: aload 10
    //   326: astore 13
    //   328: lload_1
    //   329: lstore 7
    //   331: aload 10
    //   333: astore 14
    //   335: aload 11
    //   337: invokestatic 266	ahch:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   340: astore 15
    //   342: aload 15
    //   344: astore 10
    //   346: lload_1
    //   347: lstore_3
    //   348: aload 15
    //   350: astore 12
    //   352: lload_1
    //   353: lstore 5
    //   355: aload 15
    //   357: astore 13
    //   359: lload_1
    //   360: lstore 7
    //   362: aload 15
    //   364: astore 14
    //   366: aload 15
    //   368: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifeq +39 -> 410
    //   374: aload 15
    //   376: astore 10
    //   378: aload 16
    //   380: ifnull +30 -> 410
    //   383: lload_1
    //   384: lstore_3
    //   385: aload 15
    //   387: astore 12
    //   389: lload_1
    //   390: lstore 5
    //   392: aload 15
    //   394: astore 13
    //   396: lload_1
    //   397: lstore 7
    //   399: aload 15
    //   401: astore 14
    //   403: aload 16
    //   405: invokevirtual 275	java/net/URL:getFile	()Ljava/lang/String;
    //   408: astore 10
    //   410: aload 10
    //   412: ifnull +418 -> 830
    //   415: lload_1
    //   416: lstore_3
    //   417: aload 10
    //   419: astore 12
    //   421: lload_1
    //   422: lstore 5
    //   424: aload 10
    //   426: astore 13
    //   428: lload_1
    //   429: lstore 7
    //   431: aload 10
    //   433: astore 14
    //   435: aload 10
    //   437: ldc_w 277
    //   440: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   443: ifne +38 -> 481
    //   446: lload_1
    //   447: lstore_3
    //   448: aload 10
    //   450: astore 12
    //   452: lload_1
    //   453: lstore 5
    //   455: aload 10
    //   457: astore 13
    //   459: lload_1
    //   460: lstore 7
    //   462: aload 10
    //   464: astore 14
    //   466: aload 10
    //   468: ldc_w 282
    //   471: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   474: istore 9
    //   476: iload 9
    //   478: ifeq +352 -> 830
    //   481: aconst_null
    //   482: astore 10
    //   484: aload 11
    //   486: ifnull +341 -> 827
    //   489: aload 11
    //   491: invokevirtual 285	java/net/HttpURLConnection:disconnect	()V
    //   494: ldc 218
    //   496: astore 12
    //   498: aload 12
    //   500: astore 11
    //   502: aload_0
    //   503: invokestatic 291	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   506: astore 13
    //   508: aload 12
    //   510: astore_0
    //   511: aload 13
    //   513: ifnull +61 -> 574
    //   516: aload 12
    //   518: astore 11
    //   520: aload 13
    //   522: invokevirtual 294	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   525: astore 12
    //   527: aload 12
    //   529: astore_0
    //   530: aload 12
    //   532: ifnull +42 -> 574
    //   535: aload 12
    //   537: astore 11
    //   539: aload 12
    //   541: ldc_w 277
    //   544: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   547: ifne +25 -> 572
    //   550: aload 12
    //   552: astore 11
    //   554: aload 12
    //   556: ldc_w 282
    //   559: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   562: istore 9
    //   564: aload 12
    //   566: astore_0
    //   567: iload 9
    //   569: ifeq +5 -> 574
    //   572: aconst_null
    //   573: astore_0
    //   574: aload 10
    //   576: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   579: ifne +177 -> 756
    //   582: new 6	ahch$a
    //   585: dup
    //   586: aload 10
    //   588: lload_1
    //   589: invokespecial 225	ahch$a:<init>	(Ljava/lang/String;J)V
    //   592: areturn
    //   593: astore 13
    //   595: lconst_0
    //   596: lstore_3
    //   597: ldc 218
    //   599: astore 11
    //   601: aconst_null
    //   602: astore 12
    //   604: aload 12
    //   606: astore 10
    //   608: aload 13
    //   610: invokevirtual 295	java/net/MalformedURLException:printStackTrace	()V
    //   613: lload_3
    //   614: lstore_1
    //   615: aload 11
    //   617: astore 10
    //   619: aload 12
    //   621: ifnull -127 -> 494
    //   624: aload 12
    //   626: invokevirtual 285	java/net/HttpURLConnection:disconnect	()V
    //   629: lload_3
    //   630: lstore_1
    //   631: aload 11
    //   633: astore 10
    //   635: goto -141 -> 494
    //   638: astore 13
    //   640: lconst_0
    //   641: lstore_3
    //   642: ldc 218
    //   644: astore 11
    //   646: aconst_null
    //   647: astore 12
    //   649: aload 12
    //   651: astore 10
    //   653: aload 13
    //   655: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   658: lload_3
    //   659: lstore_1
    //   660: aload 11
    //   662: astore 10
    //   664: aload 12
    //   666: ifnull -172 -> 494
    //   669: aload 12
    //   671: invokevirtual 285	java/net/HttpURLConnection:disconnect	()V
    //   674: lload_3
    //   675: lstore_1
    //   676: aload 11
    //   678: astore 10
    //   680: goto -186 -> 494
    //   683: astore 13
    //   685: lconst_0
    //   686: lstore_3
    //   687: ldc 218
    //   689: astore 11
    //   691: aconst_null
    //   692: astore 12
    //   694: aload 12
    //   696: astore 10
    //   698: aload 13
    //   700: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   703: lload_3
    //   704: lstore_1
    //   705: aload 11
    //   707: astore 10
    //   709: aload 12
    //   711: ifnull -217 -> 494
    //   714: aload 12
    //   716: invokevirtual 285	java/net/HttpURLConnection:disconnect	()V
    //   719: lload_3
    //   720: lstore_1
    //   721: aload 11
    //   723: astore 10
    //   725: goto -231 -> 494
    //   728: astore_0
    //   729: aload 12
    //   731: astore 10
    //   733: aload 10
    //   735: ifnull +8 -> 743
    //   738: aload 10
    //   740: invokevirtual 285	java/net/HttpURLConnection:disconnect	()V
    //   743: aload_0
    //   744: athrow
    //   745: astore_0
    //   746: aload_0
    //   747: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   750: aload 11
    //   752: astore_0
    //   753: goto -179 -> 574
    //   756: aload_0
    //   757: astore 10
    //   759: goto -177 -> 582
    //   762: astore_0
    //   763: aload 11
    //   765: astore 10
    //   767: goto -34 -> 733
    //   770: astore_0
    //   771: goto -38 -> 733
    //   774: astore 13
    //   776: aload 12
    //   778: astore 10
    //   780: aload 11
    //   782: astore 12
    //   784: aload 10
    //   786: astore 11
    //   788: goto -94 -> 694
    //   791: astore 10
    //   793: lload 5
    //   795: lstore_3
    //   796: aload 11
    //   798: astore 12
    //   800: aload 13
    //   802: astore 11
    //   804: aload 10
    //   806: astore 13
    //   808: goto -159 -> 649
    //   811: astore 13
    //   813: lload 7
    //   815: lstore_3
    //   816: aload 11
    //   818: astore 12
    //   820: aload 14
    //   822: astore 11
    //   824: goto -220 -> 604
    //   827: goto -333 -> 494
    //   830: goto -346 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	paramString	String
    //   1	720	1	l1	long
    //   48	768	3	l2	long
    //   54	740	5	l3	long
    //   61	753	7	l4	long
    //   474	94	9	bool	boolean
    //   7	778	10	localObject1	Object
    //   791	14	10	localIOException1	java.io.IOException
    //   45	778	11	localObject2	Object
    //   3	816	12	localObject3	Object
    //   58	463	13	localObject4	Object
    //   593	16	13	localMalformedURLException1	java.net.MalformedURLException
    //   638	16	13	localIOException2	java.io.IOException
    //   683	16	13	localException1	Exception
    //   774	27	13	localException2	Exception
    //   806	1	13	localIOException3	java.io.IOException
    //   811	1	13	localMalformedURLException2	java.net.MalformedURLException
    //   65	756	14	localObject5	Object
    //   340	60	15	str	String
    //   239	165	16	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   31	47	593	java/net/MalformedURLException
    //   31	47	638	java/io/IOException
    //   31	47	683	java/lang/Exception
    //   31	47	728	finally
    //   502	508	745	java/lang/Exception
    //   520	527	745	java/lang/Exception
    //   539	550	745	java/lang/Exception
    //   554	564	745	java/lang/Exception
    //   67	76	762	finally
    //   96	105	762	finally
    //   125	134	762	finally
    //   154	163	762	finally
    //   183	188	762	finally
    //   208	214	762	finally
    //   234	241	762	finally
    //   261	288	762	finally
    //   308	315	762	finally
    //   335	342	762	finally
    //   366	374	762	finally
    //   403	410	762	finally
    //   435	446	762	finally
    //   466	476	762	finally
    //   608	613	770	finally
    //   653	658	770	finally
    //   698	703	770	finally
    //   67	76	774	java/lang/Exception
    //   96	105	774	java/lang/Exception
    //   125	134	774	java/lang/Exception
    //   154	163	774	java/lang/Exception
    //   183	188	774	java/lang/Exception
    //   208	214	774	java/lang/Exception
    //   234	241	774	java/lang/Exception
    //   261	288	774	java/lang/Exception
    //   308	315	774	java/lang/Exception
    //   335	342	774	java/lang/Exception
    //   366	374	774	java/lang/Exception
    //   403	410	774	java/lang/Exception
    //   435	446	774	java/lang/Exception
    //   466	476	774	java/lang/Exception
    //   67	76	791	java/io/IOException
    //   96	105	791	java/io/IOException
    //   125	134	791	java/io/IOException
    //   154	163	791	java/io/IOException
    //   183	188	791	java/io/IOException
    //   208	214	791	java/io/IOException
    //   234	241	791	java/io/IOException
    //   261	288	791	java/io/IOException
    //   308	315	791	java/io/IOException
    //   335	342	791	java/io/IOException
    //   366	374	791	java/io/IOException
    //   403	410	791	java/io/IOException
    //   435	446	791	java/io/IOException
    //   466	476	791	java/io/IOException
    //   67	76	811	java/net/MalformedURLException
    //   96	105	811	java/net/MalformedURLException
    //   125	134	811	java/net/MalformedURLException
    //   154	163	811	java/net/MalformedURLException
    //   183	188	811	java/net/MalformedURLException
    //   208	214	811	java/net/MalformedURLException
    //   234	241	811	java/net/MalformedURLException
    //   261	288	811	java/net/MalformedURLException
    //   308	315	811	java/net/MalformedURLException
    //   335	342	811	java/net/MalformedURLException
    //   366	374	811	java/net/MalformedURLException
    //   403	410	811	java/net/MalformedURLException
    //   435	446	811	java/net/MalformedURLException
    //   466	476	811	java/net/MalformedURLException
  }
  
  public static void a(String paramString, ahch.b paramb)
  {
    ahav.a.getExecutor().execute(new UniformDownloadUtil.2(paramString, paramb));
  }
  
  public static void a(String paramString, ahch.c paramc)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadUtil.1(paramString, paramc));
  }
  
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject4;
    for (;;)
    {
      Object localObject2;
      try
      {
        paramHttpURLConnection = URLDecoder.decode(new String(paramHttpURLConnection.getHeaderField("Content-Disposition").getBytes("ISO-8859-1"), "utf-8"), "utf-8");
        localObject2 = localObject5;
        if (paramHttpURLConnection != null)
        {
          localObject1 = localObject4;
          String str = URLDecoder.decode(new String(paramHttpURLConnection.getBytes("ISO-8859-1"), "utf-8"), "utf-8");
          localObject2 = localObject5;
          if (str != null)
          {
            localObject1 = localObject4;
            int j = str.indexOf("filename=");
            int i = j;
            if (-1 == j)
            {
              localObject1 = localObject4;
              i = str.indexOf("FileName=");
            }
            paramHttpURLConnection = localObject3;
            if (-1 != i)
            {
              localObject1 = localObject4;
              localObject2 = str.substring(i + "filename=".length(), str.length());
              paramHttpURLConnection = localObject3;
              if (localObject2 != null)
              {
                localObject1 = localObject4;
                i = ((String)localObject2).indexOf(";");
                if (-1 == i) {
                  continue;
                }
                localObject1 = localObject4;
                paramHttpURLConnection = ((String)localObject2).substring(0, i - 1);
              }
            }
            localObject2 = paramHttpURLConnection;
            localObject1 = paramHttpURLConnection;
            if (!TextUtils.isEmpty(paramHttpURLConnection))
            {
              localObject1 = paramHttpURLConnection;
              i = paramHttpURLConnection.indexOf("\"");
              localObject1 = paramHttpURLConnection;
              j = paramHttpURLConnection.lastIndexOf("\"");
              localObject2 = paramHttpURLConnection;
              if (i == 0)
              {
                localObject2 = paramHttpURLConnection;
                localObject1 = paramHttpURLConnection;
                if (j + 1 == paramHttpURLConnection.length())
                {
                  localObject1 = paramHttpURLConnection;
                  paramHttpURLConnection = paramHttpURLConnection.substring(1);
                }
              }
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramHttpURLConnection) {}
      try
      {
        localObject2 = paramHttpURLConnection.substring(0, paramHttpURLConnection.length() - 1);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localObject1 = paramHttpURLConnection;
          paramHttpURLConnection = localUnsupportedEncodingException;
        }
      }
      paramHttpURLConnection = (HttpURLConnection)localObject2;
    }
    paramHttpURLConnection.printStackTrace();
    return localObject1;
  }
  
  public static int dh(String paramString)
  {
    return K(paramString, null);
  }
  
  public static void fV(String paramString1, String paramString2)
  {
    a(paramString1, new ahci(paramString1, paramString2));
  }
  
  public static void fW(String paramString1, String paramString2)
  {
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString1);
    if ((paramString1 == null) || (!ahbj.isFileExists(paramString1)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString1);
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = aopl.F(localBaseApplication, paramString1);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramString2);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString1)), str);
    try
    {
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + paramString1);
    }
  }
  
  public static String lh(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (localObject == null) {
          break label89;
        }
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
        if (localObject != null) {
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
        paramString.printStackTrace();
        return null;
      }
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + paramString);
      return null;
      label89:
      Object localObject = null;
    }
  }
  
  public static boolean mJ(String paramString)
  {
    return (paramString != null) && (ahbj.getExtension(paramString).equalsIgnoreCase(".apk"));
  }
  
  public static class a
  {
    public long aal;
    public String fName;
    
    public a(String paramString, long paramLong)
    {
      this.fName = paramString;
      this.aal = paramLong;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onResult(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void ai(String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahch
 * JD-Core Version:    0.7.0.1
 */