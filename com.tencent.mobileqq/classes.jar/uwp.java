import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class uwp
  implements syq<tmz, tna>
{
  uwp(uwo paramuwo, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull tmz paramtmz, @Nullable tna paramtna, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtna == null))
    {
      ved.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      uwo.a(this.jdField_a_of_type_Uwo, paramErrorMessage);
      return;
    }
    uwo.a(this.jdField_a_of_type_Uwo);
    uwo.a(this.jdField_a_of_type_Uwo).a(paramtna.jdField_a_of_type_JavaUtilList, paramtna.jdField_a_of_type_JavaLangString, paramtna.jdField_a_of_type_Boolean);
    ((uvx)tcz.a(11)).a(paramtna.jdField_a_of_type_JavaUtilList);
    boolean bool = uwo.a(paramtna, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtna.b), Integer.valueOf(uwo.b(this.jdField_a_of_type_Uwo)), Boolean.valueOf(bool) });
    if ((!paramtna.jdField_a_of_type_Boolean) && (uwo.b(this.jdField_a_of_type_Uwo) < 10) && ((!paramtna.b) || (bool)))
    {
      ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramtmz.b = uwo.a(this.jdField_a_of_type_Uwo).a();
      syo.a().a(paramtmz, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      uwo.a(this.jdField_a_of_type_Uwo).c();
    }
    paramtmz = uwo.a(this.jdField_a_of_type_Uwo).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    uwo.a(this.jdField_a_of_type_Uwo, paramtmz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwp
 * JD-Core Version:    0.7.0.1
 */