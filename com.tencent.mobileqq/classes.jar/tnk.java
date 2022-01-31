import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;

public class tnk
  implements Runnable
{
  public tnk(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void run()
  {
    if (RegisterVerifyCodeActivity.a(this.a) == 1)
    {
      RegisterVerifyCodeActivity.a(this.a).setText(2131434260);
      RegisterVerifyCodeActivity.a(this.a).setEnabled(true);
      RegisterVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    RegisterVerifyCodeActivity.b(this.a);
    RegisterVerifyCodeActivity.a(this.a).setText(this.a.getString(2131434260) + "(" + RegisterVerifyCodeActivity.a(this.a) + "s)");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnk
 * JD-Core Version:    0.7.0.1
 */