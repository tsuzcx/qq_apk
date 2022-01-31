import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wbn
  extends QQUIEventReceiver<wax, wpd>
{
  public wbn(@NonNull wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull wpd paramwpd)
  {
    if ((paramwpd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramwax.a != null) && (TextUtils.equals(paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramwax.a.b)))
    {
      wxe.a(paramwax.b, "refresh feed item , feed id :%s", paramwax.a.b);
      paramwax.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wpd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbn
 * JD-Core Version:    0.7.0.1
 */