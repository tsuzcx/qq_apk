import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.utils.AudioUtil;

public class uir
  implements Runnable
{
  public uir(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void run()
  {
    try
    {
      AudioUtil.a(2131230730, 1, MediaPlayerManager.a(this.a), MediaPlayerManager.a(this.a));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uir
 * JD-Core Version:    0.7.0.1
 */