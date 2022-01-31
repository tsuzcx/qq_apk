import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class uim
  extends QQUIEventReceiver<uhw, uwc>
{
  public uim(@NonNull uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull uwc paramuwc)
  {
    if ((paramuwc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem != null) && (paramuhw.a != null) && (TextUtils.equals(paramuwc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, paramuhw.a.b)))
    {
      ved.a(paramuhw.b, "refresh feed item , feed id :%s", paramuhw.a.b);
      paramuhw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uwc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uim
 * JD-Core Version:    0.7.0.1
 */