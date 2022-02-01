package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTPageEventMapHandler
  extends DTBaseEventMapHandler
{
  public void formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatEvent(paramString, paramMap1, paramMap2);
    formatPage(paramMap1, paramMap2);
    if ("pgout".equals(paramString)) {
      formatLvTime(paramMap1, paramMap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTPageEventMapHandler
 * JD-Core Version:    0.7.0.1
 */