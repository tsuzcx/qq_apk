import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xxd
  extends QQUIEventReceiver<xwr, ymj>
{
  public xxd(@NonNull xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull ymj paramymj)
  {
    if ((paramymj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxwr.a != null) && (TextUtils.equals(paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxwr.a.b)))
    {
      yuk.a(paramxwr.b, "refresh feed item , feed id :%s", paramxwr.a.b);
      paramxwr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ymj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxd
 * JD-Core Version:    0.7.0.1
 */