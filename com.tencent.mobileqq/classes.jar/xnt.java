import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xnt
  extends Subscriber.SingleEventSubscriberNoRefect<wmd>
{
  xno a;
  
  public xnt(@NonNull xno paramxno)
  {
    this.a = paramxno;
  }
  
  protected void a(@NonNull wmd paramwmd)
  {
    if ((paramwmd.b != null) && (paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      xno.a(this.a, paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwmd.b.mVid, paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnt
 * JD-Core Version:    0.7.0.1
 */