package com.tencent.mobileqq.mini.appbrand.jsapi;

import acfp;
import java.util.HashMap;

public class PluginConst
{
  public static class AdConst
  {
    public static final HashMap<Integer, String> CodeMsgMap = new PluginConst.AdConst.1();
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
    public static final String ERROR_MSG_BANNED;
    public static final String ERROR_MSG_CLOSED;
    public static final String ERROR_MSG_INNER_ERROR;
    public static final String ERROR_MSG_INVALID_ADUNITID;
    public static final String ERROR_MSG_INVALID_POSITION;
    public static final String ERROR_MSG_IN_REVIEW;
    public static final String ERROR_MSG_NO_AD;
    public static final String ERROR_MSG_PARAM_ERROR;
    public static final String ERROR_MSG_REJECTED;
    public static final String ERROR_MSG_SERVICE_FAIL = acfp.m(2131709739);
    public static final int KErrAdDeleted = -100100002;
    public static final int KErrAdGdtNoData = -100100008;
    public static final int KErrAdNotFound = -100100007;
    public static final int KErrAdPositionExtIsNil = -100100005;
    public static final int KErrAdPositionIsNil = -100100004;
    public static final int KErrAdShutdown = -100100001;
    public static final int KErrAdStatusUnkown = -100100003;
    public static final int KErrAppNotFound = -100100006;
    
    static
    {
      ERROR_MSG_PARAM_ERROR = acfp.m(2131709745);
      ERROR_MSG_INVALID_ADUNITID = acfp.m(2131709743);
      ERROR_MSG_INNER_ERROR = acfp.m(2131709746);
      ERROR_MSG_NO_AD = acfp.m(2131709742);
      ERROR_MSG_IN_REVIEW = acfp.m(2131709740);
      ERROR_MSG_REJECTED = acfp.m(2131709741);
      ERROR_MSG_BANNED = acfp.m(2131709744);
      ERROR_MSG_CLOSED = acfp.m(2131709738);
      ERROR_MSG_INVALID_POSITION = acfp.m(2131695898);
    }
    
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
  
  public class AudioJsPluginConst
  {
    public static final String API_OPERATE_RECORDER = "operateRecorder";
    public static final String API_PAUSE_VOICE = "pauseVoice";
    public static final String API_PLAY_VOICE = "playVoice";
    public static final String API_START_RECORD = "startRecord";
    public static final String API_STOP_RECORD = "stopRecord";
    public static final String API_STOP_VOICE = "stopVoice";
    
    public AudioJsPluginConst() {}
  }
  
  public class DataJsPluginConst
  {
    public static final String API_AUTHORIZE = "authorize";
    public static final String API_GET_GROUP_INFO = "getGroupInfo";
    public static final String API_GET_GROUP_INFO_EXTRA = "getGroupInfoExtra";
    public static final String API_GET_NATIVE_USER_INFO = "getNativeUserInfo";
    public static final String API_GET_NATIVE_WERUN_DATA = "getNativeWeRunData";
    public static final String API_GET_PHONE_NUMBER = "getPhoneNumber";
    public static final String API_GET_USERINFO_OPENDATA = "getOpenDataUserInfo";
    public static final String API_INVOKE_GROUP_JS = "invokeGroupJSApi";
    public static final String API_MAKE_PHONE_CALL = "makePhoneCall";
    public static final String API_OPEN_WERUN_SETTING = "openWeRunSetting";
    public static final String API_OPERATE_WXDATA = "operateWXData";
    public static final String API_REPORT_SUBMIT_FORM = "reportSubmitForm";
    public static final String PRIVATE_API_GET_NATIVE_USER_INFO_EXTRA = "getUserInfoExtra";
    
    public DataJsPluginConst() {}
  }
  
  public class ImageJsPluginConst
  {
    public static final String API_CHOOSE_IMAGE = "chooseImage";
    public static final String API_COMPRESS_IMAGE = "compressImage";
    public static final String API_GET_IMAGE_INFO = "getImageInfo";
    public static final String API_PREVIEW_IMAGE = "previewImage";
    public static final String API_SAVE_IMAGE_TO_ALBUM = "saveImageToPhotosAlbum";
    
    public ImageJsPluginConst() {}
  }
  
  public class InputJsPluginConst
  {
    public static final String EVENT_HIDE_KEYBOARD = "hideKeyboard";
    public static final String EVENT_SET_KEYBOARD_VALUE = "setKeyboardValue";
    public static final String EVENT_SHOW_KEYBOARD = "showKeyboard";
    
    public InputJsPluginConst() {}
  }
  
  public class InternalJsPluginConst
  {
    public static final String API_LAUNCH_APP = "launchApplication";
    public static final String API_OPEN_URL = "openUrl";
    
    public InternalJsPluginConst() {}
  }
  
  public class MapJsPluginConst
  {
    public static final String API_CHOOSE_LOCATION = "chooseLocation";
    public static final String API_GET_LOCATION = "getLocation";
    public static final String API_OPEN_LOCATION = "openLocation";
    
    public MapJsPluginConst() {}
  }
  
