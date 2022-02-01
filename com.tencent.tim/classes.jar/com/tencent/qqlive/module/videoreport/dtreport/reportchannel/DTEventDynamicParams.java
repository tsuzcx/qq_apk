package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper;
import java.util.HashMap;
import java.util.Map;

public class DTEventDynamicParams
  implements IEventDynamicParams
{
  private IDTParamProvider mDtParamProvider;
  private final Map<String, Object> mEventParams = new HashMap();
  private final ThreadLocal<Map<String, Object>> mNonRealTimeParams = new DTEventDynamicParams.1(this);
  private final Map<String, Object> mRealTimeParams = new HashMap();
  
  private void addDTParams(Map<String, Object> paramMap)
  {
    if ((this.mDtParamProvider == null) || (paramMap == null)) {
      return;
    }
    paramMap.putAll(DTCommonParams.getCommParams(this.mDtParamProvider));
  }
  
  private void checkParams(@NonNull Map<String, Object> paramMap)
  {
    VerifyDataHelper.checkMap(paramMap);
  }
  
  public static DTEventDynamicParams getInstance()
  {
    return InstanceHolder.sInstance;
  }
  
  IDTParamProvider getDTParamProvider()
  {
    return this.mDtParamProvider;
  }
  
  public void setDTCommonParams(@NonNull IDTParamProvider paramIDTParamProvider)
  {
    this.mDtParamProvider = paramIDTParamProvider;
  }
  
  public void setEventDynamicParams(String paramString, Map<String, Object> paramMap)
  {
    this.mEventParams.clear();
    this.mDtParamProvider.setEventDynamicParams(paramString, this.mEventParams);
    checkParams(this.mEventParams);
    if (paramMap != null) {
      paramMap.putAll(this.mEventParams);
    }
    this.mEventParams.clear();
  }
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    Map localMap = (Map)this.mNonRealTimeParams.get();
    localMap.clear();
    this.mDtParamProvider.setNonRealtimePublicDynamicParams(localMap);
    checkParams(localMap);
    if (paramMap != null) {
      paramMap.putAll(localMap);
    }
    addDTParams(paramMap);
    localMap.clear();
  }
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    this.mRealTimeParams.clear();
    this.mDtParamProvider.setRealtimePublicDynamicParams(this.mRealTimeParams);
    checkParams(this.mRealTimeParams);
    if (paramMap != null) {
      paramMap.putAll(this.mRealTimeParams);
    }
    this.mRealTimeParams.clear();
  }
  
  static class InstanceHolder
  {
    private static DTEventDynamicParams sInstance = new DTEventDynamicParams(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams
 * JD-Core Version:    0.7.0.1
 */