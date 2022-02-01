import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import mqq.app.AppRuntime;

public class ezb
  extends fct
{
  protected void a(String paramString)
  {
    this.a.a(3, paramString);
  }
  
  protected void b()
  {
    this.a.a(4, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    this.a.b(false);
    this.a.e();
    this.a.a(new String[0]);
    long l = this.a.a(Process.myPid());
    BaseApplicationImpl.a.a().onAppGuardModeChange(false, 0, (int)l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezb
 * JD-Core Version:    0.7.0.1
 */