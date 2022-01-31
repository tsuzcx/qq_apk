import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class fag
  implements View.OnClickListener
{
  public fag(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("9");
    VoipDialInterfaceActivity.a(this.a, '9');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new fah(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fag
 * JD-Core Version:    0.7.0.1
 */