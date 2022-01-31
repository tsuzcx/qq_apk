import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class uho
  extends QQUIEventReceiver<uhg, uwc>
{
  public uho(@NonNull uhg paramuhg)
  {
    super(paramuhg);
  }
  
  public void a(@NonNull uhg paramuhg, @NonNull uwc paramuwc)
  {
    if ((paramuwc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramuhg.a != null) && (TextUtils.equals(paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramuhg.a.b))) {
      paramuhg.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uho
 * JD-Core Version:    0.7.0.1
 */