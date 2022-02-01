import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ymf
  implements woy<xce, wov>
{
  public ymf(FeedManager.3 param3) {}
  
  public void a(@NonNull xce paramxce, @Nullable wov paramwov, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxce = (xcf)paramwov;
    paramwov = new ymj();
    paramwov.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramxce == null)) {
      yme.a().remove(this.a.a);
    }
    for (;;)
    {
      yuk.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      wjj.a().dispatch(paramwov);
      return;
      if (!paramxce.a.isEmpty())
      {
        paramwov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((ynt)paramxce.a.get(0)).a());
      }
      else
      {
        yuk.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        yme.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymf
 * JD-Core Version:    0.7.0.1
 */