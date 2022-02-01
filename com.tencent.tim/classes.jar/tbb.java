import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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

public class tbb
{
  public static String TAG = "GameCenterUtils";
  public static boolean aOA = true;
  public static boolean aOB;
  public static boolean aOx = true;
  public static boolean aOy = true;
  public static boolean aOz = true;
  public static LruCache<String, List<String>> m = new LruCache(10);
  
  public static String M(String paramString, int paramInt)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "pkg";
    }
    for (;;)
    {
      paramString = aqul.getSDKPrivatePath("com.tencent.gamecenter.wadl/" + (String)localObject + "/" + paramString);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 4, "getDownloadResDir realPath=" + paramString);
      }
      try
      {
        localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        return paramString;
        localObject = "res";
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(TAG, 4, "getDownloadApkDir make dir error", localThrowable);
      }
    }
    return paramString;
  }
  
  public static String N(String paramString, int paramInt)
  {
    String str2 = e(paramString, paramInt, ".apk");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = e(paramString, paramInt, "_tgpa.apk");
    }
    return str1;
  }
  
  public static long P(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).getLong(paramString, 0L);
    }
  }
  
  public static boolean V(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      asbt.i(TAG, "writeToSp " + paramString1 + " :" + paramString2);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean W(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = gQ(paramString2);
    } while (str == null);
    return V(paramString2, str.replace(paramString1 + "|", ""));
  }
  
  public static boolean X(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = gQ(paramString2);
    } while (str == null);
    asbt.i(TAG, "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    String str = str.replace(paramString1 + "|", "");
    return V(paramString2, str + paramString1 + "|");
  }
  
  public static boolean Y(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2)) {
        bool1 = g(new String[] { paramString2 + paramString1 });
      }
    }
    return bool1;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    for (;;)
    {
      try
      {
        int j = jqc.getNetWorkType();
        if (j < 0) {
          break label435;
        }
        i = j;
        if (j >= acbn.dQ.length) {
          break label435;
        }
        String str2 = acbn.dQ[i];
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
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "3.4.4", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if ((paramAppInterface instanceof QQAppInterface))
        {
          paramAppInterface = (QQAppInterface)paramAppInterface;
          avdb.b(paramAppInterface, "dc00087", paramString1);
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      paramAppInterface = null;
      continue;
      label435:
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
        QLog.d(TAG, 1, "reportDC00087WithExt Exception:" + paramAppInterface.getMessage());
      }
      return;
    }
    QLog.d(TAG, 1, ((StringBuffer)localObject1).toString());
    label304:
    int j = jqc.getNetWorkType();
    if (j >= 0)
    {
      i = j;
      if (j >= acbn.dQ.length) {}
    }
    for (;;)
    {
      localObject3 = acbn.dQ[i];
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
      paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "3.4.4", "1.0", "2", Build.BRAND, localObject3, localObject1, "0", "0", "1", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
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
        avdb.b(paramAppInterface, "dc00087", paramString1);
        return;
      }
      i = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        int k = jqc.getNetWorkType();
        if (k < 0) {
          break label492;
        }
        i = k;
        if (k >= acbn.dQ.length) {
          break label492;
        }
        String str2 = acbn.dQ[i];
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
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "3.4.4", "1.0", "2", Build.BRAND, str2, localObject, "0", "0", "1", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (paramVarArgs != null)
        {
          k = paramVarArgs.length;
          i = j;
          if ((i < k) && (i < 9))
          {
            paramString1.set(i + 16, paramVarArgs[i]);
            i += 1;
            continue;
          }
        }
        if ((paramAppInterface instanceof QQAppInterface))
        {
          paramAppInterface = (QQAppInterface)paramAppInterface;
          avdb.b(paramAppInterface, "dc00087", paramString1);
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      paramAppInterface = null;
      continue;
      label492:
      int i = 0;
    }
  }
  
  public static void b(Map<Integer, String> paramMap, String paramString)
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
        if ((TextUtils.isEmpty(paramString)) || (ahtz.lk == null)) {
          break;
        }
        Object localObject = (List)m.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d(TAG, 1, "get _orted_configs from cache");
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
          QLog.d(TAG, 1, "get _orted_configs from msg decode");
        }
        localObject = (String)ahtz.lk.get(paramString + "_orted_configs");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 1, "get _orted_configs from msg decode orted_configs = " + (String)localObject);
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
          QLog.d(TAG, 1, "get _orted_configs err=" + paramMap.toString());
        }
        paramMap.printStackTrace();
        return;
      }
    }
    label349:
    m.put(paramString, localArrayList);
  }
  
  /* Error */
  public static void bCr()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 447	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   5: getstatic 453	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:gameCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   8: invokevirtual 456	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   11: ldc 143
    //   13: invokevirtual 460	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_3
    //   17: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: getstatic 21	tbb:TAG	Ljava/lang/String;
    //   26: iconst_2
    //   27: new 46	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 462
    //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_3
    //   41: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_3
    //   51: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +247 -> 301
    //   57: iconst_5
    //   58: anewarray 345	java/lang/Integer
    //   61: astore 4
    //   63: aload 4
    //   65: iconst_0
    //   66: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: invokestatic 466	java/util/Arrays:fill	([Ljava/lang/Object;Ljava/lang/Object;)V
    //   72: aload_3
    //   73: aload 4
    //   75: new 468	com/tencent/mobileqq/app/DeviceProfileManager$e
    //   78: dup
    //   79: invokespecial 469	com/tencent/mobileqq/app/DeviceProfileManager$e:<init>	()V
    //   82: invokestatic 472	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/mobileqq/app/DeviceProfileManager$d;)I
    //   85: istore_0
    //   86: aload 4
    //   88: iconst_0
    //   89: aaload
    //   90: invokevirtual 348	java/lang/Integer:intValue	()I
    //   93: iconst_1
    //   94: if_icmpne +173 -> 267
    //   97: iconst_1
    //   98: istore_1
    //   99: iload_1
    //   100: putstatic 23	tbb:aOx	Z
    //   103: aload 4
    //   105: iconst_1
    //   106: aaload
    //   107: invokevirtual 348	java/lang/Integer:intValue	()I
    //   110: iconst_1
    //   111: if_icmpne +161 -> 272
    //   114: iconst_1
    //   115: istore_1
    //   116: iload_1
    //   117: putstatic 25	tbb:aOy	Z
    //   120: aload 4
    //   122: iconst_2
    //   123: aaload
    //   124: invokevirtual 348	java/lang/Integer:intValue	()I
    //   127: iconst_1
    //   128: if_icmpne +149 -> 277
    //   131: iconst_1
    //   132: istore_1
    //   133: iload_1
    //   134: putstatic 27	tbb:aOz	Z
    //   137: aload 4
    //   139: iconst_3
    //   140: aaload
    //   141: invokevirtual 348	java/lang/Integer:intValue	()I
    //   144: iconst_1
    //   145: if_icmpne +137 -> 282
    //   148: iconst_1
    //   149: istore_1
    //   150: iload_1
    //   151: putstatic 29	tbb:aOA	Z
    //   154: iload_2
    //   155: istore_1
    //   156: aload 4
    //   158: iconst_4
    //   159: aaload
    //   160: invokevirtual 348	java/lang/Integer:intValue	()I
    //   163: iconst_1
    //   164: if_icmpne +5 -> 169
    //   167: iconst_1
    //   168: istore_1
    //   169: iload_1
    //   170: putstatic 474	tbb:aOB	Z
    //   173: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +90 -> 266
    //   179: getstatic 21	tbb:TAG	Ljava/lang/String;
    //   182: iconst_2
    //   183: new 46	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 476
    //   193: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_0
    //   197: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 478
    //   203: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: getstatic 23	tbb:aOx	Z
    //   209: invokevirtual 481	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   212: ldc_w 483
    //   215: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 25	tbb:aOy	Z
    //   221: invokevirtual 481	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   224: ldc_w 485
    //   227: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: getstatic 27	tbb:aOz	Z
    //   233: invokevirtual 481	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   236: ldc_w 487
    //   239: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: getstatic 29	tbb:aOA	Z
    //   245: invokevirtual 481	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   248: ldc_w 489
    //   251: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: getstatic 474	tbb:aOB	Z
    //   257: invokevirtual 481	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   260: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: return
    //   267: iconst_0
    //   268: istore_1
    //   269: goto -170 -> 99
    //   272: iconst_0
    //   273: istore_1
    //   274: goto -158 -> 116
    //   277: iconst_0
    //   278: istore_1
    //   279: goto -146 -> 133
    //   282: iconst_0
    //   283: istore_1
    //   284: goto -134 -> 150
    //   287: astore_3
    //   288: iconst_0
    //   289: istore_0
    //   290: aload_3
    //   291: invokevirtual 490	java/lang/Exception:printStackTrace	()V
    //   294: goto -121 -> 173
    //   297: astore_3
    //   298: goto -8 -> 290
    //   301: iconst_0
    //   302: istore_0
    //   303: goto -130 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   85	218	0	i	int
    //   98	186	1	bool1	boolean
    //   1	154	2	bool2	boolean
    //   16	57	3	str	String
    //   287	4	3	localException1	Exception
    //   297	1	3	localException2	Exception
    //   61	96	4	arrayOfInteger	Integer[]
    // Exception table:
    //   from	to	target	type
    //   57	86	287	java/lang/Exception
    //   86	97	297	java/lang/Exception
    //   99	114	297	java/lang/Exception
    //   116	131	297	java/lang/Exception
    //   133	148	297	java/lang/Exception
    //   150	154	297	java/lang/Exception
    //   156	167	297	java/lang/Exception
    //   169	173	297	java/lang/Exception
  }
  
  public static boolean br(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).edit();
    localEditor.putLong("gamecenter_res", paramLong);
    boolean bool = localEditor.commit();
    asbt.i(TAG, "saveResAvilTime: ts=" + paramLong + ",flag:" + bool);
    return bool;
  }
  
  public static int bt(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getAppVersionCode packageName = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        paramString = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramString, 0);
        if (paramString != null)
        {
          int i = paramString.versionCode;
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -1;
  }
  
  public static boolean c(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = M(paramString1, paramInt);
    return ahbj.isFileExists(paramString1 + "/" + paramString2);
  }
  
  public static void cI(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((localPackageManager.getPackageInfo(((WadlResult)paramArrayList.get(i)).a.packageName.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).bBa != 9)) {
          ((WadlResult)paramArrayList.get(i)).bBa = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e(TAG, 1, "handleQueryResult e=" + paramArrayList.toString());
    }
  }
  
  public static String d(String paramString1, int paramInt, String paramString2)
  {
    return "wadl_" + paramString1 + "_" + paramInt + paramString2;
  }
  
  public static void d(WadlResult paramWadlResult)
  {
    try
    {
      if ((BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramWadlResult.a.packageName.trim(), 0) != null) && (paramWadlResult.bBa != 9)) {
        paramWadlResult.bBa = 9;
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      QLog.e(TAG, 1, "handleQueryResult e=" + paramWadlResult.toString());
    }
  }
  
  public static String e(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = d(paramString1, paramInt, paramString2);
    paramString1 = oa() + "/" + paramString1;
    if (ahbj.isFileExists(paramString1)) {
      return paramString1;
    }
    return null;
  }
  
  public static boolean e(String paramString, int paramInt1, int paramInt2)
  {
    int i = bt(paramString);
    asbt.i(TAG, "checkVersion packageName=" + paramString + ",updateVersion=" + paramInt1 + ",qgameMinVersion=" + paramInt2 + ",localVersion=" + i);
    return (paramInt2 > -1) && (i != -1) && (i < paramInt2) && (i < paramInt1);
  }
  
  public static long ec()
  {
    long l = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    asbt.i(TAG, "getResAvilTime ts" + l);
    return l;
  }
  
  public static boolean g(String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localObject = BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).edit();
        int j = paramVarArgs.length;
        while (i < j)
        {
          ((SharedPreferences.Editor)localObject).remove(paramVarArgs[i]);
          i += 1;
        }
      }
      return ((SharedPreferences.Editor)localObject).commit();
    }
    return false;
  }
  
  public static String gQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).getString(paramString, "");
    }
  }
  
  public static String gR(String paramString)
  {
    return paramString + "_appoint";
  }
  
  public static boolean gv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).getBoolean(paramString, false);
    }
  }
  
  public static boolean h(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    asbt.i(TAG, "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    return V(paramString3 + paramString1, paramString2);
  }
  
  public static boolean j(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      asbt.i(TAG, "writeToSpLong " + paramString + " :" + paramLong);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static String oa()
  {
    String str = aqul.getSDKPrivatePath("com.tencent.gamecenter.wadl/dlapks");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 4, "getDownloadApkDir realPath=" + str);
    }
    try
    {
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 4, "getDownloadApkDir make dir error", localThrowable);
    }
    return str;
  }
  
  public static boolean r(String paramString, int paramInt)
  {
    int i = bt(paramString);
    asbt.i(TAG, "checkVersion packageName=" + paramString + ",versionCode=" + paramInt + ",localVersion=" + i);
    return (i != -1) && (i < paramInt);
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    asbt.i(TAG, "startDownload delay task pParamsJson=" + paramString + ",autoInstallBySdk=" + paramBoolean + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
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
      asbt.e(TAG, "startDownload exception", paramString);
    }
  }
  
  public static boolean t(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(gR((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
      asbt.i(TAG, "writeToSp " + paramString + " :" + paramBoolean);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */