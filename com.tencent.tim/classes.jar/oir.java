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
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RockDownloadInfo;
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

public class oir
{
  private static oiq b;
  private static oiq c;
  private static WSDownloadParams d;
  public static final HashMap<String, String> eL = new HashMap();
  private static HashMap<String, Integer> eM = new HashMap();
  private static String sProcessName;
  
  private static boolean GT()
  {
    return (ohy.a().GP()) && (!TextUtils.isEmpty(ohy.a().lq())) && (ohy.a().lq().startsWith("http"));
  }
  
  public static boolean GU()
  {
    ooz.i("WeishiDownloadUtil", "getPreDownloadingClick");
    return LocalMultiProcConfig.getBool("preDownloadingClick", false);
  }
  
  private static RockDownloadInfo a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramArrayList.next();
      if ((localRockDownloadInfo.businessName.equals(paramRockDownloadInfo.businessName)) && (localRockDownloadInfo.packageName.equals(paramRockDownloadInfo.packageName)) && (localRockDownloadInfo.realVersionCode >= paramRockDownloadInfo.versionCode) && (localRockDownloadInfo.versionCode >= paramRockDownloadInfo.versionCode))
      {
        ooz.i("WeishiDownloadUtil", "Rock包版本大于或等于要下载的版本，有效~~~");
        return localRockDownloadInfo;
      }
    }
    return null;
  }
  
  private static ArrayList<RockDownloadInfo> a(oij paramoij, RockDownloadInfo paramRockDownloadInfo)
  {
    ArrayList localArrayList = adxc.a(paramRockDownloadInfo);
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
        paramoij.a(localRockDownloadInfo);
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
  
  private static oiq a(int paramInt1, int paramInt2)
  {
    if (b != null)
    {
      if (!isDownloading()) {
        uG(paramInt1);
      }
      setEventType(paramInt2);
      return b;
    }
    uG(paramInt1);
    setEventType(paramInt2);
    b = new ois();
    arvv.a().a(b);
    return b;
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, oiq paramoiq, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    paramoiq = new oij(paramActivity);
    if (!rpc.ak(paramActivity)) {
      if (!a(paramWSDownloadParams, paramoiq, paramoiq.a(), 3)) {}
    }
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        if ((!ohy.a().GQ()) || (!oof.n(paramActivity))) {
          break;
        }
        ooz.e("WeishiDownloadUtil", "B链路点击 延迟执行厂商下载");
        LocalMultiProcConfig.putBool("need_appstore_download", true);
      } while (!isDownloading());
      if ((ohy.a().GR()) && (isWifi()))
      {
        ooz.w("WeishiDownloadUtil", "当前有下载的Rock任务,开始中断-----");
        paramActivity = ohy.a().lq();
        arvz.a().dz(paramActivity, false);
        return;
      }
      paramActivity = ohy.a().lr();
      ooz.w("WeishiDownloadUtil", "当当前有QQ下载的任务,开始中断~~");
      arvz.a().dz(paramActivity, false);
      return;
      paramoiq = new oij(paramActivity);
      localRockDownloadInfo = paramoiq.a();
    } while (a(paramWSDownloadParams, paramoiq, localRockDownloadInfo, 2));
    if ((!ohy.a().GM()) && (!isWifi()))
    {
      ooz.e("WeishiDownloadUtil", "不可以在非WIFI环境下，静默下载微视");
      return;
    }
    if (isDownloading())
    {
      ooz.e("WeishiDownloadUtil", "当前有正在下载的任务,不响应静默下载请求");
      if ((ohy.a().GR()) && (isWifi()))
      {
        setEventType(2);
        return;
      }
      ong.a(true, paramWSDownloadParams);
      ong.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 2, 1, 2, 0);
      return;
    }
    ooz.e("WeishiDownloadUtil", "执行QQ或Rock下载");
    setEventType(2);
    if (ohy.a().GR())
    {
      paramoiq.a(paramActivity, localRockDownloadInfo, 2, paramWSDownloadParams, paramRockDownloadListenerWrapper);
      return;
    }
    a(paramActivity, paramWSDownloadParams, true, 2);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean)
  {
    c(paramActivity, paramWSDownloadParams);
  }
  
  public static void a(Activity paramActivity, oij paramoij, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    c(paramWSDownloadParams.mEventId, paramInt);
    opn.writeEncryptedDeviceIdToClipboard(paramWSDownloadParams.mScheme);
    a(paramActivity, paramWSDownloadParams, paramBoolean, paramInt);
  }
  
  private static void a(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2, String paramString)
  {
    ooz.e("WeishiDownloadUtil", paramString + " onDownloadFinish info = " + paramDownloadInfo);
    ooz.e("WeishiDownloadUtil", paramString + " onDownloadFinish eventId:" + paramInt1 + ",eventType:" + paramInt2);
    int i;
    if (b(paramDownloadInfo))
    {
      if (paramInt2 != 3) {
        break label255;
      }
      oik.beW();
      ooz.w("WeishiDownloadUtil", paramString + " onDownloadFinish ACTIVE closeDownloadDialog");
      i = 1;
      ong.ak(paramInt1, true);
      ong.uN(2);
      WSPublicAccReport.getInstance().reportDownload(rk(), paramInt2, 2, 2, 0);
      if (paramDownloadInfo.isAutoInstall) {
        WSPublicAccReport.getInstance().reportDownload(rk(), paramInt2, 2, 2, 1);
      }
      if (paramInt1 != 8) {
        break label423;
      }
      ond.a(132, 10, null);
    }
    for (;;)
    {
      if (eM.containsKey(paramDownloadInfo.urlStr))
      {
        eM.remove(paramDownloadInfo.urlStr);
        ooz.e("WeishiDownloadUtil", paramString + " onDownloadFinish remove retryCount!");
      }
      if (i != 0)
      {
        paramString = bK(ohy.a().rt());
        a(d, paramInt2, paramString);
      }
      ba(paramDownloadInfo.urlStr, ohy.a().rt());
      return;
      label255:
      if (paramInt2 == 2)
      {
        if (ohy.a().rp() == 2)
        {
          ofv.beL += 1;
          ooz.d("WeishiDownloadUtil", paramString + " onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ofv.beL);
          i = 1;
          break;
        }
        ooz.i("WeishiDownloadUtil", "processDownloadFinish, this is maybe DTest silent download,linktype is :" + ohy.a().rp());
        i = 1;
        break;
      }
      if (GU())
      {
        qI(false);
        ooz.e("WeishiDownloadUtil", paramString + " 预下载中用户点击了钩子，下载完成需弹起安装！！！ByQQ");
        i = 1;
        break;
      }
      ooz.e("WeishiDownloadUtil", paramString + " 正常预下载无需安装");
      i = 0;
      break;
      label423:
      if (paramInt1 == 401) {
        ond.a(138, 1, null);
      }
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null))
    {
      ooz.d("startQQDownload: activity is null Or params is null:");
      return false;
    }
    ooz.d("downloadWeishi:" + paramWSDownloadParams);
    String str = ohy.a().lr();
    c(paramWSDownloadParams.mEventId, paramInt);
    opn.writeEncryptedDeviceIdToClipboard(paramWSDownloadParams.mScheme);
    return a(paramActivity, str, paramBoolean, false, paramWSDownloadParams, paramInt);
  }
  
  private static boolean a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    ooz.i("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    beY();
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, "10261931");
    localBundle.putString(aryv.PARAM_APPNAME, "");
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, "com.tencent.weishi");
    localBundle.putString(aryv.PARAM_URL, paramString);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, false);
    paramString = aryv.PARAM_BLOCK_NOTIFY;
    if (!paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localBundle.putBoolean(paramString, paramBoolean1);
      arvz.a().d(paramActivity, localBundle, "biz_src_jc_gzh_weishi", null, 0);
      d = paramWSDownloadParams;
      ong.a(true, paramWSDownloadParams);
      ong.a(paramWSDownloadParams, 2);
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      return true;
    }
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, int paramInt, String paramString)
  {
    if (arxn.d(aroi.a().getContext(), paramString, "biz_src_jc_gzh_weishi", ""))
    {
      ooz.i("WeishiDownloadUtil", "本地QQ包的版本有效，启动开始安装成功！");
      ong.dC(1, 2);
      paramString = paramWSDownloadParams;
      if (paramWSDownloadParams == null)
      {
        paramString = new WSDownloadParams();
        ooz.e("WeishiDownloadUtil", "WSDownloadParams异常！");
      }
      WSPublicAccReport.getInstance().reportDownload(paramString.mEventId, paramInt, 2, 2, 1);
      if (paramString.mStReportItem == null) {
        paramString.mStReportItem = ond.getInitialReportItem();
      }
      ond.a(115, paramString.mStReportItem.pagetype, paramString.mStReportItem.comment_loctaion, null);
      opn.writeEncryptedDeviceIdToClipboard(paramString.mScheme);
      return true;
    }
    ooz.e("WeishiDownloadUtil", "本地QQ包安装失败,重新下载！");
    return false;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, oij paramoij, RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    ArrayList localArrayList = a(paramoij, paramRockDownloadInfo);
    if (a(localArrayList, paramRockDownloadInfo))
    {
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 1, 0);
      paramRockDownloadInfo = a(localArrayList, paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 1)
        {
          ooz.w("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
          return true;
        }
        if (ohy.a().rp() == 2)
        {
          ofv.beL += 1;
          ooz.w("WeishiDownloadUtil", "CCCCCCCCC onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ofv.beL);
        }
        paramoij.a(paramRockDownloadInfo, 1);
        opn.writeEncryptedDeviceIdToClipboard(paramWSDownloadParams.mScheme);
        ooz.e("WeishiDownloadUtil", "本地Rock包的版本有效，直接安装");
        return true;
      }
    }
    paramoij = bK(ohy.a().rt());
    if (!TextUtils.isEmpty(paramoij))
    {
      ooz.e("WeishiDownloadUtil", "checkAndInstallValidApp QQDownloader apkPath = " + paramoij);
      if (paramInt == 1)
      {
        ooz.w("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
        return true;
      }
      if (ohy.a().rp() == 2)
      {
        ofv.beL += 1;
        ooz.w("WeishiDownloadUtil", "DDDDDDDDDDD onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = " + ofv.beL);
      }
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0);
      c(paramWSDownloadParams.mEventId, paramInt);
      if (a(paramWSDownloadParams, paramInt, paramoij))
      {
        ooz.i("WeishiDownloadUtil", "installApkByQQDownloader！eventId:" + paramWSDownloadParams.mEventId + ",eventType:" + paramInt);
        return true;
      }
    }
    else
    {
      ooz.i("WeishiDownloadUtil", "本地QQ包路径为空！");
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
  
  public static int aV(String paramString)
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
        ooz.i("WeishiDownloadUtil", "versionName:" + localPackageInfo.versionName + ",versionCode:" + localPackageInfo.versionCode);
        return j;
      }
      i = j;
      ooz.w("WeishiDownloadUtil", paramString + "获取 PackageInfo 失败");
      return -1;
    }
    catch (Exception paramString)
    {
      ooz.i("WeishiDownloadUtil", paramString.getLocalizedMessage());
    }
    return i;
  }
  
  private static oiq b(int paramInt1, int paramInt2)
  {
    ooz.i("WeishiDownloadUtil", "createQzoneListener~~~");
    if (c != null)
    {
      if (!isDownloading()) {
        uG(paramInt1);
      }
      setEventType(paramInt2);
      return c;
    }
    uG(paramInt1);
    setEventType(paramInt2);
    c = new oit();
    arvv.a().a(c);
    ooz.i("WeishiDownloadUtil", "qzone registerListener");
    return c;
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 3))
    {
      ooz.e("WeishiDownloadUtil", " 下载器的DB还没准备就绪,重新注册监听，并重试下载一次");
      Integer localInteger;
      if (eM.containsKey(paramDownloadInfo.urlStr))
      {
        localInteger = (Integer)eM.get(paramDownloadInfo.urlStr);
        if (localInteger != null)
        {
          paramInt = localInteger.intValue();
          eM.put(paramDownloadInfo.urlStr, Integer.valueOf(paramInt + 1));
        }
      }
      for (;;)
      {
        localInteger = (Integer)eM.get(paramDownloadInfo.urlStr);
        if (localInteger == null) {
          break;
        }
        ooz.e("WeishiDownloadUtil", "onDownloadError retryCount = " + localInteger);
        if (localInteger.intValue() <= 3) {
          break;
        }
        ooz.e("WeishiDownloadUtil", "重试次数已经达到3次，中止！");
        return;
        eM.put(paramDownloadInfo.urlStr, Integer.valueOf(1));
      }
      ThreadManager.getUIHandler().postDelayed(new WeishiDownloadUtil.3(paramDownloadInfo), 2000L);
      return;
    }
    ooz.e("WeishiDownloadUtil", "下载器其他错误");
  }
  
  public static boolean b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    qI(false);
    if (rpw.isWeishiInstalled(paramActivity))
    {
      ooz.e("WeishiDownloadUtil", "本地已经安装微视app");
      return false;
    }
    if (!GT())
    {
      ooz.e("WeishiDownloadUtil", "预下载开关没打开");
      return false;
    }
    oij localoij = new oij(paramActivity);
    RockDownloadInfo localRockDownloadInfo = localoij.a();
    setEventType(1);
    if (a(paramWSDownloadParams, localoij, localRockDownloadInfo, 1)) {
      return false;
    }
    if ((ohy.a().GR()) && (isWifi()))
    {
      localoij.a(paramActivity, localRockDownloadInfo, 1, paramWSDownloadParams, null);
      return true;
    }
    ooz.w("WeishiDownloadUtil", "用QQ预下载兜底~");
    c(99, 1);
    a(paramActivity, paramWSDownloadParams, false, 1);
    return true;
  }
  
  private static boolean b(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (TextUtils.equals(paramDownloadInfo.packageName, "com.tencent.weishi")) && (paramDownloadInfo.urlStr != null) && (paramDownloadInfo.urlStr.startsWith(lw()));
  }
  
  private static String bK(int paramInt)
  {
    Object localObject2 = arvv.a().z("com.tencent.weishi", 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = arvv.a().y("com.tencent.weishi", 4);
    }
    localObject2 = aryy.a().c("10261931");
    if (localObject2 != null)
    {
      ((DownloadInfo)localObject2).setState(4);
      ((List)localObject1).add(localObject2);
    }
    ooz.i("WeishiDownloadUtil", ">existValidQQDownloadWeishiApk, info:" + localObject1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DownloadInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        ooz.e("WeishiDownloadUtil", "downloadInfo 's url: " + ((DownloadInfo)localObject2).urlStr);
        if ((((DownloadInfo)localObject2).getState() == 4) && (TextUtils.equals(((DownloadInfo)localObject2).packageName, "com.tencent.weishi")) && (((DownloadInfo)localObject2).urlStr != null) && (((DownloadInfo)localObject2).urlStr.startsWith(lw()))) {
          if (TextUtils.isEmpty(((DownloadInfo)localObject2).filePath))
          {
            ooz.i("WeishiDownloadUtil", "QQ下载包filePath为空!!!");
          }
          else
          {
            int i = aV(((DownloadInfo)localObject2).filePath);
            ooz.i("WeishiDownloadUtil", "判断QQ下载包有没有过期，apkVersionCode：" + i + ",targetVersion:" + paramInt);
            if (i >= paramInt)
            {
              ooz.i("WeishiDownloadUtil", "本地包版本(" + i + ")大于或等于要下载的版本" + paramInt + ")，直接安装~~~");
              return ((DownloadInfo)localObject2).filePath;
            }
          }
        }
      }
      else
      {
        ooz.e("WeishiDownloadUtil", "downloadInfo is null");
      }
    }
    return "";
  }
  
  private static void ba(String paramString, int paramInt)
  {
    Object localObject2 = arvv.a().E();
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
        if ((localObject2 != null) && (((DownloadInfo)localObject2).packageName.equals("com.tencent.weishi")) && (((DownloadInfo)localObject2).urlStr != null) && (((DownloadInfo)localObject2).urlStr.startsWith(lw())) && (!((DownloadInfo)localObject2).urlStr.equals(paramString))) {
          if ((((DownloadInfo)localObject2).getState() == 4) && (aV(((DownloadInfo)localObject2).filePath) < paramInt))
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
            if (System.currentTimeMillis() - ((DownloadInfo)localObject2).time > 2592000000L) {
              if (((DownloadInfo)localObject2).time > localObject3.time)
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
        ooz.e("WeishiDownloadUtil", "删除了info:" + ((DownloadInfo)localObject1).urlStr);
        arvv.a().N(((DownloadInfo)localObject1).urlStr, false);
      }
    }
  }
  
  public static void beX()
  {
    ooz.i("WeishiDownloadUtil", "resetDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", false);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", 0L);
  }
  
  public static void beY()
  {
    ooz.i("WeishiDownloadUtil", "updateDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", true);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", System.currentTimeMillis());
  }
  
  public static oiq c(int paramInt1, int paramInt2)
  {
    if (isQzoneProcess()) {
      return b(paramInt1, paramInt2);
    }
    return a(paramInt1, paramInt2);
  }
  
  public static void c(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramActivity == null) || (paramWSDownloadParams == null)) {
      ooz.i("WeishiDownloadUtil", "rock download activity or params is null");
    }
    oij localoij;
    RockDownloadInfo localRockDownloadInfo;
    do
    {
      do
      {
        return;
        ooz.e("WeishiDownloadUtil", "WSDownloadParams:" + paramWSDownloadParams.toString());
        localoij = new oij(paramActivity);
        if (rpc.ak(paramActivity)) {
          break;
        }
      } while (!a(paramWSDownloadParams, localoij, localoij.a(), 3));
      return;
      if (isDownloading())
      {
        qI(true);
        ooz.e("WeishiDownloadUtil", "当前有正在下载的任务,不响应钩子下载请求,但更改下载类型为主动下载");
        if ((ohy.a().GR()) && (isWifi()))
        {
          setEventType(3);
          return;
        }
        c(paramWSDownloadParams.mEventId, 3);
        ong.a(true, paramWSDownloadParams);
        ong.a(paramWSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 1, 2, 0);
        oik.aX(paramActivity);
        return;
      }
      if ((ohy.a().GQ()) && (oof.n(paramActivity)))
      {
        ooz.e("WeishiDownloadUtil", "主动点击 执行厂商下载-----");
        oof.aY(paramActivity);
        setEventType(3);
        opn.writeEncryptedDeviceIdToClipboard(paramWSDownloadParams.mScheme);
        paramWSDownloadParams.mStReportItem = ond.getInitialReportItem();
        oik.a(115, paramWSDownloadParams);
        ong.a(false, paramWSDownloadParams);
        ong.a(paramWSDownloadParams, 3);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 0, 3, 0);
        arvu.u(paramActivity, paramWSDownloadParams.mScheme, "com.tencent.weishi", "biz_src_jc_gzh_weishi");
        return;
      }
      localRockDownloadInfo = localoij.a();
    } while (a(paramWSDownloadParams, localoij, localRockDownloadInfo, 3));
    setEventType(3);
    if ((!ohy.a().GM()) && (!isWifi()))
    {
      ooz.i("WeishiDownloadUtil", "服务器关闭了4g开关");
      oik.b(paramActivity, paramWSDownloadParams);
      return;
    }
    ooz.i("WeishiDownloadUtil", "服务器打开了4g");
    if (ohy.a().GR())
    {
      localoij.a(paramActivity, localRockDownloadInfo, 3, paramWSDownloadParams, null);
      return;
    }
    oik.a(paramActivity, paramWSDownloadParams);
  }
  
  public static String e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label72;
      }
      label8:
      if (paramInt3 <= 0) {
        break label77;
      }
    }
    for (;;)
    {
      String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3;
      str = (String)eL.get(str);
      if (TextUtils.isEmpty(str)) {
        break label82;
      }
      return str;
      paramInt1 = 0;
      break;
      label72:
      paramInt2 = 0;
      break label8;
      label77:
      paramInt3 = 0;
    }
    label82:
    return "204002042";
  }
  
  private static String getCurrentProcessName()
  {
    if (sProcessName != null) {
      return sProcessName;
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
        sProcessName = (String)localObject;
        return localObject;
      }
    }
    return null;
  }
  
  public static int getEventType()
  {
    return LocalMultiProcConfig.getInt("eventType", -1);
  }
  
  public static boolean isDownloading()
  {
    long l = System.currentTimeMillis() - LocalMultiProcConfig.getLong("weishi_downloading_start_time_key", 0L);
    if (l > 120000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = LocalMultiProcConfig.getBool("weishi_downloading_key", false);
      ooz.d("WeishiDownloadUtil", "downloading  = " + bool2 + ", timeout = " + bool1 + ", time passed = " + l / 1000L + "s");
      if ((!bool2) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isQzoneProcess()
  {
    String str = getCurrentProcessName();
    ooz.d("WeishiDownloadUtil", "~~~~~~~~~~~~~~~~~~~~~~~~~currentProcessName:" + str);
    return "com.tencent.mobileqq:qzone".equals(str);
  }
  
  public static boolean isWifi()
  {
    return "wifi".equals(DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase());
  }
  
  public static String lv()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  public static String lw()
  {
    return "https://weseeugg.qq.com/download?channelid=";
  }
  
  private static void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    ooz.e("WeishiDownloadUtil", "qq installSucceed appid = " + paramString1 + ", packageName = " + paramString2);
    int i;
    if ((TextUtils.equals(paramString1, "10261931")) && (TextUtils.equals(paramString2, "com.tencent.weishi")))
    {
      ooz.e("WeishiDownloadUtil", "这是统一的DownloadListener，installSucceed, appId:" + paramString1 + ",packName:" + paramString2);
      arvv.a().b(b);
      ofv.beL = 0;
      if (!paramBoolean) {
        break label157;
      }
      c = null;
      i = rk();
      int j = getEventType();
      ong.ak(i, false);
      ong.uO(2);
      WSPublicAccReport.getInstance().reportDownload(i, j, 2, 2, 2);
      if (i != 8) {
        break label164;
      }
      ond.a(133, 10, null);
    }
    label157:
    label164:
    while (i != 401)
    {
      return;
      b = null;
      break;
    }
    ond.a(139, 1, null);
  }
  
  public static void qI(boolean paramBoolean)
  {
    ooz.i("WeishiDownloadUtil", "setPreDownloadingClick");
    LocalMultiProcConfig.putBool("preDownloadingClick", paramBoolean);
  }
  
  public static int rk()
  {
    return LocalMultiProcConfig.getInt("eventId", -1);
  }
  
  public static void setEventType(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventType", paramInt);
  }
  
  public static void uG(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventId", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oir
 * JD-Core Version:    0.7.0.1
 */