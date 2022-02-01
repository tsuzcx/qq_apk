import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import Wallet.FocusMpIdReq;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SharePlugin;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedVideoLogger;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.MultiFormatReader;
import com.tencent.mobileqq.mini.zxing.PlanarYUVLuminanceSource;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.HybridBinarizer;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class astt
  implements ChannelProxy
{
  public static volatile boolean dgw;
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private volatile rqa ffmpeg;
  MultiFormatReader multiFormatReader;
  
  private static MiniAppCmdInterface a(AsyncResult paramAsyncResult)
  {
    return new asug(paramAsyncResult);
  }
  
  public static PublishMoodInfo a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    for (;;)
    {
      int i;
      Object localObject3;
      String str1;
      String str2;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).has("text")) {
          break label443;
        }
        localObject1 = ((JSONObject)localObject2).getString("text");
        localPublishMoodInfo.mText = ((String)localObject1);
        if (!((JSONObject)localObject2).has("tag")) {
          break label450;
        }
        localObject1 = ((JSONObject)localObject2).getString("tag");
        localPublishMoodInfo.mTag = ((String)localObject1);
        if (!((JSONObject)localObject2).has("path")) {
          break label457;
        }
        localObject1 = ((JSONObject)localObject2).optString("path");
        localPublishMoodInfo.mPath = ((String)localObject1);
        if (!((JSONObject)localObject2).has("footnote")) {
          break label464;
        }
        localObject1 = ((JSONObject)localObject2).optString("footnote");
        localPublishMoodInfo.mFootnote = ((String)localObject1);
        if ((((JSONObject)localObject2).has("media")) && (!TextUtils.isEmpty(((JSONObject)localObject2).getString("media"))))
        {
          localObject1 = new ArrayList();
          localObject2 = ((JSONObject)localObject2).getJSONArray("media");
          int j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break label426;
          }
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          if ((!((JSONObject)localObject3).has("type")) || (!((JSONObject)localObject3).has("path")))
          {
            QLog.i("ChannelProxyImpl", 2, "invalid mediaItem, " + localObject3);
          }
          else
          {
            str1 = ((JSONObject)localObject3).getString("type");
            str2 = ((JSONObject)localObject3).getString("path");
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
              QLog.i("ChannelProxyImpl", 2, "invalid mediaItem, " + localObject3);
            }
          }
        }
      }
      catch (Exception paramIMiniAppContext)
      {
        QLog.i("ChannelProxyImpl", 1, "parseJsonToMoodInfo error " + paramString, paramIMiniAppContext);
      }
      for (;;)
      {
        return localPublishMoodInfo;
        localObject3 = new PublishMoodInfo.MediaInfo();
        if (paramIMiniAppContext != null) {
          ((PublishMoodInfo.MediaInfo)localObject3).mPath = ((IMiniAppFileManager)paramIMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(str2);
        }
        if ("photo".equalsIgnoreCase(str1))
        {
          ((PublishMoodInfo.MediaInfo)localObject3).mType = 1;
          ((ArrayList)localObject1).add(localObject3);
          break;
        }
        if (!"video".equalsIgnoreCase(str1)) {
          break;
        }
        ((PublishMoodInfo.MediaInfo)localObject3).mType = 2;
        ((ArrayList)localObject1).add(localObject3);
        break;
        label426:
        localPublishMoodInfo.mMediaInfo = ((ArrayList)localObject1);
      }
      i += 1;
      continue;
      label443:
      Object localObject1 = "";
      continue;
      label450:
      localObject1 = "";
      continue;
      label457:
      localObject1 = "";
      continue;
      label464:
      localObject1 = "";
    }
  }
  
  private void a(Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramActivity == null) || (paramPublishMoodInfo == null))
    {
      QLog.i("ChannelProxyImpl", 2, "handle moodInfo is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("summary", paramPublishMoodInfo.mText);
    localBundle.putBoolean("key_need_save_draft", false);
    localBundle.putBoolean("from_mini_app", true);
    localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
    localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
    localBundle.putString("shareSource", "miniApp");
    String str1;
    String str2;
    label179:
    JSONObject localJSONObject;
    if (paramMiniAppInfo != null)
    {
      str1 = paramMiniAppInfo.appId;
      if (paramMiniAppInfo != null)
      {
        str2 = "https://m.q.qq.com/a/p/{appid}".replace("{appid}", str1);
        if (!TextUtils.isEmpty(paramPublishMoodInfo.mPath))
        {
          str2 = str2 + "?s=" + paramPublishMoodInfo.mPath + "&referer=" + 2100;
          if (!TextUtils.isEmpty(paramPublishMoodInfo.mFootnote)) {
            break label361;
          }
          paramPublishMoodInfo = paramActivity.getResources().getString(2131695924);
          localJSONObject = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("icon_url", paramMiniAppInfo.iconUrl);
        localJSONObject.put("title", paramMiniAppInfo.name);
        localJSONObject.put("summary", paramPublishMoodInfo);
        localJSONObject.put("jump_url", str2);
        localJSONObject.put("button_txt", paramActivity.getResources().getString(2131695934));
        localJSONObject.put("recom_bottom_id", 2);
        localJSONObject.put("action_type", 2);
        paramPublishMoodInfo = localJSONObject.toString();
        localBundle.putString("key_mini_app_tail", paramPublishMoodInfo);
        QLog.d("ChannelProxyImpl", 1, "publishMood， comm_recom_bottom： " + paramPublishMoodInfo);
        paramPublishMoodInfo = str1;
        localBundle.putString("key_mini_appid", paramPublishMoodInfo);
        avqq.a(paramActivity, localBundle, null, -1);
        return;
      }
      catch (Exception paramPublishMoodInfo)
      {
        label361:
        QLog.d("ChannelProxyImpl", 1, "publishMood exception: " + Log.getStackTraceString(paramPublishMoodInfo));
      }
      str2 = str2 + "?referer=2100";
      break;
      paramPublishMoodInfo = paramPublishMoodInfo.mFootnote;
      break label179;
      paramPublishMoodInfo = str1;
      continue;
      paramPublishMoodInfo = null;
    }
  }
  
  private static void initOskOnce(Context paramContext)
  {
    if (!dgw)
    {
      OskPlayerConfig localOskPlayerConfig = new OskPlayerConfig();
      localOskPlayerConfig.setEnableHLSCache(true);
      localOskPlayerConfig.setDebugVersion(true);
      localOskPlayerConfig.setLogger(new DefaultLogger());
      localOskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), localOskPlayerConfig);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext == null) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
        PlayerConfig.g().setContentTypeList(paramContext);
        dgw = true;
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("ChannelProxyImpl", 1, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + paramContext);
        continue;
      }
      label126:
      QLog.e("ChannelProxyImpl", 1, "getContentTypeList null");
    }
  }
  
  private awmu newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    awmu localawmu = new awmu();
    localawmu.mTraceId = (String.valueOf(aroi.a().getUin()) + '_' + i);
    localawmu.mActionId = paramInt;
    localawmu.eBB = 1;
    localawmu.cNR = String.valueOf(paramAdItem.iAdId.get());
    localawmu.cNS = paramString;
    localawmu.aBn = i;
    localawmu.eBX = 1;
    localawmu.mAppId = "tianshu.81";
    localawmu.mModuleId = "";
    return localawmu;
  }
  
  public void JudgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, String paramString4, AsyncResult paramAsyncResult)
  {
    paramString4 = new INTERFACE.StJudgeTimingReq();
    paramString4.appid.set(paramString1);
    paramString4.appType.set(paramInt1);
    paramString4.scene.set(paramInt2);
    paramString4.factType.set(paramInt3);
    paramString4.reportTime.set(paramLong);
    paramString4.totalTime.set(paramInt4);
    paramString4.launchId.set(paramString2);
    paramString4.afterCertify.set(paramInt5);
    paramString4.via.set(paramString3);
    paramString4.AdsTotalTime.set(paramInt6);
    if (paramStCommonExt != null) {
      paramString4.extInfo.set(paramStCommonExt);
    }
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", paramString1, paramString4, INTERFACE.StJudgeTimingRsp.class, new astz(this, paramAsyncResult));
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    INTERFACE.StReportExecuteReq localStReportExecuteReq = new INTERFACE.StReportExecuteReq();
    localStReportExecuteReq.appid.set(paramString1);
    localStReportExecuteReq.execTime.set(paramInt);
    localStReportExecuteReq.instrTraceId.set(paramString2);
    localStReportExecuteReq.ruleName.set(paramString3);
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", paramString1, localStReportExecuteReq, INTERFACE.StReportExecuteRsp.class, new asua(this, paramAsyncResult));
  }
  
  public void addGroupApp(IMiniAppContext paramIMiniAppContext, AsyncResult paramAsyncResult)
  {
    QLog.d("ChannelProxyImpl", 1, "addGroupApp");
    if (paramIMiniAppContext == null) {}
    try
    {
      QLog.e("ChannelProxyImpl", 1, "addGroupApp, miniAppContext=null");
      paramIMiniAppContext = new JSONObject();
      paramIMiniAppContext.put("errMsg", "miniAppContext is null");
      paramAsyncResult.onReceiveResult(false, paramIMiniAppContext);
      return;
    }
    catch (Exception paramIMiniAppContext)
    {
      QLog.e("ChannelProxyImpl", 1, "addGroupApp, exception: " + Log.getStackTraceString(paramIMiniAppContext));
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    if (paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel != null) {}
    String str;
    for (int i = 1;; i = 0)
    {
      str = paramIMiniAppContext.getMiniAppInfo().appId;
      if (i == 0) {
        break label198;
      }
      if (paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin) {
        break;
      }
      paramIMiniAppContext = new JSONObject();
      paramIMiniAppContext.put("errMsg", "non-administrators");
      paramAsyncResult.onReceiveResult(false, paramIMiniAppContext);
      return;
    }
    TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), str, null, paramAsyncResult);
    return;
    label198:
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_user_troop_info", new Bundle(), new asty(this, paramIMiniAppContext, str, paramAsyncResult));
  }
  
  public void addPhoneNumber(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().addPhoneNumber(paramString1, paramString2, paramString3, paramInt, a(paramAsyncResult));
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    zyb.a(new FocusMpIdReq(paramString1, paramString2), new asuf(this, paramAsyncResult));
    return true;
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().batchGetContact(paramArrayList, a(paramAsyncResult));
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkNavigateRight(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkOfferId(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkSession(paramString, a(paramAsyncResult));
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performDataReport(paramArrayOfByte, a(paramAsyncResult));
  }
  
  public String decodeQR(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    long l1 = System.nanoTime();
    try
    {
      if (this.multiFormatReader == null)
      {
        this.multiFormatReader = new MultiFormatReader();
        localObject = new HashMap();
        ((Map)localObject).put(DecodeHintType.TRY_HARDER, Boolean.valueOf(true));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(BarcodeFormat.CODABAR);
        localArrayList.add(BarcodeFormat.CODE_39);
        localArrayList.add(BarcodeFormat.CODE_93);
        localArrayList.add(BarcodeFormat.CODE_128);
        localArrayList.add(BarcodeFormat.EAN_8);
        localArrayList.add(BarcodeFormat.EAN_13);
        localArrayList.add(BarcodeFormat.ITF);
        localArrayList.add(BarcodeFormat.UPC_A);
        localArrayList.add(BarcodeFormat.UPC_E);
        localArrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        ((Map)localObject).put(DecodeHintType.POSSIBLE_FORMATS, localArrayList);
        this.multiFormatReader.setHints((Map)localObject);
      }
      paramArrayOfByte = new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt1, paramInt2, false)));
      QLog.d("ChannelProxyImpl", 1, "run: " + paramArrayOfByte.getWidth() + ":" + paramArrayOfByte.getHeight());
      paramArrayOfByte = this.multiFormatReader.decodeWithState(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject;
        long l2;
        QLog.d("ChannelProxyImpl", 1, "run: failed to decode frame", paramArrayOfByte);
        this.multiFormatReader.reset();
        paramArrayOfByte = null;
      }
    }
    finally
    {
      this.multiFormatReader.reset();
    }
    if (paramArrayOfByte != null)
    {
      l2 = System.nanoTime();
      localObject = paramArrayOfByte.getText();
      Log.i("ChannelProxyImpl", "Found barcode in " + TimeUnit.NANOSECONDS.toMillis(l2 - l1) + " ms, " + (String)localObject + ", " + paramArrayOfByte.getBarcodeFormat().name());
      return localObject;
    }
    return null;
  }
  
  public void delPhoneNumber(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().delPhoneNumber(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public void downloadQQBrowser(String paramString) {}
  
  public void ffmpegExecCommand(String[] paramArrayOfString, ChannelProxy.ICommandListenr paramICommandListenr)
  {
    try
    {
      if (this.ffmpeg == null) {
        this.ffmpeg = rqa.a(BaseApplicationImpl.getApplication());
      }
      this.ffmpeg.a(paramArrayOfString, new astx(this, paramICommandListenr));
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramArrayOfString)
    {
      do
      {
        Log.e("ChannelProxyImpl", "run: ", paramArrayOfString);
      } while (paramICommandListenr == null);
      paramICommandListenr.onFailure("FFmpegCommandAlreadyRunningException");
    }
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, paramString1, paramString2, paramString3, a(paramAsyncResult));
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLinkForSDK(paramString, paramInt, a(paramAsyncResult));
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    MiniAppCmdUtil.getInstance().getAuthList(null, paramString, new astu(this, paramAuthListResult));
  }
  
  public void getContentAccelerate(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, AsyncResult paramAsyncResult) {}
  
  public String getDeviceInfo()
  {
    return avpp.a().getDeviceInfor();
  }
  
  public IFlutterProxy getFlutterProxy()
  {
    return new astw(this);
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFormId(paramString, a(paramAsyncResult));
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFriendCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult) {}
  
  public void getGdtAdInfo(String paramString1, int paramInt, String paramString2, AsyncResult paramAsyncResult) {}
  
  public void getGroupAppStatus(IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult)
  {
    QLog.d("ChannelProxyImpl", 1, "getGroupAppStatus");
    if (paramIMiniAppContext == null)
    {
      QLog.e("ChannelProxyImpl", 1, "getGroupAppStatus, miniAppContext=null");
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("entryDataHash");
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.getEntryHash()))) {
        break label182;
      }
      if (paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin)
      {
        TroopApplicationListUtil.getGroupAppStatus(String.valueOf(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), paramIMiniAppContext.getMiniAppInfo().appId, paramAsyncResult);
        return;
      }
    }
    catch (Exception paramIMiniAppContext)
    {
      QLog.e("ChannelProxyImpl", 1, "getGroupAppStatus, exception: " + Log.getStackTraceString(paramIMiniAppContext));
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    QLog.e("ChannelProxyImpl", 1, "you are not group administrator");
    paramAsyncResult.onReceiveResult(false, null);
    return;
    label182:
    QLog.e("ChannelProxyImpl", 1, "entryDataHash is not valid or you are not group administrator");
    paramAsyncResult.onReceiveResult(false, null);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(paramString1, paramString2, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupShareInfo(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public IMediaPlayer getMediaPlayer()
  {
    if (!PlayerConfig.hasInit())
    {
      Context localContext = AppLoaderFactory.g().getContext();
      if (localContext == null) {
        throw new RuntimeException("BaseApplicationImpl ctx is null");
      }
      PlayerConfig.init(localContext);
      PlayerConfig.g().setLogger(new EmbeddedVideoLogger());
    }
    if (!VideoManager.hasInit()) {
      VideoManager.init(AppLoaderFactory.g().getContext());
    }
    initOskOnce(AppLoaderFactory.g().getContext());
    return new asuq();
  }
  
  public IMediaPlayerUtil getMediaPlayerUtil()
  {
    return new astv(this);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, a(paramAsyncResult));
  }
  
  public MiniAIOEntranceProxy getMiniAIOEntranceView(Context paramContext, String paramString)
  {
    paramContext = new MiniAIOEntryView(paramContext, paramString);
    paramContext.setMiniAIOStyle(paramString);
    return paramContext;
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(paramInt, a(paramAsyncResult));
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, paramString1, paramString2, paramString3, paramInt, a(paramAsyncResult));
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPhoneNumber(paramString, a(paramAsyncResult));
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPotentialFriendList(paramStCommonExt, paramString, a(paramAsyncResult));
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getRobotUin(paramString, a(paramAsyncResult));
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult) {}
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(paramStAdaptShareInfoReq, a(paramAsyncResult));
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getTcbTicket(paramString1, null, paramString2, a(paramAsyncResult));
  }
  
  public ChannelProxy.SoLoaderOption getTissueSoLoaderOption()
  {
    return null;
  }
  
  public void getUserAppInfo(COMM.StCommonExt paramStCommonExt, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserGroupInfo(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, AsyncResult paramAsyncResult) {}
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserHealthData(paramString, null, a(paramAsyncResult));
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfo(paramString1, paramBoolean, paramString2, a(paramAsyncResult));
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoExtra(paramString, a(paramAsyncResult));
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoOpenData(paramString1, paramString2, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInteractiveStorage(paramStCommonExt, paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserSetting(paramString1, paramString2, paramString3, paramArrayList, a(paramAsyncResult));
  }
  
  public AbsVideoPlayer getVideoPlayer()
  {
    return new astk();
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (acky)((QQAppInterface)localObject).getBusinessHandler(5);
        if (localObject != null) {
          ((acky)localObject).ch(paramBundle);
        }
      }
    }
  }
  
  public boolean isGooglePlayVersion()
  {
    return false;
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, ChatActivity.class));
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("chat_subType", 2);
    localIntent.putExtra("uinname", paramString2);
    localIntent.setFlags(67108864);
    return true;
  }
  
  public void launchAddPhoneNumberFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, paramInt);
  }
  
  public void launchPhoneNumberManagementFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, paramInt);
  }
  
  public void launchSubMsgPermissionSettingFragment(Activity paramActivity, Intent paramIntent, int paramInt) {}
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getLoginCode(paramString, a(paramAsyncResult));
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap, a(paramAsyncResult));
  }
  
  public boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult)
  {
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", paramString);
      paramString = new Bundle();
      paramString.putBoolean("hide_more_button", true);
      paramContext.putExtras(paramString);
      AppLoaderFactory.g().getActivityResultManager().addActivityResultListener(new asue(this, paramAsyncResult));
      localActivity.startActivityForResult(paramContext, 9);
      return true;
    }
    return false;
  }
  
  public boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2)
  {
    PermissionSettingFragment.launchForResult((Activity)paramContext, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openQzonePublish(IMiniAppContext paramIMiniAppContext, Activity paramActivity, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    QLog.i("ChannelProxyImpl", 2, "receive openQzonePublish event");
    paramIMiniAppContext = SharePlugin.validMoodInfo(a(paramIMiniAppContext, paramString));
    if (paramIMiniAppContext != null) {
      a(paramActivity, paramIMiniAppContext, paramMiniAppInfo);
    }
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    aprg.H(paramContext, paramString1, paramString2);
    return true;
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt2, null, a(paramAsyncResult));
  }
  
  public void realTimeLogReport(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ArrayList<RealTimeLogItem> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().realTimeLogReport(paramString1, paramString2, paramString3, paramArrayOfString, paramArrayList, a(paramAsyncResult));
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().removeUserCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performReport(paramArrayOfByte, a(paramAsyncResult), "LightAppSvc." + paramString1 + "." + paramString2);
  }
  
  public void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory paramBeaconReportCategory, @NonNull String paramString, @Nullable Map<String, String> paramMap)
  {
    if (paramBeaconReportCategory == ChannelProxy.BeaconReportCategory.MINI_GAME) {
      MiniGameBeaconReport.report(paramString, paramMap);
    }
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      MiniAppCmdUtil.getInstance().reportShare(paramStCommonExt, paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, a(paramAsyncResult));
    }
  }
  
  public void sendSmsCodeRequest(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppSendSmsCodeServlet.sendSmsCodeRequest(paramString1, paramString2, new asub(this, paramAsyncResult));
  }
  
  public void sendVerifySmsCodeRequest(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppSendSmsCodeServlet.sendVerifySmsCodeRequest(paramString1, paramString2, paramString3, new asuc(this, paramAsyncResult));
  }
  
  public void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramUserAuthInfo.scope);
    if (!TextUtils.isEmpty(paramUserAuthInfo.desc)) {
      localStUserAuthInfo.desc.set(paramUserAuthInfo.desc);
    }
    localStUserAuthInfo.authState.set(paramUserAuthInfo.authState);
    MiniAppCmdUtil.getInstance().setAuth(null, paramString, localStUserAuthInfo, a(paramAsyncResult));
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setPersonalizeInfo(paramString1, paramString2, paramInt, paramString3, paramString4, a(paramAsyncResult));
  }
  
  public void setUserAppLike(boolean paramBoolean, COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult) {}
  
  public void setUserAppTop(MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult) {}
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setUserCloudStorage(paramString, paramHashMap, a(paramAsyncResult));
  }
  
  public boolean setWebviewCookie(Context paramContext, String paramString)
  {
    Object localObject = SwiftBrowserCookieMonster.pZ(paramString).replace(" ", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((Build.VERSION.SDK_INT < 21) && (paramContext != null)) {
        CookieSyncManager.createInstance(paramContext);
      }
      paramContext = CookieManager.getInstance();
      paramContext.setAcceptCookie(true);
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        paramContext.setCookie(Uri.parse(paramString).getHost(), str);
        i += 1;
      }
    }
    try
    {
      CookieSyncManager.getInstance().sync();
      return true;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    AddFriendLogicActivity.aKF = paramString1;
    paramContext.startActivity(AddFriendLogicActivity.a(paramContext, 3, paramString2, paramString1, 3024, Integer.parseInt(paramString1), null, null, null, "", null));
    return true;
  }
  
  public boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramBundle.putBoolean("hide_left_button", true);
    paramBundle.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramBundle);
    if (paramActivity != null)
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public void syncForceGroundAndRefreshBadge(Activity paramActivity, String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ChannelProxyImpl.13(this, paramActivity, paramString1, paramString2), 16, null, true);
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    awmt.a().a(newTianShuReportData(paramAdItem, paramString, paramInt));
    return true;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    paramContext = new awmr();
    paramContext.eBV = paramInt2;
    paramContext.eBW = paramInt3;
    awmt.a().a(Collections.singletonList(paramContext), new asud(this, paramAsyncResult));
    return true;
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().transForRoomId(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    return MiniAppCmdUtil.getInstance().updateBaseLibForSDK(paramString, paramBoolean1, paramBoolean2, a(paramAsyncResult));
  }
  
  public boolean updateEntryList(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "update_entry_list", localBundle, null);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
    return true;
  }
  
  public void updateUserSetting(String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().updateUserSetting(null, paramString, paramStUserSettingInfo, a(paramAsyncResult));
  }
  
  public void uploadUserLog(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appid", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
  }
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().useUserApp(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramStCommonExt, a(paramAsyncResult));
  }
  
  public void verifyPlugin(String paramString, ArrayList<com.tencent.qqmini.sdk.launcher.model.PluginInfo> paramArrayList, AsyncResult paramAsyncResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.qqmini.sdk.launcher.model.PluginInfo localPluginInfo = (com.tencent.qqmini.sdk.launcher.model.PluginInfo)paramArrayList.next();
      com.tencent.mobileqq.mini.apkg.PluginInfo localPluginInfo1 = new com.tencent.mobileqq.mini.apkg.PluginInfo();
      localPluginInfo1.setInnerVersion(localPluginInfo.getInnerVersion());
      localPluginInfo1.setPluginId(localPluginInfo.getPluginId());
      localArrayList.add(localPluginInfo1);
    }
    MiniAppCmdUtil.getInstance().verifyPlugin(paramString, localArrayList, a(paramAsyncResult));
  }
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    return MiniAppUtils.performWnsCgiRequest(paramJSONObject, paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astt
 * JD-Core Version:    0.7.0.1
 */