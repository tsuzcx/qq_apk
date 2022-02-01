import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.base.appreport.AppReport.1;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class arxu
{
  public static Lock mLock = new ReentrantLock();
  
  public static Bundle a(Context paramContext, Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramContext = new Bundle();
    paramContext.putString("platform", aroi.a().getPlatform());
    paramContext.putString("version", aroi.a().getVersionName());
    paramContext.putString("uin", paramString2);
    paramContext.putString("imei", arxr.getImei());
    paramContext.putString("imsi", arxr.getImsi());
    paramContext.putString("android_id", alla.getString(aroi.a().getContext().getContentResolver(), "android_id"));
    paramContext.putString("mac_addr", arxr.Dy());
    paramContext.putString("model_info", Build.MODEL);
    paramContext.putString("resolution", arxr.getResolution());
    paramContext.putString("keystr", aroi.a().getSkey());
    paramContext.putString("sid", aroi.a().getSkey());
    paramContext.putString("package", paramMap.values().toString());
    paramContext.putString("type", paramString1);
    return paramContext;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"");
    localStringBuilder.append("]");
    arwt.i("AppReport", "message to cgi: " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3)
  {
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new AppReport.1(paramString1, paramInt, paramContext, paramString2, paramWebView, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public static void aR(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    arwt.i("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      mLock.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        mLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        mLock.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        mLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        mLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  protected static String c(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, "");
  }
  
  public static void fP(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      mLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      mLock.unlock();
    }
  }
  
  public static void fQ(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      mLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      mLock.unlock();
    }
  }
  
  /* Error */
  public static Map<String, String> l(Context paramContext)
  {
    // Byte code:
    //   0: new 262	java/io/File
    //   3: dup
    //   4: new 118	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 266	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 184
    //   26: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 278	java/io/File:exists	()Z
    //   38: ifne +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: getstatic 18	arxu:mLock	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 182 1 0
    //   51: aload_0
    //   52: ldc 184
    //   54: invokevirtual 295	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   57: astore 4
    //   59: new 297	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 298	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 8
    //   83: aload 5
    //   85: astore 6
    //   87: aload 4
    //   89: astore 7
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 304	java/io/FileInputStream:read	([B)I
    //   98: istore_1
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpeq +64 -> 165
    //   104: aload 5
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: aload 5
    //   114: aload 8
    //   116: iconst_0
    //   117: iload_1
    //   118: invokevirtual 307	java/io/ByteArrayOutputStream:write	([BII)V
    //   121: goto -38 -> 83
    //   124: astore 6
    //   126: aload 5
    //   128: astore_0
    //   129: aload 6
    //   131: astore 5
    //   133: aload 5
    //   135: invokevirtual 215	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 308	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -108 -> 41
    //   152: aload_0
    //   153: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 5
    //   167: astore 6
    //   169: aload 4
    //   171: astore 7
    //   173: getstatic 18	arxu:mLock	Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 211 1 0
    //   181: aload 5
    //   183: astore 6
    //   185: aload 4
    //   187: astore 7
    //   189: new 195	java/lang/String
    //   192: dup
    //   193: aload 5
    //   195: invokevirtual 312	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: invokespecial 314	java/lang/String:<init>	([B)V
    //   201: invokevirtual 317	java/lang/String:trim	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload 5
    //   208: astore 6
    //   210: aload 4
    //   212: astore 7
    //   214: aload 8
    //   216: invokevirtual 321	java/lang/String:length	()I
    //   219: ifle +618 -> 837
    //   222: aload 5
    //   224: astore 6
    //   226: aload 4
    //   228: astore 7
    //   230: aload 8
    //   232: iconst_0
    //   233: aload 8
    //   235: invokevirtual 321	java/lang/String:length	()I
    //   238: iconst_1
    //   239: isub
    //   240: invokevirtual 325	java/lang/String:substring	(II)Ljava/lang/String;
    //   243: ldc 193
    //   245: invokevirtual 329	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   248: astore 8
    //   250: aload 5
    //   252: astore 6
    //   254: aload 4
    //   256: astore 7
    //   258: new 331	java/util/HashMap
    //   261: dup
    //   262: invokespecial 332	java/util/HashMap:<init>	()V
    //   265: astore 9
    //   267: aload 8
    //   269: ifnull +427 -> 696
    //   272: aload 5
    //   274: astore 6
    //   276: aload 4
    //   278: astore 7
    //   280: aload 8
    //   282: arraylength
    //   283: ifle +413 -> 696
    //   286: aload 5
    //   288: astore 6
    //   290: aload 4
    //   292: astore 7
    //   294: aload 8
    //   296: arraylength
    //   297: istore_2
    //   298: iconst_0
    //   299: istore_1
    //   300: iload_1
    //   301: iload_2
    //   302: if_icmpge +394 -> 696
    //   305: aload 5
    //   307: astore 6
    //   309: aload 4
    //   311: astore 7
    //   313: aload 8
    //   315: iload_1
    //   316: aaload
    //   317: ldc 191
    //   319: invokevirtual 329	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   322: astore 10
    //   324: aload 5
    //   326: astore 6
    //   328: aload 4
    //   330: astore 7
    //   332: aload 10
    //   334: iconst_1
    //   335: aaload
    //   336: invokestatic 338	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: istore_3
    //   340: iload_3
    //   341: bipush 8
    //   343: if_icmpne +38 -> 381
    //   346: aload 5
    //   348: astore 6
    //   350: aload 4
    //   352: astore 7
    //   354: aload 9
    //   356: aload 10
    //   358: iconst_0
    //   359: aaload
    //   360: aload 10
    //   362: iconst_0
    //   363: aaload
    //   364: iconst_0
    //   365: ldc_w 340
    //   368: iload_3
    //   369: invokestatic 342	arxu:c	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   372: invokeinterface 346 3 0
    //   377: pop
    //   378: goto +465 -> 843
    //   381: aload 5
    //   383: astore 6
    //   385: aload 4
    //   387: astore 7
    //   389: aload_0
    //   390: invokevirtual 350	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   393: aload 10
    //   395: iconst_0
    //   396: aaload
    //   397: iconst_0
    //   398: invokevirtual 356	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   401: astore 11
    //   403: aload 5
    //   405: astore 6
    //   407: aload 4
    //   409: astore 7
    //   411: aload 9
    //   413: aload 10
    //   415: iconst_0
    //   416: aaload
    //   417: aload 10
    //   419: iconst_0
    //   420: aaload
    //   421: aload 11
    //   423: getfield 362	android/content/pm/PackageInfo:versionCode	I
    //   426: aload 11
    //   428: getfield 365	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   431: iload_3
    //   432: aload_0
    //   433: aload 10
    //   435: iconst_0
    //   436: aaload
    //   437: invokestatic 371	arxn:aq	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   440: invokestatic 221	arxu:a	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   443: invokeinterface 346 3 0
    //   448: pop
    //   449: goto +394 -> 843
    //   452: astore 11
    //   454: aload 5
    //   456: astore 6
    //   458: aload 4
    //   460: astore 7
    //   462: ldc 138
    //   464: new 118	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 373
    //   474: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 10
    //   479: iconst_0
    //   480: aaload
    //   481: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 375
    //   487: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 11
    //   492: invokevirtual 376	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   495: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 379	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: goto +339 -> 843
    //   507: astore 6
    //   509: aload 5
    //   511: astore_0
    //   512: aload 6
    //   514: astore 5
    //   516: aload_0
    //   517: astore 6
    //   519: aload 4
    //   521: astore 7
    //   523: aload 5
    //   525: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   528: aload 4
    //   530: ifnull +8 -> 538
    //   533: aload 4
    //   535: invokevirtual 308	java/io/FileInputStream:close	()V
    //   538: aload_0
    //   539: ifnull -498 -> 41
    //   542: aload_0
    //   543: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
    //   546: aconst_null
    //   547: areturn
    //   548: astore_0
    //   549: aload_0
    //   550: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   553: aconst_null
    //   554: areturn
    //   555: astore 11
    //   557: aload 5
    //   559: astore 6
    //   561: aload 4
    //   563: astore 7
    //   565: ldc 138
    //   567: new 118	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   574: ldc_w 381
    //   577: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 10
    //   582: iconst_0
    //   583: aaload
    //   584: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc_w 375
    //   590: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 11
    //   595: invokevirtual 382	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   598: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 379	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: goto +236 -> 843
    //   610: astore_0
    //   611: aload 7
    //   613: astore 4
    //   615: aload 6
    //   617: astore 5
    //   619: aload 4
    //   621: ifnull +8 -> 629
    //   624: aload 4
    //   626: invokevirtual 308	java/io/FileInputStream:close	()V
    //   629: aload 5
    //   631: ifnull +8 -> 639
    //   634: aload 5
    //   636: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
    //   639: aload_0
    //   640: athrow
    //   641: astore 11
    //   643: aload 5
    //   645: astore 6
    //   647: aload 4
    //   649: astore 7
    //   651: ldc 138
    //   653: new 118	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 381
    //   663: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 10
    //   668: iconst_0
    //   669: aaload
    //   670: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc_w 375
    //   676: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 11
    //   681: invokevirtual 383	java/lang/Exception:toString	()Ljava/lang/String;
    //   684: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 379	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: goto +150 -> 843
    //   696: aload 4
    //   698: ifnull +8 -> 706
    //   701: aload 4
    //   703: invokevirtual 308	java/io/FileInputStream:close	()V
    //   706: aload 5
    //   708: ifnull +8 -> 716
    //   711: aload 5
    //   713: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
    //   716: aload 9
    //   718: areturn
    //   719: astore_0
    //   720: aload_0
    //   721: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   724: goto -18 -> 706
    //   727: astore_0
    //   728: aload_0
    //   729: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   732: goto -16 -> 716
    //   735: astore 4
    //   737: aload 4
    //   739: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   742: goto -594 -> 148
    //   745: astore 4
    //   747: aload 4
    //   749: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   752: goto -214 -> 538
    //   755: astore 4
    //   757: aload 4
    //   759: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   762: goto -133 -> 629
    //   765: astore 4
    //   767: aload 4
    //   769: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   772: goto -133 -> 639
    //   775: astore_0
    //   776: aconst_null
    //   777: astore 5
    //   779: aconst_null
    //   780: astore 4
    //   782: goto -163 -> 619
    //   785: astore_0
    //   786: aconst_null
    //   787: astore 5
    //   789: goto -170 -> 619
    //   792: astore 6
    //   794: aload_0
    //   795: astore 5
    //   797: aload 6
    //   799: astore_0
    //   800: goto -181 -> 619
    //   803: astore 5
    //   805: aconst_null
    //   806: astore_0
    //   807: aconst_null
    //   808: astore 4
    //   810: goto -294 -> 516
    //   813: astore 5
    //   815: aconst_null
    //   816: astore_0
    //   817: goto -301 -> 516
    //   820: astore 5
    //   822: aconst_null
    //   823: astore_0
    //   824: aconst_null
    //   825: astore 4
    //   827: goto -694 -> 133
    //   830: astore 5
    //   832: aconst_null
    //   833: astore_0
    //   834: goto -701 -> 133
    //   837: aconst_null
    //   838: astore 8
    //   840: goto -590 -> 250
    //   843: iload_1
    //   844: iconst_1
    //   845: iadd
    //   846: istore_1
    //   847: goto -547 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	850	0	paramContext	Context
    //   98	749	1	i	int
    //   297	6	2	j	int
    //   339	93	3	k	int
    //   57	645	4	localObject1	Object
    //   735	3	4	localIOException1	IOException
    //   745	3	4	localIOException2	IOException
    //   755	3	4	localIOException3	IOException
    //   765	3	4	localIOException4	IOException
    //   780	46	4	localObject2	Object
    //   66	730	5	localObject3	Object
    //   803	1	5	localIOException5	IOException
    //   813	1	5	localIOException6	IOException
    //   820	1	5	localFileNotFoundException1	FileNotFoundException
    //   830	1	5	localFileNotFoundException2	FileNotFoundException
    //   70	37	6	localObject4	Object
    //   124	6	6	localFileNotFoundException3	FileNotFoundException
    //   167	290	6	localObject5	Object
    //   507	6	6	localIOException7	IOException
    //   517	129	6	localObject6	Object
    //   792	6	6	localObject7	Object
    //   74	576	7	localObject8	Object
    //   81	758	8	localObject9	Object
    //   265	452	9	localHashMap	java.util.HashMap
    //   322	345	10	arrayOfString	String[]
    //   401	26	11	localPackageInfo	android.content.pm.PackageInfo
    //   452	39	11	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   555	39	11	localNumberFormatException	java.lang.NumberFormatException
    //   641	39	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   76	83	124	java/io/FileNotFoundException
    //   91	99	124	java/io/FileNotFoundException
    //   112	121	124	java/io/FileNotFoundException
    //   173	181	124	java/io/FileNotFoundException
    //   189	206	124	java/io/FileNotFoundException
    //   214	222	124	java/io/FileNotFoundException
    //   230	250	124	java/io/FileNotFoundException
    //   258	267	124	java/io/FileNotFoundException
    //   280	286	124	java/io/FileNotFoundException
    //   294	298	124	java/io/FileNotFoundException
    //   313	324	124	java/io/FileNotFoundException
    //   332	340	124	java/io/FileNotFoundException
    //   354	378	124	java/io/FileNotFoundException
    //   389	403	124	java/io/FileNotFoundException
    //   411	449	124	java/io/FileNotFoundException
    //   462	504	124	java/io/FileNotFoundException
    //   565	607	124	java/io/FileNotFoundException
    //   651	693	124	java/io/FileNotFoundException
    //   152	156	158	java/io/IOException
    //   332	340	452	android/content/pm/PackageManager$NameNotFoundException
    //   354	378	452	android/content/pm/PackageManager$NameNotFoundException
    //   389	403	452	android/content/pm/PackageManager$NameNotFoundException
    //   411	449	452	android/content/pm/PackageManager$NameNotFoundException
    //   76	83	507	java/io/IOException
    //   91	99	507	java/io/IOException
    //   112	121	507	java/io/IOException
    //   173	181	507	java/io/IOException
    //   189	206	507	java/io/IOException
    //   214	222	507	java/io/IOException
    //   230	250	507	java/io/IOException
    //   258	267	507	java/io/IOException
    //   280	286	507	java/io/IOException
    //   294	298	507	java/io/IOException
    //   313	324	507	java/io/IOException
    //   332	340	507	java/io/IOException
    //   354	378	507	java/io/IOException
    //   389	403	507	java/io/IOException
    //   411	449	507	java/io/IOException
    //   462	504	507	java/io/IOException
    //   565	607	507	java/io/IOException
    //   651	693	507	java/io/IOException
    //   542	546	548	java/io/IOException
    //   332	340	555	java/lang/NumberFormatException
    //   354	378	555	java/lang/NumberFormatException
    //   389	403	555	java/lang/NumberFormatException
    //   411	449	555	java/lang/NumberFormatException
    //   76	83	610	finally
    //   91	99	610	finally
    //   112	121	610	finally
    //   173	181	610	finally
    //   189	206	610	finally
    //   214	222	610	finally
    //   230	250	610	finally
    //   258	267	610	finally
    //   280	286	610	finally
    //   294	298	610	finally
    //   313	324	610	finally
    //   332	340	610	finally
    //   354	378	610	finally
    //   389	403	610	finally
    //   411	449	610	finally
    //   462	504	610	finally
    //   523	528	610	finally
    //   565	607	610	finally
    //   651	693	610	finally
    //   332	340	641	java/lang/Exception
    //   354	378	641	java/lang/Exception
    //   389	403	641	java/lang/Exception
    //   411	449	641	java/lang/Exception
    //   701	706	719	java/io/IOException
    //   711	716	727	java/io/IOException
    //   143	148	735	java/io/IOException
    //   533	538	745	java/io/IOException
    //   624	629	755	java/io/IOException
    //   634	639	765	java/io/IOException
    //   43	59	775	finally
    //   59	68	785	finally
    //   133	138	792	finally
    //   43	59	803	java/io/IOException
    //   59	68	813	java/io/IOException
    //   43	59	820	java/io/FileNotFoundException
    //   59	68	830	java/io/FileNotFoundException
  }
  
  public static class a
    implements arxh.a
  {
    protected Context S;
    protected String cDc;
    protected int elj;
    protected String packageName;
    protected WebView webView;
    
    public a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView)
    {
      this.S = paramContext;
      this.packageName = paramString1;
      this.elj = paramInt;
      this.cDc = paramString2;
      this.webView = paramWebView;
    }
    
    public void ai(JSONObject paramJSONObject)
    {
      JSONObject localJSONObject = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject = new JSONObject();
      }
      arwt.i("AppReport", "<AppReport> IncrementalReportCallback onResult >>> " + localJSONObject.toString());
      int i = localJSONObject.optInt("code", -1);
      paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramJSONObject != null) {}
      for (paramJSONObject = paramJSONObject.getUin();; paramJSONObject = "")
      {
        if (i == 0)
        {
          arxu.mLock.lock();
          this.S.deleteFile("appcenter_app_report_storage_file.txt");
          arxu.mLock.unlock();
        }
        for (;;)
        {
          try
          {
            if (localJSONObject.optInt("report_all") == 1)
            {
              arxu.a(this.S, this.cDc, this.webView, paramJSONObject, true);
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          while ((this.cDc != null) && (this.webView != null))
          {
            arwt.d("AppReport", "<AppReport> onResult get app update list after incremental report");
            if (i != 0) {
              break label189;
            }
            arxv.a(this.S, this.webView, this.cDc, true, paramJSONObject);
            return;
            arxu.aR(this.S, this.packageName, this.elj);
          }
        }
        label189:
        arxv.a(this.S, this.webView, this.cDc, false, paramJSONObject);
        return;
      }
    }
    
    public void onException(Exception paramException)
    {
      arwt.i("AppReport", "<AppReport> IncrementalReportCallback onException >>> " + paramException.toString());
      if ((this.cDc == null) && (this.packageName != null)) {
        arxu.aR(this.S, this.packageName, this.elj);
      }
      if ((this.cDc != null) && (this.webView != null))
      {
        arwt.d("AppReport", "<AppReport> onException get app update list after incremental report");
        SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
        paramException = "";
        if (localSimpleAccount != null) {
          paramException = localSimpleAccount.getUin();
        }
        arxv.a(this.S, this.webView, this.cDc, false, paramException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxu
 * JD-Core Version:    0.7.0.1
 */