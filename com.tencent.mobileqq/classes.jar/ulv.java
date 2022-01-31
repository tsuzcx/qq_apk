import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class ulv
  implements Runnable
{
  public ulv(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void run()
  {
    MediaPlayerManager.a(this.a).unregisterListener(MediaPlayerManager.a(this.a));
    MediaPlayerManager.a(this.a).unregisterListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulv
 * JD-Core Version:    0.7.0.1
 */