import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class ugw
  extends QQUIEventReceiver<ugk, uwc>
{
  public ugw(@NonNull ugk paramugk)
  {
    super(paramugk);
  }
  
  public void a(@NonNull ugk paramugk, @NonNull uwc paramuwc)
  {
    if ((paramuwc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramugk.a != null) && (TextUtils.equals(paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramugk.a.b)))
    {
      ved.a(paramugk.b, "refresh feed item , feed id :%s", paramugk.a.b);
      paramugk.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugw
 * JD-Core Version:    0.7.0.1
 */