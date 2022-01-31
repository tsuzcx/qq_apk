import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class euw
  implements View.OnClickListener
{
  public euw(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("2");
    VoipDialInterfaceActivity.a(this.a, '2');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new eux(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euw
 * JD-Core Version:    0.7.0.1
 */