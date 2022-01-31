import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ezk
  implements View.OnClickListener
{
  public ezk(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("2");
    VoipDialInterfaceActivity.a(this.a, '2');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ezl(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ezk
 * JD-Core Version:    0.7.0.1
 */