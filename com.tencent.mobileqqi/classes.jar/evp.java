import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class evp
  implements View.OnClickListener
{
  public evp(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("8");
    VoipDialInterfaceActivity.a(this.a, '8');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new evq(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evp
 * JD-Core Version:    0.7.0.1
 */