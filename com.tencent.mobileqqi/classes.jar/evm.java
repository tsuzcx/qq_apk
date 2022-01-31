import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class evm
  implements View.OnClickListener
{
  public evm(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("7");
    VoipDialInterfaceActivity.a(this.a, '7');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new evn(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evm
 * JD-Core Version:    0.7.0.1
 */