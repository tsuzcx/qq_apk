import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationItem;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import java.util.HashMap;
import java.util.Queue;

public class vyq
  implements Runnable
{
  public vyq(StickerBubbleAnimationView paramStickerBubbleAnimationView, StickerBubbleAnimationItem paramStickerBubbleAnimationItem) {}
  
  public void run()
  {
    Queue localQueue = (Queue)StickerBubbleAnimationView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).get(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem.a());
    if ((localQueue == null) || (!localQueue.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem))) {
      ((Queue)StickerBubbleAnimationView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).get(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem.a())).remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyq
 * JD-Core Version:    0.7.0.1
 */