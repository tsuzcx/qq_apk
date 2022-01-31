import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;

public class cxk
  extends ResourcePluginListener
{
  private cxk(GetConfig paramGetConfig) {}
  
  public void a(byte paramByte)
  {
    if (GetConfig.a(this.a) == 36)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      GetConfig.a(this.a).a.c(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    GetConfig.b(this.a).a.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cxk
 * JD-Core Version:    0.7.0.1
 */