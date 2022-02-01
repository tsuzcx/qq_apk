import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class iib
{
  private boolean PI;
  private BroadcastReceiver U;
  private VideoAppInterface mApp;
  
  public iib(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.U = new iib.a();
  }
  
  public void amw()
  {
    if (this.PI)
    {
      this.mApp.getApplication().unregisterReceiver(this.U);
      this.PI = false;
    }
  }
  
  public void amx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioExitMonitor", 2, "regist QQ Process Exit Receiver1");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.EXIT_VIDEO_PROCESS");
    if (this.mApp.getApplication().registerReceiver(this.U, localIntentFilter) != null) {
      this.PI = true;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("com.tencent.av.EXIT_VIDEO_PROCESS".equals(paramIntent.getAction())))
      {
        long l = jlc.a(paramIntent);
        QLog.w("GAudioExitMonitor", 1, "onReceive.EXIT_VIDEO_ACTION, seq[" + l + "]");
        paramContext = iib.a(iib.this).b();
        if (paramContext != null)
        {
          paramContext.a(false, 202, new int[] { paramContext.b().anb });
          paramContext.ko(202);
          paramContext.kq(1011);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iib
 * JD-Core Version:    0.7.0.1
 */