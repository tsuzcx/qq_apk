package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.impl.common.h.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.util.Map;

final class a$2
  implements h.a
{
  public final void a(String paramString, int paramInt, Map paramMap)
  {
    if ("TBSOneAction".equals(paramString)) {
      StatisticReport.create(paramString, paramInt).report();
    }
    while ((paramInt == 201) || (paramInt == 209) || (paramInt == 214) || (paramInt == 506)) {
      return;
    }
    StatisticReport localStatisticReport = StatisticReport.create(paramString, paramInt);
    if (paramMap != null)
    {
      if (paramMap.containsKey("DEPS_VERSION_CODE")) {
        localStatisticReport.setDEPSCode(((Integer)paramMap.get("DEPS_VERSION_CODE")).intValue());
      }
      if (!paramMap.containsKey("COMPONENT_NAME")) {
        break label218;
      }
    }
    label218:
    for (paramString = (String)paramMap.get("COMPONENT_NAME");; paramString = "")
    {
      paramInt = -1;
      if (paramMap.containsKey("COMPONENT_VERSION_CODE")) {
        paramInt = ((Integer)paramMap.get("COMPONENT_VERSION_CODE")).intValue();
      }
      localStatisticReport.setComponent(paramString, paramInt);
      if (paramMap.containsKey("DESCRIPTION")) {}
      for (paramString = (String)paramMap.get("DESCRIPTION");; paramString = "")
      {
        Throwable localThrowable = null;
        if (paramMap.containsKey("THROWABLE")) {
          localThrowable = (Throwable)paramMap.get("THROWABLE");
        }
        localStatisticReport.setDescription(paramString, localThrowable);
        localStatisticReport.report();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.2
 * JD-Core Version:    0.7.0.1
 */