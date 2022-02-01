import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.qphone.base.util.QLog;

public class zzb
  extends BroadcastReceiver
{
  public zzb(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketKSongFragment", 2, "receive action_recv_video_request");
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((!this.this$0.buB) || (!this.this$0.buC) || (this.this$0.bU.getVisibility() != 0)) {
          break label151;
        }
        this.this$0.csD();
      }
      label79:
      while (!this.this$0.buD)
      {
        return;
        if (!"android.intent.action.PHONE_STATE".equals(paramContext)) {
          break label188;
        }
        paramContext = (TelephonyManager)this.this$0.getActivity().getSystemService("phone");
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketKSongFragment", 2, "receive action_phone_state_changed|call_state_ringing" + paramContext.getCallState());
        }
        if (paramContext.getCallState() != 1) {
          break label188;
        }
        i = 1;
        break;
      }
      label151:
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketKSongFragment", 2, "receive pause action");
      }
      this.this$0.onError(acfp.m(2131713815));
      return;
      label188:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzb
 * JD-Core Version:    0.7.0.1
 */