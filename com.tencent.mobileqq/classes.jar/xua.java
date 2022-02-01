import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xua
  extends QQUIEventReceiver<xts, yio>
{
  public xua(@NonNull xts paramxts)
  {
    super(paramxts);
  }
  
  public void a(@NonNull xts paramxts, @NonNull yio paramyio)
  {
    if ((paramyio.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxts.a != null) && (TextUtils.equals(paramyio.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxts.a.b))) {
      paramxts.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return yio.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xua
 * JD-Core Version:    0.7.0.1
 */