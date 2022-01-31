import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class faj
  implements View.OnClickListener
{
  public faj(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("*");
    VoipDialInterfaceActivity.a(this.a, '*');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new fak(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     faj
 * JD-Core Version:    0.7.0.1
 */