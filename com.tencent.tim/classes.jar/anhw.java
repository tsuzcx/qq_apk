import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class anhw
  extends BroadcastReceiver
{
  anhw(anhv paramanhv) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.gesturemgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.b.a = DownloadInfo.get();
        int j = this.b.dGj;
        this.b.dGj = anhx.a(this.b.a);
        boolean bool;
        if ((i == 100) && (this.b.dGj != 11))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QavGesture", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGesture[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.b.dGj), this.b.a }));
          }
          paramIntent = new ArrayList();
        }
        synchronized (this.b.AB)
        {
          paramIntent.addAll(this.b.AB);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((anhs.a)???.next()).c(bool, this.b.axd(), this.b.dGj);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.b.AB)
      {
        paramIntent.addAll(this.b.AB);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((anhs.a)???.next()).onDownloadProgress(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhw
 * JD-Core Version:    0.7.0.1
 */