import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpFilterHelper;

public class zbs
  implements Runnable
{
  public zbs(ConfigHandler paramConfigHandler) {}
  
  public void run()
  {
    JumpFilterHelper.a().a(this.a.b.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zbs
 * JD-Core Version:    0.7.0.1
 */