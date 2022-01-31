import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class uws
  implements syt<tnc, tnd>
{
  uws(uwr paramuwr, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull tnc paramtnc, @Nullable tnd paramtnd, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtnd == null))
    {
      veg.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      uwr.a(this.jdField_a_of_type_Uwr, paramErrorMessage);
      return;
    }
    uwr.a(this.jdField_a_of_type_Uwr);
    uwr.a(this.jdField_a_of_type_Uwr).a(paramtnd.jdField_a_of_type_JavaUtilList, paramtnd.jdField_a_of_type_JavaLangString, paramtnd.jdField_a_of_type_Boolean);
    ((uwa)tdc.a(11)).a(paramtnd.jdField_a_of_type_JavaUtilList);
    boolean bool = uwr.a(paramtnd, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtnd.b), Integer.valueOf(uwr.b(this.jdField_a_of_type_Uwr)), Boolean.valueOf(bool) });
    if ((!paramtnd.jdField_a_of_type_Boolean) && (uwr.b(this.jdField_a_of_type_Uwr) < 10) && ((!paramtnd.b) || (bool)))
    {
      veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramtnc.b = uwr.a(this.jdField_a_of_type_Uwr).a();
      syr.a().a(paramtnc, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      uwr.a(this.jdField_a_of_type_Uwr).c();
    }
    paramtnc = uwr.a(this.jdField_a_of_type_Uwr).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    uwr.a(this.jdField_a_of_type_Uwr, paramtnc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */