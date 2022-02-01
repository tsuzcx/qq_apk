import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadReport;", "", "()V", "getApnType", "", "getClickFrom", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getOrigin", "reportAdDownloadClick", "", "context", "Landroid/content/Context;", "state", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/DownloadClickState;", "adInfo", "ex5", "reportBeacon", "action", "downloadInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "reportDownloadFinish", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ufd
{
  public static final ufd a = new ufd();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final int a(AdvertisementInfo paramAdvertisementInfo)
  {
    label16:
    long l;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
      if (paramAdvertisementInfo != null) {
        break label31;
      }
      l = 56;
      if (paramAdvertisementInfo != null) {
        break label42;
      }
    }
    label31:
    label42:
    while (paramAdvertisementInfo.longValue() != l)
    {
      return 3;
      paramAdvertisementInfo = null;
      break;
      if (paramAdvertisementInfo.longValue() != 0L) {
        break label16;
      }
      return 1;
    }
    return 5;
  }
  
  private final String a()
  {
    switch (NetworkUtil.getNetworkType((Context)BaseApplication.getContext()))
    {
    case 5: 
    default: 
      return "非wifi";
    case 1: 
      return "wifi";
    case 0: 
      return "other";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private final int b(AdvertisementInfo paramAdvertisementInfo)
  {
    label16:
    long l;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
      if (paramAdvertisementInfo != null) {
        break label31;
      }
      l = 56;
      if (paramAdvertisementInfo != null) {
        break label42;
      }
    }
    label31:
    label42:
    while (paramAdvertisementInfo.longValue() != l)
    {
      return 1;
      paramAdvertisementInfo = null;
      break;
      if (paramAdvertisementInfo.longValue() != 0L) {
        break label16;
      }
      return 3;
    }
    return 5;
  }
  
  public final void a(@Nullable Context paramContext, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
    {
      if (ufc.e(paramAdvertisementInfo))
      {
        paramContext = "2";
        if (!ufc.e(paramAdvertisementInfo)) {
          break label71;
        }
      }
      label71:
      for (long l = 3010205L;; l = 3010307L)
      {
        ueb.a(JumpMode.UNKNOWN, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
        return;
        paramContext = "1";
        break;
      }
    }
    if (ufc.d(paramAdvertisementInfo))
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.clickPos = 1;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.downloadState = 4;
      }
      uec.a(JumpMode.UNKNOWN, paramContext, paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
      return;
    }
    ois.a(new ufy().a(paramContext).a(5).b(b(paramAdvertisementInfo)).a(paramAdvertisementInfo).d(ois.a(paramAdvertisementInfo, new HashMap())).a());
  }
  
  public final void a(@NotNull Context paramContext, @NotNull DownloadClickState paramDownloadClickState, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    long l = 3010205L;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDownloadClickState, "state");
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    switch (ufe.a[paramDownloadClickState.ordinal()])
    {
    default: 
      return;
    case 1: 
      if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
      {
        if (ufc.e(paramAdvertisementInfo)) {
          if (!ufc.e(paramAdvertisementInfo)) {
            break label143;
          }
        }
        for (paramContext = "1";; paramContext = "0")
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          ueb.a(JumpMode.ANDROID_DOWNLOAD, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
          return;
          l = 3010307L;
          break;
        }
      }
      if (ufc.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD, paramContext, paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
        return;
      }
      uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD, paramContext, paramAdvertisementInfo, 20, 1, a(paramAdvertisementInfo));
      return;
    case 2: 
      if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
      {
        if (ufc.e(paramAdvertisementInfo)) {}
        for (;;)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          ueb.a(JumpMode.ANDROID_DOWNLOAD_PAUSE, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, "8", paramString));
          return;
          l = 3010307L;
        }
      }
      if (ufc.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 2;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_PAUSE, paramContext, paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
        return;
      }
      uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_PAUSE, paramContext, paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
      return;
    case 3: 
      if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
      {
        if (ufc.e(paramAdvertisementInfo)) {}
        for (;;)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          ueb.a(JumpMode.ANDROID_DOWNLOAD_CONTINUE, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, "9", paramString));
          return;
          l = 3010307L;
        }
      }
      if (ufc.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 3;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_CONTINUE, paramContext, paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
        return;
      }
      uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_CONTINUE, paramContext, paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
      return;
    case 4: 
      label143:
      if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
      {
        if (ufc.e(paramAdvertisementInfo)) {}
        for (;;)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          ueb.a(JumpMode.ANDROID_INSTALL, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, "6", paramString));
          return;
          l = 3010307L;
        }
      }
      if (ufc.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 5;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        uec.a(ReportAction.CLICK, JumpMode.ANDROID_INSTALL, paramContext, paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
        return;
      }
      ois.a(new ufy().a(paramContext).a(1).a(JumpMode.ANDROID_INSTALL).b(8).a(paramAdvertisementInfo).d(ois.a(paramAdvertisementInfo, new HashMap())).a());
      return;
    }
    if ((ufc.e(paramAdvertisementInfo)) || (ufc.g(paramAdvertisementInfo)))
    {
      if (ufc.e(paramAdvertisementInfo)) {}
      for (;;)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        ueb.a(JumpMode.ANDROID_OPEN_APP, paramAdvertisementInfo, ois.a(paramAdvertisementInfo), ueb.a(paramAdvertisementInfo, l, 9L, "5", paramString));
        return;
        l = 3010307L;
      }
    }
    if (ufc.d(paramAdvertisementInfo))
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.clickPos = 1;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.downloadState = 6;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
      }
      uec.a(ReportAction.CLICK, JumpMode.ANDROID_OPEN_APP, paramContext, paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
      return;
    }
    ois.a(new ufy().a(paramContext).a(1).b(b(paramAdvertisementInfo)).a(JumpMode.ANDROID_OPEN_APP).a(paramAdvertisementInfo).d(ois.a(paramAdvertisementInfo, new HashMap())).a());
  }
  
  public final void a(@NotNull String paramString, @Nullable uev paramuev)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (paramuev != null)
    {
      localObject = paramuev.a();
      if (localObject != null)
      {
        localHashMap.put("packageName", localObject);
        if (paramuev == null) {
          break label257;
        }
        localObject = paramuev.c();
        if (localObject == null) {
          break label257;
        }
        label52:
        localHashMap.put("appId", localObject);
        if (paramuev == null) {
          break label264;
        }
        localObject = String.valueOf(paramuev.a());
        if (localObject == null) {
          break label264;
        }
        label78:
        localHashMap.put("pkgSize", localObject);
        localHashMap.put("apnType", a.a());
        if (paramuev == null) {
          break label271;
        }
        localObject = Integer.valueOf(paramuev.c());
        label115:
        localHashMap.put("errorCode", String.valueOf(localObject));
        localHashMap.put("action", paramString);
        localObject = new StringBuilder().append("reportDownloadBeacon: packageName = ");
        if (paramuev == null) {
          break label276;
        }
      }
    }
    label257:
    label264:
    label271:
    label276:
    for (paramuev = paramuev.a();; paramuev = null)
    {
      ukq.a("AD_DOWNLOAD_TAG", paramuev + " action = " + paramString);
      paramString = pnn.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "RIJQQAppInterfaceUtil.getQQApp()");
      paramString = StatisticCollector.getInstance((Context)paramString.getApplication());
      paramuev = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramuev, "BaseApplicationImpl.getApplication()");
      paramuev = paramuev.getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(paramuev, "BaseApplicationImpl.getApplication().runtime");
      paramString.collectPerformance("000000EYXY3ATYB3", paramuev.getAccount(), "actKandianAdDownload", true, 0L, 0L, localHashMap, null);
      return;
      localObject = "";
      break;
      localObject = "";
      break label52;
      localObject = "";
      break label78;
      localObject = null;
      break label115;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */