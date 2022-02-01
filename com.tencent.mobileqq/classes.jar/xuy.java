import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xuy
  extends QQUIEventReceiver<xui, yio>
{
  public xuy(@NonNull xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull yio paramyio)
  {
    if ((paramyio.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxui.a != null) && (TextUtils.equals(paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxui.a.b)))
    {
      yqp.a(paramxui.b, "refresh feed item , feed id :%s", paramxui.a.b);
      paramxui.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return yio.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuy
 * JD-Core Version:    0.7.0.1
 */