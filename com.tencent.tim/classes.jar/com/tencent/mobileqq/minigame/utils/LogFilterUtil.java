package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class LogFilterUtil
{
  public static final Set<String> DEFAULT_BLACK_SET = new HashSet(Arrays.asList(new String[] { "__TT__GLOBAL__", "createAudioInstance", "setAudioState", "getAudioState", "operateAudio", "destroyAudioInstance", "onAudioStateChange", "setInnerAudioOptionQGame", "getAvailableAudioSources", "loadFont", "getTextLineHeight", "showKeyboard", "hideKeyboard", "updateKeyboard", "onKeyboardInput", "onKeyboardConfirm", "onKeyboardComplete", "onDeviceOrientationChange", "reportDataToDC", "reportRealtimeAction", "api_report", "insertVideoPlayer", "updateVideoPlayer", "removeVideoPlayer", "operateVideoPlayer", "login", "refreshSession", "shareAppMessageDirectly", "showShareMenu", "shareAppPictureMessage", "shareAppPictureMessageDirectly", "showShareMenuWithShareTicket", "shareAppMessage", "hideShareMenu", "updateShareMenuShareTicket", "getShareInfo", "profile", "private_addContact", "getQua", "notifyNative", "getStoreAppList", "wnsRequest", "navigateToMiniProgramConfig", "recordOffLineResourceState", "private_openUrl", "authorize", "operateWXData", "reportSubmitForm", "getNativeUserInfo", "getOpenDataUserInfo", "getNetworkType", "onNetworkStatusChange", "showToast", "hideToast", "showLoading", "hideLoading", "showModal", "showActionSheet", "setScreenBrightness", "getScreenBrightness", "setKeepScreenOn", "getBatteryInfo", "getBatteryInfoSync", "getClipboardData", "setClipboardData", "enableAccelerometer", "enableCompass", "enableGyroscope", "enableDeviceMotionChangeListening", "vibrateShort", "vibrateLong", "onAccelerometerChange", "onCompassChange", "onGyroscopeChange", "onDeviceMotionChange", "removeStorage", "removeStorageSync", "setStorage", "setStorageSync", "clearStorage", "clearStorageSync", "getStorage", "getStorageSync", "getStorageInfo", "getStorageInfoSync", "getGlobalStorage", "setGlobalStorage", "createRewardedVideoAd", "operateRewardedAd", "onRewardedVideoStateChange", "createBannerAd", "operateBannerAd", "updateBannerAdSize", "onBannerAdStateChange", "onBannerAdShowDone", "setEnableDebug", "onMemoryWarning", "setStatusBarStyle", "setMenuStyle", "getOpenDataContext", "onMessage" }));
  public static final Set<String> DEFAULT_WHITE_SET = new HashSet();
  private static final String TAG = "LogFilterUtil";
  private static final String TT_GLOBAL_TAG = "__TT__GLOBAL__";
  private static final String __JSBRIDGE_ALL_LOG__ = "__jsBridge_all_log__";
  private static Set<String> mLogBlackList;
  private static Set<String> mLogWhiteList;
  
  public static Set<String> getLogBlackList()
  {
    if (mLogBlackList == null)
    {
      mLogBlackList = new HashSet(DEFAULT_BLACK_SET);
      Object localObject = GameWnsUtils.getWnsLogBlackList();
      GameLog.getInstance().i("LogFilterUtil", "wns config black list: " + (String)localObject);
      localObject = parseConfigString2Set((String)localObject);
      if (localObject != null) {
        mLogBlackList.addAll((Collection)localObject);
      }
    }
    return mLogBlackList;
  }
  
  public static Set<String> getLogWhiteList()
  {
    if (mLogWhiteList == null)
    {
      mLogWhiteList = new HashSet(DEFAULT_WHITE_SET);
      Object localObject = GameWnsUtils.getWnsLogWhiteList();
      GameLog.getInstance().i("LogFilterUtil", "wns config white list: " + (String)localObject);
      localObject = parseConfigString2Set((String)localObject);
      if (localObject != null) {
        mLogWhiteList.addAll((Collection)localObject);
      }
      if (QLog.isColorLevel()) {
        mLogWhiteList.add("__jsBridge_all_log__");
      }
    }
    return mLogWhiteList;
  }
  
  private static Set<String> parseConfigString2Set(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    HashSet localHashSet;
    String[] arrayOfString;
    do
    {
      do
      {
        return paramString;
        localHashSet = new HashSet();
        arrayOfString = paramString.split(",");
        paramString = localHashSet;
      } while (arrayOfString == null);
      paramString = localHashSet;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localHashSet;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i].trim();
      if (!TextUtils.isEmpty(paramString)) {
        localHashSet.add(paramString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.LogFilterUtil
 * JD-Core Version:    0.7.0.1
 */