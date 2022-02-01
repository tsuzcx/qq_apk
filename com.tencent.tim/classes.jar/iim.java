import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class iim
{
  private boolean PN;
  private BroadcastReceiver W;
  private VideoAppInterface mApp;
  
  public iim(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.W = new iim.a();
  }
  
  public void amw()
  {
    if (this.PN)
    {
      this.mApp.getApplication().unregisterReceiver(this.W);
      this.PN = false;
    }
  }
  
  public void amx()
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AnnimateDownloadFinish");
    if (this.mApp.getApplication().registerReceiver(this.W, localIntentFilter) != null) {
      this.PN = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GVipFunCallMonitor", 2, "regist vipFunCall " + this.PN);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
      do
      {
        do
        {
          return;
          paramContext = iim.a(iim.this).b();
        } while (paramContext == null);
        if (QLog.isColorLevel()) {
          QLog.d("GVipFunCallMonitor", 2, "recv vipfuncall msg broadcast: " + paramIntent.getAction());
        }
      } while (!paramIntent.getAction().equals("tencent.video.q2v.AnnimateDownloadFinish"));
      if (QLog.isColorLevel()) {
        QLog.d("GVipFunCallMonitor", 2, "ACTION_ANNIMATE_DOWNLOAD_FINISH");
      }
      paramContext.kr(paramIntent.getIntExtra("fun_call_id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iim
 * JD-Core Version:    0.7.0.1
 */