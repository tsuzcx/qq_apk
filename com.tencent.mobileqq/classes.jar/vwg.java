import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vwg
  extends QQUIEventReceiver<vvy, wku>
{
  public vwg(@NonNull vvy paramvvy)
  {
    super(paramvvy);
  }
  
  public void a(@NonNull vvy paramvvy, @NonNull wku paramwku)
  {
    if ((paramwku.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramvvy.a != null) && (TextUtils.equals(paramwku.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramvvy.a.b))) {
      paramvvy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wku.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwg
 * JD-Core Version:    0.7.0.1
 */