import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;

public class auz
  implements Runnable
{
  public auz(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void run()
  {
    if (LoginVerifyCodeActivity2.a(this.a) == 1)
    {
      LoginVerifyCodeActivity2.a(this.a).setText(2131363338);
      LoginVerifyCodeActivity2.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity2.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity2.b(this.a);
    LoginVerifyCodeActivity2.a(this.a).setText(this.a.getString(2131363338) + "(" + LoginVerifyCodeActivity2.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     auz
 * JD-Core Version:    0.7.0.1
 */