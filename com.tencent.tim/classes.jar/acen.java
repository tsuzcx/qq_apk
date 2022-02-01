import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class acen
  extends acfo
{
  private String bnR;
  
  protected void DE(String paramString)
  {
    this.c.x(4, this.bnR);
    aeee.Hn(false);
  }
  
  protected void Dp(String paramString)
  {
    this.bnR = paramString;
  }
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    QQAppInterface.a().onAppForeground();
    acek.a().onAppForeground(paramString);
    aeee.Hn(true);
    this.bnR = paramString;
    CoreService.startCoreService(acfn.a().bHF);
    this.c.yR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acen
 * JD-Core Version:    0.7.0.1
 */