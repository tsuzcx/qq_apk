import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txm
  extends Subscriber.SingleEventSubscriberNoRefect<svv>
{
  txh a;
  
  public txm(@NonNull txh paramtxh)
  {
    this.a = paramtxh;
  }
  
  protected void a(@NonNull svv paramsvv)
  {
    if ((paramsvv.b != null) && (paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      txh.a(this.a, paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramsvv.b.mVid, paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txm
 * JD-Core Version:    0.7.0.1
 */