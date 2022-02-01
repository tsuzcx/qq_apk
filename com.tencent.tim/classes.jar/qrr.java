import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class qrr
  implements ppv.b<pyu, qag>
{
  qrr(qro.f paramf, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull pyu parampyu, @Nullable qag paramqag, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramqag == null) || (paramErrorMessage.isFail()))
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      qro.f.a(this.jdField_a_of_type_Qro$f, paramErrorMessage);
      return;
    }
    if (paramqag.nB != null)
    {
      parampyu = paramqag.nB.iterator();
      do
      {
        if (!parampyu.hasNext()) {
          break;
        }
        paramqag = (ptp)parampyu.next();
      } while (!paramqag.feedId.equals(this.dL));
    }
    for (int i = paramqag.bkm;; i = 0)
    {
      qro.f.a(this.jdField_a_of_type_Qro$f, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrr
 * JD-Core Version:    0.7.0.1
 */