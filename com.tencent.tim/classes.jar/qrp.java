import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class qrp
  implements ppv.b<pyt, pyt.a>
{
  qrp(qro.d paramd, JobContext paramJobContext, qvc paramqvc) {}
  
  public void a(@NonNull pyt parampyt, @Nullable pyt.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((parama == null) || (paramErrorMessage.isFail()))
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      qro.d.a(this.jdField_a_of_type_Qro$d, paramErrorMessage);
      return;
    }
    if (this.b.mType == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((psa)psx.a(17)).a(parama.nh, this.b.mFeedId, bool1, true);
      boolean bool3 = parama.isEnd;
      boolean bool2 = bool3;
      if (!parama.isEnd)
      {
        bool2 = bool3;
        if (parama.nh.size() == 0)
        {
          ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      parampyt = new qro.a(bool1, parama.nh, parama.totalNum, bool2, parama.nextCookie);
      qro.d.a(this.jdField_a_of_type_Qro$d, parampyt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrp
 * JD-Core Version:    0.7.0.1
 */