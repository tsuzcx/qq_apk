import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class qtx
  implements ppv.b<pzb, pzb.a>
{
  qtx(qtw paramqtw, boolean paramBoolean) {}
  
  public void a(@NonNull pzb parampzb, @Nullable pzb.a arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (qtw.a(this.this$0).get())
    {
      ram.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    ram.b("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    parampzb = new qtw.b(this.this$0, paramErrorMessage);
    parampzb.aFw = this.aFv;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      pmi.a().dispatch(parampzb);
      return;
    }
    parampzb.on = ???.ns;
    ((psn)psx.a(19)).z(???.ns, true);
    synchronized (this.this$0)
    {
      pmi.a().dispatch(parampzb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtx
 * JD-Core Version:    0.7.0.1
 */