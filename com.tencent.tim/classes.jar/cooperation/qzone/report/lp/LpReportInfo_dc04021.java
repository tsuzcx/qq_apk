package cooperation.qzone.report.lp;

import avpq;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc04021
  implements LpReportInfo
{
  public long delayCallback;
  public long flingCallback;
  public long idleCallback;
  public long intimeCallback;
  public long noCallback;
  private String qua = avpq.getQUA3();
  public long totalDuration;
  public long touchScrollCallback;
  
  public String getSimpleInfo()
  {
    return "dc04021: total_duration=" + this.totalDuration + " intime_callback=" + this.intimeCallback + " delay_callback=" + this.delayCallback + " no_callback=" + this.noCallback + " idle_callback=" + this.idleCallback + " touch_scroll_callback=" + this.touchScrollCallback + " fling_callback=" + this.flingCallback;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_duration", String.valueOf(this.totalDuration));
    localHashMap.put("intime_callback", String.valueOf(this.intimeCallback));
    localHashMap.put("delay_callback", String.valueOf(this.delayCallback));
    localHashMap.put("no_callback", String.valueOf(this.noCallback));
    localHashMap.put("idle_callback", String.valueOf(this.idleCallback));
    localHashMap.put("touch_scroll_callback", String.valueOf(this.touchScrollCallback));
    localHashMap.put("fling_callback", String.valueOf(this.flingCallback));
    localHashMap.put("qua", this.qua);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc04021
 * JD-Core Version:    0.7.0.1
 */