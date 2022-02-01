import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class qrm
  extends SimpleJob
{
  qrm(qrl paramqrl, String paramString, qrl.b paramb, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.this$0.aTA();
    this.this$0.bnx();
    ((psa)psx.a(17)).a(this.a.nh, qrl.a(this.this$0).mFeedId, qrl.a(this.this$0).isOpen(), this.aEV);
    this.this$0.rw("Q.qqstory.detail:CommentListPageLoader");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrm
 * JD-Core Version:    0.7.0.1
 */