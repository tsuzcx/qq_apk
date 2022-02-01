package com.huawei.hianalytics.ab.bc.ik.bc;

import android.content.Context;
import android.util.Pair;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cd
  implements com.huawei.hianalytics.ab.bc.ik.cd.ab
{
  private Context ab = com.huawei.hianalytics.ab.ab.bc.ik();
  private String bc;
  private String cd;
  private String de;
  
  public cd(String paramString1, String paramString2, String paramString3)
  {
    this.bc = paramString1;
    this.cd = paramString2;
    this.de = paramString3;
  }
  
  private void ab(String paramString, List<de> paramList)
  {
    paramString = com.huawei.hianalytics.ab.bc.kl.ef.ab(paramString);
    new com.huawei.hianalytics.ab.bc.de.bc(paramList, (String)paramString.first, (String)paramString.second, this.de).ab();
  }
  
  public void run()
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("EventReportTask", "eventReportTask is running");
    boolean bool = com.huawei.hianalytics.ab.bc.kl.bc.ab(this.ab);
    if (bool)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("EventReportTask", "workKey is refresh,begin report all data");
      this.cd = "alltype";
    }
    Object localObject = com.huawei.hianalytics.ab.bc.de.ef.ab(this.ab, this.bc, this.cd);
    if (((Map)localObject).size() == 0) {
      com.huawei.hianalytics.ab.bc.ef.ab.ab("EventReportTask", "no have events to report: tag:%s : type:%s", new Object[] { this.bc, this.cd });
    }
    for (;;)
    {
      return;
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        ab((String)localEntry.getKey(), (List)localEntry.getValue());
      }
      if ("alltype".equals(this.cd))
      {
        com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "stat_v2_1", new String[0]);
        com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "cached_v2_1", new String[0]);
      }
      while (bool)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.bc("EventReportTask", "refresh local key");
        com.huawei.hianalytics.ab.bc.gh.bc.ab().bc();
        localObject = com.huawei.hianalytics.ab.bc.de.ab.ab().bc();
        com.huawei.hianalytics.ab.bc.de.ab.ab().ab((String)localObject);
        return;
        localObject = com.huawei.hianalytics.ab.bc.kl.ef.ab(this.bc, this.cd);
        com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "stat_v2_1", new String[] { localObject });
        com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "cached_v2_1", new String[] { localObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.bc.cd
 * JD-Core Version:    0.7.0.1
 */