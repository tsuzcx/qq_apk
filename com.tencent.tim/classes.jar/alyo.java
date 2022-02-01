import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

class alyo
  extends Handler
{
  alyo(alyn paramalyn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = alyn.a(this.b).size();
    int i = 0;
    while (i < j)
    {
      alyn.a locala = (alyn.a)alyn.a(this.b).valueAt(i);
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview", locala.v("Pic.AioPreview")));
      paramMessage.a(new DataReport.ReportTask("Pic.AioPreview.Preload", locala.v("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyo
 * JD-Core Version:    0.7.0.1
 */