import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wap
  extends QQUIEventReceiver<wah, wpd>
{
  public wap(@NonNull wah paramwah)
  {
    super(paramwah);
  }
  
  public void a(@NonNull wah paramwah, @NonNull wpd paramwpd)
  {
    if ((paramwpd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramwah.a != null) && (TextUtils.equals(paramwpd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramwah.a.b))) {
      paramwah.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wpd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wap
 * JD-Core Version:    0.7.0.1
 */