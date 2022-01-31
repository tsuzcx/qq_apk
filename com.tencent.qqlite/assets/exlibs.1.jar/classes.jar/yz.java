import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;

public class yz
  implements Runnable
{
  public yz(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.a(this.a) <= 1)
    {
      AuthDevVerifyCodeActivity.a(this.a).setText(2131363325);
      AuthDevVerifyCodeActivity.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b(this.a);
    AuthDevVerifyCodeActivity.a(this.a).setText(this.a.getString(2131363325) + "(" + AuthDevVerifyCodeActivity.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yz
 * JD-Core Version:    0.7.0.1
 */