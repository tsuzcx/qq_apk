import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class evo
  implements View.OnClickListener
{
  public evo(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("8");
    VoipDialInterfaceActivity.a(this.a, '8');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new evp(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evo
 * JD-Core Version:    0.7.0.1
 */