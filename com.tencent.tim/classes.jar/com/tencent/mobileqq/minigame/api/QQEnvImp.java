package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aqgz;
import avpq;
import ayxa;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.DeviceUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;
import org.json.JSONObject;

public class QQEnvImp
  implements IQQEnv
{
  private static String[] OPENGL_ES3_BLACK_LIST = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  public static final String TAG = "QQEnvImp";
  private GameRuntimeLoader mRuntimeLoader;
  
  public QQEnvImp(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.mRuntimeLoader = paramGameRuntimeLoader;
  }
  
  public static boolean isAppSettingDebugVersion()
  {
    return false;
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
      MiniCacheFreeManager.freeCache(MainPageFragment.getUin(), this.mRuntimeLoader.getGameInfoManager().getMiniGamePkg().appConfig.config, false);
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
    String str = MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
    MiniappDownloadUtil.getInstance().download(paramString, str, true, new QQEnvImp.1(this, paramITDownloadListener, str), Downloader.DownloadMode.FastMode, null);
    GameLog.getInstance().i("[download]", "from:" + paramString + ", to:" + str);
    return true;
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
    return this.mRuntimeLoader.getGameInfoManager().getAppId();
  }
  
  public int getBenchmarkLevel()
  {
    return DeviceUtil.getDeviceBenchmarkLevel();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mFailedDrawable = new ColorDrawable(0);
      paramContext.mLoadingDrawable = new ColorDrawable(0);
      paramContext.mPlayGifImage = true;
      if (PathUtil.isNetworkUrl(paramString)) {
        return URLDrawable.getDrawable(paramString, paramContext);
      }
      return URLDrawable.getFileDrawable(getResPath(paramString, "", paramMiniGameInfo), paramContext);
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
  
  @NonNull
  public String getGameEnvVersion()
  {
    MiniGamePkg localMiniGamePkg = this.mRuntimeLoader.getGameInfoManager().getMiniGamePkg();
    if ((localMiniGamePkg != null) && (localMiniGamePkg.appConfig != null) && (localMiniGamePkg.appConfig.config != null)) {
      return localMiniGamePkg.appConfig.config.getVerTypeStr();
    }
    return "release";
  }
  
  @NonNull
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + MiniAppGlobal.STR_WXFILE + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + avpq.getQUA3() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public String getPlatformName()
  {
    return "qq";
  }
  
  public String getPlatformVersion()
  {
    return aqgz.getQQVersion();
  }
  
  public String getResPath(String paramString1, String paramString2, MiniGameInfo paramMiniGameInfo)
  {
    return MiniAppFileManager.getInstance().getAbsolutePath(paramString1);
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
    }
    return MiniAppFileManager.getInstance().getTmpPath(paramString);
  }
  
  public String getWxFilePath(String paramString)
  {
    return MiniAppFileManager.getInstance().getWxFilePath(paramString);
  }
  
  public boolean isDebug()
  {
    return isAppSettingDebugVersion();
  }
  
  public boolean isNotchValid()
  {
    return ayxa.isLiuHaiUseValid();
  }
  
  public int jsErrorDetectInterval()
  {
    return GameWnsUtils.getGameJsErrorDetectInterval();
  }
  
  public void killSelf(Context paramContext)
  {
    GameLog.getInstance().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof GameActivity)) {
      ((GameActivity)paramContext).finish();
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
    return FileUtils.readFileToStr(paramFile);
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), paramInt, paramString, "1");
    if (paramInt == 23) {
      this.mRuntimeLoader.getReportManager().onJsError();
    }
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label28;
      }
      MiniProgramLpReportDC04902.reportGameStart(this.mRuntimeLoader.getGameInfoManager().getAppId());
    }
    label28:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    MiniProgramLpReportDC04902.accumulateDrawFrameDuration(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    AppBrandTask.runTaskOnUiThread(new QQEnvImp.2(this, paramContext, paramDialogCallback));
  }
  
  public void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    MiniProgramLpReportDC04902.updateDisplayFrameTime(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp
 * JD-Core Version:    0.7.0.1
 */