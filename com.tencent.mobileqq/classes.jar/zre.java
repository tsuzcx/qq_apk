import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;

public class zre
  implements Runnable
{
  public zre(LoginWelcomeRequest paramLoginWelcomeRequest) {}
  
  public void run()
  {
    LoginWelcomeManager.a(LoginWelcomeRequest.a(this.a).b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zre
 * JD-Core Version:    0.7.0.1
 */