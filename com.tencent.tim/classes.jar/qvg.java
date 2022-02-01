import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedManager.3;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class qvg
  implements ppv.b<pyk, ppu>
{
  public qvg(FeedManager.3 param3) {}
  
  public void a(@NonNull pyk parampyk, @Nullable ppu paramppu, @NonNull ErrorMessage paramErrorMessage)
  {
    parampyk = (pyk.a)paramppu;
    paramppu = new qvf.c();
    paramppu.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (parampyk == null)) {
      qvf.i().remove(this.a.dL);
    }
    for (;;)
    {
      ram.b("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.dL, Integer.valueOf(paramErrorMessage.errorCode));
      pmi.a().dispatch(paramppu);
      return;
      if (!parampyk.nm.isEmpty())
      {
        paramppu.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((qwa)parampyk.nm.get(0)).a());
      }
      else
      {
        ram.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.dL });
        qvf.i().remove(this.a.dL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvg
 * JD-Core Version:    0.7.0.1
 */