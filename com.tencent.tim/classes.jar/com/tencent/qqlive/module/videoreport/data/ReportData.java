package com.tencent.qqlive.module.videoreport.data;

import java.util.Collections;
import java.util.Map;

public class ReportData
{
  private String mId;
  private Map<String, ?> mParams;
  
  public String getId()
  {
    return this.mId;
  }
  
  public Map<String, Object> getParams()
  {
    if (this.mParams == null) {
      return null;
    }
    return Collections.unmodifiableMap(this.mParams);
  }
  
  public void setId(String paramString)
  {
    this.mId = paramString;
  }
  
  public void setParams(Map<String, ?> paramMap)
  {
    this.mParams = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.ReportData
 * JD-Core Version:    0.7.0.1
 */