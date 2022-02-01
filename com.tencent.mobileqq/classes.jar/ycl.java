import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ycl
  implements wfk<wsp, wfh>
{
  public ycl(FeedManager.3 param3) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wfh paramwfh, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwsp = (wsq)paramwfh;
    paramwfh = new ycp();
    paramwfh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwsp == null)) {
      yck.a().remove(this.a.a);
    }
    for (;;)
    {
      ykq.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      wad.a().dispatch(paramwfh);
      return;
      if (!paramwsp.a.isEmpty())
      {
        paramwfh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((ydz)paramwsp.a.get(0)).a());
      }
      else
      {
        ykq.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        yck.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycl
 * JD-Core Version:    0.7.0.1
 */