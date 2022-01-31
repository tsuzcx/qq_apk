import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.qphone.base.util.QLog;

public class cdf
  extends BroadcastReceiver
{
  public cdf(ChatActivity paramChatActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "readconfirm network change");
      }
      paramContext = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isAvailable()) && (ChatActivity.b(this.a)))
      {
        this.a.a.removeMessages(16711689);
        this.a.a.sendEmptyMessage(16711689);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivity", 2, "receive action_recv_video_request");
            }
            this.a.d(2);
            return;
          }
        } while (!"android.intent.action.PHONE_STATE".equals(paramContext));
        paramContext = (TelephonyManager)this.a.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.a.d(2);
        }
      } while (paramContext.getCallState() != 1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "receive action_phone_state_changed|call_state_ringing");
      }
      paramContext = MediaPlayerManager.a(this.a.b);
    } while (!paramContext.d());
    paramContext.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdf
 * JD-Core Version:    0.7.0.1
 */