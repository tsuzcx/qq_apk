import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import mqq.app.AppRuntime;

public class fdg
  extends fcu
{
  protected void a(String paramString)
  {
    this.a.a(3, paramString);
  }
  
  protected void b()
  {
    this.a.a(6, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    CoreService.b();
    this.a.e();
    this.a.b(true);
    long l = this.a.a(Process.myPid());
    BaseApplicationImpl.a.a().onAppGuardModeChange(false, 2, (int)l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdg
 * JD-Core Version:    0.7.0.1
 */