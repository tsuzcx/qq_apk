import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wzg
  extends QQUIEventReceiver<wyy, xnu>
{
  public wzg(@NonNull wyy paramwyy)
  {
    super(paramwyy);
  }
  
  public void a(@NonNull wyy paramwyy, @NonNull xnu paramxnu)
  {
    if ((paramxnu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramwyy.a != null) && (TextUtils.equals(paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramwyy.a.b))) {
      paramwyy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xnu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */