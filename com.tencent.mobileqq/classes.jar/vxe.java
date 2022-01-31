import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vxe
  extends QQUIEventReceiver<vwo, wku>
{
  public vxe(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull wku paramwku)
  {
    if ((paramwku.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramvwo.a != null) && (TextUtils.equals(paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramvwo.a.b)))
    {
      wsv.a(paramvwo.b, "refresh feed item , feed id :%s", paramvwo.a.b);
      paramvwo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wku.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxe
 * JD-Core Version:    0.7.0.1
 */