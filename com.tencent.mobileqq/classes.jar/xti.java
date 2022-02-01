import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xti
  extends QQUIEventReceiver<xsw, yio>
{
  public xti(@NonNull xsw paramxsw)
  {
    super(paramxsw);
  }
  
  public void a(@NonNull xsw paramxsw, @NonNull yio paramyio)
  {
    if ((paramyio.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxsw.a != null) && (TextUtils.equals(paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxsw.a.b)))
    {
      yqp.a(paramxsw.b, "refresh feed item , feed id :%s", paramxsw.a.b);
      paramxsw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return yio.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xti
 * JD-Core Version:    0.7.0.1
 */