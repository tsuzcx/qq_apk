import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class euz
  implements View.OnClickListener
{
  public euz(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("3");
    VoipDialInterfaceActivity.a(this.a, '3');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new eva(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euz
 * JD-Core Version:    0.7.0.1
 */