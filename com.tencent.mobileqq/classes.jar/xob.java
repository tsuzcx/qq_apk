import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xob
  extends QQUIEventReceiver<xnt, ycp>
{
  public xob(@NonNull xnt paramxnt)
  {
    super(paramxnt);
  }
  
  public void a(@NonNull xnt paramxnt, @NonNull ycp paramycp)
  {
    if ((paramycp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxnt.a != null) && (TextUtils.equals(paramycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxnt.a.b))) {
      paramxnt.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ycp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xob
 * JD-Core Version:    0.7.0.1
 */