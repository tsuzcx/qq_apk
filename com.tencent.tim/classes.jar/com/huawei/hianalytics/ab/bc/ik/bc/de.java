package com.huawei.hianalytics.ab.bc.ik.bc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class de
  implements com.huawei.hianalytics.ab.bc.ik.cd.ab
{
  private String ab;
  private String bc;
  private String cd;
  private List<com.huawei.hianalytics.ab.bc.cd.bc.de> de;
  
  public de(List<com.huawei.hianalytics.ab.bc.cd.bc.de> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.ab = paramString1;
    this.bc = paramString2;
    this.cd = paramString3;
    this.de = paramList;
  }
  
  private void ab()
  {
    String str = com.huawei.hianalytics.ab.bc.kl.ef.ab(this.ab, this.cd, this.bc);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "backup_event", new String[] { str });
  }
  
  public void run()
  {
    if ((this.de == null) || (this.de.size() == 0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("FailedEventHandlerTask", "failed events is empty");
      return;
    }
    int i = com.huawei.hianalytics.ab.ab.bc.ij();
    if (com.huawei.hianalytics.ab.bc.kl.bc.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "cached_v2_1", i * 1048576))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("FailedEventHandlerTask", "The cacheFile is full,Can not writing data! reqID:" + this.bc);
      return;
    }
    String str = com.huawei.hianalytics.ab.bc.kl.ef.ab(this.ab, this.cd);
    Object localObject = (List)com.huawei.hianalytics.ab.bc.de.ef.bc(com.huawei.hianalytics.ab.ab.bc.ik(), "cached_v2_1", str).get(str);
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      this.de.addAll((Collection)localObject);
    }
    localObject = new JSONArray();
    Iterator localIterator = this.de.iterator();
    while (localIterator.hasNext())
    {
      com.huawei.hianalytics.ab.bc.cd.bc.de localde = (com.huawei.hianalytics.ab.bc.cd.bc.de)localIterator.next();
      try
      {
        ((JSONArray)localObject).put(localde.de());
      }
      catch (JSONException localJSONException)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("FailedEventHandlerTask", "event to json error");
      }
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("FailedEventHandlerTask", "data send failed, write to cache file...reqID:" + this.bc);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "cached_v2_1", str, ((JSONArray)localObject).toString());
    ab();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.bc.de
 * JD-Core Version:    0.7.0.1
 */