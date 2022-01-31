import android.os.Looper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import java.util.HashMap;

public class vyp
  implements Runnable
{
  public vyp(StickerBubbleAnimationView paramStickerBubbleAnimationView) {}
  
  public void run()
  {
    StickerBubbleAnimationView.a(this.a).clear();
    StickerBubbleAnimationView.b(this.a).clear();
    StickerBubbleAnimationView.c(this.a).clear();
    StickerBubbleAnimationView.d(this.a).clear();
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {
      localLooper.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyp
 * JD-Core Version:    0.7.0.1
 */