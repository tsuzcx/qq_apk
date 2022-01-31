import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class uvy
  implements syq<tlw, syn>
{
  public uvy(FeedManager.3 param3) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable syn paramsyn, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtlw = (tlx)paramsyn;
    paramsyn = new uwc();
    paramsyn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtlw == null)) {
      uvx.a().remove(this.a.a);
    }
    for (;;)
    {
      ved.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      stb.a().dispatch(paramsyn);
      return;
      if (!paramtlw.a.isEmpty())
      {
        paramsyn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((uxm)paramtlw.a.get(0)).a());
      }
      else
      {
        ved.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        uvx.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvy
 * JD-Core Version:    0.7.0.1
 */