import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class uwb
  implements syt<tlz, syq>
{
  public uwb(FeedManager.3 param3) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable syq paramsyq, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtlz = (tma)paramsyq;
    paramsyq = new uwf();
    paramsyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtlz == null)) {
      uwa.a().remove(this.a.a);
    }
    for (;;)
    {
      veg.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      ste.a().dispatch(paramsyq);
      return;
      if (!paramtlz.a.isEmpty())
      {
        paramsyq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((uxp)paramtlz.a.get(0)).a());
      }
      else
      {
        veg.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        uwa.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwb
 * JD-Core Version:    0.7.0.1
 */