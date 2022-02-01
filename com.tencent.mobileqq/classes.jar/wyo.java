import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wyo
  extends QQUIEventReceiver<wyc, xnu>
{
  public wyo(@NonNull wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull xnu paramxnu)
  {
    if ((paramxnu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramwyc.a != null) && (TextUtils.equals(paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramwyc.a.b)))
    {
      xvv.a(paramwyc.b, "refresh feed item , feed id :%s", paramwyc.a.b);
      paramwyc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xnu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */