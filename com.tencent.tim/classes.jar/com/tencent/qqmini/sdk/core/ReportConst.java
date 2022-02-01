package com.tencent.qqmini.sdk.core;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ReportConst
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  private static MiniAppInfo MINI_APP_CONFIG_FOR_PRELOAD;
  public static final String PRELOAD_MINI_APP_ID = "0000000000";
  public static List<String> apiReportList = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static MiniAppInfo miniAppConfigForPreload()
  {
    if (MINI_APP_CONFIG_FOR_PRELOAD == null) {}
    try
    {
      if (MINI_APP_CONFIG_FOR_PRELOAD == null)
      {
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = "0000000000";
        localMiniAppInfo.launchParam.miniAppId = "0000000000";
        MINI_APP_CONFIG_FOR_PRELOAD = localMiniAppInfo;
      }
      return MINI_APP_CONFIG_FOR_PRELOAD;
    }
    finally {}
  }
  
  public static class ACTION
  {
    public static final String ARK_ACTION = "ark";
    public static final String ARK_SUB_ACTION_BATTLE = "ark_battle";
    public static final String DESKTOP_ACTION = "desktop";
    public static final String DROP_DOWN_ACTION = "drop_down";
    public static final String DROP_DOWN_RESERVERS_DELETE = "delete";
    public static final String DROP_DOWN_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String DROP_DOWN_RESERVERS_SETTOP_ON = "settop_on";
    public static final String DROP_DOWN_SUB_ACTION_CONTACT = "contact";
    public static final String DROP_DOWN_SUB_ACTION_MESSAGE = "message";
    public static final String DROP_DOWN_SUB_ACTION_MORE = "more";
    public static final String GAME_INNER_ACTION = "game_inner";
    public static final String INNER_SUB_ACTION_LOGIN = "login";
    public static final String INNER_SUB_ACTION_REGISTER = "regist";
    public static final String KEY_ACTION_TYPE = "actiontype";
    public static final String KEY_RESERVES_ACTION = "reserves_action";
    public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
    public static final String MORE_ABOUT_RESERVERS_FEEDBACK = "feedback";
    public static final String MORE_ABOUT_RESERVERS_LAUNCH = "launch";
    public static final String MORE_ABOUT_RESERVERS_LIKE_OFF = "like_off";
    public static final String MORE_ABOUT_RESERVERS_LIKE_ON = "like_on";
    public static final String MORE_ABOUT_RESERVERS_PROFILE = "profile";
    public static final String MORE_ABOUT_RESERVERS_REPORT = "report";
    public static final String MORE_ABOUT_RESERVERS_SET = "set";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_ABOUT_RESERVERS_SHARE = "share";
    public static final String MORE_BUTTON_RESERVERS_ABOUT = "about";
    public static final String MORE_BUTTON_RESERVERS_BACK_HOME = "back_home";
    public static final String MORE_BUTTON_RESERVERS_CANCEL = "cancel";
    public static final String MORE_BUTTON_RESERVERS_CANCEL_SYSTEM = "cancel_system";
    public static final String MORE_BUTTON_RESERVERS_MESSAGE = "message";
    public static final String MORE_BUTTON_RESERVERS_OPEN = "open";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_BUTTON_RESERVERS_SHARE_Moments = "share_Moments";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QQ = "share_QQ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QZ = "share_QZ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_WX = "share_WX";
    public static final String MORE_BUTTON_RESERVERS_SHORTCUT = "add_desktop";
    public static final String PAGE_VIEW_ACTION = "page_view";
    public static final String PAGE_VIEW_SUB_ACTION_CLICK = "click";
    public static final String PAGE_VIEW_SUB_ACTION_CLOSE = "close";
    public static final String PAGE_VIEW_SUB_ACTION_EXPO = "expo";
    public static final String PAGE_VIEW_SUB_ACTION_FINISHSHOW = "finishshow";
    public static final String PAGE_VIEW_SUB_ACTION_HIDE = "hide";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD = "load";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD_FAIL = "load_fail";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW = "show";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW_FAIL = "show_fail";
    public static final String PAGE_VIEW_SUB_ACTION_UNLOAD = "unload";
    public static final String SHARE_ALERT_RESERVERS_ACTION = "show";
    public static final String USER_CLICK_ACTION = "user_click";
    public static final String USER_CLICK_SUB_ACTION_MORE_ABOUT = "more_about";
    public static final String USER_CLICK_SUB_ACTION_MORE_BUTTON = "more_button";
    public static final String USER_CLICK_SUB_ACTION_SHARE_ALERT = "share_alert";
  }
  
  public static class FailCode
  {
    public static final String CACHE_HIT = "hit";
    public static final String CACHE_UNHIT = "unhit";
    public static final String CODE_APPID_CONFLICT_FAIL = "appid_conflict";
    public static final String CODE_BASE_LIB_TASK_FAIL = "baselib_task_fail";
    public static final String CODE_DOWNLOAD_PKG_FAIL = "download_apk_fail";
    public static final String CODE_DOWNLOAD_URL_FAIL = "download_url_fail";
    public static final String CODE_INIT_DATA_FAIL = "init_data_fail";
    public static final String CODE_JS_ERROR = "jsError";
    public static final String CODE_LOADING_PAGE_BACK_PRESS = "loading_page_back_press";
    public static final String CODE_LOADING_PAGE_KILL = "loading_page_kill";
    public static final String CODE_LOAD_BASE_LIB_FAIL = "load_baselib_fail";
    public static final String CODE_LOAD_PKG_FAIL = "load_pkg_fail";
    public static final String CODE_NOT_FOREGROUND_FAIL = "not_foreground";
    public static final String CODE_NOT_READY_FAIL = "not_ready";
    public static final String CODE_OFFLINE_NOT_READY_FAIL = "offline_not_ready";
    public static final String CODE_OFFLINE_NOT_SUPPORT_FAIL = "offline_not_support";
    public static final String CODE_PKG_TASK_FAIL = "pkg_task_fail";
    public static final String CODE_QQ_VERSION_LIMIT_FAIL = "qq_version_limit_fail";
    public static final String CODE_SHORTCUT_REQUEST_FAIL = "shortcut_request_fail";
    public static final String CODE_SPLASH_EXIT_WHEN_FAIL = "splash_exit_when_fail";
    public static final String CODE_START_NO_INTENT_FAIL = "start_no_intent";
    public static final String CODE_SYSTEM_VERSION_LIMIT_FAIL = "system_version_limit_fail";
    public static final String CODE_UNPKG_PKG_FAIL = "unpkg_fail";
    public static final String IS_X5_JSCORE = "is_x5_jscore";
    public static final String JS_ERROR = "jsError";
    public static final String PKG_IS_DOWNLOADED = "pkg_is_downloaded";
    public static final String SHOW_PAGE_KILL = "show_page_kill";
    public static final String TIME_OUT_CODE = "timeout";
    public static final String TIME_OUT_CODE_10 = "timeout_10";
    public static final String TIME_OUT_CODE_15 = "timeout_15";
    public static final String TIME_OUT_CODE_20 = "timeout_20";
    public static final String TIME_OUT_CODE_25 = "timeout_25";
    public static final String TIME_OUT_CODE_5 = "timeout_5";
    public static final String USER_CANCEL_BACK_KEY = "cancel_by_backkey";
    public static final String USER_CANCEL_CLOSE = "cancel_by_close";
  }
  
  public static class PageViewSubAction
  {
    public static final String APKG_CACHE = "cache_apkg_hit";
    public static final String BACK_KEY = "2back_key";
    public static final String CLICK = "2click";
    public static final String CLOSE = "2close";
    public static final String CREATE = "2create";
    public static final String FINISHSHOW = "2finishshow";
    public static final String HIDE = "2hide";
    public static final String LAUNCH = "2launch";
    public static final String LAUNCH_FAIL = "2launch_fail";
    public static final String LOAD = "2load";
    public static final String PAGE_HIDE = "2page_hide";
    public static final String PAGE_SHOW = "2page_show";
    public static final String SHOW = "2show";
    public static final String UNLOAD = "2unload";
  }
  
  public static class QIPCMoudle
  {
    public static final String ACTION_LAUNCH_REPORT_SDK_4239 = "launch_report_sdk_4239";
    public static final String ACTION_RECORD_DURATION_SDK_4239 = "record_duration_sdk_4239";
    public static final String NAME = "MiniAppTransferModule";
  }
  
  public static class Value
  {
    public static final String MINI_APP_START_BY_ID_CACHE = "id_cache";
    public static final String MINI_APP_START_BY_LINK_CACHE = "link_cache";
    public static final String MINI_APP_START_BY_SHOW_CACHE = "show_cache";
    public static final String MINI_APP_START_IN_MAIN_LOADING = "main_loading";
    public static final String PKG_DOWNLOAD = "1";
    public static final String PKG_NO_DOWNLOAD = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.ReportConst
 * JD-Core Version:    0.7.0.1
 */