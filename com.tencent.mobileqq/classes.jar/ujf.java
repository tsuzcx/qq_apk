import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ujf
  implements slx<szd, slu>
{
  public ujf(FeedManager.3 param3) {}
  
  public void a(@NonNull szd paramszd, @Nullable slu paramslu, @NonNull ErrorMessage paramErrorMessage)
  {
    paramszd = (sze)paramslu;
    paramslu = new ujj();
    paramslu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramszd == null)) {
      uje.a().remove(this.a.a);
    }
    for (;;)
    {
      urk.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      sgi.a().dispatch(paramslu);
      return;
      if (!paramszd.a.isEmpty())
      {
        paramslu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((ukt)paramszd.a.get(0)).a());
      }
      else
      {
        urk.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        uje.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */