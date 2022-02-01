import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class inc
  extends BroadcastReceiver
{
  inc(inb paraminb) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.qavgameplaysomgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.b.a = imz.a();
        int j = this.b.aqm;
        this.b.aqm = inf.a(this.b.a);
        boolean bool;
        if ((i == 100) && (this.b.aqm != 11))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QavGPDownloadManager", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGameplay[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.b.aqm), this.b.a }));
          }
          paramIntent = new ArrayList();
        }
        synchronized (this.b.ip)
        {
          paramIntent.addAll(this.b.ip);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((ina.a)???.next()).c(bool, this.b.ui(), this.b.aqm);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.b.ip)
      {
        paramIntent.addAll(this.b.ip);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((ina.a)???.next()).onDownloadProgress(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inc
 * JD-Core Version:    0.7.0.1
 */