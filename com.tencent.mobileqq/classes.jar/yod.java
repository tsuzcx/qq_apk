import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class yod
{
  public static LruCache<String, List<String>> a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GameCenterUtils";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  }
  
  public static long a()
  {
    long l = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    bdoe.b(jdField_a_of_type_JavaLangString, "getResAvilTime ts" + l);
    return l;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getLong(paramString, 0L);
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +9 -> 15
    //   9: getstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore_3
    //   17: new 105	java/io/BufferedReader
    //   20: dup
    //   21: new 107	java/io/InputStreamReader
    //   24: dup
    //   25: new 109	java/io/FileInputStream
    //   28: dup
    //   29: new 52	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   36: ldc 111
    //   38: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokestatic 117	android/os/Process:myPid	()I
    //   44: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 122
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: ldc 127
    //   60: invokespecial 130	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   63: invokespecial 133	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: new 52	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   74: astore_3
    //   75: aload_2
    //   76: invokevirtual 136	java/io/BufferedReader:read	()I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +108 -> 189
    //   84: aload_3
    //   85: iload_1
    //   86: i2c
    //   87: invokevirtual 139	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: goto -16 -> 75
    //   94: astore_3
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 142	java/io/BufferedReader:close	()V
    //   103: invokestatic 117	android/os/Process:myPid	()I
    //   106: istore_1
    //   107: aload_0
    //   108: ifnull +150 -> 258
    //   111: aload_0
    //   112: ldc 144
    //   114: invokevirtual 148	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   117: checkcast 150	android/app/ActivityManager
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 154	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +131 -> 258
    //   130: aload_2
    //   131: invokeinterface 159 1 0
    //   136: ifle +122 -> 258
    //   139: aload_0
    //   140: invokevirtual 154	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   143: invokeinterface 163 1 0
    //   148: astore_0
    //   149: aload_0
    //   150: invokeinterface 169 1 0
    //   155: ifeq +103 -> 258
    //   158: aload_0
    //   159: invokeinterface 173 1 0
    //   164: checkcast 175	android/app/ActivityManager$RunningAppProcessInfo
    //   167: astore_2
    //   168: aload_2
    //   169: getfield 179	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   172: iload_1
    //   173: if_icmpne -24 -> 149
    //   176: aload_2
    //   177: getfield 182	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: putstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   185: getstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: areturn
    //   189: aload_3
    //   190: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   196: getstatic 103	yod:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: astore_3
    //   200: aload_3
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull -190 -> 13
    //   206: aload_2
    //   207: invokevirtual 142	java/io/BufferedReader:close	()V
    //   210: aload_3
    //   211: areturn
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   217: aload_3
    //   218: areturn
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   224: goto -121 -> 103
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 142	java/io/BufferedReader:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   245: goto -7 -> 238
    //   248: astore_0
    //   249: goto -19 -> 230
    //   252: astore_2
    //   253: aload_3
    //   254: astore_2
    //   255: goto -160 -> 95
    //   258: ldc 187
    //   260: astore_0
    //   261: goto -80 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   79	95	1	i	int
    //   66	141	2	localObject1	Object
    //   219	2	2	localIOException1	java.io.IOException
    //   229	6	2	localObject2	Object
    //   240	2	2	localIOException2	java.io.IOException
    //   252	1	2	localException1	Exception
    //   254	1	2	str1	String
    //   16	69	3	localStringBuilder	java.lang.StringBuilder
    //   94	96	3	localException2	Exception
    //   199	55	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   67	75	94	java/lang/Exception
    //   75	80	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   189	200	94	java/lang/Exception
    //   206	210	212	java/io/IOException
    //   99	103	219	java/io/IOException
    //   17	67	227	finally
    //   234	238	240	java/io/IOException
    //   67	75	248	finally
    //   75	80	248	finally
    //   84	91	248	finally
    //   189	200	248	finally
    //   17	67	252	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getString(paramString, "");
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = "wadl_" + paramString + "_" + paramInt + ".apk";
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + "com.tencent.gamecenter.wadl" + "/" + "dlapks" + "/" + paramString;
  }
  
  public static List<DownloadInfo> a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = 0;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = a(paramString + paramArrayOfString[i]);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        try
        {
          localObject = new JSONObject((String)localObject);
          localDownloadInfo.c = ((JSONObject)localObject).optString("appid");
          localDownloadInfo.j = ((JSONObject)localObject).optString("myAppId");
          localDownloadInfo.k = ((JSONObject)localObject).optString("apkId");
          localDownloadInfo.e = ((JSONObject)localObject).optString("packageName");
          localDownloadInfo.b = ((JSONObject)localObject).optInt("versionCode");
          if (paramBoolean) {
            break label221;
          }
          localArrayList.add(localDownloadInfo);
        }
        catch (Exception localException)
        {
          localArrayList.add(localDownloadInfo);
        }
        if (QLog.isColorLevel())
        {
          bdoe.b(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "exception and no installed", localException);
          continue;
          label221:
          if (localPackageManager.getPackageInfo(localDownloadInfo.e.trim(), 0) == null)
          {
            localArrayList.add(localDownloadInfo);
            if (QLog.isColorLevel()) {
              bdoe.b(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "no installed");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              bdoe.b(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "installed");
            }
            a(null, "426", "202142", localDownloadInfo.c, "42601", "1", "116");
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.gameCfg.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[2];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        if (DeviceProfileManager.a(str, arrayOfInteger, new ajvg()) >= arrayOfInteger.length)
        {
          if (arrayOfInteger[0].intValue() != 1) {
            continue;
          }
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          if (arrayOfInteger[1].intValue() != 1) {
            continue;
          }
          bool1 = bool2;
          jdField_b_of_type_Boolean = bool1;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC isDelayDownload = " + jdField_a_of_type_Boolean + " , isAppointDownload = " + jdField_b_of_type_Boolean);
      }
      return;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramAppInterface != null) {}
    for (;;)
    {
      try
      {
        paramAppInterface.getCurrentAccountUin();
        int j = nam.a();
        if (j < 0) {
          break label462;
        }
        i = j;
        if (j >= ajsf.c.length) {
          break label462;
        }
        String str2 = ajsf.c[i];
        String str1 = "";
        Object localObject = str1;
        if (paramAppInterface != null)
        {
          BaseApplication localBaseApplication = paramAppInterface.getApp();
          localObject = str1;
          if (localBaseApplication != null)
          {
            localObject = localBaseApplication.getResources().getDisplayMetrics();
            localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
        }
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.2.8", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label457;
        }
        paramAppInterface = (QQAppInterface)paramAppInterface;
        bghg.a(paramAppInterface, "dc00087", paramString1);
        return;
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      BaseApplicationImpl.sApplication.getRuntime().getAccount();
      continue;
      label457:
      paramAppInterface = null;
      continue;
      label462:
      int i = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    try
    {
      if (!QLog.isColorLevel()) {
        break label304;
      }
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("gameappid=").append(paramString3).append("/");
      ((StringBuffer)localObject1).append("oper_moudle=").append(paramString1).append("/");
      ((StringBuffer)localObject1).append("oper_id=").append(paramString2).append("/");
      ((StringBuffer)localObject1).append("moduleType=").append(paramString4).append("/");
      ((StringBuffer)localObject1).append("business=").append(paramString5).append("/");
      ((StringBuffer)localObject1).append("page=").append(paramString6).append("/");
      if ((paramMap != null) && (paramMap.keySet().size() > 0))
      {
        ((StringBuffer)localObject1).append("exts=[");
        localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          i = ((Integer)((Map.Entry)localObject3).getKey()).intValue();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          ((StringBuffer)localObject1).append(i).append("=").append((String)localObject3).append("/");
        }
        ((StringBuffer)localObject1).append("]");
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "reportDC00087WithExt Exception:" + paramAppInterface.getMessage());
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, ((StringBuffer)localObject1).toString());
    label304:
    int j = nam.a();
    if (j >= 0)
    {
      i = j;
      if (j >= ajsf.c.length) {}
    }
    for (;;)
    {
      localObject3 = ajsf.c[i];
      localObject2 = "";
      localObject1 = localObject2;
      if (paramAppInterface != null)
      {
        BaseApplication localBaseApplication = paramAppInterface.getApp();
        localObject1 = localObject2;
        if (localBaseApplication != null)
        {
          localObject1 = localBaseApplication.getResources().getDisplayMetrics();
          localObject1 = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
        }
      }
      paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.2.8", "gamecenter_ver", "2", Build.BRAND, localObject3, localObject1, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramString2 = paramMap.keySet().iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (Integer)paramString2.next();
          paramString1.set(paramString3.intValue() + 14, paramMap.get(paramString3));
        }
      }
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
      {
        bghg.a(paramAppInterface, "dc00087", paramString1);
        return;
      }
      i = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    int j = 0;
    if (paramAppInterface != null) {}
    try
    {
      paramAppInterface.getCurrentAccountUin();
      int k = nam.a();
      int i;
      if (k >= 0)
      {
        i = k;
        if (k >= ajsf.c.length) {}
      }
      for (;;)
      {
        String str2 = ajsf.c[i];
        String str1 = "";
        Object localObject = str1;
        if (paramAppInterface != null)
        {
          BaseApplication localBaseApplication = paramAppInterface.getApp();
          localObject = str1;
          if (localBaseApplication != null)
          {
            localObject = localBaseApplication.getResources().getDisplayMetrics();
            localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
        }
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.2.8", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (paramVarArgs != null)
        {
          k = paramVarArgs.length;
          i = j;
          for (;;)
          {
            if ((i < k) && (i < 9))
            {
              paramString1.set(i + 16, paramVarArgs[i]);
              i += 1;
              continue;
              BaseApplicationImpl.sApplication.getRuntime().getAccount();
              break;
            }
          }
        }
        if ((paramAppInterface instanceof QQAppInterface)) {}
        for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
        {
          bghg.a(paramAppInterface, "dc00087", paramString1);
          return;
        }
        i = 0;
      }
      return;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramWadlResult.a.j.trim(), 0) != null) && (paramWadlResult.b != 9)) {
        paramWadlResult.b = 9;
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQueryResult e=" + paramWadlResult.toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    bdoe.b(jdField_a_of_type_JavaLangString, "startDownload delay task pParamsJson=" + paramString + ",autoInstallBySdk=" + paramBoolean + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
    try
    {
      WadlJsBridge.startDownload(paramString, paramBoolean, paramInt);
      paramString = new JSONObject(paramString).optString("appid");
      if (2 == paramInt)
      {
        a(null, "427", "202139", paramString, "42701", "1", "117");
        return;
      }
      if (1 == paramInt)
      {
        a(null, "426", "202140", paramString, "42601", "1", "116");
        return;
      }
    }
    catch (Exception paramString)
    {
      bdoe.a(jdField_a_of_type_JavaLangString, "startDownload exception", paramString);
    }
  }
  
  public static void a(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((localPackageManager.getPackageInfo(((WadlResult)paramArrayList.get(i)).a.j.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).b != 9)) {
          ((WadlResult)paramArrayList.get(i)).b = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQueryResult e=" + paramArrayList.toString());
    }
  }
  
  public static void a(Map<Integer, String> paramMap, String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramMap == null) {
      return;
    }
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (aqst.a == null)) {
          break;
        }
        Object localObject = (List)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from cache");
            i = j;
          }
          if (i >= ((List)localObject).size()) {
            break;
          }
          paramMap.put(Integer.valueOf(15 + i), ((List)localObject).get(i));
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from msg decode");
        }
        localObject = (String)aqst.a.get(paramString + "_orted_configs");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from msg decode orted_configs = " + (String)localObject);
        }
        localObject = new JSONArray((String)localObject);
        localArrayList = new ArrayList();
        if (i >= ((JSONArray)localObject).length()) {
          break label349;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        Iterator localIterator = localJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = localJSONObject.optString((String)localIterator.next());
          paramMap.put(Integer.valueOf(15 + i), str);
          localArrayList.add(i, str);
        }
        else
        {
          i += 1;
        }
      }
      catch (Throwable paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs err=" + paramMap.toString());
        }
        paramMap.printStackTrace();
        return;
      }
    }
    label349:
    jdField_a_of_type_AndroidUtilLruCache.put(paramString, localArrayList);
  }
  
  public static void a(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      bdoe.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp:" + paramArrayOfString);
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    for (;;)
    {
      return;
      a("DELAY_LIST", "");
      paramArrayOfString = a(paramArrayOfString, "DELAY_APPID_DETAIL_", true);
      if (paramArrayOfString.size() == 0)
      {
        if (QLog.isColorLevel()) {
          bdoe.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp params.size=0:");
        }
      }
      else
      {
        paramArrayOfString = paramArrayOfString.iterator();
        while (paramArrayOfString.hasNext())
        {
          Object localObject = (DownloadInfo)paramArrayOfString.next();
          localObject = a("DELAY_APPID_DETAIL_" + ((DownloadInfo)localObject).c);
          try
          {
            a((String)localObject, true, 2);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    if ((bbev.h(BaseApplicationImpl.getContext())) && ((PowerManager)BaseApplicationImpl.getContext().getSystemService("power") != null) && ((ynz.a >= 20) || (ynz.jdField_b_of_type_Boolean))) {
      return true;
    }
    a(null, "426", "205572", "", "42601", "1", "116");
    return false;
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).edit();
    localEditor.putLong("gamecenter_res", paramLong);
    boolean bool = localEditor.commit();
    bdoe.b(jdField_a_of_type_JavaLangString, "saveResAvilTime: ts=" + paramLong + ",flag:" + bool);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit().remove(paramString).commit();
    }
    return false;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putLong(paramString, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString + " :" + paramLong);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putString(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString1 + " :" + paramString2);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      bdoe.b(jdField_a_of_type_JavaLangString, "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    }
    return a(paramString3 + paramString1, paramString2);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putBoolean(paramString, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString + " :" + paramBoolean);
    }
    return localEditor.commit();
  }
  
  public static String b(String paramString)
  {
    return paramString + "_appoint";
  }
  
  public static void b(String[] paramArrayOfString)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      bdoe.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp:" + paramArrayOfString);
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = "";
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject3;
      if (i < paramArrayOfString.length) {
        localObject3 = a("APPOINT_APPID_DETAIL_" + paramArrayOfString[i]);
      }
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        long l1 = ((JSONObject)localObject3).optLong("downloadStartTime", 0L);
        long l2 = ((JSONObject)localObject3).optLong("downloadEndTime", 0L);
        long l3 = NetConnInfoCenter.getServerTime();
        if ((l1 <= l3) && (l3 <= l2))
        {
          localObject3 = (String)localObject1 + paramArrayOfString[i] + "|";
          j = 1;
          localObject1 = localObject3;
        }
        else
        {
          localObject3 = (String)localObject2 + paramArrayOfString[i] + "|";
          localObject2 = localObject3;
        }
      }
      catch (Exception localException2)
      {
        i += 1;
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      if ((paramArrayOfString.length == 0) || (!a())) {
        break;
      }
      i = k;
      if (j != 0)
      {
        a("APPOINTMENT_LIST", (String)localObject2);
        i = k;
      }
      if (i < paramArrayOfString.length)
      {
        if (TextUtils.isEmpty(paramArrayOfString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          c(paramArrayOfString[i], "APPOINTMENT_CHECKLIST");
        }
      }
      localObject1 = a(paramArrayOfString, "APPOINT_APPID_DETAIL_", true);
      if (((List)localObject1).size() < 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        bdoe.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        localObject3 = a("APPOINT_APPID_DETAIL_" + ((DownloadInfo)localObject2).c);
        try
        {
          String str = a(((DownloadInfo)localObject2).c, ((DownloadInfo)localObject2).b);
          if (!apvb.a(str)) {
            break label483;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "startDownload from YY but apk is exists apkPath=" + str);
          a(null, "558", "205754", ((DownloadInfo)localObject2).c, "55801", "4", "430");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        continue;
        label483:
        a((String)localObject3, true, 1);
        c(localException1.c, "APPOINTMENT_HAS_DOWNLOAD_LIST");
        paramArrayOfString.put(localException1.c);
      }
      if (paramArrayOfString.length() <= 0) {
        break;
      }
      bich.a().a(paramArrayOfString, null);
      return;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getBoolean(paramString, false);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    return a(paramString2, str.replace(paramString1 + "|", ""));
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    if (QLog.isColorLevel()) {
      bdoe.b(jdField_a_of_type_JavaLangString, "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    }
    String str = str.replace(paramString1 + "|", "");
    return a(paramString2, str + paramString1 + "|");
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return a(paramString2 + paramString1);
    }
    return false;
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + "com.tencent.gamecenter.wadl" + "/" + "res" + "/" + paramString1;
    return apvb.a(paramString1 + "/" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yod
 * JD-Core Version:    0.7.0.1
 */