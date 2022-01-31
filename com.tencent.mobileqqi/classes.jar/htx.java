import android.os.Handler;
import android.widget.TextView;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;

public class htx
  implements Runnable
{
  public htx(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity2.a(this.a) <= 1)
    {
      AuthDevVerifyCodeActivity2.a(this.a).setText(2131562863);
      AuthDevVerifyCodeActivity2.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity2.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity2.b(this.a);
    AuthDevVerifyCodeActivity2.a(this.a).setText(this.a.getString(2131562863) + "(" + AuthDevVerifyCodeActivity2.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     htx
 * JD-Core Version:    0.7.0.1
 */