import UserGrowth.stReportItem;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class unq
{
  private static WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  public static final String a;
  public static HashMap<String, String> a;
  private static unp jdField_a_of_type_Unp;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static unp jdField_b_of_type_Unp;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131715914);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.getInt("eventId", -1);
  }
  
  public static int a(String paramString)
  {
    int j = -1;
    int i = j;
    try
    {
      PackageInfo localPackageInfo = BaseApplicationImpl.getApplication().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localPackageInfo != null)
      {
        i = j;
        j = localPackageInfo.versionCode;
        i = j;
        uya.a("WeishiDownloadUtil", "versionName:" + localPackageInfo.versionName + ",versionCode:" + localPackageInfo.versionCode);
        return j;
      }
      i = j;
      uya.c("WeishiDownloadUtil", paramString + "获取 PackageInfo 失败");
      return -1;
    }
    catch (Exception paramString)
    {
      uya.a("WeishiDownloadUtil", paramString.getLocalizedMessage());
    }
    return i;
  }
  
  private static RockDownloadInfo a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramArrayList.next();
      if ((localRockDownloadInfo.businessName.equals(paramRockDownloadInfo.businessName)) && (localRockDownloadInfo.packageName.equals(paramRockDownloadInfo.packageName)) && (localRockDownloadInfo.realVersionCode >= paramRockDownloadInfo.versionCode) && (localRockDownloadInfo.versionCode >= paramRockDownloadInfo.versionCode))
      {
        uya.a("WeishiDownloadUtil", "Rock包版本大于或等于要下载的版本，有效~~~");
        return localRockDownloadInfo;
      }
    }
    return null;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  private static String a(int paramInt)
  {
    Object localObject2 = bhyo.a().b("com.tencent.weishi", 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = bhyo.a().a("com.tencent.weishi", 4);
    }
    localObject2 = biby.a().a("10261931");
    if (localObject2 != null)
    {
      ((DownloadInfo)localObject2).a(4);
      ((List)localObject1).add(localObject2);
    }
    uya.a("WeishiDownloadUtil", ">existValidQQDownloadWeishiApk, info:" + localObject1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DownloadInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        uya.d("WeishiDownloadUtil", "downloadInfo 's url: " + ((DownloadInfo)localObject2).d);
        if ((((DownloadInfo)localObject2).a() == 4) && (TextUtils.equals(((DownloadInfo)localObject2).e, "com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(b()))) {
          if (TextUtils.isEmpty(((DownloadInfo)localObject2).l))
          {
            uya.a("WeishiDownloadUtil", "QQ下载包filePath为空!!!");
          }
          else
          {
            int i = a(((DownloadInfo)localObject2).l);
            uya.a("WeishiDownloadUtil", "判断QQ下载包有没有过期，apkVersionCode：" + i + ",targetVersion:" + paramInt);
            if (i >= paramInt)
            {
              uya.a("WeishiDownloadUtil", "本地包版本(" + i + ")大于或等于要下载的版本" + paramInt + ")，直接安装~~~");
              return ((DownloadInfo)localObject2).l;
            }
          }
        }
      }
      else
      {
        uya.d("WeishiDownloadUtil", "downloadInfo is null");
      }
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label70;
      }
      label8:
      if (paramInt3 <= 0) {
        break label75;
      }
    }
    for (;;)
    {
      String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3;
      str = (String)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (TextUtils.isEmpty(str)) {
        break label80;
      }
      return str;
      paramInt1 = 0;
      break;
      label70:
      paramInt2 = 0;
      break label8;
      label75:
      paramInt3 = 0;
    }
    label80:
    return "204002042";
  }
  
  private static ArrayList<RockDownloadInfo> a(RockDownloadPresenter paramRockDownloadPresenter, RockDownloadInfo paramRockDownloadInfo)
  {
    FileSystemManager.setContext(BaseApplicationImpl.sApplication);
    ArrayList localArrayList = apdf.a(paramRockDownloadInfo);
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return null;
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localArrayList.get(i);
      int j = localRockDownloadInfo.versionCode;
      int k = localRockDownloadInfo.realVersionCode;
      if ((k < paramRockDownloadInfo.versionCode) || (j < paramRockDownloadInfo.versionCode))
      {
        Log.i("WeishiDownloadUtil", "本地已经有的安装包版本太旧，报告服务器删除掉第" + i + "个rockDownloadInfo，此info的versionCode是" + j + ",realVersionCode是:" + k + ",要下载的version是:" + paramRockDownloadInfo.versionCode);
        paramRockDownloadPresenter.a(localRockDownloadInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("WeishiDownloadUtil", "第" + i + "个rockDownloadInfo是正确的，此info的versionCode是" + j + ",realVersionCode是:" + k + ",要下载的version是:" + paramRockDownloadInfo.versionCode);
      }
    }
    return localArrayList;
  }
  
  public static unp a(int paramInt1, int paramInt2)
  {
    if (b()) {
      return c(paramInt1, paramInt2);
    }
    return b(paramInt1, paramInt2);
  }
  
  public static void a()
  {
    uya.a("WeishiDownloadUtil", "resetDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", false);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", 0L);
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventId", paramInt);
  }
  
  public static void a(Activity paramActivity, RockDownloadPresenter paramRockDownloadPresenter, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    a(paramWSDownloadParams.mEventId, paramInt);
    uyo.b(paramWSDownloadParams.mScheme);
    a(paramActivity, paramWSDownloadParams, paramBoolean, paramInt);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null)) {
      uya.a("WeishiDownloadUtil", "rock download activity or params is null");
    }
    RockDownloadPresenter localRockDownloadPresenter;
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        uya.d("WeishiDownloadUtil", "WSDownloadParams:" + paramWSDownloadParams.toString());
        localRockDownloadPresenter = new RockDownloadPresenter();
        if (ypp.b(paramActivity)) {
          break;
        }
      } while (a(paramWSDownloadParams, localRockDownloadPresenter, localRockDownloadPresenter.a(), 3));
      QQToast.a(paramActivity, amtj.a(2131715913), 0).a();
      return;
      if (c())
      {
        a(true);
        uya.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应钩子下载请求,但更改下载类型为主动下载");
        if ((umu.a().d()) && (a()))
        {
          b(3);
          return;
        }
        a(paramWSDownloadParams.mEventId, 3);
        uvr.a(true, paramWSDownloadParams);
        uvr.a(paramWSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 1, 2, 0);
        unj.a(paramActivity);
        return;
      }
      if ((umu.a().c()) && (uxa.a(paramActivity)))
      {
        uya.d("WeishiDownloadUtil", "主动点击 执行厂商下载-----");
        uxa.a(paramActivity);
        b(3);
        uyo.b(paramWSDownloadParams.mScheme);
        paramWSDownloadParams.mStReportItem = uvi.a();
        unj.a(115, paramWSDownloadParams);
        uvr.a(false, paramWSDownloadParams);
        uvr.a(paramWSDownloadParams, 3);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 0, 3, 0);
        bhyn.a(paramActivity, paramWSDownloadParams.mScheme, "com.tencent.weishi", "biz_src_jc_gzh_weishi");
        return;
      }
      localRockDownloadInfo = localRockDownloadPresenter.a();
    } while (a(paramWSDownloadParams, localRockDownloadPresenter, localRockDownloadInfo, 3));
    b(3);
    if ((!umu.a().a()) && (!a()))
    {
      uya.a("WeishiDownloadUtil", "服务器关闭了4g开关");
      unj.b(paramActivity, paramWSDownloadParams);
      return;
    }
    uya.a("WeishiDownloadUtil", "服务器打开了4g");
    if (umu.a().d())
    {
      localRockDownloadPresenter.a(paramActivity, localRockDownloadInfo, 3, paramWSDownloadParams, null);
      return;
    }
    unj.a(paramActivity, paramWSDownloadParams);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, unp paramunp, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    paramunp = new RockDownloadPresenter();
    if (!ypp.b(paramActivity)) {
      if (!a(paramWSDownloadParams, paramunp, paramunp.a(), 3)) {}
    }
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        QQToast.a(paramActivity, amtj.a(2131715913), 0).a();
        return;
        if ((!umu.a().c()) || (!uxa.a(paramActivity))) {
          break;
        }
        uya.d("WeishiDownloadUtil", "B链路点击 延迟执行厂商下载");
        LocalMultiProcConfig.putBool("need_appstore_download", true);
      } while (!c());
      if ((umu.a().d()) && (a()))
      {
        uya.c("WeishiDownloadUtil", "当前有下载的Rock任务,开始中断-----");
        paramActivity = umu.a().c();
        bhys.a().b(paramActivity, false);
        return;
      }
      paramActivity = umu.a().d();
      uya.c("WeishiDownloadUtil", "当当前有QQ下载的任务,开始中断~~");
      bhys.a().b(paramActivity, false);
      return;
      paramunp = new RockDownloadPresenter();
      localRockDownloadInfo = paramunp.a();
    } while (a(paramWSDownloadParams, paramunp, localRockDownloadInfo, 2));
    if ((!umu.a().a()) && (!a()))
    {
      uya.d("WeishiDownloadUtil", "不可以在非WIFI环境下，静默下载微视");
      return;
    }
    if (c())
    {
      uya.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应静默下载请求");
      if ((umu.a().d()) && (a()))
      {
        b(2);
        return;
      }
      uvr.a(true, paramWSDownloadParams);
      uvr.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 2, 1, 2, 0);
      return;
    }
    uya.d("WeishiDownloadUtil", "执行QQ或Rock下载");
    b(2);
    if (umu.a().d())
    {
      paramunp.a(paramActivity, localRockDownloadInfo, 2, paramWSDownloadParams, paramRockDownloadListenerWrapper);
      return;
    }
    a(paramActivity, paramWSDownloadParams, true, 2);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean)
  {
    a(paramActivity, paramWSDownloadParams);
  }
  
  private static void a(String paramString, int paramInt)
  {
    Object localObject2 = bhyo.a().a();
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = null;
      Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (DownloadInfo)localIterator.next();
        if ((localObject2 != null) && (((DownloadInfo)localObject2).e.equals("com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(b())) && (!((DownloadInfo)localObject2).d.equals(paramString))) {
          if ((((DownloadInfo)localObject2).a() == 4) && (a(((DownloadInfo)localObject2).l) < paramInt))
          {
            localArrayList.add(localObject2);
          }
          else
          {
            Object localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = localObject2;
            }
            localObject1 = localObject3;
            if (System.currentTimeMillis() - ((DownloadInfo)localObject2).jdField_a_of_type_Long > 2592000000L) {
              if (((DownloadInfo)localObject2).jdField_a_of_type_Long > localObject3.jdField_a_of_type_Long)
              {
                localArrayList.add(localObject3);
                localObject1 = localObject2;
              }
              else
              {
                localArrayList.add(localObject2);
                localObject1 = localObject3;
              }
            }
          }
        }
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (DownloadInfo)paramString.next();
        uya.d("WeishiDownloadUtil", "删除了info:" + ((DownloadInfo)localObject1).d);
        bhyo.a().b(((DownloadInfo)localObject1).d, false);
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    uya.a("WeishiDownloadUtil", "setPreDownloadingClick");
    LocalMultiProcConfig.putBool("preDownloadingClick", paramBoolean);
  }
  
  public static boolean a()
  {
    return "wifi".equals(DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase());
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    a(false);
    if (yqu.a(paramActivity))
    {
      uya.d("WeishiDownloadUtil", "本地已经安装微视app");
      return false;
    }
    if (!e())
    {
      uya.d("WeishiDownloadUtil", "预下载开关没打开");
      return false;
    }
    RockDownloadPresenter localRockDownloadPresenter = new RockDownloadPresenter();
    RockDownloadInfo localRockDownloadInfo = localRockDownloadPresenter.a();
    b(1);
    if (a(paramWSDownloadParams, localRockDownloadPresenter, localRockDownloadInfo, 1)) {
      return false;
    }
    if ((umu.a().d()) && (a()))
    {
      localRockDownloadPresenter.a(paramActivity, localRockDownloadInfo, 1, paramWSDownloadParams, null);
      return true;
    }
    uya.c("WeishiDownloadUtil", "用QQ预下载兜底~");
    a(99, 1);
    a(paramActivity, paramWSDownloadParams, false, 1);
    return true;
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null))
    {
      uya.a("startQQDownload: activity is null Or params is null:");
      return false;
    }
    uya.a("downloadWeishi:" + paramWSDownloadParams);
    String str = umu.a().d();
    a(paramWSDownloadParams.mEventId, paramInt);
    uyo.b(paramWSDownloadParams.mScheme);
    return a(paramActivity, str, paramBoolean, false, paramWSDownloadParams, paramInt);
  }
  
  private static boolean a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    uya.a("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString(bibw.jdField_b_of_type_JavaLangString, "10261931");
    localBundle.putString(bibw.l, jdField_a_of_type_JavaLangString);
    localBundle.putString(bibw.f, "com.tencent.weishi");
    localBundle.putString(bibw.j, paramString);
    localBundle.putInt(bibw.k, 2);
    localBundle.putBoolean(bibw.h, false);
    paramString = bibw.x;
    if (!paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localBundle.putBoolean(paramString, paramBoolean1);
      bhys.a().a(paramActivity, localBundle, "biz_src_jc_gzh_weishi", null, 0);
      jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
      uvr.a(true, paramWSDownloadParams);
      uvr.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      return true;
    }
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, int paramInt, String paramString)
  {
    if (biam.a(bhpc.a().a(), paramString, "biz_src_jc_gzh_weishi", ""))
    {
      uya.a("WeishiDownloadUtil", "本地QQ包的版本有效，启动开始安装成功！");
      uvr.a(1, 2);
      paramString = paramWSDownloadParams;
      if (paramWSDownloadParams == null)
      {
        paramString = new WSDownloadParams();
        uya.d("WeishiDownloadUtil", "WSDownloadParams异常！");
      }
      WSPublicAccReport.getInstance().reportDownload(paramString.mEventId, paramInt, 2, 2, 1);
      if (paramString.mStReportItem == null) {
        paramString.mStReportItem = uvi.a();
      }
      uvi.a(115, paramString.mStReportItem.pagetype, paramString.mStReportItem.comment_loctaion, null);
      uyo.b(paramString.mScheme);
      return true;
    }
    uya.d("WeishiDownloadUtil", "本地QQ包安装失败,重新下载！");
    return false;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, RockDownloadPresenter paramRockDownloadPresenter, RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    ArrayList localArrayList = a(paramRockDownloadPresenter, paramRockDownloadInfo);
    if (a(localArrayList, paramRockDownloadInfo))
    {
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 1, 0);
      paramRockDownloadInfo = a(localArrayList, paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 1)
        {
          uya.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
          return true;
        }
        if (umu.a().a(1) == 2)
        {
          ukg.b += 1;
          uya.c("WeishiDownloadUtil", "CCCCCCCCC onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ukg.b);
        }
        paramRockDownloadPresenter.a(paramRockDownloadInfo, 1);
        uyo.b(paramWSDownloadParams.mScheme);
        uya.d("WeishiDownloadUtil", "本地Rock包的版本有效，直接安装");
        return true;
      }
    }
    paramRockDownloadPresenter = a(umu.a().c());
    if (!TextUtils.isEmpty(paramRockDownloadPresenter))
    {
      uya.d("WeishiDownloadUtil", "checkAndInstallValidApp QQDownloader apkPath = " + paramRockDownloadPresenter);
      if (paramInt == 1)
      {
        uya.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
        return true;
      }
      if (umu.a().a(1) == 2)
      {
        ukg.b += 1;
        uya.c("WeishiDownloadUtil", "DDDDDDDDDDD onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ukg.b);
      }
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      a(paramWSDownloadParams.mEventId, paramInt);
      if (a(paramWSDownloadParams, paramInt, paramRockDownloadPresenter))
      {
        uya.a("WeishiDownloadUtil", "installApkByQQDownloader！eventId:" + paramWSDownloadParams.mEventId + ",eventType:" + paramInt);
        return true;
      }
    }
    else
    {
      uya.a("WeishiDownloadUtil", "本地QQ包路径为空！");
    }
    return false;
  }
  
  private static boolean a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      do
      {
        return false;
        paramArrayList = a(paramArrayList, paramRockDownloadInfo);
      } while (paramArrayList == null);
      paramArrayList = paramArrayList.localPath;
    } while ((paramArrayList == null) || (TextUtils.isEmpty(paramArrayList)));
    return true;
  }
  
  public static int b()
  {
    return LocalMultiProcConfig.getInt("eventType", -1);
  }
  
  public static String b()
  {
    return "https://weseeugg.qq.com/download?channelid=";
  }
  
  private static unp b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Unp != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_a_of_type_Unp;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_a_of_type_Unp = new unr();
    bhyo.a().a(jdField_a_of_type_Unp);
    return jdField_a_of_type_Unp;
  }
  
  public static void b()
  {
    uya.a("WeishiDownloadUtil", "updateDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", true);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", System.currentTimeMillis());
  }
  
  public static void b(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventType", paramInt);
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 3))
    {
      uya.d("WeishiDownloadUtil", " 下载器的DB还没准备就绪,重新注册监听，并重试下载一次");
      Integer localInteger;
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
      {
        localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
        if (localInteger != null)
        {
          paramInt = localInteger.intValue();
          jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(paramInt + 1));
        }
      }
      for (;;)
      {
        localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
        if (localInteger == null) {
          break;
        }
        uya.d("WeishiDownloadUtil", "onDownloadError retryCount = " + localInteger);
        if (localInteger.intValue() <= 3) {
          break;
        }
        uya.d("WeishiDownloadUtil", "重试次数已经达到3次，中止！");
        return;
        jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(1));
      }
      ThreadManager.getUIHandler().postDelayed(new WeishiDownloadUtil.3(paramDownloadInfo), 2000L);
      return;
    }
    uya.d("WeishiDownloadUtil", "下载器其他错误");
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2, String paramString)
  {
    uya.d("WeishiDownloadUtil", paramString + " onDownloadFinish info = " + paramDownloadInfo);
    uya.d("WeishiDownloadUtil", paramString + " onDownloadFinish eventId:" + paramInt1 + ",eventType:" + paramInt2);
    int i;
    if (b(paramDownloadInfo))
    {
      if (paramInt2 != 3) {
        break label254;
      }
      unj.a();
      uya.c("WeishiDownloadUtil", paramString + " onDownloadFinish ACTIVE closeDownloadDialog");
      i = 1;
      uwc.a(paramInt1);
      uvr.a(2);
      WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 0);
      if (paramDownloadInfo.jdField_a_of_type_Boolean) {
        WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 1);
      }
      if (paramInt1 != 8) {
        break label424;
      }
      uvi.a(132, 10, null);
    }
    for (;;)
    {
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
      {
        jdField_b_of_type_JavaUtilHashMap.remove(paramDownloadInfo.d);
        uya.d("WeishiDownloadUtil", paramString + " onDownloadFinish remove retryCount!");
      }
      if (i != 0)
      {
        paramString = a(umu.a().c());
        a(jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams, paramInt2, paramString);
      }
      a(paramDownloadInfo.d, umu.a().c());
      return;
      label254:
      if (paramInt2 == 2)
      {
        if (umu.a().a(1) == 2)
        {
          ukg.b += 1;
          uya.b("WeishiDownloadUtil", paramString + " onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ukg.b);
          i = 1;
          break;
        }
        uya.a("WeishiDownloadUtil", "processDownloadFinish, this is maybe DTest silent download,linktype is :" + umu.a().a(1));
        i = 1;
        break;
      }
      if (d())
      {
        a(false);
        uya.d("WeishiDownloadUtil", paramString + " 预下载中用户点击了钩子，下载完成需弹起安装！！！ByQQ");
        i = 1;
        break;
      }
      uya.d("WeishiDownloadUtil", paramString + " 正常预下载无需安装");
      i = 0;
      break;
      label424:
      if (paramInt1 == 401) {
        uvi.a(138, 1, null);
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    uya.d("WeishiDownloadUtil", "qq installSucceed appid = " + paramString1 + ", packageName = " + paramString2);
    int i;
    if ((TextUtils.equals(paramString1, "10261931")) && (TextUtils.equals(paramString2, "com.tencent.weishi")))
    {
      uya.d("WeishiDownloadUtil", "这是统一的DownloadListener，installSucceed, appId:" + paramString1 + ",packName:" + paramString2);
      bhyo.a().b(jdField_a_of_type_Unp);
      ukg.b = 0;
      if (!paramBoolean) {
        break label154;
      }
      jdField_b_of_type_Unp = null;
      i = a();
      int j = b();
      uwc.b(i);
      uvr.b(2);
      WSPublicAccReport.getInstance().reportDownload(i, j, 2, 2, 2);
      if (i != 8) {
        break label161;
      }
      uvi.a(133, 10, null);
    }
    label154:
    label161:
    while (i != 401)
    {
      return;
      jdField_a_of_type_Unp = null;
      break;
    }
    uvi.a(139, 1, null);
  }
  
  public static boolean b()
  {
    String str = c();
    uya.b("WeishiDownloadUtil", "~~~~~~~~~~~~~~~~~~~~~~~~~currentProcessName:" + str);
    return "com.tencent.mobileqq:qzone".equals(str);
  }
  
  private static boolean b(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (TextUtils.equals(paramDownloadInfo.e, "com.tencent.weishi")) && (paramDownloadInfo.d != null) && (paramDownloadInfo.d.startsWith(b()));
  }
  
  private static String c()
  {
    if (jdField_b_of_type_JavaLangString != null) {
      return jdField_b_of_type_JavaLangString;
    }
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i)
      {
        localObject = localRunningAppProcessInfo.processName;
        jdField_b_of_type_JavaLangString = (String)localObject;
        return localObject;
      }
    }
    return null;
  }
  
  private static unp c(int paramInt1, int paramInt2)
  {
    uya.a("WeishiDownloadUtil", "createQzoneListener~~~");
    if (jdField_b_of_type_Unp != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_b_of_type_Unp;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_b_of_type_Unp = new uns();
    bhyo.a().a(jdField_b_of_type_Unp);
    uya.a("WeishiDownloadUtil", "qzone registerListener");
    return jdField_b_of_type_Unp;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis() - LocalMultiProcConfig.getLong("weishi_downloading_start_time_key", 0L);
    if (l > 120000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = LocalMultiProcConfig.getBool("weishi_downloading_key", false);
      uya.b("WeishiDownloadUtil", "downloading  = " + bool2 + ", timeout = " + bool1 + ", time passed = " + l / 1000L + "s");
      if ((!bool2) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean d()
  {
    uya.a("WeishiDownloadUtil", "getPreDownloadingClick");
    return LocalMultiProcConfig.getBool("preDownloadingClick", false);
  }
  
  private static boolean e()
  {
    return (umu.a().b()) && (!TextUtils.isEmpty(umu.a().c())) && (umu.a().c().startsWith("http"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unq
 * JD-Core Version:    0.7.0.1
 */