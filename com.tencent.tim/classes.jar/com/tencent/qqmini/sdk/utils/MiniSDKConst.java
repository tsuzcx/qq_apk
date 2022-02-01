package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.HashMap;

@MiniKeep
public class MiniSDKConst
{
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
  public static final int AUDIO_ROUTE_EARPIECE = 0;
  public static final int AUDIO_ROUTE_SPEAKER = 1;
  public static final int Audit = 2;
  public static final int AuditPass = 6;
  public static final int AuditReject = 7;
  public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.16.0.00063";
  public static final int Deleted = 5;
  public static final int Develop = 0;
  public static final String ENG_LOG_TAG = "[MiniEng]";
  public static final int Experience = 1;
  public static final String GPKG_LOG_TAG = "[Gpkg]";
  public static final int GrayRelease = 8;
  public static final String INNER_JSSDK_ASSETS_PATH = "mini";
  public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
  public static final String KEY_BASELIB_LOCAL_VERSION = "version";
  public static final String KEY_BASELIB_MIN_UPDATE_TIME = "baselib_min_update_time";
  public static final String MINI_FILE_LOG_PATH = "/Tencent/mini/files/";
  public static final String MINI_SDK_VERSION = "1.5.0";
  public static final String MINI_TAG = "[mini] ";
  public static final int MULTI_ENTER_ROOM_RESULT_DEVICE_TAKE_UP = -2;
  public static final int MULTI_ENTER_ROOM_RESULT_DUPLICATE_CALL = -3;
  public static final int MULTI_ENTER_ROOM_RESULT_FAIL = -1;
  public static final int MULTI_ENTER_ROOM_RESULT_SUCCESS = 0;
  public static final int MULTI_ERROR_ENTER_ROOM_FAIL = 2;
  public static final int MULTI_ERROR_ENTER_ROOM_TIMEOUT = 1;
  public static final int MULTI_ERROR_INTERRUPT_BY_THIRD_CALL = 4;
  public static final int MULTI_ERROR_NET_ERROR = 3;
  public static final String ON_APP_LOW_MEMORY = "onMemoryWarning";
  public static final int Offline = 9;
  public static final int Online = 3;
  public static final int Preview = 4;
  public static final int START_MODE_APPID = 1;
  public static final int START_MODE_LINK = 2;
  public static final int START_MODE_NORMAL = 0;
  public static final String STR_WXFILE = WnsConfig.getConfig("qqminiapp", "MiniAppFileString", "wxfile://");
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  public static final String URL_UPGRADE = "https://m.q.qq.com/upgrade/{appid}";
  private static String gMiniCacheFilePath = "";
  
  private static String getExternalPath()
  {
    Object localObject3 = null;
    try
    {
      Object localObject1 = AppLoaderFactory.g().getContext().getExternalCacheDir();
      if (localObject1 != null)
      {
        QMLog.e("MiniSDKConst", "getExternalPath : " + ((File)localObject1).getParent());
        localObject1 = ((File)localObject1).getParent();
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          localObject2 = null;
        }
        localObject2 = localObject3;
      } while (!"mounted".equals(Environment.getExternalStorageState()));
      Object localObject2 = Environment.getExternalStorageDirectory();
      if (localObject2 != null)
      {
        QMLog.e("MiniSDKConst", "getExternalPath1 : " + ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/");
        return ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/";
      }
      localObject2 = AppLoaderFactory.g().getContext().getFilesDir();
      if (localObject2 != null)
      {
        QMLog.e("MiniAppGlobal", "getExternalPath2 : " + ((File)localObject2).getParent());
        return ((File)localObject2).getParent();
      }
      QMLog.e("MiniAppGlobal", "getExternalPath3 : /data/data/com.tencent.mobileqq/");
    }
    return "/data/data/com.tencent.mobileqq/";
  }
  
  public static String getMiniCacheFilePath()
  {
    if (TextUtils.isEmpty(gMiniCacheFilePath)) {
      gMiniCacheFilePath = getExternalPath() + "/Tencent/mini/files/";
    }
    return gMiniCacheFilePath;
  }
  
  public static class AdConst
  {
    public static final HashMap<Integer, String> CodeMsgMap = new MiniSDKConst.AdConst.1();
    public static final int ERROR_CODE_BANNED = 1007;
    public static final int ERROR_CODE_CLOSED = 1008;
    public static final int ERROR_CODE_INNER_ERROR = 1003;
    public static final int ERROR_CODE_INVALID_ADUNITID = 1002;
    public static final int ERROR_CODE_INVALID_POSITION = 1009;
    public static final int ERROR_CODE_IN_REVIEW = 1005;
    public static final int ERROR_CODE_NO_AD = 1004;
    public static final int ERROR_CODE_PARAM_ERROR = 1001;
    public static final int ERROR_CODE_REJECTED = 1006;
    public static final int ERROR_CODE_SERVICE_FAIL = 1000;
    public static final String ERROR_MSG_BANNED = "广告组件被封禁";
    public static final String ERROR_MSG_CLOSED = "广告单元已关闭";
    public static final String ERROR_MSG_INNER_ERROR = "内部错误";
    public static final String ERROR_MSG_INVALID_ADUNITID = "广告单元无效";
    public static final String ERROR_MSG_INVALID_POSITION = "广告位置设置有误";
    public static final String ERROR_MSG_IN_REVIEW = "广告组件审核中";
    public static final String ERROR_MSG_NO_AD = "无合适的广告";
    public static final String ERROR_MSG_PARAM_ERROR = "参数错误";
    public static final String ERROR_MSG_REJECTED = "广告组件被驳回";
    public static final String ERROR_MSG_SERVICE_FAIL = "后端接口调用失败";
    public static final int KErrAdDeleted = -100100002;
    public static final int KErrAdGdtNoData = -100100008;
    public static final int KErrAdNotFound = -100100007;
    public static final int KErrAdPositionExtIsNil = -100100005;
    public static final int KErrAdPositionIsNil = -100100004;
    public static final int KErrAdShutdown = -100100001;
    public static final int KErrAdStatusUnkown = -100100003;
    public static final int KErrAppNotFound = -100100006;
    
    public static int getRetCodeByServerResult(int paramInt)
    {
      if ((paramInt >= -100101009) && (paramInt <= -100101000)) {
        return 1000;
      }
      switch (paramInt)
      {
      default: 
        return -1;
      case -100100002: 
      case -100100001: 
        return 1008;
      case -100100007: 
      case -100100004: 
      case -100100003: 
        return 1002;
      case -100100006: 
      case -100100005: 
        return 1001;
      }
      return 1004;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniSDKConst
 * JD-Core Version:    0.7.0.1
 */