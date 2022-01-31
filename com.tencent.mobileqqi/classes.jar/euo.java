import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class euo
  implements View.OnClickListener
{
  public euo(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    int i;
    if (!VoipDialInterfaceActivity.f(this.a))
    {
      bool = true;
      paramView.a(bool);
      if (VoipDialInterfaceActivity.f(this.a)) {
        break label141;
      }
      i = 1;
      label34:
      if (i != 1) {
        break label146;
      }
      Toast.makeText(this.a, this.a.getString(2131562961), 0).show();
      label59:
      paramView = this.a;
      if (VoipDialInterfaceActivity.f(this.a)) {
        break label169;
      }
    }
    label141:
    label146:
    label169:
    for (boolean bool = true;; bool = false)
    {
      VoipDialInterfaceActivity.c(paramView, bool);
      ReportController.b(this.a.b, "CliOper", "", "", "CallTab_external", "Call_Interface", 0, 1, 0, "", "", "1", "");
      if (!VoipDialInterfaceActivity.f(this.a)) {
        break label174;
      }
      this.a.f.setBackgroundResource(2130840387);
      return;
      bool = false;
      break;
      i = 0;
      break label34;
      Toast.makeText(this.a, this.a.getString(2131561997), 0).show();
      break label59;
    }
    label174:
    this.a.f.setBackgroundResource(2130840389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euo
 * JD-Core Version:    0.7.0.1
 */