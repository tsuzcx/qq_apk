import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class yjb
  implements wld<wzm, wzn>
{
  yjb(yja paramyja, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull wzm paramwzm, @Nullable wzn paramwzn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwzn == null))
    {
      yqp.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      yja.a(this.jdField_a_of_type_Yja, paramErrorMessage);
      return;
    }
    yja.a(this.jdField_a_of_type_Yja);
    yja.a(this.jdField_a_of_type_Yja).a(paramwzn.jdField_a_of_type_JavaUtilList, paramwzn.jdField_a_of_type_JavaLangString, paramwzn.jdField_a_of_type_Boolean);
    ((yij)wpm.a(11)).a(paramwzn.jdField_a_of_type_JavaUtilList);
    boolean bool = yja.a(paramwzn, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwzn.b), Integer.valueOf(yja.b(this.jdField_a_of_type_Yja)), Boolean.valueOf(bool) });
    if ((!paramwzn.jdField_a_of_type_Boolean) && (yja.b(this.jdField_a_of_type_Yja) < 10) && ((!paramwzn.b) || (bool)))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramwzm.b = yja.a(this.jdField_a_of_type_Yja).a();
      wlb.a().a(paramwzm, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      yja.a(this.jdField_a_of_type_Yja).c();
    }
    paramwzm = yja.a(this.jdField_a_of_type_Yja).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    yja.a(this.jdField_a_of_type_Yja, paramwzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjb
 * JD-Core Version:    0.7.0.1
 */