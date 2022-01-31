import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class evz
  implements View.OnClickListener
{
  public evz(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("0");
    VoipDialInterfaceActivity.a(this.a, '0');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ewa(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evz
 * JD-Core Version:    0.7.0.1
 */