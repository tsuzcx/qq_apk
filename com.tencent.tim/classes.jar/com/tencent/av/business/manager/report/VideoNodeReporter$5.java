package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import ikr;
import ikr.a;
import java.util.Iterator;
import java.util.List;

public class VideoNodeReporter$5
  implements Runnable
{
  public VideoNodeReporter$5(ikr paramikr, String paramString) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "updateCrashType ,crashType = " + this.NC);
    if (this.this$0.fi.size() > 0)
    {
      Iterator localIterator = this.this$0.fi.iterator();
      while (localIterator.hasNext()) {
        ((ikr.a)localIterator.next()).NE = this.NC;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.5
 * JD-Core Version:    0.7.0.1
 */