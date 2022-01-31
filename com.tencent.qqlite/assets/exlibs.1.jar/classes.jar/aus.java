import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;

public class aus
  implements Runnable
{
  public aus(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    if ((LoginVerifyCodeActivity.a(this.a) == 1) || (this.a.isFinishing()))
    {
      LoginVerifyCodeActivity.a(this.a).setText(2131363338);
      LoginVerifyCodeActivity.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity.b(this.a);
    LoginVerifyCodeActivity.a(this.a).setText(this.a.getString(2131363338) + "(" + LoginVerifyCodeActivity.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aus
 * JD-Core Version:    0.7.0.1
 */