import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xyt
  extends QQUIEventReceiver<xyd, ymj>
{
  public xyt(@NonNull xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull ymj paramymj)
  {
    if ((paramymj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxyd.a != null) && (TextUtils.equals(paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxyd.a.b)))
    {
      yuk.a(paramxyd.b, "refresh feed item , feed id :%s", paramxyd.a.b);
      paramxyd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ymj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyt
 * JD-Core Version:    0.7.0.1
 */