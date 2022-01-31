package com.tencent.mobileqq.emosm.web;

import java.util.HashMap;

public abstract interface IPCConstants
{
  public static final int DOWNLOAD_END_STATE_CANCELLED = 2;
  public static final int DOWNLOAD_END_STATE_ERROR = -1;
  public static final int DOWNLOAD_END_STATE_LOCAL_EXIST = 3;
  public static final int DOWNLOAD_END_STATE_NON_BUY = 4;
  public static final int DOWNLOAD_END_STATE_NO_MEMO = 1;
  public static final int DOWNLOAD_END_STATE_NO_NET = 5;
  public static final int DOWNLOAD_END_STATE_NO_SDCARD = 6;
  public static final int DOWNLOAD_END_STATE_SUCCESS = 0;
  public static final int DOWNLOAD_PEORIOD_TYPE_END = 1;
  public static final String EMO_WEB_TAG = "web.";
  public static final String IPC_BUBBLE_QUERYINFO_K = "queryBubbleInfo";
  public static final int IPC_BUBBLE_QUERYINFO_V = 6;
  public static final String IPC_BUBBLE_QUERYLOCAL = "queryLocal";
  public static final String IPC_BUBBLE_REPORTACTION = "reportActionCount";
  public static final String IPC_BUBBLE_SETUP = "setup";
  public static final String IPC_BUBBLE_START_DOWNLOAD_K = "bubble_startDownLoad";
  public static final int IPC_BUBBLE_START_DOWNLOAD_V = 5;
  public static final String IPC_BUBBLE_STOP_DOWNLOAD_K = "bubble_StopDownLoad";
  public static final int IPC_BUBBLE_STOP_DOWNLOAD_V = 7;
  public static final HashMap IPC_CMD_MAP = new IPCConstants.1();
  public static final String IPC_DEVLOCK_CMD_CHANGE_EQUIP_LOCK_MOBILE = "changeEquipLockMobile";
  public static final String IPC_DEVLOCK_CMD_CLOSE_WEB = "closeWeb";
  public static final String IPC_DEVLOCK_CMD_HANDLE_WEB_ERROR = "handleWebError";
  public static final String IPC_DEVLOCK_CMD_OPEN_EQUIP_LOCK = "openEquipmentLock";
  public static final String IPC_DEVLOCK_CMD_SET_MOBILE_RESULT = "setMobileResult";
  public static final String IPC_DEVLOCK_CMD_SET_WAITING_RESPONSE = "setWaitingResponse";
  public static final String IPC_DEVLOCK_CMD_UPDATE_RESULT = "updateResult";
  public static final String IPC_FONT_QUERYLOCAL_K = "queryFontInfo";
  public static final int IPC_FONT_QUERYLOCAL_V = 2;
  public static final String IPC_FONT_START_DOWNLOAD_K = "font_startDownLoad";
  public static final int IPC_FONT_START_DOWNLOAD_V = 3;
  public static final String IPC_FONT_STOP_DOWNLOAD_K = "font_StopDownLoad";
  public static final int IPC_FONT_STOP_DOWNLOAD_V = 4;
  public static final String IPC_FUNC_CMD_CHANGE_AVATAR = "changeAvatar";
  public static final String IPC_FUNC_CMD_GET_FACE_FILE_PATH = "getFaceFilePath";
  public static final String IPC_FUNC_CMD_GET_ROAM_ENCOUNTER = "getRoamEncounter";
  public static final String IPC_FUNC_CMD_GET_USER_VIP_TYPE = "getUserVipType";
  public static final String IPC_FUNC_CMD_NOTIFY_COMMENT_CNT = "notifyCommentCnt";
  public static final String IPC_FUNC_CMD_NOTIFY_TROOP_UPGRADE_SUCCESS = "notifyTroopUpgradeSuccess";
  public static final String IPC_FUNC_CMD_QUERY_INFO = "queryEmojiInfo";
  public static final String IPC_FUNC_CMD_QUERY_INFOS = "queryEmojiInfos";
  public static final String IPC_FUNC_CMD_QWALLET_OPEN_INIT = "qwalletOpenInit";
  public static final String IPC_FUNC_CMD_QWALLET_OPEN_LOGIN = "qwalletOpenLogin";
  public static final String IPC_FUNC_CMD_SETUP_CHAT_FONT_K = "setupChatFont";
  public static final int IPC_FUNC_CMD_SETUP_CHAT_FONT_V = 1;
  public static final String IPC_FUNC_CMD_START_DOWNLOAD = "startDownloadEmoji";
  public static final String IPC_FUNC_CMD_STOP_DOWNLOAD = "stopDownloadEmoji";
  public static final String IPC_FUNC_CMD_UPDATE_PENDANT_ID = "updatePendantId";
  public static final String IPC_FUNC_CMD_WRITE_QFACE_RESULT = "writeQFaceResult";
  public static final String IPC_QQPLUGIN_CANCELDOWNLOAD = "cancelDownloadPlugin";
  public static final String IPC_QQPLUGIN_DOWNLOADPLUGIN = "downloadPlugin";
  public static final String IPC_QQPLUGIN_QUERYPLUGIN = "queryPlugin";
  public static final String IPC_SETPWD_CMD_GET_A2 = "getA2";
  public static final String IPC_SETPWD_CMD_SET_HAS_SET_PWD = "setHasSetPwd";
  public static final String IPC_THEME_ADDTHEMESPECIFIC = "addThemeSpecific";
  public static final String IPC_THEME_PAUSEDOWNLOAD = "pausedownload";
  public static final String IPC_THEME_REMOVETHEMESPECIFIC = "removeThemeDownHandler";
  public static final String IPC_THEME_STARTDOWNLOAD = "startDownloadTheme";
  public static final String IPC_THEME_STOPDOWNLOAD = "stopdownload";
  public static final int MSG_CLIENT_RESP = 4;
  public static final int MSG_REGISTER_CLIENT = 1;
  public static final int MSG_SERVER_DOWNLOAD_STATE = 5;
  public static final int MSG_SERVER_REQ = 3;
  public static final int MSG_UNREGISTER_CLIENT = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.IPCConstants
 * JD-Core Version:    0.7.0.1
 */