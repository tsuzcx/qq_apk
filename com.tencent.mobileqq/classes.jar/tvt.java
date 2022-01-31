import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class tvt
  extends QQUIEventReceiver<tvd, ujj>
{
  public tvt(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull ujj paramujj)
  {
    if ((paramujj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramtvd.a != null) && (TextUtils.equals(paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramtvd.a.b)))
    {
      urk.a(paramtvd.b, "refresh feed item , feed id :%s", paramtvd.a.b);
      paramtvd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ujj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */