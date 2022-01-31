package com.tencent.mobileqq.emosm;

public class EmosmConstant
{
  public static final String ACTION_AIO_EMOTICON = "actEmoAIO";
  public static final String ACTION_EMOTICON_PACKAGE = "actEmoPackage";
  public static final String ACTION_QFACE_GIF = "actQFaceGif";
  public static final String ACTION_QFACE_GIF_PACKAGE = "actQFaceGifPackage";
  public static final String ACTION_QFACE_MATERIAL = "actQFaceMaterial";
  public static final String CMD_EMOSM = "BQMallSvc.TabOpReq";
  public static final String CMD_EMOSM_CHECK_OIDB = "OidbSvc.0x490_92";
  public static final String CMD_EMOSM_CHECK_UPDATE = "BQMallSvc.checkUpdate";
  public static final String CMD_EMOSM_EMOS = "EmosmEmos";
  public static final String CMD_EMOSM_PACKAGE_KEY = "EmosmPackageId";
  public static final String CMD_EMOSM_SUBCMD_FLLOW = "EmosmSubCmdFllow";
  public static final String CMD_EMOSM_SUBCMD_KEY = "EmosmSubCmd";
  public static final String EMOSM_HAS_DOWNLOAD_EMOSMPACKAGE_TAG = "emosm_has_download_emosmpackage_tag";
  public static final String EMOSM_HAS_SET_EMOSMPACKAGE_VALID = "emosm_has_set_emosmpackage_valid";
  public static final String EMOSM_HAS_SET_MAGICTAB_VALID = "emosm_has_set_magictab_valid";
  public static final String EMOSM_RECOMMEND_TAB_JSON = "emosm_recommend_tab_json_s";
  public static final String EMOSM_SP_CHAT_IS_SHOW_NEW = "emosm_sp_chat_is_show_new";
  public static final String EMOSM_SP_IS_SHOW_NEW = "emosm_sp_is_show_new";
  public static final String EMOSM_SP_LAST_CHECK_TIMESTAMP = "emosm_sp_last_check_timestamp";
  public static final String EMOSM_SP_MALL_NEW_TIMESTAMP = "emosm_sp_mall_new_timestamp";
  public static final String EMOSM_SP_RESULT = "emosm_sp_result";
  public static final String EMOSM_SP_TABFILE_TIMESTAMP = "emosm_sp_tab_file_timestamp";
  public static final String EMOSM_SP_TIMESTAMP = "emosm_sp_timestamp";
  public static final String EMOSM_SP_WORDING_TIMESTAMP = "emosm_sp_wording_timestamp";
  public static final String EMOSM__JSON_LAST_DOWNLOAD_TIMESTAMP = "emosm_json_last_download_timestamp";
  public static final String EMOTICON_JSON_UPDATE_REQUEST_SUFFIX = "_json";
  public static final int EMOTICON_TASK_AIO_PREVIEW_STATIC = 1;
  public static final int EMOTICON_TASK_GIF = 4;
  public static final int EMOTICON_TASK_PRIVIEW = 2;
  public static final int EMOTICON_TASK_SOUND = 8;
  public static final String EMO_QFACE_TAG = "Q.emoji.EmoQFace";
  public static final String EMO_TAG = "Q.emoji.EmoDown";
  public static final String LastPullRecommendEmoticonPkgTime = "emosm_last_pull_recommend_pkg_time";
  public static final String MAGIC_EMOSM_RECOMMEND_JSON = "magic_emosm_recommend_tab_json";
  public static final int PACKAGE_COMPLETE = 2;
  public static final int PACKAGE_LOADING = 1;
  public static final int PACKAGE_LOSSY = 0;
  public static final int PACKAGE_OVERDUE = 3;
  public static final String PARAM_ENCRYPT_KEYS = "param_encrypt_keys";
  public static final String PARAM_EP_ID = "param_epId";
  public static final String PARAM_ERROR = "param_error";
  public static final String PARAM_E_ID = "param_eId";
  public static final String PARAM_FAIL_CODE = "param_FailCode";
  public static final String PARAM_IP_URL = "param_ipUrl";
  public static final String PARAM_KEY_SEQ = "param_key_seq";
  public static final String PARAM_PROGRESS = "param_progress";
  public static final String PARAM_RESP_CODE = "param_respcode";
  public static final String PARAM_RESP_CONTENT = "param_resp_content";
  public static final String PARAM_RESP_CONTENT_READ = "param_resp_content_read";
  public static final String PARAM_STEP = "param_step";
  public static final String PARAM_TIMEOUT_REASON = "param_timeout";
  public static final String PARAM_TRY_COUNT = "param_try_count";
  public static final int RESULT_CODE_BIG_IMAGE_DECODE_FAIL = 11017;
  public static final int RESULT_CODE_BIG_IMAGE_ENCODE_FAIL = 11018;
  public static final int RESULT_CODE_BIG_IMAGE_OTHER_FAIL = 11020;
  public static final int RESULT_CODE_BIG_IMAGE_SAVE_FAIL = 11019;
  public static final int RESULT_CODE_DOWNLOAD_OTHER_ERROR = 11011;
  public static final int RESULT_CODE_ENCRYPT_KEYS_FAIL = 11009;
  public static final int RESULT_CODE_ENCRYPT_KEYS_NO_CALLBACK = 11022;
  public static final int RESULT_CODE_ENCRYPT_KEYS_TIMEOUT = 11023;
  public static final int RESULT_CODE_HOLD_ALL_EXCEPTION = 11015;
  public static final int RESULT_CODE_HTTP_RESPONSE_NO_OK = 11016;
  public static final int RESULT_CODE_ILLEGAL_EP_ID = 11024;
  public static final int RESULT_CODE_IS_HTML = 11021;
  public static final int RESULT_CODE_JSON_PARSE_FAIL = 11008;
  public static final int RESULT_CODE_LOCAL_FILESYSTEM_FAIL = 11013;
  public static final int RESULT_CODE_NET_CONNECT_TIMEOUT = 11004;
  public static final int RESULT_CODE_NET_CONTENT_LOSSY = 11006;
  public static final int RESULT_CODE_NET_SO_TIMEOUT = 11005;
  public static final int RESULT_CODE_NET_UNKNOWN_HOST = 11002;
  public static final int RESULT_CODE_NET_UNUSABLE = 11003;
  public static final int RESULT_CODE_OK = 0;
  public static final int RESULT_CODE_PLUGIN_ERROR = 11029;
  public static final int RESULT_CODE_PLUGIN_IS_NULL = 11027;
  public static final int RESULT_CODE_PLUGIN_LOADING_CANCEL = 11028;
  public static final int RESULT_CODE_PLUGIN_QUERY_TIMEOUT = 11026;
  public static final int RESULT_CODE_QFACE_UNZIP_FAIL = 11025;
  public static final int RESULT_CODE_SDCARD_FULL = 11001;
  public static final int RESULT_CODE_SDCARD_UNUSABLE = 11000;
  public static final int RESULT_CODE_SOCKET_EXCEPTION_ERROR = 11012;
  @Deprecated
  public static final int RESULT_CODE_TEA_ENCODE_FAIL = 11010;
  public static final int RESULT_CODE_URL_STRING_ILLEGAL = 11014;
  public static final int RESULT_CODE_USER_CANCEL = 11007;
  public static final int STEP_CHECK = 0;
  public static final int STEP_EMOTICON_AIO_PREVIEW_STATIC = 8;
  public static final int STEP_EMOTICON_IMG_GIF = 7;
  public static final int STEP_EMOTICON_IMG_PREVIEW = 6;
  public static final int STEP_EMOTICON_SOUND = 9;
  public static final int STEP_ENCRYPT_KEYS = 5;
  public static final int STEP_JSON = 1;
  public static final int STEP_PACKAGE_COLOR = 3;
  public static final int STEP_PACKAGE_GRAY = 4;
  public static final int STEP_PACKAGE_THUMB = 2;
  public static final int STEP_QFACE_COLOR = 13;
  public static final int STEP_QFACE_GIF = 12;
  public static final int STEP_QFACE_GRAY = 14;
  public static final int STEP_QFACE_IMG_PREVIEW = 15;
  public static final int STEP_QFACE_MATERIAL = 10;
  public static final int STEP_QFACE_UNZIP = 11;
  public static final int TYPE_EMOSM_ADD_FAVORITES = 6;
  public static final int TYPE_EMOSM_ADD_FORWARD = 7;
  public static final int TYPE_EMOSM_CHECK_UPDATE = 4;
  public static final int TYPE_EMOSM_PS_FETCH = 2;
  public static final int TYPE_EMOSM_P_DEL = 1;
  public static final int TYPE_EMOSM_P_KEYS_FETCH = 3;
  public static final int TYPE_EMOSM_RECOMMEND_PKG = 5;
  public static final int TYPE_EMOSM_REPORT_ADD_PKG = 8;
  public static final int TYPE_EMOSM_SEND_FLLOW = 107;
  public static final int ZIP_NO_EXIST = 0;
  public static final int ZIP_UNZIP_FAIL = 3;
  public static final int ZIP_UNZIP_ING = 1;
  public static final int ZIP_UNZIP_SUCCESS = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmConstant
 * JD-Core Version:    0.7.0.1
 */