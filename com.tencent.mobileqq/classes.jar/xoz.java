import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xoz
  extends QQUIEventReceiver<xoj, ycp>
{
  public xoz(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull ycp paramycp)
  {
    if ((paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxoj.a != null) && (TextUtils.equals(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxoj.a.b)))
    {
      ykq.a(paramxoj.b, "refresh feed item , feed id :%s", paramxoj.a.b);
      paramxoj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoz
 * JD-Core Version:    0.7.0.1
 */