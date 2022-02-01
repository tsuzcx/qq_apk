import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.utils.AudioHelper;

public class izz
  extends BroadcastReceiver
{
  public izz(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION"))
    {
      long l = AudioHelper.hG();
      paramContext = igv.a().a();
      this.this$0.a(l, "BroadcastReceiver_qzone", this.this$0.getIntent(), paramContext);
      this.this$0.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(this.this$0.mGroupId), Integer.valueOf(3) });
      this.this$0.kd("BroadcastReceiver_qzone");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izz
 * JD-Core Version:    0.7.0.1
 */