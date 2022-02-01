import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class xnq
  implements vqp<wdu, vqm>
{
  public xnq(FeedManager.3 param3) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable vqm paramvqm, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwdu = (wdv)paramvqm;
    paramvqm = new xnu();
    paramvqm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwdu == null)) {
      xnp.a().remove(this.a.a);
    }
    for (;;)
    {
      xvv.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      vli.a().dispatch(paramvqm);
      return;
      if (!paramwdu.a.isEmpty())
      {
        paramvqm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((xpe)paramwdu.a.get(0)).a());
      }
      else
      {
        xvv.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        xnp.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnq
 * JD-Core Version:    0.7.0.1
 */