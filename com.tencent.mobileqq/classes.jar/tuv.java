import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class tuv
  extends QQUIEventReceiver<tun, ujj>
{
  public tuv(@NonNull tun paramtun)
  {
    super(paramtun);
  }
  
  public void a(@NonNull tun paramtun, @NonNull ujj paramujj)
  {
    if ((paramujj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramtun.a != null) && (TextUtils.equals(paramujj.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramtun.a.b))) {
      paramtun.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return ujj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuv
 * JD-Core Version:    0.7.0.1
 */