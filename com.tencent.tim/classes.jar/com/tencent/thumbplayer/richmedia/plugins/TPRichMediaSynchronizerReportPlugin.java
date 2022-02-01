package com.tencent.thumbplayer.richmedia.plugins;

import android.os.SystemClock;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.common.report.ITPReportProperties;
import com.tencent.thumbplayer.common.report.TPBeaconReportWrapper;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPProperties;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TPRichMediaSynchronizerReportPlugin
  implements ITPPluginBase
{
  private static final String REPORT_EVENT_RICH_MEDIA_FEATURE_DATA_CALLBACK = "rich_media_feature_data_callback";
  private static final String REPORT_EVENT_RICH_MEDIA_FEATURE_SELECT = "rich_media_feature_select";
  private static final String REPORT_EVENT_RICH_MEDIA_PREPARE = "rich_media_prepare";
  private static final String REPORT_KEY_APP_PLATFORM = "appplatform";
  private static final String REPORT_KEY_CODE = "code";
  private static final String REPORT_KEY_DURATION = "duration";
  private static final String REPORT_KEY_FEATURE_TYPE = "featuretype";
  private static final String REPORT_KEY_FLOW_ID = "flowid";
  private static final String REPORT_KEY_GUID = "guid";
  private static final String REPORT_KEY_NETWORK = "network";
  private static final String REPORT_KEY_POSITION = "position";
  private static final String REPORT_KEY_SEQ = "seq";
  private static final String REPORT_KEY_URL = "url";
  private static final int SUCCESS = 0;
  private Map<Integer, TPCallbackDataParam> mCallbackDataParams = new HashMap();
  private int mCallbackDataSeq = 0;
  private int mCurrentPositionMs = -1;
  private TPRichMediaFeature[] mFeatures;
  private String mFlowId;
  TPReadWriteLock mLock = new TPReadWriteLock();
  private long mPrepareStartTimeMs = 0L;
  private List<TPSelectFeatureParam> mSelectFeatureParams = new ArrayList();
  private int mSelectSeq = 0;
  private String mUrl;
  
  private void addCommonProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("url", this.mUrl);
    paramITPReportProperties.put("flowid", this.mFlowId);
    paramITPReportProperties.put("guid", TPPlayerConfig.getGuid());
    paramITPReportProperties.put("appplatform", TPPlayerConfig.getPlatform());
    paramITPReportProperties.put("network", TPNetworkChangeMonitor.getDetailNetSubType());
  }
  
  private void allFeatureDataCallbackDone(int paramInt)
  {
    if (this.mFeatures != null)
    {
      paramInt = 0;
      while (paramInt < this.mFeatures.length)
      {
        featureDataCallbackDone(paramInt, 0);
        paramInt += 1;
      }
    }
  }
  
  private void allFeatureSelectDone(int paramInt)
  {
    if (this.mFeatures != null)
    {
      paramInt = 0;
      while (paramInt < this.mFeatures.length)
      {
        featureSelectDone(paramInt, 0);
        paramInt += 1;
      }
    }
  }
  
  private void clearResource()
  {
    this.mFeatures = null;
    this.mSelectSeq = 0;
    this.mCallbackDataSeq = 0;
    this.mPrepareStartTimeMs = 0L;
    this.mSelectFeatureParams.clear();
    this.mCallbackDataParams.clear();
  }
  
  private void featureDataCallbackDone(int paramInt1, int paramInt2)
  {
    if (!this.mCallbackDataParams.containsKey(Integer.valueOf(paramInt1))) {
      return;
    }
    String str = getFeatureType(paramInt1);
    reportFeatureDataCallback((TPCallbackDataParam)this.mCallbackDataParams.get(Integer.valueOf(paramInt1)), str, paramInt2);
    this.mCallbackDataParams.remove(Integer.valueOf(paramInt1));
  }
  
  private void featureSelectDone(int paramInt1, int paramInt2)
  {
    String str = getFeatureType(paramInt1);
    Iterator localIterator = this.mSelectFeatureParams.iterator();
    while (localIterator.hasNext())
    {
      TPSelectFeatureParam localTPSelectFeatureParam = (TPSelectFeatureParam)localIterator.next();
      if (localTPSelectFeatureParam.featureIndex == paramInt1)
      {
        reportFeatureSelect(localTPSelectFeatureParam, str, paramInt2);
        localIterator.remove();
      }
    }
  }
  
  private void finishReport(int paramInt)
  {
    reportRichMediaPrepared(paramInt);
    allFeatureSelectDone(paramInt);
    allFeatureDataCallbackDone(paramInt);
  }
  
  private void finishReportAndClearResource(int paramInt)
  {
    finishReport(paramInt);
    clearResource();
  }
  
  private String getFeatureType(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.mFeatures != null)
    {
      str1 = str2;
      if (paramInt >= 0)
      {
        str1 = str2;
        if (paramInt < this.mFeatures.length) {
          str1 = this.mFeatures[paramInt].getFeatureType();
        }
      }
    }
    return str1;
  }
  
  private void onDeselectDone(int paramInt)
  {
    featureDataCallbackDone(paramInt, 0);
  }
  
  private void onError(int paramInt)
  {
    finishReportAndClearResource(paramInt);
  }
  
  private void onFeatureFailure(int paramInt1, int paramInt2)
  {
    featureSelectDone(paramInt1, paramInt2);
    featureDataCallbackDone(paramInt1, paramInt2);
  }
  
  private void onPrepared(Object paramObject)
  {
    if ((paramObject instanceof TPRichMediaFeature[])) {
      this.mFeatures = ((TPRichMediaFeature[])paramObject);
    }
    reportRichMediaPrepared(0);
  }
  
  private void onRelease()
  {
    finishReportAndClearResource(0);
  }
  
  private void onReset()
  {
    finishReportAndClearResource(0);
  }
  
  private void onSelectDone(int paramInt)
  {
    featureSelectDone(paramInt, 0);
    if (this.mCallbackDataParams.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    this.mCallbackDataSeq += 1;
    TPCallbackDataParam localTPCallbackDataParam = new TPCallbackDataParam(null);
    localTPCallbackDataParam.seq = this.mCallbackDataSeq;
    localTPCallbackDataParam.startTimeMs = SystemClock.elapsedRealtime();
    this.mCallbackDataParams.put(Integer.valueOf(paramInt), localTPCallbackDataParam);
  }
  
  private void onSetUrl(String paramString)
  {
    this.mFlowId = (UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform());
    this.mUrl = paramString;
  }
  
  private void onStartDeselect(int paramInt)
  {
    featureSelectDone(paramInt, 0);
  }
  
  private void onStartPrepare()
  {
    this.mPrepareStartTimeMs = SystemClock.elapsedRealtime();
  }
  
  private void onStartSelect(int paramInt)
  {
    this.mSelectSeq += 1;
    TPSelectFeatureParam localTPSelectFeatureParam = new TPSelectFeatureParam(null);
    localTPSelectFeatureParam.featureIndex = paramInt;
    localTPSelectFeatureParam.seq = this.mSelectSeq;
    localTPSelectFeatureParam.startTimeMs = SystemClock.elapsedRealtime();
    this.mSelectFeatureParams.add(localTPSelectFeatureParam);
  }
  
  private void onUpdatePosition(int paramInt)
  {
    this.mCurrentPositionMs = paramInt;
  }
  
  private void reportEvent(String paramString, ITPReportProperties paramITPReportProperties)
  {
    addCommonProperties(paramITPReportProperties);
    TPBeaconReportWrapper.trackCustomKVEvent(paramString, paramITPReportProperties);
  }
  
  private void reportFeatureDataCallback(TPCallbackDataParam paramTPCallbackDataParam, String paramString, int paramInt)
  {
    TPProperties localTPProperties = new TPProperties();
    localTPProperties.put("duration", SystemClock.elapsedRealtime() - paramTPCallbackDataParam.startTimeMs);
    localTPProperties.put("code", paramInt);
    localTPProperties.put("seq", paramTPCallbackDataParam.seq);
    localTPProperties.put("featuretype", paramString);
    localTPProperties.put("position", this.mCurrentPositionMs);
    reportEvent("rich_media_feature_data_callback", localTPProperties);
  }
  
  private void reportFeatureSelect(TPSelectFeatureParam paramTPSelectFeatureParam, String paramString, int paramInt)
  {
    TPProperties localTPProperties = new TPProperties();
    localTPProperties.put("duration", SystemClock.elapsedRealtime() - paramTPSelectFeatureParam.startTimeMs);
    localTPProperties.put("code", paramInt);
    localTPProperties.put("seq", paramTPSelectFeatureParam.seq);
    localTPProperties.put("featuretype", paramString);
    localTPProperties.put("position", this.mCurrentPositionMs);
    reportEvent("rich_media_feature_select", localTPProperties);
  }
  
  private void reportRichMediaPrepared(int paramInt)
  {
    if (this.mPrepareStartTimeMs <= 0L) {
      return;
    }
    TPProperties localTPProperties = new TPProperties();
    localTPProperties.put("duration", SystemClock.elapsedRealtime() - this.mPrepareStartTimeMs);
    localTPProperties.put("code", paramInt);
    reportEvent("rich_media_prepare", localTPProperties);
    this.mPrepareStartTimeMs = 0L;
  }
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mLock.writeLock().lock();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.mLock.writeLock().unlock();
      return;
      onStartPrepare();
      continue;
      onPrepared(paramObject);
      continue;
      onStartSelect(paramInt2);
      continue;
      onSelectDone(paramInt2);
      continue;
      onStartDeselect(paramInt2);
      continue;
      onDeselectDone(paramInt2);
      continue;
      onReset();
      continue;
      onRelease();
      continue;
      onError(paramInt2);
      continue;
      onSetUrl(paramString);
      continue;
      onFeatureFailure(paramInt2, paramInt3);
      continue;
      onUpdatePosition(paramInt2);
    }
  }
  
  static class TPCallbackDataParam
  {
    public int seq;
    public long startTimeMs;
  }
  
  static class TPSelectFeatureParam
  {
    public int featureIndex;
    public int seq;
    public long startTimeMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.plugins.TPRichMediaSynchronizerReportPlugin
 * JD-Core Version:    0.7.0.1
 */