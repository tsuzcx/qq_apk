package dov.com.tencent.biz.qqstory.takevideo;

import android.util.Log;
import anoq;
import anqh;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DataReporter$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Iterator localIterator = this.Nt.iterator();
      while (localIterator.hasNext())
      {
        anqh localanqh = (anqh)localIterator.next();
        anoq.b(this.val$appInterface, localanqh);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMReportController.DataReporter", 2, Log.getStackTraceString(localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter.1
 * JD-Core Version:    0.7.0.1
 */