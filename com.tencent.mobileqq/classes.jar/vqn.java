import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vqn
  extends Subscriber.SingleEventSubscriberNoRefect<uow>
{
  vqi a;
  
  public vqn(@NonNull vqi paramvqi)
  {
    this.a = paramvqi;
  }
  
  protected void a(@NonNull uow paramuow)
  {
    if ((paramuow.b != null) && (paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      vqi.a(this.a, paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramuow.b.mVid, paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */