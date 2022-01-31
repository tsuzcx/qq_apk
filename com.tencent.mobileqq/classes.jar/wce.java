import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable;

public class wce
  implements Runnable
{
  public wce(StickerBubbleReceiverAnimationRunnable paramStickerBubbleReceiverAnimationRunnable) {}
  
  public void run()
  {
    if (StickerBubbleReceiverAnimationRunnable.a(this.a))
    {
      StickerBubbleAnimationHelper.a(this.a, StickerBubbleReceiverAnimationRunnable.a(this.a));
      StickerBubbleReceiverAnimationRunnable.a(this.a, false);
      StickerBubbleReceiverAnimationRunnable.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wce
 * JD-Core Version:    0.7.0.1
 */