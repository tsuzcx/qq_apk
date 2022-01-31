import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vvo
  extends QQUIEventReceiver<vvc, wku>
{
  public vvo(@NonNull vvc paramvvc)
  {
    super(paramvvc);
  }
  
  public void a(@NonNull vvc paramvvc, @NonNull wku paramwku)
  {
    if ((paramwku.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramvvc.a != null) && (TextUtils.equals(paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramvvc.a.b)))
    {
      wsv.a(paramvvc.b, "refresh feed item , feed id :%s", paramvvc.a.b);
      paramvvc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wku.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvo
 * JD-Core Version:    0.7.0.1
 */