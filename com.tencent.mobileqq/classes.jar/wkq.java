import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class wkq
  implements uni<vao, unf>
{
  public wkq(FeedManager.3 param3) {}
  
  public void a(@NonNull vao paramvao, @Nullable unf paramunf, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvao = (vap)paramunf;
    paramunf = new wku();
    paramunf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvao == null)) {
      wkp.a().remove(this.a.a);
    }
    for (;;)
    {
      wsv.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      uht.a().dispatch(paramunf);
      return;
      if (!paramvao.a.isEmpty())
      {
        paramunf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((wme)paramvao.a.get(0)).a());
      }
      else
      {
        wsv.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        wkp.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */