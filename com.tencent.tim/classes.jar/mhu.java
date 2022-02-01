import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import java.util.HashMap;

public class mhu
{
  public int IH = 0;
  public boolean Tx;
  public int aSo;
  public int aSp = -1;
  public int aSq;
  public int aSr;
  public int aSs = 0;
  public int aSt;
  public int aSu;
  public int aSv;
  public int aSw = -1;
  public String adD;
  public String adE = "";
  public String ahA = "";
  public String ahB = "";
  public String ahC;
  public String ahD;
  public String ahx;
  public String ahy = "";
  public String ahz = "";
  public boolean aiJ;
  public boolean amD;
  public boolean amE;
  public boolean amF;
  public boolean amG;
  public boolean amH;
  public long bandwidth;
  public int bufferCount;
  public int busiType;
  public String errCode = "";
  public String errDetailInfo = "";
  public int index = -1;
  public boolean isCompleted;
  public float jB;
  public int loopCount;
  public long mFileSize;
  public long playDuration;
  public String rowkey;
  public int secondBufferCount;
  public int skipFramesTotalCount;
  public boolean success;
  public long vA;
  public long vB;
  public long vC;
  public long vD;
  public long vE = -1L;
  public long vF;
  public long vG;
  public long vH;
  public long vI;
  public long vJ = -1L;
  public long vK = -1L;
  public String vid;
  public boolean videoCodecEnable;
  public String videoCodecJson;
  public boolean videoCodecReused;
  public int videoFormat;
  public int videoHeight;
  public String videoReportInfo = "";
  public long videoTotalCodecDuration;
  public int videoWidth;
  public long vs;
  public long vt;
  public long vu;
  public long vv;
  public long vw;
  public long vx;
  public long vy;
  public long vz;
  public Long w;
  
