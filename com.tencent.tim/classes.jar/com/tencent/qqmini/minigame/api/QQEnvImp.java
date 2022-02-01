package com.tencent.qqmini.minigame.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameReportManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.PathUtil;
import com.tencent.qqmini.minigame.utils.TTHandleThread;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.io.File;
import org.json.JSONObject;

public class QQEnvImp
  implements IQQEnv
{
  private static String[] OPENGL_ES3_BLACK_LIST = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  public static final String TAG = "QQEnvImp";
  private GameRuntimeLoader mGameRuntimeLoader;
  
  public QQEnvImp(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.mGameRuntimeLoader = paramGameRuntimeLoader;
  }
  
  public static boolean isAppSettingDebugVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  }
  
  public static boolean isUseLocalSDKResource()
  {
    return false;
  }
  
  public int blackScreenDetectInterval()
  {
    return GameWnsUtils.getGameErrorBlackDetectInterval();
  }
  
  public void cleanCache()
  {
    try
    {
      MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), this.mGameRuntimeLoader.getGameInfoManager().getMiniAppInfo(), false);
      return;
    }
    catch (Exception localException)
    {
      GameLog.getInstance().e("QQEnvImp", "cleanCache exception", localException);
    }
  }
  
  public boolean download(String paramString, ITDownloadListener paramITDownloadListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MiniAppFileManager.getMiniAppFileManager(getAppId());
    if (localObject != null) {}
    for (localObject = ((MiniAppFileManager)localObject).getTmpPathByUrl(paramString);; localObject = "")
    {
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, (String)localObject, 30, new QQEnvImp.1(this, paramITDownloadListener, paramString, (String)localObject));
      GameLog.getInstance().i("[download]", "from:" + paramString + ", to:" + (String)localObject);
      return true;
    }
  }
  
  public boolean enableOpengles3()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = OPENGL_ES3_BLACK_LIST;
    int k = arrayOfString.length;
    int i = 0;
    int j = 1;
    while (i < k)
    {
      if (str.equalsIgnoreCase(arrayOfString[i])) {
        j = 0;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (GameWnsUtils.enableOpengles3())
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int frameNoChangeLimit()
  {
    return GameWnsUtils.getFrameNoChangeLimit();
  }
  
  public boolean gameErrorDialogEnable()
  {
    return (GameWnsUtils.getGameErrorDialogEnable()) && (!GameWnsUtils.getGameErrorDialogIsBlack());
  }
  
  public String getAppId()
  {
    return this.mGameRuntimeLoader.getGameInfoManager().getAppId();
  }
  
  public int getBenchmarkLevel()
  {
    return DeviceUtil.getDeviceBenchmarkLevel();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(paramString))
    {
      if (PathUtil.isNetworkUrl(paramString)) {
        return localMiniAppProxy.getDrawable(paramContext, paramString, 0, 0, new ColorDrawable(0));
      }
      return localMiniAppProxy.getDrawable(paramContext, getResPath(paramString, "", paramMiniGameInfo), 0, 0, new ColorDrawable(0));
    }
    return null;
  }
  
  public String getGameConfig(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if ((paramMiniGameInfo == null) || (paramMiniGameInfo.gameConfigJson == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      paramMiniGameInfo = paramMiniGameInfo.gameConfigJson.opt(paramString);
    } while (paramMiniGameInfo == null);
    return paramMiniGameInfo.toString();
  }
  
  public String getGameEnvVersion()
  {
    MiniAppInfo localMiniAppInfo = this.mGameRuntimeLoader.getMiniAppInfo();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.getVerTypeStr();
    }
    return "release";
  }
  
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + MiniSDKConst.STR_WXFILE + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + QUAUtil.getPlatformQUA() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public String getPlatformName()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
  }
  
  public String getPlatformVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  public String getResPath(String paramString1, String paramString2, MiniGameInfo paramMiniGameInfo)
  {
    if (paramMiniGameInfo != null) {}
    for (paramString2 = paramMiniGameInfo.gameId;; paramString2 = getAppId())
    {
      paramString2 = MiniAppFileManager.getMiniAppFileManager(paramString2);
      if (paramString2 == null) {
        break;
      }
      return paramString2.getAbsolutePath(paramString1);
    }
    return "";
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramMiniGameInfo != null) {}
    for (paramMiniGameInfo = paramMiniGameInfo.gameId;; paramMiniGameInfo = getAppId())
    {
      paramMiniGameInfo = MiniAppFileManager.getMiniAppFileManager(paramMiniGameInfo);
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
        break label65;
      }
      if (paramMiniGameInfo == null) {
        break;
      }
      return paramMiniGameInfo.getTmpPathByUrl(paramString);
    }
    return "";
    label65:
    if (paramMiniGameInfo != null) {
      return paramMiniGameInfo.getTmpPath(paramString);
    }
    return "";
  }
  
  public String getWxFilePath(String paramString)
  {
    MiniAppFileManager localMiniAppFileManager = MiniAppFileManager.getMiniAppFileManager(getAppId());
    if (localMiniAppFileManager != null) {
      return localMiniAppFileManager.getWxFilePath(paramString);
    }
    return "";
  }
  
  public boolean isDebug()
  {
    return isAppSettingDebugVersion();
  }
  
  public boolean isNotchValid()
  {
    return LiuHaiUtils.isLiuHaiUseValid();
  }
  
  public int jsErrorDetectInterval()
  {
    return GameWnsUtils.getGameJsErrorDetectInterval();
  }
  
  public void killSelf(Context paramContext)
  {
    GameLog.getInstance().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).finish();
    }
    Process.killProcess(Process.myPid());
  }
  
  public int noPresentDurationLimit()
  {
    return GameWnsUtils.getNoPresentDurationLimit();
  }
  
  public int noPresentTouchLimit()
  {
    return GameWnsUtils.getNoPresentTouchLimit();
  }
  
  public int parseColor(String paramString)
  {
    return ColorUtils.parseColor(paramString);
  }
  
  public void postRunable(Runnable paramRunnable)
  {
    TTHandleThread.getInstance().post(paramRunnable);
  }
  
  public void postRunableDelayed(Runnable paramRunnable, long paramLong)
  {
    TTHandleThread.getInstance().postDelayed(paramRunnable, paramLong);
  }
  
  public int presentDetectInterval()
  {
    return GameWnsUtils.getGamePresentDetectInterval();
  }
  
  public String readFileToString(File paramFile)
  {
    try
    {
      paramFile = FileUtils.readFileToString(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), paramInt, paramString, "1");
    this.mGameRuntimeLoader.getReportManager().onJsError();
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label28;
      }
      MiniProgramLpReportDC04902.reportGameStart(this.mGameRuntimeLoader.getMiniAppInfoForReport().appId);
    }
    label28:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    MiniProgramLpReportDC04902.accumulateDrawFrameDuration(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    paramContext = DialogUtil.createCustomDialog(paramContext, 230, null, GameWnsUtils.getGameErrorDialogContent(), "取消", "确定", new QQEnvImp.2(this, paramDialogCallback), new QQEnvImp.3(this, paramDialogCallback));
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    MiniReportManager.reportEventType(this.mGameRuntimeLoader.getGameInfoManager().getMiniAppInfo(), 1024, "1");
  }
  
  public void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    MiniProgramLpReportDC04902.updateDisplayFrameTime(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.QQEnvImp
 * JD-Core Version:    0.7.0.1
 */