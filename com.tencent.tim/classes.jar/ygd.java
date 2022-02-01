import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.b;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ygd
  implements StickerBubbleAnimationView.b
{
  ygd(ygb paramygb) {}
  
  public void onAnimationEnd()
  {
    ygb.a(this.a, ygb.b(this.a));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.2.1(this));
  }
  
  public void onSurfaceDestroyed()
  {
    ygb.b(this.a, ygb.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygd
 * JD-Core Version:    0.7.0.1
 */