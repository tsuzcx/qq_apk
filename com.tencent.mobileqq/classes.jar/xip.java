import android.view.View;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class xip
  implements Runnable
{
  public xip(LoginView paramLoginView) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.a.b.getLocationInWindow(arrayOfInt);
    LoginView localLoginView = this.a;
    int i = this.a.b.getHeight();
    LoginView.a(localLoginView, arrayOfInt[1] + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xip
 * JD-Core Version:    0.7.0.1
 */