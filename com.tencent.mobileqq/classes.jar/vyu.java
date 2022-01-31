import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class vyu
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  public vyu(StickerBubbleAnimationViewHolder paramStickerBubbleAnimationViewHolder) {}
  
  public void a()
  {
    StickerBubbleAnimationViewHolder.a(this.a, StickerBubbleAnimationViewHolder.b(this.a));
    ThreadManager.getUIHandler().post(new vyv(this));
  }
  
  public void b()
  {
    StickerBubbleAnimationViewHolder.b(this.a, StickerBubbleAnimationViewHolder.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyu
 * JD-Core Version:    0.7.0.1
 */