import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class wpe
  extends Subscriber.SingleEventSubscriberNoRefect<voc>
{
  woz a;
  
  public wpe(@NonNull woz paramwoz)
  {
    this.a = paramwoz;
  }
  
  protected void a(@NonNull voc paramvoc)
  {
    if ((paramvoc.b != null) && (paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      woz.a(this.a, paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramvoc.b.mVid, paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpe
 * JD-Core Version:    0.7.0.1
 */