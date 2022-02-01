import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class iwh
  extends BroadcastReceiver
{
  iwh(iwg paramiwg) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.somgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.b.a = DownloadInfo.get();
        int j = this.b.auQ;
        this.b.auQ = iwi.a(this.b.a);
        boolean bool;
        if ((i == 100) && (this.b.auQ != 11))
        {
          bool = true;
          QLog.i("QavSo", 1, String.format("receive notify, lastStatus[%s], progress[%s], mStatusSo[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.b.auQ), this.b.a }));
          paramIntent = new ArrayList();
        }
        synchronized (this.b.iD)
        {
          paramIntent.addAll(this.b.iD);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((iwd.a)???.next()).c(bool, this.b.vO(), this.b.auQ);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavSo", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.b.iD)
      {
        paramIntent.addAll(this.b.iD);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((iwd.a)???.next()).onDownloadProgress(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwh
 * JD-Core Version:    0.7.0.1
 */