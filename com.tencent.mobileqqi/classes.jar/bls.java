import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;

public class bls
  implements Runnable
{
  public bls(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    this.a.a.a().removeCallbacks(this.a.f);
    this.a.g(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bls
 * JD-Core Version:    0.7.0.1
 */