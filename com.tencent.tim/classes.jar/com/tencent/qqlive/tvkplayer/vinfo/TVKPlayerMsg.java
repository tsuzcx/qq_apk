package com.tencent.qqlive.tvkplayer.vinfo;

public class TVKPlayerMsg
{
  public static int PLAYER_AUDIO_FRAME_OUTPUT_FORMAT_PCM = 1;
  public static final String PLAYER_CHOICE = "player_choice";
  public static final String PLAYER_CHOICE_AUTO = "auto";
  public static final String PLAYER_CHOICE_SELF = "self";
  public static final String PLAYER_CHOICE_SELF_SOFT = "self_soft";
  public static final String PLAYER_CHOICE_SYSTEM = "system";
  public static final int PLAYER_FORCE_TYPE_NONE = 0;
  public static final int PLAYER_FORCE_TYPE_SELF = 2;
  public static final int PLAYER_FORCE_TYPE_SELF_SOFT = 3;
  public static final int PLAYER_FORCE_TYPE_SYS = 1;
  public static final int PLAYER_HEADPHONE_BLUETOOTH = 1;
  public static final int PLAYER_HEADPHONE_WIRED = 0;
  public static final int PLAYER_INFO_AD_CGI_RECEIVE = 49;
  public static final int PLAYER_INFO_BLINDNESS_CLOSED_BY_INTERNAL = 75;
  public static final int PLAYER_INFO_CDNID = 51;
  public static final int PLAYER_INFO_CDNSERVER = 52;
  public static final int PLAYER_INFO_CURRENT_VID_DOWNLOAD_FIN = 58;
  public static final int PLAYER_INFO_DECODER_BLOCK = 28;
  @Deprecated
  public static final int PLAYER_INFO_DEFINITION_FORCE = 45;
  public static final int PLAYER_INFO_DOLBY_DECODE_FAIL = 27;
  public static final int PLAYER_INFO_DYNAMIC_LOGO = 57;
  public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
  public static final int PLAYER_INFO_END_GET_VINFO = 34;
  public static final int PLAYER_INFO_FETCH_NEXT_VIDEO_INFO = 36;
  public static final int PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED = 63;
  public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED = 62;
  public static final int PLAYER_INFO_FLOWID = 50;
  public static final int PLAYER_INFO_HDR10_ENHANCE_CLOSED_BY_INTERNAL = 74;
  @Deprecated
  public static final int PLAYER_INFO_INNER_END_SWITCH_DEFN = 41;
  @Deprecated
  public static final int PLAYER_INFO_INNER_START_SWITCH_DEFN = 40;
  public static final int PLAYER_INFO_INTERACTIVE_EOF = 69;
  public static final int PLAYER_INFO_INTERACTIVE_START = 70;
  public static final int PLAYER_INFO_LOOP_AD_START = 37;
  public static final int PLAYER_INFO_LOOP_VIDEO_START = 38;
  public static final int PLAYER_INFO_NEXT_NET_VINFO = 35;
  public static final int PLAYER_INFO_OFFLINE_2_ONLINE = 42;
  public static final int PLAYER_INFO_OFFLINE_NOMORE_CACHE = 39;
  public static final int PLAYER_INFO_ONE_LOOP_COMPLETE = 55;
  public static final int PLAYER_INFO_ONE_LOOP_START = 56;
  public static final int PLAYER_INFO_PLAYER_TYPE = 31;
  public static final int PLAYER_INFO_PLAYER_TYPE_SELF = 2;
  public static final int PLAYER_INFO_PLAYER_TYPE_SYSTEM = 1;
  @Deprecated
  public static final int PLAYER_INFO_PRE_AD_PLAYER_TYPE = 32;
  public static final int PLAYER_INFO_PRIVATE_HLS_M3U8_TAG = 53;
  @Deprecated
  public static final int PLAYER_INFO_RESTORED = 71;
  public static final int PLAYER_INFO_RETRY_PLAYER = 29;
  public static final int PLAYER_INFO_RETRY_PLAYER_DONE = 47;
  @Deprecated
  public static final int PLAYER_INFO_RETRY_URL = 30;
  public static final int PLAYER_INFO_RETURN_VIDEO_DURATION = 26;
  public static final int PLAYER_INFO_SEAMLESS_SWITCH_DEFN_DONE = 43;
  public static final int PLAYER_INFO_SEAMLESS_SWITCH_DEFN_FAIL = 44;
  @Deprecated
  public static final int PLAYER_INFO_SEAMLESS_SWITCH_TYPE = 48;
  public static final int PLAYER_INFO_SELFADAPTIVE_SWITCH_END = 67;
  public static final int PLAYER_INFO_SELFADAPTIVE_SWITCH_FAILED = 68;
  public static final int PLAYER_INFO_SELFADAPTIVE_SWITCH_START = 66;
  public static final int PLAYER_INFO_SKIPAD_FOR_VIPUSER = 25;
  public static final int PLAYER_INFO_START_BUFFERING = 21;
  public static final int PLAYER_INFO_START_GET_VINFO = 33;
  public static final int PLAYER_INFO_START_RENDERING = 23;
  public static final int PLAYER_INFO_SUBTITLE_FIRST_LOAD = 72;
  public static final int PLAYER_INFO_SUBTITLE_SEL_END = 65;
  public static final int PLAYER_INFO_SUBTITLE_SEL_START = 64;
  public static final int PLAYER_INFO_SUCC_SET_DECODER_MODE = 24;
  public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_DONE = 60;
  public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_FAIL = 61;
  public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_START = 59;
  public static final int PLAYER_INFO_SWITCH_DEFN_TYPE = 46;
  public static final int PLAYER_INFO_TV_TEST_CDN_URL = 54;
  public static final int PLAYER_INFO_UNKNOW = 20;
  public static final int PLAYER_INFO_VR_CLOSED_BY_INTERNAL = 73;
  public static final int PLAYER_REALTIME_INFO_TYPE_AD_ENABLE_CLICK = 4;
  public static final int PLAYER_REALTIME_INFO_TYPE_AD_REALTIME_STRATEGY = 5;
  public static final int PLAYER_REALTIME_INFO_TYPE_AD_REQUEST_PARAM = 3;
  public static final int PLAYER_REALTIME_INFO_TYPE_IS_PRELOAD = 1;
  public static final int PLAYER_REALTIME_INFO_TYPE_LOGO_SCENE = 8;
  public static final int PLAYER_REALTIME_INFO_TYPE_SKIP_POS = 6;
  public static final int PLAYER_REALTIME_INFO_TYPE_USER_SCENE = 2;
  public static final int PLAYER_SWITCH_DEF_IFRAME_TYPE = 1;
  public static final int PLAYER_SWITCH_DEF_SEEK_TYPE = 0;
  public static final int PLAYER_SWITCH_DEF_TYPE_REOPEN = 0;
  public static final int PLAYER_SWITCH_DEF_TYPE_SEAMLESS = 1;
  public static final int PLAYER_TYPE_DLNA_LIVE = 6;
  public static final int PLAYER_TYPE_DLNA_VOD = 7;
  public static final int PLAYER_TYPE_EXTERNAL_URL = 5;
  public static final int PLAYER_TYPE_LOCAL_FILE = 4;
  public static final int PLAYER_TYPE_LOOP_VOD = 8;
  public static final int PLAYER_TYPE_OFFLINE = 3;
  public static final int PLAYER_TYPE_ONLINE_LIVE = 1;
  public static final int PLAYER_TYPE_ONLINE_VOD = 2;
  public static int PLAYER_VIDEO_FRAME_OUTPUT_FORMAT_RGB = 1;
  public static int PLAYER_VIDEO_FRAME_OUTPUT_FORMAT_YUV = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerMsg
 * JD-Core Version:    0.7.0.1
 */