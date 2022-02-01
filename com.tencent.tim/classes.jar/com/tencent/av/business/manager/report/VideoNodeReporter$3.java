package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import ikr;
import ikr.a;
import java.util.Iterator;
import java.util.List;

public class VideoNodeReporter$3
  implements Runnable
{
  public VideoNodeReporter$3(ikr paramikr, int paramInt, long paramLong) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "in runnabe report ,node = " + this.aoi + ",value = " + this.lw);
    if (this.this$0.fi.size() > 0)
    {
      Iterator localIterator = this.this$0.fi.iterator();
      while (localIterator.hasNext())
      {
        ikr.a locala = (ikr.a)localIterator.next();
        this.this$0.d(locala.roomId, this.aoi, this.lw);
      }
    }
    QLog.d("VideoNodeReporter", 1, " report ,node = " + this.aoi + ",value = " + this.lw + ",seesionRecordList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.3
 * JD-Core Version:    0.7.0.1
 */