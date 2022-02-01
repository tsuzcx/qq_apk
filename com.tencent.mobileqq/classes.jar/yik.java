import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class yik
  implements wld<wyj, wla>
{
  public yik(FeedManager.3 param3) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wla paramwla, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwyj = (wyk)paramwla;
    paramwla = new yio();
    paramwla.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwyj == null)) {
      yij.a().remove(this.a.a);
    }
    for (;;)
    {
      yqp.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      wfo.a().dispatch(paramwla);
      return;
      if (!paramwyj.a.isEmpty())
      {
        paramwla.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((yjy)paramwyj.a.get(0)).a());
      }
      else
      {
        yqp.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        yij.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yik
 * JD-Core Version:    0.7.0.1
 */