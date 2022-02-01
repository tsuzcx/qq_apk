package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTBaseEventMapHandler
  extends DTAbstractEventMapHandler
{
  public void formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    formatPublicParams(paramMap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
 * JD-Core Version:    0.7.0.1
 */