import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class fau
  implements Runnable
{
  public fau(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void run()
  {
    if (VoipDialInterfaceActivity.c(this.a))
    {
      VoipDialInterfaceActivity.a(this.a);
      new String();
      String str = this.a.a(VoipDialInterfaceActivity.b(this.a) * 1000L);
      if (VoipDialInterfaceActivity.a(this.a) != null) {
        VoipDialInterfaceActivity.a(this.a).setText(str);
      }
    }
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fau
 * JD-Core Version:    0.7.0.1
 */