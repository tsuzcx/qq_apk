import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class dyl
  extends BroadcastReceiver
{
  public dyl(QQPlayerService paramQQPlayerService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "QQPlayerBroadcastReceiverReceiver onReceive,action:" + paramIntent.getAction());
    }
    if (("com.tencent.mobileqq.intent.logout".equals(paramIntent.getAction())) || ("qqplayer_exit_action".equals(paramIntent.getAction())))
    {
      if ((paramIntent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false)) && (this.a.a != null)) {
        this.a.a.b = true;
      }
      QQPlayerService.c(this.a.getApplicationContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyl
 * JD-Core Version:    0.7.0.1
 */