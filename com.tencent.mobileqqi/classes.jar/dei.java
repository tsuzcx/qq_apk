import android.widget.Toast;
import com.tencent.mobileqq.activity.QuickLoginActivity;
import mqq.observer.AccountObserver;

public class dei
  extends AccountObserver
{
  public dei(QuickLoginActivity paramQuickLoginActivity) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Toast.makeText(this.a.getApplicationContext(), "login failure! check you qq and password!", 0).show();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    Toast.makeText(this.a.getApplicationContext(), "login suc", 0).show();
  }
  
  protected void onLoginTimeout(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login outtime", 0).show();
  }
  
  protected void onUserCancel(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login cancel", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dei
 * JD-Core Version:    0.7.0.1
 */