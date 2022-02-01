package com.tencent.superplayer.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.DisplayUtil;
import com.tencent.superplayer.utils.HDRUtil;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.MathUtils;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SPReportHelper
  implements ISPReporter
{
  private static final int MAX_HEASER_SET_SIZE = 30;
  public static final String SEPARATOR = ";";
  private static final String TAG = "SPReportHelper";
  private Map<String, Object> mConfigMap = new HashMap();
  private SPReportEvent mEvent;
  private boolean mHasReported = false;
  private boolean mHasStartSeek = false;
  private boolean mHasStop = false;
  private Set<String> mHeaderResTypeSet = new HashSet();
  private Set<String> mHeaderUUIDSet = new HashSet();
  private List<Integer> mHttpSpeed = new ArrayList();
  private boolean mIsPrePlay = false;
  private long mLastPlayPosition = 0L;
  private List<Integer> mP2pSpeed = new ArrayList();
  private List<Integer> mPcdnSpeed = new ArrayList();
  private Set<Integer> mPcdnStopReason = new HashSet();
  private SuperPlayerMgr mPlayer;
  private boolean mPrePlayViewShowCalled = false;
  private boolean mPrepared = false;
  private long mStartBufferTime = 0L;
  private long mStartPrepareTime = 0L;
  private long mVisibleStartPrepareTime = 0L;
  
  private String appendBySeparator(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1 + paramString3 + paramString2;
  }
  
  private void checkAndWarning()
  {
    if ((this.mIsPrePlay) && (!this.mPrePlayViewShowCalled)) {
      LogUtil.w("SPReportHelper", "Player is prePlay, but prePlayViewShow not called.");
    }
  }
  
  private void doBeforeReport()
  {
    float f2 = 0.0F;
    parseConfigMapToJson();
    this.mEvent.stopPosition = this.mPlayer.getCurrentPositionMs();
    float f1 = (float)this.mEvent.duration / 1000.0F;
    if (f1 != 0.0F) {
      this.mEvent.bitrate = ((float)this.mEvent.fileSize / 1024.0F * 8.0F / f1);
    }
    this.mEvent.avgHttpSpeed = MathUtils.avgIntList(this.mHttpSpeed);
    this.mEvent.avgPcdnSpeed = MathUtils.avgIntList(this.mPcdnSpeed);
    this.mEvent.avgP2PSpeed = MathUtils.avgIntList(this.mP2pSpeed);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.mPcdnStopReason.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((Integer)localIterator.next()).append(",");
    }
    this.mEvent.pcdnStopReason = ((StringBuilder)localObject).toString();
    long l;
    if (this.mEvent.prePlay == 0)
    {
      this.mEvent.prepareDuration = this.mEvent.realPrepareDuration;
      this.mEvent.renderDuration = this.mEvent.realRenderDuration;
      this.mEvent.totalBufferDuration = (this.mEvent.realPrepareDuration + this.mEvent.secondBufferDuration);
      this.mEvent.totalBufferCount = (this.mEvent.secondBufferCount + 1);
      localObject = this.mEvent;
      ((SPReportEvent)localObject).playDuration += this.mEvent.stopPosition - this.mLastPlayPosition;
      l = this.mPlayer.getDurationMs();
      localObject = this.mEvent;
      if (l == 0L) {
        break label481;
      }
    }
    label481:
    for (f1 = this.mEvent.seekDuration * 1.0F / (float)l;; f1 = 0.0F)
    {
      ((SPReportEvent)localObject).seekPercent = f1;
      localObject = this.mEvent;
      f1 = f2;
      if (l != 0L) {
        f1 = (float)this.mEvent.seekStartTime * 1.0F / (float)l;
      }
      ((SPReportEvent)localObject).seekStartPercent = f1;
      this.mEvent.headerUUID = CommonUtil.convertSetToString(this.mHeaderUUIDSet);
      this.mEvent.headerResType = CommonUtil.convertSetToString(this.mHeaderResTypeSet);
      checkAndWarning();
      return;
      if (this.mEvent.prePlay == 2)
      {
        l = this.mVisibleStartPrepareTime - this.mStartPrepareTime;
        this.mEvent.prepareDuration = (this.mEvent.realPrepareDuration - l);
        this.mEvent.renderDuration = (this.mEvent.realRenderDuration - l);
        if (l >= 0L) {
          break;
        }
        LogUtil.e("SPReportHelper", "doBeforeReport prePlayOffsetDuration error, for prePlayOffsetDuration < 0");
        break;
      }
      if (this.mEvent.prePlay != 1) {
        break;
      }
      this.mEvent.prepareDuration = 0L;
      this.mEvent.renderDuration = 0L;
      break;
    }
  }
  
  private void initComplexData()
  {
    this.mEvent.hardwareLevel = HardwareUtil.judgeDeviceLevel(SuperPlayerSDKMgr.getContext());
    this.mEvent.deviceInfoJson = HardwareUtil.getDeviceInfoJson();
    this.mEvent.screenWidth = DisplayUtil.getScreenWidth();
    this.mEvent.screenHeight = DisplayUtil.getScreenHeight();
    this.mEvent.hdrSupport = HDRUtil.getHDRSupportListStr();
  }
  
  private void parseConfigMapToJson()
  {
    JSONObject localJSONObject = new JSONObject(this.mConfigMap);
    this.mEvent.configExt = localJSONObject.toString();
  }
  
  public void addConfigExt(String paramString, Object paramObject)
  {
    this.mConfigMap.put(paramString, paramObject);
  }
  
  public void addExtReportData(String paramString1, String paramString2)
  {
    this.mEvent.extReportData.put(paramString1, paramString2);
  }
  
  public void addExtReportData(Map<String, String> paramMap)
  {
    this.mEvent.extReportData.putAll(paramMap);
  }
  
  public void init(SuperPlayerMgr paramSuperPlayerMgr, int paramInt)
  {
    this.mPlayer = paramSuperPlayerMgr;
    this.mEvent = new SPReportEvent();
    this.mEvent.appId = SuperPlayerSDKMgr.getPlatform();
    this.mEvent.sceneId = paramInt;
    this.mEvent.sdkVersion = SuperPlayerSDKMgr.getSDKVersion();
    if ((SuperPlayerSDKMgr.getSdkOption() != null) && (SuperPlayerSDKMgr.getSdkOption().isAsyncInit))
    {
      ThreadUtil.runOnThreadPool(new SPReportHelper.1(this));
      return;
    }
    initComplexData();
  }
  
  public void onCodecReuseInfo(TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null) {}
    do
    {
      do
      {
        return;
      } while (paramTPMediaCodecInfo.mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO);
      if (paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY)
      {
        paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
        this.mEvent.videoCodecJson = paramTPMediaCodecInfo;
        try
        {
          paramTPMediaCodecInfo = new JSONObject(paramTPMediaCodecInfo);
          this.mEvent.videoCodecEnable = paramTPMediaCodecInfo.optBoolean("reuseEnable");
          this.mEvent.videoCodecReused = paramTPMediaCodecInfo.optBoolean("isReuse");
          this.mEvent.videoTotalCodecDuration = paramTPMediaCodecInfo.optInt("totalCodec");
          return;
        }
        catch (Throwable paramTPMediaCodecInfo)
        {
          LogUtil.e("SPReportHelper", "onCodecReuseInfo error:" + paramTPMediaCodecInfo.getMessage());
          return;
        }
      }
    } while (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION);
    LogUtil.e("SPReportHelper", "codec error:" + paramTPMediaCodecInfo.msg);
    try
    {
      String str = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      this.mEvent.codecErrorCodeList = appendBySeparator(this.mEvent.codecErrorCodeList, str, ";");
      this.mEvent.codecErrorMsgList = appendBySeparator(this.mEvent.codecErrorMsgList, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e("SPReportHelper", "onCodecReuseInfo error for jsonObject:" + paramTPMediaCodecInfo.msg);
    }
  }
  
  public void onDownloadProgressUpdate(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    if (paramTPDownLoadProgressInfo != null)
    {
      this.mEvent.fileSize = Math.max(paramTPDownLoadProgressInfo.totalFileSize, this.mEvent.fileSize);
      this.mEvent.totalDownloadedSize = Math.max(paramTPDownLoadProgressInfo.currentDownloadSize, this.mEvent.totalDownloadedSize);
    }
    try
    {
      paramTPDownLoadProgressInfo = new JSONObject(paramTPDownLoadProgressInfo.extraInfo);
      this.mEvent.httpDownloadSize = Math.max(paramTPDownLoadProgressInfo.optLong("HttpDownloadSize"), this.mEvent.httpDownloadSize);
      this.mEvent.httpRepeatedSize = Math.max(paramTPDownLoadProgressInfo.optLong("HttpRepeatedSize"), this.mEvent.httpRepeatedSize);
      this.mEvent.pcdnDownloadSize = Math.max(paramTPDownLoadProgressInfo.optLong("PcdnDownloadSize"), this.mEvent.pcdnDownloadSize);
      this.mEvent.pcdnRepeatedSize = Math.max(paramTPDownLoadProgressInfo.optLong("PcdnRepeatedSize"), this.mEvent.pcdnRepeatedSize);
      this.mEvent.p2pDownloadSize = Math.max(paramTPDownLoadProgressInfo.optLong("P2PDownloadSize"), this.mEvent.p2pDownloadSize);
      this.mEvent.p2pRepeatedSize = Math.max(paramTPDownLoadProgressInfo.optLong("P2PRepeatedSize"), this.mEvent.p2pRepeatedSize);
      this.mEvent.pcdnRequestSize = Math.max(paramTPDownLoadProgressInfo.optLong("pcdnRequestSize"), this.mEvent.pcdnRequestSize);
      this.mEvent.pcdnRequestCount = Math.max(paramTPDownLoadProgressInfo.optInt("pcdnRequestCount"), this.mEvent.pcdnRequestCount);
      this.mEvent.pcdnDownloadFailCount = Math.max(paramTPDownLoadProgressInfo.optInt("pcdnDownloadFailCount"), this.mEvent.pcdnDownloadFailCount);
      this.mEvent.pcdnDownloadSuccessCount = Math.max(paramTPDownLoadProgressInfo.optInt("pcdnDownloadSuccessCount"), this.mEvent.pcdnDownloadSuccessCount);
      int i = paramTPDownLoadProgressInfo.optInt("lastHttpSpeed");
      if (i > 0) {
        this.mHttpSpeed.add(Integer.valueOf(i));
      }
      i = paramTPDownLoadProgressInfo.optInt("lastPcdnSpeed");
      if (i > 0) {
        this.mPcdnSpeed.add(Integer.valueOf(i));
      }
      i = paramTPDownLoadProgressInfo.optInt("lastP2PSpeed");
      if (i > 0) {
        this.mP2pSpeed.add(Integer.valueOf(i));
      }
      return;
    }
    catch (JSONException paramTPDownLoadProgressInfo)
    {
      paramTPDownLoadProgressInfo.printStackTrace();
    }
  }
  
  public void onError(String paramString1, String paramString2)
  {
    this.mEvent.errCode = paramString1;
    this.mEvent.errDetailInfo = paramString2;
    long l = this.mPlayer.getCurrentPositionMs();
    paramString1 = this.mEvent;
    if (l > 0L) {}
    for (;;)
    {
      paramString1.stopPosition = l;
      this.mEvent.success = false;
      return;
      l = this.mEvent.stopPosition;
    }
  }
  
  public void onFirstVideoFrameRendered()
  {
    if ((this.mEvent.realRenderDuration == 0L) && (this.mStartPrepareTime != 0L)) {
      this.mEvent.realRenderDuration = (SystemClock.uptimeMillis() - this.mStartPrepareTime);
    }
  }
  
  public void onOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    this.mHasReported = false;
    this.mHasStop = false;
    if (paramSuperPlayerOption != null)
    {
      addExtReportData(paramSuperPlayerOption.toReportMap());
      this.mIsPrePlay = paramSuperPlayerOption.isPrePlay;
      this.mEvent.quicEnableMode = paramSuperPlayerOption.superPlayerDownOption.quicEnableMode;
      this.mEvent.isEnableQuicPlaintext = paramSuperPlayerOption.superPlayerDownOption.enableQuicPlaintext;
      this.mEvent.isEnableQuicConnectionMigration = paramSuperPlayerOption.superPlayerDownOption.enableQuicConnectionMigration;
      this.mEvent.quicCongestionType = paramSuperPlayerOption.superPlayerDownOption.quicCongestionType;
    }
    this.mEvent.videoSource = paramSuperPlayerVideoInfo.getVideoSource();
    this.mEvent.vid = paramSuperPlayerVideoInfo.getVid();
    this.mEvent.url = paramSuperPlayerVideoInfo.getPlayUrl();
    this.mEvent.startPosition = paramLong;
    this.mEvent.playDuration = 0L;
    this.mLastPlayPosition = paramLong;
    this.mStartPrepareTime = SystemClock.uptimeMillis();
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("failLength");
      if (j > 0)
      {
        int k = paramString.optInt("stopReason");
        this.mPcdnStopReason.add(Integer.valueOf(k));
        if (paramString.optInt("isError") != 1) {
          break label100;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          paramString = this.mEvent;
          paramString.pcdnErrorCount += 1;
          paramString = this.mEvent;
          paramString.pcdnErrorSize += j;
        }
        return;
        label100:
        i = 0;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onPrePlayViewShow()
  {
    if (!this.mIsPrePlay) {
      return;
    }
    this.mPrePlayViewShowCalled = true;
    if (this.mPrepared) {}
    for (this.mEvent.prePlay = 1;; this.mEvent.prePlay = 2)
    {
      this.mVisibleStartPrepareTime = SystemClock.uptimeMillis();
      return;
    }
  }
  
  public void onPrepared()
  {
    this.mPrepared = true;
    this.mEvent.width = this.mPlayer.getVideoWidth();
    this.mEvent.height = this.mPlayer.getVideoHeight();
    this.mEvent.duration = this.mPlayer.getDurationMs();
    this.mEvent.flowId = this.mPlayer.getFlowId();
    MediaInfo localMediaInfo = this.mPlayer.getMediaInfo();
    if (localMediaInfo != null)
    {
      this.mEvent.videoFormat = localMediaInfo.getContainerFormat();
      this.mEvent.videoCodec = localMediaInfo.getVideoCodec();
      this.mEvent.videoProfile = localMediaInfo.getVideoProfile();
      this.mEvent.codecMimeType = localMediaInfo.getCodecMimeType();
    }
    if ((this.mEvent.realPrepareDuration == 0L) && (this.mStartPrepareTime != 0L)) {
      this.mEvent.realPrepareDuration = (SystemClock.uptimeMillis() - this.mStartPrepareTime);
    }
  }
  
  public void onQuicInfoUpdate(String paramString)
  {
    for (;;)
    {
      try
      {
        LogUtils.d("SPReportHelper", "onQuicInfoUpdate jsonObject:" + paramString);
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("isDownloadByQuic")) {
          this.mEvent.isDownloadByQuic = true;
        }
        if (localJSONObject.has("downloadComplete"))
        {
          localObject = localJSONObject.getString("downloadComplete");
          if (TextUtils.equals((CharSequence)localObject, "quic"))
          {
            localObject = this.mEvent;
            ((SPReportEvent)localObject).quicDownloadCompleteCnt += 1;
          }
        }
        else
        {
          if (localJSONObject.has("downloadFailed"))
          {
            localObject = localJSONObject.getString("downloadFailed");
            if (!TextUtils.equals((CharSequence)localObject, "quic")) {
              break label431;
            }
            localObject = this.mEvent;
            ((SPReportEvent)localObject).quicDownloadFailCnt += 1;
          }
          if (localJSONObject.has("isDownloadByQuicPlaintext"))
          {
            localObject = localJSONObject.getString("isDownloadByQuicPlaintext");
            this.mEvent.isDownloadByQuicPlaintext = TextUtils.equals("true", (CharSequence)localObject);
          }
          if (localJSONObject.has("ServerIP")) {
            this.mEvent.headerServerIP = localJSONObject.optString("ServerIP");
          }
          if (localJSONObject.has("ClientIP")) {
            this.mEvent.headerClientIP = localJSONObject.optString("ClientIP");
          }
          if (localJSONObject.has("CDNIP")) {
            this.mEvent.CDNIP = localJSONObject.optString("CDNIP");
          }
          if ((!TextUtils.isEmpty(localJSONObject.optString("X-NWS-LOG-UUID"))) && (this.mHeaderUUIDSet.size() <= 30))
          {
            String str = localJSONObject.optString("X-NWS-LOG-UUID");
            localObject = str;
            if (str.contains(" ")) {
              localObject = str.substring(0, str.indexOf(" "));
            }
            this.mHeaderUUIDSet.add(localObject);
          }
          if ((TextUtils.isEmpty(localJSONObject.optString("X-CDN-RES-TYPE"))) || (this.mHeaderResTypeSet.size() > 30)) {
            break;
          }
          this.mHeaderResTypeSet.add(localJSONObject.optString("X-CDN-RES-TYPE"));
          return;
        }
        if (!TextUtils.equals((CharSequence)localObject, "http")) {
          continue;
        }
        Object localObject = this.mEvent;
        ((SPReportEvent)localObject).httpDownloadCompleteCnt += 1;
        continue;
        if (!TextUtils.equals(localJSONException, "http")) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtils.e("SPReportHelper", "onQuicInfoUpdate error for jsonObject:" + paramString);
        return;
      }
      label431:
      SPReportEvent localSPReportEvent = this.mEvent;
      localSPReportEvent.httpDownloadFailCnt += 1;
    }
  }
  
  public void onRelease()
  {
    long l;
    SPReportEvent localSPReportEvent;
    if (!this.mHasStop)
    {
      l = this.mPlayer.getCurrentPositionMs();
      localSPReportEvent = this.mEvent;
      if (l <= 0L) {
        break label36;
      }
    }
    for (;;)
    {
      localSPReportEvent.stopPosition = l;
      report();
      return;
      label36:
      l = this.mEvent.stopPosition;
    }
  }
  
  public void onSeek(long paramLong1, long paramLong2)
  {
    SPReportEvent localSPReportEvent = this.mEvent;
    localSPReportEvent.playDuration += paramLong1 - this.mLastPlayPosition;
    this.mEvent.hadSeek = true;
    localSPReportEvent = this.mEvent;
    localSPReportEvent.seekCount += 1;
    localSPReportEvent = this.mEvent;
    localSPReportEvent.seekDuration = ((int)(localSPReportEvent.seekDuration + Math.abs(paramLong2 - paramLong1)));
    if (this.mEvent.seekStartTime == 0L) {
      this.mEvent.seekStartTime = paramLong1;
    }
    this.mHasStartSeek = true;
    this.mLastPlayPosition = paramLong2;
  }
  
  public void onSeekComplete()
  {
    this.mHasStartSeek = false;
  }
  
  public void onStart()
  {
    this.mEvent.hadStart = true;
  }
  
  public void onStop()
  {
    long l = this.mPlayer.getCurrentPositionMs();
    SPReportEvent localSPReportEvent = this.mEvent;
    if (l > 0L) {}
    for (;;)
    {
      localSPReportEvent.stopPosition = l;
      this.mHasStop = true;
      report();
      return;
      l = this.mEvent.stopPosition;
    }
  }
  
  public void onVideoBufferEnd()
  {
    long l;
    SPReportEvent localSPReportEvent;
    if (this.mStartBufferTime != 0L)
    {
      l = SystemClock.uptimeMillis() - this.mStartBufferTime;
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferDuration += l;
    }
    for (;;)
    {
      localSPReportEvent = this.mEvent;
      localSPReportEvent.secondBufferCount += 1;
      this.mStartBufferTime = 0L;
      if (this.mHasStartSeek)
      {
        localSPReportEvent = this.mEvent;
        localSPReportEvent.seekBufferCount += 1;
        localSPReportEvent = this.mEvent;
        localSPReportEvent.seekBufferDuration = ((int)(l + localSPReportEvent.seekBufferDuration));
      }
      return;
      l = 0L;
    }
  }
  
  public void onVideoBufferStart()
  {
    this.mStartBufferTime = SystemClock.uptimeMillis();
  }
  
  public void onVideoFrameCheckResult(int paramInt)
  {
    this.mEvent.videoFrameCheckCode = paramInt;
  }
  
  public void report()
  {
    if (this.mHasReported)
    {
      LogUtil.d("SPReportHelper", "report ignore for has reported.");
      return;
    }
    this.mHasReported = true;
    doBeforeReport();
    Map localMap = this.mEvent.getDataMap();
    SPBeaconReporter.report(this.mEvent.getEventName(), localMap);
    LogUtil.d("SPReportHelper", "report dataMap:" + localMap);
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	com/tencent/superplayer/report/SPReportHelper:mPlayer	Lcom/tencent/superplayer/player/SuperPlayerMgr;
    //   6: invokevirtual 141	com/tencent/superplayer/player/SuperPlayerMgr:getCurrentPositionMs	()J
    //   9: lstore_2
    //   10: aload_0
    //   11: getfield 133	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   14: astore 4
    //   16: lload_2
    //   17: lconst_0
    //   18: lcmp
    //   19: ifle +117 -> 136
    //   22: aload 4
    //   24: lload_2
    //   25: putfield 146	com/tencent/superplayer/report/SPReportEvent:stopPosition	J
    //   28: aload_0
    //   29: invokevirtual 775	com/tencent/superplayer/report/SPReportHelper:report	()V
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 52	com/tencent/superplayer/report/SPReportHelper:mStartPrepareTime	J
    //   37: aload_0
    //   38: lconst_0
    //   39: putfield 56	com/tencent/superplayer/report/SPReportHelper:mStartBufferTime	J
    //   42: aload_0
    //   43: lconst_0
    //   44: putfield 54	com/tencent/superplayer/report/SPReportHelper:mVisibleStartPrepareTime	J
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 60	com/tencent/superplayer/report/SPReportHelper:mIsPrePlay	Z
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 62	com/tencent/superplayer/report/SPReportHelper:mPrepared	Z
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 66	com/tencent/superplayer/report/SPReportHelper:mPrePlayViewShowCalled	Z
    //   62: aload_0
    //   63: getfield 80	com/tencent/superplayer/report/SPReportHelper:mHttpSpeed	Ljava/util/List;
    //   66: invokeinterface 828 1 0
    //   71: aload_0
    //   72: getfield 82	com/tencent/superplayer/report/SPReportHelper:mPcdnSpeed	Ljava/util/List;
    //   75: invokeinterface 828 1 0
    //   80: aload_0
    //   81: getfield 84	com/tencent/superplayer/report/SPReportHelper:mP2pSpeed	Ljava/util/List;
    //   84: invokeinterface 828 1 0
    //   89: aload_0
    //   90: getfield 89	com/tencent/superplayer/report/SPReportHelper:mPcdnStopReason	Ljava/util/Set;
    //   93: invokeinterface 829 1 0
    //   98: aload_0
    //   99: getfield 91	com/tencent/superplayer/report/SPReportHelper:mHeaderUUIDSet	Ljava/util/Set;
    //   102: invokeinterface 829 1 0
    //   107: aload_0
    //   108: getfield 93	com/tencent/superplayer/report/SPReportHelper:mHeaderResTypeSet	Ljava/util/Set;
    //   111: invokeinterface 829 1 0
    //   116: aload_0
    //   117: getfield 133	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   120: getfield 346	com/tencent/superplayer/report/SPReportEvent:sceneId	I
    //   123: istore_1
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 135	com/tencent/superplayer/report/SPReportHelper:mPlayer	Lcom/tencent/superplayer/player/SuperPlayerMgr;
    //   129: iload_1
    //   130: invokevirtual 831	com/tencent/superplayer/report/SPReportHelper:init	(Lcom/tencent/superplayer/player/SuperPlayerMgr;I)V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: aload_0
    //   137: getfield 133	com/tencent/superplayer/report/SPReportHelper:mEvent	Lcom/tencent/superplayer/report/SPReportEvent;
    //   140: getfield 146	com/tencent/superplayer/report/SPReportEvent:stopPosition	J
    //   143: lstore_2
    //   144: goto -122 -> 22
    //   147: astore 4
    //   149: aload_0
    //   150: monitorexit
    //   151: aload 4
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	SPReportHelper
    //   123	7	1	i	int
    //   9	135	2	l	long
    //   14	9	4	localSPReportEvent	SPReportEvent
    //   147	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	147	finally
    //   22	133	147	finally
    //   136	144	147	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportHelper
 * JD-Core Version:    0.7.0.1
 */