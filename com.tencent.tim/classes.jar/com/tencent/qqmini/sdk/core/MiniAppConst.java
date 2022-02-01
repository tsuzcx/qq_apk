package com.tencent.qqmini.sdk.core;

public class MiniAppConst
{
  public static final int APP_LIFECYCLE_BACKGROUND = 3;
  public static final int APP_LIFECYCLE_DESTROY = 4;
  public static final int APP_LIFECYCLE_FOREGROUND = 2;
  public static final int APP_LIFECYCLE_START = 1;
  public static final String MENU_STYLE_DARK = "dark";
  public static final String MENU_STYLE_LIGHT = "light";
  public static final String MINI_ACTION_PROCESS = "mini_action_process";
  public static final int MINI_CMD_ON_PROCESS_BACKGROUND = 4;
  public static final int MINI_CMD_ON_PROCESS_DESTROY = 2;
  public static final int MINI_CMD_ON_PROCESS_FOREGROUND = 3;
  public static final int MINI_CMD_ON_PROCESS_START = 1;
  public static final String MINI_KEY_APPINFO = "mini_appinfo";
  public static final String MINI_KEY_CMD = "mini_cmd";
  public static final String MINI_KEY_EXTRA = "mini_process_extra";
  public static final String MINI_KEY_PRELOAD_RUNTIME_TYPE = "mini_key_preload_runtime_type";
  public static final String MINI_KEY_PRELOAD_TYPE = "mini_key_preload_type";
  public static final String MINI_KEY_PROCESS = "mini_process_name";
  public static final String MINI_KEY_RECEIVER = "receiver";
  public static final String PRELOAD_TYPE_APP = "preload_app";
  public static final String PRELOAD_TYPE_GAME = "preload_game";
  
  public static class RUNTIME_RETCODE
  {
    public static final int CODE_APKG_DOWNLOAD_FAIL = 1;
    public static final int CODE_BASELIB_UPDATED = 12;
    public static final String CODE_BASELIB_UPDATED_MSG = "基础库版本更新";
    public static final int CODE_BASELIB_UPDATE_FAIL = 11;
    public static final String CODE_BASELIB_UPDATE_FAIL_MSG = "基础库更新失败";
    public static final int CODE_PAGE_PRELOAD_FAIL = 10;
    public static final String CODE_PAGE_PRELOAD_FAIL_MSG = "Page创建失败";
    public static final int CODE_VERSIION_NOT_SUPPORT = 13;
    public static final String CODE_VERSIION_NOT_SUPPORT_MSG = "APP版本需升级";
  }
  
  public static class RUNTIME_STATE_MSG
  {
    public static final int RUNTIME_MSG_CLOSE_INNER = 60;
    public static final int RUNTIME_MSG_CLOSE_LOADING = 61;
    public static final int RUNTIME_MSG_DEBUG_DISABLE_BREAKPOINT = 101;
    public static final int RUNTIME_MSG_DEBUG_ENABLE_BREAKPOINT = 100;
    public static final int RUNTIME_MSG_DOM_READY = 11;
    public static final int RUNTIME_MSG_FRAMEWORK_COMPLETED = 3;
    public static final int RUNTIME_MSG_GAME_DESTROY = 64;
    public static final int RUNTIME_MSG_GAME_LAUNCH = 63;
    public static final int RUNTIME_MSG_HIDE_INPUT = 70;
    public static final int RUNTIME_MSG_LAUNCH_FAIL = 12;
    public static final int RUNTIME_MSG_LAUNCH_TIMEOUT = 13;
    public static final int RUNTIME_MSG_LOADED = 4;
    public static final int RUNTIME_MSG_MTA_REPORT = 50;
    public static final int RUNTIME_MSG_ON_BACK_KEY = 25;
    public static final int RUNTIME_MSG_ON_DESTROY = 23;
    public static final int RUNTIME_MSG_ON_PAUSE = 24;
    public static final int RUNTIME_MSG_ON_RESUME = 21;
    public static final int RUNTIME_MSG_ON_START = 20;
    public static final int RUNTIME_MSG_ON_STOP = 22;
    public static final int RUNTIME_MSG_ROUTE_DONE = 10;
    public static final int RUNTIME_MSG_START = 2;
    public static final int RUNTIME_MSG_UNLOAD = 62;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.MiniAppConst
 * JD-Core Version:    0.7.0.1
 */