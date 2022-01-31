import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;

public class zqt
  extends ResourcePluginListener
{
  private zqt(GetConfig paramGetConfig) {}
  
  public void a(byte paramByte)
  {
    if (GetConfig.a(this.a) == 44)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      GetConfig.b(this.a).b.c(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    GetConfig.c(this.a).b.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqt
 * JD-Core Version:    0.7.0.1
 */