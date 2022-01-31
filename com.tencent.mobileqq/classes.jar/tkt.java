import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class tkt
  extends Subscriber.SingleEventSubscriberNoRefect<sjc>
{
  tko a;
  
  public tkt(@NonNull tko paramtko)
  {
    this.a = paramtko;
  }
  
  protected void a(@NonNull sjc paramsjc)
  {
    if ((paramsjc.b != null) && (paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)) {
      tko.a(this.a, paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramsjc.b.mVid, paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkt
 * JD-Core Version:    0.7.0.1
 */