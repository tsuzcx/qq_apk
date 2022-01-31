import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ezt
  implements View.OnClickListener
{
  public ezt(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("5");
    VoipDialInterfaceActivity.a(this.a, '5');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ezu(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ezt
 * JD-Core Version:    0.7.0.1
 */