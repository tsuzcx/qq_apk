package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.text.TextUtils;
import java.util.Map;

abstract class DTBaseViewEventMapHandler
  extends DTBaseEventMapHandler
{
  public void formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatEvent(paramString, paramMap1, paramMap2);
    if ((isValidMap(paramMap2)) && (paramMap2.containsKey("cur_pg")) && (isValidMap(paramMap2.get("cur_pg")))) {
      formatPage(paramMap1, (Map)paramMap2.get("cur_pg"));
    }
    String str = getElementId(paramMap2);
    if (!TextUtils.isEmpty(str)) {
      paramMap1.put("dt_eid", str);
    }
    if ("imp_end".equals(paramString)) {
      if (!isValidMap(paramMap2)) {
        break label120;
      }
    }
    label120:
    for (paramString = paramMap2.get("element_lvtm");; paramString = null)
    {
      paramMap1.put("dt_element_lvtm", paramString);
      return;
    }
  }
  
  protected abstract String getElementId(Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseViewEventMapHandler
 * JD-Core Version:    0.7.0.1
 */