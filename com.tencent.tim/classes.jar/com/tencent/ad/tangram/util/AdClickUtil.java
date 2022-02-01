package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.net.a;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.json.JSONObject;

@Keep
public final class AdClickUtil
{
  public static final int ACTION_APP = 5;
  public static final int ACTION_APP_MARKET = 8;
  public static final int ACTION_APP_WITH_DEEPLINK = 4;
  public static final int ACTION_CANVAS = 3;
  public static final int ACTION_QQ_MINI_PROGRAM = 6;
  public static final int ACTION_UNKNOWN = 0;
  public static final int ACTION_VIDEO_CEILING = 2;
  public static final int ACTION_VIDEO_SPLICE = 7;
  public static final int ACTION_WEB = 1;
  public static final int ACTION_WEIXIN_MINI_PROGRAM = 9;
  private static final String TAG = "AdClickUtil";
  
  private static String appendUrlWithAutoDownload(String paramString1, String paramString2, Params paramParams)
  {
    String str;
    if ((paramParams == null) || (!paramParams.isValid()) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AdLog.e("AdClickUtil", "appendUrlWithAutoDownload error");
      str = null;
    }
    Uri localUri;
    Uri.Builder localBuilder;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str;
              str = paramString1;
            } while (!canAppAutoDownload(paramParams));
            localUri = AdUriUtil.parse(paramString1);
            str = paramString1;
          } while (localUri == null);
          localBuilder = localUri.buildUpon();
          str = paramString1;
        } while (localBuilder == null);
        str = paramString1;
      } while (!paramParams.ad.isAppProductType());
      if (paramParams.ad.isAppXiJingDefault()) {
        break;
      }
      str = paramString1;
    } while (!paramParams.ad.isAppXiJing());
    paramString1 = localBuilder;
    if (AdUriUtil.getQueryParameter(localUri, paramString2) == null) {
      paramString1 = localBuilder.appendQueryParameter(paramString2, "1");
    }
    return paramString1.toString();
  }
  
  private static boolean canAppAutoDownload(Params paramParams)
  {
    return (isValidForApp(paramParams)) && (paramParams.enableAutoDownload) && (a.getType((Context)paramParams.activity.get()) == 1);
  }
  
  private static a getBaseURLObject(Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid())) {
      return null;
    }
    a locala = new a();
    if (!paramParams.reportForClick)
    {
      locala.url = appendUrlWithAutoDownload(replaceUrlWithClickLpp(paramParams.ad.getUrlForLandingPage()), "autodownload", paramParams);
      locala.type = 2;
      return locala;
    }
    locala.url = appendUrlWithAutoDownload(getUrlForClick(paramParams), "_autodownload", paramParams);
    locala.type = 1;
    return locala;
  }
  
  private static a getURLObject(Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid())) {
      return null;
    }
    a locala = new a();
    if (!AdOffline.INSTANCE.isEnable((Context)paramParams.activity.get())) {}
    while (TextUtils.isEmpty(locala.url))
    {
      return getBaseURLObject(paramParams);
      if (((paramParams.ad.isAppXiJingOffline()) || (paramParams.ad.isWebXiJingOffline())) && (!TextUtils.isEmpty(AdOffline.INSTANCE.getVersionIfExistsFromMemory(paramParams.ad.getBusinessIdForXiJingOffline()))))
      {
        String str = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramParams.ad, paramParams.ad.getJSONKeyForXiJingOffline(), true);
        if (!TextUtils.isEmpty(str))
        {
          paramParams.ad.setCanvasForXiJingOffline(str);
          locala.url = appendUrlWithAutoDownload(replaceUrlWithClickLpp(paramParams.ad.getUrlForXiJingOffline()), "autodownload", paramParams);
          locala.type = 3;
        }
      }
    }
    return locala;
  }
  
  public static String getUrlForClick(Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return null;
    }
    Object localObject1 = paramParams.ad.getUrlForClick();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return null;
    }
    localObject1 = replaceUrlWithClickLpp((String)localObject1);
    Uri localUri = AdUriUtil.parse((String)localObject1);
    if (localUri == null)
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return localObject1;
    }
    Object localObject3 = localUri.buildUpon();
    if (localObject3 == null)
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return localObject1;
    }
    if (AdUriUtil.getQueryParameter(localUri, "feeds_attachment") != null)
    {
      localObject1 = localObject3;
      if (AdUriUtil.getQueryParameter(localUri, "isfromqqb") == null) {
        break label231;
      }
      label107:
      localObject3 = localObject1;
      if (AdUriUtil.getQueryParameter(localUri, "s") == null) {
        if (!TextUtils.isEmpty(paramParams.antiSpamParams)) {
          break label243;
        }
      }
    }
    Object localObject2;
    label231:
    label243:
    for (localObject3 = localObject1;; localObject3 = ((Uri.Builder)localObject2).appendQueryParameter("s", paramParams.antiSpamParams))
    {
      for (;;)
      {
        return ((Uri.Builder)localObject3).toString();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          if (paramParams.sceneID != -2147483648) {
            localJSONObject.put("click_scene", String.valueOf(paramParams.sceneID));
          }
          if (paramParams.componentID != -2147483648) {
            localJSONObject.put("click_pos", String.valueOf(paramParams.componentID));
          }
          localObject1 = localObject3;
          if (localJSONObject.length() <= 0) {
            break;
          }
          localObject1 = ((Uri.Builder)localObject3).appendQueryParameter("feeds_attachment", localJSONObject.toString());
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
          localObject2 = localObject3;
        }
      }
      break;
      localObject2 = ((Uri.Builder)localObject2).appendQueryParameter("isfromqqb", "1");
      break label107;
    }
  }
  
  private static int getVideoCeilingStyle(Params paramParams)
  {
    int k = 3;
    int i = -2147483648;
    if ((paramParams != null) && (paramParams.isValid()) && (!TextUtils.isEmpty(paramParams.ad.getVideoUrl())) && (AdVideoCeiling.getAdapter() != null)) {}
    for (int j = 1; j == 0; j = 0) {
      return -2147483648;
    }
    if (paramParams.ad.isAppProductType())
    {
      if (!isValidForApp(paramParams))
      {
        AdLog.e("AdClickUtil", "isValidForVideoCeiling error");
        return -2147483648;
      }
      if (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())) {
        if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {
          if (paramParams.videoCeilingSupportedIfInstalled) {
            i = 3;
          }
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == 1)
      {
        j = i;
        if (paramParams.ad.isCanvas())
        {
          j = i;
          if (paramParams.ad.isHitCanvasVideoCeilingExp()) {
            j = 4;
          }
        }
      }
      return j;
      i = -2147483648;
      continue;
      if (paramParams.videoCeilingSupportedIfInstalled)
      {
        i = 2;
        continue;
        if (paramParams.videoCeilingSupportedIfNotInstalled)
        {
          i = 1;
          continue;
          if ((isWebProductTypeDeeplinkSupported(paramParams)) && (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())))
          {
            Object localObject = new AdAppDeeplinkLauncher.Params();
            ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppDeeplink();
            ((AdAppDeeplinkLauncher.Params)localObject).addflags = 268435456;
            ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
            localObject = AdAppDeeplinkLauncher.canLaunch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
            if (localObject != null)
            {
              localObject = ((AdAppDeeplinkLauncher.Result)localObject).getError();
              label290:
              if ((localObject == null) || (!((AdError)localObject).isSuccess())) {
                break label334;
              }
              if (!paramParams.videoCeilingSupportedIfInstalled) {
                break label328;
              }
              i = k;
            }
            for (;;)
            {
              break;
              localObject = new AdError(1);
              break label290;
              label328:
              i = -2147483648;
              continue;
              label334:
              if (paramParams.videoCeilingSupportedIfNotInstalled) {
                i = 1;
              }
            }
          }
          if (paramParams.videoCeilingSupportedIfNotInstalled) {
            i = 1;
          }
        }
      }
    }
  }
  
  public static Result handle(Params paramParams)
  {
    AdLog.i("AdClickUtil", "handle");
    Object localObject;
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      AdLog.e("AdClickUtil", "handle error");
      localObject = new Result(4, 0);
      return localObject;
    }
    if ((paramParams.enableAutoDownload) && (!paramParams.ad.disableAutoDownload())) {}
    Result localResult;
    for (boolean bool = true;; bool = false)
    {
      paramParams.enableAutoDownload = bool;
      localResult = new Result(1, 0);
      if (!paramParams.ad.isQQMINIProgram()) {
        break;
      }
      return handleQQMINIProgramType(paramParams);
    }
    if (paramParams.ad.isAppProductType()) {
      localResult = handleAppProductType(paramParams);
    }
    for (;;)
    {
      if (localResult != null)
      {
        localObject = localResult;
        if (localResult.isSuccess()) {
          break;
        }
      }
      paramParams = handleUrl(paramParams, getBaseURLObject(paramParams));
      localObject = paramParams;
      if (paramParams == null) {
        break;
      }
      paramParams.errorHandled = true;
      return paramParams;
      if (isWebProductType(paramParams)) {
        localResult = handleWebProductType(paramParams);
      }
    }
  }
  
  private static Result handleApp(Params paramParams)
  {
    if ((!isValidForApp(paramParams)) || (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleApp error");
      return new Result(4, 5);
    }
    AdError localAdError = AdAppUtil.launch((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName(), paramParams.extrasForIntent);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new Result(localAdError, 5);
  }
  
  private static void handleAppAfterInstalled(Params paramParams)
  {
    if (!isValidForApp(paramParams)) {
      AdLog.e("AdClickUtil", "handleAppAfterInstalled error");
    }
    while ((paramParams.appReceiver == null) || (paramParams.appReceiver.get() == null)) {
      return;
    }
    ((AdAppReceiver)paramParams.appReceiver.get()).observe(paramParams);
  }
  
  private static Result handleAppMarket(Params paramParams)
  {
    if ((!isValidForApp(paramParams)) || (TextUtils.isEmpty(paramParams.ad.getAppMarketDeeplink())) || (TextUtils.isEmpty(paramParams.ad.getAppMarketPackageName()))) {}
    for (Object localObject = new Result(4, 8);; localObject = new Result(12, 8))
    {
      if ((localObject != null) && (((Result)localObject).isSuccess()) && (paramParams.reportForClick)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      if ((localObject != null) && (((Result)localObject).isSuccess())) {
        b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 285);
      }
      return localObject;
      if (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppMarketPackageName())) {
        break;
      }
    }
    localObject = new AdAppDeeplinkLauncher.Params();
    ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppMarketDeeplink();
    ((AdAppDeeplinkLauncher.Params)localObject).packageName = paramParams.ad.getAppMarketPackageName();
    ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
    localObject = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
    if (localObject != null) {}
    for (localObject = ((AdAppDeeplinkLauncher.Result)localObject).getError();; localObject = new AdError(1))
    {
      localObject = new Result((AdError)localObject, 8);
      break;
    }
  }
  
  private static Result handleAppProductType(Params paramParams)
  {
    if (!isValidForApp(paramParams))
    {
      AdLog.e("AdClickUtil", "handleAppProductType error");
      return new Result(4, 0);
    }
    boolean bool = AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName());
    if ((paramParams.videoSpliceSupported) && (paramParams.ad.isVideoSplice()))
    {
      if (!bool) {
        handleAppAfterInstalled(paramParams);
      }
      return handleVideoSplice(paramParams);
    }
    AdLog.i("AdClickUtil", "handleAppProductType " + paramParams.ad.getAppPackageName() + " installed:" + bool);
    WeakReference localWeakReference = new WeakReference(paramParams.activity.get());
    Ad localAd = paramParams.ad;
    if (bool) {}
    for (int i = 247;; i = 248)
    {
      b.reportAsync(localWeakReference, localAd, i);
      if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {
        b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
      }
      if (!bool) {
        break;
      }
      return handleAppProductTypeIfInstalled(paramParams);
    }
    return handleAppProductTypeIfNotInstalled(paramParams);
  }
  
  private static Result handleAppProductTypeIfInstalled(Params paramParams)
  {
    Object localObject;
    if ((!isValidForApp(paramParams)) || (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleAppProductTypeIfInstalled error");
      localObject = new Result(4, 0);
    }
    Result localResult;
    do
    {
      return localObject;
      AdLog.i("AdClickUtil", "handleAppProductTypeIfInstalled " + paramParams.ad.getAppPackageName());
      int i = getVideoCeilingStyle(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppWithDeeplink(paramParams, false);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    return handleApp(paramParams);
  }
  
  private static Result handleAppProductTypeIfNotInstalled(Params paramParams)
  {
    Object localObject;
    if ((!isValidForApp(paramParams)) || (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
      localObject = new Result(4, 0);
    }
    Result localResult;
    do
    {
      return localObject;
      int i = getVideoCeilingStyle(paramParams);
      if ((!paramParams.ad.isAppXiJingDefault()) && (!paramParams.ad.isAppXiJing())) {
        break label141;
      }
      handleAppAfterInstalled(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppMarket(paramParams);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    if (paramParams.ad.isCanvas()) {
      return handleCanvas(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
    label141:
    AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
    return new Result(4, 0);
  }
  
  static Result handleAppWithDeeplink(Params paramParams, boolean paramBoolean)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (TextUtils.isEmpty(paramParams.ad.getAppDeeplink())))
    {
      AdLog.e("AdClickUtil", "handleAppWithDeeplink error");
      return new Result(4, 4);
    }
    Object localObject = new AdAppDeeplinkLauncher.Params();
    ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppDeeplink();
    ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
    ((AdAppDeeplinkLauncher.Params)localObject).addflags = 268435456;
    localObject = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
    if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess()) && (paramParams.reportForClick) && (!paramBoolean)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess())) {
      b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 246);
    }
    if (localObject != null) {}
    for (paramParams = ((AdAppDeeplinkLauncher.Result)localObject).getError();; paramParams = new AdError(1)) {
      return new Result(paramParams, 4);
    }
  }
  
  private static Result handleCanvas(Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isCanvas()))
    {
      AdLog.e("AdClickUtil", "handleCanvas error");
      return new Result(4, 3);
    }
    AdError localAdError = AdCanvas.show(paramParams.activity, paramParams.ad, paramParams.enableAutoDownload, paramParams.extrasForIntent);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new Result(localAdError, 3);
  }
  
  private static Result handleQQMINIProgramType(Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isQQMINIProgram())) {
      return new Result(4, 0);
    }
    AdError localAdError = AdQQMINIProgram.show(new WeakReference(paramParams.activity.get()), paramParams.ad);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new Result(localAdError, 6);
  }
  
  private static Result handleUrl(Params paramParams, a parama)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdClickUtil", "handleUrl error");
      return new Result(4, 1);
    }
    if ((paramParams.reportForClick) && (parama.type != 1)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    paramParams = new Result(AdBrowser.show(paramParams.activity, paramParams.ad, parama.url, paramParams.extrasForIntent), 1);
    paramParams.urlType = parama.type;
    return paramParams;
  }
  
  private static Result handleVideoCeiling(Params paramParams, int paramInt)
  {
    if (paramInt == -2147483648)
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling error");
      return new Result(4, 2);
    }
    a locala = getURLObject(paramParams);
    if ((locala == null) || (!locala.isValid()))
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling error");
      return new Result(4, 2);
    }
    if ((paramParams.reportForClick) && ((locala.type != 1) || (paramInt == 4)))
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling click url:" + getUrlForClick(paramParams));
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    paramParams = new Result(AdVideoCeiling.show(paramParams.activity, paramParams.ad, locala.url, paramParams.ad.getVideoUrl(), paramInt, paramParams.videoPlayForced, false, paramParams.videoStartPositionMillis, paramParams.extrasForIntent, paramParams.enableAutoDownload), 2);
    paramParams.urlType = locala.type;
    return paramParams;
  }
  
  private static Result handleVideoSplice(Params paramParams)
  {
    String str = null;
    int i = 1;
    int j = 0;
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isVideoSplice()))
    {
      AdLog.e("AdClickUtil", "handleVideoSplice error");
      return new Result(4, 7);
    }
    a locala;
    if ((TextUtils.isEmpty(paramParams.ad.getVideoUrl2())) && (paramParams.ad.getCreativeSize() == 585))
    {
      if (!paramParams.reportForClick) {
        break label283;
      }
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      locala = null;
    }
    for (;;)
    {
      WeakReference localWeakReference = paramParams.activity;
      Ad localAd = paramParams.ad;
      if (locala != null) {
        str = locala.url;
      }
      paramParams = new Result(AdVideoSplice.show(localWeakReference, localAd, str, paramParams.ad.getVideoUrl2(), paramParams.mediaViewLocationRect, i, paramParams.videoPlayForced, false, paramParams.extrasForIntent), 7);
      i = j;
      if (locala != null) {
        i = locala.type;
      }
      paramParams.urlType = i;
      return paramParams;
      if ((!TextUtils.isEmpty(paramParams.ad.getVideoUrl2())) && (paramParams.ad.getCreativeSize() == 930))
      {
        locala = getURLObject(paramParams);
        if ((paramParams.reportForClick) && (locala.type != 1)) {
          AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
        }
        i = 0;
      }
      else
      {
        locala = null;
        i = -2147483648;
        continue;
        label283:
        locala = null;
      }
    }
  }
  
  private static Result handleWebProductType(Params paramParams)
  {
    Object localObject;
    if ((paramParams == null) || (!isWebProductType(paramParams)) || ((paramParams.ad.getDestType() != 0) && (paramParams.ad.getDestType() != 4) && (paramParams.ad.getDestType() != 7)))
    {
      AdLog.e("AdClickUtil", "handleWebProductType error");
      localObject = new Result(4, 0);
    }
    int i;
    Result localResult;
    do
    {
      return localObject;
      if ((paramParams.videoSpliceSupported) && (paramParams.ad.isVideoSplice())) {
        return handleVideoSplice(paramParams);
      }
      i = getVideoCeilingStyle(paramParams);
      if ((!isWebProductTypeDeeplinkSupported(paramParams)) || (TextUtils.isEmpty(paramParams.ad.getAppDeeplink()))) {
        break label202;
      }
      b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppWithDeeplink(paramParams, false);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    if (paramParams.ad.isCanvas()) {
      return handleCanvas(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
    label202:
    if (i != -2147483648) {
      return handleVideoCeiling(paramParams, i);
    }
    if (paramParams.ad.isCanvas()) {
      return handleCanvas(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
  }
  
  public static boolean isValidForApp(Params paramParams)
  {
    return (paramParams != null) && (paramParams.isValid()) && (paramParams.ad.isAppProductType()) && (!TextUtils.isEmpty(paramParams.ad.getProductId())) && (!TextUtils.isEmpty(paramParams.ad.getVia())) && (!TextUtils.isEmpty(paramParams.ad.getAppName())) && (!TextUtils.isEmpty(paramParams.ad.getAppId())) && (!TextUtils.isEmpty(paramParams.ad.getAppPackageName())) && (!TextUtils.isEmpty(paramParams.ad.getAppPackageUrl()));
  }
  
  private static boolean isWebProductType(Params paramParams)
  {
    return (paramParams != null) && ((isWebProductTypeDeeplinkSupported(paramParams)) || (paramParams.ad.getProductType() == 30));
  }
  
  private static boolean isWebProductTypeDeeplinkSupported(Params paramParams)
  {
    return (paramParams != null) && ((paramParams.ad.getProductType() == 25) || (paramParams.ad.getProductType() == 26) || (paramParams.ad.getProductType() == 37) || (paramParams.ad.getProductType() == 41) || (paramParams.ad.getProductType() == 1000));
  }
  
  private static String replaceUrlWithClickLpp(String paramString)
  {
    int j = 0;
    if (!paramString.contains("__CLICK_LPP__")) {
      return paramString;
    }
    Object localObject = AdProcessManager.INSTANCE.isWebProcessRunning();
    int i;
    if (localObject != null) {
      if (((Boolean)localObject).booleanValue()) {
        i = 0;
      }
    }
    for (;;)
    {
      label37:
      localObject = AdProcessManager.INSTANCE.isWebProcessRunningForPreloading();
      if (localObject != null) {
        if (!((Boolean)localObject).booleanValue()) {}
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("click_time", System.currentTimeMillis());
          ((JSONObject)localObject).put("toolsalive", i);
          ((JSONObject)localObject).put("preload", j);
          localObject = ((JSONObject)localObject).toString();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = URLEncoder.encode((String)localObject, "UTF-8");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = paramString.replaceAll("__CLICK_LPP__", (String)localObject);
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {
            break;
          }
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
          return paramString;
        }
        i = 1;
        break label37;
        j = 1;
        continue;
        j = 2;
      }
      i = 2;
    }
  }
  
  @Keep
  public static class Params
  {
    public WeakReference<Activity> activity;
    public Ad ad;
    public String antiSpamParams = null;
    public WeakReference<AdAppReceiver> appReceiver;
    public int componentID = -2147483648;
    public boolean enableAutoDownload = false;
    public Bundle extrasForIntent;
    public Rect mediaViewLocationRect = null;
    public boolean reportForClick = true;
    public int sceneID = -2147483648;
    public boolean videoCeilingSupportedIfInstalled = false;
    public boolean videoCeilingSupportedIfNotInstalled = false;
    private final boolean videoLoop = false;
    public boolean videoPlayForced = false;
    public boolean videoSpliceSupported = false;
    public long videoStartPositionMillis = 0L;
    
    public boolean isValid()
    {
      return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (!TextUtils.isEmpty(this.ad.getUrlForImpression())) && (!TextUtils.isEmpty(this.ad.getUrlForClick())) && (!TextUtils.isEmpty(this.ad.getUrlForEffect())) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()));
    }
  }
  
  @Keep
  public static class Result
  {
    public int action = 0;
    private AdError error = new AdError(1);
    public boolean errorHandled = false;
    public int urlType = 0;
    
    public Result(int paramInt1, int paramInt2)
    {
      this.error = new AdError(paramInt1);
      this.action = paramInt2;
    }
    
    public Result(AdError paramAdError, int paramInt)
    {
      this.error = paramAdError;
      this.action = paramInt;
    }
    
    public int getErrorCode()
    {
      if (this.error != null) {
        return this.error.getErrorCode();
      }
      return 1;
    }
    
    public boolean isSuccess()
    {
      return getErrorCode() == 0;
    }
  }
  
  public static final class a
  {
    public static final int TYPE_CLICK_URL = 1;
    public static final int TYPE_LANDING_PAGE = 2;
    public static final int TYPE_OFFLINE = 3;
    public static final int TYPE_UNKNOWN = 0;
    int type = 0;
    String url;
    
    boolean isValid()
    {
      return (!TextUtils.isEmpty(this.url)) && (this.type != 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil
 * JD-Core Version:    0.7.0.1
 */