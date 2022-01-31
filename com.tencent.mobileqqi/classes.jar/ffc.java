import com.tencent.mobileqq.activity.aio.VoiceNotifyConfigHelper;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ffc
  implements Runnable
{
  public ffc(ConfigHandler paramConfigHandler) {}
  
  public void run()
  {
    VoiceNotifyConfigHelper.a().a(this.a.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffc
 * JD-Core Version:    0.7.0.1
 */