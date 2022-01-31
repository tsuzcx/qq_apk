import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;

public class cvl
  implements Runnable
{
  public cvl(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void run()
  {
    if (LoginVerifyCodeActivity2.a(this.a) == 1)
    {
      LoginVerifyCodeActivity2.a(this.a).setText(2131562863);
      LoginVerifyCodeActivity2.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity2.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity2.b(this.a);
    LoginVerifyCodeActivity2.a(this.a).setText(this.a.getString(2131562863) + "(" + LoginVerifyCodeActivity2.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvl
 * JD-Core Version:    0.7.0.1
 */