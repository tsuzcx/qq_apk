import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txp
  extends Subscriber.SingleEventSubscriberNoRefect<svy>
{
  txk a;
  
  public txp(@NonNull txk paramtxk)
  {
    this.a = paramtxk;
  }
  
  protected void a(@NonNull svy paramsvy)
  {
    if ((paramsvy.b != null) && (paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      txk.a(this.a, paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramsvy.b.mVid, paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txp
 * JD-Core Version:    0.7.0.1
 */