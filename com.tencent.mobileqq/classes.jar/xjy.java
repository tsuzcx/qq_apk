import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xjy
  extends Subscriber.SingleEventSubscriberNoRefect<wii>
{
  xjt a;
  
  public xjy(@NonNull xjt paramxjt)
  {
    this.a = paramxjt;
  }
  
  protected void a(@NonNull wii paramwii)
  {
    if ((paramwii.b != null) && (paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      xjt.a(this.a, paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwii.b.mVid, paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjy
 * JD-Core Version:    0.7.0.1
 */