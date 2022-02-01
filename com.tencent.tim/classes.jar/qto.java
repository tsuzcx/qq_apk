import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class qto
  implements ppv.b<pza, pza.a>
{
  qto(qtn.a parama, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull pza parampza, @Nullable pza.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      qtn.a.a(this.jdField_a_of_type_Qtn$a, paramErrorMessage);
      return;
    }
    qtn.a.a(this.jdField_a_of_type_Qtn$a).e(parama.nk, parama.nextCookie, parama.isEnd);
    ((qvf)psx.a(11)).eE(parama.nk);
    parampza = qtn.a.a(this.jdField_a_of_type_Qtn$a).a(this.L.intValue(), 5);
    qtn.a.a(this.jdField_a_of_type_Qtn$a, parampza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qto
 * JD-Core Version:    0.7.0.1
 */