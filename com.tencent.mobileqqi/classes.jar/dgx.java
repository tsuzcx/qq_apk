import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;

public class dgx
  implements Runnable
{
  public dgx(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void run()
  {
    if (RegisterVerifyCodeActivity.a(this.a) == 1)
    {
      RegisterVerifyCodeActivity.a(this.a).setText(2131562863);
      RegisterVerifyCodeActivity.a(this.a).setEnabled(true);
      RegisterVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    RegisterVerifyCodeActivity.b(this.a);
    RegisterVerifyCodeActivity.a(this.a).setText(this.a.getString(2131562863) + "(" + RegisterVerifyCodeActivity.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgx
 * JD-Core Version:    0.7.0.1
 */