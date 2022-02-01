package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.IEventMapHandler;
import com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DTParamsNonFlattenFormatter
  extends DefaultFormatter
{
  private void formatElements(@NonNull List<ReportData> paramList, Map<String, Object> paramMap)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReportData localReportData = (ReportData)paramList.next();
      if (localReportData != null)
      {
        localArrayList1.add(localReportData.getId());
        Map localMap = BaseUtils.copyNonNull(localReportData.getParams());
        localMap.put("eid", localReportData.getId());
        localArrayList2.add(localMap);
      }
    }
    paramMap.put("element_path", localArrayList1);
    paramMap.put("element_params", localArrayList2);
  }
  
  private void formatPage(ReportData paramReportData, Map<String, Object> paramMap)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramReportData != null)
    {
      localArrayMap.put("pgid", paramReportData.getId());
      BaseUtils.copyTo(paramReportData.getParams(), localArrayMap);
    }
    paramMap.put("cur_pg", localArrayMap);
  }
  
  public Map<String, Object> formatElementParams(@NonNull List<ReportData> paramList, ReportData paramReportData)
  {
    ArrayMap localArrayMap = new ArrayMap();
    formatElements(paramList, localArrayMap);
    formatPage(paramReportData, localArrayMap);
    return localArrayMap;
  }
  
  public Map<String, Object> formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    IEventMapHandler localIEventMapHandler = DTHandleEventFormatFactory.fetchEventHandler(paramString);
    if (localIEventMapHandler != null)
    {
      localIEventMapHandler.formatEvent(paramString, paramMap1, paramMap2);
      paramString = new HashMap();
      if (paramMap1 != null) {
        paramString.putAll(paramMap1);
      }
      paramString.put("udf_kv", paramMap2);
      return paramString;
    }
    return super.formatEvent(paramString, paramMap1, paramMap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNonFlattenFormatter
 * JD-Core Version:    0.7.0.1
 */