import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationItem;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import java.util.List;
import java.util.Map;

public class wgz
  implements Runnable
{
  public wgz(StickerBubbleAnimationView paramStickerBubbleAnimationView, StickerBubbleAnimationItem paramStickerBubbleAnimationItem) {}
  
  public void run()
  {
    List localList = (List)StickerBubbleAnimationView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).get(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem.a());
    if ((localList == null) || (!localList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem)))
    {
      localList = (List)StickerBubbleAnimationView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).get(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem.a());
      if (localList != null) {
        localList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */