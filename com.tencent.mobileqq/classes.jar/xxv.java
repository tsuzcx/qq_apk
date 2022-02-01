import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class xxv
  extends QQUIEventReceiver<xxn, ymj>
{
  public xxv(@NonNull xxn paramxxn)
  {
    super(paramxxn);
  }
  
  public void a(@NonNull xxn paramxxn, @NonNull ymj paramymj)
  {
    if ((paramymj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramxxn.a != null) && (TextUtils.equals(paramymj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramxxn.a.b))) {
      paramxxn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ymj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxv
 * JD-Core Version:    0.7.0.1
 */