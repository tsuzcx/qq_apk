package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.v4.util.ArrayMap;
import java.util.Map;

public class FinalData
{
  public String eventKey;
  public Map<String, Object> eventParams = new ArrayMap();
  
  public FinalData() {}
  
  public FinalData(String paramString)
  {
    this.eventKey = paramString;
  }
  
  public Map<String, Object> getEventParams()
  {
    return this.eventParams;
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "";
    }
    this.eventParams.put(paramString, localObject);
  }
  
  public void putAll(Map<String, ?> paramMap)
  {
    if (paramMap != null) {
      this.eventParams.putAll(paramMap);
    }
  }
  
  public void reset()
  {
    this.eventKey = null;
    this.eventParams.clear();
  }
  
  public void setEventKey(String paramString)
  {
    this.eventKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.FinalData
 * JD-Core Version:    0.7.0.1
 */