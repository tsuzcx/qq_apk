import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.b;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ygc
  implements StickerBubbleAnimationView.b
{
  ygc(ygb paramygb) {}
  
  public void onAnimationEnd()
  {
    ygb.a(this.a, ygb.a(this.a));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.1.1(this));
  }
  
  public void onSurfaceDestroyed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "onSurfaceDestroyed");
    }
    ygb.b(this.a, ygb.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygc
 * JD-Core Version:    0.7.0.1
 */