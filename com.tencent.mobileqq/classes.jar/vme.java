import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vme
  extends Subscriber.SingleEventSubscriberNoRefect<ukn>
{
  vlz a;
  
  public vme(@NonNull vlz paramvlz)
  {
    this.a = paramvlz;
  }
  
  protected void a(@NonNull ukn paramukn)
  {
    if ((paramukn.b != null) && (paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      vlz.a(this.a, paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramukn.b.mVid, paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */