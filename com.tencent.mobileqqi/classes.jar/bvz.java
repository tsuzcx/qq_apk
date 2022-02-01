import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;

public class bvz
  implements Runnable
{
  public bvz(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.a(this.a) <= 1)
    {
      AuthDevVerifyCodeActivity.a(this.a).setText(2131562863);
      AuthDevVerifyCodeActivity.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b(this.a);
    AuthDevVerifyCodeActivity.a(this.a).setText(this.a.getString(2131562863) + "(" + AuthDevVerifyCodeActivity.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvz
 * JD-Core Version:    0.7.0.1
 */