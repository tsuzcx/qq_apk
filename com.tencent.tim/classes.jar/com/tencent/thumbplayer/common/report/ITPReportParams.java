package com.tencent.thumbplayer.common.report;

import org.json.JSONObject;

public abstract interface ITPReportParams
{
  public abstract void paramsToJson(JSONObject paramJSONObject);
  
  public abstract void paramsToProperties(ITPReportProperties paramITPReportProperties);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.common.report.ITPReportParams
 * JD-Core Version:    0.7.0.1
 */