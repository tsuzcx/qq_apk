import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xae
  extends QQUIEventReceiver<wzo, xnu>
{
  public xae(@NonNull wzo paramwzo)
  {
    super(paramwzo);
  }
  
  public void a(@NonNull wzo paramwzo, @NonNull xnu paramxnu)
  {
    if ((paramxnu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramwzo.a != null) && (TextUtils.equals(paramxnu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramwzo.a.b)))
    {
      xvv.a(paramwzo.b, "refresh feed item , feed id :%s", paramwzo.a.b);
      paramwzo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xnu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */