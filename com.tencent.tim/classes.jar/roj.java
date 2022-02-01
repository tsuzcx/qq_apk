import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class roj
  implements ppv.b<pzk, pzk.a>
{
  roj(roi.a parama, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull pzk parampzk, @Nullable pzk.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      roi.a.a(this.jdField_a_of_type_Roi$a, paramErrorMessage);
      return;
    }
    roi.a.a(this.jdField_a_of_type_Roi$a).e(parama.nk, parama.nextCookie, parama.isEnd);
    ((qvf)psx.a(11)).eE(parama.nk);
    parampzk = roi.a.a(this.jdField_a_of_type_Roi$a).a(this.L.intValue(), 5);
    roi.a.a(this.jdField_a_of_type_Roi$a, parampzk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roj
 * JD-Core Version:    0.7.0.1
 */