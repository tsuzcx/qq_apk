import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class ydc
  implements wfk<wts, wtt>
{
  ydc(ydb paramydb, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull wts paramwts, @Nullable wtt paramwtt, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramwtt == null))
    {
      ykq.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      ydb.a(this.jdField_a_of_type_Ydb, paramErrorMessage);
      return;
    }
    ydb.a(this.jdField_a_of_type_Ydb);
    ydb.a(this.jdField_a_of_type_Ydb).a(paramwtt.jdField_a_of_type_JavaUtilList, paramwtt.jdField_a_of_type_JavaLangString, paramwtt.jdField_a_of_type_Boolean);
    ((yck)wjs.a(11)).a(paramwtt.jdField_a_of_type_JavaUtilList);
    boolean bool = ydb.a(paramwtt, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwtt.b), Integer.valueOf(ydb.b(this.jdField_a_of_type_Ydb)), Boolean.valueOf(bool) });
    if ((!paramwtt.jdField_a_of_type_Boolean) && (ydb.b(this.jdField_a_of_type_Ydb) < 10) && ((!paramwtt.b) || (bool)))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramwts.b = ydb.a(this.jdField_a_of_type_Ydb).a();
      wfi.a().a(paramwts, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      ydb.a(this.jdField_a_of_type_Ydb).c();
    }
    paramwts = ydb.a(this.jdField_a_of_type_Ydb).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    ydb.a(this.jdField_a_of_type_Ydb, paramwts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydc
 * JD-Core Version:    0.7.0.1
 */