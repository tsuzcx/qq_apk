import android.os.Handler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class gxa
  implements Runnable
{
  public gxa(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void run()
  {
    if (VideoPlayLogic.a(this.a) != null) {
      VideoPlayLogic.c(this.a);
    }
    this.a.b.removeCallbacks(VideoPlayLogic.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxa
 * JD-Core Version:    0.7.0.1
 */