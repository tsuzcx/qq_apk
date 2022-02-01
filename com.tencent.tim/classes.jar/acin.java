import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;

public class acin
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
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    this.c.startTimer();
    CoreService.startTempService();
  }
  
  protected void cHe()
  {
    super.cHe();
    if (this.PM >= acfn.a().PH / 12000L)
    {
      CoreService.stopTempService();
      this.c.yR();
      this.PM = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acin
 * JD-Core Version:    0.7.0.1
 */