package com.tencent.qqmail.utilities.fps;

import android.os.Handler;
import android.util.Printer;
import com.tencent.qqmail.utilities.log.QMLog;

class MainLooperMonitor$2
  implements Printer
{
  MainLooperMonitor$2(MainLooperMonitor paramMainLooperMonitor) {}
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>>>> Dispatching to"))
    {
      MainLooperMonitor.access$102(this.this$0, System.currentTimeMillis());
      MainLooperMonitor.access$300(this.this$0).removeCallbacks(MainLooperMonitor.access$200(this.this$0));
      MainLooperMonitor.access$300(this.this$0).postDelayed(MainLooperMonitor.access$200(this.this$0), MainLooperMonitor.access$400(this.this$0) - 10L);
      break label66;
    }
    for (;;)
    {
      label66:
      return;
      if (paramString.startsWith("<<<<< Finished to"))
      {
        MainLooperMonitor.access$502(this.this$0, System.currentTimeMillis());
        if (!MainLooperMonitor.access$600(this.this$0)) {
          break;
        }
        QMLog.log(4, "LooperMonitor_Block", "### Block stack trace---");
        if (MainLooperMonitor.access$700(this.this$0) == null) {
          break;
        }
        paramString = MainLooperMonitor.access$700(this.this$0);
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString[i];
          QMLog.log(4, "LooperMonitor_Block", "## Block stack  " + localObject.toString());
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fps.MainLooperMonitor.2
 * JD-Core Version:    0.7.0.1
 */