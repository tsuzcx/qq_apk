package com.tencent.av.business.manager.report;

import android.text.TextUtils;
import annx;
import com.tencent.qphone.base.util.QLog;
import ikr;
import ikr.a;
import java.util.Iterator;
import java.util.List;

public class VideoNodeReporter$6
  implements Runnable
{
  public VideoNodeReporter$6(ikr paramikr, long paramLong) {}
  
  public void run()
  {
    Object localObject = ikr.a(this.this$0, this.kT);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.kT + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.kT != 0L)) {
      annx.o(null, "dc02402", (String)localObject);
    }
    ikr.a(this.this$0, this.kT);
    localObject = this.this$0.fi.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ikr.a locala = (ikr.a)((Iterator)localObject).next();
      if (this.kT == locala.roomId) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */