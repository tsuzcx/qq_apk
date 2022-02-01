package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.MathUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SPPredownloadEvent
{
  private static final String TAG = "SPPredownloadEvent";
  private long fileSize;
  private long httpDownloadSize;
  private long httpRepeatedSize;
  private List<Integer> httpSpeed = new ArrayList();
  public boolean isSuccess = true;
  private Set<Integer> mPcdnStopReason = new HashSet();
  private long p2pDownloadSize;
  private long p2pRepeatedSize;
  private List<Integer> p2pSpeed = new ArrayList();
  private int pcdnDownloadFailCount;
  private long pcdnDownloadSize;
  private int pcdnDownloadSuccessCount;
  private int pcdnErrorCount;
  private int pcdnErrorSize;
  private long pcdnRepeatedSize;
  private int pcdnRequestCount;
  private long pcdnRequestSize;
  private List<Integer> pcdnSpeed = new ArrayList();
  public boolean reported = false;
  private int sceneId;
  private long totalDownloadedSize;
  private String url;
  private String vid;
  private int videoSource;
  
  public SPPredownloadEvent(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt)
  {
    this.videoSource = paramSuperPlayerVideoInfo.getVideoSource();
    this.vid = paramSuperPlayerVideoInfo.getVid();
    this.url = paramSuperPlayerVideoInfo.getPlayUrl();
    this.sceneId = paramInt;
  }
  
  public Map<String, String> getDataMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("param_videoSource", String.valueOf(this.videoSource));
    localLinkedHashMap.put("param_vid", this.vid);
    localLinkedHashMap.put("param_url", this.url);
    localLinkedHashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
    localLinkedHashMap.put("param_appId", String.valueOf(SuperPlayerSDKMgr.getPlatform()));
    localLinkedHashMap.put("param_sdkVersion", String.valueOf(SuperPlayerSDKMgr.getSDKVersion()));
    localLinkedHashMap.put("param_sceneId", String.valueOf(this.sceneId));
    localLinkedHashMap.put("param_success", String.valueOf(this.isSuccess));
    localLinkedHashMap.put("param_fileSize", String.valueOf(this.fileSize));
    localLinkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.totalDownloadedSize));
    localLinkedHashMap.put("param_httpDownloadSize", String.valueOf(this.httpDownloadSize));
    localLinkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.httpRepeatedSize));
    localLinkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.pcdnDownloadSize));
    localLinkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.pcdnRepeatedSize));
    localLinkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.p2pDownloadSize));
    localLinkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.p2pRepeatedSize));
    localLinkedHashMap.put("param_pcdnRequestSize", String.valueOf(this.pcdnRequestSize));
    localLinkedHashMap.put("param_pcdnRequestCount", String.valueOf(this.pcdnRequestCount));
    localLinkedHashMap.put("param_pcdnDownloadFailCount", String.valueOf(this.pcdnDownloadFailCount));
    localLinkedHashMap.put("param_pcdnDownloadSuccessCount", String.valueOf(this.pcdnDownloadSuccessCount));
    localLinkedHashMap.put("param_avgHttpSpeed", String.valueOf(MathUtils.avgIntList(this.httpSpeed)));
    localLinkedHashMap.put("param_avgPcdnSpeed", String.valueOf(MathUtils.avgIntList(this.pcdnSpeed)));
    localLinkedHashMap.put("param_avgP2PSpeed", String.valueOf(MathUtils.avgIntList(this.p2pSpeed)));
    localLinkedHashMap.put("param_pcdnErrorCount", String.valueOf(this.pcdnErrorCount));
    localLinkedHashMap.put("param_pcdnErrorSize", String.valueOf(this.pcdnErrorSize));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mPcdnStopReason.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Integer)localIterator.next()).append(",");
    }
    localLinkedHashMap.put("param_pcdnStopReason", localStringBuilder.toString());
    long l = System.currentTimeMillis() / 1000L;
    localLinkedHashMap.put("param_timeStamp", String.valueOf(l));
    localLinkedHashMap.put("param_timeStamp_5min", String.valueOf(l + 300L - l % 300L));
    return localLinkedHashMap;
  }
  
  public String getEventName()
  {
    return "actSPPredownload";
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if ((paramInt == 251) && ((paramObject instanceof String))) {
      onPcdnDownloadFailed((String)paramObject);
    }
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
          break label90;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.pcdnErrorCount += 1;
          this.pcdnErrorSize += j;
        }
        return;
        label90:
        i = 0;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.reported) {}
    for (;;)
    {
      return;
      this.fileSize = Math.max(paramLong2, this.fileSize);
      this.totalDownloadedSize = Math.max(paramLong1, this.totalDownloadedSize);
      try
      {
        paramString = new JSONObject(paramString);
        this.httpDownloadSize = Math.max(paramString.optLong("HttpDownloadSize"), this.httpDownloadSize);
        this.httpRepeatedSize = Math.max(paramString.optLong("HttpRepeatedSize"), this.httpRepeatedSize);
        this.pcdnDownloadSize = Math.max(paramString.optLong("PcdnDownloadSize"), this.pcdnDownloadSize);
        this.pcdnRepeatedSize = Math.max(paramString.optLong("PcdnRepeatedSize"), this.pcdnRepeatedSize);
        this.p2pDownloadSize = Math.max(paramString.optLong("P2PDownloadSize"), this.p2pDownloadSize);
        this.p2pRepeatedSize = Math.max(paramString.optLong("P2PRepeatedSize"), this.p2pRepeatedSize);
        this.pcdnRequestSize = Math.max(paramString.optLong("pcdnRequestSize"), this.pcdnRequestSize);
        this.pcdnRequestCount = Math.max(paramString.optInt("pcdnRequestCount"), this.pcdnRequestCount);
        this.pcdnDownloadFailCount = Math.max(paramString.optInt("pcdnDownloadFailCount"), this.pcdnDownloadFailCount);
        this.pcdnDownloadSuccessCount = Math.max(paramString.optInt("pcdnDownloadSuccessCount"), this.pcdnDownloadSuccessCount);
        paramInt1 = paramString.optInt("lastHttpSpeed");
        if (paramInt1 > 0) {
          this.httpSpeed.add(Integer.valueOf(paramInt1));
        }
        paramInt1 = paramString.optInt("lastPcdnSpeed");
        if (paramInt1 > 0) {
          this.pcdnSpeed.add(Integer.valueOf(paramInt1));
        }
        paramInt1 = paramString.optInt("lastP2PSpeed");
        if (paramInt1 > 0)
        {
          this.p2pSpeed.add(Integer.valueOf(paramInt1));
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void report()
  {
    if (!this.reported) {
      SPBeaconReporter.report(getEventName(), getDataMap());
    }
    this.reported = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPPredownloadEvent
 * JD-Core Version:    0.7.0.1
 */