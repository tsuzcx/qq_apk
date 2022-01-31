import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wbv
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  public wbv(StickerBubbleAnimationViewHolder paramStickerBubbleAnimationViewHolder) {}
  
  public void a()
  {
    StickerBubbleAnimationViewHolder.a(this.a, StickerBubbleAnimationViewHolder.a(this.a));
    ThreadManager.getUIHandler().post(new wbw(this));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "onSurfaceDestroyed");
    }
    StickerBubbleAnimationViewHolder.b(this.a, StickerBubbleAnimationViewHolder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbv
 * JD-Core Version:    0.7.0.1
 */