  public class MapViewPluginConst
  {
    public static final String EVENT_ADD_MAP_CIRCLES = "addMapCircles";
    public static final String EVENT_ADD_MAP_CONTROLS = "addMapControls";
    public static final String EVENT_ADD_MAP_LINE = "addMapLines";
    public static final String EVENT_ADD_MAP_MARKERS = "addMapMarkers";
    public static final String EVENT_ADD_MAP_POLYGONS = "addMapPolygons";
    public static final String EVENT_GET_MAPCENTER_LOCATION = "getMapCenterLocation";
    public static final String EVENT_GET_MAP_REGION = "getMapRegion";
    public static final String EVENT_GET_MAP_ROTATE = "getMapRotate";
    public static final String EVENT_GET_MAP_SCALE = "getMapScale";
    public static final String EVENT_GET_MAP_SKEW = "getMapSkew";
    public static final String EVENT_INCLUDE_MAP_POINT = "includeMapPoints";
    public static final String EVENT_INSERT_MAP = "insertMap";
    public static final String EVENT_MOVE_TO_MAP_LOCATION = "moveToMapLocation";
    public static final String EVENT_REMOVE_MAP = "removeMap";
    public static final String EVENT_REMOVE_MAP_MARKERS = "removeMapMarkers";
    public static final String EVENT_TRANSLATE_MAP_MARKER = "translateMapMarker";
    public static final String EVENT_UPDATE_MAP = "updateMap";
    public static final String EVENT_UPDATE_MAP_COVERS = "updateMapCovers";
    
    public MapViewPluginConst() {}
  }
  
  public class MediaJsPluginConst
  {
    public static final String EVENT_OPERATE_CAMERA = "operateCamera";
    public static final String EVENT_REMOVE_CAMERA = "removeCamera";
    public static final String EVENT_UPDATE_CAMERA = "updateCamera";
    
    public MediaJsPluginConst() {}
  }
  
  public class NetworkJsPluginConst
  {
    public static final String API_GET_NETWORK_TYPE = "getNetworkType";
    public static final String EVENT_NETWORK_STATE_CHANGE = "onNetworkStatusChange";
    
    public NetworkJsPluginConst() {}
  }
  
  public class OtherJsPluginConst
  {
    public static final String API_ADD_COLOR_SIGN = "addColorSign";
    public static final String API_ADD_COLOR_SIGN_DIRECTLY = "addColorSignDirectly";
    public static final String API_GET_SETTING = "getSetting";
    public static final String API_IS_COLOR_SIGN_EXIST = "isColorSignExistSync";
    public static final String API_OPEN_ADDRESS = "openAddress";
    public static final String API_OPEN_SETTING = "openSetting";
    public static final String API_SCAN_CODE = "scanCode";
    
    public OtherJsPluginConst() {}
  }
  
  public class OuterJsPluginConst
  {
    public static final String API_AD_CREATE_REWARDED_VIDEO_AD = "createRewardedVideoAd";
    public static final String API_AD_OPERATE_REWARDED_VIDEO_AD = "operateRewardedAd";
    public static final String API_CHOOSE_INVOICE_TITLE = "chooseInvoiceTitle";
    
    public OuterJsPluginConst() {}
  }
  
  public class PayJsPluginConst
  {
    public static final String API_CHECK_H5_PAY_STATUS = "checkH5PayStatus";
    public static final String API_CONSUME_STAR_CURRENTY = "consumeStarCurrency";
    public static final String API_PAY_BY_H5 = "requestMidasPaymentByH5";
    public static final String API_RECHARGE_AND_CONSUME = "rechargeAndConsumeStarCurrency";
    public static final String API_RECHARGE_STAR_CURRENCY = "rechargeStarCurrency";
    public static final String API_REQUEST_MIDAS_GOODS_PAY = "requestMidasGoodsPay";
    public static final String API_REQUEST_MIDAS_MONTH_CARD_PAY = "requestMidasMonthCardPay";
    public static final String API_REQUEST_MIDAS_PAYMENT = "requestMidasPayment";
    public static final String API_REQUEST_PAYMENT = "requestPayment";
    public static final String API_REQUEST_STAR_CURRENCY = "queryStarCurrency";
    
    public PayJsPluginConst() {}
  }
  
  public class QQFriendsJsPluginConst
  {
    public static final String API_ADD_FRIEND = "addFriend";
    
    public QQFriendsJsPluginConst() {}
  }
  
  public class SchemeJsPluginConst
  {
    public static final String API_OPEN_SCHEME = "openScheme";
    public static final String API_PERSONALIZE = "Personalize";
    
    public SchemeJsPluginConst() {}
  }
  
  public class SubscribeJsPluginConst
  {
    public static final String API_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
    public static final String API_SUBSCRIBE_ONCE_APP_MSG = "subscribeOnceAppMsg";
    
    public SubscribeJsPluginConst() {}
  }
  
  public class UIJsPluginConst
  {
    public static final String EVENT_INSERT_CAMERA = "insertCamera";
    public static final String EVENT_INSERT_HTML_WEBVIEW = "insertHTMLWebView";
    public static final String EVENT_REMOVE_HTML_WEBVIEW = "removeHTMLWebView";
    public static final String EVENT_UPDATE_HTML_WEBVIEW = "updateHTMLWebView";
    public static final String EVENT_WEBVIEW_INVOKE_APPSERVICE = "onWebInvokeAppService";
    
    public UIJsPluginConst() {}
  }
  
  public class VideoJsPluginConst
  {
    public static final String API_CHOOSE_VIDEO = "chooseVideo";
    public static final String API_SAVE_VIDEO_TO_ALBUM = "saveVideoToPhotosAlbum";
    
    public VideoJsPluginConst() {}
  }
  
  public class VoIPPluginConst
  {
    public static final String API_JOIN_IP_CHAT = "joinVoIPChat";
    
    public VoIPPluginConst() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst
 * JD-Core Version:    0.7.0.1
 */