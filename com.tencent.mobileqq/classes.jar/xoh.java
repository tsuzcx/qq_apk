import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class xoh
  implements vqp<wex, wey>
{
  xoh(xog paramxog, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull wex paramwex, @Nullable wey paramwey, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwey == null))
    {
      xvv.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      xog.a(this.jdField_a_of_type_Xog, paramErrorMessage);
      return;
    }
    xog.a(this.jdField_a_of_type_Xog);
    xog.a(this.jdField_a_of_type_Xog).a(paramwey.jdField_a_of_type_JavaUtilList, paramwey.jdField_a_of_type_JavaLangString, paramwey.jdField_a_of_type_Boolean);
    ((xnp)vux.a(11)).a(paramwey.jdField_a_of_type_JavaUtilList);
    boolean bool = xog.a(paramwey, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwey.b), Integer.valueOf(xog.b(this.jdField_a_of_type_Xog)), Boolean.valueOf(bool) });
    if ((!paramwey.jdField_a_of_type_Boolean) && (xog.b(this.jdField_a_of_type_Xog) < 10) && ((!paramwey.b) || (bool)))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramwex.b = xog.a(this.jdField_a_of_type_Xog).a();
      vqn.a().a(paramwex, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      xog.a(this.jdField_a_of_type_Xog).c();
    }
    paramwex = xog.a(this.jdField_a_of_type_Xog).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    xog.a(this.jdField_a_of_type_Xog, paramwex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */