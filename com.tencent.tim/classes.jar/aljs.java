import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x210.submsgtype0x113.SubMsgType0x113.MsgBody;

public class aljs
{
  public static final String DOWNLOAD_PATH = acbn.SDCARD_PATH + "qbosssplahAD/";
  public static aljt a;
  public static final String bWL = acbn.SDCARD_PATH + "qbdownres";
  public static HashMap<String, aljt> mx = new HashMap();
  public static boolean needJump;
  
  public static void Ol(String paramString)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir sub" + paramString);
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir exception" + paramString.toString());
    }
  }
  
  public static void Om(String paramString)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("qboss_pre_download_pref_" + paramString, 0).edit().clear().apply();
    deleteFile(new File(bWL));
  }
  
  public static void S(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 4, " sendQbossSplashReportExpose sQBosstrace:" + paramString1);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), anev.class);
      try
      {
        localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
        localNewIntent.putExtra("qua", avpq.getQUA3());
        localNewIntent.putExtra("sQBosstrace", paramString1);
        localNewIntent.putExtra("iOperType", paramInt);
        localNewIntent.putExtra("sUserID", paramString2);
        localAppRuntime.startServlet(localNewIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "sendQbossSplashReportExpose exception" + paramString1.toString());
    }
  }
  
  public static long Z(String paramString)
  {
    long l = 0L;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToLong exception" + paramString.toString());
    }
    return 0L;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static HashMap<String, aljt> a(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = a(paramContext, paramString);
      paramContext = a(paramContext, paramString).iterator();
      while (paramContext.hasNext())
      {
        String str1 = (String)paramContext.next();
        String str2 = localSharedPreferences.getString("qboss_splash_ad_begin_time_" + str1, "");
        String str3 = localSharedPreferences.getString("qboss_splash_ad_end_time_" + str1, "");
        int i = localSharedPreferences.getInt("qbosss_plash_ad_content_type_" + str1, -1);
        String str4 = localSharedPreferences.getString("qbosss_splash_ad_download_url_" + str1, "");
        int j = localSharedPreferences.getInt("qbosss_splash_ad_jumptype_" + str1, -1);
        String str5 = localSharedPreferences.getString("qbosss_splash_ad_jump_h5_url_" + str1, "");
        int k = localSharedPreferences.getInt("qboss_splash_ad_exposure_platform_" + str1, 0);
        String str6 = localSharedPreferences.getString("qboss_exposure_url_" + str1, "");
        boolean bool1 = localSharedPreferences.getBoolean("qboss_exposure_is_low_device_limit_" + str1, false);
        boolean bool2 = localSharedPreferences.getBoolean("qboss_splash_ad_is_limited_" + str1, false);
        int m = localSharedPreferences.getInt("qboss_splash_ad_showpriority_" + str1, 0);
        String str7 = localSharedPreferences.getString("qboss_splash_info_report_" + str1, "");
        String str8 = localSharedPreferences.getString("qboss_splash_resource_md5_" + str1, "");
        int n = localSharedPreferences.getInt("qboss_splash_should_show_ad_mark_" + str1, 0);
        aljt.a locala = new aljt.a();
        locala.g(paramString).a(str1).b(str2).c(str3).c(i).d(str4).e(k).f(str6).e(str5).d(j).b(bool1).a(bool2).b(m).h(str7).i(str8).a(n);
        QLog.i("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP  adid =" + str1);
        mx.put(str1, locala.a());
      }
      return mx;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP exception" + paramContext.toString());
    }
  }
  
  public static Set<String> a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString).getString("splash_ad_ids", "");
    paramString = new HashSet();
    if (!TextUtils.isEmpty(paramContext)) {
      paramString.addAll(Arrays.asList(paramContext.split(",")));
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds frosm sp  adids =" + paramString);
    return paramString;
  }
  
  public static String b(String paramString, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        Object localObject2 = ((SharedPreferences)localObject1).getString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
        StringBuffer localStringBuffer = new StringBuffer();
        String str = "";
        localObject1 = str;
        int i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = str;
          i = j;
          if (!TextUtils.isEmpty(paramString))
          {
            localObject2 = ((String)localObject2).split(",");
            j = 0;
            i = k;
            localObject1 = str;
            if (j + 2 < localObject2.length)
            {
              str = localObject2[j];
              if ((i == 0) && (paramString.equals(str)))
              {
                i = 1;
                localObject1 = str;
                break label399;
              }
              localStringBuffer.append(localObject2[j]).append(",").append(localObject2[(j + 1)]).append(",").append(localObject2[(j + 2)]).append(",");
              break label399;
            }
            str = "";
            if (localStringBuffer.length() != 0) {
              str = localStringBuffer.substring(0, localStringBuffer.length() - 1);
            }
            QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs result=" + str + "removeid = " + paramString);
            localEditor.putString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, str);
            localEditor.apply();
          }
        }
        str = "";
        paramString = str;
        if (paramBoolean)
        {
          paramString = str;
          if (i != 0) {
            paramString = a(BaseApplicationImpl.getContext(), paramLong + "").getString("qboss_splash_info_report_" + (String)localObject1, "");
          }
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs exception");
        return null;
      }
      label399:
      j += 3;
    }
  }
  
  public static List<String> b(Context paramContext, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    try
    {
      Object localObject = paramContext.getString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
      QLog.i("QSplash@QbossSplashUtil", 1, "idsWithTime = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = new ArrayList();
      }
      String[] arrayOfString;
      int i;
      label173:
      Context localContext;
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfString = ((String)localObject).split(",");
        i = 0;
        for (;;)
        {
          localObject = paramContext;
          if (i + 2 >= arrayOfString.length) {
            break;
          }
          localObject = arrayOfString[i];
          if (bp(arrayOfString[(i + 1)], arrayOfString[(i + 2)]))
          {
            paramContext.add(localObject);
            QLog.i("QSplash@QbossSplashUtil", 1, "permittedAdIDs = " + (String)localObject);
          }
          i += 3;
        }
        localException1 = localException1;
        paramContext = null;
      }
      catch (Exception localException2)
      {
        break label173;
      }
      QLog.e("QSplash@QbossSplashUtil", 1, "getPermittedAdIDs exception" + localException1.toString());
      localContext = paramContext;
      return localContext;
    }
  }
  
  public static void b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong);
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_0");
      localEditor.apply();
      if (paramBoolean) {
        o(paramContext, paramLong);
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanAllConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanAllConfig exception" + paramContext.toString());
    }
  }
  
  public static boolean bp(String paramString1, String paramString2)
  {
    long l1 = Z(paramString2);
    long l2 = Z(paramString1);
    long l3 = NetConnInfoCenter.getServerTime();
    return (l2 < l3) && (l3 < l1);
  }
  
  public static String c(Set<String> paramSet)
  {
    String str = "";
    Object localObject = str;
    if (paramSet != null)
    {
      localObject = str;
      if (paramSet.size() > 0)
      {
        localObject = new StringBuffer();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          ((StringBuffer)localObject).append((String)paramSet.next()).append(",");
        }
        localObject = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1);
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds  adids =" + (String)localObject);
    return localObject;
  }
  
  public static int dK(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToInt exception" + paramString.toString());
    }
    return 0;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        deleteFile(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static void k(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      Object localObject = new SubMsgType0x113.MsgBody();
      ((SubMsgType0x113.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((SubMsgType0x113.MsgBody)localObject).int32_app_id.get();
      int j = ((SubMsgType0x113.MsgBody)localObject).int32_task_id.get();
      int k = ((SubMsgType0x113.MsgBody)localObject).enum_task_op.get();
      if (i == 2742)
      {
        if (k == 1)
        {
          localObject = b(j + "", paramLong, true);
          paramArrayOfByte = (byte[])localObject;
          if (localObject == null) {
            paramArrayOfByte = "";
          }
          S(paramArrayOfByte, null, 10);
          QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 removeid " + j + paramArrayOfByte);
        }
      }
      else if ((i == 2783) && (k == 1))
      {
        Om(String.valueOf(paramLong));
        QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 cleanConfigAndResDir");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 exception" + paramArrayOfByte.toString());
    }
  }
  
  public static void o(Context paramContext, long paramLong)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("qboss_banner_refresh_sp_" + paramLong, 0).edit();
      paramContext.putLong("qbossNextRequestTime_2742", 0L);
      paramContext.apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanRefreshSp ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanRefreshSp exception" + paramContext.toString());
    }
  }
  
  public static boolean ob(String paramString)
  {
    long l = Z(paramString);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public static void p(Context paramContext, long paramLong)
  {
    try
    {
      a(paramContext, paramLong + "").edit().clear().apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig exception" + paramContext.toString());
    }
  }
  
  public static SharedPreferences x()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("qboss_banner_refresh_sp_" + str, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aljs
 * JD-Core Version:    0.7.0.1
 */