package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import ikr;
import ikr.a;
import java.util.Iterator;
import java.util.List;

public class VideoNodeReporter$2
  implements Runnable
{
  public VideoNodeReporter$2(ikr paramikr, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.fi.size() > 0)
    {
      Iterator localIterator = this.this$0.fi.iterator();
      while (localIterator.hasNext())
      {
        ikr.a locala = (ikr.a)localIterator.next();
        if (locala.roomId == -1L)
        {
          locala.roomId = this.kT;
          this.this$0.d(this.kT, 26, this.kT);
          QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + this.kT);
          ikr.a(this.this$0, -1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.2
 * JD-Core Version:    0.7.0.1
 */