import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.qphone.base.util.QLog;

public class uig
  extends BroadcastReceiver
{
  public uig(BaseChatPie paramBaseChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "receive action_recv_video_request");
      }
      this.this$0.zV(2);
    }
    do
    {
      return;
      if ("android.intent.action.PHONE_STATE".equals(paramContext))
      {
        paramContext = (TelephonyManager)this.this$0.mContext.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.this$0.zV(2);
        }
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          paramIntent = MediaPlayerManager.a(this.this$0.app);
          if (paramIntent.isPlaying()) {
            paramIntent.stop(false);
          }
        }
        this.this$0.zQ(paramContext.getCallState());
        return;
      }
      if ((BaseChatPie.access$800() == 1) && ("vivo_smart_shot_enter".equals(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vivo", 2, "receive action_vivo_smart_shot_enter");
        }
        BaseChatPie.a(this.this$0, Boolean.valueOf(false));
        return;
      }
    } while (!"com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE".equals(paramContext));
    boolean bool = paramIntent.getBooleanExtra("mode", false);
    QLog.d("WindowsCastReceiver", 1, "onReceive mode = " + bool);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      aqfl.dYV = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */