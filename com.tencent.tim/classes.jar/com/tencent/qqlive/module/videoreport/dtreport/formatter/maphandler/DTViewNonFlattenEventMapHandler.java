package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.List;
import java.util.Map;

class DTViewNonFlattenEventMapHandler
  extends DTBaseViewEventMapHandler
{
  protected String getElementId(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("element_path");
    if (((paramMap instanceof List)) && (!((List)paramMap).isEmpty()))
    {
      paramMap = ((List)paramMap).get(0);
      if (paramMap == null) {
        return null;
      }
      return paramMap.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTViewNonFlattenEventMapHandler
 * JD-Core Version:    0.7.0.1
 */