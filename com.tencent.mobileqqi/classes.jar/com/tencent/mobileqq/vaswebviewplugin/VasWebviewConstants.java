package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Build;
import android.os.Build.VERSION;

public class VasWebviewConstants
{
  public static final int ACTIVITY_TYPE_HOMEPAGE = 1;
  public static final int ACTIVITY_TYPE_SUB_HOMEPAGE = 3;
  public static final int ACTIVITY_TYPE_SUB_PAGE = 2;
  public static final String AVATAR_PENDANT_URL;
  public static final String AVATAR_URLSTART = "http://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html";
  public static final String BUBBLETHEME_HANDLER_NAME_BUBBLE = "bubble";
  public static final String BUBBLETHEME_HANDLER_NAME_COMMON = "common";
  public static final String BUBBLETHEME_HANDLER_NAME_THEME = "theme";
  public static final String BUBBLE_MAINPAGE_URL = "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027";
  public static final String BUBBLE_URLSTART = "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html";
  public static final String BUSINESS = "business";
  public static final String CHAT_FONT_MARKET_HOME_URL;
  public static final String EMOJI_AUTHOR_URLSTART = "http://imgcache.qq.com/club/themes/mobile/bq/html/author.html";
  public static final String EMOJI_DETAIL_URLSTART = "http://imgcache.qq.com/club/themes/mobile/bq/html/detail.html";
  public static final String EMOJI_HANDLER_NAME = "_qqJSBridge_";
  public static final String EMOJI_HOME_URLSTART = "http://imgcache.qq.com/club/themes/mobile/bq/html/index.html";
  public static final String EMOJI_QFACE_URLSTART = "http://imgcache.qq.com/club/themes/mobile/bq/html/qFaceDetail.html";
  public static final int FLAG_HARDWARE_ACCELERATED = 16777216;
  public static final String FROM_INDIVIDUATION_SET = "FromIndividuationSet";
  public static final String FROM_THEME_NOVICE_GUIDE = "FromThemeNoviceGuide";
  public static final String FROM_WHERE_KEY = "FromWhere";
  public static final String HOME_AUTHOR_PAGE_URL = "http://imgcache.qq.com/club/themes/mobile/bq/html/author.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3";
  public static final String HOME_DETAIL_PAGE_URL = "http://imgcache.qq.com/club/themes/mobile/bq/html/detail.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3";
  public static final String HOME_DETAIL_QFACE_PAGE_URL = "http://imgcache.qq.com/club/themes/mobile/bq/html/qFaceDetail.html?id=[id]&type=[type]&uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=3";
  public static final String HOME_PAGE_URL = "http://imgcache.qq.com/club/themes/mobile/bq/html/index.html?uin=[uin]&adtag=[adtag]&client=[client]&version=[version]&sid=[sid]&platformId=2&device=[device]&system=[system]&systemInt=[systemInt]&updateTime=[updateTime]&updateFlag=[updateFlag]&_bid=102&_wv=1027";
  public static final String JS_CALL_JAVA_URL_SCHEME = "jsbridge://";
  public static final String KEY_ADTAG = "adTag";
  public static final String KEY_EMOJIMALL_CLOSE_BACK = "back_from_emojimall";
  public static final String KEY_EMOJIMALL_DETAIL_CHAT_TYPE = "key_emojimall_detail_chat_type";
  public static final String KEY_EMOJIMALL_DETAIL_CHAT_UIN = "key_emojimall_detail_chat_uin";
  public static final String KEY_EMOJIMALL_DETAIL_ID = "emojimall_detail_id";
  public static final String KEY_EMOJIMALL_QFACE = "emojimall_qFace";
  public static final String KEY_EMOJIMALL_SID = "emojimall_sid";
  public static final String KEY_EMOJIMALL_SRC_FROM = "emojimall_src";
  public static final String KEY_MALL_NEW_TIMESTAMP = "emomall_new_time";
  public static final String KEY_OPEN_PAGE_TIME = "startOpenPageTime";
  public static final String KEY_PAGE_TITLE = "pageTitle";
  public static final String KEY_PAGE_URL = "pageUrl";
  public static final String KEY_UPDATE_FLAG = "updateFlag";
  public static final String KEY_UPDATE_TIME = "updateTime";
  public static final String KEY_URL = "url";
  public static final Boolean LOCAL_URL_NEED_KEY_SWITCHER = Boolean.valueOf(false);
  public static final String NAMESPACE_QW = "qw.app";
  public static final String NAMESPACE_VAS = "qqjsbridge";
  public static final String PERSONALITY_QQ_SUIT_URL;
  public static final int REQUEST_CODE_QFACE = 201;
  public static final int RESULT_QFACE_LOSSY = 102;
  public static final int RESULT_QFACE_PATH_ERROR = 101;
  public static final int SRC_TYPE_AIO_EMOPANEL = 1;
  public static final int SRC_TYPE_EMO_DIRECT_AUTHOR = 5;
  public static final int SRC_TYPE_EMO_DIRECT_DETAIL_AIO = 8;
  public static final int SRC_TYPE_EMO_DIRECT_DETAIL_OTHER = 4;
  public static final int SRC_TYPE_EMO_MANAGER = 2;
  public static final int SRC_TYPE_INDIVID_CENTER = 3;
  public static final int SRC_TYPE_MAGIC_EMO_AIO = 6;
  public static final int SRC_TYPE_OTHER_UNKNOWN = 7;
  public static final String TAG = "VasWebviewPlugin";
  public static final String THEME_MAINPAGE_URL = "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027";
  public static final String THEME_URLSTART = "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html").append("?client=androidQQ").append("&version=").append("6.0.1.6600").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&updateFlag=[updateFlag]").append("&_bid=160").append("&_wv=3");
    AVATAR_PENDANT_URL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/font/index.html");
    localStringBuilder.append("?client=androidQQ").append("&version=").append("6.0.1.6600").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&updateFlag=[updateFlag]").append("&_bid=182").append("&_wv=3");
    CHAT_FONT_MARKET_HOME_URL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/suit/index.html");
    localStringBuilder.append("?client=androidQQ").append("&uin=[uin]").append("&version=").append("6.0.1.6600").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=[density]").append("&platformId=2").append("&updateFlag=[updateFlag]").append("&_bid=239").append("&adtag=mvip.gongneng.android.gxsuit").append("&_wv=5123");
    PERSONALITY_QQ_SUIT_URL = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants
 * JD-Core Version:    0.7.0.1
 */