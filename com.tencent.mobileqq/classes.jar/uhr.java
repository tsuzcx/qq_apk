import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class uhr
  extends QQUIEventReceiver<uhj, uwf>
{
  public uhr(@NonNull uhj paramuhj)
  {
    super(paramuhj);
  }
  
  public void a(@NonNull uhj paramuhj, @NonNull uwf paramuwf)
  {
    if ((paramuwf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramuhj.a != null) && (TextUtils.equals(paramuwf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramuhj.a.b))) {
      paramuhj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhr
 * JD-Core Version:    0.7.0.1
 */