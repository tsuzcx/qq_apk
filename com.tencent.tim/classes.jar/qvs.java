import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class qvs
  implements ppv.b<pzh, pzh.a>
{
  qvs(qvr.a parama, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull pzh parampzh, @Nullable pzh.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      qvr.a.a(this.jdField_a_of_type_Qvr$a, paramErrorMessage);
      return;
    }
    qvr.a.a(this.jdField_a_of_type_Qvr$a);
    qvr.a.a(this.jdField_a_of_type_Qvr$a).e(parama.nk, parama.nextCookie, parama.isEnd);
    ((qvf)psx.a(11)).eE(parama.nk);
    boolean bool = qvr.a.a(parama, this.aW);
    ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(parama.aCG), Integer.valueOf(qvr.a.b(this.jdField_a_of_type_Qvr$a)), Boolean.valueOf(bool) });
    if ((!parama.isEnd) && (qvr.a.b(this.jdField_a_of_type_Qvr$a) < 10) && ((!parama.aCG) || (bool)))
    {
      ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      parampzh.cookie = qvr.a.a(this.jdField_a_of_type_Qvr$a).mP();
      ppv.a().a(parampzh, this);
      return;
    }
    if (this.aW.getAndSet(false)) {
      qvr.a.a(this.jdField_a_of_type_Qvr$a).sortList();
    }
    parampzh = qvr.a.a(this.jdField_a_of_type_Qvr$a).a(this.L.intValue(), 5);
    qvr.a.a(this.jdField_a_of_type_Qvr$a, parampzh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvs
 * JD-Core Version:    0.7.0.1
 */