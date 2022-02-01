import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class qrq
  implements ppv.b<qrv.b, qrv.c>
{
  qrq(qro.e parame, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull qrv.b paramb, @Nullable qrv.c paramc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramc == null) || (paramErrorMessage.isFail()))
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      qro.e.a(this.jdField_a_of_type_Qro$e, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Qro$e.type == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((psm)psx.a(15)).b(paramc.mLikeEntryList, this.dL, bool, true);
      paramb = new qro.b(bool, paramc.mLikeEntryList, paramc.mLikeCount, paramc.mHasLike);
      try
      {
        qro.e.a(this.jdField_a_of_type_Qro$e, paramb);
        return;
      }
      catch (NullPointerException paramb)
      {
        ram.e("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramb);
        qro.e.b(this.jdField_a_of_type_Qro$e, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrq
 * JD-Core Version:    0.7.0.1
 */