  private String jP()
  {
    if (((this.busiType == 2) || (this.busiType == 6)) && (!TextUtils.isEmpty(this.vid))) {
      return this.adD;
    }
    if ((this.mFileSize == 0L) || (this.vI == 0L)) {
      return "0";
    }
    return String.valueOf(this.mFileSize * 8L / (this.vI * 1024L));
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", kxm.getAccount());
    localHashMap.put("param_articleID", String.valueOf(this.w));
    localHashMap.put("param_vid", this.vid);
    localHashMap.put("param_busiType", String.valueOf(this.busiType));
    localHashMap.put("param_success", String.valueOf(this.success).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.playDuration));
    localHashMap.put("param_prepareDuration", String.valueOf(this.vt));
    localHashMap.put("param_bufferTime", String.valueOf(this.vv));
    localHashMap.put("param_errCode", this.errCode);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jB));
    localHashMap.put("param_bufferCount", String.valueOf(this.bufferCount));
    localHashMap.put("param_sceneType", String.valueOf(this.IH));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.vw));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.vx));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.vy));
    localHashMap.put("param_vid2UrlTime", String.valueOf(this.vz));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.vA));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.vB));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.vC));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.vD));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.secondBufferCount));
    localHashMap.put("param_videoFormat", String.valueOf(this.videoFormat));
    localHashMap.put("param_isHitCache", String.valueOf(this.amD));
    localHashMap.put("param_errDetailInfo", this.errDetailInfo);
    localHashMap.put("param_scrollInterval", String.valueOf(this.vE));
    localHashMap.put("param_jumpFromScene", String.valueOf(this.aSp));
    localHashMap.put("param_index", String.valueOf(this.index));
    localHashMap.put("param_videoBitRate", String.valueOf(this.vF));
    localHashMap.put("param_fileSize", String.valueOf(this.mFileSize));
    localHashMap.put("param_downloadedDuration", String.valueOf(this.vH));
    localHashMap.put("param_width", String.valueOf(this.aSq));
    localHashMap.put("param_height", String.valueOf(this.aSr));
    localHashMap.put("param_totalDuration", String.valueOf(this.vI));
    localHashMap.put("param_videoCodeFormat", String.valueOf(this.aiJ));
    localHashMap.put("param_listSpeedKBS", this.ahx);
    if (this.vG >= 0L) {
      localHashMap.put("param_averageSpeedKBS", String.valueOf(this.vG));
    }
    if (this.vJ >= 0L) {
      localHashMap.put("param_maxSpeedKBS", String.valueOf(this.vJ));
    }
    if (this.vK >= 0L) {
      localHashMap.put("param_minSpeedKBS", String.valueOf(this.vK));
    }
    localHashMap.put("param_fileBitRate", jP());
    if (this.rowkey == null) {}
    for (String str = "";; str = this.rowkey)
    {
      localHashMap.put("param_rowKey", str);
      localHashMap.put("param_preloadStatus", String.valueOf(this.aSs));
      if (this.busiType == 2)
      {
        localHashMap.put("param_skipFramesErrorCount", String.valueOf(this.aSt));
        localHashMap.put("param_device_info", msz.h(false));
      }
      localHashMap.put("param_DeviceOS", String.valueOf(Build.VERSION.SDK_INT));
      if (this.busiType == 2)
      {
        localHashMap.put("param_isHWCodecFailed", String.valueOf(this.amE));
        localHashMap.put("param_isHWCodec", String.valueOf(this.Tx));
        localHashMap.put("param_HWCodecErrorCode", String.valueOf(this.ahy));
      }
      localHashMap.put("param_connectQualityReport", this.ahz);
      localHashMap.put("param_ABRReportInfo", this.videoReportInfo);
      if (this.busiType == 2)
      {
        localHashMap.put("param_videoUrlDomain", this.ahA);
        localHashMap.put("param_ipAddressCnt", String.valueOf(this.aSv));
        localHashMap.put("param_ipAddressList", this.ahB);
        localHashMap.put("param_skipFramesTotalCount", String.valueOf(this.skipFramesTotalCount));
        localHashMap.put("param_skipFramesFinalCount", String.valueOf(this.aSu));
      }
      localHashMap.put("param_version", "3.4.4.3058");
      localHashMap.put("param_subversion", "3.4.4");
      localHashMap.put("param_speedList", this.adE);
      localHashMap.put("param_isChangeHWBackup", String.valueOf(this.amF));
      localHashMap.put("param_continuousPlay", String.valueOf(this.aSw));
      localHashMap.put("param_hasHWBackup", String.valueOf(this.amG));
      localHashMap.put("param_isPreOutputFirstFrame", String.valueOf(this.amH));
      localHashMap.put("param_preparePerformanceJson", this.ahC);
      localHashMap.put("param_prepareOptimizeConfigJson", kxm.iY());
      localHashMap.put("param_httpbuffertime_for_playpreload", String.valueOf(awit.Qj()));
      localHashMap.put("param_dynamic_buffer_switch", String.valueOf(awit.Qk()));
      localHashMap.put("param_dynamic_buffer_config_json", awit.Ha());
      localHashMap.put("param_bandwidth", String.valueOf(this.bandwidth));
      localHashMap.put("param_http_buffer_range_tag", this.ahD);
      localHashMap.put("param_loop_count", String.valueOf(this.loopCount));
      localHashMap.put("param_hardwareLevel", String.valueOf(HardwareUtil.judgeDeviceLevel(BaseApplication.getContext())));
      localHashMap.put("param_deviceInfoJson", HardwareUtil.getDeviceInfoJson());
      localHashMap.put("param_videoCodecEnable", String.valueOf(this.videoCodecEnable));
      localHashMap.put("param_videoCodecReused", String.valueOf(this.videoCodecReused));
      localHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.videoTotalCodecDuration));
      localHashMap.put("param_videoCodecJson", String.valueOf(this.videoCodecJson));
      localHashMap.put("param_isSuperPlayer", String.valueOf(nbs.a.Fg()));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyVideoReportData", 2, "视频性能上报 map = " + localHashMap.toString());
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhu
 * JD-Core Version:    0.7.0.1
 */