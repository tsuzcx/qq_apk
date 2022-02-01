import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;

public class apia
  extends BroadcastReceiver
{
  public apia(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.b != null)
    {
      paramContext = paramIntent.getAction();
      if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "receive action_recv_video_request");
      }
      this.this$0.b.zV(102);
    }
    label51:
    while (!"android.intent.action.PHONE_STATE".equals(paramContext)) {
      return;
    }
    if ((((TelephonyManager)this.this$0.getActivity().getSystemService("phone")).getCallState() == 1) && (QLog.isColorLevel())) {
      QLog.d("SubmitHomeWorkFragment", 2, "receive action_phone_state_changed|call_state_ringing");
    }
    this.this$0.b.zV(102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apia
 * JD-Core Version:    0.7.0.1
 */