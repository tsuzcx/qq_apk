import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xnj
  extends QQUIEventReceiver<xmx, ycp>
{
  public xnj(@NonNull xmx paramxmx)
  {
    super(paramxmx);
  }
  
  public void a(@NonNull xmx paramxmx, @NonNull ycp paramycp)
  {
    if ((paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxmx.a != null) && (TextUtils.equals(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxmx.a.b)))
    {
      ykq.a(paramxmx.b, "refresh feed item , feed id :%s", paramxmx.a.b);
      paramxmx.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */