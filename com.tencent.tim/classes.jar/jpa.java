import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.1;
import com.tencent.biz.common.offline.HtmlOffline.2;
import com.tencent.biz.common.offline.HtmlOffline.4;
import com.tencent.biz.common.offline.HtmlOffline.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;

public class jpa
{
  public static jpj a;
  public static jpk a;
  public static jpl a;
  public static int aCz;
  public static ConcurrentHashMap<String, String> aR = new ConcurrentHashMap();
  public static boolean aba;
  protected static final String[] bb = { "config.json", "verify.json", "verify.signature" };
  protected static final String[] bc = { "0", "1" };
  public static jox c = new jpb();
  private static Context mApplicationContext;
  
  static
  {
    aCz = 0;
    jdField_a_of_type_Jpl = new jph();
    jdField_a_of_type_Jpk = new jpn();
    jdField_a_of_type_Jpj = new jpm();
  }
  
  public static boolean C(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
    }
    long l;
    do
    {
      return false;
      String str = jpe.dO(paramString1);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString1;
      if (!new File(str).exists()) {
        return true;
      }
      paramString2 = getFilePath(paramString2);
      l = System.currentTimeMillis();
      if (jqj.f(paramString2, str, paramString1)) {
        break;
      }
      bn(str, paramString1);
    } while (!jdField_a_of_type_Jpj.isColorLevel());
    jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "verfySingleFile fail :" + paramString2);
    return false;
    if (jdField_a_of_type_Jpj.isDevelopLevel()) {
      jdField_a_of_type_Jpj.d("HtmlCheckUpdate", 4, "verifyFile:time=" + (System.currentTimeMillis() - l) + ", file:" + paramString2);
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  public static jpa.a a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http")))
    {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
      return null;
    }
    Object localObject = jpe.dO(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    paramString1 = (String)localObject + paramString1;
    paramString2 = getFilePath(paramString2);
    localObject = paramString1 + "/" + paramString2;
    if (!new File((String)localObject).exists())
    {
      if (jdField_a_of_type_Jpj.isDevelopLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString2);
      }
      return null;
    }
    paramString1 = "text/html";
    if (paramString2.contains(".css")) {
      paramString1 = "text/css";
    }
    for (;;)
    {
      if (jdField_a_of_type_Jpj.isDevelopLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 4, "getResponse ****************** :" + paramString2);
      }
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        return new jpa.a(paramString1, (InputStream)localObject);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        if (!jdField_a_of_type_Jpj.isDevelopLevel()) {
          break label350;
        }
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 4, "getResponse get local file fail:" + paramString2);
      }
      if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
    label350:
    return null;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 105	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 172
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 33
    //   31: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 105	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   45: ldc 223
    //   47: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 229	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   62: aload_1
    //   63: invokevirtual 235	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 241	jqo:e	(Ljava/io/InputStream;)Ljava/lang/String;
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 246	java/io/InputStream:close	()V
    //   76: new 248	org/json/JSONObject
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 250	org/json/JSONException:printStackTrace	()V
    //   92: getstatic 64	jpa:jdField_a_of_type_Jpj	Ljpj;
    //   95: invokeinterface 89 1 0
    //   100: ifeq +16 -> 116
    //   103: getstatic 64	jpa:jdField_a_of_type_Jpj	Ljpj;
    //   106: ldc 91
    //   108: iconst_2
    //   109: ldc 252
    //   111: invokeinterface 97 4 0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   126: goto -50 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   76	85	87	org/json/JSONException
    //   58	67	118	java/io/IOException
    //   72	76	121	java/io/IOException
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, jox paramjox)
  {
    if (paramjox == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramjox.loaded(null, 1);
      return;
    }
    String str = jpe.dP(paramString1);
    if (TextUtils.isEmpty(str))
    {
      paramjox.loaded(null, 3);
      return;
    }
    JSONObject localJSONObject = b(paramString1);
    if (localJSONObject != null)
    {
      l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - d(paramContext, paramString1)) / 60000L;
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramjox.loaded(null, 5);
        return;
      }
    }
    if (BidDownloader.isDownloading(paramString1))
    {
      paramjox.loaded(null, 7);
      return;
    }
    BidDownloader.kZ(paramString1);
    str = str + paramString1 + ".zip";
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    jdField_a_of_type_Jpl.runOnSubThread(new HtmlOffline.6(paramContext, paramString2, paramString1, str, l1, paramjox, localHashMap));
  }
  
  protected static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = Integer.valueOf(paramString1).intValue();
        if (paramString3 != null) {
          break label292;
        }
        paramString1 = "";
        paramString3 = "";
        try
        {
          if (mApplicationContext == null) {
            mApplicationContext = BaseApplicationImpl.getContext();
          }
          String str = mApplicationContext.getPackageManager().getPackageInfo(mApplicationContext.getPackageName(), 0).versionName;
          paramString3 = str;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        j = paramInt2;
        if (paramInt2 == -1)
        {
          j = paramInt2;
          if (mApplicationContext != null) {
            j = jqi.getNetworkType(mApplicationContext);
          }
        }
        if (aba)
        {
          jqm.a(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, i, paramInt1, "" + paramLong, "3", "" + j, paramString1);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        i = -1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 2, "reportDownTime qver=" + paramString3 + ", mainAction=" + paramString2 + ", bid=" + i + ", code=" + paramInt1 + ", time=" + paramLong + ", netType=" + j + ", ex5=" + paramString1);
      return;
      label292:
      paramString1 = paramString3;
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, paramAppRuntime, true, c);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, jox paramjox)
  {
    if (paramjox == null) {
      return;
    }
    jdField_a_of_type_Jpl.C(new HtmlOffline.2(paramString, paramAppRuntime, paramjox));
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramString);
    paramString = new HashMap(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = b(str);
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.put(str, localObject2);
        }
      }
      else
      {
        paramString.put(str, "0");
      }
    }
    a(paramAppRuntime, paramString, paramjox, paramBoolean, false, false);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean, int paramInt)
  {
    a(paramString, paramAppRuntime, paramjox, paramBoolean, 5, false);
  }
  
  @Deprecated
  public static void a(String paramString, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    b(paramString, paramAppRuntime, paramjox, true, paramInt, paramBoolean2);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, jox paramjox)
  {
    if (jdField_a_of_type_Jpj.isColorLevel()) {
      jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUp,url=" + paramString + ",callback=" + paramjox);
    }
    if (paramjox == null) {
      return;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    int j = jml.a(true).aB(paramString);
    int i = j;
    if (j == 0) {
      i = 5;
    }
    a(str, paramAppRuntime, paramjox, paramBoolean, i);
  }
  
  public static void a(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramjox == null) {
      return;
    }
    if ((paramAppRuntime == null) || (paramArrayList.size() == 0))
    {
      paramjox.loaded("{\"r\":-1}", -1);
      return;
    }
    b(paramArrayList, paramAppRuntime, paramjox, paramBoolean1, paramBoolean2);
  }
  
  public static void a(jpj paramjpj)
  {
    jdField_a_of_type_Jpj = paramjpj;
  }
  
  public static void a(jpk paramjpk)
  {
    jdField_a_of_type_Jpk = paramjpk;
  }
  
  public static void a(jpl paramjpl)
  {
    jdField_a_of_type_Jpl = paramjpl;
  }
  
  public static void a(AppRuntime paramAppRuntime, HashMap<String, String> paramHashMap, jox paramjox, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate");
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication().getApplicationContext(), jnl.class);
    localNewIntent.putExtra("cmd", "offlinepkg.check");
    OfflinePkg.ReqBody localReqBody = new OfflinePkg.ReqBody();
    localReqBody.uint32_cmd.set(3);
    localReqBody.uint32_platform.set(3);
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      QLog.d("HtmlCheckUpdate", 1, String.format("check update, QQ Version: %s", new Object[] { "3.4.4.3058" }));
      if (QLog.isColorLevel()) {
        QLog.d("OfflineCheck", 2, "send check" + paramHashMap.toString());
      }
    }
    localReqBody.str_qver.set(ByteStringMicro.copyFrom("3.4.4.3058".getBytes()));
    localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
    i = jqi.getNetworkType(paramAppRuntime.getApplication());
    localReqBody.int32_network.set(i);
    localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
    Iterator localIterator = paramHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = (String)paramHashMap.get(localObject);
      for (;;)
      {
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            k = Integer.valueOf(str).intValue();
            j = i;
            i = k;
            if (j == 0) {
              break;
            }
            localObject = new OfflinePkg.BidPkg();
            ((OfflinePkg.BidPkg)localObject).uint32_bid.set(j);
            ((OfflinePkg.BidPkg)localObject).uint32_pkg_id.add(Integer.valueOf(i));
            localReqBody.st_bid_pkg.add((MessageMicro)localObject);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              int k;
              int j = i;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            continue;
          }
          localNumberFormatException1 = localNumberFormatException1;
          i = 0;
          localNumberFormatException1.printStackTrace();
          k = 0;
          j = i;
          i = k;
          continue;
        }
        catch (Exception localException1)
        {
          j = 0;
        }
        i = 0;
      }
    }
    try
    {
      localNewIntent.putExtra("data", localReqBody.toByteArray());
      localNewIntent.setObserver(new jpc(localNewIntent, paramjox, paramBoolean1, paramBoolean3, paramAppRuntime, paramBoolean2));
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HtmlCheckUpdate", 2, "offline check update exception!", paramAppRuntime);
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, joy paramjoy)
  {
    if (jdField_a_of_type_Jpj.isColorLevel()) {
      jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,url:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str))
    {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,business id is null!");
      }
      return false;
    }
    if (paramContext == null)
    {
      a(str, 3, 0L, 4, "lixian_cover", "0");
      return false;
    }
    if (jpe.dO(str) == null)
    {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,initEnv fail!");
      }
      a(str, 2, 0L, jqi.getNetworkType(paramContext), "lixian_cover", "0");
      return false;
    }
    if (Arrays.asList(bc).contains(str))
    {
      a(str, 4, 0L, jqi.getNetworkType(paramContext), "lixian_cover", "0");
      return false;
    }
    if (jdField_a_of_type_Jpl == null)
    {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,threadManager is null");
      }
      return false;
    }
    jdField_a_of_type_Jpl.D(new HtmlOffline.1(paramContext, paramString, paramjoy));
    return true;
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, joy paramjoy)
  {
    return a(paramContext, "https://" + paramString1 + "?_bid=" + paramString2, paramjoy);
  }
  
  public static void aC(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    paramString = "last_up_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static JSONObject b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str = jpe.dO(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = new File(str + paramString + "/" + "config.json");
        if (paramString.exists()) {
          try
          {
            paramString = new FileInputStream(paramString);
            if (paramString != null) {
              str = jqo.e(paramString);
            }
          }
          catch (IOException paramString)
          {
            try
            {
              paramString.close();
              try
              {
                paramString = new JSONObject(str);
                return paramString;
              }
              catch (JSONException paramString)
              {
                paramString.printStackTrace();
                return null;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
              paramString = paramString;
              paramString.printStackTrace();
              paramString = null;
            }
            catch (IOException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime)
  {
    a(paramString, paramAppRuntime, false, c);
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (jdField_a_of_type_Jpj.isColorLevel()) {
      jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId " + paramString);
    }
    if (paramjox == null) {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId, callback is null!");
      }
    }
    for (;;)
    {
      return;
      if (jpe.dO(paramString) == null)
      {
        if (jdField_a_of_type_Jpj.isColorLevel()) {
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,no sd card!");
        }
        paramjox.loaded(null, 3);
        return;
      }
      if (Arrays.asList(bc).contains(paramString))
      {
        if (jdField_a_of_type_Jpj.isColorLevel()) {
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,do not update");
        }
      }
      else if ((paramInt > 60) || (paramInt < 0))
      {
        if (jdField_a_of_type_Jpj.isColorLevel()) {
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,delayed too long.");
        }
      }
      else
      {
        if ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()))
        {
          QLog.w("HtmlCheckUpdate", 1, "app == null or user not login.");
          return;
        }
        JSONObject localJSONObject = b(paramString);
        long l2 = 30L;
        long l1 = l2;
        if (localJSONObject != null) {}
        try
        {
          l1 = localJSONObject.getLong("frequency");
          l2 = (System.currentTimeMillis() - d(paramAppRuntime.getApplication(), paramString)) / 60000L;
          if (jdField_a_of_type_Jpj.isColorLevel()) {
            jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:checkUpdate check freq:" + l1 + ", time:" + l2);
          }
          if ((!paramBoolean2) && (l2 < l1))
          {
            paramjox.loaded(null, 5);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
          if (BidDownloader.isDownloading(paramString))
          {
            if (jdField_a_of_type_Jpj.isColorLevel()) {
              jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:" + paramString + " is downloading");
            }
            paramjox.loaded(null, 7);
            return;
          }
          aC(paramAppRuntime.getApplication().getApplicationContext(), paramString);
          if (jdField_a_of_type_Jpl == null)
          {
            if (jdField_a_of_type_Jpj.isColorLevel()) {
              jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "threadManager is null");
            }
          }
          else
          {
            HashMap localHashMap = new HashMap(1);
            int i = 0;
            if (localJSONObject != null) {
              i = localJSONObject.optInt("version", 0);
            }
            localHashMap.put(paramString, i + "");
            jdField_a_of_type_Jpl.C(new HtmlOffline.4(paramInt, paramString, paramAppRuntime, localHashMap, paramjox, paramBoolean1, paramBoolean2));
          }
        }
      }
    }
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, jox paramjox)
  {
    a(paramString, paramAppRuntime, paramjox, paramBoolean, 5);
  }
  
  private static void b(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = b(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    a(paramAppRuntime, localHashMap, paramjox, paramBoolean1, paramBoolean2, false);
  }
  
  public static void bn(String paramString1, String paramString2)
  {
    stw.oy(paramString2);
    jqo.dn(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, new Object[] { "dealVerifyErroFile fileDir:", paramString1, " mBussinessId:", paramString2 });
    }
  }
  
  protected static void c(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, jox paramjox)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "parseExpire:" + paramString);
    }
    ArrayList localArrayList;
    JSONObject localJSONObject;
    label143:
    int k;
    do
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data");
        localArrayList = new ArrayList();
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject != null) {
            break label143;
          }
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i("HtmlCheckUpdate", 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      k = localJSONObject.optInt("code");
    } while ((k <= 0) || (k >= 10));
    int m = localJSONObject.optInt("bid");
    localArrayList.add(m + "");
    BidDownloader localBidDownloader = new BidDownloader(m + "", paramAppRuntime, paramjox, true, k);
    localBidDownloader.ver = localJSONObject.optInt("id");
    if (localJSONObject.optInt("isWifi", 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localBidDownloader.aaY = bool;
      localBidDownloader.aaT = paramBoolean;
      localBidDownloader.url = localJSONObject.optString("url");
      localBidDownloader.aCy = localJSONObject.optInt("filesize");
      localBidDownloader.yh();
      break;
    }
  }
  
  /* Error */
  protected static boolean c(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: invokevirtual 229	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 235	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: new 840	java/io/FileOutputStream
    //   21: dup
    //   22: new 116	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 841	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: sipush 4096
    //   37: newarray byte
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 845	java/io/InputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: iconst_m1
    //   48: if_icmpne +29 -> 77
    //   51: aload_2
    //   52: invokevirtual 848	java/io/FileOutputStream:flush	()V
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 246	java/io/InputStream:close	()V
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 849	java/io/FileOutputStream:close	()V
    //   71: iconst_1
    //   72: istore 4
    //   74: iload 4
    //   76: ireturn
    //   77: aload_2
    //   78: aload_1
    //   79: iconst_0
    //   80: iload_3
    //   81: invokevirtual 853	java/io/FileOutputStream:write	([BII)V
    //   84: goto -44 -> 40
    //   87: astore 5
    //   89: aload_0
    //   90: astore_1
    //   91: aload_2
    //   92: astore_0
    //   93: aload 5
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 246	java/io/InputStream:close	()V
    //   108: aload_0
    //   109: ifnull -35 -> 74
    //   112: aload_0
    //   113: invokevirtual 849	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload 5
    //   126: astore_2
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 246	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 849	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: goto -83 -> 63
    //   149: astore_0
    //   150: goto -79 -> 71
    //   153: astore_1
    //   154: goto -46 -> 108
    //   157: astore_0
    //   158: goto -23 -> 135
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore_1
    //   166: aload 5
    //   168: astore_2
    //   169: goto -42 -> 127
    //   172: astore_1
    //   173: goto -46 -> 127
    //   176: astore_2
    //   177: aload_1
    //   178: astore 5
    //   180: aload_2
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload 5
    //   186: astore_0
    //   187: goto -60 -> 127
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_0
    //   193: aload 6
    //   195: astore_1
    //   196: goto -100 -> 96
    //   199: astore_2
    //   200: aconst_null
    //   201: astore 5
    //   203: aload_0
    //   204: astore_1
    //   205: aload 5
    //   207: astore_0
    //   208: goto -112 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   0	211	1	paramString1	String
    //   0	211	2	paramString2	String
    //   45	36	3	i	int
    //   7	68	4	bool	boolean
    //   1	1	5	localObject1	Object
    //   87	80	5	localIOException	IOException
    //   178	28	5	str	String
    //   4	190	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	40	87	java/io/IOException
    //   40	46	87	java/io/IOException
    //   51	55	87	java/io/IOException
    //   77	84	87	java/io/IOException
    //   112	116	118	java/io/IOException
    //   9	18	121	finally
    //   59	63	145	java/io/IOException
    //   67	71	149	java/io/IOException
    //   104	108	153	java/io/IOException
    //   131	135	157	java/io/IOException
    //   139	143	161	java/io/IOException
    //   18	34	165	finally
    //   34	40	172	finally
    //   40	46	172	finally
    //   51	55	172	finally
    //   77	84	172	finally
    //   96	100	176	finally
    //   9	18	190	java/io/IOException
    //   18	34	199	java/io/IOException
  }
  
  protected static long d(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 4).getLong("last_up_" + paramString, 0L);
  }
  
  public static String dL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return null;
        paramString = b(paramString);
      } while (paramString == null);
      l1 = System.currentTimeMillis();
      l2 = paramString.optLong("expired", 0L);
    } while ((l2 > 0L) && (l1 > l2));
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected static String dM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if ((i < paramString.length) && (i < 100))
          {
            Object localObject = paramString[i];
            JSONObject localJSONObject;
            if ((localObject.isDirectory()) && (TextUtils.isDigitsOnly(localObject.getName())))
            {
              localJSONObject = b(localObject.getName());
              if (localJSONObject == null) {}
            }
            try
            {
              localStringBuffer.append(localObject.getName() + "|" + localJSONObject.getString("version") + ",");
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String dN(String paramString)
  {
    String str = "file://" + jpe.hP();
    if ((paramString == null) || (!paramString.startsWith(str))) {
      return "";
    }
    paramString = paramString.substring(str.length());
    int i = paramString.indexOf('/');
    if (i <= 0) {
      return "";
    }
    try
    {
      Integer.parseInt(paramString.substring(0, i), 10);
      paramString = paramString.substring(i + 1);
      if (paramString.length() > 0) {
        return "https://" + paramString;
      }
    }
    catch (NumberFormatException paramString)
    {
      return "";
    }
    return "";
  }
  
  protected static boolean dg(String paramString)
  {
    String str1 = jpe.dP(paramString);
    str1 = str1 + paramString + ".zip";
    String str2 = jpe.dO(paramString);
    str2 = str2 + paramString;
    File localFile = new File(str2 + "/b.zip");
    if (jdField_a_of_type_Jpj.isColorLevel()) {
      jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "combine zip" + paramString);
    }
    paramString = new File(str1);
    if ((localFile.exists()) && (paramString.exists())) {
      try
      {
        if (paramString.isDirectory())
        {
          QLog.e("HtmlCheckUpdate", 1, "FXXX! This is a wrong patch file! " + str1);
          paramString.delete();
          return false;
        }
        boolean bool = BspatchUtil.D(str2 + "/b.zip", str1, str1);
        return bool;
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  protected static boolean dh(String paramString)
  {
    for (;;)
    {
      String str2;
      File localFile2;
      int i;
      try
      {
        if (jdField_a_of_type_Jpj.isColorLevel()) {
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip start:" + paramString);
        }
        bool1 = TextUtils.isEmpty(paramString);
        if (bool1)
        {
          bool1 = false;
          return bool1;
        }
        String str1 = jpe.dP(paramString);
        if (TextUtils.isEmpty(str1))
        {
          if (!jdField_a_of_type_Jpj.isColorLevel()) {
            break label538;
          }
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,zip root dir is null:");
          break label538;
        }
        str1 = str1 + paramString + ".zip";
        File localFile1 = new File(str1);
        if (!localFile1.exists())
        {
          if (!jdField_a_of_type_Jpj.isColorLevel()) {
            break label543;
          }
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip:no zip ! : businessId:" + paramString);
          break label543;
        }
        String str3 = jpe.dO(paramString);
        str2 = str3 + paramString;
        str3 = str3 + paramString + "_new";
        jqo.dn(str3);
        localFile2 = new File(str3);
        if (!localFile2.mkdirs())
        {
          if (!jdField_a_of_type_Jpj.isColorLevel()) {
            break label548;
          }
          jdField_a_of_type_Jpj.d("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,mkdirs: error:" + str3);
          break label548;
        }
        long l = System.currentTimeMillis();
        i = jqp.unZipFolder(str1, str3);
        if (i > 0)
        {
          if (aCz == 0) {
            aCz = 2;
          }
          jqo.deleteFile(str1);
          a(paramString, 13, 0L, i, "lixian_update", "0");
          if (!jdField_a_of_type_Jpj.isColorLevel()) {
            break label533;
          }
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,unZipFolder fail!");
          bool2 = false;
          bool1 = bool2;
          if (!jdField_a_of_type_Jpj.isColorLevel()) {
            continue;
          }
          jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "-->offline:time of unzip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + bool2);
          bool1 = bool2;
          continue;
        }
        localFile1.renameTo(new File(str3 + "/b.zip"));
      }
      finally {}
      jqo.dn(str2);
      boolean bool2 = localFile2.renameTo(new File(str2));
      a(paramString, 13, 0L, i, "lixian_time", "0");
      continue;
      label533:
      bool2 = false;
      continue;
      label538:
      boolean bool1 = false;
      continue;
      label543:
      bool1 = false;
      continue;
      label548:
      bool1 = false;
    }
  }
  
  public static boolean di(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (jdField_a_of_type_Jpj.isColorLevel()) {
        jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
    }
    do
    {
      return false;
      String str = jpe.dO(paramString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString;
      if (!new File(str).exists()) {
        return true;
      }
      if (jqj.F(str, paramString)) {
        return true;
      }
      bn(str, paramString);
    } while (!jdField_a_of_type_Jpj.isColorLevel());
    jdField_a_of_type_Jpj.i("HtmlCheckUpdate", 2, "verfySign fail :" + paramString);
    return false;
  }
  
  public static boolean dj(String paramString)
  {
    String str = jpe.dP(paramString);
    return new File(str + paramString + ".zip").exists();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    paramString = "expire_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static String getFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf(":");
    } while ((i < 0) || (i + 3 >= paramString.length()));
    String[] arrayOfString = paramString.substring(i + 3).split("\\?");
    paramString = arrayOfString;
    if (arrayOfString[0].contains("#")) {
      paramString = arrayOfString[0].split("\\#");
    }
    return paramString[0];
  }
  
  public static String hN()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = dM(jpe.hP());
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str);
      }
    }
    if (mApplicationContext == null) {
      mApplicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    String str = dM(jpe.hO());
    if (!TextUtils.isEmpty(str))
    {
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append(str);
    }
    if (jdField_a_of_type_Jpj.isColorLevel()) {
      jdField_a_of_type_Jpj.d("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static void init()
  {
    if (mApplicationContext == null)
    {
      a(new jql());
      a(new jpn());
      a(new jpm());
      setApplicationContext(BaseApplicationImpl.getContext());
    }
  }
  
  protected static int l(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 4).getInt("expire_" + paramString, 0);
  }
  
  public static String r(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    if (paramString1.contains("#"))
    {
      String[] arrayOfString = paramString1.split("\\#");
      String str = arrayOfString[0];
      paramString1 = "";
      int i = 1;
      int j = arrayOfString.length;
      while (i < j)
      {
        paramString1 = paramString1 + "#" + arrayOfString[i];
        i += 1;
      }
      if (str.contains("?")) {
        return str.replace("?", new StringBuilder().append("?").append(paramString2).append("&").toString()) + paramString1;
      }
      return str + "?" + paramString2 + paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
    return paramString1 + "?" + paramString2;
  }
  
  public static void setApplicationContext(Context paramContext)
  {
    mApplicationContext = paramContext;
  }
  
  public static class a
  {
    public InputStream g;
    public String mime;
    
    public a(String paramString, InputStream paramInputStream)
    {
      this.mime = paramString;
      this.g = paramInputStream;
    }
  }
  
  public static class b
  {
    private String TQ;
    private joy b;
    private String mBusinessId;
    private Context mContext;
    
    public b(Context paramContext, String paramString, joy paramjoy)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramjoy == null))
      {
        if (jpa.a.isColorLevel()) {
          jpa.a.i("HtmlCheckUpdate", 2, "new TransUrl error");
        }
        return;
      }
      this.mContext = paramContext;
      this.TQ = paramString;
      this.b = paramjoy;
      this.mBusinessId = Uri.parse(paramString).getQueryParameter("_bid");
    }
    
    private void callback(String paramString, int paramInt)
    {
      if (jpa.a.isColorLevel()) {
        jpa.a.i("HtmlCheckUpdate", 2, "transThread callback mode:" + paramInt);
      }
      if (this.b != null) {
        this.b.loaded(paramInt, paramString);
      }
    }
    
    private boolean yj()
    {
      String str = jpe.dP(this.mBusinessId);
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      return jpa.c(this.mContext, "html5/" + this.mBusinessId + "/" + this.mBusinessId + ".zip", str + this.mBusinessId + ".zip");
    }
    
    public void ayS()
    {
      if (jpa.a.isColorLevel()) {
        jpa.a.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl start:" + this.mBusinessId);
      }
      jpa.aCz = 0;
      long l3 = System.currentTimeMillis();
      Object localObject1 = jpe.dO(this.mBusinessId);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (jpa.a.isColorLevel()) {
          jpa.a.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl,html root dir is null!");
        }
        callback(this.TQ, 0);
        jpa.a(this.mBusinessId, 2, 0L, -1, "lixian_cover", "0");
        return;
      }
      String str1 = (String)localObject1 + this.mBusinessId;
      Object localObject3 = jpa.a(this.mContext, this.mBusinessId);
      Object localObject2 = jpa.b(this.mBusinessId);
      int j;
      long l1;
      if (localObject2 != null)
      {
        j = jpa.l(this.mContext, this.mBusinessId);
        i = j;
        if (j != 1)
        {
          l1 = ((JSONObject)localObject2).optLong("expired", 0L);
          i = j;
          if (l1 > 0L)
          {
            i = j;
            if (l3 > l1) {
              i = 1;
            }
          }
        }
        if (i == 1)
        {
          jpa.aCz = 1;
          jqo.dn(str1);
          jpa.e(this.mContext, this.mBusinessId, 0);
          if (jpa.a.isColorLevel()) {
            jpa.a.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
          }
        }
      }
      if (!jpa.dh(this.mBusinessId))
      {
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject2 = jpa.b(this.mBusinessId);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          l1 = ((JSONObject)localObject2).optLong("expired", 0L);
          localObject1 = localObject2;
          if (l1 > 0L)
          {
            localObject1 = localObject2;
            if (l3 > l1)
            {
              if (jpa.aCz == 0) {
                jpa.aCz = 1;
              }
              jqo.dn(str1);
              localObject1 = localObject2;
              if (jpa.a.isColorLevel())
              {
                jpa.a.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl,zip expire =1");
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      int i = 0;
      int k = 0;
      int n = 0;
      if (localObject3 != null)
      {
        j = ((JSONObject)localObject3).optInt("version", 0);
        l1 = ((JSONObject)localObject3).optLong("expired", 0L);
        i = j;
        if (l1 > 0L)
        {
          i = j;
          if (l3 > l1) {
            n = 1;
          }
        }
      }
      for (int m = j;; m = i)
      {
        if (localObject1 != null) {
          k = ((JSONObject)localObject1).optInt("version", 0);
        }
        if ((m == 0) && (k == 0))
        {
          if (jpa.a.isColorLevel()) {
            jpa.a.i("HtmlCheckUpdate", 2, "-->offline:doTransUrl:no package in both asset and data dir!");
          }
          if (jpa.aCz == 0) {
            jpa.aCz = 3;
          }
          jpa.bn(str1, this.mBusinessId);
          callback(this.TQ, 0);
          localObject2 = this.mBusinessId;
          i = jqi.getNetworkType(this.mContext);
          if (localObject1 == null) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            jpa.a((String)localObject2, 5, 0L, i, "lixian_cover", (String)localObject1);
            return;
          }
        }
        if (jpa.a.isColorLevel()) {
          jpa.a.i("HtmlCheckUpdate", 2, "-->offline:getVersion :" + String.valueOf(m) + "," + String.valueOf(k));
        }
        int i1 = 6;
        i = i1;
        localObject2 = localObject1;
        j = k;
        if (k < m)
        {
          i = i1;
          localObject2 = localObject1;
          j = k;
          if (n == 0)
          {
            if (!yj()) {
              break label822;
            }
            if (!jpa.dh(this.mBusinessId)) {
              break label810;
            }
            localObject1 = jpa.b(this.mBusinessId);
            if (localObject1 == null) {
              break label798;
            }
            j = ((JSONObject)localObject1).optInt("version", 0);
            localObject2 = localObject1;
            i = i1;
          }
        }
        if (j < m)
        {
          if (jpa.a.isColorLevel()) {
            jpa.a.i("HtmlCheckUpdate", 2, "-->offline,doTransUrl:SD card update fail.");
          }
          if (jpa.aCz == 0) {
            jpa.aCz = 4;
          }
          jpa.bn(str1, this.mBusinessId);
          callback(this.TQ, 0);
          localObject3 = this.mBusinessId;
          l1 = j;
          j = jqi.getNetworkType(this.mContext);
          if (localObject2 == null) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            jpa.a((String)localObject3, i, l1, j, "lixian_cover", (String)localObject1);
            return;
            label798:
            i = 10;
            localObject2 = localObject1;
            j = k;
            break;
            label810:
            i = 9;
            localObject2 = localObject1;
            j = k;
            break;
            label822:
            i = 8;
            localObject2 = localObject1;
            j = k;
            break;
          }
        }
        i = 1;
        if (localObject2 != null) {
          i = ((JSONObject)localObject2).optInt("loadmode", 1);
        }
        localObject3 = this.TQ;
        String str2 = jpa.getFilePath(this.TQ);
        if (i == 2)
        {
          localObject1 = localObject3;
          if (!((String)localObject3).contains("_lv=")) {
            localObject1 = jpa.r((String)localObject3, "_lv=" + j);
          }
        }
        label917:
        label1453:
        label1456:
        label1471:
        for (;;)
        {
          k = 0;
          if (localObject2 != null) {
            k = ((JSONObject)localObject2).optInt("verifyType", 0);
          }
          boolean bool;
          label998:
          long l2;
          if (new File(str1).exists())
          {
            if (jpa.aR != null) {
              jpa.aR.clear();
            }
            l1 = System.currentTimeMillis();
            if ((i == 2) && (k == 1))
            {
              if (TextUtils.isEmpty(str2)) {
                break label1456;
              }
              bool = jqj.e(str2, str1, this.mBusinessId);
              i = 3;
              l2 = System.currentTimeMillis() - l1;
              l1 = 0L;
              label1009:
              if (bool) {
                break label1453;
              }
              if (jpa.aCz == 0) {
                jpa.aCz = 5;
              }
              jpa.bn(str1, this.mBusinessId);
              localObject1 = this.TQ;
              if (jpa.a.isColorLevel()) {
                jpa.a.i("HtmlCheckUpdate", 2, "-->offline:trans VerifyFile fail :" + this.mBusinessId);
              }
              i = 0;
              j = 0;
            }
          }
          for (;;)
          {
            callback((String)localObject1, i);
            if (j > 0)
            {
              long l4 = System.currentTimeMillis();
              jpa.a(this.mBusinessId, 0, j, -1, "lixian_cover", "" + (l4 - l3));
              if (jpa.a.isColorLevel()) {
                jpa.a.i("HtmlCheckUpdate", 2, "trans time:" + (l4 - l3));
              }
              if (l2 > 0L)
              {
                jpa.a(this.mBusinessId, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
                return;
                k = this.TQ.indexOf(":");
                localObject1 = this.TQ.substring(k + 3);
                localObject3 = "file://" + str1 + "/" + (String)localObject1;
                localObject1 = localObject3;
                if (!((String)localObject3).contains("_lv=")) {
                  localObject1 = jpa.r((String)localObject3, "_lv=" + j + "&_t=" + System.currentTimeMillis());
                }
                if (new File(str1 + "/" + str2).exists()) {
                  break label1471;
                }
                localObject1 = this.TQ;
                break label917;
                bool = jqj.D(str1, this.mBusinessId);
                l4 = System.currentTimeMillis();
                l2 = 0L;
                l1 = l4 - l1;
                break label1009;
              }
              if (l1 <= 0L) {
                break;
              }
              jpa.a(this.mBusinessId, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
              return;
            }
            jpa.a(this.mBusinessId, 7, j, jqi.getNetworkType(this.mContext), "lixian_cover", "0");
            return;
            continue;
            bool = false;
            break label998;
            l2 = 0L;
            l1 = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpa
 * JD-Core Version:    0.7.0.1
 */