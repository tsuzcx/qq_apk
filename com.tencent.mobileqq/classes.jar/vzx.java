import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vzx
  extends QQUIEventReceiver<vzl, wpd>
{
  public vzx(@NonNull vzl paramvzl)
  {
    super(paramvzl);
  }
  
  public void a(@NonNull vzl paramvzl, @NonNull wpd paramwpd)
  {
    if ((paramwpd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramvzl.a != null) && (TextUtils.equals(paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramvzl.a.b)))
    {
      wxe.a(paramvzl.b, "refresh feed item , feed id :%s", paramvzl.a.b);
      paramvzl.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wpd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzx
 * JD-Core Version:    0.7.0.1
 */