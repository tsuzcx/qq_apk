import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class qva
  extends SimpleObserver<qrl.b>
{
  qva(quy.a parama) {}
  
  public void c(qrl.b paramb)
  {
    super.onNext(paramb);
    if (paramb.b.isSuccess())
    {
      psa localpsa = (psa)psx.a(17);
      localpsa.a(paramb.nh, paramb.mFeedId, false, false);
      paramb.nh.addAll(localpsa.b(paramb.mFeedId, false));
    }
    pmi.a().dispatch(paramb);
    this.a.blM();
    ram.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.blM();
    ram.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qva
 * JD-Core Version:    0.7.0.1
 */