import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class ugz
  extends QQUIEventReceiver<ugn, uwf>
{
  public ugz(@NonNull ugn paramugn)
  {
    super(paramugn);
  }
  
  public void a(@NonNull ugn paramugn, @NonNull uwf paramuwf)
  {
    if ((paramuwf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramugn.a != null) && (TextUtils.equals(paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramugn.a.b)))
    {
      veg.a(paramugn.b, "refresh feed item , feed id :%s", paramugn.a.b);
      paramugn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */