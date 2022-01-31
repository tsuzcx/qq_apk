import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;

public class cvb
  implements Runnable
{
  public cvb(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    if ((LoginVerifyCodeActivity.a(this.a) == 1) || (this.a.isFinishing()))
    {
      LoginVerifyCodeActivity.a(this.a).setText(2131562863);
      LoginVerifyCodeActivity.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity.b(this.a);
    LoginVerifyCodeActivity.a(this.a).setText(this.a.getString(2131562863) + "(" + LoginVerifyCodeActivity.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvb
 * JD-Core Version:    0.7.0.1
 */