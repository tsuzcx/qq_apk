import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class woz
  implements urr<vex, uro>
{
  public woz(FeedManager.3 param3) {}
  
  public void a(@NonNull vex paramvex, @Nullable uro paramuro, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvex = (vey)paramuro;
    paramuro = new wpd();
    paramuro.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvex == null)) {
      woy.a().remove(this.a.a);
    }
    for (;;)
    {
      wxe.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      umc.a().dispatch(paramuro);
      return;
      if (!paramvex.a.isEmpty())
      {
        paramuro.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((wqn)paramvex.a.get(0)).a());
      }
      else
      {
        wxe.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        woy.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woz
 * JD-Core Version:    0.7.0.1
 */