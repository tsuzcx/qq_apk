import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xdz
  extends Subscriber.SingleEventSubscriberNoRefect<wcx>
{
  xdu a;
  
  public xdz(@NonNull xdu paramxdu)
  {
    this.a = paramxdu;
  }
  
  protected void a(@NonNull wcx paramwcx)
  {
    if ((paramwcx.b != null) && (paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      xdu.a(this.a, paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwcx.b.mVid, paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdz
 * JD-Core Version:    0.7.0.1
 */