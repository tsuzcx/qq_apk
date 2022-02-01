import android.media.AudioManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class eum
  implements View.OnClickListener
{
  public eum(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    ((AudioManager)this.a.getSystemService("audio")).setMicrophoneMute(VoipDialInterfaceActivity.e(this.a));
    if (!VoipDialInterfaceActivity.e(this.a))
    {
      Toast.makeText(this.a, this.a.getString(2131560153), 0).show();
      paramView = this.a;
      if (VoipDialInterfaceActivity.e(this.a)) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      VoipDialInterfaceActivity.b(paramView, bool);
      ReportController.b(this.a.b, "CliOper", "", "", "CallTab_external", "Call_Interface", 0, 1, 0, "", "1", "", "");
      if (!VoipDialInterfaceActivity.e(this.a)) {
        break label157;
      }
      this.a.c.setBackgroundResource(2130840380);
      return;
      Toast.makeText(this.a, this.a.getString(2131560152), 0).show();
      break;
    }
    label157:
    this.a.c.setBackgroundResource(2130840384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eum
 * JD-Core Version:    0.7.0.1
 */