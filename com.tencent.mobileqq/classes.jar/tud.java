import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class tud
  extends QQUIEventReceiver<ttr, ujj>
{
  public tud(@NonNull ttr paramttr)
  {
    super(paramttr);
  }
  
  public void a(@NonNull ttr paramttr, @NonNull ujj paramujj)
  {
    if ((paramujj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramttr.a != null) && (TextUtils.equals(paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramttr.a.b)))
    {
      urk.a(paramttr.b, "refresh feed item , feed id :%s", paramttr.a.b);
      paramttr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ujj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tud
 * JD-Core Version:    0.7.0.1
 */