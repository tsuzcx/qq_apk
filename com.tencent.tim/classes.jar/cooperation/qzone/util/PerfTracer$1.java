package cooperation.qzone.util;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class PerfTracer$1
  implements Runnable
{
  PerfTracer$1(String paramString, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.val$tag, String.valueOf(this.val$time));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "QzoneTracePref", true, 0L, 0L, localHashMap, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qzone.util.PerfTracer.1
 * JD-Core Version:    0.7.0.1
 */