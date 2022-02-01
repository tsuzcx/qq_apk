package com.tencent.mobileqq.armap;

import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public final class ArMapUtil$2
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.bQJ)
    {
      str = "1";
      localHashMap.put("isMapShow", str);
      if (!this.bQK) {
        break label106;
      }
      str = "1";
      label36:
      localHashMap.put("isFelxMap", str);
      if (!this.bQL) {
        break label112;
      }
    }
    label106:
    label112:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isFelxMapClick", str);
      localHashMap.put("operatorMapCount", String.valueOf(this.cJW));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "ARMAP_DETAIL_GRID_MAP", this.bQL, 0L, 0L, localHashMap, "", false);
      return;
      str = "0";
      break;
      str = "0";
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.2
 * JD-Core Version:    0.7.0.1
 */