import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import mqq.app.AppRuntime;

public class acgz
  extends acfo
{
  protected void Dp(String paramString)
  {
    GuardManager localGuardManager = this.c;
    if ("com.tencent.tim".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.x(i, paramString);
      return;
    }
  }
  
  public void Dq(String paramString)
  {
    super.Dq(paramString);
    this.c.yR();
    this.c.EV(true);
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(4, acfn.a().PH, 0L);
    CoreService.stopCoreService();
  }
  
  protected void cHf()
  {
    this.c.x(6, "fake_p_msg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acgz
 * JD-Core Version:    0.7.0.1
 */