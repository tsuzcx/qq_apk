import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ezq
  implements View.OnClickListener
{
  public ezq(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("4");
    VoipDialInterfaceActivity.a(this.a, '4');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ezr(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ezq
 * JD-Core Version:    0.7.0.1
 */