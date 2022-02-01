import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ivr
  extends BroadcastReceiver
{
  public ivr(SmallScreenService paramSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = AudioHelper.hG();
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "onReceive, action[" + paramContext + "], seq[" + l + "]");
    }
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      paramContext = paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER");
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onReceive NEW_OUTGOING_CALL phoneNumber = " + paramContext);
      }
    }
    while ((!paramContext.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) || (this.this$0.a == null)) {
      return;
    }
    this.this$0.getHandler().removeCallbacks(this.this$0.a);
    this.this$0.a.seq = l;
    this.this$0.getHandler().postDelayed(this.this$0.a, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivr
 * JD-Core Version:    0.7.0.1
 */