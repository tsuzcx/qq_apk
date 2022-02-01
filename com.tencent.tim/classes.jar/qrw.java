import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

class qrw
  implements ppv.b<qrv.b, qrv.c>
{
  qrw(qrv paramqrv, boolean paramBoolean) {}
  
  public void a(@NonNull qrv.b paramb, @Nullable qrv.c arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramb = new qrv.a(paramErrorMessage, qrv.a(this.this$0));
    paramb.aFe = false;
    paramb.aFd = qrv.a(this.this$0);
    paramb.mType = qrv.a(this.this$0);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      pmi.a().dispatch(paramb);
      return;
    }
    paramb.mHasLike = ???.mHasLike;
    paramb.mLikeCount = ???.mLikeCount;
    paramb.mLikeEntryList = ???.mLikeEntryList;
    paramb.aFf = this.aFc;
    ((psm)psx.a(15)).b(paramb.mLikeEntryList, qrv.a(this.this$0), qrv.c(this.this$0), true);
    synchronized (this.this$0)
    {
      qrv.a(this.this$0, true);
      pmi.a().dispatch(paramb);
      ram.b("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */