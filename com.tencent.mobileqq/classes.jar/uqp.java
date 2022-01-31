import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.utils.AudioUtil;

public class uqp
  implements Runnable
{
  public uqp(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void run()
  {
    try
    {
      AudioUtil.a(2131230731, 1, MediaPlayerManager.a(this.a), MediaPlayerManager.a(this.a));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqp
 * JD-Core Version:    0.7.0.1
 */