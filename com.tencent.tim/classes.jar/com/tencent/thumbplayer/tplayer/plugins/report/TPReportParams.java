package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.common.report.ITPReportParams;
import com.tencent.thumbplayer.common.report.ITPReportProperties;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams
{
  public static final int BUFFERING_REASON_BITRATE_JITTER = 1400109;
  public static final int BUFFERING_REASON_CDN_TIMEOUT = 1400103;
  public static final int BUFFERING_REASON_CDN_TIMEOUT_BUT_CONNECTED = 1400104;
  public static final int BUFFERING_REASON_DOWNLOAD_SHORT_TIME = 1400111;
  public static final int BUFFERING_REASON_DOWNLOAD_TASK = 1400101;
  public static final int BUFFERING_REASON_NETWORK_DEVICE_EXCEPTION = 1400102;
  public static final int BUFFERING_REASON_NETWORK_UNSTABLE = 1400100;
  public static final int BUFFERING_REASON_P2P_FASTER_THAN_HTTP = 1400110;
  public static final int BUFFERING_REASON_P2P_UPLOAD = 1400112;
  public static final int BUFFERING_REASON_RECEIVE_TIMEOUT = 1400105;
  public static final int BUFFERING_REASON_RECEIVE_TIMEOUT_BUT_CONNECTED = 1400106;
  public static final int BUFFERING_REASON_SLOWLY_SPEED = 1400107;
  public static final int BUFFERING_REASON_SLOWLY_SPEED_BUT_CONNECTED = 1400108;
  public static final String ERROR_CODE_NO_ERROR = "0";
  public static final String JSON_KEY_VAL = "val";
  public static final int LIVE_STEP_FAILED = 150;
  public static final int LIVE_STEP_LOADING_SUCC = 205;
  public static final int LIVE_STEP_PLAY = 263;
  public static final int NETWORK_TYPE_2G = 2;
  public static final int NETWORK_TYPE_3G = 3;
  public static final int NETWORK_TYPE_4G = 4;
  public static final int NETWORK_TYPE_5G = 5;
  public static final int NETWORK_TYPE_ETHERNET = 10;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  public static final int PLAYER_STEP_BUFFERING = 35;
  public static final int PLAYER_STEP_FIRST_LOAD = 30;
  public static final int PLAYER_STEP_FIRST_RENDERING = 32;
  public static final int PLAYER_STEP_GET_CDN_URL = 15;
  public static final int PLAYER_STEP_INIT_PLAYER = 5;
  public static final int PLAYER_STEP_LOAD_SUBTITLE = 33;
  public static final int PLAYER_STEP_PLAY_DONE = 50;
  public static final int PLAYER_STEP_REDIRECT = 34;
  public static final int PLAYER_STEP_USER_SEEK = 40;
  public static final int PLAYER_TYPE_SYSTEM_PLAYER = 0;
  public static final int PLAYER_TYPE_THUMB_PLAYER = 1;
  public static final int PLAY_END_REASON_APP_EXIT = 2;
  public static final int PLAY_END_REASON_EOS = 0;
  public static final int PLAY_END_REASON_PLAYER_ERROR = 3;
  public static final int PLAY_END_REASON_USER_STOP = 1;
  public static final int PLAY_EVENT_NONE = 0;
  public static final int PLAY_EVENT_PAUSE_BY_DEVICE = 2;
  public static final int PLAY_EVENT_SCREEN_SHOT = 3;
  public static final int PLAY_EVENT_SEEK = 1;
  public static final int PLAY_SCENE_NORMAL_PLAY = 1;
  public static final int PLAY_SCENE_TRICK_PLAY = 2;
  public static final int PLAY_TYPE_LIVE = 1;
  public static final int PLAY_TYPE_UNKNOWN = -1;
  public static final int PLAY_TYPE_VOD = 0;
  public static final String PROP_KEY_DATA = "data";
  private static final String TAG = "TPReportParams";
  public static final int VIDEO_DL_TYPE_HLS = 3;
  public static final int VIDEO_DL_TYPE_MP4 = 1;
  private BufferingTotalParams bufferingTotalParams = new BufferingTotalParams();
  private CommonParams commonParams = new CommonParams();
  private FirstLoadParams firstLoadParams = new FirstLoadParams();
  private FirstRenderParams firstRenderParams = new FirstRenderParams();
  private GetCdnUrlParams getCdnParams = new GetCdnUrlParams();
  private PlayerInitParams initParams = new PlayerInitParams();
  private LiveExParam liveExParam = new LiveExParam();
  private LoadSubtitleParams loadSubtitleParams = new LoadSubtitleParams();
  private PlayDoneParams playDoneParams = new PlayDoneParams();
  private RedirectParams redirectParams = new RedirectParams();
  private UserSeekTotalParams userSeekTotalParams = new UserSeekTotalParams();
  private VodExParam vodExParam = new VodExParam();
  
  public TPReportParams()
  {
    this.commonParams.reset();
    this.initParams.reset();
    this.getCdnParams.reset();
    this.firstLoadParams.reset();
    this.firstRenderParams.reset();
    this.loadSubtitleParams.reset();
    this.redirectParams.reset();
    this.bufferingTotalParams.reset();
    this.userSeekTotalParams.reset();
    this.playDoneParams.reset();
  }
  
  public BufferingOnceParams createBufferingOnceParams()
  {
    return new BufferingOnceParams();
  }
  
  public UserSeekOnceParams createUserSeekOnceParams()
  {
    return new UserSeekOnceParams();
  }
  
  public BufferingTotalParams getBufferingTotalParams()
  {
    return this.bufferingTotalParams;
  }
  
  public CommonParams getCommonParams()
  {
    return this.commonParams;
  }
  
  public FirstLoadParams getFirstLoadParams()
  {
    return this.firstLoadParams;
  }
  
  public FirstRenderParams getFirstRenderParams()
  {
    return this.firstRenderParams;
  }
  
  public GetCdnUrlParams getGetCdnParams()
  {
    return this.getCdnParams;
  }
  
  public PlayerInitParams getInitParams()
  {
    return this.initParams;
  }
  
  public LiveExParam getLiveExParam()
  {
    return this.liveExParam;
  }
  
  public LoadSubtitleParams getLoadSubtitleParams()
  {
    return this.loadSubtitleParams;
  }
  
  public PlayDoneParams getPlayDoneParams()
  {
    return this.playDoneParams;
  }
  
  public RedirectParams getRedirectParams()
  {
    return this.redirectParams;
  }
  
  public UserSeekTotalParams getUserSeekTotalParams()
  {
    return this.userSeekTotalParams;
  }
  
  public VodExParam getVodExParam()
  {
    return this.vodExParam;
  }
  
  public void resetAllParam()
  {
    this.commonParams.reset();
    this.firstLoadParams.reset();
    this.firstRenderParams.reset();
    this.loadSubtitleParams.reset();
    this.getCdnParams.reset();
    this.redirectParams.reset();
    this.bufferingTotalParams.reset();
    this.userSeekTotalParams.reset();
    this.playDoneParams.reset();
    this.liveExParam.reset();
    this.vodExParam.reset();
  }
  
  public class BufferingOnceParams
    implements ITPReportParams
  {
    public long bufferingPresentTimeLong;
    public long endTimeUnix;
    public String errCodeString;
    public int formatInt;
    public int lastEventInt;
    public int reasonInt;
    public int sceneInt;
    public long starTimeUnix;
    public String urlString;
    
    public BufferingOnceParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("scene", this.sceneInt);
        paramJSONObject.put("levent", this.lastEventInt);
        paramJSONObject.put("reason", this.reasonInt);
        paramJSONObject.put("format", this.formatInt);
        paramJSONObject.put("ptime", this.bufferingPresentTimeLong);
        paramJSONObject.put("stime", this.starTimeUnix);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("url", this.urlString);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("scene", this.sceneInt);
      paramITPReportProperties.put("levent", this.lastEventInt);
      paramITPReportProperties.put("reason", this.reasonInt);
      paramITPReportProperties.put("format", this.formatInt);
      paramITPReportProperties.put("ptime", this.bufferingPresentTimeLong);
      paramITPReportProperties.put("stime", this.starTimeUnix);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("url", this.urlString);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.sceneInt = 1;
      this.lastEventInt = 0;
      this.reasonInt = 1400100;
    }
  }
  
  public class BufferingTotalParams
    implements ITPReportParams
  {
    public int bufferingCountInt;
    public int bufferingDurationInt;
    public List<TPReportParams.BufferingOnceParams> bufferingOnceParamsList = new LinkedList();
    
    public BufferingTotalParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("bcount", this.bufferingCountInt);
        paramJSONObject.put("tduration", this.bufferingDurationInt);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.bufferingOnceParamsList.iterator();
        while (localIterator.hasNext())
        {
          TPReportParams.BufferingOnceParams localBufferingOnceParams = (TPReportParams.BufferingOnceParams)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localBufferingOnceParams.paramsToJson(localJSONObject);
          localJSONArray.put(localJSONObject);
        }
        paramJSONObject.put("val", localJSONArray);
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
        return;
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("bcount", this.bufferingCountInt);
      paramITPReportProperties.put("tduration", this.bufferingDurationInt);
    }
    
    public void reset()
    {
      this.bufferingCountInt = 0;
      this.bufferingDurationInt = 0;
      this.bufferingOnceParamsList.clear();
    }
  }
  
  public class CommonParams
    implements ITPReportParams
  {
    public String appVersionString;
    public int cdnIdInt;
    public String cdnIpString;
    public String cdnUipString;
    public String deviceNameString;
    public String deviceResolutionString;
    public int downloadTypeInt;
    public String flowIdString;
    public String guidString;
    public int loginTypeInt;
    public float mediaDurationFloat;
    public int mediaFormatInt;
    public int mediaRateInt;
    public String mediaResolutionString;
    public int networkSpeedInt;
    public int networkTypeInt;
    public int onlineInt;
    public String osVersionString;
    public int p2pInt;
    public String p2pVersionString;
    public long platformLong;
    public String playNoString;
    public int playTypeInt;
    public int playerTypeInt;
    public String playerVersionString;
    public String proto;
    public String protover;
    public String qqOpenIdString;
    public int scenesId;
    public int seqInt = 0;
    public int signalStrengthInt;
    public int stepInt;
    public int testIdInt;
    public String uinString;
    public String uipString;
    public String vidString;
    public String wxOpenIdString;
    
    public CommonParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject) {}
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("step", this.stepInt);
      paramITPReportProperties.put("seq", this.seqInt);
      paramITPReportProperties.put("platform", this.platformLong);
      paramITPReportProperties.put("flowid", this.flowIdString);
      paramITPReportProperties.put("playno", this.playNoString);
      paramITPReportProperties.put("uin", this.uinString);
      paramITPReportProperties.put("QQopenid", this.qqOpenIdString);
      paramITPReportProperties.put("WXopenid", this.wxOpenIdString);
      paramITPReportProperties.put("logintype", this.loginTypeInt);
      paramITPReportProperties.put("guid", this.guidString);
      paramITPReportProperties.put("uip", this.uipString);
      paramITPReportProperties.put("cdnuip", this.cdnUipString);
      paramITPReportProperties.put("cdnip", this.cdnIpString);
      paramITPReportProperties.put("online", this.onlineInt);
      paramITPReportProperties.put("p2p", this.p2pInt);
      paramITPReportProperties.put("sstrength", this.signalStrengthInt);
      paramITPReportProperties.put("network", this.networkTypeInt);
      paramITPReportProperties.put("speed", this.networkSpeedInt);
      paramITPReportProperties.put("device", this.deviceNameString);
      paramITPReportProperties.put("resolution", this.deviceResolutionString);
      paramITPReportProperties.put("testid", this.testIdInt);
      paramITPReportProperties.put("osver", this.osVersionString);
      paramITPReportProperties.put("p2pver", this.p2pVersionString);
      paramITPReportProperties.put("appver", this.appVersionString);
      paramITPReportProperties.put("playerver", this.playerVersionString);
      paramITPReportProperties.put("playertype", this.playerTypeInt);
      paramITPReportProperties.put("cdnid", this.cdnIdInt);
      paramITPReportProperties.put("scenesid", this.scenesId);
      paramITPReportProperties.put("playtype", this.playTypeInt);
      paramITPReportProperties.put("dltype", this.downloadTypeInt);
      paramITPReportProperties.put("vid", this.vidString);
      paramITPReportProperties.put("definition", this.mediaResolutionString);
      paramITPReportProperties.put("fmt", this.mediaFormatInt);
      paramITPReportProperties.put("rate", this.mediaRateInt);
      paramITPReportProperties.put("duration", this.mediaDurationFloat);
      paramITPReportProperties.put("proto", this.proto);
      paramITPReportProperties.put("protover", this.protover);
    }
    
    public void reset()
    {
      this.stepInt = 0;
      this.seqInt = 0;
      this.platformLong = 0L;
      this.flowIdString = "";
      this.playNoString = "";
      this.uinString = "";
      this.qqOpenIdString = "";
      this.wxOpenIdString = "";
      this.loginTypeInt = 0;
      this.guidString = "";
      this.uipString = "";
      this.cdnUipString = "";
      this.cdnIpString = "";
      this.onlineInt = 0;
      this.p2pInt = 0;
      this.signalStrengthInt = 0;
      this.networkTypeInt = 0;
      this.networkSpeedInt = 0;
      this.deviceNameString = "";
      this.deviceResolutionString = "";
      this.testIdInt = 0;
      this.osVersionString = "";
      this.p2pVersionString = "";
      this.appVersionString = "";
      this.playerVersionString = "";
      this.playerTypeInt = 0;
      this.cdnIdInt = 0;
      this.scenesId = 0;
      this.downloadTypeInt = 0;
      this.vidString = "";
      this.mediaResolutionString = "";
      this.mediaFormatInt = 0;
      this.mediaRateInt = 0;
      this.mediaDurationFloat = 0.0F;
      this.proto = "";
      this.protover = "";
    }
  }
  
  public class FirstLoadParams
    implements ITPReportParams
  {
    public String cdnUrlString;
    public int cgiUrlIndex;
    public long endTimeUnix;
    public String errCodeString;
    public long firstOpenTimeUnix;
    public long firstPacketReadTimeUnix;
    public long starTimeUnix;
    
    public FirstLoadParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("stime", this.starTimeUnix);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("fileopenedtime", this.firstOpenTimeUnix);
        paramJSONObject.put("firstpacketreadtime", this.firstPacketReadTimeUnix);
        paramJSONObject.put("url", this.cdnUrlString);
        paramJSONObject.put("urlindex", this.cgiUrlIndex);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("stime", this.starTimeUnix);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("fileopenedtime", this.firstOpenTimeUnix);
      paramITPReportProperties.put("firstpacketreadtime", this.firstPacketReadTimeUnix);
      paramITPReportProperties.put("url", this.cdnUrlString);
      paramITPReportProperties.put("urlindex", this.cgiUrlIndex);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.starTimeUnix = 0L;
      this.firstOpenTimeUnix = 0L;
      this.firstPacketReadTimeUnix = 0L;
      this.endTimeUnix = 0L;
      this.cdnUrlString = "";
      this.cgiUrlIndex = 0;
      this.errCodeString = "0";
    }
  }
  
  public class FirstRenderParams
    implements ITPReportParams
  {
    public long endTimeUnix;
    public String errCodeString;
    public long starTimeUnix;
    
    public FirstRenderParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("stime", this.starTimeUnix);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("stime", this.starTimeUnix);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.starTimeUnix = 0L;
      this.endTimeUnix = 0L;
      this.errCodeString = "0";
    }
  }
  
  public class GetCdnUrlParams
    implements ITPReportParams
  {
    public long endTimeUnix;
    public String errCodeString;
    public String proxyIpString;
    public long starTimeUnix;
    
    public GetCdnUrlParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("stime", this.starTimeUnix);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("ip", this.proxyIpString);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("stime", this.starTimeUnix);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("ip", this.proxyIpString);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.starTimeUnix = 0L;
      this.endTimeUnix = 0L;
      this.proxyIpString = "";
      this.errCodeString = "0";
    }
  }
  
  public class LiveExParam
    implements ITPReportParams
  {
    int adPlayLengthInt;
    int blockCountInt;
    int blockTimeInt;
    String cdnServerString;
    int connectTimeInt;
    int contentIdInt;
    String defSwitchString;
    int deviceTypeInt;
    int downSpeedInt;
    String downloadServerIpString;
    String downloadUrl;
    int errCodeInt;
    String extraInfoString;
    int freeTypeInt;
    String fullErrCodeString;
    int getStreamDurationInt;
    int getSyncFrameDurationInt;
    int getUrlTimeInt;
    int isLookBackInt;
    int isStreamP2PInt;
    int isUseP2PInt;
    int isUserPayInt;
    int liveDelayInt;
    int liveProgramIdInt;
    int liveTagInt;
    int liveTypeInt;
    long loadingTimeLong;
    int maxSpeedInt;
    int networkTypeInt;
    int playTimeInt;
    String playerVersionString;
    int prePlayLengthInt;
    int reconnectCntInt;
    long reportTimeLong;
    String spanId;
    int streamIdInt;
    int testSpeedInt;
    String tuid;
    String userIpString;
    String userQQString;
    
    public LiveExParam() {}
    
    public void paramsToJson(JSONObject paramJSONObject) {}
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("ftime", this.reportTimeLong);
      paramITPReportProperties.put("sip", this.userIpString);
      paramITPReportProperties.put("iqq", this.userQQString);
      paramITPReportProperties.put("prdlength", this.prePlayLengthInt);
      paramITPReportProperties.put("playad", this.adPlayLengthInt);
      paramITPReportProperties.put("fplayerver", this.playerVersionString);
      paramITPReportProperties.put("dsip", this.downloadServerIpString);
      paramITPReportProperties.put("devtype", this.deviceTypeInt);
      paramITPReportProperties.put("nettype", this.networkTypeInt);
      paramITPReportProperties.put("freetype", this.freeTypeInt);
      paramITPReportProperties.put("use_p2p", this.isUseP2PInt);
      paramITPReportProperties.put("p2p_play", this.isStreamP2PInt);
      paramITPReportProperties.put("livepid", this.liveProgramIdInt);
      paramITPReportProperties.put("sid", this.streamIdInt);
      paramITPReportProperties.put("contentid", this.contentIdInt);
      paramITPReportProperties.put("playtime", this.playTimeInt);
      paramITPReportProperties.put("isuserpay", this.isUserPayInt);
      paramITPReportProperties.put("switch", this.defSwitchString);
      paramITPReportProperties.put("live_type", this.liveTypeInt);
      paramITPReportProperties.put("xserverip", this.cdnServerString);
      paramITPReportProperties.put("durl", this.downloadUrl);
      paramITPReportProperties.put("lookback", this.isLookBackInt);
      paramITPReportProperties.put("live_delay", this.liveDelayInt);
      paramITPReportProperties.put("live_tag", this.liveTagInt);
      paramITPReportProperties.put("extraInfo", this.extraInfoString);
      paramITPReportProperties.put("cnntime", this.connectTimeInt);
      paramITPReportProperties.put("maxspeed", this.maxSpeedInt);
      paramITPReportProperties.put("testspeed", this.testSpeedInt);
      paramITPReportProperties.put("downspeed", this.downSpeedInt);
      paramITPReportProperties.put("recnncount", this.reconnectCntInt);
      paramITPReportProperties.put("loadingtime", this.loadingTimeLong);
      paramITPReportProperties.put("blocktime", this.blockTimeInt);
      paramITPReportProperties.put("blockcount", this.blockCountInt);
      paramITPReportProperties.put("errorcode", this.errCodeInt);
      paramITPReportProperties.put("geturltime", this.getUrlTimeInt);
      paramITPReportProperties.put("fullecode", this.fullErrCodeString);
      paramITPReportProperties.put("get_stream_data_duration", this.getStreamDurationInt);
      paramITPReportProperties.put("get_sync_frame_duration", this.getSyncFrameDurationInt);
      paramITPReportProperties.put("spanId", this.spanId);
      paramITPReportProperties.put("tuid", this.tuid);
    }
    
    public void reset() {}
  }
  
  public class LoadSubtitleParams
    implements ITPReportParams
  {
    public int bufferingDurationInt;
    public int cdnTypeInt;
    public int cgiUrlIndex;
    public long endTimeUnix;
    public String errCodeString;
    public long starTimeUnix;
    public String subtitleUrlString;
    
    public LoadSubtitleParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("stime", this.starTimeUnix);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("bufferduration", this.bufferingDurationInt);
        paramJSONObject.put("url", this.subtitleUrlString);
        paramJSONObject.put("vt", this.cdnTypeInt);
        paramJSONObject.put("urlindex", this.cgiUrlIndex);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("stime", this.starTimeUnix);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("bufferduration", this.bufferingDurationInt);
      paramITPReportProperties.put("url", this.subtitleUrlString);
      paramITPReportProperties.put("vt", this.cdnTypeInt);
      paramITPReportProperties.put("urlindex", this.cgiUrlIndex);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.starTimeUnix = 0L;
      this.endTimeUnix = 0L;
      this.bufferingDurationInt = 0;
      this.subtitleUrlString = "";
      this.cdnTypeInt = 0;
      this.cgiUrlIndex = 0;
      this.errCodeString = "0";
    }
  }
  
  public class PlayDoneParams
    implements ITPReportParams
  {
    public long endTimeUnix;
    public String errCodeString;
    public float playDurationFloat;
    public int reasonInt;
    
    public PlayDoneParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("reason", this.reasonInt);
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("playduration", this.playDurationFloat);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("reason", this.reasonInt);
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("playduration", this.playDurationFloat);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.reasonInt = 0;
      this.endTimeUnix = 0L;
      this.playDurationFloat = 0.0F;
      this.errCodeString = "0";
    }
  }
  
  public class PlayerInitParams
    implements ITPReportParams
  {
    public String errCodeString;
    public long playEndTimeUnix;
    public long playStarTimeUnix;
    
    public PlayerInitParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("stime", this.playStarTimeUnix);
        paramJSONObject.put("etime", this.playEndTimeUnix);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("stime", this.playStarTimeUnix);
      paramITPReportProperties.put("etime", this.playEndTimeUnix);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.playStarTimeUnix = 0L;
      this.playEndTimeUnix = 0L;
      this.errCodeString = "0";
    }
  }
  
  public class RedirectParams
    implements ITPReportParams
  {
    public int cdnTypeInt;
    public long endTimeUnix;
    public String errCodeString;
    public int redirectCountInt;
    public String redirectedUrlString;
    public long starTimeUnix;
    
    public RedirectParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("etime", this.endTimeUnix);
        paramJSONObject.put("url", this.redirectedUrlString);
        paramJSONObject.put("vt", this.cdnTypeInt);
        paramJSONObject.put("t302", this.redirectCountInt);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("etime", this.endTimeUnix);
      paramITPReportProperties.put("url", this.redirectedUrlString);
      paramITPReportProperties.put("vt", this.cdnTypeInt);
      paramITPReportProperties.put("t302", this.redirectCountInt);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.starTimeUnix = 0L;
      this.endTimeUnix = 0L;
      this.redirectedUrlString = "";
      this.cdnTypeInt = 0;
      this.redirectCountInt = 0;
      this.errCodeString = "0";
    }
  }
  
  public class UserSeekOnceParams
    implements ITPReportParams
  {
    public long endPresentTimeLong;
    public String errCodeString;
    public int formatInt;
    public long seekEndTimeUnix;
    public long seekStartTimeUnix;
    public long startPresentTimeLong;
    
    public UserSeekOnceParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("format", this.formatInt);
        paramJSONObject.put("pstime", this.startPresentTimeLong);
        paramJSONObject.put("petime", this.endPresentTimeLong);
        paramJSONObject.put("lstime", this.seekStartTimeUnix);
        paramJSONObject.put("letime", this.seekEndTimeUnix);
        paramJSONObject.put("code", this.errCodeString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("format", this.formatInt);
      paramITPReportProperties.put("pstime", this.startPresentTimeLong);
      paramITPReportProperties.put("petime", this.endPresentTimeLong);
      paramITPReportProperties.put("lstime", this.seekStartTimeUnix);
      paramITPReportProperties.put("letime", this.seekEndTimeUnix);
      paramITPReportProperties.put("code", this.errCodeString);
    }
    
    public void reset()
    {
      this.startPresentTimeLong = 0L;
      this.endPresentTimeLong = 0L;
      this.seekStartTimeUnix = 0L;
      this.seekEndTimeUnix = 0L;
      this.errCodeString = "0";
    }
  }
  
  public class UserSeekTotalParams
    implements ITPReportParams
  {
    public int seekBufferingCountInt;
    public int seekBufferingDurationInt;
    public List<TPReportParams.UserSeekOnceParams> seekOnceParamsList = new LinkedList();
    public int seekTotalCountInt;
    
    public UserSeekTotalParams() {}
    
    public void paramsToJson(JSONObject paramJSONObject)
    {
      try
      {
        paramJSONObject.put("scount", this.seekTotalCountInt);
        paramJSONObject.put("tbcount", this.seekBufferingCountInt);
        paramJSONObject.put("tbduration", this.seekBufferingDurationInt);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.seekOnceParamsList.iterator();
        while (localIterator.hasNext())
        {
          TPReportParams.UserSeekOnceParams localUserSeekOnceParams = (TPReportParams.UserSeekOnceParams)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localUserSeekOnceParams.paramsToJson(localJSONObject);
          localJSONArray.put(localJSONObject);
        }
        paramJSONObject.put("val", localJSONArray);
      }
      catch (JSONException paramJSONObject)
      {
        TPLogUtil.e("TPReportParams", paramJSONObject);
        return;
      }
    }
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("scount", this.seekTotalCountInt);
      paramITPReportProperties.put("tbcount", this.seekBufferingCountInt);
      paramITPReportProperties.put("tbduration", this.seekBufferingDurationInt);
    }
    
    public void reset()
    {
      this.seekTotalCountInt = 0;
      this.seekBufferingCountInt = 0;
      this.seekBufferingDurationInt = 0;
      this.seekOnceParamsList.clear();
    }
  }
  
  public class VodExParam
    implements ITPReportParams
  {
    int bizIdInt;
    int clipInt;
    int currentPlayInt;
    int freeTypeInt;
    int hasSubtitleInt;
    int hevcLcInt;
    int hitDownloaded;
    int isSelectedSubtitleInt;
    int multiTrackInt;
    int optimizedPlayInt;
    int statusInt;
    
    public VodExParam() {}
    
    public void paramsToJson(JSONObject paramJSONObject) {}
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("freetype", this.freeTypeInt);
      paramITPReportProperties.put("currentplay", this.currentPlayInt);
      paramITPReportProperties.put("optimizedplay", this.optimizedPlayInt);
      paramITPReportProperties.put("subtitles", this.hasSubtitleInt);
      paramITPReportProperties.put("selsubtitles", this.isSelectedSubtitleInt);
      paramITPReportProperties.put("multitrack", this.multiTrackInt);
      paramITPReportProperties.put("bizid", this.bizIdInt);
      paramITPReportProperties.put("hevclv", this.hevcLcInt);
      paramITPReportProperties.put("clip", this.clipInt);
      paramITPReportProperties.put("status", this.statusInt);
      paramITPReportProperties.put("hitdownloaded", this.hitDownloaded);
    }
    
    public void reset() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams
 * JD-Core Version:    0.7.0.1
 */