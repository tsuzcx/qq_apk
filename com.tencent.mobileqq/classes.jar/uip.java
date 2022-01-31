import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class uip
  extends QQUIEventReceiver<uhz, uwf>
{
  public uip(@NonNull uhz paramuhz)
  {
    super(paramuhz);
  }
  
  public void a(@NonNull uhz paramuhz, @NonNull uwf paramuwf)
  {
    if ((paramuwf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramuhz.a != null) && (TextUtils.equals(paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramuhz.a.b)))
    {
      veg.a(paramuhz.b, "refresh feed item , feed id :%s", paramuhz.a.b);
      paramuhz.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */